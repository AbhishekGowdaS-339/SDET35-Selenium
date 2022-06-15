package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.ContactsInfoPage;
import com.crm.comcast.POMRepo.ContactsPage;
import com.crm.comcast.POMRepo.HomePage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class CreateContactWithoutMandatoryTest extends BaseClass {
		
		@Test(groups={"regressionTest"})
		public void createContactTest() throws Throwable {
		Excel_Utility exl = new Excel_Utility();
		
		String expectedAlertMsg =exl.getStringDataFromExcel("Sheet1", 4, 15);
		
		HomePage homeP = new HomePage(driver);
		homeP.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getSaveButton().click();
		wdLib.switchToAlertAndAccept(driver, expectedAlertMsg);
		
	}
}
