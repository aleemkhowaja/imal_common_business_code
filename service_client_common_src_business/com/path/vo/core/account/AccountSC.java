/**
 * @Auther:MarwanMaddah
 * @Date:Mar 2, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.cif.CifSC;
import com.path.dbmaps.vo.CIFVO;

/**
 * @author MarwanMaddah
 * 
 */
public class AccountSC extends CifSC
{
    private BigDecimal brCode;
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifCode;
    private BigDecimal slNbr;
    private String addRef;
    private String ibanNo;
    private String ignoreException;
    private String userId;
    private String versionCode; // Web Service version
    // added by jihad
    private List<String> gmiList = new ArrayList<String>();
    private String notInStatus;
    private List<String> statusIncludeList = new ArrayList<String>();
    private List<String> statusExcludeList = new ArrayList<String>();
    private List<AMFVO> amfList = new ArrayList<AMFVO>();

    private String trxMgntAccountDtlGrid;
    private String screenRef;
    private String dormantFlag;
    private String lsArg;
    private String langCode;
    private BigDecimal lovType;
    private String ACC_BC;
    private String status;
    private String AMFStatus; // to be used in dynAccountListQuery
    private String CIFStatus; // to be used in dynAccountListQuery
    private String flag;
    private String flag2;
    private String flag3;
    private String allowInternAcc;
    private String GL_TYPE;
    private String GMI_FLAG;
    private String BS_CONTRA; // s_category
    private String AFFECT_CARD; // s_card
    private String cardNo; // CARD_NO
    private String affectPassChq;
    private String columnId;
    private List<AMFVO> lstTrsAccount = new ArrayList<AMFVO>();
    private String accNo;
    private String VIEW_DORMANT_ACC; // from CTSTELLER
    private String VIEW_SUSPEND_ACC; // from CTSTELLER
    private String TYPE; // transaction type from CTSTRXTYPE table
    private String CR_DR_FOREX; // CTSTRXTYPE table
    private String CHQ_RELATED; // CTSTRXTYPE table
    private String cifType;
    private String checkUnclaimFlag;
    private BigDecimal loginBranchCode;
    private BigDecimal trxType;
    private String accountType;
    private String warningMessages;
    private BigDecimal tellerCode;
    private BigDecimal passbookCode;
    private String passbkstatus;
    private BigDecimal cat_code;
    private String includeExclude;
    private String lienAcc;
    private BigDecimal detInd;
    private BigDecimal errorCode;
    private String errorType;
    private String errorMessage;
    private BigDecimal amount;
    private int proceedFlag;
    private int fixAccount;
    private String year;
    private BigDecimal curAcBr;
    private BigDecimal curAcCy;
    private BigDecimal curAcGl;
    private BigDecimal curAcCif;
    private BigDecimal curAcSl;
    private BigDecimal invstBr;
    private BigDecimal invstCy;
    private BigDecimal invstGl;
    private BigDecimal invstCif;
    private BigDecimal invstSl;
    private BigDecimal cardBr;
    private BigDecimal cardCy;
    private BigDecimal cardGl;
    private BigDecimal cardCif;
    private BigDecimal cardSl;
    private String crud;
    private BigDecimal balance;
    private BigDecimal returnVal;
    private String alertUserID;
    private String closeAccBreak;
    private String fullBreakDeposit;
    private String approve;
    private String closeBy;
    private Date closeDate;
    private int avoidCheckUnclaimed;
    private BigDecimal processCode;
    private BigDecimal branch;
    private BigDecimal applicationId;
    // this flag is used to check if account exist IN AMF without buisness
    // cheking on status
    private String notCheckOnStatus;
    //
    private BigDecimal giVersion;

    private String appName;
    private String gmiExcludes;
    private String gmiIncludes;

    // GL category
    private String glCategory;

    // division
    private BigDecimal accDiv;
    // departement
    private BigDecimal accDept;

    private BigDecimal lineNb;// sent from assets security type screen to
    // differentiate the lineNb
    /*
     * Simulating constants in xml
     */
    public final static BigDecimal ACCOUNT_STATUS_LOV_TYPE = ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE;

    private String glCategoryIncludes;

    private String nostroByProductClass = "N";// flag to check whether nostro
					      // account
    // is taken based on product class or not
    private BigDecimal productClass;
    private String tabIdentifier;// sent from assets security type screen to
	 // know from which tab iam calling the account
	 // lookup
    //NABIL FEGHALI - Fix Issue #212072
    private String filterByScannedCIF;
    private BigDecimal assetsAccflg;
    private String portfolioType;
    private BigDecimal fundCode;

    
    private String colName;
    private String accountDataFromLookUp;
    
    private Date dateCreated;
    
    private BigDecimal portfolioCif;
    private BigDecimal portfolioSeqNo;
    
    
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
  //habib accocunt restriction 372747
    private boolean checkNbRec;
    private int trxMgntNbRecords;
    private List<AMFVO> accountListRecords = new ArrayList<AMFVO>();
    private List<AccountCO>  cifAccList = new ArrayList<AccountCO>();
    
    private List<CIFVO> cifListRecords = new ArrayList<CIFVO>();
    
    // added by nancy -- 17/07/2018-- 382769-- account limits
    private BigDecimal accTierNo;
    private String accTierNOChar;
    private BigDecimal accLimitSuspReason;
    private String callingIndicator;
    private String nullable =  null;
    private BigDecimal nullableDecimal =  null;
    // end nancy
    
    //added by abbas for TP#627397
    private String allowInputDiffCompYn;
    //end tp#627397
    
    private String revDrawdown;
	
	private String skipAccountRestriction = "N";
    
    private String branchCentralisation;
    private BigDecimal compCodeCif;
    public BigDecimal startPosition,fieldLength;
    public BigDecimal unit;
    private String dependencyFrom;
    //Rakan Makarem -DASI170128
    private String allowedGlAction;
    private String affectedChequebook;
    
    private BigDecimal certificateCode;//Hala Al Sheikh - NBINT130004
    
    public String getColName()
    {
        return colName;
    }

    public void setColName(String colName)
    {
        this.colName = colName;
    }

    public BigDecimal getDetInd()
    {
	return detInd;
    }

    public void setDetInd(BigDecimal detInd)
    {
	this.detInd = detInd;
    }

    public String getWarningMessages()
    {
	return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
	this.warningMessages = warningMessages;
    }

    @Override
    public void setDefaultValues()
    {
	if("".equals(StringUtil.nullToEmpty(this.ACC_BC)))
	{
	    /**
	     * default AMF.ACC_BC is X that means it will be ON_BALANCE_SHEET OR
	     * OFF_BALANCE SHEET
	     */
	    this.setACC_BC(ConstantsCommon.XOR);
	}
	if("".equals(StringUtil.nullToEmpty(getGMI_FLAG())))
	{
	    /**
	     * default AMF.GMI_FLAG is X that means the Account will be General,
	     * Fixed or Internal
	     */
	    this.setGMI_FLAG(ConstantsCommon.XOR);
	}
	if("".equals(StringUtil.nullToEmpty(this.BS_CONTRA)))
	{
	    /**
	     * default BS_CONTRA is X than means ON_BALANCE_SHEET OR OFF_BALANCE
	     * SHEET
	     */
	    this.setBS_CONTRA(ConstantsCommon.XOR);
	}
	if("".equals(StringUtil.nullToEmpty(this.affectPassChq)))
	{
	    /**
	     * affectPassChq = affect Passbooks and ChequeBook is
	     * RIFATT.AFFECTION
	     */
	    this.setAffectPassChq("-1");
	}
	if("".equals(StringUtil.nullToEmpty(this.AFFECT_CARD)))
	{
	    this.setAFFECT_CARD("0");
	}

	if("".equals(StringUtil.nullToEmpty(this.flag)))
	{
	    /**
	     * Calling AccountLookupAction means FLAG is AMF TABLE Calling
	     * CIFLookupAction means FLAS is CIF table
	     */
	    this.setFlag("AMF");
	}
	if("".equals(StringUtil.nullToEmpty(this.AMFStatus)))
	{
	    /**
	     * By Default, Account Status is Active, Inactive, Dormant or
	     * Applied For Closure
	     */
	    this.setAMFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "','" + ConstantsCommon.INACTIVE_ACCOUNT + "','"
		    + ConstantsCommon.DORMANT_ACCOUNT + "','" + ConstantsCommon.SUSPENDED_ACCOUNT + "','"
		    + ConstantsCommon.APPLY_FOR_CLOSURE_ACCOUNT + "'");
	}
    }

    @Override
    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    @Override
    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    @Override
    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    @Override
    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    @Override
    public BigDecimal getGlCode()
    {
	return glCode;
    }

    @Override
    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    @Override
    public BigDecimal getSlNbr()
    {
	return slNbr;
    }

    @Override
    public void setSlNbr(BigDecimal slNbr)
    {
	this.slNbr = slNbr;
    }

    @Override
    public String getUserId()
    {
	return userId;
    }

    @Override
    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public List<String> getGmiList()
    {
	return gmiList;
    }

    public void setGmiList(List<String> gmiList)
    {
	this.gmiList = gmiList;
    }

    @Override
    public String getAddRef()
    {
	return addRef;
    }

    @Override
    public void setAddRef(String addRef)
    {
	this.addRef = addRef;
    }

    public String getScreenRef()
    {
	return screenRef;
    }

    public void setScreenRef(String screenRef)
    {
	this.screenRef = screenRef;
    }

    public String getDormantFlag()
    {
	return dormantFlag;
    }

    public void setDormantFlag(String dormantFlag)
    {
	this.dormantFlag = dormantFlag;
    }

    public String getLsArg()
    {
	return lsArg;
    }

    public void setLsArg(String lsArg)
    {
	this.lsArg = lsArg;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    @Override
    public String getACC_BC()
    {
	return ACC_BC;
    }

    @Override
    public void setACC_BC(String aCCBC)
    {
	ACC_BC = aCCBC;
    }

    @Override
    public String getFlag()
    {
	return flag;
    }

    @Override
    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public String getNotInStatus()
    {
	return notInStatus;
    }

    public void setNotInStatus(String notInStatus)
    {
	this.notInStatus = notInStatus;
    }

    /**
     * @return the accNo
     */
    @Override
    public String getAccNo()
    {
	return accNo;
    }

    /**
     * @param accNo the accNo to set
     */
    @Override
    public void setAccNo(String accNo)
    {
	this.accNo = accNo;
    }

    @Override
    public String getAllowInternAcc()
    {
	return allowInternAcc;
    }

    @Override
    public void setAllowInternAcc(String allowInternAcc)
    {
	this.allowInternAcc = allowInternAcc;
    }

    @Override
    public String getGMI_FLAG()
    {
	return GMI_FLAG;
    }

    @Override
    public void setGMI_FLAG(String gMIFLAG)
    {
	GMI_FLAG = gMIFLAG;
    }

    @Override
    public String getBS_CONTRA()
    {
	return BS_CONTRA;
    }

    @Override
    public void setBS_CONTRA(String bSCONTRA)
    {
	BS_CONTRA = bSCONTRA;
    }

    @Override
    public String getAFFECT_CARD()
    {
	return AFFECT_CARD;
    }

    @Override
    public void setAFFECT_CARD(String aFFECTCARD)
    {
	AFFECT_CARD = aFFECTCARD;
    }

    @Override
    public String getAffectPassChq()
    {
	return affectPassChq;
    }

    @Override
    public void setAffectPassChq(String affectPassChq)
    {
	this.affectPassChq = affectPassChq;
    }

    @Override
    public String getColumnId()
    {
	return columnId;
    }

    @Override
    public void setColumnId(String columnId)
    {
	this.columnId = columnId;
    }

    @Override
    public List<AMFVO> getLstTrsAccount()
    {
	return lstTrsAccount;
    }

    @Override
    public void setLstTrsAccount(List<AMFVO> lstTrsAccount)
    {
	this.lstTrsAccount = lstTrsAccount;
    }

    @Override
    public String getGL_TYPE()
    {
	return GL_TYPE;
    }

    @Override
    public void setGL_TYPE(String gLTYPE)
    {
	GL_TYPE = gLTYPE;
    }

    @Override
    public String getCifType()
    {
	return cifType;
    }

    @Override
    public void setCifType(String cifType)
    {
	this.cifType = cifType;
    }

    public String getVIEW_SUSPEND_ACC()
    {
	return VIEW_SUSPEND_ACC;
    }

    public void setVIEW_SUSPEND_ACC(String vIEWSUSPENDACC)
    {
	VIEW_SUSPEND_ACC = vIEWSUSPENDACC;
    }

    public String getVIEW_DORMANT_ACC()
    {
	return VIEW_DORMANT_ACC;
    }

    public void setVIEW_DORMANT_ACC(String vIEWDORMANTACC)
    {
	VIEW_DORMANT_ACC = vIEWDORMANTACC;
    }

    public String getTYPE()
    {
	return TYPE;
    }

    public void setTYPE(String tYPE)
    {
	TYPE = tYPE;
    }

    @Override
    public String getCR_DR_FOREX()
    {
	return CR_DR_FOREX;
    }

    @Override
    public void setCR_DR_FOREX(String cRDRFOREX)
    {
	CR_DR_FOREX = cRDRFOREX;
    }

    @Override
    public String getAMFStatus()
    {
	return AMFStatus;
    }

    @Override
    public void setAMFStatus(String aMFStatus)
    {
	AMFStatus = aMFStatus;
    }

    @Override
    public String getCIFStatus()
    {
	return CIFStatus;
    }

    @Override
    public void setCIFStatus(String cIFStatus)
    {
	CIFStatus = cIFStatus;
    }

    @Override
    public String getStatus()
    {
	return status;
    }

    @Override
    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getLoginBranchCode()
    {
	return loginBranchCode;
    }

    public void setLoginBranchCode(BigDecimal loginBranchCode)
    {
	this.loginBranchCode = loginBranchCode;
    }

    @Override
    public BigDecimal getTrxType()
    {
	return trxType;
    }

    @Override
    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public String getAccountType()
    {
	return accountType;
    }

    public void setAccountType(String accountType)
    {
	this.accountType = accountType;
    }

    @Override
    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    @Override
    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    /**
     * @return the appName
     */
    @Override
    public String getAppName()
    {
	return appName;
    }

    /**
     * @param appName the appName to set
     */
    @Override
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public BigDecimal getPassbookCode()
    {
	return passbookCode;
    }

    public void setPassbookCode(BigDecimal passbookCode)
    {
	this.passbookCode = passbookCode;
    }

    public String getPassbkstatus()
    {
	return passbkstatus;
    }

    public void setPassbkstatus(String passbkstatus)
    {
	this.passbkstatus = passbkstatus;
    }

    public BigDecimal getCat_code()
    {
	return cat_code;
    }

    public void setCat_code(BigDecimal catCode)
    {
	cat_code = catCode;
    }

    public String getIncludeExclude()
    {
	return includeExclude;
    }

    public void setIncludeExclude(String includeExclude)
    {
	this.includeExclude = includeExclude;
    }

    public String getLienAcc()
    {
	return lienAcc;
    }

    public void setLienAcc(String lienAcc)
    {
	this.lienAcc = lienAcc;
    }

    @Override
    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    @Override
    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public int getProceedFlag()
    {
	return proceedFlag;
    }

    public void setProceedFlag(int proceedFlag)
    {
	this.proceedFlag = proceedFlag;
    }

    public int getFixAccount()
    {
	return fixAccount;
    }

    public void setFixAccount(int fixAccount)
    {
	this.fixAccount = fixAccount;
    }

    public String getYear()
    {
	return year;
    }

    public void setYear(String year)
    {
	this.year = year;
    }

    public BigDecimal getCurAcBr()
    {
	return curAcBr;
    }

    public void setCurAcBr(BigDecimal curAcBr)
    {
	this.curAcBr = curAcBr;
    }

    public BigDecimal getCurAcCy()
    {
	return curAcCy;
    }

    public void setCurAcCy(BigDecimal curAcCy)
    {
	this.curAcCy = curAcCy;
    }

    public BigDecimal getCurAcGl()
    {
	return curAcGl;
    }

    public void setCurAcGl(BigDecimal curAcGl)
    {
	this.curAcGl = curAcGl;
    }

    public BigDecimal getCurAcCif()
    {
	return curAcCif;
    }

    public void setCurAcCif(BigDecimal curAcCif)
    {
	this.curAcCif = curAcCif;
    }

    public BigDecimal getCurAcSl()
    {
	return curAcSl;
    }

    public void setCurAcSl(BigDecimal curAcSl)
    {
	this.curAcSl = curAcSl;
    }

    public BigDecimal getInvstBr()
    {
	return invstBr;
    }

    public void setInvstBr(BigDecimal invstBr)
    {
	this.invstBr = invstBr;
    }

    public BigDecimal getInvstCy()
    {
	return invstCy;
    }

    public void setInvstCy(BigDecimal invstCy)
    {
	this.invstCy = invstCy;
    }

    public BigDecimal getInvstGl()
    {
	return invstGl;
    }

    public void setInvstGl(BigDecimal invstGl)
    {
	this.invstGl = invstGl;
    }

    public BigDecimal getInvstCif()
    {
	return invstCif;
    }

    public void setInvstCif(BigDecimal invstCif)
    {
	this.invstCif = invstCif;
    }

    public BigDecimal getInvstSl()
    {
	return invstSl;
    }

    public void setInvstSl(BigDecimal invstSl)
    {
	this.invstSl = invstSl;
    }

    public String getCrud()
    {
	return crud;
    }

    public void setCrud(String crud)
    {
	this.crud = crud;
    }

    public BigDecimal getBalance()
    {
	return balance;
    }

    public void setBalance(BigDecimal balance)
    {
	this.balance = balance;
    }

    public String getAlertUserID()
    {
	return alertUserID;
    }

    public void setAlertUserID(String alertUserID)
    {
	this.alertUserID = alertUserID;
    }

    public String getCloseAccBreak()
    {
	return closeAccBreak;
    }

    public void setCloseAccBreak(String closeAccBreak)
    {
	this.closeAccBreak = closeAccBreak;
    }

    public String getFullBreakDeposit()
    {
	return fullBreakDeposit;
    }

    public void setFullBreakDeposit(String fullBreakDeposit)
    {
	this.fullBreakDeposit = fullBreakDeposit;
    }

    public String getApprove()
    {
	return approve;
    }

    public void setApprove(String approve)
    {
	this.approve = approve;
    }

    public String getCloseBy()
    {
	return closeBy;
    }

    public void setCloseBy(String closeBy)
    {
	this.closeBy = closeBy;
    }

    public Date getCloseDate()
    {
	return closeDate;
    }

    public void setCloseDate(Date closeDate)
    {
	this.closeDate = closeDate;
    }

    public int getAvoidCheckUnclaimed()
    {
	return avoidCheckUnclaimed;
    }

    public void setAvoidCheckUnclaimed(int avoidCheckUnclaimed)
    {
	this.avoidCheckUnclaimed = avoidCheckUnclaimed;
    }

    public BigDecimal getProcessCode()
    {
	return processCode;
    }

    public void setProcessCode(BigDecimal processCode)
    {
	this.processCode = processCode;
    }

    public String getCheckUnclaimFlag()
    {
	return checkUnclaimFlag;
    }

    public void setCheckUnclaimFlag(String checkUnclaimFlag)
    {
	this.checkUnclaimFlag = checkUnclaimFlag;
    }

    public List<String> getStatusIncludeList()
    {
	return statusIncludeList;
    }

    public void setStatusIncludeList(List<String> statusIncludeList)
    {
	this.statusIncludeList = statusIncludeList;
    }

    public List<String> getStatusExcludeList()
    {
	return statusExcludeList;
    }

    public void setStatusExcludeList(List<String> statusExcludeList)
    {
	this.statusExcludeList = statusExcludeList;
    }

    /**
     * @return the applicationId
     */
    public BigDecimal getApplicationId()
    {
	return applicationId;
    }

    /**
     * @param applicationId the applicationId to set
     */
    public void setApplicationId(BigDecimal applicationId)
    {
	this.applicationId = applicationId;
    }

    public BigDecimal getCardBr()
    {
	return cardBr;
    }

    public void setCardBr(BigDecimal cardBr)
    {
	this.cardBr = cardBr;
    }

    public BigDecimal getCardCy()
    {
	return cardCy;
    }

    public void setCardCy(BigDecimal cardCy)
    {
	this.cardCy = cardCy;
    }

    public BigDecimal getCardGl()
    {
	return cardGl;
    }

    public void setCardGl(BigDecimal cardGl)
    {
	this.cardGl = cardGl;
    }

    public BigDecimal getCardCif()
    {
	return cardCif;
    }

    public void setCardCif(BigDecimal cardCif)
    {
	this.cardCif = cardCif;
    }

    public BigDecimal getCardSl()
    {
	return cardSl;
    }

    public void setCardSl(BigDecimal cardSl)
    {
	this.cardSl = cardSl;
    }

    public BigDecimal getBranch()
    {
	return branch;
    }

    public void setBranch(BigDecimal branch)
    {
	this.branch = branch;
    }

    public void setNotCheckOnStatus(String notCheckOnStatus)
    {
	this.notCheckOnStatus = notCheckOnStatus;
    }

    public String getNotCheckOnStatus()
    {
	return notCheckOnStatus;
    }

    /**
     * @return the giVersion
     */
    public BigDecimal getGiVersion()
    {
	return giVersion;
    }

    /**
     * @param giVersion the giVersion to set
     */
    public void setGiVersion(BigDecimal giVersion)
    {
	this.giVersion = giVersion;
    }

    @Override
    public String getGmiExcludes()
    {
	return gmiExcludes;
    }

    @Override
    public void setGmiExcludes(String gmiExcludes)
    {
	this.gmiExcludes = gmiExcludes;
    }

    @Override
    public String getGmiIncludes()
    {
	return gmiIncludes;
    }

    @Override
    public void setGmiIncludes(String gmiIncludes)
    {
	this.gmiIncludes = gmiIncludes;
    }

    public String getTrxMgntAccountDtlGrid()
    {
	return trxMgntAccountDtlGrid;
    }

    public void setTrxMgntAccountDtlGrid(String trxMgntAccountDtlGrid)
    {
	this.trxMgntAccountDtlGrid = trxMgntAccountDtlGrid;
    }

    public List<AMFVO> getAmfList()
    {
	return amfList;
    }

    public void setAmfList(List<AMFVO> amfList)
    {
	this.amfList = amfList;
    }

    public BigDecimal getAccDiv()
    {
	return accDiv;
    }

    public void setAccDiv(BigDecimal accDiv)
    {
	this.accDiv = accDiv;
    }

    public BigDecimal getAccDept()
    {
	return accDept;
    }

    public void setAccDept(BigDecimal accDept)
    {
	this.accDept = accDept;
    }

    public String getIgnoreException()
    {
	return ignoreException;
    }

    public void setIgnoreException(String ignoreException)
    {
	this.ignoreException = ignoreException;
    }

    @Override
    public String getErrorType()
    {
	return errorType;
    }

    @Override
    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public BigDecimal getReturnVal()
    {
	return returnVal;
    }

    public void setReturnVal(BigDecimal returnVal)
    {
	this.returnVal = returnVal;
    }

    public BigDecimal getBrCode()
    {
	return brCode;
    }

    public void setBrCode(BigDecimal brCode)
    {
	this.brCode = brCode;
    }

    @Override
    public String getGlCategory()
    {
	return glCategory;
    }

    @Override
    public void setGlCategory(String glCategory)
    {
	this.glCategory = glCategory;
    }

    @Override
    public String getGlCategoryIncludes()
    {
	return glCategoryIncludes;
    }

    @Override
    public void setGlCategoryIncludes(String glCategoryIncludes)
    {
	this.glCategoryIncludes = glCategoryIncludes;
    }

    public BigDecimal getLineNb()
    {
	return lineNb;
    }

    public void setLineNb(BigDecimal lineNb)
    {
	this.lineNb = lineNb;
    }

    public String getNostroByProductClass()
    {
	return nostroByProductClass;
    }

    public void setNostroByProductClass(String nostroByProductClass)
    {
	this.nostroByProductClass = nostroByProductClass;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public String getTabIdentifier()
    {
        return tabIdentifier;
    }

    public void setTabIdentifier(String tabIdentifier)
    {
        this.tabIdentifier = tabIdentifier;
    }

    public String getFilterByScannedCIF()
    {
        return filterByScannedCIF;
    }

    public void setFilterByScannedCIF(String filterByScannedCIF)
    {
        this.filterByScannedCIF = filterByScannedCIF;
    }
    
    public String getCHQ_RELATED()
    {
        return CHQ_RELATED;
    }

    public void setCHQ_RELATED(String cHQRELATED)
    {
        CHQ_RELATED = cHQRELATED;
    }

    public BigDecimal getAssetsAccflg()
    {
        return assetsAccflg;
    }

    public void setAssetsAccflg(BigDecimal assetsAccflg)
    {
        this.assetsAccflg = assetsAccflg;
    }

    public String getPortfolioType()
    {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType)
    {
        this.portfolioType = portfolioType;
    }

    public BigDecimal getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(BigDecimal fundCode)
    {
        this.fundCode = fundCode;
    }

    @Override
    public String getErrorMessage()
    {
        return errorMessage;
    }

    @Override
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getFlag2()
    {
        return flag2;
    }

    public void setFlag2(String flag2)
    {
        this.flag2 = flag2;
    }

    public String getFlag3()
    {
        return flag3;
    }

    public void setFlag3(String flag3)
    {
        this.flag3 = flag3;
    }

    /**
     * @return the versionCode
     */
    public String getVersionCode()
    {
        return versionCode;
    }

    /**
     * @param versionCode the versionCode to set
     */
    public void setVersionCode(String versionCode)
    {
        this.versionCode = versionCode;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public BigDecimal getPortfolioCif()
    {
	return portfolioCif;
    }

    public void setPortfolioCif(BigDecimal portfolioCif)
    {
	this.portfolioCif = portfolioCif;
    }

    public BigDecimal getPortfolioSeqNo()
    {
	return portfolioSeqNo;
    }

    public void setPortfolioSeqNo(BigDecimal portfolioSeqNo)
    {
	this.portfolioSeqNo = portfolioSeqNo;
    }

    @Override
    public String getPageRef()
    {
        return pageRef;
    }

    @Override
    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public String getErrType()
    {
        return errType;
    }

    public void setErrType(String errType)
    {
        this.errType = errType;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public BigDecimal getRtrnVal()
    {
        return rtrnVal;
    }

    public void setRtrnVal(BigDecimal rtrnVal)
    {
        this.rtrnVal = rtrnVal;
    }

    public BigDecimal getErrCode()
    {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
        this.errCode = errCode;
    }

    @Override
    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    @Override
    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    @Override
    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    @Override
    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public List<AMFVO> getAccountListRecords()
    {
        return accountListRecords;
    }

    public void setAccountListRecords(List<AMFVO> accountListRecords)
    {
        this.accountListRecords = accountListRecords;
    }
    
    public String getAccountDataFromLookUp()
    {
        return accountDataFromLookUp;
    }

    public void setAccountDataFromLookUp(String accountDataFromLookUp)
    {
        this.accountDataFromLookUp = accountDataFromLookUp;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public List<AccountCO> getCifAccList()
    {
        return cifAccList;
    }

    public void setCifAccList(List<AccountCO> cifAccList)
    {
        this.cifAccList = cifAccList;
    }
    
    public List<CIFVO> getCifListRecords()
    {
        return cifListRecords;
    }

    public void setCifListRecords(List<CIFVO> cifListRecords)
    {
        this.cifListRecords = cifListRecords;
    }

    public String getIbanNo()
    {
        return ibanNo;
    }

    public void setIbanNo(String ibanNo)
    {
        this.ibanNo = ibanNo;
    }

    public BigDecimal getAccTierNo()
    {
        return accTierNo;
    }

    public void setAccTierNo(BigDecimal accTierNo)
    {
        this.accTierNo = accTierNo;
    }

    public BigDecimal getAccLimitSuspReason()
    {
        return accLimitSuspReason;
    }

    public void setAccLimitSuspReason(BigDecimal accLimitSuspReason)
    {
        this.accLimitSuspReason = accLimitSuspReason;
    }

    public String getAccTierNOChar()
    {
        return accTierNOChar;
    }

    public void setAccTierNOChar(String accTierNOChar)
    {
        this.accTierNOChar = accTierNOChar;
    }

    public String getCallingIndicator()
    {
        return callingIndicator;
    }

    public void setCallingIndicator(String callingIndicator)
    {
        this.callingIndicator = callingIndicator;
    }

    public String getNullable()
    {
        return nullable;
    }

    public void setNullable(String nullable)
    {
        this.nullable = nullable;
    }

    public BigDecimal getNullableDecimal()
    {
        return nullableDecimal;
    }

    public void setNullableDecimal(BigDecimal nullableDecimal)
    {
        this.nullableDecimal = nullableDecimal;
    }

    public String getAllowInputDiffCompYn()
    {
        return allowInputDiffCompYn;
    }

    public void setAllowInputDiffCompYn(String allowInputDiffCompYn)
    {
        this.allowInputDiffCompYn = allowInputDiffCompYn;
    }
    
    public String getRevDrawdown()
    {
        return revDrawdown;
    }

    public void setRevDrawdown(String revDrawdown)
    {
        this.revDrawdown = revDrawdown;
    }
	
	public String getSkipAccountRestriction()
    {
		return skipAccountRestriction;
    }

    public void setSkipAccountRestriction(String skipAccountRestriction)
    {
		this.skipAccountRestriction = skipAccountRestriction;
    }


	public String getBranchCentralisation() {
		return branchCentralisation;
	}

	public void setBranchCentralisation(String branchCentralisation) {
		this.branchCentralisation = branchCentralisation;
	}
	
    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getStartPosition()
    {
        return startPosition;
    }

    public void setStartPosition(BigDecimal startPosition)
    {
        this.startPosition = startPosition;
    }

    public BigDecimal getFieldLength()
    {
        return fieldLength;
    }

    public void setFieldLength(BigDecimal fieldLength)
    {
        this.fieldLength = fieldLength;
    }

    public BigDecimal getUnit()
    {
        return unit;
    }

    public void setUnit(BigDecimal unit)
    {
        this.unit = unit;
    }
    public String getDependencyFrom()
    {
	return dependencyFrom;
    }

    public void setDependencyFrom(String dependencyFrom)
    {
	this.dependencyFrom = dependencyFrom;
    }

    public final String getAllowedGlAction()
    {
        return allowedGlAction;
    }

    public final void setAllowedGlAction(String allowedGlAction)
    {
        this.allowedGlAction = allowedGlAction;
    }

    public String getAffectedChequebook()
    {
        return affectedChequebook;
    }

    public void setAffectedChequebook(String affectedChequebook)
    {
        this.affectedChequebook = affectedChequebook;
    }
    
    public BigDecimal getCertificateCode()
    {
        return certificateCode;
    }

    public void setCertificateCode(BigDecimal certificateCode)
    {
        this.certificateCode = certificateCode;
    }    
}
