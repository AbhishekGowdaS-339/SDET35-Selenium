package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaginWithProductTest {
public static void main(String[] args) throws Throwable {
		
		FileInputStream fin = new FileInputStream("./data/commondata.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		String path = "./data/testcasespecificdata1.xlsx";
		FileInputStream fin1 = new FileInputStream(path);
		Workbook workbook = new WorkbookFactory().create(fin1);
		Random ran = new Random();
		int ranumber = ran.nextInt(1000);
		
		String campaignName =workbook.getSheet("Sheet1").getRow(4).getCell(7).getStringCellValue()+ranumber;
		String productName =workbook.getSheet("Sheet1").getRow(4).getCell(8).getStringCellValue()+ranumber;
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actualProductMsg = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actualProductMsg.contains(productName)) 
			System.out.println("Product is successfully created and displayed :: Pass");
		else
			System.out.println("Product is not created :: Fail");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"))).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		String parentWin = driver.getWindowHandle(); 
		Set<String> allWin = driver.getWindowHandles(); 
		
		allWin.remove(parentWin);
		
		System.out.println(allWin);
		
		for (String win : allWin) {
			//driver.navigate().to(win);
			driver.switchTo().window(win);
			driver.findElement(By.linkText(productName)).click();
		}
		
		driver.switchTo().window(parentWin);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		String actualSucceessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualSucceessfulMsg.contains(campaignName)) 
			System.out.println("Campaign name is successfully created and displayed :: Pass");
		else
			System.out.println("Organization name is not created :: Fail");
		
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		System.out.println("Logout Successfully");
		
		//driver.quit();
	}

}
