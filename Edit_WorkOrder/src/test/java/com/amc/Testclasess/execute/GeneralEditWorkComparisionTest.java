package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txrepo.WOPEpisodeVersion;
import com.amc.txrepo.WOPToMPGeneralEditWorkOrderComparison;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;


public class GeneralEditWorkComparisionTest extends TxBase {

	WOPToMPGeneralEditWorkOrderComparison generalEditwork= new WOPToMPGeneralEditWorkOrderComparison();
	
	
	@Features("Edit Work Order")

	@Stories("MP")

	@Title("WOP to MP General Edit WorkOrder Validations")
	@Test	
	public void WOPtoMPGeneralEditWorkOrderTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}else {
			
			generalEditwork = PageFactory.initElements(driverWOP, WOPToMPGeneralEditWorkOrderComparison.class);
			
			generalEditwork.WOPtoMPGeneralEditWorkOrderComparisions();
			
		}
		
		
	}
	
	
	
}
