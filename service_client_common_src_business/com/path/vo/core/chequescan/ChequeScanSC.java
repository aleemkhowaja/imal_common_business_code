package com.path.vo.core.chequescan;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to this source code
 * @author: CHADY.A
 * ChequeScanSC.java used to
 */
public class ChequeScanSC extends GridParamsSC
{
    private BigDecimal code;
    private String cbInd;
    private String trsType;
    private BigDecimal trxType;
    private BigDecimal lineNo;
    private String lang;
    private String langCode;
    private String statusCode;
    private BigDecimal lovType;
    private String chqRelated;
    private String imageSource;
    
    /**
     * @return the code
     */
    public BigDecimal getCode()
    {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(BigDecimal code)
    {
        this.code = code;
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
    /**
     * @return the lang
     */
    public String getLang()
    {
        return lang;
    }
    /**
     * @param lang the lang to set
     */
    public void setLang(String lang)
    {
        this.lang = lang;
    }
    /**
     * @return the cbInd
     */
    public String getCbInd()
    {
        return cbInd;
    }
    /**
     * @param cbInd the cbInd to set
     */
    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }
    /**
     * @return the trsType
     */
    public String getTrsType()
    {
        return trsType;
    }
    /**
     * @param trsType the trsType to set
     */
    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
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
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }
    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    /**
     * @return the lovType
     */
    public BigDecimal getLovType()
    {
        return lovType;
    }
    /**
     * @param lovType the lovType to set
     */
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }
    /**
     * @return the statusCode
     */
    public String getStatusCode()
    {
        return statusCode;
    }
    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }
    /**
     * @return the chqRelated
     */
    public String getChqRelated()
    {
        return chqRelated;
    }
    /**
     * @param chqRelated the chqRelated to set
     */
    public void setChqRelated(String chqRelated)
    {
        this.chqRelated = chqRelated;
    }
    public String getImageSource()
    {
        return imageSource;
    }
    public void setImageSource(String imageSource)
    {
        this.imageSource = imageSource;
    }
    
    
    
}
