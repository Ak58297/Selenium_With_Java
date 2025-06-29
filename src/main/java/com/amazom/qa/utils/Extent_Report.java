package com.amazom.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	
	public static ExtentReports getReporter() {

	String path=System.getProperty("user.dir")+"\\Reports\\index.html";
	//ExtentSparkReporter is used to generate visually rich HTML reports for your Selenium test executions. 
	//It’s part of the ExtentReports library (version 5 and above) and is the modern replacement for the older ExtentHtmlReporter.

	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	//to create detailed, interactive HTML reports. 
//	- Track Test Status: Log each test step as pass, fail, skip, or info.
//	- Attach Screenshots: Especially useful for failed steps to aid debugging.
//	- Customize Reports: Set themes, titles, timestamps, and even branding.

	ExtentReports extentReport = new ExtentReports();
	extentReport.attachReporter(reporter);
	extentReport.setSystemInfo("QA", "ABhishek Kumar");
	
	return extentReport;
}
}
