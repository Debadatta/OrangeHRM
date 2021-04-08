package Lib;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
