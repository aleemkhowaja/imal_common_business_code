package com.path.vo.core.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.BaseSC;

public class CtstrsUploadSC extends BaseSC
{
    private String userId;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal recordBranch;
    private BigDecimal batchNo;
    private BigDecimal fileType;
    private String isMultiTrsfrSglRow;
    private BigDecimal baseCurrencyCode;
    private String lstSerialNo;
    private Date systemDate;
    private BigDecimal lstSerialNoSpl;
    private String openExceptionReport;

    private String multiTrx;
    private String isBranchManager;
    private String tmpTableUserName;
    private String inwardSwift;
    private String importNI;
    private String language;

    // ------- Alert needed attribute -----
    private String isAlertMode;
    private BigDecimal alertToDoCode;
    private BigDecimal alertToDoLine;
    private String alertStatus;

    private BigDecimal tellerCode;
    private String reverseCreate;
    private BigDecimal defaultTrxType;
    private BigDecimal selectedTrxType;
    private BigDecimal errorCode;
    private String errorType;
    private String errorMessage;
    private String checkClosedTrxDate;
    private String printExceptionsReport ;
    private String deductChargeFrom  ;
    private String allowRetrieveAllBranches  ;
   // for Multi Thread process
    private BigDecimal threadId;
    private int numberOfThreads;
    private List<Integer> threadIdsList;
    private String exceptionMessage;
    private BigDecimal lineBatchNo;
    private BigDecimal lineSerialNo;
    private BigDecimal batchCif;
    
    
    public String getExceptionMessage()
    {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage)
    {
        this.exceptionMessage = exceptionMessage;
    }

    public String getCheckClosedTrxDate()
    {
        return checkClosedTrxDate;
    }

    public void setCheckClosedTrxDate(String checkClosedTrxDate)
    {
        this.checkClosedTrxDate = checkClosedTrxDate;
    }

    public String getOpenExceptionReport()
    {
        return openExceptionReport;
    }

    public void setOpenExceptionReport(String openExceptionReport)
    {
        this.openExceptionReport = openExceptionReport;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public String getReverseCreate()
    {
        return reverseCreate;
    }

    public void setReverseCreate(String reverseCreate)
    {
        this.reverseCreate = reverseCreate;
    }

    public BigDecimal getDefaultTrxType()
    {
	return defaultTrxType;
    }

    public void setDefaultTrxType(BigDecimal defaultTrxType)
    {
	this.defaultTrxType = defaultTrxType;
    }

    public BigDecimal getSelectedTrxType()
    {
	return selectedTrxType;
    }

    public void setSelectedTrxType(BigDecimal selectedTrxType)
    {
	this.selectedTrxType = selectedTrxType;
    }

    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public String getTmpTableUserName()
    {
	return tmpTableUserName;
    }

    public void setTmpTableUserName(String tmpTableUserName)
    {
	this.tmpTableUserName = tmpTableUserName;
    }

    public String getMultiTrx()
    {
	return multiTrx;
    }

    public void setMultiTrx(String multiTrx)
    {
	this.multiTrx = multiTrx;
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

    public Date getSystemDate()
    {
	return systemDate;
    }

    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }

    public String getLstSerialNo()
    {
	return lstSerialNo;
    }

    public void setLstSerialNo(String lstSerialNo)
    {
	this.lstSerialNo = lstSerialNo;
    }

    public BigDecimal getFileType()
    {
	return fileType;
    }

    public void setFileType(BigDecimal fileType)
    {
	this.fileType = fileType;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
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

    public BigDecimal getBatchNo()
    {
	return batchNo;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
	this.batchNo = batchNo;
    }

    public String getIsBranchManager()
    {
	return isBranchManager;
    }

    public void setIsBranchManager(String isBranchManager)
    {
	this.isBranchManager = isBranchManager;
    }

    public BigDecimal getBaseCurrencyCode()
    {
	return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
	this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getIsMultiTrsfrSglRow()
    {
	return isMultiTrsfrSglRow;
    }

    public void setIsMultiTrsfrSglRow(String isMultiTrsfrSglRow)
    {
	this.isMultiTrsfrSglRow = isMultiTrsfrSglRow;
    }

    public String getIsAlertMode()
    {
	return isAlertMode;
    }

    public void setIsAlertMode(String isAlertMode)
    {
	this.isAlertMode = isAlertMode;
    }

    public BigDecimal getAlertToDoCode()
    {
	return alertToDoCode;
    }

    public void setAlertToDoCode(BigDecimal alertToDoCode)
    {
	this.alertToDoCode = alertToDoCode;
    }

    public BigDecimal getAlertToDoLine()
    {
	return alertToDoLine;
    }

    public void setAlertToDoLine(BigDecimal alertToDoLine)
    {
	this.alertToDoLine = alertToDoLine;
    }

    public String getAlertStatus()
    {
	return alertStatus;
    }

    public void setAlertStatus(String alertStatus)
    {
	this.alertStatus = alertStatus;
    }

    public String getInwardSwift()
    {
	return inwardSwift;
    }

    public void setInwardSwift(String inwardSwift)
    {
	this.inwardSwift = inwardSwift;
    }

    public BigDecimal getLstSerialNoSpl()
    {
	return lstSerialNoSpl;
    }

    public void setLstSerialNoSpl(BigDecimal lstSerialNoSpl)
    {
	this.lstSerialNoSpl = lstSerialNoSpl;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getPrintExceptionsReport()
    {
        return printExceptionsReport;
    }

    public void setPrintExceptionsReport(String printExceptionsReport)
    {
        this.printExceptionsReport = printExceptionsReport;
    }

    public String getDeductChargeFrom()
    {
        return deductChargeFrom;
    }

    public void setDeductChargeFrom(String deductChargeFrom)
    {
        this.deductChargeFrom = deductChargeFrom;
    }

    public String getAllowRetrieveAllBranches()
    {
        return allowRetrieveAllBranches;
    }

    public void setAllowRetrieveAllBranches(String allowRetrieveAllBranches)
    {
        this.allowRetrieveAllBranches = allowRetrieveAllBranches;
    }

    public BigDecimal getRecordBranch()
    {
        return recordBranch;
    }

    public void setRecordBranch(BigDecimal recordBranch)
    {
        this.recordBranch = recordBranch;
    }

    public BigDecimal getThreadId()
    {
        return threadId;
    }

    public void setThreadId(BigDecimal threadId)
    {
        this.threadId = threadId;
    }


    public int getNumberOfThreads()
    {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads)
    {
        this.numberOfThreads = numberOfThreads;
    }

    public List<Integer> getThreadIdsList()
    {
        return threadIdsList;
    }

    public void setThreadIdsList(List<Integer> threadIdsList)
    {
        this.threadIdsList = threadIdsList;
    }

    public String getImportNI()
    {
        return importNI;
    }

    public void setImportNI(String importNI)
    {
        this.importNI = importNI;
    }

    public BigDecimal getLineBatchNo()
    {
        return lineBatchNo;
    }

    public void setLineBatchNo(BigDecimal lineBatchNo)
    {
        this.lineBatchNo = lineBatchNo;
    }

    public BigDecimal getLineSerialNo()
    {
        return lineSerialNo;
    }

    public void setLineSerialNo(BigDecimal lineSerialNo)
    {
        this.lineSerialNo = lineSerialNo;
    }

    public BigDecimal getBatchCif()
    {
        return batchCif;
    }

    public void setBatchCif(BigDecimal batchCif)
    {
        this.batchCif = batchCif;
    }


    

}
