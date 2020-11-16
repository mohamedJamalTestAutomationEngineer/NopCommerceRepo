package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "a.button-2.print-order-button")
	WebElement printOrderBtn;
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement printPDFBtn;
	
	public void printOrder()
	{
		clickOnButton(printOrderBtn);
	}
	
	public void downloadPDFInvoice() throws InterruptedException
	{
	  clickOnButton(printPDFBtn);
	  Thread.sleep(1000);
	}

}
