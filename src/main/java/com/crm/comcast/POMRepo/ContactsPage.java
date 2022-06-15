package com.crm.comcast.POMRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	public ContactsPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement  contactsPlusLink;
	
	@FindBy(xpath = "(//a[@title='Contacts'])[position() mod 2 =0]")
	private List<WebElement>  listOfLastName;

	public List<WebElement> getListOfLastName() {
		return listOfLastName;
	}

	public WebElement getContactsPlusLink() {
		return contactsPlusLink;
	}
	
}
