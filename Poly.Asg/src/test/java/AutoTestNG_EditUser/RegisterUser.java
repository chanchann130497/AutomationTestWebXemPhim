package AutoTestNG_EditUser;

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

public class RegisterUser {
	public WebDriver driver;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	private Map<String, Object[]> TestNGResult;
	private Map<String, String[]> dataAddTest;
	private Map<String, String[]> dataUpdateTest;
	private Map<String, String[]> dataDeleteTest;
	int index = 1;

	private final String EXCEL_DIR = System.getProperty("user.dir") + "/test-resources/data/";
	private final String IMAGE_DIR = System.getProperty("user.dir") + "/test-resources/images/";

	// ---------- Xử lý chụp ảnh -------------------------
	// -----Hàm chụp ảnh------
	public void takeScreenShot(WebDriver driver, String outputSrc) throws IOException {
//			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshot, new File(outputSrc));
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
	// data Add
	private void readDataAddFromExcel() {
		try {
			dataAddTest = new HashMap<String, String[]>();
			worksheet = workbook.getSheet("Add"); // tên sheet cần lấy data
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
						String password = ""; // giá trị ô password
						String fullname = ""; // giá trị ô fullname
						String email = ""; // giá trị ô email
						String expected = ""; // giá trị ô expected
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								username = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								password = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 3) {
								fullname = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 4) {
								email = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 5) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { username, password, fullname, email, expected };
							dataAddTest.put(key, myArr);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("readDataFromExcel() : " + e.getMessage());
		}
	}

	// data Edit
	private void readDataEditFromExcel() {
		try {
			dataUpdateTest = new HashMap<String, String[]>();
			worksheet = workbook.getSheet("Edit"); // tên sheet cần lấy data
			if (worksheet == null) {
				System.out.println("Không tìm thấy worksheet : Edit");
			} else {
				Iterator<Row> rowIterator = worksheet.iterator();
				DataFormatter dataFormat = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() >= 1) {
						Iterator<Cell> cellIterator = row.cellIterator();
						String key = ""; // key - ô stt
						String username = ""; // giá trị ô username
						String password = ""; // giá trị ô password
						String fullname = ""; // giá trị ô fullname
						String email = ""; // giá trị ô email
						String expected = ""; // giá trị ô expected
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								username = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								password = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 3) {
								fullname = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 4) {
								email = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 5) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { username, password, fullname, email, expected };
							dataUpdateTest.put(key, myArr);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("readDataUpdateFromExcel() : " + e.getMessage());
		}
	}

	// data Delete
	private void readDataDeleteFromExcel() {
		try {
			dataDeleteTest = new HashMap<String, String[]>();
			worksheet = workbook.getSheet("Delete"); // tên sheet cần lấy data
			if (worksheet == null) {
				System.out.println("Không tìm thấy worksheet : Delete");
			} else {
				Iterator<Row> rowIterator = worksheet.iterator();
				DataFormatter dataFormat = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() >= 1) {
						Iterator<Cell> cellIterator = row.cellIterator();
						String key = ""; // key - ô stt
						String username = ""; // giá trị ô username
						String expected = ""; // giá trị ô expected
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								username = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { username, expected };
							dataDeleteTest.put(key, myArr);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("readDataDeleteFromExcel() : " + e.getMessage());
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

			workbook = new XSSFWorkbook(new FileInputStream(new File(EXCEL_DIR + "TEST_REGISTRATION_USER.xlsx")));
			worksheet = workbook.getSheet("Add");
			readDataAddFromExcel(); // đọc dữ liệu add

			worksheet = workbook.getSheet("Edit");
			readDataEditFromExcel(); // đọc dữ liệu update

			worksheet = workbook.getSheet("Delete");
			readDataDeleteFromExcel(); // đọc dữ liệu delete

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			workbook = new XSSFWorkbook();
			worksheet = workbook.createSheet("TestNG Result Summary");
			// thêm test result vào file excel ở cột header
			CellStyle rowStyle = workbook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			rowStyle.setWrapText(true);

			// viết header vào dòng đầu tiên
			TestNGResult.put("1", new Object[] { "STT", "Username", "Password", "Fullname", "Email", "Action",
					"Expected", "Actual", "Status", "Date Check", "LINK", "Image" });
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
				FileOutputStream out = new FileOutputStream(new File(EXCEL_DIR + "RESULT_TEST_REGISTRATION_USER.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("Successfully save to Excel File!!!");
			} catch (Exception e) {
				System.out.println("suiteTearDown() : " + e.getMessage());
			}
		}
	}

	// Test Add
	@Test(description = "Test Add User", priority = 1)
	public void testAdd() {
		try {
			Set<String> keySet = dataAddTest.keySet();
			for (String key : keySet) {
				String[] value = dataAddTest.get(key);
				String username = value[0];
				String password = value[1];
				String fullname = value[2];
				String email = value[3];
				String expected = value[4];
				String actual = "";

				driver.get("http://localhost:8080/Poly.Asg/Login");
				driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[1]/input"))
						.sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[2]/input"))
						.sendKeys("admin01");

				Thread.sleep(1000);

				WebElement btnLogin = driver
						.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[3]/button[1]"));
				Actions actionLogin = new Actions(driver).click(btnLogin);
				actionLogin.build().perform();

				Thread.sleep(1000);

				WebElement btnUser = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/div[1]/a"));
				Actions actionUser = new Actions(driver).click(btnUser);
				actionUser.build().perform();

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input"))
						.sendKeys(username);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[1]/input"))
						.sendKeys(password);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[2]/input"))
						.sendKeys(fullname);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[2]/input"))
						.sendKeys(email);

				try {
					UserDao userDao = new UserDao();
//					User user = new User();
					if (userDao.findById(username) != null) {
						actual = "FAILED";
					} else {
						WebElement btnCreate = driver.findElement(
								By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[1]"));
						Actions actionCreate = new Actions(driver).click(btnCreate);
						actionCreate.build().perform();
						actual = "SUCCESS";
					}
				} catch (Exception e) {
					actual = "FAILED";
				}

				System.out.println(username + " | " + password + " | " + fullname + " | " + email + " | " + expected
						+ " | " + actual);

				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							username, // Username
							password, // password
							fullname, // fullname
							email, // email
							"Test Add User", // action
							expected, // expected
							actual, // actual
							"PASS", // status
							formattedDate, // date check
							"" // image
					});
				} else {
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input"))
							.sendKeys(username);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[1]/input"))
							.sendKeys(password);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[2]/input"))
							.sendKeys(fullname);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[2]/input"))
							.sendKeys(email);
					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), username, password, fullname, email, "Test Add User",
									expected, actual, "FAILED", formattedDate, path.replace("\\", "/") });
				}
				index++;
			}

		} catch (Exception e) {
			System.out.println("testAdd() : " + e.getMessage());
		}
	}

	// Test Update
	@Test(description = "Test Update User", priority = 2)
	public void testUpdate() {
		try {
			Set<String> keyset = dataUpdateTest.keySet();
			for(String key : keyset) {
				String[] value = dataUpdateTest.get(key);
				String username = value[0];
				String password = value[1];
				String fullname = value[2];
				String email = value[3];
				String expected = value[4];
				String actual = "";
				
				driver.get("http://localhost:8080/Poly.Asg/Login");
				driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[1]/input"))
						.sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[2]/input"))
						.sendKeys("admin01");

				Thread.sleep(1000);

				WebElement btnLogin = driver
						.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[3]/button[1]"));
				Actions actionLogin = new Actions(driver).click(btnLogin);
				actionLogin.build().perform();

				Thread.sleep(1000);

				WebElement btnUser = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/div[1]/a"));
				Actions actionUser = new Actions(driver).click(btnUser);
				actionUser.build().perform();

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input"))
						.sendKeys(username);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[1]/input"))
						.sendKeys(password);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[2]/input"))
						.sendKeys(fullname);
				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[2]/input"))
						.sendKeys(email);
				try {
					UserDao userDao = new UserDao();
					User user = new User();
					if (userDao.findById(username) != null) {
						actual = "FAILED";
					} else {
						user = userDao.findById(username);
						WebElement btnUpdate = driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[2]"));
						Actions actionUpdate = new Actions(driver).click(btnUpdate);
						actionUpdate.build().perform();

						boolean checkFullname = user.getFullname().equals(fullname) ? true : false;
						boolean checkPassword = user.getPassword().equals(password) ? true  : false;
						boolean checkEmail = user.getEmail().equals(email) ? true : false;
						if(checkFullname && checkPassword && checkEmail) {
							actual = "SUCCESS";	
						}else {
							actual = "FAILED";
						}
						
					}
				} catch (Exception e) {
					actual = "FAILED";
				}
				
				System.out.println(username + " | " + password + " | " + fullname + " | " + email + " | " + expected
						+ " | " + actual);

				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							username, // Username
							password, // password
							fullname, // fullname
							email, // email
							"Test Update User", // action
							expected, // expected
							actual, // actual
							"PASS", // status
							formattedDate, // date check
							"" // image
					});
				} else {
					driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input")).sendKeys(username);
					driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[1]/input")).sendKeys(password);
					driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[2]/input")).sendKeys(fullname);
					driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[2]/div[2]/input")).sendKeys(email);
					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), username, password, fullname, email, "Test Update User",
									expected, actual, "FAILED", formattedDate, path.replace("\\", "/") });
				}
				index++;
				
			}
		}catch(Exception e) {
			System.out.println("testUpdate() : " + e.getMessage());
		}
	}

	// Test Delete
	@Test(description = "Test Delete User", priority = 3)
	public void testDelete() {
		try {
			Set<String> keyset = dataDeleteTest.keySet();
			for(String key : keyset) {
				String[] value = dataDeleteTest.get(key);
				String username = value[0];
				String expected = value[1];
				String actual = "";

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);
				
				if(username.length() <= 0) {
					actual = "FAILED";
				}else {
					driver.get("http://localhost:8080/Poly.Asg/Login");
					driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[1]/input"))
							.sendKeys("admin");
					driver.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[2]/div[2]/input"))
							.sendKeys("admin01");

					Thread.sleep(1000);

					WebElement btnLogin = driver
							.findElement(By.xpath("/html/body/div[1]/section/div/form/div/div[3]/button[1]"));
					Actions actionLogin = new Actions(driver).click(btnLogin);
					actionLogin.build().perform();

					Thread.sleep(1000);

					WebElement btnUser = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/div[1]/a"));
					Actions actionUser = new Actions(driver).click(btnUser);
					actionUser.build().perform();

					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input"))
							.sendKeys(username);
					UserDao userDao = new UserDao();
					User userBefore = new User();
					userBefore = userDao.findById(username);
					if(userBefore != null) {
						WebElement btnDelete = driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[3]"));
						Actions actionDelete = new Actions(driver).click(btnDelete);
						actionDelete.build().perform();
						User userAfter = new User();
						userAfter = userDao.findById(username);
						if(userAfter == null) {
							actual = "SUCCESS";
						}else {
							actual = "FAILED";
						}
					}else {
						actual = "FAILED";
					}
				}
				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							username, // Username
							"", // password
							"", // fullname
							"", // email
							"Test Delete User", // action
							expected, // expected
							actual, // actual
							"PASS", // status
							formattedDate, // date check
							"" // image
					});
				} else {
					driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div/div[1]/div[1]/input")).sendKeys(username);
					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), username, "", "", "", "Test Delete User",
									expected, actual, "FAILED", formattedDate, path.replace("\\", "/") });
				}
				index++;
			}
		}catch(Exception e) {
			System.out.println("testDelete() : " + e.getMessage());
		}
	}

}



















































