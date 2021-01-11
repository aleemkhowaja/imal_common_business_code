/**
 * 
 */
package com.path.vo.core.trxmgnt.remittancedenom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          TrxMgntRemtDenomSC.java used to
 */
public class TrxMgntRemtDenomSC extends GridParamsSC
{
    private BigDecimal trsNo;
    private BigDecimal trxType;
    private BigDecimal seqFr;
    private BigDecimal seqTo;
    private BigDecimal trsCy;
    private BigDecimal value;
    private BigDecimal tellerNo;
    private BigDecimal remittType;
    private String cbInd;
    private String trsType;
    private String langCode;
    private String appName;
    private String progRef;
    private String ivCrud;
    private String serialNo;
    private String flag;
    private String remittanceType;
    private String predefinedValue;
    private String collectionRemittType;

    /**
     * @return the trsNo
     */
    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    /**
     * @param trsNo the trsNo to set
     */
    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
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
     * @return the appName
     */
    public String getAppName()
    {
	return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
	return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    /**
     * @return the ivCrud
     */
    public String getIvCrud()
    {
	return ivCrud;
    }

    /**
     * @param ivCrud the ivCrud to set
     */
    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public String getSerialNo()
    {
	return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
	this.serialNo = serialNo;
    }

    public BigDecimal getSeqFr()
    {
	return seqFr;
    }

    public void setSeqFr(BigDecimal seqFr)
    {
	this.seqFr = seqFr;
    }

    public BigDecimal getSeqTo()
    {
	return seqTo;
    }

    public void setSeqTo(BigDecimal seqTo)
    {
	this.seqTo = seqTo;
    }

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public BigDecimal getRemittType()
    {
	return remittType;
    }

    public void setRemittType(BigDecimal remittType)
    {
	this.remittType = remittType;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public BigDecimal getTellerNo()
    {
        return tellerNo;
    }

    public void setTellerNo(BigDecimal tellerNo)
    {
        this.tellerNo = tellerNo;
    }

    public String getRemittanceType()
    {
        return remittanceType;
    }

    public void setRemittanceType(String remittanceType)
    {
        this.remittanceType = remittanceType;
    }

    public String getPredefinedValue()
    {
        return predefinedValue;
    }

    public void setPredefinedValue(String predefinedValue)
    {
        this.predefinedValue = predefinedValue;
    }

    /**
     * @return the collectionRemittType
     */
    public String getCollectionRemittType()
    {
        return collectionRemittType;
    }

    /**
     * @param collectionRemittType the collectionRemittType to set
     */
    public void setCollectionRemittType(String collectionRemittType)
    {
        this.collectionRemittType = collectionRemittType;
    }

}
