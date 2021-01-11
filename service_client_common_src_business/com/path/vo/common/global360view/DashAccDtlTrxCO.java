/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashAccDtlTrxCO.java used to
 */
public class DashAccDtlTrxCO extends RetailBaseVO
{
    private BigDecimal trx_branch;
    private BigDecimal trx_no;
    private String     trx_desc;
    private String     trx_status;
    private Date       trade_date;
    private Date       value_date;
    private BigDecimal amount;
    private BigDecimal cvAmount;
    private String     voidReason;
    
    private BigDecimal branchCode;
    private BigDecimal glCode;
    private BigDecimal currencyCode;
    private BigDecimal slNo;
    private BigDecimal decimal_points;
    private BigDecimal cv_decimal_points;
    private CTSTRSVO ctstrsVO = new CTSTRSVO();
    
    /**
     * @return the trx_branch
     */
    public BigDecimal getTrx_branch()
    {
        return trx_branch;
    }
    /**
     * @param trxBranch the trx_branch to set
     */
    public void setTrx_branch(BigDecimal trxBranch)
    {
        trx_branch = trxBranch;
    }
    /**
     * @return the trx_no
     */
    public BigDecimal getTrx_no()
    {
        return trx_no;
    }
    /**
     * @param trxNo the trx_no to set
     */
    public void setTrx_no(BigDecimal trxNo)
    {
        trx_no = trxNo;
    }
    /**
     * @return the trx_desc
     */
    public String getTrx_desc()
    {
        return trx_desc;
    }
    /**
     * @param trxDesc the trx_desc to set
     */
    public void setTrx_desc(String trxDesc)
    {
        trx_desc = trxDesc;
    }
    /**
     * @return the trx_status
     */
    public String getTrx_status()
    {
        return trx_status;
    }
    /**
     * @param trxStatus the trx_status to set
     */
    public void setTrx_status(String trxStatus)
    {
        trx_status = trxStatus;
    }
    /**
     * @return the trade_date
     */
    public Date getTrade_date()
    {
        return trade_date;
    }
    /**
     * @param tradeDate the trade_date to set
     */
    public void setTrade_date(Date tradeDate)
    {
        trade_date = tradeDate;
    }
    /**
     * @return the value_date
     */
    public Date getValue_date()
    {
        return value_date;
    }
    /**
     * @param valueDate the value_date to set
     */
    public void setValue_date(Date valueDate)
    {
        value_date = valueDate;
    }
    /**
     * @return the voidReason
     */
    public String getVoidReason()
    {
        return voidReason;
    }
    /**
     * @param voidReason the voidReason to set
     */
    public void setVoidReason(String voidReason)
    {
        this.voidReason = voidReason;
    }
    /**
     * @return the branchCode
     */
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    /**
     * @return the glCode
     */
    public BigDecimal getGlCode()
    {
        return glCode;
    }
    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }
    /**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }
    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    /**
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
        return slNo;
    }
    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
        this.slNo = slNo;
    }
    /**
     * @return the amount
     */
    public BigDecimal getAmount()
    {
        return amount;
    }
    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    /**
     * @return the cvAmount
     */
    public BigDecimal getCvAmount()
    {
        return cvAmount;
    }
    /**
     * @param cvAmount the cvAmount to set
     */
    public void setCvAmount(BigDecimal cvAmount)
    {
        this.cvAmount = cvAmount;
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
    /**
     * @return the cv_decimal_points
     */
    public BigDecimal getCv_decimal_points()
    {
        return cv_decimal_points;
    }
    /**
     * @param cvDecimalPoints the cv_decimal_points to set
     */
    public void setCv_decimal_points(BigDecimal cvDecimalPoints)
    {
        cv_decimal_points = cvDecimalPoints;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
}
