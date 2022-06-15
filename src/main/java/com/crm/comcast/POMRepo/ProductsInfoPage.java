package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	public ProductsInfoPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "productname")
	private WebElement  productNameTF;
	
	@FindBy (xpath = "//input[@value='  Save  ']")
	private WebElement saveButton;

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	

}
