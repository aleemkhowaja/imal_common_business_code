package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.charges.ChargesBO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.charges.ChargesSC;

public class ChargesDependencyAction extends RetailBaseAction{
	
	private ChargesBO chargesBO;	
	private TRSCHARGESVO chargesVO;	
	private BigDecimal  CODE; 
	ChargesSC chargesSC = new ChargesSC();
	public String dependancyByCharges()
	{
		try 
		{
			SessionCO sessionCO = returnSessionObject();
			chargesSC.setCompCode(sessionCO.getCompanyCode());
			chargesSC.setBranchCode(sessionCO.getBranchCode());
			chargesVO = chargesBO.returnChargesById(chargesSC);
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in DependancyByChargeCode method of ChargeCode");
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	

	public void setChargesBO(ChargesBO chargesBO) {
		this.chargesBO = chargesBO;
	}

	public TRSCHARGESVO getChargesVO() {
		return chargesVO;
	}

	public void setChargesVO(TRSCHARGESVO chargesVO) {
		this.chargesVO = chargesVO;
	}

	public BigDecimal getCODE() {
		return CODE;
	}

	public void setCODE(BigDecimal cODE) {
		CODE = cODE;
	}


	public ChargesSC getChargesSC() {
		return chargesSC;
	}


	public void setChargesSC(ChargesSC chargesSC) {
		this.chargesSC = chargesSC;
	}




	
	
	
	
		

}
