
package com.amc.txrepo;





import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

import junit.framework.Assert;

public class WOPEpisodeVersion extends TxBase {

	ExcelUtils ProductBrowserData = new ExcelUtils();
	
	ExcelUtils VersionData = new ExcelUtils();
		
	Screen productscreen = new Screen();
	
	GeneralEditWorkOrder generalEditWork = new GeneralEditWorkOrder();
	
	TempoEditWorkOrder TempoEditWork = new TempoEditWorkOrder();
	
	public static String  duplicateVersion;
	
	public static String  AMCNID;
	
	public static String rlacheckpoint;
	
	public static String  Execution="Fail";
	
     // Episode Version Creation In WOP Product Browser
	
	
	public void EpisodeVersionCreation() throws Exception {
		
		//productscreen.wait((double) 13.0);

		String BrowserSearch = "Pictures\\WopImages\\BrowserSearch.PNG";
		
		ProductBrowserData.readingexcelFiles("ProductBrowserData");
		
		imageEnterText(BrowserSearch,ProductBrowserData.excelData[1][0] ,10);
					
		Clickenter();
		
		String AmcnIDField = "Pictures\\WopImages\\AmcnIDField.PNG";
				
		imageClickAndTab(AmcnIDField,5);
		
		productscreen.wait((double) 2.0);
		
		String AmcnField2 = "Pictures\\WopImages\\AmcnField2.PNG";
		
		imageEnterText(AmcnField2,ProductBrowserData.excelData[1][1] ,10);
		
		Clickenter();
				
		String VersionMA = "Pictures\\WopImages\\VersionMA.PNG";
		
		imageDoubleClick(VersionMA, 5);
		
		productscreen.wait((double) 5.0);
		
		String Supplier = "Pictures\\WopImages\\Supplier.PNG";
		
		imageEnterText(Supplier,"Miramax",10);
		
		for(int i=0; i<=2;i++) {
			
			Clickenter();
		}
		
		productscreen.wait((double) 2.0);
		
		String ProductionMode = "Pictures\\WopImages\\ProductionMode.PNG";
		
		imageEnterText(ProductionMode,"Scripted",10);
		
		Clickenter();
		
		/*propagatewindow();
		
		Clickenter();*/
		
		String  wopProductionMode= "ProductionMode:"; 
   		
   	    wopEpisodeVersionData(wopProductionMode+"Scripted");
   	    
   	 productscreen.wait((double) 2.0);
   	    
   	 String EpisodeNumber = "Pictures\\WopImages\\EpisodeNumber.PNG";
		
		imagecopyText(EpisodeNumber,10);
		
		String  wopEpisodeNumber= "EpisodeNumber:"; 
		
	    wopEpisodeVersionData(wopEpisodeNumber+TxBase.textvalue);
		
		
	    String AiringOrder = "Pictures\\WopImages\\AiringOrder.PNG";
		
		imagecopyText(AiringOrder,10);
		
		String  wopAiringOrder= "AiringOrder:"; 
		
	    wopEpisodeVersionData(wopAiringOrder+TxBase.textvalue);
	    
	    
	    String ShowType = "Pictures\\WopImages\\ShowType.PNG";
		
		imagecopyText(ShowType,10);
		
		String  wopShowType= "ShowType:"; 
		
	    wopEpisodeVersionData(wopShowType+TxBase.textvalue);
	    
	    
	    String SecurityStatus = "Pictures\\WopImages\\SecurityStatus.PNG";
		
	    imagedoubleclickcopyText(SecurityStatus,10);
		
		String  wopSecurityStatus= "SecurityStatus:"; 
		
	    wopEpisodeVersionData(wopSecurityStatus+TxBase.textvalue);
	    
	    
	    String EditRestricted = "Pictures\\WopImages\\EditRestricted.PNG";
		
		imagecopyText(EditRestricted,10);
		
		String  wopEditRestricted= "EditRestricted:"; 
		
	    wopEpisodeVersionData(wopEditRestricted+TxBase.textvalue);
   	    
   	     
   	    // Taking Ownernetwork Field
		
   		productscreen.wait((double) 2.0);
   			
   		String EOwnernetwork = "Pictures\\WopImages\\EOwnernetwork.PNG";
   			
   		imagecopyText(EOwnernetwork, 10);
   			   		
   	    String  wopEOwnernetwork= "Ownernetwork:"; 
   		
   	    wopEpisodeVersionData(wopEOwnernetwork+TxBase.textvalue);
   	    	
		
		// Taking Title Field
		
		productscreen.wait((double) 2.0);
		
		String Titlesicon = "Pictures\\WopImages\\Titlesicon.PNG";
		
		imageFindClick(Titlesicon, 10);
		
		productscreen.wait((double) 3.0);
		
        String titleone = "Pictures\\WopImages\\Titlesone.PNG";
		
        imageFindClick(titleone, 10);
        
        productscreen.wait((double) 2.0);
		
		String titlecolor = "Pictures\\WopImages\\Titlecolour.PNG";
			
		imagedoubleclickcopyText(titlecolor, 10);
		   		
   	    String  woptitile= "Title:"; 
	
   	    wopEpisodeVersionData(woptitile+TxBase.textvalue);
   	    
   	    
   	    String  woptitileGeneral= "GeneralEditWorkOrderTitle:"; 
 	
   	    wopGeneralEditWorkOrderData(woptitileGeneral+TxBase.textvalue);
   	 
   	 
   	    String  woptitileTempo= "TempoEditWorkOrderTitle:"; 
 	
   	    wopTempoEditWorkOrderData(woptitileTempo+TxBase.textvalue);
   	    
   	      
	    productscreen.wait((double) 2.0);
		
		VersionData.readingexcelFiles("EPVersionData");
		
		// Product Version Selection 
		
		Version:
		
		for(int i=1; i<=VersionData.lastRow;  i++) {
			
			
	    String ProductMenu = "Pictures\\WopImages\\ProductMenu.PNG";
			
		imageFindClick(ProductMenu,10);
			
	    String NewVersionItem = "Pictures\\WopImages\\NewVersionItem.PNG";
			
	    imageFindClick(NewVersionItem,10);		
		
		productscreen.wait((double) 4.0);
		
		String FindBar = "Pictures\\WopImages\\FindBar.PNG";
		
		imageEnterText(FindBar,VersionData.excelData[i][0] ,10);
		
		productscreen.wait((double) 4.0);
		
        String CheckBox = "Pictures\\WopImages\\CheckBox.PNG";
		
		imageFindClick(CheckBox,10);
		
		productscreen.wait((double) 4.0);
		
		String ClearFindBar = "Pictures\\WopImages\\ClearFindBar.PNG";
		
		imageClearText(ClearFindBar, 10);
		
		productscreen.wait((double) 4.0);
		
		String FindBar2 = "Pictures\\WopImages\\FindBar2.PNG";
		
		imageEnterText(FindBar2,VersionData.excelData[i][1] ,10);
		
		productscreen.wait((double) 4.0);
		
        String CheckBox1 = "Pictures\\WopImages\\CheckBox.PNG";
		
		imageFindClick(CheckBox1,10);
		
		productscreen.wait((double) 4.0);
		
		String VersionOkButton = "Pictures\\WopImages\\VersionOkButton.PNG";
		
		imageFindClick(VersionOkButton,10);
		
		// Selected Version Duplicate
		
		productscreen.wait((double) 3.0);
		
		try {
			
			String SaveChanges = "Pictures\\WopImages\\SaveChanges.PNG";
			
		    imageFindClick(SaveChanges,10);
		    
		    productscreen.wait((double) 3.0);
						
		}catch (Exception e) {
			
			System.out.println("No Save Changes Winow is Displayed");
		}
				
		try {
        
			String SelectedVersionDuplicateWindow = "Pictures\\WopImages\\SelectedVersionDuplicateWindow.PNG";
		
		    imageFindClick(SelectedVersionDuplicateWindow,10);
		
		    duplicateVersion= "Selected Version Already Exist";
		    
		    productscreen.wait((double) 2.0);
		
		} catch (Exception e) {
			
			System.out.println("No Duplicate Version Exists");
			
			
		}
		
		if(duplicateVersion=="Selected Version Already Exist") {
			
			System.out.println("Duplicate Version Exist and Try For Another Version");
					
			duplicateVersion = null;
			
			String MARLA = "Pictures\\WopImages\\MARLA.PNG";
			
		    imageFindClick(MARLA,10);
		    
		    productscreen.wait((double) 3.0);
			
		} else {
			
			System.out.println("Selected Version:" + VersionData.excelData[i][0] + VersionData.excelData[i][1] );
			
			logStep("Episode Verison Creation is Success");
			
			break Version;
		}
		
				
		}
				
		
}

	       // Linking Media Asset to Created Version
	
	       public void MediaAssetLinking() throws java.lang.Exception {
	    	   	    	   
	    	   
	    	   productscreen.wait((double) 2.0);
	    	   
	    	   String NewMediaAssetVersion = "Pictures\\WopImages\\NewMediaAssetVersion.PNG";
				
			   imageFindClick(NewMediaAssetVersion,10);
			   
			   String SaveChanges = "Pictures\\WopImages\\SaveChanges.PNG";
				
			   imageFindClick(SaveChanges,10);
			   
			   String PrototypeFind = "Pictures\\WopImages\\PrototypeFind.PNG";				
			   
			   imageEnterText(PrototypeFind,ProductBrowserData.excelData[1][2] ,10);
			   
			   productscreen.wait((double) 2.0);
			   
			   String PrototypeCreate = "Pictures\\WopImages\\PrototypeCreate.PNG";
				
			   imageFindClick(PrototypeCreate,10);
			   			    		   
			 // Giving Protoype Data
			   
			   String VideoComponent = "Pictures\\WopImages\\VideoComponent.PNG";
				
			   imageFindClick(VideoComponent,10);
			   
			   productscreen.wait((double) 4.0);
			   			   
			   String ExpectedScanType = "Pictures\\WopImages\\ExpectedScanType.PNG";
			   
			   EnterTextandTabVersion(ExpectedScanType,ProductBrowserData.excelData[1][3],10);
			   
			   productscreen.wait((double) 3.0);
			   
			   String FormatAssignMent = "Pictures\\WopImages\\FormatAssignMent.PNG";
			   
			   imageFindClick(FormatAssignMent,10);
			   
			   productscreen.wait((double) 3.0);
			   
			   String ExpectedSegments = "Pictures\\WopImages\\EpectedSegments.PNG";
			   
			   imageFindClick(ExpectedSegments,10);
			   
			   ClickandUpArrow();
			   
			   //imageEnterText(ExpectedSegments,ProductBrowserData.excelData[1][4],10);
			   
			   
			   for(int tab=0; tab<=2; tab++) {
				   
				   productscreen.type(Keys.TAB);
			   }
			   
			   productscreen.wait((double) 3.0);
			   
			   String EstimatedTRTVersion = "Pictures\\WopImages\\ExpectedTRTVersion.PNG";
			   
			   imageEnterText(EstimatedTRTVersion,ProductBrowserData.excelData[1][10],10);
			   			   
			   			   
			   productscreen.wait((double) 2.0);
			   
			   String ReadyToPublishVersion = "Pictures\\WopImages\\ReadyToPublishVersion.PNG";
			   
			   imageFindClick(ReadyToPublishVersion,10);
			   
			   productscreen.wait((double) 2.0);
			   
			    String MAVersionType = "Pictures\\WopImages\\MAVersionType.PNG";
				
				imagecopyText(MAVersionType,10);
					
				String  wopMAVersionType= "MAVersionType:"; 
					
				wopEpisodeVersionData(wopMAVersionType+TxBase.textvalue);
				
				
				String  wopColor= "Color/B&W:"; 
				
				wopEpisodeVersionData(wopColor+"Color/B&W");
			   
				
			   productscreen.wait((double) 5.0);
			   
			   String MediaAssetLsit = "Pictures\\WopImages\\MediaAssetLsit.PNG";
			   
			   imagecopyMat(MediaAssetLsit , 10);
			   
			   productscreen.wait((double) 2.0);
			   
               String videoAMCNID = "AMCNIDVideo:";
			   
			   wopEpisodeVersionData(videoAMCNID+TxBase.Mattextvalue+".video");
			   
			     
			   // Taking Asset Source Field
				
				productscreen.wait((double) 2.0);
				
				String Type = "Pictures\\WopImages\\Type.PNG";
				
				imagecopyText(Type, 10);
				   		
		   	    String  woptype= "AssetSource:"; 
			
		   	    wopEpisodeVersionData(woptype+TxBase.textvalue);
		   	    
		   	    
		   	    // Taking Distributor Field
				
		   		productscreen.wait((double) 3.0);
		   			
		   		String Distributor = "Pictures\\WopImages\\Distributor.PNG";
		   			
		   		imagecopyText(Distributor, 10);
		   			   		
		   	    String  wopDistributor= "Distributor:"; 
		   		
		   	    wopEpisodeVersionData(wopDistributor+TxBase.textvalue);
		   	    
		   	    
		   	    // Taking TheatricalLength Field
				
		   		productscreen.wait((double) 3.0);
		   			
		   		String TheatricalLength = "Pictures\\WopImages\\TheatricalLength.PNG";
		   			
		 		imagedoubleclickcopyText(TheatricalLength, 10);
		   			   		
		   	    String  wopTheatricalLength= "TheatricalLength:"; 
		   		
		   	    wopEpisodeVersionData(wopTheatricalLength+TxBase.textvalue);
		   	    
		   		
		   	    // Taking Audio Components Fields
				
				String AudioComponent = "Pictures\\WopImages\\AudioComponent.PNG";
				   
				imageFindClick(AudioComponent,10);
				
				
				String audioAMCNID = "AMCNIDAudio:";
				   
				wopEpisodeVersionData(audioAMCNID+TxBase.Mattextvalue+".1.English.OA");
				
				screen.wait((double) 2.0);
				
				String FileStatus = "Pictures\\WopImages\\FileStatus.PNG";
				   
				imagedoubleclickcopyText(FileStatus,10);
				
				String filestatus = "FileStatus:";
				   
				wopEpisodeVersionData(filestatus+TxBase.textvalue);
				
				String EAudioLanguage = "Pictures\\WopImages\\EAudioLanguage.PNG";
				   
				imagedoubleclickcopyText(EAudioLanguage,10);
				
				String AudioLanguageexp = "ExpectedLanguage:";
				   
				wopEpisodeVersionData(AudioLanguageexp+TxBase.textvalue);
				
				screen.wait((double) 2.0);
					
				String EChannelPair = "Pictures\\WopImages\\EChannelPair.PNG";
				   
				imagedoubleclickcopyText(EChannelPair,10);
				
				String ChannelPairExp = "ExpectedChannel1-2:";
				   
				wopEpisodeVersionData(ChannelPairExp+TxBase.textvalue);
				
				screen.wait((double) 2.0);
								
				// ========== Edit Work Order =========== 
			
				generalEditWork.GeneralEditWorkOrderCreation();
				
				TempoEditWork.TempoEditWorkOrderCreation();
				
				screen.wait((double) 2.0);
				
			   String SavePrototype = "Pictures\\WopImages\\SavePrototype.PNG";
			   
			   imageFindClick(SavePrototype,10);
			   
			   productscreen.wait((double) 2.0);
			   
			   String File1 = "Pictures\\WopImages\\File1.PNG";
			   
			   imageFindClick(File1,10);
			   
			   productscreen.wait((double) 2.0);
			   
			   String PrototypeClose = "Pictures\\WopImages\\PrototypeClose.PNG";
			   
			   imageFindClick(PrototypeClose,10);
			      
			   logStep("Created Media Asset In WOP Business System:" + ProductBrowserData.excelData[1][2]);
			   
			   productscreen.wait((double) 3.0);
			      
			   String EpisodeVersionType = "Pictures\\WopImages\\EpisodeVersionType.PNG";
				
			   imagecopyText(EpisodeVersionType,10);
				
			   String  wopEpisodeVersionType= "EpisodeVersionType:"; 
				
			   wopEpisodeVersionData(wopEpisodeVersionType+TxBase.textvalue);
			   
			   
			   productscreen.wait((double) 2.0);
			   
			   String General = "Pictures\\WopImages\\General.PNG";
			   
			   imageFindClick(General,10);
			   
			   
			   // for(int i=1; i<=10;i++) {
			    
			   //logStep("Waited 80 Seconds For WOP Services UP And Run ");
			    
			   productscreen.wait((double) 40.0);
			   
			   // Checkpoint to Validate WOP Services
			 
			   try {
				   
			   String CheckPoint = "Pictures\\WopImages\\CheckPoint.PNG";
			   
			   imagecopyDecimalText(CheckPoint,10);
			   
			    rlacheckpoint = TxBase.textvalueDecimal;
				   
				   //rlacheckpoint="RLA177304.2";
			    		    	
			   if(rlacheckpoint.contains("RLA")) {
				   
				  logStep("WOP Services Up And Running :" + TxBase.textvalueDecimal);
				   
				  //logStep("WOP Services Up And Running :" + rlacheckpoint);
				   				   
				  System.out.println(" WOP Services UP And Running:" + TxBase.textvalueDecimal);
				   
				   //System.out.println(" WOP Services UP And Running:" + rlacheckpoint);
				   
				   Execution ="Pass";
				   
				  // break;
			   
			   //}else {
				  // if(i==10) {
				   
			   }  else {
				   
				   logStep("WOP Services are not Up & Running");
				   
				   System.out.println("WOP Services are not Up&Running");
				   
				   Execution ="Fail";
				   
				   Assert.fail("Id was not changed to RLA,-WOP services are not running..." + rlacheckpoint.contains("RLA"));
				   
				   //}else {
					  // logStep(i*10+" Seconds Waited for WOP Services Up & Running");
					   
					   //System.out.println(i*10+" Seconds Waited for WOP Services Up & Running");
				   //}
			   //}
			   
				   }
			   
			   }
			   
			   catch(Exception e) {
					   
				   System.out.println(e.getMessage());
				   
				   Execution ="Fail";
					   
				   }
			    
	       }   	   
	       
	       

	       
       
	       
	       // WOP Source Data:
	       
	       public void wopSourceData() throws FindFailed {
	    	   
	         AMCNID = ProductBrowserData.excelData[1][1];
	   		
	   		String  amcnId= "AMCNID:";  
	   		   		
	        wopEpisodeVersionData(amcnId+rlacheckpoint);
	        
	        String EscandType = ProductBrowserData.excelData[1][3];
	   		
	   		String  scantype= "ExpectedScanType:"; 
	   		
	   	    wopEpisodeVersionData(scantype+EscandType);
	   	    
	   	    
	   	    String Esegments = ProductBrowserData.excelData[1][4];
	   		
	   		String  segments= "ExpectedSegments:"; 
	   		
	   	    wopEpisodeVersionData(segments+Esegments);
	   	    
	   	    
	   	     String Eframerate = ProductBrowserData.excelData[1][5];
	   		
	   		 String  framerate= "ExpectedFrameRate:"; 
	   		
	   	    wopEpisodeVersionData(framerate+Eframerate);
	   	    
	   	    
	   	    String EvideoCodec = ProductBrowserData.excelData[1][6];
	   		
	   	    String  videocodec= "ExpectedVideoCodec:"; 
   		
	   	    wopEpisodeVersionData(videocodec+EvideoCodec);
	   	    
	   	    
	   	    String EaspectRatio = ProductBrowserData.excelData[1][7];
	   		
	   	    String  aspectratio= "ExpectedAspectRatio:"; 
		
	   	    wopEpisodeVersionData(aspectratio+EaspectRatio);
	   	    
	   	 
	   	    String Eformat = ProductBrowserData.excelData[1][8];
	   		
	   	    String  format= "ExpectedFormat:"; 
		
	   	    wopEpisodeVersionData(format+Eformat);
	   	    
	   	    
	   	    String ETRT = "1:30:00;00";
	   		
	   	    String  trt= "EstimatedTRT:"; 
		
	   	    wopEpisodeVersionData(trt+ETRT);
	   	       	    
	   	    
	   	    String supplier = "Miramax";
	   		
	   	    String  suppli= "Supplier:"; 
		
	   	    wopEpisodeVersionData(suppli+supplier);
	   	    
	   		
	   	    String  matId= "MatID:"; 
		
	   	    wopEpisodeVersionData(matId+TxBase.Mattextvalue);
	   	    
	   	    
	   	   productscreen.wait((double) 2.0);
		   
		   String SaveEpisodeVersion = "Pictures\\WopImages\\SavePrototype.PNG";
		   
		   imageFindClick(SaveEpisodeVersion,10);
		   
		   productscreen.wait((double) 65.0);
		   
		   /*for(int i=0; i<=1; i++) {
		   
		   String File1 = "Pictures\\WopImages\\File1.PNG";
		   
		   imageFindClick(File1,10);
		   
		   productscreen.wait((double) 2.0);
		   
		   String PrototypeClose = "Pictures\\WopImages\\PrototypeClose.PNG";
		   
		   imageFindClick(PrototypeClose,10);
		   
		   productscreen.wait((double) 2.0);
		   
		   }*/
	   	       	    
	   	  //disconnectWop();
	       
	       }
	
}
