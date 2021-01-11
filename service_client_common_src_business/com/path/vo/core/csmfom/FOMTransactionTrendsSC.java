package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * FOMTransactionTrendsSC.java used to
 */
public class FOMTransactionTrendsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private BigDecimal lovType;
    private String langCode;
    private BigDecimal compCodeCif;//EWBI160091 (403157)- Modification of CIF

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

	public BigDecimal getLovType()
	{
		return lovType;
	}

	public void setLovType(BigDecimal lovType)
	{
		this.lovType = lovType;
	}

	public String getLangCode()
	{
		return langCode;
	}

	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	
	
    
}
