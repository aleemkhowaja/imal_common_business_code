/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.transfercash;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERACCDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_CASH_BALANCEVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.recordofremittance.RecordOfRemittanceCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

public class TransferCashCO extends RetailBaseVO
{
    private BigDecimal trxNo;
    private BigDecimal vaultNo;
    private String status;
    private String briefNameEngTo;
    private BigDecimal tellerCode;
    private BigDecimal user;
    private String briefNameEngFrom;
    private String vaultBranchDesc;
    private Date tradeDate;
    private String formatedTrdDt;
    private String vaultDesc;
    private String userName;
    private String shortDescEng;
    private String shortDescArab;
    private BigDecimal trxType;
    private CTSTELLER_CASH_BALANCEVO ctstellerCashBalanceVO;
    private CTSTELLERVO ctstellervo;
    private CTSCONTROLVO ctsControlVO;
    private Boolean remittTypeVisibility;
    private Boolean remittTypeCanBeVisible;
    private Boolean remittTypeDisabled;
    private Boolean trxTypeDisabled;
    private String reference;
    private Boolean vaultNoReadOnly = false;
    private String statusDesc;
    private String alertCode;
    private String activeFlag;
    private String activeFlagError;
    private BigDecimal remittanceAmountByCurrency;
    private BigDecimal remittanceCurrency;
    private String tabTransferType;
    private String vaultDirection;
    private String separateVaultNo;
    private String vaultTypeIndicator;
    private String forbidTransferToMain;
    private String isMainVault;
    
    // CDMI170093-Transfert de fond vers un utilisateur specifique-TP: #536820
    private String substatusDesc; 

    // ------Cheques grid properties---------//

    private Boolean chequesGridChequeNoColHidden = true;
    private Boolean chequesGridTrxTypeColHidden = true;
    private Boolean chequesGridCorrBankColHidden = true;
    private Boolean chequesGridCorrBankNameColHidden = true;
    private Boolean chequesGridCtsTrsColHidden = true;
    private Boolean chequesGridEditable;
    private Boolean chequesGridAddIconVisibility;
    private Boolean chequesGridDeleteIconVisibility;
    private Boolean chequesGridVisibility = true;
    private TransferCashChequesGridCO selectedTransferCashChequesGridCO;
    private List<TransferCashChequesGridCO> transferCashChequesGridCOs;

    // ------Cash grid properties---------//

    private Boolean cashGridCountedValueEditable;
    private Boolean cashGridCurrencyEditable;
    private Boolean cashGridBalanceHidden = true;
    private Boolean cashGridCashShotOverHidden = true;
    private Boolean cashGridValueHidden = true;
    private Boolean cashGridJvopnoHidden = true;
    private Boolean cashGridEditable;
    private Boolean cashGridVisibility = true;
    private Boolean cashGridAddIconVisibility;
    private Boolean cashGridDeleteIconVisibility;
    private TransferCashSubGridCashCO selectedTransferCashSubGridCashCO;
    private List<TransferCashSubGridCashCO> transferCashSubGridCashCOs;

    // ------Remittance grid properties---------//

    private Boolean remittanceGridSerialColHidden = true;
    private Boolean remittanceGridSerialDisabled = false;
    private Boolean remittanceGridValueColHidden = true;
    private Boolean remittanceGridAmountColHidden = true;
    private Boolean remittanceGridCtsTrsColHidden = true;
    private Boolean remittGridEditable;
    private Boolean remittanceGridAddIconVisibility;
    private Boolean remittanceGridDeleteIconVisibility;
    private Boolean remittanceGridVisibility = true;
    private TransferCashRemittanceGridCO selectedTransferCashRemittanceGridCO;
    private List<TransferCashRemittanceGridCO> transferCashRemittanceGridCOs;

    private String branchName;
    private Boolean tellerCodeReadOnly = false;
    private AMFVO amf;
    private CTSTELLERACCDETVO ctsTellerAccDet;
    private String tellerVaultTranslatedMessageByKey;
    private String proceedTranslatedMessageByKey;
    private String dateApprovedTranslatedMessageByKey;
    private Boolean trxTypeVisibility = true;
    private Boolean tellerCodeVisibility = true;
    private Boolean toVaultCodeLabelVisibility = true;
    private Boolean fromVaultCodeLabelVisibility = true;
    private Boolean toUserCodeLabelVisibility = true;
    private Boolean fromUserCodeLabelVisibility = true;
    private int confirmationMessage;
    private boolean messageConfirmed;
    private BigDecimal baseCurrDecPoint;
    private Boolean vaultNoVisibility = true;
    private CTSTRSVO ctsTrsVO;
    private CTSTRXTYPEVO ctsTrxTypeVO;
    private CURRENCIESVO currenciesVO;
    private String lsError;
    private List<TransferCashChequesGridCO> newTransferCashChequesGridCOs;
    private Boolean vaultBranchVisibility;
    private ArrayList<String> listOfWarningMessages;
    private String chequeGridValueFormat;
    private BigDecimal lovType;
    private String trxTypeDesc;
    private String onInitialize;
    private Boolean hideDenominations;
    
    private String userIsBranchManager;
    private String localApproveUserName;;
    private boolean isFromAlert;
    private boolean isRemoteAlertApprove;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String cashShortOverDescription;
    private String cashShortOverDescriptionArab;
    private String cashOverDescription;
    private String cashOverDescriptionArab;
    
    private ArrayList<SmartCO> smartCOList;
    
    private ReportResponseCO reportResponseCO;
    private String askForPrint;
    private String printConfirmationMessage;
    private String informativeMessageOnLoad;
    private String hideButtons;
    private BigDecimal returnLastCreatedTrx;
    private int line_no;
    //cdmi
    private BigDecimal sessionBranchCode;
    
    private List<TrxMgntCO> trxMgntCOList = new ArrayList<TrxMgntCO>(); 
    
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private String originalProgRef;
    
    private String generatedTrxNumbers;
    
    private String fromAlertButton;
    

    private RecordOfRemittanceCO recordOfRemittanceCO = new RecordOfRemittanceCO();

    private String remittByCompByBranch;
    private String shouldCheckOnAuthorizer;
    private Boolean vaultBranchReadOnly = false;
    
    private String fromVaultBranchDesc;
    private Boolean fromVaultBranchVisibility = false;
    private Boolean fromVaultBranchReadOnly;
    private String dependencyOfFromVaultBranch;
    //DASI170153
    private BigDecimal vaultLinkedBranch;
    private String isHoBranch;
    private String vaultType;
    private String userType;
    private String fromOperationNatureDep;
    
    public String getFromAlertButton()
    {
        return fromAlertButton;
    }

    public void setFromAlertButton(String fromAlertButton)
    {
        this.fromAlertButton = fromAlertButton;
    }

    public int getConfirmationMessage()
    {
	return confirmationMessage;
    }

    public void setConfirmationMessage(int confirmationMessage)
    {
	this.confirmationMessage = confirmationMessage;
    }

    public boolean getMessageConfirmed()
    {
	return messageConfirmed;
    }

    public void setMessageConfirmed(boolean messageConfirmed)
    {
	this.messageConfirmed = messageConfirmed;
    }

    @Override
    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    @Override
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public String getTellerVaultTranslatedMessageByKey()
    {
	return tellerVaultTranslatedMessageByKey;
    }

    public void setTellerVaultTranslatedMessageByKey(String tellerVaultTranslatedMessageByKey)
    {
	this.tellerVaultTranslatedMessageByKey = tellerVaultTranslatedMessageByKey;
    }

    public AMFVO getAmf()
    {
	return amf;
    }

    public void setAmf(AMFVO amf)
    {
	this.amf = amf;
    }

    public CTSTELLERACCDETVO getCtsTellerAccDet()
    {
	return ctsTellerAccDet;
    }

    public void setCtsTellerAccDet(CTSTELLERACCDETVO ctsTellerAccDet)
    {
	this.ctsTellerAccDet = ctsTellerAccDet;
    }

    public BigDecimal getTrxNo()
    {
	return trxNo;
    }

    public void setTrxNo(BigDecimal trxNo)
    {
	this.trxNo = trxNo;
    }

    public BigDecimal getVaultNo()
    {
	return vaultNo;
    }

    public void setVaultNo(BigDecimal vaultNo)
    {
	this.vaultNo = vaultNo;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getBriefNameEngTo()
    {
	return briefNameEngTo;
    }

    public void setBriefNameEngTo(String briefNameEngTo)
    {
	this.briefNameEngTo = briefNameEngTo;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public String getBriefNameEngFrom()
    {
	return briefNameEngFrom;
    }

    public void setBriefNameEngFrom(String briefNameEngFrom)
    {
	this.briefNameEngFrom = briefNameEngFrom;
    }

    public Date getTradeDate()
    {
	return tradeDate;
    }

    public void setTradeDate(Date tradeDate)
    {
	this.tradeDate = tradeDate;
    }

    public String getVaultDesc()
    {
	return vaultDesc;
    }

    public void setVaultDesc(String vaultDesc)
    {
	this.vaultDesc = vaultDesc;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getShortDescEng()
    {
	return shortDescEng;
    }

    public void setShortDescEng(String shortDescEng)
    {
	this.shortDescEng = shortDescEng;
    }

    public String getShortDescArab()
    {
	return shortDescArab;
    }

    public void setShortDescArab(String shortDescArab)
    {
	this.shortDescArab = shortDescArab;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public CTSTELLER_CASH_BALANCEVO getCtstellerCashBalanceVO()
    {
	return ctstellerCashBalanceVO;
    }

    public void setCtstellerCashBalanceVO(CTSTELLER_CASH_BALANCEVO ctstellerCashBalanceVO)
    {
	this.ctstellerCashBalanceVO = ctstellerCashBalanceVO;
    }

    public CTSTELLERVO getCtstellervo()
    {
	return ctstellervo;
    }

    public void setCtstellervo(CTSTELLERVO ctstellervo)
    {
	this.ctstellervo = ctstellervo;
    }

    public List<TransferCashSubGridCashCO> getTransferCashSubGridCashCOs()
    {
	return transferCashSubGridCashCOs;
    }

    public void setTransferCashSubGridCashCOs(List<TransferCashSubGridCashCO> transferCashSubGridCashCOs)
    {
	this.transferCashSubGridCashCOs = transferCashSubGridCashCOs;
    }

    public List<TransferCashRemittanceGridCO> getTransferCashRemittanceGridCOs()
    {
	return transferCashRemittanceGridCOs;
    }

    public void setTransferCashRemittanceGridCOs(List<TransferCashRemittanceGridCO> transferCashRemittanceGridCOs)
    {
	this.transferCashRemittanceGridCOs = transferCashRemittanceGridCOs;
    }

    public String getReference()
    {
	return reference;
    }

    public void setReference(String reference)
    {
	this.reference = reference;
    }

    public TransferCashRemittanceGridCO getSelectedTransferCashRemittanceGridCO()
    {
	return selectedTransferCashRemittanceGridCO;
    }

    public void setSelectedTransferCashRemittanceGridCO(
	    TransferCashRemittanceGridCO selectedTransferCashRemittanceGridCO)
    {
	this.selectedTransferCashRemittanceGridCO = selectedTransferCashRemittanceGridCO;
    }

    public BigDecimal getUser()
    {
	return user;
    }

    public void setUser(BigDecimal user)
    {
	this.user = user;
    }

    public TransferCashSubGridCashCO getSelectedTransferCashSubGridCashCO()
    {
	return selectedTransferCashSubGridCashCO;
    }

    public void setSelectedTransferCashSubGridCashCO(TransferCashSubGridCashCO selectedTransferCashSubGridCashCO)
    {
	this.selectedTransferCashSubGridCashCO = selectedTransferCashSubGridCashCO;
    }

    public Boolean getRemittTypeVisibility()
    {
	return remittTypeVisibility;
    }

    public void setRemittTypeVisibility(Boolean remittTypeVisibility)
    {
	this.remittTypeVisibility = remittTypeVisibility;
    }
    
    public Boolean getRemittTypeCanBeVisible()
    {
	return remittTypeCanBeVisible;
    }

    public void setRemittTypeCanBeVisible(Boolean remittTypeCanBeVisible)
    {
	this.remittTypeCanBeVisible = remittTypeCanBeVisible;
    }

    public Boolean getCashGridEditable()
    {
	return cashGridEditable;
    }

    public void setCashGridEditable(Boolean cashGridEditable)
    {
	this.cashGridEditable = cashGridEditable;
    }

    public Boolean getRemittGridEditable()
    {
	return remittGridEditable;
    }

    public void setRemittGridEditable(Boolean remittGridEditable)
    {
	this.remittGridEditable = remittGridEditable;
    }

    public Boolean getCashGridCountedValueEditable()
    {
	return cashGridCountedValueEditable;
    }

    public void setCashGridCountedValueEditable(Boolean cashGridCountedValueEditable)
    {
	this.cashGridCountedValueEditable = cashGridCountedValueEditable;
    }

    public Boolean getCashGridBalanceHidden()
    {
	return cashGridBalanceHidden;
    }

    public void setCashGridBalanceHidden(Boolean cashGridBalanceHidden)
    {
	this.cashGridBalanceHidden = cashGridBalanceHidden;
    }

    public Boolean getCashGridCashShotOverHidden()
    {
	return cashGridCashShotOverHidden;
    }

    public void setCashGridCashShotOverHidden(Boolean cashGridCashShotOverHidden)
    {
	this.cashGridCashShotOverHidden = cashGridCashShotOverHidden;
    }

    public Boolean getCashGridValueHidden()
    {
	return cashGridValueHidden;
    }

    public void setCashGridValueHidden(Boolean cashGridValueHidden)
    {
	this.cashGridValueHidden = cashGridValueHidden;
    }

    public Boolean getCashGridJvopnoHidden()
    {
	return cashGridJvopnoHidden;
    }

    public void setCashGridJvopnoHidden(Boolean cashGridJvopnoHidden)
    {
	this.cashGridJvopnoHidden = cashGridJvopnoHidden;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getAlertCode()
    {
	return alertCode;
    }

    public void setAlertCode(String alertCode)
    {
	this.alertCode = alertCode;
    }

    public String getActiveFlag()
    {
	return activeFlag;
    }

    public void setActiveFlag(String activeFlag)
    {
	this.activeFlag = activeFlag;
    }

    public Boolean getChequesGridChequeNoColHidden()
    {
	return chequesGridChequeNoColHidden;
    }

    public void setChequesGridChequeNoColHidden(Boolean chequesGridChequeNoColHidden)
    {
	this.chequesGridChequeNoColHidden = chequesGridChequeNoColHidden;
    }

    public Boolean getChequesGridTrxTypeColHidden()
    {
	return chequesGridTrxTypeColHidden;
    }

    public void setChequesGridTrxTypeColHidden(Boolean chequesGridTrxTypeColHidden)
    {
	this.chequesGridTrxTypeColHidden = chequesGridTrxTypeColHidden;
    }

    public Boolean getChequesGridCorrBankColHidden()
    {
	return chequesGridCorrBankColHidden;
    }

    public void setChequesGridCorrBankColHidden(Boolean chequesGridCorrBankColHidden)
    {
	this.chequesGridCorrBankColHidden = chequesGridCorrBankColHidden;
    }

    public Boolean getChequesGridCorrBankNameColHidden()
    {
	return chequesGridCorrBankNameColHidden;
    }

    public void setChequesGridCorrBankNameColHidden(Boolean chequesGridCorrBankNameColHidden)
    {
	this.chequesGridCorrBankNameColHidden = chequesGridCorrBankNameColHidden;
    }

    public String getBranchName()
    {
	return branchName;
    }

    public void setBranchName(String branchName)
    {
	this.branchName = branchName;
    }

    public Boolean getTellerCodeReadOnly()
    {
	return tellerCodeReadOnly;
    }

    public void setTellerCodeReadOnly(Boolean tellerCodeReadOnly)
    {
	this.tellerCodeReadOnly = tellerCodeReadOnly;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public List<TransferCashChequesGridCO> getTransferCashChequesGridCOs()
    {
	return transferCashChequesGridCOs;
    }

    public void setTransferCashChequesGridCOs(List<TransferCashChequesGridCO> transferCashChequesGridCOs)
    {
	this.transferCashChequesGridCOs = transferCashChequesGridCOs;
    }

    public TransferCashChequesGridCO getSelectedTransferCashChequesGridCO()
    {
	return selectedTransferCashChequesGridCO;
    }

    public void setSelectedTransferCashChequesGridCO(TransferCashChequesGridCO selectedTransferCashChequesGridCO)
    {
	this.selectedTransferCashChequesGridCO = selectedTransferCashChequesGridCO;
    }

    public Boolean getRemittanceGridAddIconVisibility()
    {
	return remittanceGridAddIconVisibility;
    }

    public void setRemittanceGridAddIconVisibility(Boolean remittanceGridAddIconVisibility)
    {
	this.remittanceGridAddIconVisibility = remittanceGridAddIconVisibility;
    }

    public Boolean getChequesGridAddIconVisibility()
    {
	return chequesGridAddIconVisibility;
    }

    public void setChequesGridAddIconVisibility(Boolean chequesGridAddIconVisibility)
    {
	this.chequesGridAddIconVisibility = chequesGridAddIconVisibility;
    }

    public Boolean getChequesGridVisibility()
    {
	return chequesGridVisibility;
    }

    public void setChequesGridVisibility(Boolean chequesGridVisibility)
    {
	this.chequesGridVisibility = chequesGridVisibility;
    }

    public Boolean getRemittanceGridVisibility()
    {
	return remittanceGridVisibility;
    }

    public void setRemittanceGridVisibility(Boolean remittanceGridVisibility)
    {
	this.remittanceGridVisibility = remittanceGridVisibility;
    }

    public Boolean getTrxTypeVisibility()
    {
	return trxTypeVisibility;
    }

    public void setTrxTypeVisibility(Boolean trxTypeVisibility)
    {
	this.trxTypeVisibility = trxTypeVisibility;
    }

    public Boolean getTellerCodeVisibility()
    {
	return tellerCodeVisibility;
    }

    public void setTellerCodeVisibility(Boolean tellerCodeVisibility)
    {
	this.tellerCodeVisibility = tellerCodeVisibility;
    }

    public Boolean getVaultNoReadOnly()
    {
	return vaultNoReadOnly;
    }

    public void setVaultNoReadOnly(Boolean vaultNoReadOnly)
    {
	this.vaultNoReadOnly = vaultNoReadOnly;
    }

    public Boolean getVaultNoVisibility()
    {
	return vaultNoVisibility;
    }

    public void setVaultNoVisibility(Boolean vaultNoVisibility)
    {
	this.vaultNoVisibility = vaultNoVisibility;
    }

    public Boolean getCashGridCurrencyEditable()
    {
	return cashGridCurrencyEditable;
    }

    public void setCashGridCurrencyEditable(Boolean cashGridCurrencyEditable)
    {
	this.cashGridCurrencyEditable = cashGridCurrencyEditable;
    }

    public Boolean getCashGridVisibility()
    {
	return cashGridVisibility;
    }

    public void setCashGridVisibility(Boolean cashGridVisibility)
    {
	this.cashGridVisibility = cashGridVisibility;
    }

    public Boolean getCashGridAddIconVisibility()
    {
	return cashGridAddIconVisibility;
    }

    public void setCashGridAddIconVisibility(Boolean cashGridAddIconVisibility)
    {
	this.cashGridAddIconVisibility = cashGridAddIconVisibility;
    }

    public Boolean getCashGridDeleteIconVisibility()
    {
	return cashGridDeleteIconVisibility;
    }

    public void setCashGridDeleteIconVisibility(Boolean cashGridDeleteIconVisibility)
    {
	this.cashGridDeleteIconVisibility = cashGridDeleteIconVisibility;
    }

    public Boolean getChequesGridDeleteIconVisibility()
    {
	return chequesGridDeleteIconVisibility;
    }

    public void setChequesGridDeleteIconVisibility(Boolean chequesGridDeleteIconVisibility)
    {
	this.chequesGridDeleteIconVisibility = chequesGridDeleteIconVisibility;
    }

    public Boolean getChequesGridEditable()
    {
	return chequesGridEditable;
    }

    public void setChequesGridEditable(Boolean chequesGridEditable)
    {
	this.chequesGridEditable = chequesGridEditable;
    }

    public Boolean getRemittanceGridDeleteIconVisibility()
    {
	return remittanceGridDeleteIconVisibility;
    }

    public void setRemittanceGridDeleteIconVisibility(Boolean remittanceGridDeleteIconVisibility)
    {
	this.remittanceGridDeleteIconVisibility = remittanceGridDeleteIconVisibility;
    }

    public CTSTRSVO getCtsTrsVO()
    {
	return ctsTrsVO;
    }

    public void setCtsTrsVO(CTSTRSVO ctsTrsVO)
    {
	this.ctsTrsVO = ctsTrsVO;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
	return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
	this.ctsTrxTypeVO = ctsTrxTypeVO;
    }

    public CURRENCIESVO getCurrenciesVO()
    {
	return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
	this.currenciesVO = currenciesVO;
    }

    public String getLsError()
    {
	return lsError;
    }

    public void setLsError(String lsError)
    {
	this.lsError = lsError;
    }

    public List<TransferCashChequesGridCO> getNewTransferCashChequesGridCOs()
    {
	return newTransferCashChequesGridCOs;
    }

    public void setNewTransferCashChequesGridCOs(List<TransferCashChequesGridCO> newTransferCashChequesGridCOs)
    {
	this.newTransferCashChequesGridCOs = newTransferCashChequesGridCOs;
    }

    public String getProceedTranslatedMessageByKey()
    {
	return proceedTranslatedMessageByKey;
    }

    public void setProceedTranslatedMessageByKey(String proceedTranslatedMessageByKey)
    {
	this.proceedTranslatedMessageByKey = proceedTranslatedMessageByKey;
    }

    public String getDateApprovedTranslatedMessageByKey()
    {
	return dateApprovedTranslatedMessageByKey;
    }

    public void setDateApprovedTranslatedMessageByKey(String dateApprovedTranslatedMessageByKey)
    {
	this.dateApprovedTranslatedMessageByKey = dateApprovedTranslatedMessageByKey;
    }

    public Boolean getToVaultCodeLabelVisibility()
    {
	return toVaultCodeLabelVisibility;
    }

    public void setToVaultCodeLabelVisibility(Boolean toVaultCodeLabelVisibility)
    {
	this.toVaultCodeLabelVisibility = toVaultCodeLabelVisibility;
    }

    public Boolean getFromVaultCodeLabelVisibility()
    {
	return fromVaultCodeLabelVisibility;
    }

    public void setFromVaultCodeLabelVisibility(Boolean fromVaultCodeLabelVisibility)
    {
	this.fromVaultCodeLabelVisibility = fromVaultCodeLabelVisibility;
    }

    public Boolean getToUserCodeLabelVisibility()
    {
	return toUserCodeLabelVisibility;
    }

    public void setToUserCodeLabelVisibility(Boolean toUserCodeLabelVisibility)
    {
	this.toUserCodeLabelVisibility = toUserCodeLabelVisibility;
    }

    public Boolean getFromUserCodeLabelVisibility()
    {
	return fromUserCodeLabelVisibility;
    }

    public void setFromUserCodeLabelVisibility(Boolean fromUserCodeLabelVisibility)
    {
	this.fromUserCodeLabelVisibility = fromUserCodeLabelVisibility;
    }

    public Boolean getVaultBranchVisibility()
    {
	return vaultBranchVisibility;
    }

    public void setVaultBranchVisibility(Boolean vaultBranchVisibility)
    {
	this.vaultBranchVisibility = vaultBranchVisibility;
    }

    public String getVaultBranchDesc()
    {
	return vaultBranchDesc;
    }

    public void setVaultBranchDesc(String vaultBranchDesc)
    {
	this.vaultBranchDesc = vaultBranchDesc;
    }

    public Boolean getRemittanceGridSerialColHidden()
    {
	return remittanceGridSerialColHidden;
    }

    public void setRemittanceGridSerialColHidden(Boolean remittanceGridSerialColHidden)
    {
	this.remittanceGridSerialColHidden = remittanceGridSerialColHidden;
    }

    public Boolean getRemittanceGridSerialDisabled()
    {
	return remittanceGridSerialDisabled;
    }

    public void setRemittanceGridSerialDisabled(Boolean remittanceGridSerialDisabled)
    {
	this.remittanceGridSerialDisabled = remittanceGridSerialDisabled;
    }

    public Boolean getRemittanceGridValueColHidden()
    {
	return remittanceGridValueColHidden;
    }

    public void setRemittanceGridValueColHidden(Boolean remittanceGridValueColHidden)
    {
	this.remittanceGridValueColHidden = remittanceGridValueColHidden;
    }

    public Boolean getRemittanceGridAmountColHidden()
    {
	return remittanceGridAmountColHidden;
    }

    public void setRemittanceGridAmountColHidden(Boolean remittanceGridAmountColHidden)
    {
	this.remittanceGridAmountColHidden = remittanceGridAmountColHidden;
    }

    public Boolean getRemittanceGridCtsTrsColHidden()
    {
	return remittanceGridCtsTrsColHidden;
    }

    public void setRemittanceGridCtsTrsColHidden(Boolean remittanceGridCtsTrsColHidden)
    {
	this.remittanceGridCtsTrsColHidden = remittanceGridCtsTrsColHidden;
    }

    public String getChequeGridValueFormat()
    {
        return chequeGridValueFormat;
    }

    public void setChequeGridValueFormat(String chequeGridValueFormat)
    {
        this.chequeGridValueFormat = chequeGridValueFormat;
    }

    public String getFormatedTrdDt()
    {
        return formatedTrdDt;
    }

    public void setFormatedTrdDt(String formatedTrdDt)
    {
        this.formatedTrdDt = formatedTrdDt;
    }
    
    public BigDecimal getLovType()
    {
        return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }

    public Boolean getRemittTypeDisabled()
    {
        return remittTypeDisabled;
    }

    public void setRemittTypeDisabled(Boolean remittTypeDisabled)
    {
        this.remittTypeDisabled = remittTypeDisabled;
    }

    public Boolean getTrxTypeDisabled()
    {
        return trxTypeDisabled;
    }

    public void setTrxTypeDisabled(Boolean trxTypeDisabled)
    {
        this.trxTypeDisabled = trxTypeDisabled;
    }

    public String getTrxTypeDesc()
    {
        return trxTypeDesc;
    }

    public void setTrxTypeDesc(String trxTypeDesc)
    {
        this.trxTypeDesc = trxTypeDesc;
    }

    public String getOnInitialize()
    {
        return onInitialize;
    }

    public void setOnInitialize(String onInitialize)
    {
        this.onInitialize = onInitialize;
    }

    public String getActiveFlagError()
    {
        return activeFlagError;
    }

    public void setActiveFlagError(String activeFlagError)
    {
        this.activeFlagError = activeFlagError;
    }

    public Boolean getHideDenominations()
    {
        return hideDenominations;
    }

    public void setHideDenominations(Boolean hideDenominations)
    {
        this.hideDenominations = hideDenominations;
    }

    public String getUserIsBranchManager()
    {
        return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
        this.userIsBranchManager = userIsBranchManager;
    }

    public boolean getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(boolean isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }

    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }

    public boolean getIsRemoteAlertApprove()
    {
        return isRemoteAlertApprove;
    }

    public void setIsRemoteAlertApprove(boolean isRemoteAlertApprove)
    {
        this.isRemoteAlertApprove = isRemoteAlertApprove;
    }

    public String getLocalApproveUserName()
    {
        return localApproveUserName;
    }

    public void setLocalApproveUserName(String localApproveUserName)
    {
        this.localApproveUserName = localApproveUserName;
    }

    public String getCashShortOverDescription()
    {
        return cashShortOverDescription;
    }

    public void setCashShortOverDescription(String cashShortOverDescription)
    {
        this.cashShortOverDescription = cashShortOverDescription;
    }

    public String getCashShortOverDescriptionArab()
    {
        return cashShortOverDescriptionArab;
    }

    public void setCashShortOverDescriptionArab(String cashShortOverDescriptionArab)
    {
        this.cashShortOverDescriptionArab = cashShortOverDescriptionArab;
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

    public String getAskForPrint()
    {
        return askForPrint;
    }

    public void setAskForPrint(String askForPrint)
    {
        this.askForPrint = askForPrint;
    }

    public String getPrintConfirmationMessage()
    {
        return printConfirmationMessage;
    }

    public void setPrintConfirmationMessage(String printConfirmationMessage)
    {
        this.printConfirmationMessage = printConfirmationMessage;
    }

    public String getInformativeMessageOnLoad()
    {
        return informativeMessageOnLoad;
    }

    public void setInformativeMessageOnLoad(String informativeMessageOnLoad)
    {
        this.informativeMessageOnLoad = informativeMessageOnLoad;
    }

    public String getHideButtons()
    {
        return hideButtons;
    }

    public void setHideButtons(String hideButtons)
    {
        this.hideButtons = hideButtons;
    }

    public BigDecimal getReturnLastCreatedTrx()
    {
        return returnLastCreatedTrx;
    }

    public void setReturnLastCreatedTrx(BigDecimal returnLastCreatedTrx)
    {
        this.returnLastCreatedTrx = returnLastCreatedTrx;
    }

    public int getLine_no()
    {
        return line_no;
    }

    public void setLine_no(int line_no)
    {
        this.line_no = line_no;
    }
        
    public List<TrxMgntCO> getTrxMgntCOList()
    {
        return trxMgntCOList;
    }

    public void setTrxMgntCOList(List<TrxMgntCO> trxMgntCOList)
    {
        this.trxMgntCOList = trxMgntCOList;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayHm()
    {
        return sysParamScreenDisplayHm;
    }

    public void setSysParamScreenDisplayHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm)
    {
        this.sysParamScreenDisplayHm = sysParamScreenDisplayHm;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    public String getGeneratedTrxNumbers()
    {
        return generatedTrxNumbers;
    }

    public void setGeneratedTrxNumbers(String generatedTrxNumbers)
    {
        this.generatedTrxNumbers = generatedTrxNumbers;
    }

    public ArrayList<String> getListOfWarningMessages()
    {
        return listOfWarningMessages;
    }

    public void setListOfWarningMessages(ArrayList<String> listOfWarningMessages)
    {
        this.listOfWarningMessages = listOfWarningMessages;
    }

    public String getCashOverDescription()
    {
        return cashOverDescription;
    }

    public void setCashOverDescription(String cashOverDescription)
    {
        this.cashOverDescription = cashOverDescription;
    }

    public String getCashOverDescriptionArab()
    {
        return cashOverDescriptionArab;
    }

    public void setCashOverDescriptionArab(String cashOverDescriptionArab)
    {
        this.cashOverDescriptionArab = cashOverDescriptionArab;
    }

    public Boolean getChequesGridCtsTrsColHidden()
    {
        return chequesGridCtsTrsColHidden;
    }

    public void setChequesGridCtsTrsColHidden(Boolean chequesGridCtsTrsColHidden)
    {
        this.chequesGridCtsTrsColHidden = chequesGridCtsTrsColHidden;
    }

    public BigDecimal getRemittanceAmountByCurrency()
    {
        return remittanceAmountByCurrency;
    }

    public void setRemittanceAmountByCurrency(BigDecimal remittanceAmountByCurrency)
    {
        this.remittanceAmountByCurrency = remittanceAmountByCurrency;
    }

    public BigDecimal getRemittanceCurrency()
    {
        return remittanceCurrency;
    }

    public void setRemittanceCurrency(BigDecimal remittanceCurrency)
    {
        this.remittanceCurrency = remittanceCurrency;
    }

    public String getTabTransferType()
    {
        return tabTransferType;
    }

    public void setTabTransferType(String tabTransferType)
    {
        this.tabTransferType = tabTransferType;
    }

    public String getVaultDirection()
    {
        return vaultDirection;
    }

    public void setVaultDirection(String vaultDirection)
    {
        this.vaultDirection = vaultDirection;
    }

    public String getSeparateVaultNo()
    {
        return separateVaultNo;
    }

    public void setSeparateVaultNo(String separateVaultNo)
    {
        this.separateVaultNo = separateVaultNo;
    }

    public String getVaultTypeIndicator()
    {
        return vaultTypeIndicator;
    }

    public void setVaultTypeIndicator(String vaultTypeIndicator)
    {
        this.vaultTypeIndicator = vaultTypeIndicator;
    }

    public String getForbidTransferToMain()
    {
        return forbidTransferToMain;
    }

    public void setForbidTransferToMain(String forbidTransferToMain)
    {
        this.forbidTransferToMain = forbidTransferToMain;
    }

    public String getIsMainVault()
    {
        return isMainVault;
    }

    public void setIsMainVault(String isMainVault)
    {
        this.isMainVault = isMainVault;
    }


    public RecordOfRemittanceCO getRecordOfRemittanceCO()
    {
        return recordOfRemittanceCO;
    }

    public void setRecordOfRemittanceCO(RecordOfRemittanceCO recordOfRemittanceCO)
    {
        this.recordOfRemittanceCO = recordOfRemittanceCO;
    }

    public String getRemittByCompByBranch()
    {
        return remittByCompByBranch;
    }

    public void setRemittByCompByBranch(String remittByCompByBranch)
    {
        this.remittByCompByBranch = remittByCompByBranch;
    }

    public final String getShouldCheckOnAuthorizer()
    {
        return shouldCheckOnAuthorizer;
    }

    public final void setShouldCheckOnAuthorizer(String shouldCheckOnAuthorizer)
    {
        this.shouldCheckOnAuthorizer = shouldCheckOnAuthorizer;
    }

    public String getSubstatusDesc()
    {
        return substatusDesc;
    }

    public void setSubstatusDesc(String substatusDesc)
    {
        this.substatusDesc = substatusDesc;
    }

    public BigDecimal getSessionBranchCode()
    {
        return sessionBranchCode;
    }

    public  void setSessionBranchCode(BigDecimal sessionBranchCode)
    {
        this.sessionBranchCode = sessionBranchCode;
    }

    public final Boolean getVaultBranchReadOnly()
    {
        return vaultBranchReadOnly;
    }

    public final void setVaultBranchReadOnly(Boolean vaultBranchReadOnly)
    {
        this.vaultBranchReadOnly = vaultBranchReadOnly;
    }

    public String getFromVaultBranchDesc()
    {
        return fromVaultBranchDesc;
    }

    public void setFromVaultBranchDesc(String fromVaultBranchDesc)
    {
        this.fromVaultBranchDesc = fromVaultBranchDesc;
    }

    public Boolean getFromVaultBranchVisibility()
    {
        return fromVaultBranchVisibility;
    }

    public void setFromVaultBranchVisibility(Boolean fromVaultBranchVisibility)
    {
        this.fromVaultBranchVisibility = fromVaultBranchVisibility;
    }

    public Boolean getFromVaultBranchReadOnly()
    {
        return fromVaultBranchReadOnly;
    }

    public void setFromVaultBranchReadOnly(Boolean fromVaultBranchReadOnly)
    {
        this.fromVaultBranchReadOnly = fromVaultBranchReadOnly;
    }

    public String getDependencyOfFromVaultBranch()
    {
        return dependencyOfFromVaultBranch;
    }

    public void setDependencyOfFromVaultBranch(String dependencyOfFromVaultBranch)
    {
        this.dependencyOfFromVaultBranch = dependencyOfFromVaultBranch;
    }

    public BigDecimal getVaultLinkedBranch()
    {
        return vaultLinkedBranch;
    }

    public void setVaultLinkedBranch(BigDecimal vaultLinkedBranch)
    {
        this.vaultLinkedBranch = vaultLinkedBranch;
    }

    public String getIsHoBranch()
    {
        return isHoBranch;
    }

    public void setIsHoBranch(String isHoBranch)
    {
        this.isHoBranch = isHoBranch;
    }

    public String getVaultType()
    {
        return vaultType;
    }

    public void setVaultType(String vaultType)
    {
        this.vaultType = vaultType;
    }


    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getFromOperationNatureDep()
    {
        return fromOperationNatureDep;
    }

    public void setFromOperationNatureDep(String fromOperationNatureDep)
    {
        this.fromOperationNatureDep = fromOperationNatureDep;
    }

}
