package com.Essan_Rad.GenericUtils;

import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationImpClass implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation,  Method testMethod) {
		annotation.setRetryAnalyzer(com.Essan_Rad.GenericUtils.RetryImplementationClass.class);
	}

	
}
