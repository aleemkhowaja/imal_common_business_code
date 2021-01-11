/**
 * 
 */
package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * AccPositionBlockedCO.java used to
 */
public class AccPositionBlockedCO extends BaseVO
{
    private CTSTRSVO ctstrsVO;
    private CTSTRXTYPEVO ctstrxtypeVO;
    private BigDecimal AMOUNT;
    private String statusDesc;
    private BigDecimal currencyDec;
    /**
     * @return the ctstrsVO
     */
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    /**
     * @param ctstrsVO the ctstrsVO to set
     */
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    /**
     * @return the ctstrxtypeVO
     */
    public CTSTRXTYPEVO getCtstrxtypeVO()
    {
        return ctstrxtypeVO;
    }
    /**
     * @param ctstrxtypeVO the ctstrxtypeVO to set
     */
    public void setCtstrxtypeVO(CTSTRXTYPEVO ctstrxtypeVO)
    {
        this.ctstrxtypeVO = ctstrxtypeVO;
    }
    /**
     * @return the aMOUNT
     */
    public BigDecimal getAMOUNT()
    {
        return AMOUNT;
    }
    /**
     * @param aMOUNT the aMOUNT to set
     */
    public void setAMOUNT(BigDecimal aMOUNT)
    {
        AMOUNT = aMOUNT;
    }
    /**
     * @return the statusDesc
     */
    public String getStatusDesc()
    {
        return statusDesc;
    }
    /**
     * @param statusDesc the statusDesc to set
     */
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    /**
     * @return the currencyDec
     */
    public BigDecimal getCurrencyDec()
    {
        return currencyDec;
    }
    /**
     * @param currencyDec the currencyDec to set
     */
    public void setCurrencyDec(BigDecimal currencyDec)
    {
        this.currencyDec = currencyDec;
    } 

}
