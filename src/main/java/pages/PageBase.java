package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	protected WebDriver driver = null;
	public JavascriptExecutor jse;
	public Select selectOptions;
	public Actions actionBuilder;
	protected WebDriverWait wait;
	
	public PageBase (WebDriver constructorDriver)
	{
		// instead of the more standard Selenium findElement calls in the page object. 
		// This simplifies your page object code because you don't need to define the findElement
		// calls (PageFactory assumes you are running the find by name or ID). 
		//PageFactory.initElements(driver, pageObjectClass) implicitly creates the findElement 
		// calls behind the scene.
		PageFactory.initElements(constructorDriver, this);
		// another description for method work
		// It is used to initialize elements of a Page class without having to use ‘FindElement’
		// or ‘FindElements’ methods. Annotations can be used to supply descriptive names of 
		//target objects to improve code readability.
		
		
		// AjaxElementLocatorFactory is a lazy loading concept of PageFactory in Selenium. It is 
		// used to find the web elements only when the elements are used in any operation.
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(constructorDriver, 200);
		PageFactory.initElements(factory, this);
		// Here, when an operation is performed on an element the wait for its visibility starts
		// from that moment only. If the element is not found in the given time interval
		// for example , you want to click on a button , you find web element before , once you
		// start to click on button , time starts from here
	}

	public static void clickOnButton(WebElement button)
	{
		button.click();
	}
	
	public static void setElementTxtBox(WebElement txtBox , String value)
	{
		txtBox.sendKeys(value);
	}
	
	// could we use static with the function
	public void clearTxtBox(WebElement element)
	{
		element.clear();
	}
	
	// if you make method static , you will not able to use jse and its methods 
	public void scrollTo()
	{
		jse.executeScript("scrollBy(0,4000)");
	}
	
	public void waitForElementToBeClickable(WebElement element)
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public Boolean IsElementVisible(By by)
    {
        try
        {
            return driver.findElement(by).isDisplayed();
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
	
}
