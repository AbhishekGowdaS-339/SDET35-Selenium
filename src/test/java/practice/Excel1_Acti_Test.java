package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel1_Acti_Test {
	public static void main(String[] args) throws Throwable {
		String path = "./data/testcasespecificdata.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = new WorkbookFactory().create(fin);
		
		String url = workbook.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		String username = workbook.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
		String password = workbook.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue();
		String browser =workbook.getSheet("Sheet2").getRow(3).getCell(1).getStringCellValue();
		
		System.out.println("url: "+url);
		System.out.println("USername: "+username);
		System.out.println("Password: "+password);
		
		WebDriver driver;
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	
		System.out.println("Execution Complete");
		
	}

}
