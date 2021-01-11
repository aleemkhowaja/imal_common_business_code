package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: johnmassaad
 *
 * FOMRealBeneficiariesSC.java used to
 */
public class FOMRealBeneficiariesSC extends GridParamsSC
{
	private BigDecimal cifNo;
	private BigDecimal linkCIFNo;
	private Date myDate;
	private String myName;
	private String fromField;
	private String idNO;
	private BigDecimal lineNo;
	private String transferType;
	private String additionalReference;
	private BigDecimal glCode;
	private String benefAccNo;
	private String preferredLanguage;
	private String nickName;
	private BigDecimal compCodeCif;
	
        // Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
        private String parentNickName;
        private String parentChildInd;
        private BigDecimal subLineNo;
        //

	public void setMyDate(Date myDate)
	{
		this.myDate = myDate;
	}
	public Date getMyDate()
	{
		return myDate;
	}
	public void setMyName(String myName)
	{
		this.myName = myName;
	}
	public String getMyName()
	{
		return myName;
	}
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	public String getFromField()
	{
	    return fromField;
	}
	public void setFromField(String fromField)
	{
	    this.fromField = fromField;
	}
	public BigDecimal getLinkCIFNo()
	{
	    return linkCIFNo;
	}
	public void setLinkCIFNo(BigDecimal linkCIFNo)
	{
	    this.linkCIFNo = linkCIFNo;
	}
	public String getIdNO()
	{
	    return idNO;
	}
	public void setIdNO(String idNO)
	{
	    this.idNO = idNO;
	}
	public BigDecimal getLineNo()
	{
	    return lineNo;
	}
	public void setLineNo(BigDecimal lineNo)
	{
	    this.lineNo = lineNo;
	}
	public String getTransferType()
	{
	    return transferType;
	}
	public void setTransferType(String transferType)
	{
	    this.transferType = transferType;
	}
	public String getAdditionalReference()
	{
	    return additionalReference;
	}
	public void setAdditionalReference(String additionalReference)
	{
	    this.additionalReference = additionalReference;
	}
	public BigDecimal getGlCode()
	{
	    return glCode;
	}
	public void setGlCode(BigDecimal glCode)
	{
	    this.glCode = glCode;
	}
	public String getBenefAccNo()
	{
	    return benefAccNo;
	}
	public void setBenefAccNo(String benefAccNo)
	{
	    this.benefAccNo = benefAccNo;
	}
	public String getPreferredLanguage()
	{
	    return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage)
	{
	    this.preferredLanguage = preferredLanguage;
	}
	public String getNickName()
	{
	    return nickName;
	}
	public void setNickName(String nickName)
	{
	    this.nickName = nickName;
	}
	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}
	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	public String getParentChildInd()
	{
	    return parentChildInd;
	}
	public void setParentChildInd(String parentChildInd)
	{
	    this.parentChildInd = parentChildInd;
	}
	public BigDecimal getSubLineNo()
	{
	    return subLineNo;
	}
	public void setSubLineNo(BigDecimal subLineNo)
	{
	    this.subLineNo = subLineNo;
	}
	public String getParentNickName()
	{
	    return parentNickName;
	}
	public void setParentNickName(String parentNickName)
	{
	    this.parentNickName = parentNickName;
	}
}
