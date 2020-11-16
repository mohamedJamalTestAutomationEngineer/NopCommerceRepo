package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONreader {

	public String firstName, lastName, email, password, productName, reviewTitle, reviewMessageBox;

	public void JsonReader() throws FileNotFoundException, IOException, ParseException {
		String JSONFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\productReviewData.json";
		// generate file for the jsonData
		File srcFile = new File(JSONFilePath);
		// parse json file like stream file in case excel files or CSVs
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader(srcFile));

		for (Object jsonObj : array) {
			JSONObject person = (JSONObject) jsonObj;
			
			firstName = (String) person.get("firstName");

			lastName = (String) person.get("lastName");

			email = (String) person.get("email");

			password = (String) person.get("password");

			productName = (String) person.get("productName");

			reviewTitle = (String) person.get("reviewTitle");

			reviewMessageBox = (String) person.get("reviewMessageBox");
		}
	}

}
