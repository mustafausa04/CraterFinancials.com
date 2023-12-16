package tests;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagement_steps {
	//we brought these methods below from cucumber file UserManagement.feature file with all the steps after we run
	//the cucumber file there we copy the steps and bring them here and delete the lines that came with and then
	//we implement them with what we need
	
	BrowserUtils utils = new BrowserUtils();//to access the wait
	LoginPage loginpage = new LoginPage();//to access the elements in the LoginPge class
	DashboardPage dashboardpage = new DashboardPage();//to access the element in the DashboardPge class
	
	//valid credential login test-start
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(TestDataReader.getProperty("appurl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.getDriver().manage().window().maximize();
		utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	}

	@When("I enter valid useremail and valid password")
	public void i_enter_valid_useremail_and_valid_password() {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginpage.login_page_login_btn.click();
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		//this is to confirm that you logged in and you are on the second page , we will grab the first element on
		//that page it's "Dashboard" and wait to appear then when we see it we can validate that we see it in the
		//next step if we don't put wait time the test will fail because loading the page will be fast and it can't 
		//read the element which leads to fail, so we created a wait method in the BrowserUtils class and call the
		//element "Dashboard" By its xpath like below to make wait after its appear to give time to read it.
		utils.waitUntilElementVisibleWithLocator(By.xpath("//span[text()='Amount Due']"));
		
		//here we will use Assert it means validate, to validate that we see the "Dashboard" element on the second page
		//if it returns true, but if returns false it means we are not on the second page and test will fail
	    Assert.assertTrue(dashboardpage.dashboard_tab.isDisplayed());
	}
	//valid credential login test-end
	
	
    //invalid email login attempt-start
	//there is no need to mention step1 which is "i'm on the login page" as we said cucumber doesn't repeat the same
	//steps that are duplicate, same with step3 click on login button
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, "yummy@primetechschool.com");
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	}
	
    //here we will compare the the message we added in the cucumber file with one in the page 
	@Then("I should see an error message {string} displays")
	public void i_should_see_an_error_message_displays(String errorMessage) {
	   utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);//we let the element wait
	   //and here we compare the error message to the one we added in the cucumber file "UserManagement" 
	   Assert.assertEquals(errorMessage, loginpage.login_page_invalidLogin_message.getText());
	}

	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
	   Assert.assertTrue(loginpage.login_page_login_btn.isDisplayed());
	}
	//invalid email login attempt-end
	
	
}
