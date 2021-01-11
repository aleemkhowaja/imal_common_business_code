package com.path.vo.core.trxmgnt.nonfininfo.morebenef;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntMoreBenefSC extends GridParamsSC
{
    private BigDecimal trsNo;
    private BigDecimal destinCountry;
    private String language;
    private BigDecimal lovType;
    private String appName;
    private String progRef;
    private String ivCrud;
    private String preferredLanguage;
    private String langCode;
    private BigDecimal trxType;
    private String trxTypeSendSwift;
    private String trxTypeValidateIban;
    private BigDecimal trsCy;
    private String dependencyProperty;

    private String multiBenef;
    private BigDecimal trsAcCif;
    private String trsfrType;
    private BigDecimal multiTrsNo;
    private BigDecimal nonFinLineNo;

    private BigDecimal lineNo;
    
    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
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

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getDestinCountry()
    {
	return destinCountry;
    }

    public void setDestinCountry(BigDecimal destinCountry)
    {
	this.destinCountry = destinCountry;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public String getTrxTypeSendSwift()
    {
	return trxTypeSendSwift;
    }

    public void setTrxTypeSendSwift(String trxTypeSendSwift)
    {
	this.trxTypeSendSwift = trxTypeSendSwift;
    }

    public String getTrxTypeValidateIban()
    {
	return trxTypeValidateIban;
    }

    public void setTrxTypeValidateIban(String trxTypeValidateIban)
    {
	this.trxTypeValidateIban = trxTypeValidateIban;
    }

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public String getDependencyProperty()
    {
	return dependencyProperty;
    }

    public void setDependencyProperty(String dependencyProperty)
    {
	this.dependencyProperty = dependencyProperty;
    }

    public String getMultiBenef()
    {
	return multiBenef;
    }

    public void setMultiBenef(String multiBenef)
    {
	this.multiBenef = multiBenef;
    }

    public BigDecimal getTrsAcCif()
    {
	return trsAcCif;
    }

    public void setTrsAcCif(BigDecimal trsAcCif)
    {
	this.trsAcCif = trsAcCif;
    }

    public String getTrsfrType()
    {
	return trsfrType;
    }

    public void setTrsfrType(String trsfrType)
    {
	this.trsfrType = trsfrType;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getMultiTrsNo()
    {
        return multiTrsNo;
    }

    public void setMultiTrsNo(BigDecimal multiTrsNo)
    {
        this.multiTrsNo = multiTrsNo;
    }

    public BigDecimal getNonFinLineNo()
    {
        return nonFinLineNo;
    }

    public void setNonFinLineNo(BigDecimal nonFinLineNo)
    {
        this.nonFinLineNo = nonFinLineNo;
    }

}
