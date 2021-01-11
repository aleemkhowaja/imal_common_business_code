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
 * FomBillTypeSC.java used to
 */
public class FomBillTypeSC  extends  GridParamsSC
{
    private BigDecimal cifCode;
    private String language;
    private BigDecimal billTypeCode;
    private BigDecimal trxTypeCode;
    private BigDecimal cyCode;
    
    public BigDecimal getBillTypeCode()
    {
        return billTypeCode;
    }

    public void setBillTypeCode(BigDecimal billTypeCode)
    {
        this.billTypeCode = billTypeCode;
    }
    
    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

	public BigDecimal getCifCode()
	{
		return cifCode;
	}

	public void setCifCode(BigDecimal cifCode)
	{
		this.cifCode = cifCode;
	}

	public BigDecimal getTrxTypeCode()
	{
		return trxTypeCode;
	}

	public void setTrxTypeCode(BigDecimal trxTypeCode)
	{
		this.trxTypeCode = trxTypeCode;
	}

	public BigDecimal getCyCode()
	{
		return cyCode;
	}

	public void setCyCode(BigDecimal cyCode)
	{
		this.cyCode = cyCode;
	}


 

    


}
