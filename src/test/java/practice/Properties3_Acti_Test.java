package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Properties3_Acti_Test {
	public static void main(String[] args) throws Throwable {
		FileInputStream fin = new FileInputStream("./data/commondata.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url1");
		String username = pro.getProperty("un1");
		String password = pro.getProperty("pwd");
		//Launch the Browser
		
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		
		Thread.sleep(10000);
		
		//driver.quit();
	}
}
