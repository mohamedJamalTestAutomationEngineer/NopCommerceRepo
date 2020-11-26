package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterationPage;

public class TestMyAccount extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	
	String firstName = "111";
	String lastName = "222";
	String email = "he1tya5111a@gmail.com";
	String password = "123456";
	String passwordChanged = "1234567289";
	
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();
				
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void testOpenMyAccount()
	{
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openMyAccount();
	}
	
	@Test(priority = 3)
	public void testChangePassword()
	{
		myAccountObject = new MyAccountPage(driver);
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		myAccountObject.changePassword(password, passwordChanged);
		Assert.assertTrue(myAccountObject.changePasswordSuccessMesg.getText().contains("changed"));
	}
	
	@Test(priority = 4)
	public void testRegisteredUserCanLogOut()
	{
		loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}

	
	@Test(priority = 5)
	public void testUserCanLogin()
	{
		homeObject.openLoginScreen();
		loginObject = new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.userLogin(email, passwordChanged);
		Assert.assertTrue(loginObject.logOutBtn.getText().contains("Log out"));
		
		
		// these steps here to close scenario
		//loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}
	

}
