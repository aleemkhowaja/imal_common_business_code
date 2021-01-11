package com.path.vo.core.specialconditions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CTSSPCONDVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.core.common.RetailBaseVO;

@SuppressWarnings("serial")
public final class SpecialConditionsCO extends RetailBaseVO
{
    private String reasonType = String.valueOf(5);
    private String voidReasonType = String.valueOf(1);
    private String requesterSourceAsReasonType = String.valueOf(17);
    private CTSSPCONDVO specialConditionsVO = new CTSSPCONDVO();
    private String cifOrAccountName;
    private String accountName;
    private String cifName;
    private String administrationName;
    private BigDecimal requesterSourceCode;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenToPropertyHashMap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String pageRef;
    private String allowStandingOrder;
    private String isBranchManager;
    private AlertsParamCO alertsParamCO;
    private String isFromAlert;
    private String userConfirmation;
    private String printBatchSuccessMessage;
    private List<ReportResponseCO> reportResponseSPCONDSList = new ArrayList<ReportResponseCO>();
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private List<String> statusList;
    private List<BigDecimal> condAutoList;

    private String statusDescription;
    private String entityTypeDescription;
    private String forbidRestrictTrxDescription;
    private String forbidProductDescription;
    private String recordSourceDescription;
    private String specificBranchUpdates;
    private List<SpCondSpecificBranchCO> SpCondSpecificBranchCOs;
    private SpCondSpecificBranchCO spCondSpecificBranchCO  = new SpCondSpecificBranchCO();
    private String BranchCentralisation; // BB110153 - Special Condition
    private BigDecimal specialConditionListOpen; // added by nancy -- 12/05/2018-- Bug 667600
    private String fromPrintSpecialCond; // added by nancy -- 12/05/2018-- Bug 667600
    private String fromPrintMenuSpecialCond; // added by nancy -- 12/05/2018-- Bug 667600
    private ArrayList<String> warningMessagesList = new ArrayList<String>(); 

    private String allowCifCreationMaskYN;
    private String voidReasonCodeDesc;
    
    private String forbidProductExceptionOpened;
    private SpecialConditionsExceptionCO spCondExceptionCO;
    private String spCondForbidProductExceptionCOsStr;
    private List<SpecialConditionsExceptionCO> spCondForbidProductExceptionCOsList = new ArrayList<SpecialConditionsExceptionCO>();
    private int whichDate;
    private String fromSave;
    

    private List<SpecialCondForbidExcepCO> specialCondForbidExcepCOs;
    private String forbidExcepCreditUpdates;
    private String forbidExcepDebitUpdates;
    private List<SpecialCondForbidExcepCO> spCondforbidExcepCreditCOs;
    private List<SpecialCondForbidExcepCO> spCondforbidExcepDebitCOs;
    private String crDrForex;
    private BigDecimal exceptionLineNo;
    private String additional_Reference;
    private String iban_Acc_Number;
    



    public void setSpecialConditionsVO(final CTSSPCONDVO obj)
    {
	specialConditionsVO = obj;
    }

    public CTSSPCONDVO getSpecialConditionsVO()
    {
	return specialConditionsVO;
    }

    public String getAdministrationName()
    {
	return administrationName;
    }

    public void setAdministrationName(String obj)
    {
	administrationName = obj;
    }

    public String getReasonType()
    {
	return reasonType;
    }

    public String getRequesterSourceAsReasonType()
    {
	return requesterSourceAsReasonType;
    }

    public void setCifOrAccountName(String obj)
    {
	cifOrAccountName = obj;
	if(StringUtil.isNotEmpty(obj))
	{
	    final String entityType = specialConditionsVO.getENTITY_TYPE();
	    if(StringUtil.isNotEmpty(entityType))
	    {
		if("A".equals(entityType))
		{
		    accountName = cifOrAccountName;
		}
		else if("C".equals(entityType))
		{
		    cifName = cifOrAccountName;
		}
	    }
	}
    }

    public String getCifOrAccountName()
    {
	return cifOrAccountName;
    }

    public BigDecimal getRequesterSourceCode()
    {
	return requesterSourceCode;
    }

    public void setReasonType(String reasonType)
    {
	this.reasonType = reasonType;
    }

    public void setRequesterSourceCode(BigDecimal requesterSourceCode)
    {
	this.requesterSourceCode = requesterSourceCode;
    }

    public void setRequesterSourceAsReasonType(String requesterSourceAsReasonType)
    {
	this.requesterSourceAsReasonType = requesterSourceAsReasonType;
    }

    public void setSysParamScreenToPropertyHashMap(
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenToPropertyHashMap)
    {
	this.sysParamScreenToPropertyHashMap = sysParamScreenToPropertyHashMap;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenToPropertyHashMap()
    {
	return sysParamScreenToPropertyHashMap;
    }

    public void setPageRef(String obj)
    {
	pageRef = obj;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setAllowStandingOrder(String allowStandingOrder)
    {
	this.allowStandingOrder = allowStandingOrder;
	if(StringUtil.isNotEmpty(allowStandingOrder))
	{
	    final String so = "true".equals(allowStandingOrder) ? String.valueOf(1)
		    : String.valueOf(0);
	    specialConditionsVO.setALLOW_SO(so);
	}
    }

    public String getAllowStandingOrder()
    {
	if(String.valueOf(1).equals(specialConditionsVO.getALLOW_SO()))
	{
	    allowStandingOrder = "true";
	}
	else if(String.valueOf(0).equals(specialConditionsVO.getALLOW_SO()))
	{
	    allowStandingOrder = "false";
	}
	return allowStandingOrder;
    }

    public void setIsBranchManager(String obj)
    {
	isBranchManager = obj;
    }

    public String getIsBranchManager()
    {
	return isBranchManager;
    }

    public String getAccountName()
    {
	return accountName;
    }

    public String getCifName()
    {
	return cifName;
    }

    public void setAccountName(String obj)
    {
	accountName = obj;
	if(StringUtil.isNotEmpty(obj))
	{
	    setCifOrAccountName(obj);
	}
    }

    public void setCifName(final String obj)
    {
	cifName = obj;
	if(StringUtil.isNotEmpty(obj))
	{
	    setCifOrAccountName(obj);
	}
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO obj)
    {
	alertsParamCO = obj;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String obj)
    {
	if(StringUtil.isNotEmpty(obj))
	{
	    isFromAlert = obj;
	}
	else
	{
	    isFromAlert = "false";
	}
    }

    public String getUserConfirmation()
    {
	return userConfirmation;
    }

    public void setUserConfirmation(String obj)
    {
	userConfirmation = obj;
    }

    public List<ReportResponseCO> getReportResponseSPCONDSList()
    {
	return Collections.unmodifiableList(reportResponseSPCONDSList);
    }

    public void setReportResponseSPCONDSList(List<ReportResponseCO> obj)
    {
	reportResponseSPCONDSList = obj;
    }

    public String getPrintBatchSuccessMessage()
    {
	return printBatchSuccessMessage;
    }

    public void setPrintBatchSuccessMessage(String obj)
    {
	printBatchSuccessMessage = obj;
    }

    public List<String> getStatusList()
    {
	return statusList;
    }

    public void setStatusList(List<String> statusList)
    {
	this.statusList = statusList;
    }

    public List<BigDecimal> getCondAutoList()
    {
	return condAutoList;
    }

    public void setCondAutoList(List<BigDecimal> condAutoList)
    {
	this.condAutoList = condAutoList;
    }

    public void setStatusDescription(String statusDescription)
    {
	this.statusDescription = statusDescription;
    }

    public String getStatusDescription()
    {
	return statusDescription;
    }

    public void setEntityTypeDescription(String entityTypeDescription)
    {
	this.entityTypeDescription = entityTypeDescription;
    }

    public String getEntityTypeDescription()
    {
	return entityTypeDescription;
    }

    public void setForbidRestrictTrxDescription(String forbidRestrictTrxDescription)
    {
	this.forbidRestrictTrxDescription = forbidRestrictTrxDescription;
    }

    public String getForbidRestrictTrxDescription()
    {
	return forbidRestrictTrxDescription;
    }

    public void setForbidProductDescription(String forbidProductDescription)
    {
	this.forbidProductDescription = forbidProductDescription;
    }

    public String getForbidProductDescription()
    {
	return forbidProductDescription;
    }

    public void setRecordSourceDescription(String recordSourceDescription)
    {
	this.recordSourceDescription = recordSourceDescription;
    }

    public String getRecordSourceDescription()
    {
	return recordSourceDescription;
    }
    
    public String getSpecificBranchUpdates()
    {
        return specificBranchUpdates;
    }

    public void setSpecificBranchUpdates(String specificBranchUpdates)
    {
        this.specificBranchUpdates = specificBranchUpdates;
    }

    public List<SpCondSpecificBranchCO> getSpCondSpecificBranchCOs()
    {
        return SpCondSpecificBranchCOs;
    }

    public void setSpCondSpecificBranchCOs(List<SpCondSpecificBranchCO> spCondSpecificBranchCOs)
    {
        SpCondSpecificBranchCOs = spCondSpecificBranchCOs;
    }

    public SpCondSpecificBranchCO getSpCondSpecificBranchCO()
    {
        return spCondSpecificBranchCO;
    }

    public void setSpCondSpecificBranchCO(SpCondSpecificBranchCO spCondSpecificBranchCO)
    {
        this.spCondSpecificBranchCO = spCondSpecificBranchCO;
    }
    public String getBranchCentralisation()
    {
        return BranchCentralisation;
    }

    public void setBranchCentralisation(String branchCentralisation)
    {
        BranchCentralisation = branchCentralisation;
    }

    public BigDecimal getSpecialConditionListOpen()
    {
        return specialConditionListOpen;
    }

    public void setSpecialConditionListOpen(BigDecimal specialConditionListOpen)
    {
        this.specialConditionListOpen = specialConditionListOpen;
    }

    public String getFromPrintSpecialCond()
    {
        return fromPrintSpecialCond;
    }

    public void setFromPrintSpecialCond(String fromPrintSpecialCond)
    {
        this.fromPrintSpecialCond = fromPrintSpecialCond;
    }

    public ReportResponseCO getReportResponseCO()
    {
        return reportResponseCO;
    }

    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
        this.reportResponseCO = reportResponseCO;
    }

    public String getFromPrintMenuSpecialCond()
    {
        return fromPrintMenuSpecialCond;
    }

    public void setFromPrintMenuSpecialCond(String fromPrintMenuSpecialCond)
    {
        this.fromPrintMenuSpecialCond = fromPrintMenuSpecialCond;
    }

    public ArrayList<String> getWarningMessagesList()
    {
        return warningMessagesList;
    }

    public void setWarningMessagesList(ArrayList<String> warningMessagesList)
    {
        this.warningMessagesList = warningMessagesList;
    }


    public List<SpecialCondForbidExcepCO> getSpecialCondForbidExcepCOs()
    {
        return specialCondForbidExcepCOs;
    }

    public void setSpecialCondForbidExcepCOs(List<SpecialCondForbidExcepCO> specialCondForbidExcepCOs)
    {
        this.specialCondForbidExcepCOs = specialCondForbidExcepCOs;
    }

    public String getForbidExcepCreditUpdates()
    {
        return forbidExcepCreditUpdates;
    }

    public void setForbidExcepCreditUpdates(String forbidExcepCreditUpdates)
    {
        this.forbidExcepCreditUpdates = forbidExcepCreditUpdates;
    }

    public String getForbidExcepDebitUpdates()
    {
        return forbidExcepDebitUpdates;
    }

    public void setForbidExcepDebitUpdates(String forbidExcepDebitUpdates)
    {
        this.forbidExcepDebitUpdates = forbidExcepDebitUpdates;
    }

    public List<SpecialCondForbidExcepCO> getSpCondforbidExcepCreditCOs()
    {
        return spCondforbidExcepCreditCOs;
    }

    public void setSpCondforbidExcepCreditCOs(List<SpecialCondForbidExcepCO> spCondforbidExcepCreditCOs)
    {
        this.spCondforbidExcepCreditCOs = spCondforbidExcepCreditCOs;
    }

    public List<SpecialCondForbidExcepCO> getSpCondforbidExcepDebitCOs()
    {
        return spCondforbidExcepDebitCOs;
    }

    public void setSpCondforbidExcepDebitCOs(List<SpecialCondForbidExcepCO> spCondforbidExcepDebitCOs)
    {
        this.spCondforbidExcepDebitCOs = spCondforbidExcepDebitCOs;
    }

    public String getCrDrForex()
    {
        return crDrForex;
    }

    public void setCrDrForex(String crDrForex)
    {
        this.crDrForex = crDrForex;
    }

    public BigDecimal getExceptionLineNo()
    {
        return exceptionLineNo;
    }

    public void setExceptionLineNo(BigDecimal exceptionLineNo)
    {
        this.exceptionLineNo = exceptionLineNo;
    }

    public String getAdditional_Reference()
    {
        return additional_Reference;
    }

    public void setAdditional_Reference(String additional_Reference)
    {
        this.additional_Reference = additional_Reference;
    }

    public String getIban_Acc_Number()
    {
        return iban_Acc_Number;
    }

    public void setIban_Acc_Number(String iban_Acc_Number)
    {
        this.iban_Acc_Number = iban_Acc_Number;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getSpCondForbidProductExceptionCOsStr()
    {
        return spCondForbidProductExceptionCOsStr;
    }

    public void setSpCondForbidProductExceptionCOsStr(String spCondForbidProductExceptionCOsStr)
    {
        this.spCondForbidProductExceptionCOsStr = spCondForbidProductExceptionCOsStr;
    }
    
    public String getVoidReasonType()
    {
        return voidReasonType;
    }

    public void setVoidReasonType(String voidReasonType)
    {
        this.voidReasonType = voidReasonType;
    }

    public String getVoidReasonCodeDesc()
    {
        return voidReasonCodeDesc;
    }

    public void setVoidReasonCodeDesc(String voidReasonCodeDesc)
    {
        this.voidReasonCodeDesc = voidReasonCodeDesc;
    }

    public SpecialConditionsExceptionCO getSpCondExceptionCO()
    {
        return spCondExceptionCO;
    }

    public void setSpCondExceptionCO(SpecialConditionsExceptionCO spCondExceptionCO)
    {
        this.spCondExceptionCO = spCondExceptionCO;
    }

    public List<SpecialConditionsExceptionCO> getSpCondForbidProductExceptionCOsList()
    {
        return spCondForbidProductExceptionCOsList;
    }

    public void setSpCondForbidProductExceptionCOsList(
    	List<SpecialConditionsExceptionCO> spCondForbidProductExceptionCOsList)
    {
        this.spCondForbidProductExceptionCOsList = spCondForbidProductExceptionCOsList;
    }

    public String getForbidProductExceptionOpened()
    {
        return forbidProductExceptionOpened;
    }

    public void setForbidProductExceptionOpened(String forbidProductExceptionOpened)
    {
        this.forbidProductExceptionOpened = forbidProductExceptionOpened;
    }

    public int getWhichDate()
    {
	return whichDate;
    }

    public void setWhichDate(int whichDate)
    {
	this.whichDate = whichDate;
    }

    public String getFromSave()
    {
	return fromSave;
    }

    public void setFromSave(String fromSave)
    {
	this.fromSave = fromSave;
    }
}