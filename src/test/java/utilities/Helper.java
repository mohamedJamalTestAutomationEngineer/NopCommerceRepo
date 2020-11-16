package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	// used for taking screenshots on failure
	public static void captureScreenshot(WebDriver driver , String screenshotName)
	{
		// dest will the path of screenshot , varaiable screenshotName will be replaced by test method while calling
		Path dest = Paths.get("./screenshots", screenshotName + ".png");
		
		try {
			// I don`t know the reason of this line
			Files.createDirectories(dest.getParent());
			// save the taken image in the output file "out"
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while taking screenshoot : " + e.getMessage());
		}
	}

}
