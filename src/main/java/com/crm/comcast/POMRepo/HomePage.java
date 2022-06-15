package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage extends WebDriver_Utility  {
	
	//WebDriver driver;
	
	//Cross check why this constructor has to be parameterized, what will happen if no parameterized constructor is used 
	//Check what will happen to the control on driver if the No parameterized construct is used
	//When we navigate to this page initially what will happen
	public HomePage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Organizations")
	private WebElement  organizationLink;
	
	@FindBy (linkText = "Products")
	private WebElement productsLink;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy (name ="Purchase Order")
	private WebElement purchaseLink;
	
	@FindBy (xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorSignout;
	
	@FindBy (linkText ="Sign Out")
	private WebElement signoutButton;
	
	@FindBy (linkText ="Contacts")
	private WebElement contactsLink;
	
	@FindBy (linkText ="Campaigns")
	private WebElement campaignLink;
	
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getPurchaseLink() {
		return purchaseLink;
	}
	
	public WebElement getAdministratorSignout() {
		return administratorSignout;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}
	
	public void logout(WebDriver driver) {
		WebDriver_Utility wd = new WebDriver_Utility();
		wd.mouseOverOnElement(driver, administratorSignout);
		signoutButton.click();
	}
	
}
