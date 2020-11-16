package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	// why static , initialize driver before use it best practice
	public static WebDriver driver = null;
	
	public static String downloadPath = System.getProperty("user.dir") + "\\downloads";
	
	public static ChromeOptions chromeOption()
	{
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs" , chromeprefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;
	}
	
	// notice that download with firefox is not working correctly . download pop appear and closed after some seconds and driver
	// doesn`t select download option
	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		
		return option;
	}
	
	@BeforeSuite
	@Parameters("browser") // will get value from testng.xml file  
	// for @Optional("chrome") , enable user to run any test file without backing to testng.xml
	public void startDriver(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(chromeOption());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String fireFoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver(firefoxOption());
		}
		else
		{
			
		}
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	// take screenshot when test case fails and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("failed");
			System.out.println("taking screenshot... ");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	
	@AfterSuite
	public void stopDriver()
	{
	  driver.quit();	
	}
}
