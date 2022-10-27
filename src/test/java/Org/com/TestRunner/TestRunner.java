package Org.com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Org\\com\\Features",glue = {"Org.com.Stepdefinitions","Hooks"},
tags = "@tag1 and not @ignore",plugin = {
		   "pretty", "html:target\\Report\\html\\BDD_HtmlReport.html",
		   "json:target\\Report\\json\\Cucumber.json",
		   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
 dryRun = false,monochrome = true,publish = false)

public class TestRunner extends AbstractTestNGCucumberTests{

}
