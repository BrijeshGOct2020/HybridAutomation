package testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.PredefinedActions;

public class TestBase {
	
	@BeforeMethod
	public void setUp() {
		PredefinedActions.start();
	}

	@AfterMethod
	public void tearDown(ITestResult iTestResult) {
		if(iTestResult.getStatus() == ITestResult.FAILURE) {
			PredefinedActions.captureScreenshot(iTestResult.getName());
			System.out.println("Screenshot captured for:"+iTestResult.getName());
		}
		PredefinedActions.quit();
	}
}
