package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.common.RetailBaseVO;

/****
 * Class for General Accounts main screen Copyright 2012, Path Solutions Path
 * Solutions retains all ownership rights to this source code
 * 
 * @author: navas
 * 
 *          GeneralAccountsCO.java used to
 */
public class AccountsEventMgmtCO extends RetailBaseVO
{

    private String status; // RA_STATUS
    private String accountNumber; // RA_CODE
    private String gmiFlag; // RA_GMI
    private String autoSweep;
    private String progRef;
    private String flag;
    private String ptIndex;
    private String pftPostTo;
    private String renewAccount;
    private String message;
    private String accountName;
    private String isCreateAccount;
    private String accDescMI;
    private String accDescOI;
    private String columnSelector;
    private String externalTransfer;// ext_trf
    private String productType;// lnk_product_type
    private String distributionPeriodicity;// MATURED_CALCULATION
    private String maturityFlag;
    private String ecoSectorDesc;
    private String subEcoSectorDesc;
    private String limitType;
    private String accountSign;
    private String mode;// Whether it is New record/ Or Edit on Existing record
    private String allowChangeCif;
    private String pftDesc;// st_pft
    private String pftAddRef;//
    private String postProfitTo;// postInterestTo
    private String callingMode;// On change/Update/etc...
    private String ptIndicator;
    private String prefferedLanguage;
    private String glDesc;
    private String editType;
    private String currencyDesc;
    private String[] infoErrorParam;
    private String drPtIndex;
    private String typesGA;
    private String businessCrud;
    private String _addressPageRef;
    private String cifShortNameEng;
    private String cifLongNameEng;
    private String cifDesc;
    private String cifMailStmt;
    private String cifPeriod;
    private String cifShortNameArb;
    private String cifLongNameArb;
    private String cifRelOff;
    private String cifResident;
    private String legalStatusPremDedPcs;
    private String cifDeptDesc;
    private String vipAlert;
    private String cifDivisionDesc;
    private String pageRef;
    private String suspendReasonDesc;
    private String mailStatement;
    private String mailAdvise;
    private String statementPeriod;
    private String minStatementBalance;
    private String iv_crud;
    private String modeOfPayment;// trsfrMethod - trsfr_method
    private String certOfDepositGridString;
    private String glCategory;
    private String pcInd;
    private String genAccDesCif;
    private String drCrIdx;
    private String specialRate;
    private String editMode;
    private String accountNumberLabel;
    private String baseCurrencyName;
    private String addRef;
    private String receivedFrom;
    private String openDepTrxTypeDesc;
    private String userId;

    private BigDecimal cifDept;
    private BigDecimal cifLegalStatus;
    private BigDecimal cifDivision;
    private BigDecimal blackListed;
    private BigDecimal monthlySalary;
    private BigDecimal cifRelOffID;
    private BigDecimal cifType;
    private BigDecimal ecoSectorCode;
    private BigDecimal subEcoSectorCode;
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifSubNo;
    private BigDecimal suspendReasonCode;
    private BigDecimal slNo;
    private BigDecimal branchCode;
    private BigDecimal compCode;
    private BigDecimal amount;
    private BigDecimal detInd;
    private BigDecimal depositRate;
    private BigDecimal depositEquiv;
    private BigDecimal minRate;
    private BigDecimal maxRate;
    private BigDecimal rate;
    private BigDecimal facilityNo;
    private BigDecimal maturityGl;
    private BigDecimal trfBr;
    private BigDecimal trfCy;
    private BigDecimal trfGl;
    private BigDecimal trfCif;
    private BigDecimal trfSl;
    private BigDecimal linkBranchNo;
    private BigDecimal linkReference;
    private BigDecimal linkYear;
    private BigDecimal renewalMaturityDays;
    private BigDecimal accGlMI;// trf_gl
    private BigDecimal accSlMI;// trf_sl
    private BigDecimal accGlOI;// off_gl
    private BigDecimal accSlOI;// off_sl
    private BigDecimal pftBr;// pft_Br
    private BigDecimal pftCy;// pft_Cy
    private BigDecimal accGlPI;// pft_gl
    private BigDecimal accSlPI;// pft_sl
    private BigDecimal accCifPI;// pft_cif
    private BigDecimal maturityDays;
    private BigDecimal creditPointRate;
    private BigDecimal debitPointRate;
    private BigDecimal openDepAmount; // hidden
    private BigDecimal cvAvailableBalance; // hidden
    private BigDecimal fcAvailableBalance; // hidden
    private BigDecimal baseCurrencyCode;
    private BigDecimal psrCustomerPercentage;
    private BigDecimal modaribRate;
    private BigDecimal currencyMinBalance; // hidden
    private BigDecimal facilitySubLimit;
    private BigDecimal overdraftLimit;
    private BigDecimal libor;
    private BigDecimal penalty;
    private BigDecimal chargesFees;
    private BigDecimal infoErrorCode;
    private BigDecimal minimumOpeningBalance;
    private BigDecimal minimumOpeningBalancePrev;// hidden
    private BigDecimal adecAamount;
    private BigDecimal cvAmount;
    private BigDecimal asColName;
    private BigDecimal tellerCode;
    private BigDecimal openDepTrxType;
    private BigDecimal baseCurrencyDecimalPoints;
    private BigDecimal accMainDetTransfrAccBr;// Closing transfer details - main
					      // details tab
    private BigDecimal accMainDetTransfrAccCy;// Closing transfer details - main
					      // details tab
    private BigDecimal accMainDetTransfrAccGl;// Closing transfer details - main
					      // details tab
    private BigDecimal accMainDetTransfrAccCif;// Closing transfer details -
					       // main details tab
    private BigDecimal accMainDetTransfrAccSl;// Closing transfer details - main
					      // details tab
    private BigDecimal blockedCV;
    private BigDecimal blockedFC;
    private String warningMessage;

    private Date dateClosed;
    private Date dateSubmitted;
    private Date applicableDate;
    private Date maturityDate;
    private Date finalMaturityDate;
    private Date expiryDate;
    private Date renewalMaturityDate;
    private Date lastPostDate;
    private Date lastRenewDate;
    private Date debitApplicableDate;
    private Date creditApplicableDate;
    private Date birthDate;

    private Boolean distProfitToMaturityAccount;
    private Boolean createNewAccountFlag;// new_ind
    private Boolean afterConfirmMsgFlag;
    private Boolean updatePassbookFlag;

    private List<SelectCO> pftPostToDropDwn = new ArrayList<SelectCO>();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayVO = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private AccountsDefaultCO accountsDefaultCO = new AccountsDefaultCO();
    private boolean resetGLDetails;
    private BigDecimal scannedCIFNo;
    private BigDecimal minimumBalance;
    private String MKT_BY_ID;
    private String MKT_FOR_ID;
    private String MKT_POSITION_BY;
    private String MKT_DIVISION_BY;
    private String MKT_DEPARTMENT_BY;
    private String MKT_BY;
    private String MKT_FOR;
    private String MKT_DIVISION_FOR;
    private String MKT_DEPARTMENT_FOR;
    private ArrayList<Integer> warningListCode = new ArrayList<Integer>();
    private String validateAllowedCurrency;

    private Boolean fromCloseTransferFlag;
    // Flag for Account Component SL - Main  Details tab
    private Boolean fromMainDetailsTansferToDepositFlag;
    // Flag for Account Component SL in Maturity Instructions - Instruction tab of FMA
    private Boolean fromFMAMaturityInstructionsTansferFlag;
    // Flag for Account Component SL in Offending Instructions - Instruction tab of FMA
    private Boolean fromFMAOffendingInstructionsFlag;
    // Flag for Account Component SL in Profit Calculation Instructions - Instruction tab of FMA
    private Boolean fromFMAProfitCalcInstructionsFlag;
    // Flag for Account Component SL in Opening Deposit Details - Instruction tab of FMA
    private Boolean fromFMAOpeningDepositDetailsFlag;
    // Flag for Account Component SL in Profit Calculation Instructions - PT Details tab of GA
    private Boolean fromGAProfitCalcInstructionsFlag;
    // Flag for Account Component SL in Offending Instructions Section - Transfer Details tab of GA
    private Boolean fromGATransferDetailsOffendingInstructionsFlag;

    // suspicious cif
    private Integer countSuspicious;
    private String soundex1;
    private String soundex2;
    private String soundex3;
    private String soundex4;
    private String soundexAr1;
    private String soundexAr2;
    private String soundexAr3;
    private String soundexAr4;

    private String modeComm;

    private RIFATTVO rifattVO;

    // IIAB100318 John Massaad
    private BigDecimal addRefGlobalMaskLength;
    private String addRefProtectMask;
    private String oldAddRef;
    
    
    //related for maximumOverdrawBalanceDesc
    private String accountSign1;
    //related for minimumBalancePointsDesc
    private String accountSign2;

    public String getModeComm()
    {
	return modeComm;
    }

    public void setModeComm(String modeComm)
    {
	this.modeComm = modeComm;
    }

    public String getAccountNumberLabel()
    {
	return accountNumberLabel;
    }

    public void setAccountNumberLabel(String accountNumberLabel)
    {
	this.accountNumberLabel = accountNumberLabel;
    }

    public String getEditMode()
    {
	return editMode;
    }

    public void setEditMode(String editMode)
    {
	this.editMode = editMode;
    }

    AddressCommonCO addressCommonCO;
    private String saveType;

    public AddressCommonCO getAddressCommonCO()
    {
	return addressCommonCO;
    }

    public void setAddressCommonCO(AddressCommonCO addressCommonCO)
    {
	this.addressCommonCO = addressCommonCO;
    }

    public String getSpecialRate()
    {
	return specialRate;
    }

    public void setSpecialRate(String specialRate)
    {
	this.specialRate = specialRate;
    }

    public String getDrCrIdx()
    {
	return drCrIdx;
    }

    public void setDrCrIdx(String drCrIdx)
    {
	this.drCrIdx = drCrIdx;
    }

    /**
     * @return the maturityDate
     */
    public Date getMaturityDate()
    {
	return maturityDate;
    }

    /**
     * @param maturityDate the maturityDate to set
     */
    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    /**
     * @return the finalMaturityDate
     */
    public Date getFinalMaturityDate()
    {
	return finalMaturityDate;
    }

    /**
     * @param finalMaturityDate the finalMaturityDate to set
     */
    public void setFinalMaturityDate(Date finalMaturityDate)
    {
	this.finalMaturityDate = finalMaturityDate;
    }

    public Date getDateClosed()
    {
	return dateClosed;
    }

    public void setDateClosed(Date dateClosed)
    {
	this.dateClosed = dateClosed;
    }

    /**
     * @return the dateSubmitted
     */
    public Date getDateSubmitted()
    {
	return dateSubmitted;
    }

    /**
     * @param dateSubmitted the dateSubmitted to set
     */
    public void setDateSubmitted(Date dateSubmitted)
    {
	this.dateSubmitted = dateSubmitted;
    }

    /**
     * @return the applicableDate
     */
    public Date getApplicableDate()
    {
	return applicableDate;
    }

    /**
     * @param applicableDate the applicableDate to set
     */
    public void setApplicableDate(Date applicableDate)
    {
	this.applicableDate = applicableDate;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getAccountNumber()
    {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
	this.accountNumber = accountNumber;
    }

    public String getGmiFlag()
    {
	return gmiFlag;
    }

    /**
     * @return the ptIndex
     */
    public String getPtIndex()
    {
	return ptIndex;
    }

    /**
     * @param ptIndex the ptIndex to set
     */
    public void setPtIndex(String ptIndex)
    {
	this.ptIndex = ptIndex;
    }

    public void setGmiFlag(String gmiFlag)
    {
	this.gmiFlag = gmiFlag;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCifSubNo()
    {
	return cifSubNo;
    }

    public void setCifSubNo(BigDecimal cifSubNo)
    {
	this.cifSubNo = cifSubNo;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    /**
     * @return the compCode
     */
    public BigDecimal getCompCode()
    {
	return compCode;
    }

    /**
     * @param compCode the compCode to set
     */
    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    /**
     * @return the autoSweep
     */
    public String getAutoSweep()
    {
	return autoSweep;
    }

    /**
     * @param autoSweep the autoSweep to set
     */
    public void setAutoSweep(String autoSweep)
    {
	this.autoSweep = autoSweep;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount()
    {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
	return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    /**
     * @return the flag
     */
    public String getFlag()
    {
	return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    /**
     * @return the detInd
     */
    public BigDecimal getDetInd()
    {
	return detInd;
    }

    /**
     * @param detInd the detInd to set
     */
    public void setDetInd(BigDecimal detInd)
    {
	this.detInd = detInd;
    }

    /**
     * @return the depositRate
     */
    public BigDecimal getDepositRate()
    {
	return depositRate;
    }

    /**
     * @param depositRate the depositRate to set
     */
    public void setDepositRate(BigDecimal depositRate)
    {
	this.depositRate = depositRate;
    }

    /**
     * @return the depositEquiv
     */
    public BigDecimal getDepositEquiv()
    {
	return depositEquiv;
    }

    /**
     * @param depositEquiv the depositEquiv to set
     */
    public void setDepositEquiv(BigDecimal depositEquiv)
    {
	this.depositEquiv = depositEquiv;
    }

    /**
     * @return the minRate
     */
    public BigDecimal getMinRate()
    {
	return minRate;
    }

    /**
     * @param minRate the minRate to set
     */
    public void setMinRate(BigDecimal minRate)
    {
	this.minRate = minRate;
    }

    /**
     * @return the maxRate
     */
    public BigDecimal getMaxRate()
    {
	return maxRate;
    }

    /**
     * @param maxRate the maxRate to set
     */
    public void setMaxRate(BigDecimal maxRate)
    {
	this.maxRate = maxRate;
    }

    /**
     * @return the rate
     */
    public BigDecimal getRate()
    {
	return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(BigDecimal rate)
    {
	this.rate = rate;
    }

    /**
     * @return the facilityNo
     */
    public BigDecimal getFacilityNo()
    {
	return facilityNo;
    }

    /**
     * @param facilityNo the facilityNo to set
     */
    public void setFacilityNo(BigDecimal facilityNo)
    {
	this.facilityNo = facilityNo;
    }

    /**
     * @return the expiryDate
     */
    public Date getExpiryDate()
    {
	return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate)
    {
	this.expiryDate = expiryDate;
    }

    public String getPftPostTo()
    {
	return pftPostTo;
    }

    public void setPftPostTo(String pftPostTo)
    {
	this.pftPostTo = pftPostTo;
    }

    public BigDecimal getMaturityGl()
    {
	return maturityGl;
    }

    public void setMaturityGl(BigDecimal maturityGl)
    {
	this.maturityGl = maturityGl;
    }

    public BigDecimal getTrfBr()
    {
	return trfBr;
    }

    public void setTrfBr(BigDecimal trfBr)
    {
	this.trfBr = trfBr;
    }

    public BigDecimal getTrfCy()
    {
	return trfCy;
    }

    public void setTrfCy(BigDecimal trfCy)
    {
	this.trfCy = trfCy;
    }

    public BigDecimal getTrfGl()
    {
	return trfGl;
    }

    public void setTrfGl(BigDecimal trfGl)
    {
	this.trfGl = trfGl;
    }

    public BigDecimal getTrfCif()
    {
	return trfCif;
    }

    public void setTrfCif(BigDecimal trfCif)
    {
	this.trfCif = trfCif;
    }

    public BigDecimal getTrfSl()
    {
	return trfSl;
    }

    public void setTrfSl(BigDecimal trfSl)
    {
	this.trfSl = trfSl;
    }

    public String getRenewAccount()
    {
	return renewAccount;
    }

    public void setRenewAccount(String renewAccount)
    {
	this.renewAccount = renewAccount;
    }

    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }

    public String getAccountName()
    {
	return accountName;
    }

    public void setAccountName(String accountName)
    {
	this.accountName = accountName;
    }

    public List<SelectCO> getPftPostToDropDwn()
    {
	return pftPostToDropDwn;
    }

    public void setPftPostToDropDwn(List<SelectCO> pftPostToDropDwn)
    {
	this.pftPostToDropDwn = pftPostToDropDwn;
    }

    public String getIsCreateAccount()
    {
	return isCreateAccount;
    }

    public void setIsCreateAccount(String isCreateAccount)
    {
	this.isCreateAccount = isCreateAccount;
    }

    public BigDecimal getLinkBranchNo()
    {
	return linkBranchNo;
    }

    public void setLinkBranchNo(BigDecimal linkBranchNo)
    {
	this.linkBranchNo = linkBranchNo;
    }

    public BigDecimal getLinkReference()
    {
	return linkReference;
    }

    public void setLinkReference(BigDecimal linkReference)
    {
	this.linkReference = linkReference;
    }

    public BigDecimal getLinkYear()
    {
	return linkYear;
    }

    public void setLinkYear(BigDecimal linkYear)
    {
	this.linkYear = linkYear;
    }

    public Date getRenewalMaturityDate()
    {
	return renewalMaturityDate;
    }

    public void setRenewalMaturityDate(Date renewalMaturityDate)
    {
	this.renewalMaturityDate = renewalMaturityDate;
    }

    public BigDecimal getRenewalMaturityDays()
    {
	return renewalMaturityDays;
    }

    public void setRenewalMaturityDays(BigDecimal renewalMaturityDays)
    {
	this.renewalMaturityDays = renewalMaturityDays;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayVO()
    {
	return sysParamScreenDisplayVO;
    }

    public void setSysParamScreenDisplayVO(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayVO)
    {
	this.sysParamScreenDisplayVO = sysParamScreenDisplayVO;
    }

    public BigDecimal getAccGlMI()
    {
	return accGlMI;
    }

    public void setAccGlMI(BigDecimal accGlMI)
    {
	this.accGlMI = accGlMI;
    }

    public BigDecimal getAccSlMI()
    {
	return accSlMI;
    }

    public void setAccSlMI(BigDecimal accSlMI)
    {
	this.accSlMI = accSlMI;
    }

    public String getAccDescMI()
    {
	return accDescMI;
    }

    public void setAccDescMI(String accDescMI)
    {
	this.accDescMI = accDescMI;
    }

    public Boolean getDistProfitToMaturityAccount()
    {
	return distProfitToMaturityAccount;
    }

    public void setDistProfitToMaturityAccount(Boolean distProfitToMaturityAccount)
    {
	this.distProfitToMaturityAccount = distProfitToMaturityAccount;
    }

    public String getAccDescOI()
    {
	return accDescOI;
    }

    public void setAccDescOI(String accDescOI)
    {
	this.accDescOI = accDescOI;
    }

    public BigDecimal getAccGlOI()
    {
	return accGlOI;
    }

    public void setAccGlOI(BigDecimal accGlOI)
    {
	this.accGlOI = accGlOI;
    }

    public BigDecimal getAccSlOI()
    {
	return accSlOI;
    }

    public void setAccSlOI(BigDecimal accSlOI)
    {
	this.accSlOI = accSlOI;
    }

    public BigDecimal getAccGlPI()
    {
	return accGlPI;
    }

    public void setAccGlPI(BigDecimal accGlPI)
    {
	this.accGlPI = accGlPI;
    }

    public BigDecimal getAccSlPI()
    {
	return accSlPI;
    }

    public void setAccSlPI(BigDecimal accSlPI)
    {
	this.accSlPI = accSlPI;
    }

    public BigDecimal getAccCifPI()
    {
	return accCifPI;
    }

    public void setAccCifPI(BigDecimal accCifPI)
    {
	this.accCifPI = accCifPI;
    }

    public String getColumnSelector()
    {
	return columnSelector;
    }

    public void setColumnSelector(String columnSelector)
    {
	this.columnSelector = columnSelector;
    }

    public String getExternalTransfer()
    {
	return externalTransfer;
    }

    public void setExternalTransfer(String externalTransfer)
    {
	this.externalTransfer = externalTransfer;
    }

    public String getProductType()
    {
	return productType;
    }

    public void setProductType(String productType)
    {
	this.productType = productType;
    }

    public String getDistributionPeriodicity()
    {
	return distributionPeriodicity;
    }

    public void setDistributionPeriodicity(String distributionPeriodicity)
    {
	this.distributionPeriodicity = distributionPeriodicity;
    }

    public Date getLastPostDate()
    {
	return lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate)
    {
	this.lastPostDate = lastPostDate;
    }

    public Date getLastRenewDate()
    {
	return lastRenewDate;
    }

    public void setLastRenewDate(Date lastRenewDate)
    {
	this.lastRenewDate = lastRenewDate;
    }

    public String getMaturityFlag()
    {
	return maturityFlag;
    }

    public void setMaturityFlag(String maturityFlag)
    {
	this.maturityFlag = maturityFlag;
    }

    public BigDecimal getMaturityDays()
    {
	return maturityDays;
    }

    public void setMaturityDays(BigDecimal maturityDays)
    {
	this.maturityDays = maturityDays;
    }

    /**
     * @return the limitType
     */
    public String getLimitType()
    {
	return limitType;
    }

    /**
     * @param limitType the limitType to set
     */
    public void setLimitType(String limitType)
    {
	this.limitType = limitType;
    }

    /**
     * @return the cifType
     */
    public BigDecimal getCifType()
    {
	return cifType;
    }

    /**
     * @param cifType the cifType to set
     */
    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    /**
     * @return the ecoSectorCode
     */
    public BigDecimal getEcoSectorCode()
    {
	return ecoSectorCode;
    }

    /**
     * @param ecoSectorCode the ecoSectorCode to set
     */
    public void setEcoSectorCode(BigDecimal ecoSectorCode)
    {
	this.ecoSectorCode = ecoSectorCode;
    }

    /**
     * @return the ecoSectorDesc
     */
    public String getEcoSectorDesc()
    {
	return ecoSectorDesc;
    }

    /**
     * @param ecoSectorDesc the ecoSectorDesc to set
     */
    public void setEcoSectorDesc(String ecoSectorDesc)
    {
	this.ecoSectorDesc = ecoSectorDesc;
    }

    /**
     * @return the subEcoSectorDesc
     */
    public String getSubEcoSectorDesc()
    {
	return subEcoSectorDesc;
    }

    /**
     * @param subEcoSectorDesc the subEcoSectorDesc to set
     */
    public void setSubEcoSectorDesc(String subEcoSectorDesc)
    {
	this.subEcoSectorDesc = subEcoSectorDesc;
    }

    /**
     * @return the subEcoSectorCode
     */
    public BigDecimal getSubEcoSectorCode()
    {
	return subEcoSectorCode;
    }

    /**
     * @param subEcoSectorCode the subEcoSectorCode to set
     */
    public void setSubEcoSectorCode(BigDecimal subEcoSectorCode)
    {
	this.subEcoSectorCode = subEcoSectorCode;
    }

    public String getAccountSign()
    {
	return accountSign;
    }

    public void setAccountSign(String accountSign)
    {
	this.accountSign = accountSign;
    }

    public Date getDebitApplicableDate()
    {
	return debitApplicableDate;
    }

    public void setDebitApplicableDate(Date debitApplicableDate)
    {
	this.debitApplicableDate = debitApplicableDate;
    }

    public Date getCreditApplicableDate()
    {
	return creditApplicableDate;
    }

    public void setCreditApplicableDate(Date creditApplicableDate)
    {
	this.creditApplicableDate = creditApplicableDate;
    }

    public BigDecimal getCreditPointRate()
    {
	return creditPointRate;
    }

    public void setCreditPointRate(BigDecimal creditPointRate)
    {
	this.creditPointRate = creditPointRate;
    }

    public BigDecimal getDebitPointRate()
    {
	return debitPointRate;
    }

    public void setDebitPointRate(BigDecimal debitPointRate)
    {
	this.debitPointRate = debitPointRate;
    }

    public BigDecimal getOpenDepAmount()
    {
	return openDepAmount;
    }

    public void setOpenDepAmount(BigDecimal openDepAmount)
    {
	this.openDepAmount = openDepAmount;
    }

    public BigDecimal getCvAvailableBalance()
    {
	return cvAvailableBalance;
    }

    public void setCvAvailableBalance(BigDecimal cvAvailableBalance)
    {
	this.cvAvailableBalance = cvAvailableBalance;
    }

    public BigDecimal getFcAvailableBalance()
    {
	return fcAvailableBalance;
    }

    public void setFcAvailableBalance(BigDecimal fcAvailableBalance)
    {
	this.fcAvailableBalance = fcAvailableBalance;
    }

    public BigDecimal getBaseCurrencyCode()
    {
	return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
	this.baseCurrencyCode = baseCurrencyCode;
    }

    public BigDecimal getPsrCustomerPercentage()
    {
	return psrCustomerPercentage;
    }

    public void setPsrCustomerPercentage(BigDecimal psrCustomerPercentage)
    {
	this.psrCustomerPercentage = psrCustomerPercentage;
    }

    public BigDecimal getModaribRate()
    {
	return modaribRate;
    }

    public void setModaribRate(BigDecimal modaribRate)
    {
	this.modaribRate = modaribRate;
    }

    public BigDecimal getCurrencyMinBalance()
    {
	return currencyMinBalance;
    }

    public void setCurrencyMinBalance(BigDecimal currencyMinBalance)
    {
	this.currencyMinBalance = currencyMinBalance;
    }

    public String getMode()
    {
	return mode;
    }

    public void setMode(String mode)
    {
	this.mode = mode;
    }

    public BigDecimal getFacilitySubLimit()
    {
	return facilitySubLimit;
    }

    public void setFacilitySubLimit(BigDecimal facilitySubLimit)
    {
	this.facilitySubLimit = facilitySubLimit;
    }

    public BigDecimal getOverdraftLimit()
    {
	return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit)
    {
	this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getLibor()
    {
	return libor;
    }

    public void setLibor(BigDecimal libor)
    {
	this.libor = libor;
    }

    public BigDecimal getPenalty()
    {
	return penalty;
    }

    public void setPenalty(BigDecimal penalty)
    {
	this.penalty = penalty;
    }

    public BigDecimal getChargesFees()
    {
	return chargesFees;
    }

    public void setChargesFees(BigDecimal chargesFees)
    {
	this.chargesFees = chargesFees;
    }

    public String getAllowChangeCif()
    {
	return allowChangeCif;
    }

    public void setAllowChangeCif(String allowChangeCif)
    {
	this.allowChangeCif = allowChangeCif;
    }

    public String getPftDesc()
    {
	return pftDesc;
    }

    public void setPftDesc(String pftDesc)
    {
	this.pftDesc = pftDesc;
    }

    public String getPftAddRef()
    {
	return pftAddRef;
    }

    public void setPftAddRef(String pftAddRef)
    {
	this.pftAddRef = pftAddRef;
    }

    public BigDecimal getPftBr()
    {
	return pftBr;
    }

    public void setPftBr(BigDecimal pftBr)
    {
	this.pftBr = pftBr;
    }

    public BigDecimal getPftCy()
    {
	return pftCy;
    }

    public void setPftCy(BigDecimal pftCy)
    {
	this.pftCy = pftCy;
    }

    public String getPostProfitTo()
    {
	return postProfitTo;
    }

    public void setPostProfitTo(String postProfitTo)
    {
	this.postProfitTo = postProfitTo;
    }

    public BigDecimal getInfoErrorCode()
    {
	return infoErrorCode;
    }

    public void setInfoErrorCode(BigDecimal infoErrorCode)
    {
	this.infoErrorCode = infoErrorCode;
    }

    public String[] getInfoErrorParam()
    {
	return infoErrorParam;
    }

    public void setInfoErrorParam(String... infoErrorParam)
    {
	this.infoErrorParam = infoErrorParam;
    }

    public String getCallingMode()
    {
	return callingMode;
    }

    public void setCallingMode(String callingMode)
    {
	this.callingMode = callingMode;
    }

    public String getCifShortNameEng()
    {
	return cifShortNameEng;
    }

    public void setCifShortNameEng(String cifShortNameEng)
    {
	this.cifShortNameEng = cifShortNameEng;
    }

    public String getCifLongNameEng()
    {
	return cifLongNameEng;
    }

    public void setCifLongNameEng(String cifLongNameEng)
    {
	this.cifLongNameEng = cifLongNameEng;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
    }

    public String getCifMailStmt()
    {
	return cifMailStmt;
    }

    public void setCifMailStmt(String cifMailStmt)
    {
	this.cifMailStmt = cifMailStmt;
    }

    public String getCifPeriod()
    {
	return cifPeriod;
    }

    public void setCifPeriod(String cifPeriod)
    {
	this.cifPeriod = cifPeriod;
    }

    public String getCifShortNameArb()
    {
	return cifShortNameArb;
    }

    public void setCifShortNameArb(String cifShortNameArb)
    {
	this.cifShortNameArb = cifShortNameArb;
    }

    public String getCifLongNameArb()
    {
	return cifLongNameArb;
    }

    public void setCifLongNameArb(String cifLongNameArb)
    {
	this.cifLongNameArb = cifLongNameArb;
    }

    public String getCifRelOff()
    {
	return cifRelOff;
    }

    public void setCifRelOff(String cifRelOff)
    {
	this.cifRelOff = cifRelOff;
    }

    public String getCifResident()
    {
	return cifResident;
    }

    public void setCifResident(String cifResident)
    {
	this.cifResident = cifResident;
    }

    public String getLegalStatusPremDedPcs()
    {
	return legalStatusPremDedPcs;
    }

    public void setLegalStatusPremDedPcs(String legalStatusPremDedPcs)
    {
	this.legalStatusPremDedPcs = legalStatusPremDedPcs;
    }

    public String getVipAlert()
    {
	return vipAlert;
    }

    public void setVipAlert(String vipAlert)
    {
	this.vipAlert = vipAlert;
    }

    public BigDecimal getCifLegalStatus()
    {
	return cifLegalStatus;
    }

    public void setCifLegalStatus(BigDecimal cifLegalStatus)
    {
	this.cifLegalStatus = cifLegalStatus;
    }

    public BigDecimal getCifDivision()
    {
	return cifDivision;
    }

    public void setCifDivision(BigDecimal cifDivision)
    {
	this.cifDivision = cifDivision;
    }

    public BigDecimal getBlackListed()
    {
	return blackListed;
    }

    public void setBlackListed(BigDecimal blackListed)
    {
	this.blackListed = blackListed;
    }

    public BigDecimal getMonthlySalary()
    {
	return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary)
    {
	this.monthlySalary = monthlySalary;
    }

    public BigDecimal getCifRelOffID()
    {
	return cifRelOffID;
    }

    public void setCifRelOffID(BigDecimal cifRelOffID)
    {
	this.cifRelOffID = cifRelOffID;
    }

    public Date getBirthDate()
    {
	return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
	this.birthDate = birthDate;
    }

    public String getCifDeptDesc()
    {
	return cifDeptDesc;
    }

    public void setCifDeptDesc(String cifDeptDesc)
    {
	this.cifDeptDesc = cifDeptDesc;
    }

    public String getCifDivisionDesc()
    {
	return cifDivisionDesc;
    }

    public void setCifDivisionDesc(String cifDivisionDesc)
    {
	this.cifDivisionDesc = cifDivisionDesc;
    }

    public void setCifDept(BigDecimal cifDept)
    {
	this.cifDept = cifDept;
    }

    public BigDecimal getCifDept()
    {
	return cifDept;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public String getPtIndicator()
    {
	return ptIndicator;
    }

    public void setPtIndicator(String ptIndicator)
    {
	this.ptIndicator = ptIndicator;
    }

    public String getPrefferedLanguage()
    {
	return prefferedLanguage;
    }

    public void setPrefferedLanguage(String prefferedLanguage)
    {
	this.prefferedLanguage = prefferedLanguage;
    }

    public AccountsDefaultCO getAccountsDefaultCO()
    {
	return accountsDefaultCO;
    }

    public void setAccountsDefaultCO(AccountsDefaultCO accountsDefaultCO)
    {
	this.accountsDefaultCO = accountsDefaultCO;
    }

    public Boolean getCreateNewAccountFlag()
    {
	return createNewAccountFlag;
    }

    public void setCreateNewAccountFlag(Boolean createNewAccountFlag)
    {
	this.createNewAccountFlag = createNewAccountFlag;
    }

    public String getGlDesc()
    {
	return glDesc;
    }

    public void setGlDesc(String glDesc)
    {
	this.glDesc = glDesc;
    }

    public String getEditType()
    {
	return editType;
    }

    public void setEditType(String editType)
    {
	this.editType = editType;
    }

    public String getCertOfDepositGridString()
    {
	return certOfDepositGridString;
    }

    public void setCertOfDepositGridString(String certOfDepositGridString)
    {
	this.certOfDepositGridString = certOfDepositGridString;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public String getDrPtIndex()
    {
	return drPtIndex;
    }

    public void setDrPtIndex(String drPtIndex)
    {
	this.drPtIndex = drPtIndex;
    }

    public String getTypesGA()
    {
	return typesGA;
    }

    public void setTypesGA(String typesGA)
    {
	this.typesGA = typesGA;
    }

    public String getGlCategory()
    {
	return glCategory;
    }

    public void setGlCategory(String glCategory)
    {
	this.glCategory = glCategory;
    }

    public String getBusinessCrud()
    {
	return businessCrud;
    }

    public void setBusinessCrud(String businessCrud)
    {
	this.businessCrud = businessCrud;
    }

    public BigDecimal getMinimumOpeningBalance()
    {
	return minimumOpeningBalance;
    }

    public void setMinimumOpeningBalance(BigDecimal minimumOpeningBalance)
    {
	this.minimumOpeningBalance = minimumOpeningBalance;
    }

    public BigDecimal getMinimumOpeningBalancePrev()
    {
	return minimumOpeningBalancePrev;
    }

    public void setMinimumOpeningBalancePrev(BigDecimal minimumOpeningBalancePrev)
    {
	this.minimumOpeningBalancePrev = minimumOpeningBalancePrev;
    }

    public BigDecimal getAdecAamount()
    {
	return adecAamount;
    }

    public void setAdecAamount(BigDecimal adecAamount)
    {
	this.adecAamount = adecAamount;
    }

    public BigDecimal getCvAmount()
    {
	return cvAmount;
    }

    public void setCvAmount(BigDecimal cvAmount)
    {
	this.cvAmount = cvAmount;
    }

    public BigDecimal getAsColName()
    {
	return asColName;
    }

    public void setAsColName(BigDecimal asColName)
    {
	this.asColName = asColName;
    }

    public BigDecimal getSuspendReasonCode()
    {
	return suspendReasonCode;
    }

    public void setSuspendReasonCode(BigDecimal suspendReasonCode)
    {
	this.suspendReasonCode = suspendReasonCode;
    }

    public String getSuspendReasonDesc()
    {
	return suspendReasonDesc;
    }

    public void setSuspendReasonDesc(String suspendReasonDesc)
    {
	this.suspendReasonDesc = suspendReasonDesc;
    }

    public String getPcInd()
    {
	return pcInd;
    }

    public void setPcInd(String pcInd)
    {
	this.pcInd = pcInd;
    }

    public String getGenAccDesCif()
    {
	return genAccDesCif;
    }

    public void setGenAccDesCif(String genAccDesCif)
    {
	this.genAccDesCif = genAccDesCif;
    }

    public String get_addressPageRef()
    {
	return _addressPageRef;
    }

    public void set_addressPageRef(String addressPageRef)
    {
	_addressPageRef = addressPageRef;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getMailStatement()
    {
	return mailStatement;
    }

    public void setMailStatement(String mailStatement)
    {
	this.mailStatement = mailStatement;
    }

    public String getMailAdvise()
    {
	return mailAdvise;
    }

    public void setMailAdvise(String mailAdvise)
    {
	this.mailAdvise = mailAdvise;
    }

    public String getStatementPeriod()
    {
	return statementPeriod;
    }

    public void setStatementPeriod(String statementPeriod)
    {
	this.statementPeriod = statementPeriod;
    }

    public String getMinStatementBalance()
    {
	return minStatementBalance;
    }

    public void setMinStatementBalance(String minStatementBalance)
    {
	this.minStatementBalance = minStatementBalance;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    /**
     * @return the afterConfirmMsgFlag
     */
    public Boolean getAfterConfirmMsgFlag()
    {
	return afterConfirmMsgFlag;
    }

    /**
     * @param afterConfirmMsgFlag the afterConfirmMsgFlag to set
     */
    public void setAfterConfirmMsgFlag(Boolean afterConfirmMsgFlag)
    {
	this.afterConfirmMsgFlag = afterConfirmMsgFlag;
    }

    /**
     * @return the updatePassbookFlag
     */
    public Boolean getUpdatePassbookFlag()
    {
	return updatePassbookFlag;
    }

    /**
     * @param updatePassbookFlag the updatePassbookFlag to set
     */
    public void setUpdatePassbookFlag(Boolean updatePassbookFlag)
    {
	this.updatePassbookFlag = updatePassbookFlag;
    }

    public String getModeOfPayment()
    {
	return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment)
    {
	this.modeOfPayment = modeOfPayment;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public BigDecimal getOpenDepTrxType()
    {
	return openDepTrxType;
    }

    public void setOpenDepTrxType(BigDecimal openDepTrxType)
    {
	this.openDepTrxType = openDepTrxType;
    }

    public String getBaseCurrencyName()
    {
	return baseCurrencyName;
    }

    public void setBaseCurrencyName(String baseCurrencyName)
    {
	this.baseCurrencyName = baseCurrencyName;
    }

    public BigDecimal getBaseCurrencyDecimalPoints()
    {
	return baseCurrencyDecimalPoints;
    }

    public void setBaseCurrencyDecimalPoints(BigDecimal baseCurrencyDecimalPoints)
    {
	this.baseCurrencyDecimalPoints = baseCurrencyDecimalPoints;
    }

    public BigDecimal getAccMainDetTransfrAccBr()
    {
	return accMainDetTransfrAccBr;
    }

    public void setAccMainDetTransfrAccBr(BigDecimal accMainDetTransfrAccBr)
    {
	this.accMainDetTransfrAccBr = accMainDetTransfrAccBr;
    }

    public BigDecimal getAccMainDetTransfrAccCy()
    {
	return accMainDetTransfrAccCy;
    }

    public void setAccMainDetTransfrAccCy(BigDecimal accMainDetTransfrAccCy)
    {
	this.accMainDetTransfrAccCy = accMainDetTransfrAccCy;
    }

    public BigDecimal getAccMainDetTransfrAccGl()
    {
	return accMainDetTransfrAccGl;
    }

    public void setAccMainDetTransfrAccGl(BigDecimal accMainDetTransfrAccGl)
    {
	this.accMainDetTransfrAccGl = accMainDetTransfrAccGl;
    }

    public BigDecimal getAccMainDetTransfrAccCif()
    {
	return accMainDetTransfrAccCif;
    }

    public void setAccMainDetTransfrAccCif(BigDecimal accMainDetTransfrAccCif)
    {
	this.accMainDetTransfrAccCif = accMainDetTransfrAccCif;
    }

    public BigDecimal getAccMainDetTransfrAccSl()
    {
	return accMainDetTransfrAccSl;
    }

    public void setAccMainDetTransfrAccSl(BigDecimal accMainDetTransfrAccSl)
    {
	this.accMainDetTransfrAccSl = accMainDetTransfrAccSl;
    }

    public BigDecimal getBlockedCV()
    {
	return blockedCV;
    }

    public void setBlockedCV(BigDecimal blockedCV)
    {
	this.blockedCV = blockedCV;
    }

    public BigDecimal getBlockedFC()
    {
	return blockedFC;
    }

    public void setBlockedFC(BigDecimal blockedFC)
    {
	this.blockedFC = blockedFC;
    }

    public String getAddRef()
    {
	return addRef;
    }

    public void setAddRef(String addRef)
    {
	this.addRef = addRef;
    }

    public BigDecimal getMinimumBalance()
    {
	return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance)
    {
	this.minimumBalance = minimumBalance;
    }

    public boolean isResetGLDetails()
    {
	return resetGLDetails;
    }

    public void setResetGLDetails(boolean resetGLDetails)
    {
	this.resetGLDetails = resetGLDetails;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public String getMKT_BY_ID()
    {
	return MKT_BY_ID;
    }

    public void setMKT_BY_ID(String mKTBYID)
    {
	MKT_BY_ID = mKTBYID;
    }

    public String getMKT_FOR_ID()
    {
	return MKT_FOR_ID;
    }

    public void setMKT_FOR_ID(String mKTFORID)
    {
	MKT_FOR_ID = mKTFORID;
    }

    public String getMKT_POSITION_BY()
    {
	return MKT_POSITION_BY;
    }

    public void setMKT_POSITION_BY(String mKTPOSITIONBY)
    {
	MKT_POSITION_BY = mKTPOSITIONBY;
    }

    public String getMKT_DIVISION_BY()
    {
	return MKT_DIVISION_BY;
    }

    public void setMKT_DIVISION_BY(String mKTDIVISIONBY)
    {
	MKT_DIVISION_BY = mKTDIVISIONBY;
    }

    public String getMKT_DEPARTMENT_BY()
    {
	return MKT_DEPARTMENT_BY;
    }

    public void setMKT_DEPARTMENT_BY(String mKTDEPARTMENTBY)
    {
	MKT_DEPARTMENT_BY = mKTDEPARTMENTBY;
    }

    public String getMKT_BY()
    {
	return MKT_BY;
    }

    public void setMKT_BY(String mKTBY)
    {
	MKT_BY = mKTBY;
    }

    public String getMKT_FOR()
    {
	return MKT_FOR;
    }

    public void setMKT_FOR(String mKTFOR)
    {
	MKT_FOR = mKTFOR;
    }

    public String getMKT_DIVISION_FOR()
    {
	return MKT_DIVISION_FOR;
    }

    public void setMKT_DIVISION_FOR(String mKTDIVISIONFOR)
    {
	MKT_DIVISION_FOR = mKTDIVISIONFOR;
    }

    public String getMKT_DEPARTMENT_FOR()
    {
	return MKT_DEPARTMENT_FOR;
    }

    public void setMKT_DEPARTMENT_FOR(String mKTDEPARTMENTFOR)
    {
	MKT_DEPARTMENT_FOR = mKTDEPARTMENTFOR;
    }

    /**
     * @return the receivedFrom
     */
    public String getReceivedFrom()
    {
	return receivedFrom;
    }

    /**
     * @param receivedFrom the receivedFrom to set
     */
    public void setReceivedFrom(String receivedFrom)
    {
	this.receivedFrom = receivedFrom;
    }

    public String getOpenDepTrxTypeDesc()
    {
	return openDepTrxTypeDesc;
    }

    public void setOpenDepTrxTypeDesc(String openDepTrxTypeDesc)
    {
	this.openDepTrxTypeDesc = openDepTrxTypeDesc;
    }

    public ArrayList<Integer> getWarningListCode()
    {
	return warningListCode;
    }

    public void setWarningListCode(ArrayList<Integer> warningListCode)
    {
	this.warningListCode = warningListCode;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public String getValidateAllowedCurrency()
    {
	return validateAllowedCurrency;
    }

    public void setValidateAllowedCurrency(String validateAllowedCurrency)
    {
	this.validateAllowedCurrency = validateAllowedCurrency;
    }

    public Boolean getFromCloseTransferFlag()
    {
	return fromCloseTransferFlag;
    }

    public void setFromCloseTransferFlag(Boolean fromCloseTransferFlag)
    {
	this.fromCloseTransferFlag = fromCloseTransferFlag;
    }

    public Boolean getFromFMAMaturityInstructionsTansferFlag()
    {
	return fromFMAMaturityInstructionsTansferFlag;
    }

    public void setFromFMAMaturityInstructionsTansferFlag(Boolean fromFMAMaturityInstructionsTansferFlag)
    {
	this.fromFMAMaturityInstructionsTansferFlag = fromFMAMaturityInstructionsTansferFlag;
    }

    public Boolean getFromFMAOffendingInstructionsFlag()
    {
	return fromFMAOffendingInstructionsFlag;
    }

    public void setFromFMAOffendingInstructionsFlag(Boolean fromFMAOffendingInstructionsFlag)
    {
	this.fromFMAOffendingInstructionsFlag = fromFMAOffendingInstructionsFlag;
    }

    public Boolean getFromFMAProfitCalcInstructionsFlag()
    {
	return fromFMAProfitCalcInstructionsFlag;
    }

    public void setFromFMAProfitCalcInstructionsFlag(Boolean fromFMAProfitCalcInstructionsFlag)
    {
	this.fromFMAProfitCalcInstructionsFlag = fromFMAProfitCalcInstructionsFlag;
    }

    public Boolean getFromMainDetailsTansferToDepositFlag()
    {
	return fromMainDetailsTansferToDepositFlag;
    }

    public void setFromMainDetailsTansferToDepositFlag(Boolean fromMainDetailsTansferToDepositFlag)
    {
	this.fromMainDetailsTansferToDepositFlag = fromMainDetailsTansferToDepositFlag;
    }

    public Boolean getFromGAProfitCalcInstructionsFlag()
    {
	return fromGAProfitCalcInstructionsFlag;
    }

    public void setFromGAProfitCalcInstructionsFlag(Boolean fromGAProfitCalcInstructionsFlag)
    {
	this.fromGAProfitCalcInstructionsFlag = fromGAProfitCalcInstructionsFlag;
    }

    public Boolean getFromGATransferDetailsOffendingInstructionsFlag()
    {
	return fromGATransferDetailsOffendingInstructionsFlag;
    }

    public void setFromGATransferDetailsOffendingInstructionsFlag(Boolean fromGATransferDetailsOffendingInstructionsFlag)
    {
	this.fromGATransferDetailsOffendingInstructionsFlag = fromGATransferDetailsOffendingInstructionsFlag;
    }

    public Boolean getFromFMAOpeningDepositDetailsFlag()
    {
	return fromFMAOpeningDepositDetailsFlag;
    }

    public void setFromFMAOpeningDepositDetailsFlag(Boolean fromFMAOpeningDepositDetailsFlag)
    {
	this.fromFMAOpeningDepositDetailsFlag = fromFMAOpeningDepositDetailsFlag;
    }

    public Integer getCountSuspicious()
    {
	return countSuspicious;
    }

    public void setCountSuspicious(Integer countSuspicious)
    {
	this.countSuspicious = countSuspicious;
    }

    public String getSoundex1()
    {
	return soundex1;
    }

    public void setSoundex1(String soundex1)
    {
	this.soundex1 = soundex1;
    }

    public String getSoundex2()
    {
	return soundex2;
    }

    public void setSoundex2(String soundex2)
    {
	this.soundex2 = soundex2;
    }

    public String getSoundex3()
    {
	return soundex3;
    }

    public void setSoundex3(String soundex3)
    {
	this.soundex3 = soundex3;
    }

    public String getSoundex4()
    {
	return soundex4;
    }

    public void setSoundex4(String soundex4)
    {
	this.soundex4 = soundex4;
    }

    public String getSoundexAr1()
    {
	return soundexAr1;
    }

    public void setSoundexAr1(String soundexAr1)
    {
	this.soundexAr1 = soundexAr1;
    }

    public String getSoundexAr2()
    {
	return soundexAr2;
    }

    public void setSoundexAr2(String soundexAr2)
    {
	this.soundexAr2 = soundexAr2;
    }

    public String getSoundexAr3()
    {
	return soundexAr3;
    }

    public void setSoundexAr3(String soundexAr3)
    {
	this.soundexAr3 = soundexAr3;
    }

    public String getSoundexAr4()
    {
	return soundexAr4;
    }

    public void setSoundexAr4(String soundexAr4)
    {
	this.soundexAr4 = soundexAr4;
    }

    public String getWarningMessage()
    {
	return warningMessage;
    }

    public void setWarningMessage(String warningMessage)
    {
	this.warningMessage = warningMessage;
    }

    public RIFATTVO getRifattVO()
    {
	return rifattVO;
    }

    public void setRifattVO(RIFATTVO rifattVO)
    {
	this.rifattVO = rifattVO;
    }

    public BigDecimal getAddRefGlobalMaskLength()
    {
	return addRefGlobalMaskLength;
    }

    public void setAddRefGlobalMaskLength(BigDecimal addRefGlobalMaskLength)
    {
	this.addRefGlobalMaskLength = addRefGlobalMaskLength;
    }

    public String getAddRefProtectMask()
    {
	return addRefProtectMask;
    }

    public void setAddRefProtectMask(String addRefProtectMask)
    {
	this.addRefProtectMask = addRefProtectMask;
    }

    public String getOldAddRef()
    {
	return oldAddRef;
    }

    public void setOldAddRef(String oldAddRef)
    {
	this.oldAddRef = oldAddRef;
    }

    public String getAccountSign1()
    {
        return accountSign1;
    }

    public void setAccountSign1(String accountSign1)
    {
        this.accountSign1 = accountSign1;
    }

    public String getAccountSign2()
    {
        return accountSign2;
    }

    public void setAccountSign2(String accountSign2)
    {
        this.accountSign2 = accountSign2;
    }

}