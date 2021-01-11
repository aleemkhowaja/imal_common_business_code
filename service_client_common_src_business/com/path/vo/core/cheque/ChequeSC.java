package com.path.vo.core.cheque;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: WissamChebli
 * 
 *          ChequeBookSC.java used to
 */
public class ChequeSC extends GridParamsSC
{
    private BigDecimal CODE;
    private String briefNameEng;
    private BigDecimal linkSerial;
    private BigDecimal ACC_BR;
    private BigDecimal ACC_CY;
    private BigDecimal ACC_GL;
    private BigDecimal ACC_CIF;
    private BigDecimal ACC_SL;
    private BigDecimal PREVIOUSNBR;
    private BigDecimal CHQBOOK_NUM;
    private String status;
    private String type;
    private Date runningDate;
    private String userName;
    private BigDecimal toNumber;
    private BigDecimal fromNumber;
    private String process;
    private String lang;
    private BigDecimal errorCode;
    private String errorMessage;
    private String addReference;
    private String chqType;
    private String userType;
    private BigDecimal deliveryMode;
    private List<String> inStatusList = new ArrayList<String>();
    private List<String> notInStatusList = new ArrayList<String>();
    private BigDecimal transactionNO;
    private String chequeUnique;
    private String flag;
    
    private BigDecimal cifTypeCode;
    private String billFlag;
    

    
    /**
     * @return the linkSerial
     */
    public BigDecimal getLinkSerial()
    {
	return linkSerial;
    }

    /**
     * @param linkSerial the linkSerial to set
     */
    public void setLinkSerial(BigDecimal linkSerial)
    {
	this.linkSerial = linkSerial;
    }

    /**
     * @return the cODE
     */
    public BigDecimal getCODE()
    {
	return CODE;
    }

    /**
     * @param cODE the cODE to set
     */
    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    /**
     * @return the aCC_BR
     */
    public BigDecimal getACC_BR()
    {
	return ACC_BR;
    }

    /**
     * @param aCCBR the aCC_BR to set
     */
    public void setACC_BR(BigDecimal aCCBR)
    {
	ACC_BR = aCCBR;
    }

    /**
     * @return the aCC_CY
     */
    public BigDecimal getACC_CY()
    {
	return ACC_CY;
    }

    /**
     * @param aCCCY the aCC_CY to set
     */
    public void setACC_CY(BigDecimal aCCCY)
    {
	ACC_CY = aCCCY;
    }

    /**
     * @return the aCC_GL
     */
    public BigDecimal getACC_GL()
    {
	return ACC_GL;
    }

    /**
     * @param aCCGL the aCC_GL to set
     */
    public void setACC_GL(BigDecimal aCCGL)
    {
	ACC_GL = aCCGL;
    }

    /**
     * @return the aCC_CIF
     */
    public BigDecimal getACC_CIF()
    {
	return ACC_CIF;
    }

    /**
     * @param aCCCIF the aCC_CIF to set
     */
    public void setACC_CIF(BigDecimal aCCCIF)
    {
	ACC_CIF = aCCCIF;
    }

    /**
     * @return the aCC_SL
     */
    public BigDecimal getACC_SL()
    {
	return ACC_SL;
    }

    /**
     * @param aCCSL the aCC_SL to set
     */
    public void setACC_SL(BigDecimal aCCSL)
    {
	ACC_SL = aCCSL;
    }

    /**
     * @return the pREVIOUSNBR
     */
    public BigDecimal getPREVIOUSNBR()
    {
	return PREVIOUSNBR;
    }

    /**
     * @param pREVIOUSNBR the pREVIOUSNBR to set
     */
    public void setPREVIOUSNBR(BigDecimal pREVIOUSNBR)
    {
	PREVIOUSNBR = pREVIOUSNBR;
    }

    /**
     * @return the cHQBOOK_NUM
     */
    public BigDecimal getCHQBOOK_NUM()
    {
	return CHQBOOK_NUM;
    }

    /**
     * @param cHQBOOKNUM the cHQBOOK_NUM to set
     */
    public void setCHQBOOK_NUM(BigDecimal cHQBOOKNUM)
    {
	CHQBOOK_NUM = cHQBOOKNUM;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
	this.status = status;
    }

    /**
     * @return the type
     */
    public String getType()
    {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
	this.type = type;
    }

    /**
     * @return the runningDate
     */
    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    /**
     * @param runningDate the runningDate to set
     */
    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
	return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    /**
     * @return the toNumber
     */
    public BigDecimal getToNumber()
    {
	return toNumber;
    }

    /**
     * @param toNumber the toNumber to set
     */
    public void setToNumber(BigDecimal toNumber)
    {
	this.toNumber = toNumber;
    }

    /**
     * @return the fromNumber
     */
    public BigDecimal getFromNumber()
    {
	return fromNumber;
    }

    /**
     * @param fromNumber the fromNumber to set
     */
    public void setFromNumber(BigDecimal fromNumber)
    {
	this.fromNumber = fromNumber;
    }

    /**
     * @return the process
     */
    public String getProcess()
    {
	return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(String process)
    {
	this.process = process;
    }

    /**
     * @return the lang
     */
    public String getLang()
    {
	return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang)
    {
	this.lang = lang;
    }

    /**
     * @return the errorCode
     */
    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
	return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    /**
     * @return the addReference
     */
    public String getAddReference()
    {
	return addReference;
    }

    /**
     * @param addReference the addReference to set
     */
    public void setAddReference(String addReference)
    {
	this.addReference = addReference;
    }

    /**
     * @return the chqType
     */
    public String getChqType()
    {
	return chqType;
    }

    /**
     * @param chqType the chqType to set
     */
    public void setChqType(String chqType)
    {
	this.chqType = chqType;
    }

    /**
     * @return the userType
     */
    public String getUserType()
    {
	return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType)
    {
	this.userType = userType;
    }

    /**
     * @return the deliveryMode
     */
    public BigDecimal getDeliveryMode()
    {
	return deliveryMode;
    }

    /**
     * @param deliveryMode the deliveryMode to set
     */
    public void setDeliveryMode(BigDecimal deliveryMode)
    {
	this.deliveryMode = deliveryMode;
    }

    public List<String> getInStatusList()
    {
        return inStatusList;
    }

    public void setInStatusList(List<String> inStatusList)
    {
        this.inStatusList = inStatusList;
    }

    public List<String> getNotInStatusList()
    {
        return notInStatusList;
    }

    public void setNotInStatusList(List<String> notInStatusList)
    {
        this.notInStatusList = notInStatusList;
    }

    public BigDecimal getTransactionNO()
    {
        return transactionNO;
    }

    public void setTransactionNO(BigDecimal transactionNO)
    {
        this.transactionNO = transactionNO;
    }

    public String getChequeUnique()
    {
        return chequeUnique;
    }

    public void setChequeUnique(String chequeUnique)
    {
        this.chequeUnique = chequeUnique;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public String getBriefNameEng()
    {
	return briefNameEng;
    }

    public void setBriefNameEng(String briefNameEng)
    {
	this.briefNameEng = briefNameEng;
    }

    public String getBillFlag()
    {
	return billFlag;
    }

    public void setBillFlag(String billFlag)
    {
	this.billFlag = billFlag;
    }
}
