package com.amc.Testclasess.execute;



import java.util.ArrayList;



import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
public class DryRun extends TxBase {
	
	public static String  Execution="Pass";
	
public static ArrayList<String> one = new ArrayList<String>();
	
	public static ArrayList<String> two = new ArrayList<String>();
	
	public static String value;
	
	
	@Test
	public void dryRun() throws java.lang.Exception {
		
		String MPEpisodeNumber = "Pictures\\WopImages\\MPEpisodeNumber.PNG";
		
		imagecopyText(MPEpisodeNumber,10);
			
		String  mpEpisodeNumber= "EpisodeNumber:"; 
			
		mpEpisodeVersionData(mpEpisodeNumber);
		
		
	}
		
}