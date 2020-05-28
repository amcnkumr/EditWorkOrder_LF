package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.amc.txbase.TxBase;
import com.amc.txrepo.RecordLocatorObjects;
import com.amc.txrepo.WOPEpisodeVersion;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class RecordLocatorTest extends TxBase {

	RecordLocatorObjects recordLocator;

	
	
	
	@Features("Edit Work Order")
	@Stories("Portal")	
	@Title("WOP to Portal Integration")	
	@Test
	
	public void recordSearchField() throws Throwable {
		
    if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}else {
		
		recordLocator = PageFactory.initElements(driverWOP, RecordLocatorObjects.class);
		
		recordLocator.recordLocatorSelection();
		
		recordLocator.recordSearchField();
	
		portalEpisodeVersionData("MAVersionType:"+"Version Type");
		
		recordLocator.portalMetaDataScreen("EditRestricted:","Edit Restricted");

		recordLocator.portalMetaDataScreen("SecurityStatus:","Security Status");
		
		recordLocator.portalMetaDataScreen("EpisodeVersionType:","Episode Version Type Code");
		
		recordLocator.portalMetaDataScreen("ExpectedSegments:","Expected Number of Segments");
		
		recordLocator.portalMetaDataScreen("ExpectedScanType:","Scan Type Expected");
		
		recordLocator.portalMetaDataScreen("ExpectedFrameRate:","Frame Rate Expected");
		
		recordLocator.portalMetaDataScreen("ExpectedAspectRatio:","Aspect Ratio Expected");

		recordLocator.portalMetaDataScreen("ExpectedVideoCodec:","Codec Expected");
		
		recordLocator.portalMetaDataScreen("ExpectedFormat:","Format Expected");
		
		recordLocator.portalMetaDataScreen("EstimatedTRT:","Expected TRT");
			
		recordLocator.portalMetaDataScreen("AMCNID:","AMCN ID");
		
		recordLocator.portalMetaDataScreen("MatID:","Material ID");
				
		recordLocator.portalMetaDataScreen("Supplier:","Supplier");
		
		recordLocator.portalMetaDataScreen("Ownernetwork:","Owner Network");
		
		recordLocator.portalMetaDataScreen("Distributor:","Distributor Production Company");
				
		portalEpisodeVersionData("AMCNIDVideo:"+TxBase.Mattextvalue+".video");
		
		portalEpisodeVersionData("AMCNIDAudio:"+TxBase.Mattextvalue+".1.English.OA");
		
		portalEpisodeVersionData("ExpectedLanguage:"+"English");
		
		portalEpisodeVersionData("ExpectedChannel1-2:"+"Stereo");
		
		
		
	}
    
	
	}
}
