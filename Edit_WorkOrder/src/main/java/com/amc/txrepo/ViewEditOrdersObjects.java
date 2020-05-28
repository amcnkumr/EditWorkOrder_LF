package com.amc.txrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

public class ViewEditOrdersObjects extends TxBase {
	
	ExcelUtils excelUtils = new ExcelUtils();
	
	@FindBy(xpath = "//div[contains(text(), 'View Edit Orders')]")
	WebElement viewEditOrders;
	
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement ViewrecordSearchField;
	
	
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[5]")
	WebElement ViewEditMatID;
	
	
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[7]")
	WebElement ViewEditTitle;
	
	//*[@id="tab-close"]/i
	
	@FindBy(xpath = "//div[@id='tab-close']/i")
	WebElement ViewEditScreenClose;
	
	
	public void ViewEditOrdersSelection() throws InterruptedException, FindFailed {
		
		switchToFirstFrame();
		
		
		ExplicitWait(viewEditOrders);

		viewEditOrders.click();
		
		switchBackFromFrame();
		
		switchToSecondFrameViewEdit();
		
	    Thread.sleep(20000);
		
		ExplicitWait(ViewrecordSearchField);
		
		try {
			
			ViewrecordSearchField.sendKeys(TxBase.GeneralMattextvalue);
			
			//ViewrecordSearchField.sendKeys("LSIT01021936");
			
			Thread.sleep(4000);
			
			ExplicitWait(ViewEditMatID);
			
			String GeneralId= ViewEditMatID.getText();
			
			portalGeneralEditWorkOrderData("GeneralEditMatID:"+GeneralId);
			

			ExplicitWait(ViewEditTitle);
			
			String GeneralTitle= ViewEditTitle.getText();
			
			portalGeneralEditWorkOrderData("GeneralEditWorkOrderTitle:"+GeneralTitle);
			
			logStep("General Edit Work Order Record Integration is success");
			
			

		}	catch(Exception e) {
			
			System.out.println("General Edit Work order record Not Found");
			
		}
		
		
		Thread.sleep(7000);
		
		ViewrecordSearchField.clear();
		
		try {
			
			ViewrecordSearchField.sendKeys(TxBase.TempoMattextvalue);
			
			//ViewrecordSearchField.sendKeys("LSIT01021937");
			
			Thread.sleep(4000);
			
			ExplicitWait(ViewEditMatID);
			
			String TempoID= ViewEditMatID.getText();
			
			portalTempoEditWorkOrderData("TempoEditMatID:"+TempoID);
			
			
			ExplicitWait(ViewEditTitle);
			
			String TempoTitle= ViewEditTitle.getText();
			
			portalTempoEditWorkOrderData("TempoEditWorkOrderTitle:"+TempoTitle);
					
			logStep("Tempo Edit Work Order Record Integration is success");
		
		}catch(Exception e) {
			
			System.out.println("Tempo Edit Work order record Not Found");
		}
		
		
		
		
		String ViewEditClose = "Pictures\\WopImages\\ViewEditClose.PNG";
		
		imageFindClick(ViewEditClose,10);
		
		switchBackFromFrame();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
