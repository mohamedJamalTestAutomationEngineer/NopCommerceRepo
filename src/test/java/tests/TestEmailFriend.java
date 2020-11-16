package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.RegisterationPage;
import pages.SearchPage;

public class TestEmailFriend extends TestBase{
	
	HomePage homeObject;
	RegisterationPage registerObject;
	EmailPage EmailPageOBject;
	LoginPage loginObject;
	
	String productName = "mac";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	
	String firstName = "1111q1yqqu";
	String lastName = "222q11utqq";
	String email = "hi1iuyrui5@gmail.com";
	String password = "12134115678";
	String friendmail = "n21etaqp2@one.com";
	String txtMessage = "check this product qqagain1et";
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();		
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("registration completed"));
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
	public void openEmailFriendScreen()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openEmailFriendScreen();
	}
	
	@Test(priority = 4)
	public void testSendEmailFunction()
	{
		EmailPageOBject = new EmailPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		EmailPageOBject.sendEmailToFriend(friendmail,txtMessage);
		Assert.assertTrue(EmailPageOBject.successOfSendMailMessage.getText().contains("message has been sent"));
	}
	
	@Test(priority = 5)
	public void testRegisteredUserCanLogOut()
	{
		loginObject = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.registeredUserLogOut();
	}
	
}
