package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.struts2.lib.common.GridParamsSC;

public class BlackListSC extends GridParamsSC
{
    private String ivCrud;
    private BigDecimal code;
    private String  langCode;
    private BigDecimal lovType;
    private BigDecimal BlackListType;
    private String tableName;
    //private MOSBLACKLISTVO blackListVO = new MOSBLACKLISTVO();
    private BigDecimal cif;
    private String cifFirstNameEng;
    private String cifSecNameEng;
    private String cifThirdNameEng;
    private String cifLastNameEng;
    private String longNameEng;
    private String country;
    private String cifFirstNameAr;
    private String cifSecNameAr;
    private String cifThirdNameAr;
    private String cifLastNameAr;
    private String longNameAr;
    private BigDecimal errorCode;
    private String errorMessage;
    private String idNo;
    private Date revisionDate;
    private String errorType;
    private String errorTxt;
    private BigDecimal tellerCode;//Hasan BB140080
    
    //Hasan BMO160011 23/01/2016
    private String restrictFactor;
    private BigDecimal entityCode;
    private BigDecimal returnedValue;
    private BigDecimal reasonCode;
    private String parentRef;
    private String appName;
    private BigDecimal cyCode;
    private BigDecimal glCode;
    private BigDecimal slNo;
    private String trsType;
    private String cbInd;
    private String methodName;
    private Integer msgCode;
    private String autoCreation;
    private String cardType;
    private BigDecimal lineNo;
    private BigDecimal restrictionPeriod;
    private String restrictionPeriodType;
    private String entity;
    private String errorMessage2;
    private String allowCifCreationMaskYN;
    private BigDecimal trxType;
    private CTSTELLERVO ctsTellerVO;
    
    public String getRestrictFactor()
    {
        return restrictFactor;
    }

    public void setRestrictFactor(String restrictFactor)
    {
        this.restrictFactor = restrictFactor;
    }

    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

    public BigDecimal getReturnedValue()
    {
        return returnedValue;
    }

    public void setReturnedValue(BigDecimal returnedValue)
    {
        this.returnedValue = returnedValue;
    }

    public BigDecimal getReasonCode()
    {
        return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
        this.reasonCode = reasonCode;
    }

    public String getParentRef()
    {
        return parentRef;
    }

    public void setParentRef(String parentRef)
    {
        this.parentRef = parentRef;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public BigDecimal getCyCode()
    {
        return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
        this.cyCode = cyCode;
    }

    public BigDecimal getGlCode()
    {
        return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }

    public BigDecimal getSlNo()
    {
        return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
        this.slNo = slNo;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getMethodName()
    {
        return methodName;
    }

    public void setMethodName(String methodName)
    {
        this.methodName = methodName;
    }

    public Integer getMsgCode()
    {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
        this.msgCode = msgCode;
    }

    public String getAutoCreation()
    {
        return autoCreation;
    }

    public void setAutoCreation(String autoCreation)
    {
        this.autoCreation = autoCreation;
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

	public String getIvCrud()
	{
		return ivCrud;
	}

	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
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

//	public MOSBLACKLISTVO getBlackListVO()
//	{
//		return blackListVO;
//	}
//
//	public void setBlackListVO(MOSBLACKLISTVO blackListVO)
//	{
//		this.blackListVO = blackListVO;
//	}

	public BigDecimal getBlackListType()
	{
	    return BlackListType;
	}

	public void setBlackListType(BigDecimal blackListType)
	{
	    BlackListType = blackListType;
	}

	public String getTableName()
	{
	    return tableName;
	}

	public void setTableName(String tableName)
	{
	    this.tableName = tableName;
	}

	public BigDecimal getCif()
	{
	    return cif;
	}

	public void setCif(BigDecimal cif)
	{
	    this.cif = cif;
	}

	public String getCifFirstNameEng()
	{
	    return cifFirstNameEng;
	}

	public void setCifFirstNameEng(String cifFirstNameEng)
	{
	    this.cifFirstNameEng = cifFirstNameEng;
	}

	public String getCifSecNameEng()
	{
	    return cifSecNameEng;
	}

	public void setCifSecNameEng(String cifSecNameEng)
	{
	    this.cifSecNameEng = cifSecNameEng;
	}

	public String getCifThirdNameEng()
	{
	    return cifThirdNameEng;
	}

	public void setCifThirdNameEng(String cifThirdNameEng)
	{
	    this.cifThirdNameEng = cifThirdNameEng;
	}

	public String getCifLastNameEng()
	{
	    return cifLastNameEng;
	}

	public void setCifLastNameEng(String cifLastNameEng)
	{
	    this.cifLastNameEng = cifLastNameEng;
	}

	public String getLongNameEng()
	{
	    return longNameEng;
	}

	public void setLongNameEng(String longNameEng)
	{
	    this.longNameEng = longNameEng;
	}

	public String getCifFirstNameAr()
	{
	    return cifFirstNameAr;
	}

	public void setCifFirstNameAr(String cifFirstNameAr)
	{
	    this.cifFirstNameAr = cifFirstNameAr;
	}

	public String getCifSecNameAr()
	{
	    return cifSecNameAr;
	}

	public void setCifSecNameAr(String cifSecNameAr)
	{
	    this.cifSecNameAr = cifSecNameAr;
	}

	public String getCifThirdNameAr()
	{
	    return cifThirdNameAr;
	}

	public void setCifThirdNameAr(String cifThirdNameAr)
	{
	    this.cifThirdNameAr = cifThirdNameAr;
	}

	public String getCifLastNameAr()
	{
	    return cifLastNameAr;
	}

	public void setCifLastNameAr(String cifLastNameAr)
	{
	    this.cifLastNameAr = cifLastNameAr;
	}

	public String getLongNameAr()
	{
	    return longNameAr;
	}

	public void setLongNameAr(String longNameAr)
	{
	    this.longNameAr = longNameAr;
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

	public String getIdNo()
	{
	    return idNo;
	}

	public void setIdNo(String idNo)
	{
	    this.idNo = idNo;
	}

	public Date getRevisionDate()
	{
	    return revisionDate;
	}

	public void setRevisionDate(Date revisionDate)
	{
	    this.revisionDate = revisionDate;
	}

	public String getCountry()
	{
	    return country;
	}

	public void setCountry(String country)
	{
	    this.country = country;
	}

	public String getErrorType()
	{
	    return errorType;
	}

	public void setErrorType(String errorType)
	{
	    this.errorType = errorType;
	}

	public String getErrorTxt()
	{
	    return errorTxt;
	}

	public void setErrorTxt(String errorTxt)
	{
	    this.errorTxt = errorTxt;
	}

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public BigDecimal getRestrictionPeriod()
    {
	return restrictionPeriod;
    }

    public void setRestrictionPeriod(BigDecimal restrictionPeriod)
    {
	this.restrictionPeriod = restrictionPeriod;
    }

    public String getRestrictionPeriodType()
    {
	return restrictionPeriodType;
    }

    public void setRestrictionPeriodType(String restrictionPeriodType)
    {
	this.restrictionPeriodType = restrictionPeriodType;
    }

    public String getEntity()
    {
	return entity;
    }

    public void setEntity(String entity)
    {
	this.entity = entity;
    }

    public String getErrorMessage2()
    {
	return errorMessage2;
    }

    public void setErrorMessage2(String errorMessage2)
    {
	this.errorMessage2 = errorMessage2;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }
	
}
