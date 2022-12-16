package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class NeostoxSignINpage 
{
	@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signInButton;
	
	public NeostoxSignINpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonSignInButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 2000);
		Reporter.log("Clicking on Sign in Button", true);
		signInButton.click();
	}

}
