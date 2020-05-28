package com.amc.Testclasess.execute;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txrepo.WOPEpisodeVersion;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;



public class WOPEpisodeVersionTest extends TxBase {
	
	WOPEpisodeVersion productBrowser;
	
	
	
	@Features("Edit Work Order")

	@Stories("WOP")

	@Title("WOP Episode version Creation")
	
	@Test	
	public void wopEpisodeVersionCreation() throws java.lang.Exception {
				
		Thread.sleep(2000);
		
		productBrowser = PageFactory.initElements(driverWOP, WOPEpisodeVersion.class);
		
		productBrowser.EpisodeVersionCreation();
		
		productBrowser.MediaAssetLinking();
		
		productBrowser.wopSourceData();
	
	}
	
	
	 
	}	
		 
		 
	 
	 
	 
	 

