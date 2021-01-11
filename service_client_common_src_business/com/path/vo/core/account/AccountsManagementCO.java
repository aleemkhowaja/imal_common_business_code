package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMF_ADDRESSVO;
import com.path.dbmaps.vo.AMF_EXTENDEDVO;
import com.path.dbmaps.vo.AMF_PT_DETAILSVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CTSCARDS_ACCVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_ACC_TRX_LIMITVO;
import com.path.dbmaps.vo.CTS_AMF_KYC_DETAILSVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.PFT_EXCEPTIONAL_RATEVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.cifproduct.CifProductsCO;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.common.chargeswaiver.ChargesWaiverCO;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.cardsmanagement.CardsManagementCO;



/****
 * Class for General Accounts main screen Copyright 2012, Path Solutions Path
 * Solutions retains all ownership rights to this source code
 * 
 * @author: navas
 * 
 *          GeneralAccountsCO.java used to
 */
public class AccountsManagementCO extends RetailBaseVO
{
    private PFT_EXCEPTIONAL_RATEVO  PftExceptionalRateVO = new PFT_EXCEPTIONAL_RATEVO();
    private String fromToAmtIndicator;
    private AMFVO amfVO = new AMFVO();
    private AMF_EXTENDEDVO amfExtendedVO = new AMF_EXTENDEDVO();
    private ACC_NV_CONTROLVO accControlVO = new ACC_NV_CONTROLVO();
    private AmfDrawDownsCO amfDrawDownsCO = new AmfDrawDownsCO();
    private RIFATTVO rifattVO = new RIFATTVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTSCONTROLVO ctsControl = new CTSCONTROLVO();
    private COMPANIESVO companiesVO = new COMPANIESVO();
    private PTH_CTRLVO pthCtrlVO = new PTH_CTRLVO();
    private CIFVO cifVO = new CIFVO();
    private GEN_LEDGERVO genLedGer = new GEN_LEDGERVO();
    private AddressCommonCO addressCommonCO = new AddressCommonCO();/* Libin */
    private AMF_ADDRESSVO addressVO = new AMF_ADDRESSVO();
    private List<AMF_ADDRESSVO> addressVOList = new ArrayList<AMF_ADDRESSVO>();
    private MosBlackListCO mosBlackListCO = new MosBlackListCO();
    private CTSCARDS_ACCVO ctsCardsAccVO;
    private CTSCARDS_MGTVO ctsCardsMgtVO;
    
    //AMANA130105---[John Massaad]
    private FMSFACILITYDETVO fmsFacilityDetVO  = new FMSFACILITYDETVO();
    //AMANA130105---[John Massaad]
    
    private SignatureCO signatureCO = new SignatureCO();    //Drawdown details;
    private S_APPVO sappVO = new S_APPVO();
    private String integAction; // Web Service Action
    /* Variable to handle the cif product */
    private CifProductsCO cifProducts = new CifProductsCO();
    private AccountsDefaultCO accountsDefaultCO = new AccountsDefaultCO();//to check
    
//  Print advice
    private ReportResponseCO accountAutoSweepConfirmationReport = new ReportResponseCO();    
// Alerts property
    private AlertsParamCO alertsParamCO;
    private CURRENCIESVO currenciesVO;
    
    
    // added by nancy - 18/10/2017- 574009-SBI170024 - account wise slabs required, Rack rate change in the product with date range for profit
    private String exceptionalCrDrIdx;
    private String exceptionalRatesChanged;
    // end nancy
    
    BigDecimal profitTillDueDate;// for Profit Paid Till Date
    BigDecimal profitTillDate;// for Profit Accrued Till Date
    private BigDecimal lovTypeId;
    private String curAccName;
    private String curAccAddRef;
    private BigDecimal currentMaturityDays;// Computed field in the fixed
					   // maturity account
    private String renewAccount;
    private BigDecimal psrCustomer;

    private String branchDesc;
    private String currencyDesc;
    private String glDesc;
    private String cifName;
    private String statusReasonDesc;
    private String economicSectorDesc;
    private String subEconomicSectorDesc;
    private String divisionDesc;
    private String departmentDesc;
    private String unitsDesc;
    private String officerDesc;
    private String chargesDesc;
    private String marketedByPositionDesc;
    private String marketedByDivisionDesc;
    private String marketedByDepartmentDesc;
    private String marketedForDivisionDesc;
    private String marketedForDepartmentDesc;
    private String trxtTypeDesc;
    private String holdTrxTypeDesc;

    private String trfCurAccName;
    private String trfCurAccAddRef;
    private String offCurAccName;
    private String offCurAccAddRef;
    private String pftCurAccName;
    private String pftCurAccAddRef;
    private Boolean createNewAccountFlag;// new_ind
    private Boolean enforceSignLimit;
    private Boolean autoSweepFlag;
    private Boolean pointAccrualToMaturity;
    private Boolean taxApplied;
    private Boolean applyPcsCharges;
    private Boolean zakatApplied;
    private Boolean premiumDeductionPcs;
    private Boolean advancedProfitFlag;
    private Boolean resetRateMaturity;
    private Boolean appTaxCapRev;
    private Boolean specialRate;
    private Boolean createNewAccountTransferFlag;
    private boolean callFromPopup;
    private String statusDesc;
    private String bsContra;
    private String unclaimedTrans;
    private String cifblacklistedTrans;
    private boolean moreAddressReadOnly;

    /* jihad */
    private String saveType;
    private String saveTypeAMFextended;
    private String saveTypeAddress;

    //
    boolean globalConfirmationFlag;
    private boolean updatePassbookFlag;
    private boolean updateBillsFlag;
    private ArrayList<BaseException> warningMessagesList = new ArrayList<BaseException>();
    // Libin added for Certificate Of Deposit
    private List<CertificateDepositCO> certOfDepositList = new ArrayList<CertificateDepositCO>();
    private List<CtsMailDetCO> mailDetList = new ArrayList<CtsMailDetCO>();
    
    private List<LimitSchemaCO> limitSchemaList = new ArrayList<LimitSchemaCO>();
    private List<ChargesWaiverCO> chargesWaiverList;
    private List<AccountsChargesCO> accountsChargesListCOs;
    private List<PftExceptionalRateCO> pftExceptionalDebitRateCOs;
    private List<PftExceptionalRateCO> pftExceptionalCrebitRateCOs;
    private boolean accountsChargesWindowOpened;
    private String warningMessage;

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private Integer noOfCifProducts;
    private String issueChqbkState;
    private String issueBillsState;
    private String issueCardState;
    private String issuePassBookState;
    //private String showMemoOnLoad;//NABIL FEGHALI - IIAB120195 - IMAL - MEMO ALERT - TRX
    //private String memoOptRef;//NABIL FEGHALI - IIAB120195 - IMAL - MEMO ALERT - TRX
    private String blackListWarningMsg;
    private String unclaimedWarningMsg;
    private Boolean isPrintCertificate = Boolean.FALSE;
    private String parentRef;

    // boolean variables used to set tabs as readonly or not.
    private boolean headerScreenReadOnly;
    private boolean mainDetailsTabReadOnly;
    private boolean instructionsTabReadOnly;
    private boolean ptDetailsTabReadOnly;
    private boolean mailingDetailsTabReadOnly;
    private boolean marketDetailsTabReadOnly;
    private boolean customFieldsTabReadOnly;
    private boolean additionalDetailsTabReadOnly; //
    private boolean limitSchemaScreenReadOnly;
    private boolean cifProductScreenReadOnly;
    private boolean accountDrawDownScreenReadOnly;
    private boolean accountAddressScreenReadOnly;
    private boolean certificateOfDepositScreenReadOnly;
    private boolean soMailDetailsScreenReadOnly;
    private boolean allScreenReadOnly;
    private int proceed;

    private String showExceptionalRatesBtns;
    //
    private boolean approveFirstTime;

    // Additional Fields by Type isLoaded flag
    private List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList = new ArrayList<AdditionalFieldsByTypeCO>();
    private String additionalFieldsURL;

    private String vipAlert;
    private String ofTheTotalDepositAmount;
    private String percentageLabel;
    // Alerts property
    private String showAlertButton;
    private String userIsBranchManager;
    private String isRateAlert;
    private BigDecimal initialMinimumOpeningBalance;
    private BigDecimal scannedCIFNo;
    private String isFromAlert;
    // PB = <*AUTO_APPROVE*>
    private Boolean autoApproveFlag;
    private String showAlertModifyButton;
    private String showAlertScanButton;
    private String accountNumber;
    private BigDecimal minimumBalance;
    private boolean autoCreate;
    private BigDecimal trsNo;

    private ArrayList<SmartCO> smartCOList;
    private boolean investmentAccount;

    private ArrayList<String> warningList = new ArrayList<String>();

    // Print advice
    private List<ReportResponseCO> accountConfirmationReportList = new ArrayList<ReportResponseCO>();
    private List<ReportResponseCO> cardReportResponseCOList = new ArrayList<ReportResponseCO>();
    private String accPrintConfirmation;
    // NABIL FEGHALI - BB120129 - YMC FORMS
    private List<ReportResponseCO> additionalAdvicesReportList = new ArrayList<ReportResponseCO>();
    //AMANA1301 -- [John Massaad]
    //AMANA1301 -- [John Massaad]
    
    // Libin commented this as any reference to its usage is not seen anywhere
    // and this entry is a duplicate name in "AccountsMainAction
    // and it results in issues to the values set to pftPostToDropDown variable
    // in action class
    // If this entry is needed please assign a different variable name and use
    // accordingly
    // This entry resulted in bug 0091011 and spend hours to locate this
    private List<SelectCO> pftPostToDropDwn = new ArrayList<SelectCO>();
    private String fixAccReportType;// OP ACC or ADV

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
    private boolean certificateOfDepositGridEditable = true;

    private boolean autoCreateApprove;

    // IIAB100318 John Massaad
    private BigDecimal addRefGlobalMaskLength;
    private String addRefProtectMask;
    private String addRefGlobalMask;

    // TONY NOUH IIAB110142 30/12/2013
    private Integer accountsHavingCifDormant;

    
    //related for maximumOverdrawBalanceDesc
    private String accountSign1;
    //related for minimumBalancePointsDesc
    private String accountSign2;
    
    private String flag;
    private BigDecimal cifType;//to check
    private String limitType;;//to check
    private String drCrIdx;
    private String pftDrCrIdx;
    private BigDecimal linkReference;
    private String editType;
    private BigDecimal detInd;
    private String pcInd;
    private String genAccDesCif;
    private BigDecimal cvAmount;
    private String receivedFrom;
    private String ptIndex;
    private Date applicableDate;
    private String mode;
    private String callingMode;
    private BigDecimal infoErrorCode;
    private String[] infoErrorParam;
    private String columnSelector;
    private String businessCrud;
    private Boolean afterConfirmMsgFlag;
    private String maturityFlag;
    private boolean resetGLDetails;
    private String glCategory;
    private String validateAllowedCurrency;
    private String editMode;
    private String addressPageRef;
    //private Boolean fromCloseTransferFlag;
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
    private String oldAddRef;
    private String baseCurrencyName;
    private BigDecimal amount; // used as criteria for the queries in AccountsEventMgmtMapper
    private boolean addRefChanged;
    private String preferredLanguage; // should be removed and replaced by loginPreferredLanguage after sending email to all teams
    private String colName;
    private Date dateUpdated;
    private String newDateUpdated;
    private String nullDateClosed;//contain value '1' if we need to set date closed to null
    private String nullEffClosedDate;//contain value '1' if we need to set effective closed date to null
    private Date oldDateValue;
    private boolean moreAddressWindowOpened;
    private boolean returnChargesSchemaFromPftRate;
    
    private BigDecimal availableOverdraft;
    private BigDecimal ovDraftAvLimit;
    
    private BigDecimal lockId;//US 154817 
    private String accForLockExists;//US 154817 return true in case the procedure P_RET_LOCK_UNLOCK_SAFE_ACC return accounts to be locked
    
    private Boolean isFromModaribRateDep;
    
    private String exemptFullChargesWaiver;
    

    private Integer accountsManagementLstRec;
    private List<AccountsManagementCO> accountsManagementLst;
    
    private String checkType;
    
    private String printAlertAck;
    
    private String subStatusDesc;//Hala - TP661014 JAIZ160072 - 30/08/2018
    
    //id:1057741 Details:MBSI200026 - Seperator set up not working while account number generation falha TAR:MBSI200026
    private String FORMATTED_ADDITIONAL_REFERENCE;
    
    /**
     * @author RaniaAlBitar
     * DB170108 - Advance profit payment
     */
    
    
    private String openingAccSignature;
    private String displayPhoto;
    private BigDecimal openingAccSignatureAmt;
    
    private String bicCode;//maureen
    private String registerNumber;//maureen
    private String registeredMobile;//maureen
    private String IDNo;
    private BigDecimal IDType;
    private String issueCountry;
    private String mobileWalletYN;
    private CTS_AMF_KYC_DETAILSVO ctsAmfKycDetailsVO;
    private BigDecimal screenId;
    private String additionnalKycProps;
    private String kycDhfLoaded;
    private String allowInternalOpenDepAcc;//Rania - Bug #cc -  System is not showing internal Accounts in the lookup query - DB140010 - the FMA should allow to be funded from other accounts
    private BigDecimal payAmount; //Rania - DB140075 - Customer wants to close the General Account - R14.1.1
    private BigDecimal originalPayAmount; 

    private String statusCode;
    
    /**
     * @author RaniaAlBitar
     * DB170108 - Advance profit payment
     */
    
    private String advanceProfitPaymentGridUpdate;
    private List<AdvanceProfitRatesCO> advanceProfitRatesCOList = new ArrayList<AdvanceProfitRatesCO>(); 
    private String advanceProfitRatesGridUpdates; 
    private String advanceProfitRateAccAddRef; 
    private String advanceProfitRateAccDesc; 
    private Date toDate; 
    private Date fromDate; 
    private String pointsPosted; 
    private BigDecimal advanceRate; 
    private String errorText;  
    private String advanceProfitAlert;
    private String advanceProfitAlertIndicator;
    /**End Rania */
    
    private String exemptReasonDesc;
    
    
    private String reasonCodeDesc;
    private String exemptedFromFilerFlag;
    
    private String isAsaanAcc;    
    
    private String drcrIdx;

    
    private BigDecimal overDraftLimit; //Rania - AIBBI180340 - SBI170029 - Excess Over Limit 
    private String accOverDrawnYN; //Rania - AIBBI180340 - SBI170029 - Excess Over Limit 
    private BigDecimal originCR_PT_RATE;
    private BigDecimal originDR_PT_RATE;
    private String rateChangedFlag;

    private BigDecimal maxAmount;
    private String actionType;
    private String msgConfCode;
    private String revDrawdown;
    
    private String cifNationalityCheck;//Hala Al Sheikh - ABSAI180072
    
    private String fromDeleteDrawDown;
    
    private String savingAccount;
    private String currentAccount;
    
    private String updateApplDate;
    private BigDecimal RATE;
    
    private BigDecimal lastPoints;
    
    private BigDecimal totalAccruedPoints;
    
    //Webservice: Reports generation
    private List<ReportsCO> reportsList;
    //
    //Tony Nouh User Story#336860 INDI150072
    private List<AMF_PT_DETAILSVO> amfPtDetailsDebitVOs;
    private List<AMF_PT_DETAILSVO> amfPtDetailsCreditVOs;
    
    private String exemptedFromVAT; //Hasan Bug#402973 17/05/2016
    private BigDecimal compCodeCif;//Hasan EWBI160091 15/06/2016
    
    //US 418490 
    private String currISOCode;
    private BigDecimal todayAmountCredit;
    private BigDecimal todayAmountDebit;
    private BigDecimal todayAmountFloat;
    public BigDecimal dealNo;
    public String dealCustomNo;
    
    //US 418496
    private BigDecimal pointRate;
    private BigDecimal newBS;
    
    //418497
    private String instruction1,instruction2;
    private String errorMessage;
    private Date maturityDate;

    
    // Hala Al Sheikh - SBI170059 SBI170060    
    private String clubbingOverdraftAcc; 
    private BigDecimal overdraftType;	 
    private BigDecimal nullDec;
    private Date nullDate;
    private String nullStr; 	
    
    //Rania - Merging of AIB150186 and AIB170086-14.1.3
    private String chargesWaiverLoaded;
    //

    //418497
    private Date lastDepositDate,lastWithdrawalDate,lastActivityDate;
    private BigDecimal lastDepositAmount,lastWithdrawalAmount;
    private BigDecimal todayCreditAmount,todayDebitAmount;
    private BigDecimal opNo, lineNo;
    private BigDecimal alPos;
    //#DN 454456 - EWBI160710
    public BigDecimal startPosition,fieldLength;
    
    //Raed Saad - [BB160150]
    private String nickName;
    private String allowCifCreationMaskYN;
    private String maskNameYN;
    //END Raed Saad - [BB160150]
    
    //Hasan BMO160011 23/01/2017
    private BigDecimal blackListReason;
    private BigDecimal blackListReturnValue;
    private String blackListReasonDesc;
    private String methodName;
    private Integer msgCode;    
    private BigDecimal trxType;
    private BigDecimal openingDepCif;
    
    private String cifDesc;
    
    //Raed Saad - [#539366 - AMANA130105] 
    private String facilityUsedByCustomer;
    private List<AccountsGAProfitDeclarationCO> profitDeclAllRecList = new ArrayList<AccountsGAProfitDeclarationCO>();
    //END - Raed Saad - [#539366 - AMANA130105] 

    //Raed Saad - [#555944 AMANA150181] 
    private String refundCurAccName;
    private String refundCurAccAddRef;
    //END - Raed Saad - [#555944 AMANA150181] 
    private BigDecimal oldFacilityNo;
    private BigDecimal oldFacilitySubLimit;
    
    private String signatureSign;
    private BigDecimal signAmount;
    //Rakan Makarem -DASI170128
    private String allowedGl;
    private String allowedBill;
    private String allowedGlAction;

    //Hala Al Sheikh TP790351 - DASI190021
    private BigDecimal accCySettlement;
    private BigDecimal accCifSettlement;
    private String accAddRefSettlement;
    private String accDescSettlement;
    private BigDecimal accGlSettlement;
    private BigDecimal accSlSettlement;
    
    private String affectedChequebook;
    
    //maria for bmo180074
    private String errorMsg;
    private String errorType;
    private BigDecimal errorCode;
    private String origin;
    private boolean sendRestrictAlert;
    boolean restrictConfirmationFlag; 
    
    //#809406 - AMANA180073 
    private String ptIndicator;
    private String continueProcess = "false";
    
    
    private CardsManagementCO cardsManagementCO = new CardsManagementCO();//BB200555    

    
    //Hasan ghrayeb -BB200160

    private CTS_ACC_TRX_LIMITVO ctsacctrxlimitvo;
    //End Hasan
    
    
    
    public String getPrintAlertAck()
    {
        return printAlertAck;
    }

    public void setPrintAlertAck(String printAlertAck)
    {
        this.printAlertAck = printAlertAck;
    }

    public BigDecimal getSignAmount()
    {
        return signAmount;
    }

    public void setSignAmount(BigDecimal signAmount)
    {
        this.signAmount = signAmount;
    }

    public String getSignatureSign()
    {
        return signatureSign;
    }

    public void setSignatureSign(String signatureSign)
    {
        this.signatureSign = signatureSign;
    }

    public BigDecimal getOldFacilityNo()
    {
        return oldFacilityNo;
    }

    public void setOldFacilityNo(BigDecimal oldFacilityNo)
    {
        this.oldFacilityNo = oldFacilityNo;
    }

    public BigDecimal getOldFacilitySubLimit()
    {
        return oldFacilitySubLimit;
    }

    public void setOldFacilitySubLimit(BigDecimal oldFacilitySubLimit)
    {
        this.oldFacilitySubLimit = oldFacilitySubLimit;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public List<AccountsChargesCO> getAccountsChargesListCOs()
    {
        return accountsChargesListCOs;
    }

    public void setAccountsChargesListCOs(List<AccountsChargesCO> accountsChargesListCOs)
    {
        this.accountsChargesListCOs = accountsChargesListCOs;
    }

    public boolean isAccountsChargesWindowOpened()
    {
        return accountsChargesWindowOpened;
    }

    public void setAccountsChargesWindowOpened(boolean accountsChargesWindowOpened)
    {
        this.accountsChargesWindowOpened = accountsChargesWindowOpened;
    }

    public boolean isReturnChargesSchemaFromPftRate()
    {
        return returnChargesSchemaFromPftRate;
    }

    public void setReturnChargesSchemaFromPftRate(boolean returnChargesSchemaFromPftRate)
    {
        this.returnChargesSchemaFromPftRate = returnChargesSchemaFromPftRate;
    }

    public String getColName()
    {
        return colName;
    }

    public void setColName(String colName)
    {
        this.colName = colName;
    }
    
    public String getAccountNumber()
    {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
	this.accountNumber = accountNumber;
    }

    public AMFVO getAmfVO()
    {
	return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
	this.amfVO = amfVO;
    }

    public AMF_EXTENDEDVO getAmfExtendedVO()
    {
	return amfExtendedVO;
    }

    public void setAmfExtendedVO(AMF_EXTENDEDVO amfExtendedVO)
    {
	this.amfExtendedVO = amfExtendedVO;
    }

    /**
     * @return the profitTillDueDate
     */
    public BigDecimal getProfitTillDueDate()
    {
	return profitTillDueDate;
    }

    /**
     * @param profitTillDueDate the profitTillDueDate to set
     */
    public void setProfitTillDueDate(BigDecimal profitTillDueDate)
    {
	this.profitTillDueDate = profitTillDueDate;
    }

    /**
     * @return the profitTillDate
     */
    public BigDecimal getProfitTillDate()
    {
	return profitTillDate;
    }

    /**
     * @param profitTillDate the profitTillDate to set
     */
    public void setProfitTillDate(BigDecimal profitTillDate)
    {
	this.profitTillDate = profitTillDate;
    }

    /**
     * @return the curAccName
     */
    public String getCurAccName()
    {
	return curAccName;
    }

    /**
     * @param curAccName the curAccName to set
     */
    public void setCurAccName(String curAccName)
    {
	this.curAccName = curAccName;
    }

    /**
     * @return the curAccAddRef
     */
    public String getCurAccAddRef()
    {
	return curAccAddRef;
    }

    /**
     * @param curAccAddRef the curAccAddRef to set
     */
    public void setCurAccAddRef(String curAccAddRef)
    {
	this.curAccAddRef = curAccAddRef;
    }

    public BigDecimal getCurrentMaturityDays()
    {
	return currentMaturityDays;
    }

    public void setCurrentMaturityDays(BigDecimal currentMaturityDays)
    {
	this.currentMaturityDays = currentMaturityDays;
    }

    public String getRenewAccount()
    {
	return renewAccount;
    }

    public void setRenewAccount(String renewAccount)
    {
	this.renewAccount = renewAccount;
    }

    /**
     * @return the psrCustomer
     */
    public BigDecimal getPsrCustomer()
    {
	return psrCustomer;
    }

    /**
     * @param psrCustomer the psrCustomer to set
     */
    public void setPsrCustomer(BigDecimal psrCustomer)
    {
	this.psrCustomer = psrCustomer;
    }

    /**
     * @return the branchDesc
     */
    public String getBranchDesc()
    {
	return branchDesc;
    }

    /**
     * @param branchDesc the branchDesc to set
     */
    public void setBranchDesc(String branchDesc)
    {
	this.branchDesc = branchDesc;
    }

    /**
     * @return the currencyDesc
     */
    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    /**
     * @param currencyDesc the currencyDesc to set
     */
    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    /**
     * @return the glDesc
     */
    public String getGlDesc()
    {
	return glDesc;
    }

    /**
     * @param glDesc the glDesc to set
     */
    public void setGlDesc(String glDesc)
    {
	this.glDesc = glDesc;
    }

    /**
     * @return the cifName
     */
    public String getCifName()
    {
	return cifName;
    }

    /**
     * @param cifName the cifName to set
     */
    public void setCifName(String cifName)
    {
	this.cifName = cifName;
    }

    /**
     * @return the statusReasonDesc
     */
    public String getStatusReasonDesc()
    {
	return statusReasonDesc;
    }

    /**
     * @param statusReasonDesc the statusReasonDesc to set
     */
    public void setStatusReasonDesc(String statusReasonDesc)
    {
	this.statusReasonDesc = statusReasonDesc;
    }

    public String getEconomicSectorDesc()
    {
	return economicSectorDesc;
    }

    public void setEconomicSectorDesc(String economicSectorDesc)
    {
	this.economicSectorDesc = economicSectorDesc;
    }

    public String getDivisionDesc()
    {
	return divisionDesc;
    }

    public void setDivisionDesc(String divisionDesc)
    {
	this.divisionDesc = divisionDesc;
    }

    public String getDepartmentDesc()
    {
	return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc)
    {
	this.departmentDesc = departmentDesc;
    }

    public String getSubEconomicSectorDesc()
    {
	return subEconomicSectorDesc;
    }

    public void setSubEconomicSectorDesc(String subEconomicSectorDesc)
    {
	this.subEconomicSectorDesc = subEconomicSectorDesc;
    }

    public String getUnitsDesc()
    {
	return unitsDesc;
    }

    public void setUnitsDesc(String unitsDesc)
    {
	this.unitsDesc = unitsDesc;
    }

    public String getOfficerDesc()
    {
	return officerDesc;
    }

    public void setOfficerDesc(String officerDesc)
    {
	this.officerDesc = officerDesc;
    }

    public String getChargesDesc()
    {
	return chargesDesc;
    }

    public void setChargesDesc(String chargesDesc)
    {
	this.chargesDesc = chargesDesc;
    }

    public String getMarketedByDivisionDesc()
    {
	return marketedByDivisionDesc;
    }

    public void setMarketedByDivisionDesc(String marketedByDivisionDesc)
    {
	this.marketedByDivisionDesc = marketedByDivisionDesc;
    }

    public String getMarketedByPositionDesc()
    {
	return marketedByPositionDesc;
    }

    public void setMarketedByPositionDesc(String marketedByPositionDesc)
    {
	this.marketedByPositionDesc = marketedByPositionDesc;
    }

    public String getMarketedByDepartmentDesc()
    {
	return marketedByDepartmentDesc;
    }

    public void setMarketedByDepartmentDesc(String marketedByDepartmentDesc)
    {
	this.marketedByDepartmentDesc = marketedByDepartmentDesc;
    }

    public String getMarketedForDivisionDesc()
    {
	return marketedForDivisionDesc;
    }

    public void setMarketedForDivisionDesc(String marketedForDivisionDesc)
    {
	this.marketedForDivisionDesc = marketedForDivisionDesc;
    }

    public String getMarketedForDepartmentDesc()
    {
	return marketedForDepartmentDesc;
    }

    public void setMarketedForDepartmentDesc(String marketedForDepartmentDesc)
    {
	this.marketedForDepartmentDesc = marketedForDepartmentDesc;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public ACC_NV_CONTROLVO getAccControlVO()
    {
	return accControlVO;
    }

    public void setAccControlVO(ACC_NV_CONTROLVO accControlVO)
    {
	this.accControlVO = accControlVO;
    }

    public RIFATTVO getRifattVO()
    {
	return rifattVO;
    }

    public void setRifattVO(RIFATTVO rifattVO)
    {
	this.rifattVO = rifattVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public CTSCONTROLVO getCtsControl()
    {
	return ctsControl;
    }

    public void setCtsControl(CTSCONTROLVO ctsControl)
    {
	this.ctsControl = ctsControl;
    }

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public PTH_CTRLVO getPthCtrlVO()
    {
	return pthCtrlVO;
    }

    public void setPthCtrlVO(PTH_CTRLVO pthCtrlVO)
    {
	this.pthCtrlVO = pthCtrlVO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public AddressCommonCO getAddressCommonCO()
    {
	return addressCommonCO;
    }

    public void setAddressCommonCO(AddressCommonCO addressCommonCO)
    {
	this.addressCommonCO = addressCommonCO;
    }

    public Boolean getCreateNewAccountFlag()
    {
	return createNewAccountFlag;
    }

    public void setCreateNewAccountFlag(Boolean createNewAccountFlag)
    {
	this.createNewAccountFlag = createNewAccountFlag;
    }

    public ArrayList<BaseException> getWarningMessagesList()
    {
	return warningMessagesList;
    }

    public void setWarningMessagesList(ArrayList<BaseException> warningMessagesList)
    {
	this.warningMessagesList = warningMessagesList;
    }

    public List<CertificateDepositCO> getCertOfDepositList()
    {
	return certOfDepositList;
    }

    public void setCertOfDepositList(List<CertificateDepositCO> certOfDepositList)
    {
	this.certOfDepositList = certOfDepositList;
    }

    public AMF_ADDRESSVO getAddressVO()
    {
	return addressVO;
    }

    public void setAddressVO(AMF_ADDRESSVO addressVO)
    {
	this.addressVO = addressVO;
    }

    public String getSaveTypeAMFextended()
    {
	return saveTypeAMFextended;
    }

    public void setSaveTypeAMFextended(String saveTypeAMFextended)
    {
	this.saveTypeAMFextended = saveTypeAMFextended;
    }

    public S_APPVO getSappVO()
    {
	return sappVO;
    }

    public void setSappVO(S_APPVO sappVO)
    {
	this.sappVO = sappVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementHashmap()
    {
	return elementHashmap;
    }

    public void setElementHashmap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	this.elementHashmap = elementHashmap;
    }

    public List<CtsMailDetCO> getMailDetList()
    {
	return mailDetList;
    }

    public void setMailDetList(List<CtsMailDetCO> mailDetList)
    {
	this.mailDetList = mailDetList;
    }

    public String getTrfCurAccName()
    {
	return trfCurAccName;
    }

    public void setTrfCurAccName(String trfCurAccName)
    {
	this.trfCurAccName = trfCurAccName;
    }

    public String getTrfCurAccAddRef()
    {
	return trfCurAccAddRef;
    }

    public void setTrfCurAccAddRef(String trfCurAccAddRef)
    {
	this.trfCurAccAddRef = trfCurAccAddRef;
    }

    public String getOffCurAccName()
    {
	return offCurAccName;
    }

    public void setOffCurAccName(String offCurAccName)
    {
	this.offCurAccName = offCurAccName;
    }

    public String getOffCurAccAddRef()
    {
	return offCurAccAddRef;
    }

    public void setOffCurAccAddRef(String offCurAccAddRef)
    {
	this.offCurAccAddRef = offCurAccAddRef;
    }

    public String getPftCurAccName()
    {
	return pftCurAccName;
    }

    public void setPftCurAccName(String pftCurAccName)
    {
	this.pftCurAccName = pftCurAccName;
    }

    public String getPftCurAccAddRef()
    {
	return pftCurAccAddRef;
    }

    public void setPftCurAccAddRef(String pftCurAccAddRef)
    {
	this.pftCurAccAddRef = pftCurAccAddRef;
    }

    public String getSaveTypeAddress()
    {
	return saveTypeAddress;
    }

    public void setSaveTypeAddress(String saveTypeAddress)
    {
	this.saveTypeAddress = saveTypeAddress;
    }

    public String getParentRef()
    {
	return parentRef;
    }

    public void setParentRef(String parentRef)
    {
	this.parentRef = parentRef;
    }

    public GEN_LEDGERVO getGenLedGer()
    {
	return genLedGer;
    }

    public void setGenLedGer(GEN_LEDGERVO genLedGer)
    {
	this.genLedGer = genLedGer;
    }

    public boolean isApproveFirstTime()
    {
	return approveFirstTime;
    }

    public void setApproveFirstTime(boolean approveFirstTime)
    {
	this.approveFirstTime = approveFirstTime;
    }

    public boolean isHeaderScreenReadOnly()
    {
	return headerScreenReadOnly;
    }

    public void setHeaderScreenReadOnly(boolean headerScreenReadOnly)
    {
	this.headerScreenReadOnly = headerScreenReadOnly;
    }

    public boolean isMainDetailsTabReadOnly()
    {
	return mainDetailsTabReadOnly;
    }

    public void setMainDetailsTabReadOnly(boolean mainDetailsTabReadOnly)
    {
	this.mainDetailsTabReadOnly = mainDetailsTabReadOnly;
    }

    public boolean isInstructionsTabReadOnly()
    {
	return instructionsTabReadOnly;
    }

    public void setInstructionsTabReadOnly(boolean instructionsTabReadOnly)
    {
	this.instructionsTabReadOnly = instructionsTabReadOnly;
    }

    public boolean isPtDetailsTabReadOnly()
    {
	return ptDetailsTabReadOnly;
    }

    public void setPtDetailsTabReadOnly(boolean ptDetailsTabReadOnly)
    {
	this.ptDetailsTabReadOnly = ptDetailsTabReadOnly;
    }

    public boolean isMailingDetailsTabReadOnly()
    {
	return mailingDetailsTabReadOnly;
    }

    public void setMailingDetailsTabReadOnly(boolean mailingDetailsTabReadOnly)
    {
	this.mailingDetailsTabReadOnly = mailingDetailsTabReadOnly;
    }

    public boolean isMarketDetailsTabReadOnly()
    {
	return marketDetailsTabReadOnly;
    }

    public void setMarketDetailsTabReadOnly(boolean marketDetailsTabReadOnly)
    {
	this.marketDetailsTabReadOnly = marketDetailsTabReadOnly;
    }

    public boolean isCustomFieldsTabReadOnly()
    {
	return customFieldsTabReadOnly;
    }

    public void setCustomFieldsTabReadOnly(boolean customFieldsTabReadOnly)
    {
	this.customFieldsTabReadOnly = customFieldsTabReadOnly;
    }

    public boolean isAdditionalDetailsTabReadOnly()
    {
	return additionalDetailsTabReadOnly;
    }

    public void setAdditionalDetailsTabReadOnly(boolean additionalDetailsTabReadOnly)
    {
	this.additionalDetailsTabReadOnly = additionalDetailsTabReadOnly;
    }

    public boolean isLimitSchemaScreenReadOnly()
    {
	return limitSchemaScreenReadOnly;
    }

    public void setLimitSchemaScreenReadOnly(boolean limitSchemaScreenReadOnly)
    {
	this.limitSchemaScreenReadOnly = limitSchemaScreenReadOnly;
    }

    public boolean isCifProductScreenReadOnly()
    {
	return cifProductScreenReadOnly;
    }

    public void setCifProductScreenReadOnly(boolean cifProductScreenReadOnly)
    {
	this.cifProductScreenReadOnly = cifProductScreenReadOnly;
    }

    public boolean isAccountDrawDownScreenReadOnly()
    {
	return accountDrawDownScreenReadOnly;
    }

    public void setAccountDrawDownScreenReadOnly(boolean accountDrawDownScreenReadOnly)
    {
	this.accountDrawDownScreenReadOnly = accountDrawDownScreenReadOnly;
    }

    public boolean isAccountAddressScreenReadOnly()
    {
	return accountAddressScreenReadOnly;
    }

    public void setAccountAddressScreenReadOnly(boolean accountAddressScreenReadOnly)
    {
	this.accountAddressScreenReadOnly = accountAddressScreenReadOnly;
    }

    public boolean isCertificateOfDepositScreenReadOnly()
    {
	return certificateOfDepositScreenReadOnly;
    }

    public void setCertificateOfDepositScreenReadOnly(boolean certificateOfDepositScreenReadOnly)
    {
	this.certificateOfDepositScreenReadOnly = certificateOfDepositScreenReadOnly;
    }

    public boolean isSoMailDetailsScreenReadOnly()
    {
	return soMailDetailsScreenReadOnly;
    }

    public void setSoMailDetailsScreenReadOnly(boolean soMailDetailsScreenReadOnly)
    {
	this.soMailDetailsScreenReadOnly = soMailDetailsScreenReadOnly;
    }

    public BigDecimal getLovTypeId()
    {
	return lovTypeId;
    }

    public void setLovTypeId(BigDecimal lovTypeId)
    {
	this.lovTypeId = lovTypeId;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getBsContra()
    {
	return bsContra;
    }

    public void setBsContra(String bsContra)
    {
	this.bsContra = bsContra;
    }

    /**
     * @return the additionalFieldsByTypeCOList
     */
    public List<AdditionalFieldsByTypeCO> getAdditionalFieldsByTypeCOList()
    {
	return additionalFieldsByTypeCOList;
    }

    /**
     * @param additionalFieldsByTypeCOList the additionalFieldsByTypeCOList to
     *            set
     */
    public void setAdditionalFieldsByTypeCOList(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList)
    {
	this.additionalFieldsByTypeCOList = additionalFieldsByTypeCOList;
    }

    /**
     * @return the additionalFieldsURL
     */
    public String getAdditionalFieldsURL()
    {
	return additionalFieldsURL;
    }

    /**
     * @param additionalFieldsURL the additionalFieldsURL to set
     */
    public void setAdditionalFieldsURL(String additionalFieldsURL)
    {
	this.additionalFieldsURL = additionalFieldsURL;
    }

    public String getVipAlert()
    {
	return vipAlert;
    }

    public void setVipAlert(String vipAlert)
    {
	this.vipAlert = vipAlert;
    }

    /**
     * @return the noOfCifProducts
     */
    public Integer getNoOfCifProducts()
    {
	return noOfCifProducts;
    }

    /**
     * @param noOfCifProducts the noOfCifProducts to set
     */
    public void setNoOfCifProducts(Integer noOfCifProducts)
    {
	this.noOfCifProducts = noOfCifProducts;
    }

    /**
     * @return the limitSchemaList
     */
    public List<LimitSchemaCO> getLimitSchemaList()
    {
	return limitSchemaList;
    }

    /**
     * @param limitSchemaList the limitSchemaList to set
     */
    public void setLimitSchemaList(List<LimitSchemaCO> limitSchemaList)
    {
	this.limitSchemaList = limitSchemaList;
    }

    /**
     * @return the issueChqbkState
     */
    public String getIssueChqbkState()
    {
	return issueChqbkState;
    }

    /**
     * @param issueChqbkState the issueChqbkState to set
     */
    public void setIssueChqbkState(String issueChqbkState)
    {
	this.issueChqbkState = issueChqbkState;
    }

    /**
     * @return the issueCardState
     */
    public String getIssueCardState()
    {
	return issueCardState;
    }

    /**
     * @param issueCardState the issueCardState to set
     */
    public void setIssueCardState(String issueCardState)
    {
	this.issueCardState = issueCardState;
    }

    /**
     * @return the issuePassBookState
     */
    public String getIssuePassBookState()
    {
	return issuePassBookState;
    }

    /**
     * @param issuePassBookState the issuePassBookState to set
     */
    public void setIssuePassBookState(String issuePassBookState)
    {
	this.issuePassBookState = issuePassBookState;
    }

    public boolean isAllScreenReadOnly()
    {
	return allScreenReadOnly;
    }

    public void setAllScreenReadOnly(boolean allScreenReadOnly)
    {
	this.allScreenReadOnly = allScreenReadOnly;
    }

    public Boolean getEnforceSignLimit()
    {
	return enforceSignLimit;
    }

    public void setEnforceSignLimit(Boolean enforceSignLimit)
    {
	this.enforceSignLimit = enforceSignLimit;
    }

    /**
     * @return the callFromPopup
     */
    public boolean getCallFromPopup()
    {
	return callFromPopup;
    }

    /**
     * @param callFromPopup the callFromPopup to set
     */
    public void setCallFromPopup(boolean callFromPopup)
    {
	this.callFromPopup = callFromPopup;
    }

    public int getProceed()
    {
	return proceed;
    }

    public void setProceed(int proceed)
    {
	this.proceed = proceed;
    }
/////NABIL FEGHALI - IIAB120195 - IMAL - MEMO ALERT - TRX
//    public String getShowMemoOnLoad()
//    {
//	return showMemoOnLoad;
//    }
//
//    public void setShowMemoOnLoad(String showMemoOnLoad)
//    {
//	this.showMemoOnLoad = showMemoOnLoad;
//    }

    public String getBlackListWarningMsg()
    {
	return blackListWarningMsg;
    }

    public void setBlackListWarningMsg(String blackListWarningMsg)
    {
	this.blackListWarningMsg = blackListWarningMsg;
    }

    public String getOfTheTotalDepositAmount()
    {
	return ofTheTotalDepositAmount;
    }

    public void setOfTheTotalDepositAmount(String ofTheTotalDepositAmount)
    {
	this.ofTheTotalDepositAmount = ofTheTotalDepositAmount;
    }

    public String getPercentageLabel()
    {
	return percentageLabel;
    }

    public void setPercentageLabel(String percentageLabel)
    {
	this.percentageLabel = percentageLabel;
    }

    public String getUnclaimedTrans()
    {
	return unclaimedTrans;
    }

    public void setUnclaimedTrans(String unclaimedTrans)
    {
	this.unclaimedTrans = unclaimedTrans;
    }

    public String getUnclaimedWarningMsg()
    {
	return unclaimedWarningMsg;
    }

    public void setUnclaimedWarningMsg(String unclaimedWarningMsg)
    {
	this.unclaimedWarningMsg = unclaimedWarningMsg;
    }

    public String getCifblacklistedTrans()
    {
	return cifblacklistedTrans;
    }

    public void setCifblacklistedTrans(String cifblacklistedTrans)
    {
	this.cifblacklistedTrans = cifblacklistedTrans;
    }

    /**
     * @return the updatePassbookFlag
     */
    public boolean isUpdatePassbookFlag()
    {
	return updatePassbookFlag;
    }

    /**
     * @param updatePassbookFlag the updatePassbookFlag to set
     */
    public void setUpdatePassbookFlag(boolean updatePassbookFlag)
    {
	this.updatePassbookFlag = updatePassbookFlag;
    }

    public Boolean getAutoSweepFlag()
    {
	return autoSweepFlag;
    }

    public void setAutoSweepFlag(Boolean autoSweepFlag)
    {
	this.autoSweepFlag = autoSweepFlag;
    }

    public Boolean getPointAccrualToMaturity()
    {
	return pointAccrualToMaturity;
    }

    public void setPointAccrualToMaturity(Boolean pointAccrualToMaturity)
    {
	this.pointAccrualToMaturity = pointAccrualToMaturity;
    }

    public Boolean getTaxApplied()
    {
	return taxApplied;
    }

    public void setTaxApplied(Boolean taxApplied)
    {
	this.taxApplied = taxApplied;
    }

    public Boolean getApplyPcsCharges()
    {
	return applyPcsCharges;
    }

    public void setApplyPcsCharges(Boolean applyPcsCharges)
    {
	this.applyPcsCharges = applyPcsCharges;
    }

    public Boolean getZakatApplied()
    {
	return zakatApplied;
    }

    public void setZakatApplied(Boolean zakatApplied)
    {
	this.zakatApplied = zakatApplied;
    }

    public Boolean getPremiumDeductionPcs()
    {
	return premiumDeductionPcs;
    }

    public void setPremiumDeductionPcs(Boolean premiumDeductionPcs)
    {
	this.premiumDeductionPcs = premiumDeductionPcs;
    }

    public Boolean getAdvancedProfitFlag()
    {
	return advancedProfitFlag;
    }

    public void setAdvancedProfitFlag(Boolean advancedProfitFlag)
    {
	this.advancedProfitFlag = advancedProfitFlag;
    }

    public Boolean getResetRateMaturity()
    {
	return resetRateMaturity;
    }

    public void setResetRateMaturity(Boolean resetRateMaturity)
    {
	this.resetRateMaturity = resetRateMaturity;
    }

    public Boolean getAppTaxCapRev()
    {
	return appTaxCapRev;
    }

    public void setAppTaxCapRev(Boolean appTaxCapRev)
    {
	this.appTaxCapRev = appTaxCapRev;
    }

    public Boolean getSpecialRate()
    {
	return specialRate;
    }

    public void setSpecialRate(Boolean specialRate)
    {
	this.specialRate = specialRate;
    }

    public Boolean getCreateNewAccountTransferFlag()
    {
	return createNewAccountTransferFlag;
    }

    public void setCreateNewAccountTransferFlag(Boolean createNewAccountTransferFlag)
    {
	this.createNewAccountTransferFlag = createNewAccountTransferFlag;
    }

    public String getShowAlertButton()
    {
	return showAlertButton;
    }

    public void setShowAlertButton(String showAlertButton)
    {
	this.showAlertButton = showAlertButton;
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
	this.alertsParamCO = alertsParamCO;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    public String getIsRateAlert()
    {
	return isRateAlert;
    }

    public void setIsRateAlert(String isRateAlert)
    {
	this.isRateAlert = isRateAlert;
    }

    public BigDecimal getInitialMinimumOpeningBalance()
    {
	return initialMinimumOpeningBalance;
    }

    public void setInitialMinimumOpeningBalance(BigDecimal initialMinimumOpeningBalance)
    {
	this.initialMinimumOpeningBalance = initialMinimumOpeningBalance;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public String getShowAlertModifyButton()
    {
	return showAlertModifyButton;
    }

    public void setShowAlertModifyButton(String showAlertModifyButton)
    {
	this.showAlertModifyButton = showAlertModifyButton;
    }

    public String getShowAlertScanButton()
    {
	return showAlertScanButton;
    }

    public void setShowAlertScanButton(String showAlertScanButton)
    {
	this.showAlertScanButton = showAlertScanButton;
    }

    public Boolean getAutoApproveFlag()
    {
	return autoApproveFlag;
    }

    public void setAutoApproveFlag(Boolean autoApproveFlag)
    {
	this.autoApproveFlag = autoApproveFlag;
    }

    public boolean isMoreAddressReadOnly()
    {
	return moreAddressReadOnly;
    }

    public void setMoreAddressReadOnly(boolean moreAddressReadOnly)
    {
	this.moreAddressReadOnly = moreAddressReadOnly;
    }

    public BigDecimal getMinimumBalance()
    {
	return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance)
    {
	this.minimumBalance = minimumBalance;
    }

    public boolean isGlobalConfirmationFlag()
    {
	return globalConfirmationFlag;
    }

    public void setGlobalConfirmationFlag(boolean globalConfirmationFlag)
    {
	this.globalConfirmationFlag = globalConfirmationFlag;
    }

    public boolean isAutoCreate()
    {
	return autoCreate;
    }

    public void setAutoCreate(boolean autoCreate)
    {
	this.autoCreate = autoCreate;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    /**
     * @return the smartCOList
     */
    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    /**
     * @param smartCOList the smartCOList to set
     */
    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public boolean isInvestmentAccount()
    {
	return investmentAccount;
    }

    public void setInvestmentAccount(boolean investmentAccount)
    {
	this.investmentAccount = investmentAccount;
    }

    public MosBlackListCO getMosBlackListCO()
    {
	return mosBlackListCO;
    }

    public void setMosBlackListCO(MosBlackListCO mosBlackListCO)
    {
	this.mosBlackListCO = mosBlackListCO;
    }

    /**
     * @return the cifProducts
     */
    public CifProductsCO getCifProducts()
    {
	return cifProducts;
    }

    /**
     * @param cifProducts the cifProducts to set
     */
    public void setCifProducts(CifProductsCO cifProducts)
    {
	this.cifProducts = cifProducts;
    }

    public SignatureCO getSignatureCO()
    {
	return signatureCO;
    }

    public void setSignatureCO(SignatureCO signatureCO)
    {
	this.signatureCO = signatureCO;
    }

    public String getTrxtTypeDesc()
    {
	return trxtTypeDesc;
    }

    public void setTrxtTypeDesc(String trxtTypeDesc)
    {
	this.trxtTypeDesc = trxtTypeDesc;
    }

    public ArrayList<String> getWarningList()
    {
	return warningList;
    }

    public void setWarningList(ArrayList<String> warningList)
    {
	this.warningList = warningList;
    }

    public List<ReportResponseCO> getAccountConfirmationReportList()
    {
	return accountConfirmationReportList;
    }

    public void setAccountConfirmationReportList(List<ReportResponseCO> accountConfirmationReportList)
    {
	this.accountConfirmationReportList = accountConfirmationReportList;
    }

    public ReportResponseCO getAccountAutoSweepConfirmationReport()
    {
	return accountAutoSweepConfirmationReport;
    }

    public void setAccountAutoSweepConfirmationReport(ReportResponseCO accountAutoSweepConfirmationReport)
    {
	this.accountAutoSweepConfirmationReport = accountAutoSweepConfirmationReport;
    }

    public List<ReportResponseCO> getCardReportResponseCOList()
    {
	return cardReportResponseCOList;
    }

    public void setCardReportResponseCOList(List<ReportResponseCO> cardReportResponseCOList)
    {
	this.cardReportResponseCOList = cardReportResponseCOList;
    }

    public String getAccPrintConfirmation()
    {
	return accPrintConfirmation;
    }

    public void setAccPrintConfirmation(String accPrintConfirmation)
    {
	this.accPrintConfirmation = accPrintConfirmation;
    }

    public Boolean getIsPrintCertificate()
    {
	return isPrintCertificate;
    }

    public void setIsPrintCertificate(Boolean isPrintCertificate)
    {
	this.isPrintCertificate = isPrintCertificate;
    }

    /**
     * @return the holdTrxTypeDesc
     */
    public String getHoldTrxTypeDesc()
    {
	return holdTrxTypeDesc;
    }

    /**
     * @param holdTrxTypeDesc the holdTrxTypeDesc to set
     */
    public void setHoldTrxTypeDesc(String holdTrxTypeDesc)
    {
	this.holdTrxTypeDesc = holdTrxTypeDesc;
    }

    // public List<SelectCO> getPftPostToDropDown() {
    // return pftPostToDropDown;
    // }
    // public void setPftPostToDropDown(List<SelectCO> pftPostToDropDown) {
    // this.pftPostToDropDown = pftPostToDropDown;
    // }
    public String getFixAccReportType()
    {
	return fixAccReportType;
    }

    public void setFixAccReportType(String fixAccReportType)
    {
	this.fixAccReportType = fixAccReportType;
    }

    public CTSCARDS_ACCVO getCtsCardsAccVO()
    {
	return ctsCardsAccVO;
    }

    public void setCtsCardsAccVO(CTSCARDS_ACCVO ctsCardsAccVO)
    {
	this.ctsCardsAccVO = ctsCardsAccVO;
    }

    public CTSCARDS_MGTVO getCtsCardsMgtVO()
    {
	return ctsCardsMgtVO;
    }

    public void setCtsCardsMgtVO(CTSCARDS_MGTVO ctsCardsMgtVO)
    {
	this.ctsCardsMgtVO = ctsCardsMgtVO;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
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

    public boolean isAutoCreateApprove()
    {
	return autoCreateApprove;
    }

    public void setAutoCreateApprove(boolean autoCreateApprove)
    {
	this.autoCreateApprove = autoCreateApprove;
    }

    public boolean getCertificateOfDepositGridEditable()
    {
	return certificateOfDepositGridEditable;
    }

    public void setCertificateOfDepositGridEditable(boolean certificateOfDepositGridEditable)
    {
	this.certificateOfDepositGridEditable = certificateOfDepositGridEditable;
    }

    public Integer getAccountsHavingCifDormant()
    {
	return accountsHavingCifDormant;
    }

    public void setAccountsHavingCifDormant(Integer accountsHavingCifDormant)
    {
	this.accountsHavingCifDormant = accountsHavingCifDormant;
    }

    public List<ReportResponseCO> getAdditionalAdvicesReportList()
    {
	return additionalAdvicesReportList;
    }

    public void setAdditionalAdvicesReportList(List<ReportResponseCO> additionalAdvicesReportList)
    {
	this.additionalAdvicesReportList = additionalAdvicesReportList;
    }
////NABIL FEGHALI - IIAB120195 - IMAL - MEMO ALERT - TRX
//    public String getMemoOptRef()
//    {
//	return memoOptRef;
//    }
//
//    public void setMemoOptRef(String memoOptRef)
//    {
//	this.memoOptRef = memoOptRef;
//    }

    public String getWarningMessage()
    {
	return warningMessage;
    }

    public void setWarningMessage(String warningMessage)
    {
	this.warningMessage = warningMessage;
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

    public AmfDrawDownsCO getAmfDrawDownsCO()
    {
        return amfDrawDownsCO;
    }

    public void setAmfDrawDownsCO(AmfDrawDownsCO amfDrawDownsCO)
    {
        this.amfDrawDownsCO = amfDrawDownsCO;
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

    public AccountsDefaultCO getAccountsDefaultCO()
    {
        return accountsDefaultCO;
    }

    public void setAccountsDefaultCO(AccountsDefaultCO accountsDefaultCO)
    {
        this.accountsDefaultCO = accountsDefaultCO;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public String getDrCrIdx()
    {
        return drCrIdx;
    }

    public void setDrCrIdx(String drCrIdx)
    {
        this.drCrIdx = drCrIdx;
    }

    public BigDecimal getLinkReference()
    {
        return linkReference;
    }

    public void setLinkReference(BigDecimal linkReference)
    {
        this.linkReference = linkReference;
    }

    public String getLimitType()
    {
        return limitType;
    }

    public void setLimitType(String limitType)
    {
        this.limitType = limitType;
    }

    public String getEditType()
    {
        return editType;
    }

    public void setEditType(String editType)
    {
        this.editType = editType;
    }

    public BigDecimal getDetInd()
    {
        return detInd;
    }

    public void setDetInd(BigDecimal detInd)
    {
        this.detInd = detInd;
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

    public BigDecimal getCvAmount()
    {
        return cvAmount;
    }

    public void setCvAmount(BigDecimal cvAmount)
    {
        this.cvAmount = cvAmount;
    }

    public String getReceivedFrom()
    {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom)
    {
        this.receivedFrom = receivedFrom;
    }

    public String getPtIndex()
    {
        return ptIndex;
    }

    public void setPtIndex(String ptIndex)
    {
        this.ptIndex = ptIndex;
    }

    public Date getApplicableDate()
    {
        return applicableDate;
    }

    public void setApplicableDate(Date applicableDate)
    {
        this.applicableDate = applicableDate;
    }

    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public String getCallingMode()
    {
        return callingMode;
    }

    public void setCallingMode(String callingMode)
    {
        this.callingMode = callingMode;
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

    public List<SelectCO> getPftPostToDropDwn()
    {
        return pftPostToDropDwn;
    }

    public void setPftPostToDropDwn(List<SelectCO> pftPostToDropDwn)
    {
        this.pftPostToDropDwn = pftPostToDropDwn;
    }

    public String getColumnSelector()
    {
        return columnSelector;
    }

    public void setColumnSelector(String columnSelector)
    {
        this.columnSelector = columnSelector;
    }

    public String getBusinessCrud()
    {
        return businessCrud;
    }

    public void setBusinessCrud(String businessCrud)
    {
        this.businessCrud = businessCrud;
    }

    public Boolean getAfterConfirmMsgFlag()
    {
        return afterConfirmMsgFlag;
    }

    public void setAfterConfirmMsgFlag(Boolean afterConfirmMsgFlag)
    {
        this.afterConfirmMsgFlag = afterConfirmMsgFlag;
    }

    public String getMaturityFlag()
    {
        return maturityFlag;
    }

    public void setMaturityFlag(String maturityFlag)
    {
        this.maturityFlag = maturityFlag;
    }

    public boolean isResetGLDetails()
    {
        return resetGLDetails;
    }

    public void setResetGLDetails(boolean resetGLDetails)
    {
        this.resetGLDetails = resetGLDetails;
    }

    public String getGlCategory()
    {
        return glCategory;
    }

    public void setGlCategory(String glCategory)
    {
        this.glCategory = glCategory;
    }

    public String getValidateAllowedCurrency()
    {
        return validateAllowedCurrency;
    }

    public void setValidateAllowedCurrency(String validateAllowedCurrency)
    {
        this.validateAllowedCurrency = validateAllowedCurrency;
    }

    public String getEditMode()
    {
        return editMode;
    }

    public void setEditMode(String editMode)
    {
        this.editMode = editMode;
    }

    public String getAddressPageRef()
    {
        return addressPageRef;
    }

    public void setAddressPageRef(String addressPageRef)
    {
        this.addressPageRef = addressPageRef;
    }

    public Boolean getFromMainDetailsTansferToDepositFlag()
    {
        return fromMainDetailsTansferToDepositFlag;
    }

    public void setFromMainDetailsTansferToDepositFlag(Boolean fromMainDetailsTansferToDepositFlag)
    {
        this.fromMainDetailsTansferToDepositFlag = fromMainDetailsTansferToDepositFlag;
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

    public Boolean getFromFMAOpeningDepositDetailsFlag()
    {
        return fromFMAOpeningDepositDetailsFlag;
    }

    public void setFromFMAOpeningDepositDetailsFlag(Boolean fromFMAOpeningDepositDetailsFlag)
    {
        this.fromFMAOpeningDepositDetailsFlag = fromFMAOpeningDepositDetailsFlag;
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

    public String getOldAddRef()
    {
        return oldAddRef;
    }

    public void setOldAddRef(String oldAddRef)
    {
        this.oldAddRef = oldAddRef;
    }

    public String getBaseCurrencyName()
    {
        return baseCurrencyName;
    }

    public void setBaseCurrencyName(String baseCurrencyName)
    {
        this.baseCurrencyName = baseCurrencyName;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getPreferredLanguage()
    {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
        this.preferredLanguage = preferredLanguage;
    }

    public boolean getAddRefChanged()
    {
        return addRefChanged;
    }

    public void setAddRefChanged(boolean addRefChanged)
    {
        this.addRefChanged = addRefChanged;
    }

    public String getAddRefGlobalMask()
    {
        return addRefGlobalMask;
    }

    public void setAddRefGlobalMask(String addRefGlobalMask)
    {
        this.addRefGlobalMask = addRefGlobalMask;
    }

    public String getPftDrCrIdx()
    {
        return pftDrCrIdx;
    }

    public void setPftDrCrIdx(String pftDrCrIdx)
    {
        this.pftDrCrIdx = pftDrCrIdx;
    }

    public Date getDateUpdated()
    {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated)
    {
        this.dateUpdated = dateUpdated;
    }

    public String getNewDateUpdated()
    {
        return newDateUpdated;
    }

    public void setNewDateUpdated(String newDateUpdated)
    {
        this.newDateUpdated = newDateUpdated;
    }

    public String getNullDateClosed()
    {
        return nullDateClosed;
    }

    public void setNullDateClosed(String nullDateClosed)
    {
        this.nullDateClosed = nullDateClosed;
    }

    public String getNullEffClosedDate()
    {
        return nullEffClosedDate;
    }

    public void setNullEffClosedDate(String nullEffClosedDate)
    {
        this.nullEffClosedDate = nullEffClosedDate;
    }

    public Date getOldDateValue()
    {
        return oldDateValue;
    }

    public void setOldDateValue(Date oldDateValue)
    {
        this.oldDateValue = oldDateValue;
    }

    public boolean isMoreAddressWindowOpened()
    {
        return moreAddressWindowOpened;
    }

    public void setMoreAddressWindowOpened(boolean moreAddressWindowOpened)
    {
        this.moreAddressWindowOpened = moreAddressWindowOpened;
    }

    
    public String getExemptFullChargesWaiver()
    {
        return exemptFullChargesWaiver;
    }

    public void setExemptFullChargesWaiver(String exemptFullChargesWaiver)
    {
        this.exemptFullChargesWaiver = exemptFullChargesWaiver;
    }

    public List<ChargesWaiverCO> getChargesWaiverList()
    {
        return chargesWaiverList;
    }

    public void setChargesWaiverList(List<ChargesWaiverCO> chargesWaiverList)
    {
        this.chargesWaiverList = chargesWaiverList;
    }

    public String getExceptionalCrDrIdx()
    {
        return exceptionalCrDrIdx;
    }

    public void setExceptionalCrDrIdx(String exceptionalCrDrIdx)
    {
        this.exceptionalCrDrIdx = exceptionalCrDrIdx;
    }

    public PFT_EXCEPTIONAL_RATEVO getPftExceptionalRateVO()
    {
        return PftExceptionalRateVO;
    }

    public void setPftExceptionalRateVO(PFT_EXCEPTIONAL_RATEVO pftExceptionalRateVO)
    {
        PftExceptionalRateVO = pftExceptionalRateVO;
    }

    public String getFromToAmtIndicator()
    {
        return fromToAmtIndicator;
    }

    public void setFromToAmtIndicator(String fromToAmtIndicator)
    {
        this.fromToAmtIndicator = fromToAmtIndicator;
    }
    
    public List<PftExceptionalRateCO> getPftExceptionalDebitRateCOs()
    {
        return pftExceptionalDebitRateCOs;
    }

    public void setPftExceptionalDebitRateCOs(List<PftExceptionalRateCO> pftExceptionalDebitRateCOs)
    {
        this.pftExceptionalDebitRateCOs = pftExceptionalDebitRateCOs;
    }

    public List<PftExceptionalRateCO> getPftExceptionalCrebitRateCOs()
    {
        return pftExceptionalCrebitRateCOs;
    }

    public void setPftExceptionalCrebitRateCOs(List<PftExceptionalRateCO> pftExceptionalCrebitRateCOs)
    {
        this.pftExceptionalCrebitRateCOs = pftExceptionalCrebitRateCOs;
    }

    public String getExceptionalRatesChanged()
    {
        return exceptionalRatesChanged;
    }

    public void setExceptionalRatesChanged(String exceptionalRatesChanged)
    {
        this.exceptionalRatesChanged = exceptionalRatesChanged;
    }

    public String getShowExceptionalRatesBtns()
    {
        return showExceptionalRatesBtns;
    }

    public void setShowExceptionalRatesBtns(String showExceptionalRatesBtns)
    {
        this.showExceptionalRatesBtns = showExceptionalRatesBtns;
    }
    
    public String getCheckType()
    {
        return checkType;
    }

    public void setCheckType(String checkType)
    {
        this.checkType = checkType;
    }
    

    public String getSubStatusDesc()
    {
        return subStatusDesc;
    }

    public void setSubStatusDesc(String subStatusDesc)
    {
        this.subStatusDesc = subStatusDesc;
    }
    

    public String getIsAsaanAcc()
    {
        return isAsaanAcc;
    }

    public void setIsAsaanAcc(String isAsaanAcc)
    {
        this.isAsaanAcc = isAsaanAcc;
    }

    public String getReasonCodeDesc()
    {
        return reasonCodeDesc;
    }

    public void setReasonCodeDesc(String reasonCodeDesc)
    {
        this.reasonCodeDesc = reasonCodeDesc;
    }

    public String getExemptedFromFilerFlag()
    {
        return exemptedFromFilerFlag;
    }

    public void setExemptedFromFilerFlag(String exemptedFromFilerFlag)
    {
        this.exemptedFromFilerFlag = exemptedFromFilerFlag;
    }

    
    public String getDrcrIdx()
    {
        return drcrIdx;
    }

    public void setDrcrIdx(String drcrIdx)
    {
        this.drcrIdx = drcrIdx;
    }


    public String getClubbingOverdraftAcc()
    {
        return clubbingOverdraftAcc;
    }

    public void setClubbingOverdraftAcc(String clubbingOverdraftAcc)
    {
        this.clubbingOverdraftAcc = clubbingOverdraftAcc;
    }

    public BigDecimal getOverdraftType()
    {
        return overdraftType;
    }

    public void setOverdraftType(BigDecimal overdraftType)
    {
        this.overdraftType = overdraftType;
    }

    public BigDecimal getNullDec()
    {
        return nullDec;
    }

    public void setNullDec(BigDecimal nullDec)
    {
        this.nullDec = nullDec;
    }

    public Date getNullDate()
    {
        return nullDate;
    }

    public void setNullDate(Date nullDate)
    {
        this.nullDate = nullDate;
    }

    public String getIntegAction()
    {
        return integAction;
    }

    public void setIntegAction(String integAction)
    {
        this.integAction = integAction;
    }

    public String getNullStr()
    {
        return nullStr;
    }

    public void setDealCustomNo(String dealCustomNo)
    {
        this.dealCustomNo = dealCustomNo;
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

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public BigDecimal getBlackListReason()
    {
        return blackListReason;
    }

    public void setBlackListReason(BigDecimal blackListReason)
    {
        this.blackListReason = blackListReason;
    }

    public String getBlackListReasonDesc()
    {
        return blackListReasonDesc;
    }

    public void setBlackListReasonDesc(String blackListReasonDesc)
    {
        this.blackListReasonDesc = blackListReasonDesc;
    }

    public String getMethodName()
    {
        return methodName;
    }

    public void setMethodName(String methodName)
    {
        this.methodName = methodName;
    }

    public BigDecimal getBlackListReturnValue()
    {
        return blackListReturnValue;
    }

    public void setBlackListReturnValue(BigDecimal blackListReturnValue)
    {
        this.blackListReturnValue = blackListReturnValue;
    }

    public Integer getMsgCode()
    {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
        this.msgCode = msgCode;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public BigDecimal getOpeningDepCif()
    {
        return openingDepCif;
    }

    public void setOpeningDepCif(BigDecimal openingDepCif)
    {
        this.openingDepCif = openingDepCif;
    }

    public String getMaskNameYN()
    {
        return maskNameYN;
    }

    public void setMaskNameYN(String maskNameYN)
    {
        this.maskNameYN = maskNameYN;
    }

    public String getCifDesc()
    {
        return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
        this.cifDesc = cifDesc;
    }

    public String getRefundCurAccName()
    {
        return refundCurAccName;
    }

    public void setRefundCurAccName(String refundCurAccName)
    {
        this.refundCurAccName = refundCurAccName;
    }

    public String getRefundCurAccAddRef()
    {
        return refundCurAccAddRef;
    }

    public void setRefundCurAccAddRef(String refundCurAccAddRef)
    {
        this.refundCurAccAddRef = refundCurAccAddRef;
    }

    
    public boolean isUpdateBillsFlag()
    {
        return updateBillsFlag;
    }

    public void setUpdateBillsFlag(boolean updateBillsFlag)
    {
        this.updateBillsFlag = updateBillsFlag;
    }
    
    public String getIssueBillsState()
    {
        return issueBillsState;
    }

    public void setIssueBillsState(String issueBillsState)
    {
        this.issueBillsState = issueBillsState;
    }

    public final String getAllowedGl()
    {
        return allowedGl;
    }

    public final void setAllowedGl(String allowedGl)
    {
        this.allowedGl = allowedGl;
    }

    public final String getAllowedBill()
    {
        return allowedBill;
    }

    public final void setAllowedBill(String allowedBill)
    {
        this.allowedBill = allowedBill;
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

    public BigDecimal getAccCySettlement()
    {
        return accCySettlement;
    }

    public void setAccCySettlement(BigDecimal accCySettlement)
    {
        this.accCySettlement = accCySettlement;
    }

    public String getAccAddRefSettlement()
    {
        return accAddRefSettlement;
    }

    public void setAccAddRefSettlement(String accAddRefSettlement)
    {
        this.accAddRefSettlement = accAddRefSettlement;
    }

    public String getAccDescSettlement()
    {
        return accDescSettlement;
    }

    public void setAccDescSettlement(String accDescSettlement)
    {
        this.accDescSettlement = accDescSettlement;
    }

    public BigDecimal getAccGlSettlement()
    {
        return accGlSettlement;
    }

    public void setAccGlSettlement(BigDecimal accGlSettlement)
    {
        this.accGlSettlement = accGlSettlement;
    }

    public BigDecimal getAccSlSettlement()
    {
        return accSlSettlement;
    }

    public void setAccSlSettlement(BigDecimal accSlSettlement)
    {
        this.accSlSettlement = accSlSettlement;
    }

    public BigDecimal getAccCifSettlement()
    {
        return accCifSettlement;
    }

    public void setAccCifSettlement(BigDecimal accCifSettlement)
    {
        this.accCifSettlement = accCifSettlement;
    }
      
    public void setNullStr(String nullStr)
    {
        this.nullStr = nullStr;
    }


    public String getOpeningAccSignature()
    {
        return openingAccSignature;
    }

    public void setOpeningAccSignature(String openingAccSignature)
    {
        this.openingAccSignature = openingAccSignature;
    }

    public String getDisplayPhoto()
    {
        return displayPhoto;
    }

    public void setDisplayPhoto(String displayPhoto)
    {
        this.displayPhoto = displayPhoto;
    }

    public BigDecimal getOpeningAccSignatureAmt()
    {
        return openingAccSignatureAmt;
    }

    public void setOpeningAccSignatureAmt(BigDecimal openingAccSignatureAmt)
    {
        this.openingAccSignatureAmt = openingAccSignatureAmt;
    }
    
    public String getBicCode()
    {
        return bicCode;
    }

    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    public String getRegisterNumber()
    {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber)
    {
        this.registerNumber = registerNumber;
    }

    public String getRegisteredMobile()
    {
        return registeredMobile;
    }

    public void setRegisteredMobile(String registeredMobile)
    {
        this.registeredMobile = registeredMobile;
    }

    public String getIDNo()
    {
        return IDNo;
    }

    public void setIDNo(String iDNo)
    {
        IDNo = iDNo;
    }

    public BigDecimal getIDType()
    {
        return IDType;
    }

    public void setIDType(BigDecimal iDType)
    {
        IDType = iDType;
    }

    public String getIssueCountry()
    {
        return issueCountry;
    }

    public void setIssueCountry(String issueCountry)
    {
        this.issueCountry = issueCountry;
    }

    public String getMobileWalletYN()
    {
        return mobileWalletYN;
    }

    public void setMobileWalletYN(String mobileWalletYN)
    {
        this.mobileWalletYN = mobileWalletYN;
    }

    public CTS_AMF_KYC_DETAILSVO getCtsAmfKycDetailsVO()
    {
        return ctsAmfKycDetailsVO;
    }

    public void setCtsAmfKycDetailsVO(CTS_AMF_KYC_DETAILSVO ctsAmfKycDetailsVO)
    {
        this.ctsAmfKycDetailsVO = ctsAmfKycDetailsVO;
    }

    public BigDecimal getScreenId()
    {
        return screenId;
    }

    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }

    public String getAdditionnalKycProps()
    {
        return additionnalKycProps;
    }

    public void setAdditionnalKycProps(String additionnalKycProps)
    {
        this.additionnalKycProps = additionnalKycProps;
    }

    public String getKycDhfLoaded()
    {
        return kycDhfLoaded;
    }

    public void setKycDhfLoaded(String kycDhfLoaded)
    {
        this.kycDhfLoaded = kycDhfLoaded;
    }

    public CURRENCIESVO getCurrenciesVO()
    {
        return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
        this.currenciesVO = currenciesVO;
    }
    
    public String getAllowInternalOpenDepAcc()
    {
        return allowInternalOpenDepAcc;
    }

    public void setAllowInternalOpenDepAcc(String allowInternalOpenDepAcc)
    {
        this.allowInternalOpenDepAcc = allowInternalOpenDepAcc;
    }

    public BigDecimal getPayAmount()
    {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount)
    {
        this.payAmount = payAmount;
    }

    public String getStatusCode()
    {
	return statusCode;
    }

    public void setStatusCode(String statusCode)
    {
	this.statusCode = statusCode;
    }

    public String getAdvanceProfitPaymentGridUpdate()
    {
        return advanceProfitPaymentGridUpdate;
    }

    public void setAdvanceProfitPaymentGridUpdate(String advanceProfitPaymentGridUpdate)
    {
        this.advanceProfitPaymentGridUpdate = advanceProfitPaymentGridUpdate;
    }

    public List<AdvanceProfitRatesCO> getAdvanceProfitRatesCOList()
    {
        return advanceProfitRatesCOList;
    }

    public void setAdvanceProfitRatesCOList(List<AdvanceProfitRatesCO> advanceProfitRatesCOList)
    {
        this.advanceProfitRatesCOList = advanceProfitRatesCOList;
    }

    public String getAdvanceProfitRatesGridUpdates()
    {
        return advanceProfitRatesGridUpdates;
    }

    public void setAdvanceProfitRatesGridUpdates(String advanceProfitRatesGridUpdates)
    {
        this.advanceProfitRatesGridUpdates = advanceProfitRatesGridUpdates;
    }

    public String getAdvanceProfitRateAccAddRef()
    {
        return advanceProfitRateAccAddRef;
    }

    public void setAdvanceProfitRateAccAddRef(String advanceProfitRateAccAddRef)
    {
        this.advanceProfitRateAccAddRef = advanceProfitRateAccAddRef;
    }

    public String getAdvanceProfitRateAccDesc()
    {
        return advanceProfitRateAccDesc;
    }

    public void setAdvanceProfitRateAccDesc(String advanceProfitRateAccDesc)
    {
        this.advanceProfitRateAccDesc = advanceProfitRateAccDesc;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public String getPointsPosted()
    {
        return pointsPosted;
    }

    public void setPointsPosted(String pointsPosted)
    {
        this.pointsPosted = pointsPosted;
    }

    public BigDecimal getAdvanceRate()
    {
        return advanceRate;
    }

    public void setAdvanceRate(BigDecimal advanceRate)
    {
        this.advanceRate = advanceRate;
    }

    public String getErrorText()
    {
        return errorText;
    }

    public void setErrorText(String errorText)
    {
        this.errorText = errorText;
    }

    public String getAdvanceProfitAlert()
    {
        return advanceProfitAlert;
    }

    public void setAdvanceProfitAlert(String advanceProfitAlert)
    {
        this.advanceProfitAlert = advanceProfitAlert;
    }

    public String getAdvanceProfitAlertIndicator()
    {
        return advanceProfitAlertIndicator;
    }

    public void setAdvanceProfitAlertIndicator(String advanceProfitAlertIndicator)
    {
        this.advanceProfitAlertIndicator = advanceProfitAlertIndicator;
    }

    public BigDecimal getOverDraftLimit()
    {
        return overDraftLimit;
    }

    public void setOverDraftLimit(BigDecimal overDraftLimit)
    {
        this.overDraftLimit = overDraftLimit;
    }

    public String getAccOverDrawnYN()
    {
        return accOverDrawnYN;
    }

    public void setAccOverDrawnYN(String accOverDrawnYN)
    {
        this.accOverDrawnYN = accOverDrawnYN;
    }

    public BigDecimal getOriginCR_PT_RATE()
    {
	return originCR_PT_RATE;
    }

    public void setOriginCR_PT_RATE(BigDecimal originCR_PT_RATE)
    {
	this.originCR_PT_RATE = originCR_PT_RATE;
    }

    public BigDecimal getOriginDR_PT_RATE()
    {
	return originDR_PT_RATE;
    }

    public void setOriginDR_PT_RATE(BigDecimal originDR_PT_RATE)
    {
	this.originDR_PT_RATE = originDR_PT_RATE;
    }

    public String getRateChangedFlag()
    {
	return rateChangedFlag;
    }

    public void setRateChangedFlag(String rateChangedFlag)
    {
	this.rateChangedFlag = rateChangedFlag;
    }

    
    public BigDecimal getMaxAmount()
    {
	return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount)
    {
	this.maxAmount = maxAmount;
    }

    public String getActionType()
    {
	return actionType;
    }

    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }

    public String getMsgConfCode()
    {
        return msgConfCode;
    }

    public void setMsgConfCode(String msgConfCode)
    {
        this.msgConfCode = msgConfCode;
    }

    public String getRevDrawdown()
    {
        return revDrawdown;
    }

    public void setRevDrawdown(String revDrawdown)
    {
        this.revDrawdown = revDrawdown;
    }
    
    public String getCifNationalityCheck()
    {
        return cifNationalityCheck;
    }

    public void setCifNationalityCheck(String cifNationalityCheck)
    {
        this.cifNationalityCheck = cifNationalityCheck;
    }

    public String getFromDeleteDrawDown()
    {
        return fromDeleteDrawDown;
    }

    public void setFromDeleteDrawDown(String fromDeleteDrawDown)
    {
        this.fromDeleteDrawDown = fromDeleteDrawDown;
    }

    public String getSavingAccount()
    {
        return savingAccount;
    }

    public void setSavingAccount(String savingAccount)
    {
        this.savingAccount = savingAccount;
    }

    public String getCurrentAccount()
    {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount)
    {
        this.currentAccount = currentAccount;
    }
    
    public String getUpdateApplDate()
    {
        return updateApplDate;
    }

    public void setUpdateApplDate(String updateApplDate)
    {
        this.updateApplDate = updateApplDate;
    }

    public BigDecimal getRATE()
    {
        return RATE;
    }

    public void setRATE(BigDecimal rATE)
    {
        RATE = rATE;
    }

    public BigDecimal getLastPoints()
    {
        return lastPoints;
    }

    public void setLastPoints(BigDecimal lastPoints)
    {
        this.lastPoints = lastPoints;
    }

    public BigDecimal getTotalAccruedPoints()
    {
        return totalAccruedPoints;
    }

    public void setTotalAccruedPoints(BigDecimal totalAccruedPoints)
    {
        this.totalAccruedPoints = totalAccruedPoints;
    }

    public String getExemptReasonDesc()
    {
        return exemptReasonDesc;
    }

    public void setExemptReasonDesc(String exemptReasonDesc)
    {
        this.exemptReasonDesc = exemptReasonDesc;
    }

	public List<ReportsCO> getReportsList() {
		return reportsList;
	}

	public void setReportsList(List<ReportsCO> reportsList) {
		this.reportsList = reportsList;
	}
    
    public BigDecimal getPointRate()
    {
        return pointRate;
    }

    public void setPointRate(BigDecimal pointRate)
    {
        this.pointRate = pointRate;
    }

    public BigDecimal getNewBS()
    {
        return newBS;
    }

    public void setNewBS(BigDecimal newBS)
    {
        this.newBS = newBS;
    }

    public String getInstruction1()
    {
        return instruction1;
    }

    public void setInstruction1(String instruction1)
    {
        this.instruction1 = instruction1;
    }

    public String getInstruction2()
    {
        return instruction2;
    }

    public void setInstruction2(String instruction2)
    {
        this.instruction2 = instruction2;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public Date getMaturityDate()
    {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
        this.maturityDate = maturityDate;
    }

    public Date getLastDepositDate()
    {
        return lastDepositDate;
    }

    public void setLastDepositDate(Date lastDepositDate)
    {
        this.lastDepositDate = lastDepositDate;
    }

    public Date getLastWithdrawalDate()
    {
        return lastWithdrawalDate;
    }

    public void setLastWithdrawalDate(Date lastWithdrawalDate)
    {
        this.lastWithdrawalDate = lastWithdrawalDate;
    }

    public Date getLastActivityDate()
    {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate)
    {
        this.lastActivityDate = lastActivityDate;
    }

    public BigDecimal getLastDepositAmount()
    {
        return lastDepositAmount;
    }

    public void setLastDepositAmount(BigDecimal lastDepositAmount)
    {
        this.lastDepositAmount = lastDepositAmount;
    }

    public BigDecimal getLastWithdrawalAmount()
    {
        return lastWithdrawalAmount;
    }

    public void setLastWithdrawalAmount(BigDecimal lastWithdrawalAmount)
    {
        this.lastWithdrawalAmount = lastWithdrawalAmount;
    }

    public BigDecimal getTodayCreditAmount()
    {
        return todayCreditAmount;
    }

    public void setTodayCreditAmount(BigDecimal todayCreditAmount)
    {
        this.todayCreditAmount = todayCreditAmount;
    }

    public BigDecimal getTodayDebitAmount()
    {
        return todayDebitAmount;
    }

    public void setTodayDebitAmount(BigDecimal todayDebitAmount)
    {
        this.todayDebitAmount = todayDebitAmount;
    }

    public BigDecimal getOpNo()
    {
        return opNo;
    }

    public void setOpNo(BigDecimal opNo)
    {
        this.opNo = opNo;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getAlPos()
    {
        return alPos;
    }

    public void setAlPos(BigDecimal alPos)
    {
        this.alPos = alPos;
    }

    public String getChargesWaiverLoaded()
    {
        return chargesWaiverLoaded;
    }

    public void setChargesWaiverLoaded(String chargesWaiverLoaded)
    {
        this.chargesWaiverLoaded = chargesWaiverLoaded;
    }

    public BigDecimal getAvailableOverdraft()
    {
        return availableOverdraft;
    }

    public void setAvailableOverdraft(BigDecimal availableOverdraft)
    {
        this.availableOverdraft = availableOverdraft;
    }

    public BigDecimal getOvDraftAvLimit()
    {
        return ovDraftAvLimit;
    }

    public void setOvDraftAvLimit(BigDecimal ovDraftAvLimit)
    {
        this.ovDraftAvLimit = ovDraftAvLimit;
    }
    
    public List<AMF_ADDRESSVO> getAddressVOList()
    {
        return addressVOList;
    }

    public void setAddressVOList(List<AMF_ADDRESSVO> addressVOList)
    {
        this.addressVOList = addressVOList;
    }

    public BigDecimal getLockId()
    {
        return lockId;
    }

    public void setLockId(BigDecimal lockId)
    {
        this.lockId = lockId;
    }

    public String getAccForLockExists()
    {
        return accForLockExists;
    }

    public void setAccForLockExists(String accForLockExists)
    {
        this.accForLockExists = accForLockExists;
    }

    public List<AMF_PT_DETAILSVO> getAmfPtDetailsDebitVOs()
    {
        return amfPtDetailsDebitVOs;
    }

    public void setAmfPtDetailsDebitVOs(List<AMF_PT_DETAILSVO> amfPtDetailsDebitVOs)
    {
        this.amfPtDetailsDebitVOs = amfPtDetailsDebitVOs;
    }

    public List<AMF_PT_DETAILSVO> getAmfPtDetailsCreditVOs()
    {
        return amfPtDetailsCreditVOs;
    }

    public void setAmfPtDetailsCreditVOs(List<AMF_PT_DETAILSVO> amfPtDetailsCreditVOs)
    {
        this.amfPtDetailsCreditVOs = amfPtDetailsCreditVOs;
    }

    public String getExemptedFromVAT()
    {
        return exemptedFromVAT;
    }

    public void setExemptedFromVAT(String exemptedFromVAT)
    {
        this.exemptedFromVAT = exemptedFromVAT;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public Integer getAccountsManagementLstRec()
    {
        return accountsManagementLstRec;
    }

    public void setAccountsManagementLstRec(Integer accountsManagementLstRec)
    {
        this.accountsManagementLstRec = accountsManagementLstRec;
    }

    public List<AccountsManagementCO> getAccountsManagementLst()
    {
        return accountsManagementLst;
    }

    public void setAccountsManagementLst(List<AccountsManagementCO> accountsManagementLst)
    {
        this.accountsManagementLst = accountsManagementLst;
    }

    public String getCurrISOCode()
    {
        return currISOCode;
    }

    public void setCurrISOCode(String currISOCode)
    {
        this.currISOCode = currISOCode;
    }

    public BigDecimal getTodayAmountCredit()
    {
        return todayAmountCredit;
    }

    public void setTodayAmountCredit(BigDecimal todayAmountCredit)
    {
        this.todayAmountCredit = todayAmountCredit;
    }

    public BigDecimal getTodayAmountDebit()
    {
        return todayAmountDebit;
    }

    public void setTodayAmountDebit(BigDecimal todayAmountDebit)
    {
        this.todayAmountDebit = todayAmountDebit;
    }

    public BigDecimal getTodayAmountFloat()
    {
        return todayAmountFloat;
    }

    public void setTodayAmountFloat(BigDecimal todayAmountFloat)
    {
        this.todayAmountFloat = todayAmountFloat;
    }

    public BigDecimal getDealNo()
    {
        return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
        this.dealNo = dealNo;
    }

    public String getDealCustomNo()
    {
        return dealCustomNo;
    }
	
    public Boolean getIsFromModaribRateDep()
    {
        return isFromModaribRateDep;
    }

    public void setIsFromModaribRateDep(Boolean isFromModaribRateDep)
    {
        this.isFromModaribRateDep = isFromModaribRateDep;
    }



    public FMSFACILITYDETVO getFmsFacilityDetVO()
    {
        return fmsFacilityDetVO;
    }

    public void setFmsFacilityDetVO(FMSFACILITYDETVO fmsFacilityDetVO)
    {
        this.fmsFacilityDetVO = fmsFacilityDetVO;
    }

    public String getFacilityUsedByCustomer()
    {
        return facilityUsedByCustomer;
    }

    public void setFacilityUsedByCustomer(String facilityUsedByCustomer)
    {
        this.facilityUsedByCustomer = facilityUsedByCustomer;
    }

    public List<AccountsGAProfitDeclarationCO> getProfitDeclAllRecList()
    {
        return profitDeclAllRecList;
    }

    public void setProfitDeclAllRecList(List<AccountsGAProfitDeclarationCO> profitDeclAllRecList)
    {
        this.profitDeclAllRecList = profitDeclAllRecList;
    }



    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }


    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public boolean isSendRestrictAlert()
    {
        return sendRestrictAlert;
    }

    public void setSendRestrictAlert(boolean sendRestrictAlert)
    {
        this.sendRestrictAlert = sendRestrictAlert;
    }

    public boolean isRestrictConfirmationFlag()
    {
        return restrictConfirmationFlag;
    }

    public void setRestrictConfirmationFlag(boolean restrictConfirmationFlag)
    {
        this.restrictConfirmationFlag = restrictConfirmationFlag;
    }

    public String getFORMATTED_ADDITIONAL_REFERENCE()
   	{
   	    return FORMATTED_ADDITIONAL_REFERENCE;
   	}

   	public void setFORMATTED_ADDITIONAL_REFERENCE(String fORMATTED_ADDITIONAL_REFERENCE)
   	{
   	    FORMATTED_ADDITIONAL_REFERENCE = fORMATTED_ADDITIONAL_REFERENCE;
   	}

   	public BigDecimal getOriginalPayAmount()
	{
	    return originalPayAmount;
	}

	public void setOriginalPayAmount(BigDecimal originalPayAmount)
	{
	    this.originalPayAmount = originalPayAmount;
	}
	
	 public String getPtIndicator()
	 {
	       return ptIndicator;
	 }

	 public void setPtIndicator(String ptIndicator)
	 {
	      this.ptIndicator = ptIndicator;
	 }

	 public String getContinueProcess()
	  {
	      return continueProcess;
	  }

	  public void setContinueProcess(String continueProcess)
	  {
	      this.continueProcess = continueProcess;
	  }
	    
	  public CardsManagementCO getCardsManagementCO()
	  {
	      return cardsManagementCO;
	  }

	  public void setCardsManagementCO(CardsManagementCO cardsManagementCO)
	  {
	      this.cardsManagementCO = cardsManagementCO;
	  }
	  
	    public CTS_ACC_TRX_LIMITVO getCtsacctrxlimitvo()
	    {
	        return ctsacctrxlimitvo;
	    }

	    public void setCtsacctrxlimitvo(CTS_ACC_TRX_LIMITVO ctsacctrxlimitvo)
	    {
	        this.ctsacctrxlimitvo = ctsacctrxlimitvo;
	    }

}