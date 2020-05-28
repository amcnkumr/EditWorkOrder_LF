package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;


import com.amc.txrepo.WOPtoPortalTempoEditComparision;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class WOPtoPortalTempoCompareTest extends TxBase {

	
	WOPtoPortalTempoEditComparision gep = new WOPtoPortalTempoEditComparision();
	
	
	@Features("Edit Work Order")

	@Stories("Portal")

	@Title("WOP to Portal Tempo Edit WorkOrder Validations")
	
	@Test
	public void WOPtoPortalTempoEditWorkOrderTest() {
		
		
		gep = PageFactory.initElements(driverWOP, WOPtoPortalTempoEditComparision.class);
		
		gep.WOPtoMPPortalTempoEditWorkOrderComparisions();
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
