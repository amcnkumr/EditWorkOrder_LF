package com.amc.txrepo;

import com.amc.txbase.TxBase;

public class WOPToMPGeneralEditWorkOrderComparison extends TxBase {
	
	
	
	// Comparing WOPtoMP General EditWork Order Validations:
	
		public void WOPtoMPGeneralEditWorkOrderComparisions() {
			
		logStep("General Edit Work Order Integration is succes:"+ TxBase.GeneralSourceAsset);
			
			for(int i=0; i<TxBase.WOPGeneralEditWork.size(); i++) {
				
				for(int j=0; j<TxBase.MPGeneralEditWork.size();j++) {
							
				if(TxBase.WOPGeneralEditWork.get(i).equalsIgnoreCase(TxBase.MPGeneralEditWork.get(j))) {
					
					String wopGeneralEdit = TxBase.WOPGeneralEditWork.get(i);
					
					String mpGeneralEdit = TxBase.MPGeneralEditWork.get(j);
														
				//logStep(String.format("WOP Data " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " ));
								
				logStep(String.format("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" MP General Edit Work Order"+" [ " + mpGeneralEdit + " ] " ));
				
				//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " );
				
				System.out.println("WOP General Edit Work Order"+" [ " + wopGeneralEdit + " ]"+" Matched With"+" MP General Edit Work Order"+" [ " + mpGeneralEdit + " ] " );		
						
					}
				
				}
			
			}
		}
		
	
	

}
