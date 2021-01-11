package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.MOSBLACKLISTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

public class BlackListCO extends RetailBaseVO
{
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private MOSBLACKLISTVO blackListVO = new MOSBLACKLISTVO();
    private CIFCO cifCO = new CIFCO();

    private String statusDesc;
    private String legalStatusDesc;
    private String cifDesc;
    private String countriesDesc;
    private String regionDesc;
    private String nationDesc;
    private String ciftypeDesc;
    private String issueCountryDesc;
    private String codeSourceDesc;
    private String typeDesc;
    private String preferredLanguage;
    private String userId;
    private String app;
    private String pageRef;
    private boolean messageConfirmed;
    private String actionType;

    private AuditRefCO auditRefCO; // for audit reference setting to be common
    List<BlackListIdsCO> blackListIdsList = new ArrayList<BlackListIdsCO>();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private String userIsBranchManager;
    private String localApproveUserName;;
    private boolean isFromAlert;
    private boolean isRemoteAlertApprove;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String nickName;
    private String allowCifCreationMaskYN;
    //SmartCO list
    private ArrayList<SmartCO> smartCOList;
    
       
    private BigDecimal returnedValue;//Hasan BMO160011 27/01/2016
    private BigDecimal reasonCode;

    public BigDecimal getReturnedValue()
    {
        return returnedValue;
    }

    public void setReturnedValue(BigDecimal returnedValue)
    {
        this.returnedValue = returnedValue;
    }

    public MOSBLACKLISTVO getBlackListVO()
    {
	return blackListVO;
    }

    public void setBlackListVO(MOSBLACKLISTVO blackListVO)
    {
	this.blackListVO = blackListVO;
    }

    public CIFCO getCifCO()
    {
        return cifCO;
    }

    public void setCifCO(CIFCO cifCO)
    {
        this.cifCO = cifCO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getLegalStatusDesc()
    {
	return legalStatusDesc;
    }

    public void setLegalStatusDesc(String legalStatusDesc)
    {
	this.legalStatusDesc = legalStatusDesc;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
    }

    public String getCountriesDesc()
    {
	return countriesDesc;
    }

    public void setCountriesDesc(String countriesDesc)
    {
	this.countriesDesc = countriesDesc;
    }

    public String getRegionDesc()
    {
	return regionDesc;
    }

    public void setRegionDesc(String regionDesc)
    {
	this.regionDesc = regionDesc;
    }

    public String getNationDesc()
    {
	return nationDesc;
    }

    public void setNationDesc(String nationDesc)
    {
	this.nationDesc = nationDesc;
    }

    public String getCiftypeDesc()
    {
	return ciftypeDesc;
    }

    public void setCiftypeDesc(String ciftypeDesc)
    {
	this.ciftypeDesc = ciftypeDesc;
    }

    public String getIssueCountryDesc()
    {
	return issueCountryDesc;
    }

    public void setIssueCountryDesc(String issueCountryDesc)
    {
	this.issueCountryDesc = issueCountryDesc;
    }

    public String getTypeDesc()
    {
	return typeDesc;
    }

    public void setTypeDesc(String typeDesc)
    {
	this.typeDesc = typeDesc;
    }

    public String getCodeSourceDesc()
    {
	return codeSourceDesc;
    }

    public void setCodeSourceDesc(String codeSourceDesc)
    {
	this.codeSourceDesc = codeSourceDesc;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public AuditRefCO getAuditRefCO()
    {
	return auditRefCO;
    }

    public void setAuditRefCO(AuditRefCO auditRefCO)
    {
	this.auditRefCO = auditRefCO;
    }

    public List<BlackListIdsCO> getBlackListIdsList()
    {
	return blackListIdsList;
    }

    public void setBlackListIdsList(List<BlackListIdsCO> blackListIdsList)
    {
	this.blackListIdsList = blackListIdsList;
    }

    public String getApp()
    {
	return app;
    }

    public void setApp(String app)
    {
	this.app = app;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public boolean getMessageConfirmed()
    {
	return messageConfirmed;
    }

    public void setMessageConfirmed(boolean messageConfirmed)
    {
	this.messageConfirmed = messageConfirmed;
    }

    public String getActionType()
    {
	return actionType;
    }

    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    public String getLocalApproveUserName()
    {
	return localApproveUserName;
    }

    public void setLocalApproveUserName(String localApproveUserName)
    {
	this.localApproveUserName = localApproveUserName;
    }

    public boolean getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(boolean isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public boolean getIsRemoteAlertApprove()
    {
	return isRemoteAlertApprove;
    }

    public void setIsRemoteAlertApprove(boolean isRemoteAlertApprove)
    {
	this.isRemoteAlertApprove = isRemoteAlertApprove;
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
	this.alertsParamCO = alertsParamCO;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}

	public String getNickName()
	{
	    return nickName;
	}

	public void setNickName(String nickName)
	{
	    this.nickName = nickName;
	}

	
	public BigDecimal getReasonCode()
	{
	    return reasonCode;
	}

	public void setReasonCode(BigDecimal reasonCode)
	{
	    this.reasonCode = reasonCode;
	}

	public String getAllowCifCreationMaskYN()
	{
	    return allowCifCreationMaskYN;
	}

	public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
	{
	    this.allowCifCreationMaskYN = allowCifCreationMaskYN;
	}

    
}
