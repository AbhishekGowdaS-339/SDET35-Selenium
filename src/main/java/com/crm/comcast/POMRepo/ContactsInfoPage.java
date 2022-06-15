package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	public ContactsInfoPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "lastname")
	private WebElement  lastNameTF;
	
	@FindBy (xpath = "//input[@value='  Save  ']")
	private WebElement saveButton;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
