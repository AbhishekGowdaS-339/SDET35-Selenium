
package com.crm.comcast.campaignTest;

import org.openqa.selenium.By;
import org.testng.Assert;
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

public class CreateCampaginWithProduct_2_Test extends BaseClass {
		
		@Test(groups={"smokeTest", "regressionTest"})
		public void CreateCampaginWithProductTest(String Browser) throws Throwable{
	
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
		Assert.assertEquals(createdPdtP.actualProductName().contains(productName), true);
		
		
		wdLib.mouseOverOnElement(driver, homeP.getMoreLink());
		homeP.getCampaignLink().click();
		
		CampaignPage campaignP = new CampaignPage(driver);
		campaignP.getCampaignPlusLink().click();
	
		CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
		String parentWin = driver.getWindowHandle(); 
		campaignIP.getCampaignNameTF().sendKeys(campaignName);
		campaignIP.getProdWinButton().click();
		wdLib.switchToWindowExcludeParent(driver, createdPdtP.actualProductName());
		driver.findElement(By.linkText(productName)).click();
		
		driver.switchTo().window(parentWin);
		campaignIP.getSaveButton().click();
		
		CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
		Assert.assertEquals(createdCpanP.actualCampaignName().contains(campaignName), true);
		
				 
	}
}
