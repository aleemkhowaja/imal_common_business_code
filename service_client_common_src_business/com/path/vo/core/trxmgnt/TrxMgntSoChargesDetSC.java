package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntSoChargesDetSC extends GridParamsSC 
{
    private BigDecimal trsNo;
    private String     chargeType;
    private String     cashDeductInd;
    private BigDecimal trsCy;
    private BigDecimal trsAcCy;
    private BigDecimal trsAcGl;
    private BigDecimal exchangeRate;
    private String     language;
    private BigDecimal lovType;
    private String     appName;
    private String     progRef;
    private String     ivCrud;
    private BigDecimal trxType;
    private BigDecimal cifNO;
    private BigDecimal cifType;
    private BigDecimal schema;
    private BigDecimal chAcCy;
    private String     soChargesAction;
    private BigDecimal baseCurrencyCode;
    
    private String     trsfrMethod;
    private BigDecimal trxAmount;
    private BigDecimal trsAcCif;
    private BigDecimal toTrsAcCif;
    private BigDecimal toTrsAcBr;
    private BigDecimal chAcBr;
    private BigDecimal chAcCif;
    private BigDecimal trsAcSl;
    private BigDecimal toTrsAcCy;
    private BigDecimal toTrsAcGl;
    private BigDecimal toTrsAcSl;
    private String     docLang;
    private String     soChargesEmpty;
    private String     frmAlert = "false";
    private String     baseCyFormat;
    private String     crDrForex;
    private String     fcCyFormat;
    
    public  BigDecimal getTrsNo()
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

    public String getCashDeductInd()
    {
	return cashDeductInd;
    }

    public void setCashDeductInd(String cashDeductInd)
    {
	this.cashDeductInd = cashDeductInd;
    }

    public BigDecimal getTrsAcCy()
    {
	return trsAcCy;
    }

    public void setTrsAcCy(BigDecimal trsAcCy)
    {
	this.trsAcCy = trsAcCy;
    }

    public BigDecimal getTrsAcGl()
    {
	return trsAcGl;
    }

    public void setTrsAcGl(BigDecimal trsAcGl)
    {
	this.trsAcGl = trsAcGl;
    }

    public BigDecimal getExchangeRate()
    {
	return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate)
    {
	this.exchangeRate = exchangeRate;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    public String getChargeType()
    {
	return chargeType;
    }

    public void setChargeType(String chargeType)
    {
	this.chargeType = chargeType;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public BigDecimal getCifNO()
    {
        return cifNO;
    }

    public void setCifNO(BigDecimal cifNO)
    {
        this.cifNO = cifNO;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getSchema()
    {
        return schema;
    }

    public void setSchema(BigDecimal schema)
    {
        this.schema = schema;
    }

    /**
     * @return the chAcCy
     */
    public BigDecimal getChAcCy()
    {
        return chAcCy;
    }

    /**
     * @param chAcCy the chAcCy to set
     */
    public void setChAcCy(BigDecimal chAcCy)
    {
        this.chAcCy = chAcCy;
    }

    /**
     * @return the soChargesAction
     */
    public String getSoChargesAction()
    {
        return soChargesAction;
    }

    /**
     * @param soChargesAction the soChargesAction to set
     */
    public void setSoChargesAction(String soChargesAction)
    {
        this.soChargesAction = soChargesAction;
    }

    /**
     * @return the baseCurrencyCode
     */
    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    /**
     * @param baseCurrencyCode the baseCurrencyCode to set
     */
    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    /**
     * @return the trsfrMethod
     */
    public String getTrsfrMethod()
    {
        return trsfrMethod;
    }

    /**
     * @param trsfrMethod the trsfrMethod to set
     */
    public void setTrsfrMethod(String trsfrMethod)
    {
        this.trsfrMethod = trsfrMethod;
    }

    /**
     * @return the trxAmount
     */
    public BigDecimal getTrxAmount()
    {
        return trxAmount;
    }

    /**
     * @param trxAmount the trxAmount to set
     */
    public void setTrxAmount(BigDecimal trxAmount)
    {
        this.trxAmount = trxAmount;
    }

    /**
     * @return the trsAcCif
     */
    public BigDecimal getTrsAcCif()
    {
        return trsAcCif;
    }

    /**
     * @param trsAcCif the trsAcCif to set
     */
    public void setTrsAcCif(BigDecimal trsAcCif)
    {
        this.trsAcCif = trsAcCif;
    }

    /**
     * @return the toTrsAcCif
     */
    public BigDecimal getToTrsAcCif()
    {
        return toTrsAcCif;
    }

    /**
     * @param toTrsAcCif the toTrsAcCif to set
     */
    public void setToTrsAcCif(BigDecimal toTrsAcCif)
    {
        this.toTrsAcCif = toTrsAcCif;
    }

    /**
     * @return the toTrsAcBr
     */
    public BigDecimal getToTrsAcBr()
    {
        return toTrsAcBr;
    }

    /**
     * @param toTrsAcBr the toTrsAcBr to set
     */
    public void setToTrsAcBr(BigDecimal toTrsAcBr)
    {
        this.toTrsAcBr = toTrsAcBr;
    }

    /**
     * @return the chAcCif
     */
    public BigDecimal getChAcCif()
    {
        return chAcCif;
    }

    /**
     * @param chAcCif the chAcCif to set
     */
    public void setChAcCif(BigDecimal chAcCif)
    {
        this.chAcCif = chAcCif;
    }

    /**
     * @return the chAcBr
     */
    public BigDecimal getChAcBr()
    {
        return chAcBr;
    }

    /**
     * @param chAcBr the chAcBr to set
     */
    public void setChAcBr(BigDecimal chAcBr)
    {
        this.chAcBr = chAcBr;
    }

    /**
     * @return the trsAcSl
     */
    public BigDecimal getTrsAcSl()
    {
        return trsAcSl;
    }

    /**
     * @param trsAcSl the trsAcSl to set
     */
    public void setTrsAcSl(BigDecimal trsAcSl)
    {
        this.trsAcSl = trsAcSl;
    }

    /**
     * @return the toTrsAcCy
     */
    public BigDecimal getToTrsAcCy()
    {
        return toTrsAcCy;
    }

    /**
     * @param toTrsAcCy the toTrsAcCy to set
     */
    public void setToTrsAcCy(BigDecimal toTrsAcCy)
    {
        this.toTrsAcCy = toTrsAcCy;
    }

    /**
     * @return the toTrsAcGl
     */
    public BigDecimal getToTrsAcGl()
    {
        return toTrsAcGl;
    }

    /**
     * @param toTrsAcGl the toTrsAcGl to set
     */
    public void setToTrsAcGl(BigDecimal toTrsAcGl)
    {
        this.toTrsAcGl = toTrsAcGl;
    }

    /**
     * @return the toTrsAcSl
     */
    public BigDecimal getToTrsAcSl()
    {
        return toTrsAcSl;
    }

    /**
     * @param toTrsAcSl the toTrsAcSl to set
     */
    public void setToTrsAcSl(BigDecimal toTrsAcSl)
    {
        this.toTrsAcSl = toTrsAcSl;
    }

    /**
     * @return the docLang
     */
    public String getDocLang()
    {
        return docLang;
    }

    /**
     * @param docLang the docLang to set
     */
    public void setDocLang(String docLang)
    {
        this.docLang = docLang;
    }

    /**
     * @return the soChargesEmpty
     */
    public String getSoChargesEmpty()
    {
        return soChargesEmpty;
    }

    /**
     * @param soChargesEmpty the soChargesEmpty to set
     */
    public void setSoChargesEmpty(String soChargesEmpty)
    {
        this.soChargesEmpty = soChargesEmpty;
    }

    /**
     * @return the frmAlert
     */
    public String getFrmAlert()
    {
        return frmAlert;
    }

    /**
     * @param frmAlert the frmAlert to set
     */
    public void setFrmAlert(String frmAlert)
    {
        this.frmAlert = frmAlert;
    }

    public String getBaseCyFormat()
    {
        return baseCyFormat;
    }

    public void setBaseCyFormat(String baseCyFormat)
    {
        this.baseCyFormat = baseCyFormat;
    }

    public String getCrDrForex()
    {
        return crDrForex;
    }

    public void setCrDrForex(String crDrForex)
    {
        this.crDrForex = crDrForex;
    }

    public String getFcCyFormat()
    {
        return fcCyFormat;
    }

    public void setFcCyFormat(String fcCyFormat)
    {
        this.fcCyFormat = fcCyFormat;
    }

}
