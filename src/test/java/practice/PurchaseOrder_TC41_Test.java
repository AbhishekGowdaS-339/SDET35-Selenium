package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Generic_Utilities.Excel_Utility;
//import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class PurchaseOrder_TC41_Test {
public static void main(String[] args) throws Throwable {
		
		Excel_Utility exl = new Excel_Utility();
		PropertyFile_Utility pro = new PropertyFile_Utility();
		//Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
		
		String vendorName =exl.getStringDataFromExcel("Sheet1", 4, 9);
		String purchaseSub =exl.getStringDataFromExcel("Sheet1", 4, 10);
		String billingAdd =exl.getStringDataFromExcel("Sheet1", 4, 11);
		String shippingAdd =exl.getStringDataFromExcel("Sheet1", 4, 12);
		int qty1 =(int)exl.getNumDataFromExcel("Sheet1", 4, 13);
		String qty = ""+ qty1;
		
		String browser = pro.getDataFromProperty("browser");
		WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		driver.get(pro.getDataFromProperty("url"));
		
		driver.findElement(By.name("user_name")).sendKeys(pro.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		wd.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")));
		driver.findElement(By.linkText("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("subject")).sendKeys(purchaseSub);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parentWin = driver.getWindowHandle(); 
		wd.switchToWindowExcludeParent(driver, "PurchaseOrder&action");
		driver.findElement(By.linkText(vendorName)).click();
		driver.switchTo().window(parentWin);
		wd.scrollTo(driver, "window.scrollTo(0,1000);");
		
		driver.findElement(By.id("searchIcon1")).click();
		wd.switchToWindowExcludeParent(driver, "Products&action");
		driver.findElement(By.linkText("Blower36")).click();
		driver.switchTo().window(parentWin);
		
		driver.findElement(By.name("qty1")).sendKeys(qty);
		driver.findElement(By.name("bill_street")).sendKeys(billingAdd);
		driver.findElement(By.name("ship_street")).sendKeys(shippingAdd);
		
		driver.findElement(By.name("Duplicate")).click();
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actualSucceessfulMsg = driver.findElement(By.className("lvtHeaderText")).getText();
		wd.pageCreateConfirmationMsg(actualSucceessfulMsg, purchaseSub);
		
		wd.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		System.out.println("Logout Successfully");
	}
}
