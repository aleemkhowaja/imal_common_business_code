package com.path.actions.common.trxtypecharges;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.dbmaps.vo.CTSCHARGES_ROSTERVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCurrencyCO;
import com.path.vo.core.csmfom.CTSChargesExemptedBranchCO;

public class MaintenenceChargesGridAction extends GridBaseAction
{
	 private ChargesSchemaBO chargesSchemaBO;
	 private ChargesSchemaSC criteria = new ChargesSchemaSC();
	 private BigDecimal schemaCode;	
	 private List chargeTypeList = new ArrayList<SelectCO>();
	 
	public String loadTireDetailsGrid()
    {
		try
		{
			
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			//criteria.setCode(new BigDecimal(100));//temp entry
			//criteria.setCurrencyCode(new BigDecimal(1));//temp entry
		    copyproperties(criteria);		    
		    if(checkNbRec(criteria))
		    {
			setRecords(chargesSchemaBO.maintenenceChargesListCount(criteria));
		    }
		    List<CTSCHARGES_ROSTERVO> maintenenceChargesVOList = chargesSchemaBO.maintenenceChargesList(criteria);
		    setGridModel(maintenenceChargesVOList);
		}
		catch(Exception ex)
		{	
			handleException(ex, null, null);
		}
		
		return "success";
    }
	
	
	public String loadExcemptedInBranchesGrid()
    {
		try
		{
			SessionCO sessionCO = returnSessionObject();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    copyproperties(criteria);		    
		    if(checkNbRec(criteria))
		    {
			setRecords(chargesSchemaBO.excemptedInBranchesListCount(criteria));
		    }
		    List<CTSChargesExemptedBranchCO> excemptedInBranchesVOList = chargesSchemaBO.excemptedInBranchesList(criteria);
		    setGridModel(excemptedInBranchesVOList);
		}
		catch(Exception ex)
		{			
		    handleException(ex, null, null);
		}
		
		return "success";
    }

	 public String populateForeignChargesTierPopup()
	 {
	     return "ForeignChargesTierGrid";
	 }
	
	public String loadForeignCYChargeGrid()
    {
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			//criteria.setCode(new BigDecimal(123));//temp entry
		    copyproperties(criteria);		    
		    if(checkNbRec(criteria))
		    {
			setRecords(chargesSchemaBO.chargesSchemaForeignCYChargeListCount(criteria));
		    }
		    List<CTSChargesCurrencyCO> chargesCurrencyCOList = chargesSchemaBO.chargesSchemaForeignCYChargeList(criteria);
		    if(chargesCurrencyCOList != null && !chargesCurrencyCOList.isEmpty())
		    {
		    	for(CTSChargesCurrencyCO cyCO:chargesCurrencyCOList)
		    	{
		    		BigDecimal currDecPoint = cyCO.getCurrencyVO().getDECIMAL_POINTS();
		    		cyCO.setAmtFormat(currDecPoint);
		    	}
		    }
		    
		    setGridModel(chargesCurrencyCOList);
		}
		catch(Exception ex)
		{	
			handleException(ex, null, null);
		}
		
		return "success";
    }
	
    public String loadChargeType() 
    {
		try 
		{
			SelectSC selSC = new SelectSC(new BigDecimal(88)); // 88
			chargeTypeList = returnLOV(selSC);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public void setChargesSchemaBO(ChargesSchemaBO chargesSchemaBO)
	{
		this.chargesSchemaBO = chargesSchemaBO;
	}


	public ChargesSchemaSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ChargesSchemaSC criteria)
	{
		this.criteria = criteria;
	}

	public BigDecimal getSchemaCode()
	{
		return schemaCode;
	}

	public void setSchemaCode(BigDecimal schemaCode)
	{
		this.schemaCode = schemaCode;
	}

	public List getChargeTypeList() {
		return chargeTypeList;
	}

	public void setChargeTypeList(List chargeTypeList) {
		this.chargeTypeList = chargeTypeList;
	}


//	public BigDecimal getCurrencyCode() {
//		return currencyCode;
//	}
//
//
//	public void setCurrencyCode(BigDecimal currencyCode) {
//		this.currencyCode = currencyCode;
//	}


	 
	
}
