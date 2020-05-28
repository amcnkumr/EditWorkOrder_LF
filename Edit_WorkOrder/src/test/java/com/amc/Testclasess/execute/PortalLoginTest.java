package com.amc.Testclasess.execute;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txbase.WOPprogrameUtils;
import com.amc.txrepo.PortalLoginObjects;


import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class PortalLoginTest extends TxBase {
	
	PortalLoginObjects portalLogin;
	
	
	WOPprogrameUtils WopUtils = new WOPprogrameUtils();
		
	
	@Features("Edit Work Order")
	@Stories("Portal")	
	@Title("Portal Login And Launch ")
	@Test
	public void PortalLogin() throws Exception {
			
		/*if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}else {*/
		
		
		//Thread.sleep(20000);
		
		WopUtils.launchProgram("Portal","Test");
		
		portalLogin= PageFactory.initElements(driverWOP, PortalLoginObjects.class);
		
		System.out.println("Test================");
		
		portalLogin.loginPortal("Portal");
		
	//}
	
	}
	
}
