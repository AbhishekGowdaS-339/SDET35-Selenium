package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedPdtPage {
	public CreatedPdtPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "lvtHeaderText")
	private WebElement  createdPdtPageName;

	public WebElement getCreatedPdtPageName() {
		return createdPdtPageName;
	}
	
	public String actualProductName() {
		return createdPdtPageName.getText();
		
	}

}
