package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterationPage;

public class TestMyAccountUsingDDTandExcelFile extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
    MyAccountPage myAccountObject;

	
	@DataProvider(name = "readFromExcel")
	public Object[][] userMyAccountData() throws IOException
	{
		ExcelReader ex = new ExcelReader();
		return ex.getDataFromExcelSheetAfterStreaming();
	}
	
	// 
	@Test(priority = 1   , dataProvider = "readFromExcel")
	public void testUserCanRegisterSuccessfully(String firstName , String lastName , String email ,String password 
			, String passwordChanged)
	{
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationScreen();
		
		registerObject = new RegisterationPage(driver);		
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));		
		
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openMyAccount();
		myAccountObject.changePassword(password, passwordChanged);
		Assert.assertTrue(myAccountObject.changePasswordSuccessMesg.getText().contains("changed"));
		
		//homeObject.openLoginScreen();
     	loginObject = new LoginPage(driver);
      	loginObject.registeredUserLogOut();
      	
      	homeObject.openLoginScreen();
		loginObject.userLogin(email, passwordChanged);
		Assert.assertTrue(loginObject.logOutBtn.getText().contains("Log out"));
		loginObject.registeredUserLogOut();
	}	
	
}
