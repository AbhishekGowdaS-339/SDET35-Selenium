package practice_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.comcast.POMRepo.CampaignInfoPage;
import com.crm.comcast.POMRepo.CampaignPage;
import com.crm.comcast.POMRepo.CreatedCpamPage;
import com.crm.comcast.POMRepo.CreatedPdtPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;
import com.crm.comcast.POMRepo.ProductPage;
import com.crm.comcast.POMRepo.ProductsInfoPage;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;  
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaginWithProduct_2_Test {
public static void main(String[] args) throws Throwable {
	
		Excel_Utility exl = new Excel_Utility();
		PropertyFile_Utility pro = new PropertyFile_Utility();
		Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
  
		String campaignName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		String productName =exl.getStringDataFromExcel("Sheet1", 4, 8)+jav.getRandomNum();
		String browser = pro.getDataFromProperty("browser");
		
		WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		
		LoginPage loginP = new LoginPage(driver);  
		driver.get(pro.getDataFromProperty("url"));
		loginP.loginToApp(pro.getDataFromProperty("username"), pro.getDataFromProperty("password"));
		
		HomePage homeP = new HomePage(driver);
		homeP.getProductsLink().click();
		
		ProductPage productP = new ProductPage(driver);
		productP.getProductPlusLink().click();
		
		ProductsInfoPage productIP = new ProductsInfoPage(driver);
		productIP.getProductNameTF().sendKeys(productName);
		productIP.getSaveButton().click();
		
		CreatedPdtPage createdPdtP = new CreatedPdtPage(driver);
		String actualProductMsg =createdPdtP.getCreatedPdtPageName().getText();
		wd.pageCreateConfirmationMsg(actualProductMsg, productName);
		
		wd.mouseOverOnElement(driver, homeP.getMoreLink());
		homeP.getCampaignLink().click();
		
		CampaignPage campaignP = new CampaignPage(driver);
		campaignP.getCampaignPlusLink().click();
	
		CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
		String parentWin = driver.getWindowHandle(); 
		campaignIP.getCampaignNameTF().sendKeys(campaignName);
		campaignIP.getProdWinButton().click();
		wd.switchToWindowExcludeParent(driver, actualProductMsg);
		driver.findElement(By.linkText(productName)).click();
		
		driver.switchTo().window(parentWin);
		campaignIP.getSaveButton().click();
		
		CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
		wd.pageCreateConfirmationMsg(createdCpanP.getCreatedCpanName().getText(), campaignName);	
		
		wd.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton().click();
		
		System.out.println("Logout Successfully");
		
		//driver.quit();
		 
	}
}
