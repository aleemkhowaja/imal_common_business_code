/**
 * 
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees/anish
 *
 * FomTrxTypeLimitsSC.java used to
 */
@SuppressWarnings("serial")
public class FomTrxTypelimitAddFieldsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal trxType;
    private BigDecimal cy;
    /**
     * @return the cifNo
     */
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    /**
     * @param cifNo the cifNo to set
     */
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
     * @return the cy
     */
    public BigDecimal getCy()
    {
        return cy;
    }
    /**
     * @param cy the cy to set
     */
    public void setCy(BigDecimal cy)
    {
        this.cy = cy;
    }
}
