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
 * FOMPaymentChannelSC.java used to
 */
public class FOMPaymentChannelSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal trxType;
    private BigDecimal currency;

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    /**
     * @return the trxType
     */
    public BigDecimal getTrxType()
    {
        return trxType;
    }

    /**
     * @param trxType the trxType to set
     */
    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    /**
     * @return the currency
     */
    public BigDecimal getCurrency()
    {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(BigDecimal currency)
    {
        this.currency = currency;
    }
}
