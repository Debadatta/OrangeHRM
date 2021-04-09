package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	WebElement element = null;
	
	public Util() {
		
	}
	
	
	public String dateFormater(String dateFormat, int duration) {
		String strDate = "";
		try {
			Date dt = new Date();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, duration);
			dt = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			strDate= formatter.format(dt);
			System.out.println(strDate);
		
		} catch(Exception E) {
			Log.error("Date not valid.");
		}
		return strDate;
	}
	
	public WebElement waitUntilElementPresent(WebDriver driver, By ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			element = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(ele));
			
		} catch(Exception e) {
				Log.error("Element not found.");
			}
		return element;
	}
	
	public void readExcel(String filePath, String fileName, String sheetName) throws IOException{

	    //Create an object of File class to open xls file
	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook OrangeHRMWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    
	    //Check condition if the file is xls file
	    if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class
	    	OrangeHRMWorkbook = new HSSFWorkbook(inputStream);

	    } else {
	    	Log.error("Please provide a Excel sheet of .xls format.");
	    }

	    //Read sheet inside the workbook by its name
	    Sheet OrangeHRMSheet = OrangeHRMWorkbook.getSheet(sheetName);

	    //Find number of rows in excel file
	    int rowCount = OrangeHRMSheet.getLastRowNum()- OrangeHRMSheet.getFirstRowNum();

	    for(int i=1; i<=OrangeHRMSheet.getLastRowNum(); i++) {
	    	
	         Cell cell = OrangeHRMSheet.getRow(i).getCell(1);
	         cell.getStringCellValue();
	    }  
	   }
//====================================================================
	public static Object[][] LoginData;
	public static Object[][] ShipmentData;
	public static HSSFRow Row;
	public static HSSFCell cell;
	public static HSSFSheet Sheet;
	public static HSSFWorkbook WBook = null;
	public static HSSFSheet WSheet = null;

	public static HSSFSheet DataSheet(String FilePath, String SheetName) {
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			WBook = new HSSFWorkbook(fis);
			WSheet = WBook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WSheet;
	}

	@SuppressWarnings("deprecation")
	public static String getCellData(String Sheet, int row, int col) {

		try {

			int index = WBook.getSheetIndex(Sheet);

			WSheet = WBook.getSheetAt(index);
			Row = WSheet.getRow(row);
			if (Row == null)
				return "";

			cell = Row.getCell(col);
			if (cell == null)
				return "";

			switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();

			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());

			case BLANK:
				return "";

			case ERROR:
				return cell.getStringCellValue();

			case NUMERIC:
				return String.valueOf(cell.getNumericCellValue());

			default:
				return "Cell not found";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + row + " or column " + col + " does not exist in xls";
		}

	}


}

