package practice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContact_3_Test {
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
		//WorkbookFactory workbook = new WorkbookFactory();
		Workbook workbook = new WorkbookFactory().create(fin1);
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		String lastName = workbook.getSheet("Sheet1").getRow(4).getCell(7).getStringCellValue()+ranNum;
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actualSucceessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualSucceessfulMsg.contains(lastName)) 
			System.out.println("Contact is successfully created and information is displayed :: Pass : and the name is :: "+lastName);
		else
			System.out.println("Contact is not created :: Fail");
		
		driver.findElement(By.name("Delete")).click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		int count =0;
		
		List<WebElement> listLastName = driver.findElements(By.xpath("(//a[@title='Contacts'])[position() mod 2 =0]"));
		for (WebElement lastNameEle : listLastName) {
			if(lastNameEle.equals(lastName)) {
				count++;
				break;
			}
		}
		
		if(count!=0)
			System.out.println("Contact "+lastName+" is not deleted and script Failed");
		else 
			System.out.println("Contact "+lastName+" is deleted and script Pass");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout Successfully");
			
	
	}
	
}
