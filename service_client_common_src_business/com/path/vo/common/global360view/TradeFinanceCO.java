/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: elieachkar
 * @date: May 12, 2014
 * TradeFinanceCO.java used to
 */
public class TradeFinanceCO extends RetailBaseVO
{
    private BigDecimal inOutLC;
    private BigDecimal lgs;
    private BigDecimal inOutBills;
    private BigDecimal acceptance;

    // Elie Achkar TFA new variables
    private BigDecimal impLcSum;
    private BigDecimal impLcOuts;
    private BigDecimal impLcAccept;
    private BigDecimal impLcSettled;
    private BigDecimal expLcSum;
    private BigDecimal expLcOuts;
    private BigDecimal expLcAccept;
    private BigDecimal expLcSettled;
    private BigDecimal lgOuts;
    private BigDecimal lgSettled;
    private BigDecimal expBillsSum;
    private BigDecimal expBillsOuts;
    private BigDecimal expBillsAccept;
    private BigDecimal expBillsSettled;
    private BigDecimal impBillsSum;
    private BigDecimal impBillsOuts;
    private BigDecimal impBillsAccept;
    private BigDecimal impBillsSettled;
    private BigDecimal decimal_points;
   

    /**
     * @return the inOutLC
     */
    public BigDecimal getInOutLC()
    {
        return inOutLC;
    }

    /**
     * @param inOutLC the inOutLC to set
     */
    public void setInOutLC(BigDecimal inOutLC)
    {
        this.inOutLC = inOutLC;
    }

    /**
     * @return the lgs
     */
    public BigDecimal getLgs()
    {
        return lgs;
    }

    /**
     * @param lgs the lgs to set
     */
    public void setLgs(BigDecimal lgs)
    {
        this.lgs = lgs;
    }

    /**
     * @return the inOutBills
     */
    public BigDecimal getInOutBills()
    {
        return inOutBills;
    }

    /**
     * @param inOutBills the inOutBills to set
     */
    public void setInOutBills(BigDecimal inOutBills)
    {
        this.inOutBills = inOutBills;
    }

    /**
     * @return the acceptance
     */
    public BigDecimal getAcceptance()
    {
        return acceptance;
    }

    /**
     * @param acceptance the acceptance to set
     */
    public void setAcceptance(BigDecimal acceptance)
    {
        this.acceptance = acceptance;
    }

    /**
     * @return the decimal_points
     */
    public BigDecimal getDecimal_points()
    {
        return decimal_points;
    }

    /**
     * @param decimalPoints the decimal_points to set
     */
    public void setDecimal_points(BigDecimal decimalPoints)
    {
        decimal_points = decimalPoints;
    }

    public BigDecimal getImpLcSum()
    {
        return impLcSum;
    }

    public void setImpLcSum(BigDecimal impLcSum)
    {
        this.impLcSum = impLcSum;
    }

    public BigDecimal getImpLcOuts()
    {
        return impLcOuts;
    }

    public void setImpLcOuts(BigDecimal impLcOuts)
    {
        this.impLcOuts = impLcOuts;
    }

    public BigDecimal getImpLcAccept()
    {
        return impLcAccept;
    }

    public void setImpLcAccept(BigDecimal impLcAccept)
    {
        this.impLcAccept = impLcAccept;
    }

    public BigDecimal getImpLcSettled()
    {
        return impLcSettled;
    }

    public void setImpLcSettled(BigDecimal impLcSettled)
    {
        this.impLcSettled = impLcSettled;
    }

    public BigDecimal getExpLcSum()
    {
        return expLcSum;
    }

    public void setExpLcSum(BigDecimal expLcSum)
    {
        this.expLcSum = expLcSum;
    }

    public BigDecimal getExpLcOuts()
    {
        return expLcOuts;
    }

    public void setExpLcOuts(BigDecimal expLcOuts)
    {
        this.expLcOuts = expLcOuts;
    }

    public BigDecimal getExpLcAccept()
    {
        return expLcAccept;
    }

    public void setExpLcAccept(BigDecimal expLcAccept)
    {
        this.expLcAccept = expLcAccept;
    }

    public BigDecimal getExpLcSettled()
    {
        return expLcSettled;
    }

    public void setExpLcSettled(BigDecimal expLcSettled)
    {
        this.expLcSettled = expLcSettled;
    }

    public BigDecimal getLgOuts()
    {
        return lgOuts;
    }

    public void setLgOuts(BigDecimal lgOuts)
    {
        this.lgOuts = lgOuts;
    }

    public BigDecimal getLgSettled()
    {
        return lgSettled;
    }

    public void setLgSettled(BigDecimal lgSettled)
    {
        this.lgSettled = lgSettled;
    }

    public BigDecimal getExpBillsSum()
    {
        return expBillsSum;
    }

    public void setExpBillsSum(BigDecimal expBillsSum)
    {
        this.expBillsSum = expBillsSum;
    }

    public BigDecimal getExpBillsOuts()
    {
        return expBillsOuts;
    }

    public void setExpBillsOuts(BigDecimal expBillsOuts)
    {
        this.expBillsOuts = expBillsOuts;
    }

    public BigDecimal getExpBillsAccept()
    {
        return expBillsAccept;
    }

    public void setExpBillsAccept(BigDecimal expBillsAccept)
    {
        this.expBillsAccept = expBillsAccept;
    }

    public BigDecimal getExpBillsSettled()
    {
        return expBillsSettled;
    }

    public void setExpBillsSettled(BigDecimal expBillsSettled)
    {
        this.expBillsSettled = expBillsSettled;
    }

    public BigDecimal getImpBillsSum()
    {
        return impBillsSum;
    }

    public void setImpBillsSum(BigDecimal impBillsSum)
    {
        this.impBillsSum = impBillsSum;
    }

    public BigDecimal getImpBillsOuts()
    {
        return impBillsOuts;
    }

    public void setImpBillsOuts(BigDecimal impBillsOuts)
    {
        this.impBillsOuts = impBillsOuts;
    }

    public BigDecimal getImpBillsAccept()
    {
        return impBillsAccept;
    }

    public void setImpBillsAccept(BigDecimal impBillsAccept)
    {
        this.impBillsAccept = impBillsAccept;
    }

    public BigDecimal getImpBillsSettled()
    {
        return impBillsSettled;
    }

    public void setImpBillsSettled(BigDecimal impBillsSettled)
    {
        this.impBillsSettled = impBillsSettled;
    }

}
