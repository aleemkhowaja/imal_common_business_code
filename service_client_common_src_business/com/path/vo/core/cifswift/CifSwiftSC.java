package com.path.vo.core.cifswift;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifSwiftSC extends GridParamsSC
{

    private BigDecimal cifCode;
    private String clientIsBank;
    private String rma;
    private String bankCode;
    private String countryCode;
    private String locationCode;
    private String terminalCode;
    private String strBranchCode;
    private BigDecimal bicCodeLimit;
    private BigDecimal destinCountry;
    private BigDecimal bankCif;
    private BigDecimal corrBank;

    // this property stand for identifying from which screen the lookup is called
    private String fromWhere;
    private String transferType;
    private BigDecimal trxType;
    private BigDecimal currencyCode;

    public String getClientIsBank()
    {
	return clientIsBank;
    }

    public void setClientIsBank(String clientIsBank)
    {
	this.clientIsBank = clientIsBank;
    }

    public String getRma()
    {
	return rma;
    }

    public void setRma(String rma)
    {
	this.rma = rma;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public String getStrBranchCode()
    {
	return strBranchCode;
    }

    public void setStrBranchCode(String strBranchCode)
    {
	this.strBranchCode = strBranchCode;
    }

    public BigDecimal getBicCodeLimit()
    {
	return bicCodeLimit;
    }

    public void setBicCodeLimit(BigDecimal bicCodeLimit)
    {
	this.bicCodeLimit = bicCodeLimit;
    }

    public String getBankCode()
    {
	return bankCode;
    }

    public void setBankCode(String bankCode)
    {
	this.bankCode = bankCode;
    }

    public String getCountryCode()
    {
	return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
	this.countryCode = countryCode;
    }

    public String getLocationCode()
    {
	return locationCode;
    }

    public void setLocationCode(String locationCode)
    {
	this.locationCode = locationCode;
    }

    public String getTerminalCode()
    {
	return terminalCode;
    }

    public void setTerminalCode(String terminalCode)
    {
	this.terminalCode = terminalCode;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }

    public String getTransferType()
    {
        return transferType;
    }

    public void setTransferType(String transferType)
    {
        this.transferType = transferType;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    
    public BigDecimal getDestinCountry()
    {
        return destinCountry;
    }

    public void setDestinCountry(BigDecimal destinCountry)
    {
        this.destinCountry = destinCountry;
    }

    public BigDecimal getBankCif()
    {
        return bankCif;
    }

    public void setBankCif(BigDecimal bankCif)
    {
        this.bankCif = bankCif;
    }

    public BigDecimal getCorrBank()
    {
        return corrBank;
    }

    public void setCorrBank(BigDecimal corrBank)
    {
        this.corrBank = corrBank;
    }

    
}
