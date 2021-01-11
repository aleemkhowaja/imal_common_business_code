/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.recordofremittance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.dbmaps.vo.REMITTANCE_INVENTORYVO;
import com.path.dbmaps.vo.REMITTANCE_RECORDVO;
import com.path.dbmaps.vo.REMITTANCE_RECORD_DENOMVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.common.RetailBaseVO;

public class RecordOfRemittanceCO extends RetailBaseVO
{
    private REMITTANCE_RECORDVO remittanceRecordVO = new REMITTANCE_RECORDVO();
    private CTSREASONSVO ctsReasonsVO;
    private List<StatusCO> statusList;
    private String vaultDesc;
    private String remittanceDesc;
    private String currencyDesc;
    private BigDecimal cyDec;
    private BigDecimal currencyCode;
    private BigDecimal tempValue;
    private BigDecimal instrAvailQtyHT;
    private BigDecimal instrAvailQtyVault;
    private BigDecimal tellerNo;
    private BigDecimal amount;
    private String statusDesc;
    private REMITTANCE_RECORD_DENOMVO selectedDenomRecord;
    private List<REMITTANCE_RECORD_DENOMVO> remittanceRecordDenomVOs;
    private BigDecimal minSeqNo;
    private BigDecimal maxCurrency;
    private String localApproveUserName;
    private String userIsBranchManager;
    private boolean isRemoteAlertApprove;
    private String isFromAlert;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String cyFormat;
    private REMITTANCE_INVENTORYVO remittanceInventory=new REMITTANCE_INVENTORYVO();
    private String warningMessage;
    private String onlyIS;				// To Retrieve only the records who have status 'IS' In Stock
   //added By nancy -14/07/2017-506480-SBI170091 - Rupee Traverler Cheque (RTC)
    private String createTrxForNonCashTrsf;
   // end nancy
    
    //SMART list
    private ArrayList<SmartCO> smartCOList;
    
    private ReportResponseCO reportResponseCO;
    
    private String printConfirmationMessage;
    
    private boolean remitDenomValueHidden;
    
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private String prizeBondTypeList; //Rania - 504699 - SBI170064 - Prize Bond Management
    private BigDecimal denomination; //Rania - 504699 - SBI170064 - Prize Bond Management
    private Date drawDate; //Rania - 504699 - SBI170064 - Prize Bond Management
    private REMITTANCEVO remittanceVO = new REMITTANCEVO(); //Rania - 504699 - SBI170064 - Prize Bond Management
    private String fromRetrieve;
    private BigDecimal trxType;
    
    public REMITTANCE_RECORDVO getRemittanceRecordVO()
    {
	return remittanceRecordVO;
    }

    public void setRemittanceRecordVO(REMITTANCE_RECORDVO remittanceRecordVO)
    {
	this.remittanceRecordVO = remittanceRecordVO;
    }

    public List<StatusCO> getStatusList()
    {
	return statusList;
    }

    public CTSREASONSVO getCtsReasonsVO()
    {
	return ctsReasonsVO;
    }

    public void setStatusList(List<StatusCO> statusList)
    {
	this.statusList = statusList;
    }

    public void setCtsReasonsVO(CTSREASONSVO ctsReasonsVO)
    {
	this.ctsReasonsVO = ctsReasonsVO;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getTempValue()
    {
	return tempValue;
    }

    public void setTempValue(BigDecimal tempValue)
    {
	this.tempValue = tempValue;
    }

    public BigDecimal getInstrAvailQtyHT()
    {
	return instrAvailQtyHT;
    }

    public void setInstrAvailQtyHT(BigDecimal instrAvailQtyHT)
    {
	this.instrAvailQtyHT = instrAvailQtyHT;
    }

    public BigDecimal getInstrAvailQtyVault()
    {
	return instrAvailQtyVault;
    }

    public void setInstrAvailQtyVault(BigDecimal instrAvailQtyVault)
    {
	this.instrAvailQtyVault = instrAvailQtyVault;
    }

    public BigDecimal getTellerNo()
    {
	return tellerNo;
    }

    public void setTellerNo(BigDecimal tellerNo)
    {
	this.tellerNo = tellerNo;
    }

    public String getVaultDesc()
    {
	return vaultDesc;
    }

    public void setVaultDesc(String vaultDesc)
    {
	this.vaultDesc = vaultDesc;
    }

    public String getRemittanceDesc()
    {
	return remittanceDesc;
    }

    public void setRemittanceDesc(String remittanceDesc)
    {
	this.remittanceDesc = remittanceDesc;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public BigDecimal getCyDec()
    {
	return cyDec;
    }

    public void setCyDec(BigDecimal cyDec)
    {
	this.cyDec = cyDec;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public List<REMITTANCE_RECORD_DENOMVO> getRemittanceRecordDenomVOs()
    {
	return remittanceRecordDenomVOs;
    }

    public void setRemittanceRecordDenomVOs(List<REMITTANCE_RECORD_DENOMVO> remittanceRecordDenomVOs)
    {
	this.remittanceRecordDenomVOs = remittanceRecordDenomVOs;
    }

    public REMITTANCE_RECORD_DENOMVO getSelectedDenomRecord()
    {
	return selectedDenomRecord;
    }

    public void setSelectedDenomRecord(REMITTANCE_RECORD_DENOMVO selectedDenomRecord)
    {
	this.selectedDenomRecord = selectedDenomRecord;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    /**
     * @return the maxCurrency
     */
    public BigDecimal getMaxCurrency()
    {
        return maxCurrency;
    }

    /**
     * @param maxCurrency the maxCurrency to set
     */
    public void setMaxCurrency(BigDecimal maxCurrency)
    {
        this.maxCurrency = maxCurrency;
    }

    /**
     * @return the minSeqNo
     */
    public BigDecimal getMinSeqNo()
    {
        return minSeqNo;
    }

    /**
     * @param minSeqNo the minSeqNo to set
     */
    public void setMinSeqNo(BigDecimal minSeqNo)
    {
        this.minSeqNo = minSeqNo;
    }

    public String getLocalApproveUserName()
    {
        return localApproveUserName;
    }

    public void setLocalApproveUserName(String localApproveUserName)
    {
        this.localApproveUserName = localApproveUserName;
    }

    public String getUserIsBranchManager()
    {
        return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
        this.userIsBranchManager = userIsBranchManager;
    }

    public boolean isRemoteAlertApprove()
    {
        return isRemoteAlertApprove;
    }

    public void setRemoteAlertApprove(boolean isRemoteAlertApprove)
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

    public String getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }

    public String getCyFormat()
    {
        return cyFormat;
    }

    public void setCyFormat(String cyFormat)
    {
        this.cyFormat = cyFormat;
    }

	public REMITTANCE_INVENTORYVO getRemittanceInventory() {
		return remittanceInventory;
	}

	public void setRemittanceInventory(REMITTANCE_INVENTORYVO remittanceInventory) {
		this.remittanceInventory = remittanceInventory;
	}

	public String getWarningMessage()
	{
	    return warningMessage;
	}

	public void setWarningMessage(String warningMessage)
	{
	    this.warningMessage = warningMessage;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
	    this.smartCOList = smartCOList;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
	    return smartCOList;
	}

	public ReportResponseCO getReportResponseCO()
	{
	    return reportResponseCO;
	}

	public void setReportResponseCO(ReportResponseCO reportResponseCO)
	{
	    this.reportResponseCO = reportResponseCO;
	}

	public String getPrintConfirmationMessage()
	{
	    return printConfirmationMessage;
	}

	public void setPrintConfirmationMessage(String printConfirmationMessage)
	{
	    this.printConfirmationMessage = printConfirmationMessage;
	}

	public boolean getRemitDenomValueHidden()
	{
	    return remitDenomValueHidden;
	}

	public void setRemitDenomValueHidden(boolean remitDenomValueHidden)
	{
	    this.remitDenomValueHidden = remitDenomValueHidden;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayHm()
	{
	    return sysParamScreenDisplayHm;
	}

	public void setSysParamScreenDisplayHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm)
	{
	    this.sysParamScreenDisplayHm = sysParamScreenDisplayHm;
	}

	public String getOnlyIS()
	{
	    return onlyIS;
	}

	public void setOnlyIS(String onlyIS)
	{
	    this.onlyIS = onlyIS;
	}

	//added By nancy -14/07/2017-506480-SBI170091 - Rupee Traverler Cheque (RTC)
	public String getCreateTrxForNonCashTrsf()
	{
	    return createTrxForNonCashTrsf;
	}

	public void setCreateTrxForNonCashTrsf(String createTrxForNonCashTrsf)
	{
	    this.createTrxForNonCashTrsf = createTrxForNonCashTrsf;
	}
	// end nancy 

	public String getPrizeBondTypeList()
	{
	    return prizeBondTypeList;
	}

	public void setPrizeBondTypeList(String prizeBondTypeList)
	{
	    this.prizeBondTypeList = prizeBondTypeList;
	}

	public BigDecimal getDenomination()
	{
	    return denomination;
	}

	public void setDenomination(BigDecimal denomination)
	{
	    this.denomination = denomination;
	}

	public Date getDrawDate()
	{
	    return drawDate;
	}

	public void setDrawDate(Date drawDate)
	{
	    this.drawDate = drawDate;
	}

	public REMITTANCEVO getRemittanceVO()
	{
	    return remittanceVO;
	}

	public void setRemittanceVO(REMITTANCEVO remittanceVO)
	{
	    this.remittanceVO = remittanceVO;
	}
	
	public String getFromRetrieve()
	{
	    return fromRetrieve;
	}

	public void setFromRetrieve(String fromRetrieve)
	{
	    this.fromRetrieve = fromRetrieve;
	}

	public BigDecimal getTrxType()
	{
	    return trxType;
	}

	public void setTrxType(BigDecimal trxType)
	{
	    this.trxType = trxType;
	}
}
