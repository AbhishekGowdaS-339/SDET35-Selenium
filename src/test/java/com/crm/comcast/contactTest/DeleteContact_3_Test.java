package com.crm.comcast.contactTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.ContactsInfoPage;
import com.crm.comcast.POMRepo.ContactsPage;
import com.crm.comcast.POMRepo.CreatedCntPage;
import com.crm.comcast.POMRepo.HomePage;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

public class DeleteContact_3_Test extends BaseClass{
	
		@Test(groups={"sanityTest"})
		public void deleteContactTest() throws Throwable {
		
		Excel_Utility exl = new Excel_Utility();

		
		String LastName =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 7);
		String alertMsg =exl.getStringDataFromExcelAndRandomNum("Sheet1", 4, 14);
	
		HomePage homeP = new HomePage(driver);
		homeP.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getLastNameTF().sendKeys(LastName);
		contactsIP.getSaveButton().click();
		
		CreatedCntPage createdCP = new CreatedCntPage(driver);
		Assert.assertEquals(createdCP.actualContactName().contains(LastName), true);
		createdCP.getDeletePage().click();
		
		wdLib.switchToAlertAndAccept(driver, alertMsg);	
		
		int count =0;
		
		for (WebElement lastNameEle : contactsP.getListOfLastName()) {
			if(lastNameEle.equals(LastName)) {
				count++;
				break;
			}
		}
		
		if(count!=0)
			System.out.println("Contact "+LastName+" is not deleted and script Failed");
		else 
			System.out.println("Contact "+LastName+" is deleted and script Pass");
		
	}
}
