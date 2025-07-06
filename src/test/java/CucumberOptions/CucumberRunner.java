package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/java/FeatureFiles",       // Path to your .feature files
	    glue = "stepDefinations"  , 
	    monochrome = true,
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "json:target/cucumber.json"
	    },
	    tags="@Mobile"
	   // tags ="@SmokeTest or @tag3"                             // Optional: run scenarios with specific tag
	)
public class CucumberRunner  extends AbstractTestNGCucumberTests{

	
	
}
