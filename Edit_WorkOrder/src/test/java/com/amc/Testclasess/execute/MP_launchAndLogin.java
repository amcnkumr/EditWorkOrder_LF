package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txbase.WOPprogrameUtils;
import com.amc.txrepo.MPObjects;
import com.amc.txrepo.WOPEpisodeVersion;
import com.amc.txrepo.WOPObjets;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class MP_launchAndLogin extends TxBase {
	
	WOPprogrameUtils WopUtils = new WOPprogrameUtils();
	
	WOPObjets WopObj ;
	
	MPObjects MpObj;
	
	
	@Features("Edit Work Order")

	@Stories("MP")

	@Title("MP Login and Launch")
	
	@Test
	public void mpLaunchAndLoginTest() throws Exception {
		
		//Launch the browser and MP Program
			
		if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
				
				logStep("WOP is Not Up and Running");
				
				Assert.fail("WOP is Not Up and Running");
				
			}else {
				
		Thread.sleep(20000);
		
		WopUtils.launchProgram("MP","Test");
		
		MpObj=  PageFactory.initElements(driverWOP, MPObjects.class);
		
		System.out.println("Test================");
		
		MpObj.NonProdLogin("NonProd");
		
		MpObj.selectProgrameType("MediaPulse-TEST");
			}
	}

}
