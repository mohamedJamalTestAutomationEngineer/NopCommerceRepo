package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONreader;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.RegisterationPage;
import pages.SearchPage;

public class TestAddingProductReviewUsingDDTandJSONFile extends TestBase{

	JSONreader dataReader;
	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;	
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		dataReader = new JSONreader();
		dataReader.JsonReader();
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();		
		registerObject.userRegisteration(dataReader.firstName, dataReader.lastName, dataReader.email, dataReader.password);
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
	}
	
	@Test(priority = 2 , enabled = true)
	public void testUserCanSearchWithAutoSuggest() throws FileNotFoundException, IOException, ParseException
	{
		dataReader = new JSONreader();
		dataReader.JsonReader();
		try {
			searchObject = new SearchPage(driver);
			// is this line required , we can make assert on webelement which is public without taking an object
			// but you are wrong , you should take an object before using it
			productDetailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggest(dataReader.productName);
			Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occurred " + e.getMessage());
		}
		
	}
	
	@Test(priority = 3 , enabled = true)
	public void testAddReviewForProduct() throws FileNotFoundException, IOException, ParseException
	{
		dataReader = new JSONreader();
		dataReader.JsonReader();
		productDetailsObject = new ProductDetailsPage(driver);
		ProductReviewPage reviewPageObject = new ProductReviewPage(driver);
		productDetailsObject.openReviewScreen();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		reviewPageObject.addProductReview(dataReader.reviewTitle, dataReader.reviewMessageBox);
		Assert.assertTrue(reviewPageObject.reviewSuccessMessage.getText().contains("Product review is successfully added"));
	}
	
	@Test(priority = 4 , enabled = true)
	public void userCanLogOut()
	{
		loginObject = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.registeredUserLogOut();
	}
	
}
