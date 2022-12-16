package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class neoStoxHomepage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logoutButton;
	
	public neoStoxHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		if(okButton.isDisplayed())
		{
			UtilityNew.wait(driver, 2000);
			okButton.click();
			Reporter.log("Handling popup", true);
			Reporter.log("clicking on Ok button of popup", true);
			UtilityNew.wait(driver, 2000);
			closeButton.click();
			Reporter.log("clicking on close button of popup", true);
		}
		else
		{
			Reporter.log("there is no popup", true);
			Thread.sleep(2000);
		}
		
	}
	public String getActualUserName(WebDriver driver)
	{
		UtilityNew.wait(driver, 2000);
		String actualUserName = userName.getText();
		Reporter.log("getting actual user name", true);
//		String realUserName = actualUserName.substring(3);
//		Reporter.log("actual user name is"+realUserName, true);
//		Reporter.log("actual user name is"+actualUserName, true);
		return actualUserName;
	}
	public String getAccBalance(WebDriver driver)
	{
		UtilityNew.wait(driver, 2000);
		String accBalance = acBalance.getText();
		Reporter.log("getting accbalance", true);
		Reporter.log("Account balance is"+accBalance, true);
		return accBalance;
	}
	public void logOut(WebDriver driver)
	{
		UtilityNew.wait(driver, 2000);
		userName.click();
		UtilityNew.wait(driver, 2000);
		logoutButton.click();
		Reporter.log("logging out", true);
	}

	

}
