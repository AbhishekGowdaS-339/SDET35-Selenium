

package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedOrgPage {
	
	public CreatedOrgPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "dvHeaderText")
	private WebElement  createdPageName;

	public WebElement getCreatedPageName() {
		return createdPageName;
	}
	
	public String actualOrgtName() {
		return createdPageName.getText();
		
	}
}
