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
 * FOMReferencePrefixSC.java used to
 */
public class FOMReferencePrefixSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal trxType;
    private BigDecimal cyNum;
    private BigDecimal lineNo;
    
    
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
     * @return the cyNum
     */
    public BigDecimal getCyNum()
    {
        return cyNum;
    }

    /**
     * @param cyNum the cyNum to set
     */
    public void setCyNum(BigDecimal cyNum)
    {
        this.cyNum = cyNum;
    }

    /**
     * @return the lineNo
     */
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    /**
     * @param lineNo the lineNo to set
     */
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

}
