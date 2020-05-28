package com.amc.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;
import com.amc.txbase.WOPprogrameUtils;
import com.amc.txrepo.WOPObjets;

public class WopIntegration extends TxBase{
	private List<String> methodsToRun = new ArrayList<>();
	WOPprogrameUtils WopUtils = new WOPprogrameUtils();
	WOPObjets WopObj ;
	ExcelUtils excelUtils = new ExcelUtils();

	@Factory(dataProvider = "dp")
	public WopIntegration(List<String> methodsToRun) {
		this.methodsToRun = methodsToRun;
	}
	
	
	public void run(IHookCallBack callBack, ITestResult testResult) {
        String testMethodName = testResult.getMethod().getMethodName();
        if (methodsToRun.contains(testMethodName)) {
            System.err.println("About to run " + testResult.getMethod().getMethodName());
            callBack.runTestMethod(testResult);
        } else {
            testResult.setStatus(ITestResult.SKIP);
        }
    }
	
	
	@Test
	public void scheduleThroughPrellminaryGenaricPrograme() throws Exception {

		//	  WopObj.Login("NareshKumar");
		//	  WopObj.selectProgrameType();
		WopObj.scheduleThroughPrellminaryGenaricPrograme();
		// WopObj.scheduleThroughExploitationWindowBrowser();
	}

	@Test
	public void scheduleThroughExploitationWindowBrowser() throws Exception {
		WopObj.scheduleThroughExploitationWindowBrowser();
	}
	
	@Test
	public void Testdp() throws Exception {
		System.out.println("Test Started ");
	}

	@BeforeTest
	public void LaunchWOP() throws Exception {
		//Launch the browser and WOP Program
		//WopUtils.launchProgram("WOP","Test");
		Thread.sleep(4000);
		WopObj = PageFactory.initElements(driverWOP, WOPObjets.class);
	}

	@DataProvider(name = "dp")
	public static Object[][] getData() {
		return new Object[][]{

			{Arrays.asList("Testdp","scheduleThroughExploitationWindowBrowser")}
		};
	}
}
