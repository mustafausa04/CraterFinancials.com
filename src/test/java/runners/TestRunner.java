package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//when we run this code it will be with junit, so the explaination is the cucumber class will RunWith JUnit and it will
//go locate the features file glue it to test package where the UserManagement_steps are and filter through it to get
//the tag that we want to run

@RunWith(Cucumber.class)
@CucumberOptions(
		//so here we will create plugin using the pretty library to create 2 folders html, json and files report
		//inside of them, run the program then go to the project on the left menu, refresh it so you can see the 
		//folder "Cucumber_reports", open it, click on the html file there and open with web browser to see the report
		plugin = {"pretty", //we use plugin for html and json to get a cucumber report we have to put "pretty"
				"html:Cucumber_reports/cucumber_report.html",//we create this file here and it will be added to the
				"json:Cucumber_reports/cucumber_report.json"},//rest of folder once we run and refresh
		
		features="./src/test/resources/features",//we put ./src...etc because we are inside the TestRunner file and we
		                                         //we need to get out of the folder src/test/java to get to 
		                                         //src/test/resources/features
		glue="tests",     //here we put all our step definitions folders which are all in tests package 
		//tags="@invalidEmailLogin"//we want this scenario to be run so we bring the tag from cucumber file
		//tags="@createItem"//this one is not working
        //tags="@newCustomerBTNTest"
		//tags="@newCustomerBasicInfoFormLabel"
		//tags="@customerManagementTests"//this one is not working
		//tags="@newCustomerBasicInfoFields"
		//tags="@newCustomerTableList"
		//tags="@editItem"
		//tags="@ScenarioOutlineDemo"
		//tags="@customerTableColumns"
		//tags="@customerTableMoreOptions"
		//tags="@newCustomerCreatedMessage"
		//tags="@newCustomerInvalidNoInfo"
		tags="@newCustomers"
		
		)
public class TestRunner {

}
