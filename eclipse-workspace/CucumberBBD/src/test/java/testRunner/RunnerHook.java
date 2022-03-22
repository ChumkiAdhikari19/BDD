package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/AddTobasket.feature"},

		glue= {"stepDefinations"
				,"hook"
				},
	dryRun =false,
	monochrome = true,
	//tags="@Functional" ,      ////"not @reg"-->exclude, and -->both tag should be there in scenario,or-->it will execute the scenario which is having any of tag
	plugin = {"pretty","html:target/reg.html",
			"json:target/smoke.json",
			//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			
			})
	  

public class RunnerHook extends AbstractTestNGCucumberTests {

	

}


