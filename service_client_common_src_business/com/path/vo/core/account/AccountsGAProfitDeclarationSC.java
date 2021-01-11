package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AccountsGAProfitDeclarationSC.java used to
 */
public class AccountsGAProfitDeclarationSC extends GridParamsSC
{
    
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifSubNo;
    private BigDecimal slNo;
    private Date dateOpened;
    private String dateOpenedString;
    private Date expectedProfitDeclarationDate;
    private BigDecimal rowCount;
    private BigDecimal profitDeclPeriodNo;
    private String profitDeclPeriodFreq;
    private BigDecimal bankProfitShare;
    private BigDecimal psrExcessLimit;
    private BigDecimal facilityNo;
    private BigDecimal facilitySublimit;
    private BigDecimal decimalPoints;
    
    
    private BigDecimal lineNo;
    
    
    
    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }
    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public BigDecimal getGlCode()
    {
        return glCode;
    }
    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }
    public BigDecimal getCifSubNo()
    {
        return cifSubNo;
    }
    public void setCifSubNo(BigDecimal cifSubNo)
    {
        this.cifSubNo = cifSubNo;
    }
    public BigDecimal getSlNo()
    {
        return slNo;
    }
    public void setSlNo(BigDecimal slNo)
    {
        this.slNo = slNo;
    }
    public Date getDateOpened()
    {
        return dateOpened;
    }
    public void setDateOpened(Date dateOpened)
    {
        this.dateOpened = dateOpened;
    }
    public BigDecimal getProfitDeclPeriodNo()
    {
        return profitDeclPeriodNo;
    }
    public void setProfitDeclPeriodNo(BigDecimal profitDeclPeriodNo)
    {
        this.profitDeclPeriodNo = profitDeclPeriodNo;
    }
    public String getProfitDeclPeriodFreq()
    {
        return profitDeclPeriodFreq;
    }
    public void setProfitDeclPeriodFreq(String profitDeclPeriodFreq)
    {
        this.profitDeclPeriodFreq = profitDeclPeriodFreq;
    }
    public BigDecimal getRowCount()
    {
        return rowCount;
    }
    public void setRowCount(BigDecimal rowCount)
    {
        this.rowCount = rowCount;
    }
    public Date getExpectedProfitDeclarationDate()
    {
        return expectedProfitDeclarationDate;
    }
    public void setExpectedProfitDeclarationDate(Date expectedProfitDeclarationDate)
    {
        this.expectedProfitDeclarationDate = expectedProfitDeclarationDate;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
    public String getDateOpenedString()
    {
        return dateOpenedString;
    }
    public void setDateOpenedString(String dateOpenedString)
    {
        this.dateOpenedString = dateOpenedString;
    }
    public BigDecimal getPsrExcessLimit()
    {
        return psrExcessLimit;
    }
    public void setPsrExcessLimit(BigDecimal psrExcessLimit)
    {
        this.psrExcessLimit = psrExcessLimit;
    }
    public BigDecimal getBankProfitShare()
    {
        return bankProfitShare;
    }
    public void setBankProfitShare(BigDecimal bankProfitShare)
    {
        this.bankProfitShare = bankProfitShare;
    }
    public BigDecimal getFacilityNo()
    {
        return facilityNo;
    }
    public void setFacilityNo(BigDecimal facilityNo)
    {
        this.facilityNo = facilityNo;
    }
    public BigDecimal getFacilitySublimit()
    {
        return facilitySublimit;
    }
    public void setFacilitySublimit(BigDecimal facilitySublimit)
    {
        this.facilitySublimit = facilitySublimit;
    }
    public BigDecimal getDecimalPoints()
    {
        return decimalPoints;
    }
    public void setDecimalPoints(BigDecimal decimalPoints)
    {
        this.decimalPoints = decimalPoints;
    }
    
}
