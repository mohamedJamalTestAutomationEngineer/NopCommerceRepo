package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class TestContactUs extends TestBase{
	
	HomePage homeObject;
	ContactUsPage contactObject;
	
	String name = "test nenamqe2!";
	String email = "t1aaa8n1p@teqst.com";
	String enquiry = "again , this asass for est fg!";
	
	@Test
	public void testUserCanContactUs()
	{
		homeObject = new HomePage(driver);
		contactObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactObject.ContactUs(name, email, enquiry);
		Assert.assertTrue(contactObject.successMessg.getText().contains("has been successfully sent"));
	}

}
