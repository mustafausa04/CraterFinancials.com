package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AmazonHomepage {
	// The purpose of this constructor is that whenever we create an object of this class,
	// we are initializing the page factory 
	// and initializing the webElements within this class with the object of the driver we have.
	//basically we will call the id or xpath below in any other file any time we want without creating driver.getBy
	//the page package or page project is to keep all elements here from the website and attche them to the Driver
	//so we can all any element we added here in any other folder at any time we want
	public AmazonHomepage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//find the elements
	@FindBy (id = "twotabsearchtextbox")
	public WebElement amazonSearchBox;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	public WebElement amazonSearchButton;

}
