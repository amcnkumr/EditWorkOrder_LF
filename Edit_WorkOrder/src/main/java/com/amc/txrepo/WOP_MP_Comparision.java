package com.amc.txrepo;



import com.amc.txbase.TxBase;

public class WOP_MP_Comparision extends TxBase{
	
	
	
	// Comparing WOP to MP Data Validations:
	
	public void WOPtoMPDataComparisions() {
		
		for(int i=0; i<TxBase.wopEpisodeVersionData.size(); i++) {
			
			for(int j=0; j<TxBase.mpEpisodeVersionData.size();j++) {
						
			if(TxBase.wopEpisodeVersionData.get(i).equalsIgnoreCase(TxBase.mpEpisodeVersionData.get(j))) {
				
				String wopEpisodeData = TxBase.wopEpisodeVersionData.get(i);
				
				String mpEpisodeData = TxBase.mpEpisodeVersionData.get(j);
													
			//logStep(String.format("WOP Data " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " ));
							
			logStep(String.format("WOP Data"+" [ " + wopEpisodeData + " ]"+" Matched With"+" MP Data"+" [ " + mpEpisodeData + " ] " ));
			
			//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " );
			
			System.out.println("WOP Data"+" [ " + wopEpisodeData + " ]"+" Matched With"+" MP Data"+" [ " + mpEpisodeData + " ] " );		
					
				}
			
			}
		
		}
	}
	
	
	
	
	

}
