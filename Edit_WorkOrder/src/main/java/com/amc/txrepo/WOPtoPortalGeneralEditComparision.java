package com.amc.txrepo;

import com.amc.txbase.TxBase;

public class WOPtoPortalGeneralEditComparision extends TxBase{
	

	
	
	
	// Comparing WOPtoPortal General EditWork Order Validations:
	
		public void WOPtoMPPortalGeneralEditWorkOrderComparisions() {
			
	
			for(int i=0; i<TxBase.WOPGeneralEditWork.size(); i++) {
				
				for(int j=0; j<TxBase.portalGeneralEditWork.size();j++) {
							
				if(TxBase.WOPGeneralEditWork.get(i).equalsIgnoreCase(TxBase.portalGeneralEditWork.get(j))) {
					
					String wopGeneralEdit = TxBase.WOPGeneralEditWork.get(i);
					
					String portalGeneralEdit = TxBase.portalGeneralEditWork.get(j);
														
				//logStep(String.format("WOP Data " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " ));
								
				logStep(String.format("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" Portal General Edit Work Order"+" [ " + portalGeneralEdit + " ] " ));
				
				//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " );
				
				System.out.println("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" Portal General Edit Work Order"+" [ " + portalGeneralEdit + " ] " );		
						
					}
				
				}
			
			}
		}
		
	
	


	
	

}
