package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}

	@FindBy(css = "h1")
	WebElement wishlistHeader;
	
	@FindBy(name = "removefromcart")
	WebElement removeProductfromWishlistCart;
	
	@FindBy(css = "td.product")
	WebElement prodcutCell;
	
	@FindBy(name = "updatecart")
	WebElement updateWishList;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyWishlistMessg;
	
	public void removeProductFromWishlist()
	{
		clickOnButton(removeProductfromWishlistCart);
		clickOnButton(updateWishList);
	}
	
}
