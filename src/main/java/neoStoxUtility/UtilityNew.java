package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import org.testng.Reporter;

public class UtilityNew 
{
	//commonly used method
	//wait,screenshot,scrollinto view,excel reading
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//create object of Properties class-->java.util
		Properties prop =new Properties();
		//create object of FileInputStream and pass properties file path as a parameter
		FileInputStream myfile = new FileInputStream("C:\\Users\\Ashok\\eclipse-workspace\\16EvenMaven\\neoStox.properties");
	    prop.load(myfile);
	    String value = prop.getProperty(key);
	    Reporter.log("Reading "+key+"from property file", true);
	    return value;
	    
		
	}
//	public static String readDatafromExcel(Integer row, Integer cell) throws EncryptedDocumentException, IOException
//	{
//		File myfile = new File("D:\\Sanit XL\\Sanitxl1.xlsx");
//		String value = WorkbookFactory.create(myfile).getSheet("Sheet4").getRow(row).getCell(cell).getStringCellValue();
//		Reporter.log("reading value from excel", true);
//		return value;
//	}
	
	public static void screenshot(WebDriver driver, String name) throws IOException
	{
		wait(driver, 2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Sanit XL\\"+name+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot", true);
	}
	
	public static void scrollintoview(WebDriver driver, WebElement element)
	{
		wait(driver, 2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling into view", true);
	}
	
	public static void wait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Waiting for "+time+" ms", true);
	}

}
