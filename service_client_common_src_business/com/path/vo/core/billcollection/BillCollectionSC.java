package com.path.vo.core.billcollection;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * 
 * BillCollectionSC.java used for search criteria parameters of Bill
 */
public class BillCollectionSC extends GridParamsSC
{
    private BigDecimal billNbr;
    private String billType;
    private String creditAvailable;
    private String status;
    private BigDecimal statusLovType;
    private BigDecimal trxType;
    private int alwaysClosedAcceptance;
    private String billSetlType;
    
    private String statusInclude;

    public BigDecimal getBillNbr()
    {
        return billNbr;
    }

    public void setBillNbr(BigDecimal billNbr)
    {
        this.billNbr = billNbr;
    }

    public String getBillType()
    {
        return billType;
    }

    public void setBillType(String billType)
    {
        this.billType = billType;
    }

    public String getCreditAvailable()
    {
        return creditAvailable;
    }

    public void setCreditAvailable(String creditAvailable)
    {
        this.creditAvailable = creditAvailable;
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

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public int getAlwaysClosedAcceptance()
    {
        return alwaysClosedAcceptance;
    }

    public void setAlwaysClosedAcceptance(int alwaysClosedAcceptance)
    {
        this.alwaysClosedAcceptance = alwaysClosedAcceptance;
    }

    public String getBillSetlType()
    {
        return billSetlType;
    }

    public void setBillSetlType(String billSetlType)
    {
        this.billSetlType = billSetlType;
    }
    
    public String getStatusInclude()
    {
        return statusInclude;
    }

    public void setStatusInclude(String statusInclude)
    {
        this.statusInclude = statusInclude;
    }



}
