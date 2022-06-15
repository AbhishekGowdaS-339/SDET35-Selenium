package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedCntPage {
	
	//WebDriver driver;
	public CreatedCntPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "dvHeaderText")
	private WebElement  createdCntPageName;
	
	@FindBy (name = "Delete")
	private WebElement  deletePage;

	public WebElement getDeletePage() {
		return deletePage;
	}

	public WebElement getCreatedCntPageName() {
		return createdCntPageName;
	}
	
	public String actualContactName() {
		return createdCntPageName.getText();
		
	}

}
