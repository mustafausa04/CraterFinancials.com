package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//div[text()='Email ']")
	public WebElement login_page_email_label;
	
	@FindBy (css = "input[name=email]")
	public WebElement login_page_email_box;
	
	@FindBy (xpath = "//div[text()='Password ']")
	public WebElement login_page_password_label;
	
	@FindBy (css = "input[name=password]")
	public WebElement login_page_password_box;
	
	@FindBy (linkText = "Forgot Password?")
	public WebElement login_page_forgotPassword_link;
	
	@FindBy (xpath = "//button[text()='Login']")
	public WebElement login_page_login_btn;
	
	@FindBy (xpath = "//p[contains(text(), 'Copyright @')]")
	public WebElement login_page_copyright_text;
	
	@FindBy (xpath = "//h1[contains(text(), 'Simple Invoicing')]")
	public WebElement login_page_simple_invoicing_text;
	
	@FindBy (xpath = "//p[contains(text(), 'Crater helps you')]")
	public WebElement login_page_craterHelpsYou_text;
	
	// how to have multiple elements as a page object
	//this is for the message appears when you don't put email or password or both
	@FindBy (xpath = "//span[text()='Field is required']")
	public List<WebElement> login_page_fieldRequired_Messages;
	
	//this is for the error message appears when we put invalid email or password
	@FindBy (xpath = "//p[text()='These credentials do not match our records.']")
	public WebElement login_page_invalidLogin_message;
	
	//this is the primetech school wesite for education only, (http://crater.primetech-apps.com/login), 
	//copy this url and paste
	//in the browser, a red window will show up, just click anywhere in that red window and put ( thisisunsafe ), it 
	// will unblock the website for you.
	//put this email address and password to login in the website (crater.primetech-apps.com/login)
	//email: dummy@primetechschool.com
	//password: primetech@school

}
