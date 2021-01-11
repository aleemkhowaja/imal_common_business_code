package com.path.vo.common.cydenom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 * 
 */
public class CyDenomCommonSC extends GridParamsSC
{
    private BigDecimal trsNo;
    private String trsType;
    private String preferredLanguage;
    private String langCode;
    private String appName;
    private String progRef;
    private String ivCrud;
    private BigDecimal lovType;
    private BigDecimal value;
    private BigDecimal cyCode;
    private BigDecimal tellerCode;
    private String screenSrc;
    private BigDecimal amount;
    private String gvMessage;
    private String cyDesc;
    private BigDecimal cyDecimalPoints;
    private String status;
    private String _cyDenomPageRef;
    private String inOut;
    private String trxReverseOrCancel;
    private String trsfrType;
    private String trsfrReference;
    private Date tradeDate;
    private BigDecimal vaultBranch;
    private String recalculateCyDenom;
    private String cyDenomGridUpdate;
    private String cyDetType;
    private boolean loadTempCyDenom;

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

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public BigDecimal getCyCode()
    {
        return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
        this.cyCode = cyCode;
    }

    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getGvMessage()
    {
        return gvMessage;
    }

    public void setGvMessage(String gvMessage)
    {
        this.gvMessage = gvMessage;
    }

    public String getCyDesc()
    {
        return cyDesc;
    }

    public void setCyDesc(String cyDesc)
    {
        this.cyDesc = cyDesc;
    }

    public BigDecimal getCyDecimalPoints()
    {
        return cyDecimalPoints;
    }

    public void setCyDecimalPoints(BigDecimal cyDecimalPoints)
    {
        this.cyDecimalPoints = cyDecimalPoints;
    }

    public String get_cyDenomPageRef()
    {
        return _cyDenomPageRef;
    }

    public void set_cyDenomPageRef(String cyDenomPageRef)
    {
        _cyDenomPageRef = cyDenomPageRef;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getInOut()
    {
        return inOut;
    }

    public void setInOut(String inOut)
    {
        this.inOut = inOut;
    }

    public String getTrxReverseOrCancel()
    {
        return trxReverseOrCancel;
    }

    public void setTrxReverseOrCancel(String trxReverseOrCancel)
    {
        this.trxReverseOrCancel = trxReverseOrCancel;
    }

    public String getTrsfrType()
    {
        return trsfrType;
    }

    public void setTrsfrType(String trsfrType)
    {
        this.trsfrType = trsfrType;
    }

    public String getTrsfrReference()
    {
        return trsfrReference;
    }

    public void setTrsfrReference(String trsfrReference)
    {
        this.trsfrReference = trsfrReference;
    }

    public Date getTradeDate()
    {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate)
    {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getVaultBranch()
    {
        return vaultBranch;
    }

    public void setVaultBranch(BigDecimal vaultBranch)
    {
        this.vaultBranch = vaultBranch;
    }

    public String getRecalculateCyDenom()
    {
        return recalculateCyDenom;
    }

    public void setRecalculateCyDenom(String recalculateCyDenom)
    {
        this.recalculateCyDenom = recalculateCyDenom;
    }

    public String getCyDenomGridUpdate()
    {
        return cyDenomGridUpdate;
    }

    public void setCyDenomGridUpdate(String cyDenomGridUpdate)
    {
        this.cyDenomGridUpdate = cyDenomGridUpdate;
    }

    public String getCyDetType()
    {
        return cyDetType;
    }

    public void setCyDetType(String cyDetType)
    {
        this.cyDetType = cyDetType;
    }

    public boolean isLoadTempCyDenom()
    {
        return loadTempCyDenom;
    }

    public void setLoadTempCyDenom(boolean loadTempCyDenom)
    {
        this.loadTempCyDenom = loadTempCyDenom;
    }

}
