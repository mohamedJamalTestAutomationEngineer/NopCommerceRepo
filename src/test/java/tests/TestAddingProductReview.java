package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.RegisterationPage;
import pages.SearchPage;

public class TestAddingProductReview extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	
	String firstName = "111";
	String lastName = "222";
	String email = "i233k36i@gmail.com";
	String password = "12345678";
	String productName = "mac";
	String reviewTitle = "test review2013";
	String reviewMessageBox = "this is a gooqw1d product q11w2";
	
	
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();		
		registerObject.userRegisteration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void testUserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			// is this line required , we can make assert on webelement which is public without taking an object
			// but you are wrong , you should take an object before using it
			productDetailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggest(productName);
			Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occurred " + e.getMessage());
		}
		
	}
	
	@Test(priority = 3)
	public void testAddReviewForProduct()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		ProductReviewPage reviewPageObject = new ProductReviewPage(driver);
		productDetailsObject.openReviewScreen();
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		reviewPageObject.addProductReview(reviewTitle, reviewMessageBox);
		Assert.assertTrue(reviewPageObject.reviewSuccessMessage.getText().contains("Product review is successfully added"));
	}
	
	@Test(priority = 4 )
	public void userCanLogOut()
	{
		loginObject = new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.registeredUserLogOut();
	}
	
}
