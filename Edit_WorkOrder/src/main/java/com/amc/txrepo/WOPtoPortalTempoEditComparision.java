package com.amc.txrepo;

import com.amc.txbase.TxBase;

public class WOPtoPortalTempoEditComparision extends TxBase{
	

	
	
	
	// Comparing WOPtoPortal General EditWork Order Validations:
	
		public void WOPtoMPPortalTempoEditWorkOrderComparisions() {
			
	
			for(int i=0; i<TxBase.WOPGeneralEditWork.size(); i++) {
				
				for(int j=0; j<TxBase.portalTempoEditWork.size();j++) {
							
				if(TxBase.WOPGeneralEditWork.get(i).equalsIgnoreCase(TxBase.portalTempoEditWork.get(j))) {
					
					String wopGeneralEdit = TxBase.WOPGeneralEditWork.get(i);
					
					String portalTempo = TxBase.portalTempoEditWork.get(j);
														
				//logStep(String.format("WOP Data " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " ));
								
				logStep(String.format("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" Portal Tempo Edit Work Order"+" [ " + portalTempo + " ] " ));
				
				//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " );
				
				System.out.println("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" Portal Tempo Edit Work Order"+" [ " + portalTempo + " ] " );		
						
					}
				
				}
			
			}
		}
		
	
	


	
	

}
