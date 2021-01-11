package com.path.vo.core.lettercredit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * LetterCreditSC.java used for search criteria parameters for Letter credit
 */
public class LetterCreditSC extends GridParamsSC
{
    private String lcType;
    private BigDecimal lcNbr;
    private BigDecimal lcRefNbr;
    private BigDecimal lcRefYear;
    private String creditAvailable;
    private String status;
    private String statusInclude;
    private BigDecimal statusLovType;
    private BigDecimal setlMethodLovType;
    private String lcRefType;
    private BigDecimal trxType;
    
    //Mark Ayoub - 450290
    private String isContractRegist;

    //Bassam Eid - US# 450296 - SBI160243 - Import Advance payment Screen required
    private String advPayFilter;
    //////////////////////////////

    public String getCreditAvailable()
    {
        return creditAvailable;
    }

    public void setCreditAvailable(String creditAvailable)
    {
        this.creditAvailable = creditAvailable;
    }

    public String getLcType()
    {
        return lcType;
    }

    public void setLcType(String lcType)
    {
        this.lcType = lcType;
    }

    public BigDecimal getLcNbr()
    {
        return lcNbr;
    }

    public void setLcNbr(BigDecimal lcNbr)
    {
        this.lcNbr = lcNbr;
    }

    public BigDecimal getLcRefNbr()
    {
        return lcRefNbr;
    }

    public void setLcRefNbr(BigDecimal lcRefNbr)
    {
        this.lcRefNbr = lcRefNbr;
    }

    public BigDecimal getLcRefYear()
    {
        return lcRefYear;
    }

    public void setLcRefYear(BigDecimal lcRefYear)
    {
        this.lcRefYear = lcRefYear;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the statusLovType
     */
    public BigDecimal getStatusLovType()
    {
        return statusLovType;
    }

    /**
     * @param statusLovType the statusLovType to set
     */
    public void setStatusLovType(BigDecimal statusLovType)
    {
        this.statusLovType = statusLovType;
    }

    /**
     * @return the setlMethodLovType
     */
    public BigDecimal getSetlMethodLovType()
    {
        return setlMethodLovType;
    }

    /**
     * @param setlMethodLovType the setlMethodLovType to set
     */
    public void setSetlMethodLovType(BigDecimal setlMethodLovType)
    {
        this.setlMethodLovType = setlMethodLovType;
    }

    /**
     * @return the lcRefType
     */
    public String getLcRefType()
    {
        return lcRefType;
    }

    /**
     * @param lcRefType the lcRefType to set
     */
    public void setLcRefType(String lcRefType)
    {
        this.lcRefType = lcRefType;
    }

    public String getStatusInclude()
    {
        return statusInclude;
    }

    public void setStatusInclude(String statusInclude)
    {
        this.statusInclude = statusInclude;
    }
    
    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getIsContractRegist() {
            return isContractRegist;
    }

    public void setIsContractRegist(String isContractRegist) {
            this.isContractRegist = isContractRegist;
    }

    public String getAdvPayFilter()
    {
        return advPayFilter;
    }

    public void setAdvPayFilter(String advPayFilter)
    {
        this.advPayFilter = advPayFilter;
    }



}
