/**
 * @Date:Feb 2, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.transfercash;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class TransferCashSC extends GridParamsSC
{
    private String language;
    private String ivCrud;
    private String status;
    private BigDecimal lovType;
    private String progRef;
    private String appName;
    private BigDecimal tellerCode;
    private String transferType;
    private String activeFlag;
    private String alertCode;
    private BigDecimal trsFrType;
    private String nostro;
    private String multiTrx;
    private BigDecimal trxNo;
    private String reference;
    private BigDecimal vaultBranch;
    private BigDecimal vaultNo;
    private String remittType;
    private BigDecimal currencyCode;
    private String asType;
    private int mainVault;
    private BigDecimal vaultType;
    private String trsFr_Type;
    private BigDecimal remittanceType;
    private int sequenceNo;
    private String fromTellerToVault;
    private BigDecimal trxType;
    private BigDecimal accBr;
    private BigDecimal accCy;
    private BigDecimal accGl;
    private BigDecimal accCif;
    private BigDecimal accSl;
    private String a_sb;
    private Date runningDate;
    private BigDecimal alBranchCode;
    private BigDecimal alCif;
    private BigDecimal odecRate;
    private BigDecimal sequenceFrom;
    private BigDecimal sequenceTo;
    private String toUpdateInventory;
    private Date tradeDate;
    private String balanceOnReverse;
    private BigDecimal amount;
    private BigDecimal chequeNo;
    private BigDecimal coreBank;
    private String detailedChequeList;
    private BigDecimal frBr;
    private BigDecimal frCy;
    private BigDecimal frGl;
    private BigDecimal frCif;
    private BigDecimal frSl;
    private BigDecimal toBr;
    private BigDecimal toCy;
    private BigDecimal toGl;
    private BigDecimal toCif;
    private BigDecimal toSl;
    private BigDecimal trxAmount;
    private BigDecimal accAmount;
    private BigDecimal cvAmount;
    private String withinLimit;
    private String errorType;
    private String errorMessage;
    private Integer errorCode;
    private boolean isTeller;
    private BigDecimal cifNo;
    private BigDecimal loggedInTeller;
    private String showAllTrx;
    private String statusDesc;
    private String defaultCashGrid;
    private String activeFlagError;
    private BigDecimal trsNo;
    private BigDecimal serialNo;
    private BigDecimal jvNo;
    private String serial;
    private String separateVaultNo;
    private String vaultTypeIndicator;
    private String forbidTransferToMain;
    private String tabTransferType;
    private String isMainVault;
    private String vaultDirection;
    private BigDecimal smsCode;
    private String smsAlertStatus;
    private String originalProgRef;
    private String remittByCompByBranch;
    private String withinLocalApproveLimit;

    
    public boolean getIsTeller()
    {
        return isTeller;
    }

    private String isTransferOfFund;

    //DASI170153 
    private String isHoBranch;
    private String operationNature;
    private BigDecimal fromVaultCode;
    private String dependencyOfFromVaultBranch;
    private String restTransferVaultATM;//#626607 DASI180069 - ATM tellers
    private BigDecimal loginTellerCode;//#626607 DASI180069 - ATM tellers
    private String allowHeadTellerAtm;//#626607 DASI180069 - ATM tellers

    public void setIsTeller(boolean isTeller)
    {
        this.isTeller = isTeller;
    }

    public BigDecimal getTrxAmount()
    {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount)
    {
        this.trxAmount = trxAmount;
    }

    public BigDecimal getAccAmount()
    {
        return accAmount;
    }

    public void setAccAmount(BigDecimal accAmount)
    {
        this.accAmount = accAmount;
    }

    public BigDecimal getCvAmount()
    {
        return cvAmount;
    }

    public void setCvAmount(BigDecimal cvAmount)
    {
        this.cvAmount = cvAmount;
    }

    public String getWithinLimit()
    {
        return withinLimit;
    }

    public void setWithinLimit(String withinLimit)
    {
        this.withinLimit = withinLimit;
    }
    
    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
        this.errorCode = errorCode;
    }

    public BigDecimal getFrBr()
    {
        return frBr;
    }

    public void setFrBr(BigDecimal frBr)
    {
        this.frBr = frBr;
    }

    public BigDecimal getFrCy()
    {
        return frCy;
    }

    public void setFrCy(BigDecimal frCy)
    {
        this.frCy = frCy;
    }

    public BigDecimal getFrGl()
    {
        return frGl;
    }

    public void setFrGl(BigDecimal frGl)
    {
        this.frGl = frGl;
    }

    public BigDecimal getFrCif()
    {
        return frCif;
    }

    public void setFrCif(BigDecimal frCif)
    {
        this.frCif = frCif;
    }

    public BigDecimal getFrSl()
    {
        return frSl;
    }

    public void setFrSl(BigDecimal frSl)
    {
        this.frSl = frSl;
    }

    public BigDecimal getToBr()
    {
        return toBr;
    }

    public void setToBr(BigDecimal toBr)
    {
        this.toBr = toBr;
    }

    public BigDecimal getToCy()
    {
        return toCy;
    }

    public void setToCy(BigDecimal toCy)
    {
        this.toCy = toCy;
    }

    public BigDecimal getToGl()
    {
        return toGl;
    }

    public void setToGl(BigDecimal toGl)
    {
        this.toGl = toGl;
    }

    public BigDecimal getToCif()
    {
        return toCif;
    }

    public void setToCif(BigDecimal toCif)
    {
        this.toCif = toCif;
    }

    public BigDecimal getToSl()
    {
        return toSl;
    }

    public void setToSl(BigDecimal toSl)
    {
        this.toSl = toSl;
    }

    public String getDetailedChequeList()
    {
        return detailedChequeList;
    }

    public void setDetailedChequeList(String detailedChequeList)
    {
        this.detailedChequeList = detailedChequeList;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getChequeNo()
    {
        return chequeNo;
    }

    public void setChequeNo(BigDecimal chequeNo)
    {
        this.chequeNo = chequeNo;
    }

    public BigDecimal getCoreBank()
    {
        return coreBank;
    }

    public void setCoreBank(BigDecimal coreBank)
    {
        this.coreBank = coreBank;
    }

    public String getBalanceOnReverse()
    {
        return balanceOnReverse;
    }

    public void setBalanceOnReverse(String balanceOnReverse)
    {
        this.balanceOnReverse = balanceOnReverse;
    }

    public Date getTradeDate()
    {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate)
    {
        this.tradeDate = tradeDate;
    }

    public String getToUpdateInventory()
    {
        return toUpdateInventory;
    }

    public void setToUpdateInventory(String toUpdateInventory)
    {
        this.toUpdateInventory = toUpdateInventory;
    }

    public BigDecimal getSequenceFrom()
    {
        return sequenceFrom;
    }

    public void setSequenceFrom(BigDecimal sequenceFrom)
    {
        this.sequenceFrom = sequenceFrom;
    }

    public BigDecimal getSequenceTo()
    {
        return sequenceTo;
    }

    public void setSequenceTo(BigDecimal sequenceTo)
    {
        this.sequenceTo = sequenceTo;
    }

    public BigDecimal getAlBranchCode()
    {
        return alBranchCode;
    }

    public void setAlBranchCode(BigDecimal alBranchCode)
    {
        this.alBranchCode = alBranchCode;
    }

    public BigDecimal getAlCif()
    {
        return alCif;
    }

    public void setAlCif(BigDecimal alCif)
    {
        this.alCif = alCif;
    }

    public BigDecimal getOdecRate()
    {
        return odecRate;
    }

    public void setOdecRate(BigDecimal odecRate)
    {
        this.odecRate = odecRate;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getA_sb()
    {
        return a_sb;
    }

    public void setA_sb(String aSb)
    {
        a_sb = aSb;
    }

    public BigDecimal getAccBr()
    {
        return accBr;
    }

    public void setAccBr(BigDecimal accBr)
    {
        this.accBr = accBr;
    }

    public BigDecimal getAccCy()
    {
        return accCy;
    }

    public void setAccCy(BigDecimal accCy)
    {
        this.accCy = accCy;
    }

    public BigDecimal getAccGl()
    {
        return accGl;
    }

    public void setAccGl(BigDecimal accGl)
    {
        this.accGl = accGl;
    }

    public BigDecimal getAccCif()
    {
        return accCif;
    }

    public void setAccCif(BigDecimal accCif)
    {
        this.accCif = accCif;
    }

    public BigDecimal getAccSl()
    {
        return accSl;
    }

    public void setAccSl(BigDecimal accSl)
    {
        this.accSl = accSl;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getFromTellerToVault()
    {
        return fromTellerToVault;
    }

    public void setFromTellerToVault(String fromTellerToVault)
    {
        this.fromTellerToVault = fromTellerToVault;
    }

    public int getSequenceNo()
    {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo)
    {
        this.sequenceNo = sequenceNo;
    }

    public BigDecimal getRemittanceType()
    {
        return remittanceType;
    }

    public void setRemittanceType(BigDecimal remittanceType)
    {
        this.remittanceType = remittanceType;
    }

    public String getTrsFr_Type()
    {
        return trsFr_Type;
    }

    public void setTrsFr_Type(String trsFrType)
    {
        trsFr_Type = trsFrType;
    }

    public BigDecimal getVaultType()
    {
        return vaultType;
    }

    public void setVaultType(BigDecimal vaultType)
    {
        this.vaultType = vaultType;
    }

    public String getAsType()
    {
        return asType;
    }

    public void setAsType(String asType)
    {
        this.asType = asType;
    }

    public int getMainVault()
    {
        return mainVault;
    }

    public void setMainVault(int mainVault)
    {
        this.mainVault = mainVault;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public String getTransferType()
    {
	return transferType;
    }

    public void setTransferType(String transferType)
    {
	this.transferType = transferType;
    }

    public String getActiveFlag()
    {
	return activeFlag;
    }

    public void setActiveFlag(String activeFlag)
    {
	this.activeFlag = activeFlag;
    }

    public String getAlertCode()
    {
	return alertCode;
    }

    public void setAlertCode(String alertCode)
    {
	this.alertCode = alertCode;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getTrsFrType()
    {
	return trsFrType;
    }

    public void setTrsFrType(BigDecimal trsFrType)
    {
	this.trsFrType = trsFrType;
    }

    public String getNostro()
    {
	return nostro;
    }

    public void setNostro(String nostro)
    {
	this.nostro = nostro;
    }

    public String getMultiTrx()
    {
	return multiTrx;
    }

    public void setMultiTrx(String multiTrx)
    {
	this.multiTrx = multiTrx;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public BigDecimal getTrxNo()
    {
	return trxNo;
    }

    public void setTrxNo(BigDecimal trxNo)
    {
	this.trxNo = trxNo;
    }

    public String getReference()
    {
	return reference;
    }

    public void setReference(String reference)
    {
	this.reference = reference;
    }

    public BigDecimal getVaultNo()
    {
	return vaultNo;
    }

    public void setVaultNo(BigDecimal vaultNo)
    {
	this.vaultNo = vaultNo;
    }

    public BigDecimal getVaultBranch()
    {
        return vaultBranch;
    }

    public void setVaultBranch(BigDecimal vaultBranch)
    {
        this.vaultBranch = vaultBranch;
    }

    public String getRemittType()
    {
        return remittType;
    }

    public void setRemittType(String remittType)
    {
        this.remittType = remittType;
    }

    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public void setTeller(boolean isTeller)
    {
        this.isTeller = isTeller;
    }

    public BigDecimal getLoggedInTeller()
    {
        return loggedInTeller;
    }

    public void setLoggedInTeller(BigDecimal loggedInTeller)
    {
        this.loggedInTeller = loggedInTeller;
    }

    public String getShowAllTrx()
    {
        return showAllTrx;
    }

    public void setShowAllTrx(String showAllTrx)
    {
        this.showAllTrx = showAllTrx;
    }

    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }

    public String getDefaultCashGrid()
    {
        return defaultCashGrid;
    }

    public void setDefaultCashGrid(String defaultCashGrid)
    {
        this.defaultCashGrid = defaultCashGrid;
    }

    public String getActiveFlagError()
    {
        return activeFlagError;
    }

    public void setActiveFlagError(String activeFlagError)
    {
        this.activeFlagError = activeFlagError;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public BigDecimal getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo)
    {
        this.serialNo = serialNo;
    }

    public BigDecimal getJvNo()
    {
        return jvNo;
    }

    public void setJvNo(BigDecimal jvNo)
    {
        this.jvNo = jvNo;
    }

    public String getSerial()
    {
        return serial;
    }

    public void setSerial(String serial)
    {
        this.serial = serial;
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

    public String getTabTransferType()
    {
        return tabTransferType;
    }

    public void setTabTransferType(String tabTransferType)
    {
        this.tabTransferType = tabTransferType;
    }

    public String getIsMainVault()
    {
        return isMainVault;
    }

    public void setIsMainVault(String isMainVault)
    {
        this.isMainVault = isMainVault;
    }

    public String getVaultDirection()
    {
        return vaultDirection;
    }

    public void setVaultDirection(String vaultDirection)
    {
        this.vaultDirection = vaultDirection;
    }

    public BigDecimal getSmsCode()
    {
        return smsCode;
    }

    public void setSmsCode(BigDecimal smsCode)
    {
        this.smsCode = smsCode;
    }

    public String getSmsAlertStatus()
    {
        return smsAlertStatus;
    }

    public void setSmsAlertStatus(String smsAlertStatus)
    {
        this.smsAlertStatus = smsAlertStatus;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    public String getRemittByCompByBranch()
    {
        return remittByCompByBranch;
    }

    public void setRemittByCompByBranch(String remittByCompByBranch)
    {
        this.remittByCompByBranch = remittByCompByBranch;
    }
    
    public String getWithinLocalApproveLimit()
    {
        return withinLocalApproveLimit;
    }

    public void setWithinLocalApproveLimit(String withinLocalApproveLimit)
    {
        this.withinLocalApproveLimit = withinLocalApproveLimit;
    }

    public String getIsTransferOfFund()
    {
        return isTransferOfFund;
    }

    public void setIsTransferOfFund(String isTransferOfFund)
    {
	this.isTransferOfFund = isTransferOfFund;
    }

    public String getIsHoBranch()
    {
	return isHoBranch;
    }

    public void setIsHoBranch(String isHoBranch)
    {
	this.isHoBranch = isHoBranch;
    }

    public String getOperationNature()
    {
	return operationNature;
    }

    public void setOperationNature(String operationNature)
    {
	this.operationNature = operationNature;
    }

    public BigDecimal getFromVaultCode()
    {
        return fromVaultCode;
    }

    public void setFromVaultCode(BigDecimal fromVaultCode)
    {
        this.fromVaultCode = fromVaultCode;
    }

    public String getDependencyOfFromVaultBranch()
    {
        return dependencyOfFromVaultBranch;
    }

    public void setDependencyOfFromVaultBranch(String dependencyOfFromVaultBranch)
    {
        this.dependencyOfFromVaultBranch = dependencyOfFromVaultBranch;
    }

    public final String getRestTransferVaultATM()
    {
        return restTransferVaultATM;
    }

    public final void setRestTransferVaultATM(String restTransferVaultATM)
    {
        this.restTransferVaultATM = restTransferVaultATM;
    }

    public BigDecimal getLoginTellerCode()
    {
        return loginTellerCode;
    }

    public void setLoginTellerCode(BigDecimal loginTellerCode)
    {
        this.loginTellerCode = loginTellerCode;
    }

    public String getAllowHeadTellerAtm()
    {
        return allowHeadTellerAtm;
    }

    public void setAllowHeadTellerAtm(String allowHeadTellerAtm)
    {
        this.allowHeadTellerAtm = allowHeadTellerAtm;
    }
}
