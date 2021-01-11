package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Reda Charabaty
 *
 * FOMProductValueDatesSC.java used to
 */
public class FOMProductValueDatesSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private String langCode;
    private BigDecimal lovType;
    private BigDecimal trxType;
    private String docType;
    
    
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public BigDecimal getLovType()
    {
        return lovType;
    }
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }
    public BigDecimal getTrxType()
    {
        return trxType;
    }
    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }
    public String getDocType()
    {
        return docType;
    }
    public void setDocType(String docType)
    {
        this.docType = docType;
    }

}
