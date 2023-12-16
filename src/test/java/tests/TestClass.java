package tests;

import java.time.Duration;
import pages.AmazonHomepage;
import utils.Driver;
import utils.TestDataReader;

public class TestClass {
	//here we keep all our actual test

	public static void main(String[] args) {
		//this is what we used to do to call the amazon page
		//Driver.getDriver().get("https://amazon.com");
		
		//but now we have the amazon url in the env.properties so we going to grab it from there but
		// in order to read something from the env.properties, 
		// we need to use the utility class TestDataReader to read with the key.
		Driver.getDriver().get(TestDataReader.getProperty("amazonurl"));//we added TestDataReader to get the url
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		// in order to use the page objects stored in the page classes, 
		// we need to create an object of that class, then call the web element object for use.
		AmazonHomepage azpage = new AmazonHomepage();
		azpage.amazonSearchBox.sendKeys("Coffee mug");
		azpage.amazonSearchButton.click();
	}

}
