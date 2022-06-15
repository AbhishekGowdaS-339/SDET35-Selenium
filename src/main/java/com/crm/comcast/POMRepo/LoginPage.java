package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//WebDriver driver;
	
	//public LoginPage() {
		//this.driver = driver;
		//PageFactory.initElements(driver, this);
	//}

	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name ="user_name")
	private WebElement usernameTF;
	
	@FindBy (name ="user_password")
	private WebElement passwordTF;
	
	@FindBy (id ="submitButton")
	private WebElement submitBT;	
	
	public WebElement getUsername() {
		return usernameTF;
	}

	public WebElement getPassword() {
		return passwordTF;
	}

	public WebElement getSubmit() {
		return submitBT;
	}

	
	public void loginToApp(String userName, String passWord) {
		usernameTF.clear();
		usernameTF.sendKeys(userName);
		passwordTF.clear();
		passwordTF.sendKeys(passWord);
		submitBT.click();
	}
	
}
