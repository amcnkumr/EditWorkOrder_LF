package com.amc.txrepo;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

import junit.framework.Assert;

public class MPEpisodeVersionObjects extends TxBase{
	
	
    ExcelUtils ProductBrowserData = new ExcelUtils();
	
	ExcelUtils VersionData = new ExcelUtils();
		
	Screen productscreen = new Screen();
	
	
	
	public void MPEpisodeVersion() throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		
		screen.wait((double) 2.0);
		
        String MataVaultLibrary = "Pictures\\WopImages\\MataVaultLibrary.PNG";
		
        imageFindClick(MataVaultLibrary ,10);
		
        screen.wait((double) 3.0);
        
        String MataVaultLibraryTitles = "Pictures\\WopImages\\MataVaultLibraryTitles.PNG";
		
        imageFindClick(MataVaultLibraryTitles ,10);
        
        screen.wait((double) 4.0);
       
        String AdvancedSearch = "Pictures\\WopImages\\AdvancedSearch.PNG";
		
        imageFindClick(AdvancedSearch ,10);

        screen.wait((double) 5.0);
        
        String EnterAmcnField = "Pictures\\WopImages\\EnterAmcnFiedl.PNG";
		
       imageEnterText(EnterAmcnField, WOPEpisodeVersion.rlacheckpoint,10);
        
        //imageEnterText(EnterAmcnField, "RLA178231.2",10);
        
		Clickenter();
		
		screen.wait((double) 4.0);
			
		try {
		
        String ResultClick = "Pictures\\WopImages\\ResultClick.PNG";
		
        imageFindClick(ResultClick ,10);		
		
        screen.wait((double) 7.0);
        
        logStep("WOP to MP Integration is Success");
        
        logStep("WOP to MP Integration Data:" + WOPEpisodeVersion.rlacheckpoint);
        
        System.out.println("WOP to MP Integration Data:" + WOPEpisodeVersion.rlacheckpoint);
        
        //logStep("WOP to MP Integration Data:" + "RLA177304.2");
        
       //System.out.println("WOP to MP Integration Data:" + "RLA177304.2");
        
		} catch(Exception e) {
			
			logStep("WOP to MP Integration is failed");
			
			System.out.println("WOP to MP Integration is failed");
			
			Assert.fail(String.format("WOP to MP Intehration is failed..." , e.getMessage())) ;
						
		}
        
		screen.wait((double) 2.0);
		
		// Taking Fields 
		
		String MPAMCNID = "Pictures\\WopImages\\MPAMCNID.PNG";
		   
		imagedoubleclickcopyText(MPAMCNID,10);
		
		String mpAMCNID = "AMCNID:";
		   
		mpEpisodeVersionData(mpAMCNID);
		
		screen.wait((double) 2.0);
		
		String MPEpisodeNumber = "Pictures\\WopImages\\MPEpisodeNumber.PNG";
		
		imagecopyText(MPEpisodeNumber,10);
			
		String  mpEpisodeNumber= "EpisodeNumber:"; 
			
		mpEpisodeVersionData(mpEpisodeNumber);
		
		
   	    String MPAiringOrder = "Pictures\\WopImages\\MPAiringOrder.PNG";
		
		imagecopyText(MPAiringOrder,10);
		
		String  mpAiringOrder= "AiringOrder:"; 
		
		mpEpisodeVersionData(mpAiringOrder);
	    
	    
	    String MPShowType = "Pictures\\WopImages\\MPShowType.PNG";
		
		imagecopyText(MPShowType,10);
		
		String  mpShowType= "ShowType:"; 
		
		mpEpisodeVersionData(mpShowType);
	
		
		tabforProductionmode();
		
		String MPProductionMode = "Pictures\\WopImages\\MPProductionMode.PNG";
		
		imagecopyText(MPProductionMode,10);
		
		String  mpProductionMode= "ProductionMode:"; 
   		
		mpEpisodeVersionData(mpProductionMode);
	    
	    
	    String MPSecurityStatus = "Pictures\\WopImages\\MPSecurityStatus.PNG";
		
	    imagecopyText(MPSecurityStatus,10);
		
		String  mpSecurityStatus= "SecurityStatus:"; 
		
		mpEpisodeVersionData(mpSecurityStatus);
	    
	    
	    String MPEditRestricted = "Pictures\\WopImages\\MPEditRestricted.PNG";
		
		imagecopyText(MPEditRestricted,10);
		
		String  mpEditRestricted= "EditRestricted:"; 
		
		mpEpisodeVersionData(mpEditRestricted);
	    	    
	  
	    String MPEpisodeVersionType = "Pictures\\WopImages\\MPEpisodeVersionType.PNG";
		
		imagecopyText(MPEpisodeVersionType,10);
		
		String  mpEpisodeVersionType= "EpisodeVersionType:"; 
		
		mpEpisodeVersionData(mpEpisodeVersionType);
		
		
		String MPOwnerNetwork = "Pictures\\WopImages\\MPOwnerNetwork.PNG";
		   
		imagedoubleclickcopyText(MPOwnerNetwork,10);
		
		String MPOwner = "Ownernetwork:";
		   
		mpEpisodeVersionData(MPOwner);
		
		screen.wait((double) 2.0);
			
		String MPSupplier = "Pictures\\WopImages\\MPSupplier.PNG";
		   
		imagedoubleclickcopyText(MPSupplier,10);
		
		String MPSupp = "Supplier:";
		   
		mpEpisodeVersionData(MPSupp);
		
		
		String MPTheatricalLength = "Pictures\\WopImages\\MPTheatricalLength.PNG";
		   
		imagedoubleclickcopyText(MPTheatricalLength,10);
		
		String MPLength = "TheatricalLength:";
		   
		mpEpisodeVersionData(MPLength);
		
		screen.wait((double) 2.0);
				
		
		String videoAMCNID = "AMCNIDVideo:";
		   
		mpEpisodeVersionDatavideo(videoAMCNID+TxBase.Mattextvalue+".video");
		
		
	   String audioAMCNID = "AMCNIDAudio:";
	   
	   mpEpisodeVersionDataAudio(audioAMCNID+TxBase.Mattextvalue+".1.English.OA");
		
		
        String MediaAssets = "Pictures\\WopImages\\MediaAssets.PNG";
		
        imageFindClick(MediaAssets ,10);
        
        refresh:
        for(int i=1; i<=175; i++) {
          
        try {
        	
        	String MPChekPoint = "Pictures\\WopImages\\MPChekPoint.PNG";
        	
        	imageFindClick(MPChekPoint,3);
        	
        	String Refresh = "Pictures\\WopImages\\Refresh.PNG";
            
            imageFindClick(Refresh,5);
        	
        	break refresh;
        }
          catch(Exception e){
        	  
        	  String Refresh = "Pictures\\WopImages\\Refresh.PNG";
              
              imageFindClick(Refresh,5);
              
        	  
          }
          
    
        
        }
        
        
        //Taking Fields Of General Edit Work Order :
        
        
        for(int GeEdit=0; GeEdit<=3; GeEdit++) {
            
        	keyDownMethod();
        
        }
        
        Clickenter();
        
        
        screen.wait((double) 7.0);
        
        String GeneralEditSourceAsset1 = "Pictures\\WopImages\\GeneralEditSourceAsset1.PNG";
		   
        imagecopyText(GeneralEditSourceAsset1,10);
		
		String soure="SourceAsset_1:";
		
		Generalsourcefield(soure);
		
		
		String MPMat = "Pictures\\WopImages\\MPMat.PNG";
		   
		imagecopyGeneralMat(MPMat,10);
		
		String mpmat = "GeneralEditMatID:";
		   
		mpGeneralEditWorkOrderData(mpmat);
		
		
		screen.wait((double) 2.0);
		
		String Wheel = "Pictures\\WopImages\\Wheel.PNG";
		
		imageFindClick(Wheel, 2);
		
		
		screen.wait((double) 2.0);
		
		String MPRequestedTRT = "Pictures\\WopImages\\MPRequestedTRT.PNG";
		   
		imagedoubleclickcopyText(MPRequestedTRT,10);
		
		String mpRequestedTRT="RequestedTRT:";
		
		mpGeneralEditWorkOrderData(mpRequestedTRT);
		
		screen.wait((double) 2.0);
		
		String VarispeedTab = "Pictures\\WopImages\\VarispeedTab.PNG";
		   
		imageFindClick(VarispeedTab,10);
		
		screen.wait((double) 1.0);
		
		String Compression = "Pictures\\WopImages\\Compression.PNG";
		   
		imagedoubleclickcopyText(Compression,10);
		
		String VarispeedType="VarispeedType:";
		
		mpGeneralEditWorkOrderData(VarispeedType);
		
		
		String  wopMAVersionType= "MAVersionType:"; 
		
		TxBase.MPGeneralEditWork.add(wopMAVersionType+"Final TX - Varispeed");
		
		
		
		
		String GeClose = "Pictures\\WopImages\\GeClose.PNG";
		   
		imageFindClick(GeClose,10);
		
		screen.wait((double) 1.0);
		
		for(int TempoEdit=0; TempoEdit<=1; TempoEdit++) {
            
			TempoKeyUp();
        
        }
		
		Clickenter();
				
		screen.wait((double) 7.0);
        
        String TempoEditSourceAsset1 = "Pictures\\WopImages\\GeneralEditSourceAsset1.PNG";
		   
        imagecopyText(TempoEditSourceAsset1,10);
		
		String soureTempo="SourceAsset_1:";
		
		Temposourcefield(soureTempo);
		
		
		String MPMatRepeat = "Pictures\\WopImages\\MPMat.PNG";
		   
		imagecopyTempoMat(MPMatRepeat,10);
		
		String mpmatrepeat = "TempoEditMatID:";
		   
		mpTempoEditWorkOrderData(mpmatrepeat);
		
		
		screen.wait((double) 2.0);
		
		String Wheelrepeat = "Pictures\\WopImages\\Wheel.PNG";
		
		imageFindClick(Wheelrepeat, 2);
		
		
		screen.wait((double) 2.0);
		
		String MPRequestedTRTRepeat = "Pictures\\WopImages\\MPRequestedTRT.PNG";
		   
		imagedoubleclickcopyText(MPRequestedTRTRepeat,10);
		
		String mpRequestedTRTRepeat="RequestedTRT:";
		
		mpTempoEditWorkOrderData(mpRequestedTRTRepeat);
		
		screen.wait((double) 2.0);
		
		String VarispeedTabRepeat = "Pictures\\WopImages\\VarispeedTab.PNG";
		   
		imageFindClick(VarispeedTabRepeat,10);
		
		screen.wait((double) 1.0);
		
		String Expansion = "Pictures\\WopImages\\Expansion.PNG";
		   
		imagedoubleclickcopyText(Expansion,10);
		
		String VarispeedTypeRepeat="VarispeedType:";
		
		mpTempoEditWorkOrderData(VarispeedTypeRepeat);
		
		TxBase.MPTempoEditWork.add(wopMAVersionType+"Final TX - Varispeed");
		
		String TempoClose = "Pictures\\WopImages\\GeClose.PNG";
		   
		imageFindClick(TempoClose,10);
		
		
		for(int TempoEdit=0; TempoEdit<=1; TempoEdit++) {
            
			TempoKeyUp();
        
        }
		
		Clickenter();
        
        
        /*screen.wait((double) 4.0);
        
        String LSIT = "Pictures\\WopImages\\LSIT.PNG";
        
        imageFindClick(LSIT,5);
		
        imageFindClick(LSIT,5);*/
        
        screen.wait((double) 6.0);
        
        String MPTitle = "Pictures\\WopImages\\MPTitle.PNG";
		   
		imagedoubleclickcopyText(MPTitle,10);
		
		String MPtitle = "Title:";
		   
		mpEpisodeVersionData(MPtitle);
		
		
		String MPAssetSource = "Pictures\\WopImages\\MPAssetSource.PNG";
		   
		imagedoubleclickcopyText(MPAssetSource,10);
		
		String mpAssetsource = "AssetSource:";
		   
		mpEpisodeVersionData(mpAssetsource);
		
		
		String MPFileStatus = "Pictures\\WopImages\\MPFileStatus.PNG";
		   
		imagedoubleclickcopyText(MPFileStatus,10);
		
		String mpfile = "FileStatus:";
		   
		mpEpisodeVersionData(mpfile);
			
		
		String MPMat1 = "Pictures\\WopImages\\MPMat.PNG";
		   
		imagedoubleclickcopyText(MPMat1,10);
		
		String mpmat1 = "MatID:";
		   
		mpEpisodeVersionData(mpmat1);
		
             
        
	}
	
        
	// Taking Fields Data
	
	public void MPEpisodeData() throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		
		screen.wait((double) 4.0);
		
		String Wheel = "Pictures\\WopImages\\Wheel.PNG";
		
		imageFindClick(Wheel, 2);
		
		screen.wait((double) 2.0);			
			  	
		String mpScanType = "Pictures\\WopImages\\mpScanType.PNG";
		
		imagecopyText(mpScanType,10);
   		
   		String  scantype= "ExpectedScanType:"; 
   		
   		mpEpisodeVersionData(scantype);
		
		
   	    String mpSegments = "Pictures\\WopImages\\mpSegments.PNG";
   	    
   	    imagecopyText(mpSegments,10);
		
		String  segments= "ExpectedSegments:"; 
		
		mpEpisodeVersionData(segments);
   		
   		
		String mpFrameRate =  "Pictures\\WopImages\\mpFrameRate.PNG";
		
		imagecopyText(mpFrameRate,10);
   		
  		String  framerate= "ExpectedFrameRate:"; 
  		
  		mpEpisodeVersionData(framerate);
   		
   		
  		String mpVideoCodec = "Pictures\\WopImages\\mpVideoCodec.PNG";
  		
  		imagecopyText(mpVideoCodec,10);
   		
   	    String  videocodec= "ExpectedVideoCodec:"; 
		
   	    mpEpisodeVersionData(videocodec);
   	    
   	    
   	    String mpAspectRatio = "Pictures\\WopImages\\mpAspectRatio.PNG";
		
   	    imagecopyText(mpAspectRatio,10);
		
	    String AspectRatio= "ExpectedAspectRatio:"; 
		
	    mpEpisodeVersionData(AspectRatio);
   		 		
   		
	    String mpFormat = "Pictures\\WopImages\\mpFormat.PNG";
		
	    imagecopyText(mpFormat,10);
		
	    String format= "ExpectedFormat:"; 
		
	    mpEpisodeVersionData(format);
   		
   		
        String mpTRT = "Pictures\\WopImages\\mpTRT.PNG";
		
		imagedoubleclickcopyText(mpTRT,10);
		
	    String trt= "ExpectedFormat:"; 
		
	    mpEpisodeVersionData(trt);
	     
	    
	    String  mpMAVersionType= "MAVersionType:"; 
		
		mpEpisodeVersionDatafinalTx(mpMAVersionType+"Final TX - Master");
		
	
		String MPColor = "Pictures\\WopImages\\MPColor.PNG";
		
		imagecopyText(MPColor,10);
			
		String  mpColor= "Color/B&W:";
		
		mpEpisodeVersionData(mpColor);
   		
	    // Taking Audio Data
   		
	    String Audiotab = "Pictures\\WopImages\\Audiotab.PNG";
		   
		imageDoubleClick(Audiotab,10);
		
		
		String Channel1 = "Pictures\\WopImages\\Channel1.PNG";
		   
		imageFindClick(Channel1,10);
		
		for(int right=0 ; right<=2; right++) {
			
			tabMethod();
		}
		
		screen.wait((double) 1.0);
		
		String MPAudioDescription = "Pictures\\WopImages\\MPAudioDescription.PNG";
		   
		imagedoubleclickcopyText(MPAudioDescription,10);
		
		String MPchannel = "ExpectedChannel1-2:";
		   
		mpEpisodeVersionData(MPchannel);
		
		screen.wait((double) 1.0);
		
        for(int right=0 ; right<=1; right++) {
			
			tabMethod();
		}
		
		screen.wait((double) 1.0);
			
		String MPAudioLanguage = "Pictures\\WopImages\\MPAudioLanguage.PNG";
		   
		imagedoubleclickcopyText(MPAudioLanguage,10);
		
		String MPlangu = "ExpectedLanguage:";
		   
		mpEpisodeVersionData(MPlangu);
		
		
   		
   		
		
	}
}

