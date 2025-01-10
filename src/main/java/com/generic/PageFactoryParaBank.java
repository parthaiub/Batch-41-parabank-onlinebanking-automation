package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryParaBank {
	
	
	//Constructor
	public PageFactoryParaBank(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Login
	@FindBy( xpath="//*[@name='username']")
private WebElement Username;
	
	@FindBy( xpath="//*[@name='password']")
private WebElement Password;
	
	@FindBy( xpath="//*[@type='submit']")
private WebElement	LoginButton;

	@FindBy( xpath="//*[text()='Log Out']")
private	WebElement LogoutbButton;
	
@FindBy( xpath="//*[text()='The username and password could not be verified.']")
	private	WebElement PasswordError;

@FindBy( xpath="//*[text()='The username and password could not be verified.']")
private	WebElement PassUsernameError;


public WebElement getUsernameaAndPassUsernameError() {
	return UsernameaAndPassUsernameError;
}

@FindBy( xpath="//*[text()='Please enter a username and password.']")
private	WebElement UsernameaAndPassUsernameError;

@FindBy( xpath="//*[text()='Please enter a username and password.']")
private	WebElement EnterUsernameError;

@FindBy( xpath="//*[text()='Please enter a username and password.']")
private	WebElement EnterPasswordError;


public WebElement getEnterPasswordError() {
	return EnterPasswordError;
}
public WebElement getEnterUsernameError() {
	return EnterUsernameError;
}
public WebElement getPassUsernameError() {
	return PassUsernameError;
}
public WebElement getPasswordError() {
	return PasswordError;
}
public WebElement getLogoutbButton() {
	return LogoutbButton;
}
public WebElement getUsername() {
	return Username;
}
public WebElement getPassword() {
	return Password;
}
public WebElement getLoginButton() {
	return LoginButton;
}



}
