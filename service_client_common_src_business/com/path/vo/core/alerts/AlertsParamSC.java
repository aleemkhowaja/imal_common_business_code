package com.path.vo.core.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class AlertsParamSC extends GridParamsSC
{
    private BigDecimal isWebVers;
    protected String actionType;
    protected String alertLabelKey;
    protected String alertSubType;
    protected String alertType;
    protected String allowLocalApproveOnly;
    protected String allowOffline = "0";
    protected BigDecimal allowToSend;
    protected BigDecimal amount;
    protected BigDecimal amountCV;
    protected String andOr;
    protected String andOrFlag;
    protected String appName;
    protected String authOdAcc;
    protected String branchCodeList;
    protected BigDecimal branchSubCode;
    protected String briefNameArab;
    protected String briefNameEnglish;
    protected BigDecimal CIF_NO;
    protected String cifNb;
    protected BigDecimal cifType;
    protected BigDecimal compSubCode;
    protected String distributionTo;
    protected String distributionType;
    protected BigDecimal ecoSector;
    protected String entityType;
    protected BigDecimal glCode;
    protected String highLightMap;
    protected String isLang;
    protected String isMultibranch;
    protected String ivCrud;
    protected String longNameArab;
    protected String longNameEnglish;
    protected BigDecimal priorityCode;
    protected String progRef;
    protected String parentRef;
    protected String reasonCode;
    protected String sendAlertCallBackFunction;
    protected String sendAlertCallBackOnChkPwd = Boolean.FALSE.toString();
    protected String sendAlertCallBackOnChkPwdSuccess = Boolean.FALSE.toString();
    protected String sendAlertCallBackOnItemClose = Boolean.FALSE.toString();
    protected String status;
    protected String statusCode;
    protected BigDecimal subTellerCode;
    protected String tellerId;
    protected BigDecimal tellerLevel;
    protected String todoAlert;
    protected String todoAlertOldStatus;
    protected String todoChecked;
    protected BigDecimal todoCode;
    protected String todoExcepArabic;
    protected String todoExcepEnglish;
    protected String todoExecution;
    protected String todoExternal;
    protected BigDecimal todoFrBranch;
    protected BigDecimal todoLine;
    protected String todoParam;
    protected String todoPriority;
    protected String todoRemarqs;
    protected BigDecimal todoTellerBranch;
    protected BigDecimal todoTellerId;
    protected String todoType;
    protected BigDecimal trs_cy;
    protected BigDecimal trsNo;
    protected BigDecimal trsType;
    protected String trxType;
    /* Login Alert Implementation TP#297149 */
    protected String enableLoginAlert;
    protected String additionalParams;
    protected Map<String, Object> additionalParamsMap = new HashMap<String, Object>();
    protected List<String> accessRightsOptList = new ArrayList<String>();
    protected String accessRightOptString ;
    
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getAlertLabelKey()
    {
        return alertLabelKey;
    }
    public void setAlertLabelKey(String alertLabelKey)
    {
        this.alertLabelKey = alertLabelKey;
    }
    public String getAlertSubType()
    {
        return alertSubType;
    }
    public void setAlertSubType(String alertSubType)
    {
        this.alertSubType = alertSubType;
    }
    public String getAlertType()
    {
        return alertType;
    }
    public void setAlertType(String alertType)
    {
        this.alertType = alertType;
    }
    public String getAllowLocalApproveOnly()
    {
        return allowLocalApproveOnly;
    }
    public void setAllowLocalApproveOnly(String allowLocalApproveOnly)
    {
        this.allowLocalApproveOnly = allowLocalApproveOnly;
    }
    public String getAllowOffline()
    {
        return allowOffline;
    }
    public void setAllowOffline(String allowOffline)
    {
        this.allowOffline = allowOffline;
    }
    public BigDecimal getAllowToSend()
    {
        return allowToSend;
    }
    public void setAllowToSend(BigDecimal allowToSend)
    {
        this.allowToSend = allowToSend;
    }
    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public BigDecimal getAmountCV()
    {
        return amountCV;
    }
    public void setAmountCV(BigDecimal amountCV)
    {
        this.amountCV = amountCV;
    }
    public String getAndOr()
    {
        return andOr;
    }
    public void setAndOr(String andOr)
    {
        this.andOr = andOr;
    }
    public String getAndOrFlag()
    {
        return andOrFlag;
    }
    public void setAndOrFlag(String andOrFlag)
    {
        this.andOrFlag = andOrFlag;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getAuthOdAcc()
    {
        return authOdAcc;
    }
    public void setAuthOdAcc(String authOdAcc)
    {
        this.authOdAcc = authOdAcc;
    }
    public String getBranchCodeList()
    {
        return branchCodeList;
    }
    public void setBranchCodeList(String branchCodeList)
    {
        this.branchCodeList = branchCodeList;
    }
    public BigDecimal getBranchSubCode()
    {
        return branchSubCode;
    }
    public void setBranchSubCode(BigDecimal branchSubCode)
    {
        this.branchSubCode = branchSubCode;
    }
    public String getBriefNameArab()
    {
        return briefNameArab;
    }
    public void setBriefNameArab(String briefNameArab)
    {
        this.briefNameArab = briefNameArab;
    }
    public String getBriefNameEnglish()
    {
        return briefNameEnglish;
    }
    public void setBriefNameEnglish(String briefNameEnglish)
    {
        this.briefNameEnglish = briefNameEnglish;
    }
    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }
    public void setCIF_NO(BigDecimal cIFNO)
    {
        CIF_NO = cIFNO;
    }
    public String getCifNb()
    {
        return cifNb;
    }
    public void setCifNb(String cifNb)
    {
        this.cifNb = cifNb;
    }
    public BigDecimal getCifType()
    {
        return cifType;
    }
    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }
    public BigDecimal getCompSubCode()
    {
        return compSubCode;
    }
    public void setCompSubCode(BigDecimal compSubCode)
    {
        this.compSubCode = compSubCode;
    }
    public String getDistributionTo()
    {
        return distributionTo;
    }
    public void setDistributionTo(String distributionTo)
    {
        this.distributionTo = distributionTo;
    }
    public String getDistributionType()
    {
        return distributionType;
    }
    public void setDistributionType(String distributionType)
    {
        this.distributionType = distributionType;
    }
    public BigDecimal getEcoSector()
    {
        return ecoSector;
    }
    public void setEcoSector(BigDecimal ecoSector)
    {
        this.ecoSector = ecoSector;
    }
    public String getEntityType()
    {
        return entityType;
    }
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    public BigDecimal getGlCode()
    {
        return glCode;
    }
    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }
    public String getHighLightMap()
    {
        return highLightMap;
    }
    public void setHighLightMap(String highLightMap)
    {
        this.highLightMap = highLightMap;
    }
    public String getIsLang()
    {
        return isLang;
    }
    public void setIsLang(String isLang)
    {
        this.isLang = isLang;
    }
    public String getIsMultibranch()
    {
        return isMultibranch;
    }
    public void setIsMultibranch(String isMultibranch)
    {
        this.isMultibranch = isMultibranch;
    }
    public String getIvCrud()
    {
        return ivCrud;
    }
    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }
    public String getLongNameArab()
    {
        return longNameArab;
    }
    public void setLongNameArab(String longNameArab)
    {
        this.longNameArab = longNameArab;
    }
    public String getLongNameEnglish()
    {
        return longNameEnglish;
    }
    public void setLongNameEnglish(String longNameEnglish)
    {
        this.longNameEnglish = longNameEnglish;
    }
    public BigDecimal getPriorityCode()
    {
        return priorityCode;
    }
    public void setPriorityCode(BigDecimal priorityCode)
    {
        this.priorityCode = priorityCode;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public String getReasonCode()
    {
        return reasonCode;
    }
    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
    }
    public String getSendAlertCallBackFunction()
    {
        return sendAlertCallBackFunction;
    }
    public void setSendAlertCallBackFunction(String sendAlertCallBackFunction)
    {
        this.sendAlertCallBackFunction = sendAlertCallBackFunction;
    }
    public String getSendAlertCallBackOnChkPwd()
    {
        return sendAlertCallBackOnChkPwd;
    }
    public void setSendAlertCallBackOnChkPwd(String sendAlertCallBackOnChkPwd)
    {
        this.sendAlertCallBackOnChkPwd = sendAlertCallBackOnChkPwd;
    }
    public String getSendAlertCallBackOnChkPwdSuccess()
    {
        return sendAlertCallBackOnChkPwdSuccess;
    }
    public void setSendAlertCallBackOnChkPwdSuccess(String sendAlertCallBackOnChkPwdSuccess)
    {
        this.sendAlertCallBackOnChkPwdSuccess = sendAlertCallBackOnChkPwdSuccess;
    }
    public String getSendAlertCallBackOnItemClose()
    {
        return sendAlertCallBackOnItemClose;
    }
    public void setSendAlertCallBackOnItemClose(String sendAlertCallBackOnItemClose)
    {
        this.sendAlertCallBackOnItemClose = sendAlertCallBackOnItemClose;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getStatusCode()
    {
        return statusCode;
    }
    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }
    public BigDecimal getSubTellerCode()
    {
        return subTellerCode;
    }
    public void setSubTellerCode(BigDecimal subTellerCode)
    {
        this.subTellerCode = subTellerCode;
    }
    public String getTellerId()
    {
        return tellerId;
    }
    public void setTellerId(String tellerId)
    {
        this.tellerId = tellerId;
    }
    public BigDecimal getTellerLevel()
    {
        return tellerLevel;
    }
    public void setTellerLevel(BigDecimal tellerLevel)
    {
        this.tellerLevel = tellerLevel;
    }
    public String getTodoAlert()
    {
        return todoAlert;
    }
    public void setTodoAlert(String todoAlert)
    {
        this.todoAlert = todoAlert;
    }
    public String getTodoAlertOldStatus()
    {
        return todoAlertOldStatus;
    }
    public void setTodoAlertOldStatus(String todoAlertOldStatus)
    {
        this.todoAlertOldStatus = todoAlertOldStatus;
    }
    public String getTodoChecked()
    {
        return todoChecked;
    }
    public void setTodoChecked(String todoChecked)
    {
        this.todoChecked = todoChecked;
    }
    public BigDecimal getTodoCode()
    {
        return todoCode;
    }
    public void setTodoCode(BigDecimal todoCode)
    {
        this.todoCode = todoCode;
    }
    public String getTodoExcepArabic()
    {
        return todoExcepArabic;
    }
    public void setTodoExcepArabic(String todoExcepArabic)
    {
        this.todoExcepArabic = todoExcepArabic;
    }
    public String getTodoExcepEnglish()
    {
        return todoExcepEnglish;
    }
    public void setTodoExcepEnglish(String todoExcepEnglish)
    {
        this.todoExcepEnglish = todoExcepEnglish;
    }
    public String getTodoExecution()
    {
        return todoExecution;
    }
    public void setTodoExecution(String todoExecution)
    {
        this.todoExecution = todoExecution;
    }
    public String getTodoExternal()
    {
        return todoExternal;
    }
    public void setTodoExternal(String todoExternal)
    {
        this.todoExternal = todoExternal;
    }
    public BigDecimal getTodoFrBranch()
    {
        return todoFrBranch;
    }
    public void setTodoFrBranch(BigDecimal todoFrBranch)
    {
        this.todoFrBranch = todoFrBranch;
    }
    public BigDecimal getTodoLine()
    {
        return todoLine;
    }
    public void setTodoLine(BigDecimal todoLine)
    {
        this.todoLine = todoLine;
    }
    public String getTodoParam()
    {
        return todoParam;
    }
    public void setTodoParam(String todoParam)
    {
        this.todoParam = todoParam;
    }
    public String getTodoPriority()
    {
        return todoPriority;
    }
    public void setTodoPriority(String todoPriority)
    {
        this.todoPriority = todoPriority;
    }
    public String getTodoRemarqs()
    {
        return todoRemarqs;
    }
    public void setTodoRemarqs(String todoRemarqs)
    {
        this.todoRemarqs = todoRemarqs;
    }
    public BigDecimal getTodoTellerBranch()
    {
        return todoTellerBranch;
    }
    public void setTodoTellerBranch(BigDecimal todoTellerBranch)
    {
        this.todoTellerBranch = todoTellerBranch;
    }
    public BigDecimal getTodoTellerId()
    {
        return todoTellerId;
    }
    public void setTodoTellerId(BigDecimal todoTellerId)
    {
        this.todoTellerId = todoTellerId;
    }
    public String getTodoType()
    {
        return todoType;
    }
    public void setTodoType(String todoType)
    {
        this.todoType = todoType;
    }
    public BigDecimal getTrs_cy()
    {
        return trs_cy;
    }
    public void setTrs_cy(BigDecimal trsCy)
    {
        trs_cy = trsCy;
    }
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }
    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }
    public BigDecimal getTrsType()
    {
        return trsType;
    }
    public void setTrsType(BigDecimal trsType)
    {
        this.trsType = trsType;
    }
    public String getTrxType()
    {
        return trxType;
    }
    public void setTrxType(String trxType)
    {
        this.trxType = trxType;
    }
    public BigDecimal getIsWebVers()
    {
        return isWebVers;
    }
    public void setIsWebVers(BigDecimal isWebVers)
    {
        this.isWebVers = isWebVers;
    }
    public String getParentRef()
    {
        return parentRef;
    }
    public void setParentRef(String parentRef)
    {
        this.parentRef = parentRef;
    }
    public String getEnableLoginAlert()
    {
        return enableLoginAlert;
    }
    public void setEnableLoginAlert(String enableLoginAlert)
    {
        this.enableLoginAlert = enableLoginAlert;
    }
    /**
     * @return the additionalParams
     */
    public String getAdditionalParams()
    {
        return additionalParams;
    }
    /**
     * @param additionalParams the additionalParams to set
     */
    public void setAdditionalParams(String additionalParams)
    {
        this.additionalParams = additionalParams;
    }
    /**
     * @return the additionalParamsMap
     */
    public Map<String, Object> getAdditionalParamsMap()
    {
        return additionalParamsMap;
    }
    /**
     * @param additionalParamsMap the additionalParamsMap to set
     */
    public void setAdditionalParamsMap(Map<String, Object> additionalParamsMap)
    {
        this.additionalParamsMap = additionalParamsMap;
    }
    
    public List<String> getAccessRightsOptList()
    {
        return accessRightsOptList;
    }
    public void setAccessRightsOptList(List<String> accessRightsOptList)
    {
        this.accessRightsOptList = accessRightsOptList;
    }
    public String getAccessRightOptString()
    {
        return accessRightOptString;
    }
    public void setAccessRightOptString(String accessRightOptString)
    {
        this.accessRightOptString = accessRightOptString;
    }
}
