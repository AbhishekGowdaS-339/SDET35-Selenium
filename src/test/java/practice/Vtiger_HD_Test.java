package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiger_HD_Test {
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String orgName = "AGS";
		
		try {
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			//driver.findElement(By.name("button")).click();
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			Thread.sleep(10000);
			
			String actualAlertText = driver.switchTo().alert().getText();
			String expectedAlertTest = "Organization Name Already Exists!";
			driver.switchTo().alert().accept();
		
			if(actualAlertText.equals(expectedAlertTest)) 
			{
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.linkText(orgName)).click();
				System.out.println("Organiztion is Created information is displayed");
			} 
	
		}
		catch (Exception e) {
			System.out.println("Existing Organization information is displayed");
		
		}
		//driver.quit();
		
	}
	/*
	DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
	chromeCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeCapabilities.setCapability(chromeOptions.CAPABILITY, chromeOptions);
	WebDriver driver = new ChromeDriver(chromeCapabilities);
	*/
	/*Set<String> allWindows = driver.getWindowHandles();
	for (String ele : allWindows) {
		System.out.println(ele);
	}*/
	/*
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	//driver.findElement(By.name("button")).click();
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	
	Thread.sleep(10000);
	String actualAlertText = driver.switchTo().alert().getText();
	String expectedAlertTest = "Organization Name Already Exists!";
	driver.switchTo().alert().accept();
	
	if(actualAlertText.equals(expectedAlertTest)) 
	{
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.linkText(orgName)).click();
	}
	*/

}
