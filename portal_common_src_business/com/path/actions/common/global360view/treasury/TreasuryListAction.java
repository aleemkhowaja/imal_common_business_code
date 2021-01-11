package com.path.actions.common.global360view.treasury;

import com.path.bo.common.global360view.treasury.TreasuryBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.TreasurySC;

@SuppressWarnings("serial")
public class TreasuryListAction extends GridBaseAction {
	
	
	
	private TreasuryBO treasuryBO;
	private TreasurySC treasurySC =  new TreasurySC();



	public String loadTreasuryDerivativesData()
	{	
		try
		{	
			String[] searchCol = {"currencyDesc" , "profitRateSwap","promissoryFX","crossCYSwap"};
			SessionCO  sessionCO   =  returnSessionObject();
			treasurySC.setCompCode(sessionCO.getCompanyCode());
			treasurySC.setBranchCode(sessionCO.getBranchCode());
			treasurySC.setRunningDate(sessionCO.getRunningDateRET());
	        treasurySC.setSearchCols(searchCol);	        
			copyproperties(treasurySC);   		
			setGridModel(treasuryBO.getTreasuryDerivativesDetails(treasurySC));    	
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in Treasury derivatives grid");
			handleException(e, null, null);
		}
		return SUCCESS;		
	}
	
	
	public String loadTreasuryDerivativesGrid(){		
		return "treasuryDerivativesList";
	}
	
 
	public void setTreasuryBO(TreasuryBO treasuryBO) {
		this.treasuryBO = treasuryBO;
	}


	public TreasurySC getTreasurySC() {
		return treasurySC;
	}


	public void setTreasurySC(TreasurySC treasurySC) {
		this.treasurySC = treasurySC;
	}
	
	public Object getModel(){
		return treasurySC;
	}
}
