package practice_generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	
		Excel_Utility exl = new Excel_Utility();
		PropertyFile_Utility pro = new PropertyFile_Utility();
		Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
		
		String orgName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		
		String browser = pro.getDataFromProperty("browser");
		WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		
		driver.get(pro.getDataFromProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(pro.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actualSucceessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
		wd.pageCreateConfirmationMsg(actualSucceessfulMsg, orgName);
		
		wd.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		System.out.println("Logout Successfully");
	}
}
