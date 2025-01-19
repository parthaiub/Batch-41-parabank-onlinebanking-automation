package com.generic;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.util.BaseConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetpDef {
	
	WebDriver driver;//Globally initiate  
	PageFactoryParaBank pf;//Globally initiate 
	SoftAssert sa;//Globally initiate
	BaseConfig config;
	
	@Given("open browser")

	public void open_browser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();

	   
	}

	@Given("go to parabank application login page")
	public void go_to_parabank_application_login_page() throws Exception {
	//come form BaseConfig
	config=new BaseConfig();
	config.getConfig("URL");
	driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//Implicit wiat =HTML Load
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));//pageload  =page  Load

	}

	@When("put valid username")
	public void put_valid_username() throws Exception {
		//How to write selenium webelement locator
		//driver.findElement(By.xpath("//*[@name='username']")).sendKeys("partha");
		
		pf = new PageFactoryParaBank(driver);
		
		//Explicit wait when add wait in particular element 
		WebDriverWait wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUsername()));
		
		pf.getUsername().sendKeys(config.getConfig("VALID_USERNAME"));
	}

	@When("put valid password")
	public void put_valid_password() throws Exception {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys(config.getConfig("VALID_PASSWORD"));
	}

	@When("click login button")
	public void click_login_button() { 
		pf = new PageFactoryParaBank(driver);
		pf.getLoginButton().click();
	}

	@Then("login should pass and logout button should visible")
	public void login_should_pass_and_logout_button_should_visible() {
		
		//Hard assert
		//Assert.assertTrue(Condition);	
		//soft assert
		sa= new SoftAssert();
		sa.assertTrue(	pf.getLogoutbButton().isDisplayed());
		sa.assertAll();// at last assert we need use sa.assertall();
		driver.quit();
	
	
	}

	@When("put invalid username")
	public void put_invalid_username() throws Exception {
		sa= new SoftAssert();
		pf = new PageFactoryParaBank(driver);
		pf.getUsername().sendKeys(config.getConfig("INVALID_USERNAME"));
	    
	}

	@Then("login should fail and dsiplay message password error")
	public void login_should_fail_and_dsiplay_message_password_error() {
		sa= new SoftAssert();
		sa.assertTrue(	pf.getPasswordError().isDisplayed());
		sa.assertAll();// at last assert we need use sa.assertall();
		driver.quit();
	
	}

	@When("put invalid password")
	public void put_invalid_password() throws Exception {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys(config.getConfig("INVALID_PASSWORD"));
	}

	@Then("login should fail and dsiplay username error")
	public void login_should_fail_and_dsiplay_username_error() { 
		sa= new SoftAssert();
		sa.assertTrue(	pf.getPassUsernameError().isDisplayed());
		sa.assertAll();
		driver.quit();
	}

	@When("put null username")
	public void put_null_username() {
		pf = new PageFactoryParaBank(driver);
		pf.getUsername().sendKeys("");
	    
	}

	@When("put null password")
	public void put_null_password() {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys("");
	}

	@Then("login should fail and dsiplay username error message Please enter a username and password")
	public void login_should_fail_and_dsiplay_username_error_message_Please_enter_a_username_and_password() {
		sa= new SoftAssert();
		sa.assertTrue(	pf.getUsernameaAndPassUsernameError().isDisplayed());
		sa.assertAll();
		driver.quit();
	}

	@Then("login should fail and dsiplay error message username require")
	public void login_should_fail_and_dsiplay_error_message_username_require() {
		sa= new SoftAssert();
		sa.assertTrue(	pf.getEnterUsernameError().isDisplayed());
		sa.assertAll();
		driver.quit();
	}

	@Then("login should fail and dsiplay error message password require")
	public void login_should_fail_and_dsiplay_error_message_password_require() {
		sa= new SoftAssert();
		sa.assertTrue(	pf.getEnterPasswordError().isDisplayed());
		sa.assertAll();
		driver.quit();
	}
	
/*
//validpasword
	
	@When("put valid username {String}")
	public void put_valid_username_Parthaiub(String username) {
	   
		pf = new PageFactoryParaBank(driver);
		WebDriverWait wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUsername()));
		pf.getUsername().sendKeys(username);
	}

	@When("put valid password {int}")
	public void put_valid_password_Partha(String password) {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys(password);
	   
	}

	//not working
	@When("put valid username Parthaiub {String}")
	public void put_valid_username_Parthaiub(String username) {
		pf = new PageFactoryParaBank(driver);
		WebDriverWait wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUsername()));
		pf.getUsername().sendKeys(username);
	}

	@When("put valid password Partha@{int}")
	public void put_valid_password_Partha(CharSequence[] password) {
	
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys(password);
	}
*/
	
}
