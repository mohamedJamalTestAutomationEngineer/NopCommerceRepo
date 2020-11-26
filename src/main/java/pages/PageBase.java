package pages;

import java.sql.Time;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class PageBase {

	protected WebDriver driver = null;
	public JavascriptExecutor jse;
	public Select selectOptions;
	public Actions actionBuilder;
	//public WebDriverWait wait;

	public PageBase(WebDriver constructorDriver) {
		// instead of the more standard Selenium findElement calls in the page object.
		// This simplifies your page object code because you don't need to define the
		// findElement
		// calls (PageFactory assumes you are running the find by name or ID).
		// PageFactory.initElements(driver, pageObjectClass) implicitly creates the
		// findElement
		// calls behind the scene.
		//*******************************   PageFactory.initElements(constructorDriver, this); **************
		// another description for method work
		// It is used to initialize elements of a Page class without having to use
		// ‘FindElement’
		// or ‘FindElements’ methods. Annotations can be used to supply descriptive
		// names of
		// target objects to improve code readability.

		// AjaxElementLocatorFactory is a lazy loading concept of PageFactory in
		// Selenium. It is
		// used to find the web elements only when the elements are used in any
		// operation.
		this.driver = constructorDriver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(constructorDriver, 400);
		PageFactory.initElements(factory, this);
		// Here, when an operation is performed on an element the wait for its
		// visibility starts
		// from that moment only. If the element is not found in the given time interval
		// for example , you want to click on a button , you find web element before ,
		// once you
		// start to click on button , time starts from here
	}


	
	public static void setElementTxtBox(WebElement txtBox, String value) {
		txtBox.sendKeys(value);
	}

	// could we use static with the function
	public void clearTxtBox(WebElement element) {
		element.clear();
	}

	// if you make method static , you will not able to use jse and its methods
	public void scrollTo() {
		jse.executeScript("scrollBy(0,4000)");
	}
	
	
	 
//	public void waitForElementToBevisibile(By element) {
//		wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//	}

	// will be postponed due to some issues in execution
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//	public void waitForElementToBeClickable2(WebDriver driver, WebElement element) {
//		wait = new WebDriverWait(driver, 60);
//
//		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//	}

//	public static void waitForPageLoad(WebDriver wdriver) {
//	    WebDriverWait wait = new WebDriverWait(wdriver, 60);
//
//	    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {
//
//	        @Override
//	        public boolean apply(WebDriver input) {
//	            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
//	        }
//
//	    };
//	    wait.until(pageLoaded);
//	}

	public static void clickOnButton(WebElement button) {
		button.click();
	}

}
