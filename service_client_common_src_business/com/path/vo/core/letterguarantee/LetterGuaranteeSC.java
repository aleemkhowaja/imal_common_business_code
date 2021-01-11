package com.path.vo.core.letterguarantee;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * LetterGuaranteeSC.java used for search criteria of Letter Guarantee
 */
public class LetterGuaranteeSC extends GridParamsSC
{
    private BigDecimal reqNbr;
    private BigDecimal lgNbr;
    private String redemp;
    private String status;
    private BigDecimal statusLovType;
    private String statusInclude;
    private BigDecimal trxType;

    public BigDecimal getReqNbr()
    {
        return reqNbr;
    }

    public void setReqNbr(BigDecimal reqNbr)
    {
        this.reqNbr = reqNbr;
    }

    public String getRedemp()
    {
        return redemp;
    }

    public void setRedemp(String redemp)
    {
        this.redemp = redemp;
    }

    public BigDecimal getLgNbr()
    {
        return lgNbr;
    }

    public void setLgNbr(BigDecimal lgNbr)
    {
        this.lgNbr = lgNbr;
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

}
