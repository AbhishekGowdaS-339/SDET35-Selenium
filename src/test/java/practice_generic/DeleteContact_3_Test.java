package practice_generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class DeleteContact_3_Test {
	public static void main(String[] args) throws Throwable {
		
		Excel_Utility exl = new Excel_Utility();
		
		PropertyFile_Utility pro = new PropertyFile_Utility();
		Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
		
		String lastName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		
		String browser = pro.getDataFromProperty("browser");
		
		WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		
		driver.get(pro.getDataFromProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(pro.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getDataFromProperty("password"));
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
		
		wd.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		System.out.println("Logout Successfully");
	}
}
