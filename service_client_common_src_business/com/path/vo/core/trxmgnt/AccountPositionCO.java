/**
 * 
 */
package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          AccountPositionCO.java used to
 */
public class AccountPositionCO extends RetailBaseVO
{
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private AMFVO amfVO = new AMFVO();
    private CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
    private BigDecimal TRX_TYPE;
    private String userName;
    private BigDecimal tellerId;
    private String currentAppName;
    private String progRef;
    private BigDecimal returnVal;
    private BigDecimal errorCode;
    private String srcType;
    private String errType;
    private String errorMsg;
    private BigDecimal availBalance;
    private BigDecimal baseCurrDecPoint;
    private String curStatus;
    private BigDecimal trsNo;
    private String cbIndicator;
    private String addRef;
    private BigDecimal coveringBalance;
    private BigDecimal duesAmountSum;
    private String hofSO;
    private String allowOverDrawn;
    private BigDecimal serialNo;
    private BigDecimal serialBranch;
    private BigDecimal batchNo;
    private BigDecimal fileType;
    
    private String accBalance;
    private String chqForCollection;
    private String investBal;
    private String blocked;
    private String settle;
    private String avlbal;
    private String balanceTrxDte;
    private String activeWithDrawal;
    private String coveringBal;
    private String duesAmount;
    private String overdraftAvailLimit;   
    private Date maturityDate;
    private Date overdraftExpiryDate;
    //ABARI120334  -- [John Massaad] 
    private String viewDormantAcc;
    private ArrayList<String> warningList = new ArrayList<String>();
    
    public String getViewDormantAcc()
    {
        return viewDormantAcc;
    }

    public void setViewDormantAcc(String viewDormantAcc)
    {
        this.viewDormantAcc = viewDormantAcc;
    }

    
    public ArrayList<String> getWarningList()
    {
        return warningList;
    }

    public void setWarningList(ArrayList<String> warningList)
    {
        this.warningList = warningList;
    }

    public AMFVO getAmfVO()
    {
	return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
	this.amfVO = amfVO;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
        return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
        this.ctsTrxTypeVO = ctsTrxTypeVO;
    }

    public BigDecimal getTRX_TYPE()
    {
        return TRX_TYPE;
    }

    public void setTRX_TYPE(BigDecimal tRXTYPE)
    {
        TRX_TYPE = tRXTYPE;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public BigDecimal getTellerId()
    {
        return tellerId;
    }

    public void setTellerId(BigDecimal tellerId)
    {
        this.tellerId = tellerId;
    }

    public String getCurrentAppName()
    {
        return currentAppName;
    }

    public void setCurrentAppName(String currentAppName)
    {
        this.currentAppName = currentAppName;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public BigDecimal getReturnVal()
    {
        return returnVal;
    }

    public void setReturnVal(BigDecimal returnVal)
    {
        this.returnVal = returnVal;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getSrcType()
    {
        return srcType;
    }

    public void setSrcType(String srcType)
    {
        this.srcType = srcType;
    }

    public String getErrType()
    {
        return errType;
    }

    public void setErrType(String errType)
    {
        this.errType = errType;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public BigDecimal getAvailBalance()
    {
        return availBalance;
    }

    public void setAvailBalance(BigDecimal availBalance)
    {
        this.availBalance = availBalance;
    }

    public String getCurStatus()
    {
        return curStatus;
    }

    public void setCurStatus(String curStatus)
    {
        this.curStatus = curStatus;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public BigDecimal getCoveringBalance()
    {
        return coveringBalance;
    }

    public void setCoveringBalance(BigDecimal coveringBalance)
    {
        this.coveringBalance = coveringBalance;
    }

    public BigDecimal getBaseCurrDecPoint()
    {
        return baseCurrDecPoint;
    }

    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
        this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public String getCbIndicator()
    {
        return cbIndicator;
    }

    public void setCbIndicator(String cbIndicator)
    {
        this.cbIndicator = cbIndicator;
    }

    public String getAddRef()
    {
        return addRef;
    }

    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }

    public String getAccBalance()
    {
        return accBalance;
    }

    public void setAccBalance(String accBalance)
    {
        this.accBalance = accBalance;
    }

    public String getChqForCollection()
    {
        return chqForCollection;
    }

    public void setChqForCollection(String chqForCollection)
    {
        this.chqForCollection = chqForCollection;
    }

    public String getInvestBal()
    {
        return investBal;
    }

    public void setInvestBal(String investBal)
    {
        this.investBal = investBal;
    }

    public String getBlocked()
    {
        return blocked;
    }

    public void setBlocked(String blocked)
    {
        this.blocked = blocked;
    }

    public String getSettle()
    {
        return settle;
    }

    public void setSettle(String settle)
    {
        this.settle = settle;
    }

    public String getAvlbal()
    {
        return avlbal;
    }

    public void setAvlbal(String avlbal)
    {
        this.avlbal = avlbal;
    }

    public String getBalanceTrxDte()
    {
        return balanceTrxDte;
    }

    public void setBalanceTrxDte(String balanceTrxDte)
    {
        this.balanceTrxDte = balanceTrxDte;
    }

    public String getActiveWithDrawal()
    {
        return activeWithDrawal;
    }

    public void setActiveWithDrawal(String activeWithDrawal)
    {
        this.activeWithDrawal = activeWithDrawal;
    }

    public String getCoveringBal()
    {
        return coveringBal;
    }

    public void setCoveringBal(String coveringBal)
    {
        this.coveringBal = coveringBal;
    }

    public String getOverdraftAvailLimit()
    {
        return overdraftAvailLimit;
    }

    public void setOverdraftAvailLimit(String overdraftAvailLimit)
    {
        this.overdraftAvailLimit = overdraftAvailLimit;
    }

    public Date getMaturityDate()
    {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
        this.maturityDate = maturityDate;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public String getHofSO()
    {
        return hofSO;
    }

    public void setHofSO(String hofSO)
    {
        this.hofSO = hofSO;
    }

    public String getAllowOverDrawn()
    {
        return allowOverDrawn;
    }

    public void setAllowOverDrawn(String allowOverDrawn)
    {
        this.allowOverDrawn = allowOverDrawn;
    }

    public BigDecimal getDuesAmountSum()
    {
        return duesAmountSum;
    }

    public void setDuesAmountSum(BigDecimal duesAmountSum)
    {
        this.duesAmountSum = duesAmountSum;
    }

    public String getDuesAmount()
    {
        return duesAmount;
    }

    public void setDuesAmount(String duesAmount)
    {
        this.duesAmount = duesAmount;
    }

    /**
     * @return the serialNo
     */
    public BigDecimal getSerialNo()
    {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(BigDecimal serialNo)
    {
        this.serialNo = serialNo;
    }

    /**
     * @return the batchNo
     */
    public BigDecimal getBatchNo()
    {
        return batchNo;
    }

    /**
     * @param batchNo the batchNo to set
     */
    public void setBatchNo(BigDecimal batchNo)
    {
        this.batchNo = batchNo;
    }

    /**
     * @return the fileType
     */
    public BigDecimal getFileType()
    {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(BigDecimal fileType)
    {
        this.fileType = fileType;
    }

    /**
     * @return the serialBranch
     */
    public BigDecimal getSerialBranch()
    {
        return serialBranch;
    }

    /**
     * @param serialBranch the serialBranch to set
     */
    public void setSerialBranch(BigDecimal serialBranch)
    {
        this.serialBranch = serialBranch;
    }

    public Date getOverdraftExpiryDate()
    {
        return overdraftExpiryDate;
    }

    public void setOverdraftExpiryDate(Date overdraftExpiryDate)
    {
        this.overdraftExpiryDate = overdraftExpiryDate;
    }

}
