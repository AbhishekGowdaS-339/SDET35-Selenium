package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.ContactsInfoPage;
import com.crm.comcast.POMRepo.ContactsPage;
import com.crm.comcast.POMRepo.CreatedCntPage;
import com.crm.comcast.POMRepo.HomePage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class CreateContactTest extends BaseClass {
		
		@Test(groups={"regressionTest"})
		public void createContactTest() throws Throwable {
		Excel_Utility exl = new Excel_Utility();
		
		String LastName =exl.getStringDataFromExcel("Sheet1", 4, 7);
		
		HomePage homeP = new HomePage(driver);
		homeP.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getLastNameTF().sendKeys(LastName);
		contactsIP.getSaveButton().click();
		
		CreatedCntPage createdCP = new CreatedCntPage(driver);
		Assert.assertEquals(createdCP.actualContactName().contains(LastName), true);
		/*
		if(createdCP.getCreatedCntPageName().getText().contains(LastName))
			System.out.println("Pass :: Contact Page "+LastName+" is created");
		else
			System.out.println("Fail :: Contact "+LastName+" is not created");
		*/
	}
}
