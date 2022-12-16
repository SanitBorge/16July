package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class NeoStoxloginpage 
{
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber")private WebElement mobilenumfield;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signInButton;
	
	public NeoStoxloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNum(WebDriver driver, String mobNum)
	{
		UtilityNew.wait(driver, 2000);
		mobilenumfield.sendKeys(mobNum);
		Reporter.log("Entering mobileNumber", true);
		
	}
	
	public void clickSigninButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 3000);
		signInButton.click();
		Reporter.log("Clicking on SignIN Button", true);
	}

}
