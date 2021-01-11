package com.path.vo.core.ctsteller;

import java.math.BigDecimal;
import java.util.List;

import com.path.vo.core.alerts.AlertsParamSC;

@SuppressWarnings("serial")
public class CTSTELLERSC extends AlertsParamSC
{
    private String alertDesc;
    private String alertDescTranslated;
    private BigDecimal autoIncr;
    private List<BigDecimal> branchCodeArrayList;
    private BigDecimal CIF_SUB_NO;
    private BigDecimal CURRENCY_CODE;
    private BigDecimal getUserPrivilege;
    private String initialUserId;
    //private Boolean isLocalApprove;
    private String language;
    private BigDecimal officerIdTellerCode;
    private BigDecimal onlineStatusLovType;
    private BigDecimal receiverCode;
    private String receiverUserId;
    private BigDecimal SL_NO;
    private BigDecimal statusLovType;
    private String subTellerUserId;
    private String tellerBr;
    private String userLevelMessage;
    private BigDecimal vaultType;
    private BigDecimal tellerCode;
    private String separatevaultType;

    //811911 "FIBSI180447 - Checking upon closing branch on teller cash box" EMail "FIBSI180447 - Checking upon closing branch on teller cash box"
    private String overPassFlag;
    
    public String getAlertDesc()
    {
        return alertDesc;
    }
    public void setAlertDesc(String alertDesc)
    {
        this.alertDesc = alertDesc;
    }
    public String getAlertDescTranslated()
    {
        return alertDescTranslated;
    }
    public void setAlertDescTranslated(String alertDescTranslated)
    {
        this.alertDescTranslated = alertDescTranslated;
    }
    public BigDecimal getAutoIncr()
    {
        return autoIncr;
    }
    public void setAutoIncr(BigDecimal autoIncr)
    {
        this.autoIncr = autoIncr;
    }
    public List<BigDecimal> getBranchCodeArrayList()
    {
        return branchCodeArrayList;
    }
    public void setBranchCodeArrayList(List<BigDecimal> branchCodeArrayList)
    {
        this.branchCodeArrayList = branchCodeArrayList;
    }
    public BigDecimal getCIF_SUB_NO()
    {
        return CIF_SUB_NO;
    }
    public void setCIF_SUB_NO(BigDecimal cIFSUBNO)
    {
        CIF_SUB_NO = cIFSUBNO;
    }
    public BigDecimal getCURRENCY_CODE()
    {
        return CURRENCY_CODE;
    }
    public void setCURRENCY_CODE(BigDecimal cURRENCYCODE)
    {
        CURRENCY_CODE = cURRENCYCODE;
    }
    public BigDecimal getGetUserPrivilege()
    {
        return getUserPrivilege;
    }
    public void setGetUserPrivilege(BigDecimal getUserPrivilege)
    {
        this.getUserPrivilege = getUserPrivilege;
    }
    public String getInitialUserId()
    {
        return initialUserId;
    }
    public void setInitialUserId(String initialUserId)
    {
        this.initialUserId = initialUserId;
    }
//    public Boolean getIsLocalApprove() 
//    {
//        return isLocalApprove;
//    }
//    public void setIsLocalApprove(Boolean isLocalApprove)
//    {
//        this.isLocalApprove = isLocalApprove;
//    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public BigDecimal getOfficerIdTellerCode()
    {
        return officerIdTellerCode;
    }
    public void setOfficerIdTellerCode(BigDecimal officerIdTellerCode)
    {
        this.officerIdTellerCode = officerIdTellerCode;
    }
    public BigDecimal getOnlineStatusLovType()
    {
        return onlineStatusLovType;
    }
    public void setOnlineStatusLovType(BigDecimal onlineStatusLovType)
    {
        this.onlineStatusLovType = onlineStatusLovType;
    }
    public BigDecimal getReceiverCode()
    {
        return receiverCode;
    }
    public void setReceiverCode(BigDecimal receiverCode)
    {
        this.receiverCode = receiverCode;
    }
    public String getReceiverUserId()
    {
        return receiverUserId;
    }
    public void setReceiverUserId(String receiverUserId)
    {
        this.receiverUserId = receiverUserId;
    }
    public BigDecimal getSL_NO()
    {
        return SL_NO;
    }
    public void setSL_NO(BigDecimal sLNO)
    {
        SL_NO = sLNO;
    }
    public BigDecimal getStatusLovType()
    {
        return statusLovType;
    }
    public void setStatusLovType(BigDecimal statusLovType)
    {
        this.statusLovType = statusLovType;
    }
    public String getSubTellerUserId()
    {
        return subTellerUserId;
    }
    public void setSubTellerUserId(String subTellerUserId)
    {
        this.subTellerUserId = subTellerUserId;
    }
    public String getTellerBr()
    {
        return tellerBr;
    }
    public void setTellerBr(String tellerBr)
    {
        this.tellerBr = tellerBr;
    }
    public String getUserLevelMessage()
    {
        return userLevelMessage;
    }
    public void setUserLevelMessage(String userLevelMessage)
    {
        this.userLevelMessage = userLevelMessage;
    }
    public BigDecimal getVaultType()
    {
        return vaultType;
    }
    public void setVaultType(BigDecimal vaultType)
    {
        this.vaultType = vaultType;
    }
    public String getSeparatevaultType()
    {
        return separatevaultType;
    }
    public void setSeparatevaultType(String separatevaultType)
    {
        this.separatevaultType = separatevaultType;
    }
    public String getOverPassFlag()
    {
        return overPassFlag;
    }
    public void setOverPassFlag(String overPassFlag)
    {
        this.overPassFlag = overPassFlag;
    }
    
    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }
    
}
