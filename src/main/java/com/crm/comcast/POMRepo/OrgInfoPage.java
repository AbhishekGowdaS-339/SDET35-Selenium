package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	public OrgInfoPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "accountname")
	private WebElement  orgNameTF;
	
	@FindBy (xpath = "//input[@value='  Save  ']")
	private WebElement saveButton;

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
