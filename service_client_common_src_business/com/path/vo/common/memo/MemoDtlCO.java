package com.path.vo.common.memo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

public class MemoDtlCO extends RetailBaseVO
{

    private CTSMEMO_DETVO ctsMemoDetVO = new CTSMEMO_DETVO();
    private CTSMEMOVO ctsMemoVO = new CTSMEMOVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String cifDesc;
    private String langCode;
    private BigDecimal lovType;
    private String statusDesc;
    private String status;
    private String accRef;
    private String accReadOnly;
    private String cifReadOnly;
    private String dateIntervalReadOnly;
    private String app;
    private String language;
    private String AC_DESC;
    private String userName;
    private String type;
    private BigDecimal event;
    private String userIsBranchManager;
    private String currentApplication;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String isFromAlert;
    private String prefLanguage;
    private String checkArg;

    private ArrayList<SmartCO> smartCOList;
    private BigDecimal errorCode;
    private String errorMessage;
    private String allowCifCreationMaskYN;
    
    //Rania - DB180100 - Customers Segmentation Enhancement
    private String segmentReadOnly;
    private String segmentDesc;
    
    
    public CTSMEMO_DETVO getCtsMemoDetVO()
    {
	return ctsMemoDetVO;
    }

    public void setCtsMemoDetVO(CTSMEMO_DETVO ctsMemoDetVO)
    {
	this.ctsMemoDetVO = ctsMemoDetVO;
    }

    public CTSMEMOVO getCtsMemoVO()
    {
	return ctsMemoVO;
    }

    public void setCtsMemoVO(CTSMEMOVO ctsMemoVO)
    {
	this.ctsMemoVO = ctsMemoVO;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
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

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getAccRef()
    {
	return accRef;
    }

    public void setAccRef(String accRef)
    {
	this.accRef = accRef;
    }

    public String getAccReadOnly()
    {
	return accReadOnly;
    }

    public void setAccReadOnly(String accReadOnly)
    {
	this.accReadOnly = accReadOnly;
    }

    public String getCifReadOnly()
    {
	return cifReadOnly;
    }

    public void setCifReadOnly(String cifReadOnly)
    {
	this.cifReadOnly = cifReadOnly;
    }

    public String getApp()
    {
	return app;
    }

    public void setApp(String app)
    {
	this.app = app;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getDateIntervalReadOnly()
    {
	return dateIntervalReadOnly;
    }

    public void setDateIntervalReadOnly(String dateIntervalReadOnly)
    {
	this.dateIntervalReadOnly = dateIntervalReadOnly;
    }

    public String getAC_DESC()
    {
	return AC_DESC;
    }

    public void setAC_DESC(String aCDESC)
    {
	AC_DESC = aCDESC;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    public String getCurrentApplication()
    {
	return currentApplication;
    }

    public void setCurrentApplication(String currentApplication)
    {
	this.currentApplication = currentApplication;
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
	this.alertsParamCO = alertsParamCO;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public String getPrefLanguage()
    {
	return prefLanguage;
    }

    public void setPrefLanguage(String prefLanguage)
    {
	this.prefLanguage = prefLanguage;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    public String getCheckArg()
    {
	return checkArg;
    }

    public void setCheckArg(String checkArg)
    {
	this.checkArg = checkArg;
    }

    public BigDecimal getEvent()
    {
	return event;
    }

    public void setEvent(BigDecimal event)
    {
	this.event = event;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getSegmentReadOnly()
    {
        return segmentReadOnly;
    }

    public void setSegmentReadOnly(String segmentReadOnly)
    {
        this.segmentReadOnly = segmentReadOnly;
    }

    public String getSegmentDesc()
    {
        return segmentDesc;
    }

    public void setSegmentDesc(String segmentDesc)
    {
        this.segmentDesc = segmentDesc;
    }
    
}
