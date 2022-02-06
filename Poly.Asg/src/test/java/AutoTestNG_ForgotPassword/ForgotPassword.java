package AutoTestNG_ForgotPassword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import edu.poly.dao.UserDao;
import edu.poly.model.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ForgotPassword {
	// username : /html/body/div/section/div/form/div/div[2]/div/div/div[1]/input
	// email : /html/body/div/section/div/form/div/div[2]/div/div/div[2]/input
	// btn : /html/body/div/section/div/form/div/div[3]/button
	
	public WebDriver driver;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	private Map<String, Object[]> TestNGResult;
	private Map<String, String[]> dataForgotPasswordTest;

	private final String EXCEL_DIR = System.getProperty("user.dir") + "/test-resources/data/";
	private final String IMAGE_DIR = System.getProperty("user.dir") + "/test-resources/images/";
	
	// ---------- Xử lý chụp ảnh -------------------------
		// -----Hàm chụp ảnh------
		public void takeScreenShot(WebDriver driver, String outputSrc) throws IOException {
//					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//					FileUtils.copyFile(screenshot, new File(outputSrc));
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(outputSrc));
		}

		public void writeImage(String imgSrc, Row row, Cell cell, XSSFSheet sheet) throws IOException {
			InputStream is = new FileInputStream(imgSrc);
			byte[] bytes = IOUtils.toByteArray(is);
			int idImg = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
			is.close();

			// Bắt buộc phải khởi tạo để đưa hình lên Excel
			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			// định vị
			ClientAnchor anchor = new XSSFClientAnchor();

			anchor.setCol1(cell.getColumnIndex() + 1);
			anchor.setRow1(row.getRowNum());
			anchor.setCol2(cell.getColumnIndex() + 2);
			anchor.setRow2(row.getRowNum() + 1);

			drawing.createPicture(anchor, idImg);

		}

		// ---------- Kết thúc Xử lý chụp ảnh ----------------
	
		// đọc dữ liệu từ file excel
		// data 
		private void readDataFromExcel() {
			try {
				dataForgotPasswordTest = new HashMap<String, String[]>();
				worksheet = workbook.getSheet("TestData"); // tên sheet cần lấy data
				if (worksheet == null) {
					System.out.println("Không tìm thấy worksheet : TestData");
				} else {
					Iterator<Row> rowIterator = worksheet.iterator();
					DataFormatter dataFormat = new DataFormatter();
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						if (row.getRowNum() >= 1) {
							Iterator<Cell> cellIterator = row.cellIterator();
							String key = ""; // key - ô stt
							String username = ""; // giá trị ô username
							String email = ""; // giá trị ô email
							String expected = ""; // giá trị ô expected
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								if (cell.getColumnIndex() == 0) {
									key = dataFormat.formatCellValue(cell);
								} else if (cell.getColumnIndex() == 1) {
									username = dataFormat.formatCellValue(cell);
								} else if (cell.getColumnIndex() == 2) {
									email = dataFormat.formatCellValue(cell);
								} else if (cell.getColumnIndex() == 3) {
									expected = dataFormat.formatCellValue(cell);
								}
								String[] myArr = { username, email, expected };
								dataForgotPasswordTest.put(key, myArr);
							}
						}
					}
				}
			} catch (Exception e) {
				System.out.println("readDataFromExcel() : " + e.getMessage());
			}
		}
		
		// ------------ Before Class ------------
		@BeforeClass(alwaysRun = true)
		public void suiteTest() {
			try {
				TestNGResult = new LinkedHashMap<String, Object[]>();

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				workbook = new XSSFWorkbook(new FileInputStream(new File(EXCEL_DIR + "TEST_FORGOTPASSWORD.xlsx")));
				worksheet = workbook.getSheet("TestData");
				readDataFromExcel(); // đọc dữ liệu add

				// -------------------------------------------------------------
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				workbook = new XSSFWorkbook();
				worksheet = workbook.createSheet("TestNG Result Summary");
				// thêm test result vào file excel ở cột header
				CellStyle rowStyle = workbook.createCellStyle();
				rowStyle.setAlignment(HorizontalAlignment.CENTER);
				rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				rowStyle.setWrapText(true);

				// viết header vào dòng đầu tiên
				TestNGResult.put("1", new Object[] { "STT", "Username", "Email", "Action", "Expected", "Actual", "Status", "Date Check", "LINK", "Image" });
			} catch (Exception e) {
				System.out.println("suiteTest() : " + e.getMessage());
			}
		}

		// ----------- After Class -----------
		@AfterClass
		public void suiteTearDown() {
			Set<String> keyset = TestNGResult.keySet();
			int rownum = 0;
			for (String key : keyset) {
				CellStyle rowStyle = workbook.createCellStyle();
				Row row = worksheet.createRow(rownum++);
				Object[] objArr = TestNGResult.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					rowStyle.setAlignment(HorizontalAlignment.CENTER);
					rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
					rowStyle.setWrapText(true);
					int flag = cellnum++;
					Cell cell = row.createCell(flag);
					if (obj instanceof Date) {
						cell.setCellValue((Date) obj);
					} else if (obj instanceof Boolean) {
						cell.setCellValue((Boolean) obj);
					} else if (obj instanceof String) {
						cell.setCellValue((String) obj);
					} else if (obj instanceof Double) {
						cell.setCellValue((Double) obj);
					}

					if (obj.toString().contains("failure") && obj.toString().contains(".png")) {
						try {
							row.setHeightInPoints(80);
							writeImage(obj.toString(), row, cell, worksheet);
							CreationHelper creationHelper = worksheet.getWorkbook().getCreationHelper();
							XSSFHyperlink hyperlink = (XSSFHyperlink) creationHelper.createHyperlink(HyperlinkType.URL);
							cell.setCellValue("Full Image");
							hyperlink.setAddress(obj.toString().replace("\\", "/"));
							cell.setHyperlink(hyperlink);
							rowStyle.setAlignment(HorizontalAlignment.CENTER);
							rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
							rowStyle.setWrapText(true);
							row.setRowStyle(rowStyle);

						} catch (Exception d) {
							System.out.println("Write Image : " + d.getMessage());
						}
					}
					rowStyle.setAlignment(HorizontalAlignment.CENTER);
					rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
					rowStyle.setWrapText(true);
					worksheet.autoSizeColumn(cellnum);
					worksheet.setColumnWidth(10, 7000);
					worksheet.setColumnWidth(11, 7000);
					row.setRowStyle(rowStyle);

				}
				try {
					FileOutputStream out = new FileOutputStream(new File(EXCEL_DIR + "RESULT_TEST_FORGOT_PASSWORD.xlsx"));
					workbook.write(out);
					out.close();
					System.out.println("Successfully save to Excel File!!!");
				} catch (Exception e) {
					System.out.println("suiteTearDown() : " + e.getMessage());
				}
			}
		}
		
		// ---------------- END AFTER CLASS --------------------------
		
		@Test
		public void testForgotPassword() {
			try {
				Set<String> keySet = dataForgotPasswordTest.keySet();
				int index = 1;
				for (String key : keySet) {
					String[] value = dataForgotPasswordTest.get(key);
					String username = value[0];
					String email = value[1];
					String expected = value[2];
					String actual = "";
					
					LocalDateTime myDateObj = LocalDateTime.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy");
					String formattedDate = myDateObj.format(myFormatObj);
					
					driver.get("http://localhost:8080/Poly.Asg/ForgotPassword");
					driver.findElement(By.xpath("/html/body/div/section/div/form/div/div[2]/div/div/div[1]/input")).sendKeys(username);
					driver.findElement(By.xpath("/html/body/div/section/div/form/div/div[2]/div/div/div[2]/input")).sendKeys(email);
					
					WebElement btnSendMail = driver.findElement(By.xpath("/html/body/div/section/div/form/div/div[3]/button"));
					Actions actionSendMail = new Actions(driver).click(btnSendMail);
					actionSendMail.build().perform();
					
					UserDao userDao = new UserDao();
					User user = userDao.findById(username);
					if(user != null) {
						boolean checkMail = user.getEmail().equalsIgnoreCase(email) ? true : false;
						if(checkMail) {
							actual = "SUCCESS";
						}else {
							actual = "FAILED";
						}
					}else {
						actual = "FAILED";
					}
					
					System.out.println("--- " + username + " | " + email + " | " + expected + " | " + actual + " ---");

					if (actual.equalsIgnoreCase(expected)) {
						TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
								username, // Username
								email, // email
								"Test ChangedPassword User", // action
								expected, // expected
								actual, // actual
								"PASS", // status
								formattedDate, // date check
								"" // image
						});
					} else {
						driver.findElement(By.xpath("/html/body/div/section/div/form/div/div[2]/div/div/div[1]/input")).sendKeys(username);
						driver.findElement(By.xpath("/html/body/div/section/div/form/div/div[2]/div/div/div[2]/input")).sendKeys(email);
						String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
						takeScreenShot(driver, path);
						TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
								username, // Username
								email, // email
								"Test ChangedPassword User", // action
								expected, // expected
								actual, // actual
								"FAILED", // status
								formattedDate, // date check
								path.replace("\\", "/")// image
						});
					}
					index++;
				}
			}catch(Exception e) {
				System.out.println("testForgotPassword() : " + e.getMessage());
			}
		}		
}



























