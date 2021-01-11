package com.path.vo.core.trxmgnt.settlement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntSettlementSC extends GridParamsSC
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
    private BigDecimal cifNo;
    private String idNo;
    private String addRef;
    private BigDecimal dealNo;
    private String customDealNo;
    private String channel;
    private Date processDate;
    private String vehicle;
    private BigDecimal errorCode;
    private String errorMessage;
    private List<TrxMgntSettlementCO> sysRefCursor;
    private String dealsDetailsGridUpdates;
    private BigDecimal dealBr;
    private BigDecimal minAmount;
    private BigDecimal cifLine;

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

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getAddRef()
    {
        return addRef;
    }

    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }

    public BigDecimal getDealNo()
    {
        return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
        this.dealNo = dealNo;
    }

    public String getCustomDealNo()
    {
        return customDealNo;
    }

    public void setCustomDealNo(String customDealNo)
    {
        this.customDealNo = customDealNo;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public Date getProcessDate()
    {
        return processDate;
    }

    public void setProcessDate(Date processDate)
    {
        this.processDate = processDate;
    }

    public String getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(String vehicle)
    {
        this.vehicle = vehicle;
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

    public String getDealsDetailsGridUpdates()
    {
        return dealsDetailsGridUpdates;
    }

    public void setDealsDetailsGridUpdates(String dealsDetailsGridUpdates)
    {
        this.dealsDetailsGridUpdates = dealsDetailsGridUpdates;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public List<TrxMgntSettlementCO> getSysRefCursor()
    {
        return sysRefCursor;
    }

    public void setSysRefCursor(List<TrxMgntSettlementCO> sysRefCursor)
    {
        this.sysRefCursor = sysRefCursor;
    }

    public BigDecimal getDealBr()
    {
        return dealBr;
    }

    public void setDealBr(BigDecimal dealBr)
    {
        this.dealBr = dealBr;
    }

    public BigDecimal getMinAmount()
    {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount)
    {
        this.minAmount = minAmount;
    }

    public BigDecimal getCifLine()
    {
        return cifLine;
    }

    public void setCifLine(BigDecimal cifLine)
    {
        this.cifLine = cifLine;
    }

}
