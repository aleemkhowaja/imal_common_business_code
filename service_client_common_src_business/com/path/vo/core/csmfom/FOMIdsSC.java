package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

 public class FOMIdsSC extends  GridParamsSC
 {
	private BigDecimal cifNo;
	private BigDecimal cifType;
	private BigDecimal lineNo;
	private String language;
	private BigDecimal idType;//TP260314
	private BigDecimal compCodeCif; // TP#505802
	private BigDecimal fromIdsButton; // TP#505802
	// added by nancy -SBI170061 - Pensioner Account
	private String fromScreenButton;
	// end nancy 
	private BigDecimal memberLineNo;

	private BigDecimal glCode;
	private BigDecimal currencyCode;
	private BigDecimal slNo;
	
        // Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
        private String fromWhere;
        private BigDecimal subLineNo;
        //

	public BigDecimal getLineNo()
	{
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo)
	{
		this.lineNo = lineNo;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public BigDecimal getCifNo()
	{
		return cifNo;
	}

	public void setCifNo(BigDecimal cifNo)
	{
		this.cifNo = cifNo;
	}

	public BigDecimal getCifType()
	{
		return cifType;
	}

	public void setCifType(BigDecimal cifType)
	{
		this.cifType = cifType;
	}

	public BigDecimal getIdType()
	{
	    return idType;
	}

	public void setIdType(BigDecimal idType)
	{
	    this.idType = idType;
	}
	
	public BigDecimal getFromIdsButton()
	{
	    return fromIdsButton;
	}

	public void setFromIdsButton(BigDecimal fromIdsButton)
	{
	    this.fromIdsButton = fromIdsButton;
	}

	public String getFromScreenButton()
	{
	    return fromScreenButton;
	}

	public void setFromScreenButton(String fromScreenButton)
	{
	    this.fromScreenButton = fromScreenButton;
	}

	public BigDecimal getMemberLineNo()
	{
	    return memberLineNo;
	}

	public void setMemberLineNo(BigDecimal memberLineNo)
	{
	    this.memberLineNo = memberLineNo;
	}

	

	public BigDecimal getGlCode()
	{
	    return glCode;
	}

	public void setGlCode(BigDecimal glCode)
	{
	    this.glCode = glCode;
	}

	public BigDecimal getCurrencyCode()
	{
	    return currencyCode;
	}

	public void setCurrencyCode(BigDecimal currencyCode)
	{
	    this.currencyCode = currencyCode;
	}

	public BigDecimal getSlNo()
	{
	    return slNo;
	}

	public void setSlNo(BigDecimal slNo)
	{
	    this.slNo = slNo;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}
	
	public String getFromWhere()
	{
	    return fromWhere;
	}

	public void setFromWhere(String fromWhere)
	{
	    this.fromWhere = fromWhere;
	}

	public BigDecimal getSubLineNo()
	{
	    return subLineNo;
	}

	public void setSubLineNo(BigDecimal subLineNo)
	{
	    this.subLineNo = subLineNo;
	}
 }
 