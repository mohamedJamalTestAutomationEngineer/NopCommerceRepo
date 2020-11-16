package bDDRunner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

// in moataz nabil video , features , glue just take the name of features and steps file . here  I make it specific
// on some steps , features but it should be general if you want to make this class generic to run
// all features from it . there is another approach ,use absoulte paths like in below and create runner for every feature
@CucumberOptions(features = "src\\test\\java\\businessFeatures"
,glue = "stepDefinitions"
,plugin = {"pretty" , "html:target/cucumber-html-report"})
public class TestRunnerChangeCurrencyBDD extends TestBase {

}
