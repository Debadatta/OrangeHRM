package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


public class ReadExcel {
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
	public static String getCellData(String FilePath, String Sheetname, int row, int col) {

		try {
			File file = new File(FilePath);
			Log.info(file + "DataSheet opened.");
			FileInputStream fis = new FileInputStream(file);
			WBook = new HSSFWorkbook(fis);
			WSheet = WBook.getSheet(Sheetname);			
			
			Log.info(Sheetname + "Sheet opened.");
			//WSheet = WBook.getSheetAt(index);
			Row = WSheet.getRow(row);
			System.out.println(Row);
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