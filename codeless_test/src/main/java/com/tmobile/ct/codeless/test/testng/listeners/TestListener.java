package com.tmobile.ct.codeless.test.testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.tmobile.ct.codeless.core.Test;
import com.tmobile.ct.codeless.test.extentreport.ExtentTestManager;

/**
 * The listener interface for receiving test events.
 * The class that is interested in processing a test
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addTestListener<code> method. When
 * the test event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Rob Graff
 * @author Sai Chandra Korpu
 * @see TestEvent
 */
public class TestListener implements ITestListener {

	/**
	 * Gets the test method name.
	 *
	 * @param iTestResult the i test result
	 * @return the test method name
	 */
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");
		Test test = (Test) result.getParameters()[0];
		ExtentTestManager.startTest(test.getName(), "Test Start");

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
		// Extentreports log operation for passed tests.
		// ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult iTestResult) {

		// To add it in the extent report
		// logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

		/*
		 * System.out.println("I am in onTestFailure method " +
		 * getTestMethodName(iTestResult) + " failed");
		 * 
		 * // Get driver from BaseTest and assign to local webdriver variable. Object
		 * testClass = iTestResult.getInstance(); WebDriver webDriver = ((WebTest)
		 * testClass).getDriver();
		 * 
		 * // Take base64Screenshot screenshot. String base64Screenshot =
		 * "data:image/png;base64," + ((TakesScreenshot)
		 * webDriver).getScreenshotAs(OutputType.BASE64);
		 * 
		 * // Extentreports log and screenshot operations for failed tests.
		 * ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
		 * ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		 */

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped!");
		// Extentreports log operation for skipped tests.
//		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		System.out.println("===============TESTINGGGGGGG");
		System.err.println("skip exception:: "+iTestResult.getThrowable());
		iTestResult.getThrowable().printStackTrace();
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("I am in onStart method " + context.getName());
//		context.setAttribute("WebDriver", this.getDriver());
		
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("I am in onFinish method " + context.getName());
		ExtentTestManager.endTest();
		ExtentTestManager.getReporter().flush();

	}

}