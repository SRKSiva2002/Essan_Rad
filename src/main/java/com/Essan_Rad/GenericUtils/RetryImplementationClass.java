package com.Essan_Rad.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer{

	int count=0;
	int upperLimit=3;
	public boolean retry(ITestResult result) {
		while (count<upperLimit) {
			count++;
			return true;
		}
		return false;
	}

}
