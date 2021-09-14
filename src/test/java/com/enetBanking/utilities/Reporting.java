package com.enetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.enetBanking.testCases.BaseClass;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public WebDriver driver;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		htmlReporter.config().setDocumentTitle("eBanking Automation Test Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Srinivas");

	}

	public void onTestSuccess(ITestResult tr) {
		extentTest = extent.createTest(tr.getName());
		extentTest.pass(MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {

		extentTest = extent.createTest(tr.getName());

		extentTest.fail(MarkupHelper.createLabel(tr.getName() + " Test Case Failed ", ExtentColor.RED));
		extentTest.fail(tr.getThrowable());

		try {

			extentTest.addScreenCaptureFromPath(BaseClass.captureScreen(tr.getName()));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult tr) {
		extentTest = extent.createTest(tr.getName());

		extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots " + tr.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {

			try {

				extentTest.fail("Screenshot is below :" + extentTest.addScreenCaptureFromPath(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
