package Lib;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;
import Lib.Util;

public class DataProviderForLogin {

	public static HSSFRow Row;
	public static HSSFCell cell;
	public static String FilePath = "D:\\Project\\Automation\\OrangeHRM\\src\\test\\resources\\TestData.xls";
	public static String SheetName = "Login";
	public static HSSFSheet Sheet;
	ReadExcel ex = new ReadExcel();

	public DataProviderForLogin() {
		
	}
	@DataProvider
	public static Object[][] getLoginData() throws Exception {

		Sheet = ReadExcel.DataSheet(FilePath, SheetName);
		// Get username and passsword from testdata.xls
		String username = Sheet.getRow(2).getCell(0).toString();
		String password = Sheet.getRow(2).getCell(1).toString();
		return new Object[][] { { username, password } };
	}
	
	public String getUsername() {
		System.out.println(FilePath);
		System.out.println(SheetName);
		String username = ReadExcel.getCellData(FilePath, SheetName, 1, 0);
		return username;
	}
	
	public String getPassword() {

		String password = ReadExcel.getCellData(FilePath, SheetName, 1, 1);
		return password ;
	}
	
	public String getInvalidUsername() {
		String username = ReadExcel.getCellData(FilePath, SheetName, 2, 0);
		return username;
	}
	
	public String getInvalidPassword() {

		String password = ReadExcel.getCellData(FilePath, SheetName, 2, 1);
		return password ;
	}

	
	
}
