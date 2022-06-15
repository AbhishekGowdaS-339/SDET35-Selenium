package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	public CampaignInfoPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name ='campaignname']")
	private WebElement campaignNameTF;
	
	@FindBy (name = "button")
	private WebElement saveButton;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement prodWinButton;
	
	public WebElement getProdWinButton() {
		return prodWinButton;
	}

	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

}
