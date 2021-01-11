package com.path.vo.core.ctsclearinghouse;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseSC.java used to
 */
public class CtsClearingHouseSC extends GridParamsSC
{
    private BigDecimal currencyCode;
    private BigDecimal clearingHouseCode;
    
    public BigDecimal getClearingHouseCode()
    {
        return clearingHouseCode;
    }

    public void setClearingHouseCode(BigDecimal clearingHouseCode)
    {
        this.clearingHouseCode = clearingHouseCode;
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
