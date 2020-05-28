package com.amc.txrepo;

import org.sikuli.hotkey.Keys;

import org.sikuli.script.Screen;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;



public class GeneralEditWorkOrder extends TxBase {

	ExcelUtils ProductBrowserData = new ExcelUtils();
	
	ExcelUtils GEWO = new ExcelUtils();
	
	Screen productscreen = new Screen();
	
	public void GeneralEditWorkOrderCreation() throws java.lang.Exception {
		
		
		ProductBrowserData.readingexcelFiles("ProductBrowserData");
		
		GEWO.readingexcelFiles("GeneralEditWorkOrder");
		
	
		// General Edit Work Order 
		
		String AssetMenu = "Pictures\\WopImages\\AssetMenu.PNG";
		
     	imageFindClick(AssetMenu, 10);
	
	 

     	String CreateEdit = "Pictures\\WopImages\\CreateEdit.PNG";
		
     	imageFindClick(CreateEdit, 10);
     
     
     	String CreateEditOk = "Pictures\\WopImages\\CreateEditOk.PNG";
		
     	imageFindClick(CreateEditOk, 10);
     
     
     	String VideoComponent = "Pictures\\WopImages\\VideoComponent.PNG";
		
	   imageFindClick(VideoComponent,10);
	   
	   productscreen.wait((double) 3.0);
	   			   
	   String ExpectedScanType = "Pictures\\WopImages\\ExpectedScanType.PNG";
	   
	   EnterTextandTabVersion(ExpectedScanType,ProductBrowserData.excelData[1][3],10);
	   
	   productscreen.wait((double) 3.0);
	   
	   String FormatAssignMent = "Pictures\\WopImages\\FormatAssignMent.PNG";
	   
	   imageFindClick(FormatAssignMent,10);
	   
	   productscreen.wait((double) 3.0);
	   
	   String ExpectedSegments = "Pictures\\WopImages\\EpectedSegments.PNG";
	   
	   imageFindClick(ExpectedSegments,10);
	   
	   ClickandUpArrow();
	    
	   
	   for(int tab=0; tab<=2; tab++) {
		   
		   productscreen.type(Keys.TAB);
	   }
	   
	   productscreen.wait((double) 3.0);
	   
	   String EstimatedTRTVersion = "Pictures\\WopImages\\ExpectedTRTVersion.PNG";
	   
	   imageEnterText(EstimatedTRTVersion,ProductBrowserData.excelData[1][10],10);
     
	   productscreen.wait((double) 2.0);
     
     String RequestedTRT = "Pictures\\WopImages\\RequestedTRT.PNG";
		
     imageEnterText(RequestedTRT,GEWO.excelData[1][0], 10);
     
     String  wopRequestedTRT= "RequestedTRT:"; 
     
     wopGeneralEditWorkOrderData(wopRequestedTRT+"01:00:00");
     
     productscreen.wait((double) 2.0);
     
     String Instructions = "Pictures\\WopImages\\Instructions.PNG";
		
     imageEnterText(Instructions,GEWO.excelData[1][3], 10);
     
     productscreen.wait((double) 2.0);
     
     String VariSpeedType = "Pictures\\WopImages\\VariSpeedType.PNG";
		
     imageEnterText(VariSpeedType,GEWO.excelData[1][1], 10);
     
     String  wopVariSpeedType= "VariSpeedType:"; 
     
      wopGeneralEditWorkOrderData(wopVariSpeedType+GEWO.excelData[1][1]);
     
      productscreen.wait((double) 2.0);
      
     	String CompleteInEdit = "Pictures\\WopImages\\CompleteInEdit.PNG";
		
     	imageFindClick(CompleteInEdit, 10);
     
     	productscreen.wait((double) 2.0);
     	
     	String ReadyToPublishVersion = "Pictures\\WopImages\\ReadyToPublishVersion.PNG";
	   
	    imageFindClick(ReadyToPublishVersion,10);
	   
	    productscreen.wait((double) 2.0);
	    
	    String MAVersionType = "Pictures\\WopImages\\MAVersionType.PNG";
	    
	    imagedoubleClickEnterText(MAVersionType,GEWO.excelData[1][2],10);
			
		String  wopMAVersionType= "MAVersionType:"; 
			
		wopGeneralEditWorkOrderData(wopMAVersionType+GEWO.excelData[1][2]);
		
		 productscreen.wait((double) 2.0);
		 
		 
		   String MediaAssetLsit = "Pictures\\WopImages\\MediaAssetLsit.PNG";
		   
		   imagecopyGeneralMat(MediaAssetLsit , 10);
		
		    String  GeneralMatID= "GeneralEditMatID:"; 
	       
		    wopGeneralEditWorkOrderData(GeneralMatID+TxBase.GeneralMattextvalue);
		    
		    productscreen.wait((double) 2.0);
     
		String MAFirst = "Pictures\\WopImages\\MAFirst.PNG";
		   
	    imageFindClick(MAFirst,10);
	    
	    keyDownMethod();
	   
 
	
	}
	
	
	
}
