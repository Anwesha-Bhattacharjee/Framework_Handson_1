package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	/*
	int CREATED = -1;
  	int SUCCESS = 1;
  	int FAILURE = 2;
  	int SKIP = 3;
  	int SUCCESS_PERCENTAGE_FAILURE = 4;
  	int STARTED = 16;
	 */

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		System.out.println(result.getMethod().getMethodName() + " " + result.getStatus());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		System.out.println(result.getMethod().getMethodName() + " " + result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		System.out.println(result.getMethod().getMethodName() + " " + result.getStatus());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		System.out.println(result.getMethod().getMethodName() + " " + result.getStatus());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		System.out.println("onstartcontext" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("onfinishcontext" + context.getName());
	}

}
