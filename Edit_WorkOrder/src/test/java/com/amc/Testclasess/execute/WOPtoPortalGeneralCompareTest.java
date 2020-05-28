package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;

import com.amc.txrepo.WOPtoPortalGeneralEditComparision;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class WOPtoPortalGeneralCompareTest extends TxBase {

	
	WOPtoPortalGeneralEditComparision gec = new WOPtoPortalGeneralEditComparision();
	
	
	@Features("Edit Work Order")

	@Stories("Portal")

	@Title("WOP to Portal General Edit WorkOrder Validations")
	
	@Test
	public void WOPtoPortalGeneralEditWorkOrderTest() {
		
		
		gec = PageFactory.initElements(driverWOP, WOPtoPortalGeneralEditComparision.class);
		
		gec.WOPtoMPPortalGeneralEditWorkOrderComparisions();
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
