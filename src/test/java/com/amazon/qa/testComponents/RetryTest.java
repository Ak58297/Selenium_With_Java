package com.amazon.qa.testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	int count=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<=1)
		{
			count++;
			return true;
		}
		return false;
	}

}
