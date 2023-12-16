package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DashboardPage {
	//we create this page to include the elements that are on the second page so we can call them 
	
	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (linkText = " Dashboard")//this is the first element located on the second page
	public WebElement dashboard_tab;
	
	@FindBy (xpath = "//a[text()=' Customers']")//this is the "Customers" icon on the second page
	public WebElement customers_tab;
	
	@FindBy (xpath = "//a[text()=' Items']")//this is the "Items" icon on the second page
	public WebElement items_tab;
	
	@FindBy (xpath = "//p[text()='Logged in successfully.']") //this is the message that appears once we login
	public WebElement loggedInSuccess_message;
}
