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
 * FOMCifClearingHouseSC.java used to
 */
public class FOMCifClearingHouseSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal compCode ;
    private BigDecimal clearingHouse ;
    private BigDecimal currencyCode ;

    
    public BigDecimal getCompCode() 
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode) 
    {
	this.compCode = compCode;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public BigDecimal getClearingHouse()
    {
        return clearingHouse;
    }

    public void setClearingHouse(BigDecimal clearingHouse)
    {
        this.clearingHouse = clearingHouse;
    }

    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    
    
    
    
}
