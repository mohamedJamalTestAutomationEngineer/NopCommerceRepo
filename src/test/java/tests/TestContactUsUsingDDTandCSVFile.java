package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.ContactUsPage;
import pages.HomePage;

public class TestContactUsUsingDDTandCSVFile extends TestBase{
	
	HomePage homeObject;
	ContactUsPage contactObject;	
	CSVReader reader;
	
	String name;
	String email;
	String enquiry;
	
	@Test(priority = 1)
	public void testUserCanContactUs() throws CsvValidationException, IOException
	{
		String csvFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\ContactUsData.csv";
		// read csv file
	    reader = new CSVReader(new FileReader(csvFilePath));
	    // this is array will contain data fetched from csv file 
	    String[]  cellData;
	    while((cellData = reader.readNext()) != null)
	    {
	    	name = cellData[0];
	    	email = cellData[1];
	    	enquiry = cellData[2];
	    	// if you put these lines belwo outside loop , you will get out from loop with last value which will be used once
	    	// for execution regardless the number of rows in data file 
	    	homeObject = new HomePage(driver);
			contactObject = new ContactUsPage(driver);
			homeObject.openContactUsPage();
			contactObject.ContactUs(name, email, enquiry);
			Assert.assertTrue(contactObject.successMessg.getText().contains("has been successfully sent"));
	    }
		
		
	}

}
