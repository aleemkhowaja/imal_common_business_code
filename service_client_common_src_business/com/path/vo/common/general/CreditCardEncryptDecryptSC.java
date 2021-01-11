package com.path.vo.common.general;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CreditCardEncryptDecryptSC extends GridParamsSC
{
    String encryptedCardNo;
    String clearString;
    BigDecimal cif;
    BigDecimal applCode;
    BigDecimal subLimitLineNo;
    BigDecimal lineNo;
    String unEncryptedCardNumber;
    String oldEncryptionKey;
    String encryptedData;

    private BigDecimal errorCode;
    private String errorDescription;

    public String getEncryptedCardNo()
    {
	return encryptedCardNo;
    }

    public void setEncryptedCardNo(String encryptedCardNo)
    {
	this.encryptedCardNo = encryptedCardNo;
    }

    public String getClearString()
    {
	return clearString;
    }

    public void setClearString(String clearString)
    {
	this.clearString = clearString;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public BigDecimal getApplCode()
    {
	return applCode;
    }

    public void setApplCode(BigDecimal applCode)
    {
	this.applCode = applCode;
    }

    public BigDecimal getSubLimitLineNo()
    {
	return subLimitLineNo;
    }

    public void setSubLimitLineNo(BigDecimal subLimitLineNo)
    {
	this.subLimitLineNo = subLimitLineNo;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public String getUnEncryptedCardNumber()
    {
	return unEncryptedCardNumber;
    }

    public void setUnEncryptedCardNumber(String unEncryptedCardNumber)
    {
	this.unEncryptedCardNumber = unEncryptedCardNumber;
    }

    public String getOldEncryptionKey()
    {
	return oldEncryptionKey;
    }

    public void setOldEncryptionKey(String oldEncryptionKey)
    {
	this.oldEncryptionKey = oldEncryptionKey;
    }

    public String getEncryptedData()
    {
	return encryptedData;
    }

    public void setEncryptedData(String encryptedData)
    {
	this.encryptedData = encryptedData;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorDescription()
    {
	return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
	this.errorDescription = errorDescription;
    }

}
