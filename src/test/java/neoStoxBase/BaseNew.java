package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;



public class BaseNew 
{
	protected static WebDriver driver;
	public void launchBrowser() throws InterruptedException, IOException
	{
        System.setProperty("webdriver.chrome.driver","D:\\Sanit 16 July A Evening\\chromedriver.exe");
		
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(neoStoxUtility.UtilityNew.readDataFromPropertyFile("url"));
		Reporter.log("launching Browser", true);
		Thread.sleep(2000);	
		
	}
	
	public static void closingBrowser(WebDriver driver) throws InterruptedException
	{
		Reporter.log("closing browser", true);
		Thread.sleep(2000);
		driver.close();
	}

}
