package com.path.vo.common.reasoncharges;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ReasonChargesCommonSC extends GridParamsSC
{
	private BigDecimal cifNo;
	private BigDecimal ciftype;
	private BigDecimal lineNo;
	private String showCharge;
	private String screenName;
	private String entityType;
	private BigDecimal compCodeCif;
	
	
	public String getShowCharge() {
		return showCharge;
	}

	public void setShowCharge(String showCharge) {
		this.showCharge = showCharge;
	}

	public BigDecimal getLineNo()
	{
		return lineNo;
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

	public BigDecimal getCiftype()
	{
		return ciftype;
	}

	public void setCiftype(BigDecimal ciftype)
	{
		this.ciftype = ciftype;
	}

	public String getScreenName()
	{
		return screenName;
	}

	public void setScreenName(String screenName)
	{
		this.screenName = screenName;
	}

	public String getEntityType()
	{
	    return entityType;
	}

	public void setEntityType(String entityType)
	{
	    this.entityType = entityType;
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
