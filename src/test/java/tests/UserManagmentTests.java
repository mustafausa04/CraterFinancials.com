package tests;

import java.time.Duration;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagmentTests {
	
	public static void main(String[] args) {
		//this is the primetech school wesite for education only, (http://crater.primetech-apps.com/login), 
		//copy this url and paste
		//in the browser, a red window will show up, just click anywhere in that red window and put ( thisisunsafe ), it 
		// will unblock the website for you.
		//put this email address and password to login in the website (crater.primetech-apps.com/login)
		//email: dummy@primetechschool.com
		//password: primetech@school
		
		//invalidEmailLoginTest();//execute wrong email, right password
		invalidPasswordLogin_test();//execute right email, wrong password 
		
	}
	
	
	static BrowserUtils utils;//this is to let us access to BrowserUtils
	static LoginPage loginpage;//this is to let us access to login page
	
	public static void invalidEmailLoginTest() {
		
		//we declare variables here so we can call them in any method we want 
		utils = new BrowserUtils();
		loginpage = new LoginPage();
		
		// invalid email login test
		// go to crater
		Driver.getDriver().get(TestDataReader.getProperty("appurl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.getDriver().manage().window().maximize();
		
		// click on login button without filling out the credential fields
		utils.waitForElementToBeVisible(loginpage.login_page_email_box);//here we are calling the wait method from the
		                                                                //BrowserUtli file or class
		loginpage.login_page_login_btn.click();
		
		// then verify there are 2 fields required messages display
		//here we will call wait method but for all elements from BrowserUtli file or class
		utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
		if (loginpage.login_page_fieldRequired_Messages.size() == 2) {
			System.out.println("There are 2 required field messages displayed");
		}else {
			System.out.println("Something is wrong with required field messages.");
		}
		
		// enter invalid email yummy@primetechschool.com and valid password primetech@school
		//here we call the action method from BrowserUtli file or class to sent the email and password to their boxes 
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, "yummy@primetechschool.com");
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
		
		//we could do the step above with these next 2 lines but it will not work because the css on the website will
		//prevent the email and password to go to their boxes so we had to with the steps above
		/*loginpage.login_page_email_box.sendKeys("yummy@primetechschool.com");
		loginpage.login_page_password_box.sendKeys(TestDataReader.getProperty("password"));*/
		
		// click login button
		loginpage.login_page_login_btn.click();
		
		// then verify that an error message  "These credentials do not match our records." displays
		utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
		if (loginpage.login_page_invalidLogin_message.isDisplayed()) {
			System.out.println("Credential invalid Error message displayed");
		}else {
			System.out.println("Credential invalid Error message not displayed"); 
		}
	}
	
	
	public static void invalidPasswordLogin_test() {
		
		utils = new BrowserUtils();
		loginpage = new LoginPage();
		
		// invalid password login test
		// go to crater
		Driver.getDriver().get(TestDataReader.getProperty("appurl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.getDriver().manage().window().maximize();
		
		//click on login button without filling out the credential fields
		utils.waitForElementToBeVisible(loginpage.login_page_email_box);//here we are calling the wait method from the
                                                                        //BrowserUtli file or class
        loginpage.login_page_login_btn.click();

        // then verify there are 2 fields required messages display
     	//here we will call wait method but for all elements from BrowserUtli file or class
     	utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
     	if (loginpage.login_page_fieldRequired_Messages.size() == 2) {
     		System.out.println("There are 2 required field messages displayed");
     	}else {
     		System.out.println("Something is wrong with required field messages.");
     	}
     	
        // enter valid email dummy@primetechschool.com and Invalid password primetech@school
     	//here we call the action method from BrowserUtli file or class to sent the email and password to their boxes 
     	/*utils.sendkeysWithActionsClass(loginpage.login_page_email_box, "dummy@primetechschool.com");*/
     	// we could use the above to provide the valid email or the one below because the one below wll get us the 
     	//the email that is in the env file and that was the Valid email
     	utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
     	//here we should provide Invalid password so we do it this way because if we get it from env file it will
     	//be the valid password and according to the test required her is Invalid password
     	utils.sendkeysWithActionsClass(loginpage.login_page_password_box, "primeschool");
     	
        // click login button
     	loginpage.login_page_login_btn.click();
     	
        // then verify that an error message  "These credentials do not match our records." displays
     	utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
     	if (loginpage.login_page_invalidLogin_message.isDisplayed()) {
     		System.out.println("Credential invalid Error message displayed");
     	}else {
     		System.out.println("Credential invalid Error message not displayed"); 
     	} 
	}

}
