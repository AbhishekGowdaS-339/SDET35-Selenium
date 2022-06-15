package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement  organizationPlusLink;

	public WebElement getOrganizationPlusLink() {
		return organizationPlusLink;
	}
}
