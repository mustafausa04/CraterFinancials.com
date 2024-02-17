package tests;

import java.time.Duration;//from java.time
import org.openqa.selenium.OutputType;// comes from selenium
import org.openqa.selenium.TakesScreenshot;//comes from selenium 
import io.cucumber.java.After;//import io.cucumber.java; from cucumber java not from junit
import io.cucumber.java.Before;//import io.cucumber.java; from cucumber java not from junit
import io.cucumber.java.Scenario;//import io.cucumber.java; from cucumber java not from junit
import utils.Driver;

public class Hooks {
	
		@Before
		public void setup() {
			Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Driver.getDriver().manage().window().maximize();
		}
		
		@After
		public void wrapup(Scenario scenario) {
			if (scenario.isFailed()) {         //if the scenario failed take a screen shot and attache it
				final byte[] screenshot = ((TakesScreenshot) 
						Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");
			}
			Driver.quitDriver();
		}
}
