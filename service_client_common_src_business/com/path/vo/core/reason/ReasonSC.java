package com.path.vo.core.reason;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonSC.java used to
 */
public class ReasonSC extends GridParamsSC
{
    private String reason_type;
    private BigDecimal code;
    private String langCode;
    private BigDecimal trxType;
    private String status;
    private String screenSrc;
    private String showMessage;
    private String fromExemptedFilerLookup;

    public String getReason_type()
    {
	return reason_type;
    }

    public void setReason_type(String reasonType)
    {
	reason_type = reasonType;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
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

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
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
     * @return the screenSrc
     */
    public String getScreenSrc()
    {
        return screenSrc;
    }

    /**
     * @param screenSrc the screenSrc to set
     */
    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    public String getShowMessage()
    {
        return showMessage;
    }

    public void setShowMessage(String showMessage)
    {
        this.showMessage = showMessage;
    }

    public String getFromExemptedFilerLookup()
    {
        return fromExemptedFilerLookup;
    }

    public void setFromExemptedFilerLookup(String fromExemptedFilerLookup)
    {
        this.fromExemptedFilerLookup = fromExemptedFilerLookup;
    }
}
