package com.path.actions.common.trxtypecharges;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * ChargesSchemaCommonAction.java used to
 */
public class ChargesSchemaCommonAction extends RetailBaseAction
{
	 private ChargesSchemaBO chargesSchemaBO;
	 private CTSCHARGES_SCHEMAVO chargesSchemaVO;
	 private CTSCHARGESVO ctsChargesVO;
	 private CTSChargesCO ctsChargesCO;
	 private ChargesSchemaSC criteria = new ChargesSchemaSC();
	 private BigDecimal schemaCode;
	 private Boolean profitCharge;
	 private Boolean passChargesSeperately;
	 private Boolean _popupReadOnlyMode = false;
	 private Map<String, String> chargeType;
	 private Map<String, String> chargeBranch;
	 private Map<String, String> dr_criteria;	 
	 
	 
	public String  loadChargesSchemaDetail()
    {
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setCode(schemaCode);
			chargesSchemaVO = chargesSchemaBO.returnChargesSchemaDetailByCode(criteria);
			if(chargesSchemaVO !=null)
			{
				setProfitCharge("1".equalsIgnoreCase(chargesSchemaVO.getPROFIT_CHARGE()) ? true : false);
				setPassChargesSeperately("1".equalsIgnoreCase(chargesSchemaVO.getPASS_CHRG_SEP_FRM_TVA()) ? true : false);
			}
			
			set_popupReadOnlyMode(true);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return "showChargesSchemaCommonPage";
    }
	
	public String  loadChargesDetail()
    {
		try
		{
			BigDecimal hide = BigDecimal.ZERO; // false
			BigDecimal show = BigDecimal.ONE; // true
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setCurrencyCode(sessionCO.getBaseCurrencyCode());
			criteria.setCode(schemaCode);
			ctsChargesCO = chargesSchemaBO.returnChargesDetailByCode(criteria);	
			
			// Hide/Show Foreign CY Charge button
			PTH_CTRLVO pthCtrlVO = returnCommonLibBO().returnPthCtrl();
			if("A".equalsIgnoreCase(pthCtrlVO.getCHARGES_BOOKING()))
			{
//				SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//	            buisnessElement.setIS_VISIBLE(show);
//				buisnessElement.setELEMENT_NAME("fom_foreignCYChargeGridDiv");//cb_charge_cy
//		    	getAdditionalScreenParams().put("fom_foreignCYChargeGridDiv",buisnessElement);//cb_charge_cy
		    	ctsChargesCO.setShowFyChargesGrid(true);
			}
			else
			{
//				SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//	            buisnessElement.setIS_VISIBLE(hide);
//				buisnessElement.setELEMENT_NAME("fom_foreignCYChargeGridDiv");//cb_charge_cy
//		    	getAdditionalScreenParams().put("fom_foreignCYChargeGridDiv",buisnessElement);//cb_charge_cy
		    	ctsChargesCO.setShowFyChargesGrid(false);
			}
			if(ctsChargesCO!=null)
			{
				if("Y".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getCHRG_ON_EXCEED()))
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_EXCEED_AMT");
			    	getAdditionalScreenParams().put("ctsChargesVO_EXCEED_AMT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_CHRG_PERCENTAGE");
			    	getAdditionalScreenParams().put("ctsChargesVO_CHRG_PERCENTAGE",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_MIN_AMT");
			    	getAdditionalScreenParams().put("ctsChargesVO_MIN_AMT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_MAX");
			    	getAdditionalScreenParams().put("ctsChargesVO_MAX",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_AMOUNT");
			    	getAdditionalScreenParams().put("ctsChargesVO_AMOUNT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesCO_CY_NAME");
			    	getAdditionalScreenParams().put("ctsChargesCO_CY_NAME",buisnessElement);
			    	
//			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//		            buisnessElement.setIS_VISIBLE(hide);
//		            buisnessElement.setELEMENT_NAME("fom_tiresdetailsGridDiv");//b_detail_Tiers
//			    	getAdditionalScreenParams().put("fom_tiresdetailsGridDiv",buisnessElement);//b_detail_Tiers
			    	ctsChargesCO.setShowTiersGrid(false);
			    }
				else
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_EXCEED_AMT");
			    	getAdditionalScreenParams().put("ctsChargesVO_EXCEED_AMT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_CHRG_PERCENTAGE");
			    	getAdditionalScreenParams().put("ctsChargesVO_CHRG_PERCENTAGE",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_MIN_AMT");
			    	getAdditionalScreenParams().put("ctsChargesVO_MIN_AMT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_MAX");
			    	getAdditionalScreenParams().put("ctsChargesVO_MAX",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_AMOUNT");
			    	getAdditionalScreenParams().put("ctsChargesVO_AMOUNT",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesCO_CY_NAME");
			    	getAdditionalScreenParams().put("ctsChargesCO_CY_NAME",buisnessElement);
			    	
//			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//		            buisnessElement.setIS_VISIBLE(show);
//		            buisnessElement.setELEMENT_NAME("fom_tiresdetailsGridDiv");//b_detail_Tiers
//			    	getAdditionalScreenParams().put("fom_tiresdetailsGridDiv",buisnessElement);//b_detail_Tiers
			    	ctsChargesCO.setShowTiersGrid(true);
			    }
				
				if("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getAPPLY_TVA()))
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_VAT_CODE");
			    	getAdditionalScreenParams().put("ctsChargesVO_VAT_CODE",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("VAT_DESC");
			    	getAdditionalScreenParams().put("VAT_DESC",buisnessElement);
				}
				else
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_VAT_CODE");
			    	getAdditionalScreenParams().put("ctsChargesVO_VAT_CODE",buisnessElement);
			    	
			    	buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("VAT_DESC");
			    	getAdditionalScreenParams().put("VAT_DESC",buisnessElement);
				}
				
				if("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getPASS_SEPARATELY()))
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_DR_CRITERIA");
			    	getAdditionalScreenParams().put("ctsChargesVO_DR_CRITERIA",buisnessElement);
			    }
				else
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_DR_CRITERIA");
			    	getAdditionalScreenParams().put("ctsChargesVO_DR_CRITERIA",buisnessElement);
			    }
				
				
				if("3".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getCHRG_BR()))
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(show);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_ACC_BR");
			    	getAdditionalScreenParams().put("ctsChargesVO_ACC_BR",buisnessElement);
			    }
				else
				{
					SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		            buisnessElement.setIS_VISIBLE(hide);
		            buisnessElement.setELEMENT_NAME("ctsChargesVO_ACC_BR");
			    	getAdditionalScreenParams().put("ctsChargesVO_ACC_BR",buisnessElement);
			    }
				
				
				 // check box
				ctsChargesCO.setAllowModifyClear("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getALLOW_CLEARING()) ? true : false);
				ctsChargesCO.setAllowModify("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getALLOW_MODIFY()) ? true : false);
				ctsChargesCO.setDeductFromTrx("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getDEDUCT_FROM_TRX()) ? true : false);
				ctsChargesCO.setFixChkBookCharge("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getFIX_CHARGES()) ? true : false);
				ctsChargesCO.setConsiderOnceMultiTran("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getCONSIDER_ONCE_FOR_MULTI_TRX()) ? true : false);
				ctsChargesCO.setChargeExceedAmt("Y".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getCHRG_ON_EXCEED()) ? true : false);
				ctsChargesCO.setBasedOnMosarafa("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getBASED_ON_MOSARAFA()) ? true : false);
				ctsChargesCO.setPassSeperately("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getPASS_SEPARATELY()) ? true : false);
				ctsChargesCO.setApplyVat("1".equalsIgnoreCase(ctsChargesCO.getCtsChargesVO().getAPPLY_TVA()) ? true : false);
				
			}
			
			SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
            buisnessElement.setIS_VISIBLE(hide);
            buisnessElement.setELEMENT_NAME("ctsChargesVO_DEDUCT_FROM_TRX");
	    	getAdditionalScreenParams().put("ctsChargesVO_DEDUCT_FROM_TRX",buisnessElement);
			
			
			
			
			loadChargeBranchDropDown();
			loadChargeTypeDropDown();			
			loadCriteriaDropDown();
			set_popupReadOnlyMode(true);
			 

		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return "showMaintenenceChargesCommonPage";
    }

	@SuppressWarnings("unchecked")
    private void loadChargeTypeDropDown()
    {
		try
		{
		    SelectSC selSC = new SelectSC(new BigDecimal(103));
		    List<SelectCO> selCOs = returnLOV(selSC);
		    chargeType = new HashMap<String, String>();
		    for(SelectCO selectCO : selCOs)
		    {
		    	chargeType.put(selectCO.getCode(), selectCO.getDescValue());
		    }
		}
	catch(BaseException e)
	{
	    e.printStackTrace();
	}

    }
	
	@SuppressWarnings("unchecked")
    private void loadChargeBranchDropDown()
    {
		try
		{
		    SelectSC selSC = new SelectSC(new BigDecimal(104));
		    List<SelectCO> selCOs = returnLOV(selSC);
		    chargeBranch = new HashMap<String, String>();
		    for(SelectCO selectCO : selCOs)
		    {
		    	chargeBranch.put(selectCO.getCode(), selectCO.getDescValue());
		    }
		}
	catch(BaseException e)
	{
	    e.printStackTrace();
	}

    }
	
	@SuppressWarnings("unchecked")
    private void loadCriteriaDropDown()
    {
		try
		{
		    SelectSC selSC = new SelectSC(new BigDecimal(105));
		    List<SelectCO> selCOs = returnLOV(selSC);
		    dr_criteria = new HashMap<String, String>();
		    for(SelectCO selectCO : selCOs)
		    {
		    	dr_criteria.put(selectCO.getCode(), selectCO.getDescValue());
		    }
		}
	catch(BaseException e)
	{
	    e.printStackTrace();
	}

    }



	public void setChargesSchemaBO(ChargesSchemaBO chargesSchemaBO)
	{
		this.chargesSchemaBO = chargesSchemaBO;
	}

	public CTSCHARGES_SCHEMAVO getChargesSchemaVO()
	{
		return chargesSchemaVO;
	}

	public void setChargesSchemaVO(CTSCHARGES_SCHEMAVO chargesSchemaVO)
	{
		this.chargesSchemaVO = chargesSchemaVO;
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

	public Boolean getPassChargesSeperately()
	{
		return passChargesSeperately;
	}

	public void setPassChargesSeperately(Boolean passChargesSeperately)
	{
		this.passChargesSeperately = passChargesSeperately;
	}

	public Boolean getProfitCharge()
	{
		return profitCharge;
	}

	public void setProfitCharge(Boolean profitCharge)
	{
		this.profitCharge = profitCharge;
	}

	public Boolean get_popupReadOnlyMode() {
		return _popupReadOnlyMode;
	}

	public void set_popupReadOnlyMode(Boolean popupReadOnlyMode) {
		_popupReadOnlyMode = popupReadOnlyMode;
	}

	public CTSCHARGESVO getCtsChargesVO() {
		return ctsChargesVO;
	}

	public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO) {
		this.ctsChargesVO = ctsChargesVO;
	}

	public CTSChargesCO getCtsChargesCO() {
		return ctsChargesCO;
	}

	public void setCtsChargesCO(CTSChargesCO ctsChargesCO) {
		this.ctsChargesCO = ctsChargesCO;
	}

	public Map<String, String> getChargeType() {
		return chargeType;
	}

	public void setChargeType(Map<String, String> chargeType) {
		this.chargeType = chargeType;
	}

	public Map<String, String> getChargeBranch() {
		return chargeBranch;
	}

	public void setChargeBranch(Map<String, String> chargeBranch) {
		this.chargeBranch = chargeBranch;
	}

	public Map<String, String> getDr_criteria() {
		return dr_criteria;
	}

	public void setDr_criteria(Map<String, String> drCriteria) {
		dr_criteria = drCriteria;
	}
	 
	
}
