package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.CampaignInfoPage;
import com.crm.comcast.POMRepo.CampaignPage;
import com.crm.comcast.POMRepo.CreatedCpamPage;
import com.crm.comcast.POMRepo.HomePage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class CreateCampaignTest extends BaseClass {
	
		@Test(groups={"regressionTest"})
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
		Assert.assertEquals(createdCpanP.actualCampaignName().contains(campaignName), true);
		
	}
}
