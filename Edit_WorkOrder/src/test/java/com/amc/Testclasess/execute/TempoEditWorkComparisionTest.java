package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txrepo.WOPEpisodeVersion;

import com.amc.txrepo.WOPToMPTempoEditWorkOrderComparison;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class TempoEditWorkComparisionTest extends TxBase{
	
	WOPToMPTempoEditWorkOrderComparison tempoEdit = new WOPToMPTempoEditWorkOrderComparison();
	
	
	@Features("Edit Work Order")

	@Stories("MP")

	@Title("WOP to MP Tempo Edit WorkOrder Validations")
	@Test	
	public void WOPtoMPTempoEditWorkOrderTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}else {
			
			tempoEdit = PageFactory.initElements(driverWOP, WOPToMPTempoEditWorkOrderComparison.class);
			
			tempoEdit.WOPtoMPTempoEditWorkOrderComparisions();
			
		}
		
		
	}
	
	
	
	

}
