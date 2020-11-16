package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}
	
	// this is the name of product in hierarchy (home/computers/notebooks/Apple MacBook Pro 13-inch)
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailFrienScreenBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement productPrice;
	
	//@FindBy(css = "p.content")
	//public WebElement addingToCartSuccessMessage;
	@FindBy(linkText = "shopping cart")
	WebElement clickToGoToShoppingCart;
	
	@FindBy(linkText = "Add your review")
	WebElement yourReview;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addMacToProductCartBtn;  // in every details page for a product , number in id locator will change
	// for example in asus product will be add-to-cart-button-5 and so on 
	
	// don`t take "valid" word with you in the css value
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy(linkText = "product comparison")
	WebElement productComparisonLink;
	
	public void openEmailFriendScreen()
	{
		clickOnButton(emailFrienScreenBtn);
	}
	
	public void openReviewScreen()
	{
		clickOnButton(yourReview);
	}
	
	public void openWishlistPage()
	{
		clickOnButton(addToWishListBtn);
	}
	
	public void opencompareListPage()
	{
		//waitForElementToBeClickable(addToCompareListBtn);
		clickOnButton(addToCompareListBtn);
		clickOnButton(productComparisonLink);
		
	}
	
	public void addProductToShoppingCart()
	{
		clickOnButton(addMacToProductCartBtn);
		//waitForElementToBeClickable(clickToGoToShoppingCart);
		clickOnButton(clickToGoToShoppingCart);
		
	}

}
