/**
 * 
 */
package com.path.vo.core.alerts;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * AlertsRequestParamSC.java used to
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AlertsRequestParamSC
{
    private String senderUserId;//sender user: user who is sending the alert
    private String receiverUserId;//receiver user: user who will receive the alert
    private BigDecimal compCode;//login compCode
    private BigDecimal branchCode;//login branchCode
    private String todoApplication;//the login application, the application in which we need to send the alert
    private Date dateReceived;//the running date, or current date
    private String todoParam;//the primary key of the alert item
    private String todoAlert;//used to define a specific value SYS_PARAM_TODO_ALERT_TYPE
    private Date noActionTime;//define the no_action_time, for example : add 5 min to the current date, the alert should be delayed for 5 min then received
    private String todoProgRef;//the next progref of the alert 
    private String alertDesc;//the alert description filled in S_TODO_DET.ALERT_DESC
    
    public String getSenderUserId()
    {
        return senderUserId;
    }
    public void setSenderUserId(String senderUserId)
    {
        this.senderUserId = senderUserId;
    }
    public String getReceiverUserId()
    {
        return receiverUserId;
    }
    public void setReceiverUserId(String receiverUserId)
    {
        this.receiverUserId = receiverUserId;
    }
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    public String getTodoApplication()
    {
        return todoApplication;
    }
    public void setTodoApplication(String todoApplication)
    {
        this.todoApplication = todoApplication;
    }
    public Date getDateReceived()
    {
        return dateReceived;
    }
    public void setDateReceived(Date dateReceived)
    {
        this.dateReceived = dateReceived;
    }
    public String getTodoParam()
    {
        return todoParam;
    }
    public void setTodoParam(String todoParam)
    {
        this.todoParam = todoParam;
    }
    public String getTodoAlert()
    {
        return todoAlert;
    }
    public void setTodoAlert(String todoAlert)
    {
        this.todoAlert = todoAlert;
    }
    public Date getNoActionTime()
    {
        return noActionTime;
    }
    public void setNoActionTime(Date noActionTime)
    {
        this.noActionTime = noActionTime;
    }
    public String getTodoProgRef()
    {
        return todoProgRef;
    }
    public void setTodoProgRef(String todoProgRef)
    {
        this.todoProgRef = todoProgRef;
    }
    public String getAlertDesc()
    {
        return alertDesc;
    }
    public void setAlertDesc(String alertDesc)
    {
        this.alertDesc = alertDesc;
    }
    
}
