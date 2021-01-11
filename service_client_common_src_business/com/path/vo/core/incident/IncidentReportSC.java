package com.path.vo.core.incident;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: John Massaad
 * 
 *          IncidentReportSC.java used to
 */


public class IncidentReportSC extends GridParamsSC
{
    
    
    private BigDecimal incdCode;
    private String status;
    private String appName;
    private String progRef;
    private String lang;
    private String isFromAlert;
    private String statusLovType;
    private String alertStatus;
    private BigDecimal errorCode;
    private String errorMessage;
    
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public String getLang()
    {
        return lang;
    }
    public void setLang(String lang)
    {
        this.lang = lang;
    }
    public BigDecimal getIncdCode()
    {
        return incdCode;
    }
    public void setIncdCode(BigDecimal incdCode)
    {
        this.incdCode = incdCode;
    }
    public String getIsFromAlert()
    {
        return isFromAlert;
    }
    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }
    public String getStatusLovType()
    {
        return statusLovType;
    }
    public void setStatusLovType(String statusLovType)
    {
        this.statusLovType = statusLovType;
    }
    public String getAlertStatus()
    {
        return alertStatus;
    }
    public void setAlertStatus(String alertStatus)
    {
        this.alertStatus = alertStatus;
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
    

}
