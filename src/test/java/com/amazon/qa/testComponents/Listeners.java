package com.amazon.qa.testComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazom.qa.utils.Extent_Report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = Extent_Report.getReporter();
	ExtentTest test;
	//ExtentTest is the class in ExtentReports used to log individual test case steps and their outcomes—like pass, fail, skip, or info—into the final HTML report

	ThreadLocal<ExtentTest> threadlocal=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
		threadlocal.set(test); //unique thread id for each test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadlocal.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadlocal.get().log(Status.FAIL, "Test Failed");
		threadlocal.get().fail(result.getThrowable()); //get the unique thread id
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		//Screenshot
		String FilePath=TakesScreenshot(result.getMethod().getMethodName(),driver);
		
		//Attach file path to takescreenshot
		threadlocal.get().addScreenCaptureFromPath(FilePath,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}
	
	@Override
	public void  onFinish(ITestContext context) {    
		extent.flush();
		  }

	@Override
	public void SetUp() {
		// TODO Auto-generated method stub
		
	}

}
