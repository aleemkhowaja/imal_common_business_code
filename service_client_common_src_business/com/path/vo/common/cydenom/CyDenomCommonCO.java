package com.path.vo.common.cydenom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 * 
 */
public class CyDenomCommonCO extends RetailBaseVO
{
    private BigDecimal branchCode;
    
    private BigDecimal trsNo;
    
    private List<TrsCurrencyDetCO> trsCurrencyDetCOs = new ArrayList<TrsCurrencyDetCO>();
    
    private TrsCurrencyDetCO trsCurrencyDetCO = new TrsCurrencyDetCO();
    
    private CTSCONTROLVO ctsContolVO;
    
    private List<CURRENCY_NOMINATION_DETVO> currencyNominationDetLst = new ArrayList<CURRENCY_NOMINATION_DETVO>();
    
    private int numberOfDenominations;
   
    private BigDecimal smallestDenomValue;
    
    private BigDecimal cyCode;
    
    private String cyDesc;
    
    private String warningMessages;
    
    private BigDecimal tellerCode;
    
    private String screenSrc;
    
    private BigDecimal cyDecimalPoints;
    
    private List<TrsCurrencyDetCO> newTrsCurrencyDetCOs = new ArrayList<TrsCurrencyDetCO>();
    
    private String allNumberOfBillsToZero;
    
    private String gvMessage;
    
    private BigDecimal remainingAmount;
    
    private BigDecimal amount;
    
    private BigDecimal originalAmount;
    
    private String delAllRecordsGraterThanSelRow;
    
    private BigDecimal totalCy;

    private String status;
    
    private String errorMessage;
    
    private String _cyDenomPageRef;
    
    private String inOut;
    
    private String trxReverseOrCancel;
    
    private Boolean hideAvailBills;
    
    private String screenReference;
    
    private BigDecimal vaultBranch;
    
    private String trsfrType;
    
    /*
     * if transaction is Active and the transaction was retrieved from database we should get the data
     * of currency denomination from data base if exists 
     */
    private String recalculateCyDenom;
    
    private String cyDenomGridUpdate;

    public BigDecimal getCyCode()
    {
        return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
        this.cyCode = cyCode;
    }

    public String getCyDesc()
    {
        return cyDesc;
    }

    public void setCyDesc(String cyDesc)
    {
        this.cyDesc = cyDesc;
    }

    public CTSCONTROLVO getCtsContolVO()
    {
        return ctsContolVO;
    }

    public void setCtsContolVO(CTSCONTROLVO ctsContolVO)
    {
        this.ctsContolVO = ctsContolVO;
    }

    public List<CURRENCY_NOMINATION_DETVO> getCurrencyNominationDetLst()
    {
        return currencyNominationDetLst;
    }

    public void setCurrencyNominationDetLst(List<CURRENCY_NOMINATION_DETVO> currencyNominationDetLst)
    {
        this.currencyNominationDetLst = currencyNominationDetLst;
    }

    public BigDecimal getSmallestDenomValue()
    {
        return smallestDenomValue;
    }

    public void setSmallestDenomValue(BigDecimal smallestDenomValue)
    {
        this.smallestDenomValue = smallestDenomValue;
    }

    public String getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public int getNumberOfDenominations()
    {
        return numberOfDenominations;
    }

    public void setNumberOfDenominations(int numberOfDenominations)
    {
        this.numberOfDenominations = numberOfDenominations;
    }

    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public BigDecimal getCyDecimalPoints()
    {
        return cyDecimalPoints;
    }

    public void setCyDecimalPoints(BigDecimal cyDecimalPoints)
    {
        this.cyDecimalPoints = cyDecimalPoints;
    }

    public List<TrsCurrencyDetCO> getTrsCurrencyDetCOs()
    {
        return trsCurrencyDetCOs;
    }

    public void setTrsCurrencyDetCOs(List<TrsCurrencyDetCO> trsCurrencyDetCOs)
    {
        this.trsCurrencyDetCOs = trsCurrencyDetCOs;
    }

    public TrsCurrencyDetCO getTrsCurrencyDetCO()
    {
        return trsCurrencyDetCO;
    }

    public void setTrsCurrencyDetCO(TrsCurrencyDetCO trsCurrencyDetCO)
    {
        this.trsCurrencyDetCO = trsCurrencyDetCO;
    }

    public List<TrsCurrencyDetCO> getNewTrsCurrencyDetCOs()
    {
        return newTrsCurrencyDetCOs;
    }

    public void setNewTrsCurrencyDetCOs(List<TrsCurrencyDetCO> newTrsCurrencyDetCOs)
    {
        this.newTrsCurrencyDetCOs = newTrsCurrencyDetCOs;
    }

    public String getAllNumberOfBillsToZero()
    {
        return allNumberOfBillsToZero;
    }

    public void setAllNumberOfBillsToZero(String allNumberOfBillsToZero)
    {
        this.allNumberOfBillsToZero = allNumberOfBillsToZero;
    }

    public String getGvMessage()
    {
        return gvMessage;
    }

    public void setGvMessage(String gvMessage)
    {
        this.gvMessage = gvMessage;
    }

    public BigDecimal getRemainingAmount()
    {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount)
    {
        this.remainingAmount = remainingAmount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getDelAllRecordsGraterThanSelRow()
    {
        return delAllRecordsGraterThanSelRow;
    }

    public void setDelAllRecordsGraterThanSelRow(String delAllRecordsGraterThanSelRow)
    {
        this.delAllRecordsGraterThanSelRow = delAllRecordsGraterThanSelRow;
    }

    public BigDecimal getTotalCy()
    {
        return totalCy;
    }

    public void setTotalCy(BigDecimal totalCy)
    {
        this.totalCy = totalCy;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public BigDecimal getOriginalAmount()
    {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount)
    {
        this.originalAmount = originalAmount;
    }

    public String get_cyDenomPageRef()
    {
        return _cyDenomPageRef;
    }

    public void set_cyDenomPageRef(String cyDenomPageRef)
    {
        _cyDenomPageRef = cyDenomPageRef;
    }

    public String getInOut()
    {
        return inOut;
    }

    public void setInOut(String inOut)
    {
        this.inOut = inOut;
    }

    public String getTrxReverseOrCancel()
    {
        return trxReverseOrCancel;
    }

    public void setTrxReverseOrCancel(String trxReverseOrCancel)
    {
        this.trxReverseOrCancel = trxReverseOrCancel;
    }

    public Boolean getHideAvailBills()
    {
        return hideAvailBills;
    }

    public void setHideAvailBills(Boolean hideAvailBills)
    {
        this.hideAvailBills = hideAvailBills;
    }

    public String getScreenReference()
    {
        return screenReference;
    }

    public void setScreenReference(String screenReference)
    {
        this.screenReference = screenReference;
    }

    public BigDecimal getVaultBranch()
    {
        return vaultBranch;
    }

    public void setVaultBranch(BigDecimal vaultBranch)
    {
        this.vaultBranch = vaultBranch;
    }

    public String getTrsfrType()
    {
        return trsfrType;
    }

    public void setTrsfrType(String trsfrType)
    {
        this.trsfrType = trsfrType;
    }

    public String getRecalculateCyDenom()
    {
        return recalculateCyDenom;
    }

    public void setRecalculateCyDenom(String recalculateCyDenom)
    {
        this.recalculateCyDenom = recalculateCyDenom;
    }

    public String getCyDenomGridUpdate()
    {
        return cyDenomGridUpdate;
    }

    public void setCyDenomGridUpdate(String cyDenomGridUpdate)
    {
        this.cyDenomGridUpdate = cyDenomGridUpdate;
    }



}
