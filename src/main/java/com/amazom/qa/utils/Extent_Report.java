package com.amazom.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	
	public static ExtentReports getReporter() {

	String path=System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	
	ExtentReports extentReport = new ExtentReports();
	extentReport.attachReporter(reporter);
	extentReport.setSystemInfo("QA", "ABhishek Kumar");
	
	return extentReport;
}
}
