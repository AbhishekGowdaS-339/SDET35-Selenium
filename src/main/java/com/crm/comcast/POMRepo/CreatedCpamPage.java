package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedCpamPage {
	public CreatedCpamPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "dvHeaderText")
	private WebElement  createdCpanName;

	public WebElement getCreatedCpanName() {
		return createdCpanName;
	}
	
	public String actualCampaignName() {
		return createdCpanName.getText();
		
	}
}
