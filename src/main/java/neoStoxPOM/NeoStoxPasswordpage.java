package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class NeoStoxPasswordpage 
{

	@FindBy(name = "ctl00$MainContent$_wp_enteraccesspin$txt_accesspin")private WebElement passwordfield;
	@FindBy(id = "lnk_submitaccesspin")private WebElement submitButton;
	
	public NeoStoxPasswordpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterpassword(WebDriver driver, String pass)
	{
		UtilityNew.wait(driver, 4000);
		passwordfield.sendKeys(pass);
		Reporter.log("Entering password", true);
		
	}
	
	public void clickOnsubmitButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 5000);
		submitButton.click();
		Reporter.log("Clicking on submit Button", true);
	}
}
