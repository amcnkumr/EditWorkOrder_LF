package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txrepo.WOPEpisodeVersion;
import com.amc.txrepo.WOP_Portal_Comparision;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class WOP_PortalComparisionTest extends TxBase {
	
	WOP_Portal_Comparision comparison = new WOP_Portal_Comparision();
	
	
	@Features("Edit Work Order")

	@Stories("Portal")

	@Title("WOP to Portal Episode Data Validations")
	
	@Test	
	public void WOPtoPortalEpisodeDataTest() throws java.lang.Exception {
				
		Thread.sleep(2000);
		
		if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}
		else {
			
			comparison = PageFactory.initElements(driverWOP, WOP_Portal_Comparision.class);
		
			comparison.WOPtoPortalDataComparisions();
		
	}
	
	
	}

	
	
	

}
