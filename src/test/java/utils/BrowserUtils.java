package utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	//here we create a function for any element to wait and we can call it any time anywhere  
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//this function will wait for the after we put the name and city and country..etc in the boxes 
	public void waitForElementToBeInputed(WebElement element, String text) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	//here we create method for more than one element 
	public void waitForAllElementsToBeVisible(List<WebElement> element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	//here we create action so we can send the email and password to their boxes but don't forget to use the 
	//build().perform()
	public void sendkeysWithActionsClass(WebElement element, String input) {
		act = new Actions(Driver.getDriver());
		act.sendKeys(element, input).build().perform();
	}
	
	public void moveToWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.moveToElement(element).build().perform();
	}
	
	public void clickWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.click(element).build().perform();
	}
	
	public void clickUsingActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.click(element).build().perform();
	}
	
	public void scrollToElementUsingActions(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.scrollToElement(element).build().perform();
	}
	
	public void scrollUp() {
		act = new Actions(Driver.getDriver());
		act.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	
	//here we create a method for the elements on the second page so we let the page wait for the element to appear
	//so it could read it because if we don't put enough time and the load fast there is a big chance to have the test
	//fail
	public void waitUntilElementVisibleWithLocator(By locator) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	// this method generate 3 digit random number this is to make the static name to dynamic name, it will add 
	//3 different numbers to any name so the any name will be added will be unique 
	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
	//this method tells the driver to wait until an element is clickable 
	public void waitUntilElementClickable(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementClickableWithLocator(By locator) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
