package xml;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.CampaignInfoPage;
import com.crm.comcast.POMRepo.CampaignPage;
import com.crm.comcast.POMRepo.CreatedCpamPage;
import com.crm.comcast.POMRepo.CreatedPdtPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.ProductPage;
import com.crm.comcast.POMRepo.ProductsInfoPage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class CampaginTest extends BaseClass {
	@Test
	public void createCampaignTest() throws Throwable {
	
	Excel_Utility exl = new Excel_Utility();
	
	String campaignName =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 7);
	
	HomePage homeP = new HomePage(driver);
	wdLib.mouseOverOnElement(driver, homeP.getMoreLink());
	homeP.getCampaignLink().click();
	
	CampaignPage campaignP = new CampaignPage(driver);
	campaignP.getCampaignPlusLink().click();
	
	CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
	campaignIP.getCampaignNameTF().sendKeys(campaignName);
	campaignIP.getSaveButton().click();
			
	CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
	if(createdCpanP.getCreatedCpanName().getText().contains(campaignName))
		System.out.println("Pass :: Campaign Page "+campaignName+" is created");
	else
		System.out.println("Fail :: Capmaign Page"+campaignName+" is not created");
	
} 	
	
		@Test
		public void CreateCampaginWithProductTest() throws Throwable{
	
		Excel_Utility exl = new Excel_Utility();
		
  
		String campaignName =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 7);
		String productName =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 8);
		
		HomePage homeP = new HomePage(driver);
		homeP.getProductsLink().click();
		
		ProductPage productP = new ProductPage(driver);
		productP.getProductPlusLink().click();
		
		ProductsInfoPage productIP = new ProductsInfoPage(driver);
		productIP.getProductNameTF().sendKeys(productName);
		productIP.getSaveButton().click();
		
		CreatedPdtPage createdPdtP = new CreatedPdtPage(driver);
		String actualProductMsg =createdPdtP.getCreatedPdtPageName().getText();
		if(createdPdtP.getCreatedPdtPageName().getText().contains(productName))
			System.out.println("Pass :: Product Page "+productName+" is created");
		else
			System.out.println("Fail :: Product Page "+productName+" is not created");
		
		
		wdLib.mouseOverOnElement(driver, homeP.getMoreLink());
		homeP.getCampaignLink().click();
		
		CampaignPage campaignP = new CampaignPage(driver);
		campaignP.getCampaignPlusLink().click();
	
		CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
		String parentWin = driver.getWindowHandle(); 
		campaignIP.getCampaignNameTF().sendKeys(campaignName);
		campaignIP.getProdWinButton().click();
		wdLib.switchToWindowExcludeParent(driver, actualProductMsg);
		driver.findElement(By.linkText(productName)).click();
		
		driver.switchTo().window(parentWin);
		campaignIP.getSaveButton().click();
		
		CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
		if(createdCpanP.getCreatedCpanName().getText().contains(campaignName))
			System.out.println("Pass :: Campaign Page "+campaignName+" is created");
		else
			System.out.println("Fail :: Capmaign Page"+campaignName+" is not created");
		
				 
	}
}
