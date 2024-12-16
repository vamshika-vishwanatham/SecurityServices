package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ={ "Features/WAF.feature" }, glue = {"stepDefinations"}, monochrome = true,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class WAFTestNGTestRunner extends AbstractTestNGCucumberTests {

}
