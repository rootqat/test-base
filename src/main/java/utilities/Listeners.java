package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basePackage.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
    
	ExtentReports extent = ExtentReportNG.ExtentReportGenerator();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
	 test= extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//WebDriver driver;
		test.fail(result.getThrowable());
		Object testObject= result.getInstance();
		Class clazz = result.getTestClass().getRealClass();
		try {
			driver=(WebDriver)clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		
		}
		try {
			test.addScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName(),BaseClass.driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "This test is skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
