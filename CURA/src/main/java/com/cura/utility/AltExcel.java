/**
 * 
 */
package com.cura.utility;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author maxxmuthu
 *
 */
public class AltExcel {
	

	public class TestClass {
		
	    @DataProvider(name = "testData")
	    public Object[][] testData(int i, int j) throws IOException {
	    	
			String Location = "./testdata/testsampledata.xlsx";
			
			XSSFWorkbook wbook = null;
			try {
				wbook = new XSSFWorkbook(Location);      //pass the excel file path in string 'location'
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
						
			XSSFSheet sheet = wbook.getSheetAt(0); //this defined which sheet needs to read from excel file
			
			int lastRowNum =  sheet.getLastRowNum();  //getLastRowNum - won't consider header for total count of rows
			int physicalNumberofRows = sheet.getPhysicalNumberOfRows();   //getPhysicalNumberofRows - will consider header also for total count of rows
			
			System.out.println("No.of Rows:" + " " + lastRowNum);
			System.out.println("Inclusive of header:" + " " + physicalNumberofRows);
			
			short lastCellNum =  sheet.getRow(0).getLastCellNum();  // to identify last cell number in the excel. or total no.of.column in excel
			
			System.out.println("No.of.Cells:" + " " + lastCellNum);
			
			Object[][] data = new Object [lastRowNum][lastCellNum]; // Object name is data

			XSSFRow row = sheet.getRow(i); // this line will be starting point of row in excel file from mentioned number. example {1,nn}
			
			XSSFCell cell = row.getCell(j); // this line will be starting point of column with respective to starting row in excel file from mentioned number. example {1,0},{1,1}
			
			DataFormatter dft = new DataFormatter();
			String value = dft.formatCellValue(cell);
			
			data [i][j] = value;
			
	        // Create a two-dimensional array to hold the test data
	       // Object[][] data = new Object[1][1];

	        // Add the value to the array
	       // data[0][0] = value;

	        // Close the workbook
	        wbook.close();

	        // Return the test data array
	        return data;
	    }

	    @Test(dataProvider = "testData")
	    public void testMethod(String value) {
	        // Use the value to test the application
	        // ...
	    }
	}


}
