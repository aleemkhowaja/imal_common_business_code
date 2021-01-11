/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.dues.DuesManagementSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          AccountDetailsCO.java used to
 */
public class DashAccountDetailsCO extends RetailBaseVO
{
    private String acc_num;
    private String acc_num_format;
    private String acc_add_ref;
    private String status;
    private String accountName;
    private BigDecimal ytdBalance;
    private BigDecimal availableBalance;
    private BigDecimal blockedAmount;
    private String approvedLine;
    private String dues;
    private BigDecimal dueCode;
    private String currency;
    private String rateOfReturn;
    private String transactions;
    private String jvs;
    private String statOfAccount;
    private String sign;

    private BigDecimal branchCode;
    private BigDecimal glCode;
    private BigDecimal currencyCode;
    private BigDecimal cifCode;
    private BigDecimal slNo;
    private BigDecimal decimalPoints;

    private String dueStatus;
    private String action;
    private BigDecimal errorCode;
    private String errorMessage;
    private DuesManagementSC duesManagementSC;

    private String gmiFlag;

    
    private BigDecimal accountType; //Rania - AIBB - Adding GL Description to Account Search Grid
    private String accountTypeDesc; //Rania - AIBB - Adding GL Description to Account Search Grid
    
    // Added by nancy - 30/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    private BigDecimal postDatedDepositchequesBalance;
    private BigDecimal postDatedWithdrawalchequesBalance;
    private BigDecimal settlementChequesBalance;
    private BigDecimal activeWdBalance;
    private BigDecimal investmentBalance;
    private String formatByCurrencyDecimalPoints;
    // end nancy

    private BigDecimal overdraftAvailLimit;
    
    /**
     * @return the status
     */
    public String getStatus()
    {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
	this.status = status;
    }

    /**
     * @return the accountName
     */
    public String getAccountName()
    {
	return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName)
    {
	this.accountName = accountName;
    }

    /**
     * @return the approvedLine
     */
    public String getApprovedLine()
    {
	return approvedLine;
    }

    /**
     * @param approvedLine the approvedLine to set
     */
    public void setApprovedLine(String approvedLine)
    {
	this.approvedLine = approvedLine;
    }

    /**
     * @return the dues
     */
    public String getDues()
    {
	return dues;
    }

    /**
     * @param dues the dues to set
     */
    public void setDues(String dues)
    {
	this.dues = dues;
    }

    /**
     * @return the currency
     */
    public String getCurrency()
    {
	return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency)
    {
	this.currency = currency;
    }

    /**
     * @return the rateOfReturn
     */
    public String getRateOfReturn()
    {
	return rateOfReturn;
    }

    /**
     * @param rateOfReturn the rateOfReturn to set
     */
    public void setRateOfReturn(String rateOfReturn)
    {
	this.rateOfReturn = rateOfReturn;
    }

    /**
     * @return the transactions
     */
    public String getTransactions()
    {
	return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(String transactions)
    {
	this.transactions = transactions;
    }

    /**
     * @return the jvs
     */
    public String getJvs()
    {
	return jvs;
    }

    /**
     * @param jvs the jvs to set
     */
    public void setJvs(String jvs)
    {
	this.jvs = jvs;
    }

    /**
     * @return the statOfAccount
     */
    public String getStatOfAccount()
    {
	return statOfAccount;
    }

    /**
     * @param statOfAccount the statOfAccount to set
     */
    public void setStatOfAccount(String statOfAccount)
    {
	this.statOfAccount = statOfAccount;
    }

    /**
     * @return the sign
     */
    public String getSign()
    {
	return sign;
    }

    /**
     * @param sign the sign to set
     */
    public void setSign(String sign)
    {
	this.sign = sign;
    }

    /**
     * @return the acc_num
     */
    public String getAcc_num()
    {
	return acc_num;
    }

    /**
     * @param accNum the acc_num to set
     */
    public void setAcc_num(String accNum)
    {
	acc_num = accNum;
    }

    /**
     * @return the branchCode
     */
    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    /**
     * @return the glCode
     */
    public BigDecimal getGlCode()
    {
	return glCode;
    }

    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    /**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    /**
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
	return slNo;
    }

    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    /**
     * @return the decimalPoints
     */
    public BigDecimal getDecimalPoints()
    {
	return decimalPoints;
    }

    /**
     * @param decimalPoints the decimalPoints to set
     */
    public void setDecimalPoints(BigDecimal decimalPoints)
    {
	this.decimalPoints = decimalPoints;
    }

    /**
     * @return the ytdBalance
     */
    public BigDecimal getYtdBalance()
    {
	return ytdBalance;
    }

    /**
     * @param ytdBalance the ytdBalance to set
     */
    public void setYtdBalance(BigDecimal ytdBalance)
    {
	this.ytdBalance = ytdBalance;
    }

    /**
     * @return the availableBalance
     */
    public BigDecimal getAvailableBalance()
    {
	return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(BigDecimal availableBalance)
    {
	this.availableBalance = availableBalance;
    }

    /**
     * @return the blockedAmount
     */
    public BigDecimal getBlockedAmount()
    {
	return blockedAmount;
    }

    /**
     * @param blockedAmount the blockedAmount to set
     */
    public void setBlockedAmount(BigDecimal blockedAmount)
    {
	this.blockedAmount = blockedAmount;
    }

    /**
     * @return the acc_add_ref
     */
    public String getAcc_add_ref()
    {
	return acc_add_ref;
    }

    /**
     * @param accAddRef the acc_add_ref to set
     */
    public void setAcc_add_ref(String accAddRef)
    {
	acc_add_ref = accAddRef;
    }

    public BigDecimal getDueCode()
    {
	return dueCode;
    }

    public void setDueCode(BigDecimal dueCode)
    {
	this.dueCode = dueCode;
    }

    public DuesManagementSC getDuesManagementSC()
    {
	return duesManagementSC;
    }

    public void setDuesManagementSC(DuesManagementSC duesManagementSC)
    {
	this.duesManagementSC = duesManagementSC;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public String getDueStatus()
    {
	return dueStatus;
    }

    public void setDueStatus(String dueStatus)
    {
	this.dueStatus = dueStatus;
    }

    public String getAction()
    {
	return action;
    }

    public void setAction(String action)
    {
	this.action = action;
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


    public String getGmiFlag()
    {
        return gmiFlag;
    }

    public void setGmiFlag(String gmiFlag)
    {
        this.gmiFlag = gmiFlag;
    }


    public BigDecimal getAccountType()
    {
        return accountType;
    }

    public void setAccountType(BigDecimal accountType)
    {
        this.accountType = accountType;
    }

    public String getAccountTypeDesc()
    {
        return accountTypeDesc;
    }

    public void setAccountTypeDesc(String accountTypeDesc)
    {
        this.accountTypeDesc = accountTypeDesc;
    }

    public String getAcc_num_format()
    {
        return acc_num_format;
    }

    public void setAcc_num_format(String acc_num_format)
    {
        this.acc_num_format = acc_num_format;
    }
    
 // Added by nancy - 30/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public BigDecimal getPostDatedDepositchequesBalance()
    {
        return postDatedDepositchequesBalance;
    }

    public void setPostDatedDepositchequesBalance(BigDecimal postDatedDepositchequesBalance)
    {
        this.postDatedDepositchequesBalance = postDatedDepositchequesBalance;
    }

    public BigDecimal getPostDatedWithdrawalchequesBalance()
    {
        return postDatedWithdrawalchequesBalance;
    }

    public void setPostDatedWithdrawalchequesBalance(BigDecimal postDatedWithdrawalchequesBalance)
    {
        this.postDatedWithdrawalchequesBalance = postDatedWithdrawalchequesBalance;
    }

    public BigDecimal getSettlementChequesBalance()
    {
        return settlementChequesBalance;
    }

    public void setSettlementChequesBalance(BigDecimal settlementChequesBalance)
    {
        this.settlementChequesBalance = settlementChequesBalance;
    }

    public BigDecimal getActiveWdBalance()
    {
        return activeWdBalance;
    }

    public void setActiveWdBalance(BigDecimal activeWdBalance)
    {
        this.activeWdBalance = activeWdBalance;
    }

    public BigDecimal getInvestmentBalance()
    {
        return investmentBalance;
    }

    public void setInvestmentBalance(BigDecimal investmentBalance)
    {
        this.investmentBalance = investmentBalance;
    }

    public String getFormatByCurrencyDecimalPoints()
    {
        return formatByCurrencyDecimalPoints;
    }

    public void setFormatByCurrencyDecimalPoints(String formatByCurrencyDecimalPoints)
    {
        this.formatByCurrencyDecimalPoints = formatByCurrencyDecimalPoints;
    }
    //end nancy
    public BigDecimal getOverdraftAvailLimit()
    {
        return overdraftAvailLimit;
    }

    public void setOverdraftAvailLimit(BigDecimal overdraftAvailLimit)
    {
        this.overdraftAvailLimit = overdraftAvailLimit;
    }
}
