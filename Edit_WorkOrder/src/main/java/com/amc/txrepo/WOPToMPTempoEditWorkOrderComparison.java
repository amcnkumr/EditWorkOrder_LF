package com.amc.txrepo;

import com.amc.txbase.TxBase;

public class WOPToMPTempoEditWorkOrderComparison extends TxBase {
	
	
	
	// Comparing WOPtoMP Tempo EditWork Order Validations:
	
		public void WOPtoMPTempoEditWorkOrderComparisions() {
			
			logStep("Tempo Edit Work Order Integration is succes:"+ TxBase.TempoSourceAsset);
			
			for(int i=0; i<TxBase.WOPTempoEditWork.size(); i++) {
				
				for(int j=0; j<TxBase.MPTempoEditWork.size();j++) {
							
				if(TxBase.WOPTempoEditWork.get(i).equalsIgnoreCase(TxBase.MPTempoEditWork.get(j))) {
					
					String wopTempoEdit = TxBase.WOPTempoEditWork.get(i);
					
					String mpTempoEdit = TxBase.MPTempoEditWork.get(j);
														
				//logStep(String.format("WOP Data " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " ));
								
				logStep(String.format("WOP Tempo Edit Work Order"+" [ " + wopTempoEdit + " ]"+" Matched With"+" MP Tempo Edit Work Order"+" [ " + mpTempoEdit + " ] " ));
				
				//System.out.println("WOP Episode Version Data  " + " [ " + wopEpisodeData + " ] " + " is Matched With " + " MP Episode Version Data " + " [ " + mpEpisodeData + " ] " );
				
				System.out.println("WOP Tempo Edit Work Order"+" [ " + wopTempoEdit + " ]"+" Matched With"+" MP Tempo Edit Work Order"+" [ " + mpTempoEdit + " ] " );		
						
					}
				
				}
			
			}
		}
		
	
	

}
