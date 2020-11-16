package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getInputFileAsAstream() {
		// get file : data xls path , correct line with correctPath . problem is not
		// here
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\datatestMyAccount.xlsx";
		// convert this file to file we can deal with it via File Library
		File srcFile = new File(filePath);

		try {
			// convert this file to stream so that you can read it
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("test data file is not found : " + e.getMessage());
			System.exit(0);
		}

		return fis;
	}

	public Object[][] getDataFromExcelSheetAfterStreaming() throws IOException {
		// read file from function getInputFileStream() and put result in fis variable
		fis = getInputFileAsAstream();
		// workbook is the entire file , we called it workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// tabs in the file or workbook are called sheets and we need to get the first
		// tab which contains data
		XSSFSheet sheet = wb.getSheetAt(0);
		// count num of rows
		int totalNumbersOfRows = (sheet.getLastRowNum() + 1);
		// count num of cols , check if they are 4 or 5
		int totalNumbersOfCols = 5;

		// create array of two dimensions to use it so that we can deal with data in the
		// file
		String[][] arrayExcelData = new String[totalNumbersOfRows][totalNumbersOfCols];

		for (int i = 0; i < totalNumbersOfRows; i++) {
			for (int j = 0; j < totalNumbersOfCols; j++) {
				// in first iteration we work on row 0 and in second iteration work on row 1 and
				// so on
				XSSFRow row = sheet.getRow(i);
				// we here have row and can get cell of the row if we reached to the
				// intersection cell where
				// i and j be together
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}

		// wb reads from stream file and we need to close it
		wb.close();
		// after we have read from the whole data from file , we can close wb as in the
		// above line and return
		// the readed data as a object to used later
		return arrayExcelData;
	}
}
