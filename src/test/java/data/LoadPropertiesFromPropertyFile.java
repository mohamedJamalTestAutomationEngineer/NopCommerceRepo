package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFromPropertyFile {

	private static Properties userEmailData(String path)
	{
		Properties pro = new Properties();
		
		try {
			// 1- first we need to create stream for the given path 
			FileInputStream stream = new FileInputStream(path);
			// 2- second , we will load this stream and start reading from it 
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occurred : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error occurred : " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("error occurred : " + e.getMessage());
		}
		
		return pro;
	}
	
	public static Properties readFromPropertiesFunction =
			userEmailData(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\emailFriendData.properties");
}
