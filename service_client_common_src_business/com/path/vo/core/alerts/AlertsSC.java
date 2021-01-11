package com.path.vo.core.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class AlertsSC extends GridParamsSC 
{
    	private String parameters;
        private BigDecimal errorCode;
        private String errorMessage;
        private String receiverCode;
        private String appName;
	private String progRef;
	private String ivCrud;
	private BigDecimal trsNo;
	private String alertType;
	private String reasonCode;
	private BigDecimal amount;
	private String status;
	private String subtype;
	private String tellerBr;
	private String tellerId; 
	private Date alertWaitingTime;
	private Date dateReceived;
	private String todoAlert;
	private String alertDesc;
	private String alertCode;
	private String isNewUser;
        private String userAction;
        private String language;
        private String todoRefreshTime;
        private String jobAction;
        private String todoParam;
	private String trsNumber;
	private String receivedFrom;
	private String todoType;
	private BigDecimal todoCode;
	private BigDecimal jobId;
	private BigDecimal todoLine;
	private String currentAppName;//current application logged in
	private String briefNameEng;
	private String briefNameAra;
	private List<String> usersList;
	private Date nextPushDate;
	private String alertAddCode;
	private String updateAllTrx;
	private BigDecimal trsType;
	private String 	processed;
	private String 	entityType;
	private BigDecimal entityTypeCode;
	private String statusCode;
	private BigDecimal statusOrder;
	private List<String> appNameList;
	private String activate;
	private String noApprovalPrivilege;
	private BigDecimal lineNo;
	private BigDecimal level;
	private String multiBranch;
	private String group;
	private String todoExcepEnglish;
	
	private String loadTrxDetailsFunc;
	private String loadTrxDetailsJs;
	private String loadTrxDetailsJsPath;
	private BigDecimal todoFrBranch;
	
	private String alertByCompBranch;
	
	private BigDecimal  todoAlertLovType;
	private BigDecimal  todoAlertDescLovType;
	private BigDecimal  batchNo;
	private String profType;
	private List<String> accessRightsOptList = new ArrayList<String>();
	
	/* Login Alert Implementation TP#297149 */
	private String enableLoginAlert;
	private String hostName;
	private String allowToSend;
	private String manualOpen;
	/**
	 * [Marwan Maddah]
	 * added to be saved on the log tables 
	 * used in AlertsBO.updateAlertLoginApprovalDate
	 */
	private String webHttpSessionId;
	
	//TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	private BigDecimal isWebVers;
	
	public BigDecimal getLineNo()
	{
	    return lineNo;
	}
	public void setLineNo(BigDecimal lineNo)
	{
	    this.lineNo = lineNo;
	}
	public String getProcessed()
	{
	    return processed;
	}
	public void setProcessed(String processed)
	{
	    this.processed = processed;
	}
	public String getEntityType()
	{
	    return entityType;
	}
	public void setEntityType(String entityType)
	{
	    this.entityType = entityType;
	}
	public Date getNextPushDate()
	{
	    return nextPushDate;
	}
	public void setNextPushDate(Date nextPushDate)
	{
	    this.nextPushDate = nextPushDate;
	}
	public String getReceiverCode()
	{
	    return receiverCode;
	}
	public void setReceiverCode(String receiverCode)
	{
	    this.receiverCode = receiverCode;
	}
	public String getLanguage()
	{
	    return language;
	}
	public void setLanguage(String language)
	{
	    this.language = language;
	}
	public String getTodoRefreshTime()
	{
	    return todoRefreshTime;
	}
	public void setTodoRefreshTime(String todoRefreshTime)
	{
	    this.todoRefreshTime = todoRefreshTime;
	}
	public String getUserAction()
	{
	    return userAction;
	}
	public void setUserAction(String userAction)
	{
	    this.userAction = userAction;
	}
	public String getJobAction()
	{
	    return jobAction;
	}
	public void setJobAction(String jobAction)
	{
	    this.jobAction = jobAction;
	}
	
	public String getSubtype()
	{
	    return subtype;
	}
	public void setSubtype(String subtype)
	{
	    this.subtype = subtype;
	}
	public String getTodoAlert()
	{
	    return todoAlert;
	}
	public void setTodoAlert(String todoAlert)
	{
	    this.todoAlert = todoAlert;
	}
	public String getAlertDesc()
	{
	    return alertDesc;
	}
	public void setAlertDesc(String alertDesc)
	{
	    this.alertDesc = alertDesc;
	}
	public String getAlertCode()
	{
	    return alertCode;
	}
	public void setAlertCode(String alertCode)
	{
	    this.alertCode = alertCode;
	}
	public String getTodoParam()
	{
	    return todoParam;
	}
	public void setTodoParam(String todoParam)
	{
	    this.todoParam = todoParam;
	}
	public String getTrsNumber()
	{
	    return trsNumber;
	}
	public void setTrsNumber(String trsNumber)
	{
	    this.trsNumber = trsNumber;
	}
	public String getReceivedFrom()
	{
	    return receivedFrom;
	}
	public void setReceivedFrom(String receivedFrom)
	{
	    this.receivedFrom = receivedFrom;
	}
	public String getTodoType()
	{
	    return todoType;
	}
	public void setTodoType(String todoType)
	{
	    this.todoType = todoType;
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
	public String getIsNewUser()
	{
	    return isNewUser;
	}
	public void setIsNewUser(String isNewUser)
	{
	    this.isNewUser = isNewUser;
	}
	
	public Date getDateReceived()
	{
	    return dateReceived;
	}
	public void setDateReceived(Date dateReceived)
	{
	    this.dateReceived = dateReceived;
	}
	public BigDecimal getJobId()
	{
	    return jobId;
	}
	public void setJobId(BigDecimal jobId)
	{
	    this.jobId = jobId;
	}
	public String getBriefNameEng()
	{
	    return briefNameEng;
	}
	public void setBriefNameEng(String briefNameEng)
	{
	    this.briefNameEng = briefNameEng;
	}
	public String getBriefNameAra()
	{
	    return briefNameAra;
	}
	public void setBriefNameAra(String briefNameAra)
	{
	    this.briefNameAra = briefNameAra;
	}
	public String getCurrentAppName()
	{
	    return currentAppName;
	}
	public void setCurrentAppName(String currentAppName)
	{
	    this.currentAppName = currentAppName;
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
	public String getIvCrud()
	{
	    return ivCrud;
	}
	public void setIvCrud(String ivCrud)
	{
	    this.ivCrud = ivCrud;
	}
	public BigDecimal getTrsNo()
	{
	    return trsNo;
	}
	public void setTrsNo(BigDecimal trsNo)
	{
	    this.trsNo = trsNo;
	}
	public String getAlertType()
	{
	    return alertType;
	}
	public void setAlertType(String alertType)
	{
	    this.alertType = alertType;
	}
	public String getReasonCode()
	{
	    return reasonCode;
	}
	public void setReasonCode(String reasonCode)
	{
	    this.reasonCode = reasonCode;
	}
	public BigDecimal getAmount()
	{
	    return amount;
	}
	public void setAmount(BigDecimal amount)
	{
	    this.amount = amount;
	}
	public String getStatus()
	{
	    return status;
	}
	public void setStatus(String status)
	{
	    this.status = status;
	}
	public String getTellerBr()
	{
	    return tellerBr;
	}
	public void setTellerBr(String tellerBr)
	{
	    this.tellerBr = tellerBr;
	}
	public String getTellerId()
	{
	    return tellerId;
	}
	public void setTellerId(String tellerId)
	{
	    this.tellerId = tellerId;
	}
	public Date getAlertWaitingTime()
	{
	    return alertWaitingTime;
	}
	public void setAlertWaitingTime(Date alertWaitingTime)
	{
	    this.alertWaitingTime = alertWaitingTime;
	}
	public BigDecimal getTodoCode()
	{
	    return todoCode;
	}
	public void setTodoCode(BigDecimal todoCode)
	{
	    this.todoCode = todoCode;
	}
	public BigDecimal getTodoLine()
	{
	    return todoLine;
	}
	public void setTodoLine(BigDecimal todoLine)
	{
	    this.todoLine = todoLine;
	}
	public List<String> getUsersList()
	{
	    return usersList;
	}
	public void setUsersList(List<String> usersList)
	{
	    this.usersList = usersList;
	}
	public String getAlertAddCode()
	{
	    return alertAddCode;
	}
	public void setAlertAddCode(String alertAddCode)
	{
	    this.alertAddCode = alertAddCode;
	}
	public String getUpdateAllTrx()
	{
	    return updateAllTrx;
	}
	public void setUpdateAllTrx(String updateAllTrx)
	{
	    this.updateAllTrx = updateAllTrx;
	}
	public BigDecimal getTrsType()
	{
	    return trsType;
	}
	public void setTrsType(BigDecimal trsType)
	{
	    this.trsType = trsType;
	}
	public String getStatusCode()
	{
	    return statusCode;
	}
	public void setStatusCode(String statusCode)
	{
	    this.statusCode = statusCode;
	}
	public BigDecimal getStatusOrder()
	{
	    return statusOrder;
	}
	public void setStatusOrder(BigDecimal statusOrder)
	{
	    this.statusOrder = statusOrder;
	}
	public List<String> getAppNameList()
	{
	    return appNameList;
	}
	public void setAppNameList(List<String> appNameList)
	{
	    this.appNameList = appNameList;
	}
	public String getActivate()
	{
	    return activate;
	}
	public void setActivate(String activate)
	{
	    this.activate = activate;
	}
	public String getNoApprovalPrivilege()
	{
	    return noApprovalPrivilege;
	}
	public void setNoApprovalPrivilege(String noApprovalPrivilege)
	{
	    this.noApprovalPrivilege = noApprovalPrivilege;
	}
	public BigDecimal getEntityTypeCode()
	{
	    return entityTypeCode;
	}
	public void setEntityTypeCode(BigDecimal entityTypeCode)
	{
	    this.entityTypeCode = entityTypeCode;
	}
	
	public BigDecimal getLevel()
	{
	    return level;
	}
	public void setLevel(BigDecimal level)
	{
	    this.level = level;
	}
	public String getMultiBranch()
	{
	    return multiBranch;
	}
	public void setMultiBranch(String multiBranch)
	{
	    this.multiBranch = multiBranch;
	}
	public String getGroup()
	{
	    return group;
	}
	public void setGroup(String group)
	{
	    this.group = group;
	}
	
	public String getTodoExcepEnglish()
	{
	    return todoExcepEnglish;
	}
	public void setTodoExcepEnglish(String todoExcepEnglish)
	{
	    this.todoExcepEnglish = todoExcepEnglish;
	}
	public String getLoadTrxDetailsFunc()
	{
	    return loadTrxDetailsFunc;
	}
	public void setLoadTrxDetailsFunc(String loadTrxDetailsFunc)
	{
	    this.loadTrxDetailsFunc = loadTrxDetailsFunc;
	}
	public String getLoadTrxDetailsJs()
	{
	    return loadTrxDetailsJs;
	}
	public void setLoadTrxDetailsJs(String loadTrxDetailsJs)
	{
	    this.loadTrxDetailsJs = loadTrxDetailsJs;
	}
	public String getLoadTrxDetailsJsPath()
	{
	    return loadTrxDetailsJsPath;
	}
	public void setLoadTrxDetailsJsPath(String loadTrxDetailsJsPath)
	{
	    this.loadTrxDetailsJsPath = loadTrxDetailsJsPath;
	}
	public BigDecimal getTodoFrBranch()
	{
	    return todoFrBranch;
	}
	public void setTodoFrBranch(BigDecimal todoFrBranch)
	{
	    this.todoFrBranch = todoFrBranch;
	}
	public String getAlertByCompBranch()
	{
	    return alertByCompBranch;
	}
	public void setAlertByCompBranch(String alertByCompBranch)
	{
	    this.alertByCompBranch = alertByCompBranch;
	}
	public BigDecimal getTodoAlertLovType()
	{
	    return todoAlertLovType;
	}
	public void setTodoAlertLovType(BigDecimal todoAlertLovType)
	{
	    this.todoAlertLovType = todoAlertLovType;
	}
	public BigDecimal getTodoAlertDescLovType()
	{
	    return todoAlertDescLovType;
	}
	public void setTodoAlertDescLovType(BigDecimal todoAlertDescLovType)
	{
	    this.todoAlertDescLovType = todoAlertDescLovType;
	}
	public BigDecimal getBatchNo()
	{
	    return batchNo;
	}
	public void setBatchNo(BigDecimal batchNo)
	{
	    this.batchNo = batchNo;
	}
	public String getParameters()
	{
	    return parameters;
	}
	public void setParameters(String parameters)
	{
	    this.parameters = parameters;
	}
	public String getProfType()
	{
	    return profType;
	}
	public void setProfType(String profType)
	{
	    this.profType = profType;
	}
	public String getEnableLoginAlert()
	{
	    return enableLoginAlert;
	}
	public void setEnableLoginAlert(String enableLoginAlert)
	{
	    this.enableLoginAlert = enableLoginAlert;
	}
	public String getHostName()
	{
	    return hostName;
	}
	public void setHostName(String hostName)
	{
	    this.hostName = hostName;
	}
	/**
	 * @return the webHttpSessionId
	 */
	public String getWebHttpSessionId()
	{
	    return webHttpSessionId;
	}
	/**
	 * @param webHttpSessionId the webHttpSessionId to set
	 */
	public void setWebHttpSessionId(String webHttpSessionId)
	{
	    this.webHttpSessionId = webHttpSessionId;
	}
	public List<String> getAccessRightsOptList()
	{
	    return accessRightsOptList;
	}
	public void setAccessRightsOptList(List<String> accessRightsOptList)
	{
	    this.accessRightsOptList = accessRightsOptList;
	}
	public String getAllowToSend()
	{
	    return allowToSend;
	}
	public void setAllowToSend(String allowToSend)
	{
	    this.allowToSend = allowToSend;
	}
	
	/**
	 * @return the manualOpen
	 */
	public String getManualOpen()
	{
	    return manualOpen;
	}
	/**
	 * @param manualOpen the manualOpen to set
	 */
	public void setManualOpen(String manualOpen)
	{
	    this.manualOpen = manualOpen;
	}
	
	public BigDecimal getIsWebVers() 
	{
		return isWebVers;
	}
	
	public void setIsWebVers(BigDecimal isWebVers) 
	{
		this.isWebVers = isWebVers;
	}
	
}
