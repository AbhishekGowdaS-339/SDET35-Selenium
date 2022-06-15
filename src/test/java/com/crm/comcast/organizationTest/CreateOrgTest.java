package com.crm.comcast.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.CreatedOrgPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.OrgInfoPage;
import com.crm.comcast.POMRepo.OrganizationPage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class CreateOrgTest extends BaseClass{
		
		@Test(groups={"sanity"})
		public void createOrganizationtest() throws Throwable {
		Excel_Utility exl = new Excel_Utility();

		String orgName =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 7);
		
		HomePage homeP = new HomePage(driver);
		homeP.getOrganizationLink().click();
		
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.getOrganizationPlusLink().click();
		
		OrgInfoPage orgInfoP = new OrgInfoPage(driver);
		orgInfoP.getOrgNameTF().sendKeys(orgName);
		orgInfoP.getSaveButton().click();
		
		CreatedOrgPage createdOP = new CreatedOrgPage(driver);
		/*
		wd.pageCreateConfirmationMsg(createdOP.getCreatedPageName().getText(), orgName);
		
		if(createdOP.getCreatedPageName().getText().contains(orgName)) 
			System.out.println("Pass :: Campaign Page "+orgName+" is successfully created");
		else
			System.out.println("Fail :: Campaign Page "+orgName+" is not created");
		*/
		Assert.assertEquals(false, true);
		Assert.assertEquals(createdOP.actualOrgtName().contains(orgName), true);

	}
}
