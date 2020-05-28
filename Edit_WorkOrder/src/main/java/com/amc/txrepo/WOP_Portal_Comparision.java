package com.amc.txrepo;



import com.amc.txbase.TxBase;

public class WOP_Portal_Comparision extends TxBase{
	
	
	
	// Comparing WOP to MP Data Validations:
	
	public void WOPtoPortalDataComparisions() {
		
		for(int i=0; i<TxBase.wopEpisodeVersionData.size(); i++) {
			
			for(int j=0; j<TxBase.portalEpisodeVersionData.size();j++) {
						
			if(TxBase.wopEpisodeVersionData.get(i).equalsIgnoreCase(TxBase.portalEpisodeVersionData.get(j))) {
				
				String wopEpisodeData = TxBase.wopEpisodeVersionData.get(i);
				
				String portalEpisodeData = TxBase.portalEpisodeVersionData.get(j);
													
			//logStep(String.format("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " Portal Episode Version Data " + " [ " + portalEpisodeData + " ] " ));
			
			logStep(String.format("WOP Data"+" [ " + wopEpisodeData + " ]"+" Matched With"+" Portal Data"+" [ " + portalEpisodeData + " ] " ));		
			
			//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " Portal Episode Version Data " + " [ " + portalEpisodeData + " ] " );
				
			System.out.println("WOP Data"+" [ " + wopEpisodeData + " ]"+" Matched With"+" Portal Data"+" [ " + portalEpisodeData + " ] " );		

					
				}
			
			}
		
		}
	}
	
	
	
	
	

}
