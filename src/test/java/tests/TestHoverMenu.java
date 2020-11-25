package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestHoverMenu extends TestBase{

	HomePage homeObject;
	
	@Test
	public void testHoverMenu() 
	{
		homeObject = new HomePage(driver);
		homeObject.selectNoteBooksFromMainMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	
}
