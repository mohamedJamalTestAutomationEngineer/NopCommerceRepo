package bDDRunner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src\\test\\java\\businessFeatures"
,glue = "stepDefinitions"
,plugin = {"pretty" , "html:target/cucumber-html-report"})
public class GenericTestRunnerForAllFeatures extends TestBase{

}
