package com.path.vo.core.cardintegration;


import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;


public class CardIntegrationSC extends GridParamsSC
{	
    private BigDecimal CIF_NO;
    private String     appName;
    private BigDecimal lovType;
    private String     langCode;
    private BigDecimal   code;
    private String	language;
    private String	progRef;
    private String     ivCrud;
    private BigDecimal requestCode;
    private String actionType;
    private String additionalReference ;
    private String CARD_NO ;
    private BigDecimal cardType;
    private String fileCode;
    private BigDecimal batchNo;
    private Date systemDate;
    private BigDecimal baseCurr;
    private String dynamicSQL;
    private BigDecimal dynamicSqlNo;
    private Date expiryDate;
    private String cardName;
    

    
    
    public BigDecimal getCode()
    {
        return code;
    }
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }
    public void setCIF_NO(BigDecimal cIF_NO)
    {
        CIF_NO = cIF_NO;
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
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public String getIvCrud()
    {
        return ivCrud;
    }
    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }
    public BigDecimal getRequestCode()
    {
        return requestCode;
    }
    public void setRequestCode(BigDecimal requestCode)
    {
        this.requestCode = requestCode;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getAdditionalReference()
    {
        return additionalReference;
    }
    public void setAdditionalReference(String additionalReference)
    {
        this.additionalReference = additionalReference;
    }
    public String getCARD_NO()
    {
        return CARD_NO;
    }
    public void setCARD_NO(String cARD_NO)
    {
        CARD_NO = cARD_NO;
    }
    public BigDecimal getCardType()
    {
        return cardType;
    }
    public void setCardType(BigDecimal cardType)
    {
        this.cardType = cardType;
    }
    public String getFileCode()
    {
        return fileCode;
    }
    public void setFileCode(String fileCode)
    {
        this.fileCode = fileCode;
    }
    public BigDecimal getBatchNo()
    {
        return batchNo;
    }
    public void setBatchNo(BigDecimal batchNo)
    {
        this.batchNo = batchNo;
    }
    public Date getSystemDate()
    {
        return systemDate;
    }
    public void setSystemDate(Date systemDate)
    {
        this.systemDate = systemDate;
    }
    public BigDecimal getBaseCurr()
    {
        return baseCurr;
    }
    public void setBaseCurr(BigDecimal baseCurr)
    {
        this.baseCurr = baseCurr;
    }
    public String getDynamicSQL()
    {
        return dynamicSQL;
    }
    public void setDynamicSQL(String dynamicSQL)
    {
        this.dynamicSQL = dynamicSQL;
    }
    public BigDecimal getDynamicSqlNo()
    {
        return dynamicSqlNo;
    }
    public void setDynamicSqlNo(BigDecimal dynamicSqlNo)
    {
        this.dynamicSqlNo = dynamicSqlNo;
    }
    public Date getExpiryDate()
    {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }
   
    public String getCardName()
    {
        return cardName;
    }
    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    
    
    
    
    }
