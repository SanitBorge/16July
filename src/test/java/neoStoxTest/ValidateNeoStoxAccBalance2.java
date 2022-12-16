package neoStoxTest;



import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxPasswordpage;
import neoStoxPOM.NeoStoxloginpage;
import neoStoxPOM.NeostoxSignINpage;
import neoStoxPOM.neoStoxHomepage;
import neoStoxUtility.UtilityNew;

@Listeners(neoStoxBase.Listener.class)
public class ValidateNeoStoxAccBalance2 extends BaseNew {
	NeoStoxloginpage login;
	NeoStoxPasswordpage password;
	neoStoxHomepage home;
	NeostoxSignINpage signin;
  @BeforeClass
  public void launchNeoStox() throws InterruptedException, IOException
  {
	  launchBrowser();//from base class
	  login = new NeoStoxloginpage(driver);
	  password = new NeoStoxPasswordpage(driver);
	  home = new neoStoxHomepage(driver);
	  signin=new NeostoxSignINpage(driver);
  }
  @BeforeMethod
  public void loginNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  signin.clickonSignInButton(driver);
	  Thread.sleep(2000);
	  login.sendMobileNum(driver, UtilityNew.readDataFromPropertyFile("mobileNum"));
	  login.clickSigninButton(driver);
	  UtilityNew.wait(driver, 3000);
	  password.enterpassword(driver, UtilityNew.readDataFromPropertyFile("password"));
	  Thread.sleep(3000);
	  password.clickOnsubmitButton(driver);
	  Thread.sleep(3000);
	  home.handlePopUp(driver);
	  
  }
  @Test(priority=-1)
  public void validateAccBalance() throws IOException
  {
	  Assert.assertNotNull(home.getAccBalance(driver));
	  Reporter.log("Ac balance is"+home.getAccBalance(driver), true);
	  
  }
  @Test
  public void validateUserID() throws EncryptedDocumentException, IOException
  {
	  Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("userName"),"Tc is failed actual and expected user name are not matching");
      
  }
  @AfterMethod
  public void logoutfromneoStox()
  {
	  home.logOut(driver);
	  UtilityNew.wait(driver, 2000);
  }
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	  
	closingBrowser(driver);  

  }
}
