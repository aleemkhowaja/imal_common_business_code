package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPE_LINKVO;
import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntSC extends GridParamsSC
{
    private BigDecimal loginBraCode;
    private BigDecimal trsCy;
    private String maskedCardNo;
    private BigDecimal tellerCode;
    private BigDecimal trsNo;
    private BigDecimal toTrsNo;
    private BigDecimal fromTrsNo;
    private BigDecimal cyCode;
    private BigDecimal code;
    private BigDecimal firstCIFNo;
    private String cyField;
    private String defaultIntrs;
    private String cbInd;
    private String trsType;
    private String drCrType;
    private BigDecimal trxType;
    private String limitType;
    private String bankBranch;
    private String branchRef;
    private String key;
    private String algorithm;
    private String blockActiveWith;
    private String trsNoList;
    private String versionCode; // Web Service version
    private String isUnifiedCharge;

    private String langCode;
    private BigDecimal lovType;
    private BigDecimal scannedCIFNo;
    private String appName;
    private String progRef;
    private String ivCrud;
    private String screenSrc; // instead of isMultiCHQ we specify the screen
    // source;

    private BigDecimal inTrsno;
    private BigDecimal trsAcBr;
    private BigDecimal trsAcCy;
    private BigDecimal trsAcGl;
    private BigDecimal trsAcCif;
    private BigDecimal trsAcSl;
    private BigDecimal toTrsAcBr;
    private BigDecimal toTrsAcCy;
    private BigDecimal toTrsAcGl;
    private BigDecimal toTrsAcCif;
    private BigDecimal toTrsAcSl;
    private BigDecimal ctrlAcCy;
    private BigDecimal ctrlAcGl;
    private BigDecimal ctrlAcCif;
    private BigDecimal ctrlAcSl;
    private BigDecimal chAcBr;
    private BigDecimal chAcCy;
    private BigDecimal chAcGl;
    private BigDecimal chAcCif;
    private BigDecimal chAcSl;
    private BigDecimal trxAmount;
    private BigDecimal accAmount;
    private BigDecimal cvAmount;
    private BigDecimal totalFCcharge;
    private BigDecimal totalCVcharge;
    private BigDecimal totalDuesFCcharge ; 	//JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 
    private BigDecimal totalDuesCVcharge;	//JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659
    private BigDecimal duesRemainingCharge;	//JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659
    private String deduct;
    private String action;
    private String alertMode;
    private String trsfrMethod;
    private String overDrawnVoid;
    private String draftTrx;
    private Date trsDate;
    private Date valueDate;
    private Date systemDate;
    private Date chqDate;
    private String rateFlag;
    private BigDecimal chqNum;
    private BigDecimal fromRemit;
    private BigDecimal toRemit;
    private BigDecimal bankCif;
    private BigDecimal outTrsno;
    private String errType;
    private String type;
    private String selectedAcc;
    private BigDecimal errorCode;
    private String errorMessage;
    private String reason;
    private String iban;
    private BigDecimal country;
    private List<BigDecimal> countryList;
    private BigDecimal currency;
    private BigDecimal cif;
    private BigDecimal valid;
    private BigDecimal toTellerCode;
    private BigDecimal DayNum;
    private String reference;
    private String soType;
    private BigDecimal trxPriority;
    private String status;
    private String alertStatus;
    private String accAddRef;
    private List<CTSTRS_ACC_DETVO> ctstrsACCDETVOs;
    private String MULTI_BRANCH;
    private String colName;
    private String teller;
    private List<CTSTRXTYPE_LINKVO> trxLinkList = new ArrayList<CTSTRXTYPE_LINKVO>();
    private BigDecimal clearingHouse;
    private BigDecimal billType;
    private BigDecimal destinCountry;
    private BigDecimal benefBank;
    private BigDecimal exchRate;
    private BigDecimal vatCVAmount;
    private BigDecimal vatFCAmount;
    private String crDrForex;
    private String flag;
    private String chargeCyPolicy;
    private BigDecimal facilityApplicationRef;
    private BigDecimal facilityCollateralRef;
    private String swiftInfo;
    private BigDecimal linkToTrsNo;
    private BigDecimal linkToTrxTypeCode;
    private String multiDivInd;
    private String cardNo;
    private String totalAccount;
    private BigDecimal typeCode;
    private String soReference;
    private BigDecimal fcAmount;
    private BigDecimal frCif;
    private BigDecimal frCy;
    private BigDecimal toCy;
    private String typeFrTo;
    private String remitSerial;
    private BigDecimal remitAmount;
    private BigDecimal trsfrType;
    private BigDecimal minMaxBal;
    private BigDecimal remittanceType;
    private BigDecimal remittanceNum;
    private String remitCy;
    private BigDecimal defaultAccount;
    private String remitByHeadTeller;
    private BigDecimal headTeller;
    private BigDecimal minSeqNo;
    private String stOrder;
    private BigDecimal micrCodeline;
    private String micrIN;
    private String micrOUT;
    private String trxDefaultAcc;
    private String warningMessages;
    private String showTodayTrx;
    private String showAllTrx;
    private String lsLinkToOtrTrx;
    private BigDecimal trsTime;
    private BigDecimal closeTime;
    private String cash;
    private BigDecimal acFromCyUnits;
    private String acFromCyMultiDiv;
    private BigDecimal acToCyUnits;
    private String acToCyMultiDiv;
    private BigDecimal decimalPoints;
    private Date firstPeriod;
    private Date lastPeriod;
    private String trends;
    private Date openDate;
    private int maintainHijiriDate;
    private String chqRelated;
    private BigDecimal cifType;
    private String hCVDateBasedOnCy;
    private BigDecimal hCVDateDaysNo;
    private String cCVDateBasedOn;
    private BigDecimal cCVDateDaysOn;
    private BigDecimal chqClear;
    private String checkClosingTime;
    private String holFlag;
    private String gmiFlag;
    private Date maturityDate;
    private String sendSwift;
    private String typeOrigin;
    private String replaceChqDate;
    private BigDecimal hofDays;
    private Date releaseDate;
    private Date trsDateHijri;
    private Date valueDateHijri;
    private String vDateType;
    private BigDecimal maintainHijri;
    private BigDecimal originBraCode;
    private String holClearFlag;
    private BigDecimal holClearBrCode;
    private String remittanceChanged;
    private int isTC;
    private String allowProceed;
    private String allowProcceedUpdateApprove;
    private BigDecimal amount;
    private BigDecimal trsAcAmount;
    private String cashDeductInd;
    private String lsTrxSts;
    private boolean fromRetrieve;

    private BigDecimal oldFromRemit;
    private BigDecimal oldToRemit;
    private BigDecimal tcLineNumber;
    private BigDecimal linkToTrsNoBr;
    private String instructions1;
    private String instructions2;
    private String inOut;
    private String trxReverseOrCancel;
    private String recalculateCyDenom;
    private String operation;
    private String trxMgntChargesGridUpdate;
    private String cyExchChargesGridUpdate;
    private String terminalID;
    private String linkToOtherTrxProceed;
    private BigDecimal initLine;
    private String branchesIn;
    private String branchesOut;
    private String manualJV;
    private BigDecimal opNo;
    private BigDecimal jvNo;
    private String entriesLevel;
    private String amfAlertStatus;
    private String reverseCharges;
    private String dofTrxType;
    private BigDecimal chargeSchema;
    private BigDecimal addNum;
    private String addString;
    private Date addDate;
    private BigDecimal charges;
    private BigDecimal irisCifNo;
    private String multiTrx;
    private String isSO;
    private String onOffBs;
    private String chargesEntries;
    private String fromAmendSO;
    private String periodicityType;

    private BigDecimal batchBrCode;
    private BigDecimal batchNo;
    private BigDecimal serialNo;
    private BigDecimal fileType;
    private String staff;
    private BigDecimal jvType;
    private BigDecimal callType;
    private BigDecimal bodAmount;
    //Hasan EWBI160043 08/09/2016
    private String checkUpdateChequeDate;
    private String checkUpdateChequeDateList;
    private String chqAccNum;
    private String parentRef;//Hasan BMO160011 06/02/2017
    private BigDecimal maskTellerCode; //maria BMO180075 enhencement 
    private String maskTrxAmtApproveYN; //maria BMO180075 enhencement
    private String allowCifCreationMaskYN;    
    // added by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
    private String printingLocation;
    // end nancy
    private BigDecimal subStatusLovType;
    
    private String linkTrx;
    // Hala Al Sheikh TP790351 - DASI190021
    private BigDecimal vatCode;    
    
    //Sabine ZBI 
    private BigDecimal  baseCurrencyCode;
    private BigDecimal chargeCVAmount;
    private BigDecimal chargeFCAmount;
    /*
     * currency exchange parameter
     */
    private BigDecimal exchangeRate;

    private BigDecimal cashInCurrencyCode;

    private BigDecimal cashInAmount;

    private BigDecimal cashInAccBr;

    private BigDecimal cashInAccCy;

    private BigDecimal cashInAccGl;

    private BigDecimal cashInAccCif;

    private BigDecimal cashOutCurrencyCode;

    private BigDecimal cashOutAmount;

    private BigDecimal cashOutAccBr;

    private BigDecimal cashOutAccCy;

    private BigDecimal cashOutAccGl;

    private BigDecimal cashOutAccCif;
    // addded by jihad to create HOF trx
    private String hofReason;
    private BigDecimal releaseDays;

    private String chargesCodeLst;

    // Break Of Deposit
    private String istaxincluded;
    private String isenabletcr;
    private String isapplytrcrate;
    private BigDecimal idectvarate;
    private BigDecimal idectrcrate;
    private BigDecimal GV_FISCAL_YEAR;

    private String isAppliedPenalty;
    private BigDecimal profitReverseFc;
    private BigDecimal profitReverseCv;
    private BigDecimal tcrFcAmount;
    private BigDecimal tcrCvAmount;
    private BigDecimal tvaAmount;

    private BigDecimal relatedGl;
    private BigDecimal PROFIT_GROUP;
    private BigDecimal DISTRIBUTED_PROFIT_CV;
    private BigDecimal DISTRIBUTED_PROFIT_FC;
    private BigDecimal NON_DISTRIBUTED_PROFIT_CV;
    private BigDecimal NON_DISTRIBUTED_PROFIT_FC;
    private BigDecimal THIS_MONTH_PROFIT_CV;

    private BigDecimal THIS_MONTH_PROFIT_FC;
    private BigDecimal DISTRIBUTED_PROFIT_RECALC_CV;
    private BigDecimal DISTRIBUTED_PROFIT_RECALC_FC;
    private BigDecimal NON_DISTR_PROFIT_RECALC_CV;
    private BigDecimal NON_DISTR_PROFIT_RECALC_FC;
    private BigDecimal THIS_MONTH_PROFIT_RECALC_CV;
    private BigDecimal THIS_MONTH_PROFIT_RECALC_FC;
    private BigDecimal CURRENT_PROFIT_CV;
    private BigDecimal CURRENT_PROFIT_FC;
    private BigDecimal TAX_CV;
    private BigDecimal TAX_FC;
    private BigDecimal CHARGES_CV;
    private BigDecimal CHARGES_FC;

    private BigDecimal PENALTY_CV;
    private BigDecimal PENALTY_FC;
    private BigDecimal zakatCV;
    private BigDecimal zakatFC;
    private BigDecimal zakatChgCV;
    private BigDecimal zakatChgFC;
    private BigDecimal OLD_PROFIT_RATE;

    private String fullBreakDeposit;
    private String excludePcsDistribution;

    private BigDecimal adecAdvFC;
    private BigDecimal adecAdvCv;
    private BigDecimal adecAccrualCv;
    private BigDecimal adecAccrualFc;

    private BigDecimal adecBal;
    private BigDecimal adecProfit;
    private BigDecimal adecProfitCV;
    private BigDecimal adecPenalty;
    private BigDecimal adecPenaltyCV;
    private BigDecimal adecNetProfit;
    private BigDecimal adecNetProfitCV;
    private String asOverPenalty;
    private BigDecimal adecOrigProfit;
    private BigDecimal adecOrigProfitCV;
    
    private BigDecimal adecCrProfit;
    private BigDecimal adecCrProfitCV;
    private BigDecimal adecDrProfit;
    private BigDecimal adecDrProfitCV;
    private String postchgComm;
    
    private BigDecimal PRFT_BR;
    private BigDecimal PRFT_CY;
    private BigDecimal PRFT_GL;
    private BigDecimal PRFT_CIF;
    private BigDecimal PRFT_SL;
    
    private BigDecimal PENALTY_GL;
    private BigDecimal PENALTY_CIF;
    private BigDecimal PENALTY_SL;
    // ----needed for PKG_PCS_BREAK_OF_DEPOSIT.P_GET_PCS_CHARGES--
    private BigDecimal ADEC_PROFIT_CV;
    private BigDecimal ADEC_PROFIT_FC;
    private BigDecimal AL_PROFIT_GROUP;
    private String AS_APPLY_PCS_CHARGES;
    private BigDecimal AL_UNIT;
    private String AC_MULTDIV;
    private BigDecimal AL_CY_DECIMALS;
    private BigDecimal ADEC_RATE;
    private BigDecimal ADEC_ORIG_RATE;
    private String AS_CHARGE_CURRENCY;
    private BigDecimal commissionFC;
    private BigDecimal commissionCV;
    private BigDecimal chargeFC;
    private BigDecimal chargeCV;
    private BigDecimal roundedAmtCV;
    private BigDecimal roundedAmtFC;
    // ----needed for PKG_PCS_BREAK_OF_DEPOSIT.P_GET_PCS_CHARGES--
    private BigDecimal tax;
    private BigDecimal taxPtCv;
    
    private BigDecimal relatedGLNew;
    private BigDecimal modaribRateAmtCV;
    private BigDecimal modaribRateAmtFC;
    private BigDecimal riskProvAmtCV;
    private BigDecimal riskProvAmtFC;
    private BigDecimal otherProvAmtCV;
    private BigDecimal otherProvAmtFC;
    

    // Cheque count printed for multiCheque
    private BigDecimal multiChqCode;
    private BigDecimal minTrsNo;
    private BigDecimal maxTrsNo;
    private BigDecimal printedCount;
    private BigDecimal nonPrintedCount;
    private BigDecimal totalCount;

    private BigDecimal ACCR_GL;
    private BigDecimal ACCR_CIF;
    private BigDecimal ACCR_SL;
    private String currStatus;
    private String contProcess;
    private BigDecimal addAmt1;
    private BigDecimal addAmt2;
    private BigDecimal addAmt3;
    private BigDecimal addAmt4;
    private String os_s_string;
    private BigDecimal overDrawnAmount;
    private BigDecimal overDrawnAmountFr;
    private BigDecimal overDrawnAmountTo;

    private BigDecimal windTrxType;
    private BigDecimal saveCount;
    private String chargesWaived;
    private String linkToOtherTrxLookup;
    private String fromForceMatch;
    private String is_tc_92;
    private String ignoreHolidaysForTrsDate;
    // this flag is set to true when we call this sc from Clearing/Maintenance
    // screen
    private boolean fromClearingVoiding;

    private BigDecimal sessionID;
    private BigDecimal lineNo;
    //NABIL FEGHALI - BISI120001 Template Entries Voiding
    private BigDecimal templateCode;
    private String entryType;
    private String rateChanged;
    private Date fromDate;
    private Date toDate;
    private BigDecimal openingBal;
    private BigDecimal numDays;

    /*
     * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 
     * used for product screens to store entity code (product number) and entity type (screen reference ex: 'CHQ', 'SMS', 'PAS'...)
     */
    private BigDecimal entityCode;
    private String entityType;
    private String duesSubOperation;
    private String duesInd;
    private String duesCollectionType;
    private String duesPaymentMethod; 
    private String chargeBriefNameEng;
    private String chargeBriefNameArab;
    private String chargesEmpty;
    
    private String ibDeduct;		//Deduct flag for BB120355 - Salary file upload from IB for corporate customers
    private String ibBatch;		//Batch Number for BB120355 - Salary file upload from IB for corporate customers
    private String sign;		//To specify which sign we want to check for (C/D)
    private String bankBicCode;		//Used to supply P_RET_GET_BIC_CODE with a give BIC Code for validation
    private String bicCode;		//Used to get the calculated BIC Code from P_RET_GET_BIC_CODE
    private String chargeBranch;	//To set charge branch flag from CTSCHARGES

    private BigDecimal cifEcoSector;
    private BigDecimal cifPriority;
    
    private String autoApprove;// 1 if trxApproveMgnt is called from trxMgntSave
    
    //BB130291
    private Boolean requiredDataByCifNoOnly;
    
    private String lockUnlockAccountsFlag;//US 154817 flag 'L' for locking and 'U' for unlocking
    private String fromAccGmiFlag;//US 154817
    private String fromAccSign;//US 154817
    private String toAccGmiFlag;//US 154817
    private String toAccSign;//US 154817
    private String checkDataSys2;//US 154817 CTSTRXTYPE.CHECK_DATA_SYS2
    private BigDecimal overrideUsrLevel;//US 154817 CTSTRXTYPE.OVERRIDE_USR_LEVEL
    private BigDecimal userLevel;//US 154817 CTSTELLER.PRIVILEGE_LEVEL
    private BigDecimal safeApp;//US 154817 PTH_CTRL.SAFE_APP
    private BigDecimal lockId;//US 154817 
    private String fromJava;//US 154817 true in case calling the procedure P_RET_LOCK_UNLOCK_SAFE_ACC from java
    private String accForLockExists;//US 154817 return true in case the procedure P_RET_LOCK_UNLOCK_SAFE_ACC return accounts to be locked
    private BigDecimal iisExists;//BB140182 - Salary was posted but the online salary block failed
    
    private boolean checkNbRec;
    
    private CTSTELLERVO ctsTellerVO;
    private String chargeType;
    private int trxMgntNbRecords;
    private List<TrxMgntCO> trxMgntListRecords;
    private String trxWhereQuery;
    private String trxWhereQueryForInnerSelect;
    
    private Boolean checkFomTrxDetails;
    //TONY NOUH User Story#315732  AMANA130105 Overdraft Products
    private BigDecimal profitDeclGracePeriodNo;//RIFATT
    private String profitDeclGracePeriodFreq;//RIFATT
    private String odType;//RIFATT
    private String mousharakaIjra;//ACC_NV_CONTROL
    private Date ijraEndingPeriodicity;//AMF_EXTENDED.IJARA_ENDING_PERIODICITY
    private Date limitExpDate;//AMF.LIMIT_EXP_DATE
    private String globalConfirmation;
    private String alertCifWatchList;
    private String alertIisOverdueInst;
    private String alertDidntDeclProfit;
    //END TONY NOUH User Story#315732  AMANA130105 Overdraft Products
    
    
    /* 368769 BIPL120018 raed saad*/
    private Date runningDate;
    private Date dateClosed;
    private BigDecimal partial_PFT_FC;
    private BigDecimal partial_PFT_CV;  
    /* 368769 BIPL120018 */
    
    private String createdBy;
    private BigDecimal createdByTellerCode;
    private BigDecimal alPos;
    private String docType;
    private BigDecimal avaAllocationCode;   
    
    private String availBalAfter;
    private String toAvailBalAfter;
    private BigDecimal deductBr;
    
    // Raed Saad - [#562508 ABARSI160021]
    private BigDecimal fromCif;
    private BigDecimal toCif;
    private BigDecimal taxRegulationID;
    // END - Raed Saad - [#562508 ABARSI160021]
    
    /** Rania Al-Bitar
     * Date: 19/01/2018
     */
    //BB140096 --[John Massaad]
    private String benefBICCode;
    private String intermBICCode;
    //Raed Saad - Bug#614187 
    //End - Raed Saad - Bug#614187 
    private String cyISO;
    
    private BigDecimal oldTrxAmount;
    private BigDecimal productClass;
    private BigDecimal remainingLimit;
 
    private BigDecimal isoInterface;
    private String fileName;
    private String fileCode;
    private BigDecimal sequence_no;
    private BigDecimal fromDay;
    private BigDecimal toDay;
    private BigDecimal month;
    private BigDecimal soPeriodInterval;
    private String narration;   
    
    // Raees IIS Account transfer
    private String calledFrom;
    
    //Habib Baalbaki accocunt restriction 372747
    private String pageRef;
    private List<TrxMgntCO> multiChequesEntryList = new ArrayList<>();
    
    private BigDecimal lossCV;
    private BigDecimal lossFC;
    private BigDecimal injProvAmtCV;
    private BigDecimal injProvAmtFC;
    private BigDecimal injRiskProvAmtCV;
    private BigDecimal injRiskProvAmtFC;

  //Rania - DB150021 Maisarah Credit Card
    private BigDecimal shadowAccountBr;
    private BigDecimal shadowAccountCy;
    private BigDecimal shadowAccountGl;
    private BigDecimal shadowAccountCif;
    private BigDecimal shadowAccountSl;

    private BigDecimal fundingAccountBr;
    private BigDecimal fundingAccountCy;
    private BigDecimal fundingAccountGl;
    private BigDecimal fundingAccountCif;
    private BigDecimal fundingAccountSl;
    //End Rania
    private List<CTSTRXTYPE_EXTENDEDVO> certifiedTrxTypeList = new ArrayList<CTSTRXTYPE_EXTENDEDVO>();

    private String postPftCr;
    private BigDecimal mcashLimit; //DB140075 - Customer wants to close the General Account - R14.1.1
    

    private BigDecimal lovSubstatus=TrxMgntConstant.SUB_STATUS_LOV_TYPE;
    private String isCollateralized; //ABAR130131 - NANTISSEMENT DES BONS DES CAISSES
    private String trxMethod;

    private BigDecimal returnedZakatCV;
    private BigDecimal returnedZakatFC;
    
    private String showSoRefLookup; //Rania - 829901
    
    private String allowIssueCertif;
    private String allowCancelCertif;
    private String allowCollectCertif;
    
  //#795165 Branches cash limit monitoring [MFALHA]

   
    private BigDecimal branchCashLimit;
    private BigDecimal utilizedBalance;
    private BigDecimal remainingBalance;
    private BigDecimal exceededBalance;
    private BigDecimal exceededPercentage;
    private String exceededLimit;
    private String responseOutput;
    private String fromProduct;
    private BigDecimal lovTypeSynthesis;
  //#795165 Branches cash limit monitoring [MFALHA]
    
    private BigDecimal requestId;
    
    private String benefName;
    private String benefAcc;
    private String benefBankName;
    private String benefBankBr;
    private String toAccAddRef;
    private BigDecimal trsAmount;
    private String isoCurrencyCode;
    private String trxDate;
    private String trxTime;
    private String ceftsStatus;
    private String trxReference;
    private String responseCode; 
    private BigDecimal de11StanSeq;
    private String de37RetRefNbSeq;
    private BigDecimal interfaceCode;
    private BigDecimal process_code;
    private String trxAuthCode;
    private String transDatetime;
    private String acquInstId;
    private BigDecimal requestId2;
    private String messageCode;
    private String ceftsTrxType;
    private String mode;
    private BigDecimal trxIID;
    private String trxOutIn;
    private String ceftsPrcCode;
    private BigDecimal incrementalCefts;
  
    //Hala Al Sheikh - AIB100209
    private String idNo;
    private Integer idNoReturnVal;
    private String intermediateBankName;
    private String intermediateBankBicCode;
    private String intermediateBankAddress1;
    private String intermediateBankAddress2;
    private String intermediateBankAddress3;
    private String intermediateBankAccount;
    private BigDecimal beneficiaryBank;
    private String beneficiaryBankName;
    private String beneficiaryBankBicCode;
    private String beneficiaryBankBranch;
    private String beneficiaryBankAddress1;
    private String beneficiaryBankAddress2;
    private String beneficiaryBankAddress3;
    private String beneficiaryBankAccount;
    private String beneficiaryName;
    private String beneficiaryAccount;
    private String beneficiaryAddress1;
    private String beneficiaryAddress2;
    private String beneficiaryAddress3;    
    private String instructions3; 
    private String instructions4; 
    private String swiftMess1;
    private String swiftMess2;
    private String swiftMess3;
    private String swiftMess4;
    private BigDecimal intermediateBankCode;
    private String intermediateBankBranch;
    private BigDecimal beneficiaryCorrespondentBank;
    private BigDecimal beneficiaryCity;
    private String recCorrespondentBankBicCode;
    private String recCorrespondentBankAddress;
    private String recCorrespondentBankAddress1;
    private String recCorrespondentBankAddress2;
    private String recCorrespondentBankAddress3;
    private String swiftSendReceive;
    private String swiftSendReceive1;
    private String swiftSendReceive2;
    private String swiftSendReceive3;
    private String icNo;
    private BigDecimal soPercMin;
    private BigDecimal soPercMax;
    private BigDecimal soPerc;
    private BigDecimal soPercCr;
    private BigDecimal soFirstPayment;
    private BigDecimal soLastPayment;
    private String reference1;
    private String reference2;
    private String reference3;
    private String statusReasonDesc;
    private String benefAddress; 
    private String description,description1,description2;
    private String descriptionAr,descriptionAr1,descriptionAr2;
    private String atmReference;
    private Integer useCard, useDate, useRemittance;
    private String toAccIban;
    private String remittanceDesc, remittanceCurrencyIso;    
    private String chequeAccountNumber, chequePayeeName;
    private BigDecimal chargeCode;
    private String subStatusDesc;
    
    public BigDecimal getDeductBr()
    {
        return deductBr;
    }

    public void setDeductBr(BigDecimal deductBr)
    {
        this.deductBr = deductBr;
    }
    private BigDecimal multiTrsNo;
    private BigDecimal nonFinLineNo;
    
    public String getHolClearFlag()
    {
	return holClearFlag;
    }

    public void setHolClearFlag(String holClearFlag)
    {
	this.holClearFlag = holClearFlag;
    }

    public BigDecimal getHolClearBrCode()
    {
	return holClearBrCode;
    }

    public void setHolClearBrCode(BigDecimal holClearBrCode)
    {
	this.holClearBrCode = holClearBrCode;
    }

    public BigDecimal getOriginBraCode()
    {
	return originBraCode;
    }

    public void setOriginBraCode(BigDecimal originBraCode)
    {
	this.originBraCode = originBraCode;
    }

    public String getMULTI_BRANCH()
    {
	return MULTI_BRANCH;
    }

    public void setMULTI_BRANCH(String mULTIBRANCH)
    {
	MULTI_BRANCH = mULTIBRANCH;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
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

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public Date getDateClosed()
    {
	return dateClosed;
    }

    public void setDateClosed(Date dateClosed)
    {
	this.dateClosed = dateClosed;
    }

    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public BigDecimal getPartial_PFT_FC()
    {
	return partial_PFT_FC;
    }

    public void setPartial_PFT_FC(BigDecimal partial_PFT_FC)
    {
	this.partial_PFT_FC = partial_PFT_FC;
    }

    public BigDecimal getPartial_PFT_CV()
    {
	return partial_PFT_CV;
    }

    public void setPartial_PFT_CV(BigDecimal partial_PFT_CV)
    {
	this.partial_PFT_CV = partial_PFT_CV;
    }

	public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public String getCbInd()
    {
	return cbInd;
    }

    public void setCbInd(String cbInd)
    {
	this.cbInd = cbInd;
    }

    public String getTrsType()
    {
	return trsType;
    }

    public void setTrsType(String trsType)
    {
	this.trsType = trsType;
    }

    public BigDecimal getInTrsno()
    {
	return inTrsno;
    }

    public void setInTrsno(BigDecimal inTrsno)
    {
	this.inTrsno = inTrsno;
    }

    public BigDecimal getTrsAcBr()
    {
	return trsAcBr;
    }

    public void setTrsAcBr(BigDecimal trsAcBr)
    {
	this.trsAcBr = trsAcBr;
    }

    public BigDecimal getTrsAcCy()
    {
	return trsAcCy;
    }

    public void setTrsAcCy(BigDecimal trsAcCy)
    {
	this.trsAcCy = trsAcCy;
    }

    public BigDecimal getTrsAcGl()
    {
	return trsAcGl;
    }

    public void setTrsAcGl(BigDecimal trsAcGl)
    {
	this.trsAcGl = trsAcGl;
    }

    public BigDecimal getTrsAcCif()
    {
	return trsAcCif;
    }

    public void setTrsAcCif(BigDecimal trsAcCif)
    {
	this.trsAcCif = trsAcCif;
    }

    public BigDecimal getTrsAcSl()
    {
	return trsAcSl;
    }

    public void setTrsAcSl(BigDecimal trsAcSl)
    {
	this.trsAcSl = trsAcSl;
    }

    public BigDecimal getToTrsAcBr()
    {
	return toTrsAcBr;
    }

    public void setToTrsAcBr(BigDecimal toTrsAcBr)
    {
	this.toTrsAcBr = toTrsAcBr;
    }

    public BigDecimal getToTrsAcCy()
    {
	return toTrsAcCy;
    }

    public void setToTrsAcCy(BigDecimal toTrsAcCy)
    {
	this.toTrsAcCy = toTrsAcCy;
    }

    public BigDecimal getToTrsAcGl()
    {
	return toTrsAcGl;
    }

    public void setToTrsAcGl(BigDecimal toTrsAcGl)
    {
	this.toTrsAcGl = toTrsAcGl;
    }

    public BigDecimal getToTrsAcCif()
    {
	return toTrsAcCif;
    }

    public void setToTrsAcCif(BigDecimal toTrsAcCif)
    {
	this.toTrsAcCif = toTrsAcCif;
    }

    public BigDecimal getToTrsAcSl()
    {
	return toTrsAcSl;
    }

    public void setToTrsAcSl(BigDecimal toTrsAcSl)
    {
	this.toTrsAcSl = toTrsAcSl;
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

    public String getAction()
    {
	return action;
    }

    public void setAction(String action)
    {
	this.action = action;
    }

    public String getTrsfrMethod()
    {
	return trsfrMethod;
    }

    public void setTrsfrMethod(String trsfrMethod)
    {
	this.trsfrMethod = trsfrMethod;
    }

    public Date getTrsDate()
    {
	return trsDate;
    }

    public void setTrsDate(Date trsDate)
    {
	this.trsDate = trsDate;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getSystemDate()
    {
	return systemDate;
    }

    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }

    public Date getChqDate()
    {
	return chqDate;
    }

    public void setChqDate(Date chqDate)
    {
	this.chqDate = chqDate;
    }

    public BigDecimal getChqNum()
    {
	return chqNum;
    }

    public void setChqNum(BigDecimal chqNum)
    {
	this.chqNum = chqNum;
    }

    public BigDecimal getFromRemit()
    {
	return fromRemit;
    }

    public void setFromRemit(BigDecimal fromRemit)
    {
	this.fromRemit = fromRemit;
    }

    public BigDecimal getToRemit()
    {
	return toRemit;
    }

    public void setToRemit(BigDecimal toRemit)
    {
	this.toRemit = toRemit;
    }

    public BigDecimal getBankCif()
    {
	return bankCif;
    }

    public void setBankCif(BigDecimal bankCif)
    {
	this.bankCif = bankCif;
    }

    public BigDecimal getOutTrsno()
    {
	return outTrsno;
    }

    public void setOutTrsno(BigDecimal outTrsno)
    {
	this.outTrsno = outTrsno;
    }

    public String getErrType()
    {
	return errType;
    }

    public void setErrType(String errType)
    {
	this.errType = errType;
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

    public String getReason()
    {
	return reason;
    }

    public void setReason(String reason)
    {
	this.reason = reason;
    }

    public String getIban()
    {
	return iban;
    }

    public void setIban(String iban)
    {
	this.iban = iban;
    }

    public BigDecimal getCountry()
    {
	return country;
    }

    public void setCountry(BigDecimal country)
    {
	this.country = country;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public BigDecimal getValid()
    {
	return valid;
    }

    public void setValid(BigDecimal valid)
    {
	this.valid = valid;
    }

    public BigDecimal getToTellerCode()
    {
	return toTellerCode;
    }

    public void setToTellerCode(BigDecimal toTellerCode)
    {
	this.toTellerCode = toTellerCode;
    }

    public String getReference()
    {
	return reference;
    }

    public void setReference(String reference)
    {
	this.reference = reference;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public String getCyField()
    {
	return cyField;
    }

    public void setCyField(String cyField)
    {
	this.cyField = cyField;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public String getDefaultIntrs()
    {
	return defaultIntrs;
    }

    public void setDefaultIntrs(String defaultIntrs)
    {
	this.defaultIntrs = defaultIntrs;
    }

    public String getSoType()
    {
	return soType;
    }

    public void setSoType(String soType)
    {
	this.soType = soType;
    }

    public BigDecimal getTrxPriority()
    {
	return trxPriority;
    }

    public void setTrxPriority(BigDecimal trxPriority)
    {
	this.trxPriority = trxPriority;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getAccAddRef()
    {
	return accAddRef;
    }

    public void setAccAddRef(String accAddRef)
    {
	this.accAddRef = accAddRef;
    }

    public List<CTSTRS_ACC_DETVO> getCtstrsACCDETVOs()
    {
	return ctstrsACCDETVOs;
    }

    public void setCtstrsACCDETVOs(List<CTSTRS_ACC_DETVO> ctstrsACCDETVOs)
    {
	this.ctstrsACCDETVOs = ctstrsACCDETVOs;
    }

    public BigDecimal getTotalFCcharge()
    {
	return totalFCcharge;
    }

    public void setTotalFCcharge(BigDecimal totalFCcharge)
    {
	this.totalFCcharge = totalFCcharge;
    }

    public BigDecimal getTotalCVcharge()
    {
	return totalCVcharge;
    }

    public void setTotalCVcharge(BigDecimal totalCVcharge)
    {
	this.totalCVcharge = totalCVcharge;
    }

    public String getDeduct()
    {
	return deduct;
    }

    public void setDeduct(String deduct)
    {
	this.deduct = deduct;
    }

    public String getAlertMode()
    {
	return alertMode;
    }

    public void setAlertMode(String alertMode)
    {
	this.alertMode = alertMode;
    }

    public String getOverDrawnVoid()
    {
	return overDrawnVoid;
    }

    public void setOverDrawnVoid(String overDrawnVoid)
    {
	this.overDrawnVoid = overDrawnVoid;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public BigDecimal getDayNum()
    {
	return DayNum;
    }

    public void setDayNum(BigDecimal dayNum)
    {
	DayNum = dayNum;
    }

    public String getColName()
    {
	return colName;
    }

    public void setColName(String colName)
    {
	this.colName = colName;
    }

    /**
     * @return the teller
     */
    public String getTeller()
    {
	return teller;
    }

    /**
     * @param teller the teller to set
     */
    public void setTeller(String teller)
    {
	this.teller = teller;
    }

    /**
     * @return the trxLinkList
     */
    public List<CTSTRXTYPE_LINKVO> getTrxLinkList()
    {
	return trxLinkList;
    }

    /**
     * @param trxLinkList the trxLinkList to set
     */
    public void setTrxLinkList(List<CTSTRXTYPE_LINKVO> trxLinkList)
    {
	this.trxLinkList = trxLinkList;
    }

    public BigDecimal getExchRate()
    {
	return exchRate;
    }

    public void setExchRate(BigDecimal exchRate)
    {
	this.exchRate = exchRate;
    }

    public BigDecimal getVatCVAmount()
    {
	return vatCVAmount;
    }

    public void setVatCVAmount(BigDecimal vatCVAmount)
    {
	this.vatCVAmount = vatCVAmount;
    }

    public BigDecimal getVatFCAmount()
    {
	return vatFCAmount;
    }

    public void setVatFCAmount(BigDecimal vatFCAmount)
    {
	this.vatFCAmount = vatFCAmount;
    }

    public String getCrDrForex()
    {
	return crDrForex;
    }

    public void setCrDrForex(String crDrForex)
    {
	this.crDrForex = crDrForex;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public String getScreenSrc()
    {
	return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
	this.screenSrc = screenSrc;
    }

    public BigDecimal getClearingHouse()
    {
	return clearingHouse;
    }

    public void setClearingHouse(BigDecimal clearingHouse)
    {
	this.clearingHouse = clearingHouse;
    }

    public BigDecimal getBillType()
    {
	return billType;
    }

    public void setBillType(BigDecimal billType)
    {
	this.billType = billType;
    }

    public BigDecimal getDestinCountry()
    {
	return destinCountry;
    }

    public void setDestinCountry(BigDecimal destinCountry)
    {
	this.destinCountry = destinCountry;
    }

    public BigDecimal getBenefBank()
    {
	return benefBank;
    }

    public void setBenefBank(BigDecimal benefBank)
    {
	this.benefBank = benefBank;
    }

    public String getChargeCyPolicy()
    {
	return chargeCyPolicy;
    }

    public void setChargeCyPolicy(String chargeCyPolicy)
    {
	this.chargeCyPolicy = chargeCyPolicy;
    }

    public BigDecimal getFacilityApplicationRef()
    {
	return facilityApplicationRef;
    }

    public void setFacilityApplicationRef(BigDecimal facilityApplicationRef)
    {
	this.facilityApplicationRef = facilityApplicationRef;
    }

    public BigDecimal getFacilityCollateralRef()
    {
	return facilityCollateralRef;
    }

    public void setFacilityCollateralRef(BigDecimal facilityCollateralRef)
    {
	this.facilityCollateralRef = facilityCollateralRef;
    }

    public String getSwiftInfo()
    {
	return swiftInfo;
    }

    public void setSwiftInfo(String swiftInfo)
    {
	this.swiftInfo = swiftInfo;
    }

    /**
     * @return the linkToTrsNo
     */
    public BigDecimal getLinkToTrsNo()
    {
	return linkToTrsNo;
    }

    /**
     * @param linkToTrsNo the linkToTrsNo to set
     */
    public void setLinkToTrsNo(BigDecimal linkToTrsNo)
    {
	this.linkToTrsNo = linkToTrsNo;
    }

    /**
     * @return the linkToTrxTypeCode
     */
    public BigDecimal getLinkToTrxTypeCode()
    {
	return linkToTrxTypeCode;
    }

    /**
     * @param linkToTrxTypeCode the linkToTrxTypeCode to set
     */
    public void setLinkToTrxTypeCode(BigDecimal linkToTrxTypeCode)
    {
	this.linkToTrxTypeCode = linkToTrxTypeCode;
    }

    public String getMultiDivInd()
    {
	return multiDivInd;
    }

    public void setMultiDivInd(String multiDivInd)
    {
	this.multiDivInd = multiDivInd;
    }

    public BigDecimal getMultiChqCode()
    {
	return multiChqCode;
    }

    public void setMultiChqCode(BigDecimal multiChqCode)
    {
	this.multiChqCode = multiChqCode;
    }

    public BigDecimal getMinTrsNo()
    {
	return minTrsNo;
    }

    public void setMinTrsNo(BigDecimal minTrsNo)
    {
	this.minTrsNo = minTrsNo;
    }

    public BigDecimal getMaxTrsNo()
    {
	return maxTrsNo;
    }

    public void setMaxTrsNo(BigDecimal maxTrsNo)
    {
	this.maxTrsNo = maxTrsNo;
    }

    public BigDecimal getPrintedCount()
    {
	return printedCount;
    }

    public void setPrintedCount(BigDecimal printedCount)
    {
	this.printedCount = printedCount;
    }

    public BigDecimal getNonPrintedCount()
    {
	return nonPrintedCount;
    }

    public void setNonPrintedCount(BigDecimal nonPrintedCount)
    {
	this.nonPrintedCount = nonPrintedCount;
    }

    public BigDecimal getTotalCount()
    {
	return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount)
    {
	this.totalCount = totalCount;
    }

    public String getCardNo()
    {
	return cardNo;
    }

    public void setCardNo(String cardNo)
    {
	this.cardNo = cardNo;
    }

    public BigDecimal getTypeCode()
    {
	return typeCode;
    }

    public void setTypeCode(BigDecimal typeCode)
    {
	this.typeCode = typeCode;
    }

    public String getSoReference()
    {
	return soReference;
    }

    public void setSoReference(String soReference)
    {
	this.soReference = soReference;
    }

    public String getDrCrType()
    {
	return drCrType;
    }

    public void setDrCrType(String drCrType)
    {
	this.drCrType = drCrType;
    }

    public BigDecimal getFcAmount()
    {
	return fcAmount;
    }

    public void setFcAmount(BigDecimal fcAmount)
    {
	this.fcAmount = fcAmount;
    }

    public BigDecimal getFrCif()
    {
	return frCif;
    }

    public void setFrCif(BigDecimal frCif)
    {
	this.frCif = frCif;
    }

    public BigDecimal getFrCy()
    {
	return frCy;
    }

    public void setFrCy(BigDecimal frCy)
    {
	this.frCy = frCy;
    }

    public BigDecimal getRemitAmount()
    {
	return remitAmount;
    }

    public void setRemitAmount(BigDecimal remitAmount)
    {
	this.remitAmount = remitAmount;
    }

    public BigDecimal getTrsfrType()
    {
	return trsfrType;
    }

    public void setTrsfrType(BigDecimal trsfrType)
    {
	this.trsfrType = trsfrType;
    }

    public String getTypeFrTo()
    {
	return typeFrTo;
    }

    public void setTypeFrTo(String typeFrTo)
    {
	this.typeFrTo = typeFrTo;
    }

    public BigDecimal getMinMaxBal()
    {
	return minMaxBal;
    }

    public void setMinMaxBal(BigDecimal minMaxBal)
    {
	this.minMaxBal = minMaxBal;
    }

    public BigDecimal getRemittanceType()
    {
	return remittanceType;
    }

    public void setRemittanceType(BigDecimal remittanceType)
    {
	this.remittanceType = remittanceType;
    }

    public String getRemitCy()
    {
	return remitCy;
    }

    public void setRemitCy(String remitCy)
    {
	this.remitCy = remitCy;
    }

    public BigDecimal getDefaultAccount()
    {
	return defaultAccount;
    }

    public void setDefaultAccount(BigDecimal defaultAccount)
    {
	this.defaultAccount = defaultAccount;
    }

    public String getRemitByHeadTeller()
    {
	return remitByHeadTeller;
    }

    public void setRemitByHeadTeller(String remitByHeadTeller)
    {
	this.remitByHeadTeller = remitByHeadTeller;
    }

    public BigDecimal getHeadTeller()
    {
	return headTeller;
    }

    public void setHeadTeller(BigDecimal headTeller)
    {
	this.headTeller = headTeller;
    }

    public BigDecimal getMinSeqNo()
    {
	return minSeqNo;
    }

    public void setMinSeqNo(BigDecimal minSeqNo)
    {
	this.minSeqNo = minSeqNo;
    }

    public String getStOrder()
    {
	return stOrder;
    }

    public void setStOrder(String stOrder)
    {
	this.stOrder = stOrder;
    }

    public BigDecimal getMicrCodeline()
    {
	return micrCodeline;
    }

    public void setMicrCodeline(BigDecimal micrCodeline)
    {
	this.micrCodeline = micrCodeline;
    }

    public String getTrxDefaultAcc()
    {
	return trxDefaultAcc;
    }

    public void setTrxDefaultAcc(String trxDefaultAcc)
    {
	this.trxDefaultAcc = trxDefaultAcc;
    }

    public String getTotalAccount()
    {
	return totalAccount;
    }

    public void setTotalAccount(String totalAccount)
    {
	this.totalAccount = totalAccount;
    }

    public String getWarningMessages()
    {
	return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
	this.warningMessages = warningMessages;
    }

    /**
     * @return the showTodayTrx
     */
    public String getShowTodayTrx()
    {
	return showTodayTrx;
    }

    /**
     * @param showTodayTrx the showTodayTrx to set
     */
    public void setShowTodayTrx(String showTodayTrx)
    {
	this.showTodayTrx = showTodayTrx;
    }

    /**
     * @return the showAllTrx
     */
    public String getShowAllTrx()
    {
	return showAllTrx;
    }

    /**
     * @param showAllTrx the showAllTrx to set
     */
    public void setShowAllTrx(String showAllTrx)
    {
	this.showAllTrx = showAllTrx;
    }

    /**
     * @return the lsLinkToOtrTrx
     */
    public String getLsLinkToOtrTrx()
    {
	return lsLinkToOtrTrx;
    }

    /**
     * @param lsLinkToOtrTrx the lsLinkToOtrTrx to set
     */
    public void setLsLinkToOtrTrx(String lsLinkToOtrTrx)
    {
	this.lsLinkToOtrTrx = lsLinkToOtrTrx;
    }

    public BigDecimal getTrsTime()
    {
	return trsTime;
    }

    public void setTrsTime(BigDecimal trsTime)
    {
	this.trsTime = trsTime;
    }

    public BigDecimal getCloseTime()
    {
	return closeTime;
    }

    public void setCloseTime(BigDecimal closeTime)
    {
	this.closeTime = closeTime;
    }

    public String getCash()
    {
	return cash;
    }

    public void setCash(String cash)
    {
	this.cash = cash;
    }

    public BigDecimal getAcFromCyUnits()
    {
	return acFromCyUnits;
    }

    public void setAcFromCyUnits(BigDecimal acFromCyUnits)
    {
	this.acFromCyUnits = acFromCyUnits;
    }

    public String getAcFromCyMultiDiv()
    {
	return acFromCyMultiDiv;
    }

    public void setAcFromCyMultiDiv(String acFromCyMultiDiv)
    {
	this.acFromCyMultiDiv = acFromCyMultiDiv;
    }

    public BigDecimal getAcToCyUnits()
    {
	return acToCyUnits;
    }

    public void setAcToCyUnits(BigDecimal acToCyUnits)
    {
	this.acToCyUnits = acToCyUnits;
    }

    public String getAcToCyMultiDiv()
    {
	return acToCyMultiDiv;
    }

    public void setAcToCyMultiDiv(String acToCyMultiDiv)
    {
	this.acToCyMultiDiv = acToCyMultiDiv;
    }

    public BigDecimal getDecimalPoints()
    {
	return decimalPoints;
    }

    public void setDecimalPoints(BigDecimal decimalPoints)
    {
	this.decimalPoints = decimalPoints;
    }

    public Date getFirstPeriod()
    {
	return firstPeriod;
    }

    public void setFirstPeriod(Date firstPeriod)
    {
	this.firstPeriod = firstPeriod;
    }

    public Date getLastPeriod()
    {
	return lastPeriod;
    }

    public void setLastPeriod(Date lastPeriod)
    {
	this.lastPeriod = lastPeriod;
    }

    public String getTrends()
    {
	return trends;
    }

    public void setTrends(String trends)
    {
	this.trends = trends;
    }

    public Date getOpenDate()
    {
	return openDate;
    }

    public void setOpenDate(Date openDate)
    {
	this.openDate = openDate;
    }

    /**
     * @return the maintainHijiriDate
     */
    public int getMaintainHijiriDate()
    {
	return maintainHijiriDate;
    }

    /**
     * @param maintainHijiriDate the maintainHijiriDate to set
     */
    public void setMaintainHijiriDate(int maintainHijiriDate)
    {
	this.maintainHijiriDate = maintainHijiriDate;
    }

    public String getChqRelated()
    {
	return chqRelated;
    }

    public void setChqRelated(String chqRelated)
    {
	this.chqRelated = chqRelated;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public String gethCVDateBasedOnCy()
    {
	return hCVDateBasedOnCy;
    }

    public void sethCVDateBasedOnCy(String hCVDateBasedOnCy)
    {
	this.hCVDateBasedOnCy = hCVDateBasedOnCy;
    }

    public BigDecimal gethCVDateDaysNo()
    {
	return hCVDateDaysNo;
    }

    public void sethCVDateDaysNo(BigDecimal hCVDateDaysNo)
    {
	this.hCVDateDaysNo = hCVDateDaysNo;
    }

    public String getcCVDateBasedOn()
    {
	return cCVDateBasedOn;
    }

    public void setcCVDateBasedOn(String cCVDateBasedOn)
    {
	this.cCVDateBasedOn = cCVDateBasedOn;
    }

    public BigDecimal getcCVDateDaysOn()
    {
	return cCVDateDaysOn;
    }

    public void setcCVDateDaysOn(BigDecimal cCVDateDaysOn)
    {
	this.cCVDateDaysOn = cCVDateDaysOn;
    }

    public BigDecimal getChqClear()
    {
	return chqClear;
    }

    public void setChqClear(BigDecimal chqClear)
    {
	this.chqClear = chqClear;
    }

    public String getCheckClosingTime()
    {
	return checkClosingTime;
    }

    public void setCheckClosingTime(String checkClosingTime)
    {
	this.checkClosingTime = checkClosingTime;
    }

    public String getHolFlag()
    {
	return holFlag;
    }

    public void setHolFlag(String holFlag)
    {
	this.holFlag = holFlag;
    }

    public String getGmiFlag()
    {
	return gmiFlag;
    }

    public void setGmiFlag(String gmiFlag)
    {
	this.gmiFlag = gmiFlag;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public String getSendSwift()
    {
	return sendSwift;
    }

    public void setSendSwift(String sendSwift)
    {
	this.sendSwift = sendSwift;
    }

    public String getTypeOrigin()
    {
	return typeOrigin;
    }

    public void setTypeOrigin(String typeOrigin)
    {
	this.typeOrigin = typeOrigin;
    }

    public String getReplaceChqDate()
    {
	return replaceChqDate;
    }

    public void setReplaceChqDate(String replaceChqDate)
    {
	this.replaceChqDate = replaceChqDate;
    }

    public BigDecimal getHofDays()
    {
	return hofDays;
    }

    public void setHofDays(BigDecimal hofDays)
    {
	this.hofDays = hofDays;
    }

    public Date getReleaseDate()
    {
	return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
	this.releaseDate = releaseDate;
    }

    public Date getTrsDateHijri()
    {
	return trsDateHijri;
    }

    public void setTrsDateHijri(Date trsDateHijri)
    {
	this.trsDateHijri = trsDateHijri;
    }

    public String getvDateType()
    {
	return vDateType;
    }

    public void setvDateType(String vDateType)
    {
	this.vDateType = vDateType;
    }

    public BigDecimal getMaintainHijri()
    {
	return maintainHijri;
    }

    public void setMaintainHijri(BigDecimal maintainHijri)
    {
	this.maintainHijri = maintainHijri;
    }

    public String getRemittanceChanged()
    {
	return remittanceChanged;
    }

    public void setRemittanceChanged(String remittanceChanged)
    {
	this.remittanceChanged = remittanceChanged;
    }

    public int getIsTC()
    {
	return isTC;
    }

    public void setIsTC(int isTC)
    {
	this.isTC = isTC;
    }

    public String getAllowProceed()
    {
	return allowProceed;
    }

    public void setAllowProceed(String allowProceed)
    {
	this.allowProceed = allowProceed;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public BigDecimal getTrsAcAmount()
    {
	return trsAcAmount;
    }

    public void setTrsAcAmount(BigDecimal trsAcAmount)
    {
	this.trsAcAmount = trsAcAmount;
    }

    public String getCashDeductInd()
    {
	return cashDeductInd;
    }

    public void setCashDeductInd(String cashDeductInd)
    {
	this.cashDeductInd = cashDeductInd;
    }

    public String getSelectedAcc()
    {
	return selectedAcc;
    }

    public void setSelectedAcc(String selectedAcc)
    {
	this.selectedAcc = selectedAcc;
    }

    public String getBlockActiveWith()
    {
	return blockActiveWith;
    }

    public void setBlockActiveWith(String blockActiveWith)
    {
	this.blockActiveWith = blockActiveWith;
    }

    public String getAlertStatus()
    {
	return alertStatus;
    }

    public void setAlertStatus(String alertStatus)
    {
	this.alertStatus = alertStatus;
    }

    public BigDecimal getOldFromRemit()
    {
	return oldFromRemit;
    }

    public void setOldFromRemit(BigDecimal oldFromRemit)
    {
	this.oldFromRemit = oldFromRemit;
    }

    public BigDecimal getOldToRemit()
    {
	return oldToRemit;
    }

    public void setOldToRemit(BigDecimal oldToRemit)
    {
	this.oldToRemit = oldToRemit;
    }

    public BigDecimal getTcLineNumber()
    {
	return tcLineNumber;
    }

    public void setTcLineNumber(BigDecimal tcLineNumber)
    {
	this.tcLineNumber = tcLineNumber;
    }

    public BigDecimal getLinkToTrsNoBr()
    {
	return linkToTrsNoBr;
    }

    public void setLinkToTrsNoBr(BigDecimal linkToTrsNoBr)
    {
	this.linkToTrsNoBr = linkToTrsNoBr;
    }

    public String getInstructions1()
    {
	return instructions1;
    }

    public void setInstructions1(String instructions1)
    {
	this.instructions1 = instructions1;
    }

    /**
     * @return the lsTrxSts
     */
    public String getLsTrxSts()
    {
	return lsTrxSts;
    }

    /**
     * @param lsTrxSts the lsTrxSts to set
     */
    public void setLsTrxSts(String lsTrxSts)
    {
	this.lsTrxSts = lsTrxSts;
    }

    /**
     * @return the fromRetrieve
     */
    public boolean isFromRetrieve()
    {
	return fromRetrieve;
    }

    /**
     * @param fromRetrieve the fromRetrieve to set
     */
    public void setFromRetrieve(boolean fromRetrieve)
    {
	this.fromRetrieve = fromRetrieve;
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

    public String getLimitType()
    {
	return limitType;
    }

    public void setLimitType(String limitType)
    {
	this.limitType = limitType;
    }

    public String getRecalculateCyDenom()
    {
	return recalculateCyDenom;
    }

    public void setRecalculateCyDenom(String recalculateCyDenom)
    {
	this.recalculateCyDenom = recalculateCyDenom;
    }

    public String getOperation()
    {
	return operation;
    }

    public void setOperation(String operation)
    {
	this.operation = operation;
    }

    public String getTrxMgntChargesGridUpdate()
    {
	return trxMgntChargesGridUpdate;
    }

    public void setTrxMgntChargesGridUpdate(String trxMgntChargesGridUpdate)
    {
	this.trxMgntChargesGridUpdate = trxMgntChargesGridUpdate;
    }

    public BigDecimal getChAcCif()
    {
	return chAcCif;
    }

    public void setChAcCif(BigDecimal chAcCif)
    {
	this.chAcCif = chAcCif;
    }

    public BigDecimal getExchangeRate()
    {
	return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate)
    {
	this.exchangeRate = exchangeRate;
    }

    public BigDecimal getCashInCurrencyCode()
    {
	return cashInCurrencyCode;
    }

    public void setCashInCurrencyCode(BigDecimal cashInCurrencyCode)
    {
	this.cashInCurrencyCode = cashInCurrencyCode;
    }

    public BigDecimal getCashInAmount()
    {
	return cashInAmount;
    }

    public void setCashInAmount(BigDecimal cashInAmount)
    {
	this.cashInAmount = cashInAmount;
    }

    public BigDecimal getCashInAccBr()
    {
	return cashInAccBr;
    }

    public void setCashInAccBr(BigDecimal cashInAccBr)
    {
	this.cashInAccBr = cashInAccBr;
    }

    public BigDecimal getCashInAccCy()
    {
	return cashInAccCy;
    }

    public void setCashInAccCy(BigDecimal cashInAccCy)
    {
	this.cashInAccCy = cashInAccCy;
    }

    public BigDecimal getCashInAccGl()
    {
	return cashInAccGl;
    }

    public void setCashInAccGl(BigDecimal cashInAccGl)
    {
	this.cashInAccGl = cashInAccGl;
    }

    public BigDecimal getCashInAccCif()
    {
	return cashInAccCif;
    }

    public void setCashInAccCif(BigDecimal cashInAccCif)
    {
	this.cashInAccCif = cashInAccCif;
    }

    public BigDecimal getCashOutCurrencyCode()
    {
	return cashOutCurrencyCode;
    }

    public void setCashOutCurrencyCode(BigDecimal cashOutCurrencyCode)
    {
	this.cashOutCurrencyCode = cashOutCurrencyCode;
    }

    public BigDecimal getCashOutAmount()
    {
	return cashOutAmount;
    }

    public void setCashOutAmount(BigDecimal cashOutAmount)
    {
	this.cashOutAmount = cashOutAmount;
    }

    public BigDecimal getCashOutAccBr()
    {
	return cashOutAccBr;
    }

    public void setCashOutAccBr(BigDecimal cashOutAccBr)
    {
	this.cashOutAccBr = cashOutAccBr;
    }

    public BigDecimal getCashOutAccCy()
    {
	return cashOutAccCy;
    }

    public void setCashOutAccCy(BigDecimal cashOutAccCy)
    {
	this.cashOutAccCy = cashOutAccCy;
    }

    public BigDecimal getCashOutAccGl()
    {
	return cashOutAccGl;
    }

    public void setCashOutAccGl(BigDecimal cashOutAccGl)
    {
	this.cashOutAccGl = cashOutAccGl;
    }

    public BigDecimal getCashOutAccCif()
    {
	return cashOutAccCif;
    }

    public void setCashOutAccCif(BigDecimal cashOutAccCif)
    {
	this.cashOutAccCif = cashOutAccCif;
    }

    public String getCyExchChargesGridUpdate()
    {
	return cyExchChargesGridUpdate;
    }

    public void setCyExchChargesGridUpdate(String cyExchChargesGridUpdate)
    {
	this.cyExchChargesGridUpdate = cyExchChargesGridUpdate;
    }

    public String getTerminalID()
    {
	return terminalID;
    }

    public void setTerminalID(String terminalID)
    {
	this.terminalID = terminalID;
    }

    public BigDecimal getInitLine()
    {
	return initLine;
    }

    public void setInitLine(BigDecimal initLine)
    {
	this.initLine = initLine;
    }

    public String getBranchesIn()
    {
	return branchesIn;
    }

    public void setBranchesIn(String branchesIn)
    {
	this.branchesIn = branchesIn;
    }

    public String getManualJV()
    {
	return manualJV;
    }

    public void setManualJV(String manualJV)
    {
	this.manualJV = manualJV;
    }

    public BigDecimal getOpNo()
    {
	return opNo;
    }

    public void setOpNo(BigDecimal opNo)
    {
	this.opNo = opNo;
    }

    public String getBranchesOut()
    {
	return branchesOut;
    }

    public void setBranchesOut(String branchesOut)
    {
	this.branchesOut = branchesOut;
    }

    public String getEntriesLevel()
    {
	return entriesLevel;
    }

    public void setEntriesLevel(String entriesLevel)
    {
	this.entriesLevel = entriesLevel;
    }

    public String getAmfAlertStatus()
    {
	return amfAlertStatus;
    }

    public void setAmfAlertStatus(String amfAlertStatus)
    {
	this.amfAlertStatus = amfAlertStatus;
    }

    public String getReverseCharges()
    {
	return reverseCharges;
    }

    public void setReverseCharges(String reverseCharges)
    {
	this.reverseCharges = reverseCharges;
    }

    public String getDofTrxType()
    {
	return dofTrxType;
    }

    public void setDofTrxType(String dofTrxType)
    {
	this.dofTrxType = dofTrxType;
    }

    public BigDecimal getChargeSchema()
    {
	return chargeSchema;
    }

    public void setChargeSchema(BigDecimal chargeSchema)
    {
	this.chargeSchema = chargeSchema;
    }

    public BigDecimal getAddNum()
    {
	return addNum;
    }

    public void setAddNum(BigDecimal addNum)
    {
	this.addNum = addNum;
    }

    public String getAddString()
    {
	return addString;
    }

    public void setAddString(String addString)
    {
	this.addString = addString;
    }

    public Date getAddDate()
    {
	return addDate;
    }

    public void setAddDate(Date addDate)
    {
	this.addDate = addDate;
    }

    /**
     * @return the charges
     */
    public BigDecimal getCharges()
    {
	return charges;
    }

    /**
     * @param charges the charges to set
     */
    public void setCharges(BigDecimal charges)
    {
	this.charges = charges;
    }

    public Date getValueDateHijri()
    {
	return valueDateHijri;
    }

    public void setValueDateHijri(Date valueDateHijri)
    {
	this.valueDateHijri = valueDateHijri;
    }

    public String getHofReason()
    {
	return hofReason;
    }

    public void setHofReason(String hofReason)
    {
	this.hofReason = hofReason;
    }

    public BigDecimal getReleaseDays()
    {
	return releaseDays;
    }

    public void setReleaseDays(BigDecimal releaseDays)
    {
	this.releaseDays = releaseDays;
    }

    /**
     * @return the irisCifNo
     */
    public BigDecimal getIrisCifNo()
    {
	return irisCifNo;
    }

    /**
     * @param irisCifNo the irisCifNo to set
     */
    public void setIrisCifNo(BigDecimal irisCifNo)
    {
	this.irisCifNo = irisCifNo;
    }

    public BigDecimal getJvNo()
    {
	return jvNo;
    }

    public void setJvNo(BigDecimal jvNo)
    {
	this.jvNo = jvNo;
    }

    public String getMultiTrx()
    {
	return multiTrx;
    }

    public void setMultiTrx(String multiTrx)
    {
	this.multiTrx = multiTrx;
    }

    public String getIsSO()
    {
	return isSO;
    }

    public void setIsSO(String isSO)
    {
	this.isSO = isSO;
    }

    public String getOnOffBs()
    {
	return onOffBs;
    }

    public void setOnOffBs(String onOffBs)
    {
	this.onOffBs = onOffBs;
    }

    public String getChargesEntries()
    {
	return chargesEntries;
    }

    public void setChargesEntries(String chargesEntries)
    {
	this.chargesEntries = chargesEntries;
    }

    public BigDecimal getChAcGl()
    {
	return chAcGl;
    }

    public void setChAcGl(BigDecimal chAcGl)
    {
	this.chAcGl = chAcGl;
    }

    public List<BigDecimal> getCountryList()
    {
	return countryList;
    }

    public void setCountryList(List<BigDecimal> countryList)
    {
	this.countryList = countryList;
    }

    /**
     * @return the chargesCodeLst
     */
    public String getChargesCodeLst()
    {
	return chargesCodeLst;
    }

    /**
     * @param chargesCodeLst the chargesCodeLst to set
     */
    public void setChargesCodeLst(String chargesCodeLst)
    {
	this.chargesCodeLst = chargesCodeLst;
    }

    public BigDecimal getChAcBr()
    {
	return chAcBr;
    }

    public void setChAcBr(BigDecimal chAcBr)
    {
	this.chAcBr = chAcBr;
    }

    /**
     * @return the fromAmendSO
     */
    public String getFromAmendSO()
    {
	return fromAmendSO;
    }

    /**
     * @param fromAmendSO the fromAmendSO to set
     */
    public void setFromAmendSO(String fromAmendSO)
    {
	this.fromAmendSO = fromAmendSO;
    }

    public BigDecimal getRelatedGl()
    {
	return relatedGl;
    }

    public BigDecimal getPROFIT_GROUP()
    {
	return PROFIT_GROUP;
    }

    public BigDecimal getDISTRIBUTED_PROFIT_CV()
    {
	return DISTRIBUTED_PROFIT_CV;
    }

    public BigDecimal getDISTRIBUTED_PROFIT_FC()
    {
	return DISTRIBUTED_PROFIT_FC;
    }

    public BigDecimal getNON_DISTRIBUTED_PROFIT_CV()
    {
	return NON_DISTRIBUTED_PROFIT_CV;
    }

    public BigDecimal getNON_DISTRIBUTED_PROFIT_FC()
    {
	return NON_DISTRIBUTED_PROFIT_FC;
    }

    public BigDecimal getTHIS_MONTH_PROFIT_CV()
    {
	return THIS_MONTH_PROFIT_CV;
    }

    public BigDecimal getTHIS_MONTH_PROFIT_FC()
    {
	return THIS_MONTH_PROFIT_FC;
    }

    public BigDecimal getDISTRIBUTED_PROFIT_RECALC_CV()
    {
	return DISTRIBUTED_PROFIT_RECALC_CV;
    }

    public BigDecimal getDISTRIBUTED_PROFIT_RECALC_FC()
    {
	return DISTRIBUTED_PROFIT_RECALC_FC;
    }

    public BigDecimal getNON_DISTR_PROFIT_RECALC_CV()
    {
	return NON_DISTR_PROFIT_RECALC_CV;
    }

    public BigDecimal getNON_DISTR_PROFIT_RECALC_FC()
    {
	return NON_DISTR_PROFIT_RECALC_FC;
    }

    public BigDecimal getTHIS_MONTH_PROFIT_RECALC_CV()
    {
	return THIS_MONTH_PROFIT_RECALC_CV;
    }

    public BigDecimal getTHIS_MONTH_PROFIT_RECALC_FC()
    {
	return THIS_MONTH_PROFIT_RECALC_FC;
    }

    public BigDecimal getCURRENT_PROFIT_CV()
    {
	return CURRENT_PROFIT_CV;
    }

    public BigDecimal getCURRENT_PROFIT_FC()
    {
	return CURRENT_PROFIT_FC;
    }

    public BigDecimal getTAX_CV()
    {
	return TAX_CV;
    }

    public BigDecimal getTAX_FC()
    {
	return TAX_FC;
    }

    public BigDecimal getCHARGES_CV()
    {
	return CHARGES_CV;
    }

    public BigDecimal getCHARGES_FC()
    {
	return CHARGES_FC;
    }

    public BigDecimal getPENALTY_CV()
    {
	return PENALTY_CV;
    }

    public BigDecimal getPENALTY_FC()
    {
	return PENALTY_FC;
    }

    public BigDecimal getZakatCV()
    {
	return zakatCV;
    }

    public BigDecimal getZakatFC()
    {
	return zakatFC;
    }

    public BigDecimal getZakatChgCV()
    {
	return zakatChgCV;
    }

    public BigDecimal getZakatChgFC()
    {
	return zakatChgFC;
    }

    public BigDecimal getOLD_PROFIT_RATE()
    {
	return OLD_PROFIT_RATE;
    }

    public String getFullBreakDeposit()
    {
	return fullBreakDeposit;
    }

    public String getExcludePcsDistribution()
    {
	return excludePcsDistribution;
    }

    public BigDecimal getAdecAdvFC()
    {
	return adecAdvFC;
    }

    public BigDecimal getAdecAdvCv()
    {
	return adecAdvCv;
    }

    public BigDecimal getAdecAccrualCv()
    {
	return adecAccrualCv;
    }

    public BigDecimal getAdecAccrualFc()
    {
	return adecAccrualFc;
    }

    public BigDecimal getAdecBal()
    {
	return adecBal;
    }

    public BigDecimal getAdecProfit()
    {
	return adecProfit;
    }

    public BigDecimal getAdecPenalty()
    {
	return adecPenalty;
    }

    public BigDecimal getAdecNetProfit()
    {
	return adecNetProfit;
    }

    public String getAsOverPenalty()
    {
	return asOverPenalty;
    }

    public BigDecimal getPRFT_CY()
    {
	return PRFT_CY;
    }

    public BigDecimal getPRFT_GL()
    {
	return PRFT_GL;
    }

    public BigDecimal getPRFT_CIF()
    {
	return PRFT_CIF;
    }

    public BigDecimal getPRFT_SL()
    {
	return PRFT_SL;
    }

    public BigDecimal getPENALTY_GL()
    {
	return PENALTY_GL;
    }

    public BigDecimal getPENALTY_CIF()
    {
	return PENALTY_CIF;
    }

    public BigDecimal getPENALTY_SL()
    {
	return PENALTY_SL;
    }

    public BigDecimal getACCR_GL()
    {
	return ACCR_GL;
    }

    public BigDecimal getACCR_CIF()
    {
	return ACCR_CIF;
    }

    public BigDecimal getACCR_SL()
    {
	return ACCR_SL;
    }

    public void setRelatedGl(BigDecimal relatedGl)
    {
	this.relatedGl = relatedGl;
    }

    public void setPROFIT_GROUP(BigDecimal pROFITGROUP)
    {
	PROFIT_GROUP = pROFITGROUP;
    }

    public void setDISTRIBUTED_PROFIT_CV(BigDecimal dISTRIBUTEDPROFITCV)
    {
	DISTRIBUTED_PROFIT_CV = dISTRIBUTEDPROFITCV;
    }

    public void setDISTRIBUTED_PROFIT_FC(BigDecimal dISTRIBUTEDPROFITFC)
    {
	DISTRIBUTED_PROFIT_FC = dISTRIBUTEDPROFITFC;
    }

    public void setNON_DISTRIBUTED_PROFIT_CV(BigDecimal nONDISTRIBUTEDPROFITCV)
    {
	NON_DISTRIBUTED_PROFIT_CV = nONDISTRIBUTEDPROFITCV;
    }

    public void setNON_DISTRIBUTED_PROFIT_FC(BigDecimal nONDISTRIBUTEDPROFITFC)
    {
	NON_DISTRIBUTED_PROFIT_FC = nONDISTRIBUTEDPROFITFC;
    }

    public void setTHIS_MONTH_PROFIT_CV(BigDecimal tHISMONTHPROFITCV)
    {
	THIS_MONTH_PROFIT_CV = tHISMONTHPROFITCV;
    }

    public void setTHIS_MONTH_PROFIT_FC(BigDecimal tHISMONTHPROFITFC)
    {
	THIS_MONTH_PROFIT_FC = tHISMONTHPROFITFC;
    }

    public void setDISTRIBUTED_PROFIT_RECALC_CV(BigDecimal dISTRIBUTEDPROFITRECALCCV)
    {
	DISTRIBUTED_PROFIT_RECALC_CV = dISTRIBUTEDPROFITRECALCCV;
    }

    public void setDISTRIBUTED_PROFIT_RECALC_FC(BigDecimal dISTRIBUTEDPROFITRECALCFC)
    {
	DISTRIBUTED_PROFIT_RECALC_FC = dISTRIBUTEDPROFITRECALCFC;
    }

    public void setNON_DISTR_PROFIT_RECALC_CV(BigDecimal nONDISTRPROFITRECALCCV)
    {
	NON_DISTR_PROFIT_RECALC_CV = nONDISTRPROFITRECALCCV;
    }

    public void setNON_DISTR_PROFIT_RECALC_FC(BigDecimal nONDISTRPROFITRECALCFC)
    {
	NON_DISTR_PROFIT_RECALC_FC = nONDISTRPROFITRECALCFC;
    }

    public void setTHIS_MONTH_PROFIT_RECALC_CV(BigDecimal tHISMONTHPROFITRECALCCV)
    {
	THIS_MONTH_PROFIT_RECALC_CV = tHISMONTHPROFITRECALCCV;
    }

    public void setTHIS_MONTH_PROFIT_RECALC_FC(BigDecimal tHISMONTHPROFITRECALCFC)
    {
	THIS_MONTH_PROFIT_RECALC_FC = tHISMONTHPROFITRECALCFC;
    }

    public void setCURRENT_PROFIT_CV(BigDecimal cURRENTPROFITCV)
    {
	CURRENT_PROFIT_CV = cURRENTPROFITCV;
    }

    public void setCURRENT_PROFIT_FC(BigDecimal cURRENTPROFITFC)
    {
	CURRENT_PROFIT_FC = cURRENTPROFITFC;
    }

    public void setTAX_CV(BigDecimal tAXCV)
    {
	TAX_CV = tAXCV;
    }

    public void setTAX_FC(BigDecimal tAXFC)
    {
	TAX_FC = tAXFC;
    }

    public void setCHARGES_CV(BigDecimal cHARGESCV)
    {
	CHARGES_CV = cHARGESCV;
    }

    public void setCHARGES_FC(BigDecimal cHARGESFC)
    {
	CHARGES_FC = cHARGESFC;
    }

    public void setPENALTY_CV(BigDecimal pENALTYCV)
    {
	PENALTY_CV = pENALTYCV;
    }

    public void setPENALTY_FC(BigDecimal pENALTYFC)
    {
	PENALTY_FC = pENALTYFC;
    }

    public void setZakatCV(BigDecimal zakatCV)
    {
	this.zakatCV = zakatCV;
    }

    public void setZakatFC(BigDecimal zakatFC)
    {
	this.zakatFC = zakatFC;
    }

    public void setZakatChgCV(BigDecimal zakatChgCV)
    {
	this.zakatChgCV = zakatChgCV;
    }

    public void setZakatChgFC(BigDecimal zakatChgFC)
    {
	this.zakatChgFC = zakatChgFC;
    }

    public void setOLD_PROFIT_RATE(BigDecimal oLDPROFITRATE)
    {
	OLD_PROFIT_RATE = oLDPROFITRATE;
    }

    public void setFullBreakDeposit(String fullBreakDeposit)
    {
	this.fullBreakDeposit = fullBreakDeposit;
    }

    public void setExcludePcsDistribution(String excludePcsDistribution)
    {
	this.excludePcsDistribution = excludePcsDistribution;
    }

    public void setAdecAdvFC(BigDecimal adecAdvFC)
    {
	this.adecAdvFC = adecAdvFC;
    }

    public void setAdecAdvCv(BigDecimal adecAdvCv)
    {
	this.adecAdvCv = adecAdvCv;
    }

    public void setAdecAccrualCv(BigDecimal adecAccrualCv)
    {
	this.adecAccrualCv = adecAccrualCv;
    }

    public void setAdecAccrualFc(BigDecimal adecAccrualFc)
    {
	this.adecAccrualFc = adecAccrualFc;
    }

    public void setAdecBal(BigDecimal adecBal)
    {
	this.adecBal = adecBal;
    }

    public void setAdecProfit(BigDecimal adecProfit)
    {
	this.adecProfit = adecProfit;
    }

    public void setAdecPenalty(BigDecimal adecPenalty)
    {
	this.adecPenalty = adecPenalty;
    }

    public void setAdecNetProfit(BigDecimal adecNetProfit)
    {
	this.adecNetProfit = adecNetProfit;
    }

    public void setAsOverPenalty(String asOverPenalty)
    {
	this.asOverPenalty = asOverPenalty;
    }

    public void setPRFT_CY(BigDecimal pRFTCY)
    {
	PRFT_CY = pRFTCY;
    }

    public void setPRFT_GL(BigDecimal pRFTGL)
    {
	PRFT_GL = pRFTGL;
    }

    public void setPRFT_CIF(BigDecimal pRFTCIF)
    {
	PRFT_CIF = pRFTCIF;
    }

    public void setPRFT_SL(BigDecimal pRFTSL)
    {
	PRFT_SL = pRFTSL;
    }

    public void setPENALTY_GL(BigDecimal pENALTYGL)
    {
	PENALTY_GL = pENALTYGL;
    }

    public void setPENALTY_CIF(BigDecimal pENALTYCIF)
    {
	PENALTY_CIF = pENALTYCIF;
    }

    public void setPENALTY_SL(BigDecimal pENALTYSL)
    {
	PENALTY_SL = pENALTYSL;
    }

    public void setACCR_GL(BigDecimal aCCRGL)
    {
	ACCR_GL = aCCRGL;
    }

    public void setACCR_CIF(BigDecimal aCCRCIF)
    {
	ACCR_CIF = aCCRCIF;
    }

    public void setACCR_SL(BigDecimal aCCRSL)
    {
	ACCR_SL = aCCRSL;
    }

    /**
     * @return the contProcess
     */
    public String getContProcess()
    {
	return contProcess;
    }

    /**
     * @param contProcess the contProcess to set
     */
    public void setContProcess(String contProcess)
    {
	this.contProcess = contProcess;
    }

    /**
     * @return the currStatus
     */
    public String getCurrStatus()
    {
	return currStatus;
    }

    /**
     * @param currStatus the currStatus to set
     */
    public void setCurrStatus(String currStatus)
    {
	this.currStatus = currStatus;
    }

    public String getIsAppliedPenalty()
    {
	return isAppliedPenalty;
    }

    public BigDecimal getProfitReverseFc()
    {
	return profitReverseFc;
    }

    public BigDecimal getProfitReverseCv()
    {
	return profitReverseCv;
    }

    public BigDecimal getTcrFcAmount()
    {
	return tcrFcAmount;
    }

    public BigDecimal getTvaAmount()
    {
	return tvaAmount;
    }

    public void setIsAppliedPenalty(String isAppliedPenalty)
    {
	this.isAppliedPenalty = isAppliedPenalty;
    }

    public void setProfitReverseFc(BigDecimal profitReverseFc)
    {
	this.profitReverseFc = profitReverseFc;
    }

    public void setProfitReverseCv(BigDecimal profitReverseCv)
    {
	this.profitReverseCv = profitReverseCv;
    }

    public void setTcrFcAmount(BigDecimal tcrFcAmount)
    {
	this.tcrFcAmount = tcrFcAmount;
    }

    public void setTvaAmount(BigDecimal tvaAmount)
    {
	this.tvaAmount = tvaAmount;
    }

    public String getLinkToOtherTrxProceed()
    {
	return linkToOtherTrxProceed;
    }

    public void setLinkToOtherTrxProceed(String linkToOtherTrxProceed)
    {
	this.linkToOtherTrxProceed = linkToOtherTrxProceed;
    }

    public String getIstaxincluded()
    {
	return istaxincluded;
    }

    public String getIsenabletcr()
    {
	return isenabletcr;
    }

    public String getIsapplytrcrate()
    {
	return isapplytrcrate;
    }

    public BigDecimal getIdectvarate()
    {
	return idectvarate;
    }

    public BigDecimal getIdectrcrate()
    {
	return idectrcrate;
    }

    public BigDecimal getGV_FISCAL_YEAR()
    {
	return GV_FISCAL_YEAR;
    }

    public void setIstaxincluded(String istaxincluded)
    {
	this.istaxincluded = istaxincluded;
    }

    public void setIsenabletcr(String isenabletcr)
    {
	this.isenabletcr = isenabletcr;
    }

    public void setIsapplytrcrate(String isapplytrcrate)
    {
	this.isapplytrcrate = isapplytrcrate;
    }

    public void setIdectvarate(BigDecimal idectvarate)
    {
	this.idectvarate = idectvarate;
    }

    public void setIdectrcrate(BigDecimal idectrcrate)
    {
	this.idectrcrate = idectrcrate;
    }

    public void setGV_FISCAL_YEAR(BigDecimal gVFISCALYEAR)
    {
	GV_FISCAL_YEAR = gVFISCALYEAR;
    }

    public BigDecimal getADEC_PROFIT_CV()
    {
	return ADEC_PROFIT_CV;
    }

    public BigDecimal getADEC_PROFIT_FC()
    {
	return ADEC_PROFIT_FC;
    }

    public BigDecimal getAL_PROFIT_GROUP()
    {
	return AL_PROFIT_GROUP;
    }

    public String getAS_APPLY_PCS_CHARGES()
    {
	return AS_APPLY_PCS_CHARGES;
    }

    public BigDecimal getAL_UNIT()
    {
	return AL_UNIT;
    }

    public String getAC_MULTDIV()
    {
	return AC_MULTDIV;
    }

    public BigDecimal getAL_CY_DECIMALS()
    {
	return AL_CY_DECIMALS;
    }

    public BigDecimal getADEC_RATE()
    {
	return ADEC_RATE;
    }

    public String getAS_CHARGE_CURRENCY()
    {
	return AS_CHARGE_CURRENCY;
    }

    public void setADEC_PROFIT_CV(BigDecimal aDECPROFITCV)
    {
	ADEC_PROFIT_CV = aDECPROFITCV;
    }

    public void setADEC_PROFIT_FC(BigDecimal aDECPROFITFC)
    {
	ADEC_PROFIT_FC = aDECPROFITFC;
    }

    public void setAL_PROFIT_GROUP(BigDecimal aLPROFITGROUP)
    {
	AL_PROFIT_GROUP = aLPROFITGROUP;
    }

    public void setAS_APPLY_PCS_CHARGES(String aSAPPLYPCSCHARGES)
    {
	AS_APPLY_PCS_CHARGES = aSAPPLYPCSCHARGES;
    }

    public void setAL_UNIT(BigDecimal aLUNIT)
    {
	AL_UNIT = aLUNIT;
    }

    public void setAC_MULTDIV(String aCMULTDIV)
    {
	AC_MULTDIV = aCMULTDIV;
    }

    public void setAL_CY_DECIMALS(BigDecimal aLCYDECIMALS)
    {
	AL_CY_DECIMALS = aLCYDECIMALS;
    }

    public void setADEC_RATE(BigDecimal aDECRATE)
    {
	ADEC_RATE = aDECRATE;
    }

    public void setAS_CHARGE_CURRENCY(String aSCHARGECURRENCY)
    {
	AS_CHARGE_CURRENCY = aSCHARGECURRENCY;
    }

    public BigDecimal getToTrsNo()
    {
	return toTrsNo;
    }

    public void setToTrsNo(BigDecimal toTrsNo)
    {
	this.toTrsNo = toTrsNo;
    }

    public BigDecimal getFromTrsNo()
    {
	return fromTrsNo;
    }

    public void setFromTrsNo(BigDecimal fromTrsNo)
    {
	this.fromTrsNo = fromTrsNo;
    }

    public BigDecimal getCtrlAcCy()
    {
	return ctrlAcCy;
    }

    public void setCtrlAcCy(BigDecimal ctrlAcCy)
    {
	this.ctrlAcCy = ctrlAcCy;
    }

    public BigDecimal getCtrlAcGl()
    {
	return ctrlAcGl;
    }

    public void setCtrlAcGl(BigDecimal ctrlAcGl)
    {
	this.ctrlAcGl = ctrlAcGl;
    }

    public BigDecimal getCtrlAcCif()
    {
	return ctrlAcCif;
    }

    public void setCtrlAcCif(BigDecimal ctrlAcCif)
    {
	this.ctrlAcCif = ctrlAcCif;
    }

    public BigDecimal getCtrlAcSl()
    {
	return ctrlAcSl;
    }

    public void setCtrlAcSl(BigDecimal ctrlAcSl)
    {
	this.ctrlAcSl = ctrlAcSl;
    }

    public BigDecimal getChAcCy()
    {
	return chAcCy;
    }

    public void setChAcCy(BigDecimal chAcCy)
    {
	this.chAcCy = chAcCy;
    }

    public BigDecimal getChAcSl()
    {
	return chAcSl;
    }

    public void setChAcSl(BigDecimal chAcSl)
    {
	this.chAcSl = chAcSl;
    }

    public BigDecimal getAddAmt1()
    {
	return addAmt1;
    }

    public void setAddAmt1(BigDecimal addAmt1)
    {
	this.addAmt1 = addAmt1;
    }

    public BigDecimal getAddAmt2()
    {
	return addAmt2;
    }

    public void setAddAmt2(BigDecimal addAmt2)
    {
	this.addAmt2 = addAmt2;
    }

    public BigDecimal getAddAmt3()
    {
	return addAmt3;
    }

    public void setAddAmt3(BigDecimal addAmt3)
    {
	this.addAmt3 = addAmt3;
    }

    public BigDecimal getAddAmt4()
    {
	return addAmt4;
    }

    public void setAddAmt4(BigDecimal addAmt4)
    {
	this.addAmt4 = addAmt4;
    }

    public String getOs_s_string()
    {
	return os_s_string;
    }

    public void setOs_s_string(String osSString)
    {
	os_s_string = osSString;
    }

    public BigDecimal getOverDrawnAmount()
    {
	return overDrawnAmount;
    }

    public void setOverDrawnAmount(BigDecimal overDrawnAmount)
    {
	this.overDrawnAmount = overDrawnAmount;
    }

    /**
     * @return the windTrxType
     */
    public BigDecimal getWindTrxType()
    {
	return windTrxType;
    }

    /**
     * @param windTrxType the windTrxType to set
     */
    public void setWindTrxType(BigDecimal windTrxType)
    {
	this.windTrxType = windTrxType;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public BigDecimal getSaveCount()
    {
	return saveCount;
    }

    public void setSaveCount(BigDecimal saveCount)
    {
	this.saveCount = saveCount;
    }

    public BigDecimal getLoginBraCode()
    {
	return loginBraCode;
    }

    public void setLoginBraCode(BigDecimal loginBraCode)
    {
	this.loginBraCode = loginBraCode;
    }

    public BigDecimal getFirstCIFNo()
    {
	return firstCIFNo;
    }

    public void setFirstCIFNo(BigDecimal firstCIFNo)
    {
	this.firstCIFNo = firstCIFNo;
    }

    public String getChargesWaived()
    {
	return chargesWaived;
    }

    public void setChargesWaived(String chargesWaived)
    {
	this.chargesWaived = chargesWaived;
    }

    public String getLinkToOtherTrxLookup()
    {
	return linkToOtherTrxLookup;
    }

    public void setLinkToOtherTrxLookup(String linkToOtherTrxLookup)
    {
	this.linkToOtherTrxLookup = linkToOtherTrxLookup;
    }

    public String getRateFlag()
    {
	return rateFlag;
    }

    public void setRateFlag(String rateFlag)
    {
	this.rateFlag = rateFlag;
    }

    public BigDecimal getToCy()
    {
	return toCy;
    }

    public void setToCy(BigDecimal toCy)
    {
	this.toCy = toCy;
    }

    public String getPeriodicityType()
    {
	return periodicityType;
    }

    public void setPeriodicityType(String periodicityType)
    {
	this.periodicityType = periodicityType;
    }

    public String getIgnoreHolidaysForTrsDate()
    {
	return ignoreHolidaysForTrsDate;
    }

    public void setIgnoreHolidaysForTrsDate(String ignoreHolidaysForTrsDate)
    {
	this.ignoreHolidaysForTrsDate = ignoreHolidaysForTrsDate;
    }

    public String getMaskedCardNo()
    {
	return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
	this.maskedCardNo = maskedCardNo;
    }

    public boolean isFromClearingVoiding()
    {
	return fromClearingVoiding;
    }

    public void setFromClearingVoiding(boolean fromClearingVoiding)
    {
	this.fromClearingVoiding = fromClearingVoiding;
    }

    public BigDecimal getBatchBrCode()
    {
	return batchBrCode;
    }

    public BigDecimal getBatchNo()
    {
	return batchNo;
    }

    public BigDecimal getSerialNo()
    {
	return serialNo;
    }

    public void setBatchBrCode(BigDecimal batchBrCode)
    {
	this.batchBrCode = batchBrCode;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
	this.batchNo = batchNo;
    }

    public void setSerialNo(BigDecimal serialNo)
    {
	this.serialNo = serialNo;
    }

    public String getStaff()
    {
	return staff;
    }

    public void setStaff(String staff)
    {
	this.staff = staff;
    }

    public BigDecimal getSessionID()
    {
	return sessionID;
    }

    public void setSessionID(BigDecimal sessionID)
    {
	this.sessionID = sessionID;
    }

    public String getFromForceMatch()
    {
	return fromForceMatch;
    }

    public void setFromForceMatch(String fromForceMatch)
    {
	this.fromForceMatch = fromForceMatch;
    }

    public String getIs_tc_92()
    {
	return is_tc_92;
    }

    public void setIs_tc_92(String isTc_92)
    {
	is_tc_92 = isTc_92;
    }

    public String getIsUnifiedCharge()
    {
	return isUnifiedCharge;
    }

    public void setIsUnifiedCharge(String isUnifiedCharge)
    {
	this.isUnifiedCharge = isUnifiedCharge;
    }

  public BigDecimal getTemplateCode()
    {
        return templateCode;
    }

    public void setTemplateCode(BigDecimal templateCode)
    {
        this.templateCode = templateCode;
    }

    public String getEntryType()
    {
        return entryType;
    }

    public void setEntryType(String entryType)
    {
        this.entryType = entryType;
    }
    public BigDecimal getTotalDuesFCcharge()
    {
	return totalDuesFCcharge;
    }

    public void setTotalDuesFCcharge(BigDecimal totalDuesFCcharge)
    {
	this.totalDuesFCcharge = totalDuesFCcharge;
    }

    public BigDecimal getTotalDuesCVcharge()
    {
	return totalDuesCVcharge;
    }

    public void setTotalDuesCVcharge(BigDecimal totalDuesCVcharge)
    {
	this.totalDuesCVcharge = totalDuesCVcharge;
    }

    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
   
    public String getDuesInd()
    {
        return duesInd;
    }

    public void setDuesInd(String duesInd)
    {
        this.duesInd = duesInd;
    }

    public String getDuesCollectionType()
    {
        return duesCollectionType;
    }

    public void setDuesCollectionType(String duesCollectionType)
    {
        this.duesCollectionType = duesCollectionType;
    }

    public String getDuesSubOperation()
    {
        return duesSubOperation;
    }

    public void setDuesSubOperation(String duesSubOperation)
    {
        this.duesSubOperation = duesSubOperation;
    }

    public String getDuesPaymentMethod()
    {
        return duesPaymentMethod;
    }

    public void setDuesPaymentMethod(String duesPaymentMethod)
    {
        this.duesPaymentMethod = duesPaymentMethod;
    }

    public BigDecimal getDuesRemainingCharge()
    {
        return duesRemainingCharge;
    }

    public void setDuesRemainingCharge(BigDecimal duesRemainingCharge)
    {
        this.duesRemainingCharge = duesRemainingCharge;
    }

    public String getChargeBriefNameEng()
    {
        return chargeBriefNameEng;
    }

    public void setChargeBriefNameEng(String chargeBriefNameEng)
    {
        this.chargeBriefNameEng = chargeBriefNameEng;
    }

    public String getChargeBriefNameArab()
    {
        return chargeBriefNameArab;
    }

    public void setChargeBriefNameArab(String chargeBriefNameArab)
    {
        this.chargeBriefNameArab = chargeBriefNameArab;
    }

    public String getChargesEmpty()
    {
        return chargesEmpty;
    }

    public void setChargesEmpty(String chargesEmpty)
    {
        this.chargesEmpty = chargesEmpty;
    }

    public String getIbDeduct()
    {
        return ibDeduct;
    }

    public void setIbDeduct(String ibDeduct)
    {
        this.ibDeduct = ibDeduct;
    }

    public String getIbBatch()
    {
        return ibBatch;
    }

    public void setIbBatch(String ibBatch)
    {
        this.ibBatch = ibBatch;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getBankBicCode()
    {
        return bankBicCode;
    }

    public void setBankBicCode(String bankBicCode)
    {
        this.bankBicCode = bankBicCode;
    }

    public String getBicCode()
    {
        return bicCode;
    }

    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public String getChargeBranch()
    {
        return chargeBranch;
    }

    public void setChargeBranch(String chargeBranch)
    {
        this.chargeBranch = chargeBranch;
    }

    public BigDecimal getCifEcoSector()
    {
        return cifEcoSector;
    }

    public void setCifEcoSector(BigDecimal cifEcoSector)
    {
        this.cifEcoSector = cifEcoSector;
    }

    public BigDecimal getCifPriority()
    {
        return cifPriority;
    }

    public void setCifPriority(BigDecimal cifPriority)
    {
        this.cifPriority = cifPriority;
    }

    public String getAutoApprove()
    {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove)
    {
        this.autoApprove = autoApprove;
    }

    public BigDecimal getFileType()
    {
        return fileType;
    }

    public void setFileType(BigDecimal fileType)
    {
        this.fileType = fileType;
    }

    /**
     * @return the trsNoList
     */
    public String getTrsNoList()
    {
        return trsNoList;
    }

    /**
     * @param trsNoList the trsNoList to set
     */
    public void setTrsNoList(String trsNoList)
    {
        this.trsNoList = trsNoList;
    }

    public BigDecimal getCommissionFC()
    {
        return commissionFC;
    }

    public void setCommissionFC(BigDecimal commissionFC)
    {
        this.commissionFC = commissionFC;
    }

    public BigDecimal getChargeFC()
    {
        return chargeFC;
    }

    public void setChargeFC(BigDecimal chargeFC)
    {
        this.chargeFC = chargeFC;
    }

    public BigDecimal getTax()
    {
        return tax;
    }

    public void setTax(BigDecimal tax)
    {
        this.tax = tax;
    }

    public String getRateChanged()
    {
        return rateChanged;
    }

    public void setRateChanged(String rateChanged)
    {
        this.rateChanged = rateChanged;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public BigDecimal getOpeningBal()
    {
        return openingBal;
    }

    public void setOpeningBal(BigDecimal openingBal)
    {
        this.openingBal = openingBal;
    }

    public BigDecimal getNumDays()
    {
        return numDays;
    }

    public void setNumDays(BigDecimal numDays)
    {
        this.numDays = numDays;
    }

    public BigDecimal getTcrCvAmount()
    {
        return tcrCvAmount;
    }

    public void setTcrCvAmount(BigDecimal tcrCvAmount)
    {
        this.tcrCvAmount = tcrCvAmount;
    }

    public BigDecimal getPRFT_BR()
    {
        return PRFT_BR;
    }

    public void setPRFT_BR(BigDecimal pRFTBR)
    {
        PRFT_BR = pRFTBR;
    }

    public BigDecimal getTaxPtCv()
    {
        return taxPtCv;
    }

    public void setTaxPtCv(BigDecimal taxPtCv)
    {
        this.taxPtCv = taxPtCv;
    }

    public String getLockUnlockAccountsFlag()
    {
        return lockUnlockAccountsFlag;
    }

    public void setLockUnlockAccountsFlag(String lockUnlockAccountsFlag)
    {
        this.lockUnlockAccountsFlag = lockUnlockAccountsFlag;
    }

    public BigDecimal getSafeApp()
    {
        return safeApp;
    }

    public void setSafeApp(BigDecimal safeApp)
    {
        this.safeApp = safeApp;
    }

    public String getFromAccGmiFlag()
    {
        return fromAccGmiFlag;
    }

    public void setFromAccGmiFlag(String fromAccGmiFlag)
    {
        this.fromAccGmiFlag = fromAccGmiFlag;
    }

    public String getFromAccSign()
    {
        return fromAccSign;
    }

    public void setFromAccSign(String fromAccSign)
    {
        this.fromAccSign = fromAccSign;
    }

    public String getToAccGmiFlag()
    {
        return toAccGmiFlag;
    }

    public void setToAccGmiFlag(String toAccGmiFlag)
    {
        this.toAccGmiFlag = toAccGmiFlag;
    }

    public String getToAccSign()
    {
        return toAccSign;
    }

    public void setToAccSign(String toAccSign)
    {
        this.toAccSign = toAccSign;
    }

    public String getCheckDataSys2()
    {
        return checkDataSys2;
    }

    public void setCheckDataSys2(String checkDataSys2)
    {
        this.checkDataSys2 = checkDataSys2;
    }

    public BigDecimal getOverrideUsrLevel()
    {
        return overrideUsrLevel;
    }

    public void setOverrideUsrLevel(BigDecimal overrideUsrLevel)
    {
        this.overrideUsrLevel = overrideUsrLevel;
    }

    public BigDecimal getUserLevel()
    {
        return userLevel;
    }

    public void setUserLevel(BigDecimal userLevel)
    {
        this.userLevel = userLevel;
    }

    public BigDecimal getLockId()
    {
        return lockId;
    }

    public void setLockId(BigDecimal lockId)
    {
        this.lockId = lockId;
    }

    public String getFromJava()
    {
        return fromJava;
    }

    public void setFromJava(String fromJava)
    {
        this.fromJava = fromJava;
    }

    public String getAccForLockExists()
    {
        return accForLockExists;
    }

    public void setAccForLockExists(String accForLockExists)
    {
        this.accForLockExists = accForLockExists;
    }

    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    public List<TrxMgntCO> getTrxMgntListRecords()
    {
        return trxMgntListRecords;
    }

    public void setTrxMgntListRecords(List<TrxMgntCO> trxMgntListRecords)
    {
        this.trxMgntListRecords = trxMgntListRecords;
    }

    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public String getVersionCode()
    {
        return versionCode;
    }

    public void setVersionCode(String versionCode)
    {
        this.versionCode = versionCode;
    }

    public String getMicrIN()
    {
        return micrIN;
    }

    public void setMicrIN(String micrIN)
    {
        this.micrIN = micrIN;
    }

    public String getAlgorithm()
    {
        return algorithm;
    }

    public void setAlgorithm(String algorithm)
    {
        this.algorithm = algorithm;
    }

    public String getTrxWhereQuery()
    {
        return trxWhereQuery;
    }

    public void setTrxWhereQuery(String trxWhereQuery)
    {
        this.trxWhereQuery = trxWhereQuery;
    }

    public String getTrxWhereQueryForInnerSelect()
    {
        return trxWhereQueryForInnerSelect;
    }

    public void setTrxWhereQueryForInnerSelect(String trxWhereQueryForInnerSelect)
    {
        this.trxWhereQueryForInnerSelect = trxWhereQueryForInnerSelect;
    }
   

    public Boolean getCheckFomTrxDetails()
    {
        return checkFomTrxDetails;
    }

    public void setCheckFomTrxDetails(Boolean checkFomTrxDetails)
    {
        this.checkFomTrxDetails = checkFomTrxDetails;
    }

    public String getMicrOUT()
    {
        return micrOUT;
    }

    public void setMicrOUT(String micrOUT)
    {
        this.micrOUT = micrOUT;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public BigDecimal getCreatedByTellerCode()
    {
        return createdByTellerCode;
    }

    public void setCreatedByTellerCode(BigDecimal createdByTellerCode)
    {
	this.createdByTellerCode = createdByTellerCode;
    }

    public void setCheckUpdateChequeDate(String checkUpdateChequeDate)
    {
	this.checkUpdateChequeDate = checkUpdateChequeDate;
    }

    public String getCheckUpdateChequeDate()
    {
	return checkUpdateChequeDate;
    }

    public void setCheckUpdateChequeDateList(String checkUpdateChequeDateList)
    {
	this.checkUpdateChequeDateList = checkUpdateChequeDateList;
    }

	public void setChqAccNum(String chqAccNum)
	{
	    this.chqAccNum = chqAccNum;
	}

	public String getChqAccNum()
	{
	    return chqAccNum;
	}

    public String getCheckUpdateChequeDateList()
    {
	return checkUpdateChequeDateList;
    }

    public BigDecimal getAlPos()
    {
        return alPos;
    }

    public void setAlPos(BigDecimal alPos)
    {
        this.alPos = alPos;
    }

    public BigDecimal getRelatedGLNew()
    {
        return relatedGLNew;
    }

    public void setRelatedGLNew(BigDecimal relatedGLNew)
    {
        this.relatedGLNew = relatedGLNew;
    }

    public BigDecimal getModaribRateAmtCV()
    {
        return modaribRateAmtCV;
    }

    public void setModaribRateAmtCV(BigDecimal modaribRateAmtCV)
    {
        this.modaribRateAmtCV = modaribRateAmtCV;
    }

    public BigDecimal getModaribRateAmtFC()
    {
        return modaribRateAmtFC;
    }

    public void setModaribRateAmtFC(BigDecimal modaribRateAmtFC)
    {
        this.modaribRateAmtFC = modaribRateAmtFC;
    }

    public BigDecimal getRiskProvAmtCV()
    {
        return riskProvAmtCV;
    }

    public void setRiskProvAmtCV(BigDecimal riskProvAmtCV)
    {
        this.riskProvAmtCV = riskProvAmtCV;
    }

    public BigDecimal getRiskProvAmtFC()
    {
        return riskProvAmtFC;
    }

    public void setRiskProvAmtFC(BigDecimal riskProvAmtFC)
    {
        this.riskProvAmtFC = riskProvAmtFC;
    }

    public BigDecimal getOtherProvAmtCV()
    {
        return otherProvAmtCV;
    }

    public void setOtherProvAmtCV(BigDecimal otherProvAmtCV)
    {
        this.otherProvAmtCV = otherProvAmtCV;
    }

    public BigDecimal getOtherProvAmtFC()
    {
        return otherProvAmtFC;
    }

    public void setOtherProvAmtFC(BigDecimal otherProvAmtFC)
    {
        this.otherProvAmtFC = otherProvAmtFC;
    }

    public String getParentRef()
    {
	return parentRef;
    }

    public void setParentRef(String parentRef)
    {
	this.parentRef = parentRef;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    public String getChargeType()
    {
        return chargeType;
    } 

    public void setChargeType(String chargeType)
    {
        this.chargeType = chargeType;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

   

    public String getPrintingLocation()
    {
        return printingLocation;
    }

    public void setPrintingLocation(String printingLocation)
    {
        this.printingLocation = printingLocation;
    }
    public BigDecimal getFromCif()
    {
        return fromCif;
    }

    public void setFromCif(BigDecimal fromCif)
    {
        this.fromCif = fromCif;
    }

    public BigDecimal getToCif()
    {
        return toCif;
    }

    public void setToCif(BigDecimal toCif)
    {
        this.toCif = toCif;
    }

    public BigDecimal getTaxRegulationID()
    {
        return taxRegulationID;
    }

    public void setTaxRegulationID(BigDecimal taxRegulationID)
    {
        this.taxRegulationID = taxRegulationID;
    }

    public String getBankBranch()
    {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch)
    {
        this.bankBranch = bankBranch;
    }

    public String getBranchRef()
    {
        return branchRef;
    }

    public void setBranchRef(String branchRef)
    {
        this.branchRef = branchRef;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }	   

    public BigDecimal getSubStatusLovType()
    {
        return subStatusLovType;
    }

    public void setSubStatusLovType(BigDecimal subStatusLovType)
    {
        this.subStatusLovType = subStatusLovType;
    }

    public String getLinkTrx()
    {
        return linkTrx;
    }

    public void setLinkTrx(String linkTrx)
    {
        this.linkTrx = linkTrx;
    }
    public String getInstructions2()
    {
        return instructions2;
    }

    public void setInstructions2(String instructions2)
    {
        this.instructions2 = instructions2;
    }

    public String getInstructions3()
    {
        return instructions3;
    }

    public void setInstructions3(String instructions3)
    {
        this.instructions3 = instructions3;
    }

    public String getInstructions4()
    {
        return instructions4;
    }

    public void setInstructions4(String instructions4)
    {
        this.instructions4 = instructions4;
    }

    public String getSwiftMess1()
    {
        return swiftMess1;
    }

    public void setSwiftMess1(String swiftMess1)
    {
        this.swiftMess1 = swiftMess1;
    }

    public String getSwiftMess2()
    {
        return swiftMess2;
    }

    public void setSwiftMess2(String swiftMess2)
    {
        this.swiftMess2 = swiftMess2;
    }

    public String getSwiftMess3()
    {
        return swiftMess3;
    }

    public void setSwiftMess3(String swiftMess3)
    {
        this.swiftMess3 = swiftMess3;
    }

    public String getSwiftMess4()
    {
        return swiftMess4;
    }

    public void setSwiftMess4(String swiftMess4)
    {
        this.swiftMess4 = swiftMess4;
    }

    public BigDecimal getIntermediateBankCode()
    {
        return intermediateBankCode;
    }

    public void setIntermediateBankCode(BigDecimal intermediateBankCode)
    {
        this.intermediateBankCode = intermediateBankCode;
    }

    public String getIntermediateBankBranch()
    {
        return intermediateBankBranch;
    }

    public void setIntermediateBankBranch(String intermediateBankBranch)
    {
        this.intermediateBankBranch = intermediateBankBranch;
    }

    public BigDecimal getBeneficiaryCorrespondentBank()
    {
        return beneficiaryCorrespondentBank;
    }

    public void setBeneficiaryCorrespondentBank(BigDecimal beneficiaryCorrespondentBank)
    {
        this.beneficiaryCorrespondentBank = beneficiaryCorrespondentBank;
    }

    public BigDecimal getBeneficiaryCity()
    {
        return beneficiaryCity;
    }

    public void setBeneficiaryCity(BigDecimal beneficiaryCity)
    {
        this.beneficiaryCity = beneficiaryCity;
    }

    public String getRecCorrespondentBankBicCode()
    {
        return recCorrespondentBankBicCode;
    }

    public void setRecCorrespondentBankBicCode(String recCorrespondentBankBicCode)
    {
        this.recCorrespondentBankBicCode = recCorrespondentBankBicCode;
    }

    public String getRecCorrespondentBankAddress()
    {
        return recCorrespondentBankAddress;
    }

    public void setRecCorrespondentBankAddress(String recCorrespondentBankAddress)
    {
        this.recCorrespondentBankAddress = recCorrespondentBankAddress;
    }

    public String getRecCorrespondentBankAddress1()
    {
        return recCorrespondentBankAddress1;
    }

    public void setRecCorrespondentBankAddress1(String recCorrespondentBankAddress1)
    {
        this.recCorrespondentBankAddress1 = recCorrespondentBankAddress1;
    }

    public String getRecCorrespondentBankAddress2()
    {
        return recCorrespondentBankAddress2;
    }

    public void setRecCorrespondentBankAddress2(String recCorrespondentBankAddress2)
    {
        this.recCorrespondentBankAddress2 = recCorrespondentBankAddress2;
    }

    public String getRecCorrespondentBankAddress3()
    {
        return recCorrespondentBankAddress3;
    }

    public void setRecCorrespondentBankAddress3(String recCorrespondentBankAddress3)
    {
        this.recCorrespondentBankAddress3 = recCorrespondentBankAddress3;
    }

    public String getSwiftSendReceive()
    {
        return swiftSendReceive;
    }

    public void setSwiftSendReceive(String swiftSendReceive)
    {
        this.swiftSendReceive = swiftSendReceive;
    }

    public String getSwiftSendReceive1()
    {
        return swiftSendReceive1;
    }

    public void setSwiftSendReceive1(String swiftSendReceive1)
    {
        this.swiftSendReceive1 = swiftSendReceive1;
    }

    public String getSwiftSendReceive2()
    {
        return swiftSendReceive2;
    }

    public void setSwiftSendReceive2(String swiftSendReceive2)
    {
        this.swiftSendReceive2 = swiftSendReceive2;
    }

    public String getSwiftSendReceive3()
    {
        return swiftSendReceive3;
    }

    public void setSwiftSendReceive3(String swiftSendReceive3)
    {
        this.swiftSendReceive3 = swiftSendReceive3;
    }

    public String getIcNo()
    {
        return icNo;
    }

    public void setIcNo(String icNo)
    {
        this.icNo = icNo;
    }

    public BigDecimal getSoPercMin()
    {
        return soPercMin;
    }

    public void setSoPercMin(BigDecimal soPercMin)
    {
        this.soPercMin = soPercMin;
    }

    public BigDecimal getSoPercMax()
    {
        return soPercMax;
    }

    public void setSoPercMax(BigDecimal soPercMax)
    {
        this.soPercMax = soPercMax;
    }

    public BigDecimal getSoPerc()
    {
        return soPerc;
    }

    public void setSoPerc(BigDecimal soPerc)
    {
        this.soPerc = soPerc;
    }

    public BigDecimal getSoPercCr()
    {
        return soPercCr;
    }

    public void setSoPercCr(BigDecimal soPercCr)
    {
        this.soPercCr = soPercCr;
    }

    public BigDecimal getSoFirstPayment()
    {
        return soFirstPayment;
    }

    public void setSoFirstPayment(BigDecimal soFirstPayment)
    {
        this.soFirstPayment = soFirstPayment;
    }

    public BigDecimal getSoLastPayment()
    {
        return soLastPayment;
    }

    public void setSoLastPayment(BigDecimal soLastPayment)
    {
        this.soLastPayment = soLastPayment;
    }

    public String getReference1()
    {
        return reference1;
    }

    public void setReference1(String reference1)
    {
        this.reference1 = reference1;
    }

    public String getReference2()
    {
        return reference2;
    }

    public void setReference2(String reference2)
    {
        this.reference2 = reference2;
    }

    public String getReference3()
    {
        return reference3;
    }

    public void setReference3(String reference3)
    {
        this.reference3 = reference3;
    }

    public String getStatusReasonDesc()
    {
        return statusReasonDesc;
    }

    public void setStatusReasonDesc(String statusReasonDesc)
    {
        this.statusReasonDesc = statusReasonDesc;
    }

    public String getBenefAddress()
    {
        return benefAddress;
    }

    public void setBenefAddress(String benefAddress)
    {
        this.benefAddress = benefAddress;
    }

    public String getIntermediateBankName()
    {
        return intermediateBankName;
    }

    public void setIntermediateBankName(String intermediateBankName)
    {
        this.intermediateBankName = intermediateBankName;
    }

    public String getIntermediateBankBicCode()
    {
        return intermediateBankBicCode;
    }

    public void setIntermediateBankBicCode(String intermediateBankBicCode)
    {
        this.intermediateBankBicCode = intermediateBankBicCode;
    }

    public String getIntermediateBankAddress1()
    {
        return intermediateBankAddress1;
    }

    public void setIntermediateBankAddress1(String intermediateBankAddress1)
    {
        this.intermediateBankAddress1 = intermediateBankAddress1;
    }

    public String getIntermediateBankAddress2()
    {
        return intermediateBankAddress2;
    }

    public void setIntermediateBankAddress2(String intermediateBankAddress2)
    {
        this.intermediateBankAddress2 = intermediateBankAddress2;
    }

    public String getIntermediateBankAddress3()
    {
        return intermediateBankAddress3;
    }

    public void setIntermediateBankAddress3(String intermediateBankAddress3)
    {
        this.intermediateBankAddress3 = intermediateBankAddress3;
    }

    public String getIntermediateBankAccount()
    {
        return intermediateBankAccount;
    }

    public void setIntermediateBankAccount(String intermediateBankAccount)
    {
        this.intermediateBankAccount = intermediateBankAccount;
    }

    public BigDecimal getBeneficiaryBank()
    {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(BigDecimal beneficiaryBank)
    {
        this.beneficiaryBank = beneficiaryBank;
    }

    public String getBeneficiaryBankName()
    {
        return beneficiaryBankName;
    }

    public void setBeneficiaryBankName(String beneficiaryBankName)
    {
        this.beneficiaryBankName = beneficiaryBankName;
    }

    public String getBeneficiaryBankBicCode()
    {
        return beneficiaryBankBicCode;
    }

    public void setBeneficiaryBankBicCode(String beneficiaryBankBicCode)
    {
        this.beneficiaryBankBicCode = beneficiaryBankBicCode;
    }

    public String getBeneficiaryBankBranch()
    {
        return beneficiaryBankBranch;
    }

    public void setBeneficiaryBankBranch(String beneficiaryBankBranch)
    {
        this.beneficiaryBankBranch = beneficiaryBankBranch;
    }

    public String getBeneficiaryBankAddress1()
    {
        return beneficiaryBankAddress1;
    }

    public void setBeneficiaryBankAddress1(String beneficiaryBankAddress1)
    {
        this.beneficiaryBankAddress1 = beneficiaryBankAddress1;
    }

    public String getBeneficiaryBankAddress2()
    {
        return beneficiaryBankAddress2;
    }

    public void setBeneficiaryBankAddress2(String beneficiaryBankAddress2)
    {
        this.beneficiaryBankAddress2 = beneficiaryBankAddress2;
    }

    public String getBeneficiaryBankAddress3()
    {
        return beneficiaryBankAddress3;
    }

    public void setBeneficiaryBankAddress3(String beneficiaryBankAddress3)
    {
        this.beneficiaryBankAddress3 = beneficiaryBankAddress3;
    }

    public String getBeneficiaryBankAccount()
    {
        return beneficiaryBankAccount;
    }

    public void setBeneficiaryBankAccount(String beneficiaryBankAccount)
    {
        this.beneficiaryBankAccount = beneficiaryBankAccount;
    }

    public String getBeneficiaryName()
    {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName)
    {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAccount()
    {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount)
    {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public String getBeneficiaryAddress1()
    {
        return beneficiaryAddress1;
    }

    public void setBeneficiaryAddress1(String beneficiaryAddress1)
    {
        this.beneficiaryAddress1 = beneficiaryAddress1;
    }

    public String getBeneficiaryAddress2()
    {
        return beneficiaryAddress2;
    }

    public void setBeneficiaryAddress2(String beneficiaryAddress2)
    {
        this.beneficiaryAddress2 = beneficiaryAddress2;
    }

    public String getBeneficiaryAddress3()
    {
        return beneficiaryAddress3;
    }

    public void setBeneficiaryAddress3(String beneficiaryAddress3)
    {
        this.beneficiaryAddress3 = beneficiaryAddress3;
    }

    public BigDecimal getMultiTrsNo()
    {
        return multiTrsNo;
    }

    public void setMultiTrsNo(BigDecimal multiTrsNo)
    {
        this.multiTrsNo = multiTrsNo;
    }

    public BigDecimal getNonFinLineNo()
    {
        return nonFinLineNo;
    }

    public void setNonFinLineNo(BigDecimal nonFinLineNo)
    {
        this.nonFinLineNo = nonFinLineNo;
    }

    public BigDecimal getVatCode()
    {
        return vatCode;
    }

    public void setVatCode(BigDecimal vatCode)
    {
        this.vatCode = vatCode;
    }
    public BigDecimal getFromDay()
    {
        return fromDay;
    }

    public void setFromDay(BigDecimal fromDay)
    {
        this.fromDay = fromDay;
    }

    public BigDecimal getToDay()
    {
        return toDay;
    }

    public void setToDay(BigDecimal toDay)
    {
        this.toDay = toDay;
    }

    public BigDecimal getMonth()
    {
        return month;
    }

    public void setMonth(BigDecimal month)
    {
        this.month = month;
    }

    public BigDecimal getSoPeriodInterval()
    {
        return soPeriodInterval;
    }

    public void setSoPeriodInterval(BigDecimal soPeriodInterval)
    {
        this.soPeriodInterval = soPeriodInterval;
    }

    public String getNarration()
    {
        return narration;
    }

    public void setNarration(String narration)
    {
        this.narration = narration;
    }

    public String getBenefAcc()
    {
        return benefAcc;
    }

    public void setBenefAcc(String benefAcc)
    {
        this.benefAcc = benefAcc;
    }

    public String getToAccAddRef()
    {
        return toAccAddRef;
    }

    public void setToAccAddRef(String toAccAddRef)
    {
        this.toAccAddRef = toAccAddRef;
    }

    public String getCyISO()
    {
        return cyISO;
    }

    public void setCyISO(String cyISO)
    {
        this.cyISO = cyISO;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription1()
    {
        return description1;
    }

    public void setDescription1(String description1)
    {
        this.description1 = description1;
    }

    public String getDescription2()
    {
        return description2;
    }

    public void setDescription2(String description2)
    {
        this.description2 = description2;
    }

    public String getDescriptionAr()
    {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr)
    {
        this.descriptionAr = descriptionAr;
    }

    public String getDescriptionAr1()
    {
        return descriptionAr1;
    }

    public void setDescriptionAr1(String descriptionAr1)
    {
        this.descriptionAr1 = descriptionAr1;
    }

    public String getDescriptionAr2()
    {
        return descriptionAr2;
    }

    public void setDescriptionAr2(String descriptionAr2)
    {
        this.descriptionAr2 = descriptionAr2;
    }

    public String getAtmReference()
    {
        return atmReference;
    }

    public void setAtmReference(String atmReference)
    {
        this.atmReference = atmReference;
    }

    public Integer getUseCard()
    {
        return useCard;
    }

    public void setUseCard(Integer useCard)
    {
        this.useCard = useCard;
    }

    public Integer getUseDate()
    {
        return useDate;
    }

    public void setUseDate(Integer useDate)
    {
        this.useDate = useDate;
    }

    public String getToAccIban()
    {
        return toAccIban;
    }

    public void setToAccIban(String toAccIban)
    {
        this.toAccIban = toAccIban;
    }

    public String getRemittanceDesc()
    {
        return remittanceDesc;
    }

    public void setRemittanceDesc(String remittanceDesc)
    {
        this.remittanceDesc = remittanceDesc;
    }

    public String getRemittanceCurrencyIso()
    {
        return remittanceCurrencyIso;
    }

    public void setRemittanceCurrencyIso(String remittanceCurrencyIso)
    {
        this.remittanceCurrencyIso = remittanceCurrencyIso;
    }

    public Integer getUseRemittance()
    {
        return useRemittance;
    }

    public void setUseRemittance(Integer useRemittance)
    {
        this.useRemittance = useRemittance;
    }

    public String getChequeAccountNumber()
    {
        return chequeAccountNumber;
    }

    public void setChequeAccountNumber(String chequeAccountNumber)
    {
        this.chequeAccountNumber = chequeAccountNumber;
    }

    public String getChequePayeeName()
    {
        return chequePayeeName;
    }

    public void setChequePayeeName(String chequePayeeName)
    {
        this.chequePayeeName = chequePayeeName;
    }

    public String getDraftTrx()
    {
        return draftTrx;
    }

    public void setDraftTrx(String draftTrx)
    {
        this.draftTrx = draftTrx;
    }

    public String getRemitSerial()
    {
        return remitSerial;
    }

    public void setRemitSerial(String remitSerial)
    {
        this.remitSerial = remitSerial;
    }

    public BigDecimal getRemittanceNum()
    {
        return remittanceNum;
    }

    public void setRemittanceNum(BigDecimal remittanceNum)
    {
        this.remittanceNum = remittanceNum;
    }

    public String getAllowProcceedUpdateApprove()
    {
        return allowProcceedUpdateApprove;
    }

    public void setAllowProcceedUpdateApprove(String allowProcceedUpdateApprove)
    {
        this.allowProcceedUpdateApprove = allowProcceedUpdateApprove;
    }

    public BigDecimal getJvType()
    {
        return jvType;
    }

    public void setJvType(BigDecimal jvType)
    {
        this.jvType = jvType;
    }

    public BigDecimal getCallType()
    {
        return callType;
    }

    public void setCallType(BigDecimal callType)
    {
        this.callType = callType;
    }

    public BigDecimal getBodAmount()
    {
        return bodAmount;
    }

    public void setBodAmount(BigDecimal bodAmount)
    {
        this.bodAmount = bodAmount;
    }

    public BigDecimal getAdecProfitCV()
    {
        return adecProfitCV;
    }

    public void setAdecProfitCV(BigDecimal adecProfitCV)
    {
        this.adecProfitCV = adecProfitCV;
    }

    public BigDecimal getAdecPenaltyCV()
    {
        return adecPenaltyCV;
    }

    public void setAdecPenaltyCV(BigDecimal adecPenaltyCV)
    {
        this.adecPenaltyCV = adecPenaltyCV;
    }

    public BigDecimal getAdecNetProfitCV()
    {
        return adecNetProfitCV;
    }

    public void setAdecNetProfitCV(BigDecimal adecNetProfitCV)
    {
        this.adecNetProfitCV = adecNetProfitCV;
    }

    public BigDecimal getAdecOrigProfit()
    {
        return adecOrigProfit;
    }

    public void setAdecOrigProfit(BigDecimal adecOrigProfit)
    {
        this.adecOrigProfit = adecOrigProfit;
    }

    public BigDecimal getAdecOrigProfitCV()
    {
        return adecOrigProfitCV;
    }

    public void setAdecOrigProfitCV(BigDecimal adecOrigProfitCV)
    {
        this.adecOrigProfitCV = adecOrigProfitCV;
    }

    public BigDecimal getAdecCrProfit()
    {
        return adecCrProfit;
    }

    public void setAdecCrProfit(BigDecimal adecCrProfit)
    {
        this.adecCrProfit = adecCrProfit;
    }

    public BigDecimal getAdecCrProfitCV()
    {
        return adecCrProfitCV;
    }

    public void setAdecCrProfitCV(BigDecimal adecCrProfitCV)
    {
        this.adecCrProfitCV = adecCrProfitCV;
    }

    public BigDecimal getAdecDrProfit()
    {
        return adecDrProfit;
    }

    public void setAdecDrProfit(BigDecimal adecDrProfit)
    {
        this.adecDrProfit = adecDrProfit;
    }

    public BigDecimal getAdecDrProfitCV()
    {
        return adecDrProfitCV;
    }

    public void setAdecDrProfitCV(BigDecimal adecDrProfitCV)
    {
        this.adecDrProfitCV = adecDrProfitCV;
    }

    public String getPostchgComm()
    {
        return postchgComm;
    }

    public void setPostchgComm(String postchgComm)
    {
        this.postchgComm = postchgComm;
    }

    public BigDecimal getADEC_ORIG_RATE()
    {
        return ADEC_ORIG_RATE;
    }

    public void setADEC_ORIG_RATE(BigDecimal aDEC_ORIG_RATE)
    {
        ADEC_ORIG_RATE = aDEC_ORIG_RATE;
    }

    public BigDecimal getCommissionCV()
    {
        return commissionCV;
    }

    public void setCommissionCV(BigDecimal commissionCV)
    {
        this.commissionCV = commissionCV;
    }

    public BigDecimal getChargeCV()
    {
        return chargeCV;
    }

    public void setChargeCV(BigDecimal chargeCV)
    {
        this.chargeCV = chargeCV;
    }

    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }
    
    public BigDecimal getOverDrawnAmountFr()
    {
        return overDrawnAmountFr;
    }

    public void setOverDrawnAmountFr(BigDecimal overDrawnAmountFr)
    {
        this.overDrawnAmountFr = overDrawnAmountFr;
    }

    public BigDecimal getOverDrawnAmountTo()
    {
        return overDrawnAmountTo;
    }

    public void setOverDrawnAmountTo(BigDecimal overDrawnAmountTo)
    {
        this.overDrawnAmountTo = overDrawnAmountTo;
    }

    public Boolean getRequiredDataByCifNoOnly()
    {
        return requiredDataByCifNoOnly;
    }

    public void setRequiredDataByCifNoOnly(Boolean requiredDataByCifNoOnly)
    {
        this.requiredDataByCifNoOnly = requiredDataByCifNoOnly;
    }

    public BigDecimal getIisExists()
    {
        return iisExists;
    }

    public void setIisExists(BigDecimal iisExists)
    {
        this.iisExists = iisExists;
    }

    public BigDecimal getProfitDeclGracePeriodNo()
    {
        return profitDeclGracePeriodNo;
    }

    public void setProfitDeclGracePeriodNo(BigDecimal profitDeclGracePeriodNo)
    {
        this.profitDeclGracePeriodNo = profitDeclGracePeriodNo;
    }

    public String getProfitDeclGracePeriodFreq()
    {
        return profitDeclGracePeriodFreq;
    }

    public void setProfitDeclGracePeriodFreq(String profitDeclGracePeriodFreq)
    {
        this.profitDeclGracePeriodFreq = profitDeclGracePeriodFreq;
    }

    public String getOdType()
    {
        return odType;
    }

    public void setOdType(String odType)
    {
        this.odType = odType;
    }

    public String getMousharakaIjra()
    {
        return mousharakaIjra;
    }

    public void setMousharakaIjra(String mousharakaIjra)
    {
        this.mousharakaIjra = mousharakaIjra;
    }

    public Date getIjraEndingPeriodicity()
    {
        return ijraEndingPeriodicity;
    }

    public void setIjraEndingPeriodicity(Date ijraEndingPeriodicity)
    {
        this.ijraEndingPeriodicity = ijraEndingPeriodicity;
    }

    public Date getLimitExpDate()
    {
        return limitExpDate;
    }

    public void setLimitExpDate(Date limitExpDate)
    {
        this.limitExpDate = limitExpDate;
    }

    public String getGlobalConfirmation()
    {
        return globalConfirmation;
    }

    public void setGlobalConfirmation(String globalConfirmation)
    {
        this.globalConfirmation = globalConfirmation;
    }

    public String getAlertCifWatchList()
    {
        return alertCifWatchList;
    }

    public void setAlertCifWatchList(String alertCifWatchList)
    {
        this.alertCifWatchList = alertCifWatchList;
    }

    public String getAlertIisOverdueInst()
    {
        return alertIisOverdueInst;
    }

    public void setAlertIisOverdueInst(String alertIisOverdueInst)
    {
        this.alertIisOverdueInst = alertIisOverdueInst;
    }

    public String getAlertDidntDeclProfit()
    {
        return alertDidntDeclProfit;
    }

    public void setAlertDidntDeclProfit(String alertDidntDeclProfit)
    {
        this.alertDidntDeclProfit = alertDidntDeclProfit;
    }

    public String getDocType()
    {
        return docType;
    }

    public void setDocType(String docType)
    {
        this.docType = docType;
    }

    public BigDecimal getAvaAllocationCode()
    {
        return avaAllocationCode;
    }

    public void setAvaAllocationCode(BigDecimal avaAllocationCode)
    {
        this.avaAllocationCode = avaAllocationCode;
    }

    public String getAvailBalAfter()
    {
        return availBalAfter;
    }

    public void setAvailBalAfter(String availBalAfter)
    {
        this.availBalAfter = availBalAfter;
    }

    public String getToAvailBalAfter()
    {
        return toAvailBalAfter;
    }

    public void setToAvailBalAfter(String toAvailBalAfter)
    {
        this.toAvailBalAfter = toAvailBalAfter;
    }

    public String getBenefBICCode()
    {
        return benefBICCode;
    }

    public void setBenefBICCode(String benefBICCode)
    {
        this.benefBICCode = benefBICCode;
    }

    public String getIntermBICCode()
    {
        return intermBICCode;
    }

    public void setIntermBICCode(String intermBICCode)
    {
        this.intermBICCode = intermBICCode;
    }

    public BigDecimal getOldTrxAmount()
    {
        return oldTrxAmount;
    }

    public void setOldTrxAmount(BigDecimal oldTrxAmount)
    {
        this.oldTrxAmount = oldTrxAmount;
    }

    public BigDecimal getProductClass()
    {
        return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
        this.productClass = productClass;
    }

    public BigDecimal getRemainingLimit()
    {
        return remainingLimit;
    }

    public void setRemainingLimit(BigDecimal remainingLimit)
    {
        this.remainingLimit = remainingLimit;
    }

    public BigDecimal getIsoInterface()
    {
        return isoInterface;
    }

    public void setIsoInterface(BigDecimal isoInterface)
    {
        this.isoInterface = isoInterface;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileCode()
    {
        return fileCode;
    }

    public void setFileCode(String fileCode)
    {
        this.fileCode = fileCode;
    }

    public BigDecimal getSequence_no()
    {
        return sequence_no;
    }

    public void setSequence_no(BigDecimal sequence_no)
    {
        this.sequence_no = sequence_no;
    }

    public String getCalledFrom()
    {
        return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
        this.calledFrom = calledFrom;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public List<TrxMgntCO> getMultiChequesEntryList()
    {
        return multiChequesEntryList;
    }

    public void setMultiChequesEntryList(List<TrxMgntCO> multiChequesEntryList)
    {
        this.multiChequesEntryList = multiChequesEntryList;
    }

    public BigDecimal getLossCV()
    {
        return lossCV;
    }

    public void setLossCV(BigDecimal lossCV)
    {
        this.lossCV = lossCV;
    }

    public BigDecimal getLossFC()
    {
        return lossFC;
    }

    public void setLossFC(BigDecimal lossFC)
    {
        this.lossFC = lossFC;
    }

    public BigDecimal getInjProvAmtCV()
    {
        return injProvAmtCV;
    }

    public void setInjProvAmtCV(BigDecimal injProvAmtCV)
    {
        this.injProvAmtCV = injProvAmtCV;
    }

    public BigDecimal getInjProvAmtFC()
    {
        return injProvAmtFC;
    }

    public void setInjProvAmtFC(BigDecimal injProvAmtFC)
    {
        this.injProvAmtFC = injProvAmtFC;
    }

    public BigDecimal getInjRiskProvAmtCV()
    {
        return injRiskProvAmtCV;
    }

    public void setInjRiskProvAmtCV(BigDecimal injRiskProvAmtCV)
    {
        this.injRiskProvAmtCV = injRiskProvAmtCV;
    }

    public BigDecimal getInjRiskProvAmtFC()
    {
        return injRiskProvAmtFC;
    }

    public void setInjRiskProvAmtFC(BigDecimal injRiskProvAmtFC)
    {
        this.injRiskProvAmtFC = injRiskProvAmtFC;
    }

    public BigDecimal getShadowAccountBr()
    {
        return shadowAccountBr;
    }

    public void setShadowAccountBr(BigDecimal shadowAccountBr)
    {
        this.shadowAccountBr = shadowAccountBr;
    }

    public BigDecimal getShadowAccountCy()
    {
        return shadowAccountCy;
    }

    public void setShadowAccountCy(BigDecimal shadowAccountCy)
    {
        this.shadowAccountCy = shadowAccountCy;
    }

    public BigDecimal getShadowAccountGl()
    {
        return shadowAccountGl;
    }

    public void setShadowAccountGl(BigDecimal shadowAccountGl)
    {
        this.shadowAccountGl = shadowAccountGl;
    }

    public BigDecimal getShadowAccountCif()
    {
        return shadowAccountCif;
    }

    public void setShadowAccountCif(BigDecimal shadowAccountCif)
    {
        this.shadowAccountCif = shadowAccountCif;
    }

    public BigDecimal getShadowAccountSl()
    {
        return shadowAccountSl;
    }

    public void setShadowAccountSl(BigDecimal shadowAccountSl)
    {
        this.shadowAccountSl = shadowAccountSl;
    }

    public BigDecimal getFundingAccountBr()
    {
        return fundingAccountBr;
    }

    public void setFundingAccountBr(BigDecimal fundingAccountBr)
    {
        this.fundingAccountBr = fundingAccountBr;
    }

    public BigDecimal getFundingAccountCy()
    {
        return fundingAccountCy;
    }

    public void setFundingAccountCy(BigDecimal fundingAccountCy)
    {
        this.fundingAccountCy = fundingAccountCy;
    }

    public BigDecimal getFundingAccountGl()
    {
        return fundingAccountGl;
    }

    public void setFundingAccountGl(BigDecimal fundingAccountGl)
    {
        this.fundingAccountGl = fundingAccountGl;
    }

    public BigDecimal getFundingAccountCif()
    {
        return fundingAccountCif;
    }

    public void setFundingAccountCif(BigDecimal fundingAccountCif)
    {
        this.fundingAccountCif = fundingAccountCif;
    }

    public BigDecimal getFundingAccountSl()
    {
        return fundingAccountSl;
    }

    public void setFundingAccountSl(BigDecimal fundingAccountSl)
    {
        this.fundingAccountSl = fundingAccountSl;
    }

    public List<CTSTRXTYPE_EXTENDEDVO> getCertifiedTrxTypeList()
    {
        return certifiedTrxTypeList;
    }

    public void setCertifiedTrxTypeList(List<CTSTRXTYPE_EXTENDEDVO> certifiedTrxTypeList)
    {
        this.certifiedTrxTypeList = certifiedTrxTypeList;
    }

    public String getPostPftCr()
    {
        return postPftCr;
    }

    public void setPostPftCr(String postPftCr)
    {
        this.postPftCr = postPftCr;
    }

    public BigDecimal getMcashLimit()
    {
        return mcashLimit;
    }

    public void setMcashLimit(BigDecimal mcashLimit)
    {
        this.mcashLimit = mcashLimit;
    }

    public BigDecimal getLovSubstatus()
    {
        return lovSubstatus;
    }

    public void setLovSubstatus(BigDecimal lovSubstatus)
    {
        this.lovSubstatus = lovSubstatus;
    }

    public String getIsCollateralized()
    {
        return isCollateralized;
    }

    public void setIsCollateralized(String isCollateralized)
    {
        this.isCollateralized = isCollateralized;
    }

    public String getTrxMethod()
    {
        return trxMethod;
    }

    public void setTrxMethod(String trxMethod)
    {
        this.trxMethod = trxMethod;
    }

    public BigDecimal getReturnedZakatCV()
    {
        return returnedZakatCV;
    }

    public void setReturnedZakatCV(BigDecimal returnedZakatCV)
    {
        this.returnedZakatCV = returnedZakatCV;
    }

    public BigDecimal getReturnedZakatFC()
    {
        return returnedZakatFC;
    }

    public void setReturnedZakatFC(BigDecimal returnedZakatFC)
    {
        this.returnedZakatFC = returnedZakatFC;
    }

    public String getShowSoRefLookup()
    {
        return showSoRefLookup;
    }

    public void setShowSoRefLookup(String showSoRefLookup)
    {
        this.showSoRefLookup = showSoRefLookup;
    }

    public String getAllowIssueCertif()
    {
        return allowIssueCertif;
    }

    public void setAllowIssueCertif(String allowIssueCertif)
    {
        this.allowIssueCertif = allowIssueCertif;
    }

    public String getAllowCancelCertif()
    {
        return allowCancelCertif;
    }

    public void setAllowCancelCertif(String allowCancelCertif)
    {
        this.allowCancelCertif = allowCancelCertif;
    }

    public String getAllowCollectCertif()
    {
        return allowCollectCertif;
    }

    public void setAllowCollectCertif(String allowCollectCertif)
    {
        this.allowCollectCertif = allowCollectCertif;
    }

    public BigDecimal getBranchCashLimit()
    {
        return branchCashLimit;
    }

    public void setBranchCashLimit(BigDecimal branchCashLimit)
    {
        this.branchCashLimit = branchCashLimit;
    }

    public BigDecimal getUtilizedBalance()
    {
        return utilizedBalance;
    }

    public void setUtilizedBalance(BigDecimal utilizedBalance)
    {
        this.utilizedBalance = utilizedBalance;
    }

    public BigDecimal getRemainingBalance()
    {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance)
    {
        this.remainingBalance = remainingBalance;
    }

    public BigDecimal getExceededBalance()
    {
        return exceededBalance;
    }

    public void setExceededBalance(BigDecimal exceededBalance)
    {
        this.exceededBalance = exceededBalance;
    }

    public BigDecimal getExceededPercentage()
    {
        return exceededPercentage;
    }

    public void setExceededPercentage(BigDecimal exceededPercentage)
    {
        this.exceededPercentage = exceededPercentage;
    }

    public String getExceededLimit()
    {
        return exceededLimit;
    }

    public void setExceededLimit(String exceededLimit)
    {
        this.exceededLimit = exceededLimit;
    }

    public String getResponseOutput()
    {
        return responseOutput;
    }

    public void setResponseOutput(String responseOutput)
    {
        this.responseOutput = responseOutput;
    }

    public String getFromProduct()
    {
        return fromProduct;
    }

    public void setFromProduct(String fromProduct)
    {
        this.fromProduct = fromProduct;
    }

    public BigDecimal getLovTypeSynthesis()
    {
        return lovTypeSynthesis;
    }

    public void setLovTypeSynthesis(BigDecimal lovTypeSynthesis)
    {
        this.lovTypeSynthesis = lovTypeSynthesis;
    }

    public BigDecimal getRequestId()
    {
        return requestId;
    }

    public void setRequestId(BigDecimal requestId)
    {
        this.requestId = requestId;
    }

    public String getBenefName()
    {
        return benefName;
    }

    public void setBenefName(String benefName)
    {
        this.benefName = benefName;
    }

    public String getBenefBankName()
    {
        return benefBankName;
    }

    public void setBenefBankName(String benefBankName)
    {
        this.benefBankName = benefBankName;
    }

    public String getBenefBankBr()
    {
        return benefBankBr;
    }

    public void setBenefBankBr(String benefBankBr)
    {
        this.benefBankBr = benefBankBr;
    }

    public BigDecimal getTrsAmount()
    {
        return trsAmount;
    }

    public void setTrsAmount(BigDecimal trsAmount)
    {
        this.trsAmount = trsAmount;
    }

    public String getIsoCurrencyCode()
    {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode)
    {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public String getTrxDate()
    {
        return trxDate;
    }

    public void setTrxDate(String trxDate)
    {
        this.trxDate = trxDate;
    }

    public String getTrxTime()
    {
        return trxTime;
    }

    public void setTrxTime(String trxTime)
    {
        this.trxTime = trxTime;
    }

    public String getCeftsStatus()
    {
        return ceftsStatus;
    }

    public void setCeftsStatus(String ceftsStatus)
    {
        this.ceftsStatus = ceftsStatus;
    }

    public String getTrxReference()
    {
        return trxReference;
    }

    public void setTrxReference(String trxReference)
    {
        this.trxReference = trxReference;
    }

    public String getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(String responseCode)
    {
        this.responseCode = responseCode;
    }

    public BigDecimal getDe11StanSeq()
    {
        return de11StanSeq;
    }

    public void setDe11StanSeq(BigDecimal de11StanSeq)
    {
        this.de11StanSeq = de11StanSeq;
    }

    public String getDe37RetRefNbSeq()
    {
        return de37RetRefNbSeq;
    }

    public void setDe37RetRefNbSeq(String de37RetRefNbSeq)
    {
        this.de37RetRefNbSeq = de37RetRefNbSeq;
    }

    public BigDecimal getInterfaceCode()
    {
        return interfaceCode;
    }

    public void setInterfaceCode(BigDecimal interfaceCode)
    {
        this.interfaceCode = interfaceCode;
    }

    public BigDecimal getProcess_code()
    {
        return process_code;
    }

    public void setProcess_code(BigDecimal process_code)
    {
        this.process_code = process_code;
    }

    public String getTrxAuthCode()
    {
        return trxAuthCode;
    }

    public void setTrxAuthCode(String trxAuthCode)
    {
        this.trxAuthCode = trxAuthCode;
    }

    public String getTransDatetime()
    {
        return transDatetime;
    }

    public void setTransDatetime(String transDatetime)
    {
        this.transDatetime = transDatetime;
    }

    public String getAcquInstId()
    {
        return acquInstId;
    }

    public void setAcquInstId(String acquInstId)
    {
        this.acquInstId = acquInstId;
    }

    public BigDecimal getRequestId2()
    {
        return requestId2;
    }

    public void setRequestId2(BigDecimal requestId2)
    {
        this.requestId2 = requestId2;
    }

    public String getMessageCode()
    {
        return messageCode;
    }

    public void setMessageCode(String messageCode)
    {
        this.messageCode = messageCode;
    }

    public String getCeftsTrxType()
    {
        return ceftsTrxType;
    }

    public void setCeftsTrxType(String ceftsTrxType)
    {
        this.ceftsTrxType = ceftsTrxType;
    }

    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public BigDecimal getTrxIID()
    {
        return trxIID;
    }

    public void setTrxIID(BigDecimal trxIID)
    {
        this.trxIID = trxIID;
    }

    public String getTrxOutIn()
    {
        return trxOutIn;
    }

    public void setTrxOutIn(String trxOutIn)
    {
        this.trxOutIn = trxOutIn;
    }

    public String getCeftsPrcCode()
    {
        return ceftsPrcCode;
    }

    public void setCeftsPrcCode(String ceftsPrcCode)
    {
        this.ceftsPrcCode = ceftsPrcCode;
    }

    public BigDecimal getIncrementalCefts()
    {
        return incrementalCefts;
    }

    public void setIncrementalCefts(BigDecimal incrementalCefts)
    {
        this.incrementalCefts = incrementalCefts;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public Integer getIdNoReturnVal()
    {
        return idNoReturnVal;
    }

    public void setIdNoReturnVal(Integer idNoReturnVal)
    {
        this.idNoReturnVal = idNoReturnVal;
    }
    
    public void setMaskTellerCode(BigDecimal maskTellerCode)
    {
	this.maskTellerCode = maskTellerCode;
    }
    
    public BigDecimal getMaskTellerCode()
    {
	return maskTellerCode;
    }

    public void setMaskTrxAmtApproveYN(String maskTrxAmtApproveYN)
    {
    	this.maskTrxAmtApproveYN = maskTrxAmtApproveYN;
    }
        
    public String getMaskTrxAmtApproveYN()
    {
        return maskTrxAmtApproveYN;
    }

    public BigDecimal getChargeCVAmount()
    {
	return chargeCVAmount;
    }

    public void setChargeCVAmount(BigDecimal chargeCVAmount)
    {
	this.chargeCVAmount = chargeCVAmount;
    }

    public BigDecimal getChargeFCAmount()
    {
	return chargeFCAmount;
    }

    public void setChargeFCAmount(BigDecimal chargeFCAmount)
    {
	this.chargeFCAmount = chargeFCAmount;
    }

    public BigDecimal getChargeCode()
    {
	return chargeCode;
    }

    public void setChargeCode(BigDecimal chargeCode)
    {
	this.chargeCode = chargeCode;
    }

    public String getSubStatusDesc()
    {
	return subStatusDesc;
    }

    public void setSubStatusDesc(String subStatusDesc)
    {
	this.subStatusDesc = subStatusDesc;
    }
    
    /**
     * @return the roundedAmtCV
     */
    public BigDecimal getRoundedAmtCV()
    {
        return roundedAmtCV;
    }

    /**
     * @param roundedAmtCV the roundedAmtCV to set
     */
    public void setRoundedAmtCV(BigDecimal roundedAmtCV)
    {
        this.roundedAmtCV = roundedAmtCV;
    }
    
    /**
     * @return the roundedAmtFC
     */
    public BigDecimal getRoundedAmtFC()
    {
        return roundedAmtFC;
    }

    /**
     * @param roundedAmtFC the roundedAmtFC to set
     */
    public void setRoundedAmtFC(BigDecimal roundedAmtFC)
    {
        this.roundedAmtFC = roundedAmtFC;
    }
    
}
