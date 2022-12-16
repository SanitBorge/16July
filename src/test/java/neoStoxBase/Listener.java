package neoStoxBase;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class Listener extends BaseNew implements ITestListener
{
	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
		String methodName = result.getName();
		Reporter.log("Tc "+methodName+"failed please try again", true );
		try {
			WebDriver driver = null;
			UtilityNew.screenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC "+result.getName()+" success", true);
	}
	public void onTestSkipped(ITestResult result) {

		Reporter.log("Tc "+result.getName()+" is skipped please check", true);

	}

}
