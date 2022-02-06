package AutoTestNG_EditVideo;

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
import edu.poly.dao.VideoDao;
import edu.poly.model.User;
import edu.poly.model.Video;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CRUDVideo {
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
			worksheet = workbook.getSheet("Add");
			if (worksheet == null) {
				System.out.println("Không tìm thấy worksheet : TestData");
			} else {
				Iterator<Row> rowIterator = worksheet.iterator();
				DataFormatter dataFormat = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() >= 1) {
						Iterator<Cell> cellIterator = row.cellIterator();
						String key = "";
						String videoid = "";
						String title = "";
						String poster = "";
						String views = "";
						String description = "";
						String active = "";
						String expected = "";
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								videoid = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								title = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 3) {
								poster = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 4) {
								views = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 5) {
								description = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 6) {
								active = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 7) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { videoid, title, poster, views, description, active, expected };
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
			worksheet = workbook.getSheet("Edit");
			if (worksheet == null) {
				System.out.println("Không tìm thấy worksheet : Edit");
			} else {
				Iterator<Row> rowIterator = worksheet.iterator();
				DataFormatter dataFormat = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() >= 1) {
						Iterator<Cell> cellIterator = row.cellIterator();
						String key = "";
						String videoid = "";
						String title = "";
						String poster = "";
						String views = "";
						String description = "";
						String active = "";
						String expected = "";
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								videoid = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								title = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 3) {
								poster = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 4) {
								views = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 5) {
								description = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 6) {
								active = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 7) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { videoid, title, poster, views, description, active, expected };
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
			worksheet = workbook.getSheet("Delete");
			if (worksheet == null) {
				System.out.println("Không tìm thấy worksheet : Delete");
			} else {
				Iterator<Row> rowIterator = worksheet.iterator();
				DataFormatter dataFormat = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() >= 1) {
						Iterator<Cell> cellIterator = row.cellIterator();
						String key = "";
						String videoid = "";
						String title = "";
						String poster = "";
						String views = "";
						String description = "";
						String active = "";
						String expected = "";
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								key = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 1) {
								videoid = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 2) {
								title = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 3) {
								poster = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 4) {
								views = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 5) {
								description = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 6) {
								active = dataFormat.formatCellValue(cell);
							} else if (cell.getColumnIndex() == 7) {
								expected = dataFormat.formatCellValue(cell);
							}
							String[] myArr = { videoid, title, poster, views, description, active, expected };
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

			workbook = new XSSFWorkbook(new FileInputStream(new File(EXCEL_DIR + "TEST_CRUD_Video.xlsx")));
			worksheet = workbook.getSheet("Add");
			readDataAddFromExcel();

			worksheet = workbook.getSheet("Edit");
			readDataEditFromExcel();

			worksheet = workbook.getSheet("Delete");
			readDataDeleteFromExcel();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			workbook = new XSSFWorkbook();
			worksheet = workbook.createSheet("TestNG Result Summary");
			CellStyle rowStyle = workbook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			rowStyle.setWrapText(true);

			TestNGResult.put("1", new Object[] { "STT", "VideoId", "Title", "Poster", "Views", "Description", "Active",
					"Action", "Expected", "Actual", "Status", "Date Check", "LINK", "Image" });
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
				worksheet.setColumnWidth(12, 6000);
				worksheet.setColumnWidth(13, 9000);
				row.setRowStyle(rowStyle);

			}
			try {
				FileOutputStream out = new FileOutputStream(new File(EXCEL_DIR + "RESULT_TEST_CRUD_Video.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("Successfully save to Excel File!!!");
			} catch (Exception e) {
				System.out.println("suiteTearDown() : " + e.getMessage());
			}
		}
	}

	// Test Add
	@Test(description = "Test Add Video", priority = 1)
	public void testAdd() {
		try {
			Set<String> keySet = dataAddTest.keySet();
			for (String key : keySet) {
				String[] value = dataAddTest.get(key);
				String videoid = value[0];
				String title = value[1];
				String poster = value[2];
				String views = value[3];
				String description = value[4];
				String active = value[5];
				String expected = value[6];
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

				WebElement btnVideo = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/li[2]/a"));
				Actions actionVideo = new Actions(driver).click(btnVideo);
				actionVideo.build().perform();

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
						.sendKeys(videoid);
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
						.sendKeys(title);
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
						.sendKeys(views);
				Thread.sleep(1000);

				WebElement btnCheck = driver.findElement(By.xpath(
						"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
				Actions actionCheck = new Actions(driver).click(btnCheck);
				actionCheck.build().perform();
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
						.sendKeys(description);
				Thread.sleep(1000);

				try {
					VideoDao videoDao = new VideoDao();
					if (videoDao.findById(videoid) != null) {
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

				System.out.println(videoid + " | " + title + " | " + poster + " | " + views + " | " + description
						+ " | " + active + " | " + expected + " | " + actual);

				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							videoid, title, poster, views, description, active, "Test Add Video", expected, actual,
							"PASS", formattedDate, "" });
				} else {
					WebElement btnReset = driver
							.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[4]"));
					Actions actionReset = new Actions(driver).click(btnReset);
					actionReset.build().perform();
					Thread.sleep(2000);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
							.sendKeys(videoid);
					Thread.sleep(1000);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
							.sendKeys(title);
					Thread.sleep(1000);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
							.sendKeys(views);
					Thread.sleep(1000);

					WebElement btnCheck1 = driver.findElement(By.xpath(
							"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
					Actions actionCheck1 = new Actions(driver).click(btnCheck1);
					actionCheck1.build().perform();
					Thread.sleep(1000);

					Thread.sleep(1000);

					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
							.sendKeys(description);

					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), videoid, title, poster, views, description, active,
									"Test Add Video", expected, actual, "FAILED", formattedDate,
									path.replace("\\", "/") });
				}
				index++;

			}

		} catch (Exception e) {
		}
	}

	// Test Update
	@Test(description = "Test Update Video", priority = 2)
	public void testUpdate() {
		try {
			Set<String> keyset = dataUpdateTest.keySet();
			for (String key : keyset) {
				String[] value = dataUpdateTest.get(key);
				String videoid = value[0];
				String title = value[1];
				String poster = value[2];
				String views = value[3];
				String description = value[4];
				String active = value[5];
				String expected = value[6];
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

				WebElement btnVideo = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/li[2]/a"));
				Actions actionVideo = new Actions(driver).click(btnVideo);
				actionVideo.build().perform();

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
						.sendKeys(videoid);
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
						.sendKeys(title);
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
						.sendKeys(views);
				Thread.sleep(1000);

				WebElement btnCheck = driver.findElement(By.xpath(
						"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
				Actions actionCheck = new Actions(driver).click(btnCheck);
				actionCheck.build().perform();
				Thread.sleep(1000);

				driver.findElement(
						By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
						.sendKeys(description);
				Thread.sleep(1000);

				try {
					VideoDao videoDao = new VideoDao();
					if (videoDao.findById(videoid) != null) {
						actual = "FAILED";
					} else if (videoDao.findById(videoid).getVideoId().equalsIgnoreCase(videoid)) {
						WebElement btnUpdate = driver.findElement(
								By.xpath("/html/body/main/section/div/div[2]/div[1]/form/div/div[2]/button[2]"));
						Actions actionUpdate = new Actions(driver).click(btnUpdate);
						actionUpdate.build().perform();
						actual = "SUCCESS";
					} else {
						WebElement btnUpdate = driver.findElement(
								By.xpath("/html/body/main/section/div/div[2]/div[1]/form/div/div[2]/button[2]"));
						Actions actionUpdate = new Actions(driver).click(btnUpdate);
						actionUpdate.build().perform();
						actual = "FAILED";
					}

				} catch (Exception e) {
					actual = "FAILED";
				}

				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							videoid, title, poster, views, description, active, "Test Update Video", // action
							expected, // expected
							actual, // actual
							"PASS", // status
							formattedDate, // date check
							"" // image
					});
				} else {
					WebElement btnReset = driver
							.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[4]"));
					Actions actionReset = new Actions(driver).click(btnReset);
					actionReset.build().perform();

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
							.sendKeys(videoid);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
							.sendKeys(title);
					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
							.sendKeys(views);
					WebElement btnActive = driver.findElement(By.xpath(
							"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
					Actions actionActive = new Actions(driver).click(btnActive);
					actionActive.build().perform();
					Thread.sleep(1000);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
							.sendKeys(description);
					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), videoid, title, poster, views, description, active,
									"Test Update Video", expected, actual, "FAILED", formattedDate,
									path.replace("\\", "/") });
				}
				index++;
				System.out.println(videoid + " | " + title + " | " + poster + " | " + views + " | " + description
						+ " | " + active + " | " + expected + " | " + actual);

			}

		} catch (Exception e) {
		}
	}

	@Test(description = "Test Delete Video", priority = 3)
	public void testDelete() {
		try {
			Set<String> keyset = dataDeleteTest.keySet();
			for (String key : keyset) {
				String[] value = dataDeleteTest.get(key);
				String videoid = value[0];
				String title = value[1];
				String poster = value[2];
				String views = value[3];
				String description = value[4];
				String active = value[5];
				String expected = value[6];
				String actual = "";

				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy ");
				String formattedDate = myDateObj.format(myFormatObj);

				if (videoid.length() <= 0) {
					actual = "FAILED";
				} else {
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

					WebElement btnVideo = driver.findElement(By.xpath("/html/body/main/nav/nav/div/ul/li[2]/a"));
					Actions actionVideo = new Actions(driver).click(btnVideo);
					actionVideo.build().perform();

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
							.sendKeys(videoid);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
							.sendKeys(title);
					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
							.sendKeys(views);
					WebElement btnActive = driver.findElement(By.xpath(
							"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
					Actions actionActive = new Actions(driver).click(btnActive);
					actionActive.build().perform();
					Thread.sleep(2000);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
							.sendKeys(description);

					VideoDao videoDao = new VideoDao();
					Video videoBefore = new Video();
					videoBefore = videoDao.findById(videoid);
					if (videoBefore != null) {
						WebElement btnDelete = driver.findElement(
								By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[3]"));
						Actions actionDelete = new Actions(driver).click(btnDelete);
						actionDelete.build().perform();
						Video videoAfter = new Video();

						videoAfter = videoDao.findById(videoid);
						if (videoAfter == null) {
							actual = "SUCCESS";
						} else {
							actual = "FAILED";
						}
					} else {
						actual = "FAILED";
					}
				}
				if (actual.equalsIgnoreCase(expected)) {
					TestNGResult.put(String.valueOf(index + 1), new Object[] { String.valueOf(index), // STT
							videoid, title, poster, views, description, active, "Test Delete Video", // action
							expected, // expected
							actual, // actual
							"PASS", // status
							formattedDate, // date check
							"" // image
					});
				} else {
					WebElement btnReset = driver
							.findElement(By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[2]/button[4]"));
					Actions actionReset = new Actions(driver).click(btnReset);
					actionReset.build().perform();

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[1]/input"))
							.sendKeys(videoid);

					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[2]/input"))
							.sendKeys(title);
					driver.findElement(By
							.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[3]/input"))
							.sendKeys(views);
					WebElement btnActive = driver.findElement(By.xpath(
							"/html/body/main/section/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div[4]/label[1]/input"));
					Actions actionActive = new Actions(driver).click(btnActive);
					actionActive.build().perform();
					Thread.sleep(2000);
					driver.findElement(
							By.xpath("/html/body/main/section/div/div/div[1]/form/div/div[1]/div[2]/div/textarea"))
							.sendKeys(description);
					String path = IMAGE_DIR + "failure-" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					TestNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), videoid, title, poster, views, description, active,
									"Test Delete Video", expected, actual, "FAILED", formattedDate,
									path.replace("\\", "/") });
				}
				index++;
				System.out.println(videoid + " | " + title + " | " + poster + " | " + views + " | " + description
						+ " | " + active + " | " + expected + " | " + actual);
			}
		} catch (Exception e) {
		}
	}

}
