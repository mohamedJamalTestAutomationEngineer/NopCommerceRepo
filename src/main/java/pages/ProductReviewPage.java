package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_3")
	WebElement productRate3;
	
	@FindBy(name = "add-review")
	WebElement reviewSub;
	
	@FindBy(css = "div.result")
	public WebElement reviewSuccessMessage;
	
	public void addProductReview(String reviewHeader , String reviewMessage)
	{
		setElementTxtBox(reviewTitle, reviewHeader);
		setElementTxtBox(reviewTxt, reviewMessage);
		clickOnButton(productRate3);
		clickOnButton(reviewSub);
	}
}
