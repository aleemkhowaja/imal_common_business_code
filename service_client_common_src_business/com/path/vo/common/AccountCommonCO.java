/**
 * 
 */
package com.path.vo.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * accountCommonCO.java used as a POJO for account related files
 */
public class AccountCommonCO extends BaseVO implements Serializable
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal fromCy;
    private BigDecimal fromGl;
    private BigDecimal fromCif;
    private BigDecimal fromSl;
    private BigDecimal toCy;
    private BigDecimal toGl;
    private BigDecimal toCif;
    private BigDecimal toSl;
    private BigDecimal FC_AMOUNT;
    private BigDecimal CV_AMOUNT;
    
    private Date fromDate;
    
    private String userId;
    private String byTradeDtValueDt;
    private String add5;
    private String appType;
    private String includeReserve;
    private Date toDate;
    
    private String balanceType;
    private String as_Vt;
    private BigDecimal threshold; 
    private Date adt_opened;
    private String option;
    private String auto_sweep;
    private String clearing;
    private String includeReval;
    private String includeReverse;
    private String stmtType;
    private String endWeekDay;
    private String language;
    private BigDecimal errorCode;
    private String errorMessage;
    private String consMCETrs;
    private String consMCECharges;

    
    /**
     * @return the compCode
     */
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    /**
     * @param compCode the compCode to set
     */
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
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
     * @return the fromCy
     */
    public BigDecimal getFromCy()
    {
        return fromCy;
    }
    /**
     * @param fromCy the fromCy to set
     */
    public void setFromCy(BigDecimal fromCy)
    {
        this.fromCy = fromCy;
    }
    /**
     * @return the fromGl
     */
    public BigDecimal getFromGl()
    {
        return fromGl;
    }
    /**
     * @param fromGl the fromGl to set
     */
    public void setFromGl(BigDecimal fromGl)
    {
        this.fromGl = fromGl;
    }
    /**
     * @return the fromCif
     */
    public BigDecimal getFromCif()
    {
        return fromCif;
    }
    /**
     * @param fromCif the fromCif to set
     */
    public void setFromCif(BigDecimal fromCif)
    {
        this.fromCif = fromCif;
    }
    /**
     * @return the fromSl
     */
    public BigDecimal getFromSl()
    {
        return fromSl;
    }
    /**
     * @param fromSl the fromSl to set
     */
    public void setFromSl(BigDecimal fromSl)
    {
        this.fromSl = fromSl;
    }
    /**
     * @return the toCy
     */
    public BigDecimal getToCy()
    {
        return toCy;
    }
    /**
     * @param toCy the toCy to set
     */
    public void setToCy(BigDecimal toCy)
    {
        this.toCy = toCy;
    }
    /**
     * @return the toGl
     */
    public BigDecimal getToGl()
    {
        return toGl;
    }
    /**
     * @param toGl the toGl to set
     */
    public void setToGl(BigDecimal toGl)
    {
        this.toGl = toGl;
    }
    /**
     * @return the toCif
     */
    public BigDecimal getToCif()
    {
        return toCif;
    }
    /**
     * @param toCif the toCif to set
     */
    public void setToCif(BigDecimal toCif)
    {
        this.toCif = toCif;
    }
    /**
     * @return the toSl
     */
    public BigDecimal getToSl()
    {
        return toSl;
    }
    /**
     * @param toSl the toSl to set
     */
    public void setToSl(BigDecimal toSl)
    {
        this.toSl = toSl;
    }
    /**
     * @return the fC_AMOUNT
     */
    public BigDecimal getFC_AMOUNT()
    {
        return FC_AMOUNT;
    }
    /**
     * @param fCAMOUNT the fC_AMOUNT to set
     */
    public void setFC_AMOUNT(BigDecimal fCAMOUNT)
    {
        FC_AMOUNT = fCAMOUNT;
    }
    /**
     * @return the cV_AMOUNT
     */
    public BigDecimal getCV_AMOUNT()
    {
        return CV_AMOUNT;
    }
    /**
     * @param cVAMOUNT the cV_AMOUNT to set
     */
    public void setCV_AMOUNT(BigDecimal cVAMOUNT)
    {
        CV_AMOUNT = cVAMOUNT;
    }
    /**
     * @return the fromDate
     */
    public Date getFromDate()
    {
        return fromDate;
    }
    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }
    /**
     * @return the userId
     */
    public String getUserId()
    {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    /**
     * @return the byTradeDtValueDt
     */
    public String getByTradeDtValueDt()
    {
        return byTradeDtValueDt;
    }
    /**
     * @param byTradeDtValueDt the byTradeDtValueDt to set
     */
    public void setByTradeDtValueDt(String byTradeDtValueDt)
    {
        this.byTradeDtValueDt = byTradeDtValueDt;
    }
    /**
     * @return the add5
     */
    public String getAdd5()
    {
        return add5;
    }
    /**
     * @param add5 the add5 to set
     */
    public void setAdd5(String add5)
    {
        this.add5 = add5;
    }
    /**
     * @return the includeReserve
     */
    public String getIncludeReserve()
    {
        return includeReserve;
    }
    /**
     * @param includeReserve the includeReserve to set
     */
    public void setIncludeReserve(String includeReserve)
    {
        this.includeReserve = includeReserve;
    }
    public Date getToDate()
    {
        return toDate;
    }
    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }
    public String getBalanceType()
    {
        return balanceType;
    }
    public void setBalanceType(String balanceType)
    {
        this.balanceType = balanceType;
    }
    public String getAs_Vt()
    {
        return as_Vt;
    }
    public void setAs_Vt(String asVt)
    {
        as_Vt = asVt;
    }
    public BigDecimal getThreshold()
    {
        return threshold;
    }
    public void setThreshold(BigDecimal threshold)
    {
        this.threshold = threshold;
    }
    public Date getAdt_opened()
    {
        return adt_opened;
    }
    public void setAdt_opened(Date adtOpened)
    {
        adt_opened = adtOpened;
    }
    public String getOption()
    {
        return option;
    }
    public void setOption(String option)
    {
        this.option = option;
    }
    public String getAuto_sweep()
    {
        return auto_sweep;
    }
    public void setAuto_sweep(String autoSweep)
    {
        auto_sweep = autoSweep;
    }
 
    public String getIncludeReval()
    {
        return includeReval;
    }
    public void setIncludeReval(String includeReval)
    {
        this.includeReval = includeReval;
    }
   
    public String getStmtType()
    {
        return stmtType;
    }
    public void setStmtType(String stmtType)
    {
        this.stmtType = stmtType;
    }
    public String getEndWeekDay()
    {
        return endWeekDay;
    }
    public void setEndWeekDay(String endWeekDay)
    {
        this.endWeekDay = endWeekDay;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    public String getClearing()
    {
        return clearing;
    }
    public void setClearing(String clearing)
    {
        this.clearing = clearing;
    }
    public String getIncludeReverse()
    {
        return includeReverse;
    }
    public void setIncludeReverse(String includeReverse)
    {
        this.includeReverse = includeReverse;
    }
    public String getAppType()
    {
        return appType;
    }
    public void setAppType(String appType)
    {
        this.appType = appType;
    }
    public String getConsMCETrs()
    {
        return consMCETrs;
    }
    public void setConsMCETrs(String consMCETrs)
    {
        this.consMCETrs = consMCETrs;
    }
    public String getConsMCECharges()
    {
        return consMCECharges;
    }
    public void setConsMCECharges(String consMCECharges)
    {
        this.consMCECharges = consMCECharges;
    }
    
    
	
}
