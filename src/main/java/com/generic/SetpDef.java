package com.generic;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetpDef {
	
	WebDriver driver;//Globally initiate  
	PageFactoryParaBank pf;//Globally initiate 
	SoftAssert sa;//Globally initiate
	
	@Given("open browser")

	public void open_browser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   
	}

	@Given("go to parabank application login page")
	public void go_to_parabank_application_login_page() {
	driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
	

	}

	@When("put valid username")
	public void put_valid_username() {
		//How to write selenium webelement locator
		//driver.findElement(By.xpath("//*[@name='username']")).sendKeys("partha");
		
		pf = new PageFactoryParaBank(driver);
		pf.getUsername().sendKeys("Parthaiub");
	}

	@When("put valid password")
	public void put_valid_password() {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys("Partha@12345");
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
	public void put_invalid_username() {
		sa= new SoftAssert();
		pf = new PageFactoryParaBank(driver);
		pf.getUsername().sendKeys("artha");
	    
	}

	@Then("login should fail and dsiplay message password error")
	public void login_should_fail_and_dsiplay_message_password_error() {
		sa= new SoftAssert();
		sa.assertTrue(	pf.getPasswordError().isDisplayed());
		sa.assertAll();// at last assert we need use sa.assertall();
		driver.quit();
	
	}

	@When("put invalid password")
	public void put_invalid_password() {
		pf = new PageFactoryParaBank(driver);
		pf.getPassword().sendKeys("2345");
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


}
