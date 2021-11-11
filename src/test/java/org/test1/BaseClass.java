package org.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	WebElement element;

	// Launch browser
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// maximize the window
	public void maximize() {
		driver.manage().window().maximize();
	}

	public void setUrl(String data) {
		driver.get(data);
	}

	public WebElement locatorId(String data) {
		return element = driver.findElement(By.id(data));
	}

	public WebElement locatorName(String data) {
		return element = driver.findElement(By.name(data));
	}

	public WebElement locatorClass(String data) {
		return element = driver.findElement(By.className(data));
	}

	public WebElement locatorxpath(String data) {
		return element = driver.findElement(By.xpath(data));
	}

	public void type(WebElement element, String data) {
		element.sendKeys(data);
		
	}

	public void btnclick(WebElement element) {
		element.click();
		
	}

	
	// DropDownSelect
	public WebElement dnDselect(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
		return element;
	}

	// Input the data to Excel
	public String setCellValue(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		File file = new File("C:\\Users\\Thiru\\Desktop\\Reuseable task\\FirstDay\\Excel\\Hotelbooking.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		return data;

	}// Get Attribute value

	public String getAttribute(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	// Close the window
	public void closeWindow() {
		driver.close();
	}

	// get the data from excel
	public String getData(String sheetName, int rowNum, int cellNum) throws IOException {
		String data = null;
		File file = new File("C:\\Users\\Thiru\\Desktop\\Reuseable task\\FirstDay\\Excel\\Hotelbooking.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		if (cellType == 0) {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			data = String.valueOf(l);

			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mmm/yyyy");
				data = dateFormat.format(date);
			}
		}
		return data;

	}
}
