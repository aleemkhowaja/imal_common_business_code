package com.path.vo.core.cardtype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CardTypeSC extends GridParamsSC
{
    private BigDecimal code;
    private BigDecimal cifTypeCode;
    private BigDecimal cif;
    private BigDecimal cardType;
    private String type;
    private String sameType;
    private String maskedCardNo;
    private boolean multiHO;
    private String screenName;
    // added by nancy -- 27/08/2018
    private String status;
    // end nancy
    //Ali Nakouzi
    private String cardCrDrtype;
    private String pin_Type;
    private BigDecimal lovTypePinType;
    private String language;

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public BigDecimal getCardType()
    {
	return cardType;
    }

    public void setCardType(BigDecimal cardType)
    {
	this.cardType = cardType;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getSameType()
    {
	return sameType;
    }

    public void setSameType(String sameType)
    {
	this.sameType = sameType;
    }

    public String getMaskedCardNo()
    {
	return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
	this.maskedCardNo = maskedCardNo;
    }

    public String getPin_Type()
    {
        return pin_Type;
    }

    public void setPin_Type(String pin_Type)
    {
        this.pin_Type = pin_Type;
    }

    public BigDecimal getLovTypePinType()
    {
        return lovTypePinType;
    }

    public void setLovTypePinType(BigDecimal lovTypePinType)
    {
        this.lovTypePinType = lovTypePinType;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public boolean isMultiHO()
    {
        return multiHO;
    }

    public void setMultiHO(boolean multiHO)
    {
        this.multiHO = multiHO;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCardCrDrtype()
    {
        return cardCrDrtype;
    }

    public void setCardCrDrtype(String cardCrDrtype)
    {
        this.cardCrDrtype = cardCrDrtype;
    }

}
