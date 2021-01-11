package com.path.vo.common.trxtypecharges;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxTypeChargesCommonSC extends GridParamsSC
{
	private BigDecimal cifNo;
	private BigDecimal lineNo;
	//added by jihad	
	private String entityType;
	//
	private String     langCode;
	private BigDecimal policyLovType;
	private BigDecimal cashAccLovType;
	private BigDecimal compCodeCif;
	
	public BigDecimal getLineNo()
	{
		return lineNo;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public void setLineNo(BigDecimal lineNo)
	{
		this.lineNo = lineNo;
	}

	public BigDecimal getCifNo()
	{
		return cifNo;
	}

	public void setCifNo(BigDecimal cifNo)
	{
		this.cifNo = cifNo;
	}

	public String getLangCode()
	{
		return langCode;
	}

	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}

	public BigDecimal getPolicyLovType()
	{
		return policyLovType;
	}

	public void setPolicyLovType(BigDecimal policyLovType)
	{
		this.policyLovType = policyLovType;
	}

	public BigDecimal getCashAccLovType()
	{
		return cashAccLovType;
	}

	public void setCashAccLovType(BigDecimal cashAccLovType)
	{
		this.cashAccLovType = cashAccLovType;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}

}
