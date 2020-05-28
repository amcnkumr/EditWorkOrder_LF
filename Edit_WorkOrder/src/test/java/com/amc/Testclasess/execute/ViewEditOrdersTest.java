package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;

import com.amc.txrepo.ViewEditOrdersObjects;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class ViewEditOrdersTest extends TxBase {
	
	ViewEditOrdersObjects viewEdit = new ViewEditOrdersObjects();
	
	
	
	
	@Features("Edit Work Order")
	@Stories("Portal")	
	@Title("WOP to Portal Edit Work Order Integration")	
	@Test
	public void EditWorkOrderTest() throws InterruptedException, FindFailed {
		
		viewEdit = PageFactory.initElements(driverWOP, ViewEditOrdersObjects.class);
		
		viewEdit.ViewEditOrdersSelection();
		
	}

}
