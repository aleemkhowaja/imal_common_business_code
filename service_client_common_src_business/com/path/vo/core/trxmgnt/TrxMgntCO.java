package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMFVOKey;
import com.path.dbmaps.vo.AMF_EXTENDEDVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.dbmaps.vo.CTSBATCHVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSOVERDRAFT_SETTLMENTVO;
import com.path.dbmaps.vo.CTSSTATUSVO;
import com.path.dbmaps.vo.CTSTELLERACCTYPEDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRSSTATUSVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTSTRS_ADV_PROFVO;
import com.path.dbmaps.vo.CTSTRS_ALERTVO;
import com.path.dbmaps.vo.CTSTRS_BENEF_DETVO;
import com.path.dbmaps.vo.CTSTRS_BENEF_DET_ALERTVO;
import com.path.dbmaps.vo.CTSTRS_BREAK_DEPVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DETVO;
import com.path.dbmaps.vo.CTSTRS_EXCH_CLIENT_DETVO;
import com.path.dbmaps.vo.CTSTRS_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRS_OUTSTANDING_PFTVO;
import com.path.dbmaps.vo.CTSTRS_REMITT_DENOMVO;
import com.path.dbmaps.vo.CTSTRS_SO_CHARGES_DETVO;
import com.path.dbmaps.vo.CTSTRS_STATEMENTVO;
import com.path.dbmaps.vo.CTSTRS_UPLOAD_TMPVO;
import com.path.dbmaps.vo.CTSTRS_VDATE_INFOVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPE_STATUSVO;
import com.path.dbmaps.vo.CTS_CIRCULAR_DEFVO;
import com.path.dbmaps.vo.CTS_EXCEPTIONS_TRACEVO;
import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.dbmaps.vo.CTS_NON_FIN_INFOVO;
import com.path.dbmaps.vo.CTS_NON_FIN_INFO_ALERTVO;
import com.path.dbmaps.vo.CTS_SUB_INSTRUCTIONVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.EMPVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTL_CIFVO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.cydenom.TrsCurrencyDetCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.cardreader.CardReaderCO;
import com.path.vo.core.chequescan.ChequeScanCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.common.billtypeaddref.BillTypeAddReferenceCO;
import com.path.vo.core.passbook.PassBookCO;
import com.path.vo.core.recordofremittance.RecordOfRemittanceCO;
import com.path.vo.core.trxmgnt.accountdtl.TrxMgntAccountDtlCO;
import com.path.vo.core.trxmgnt.beneficiary.TrxMgntBenefCO;
import com.path.vo.core.trxmgnt.fxdeal.TrxMgntFxDealCO;
import com.path.vo.core.trxmgnt.nonfininfo.morebenef.TrxMgntMoreBenefCO;
import com.path.vo.core.trxmgnt.nonfininfo.morebenef.TrxMgntMoreBenefDetailsCO;
import com.path.vo.core.trxmgnt.overdraftsettlment.TrxMgntOverdraftSettlCO;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;
import com.path.vo.core.trxmgnt.settlement.TrxMgntSettlementCO;
import com.path.vo.core.trxtype.TrsTypeAddFieldsValuesCO;
//import com.path.vo.core.webservice.RetWebServiceCO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: GuittaAbouGharrach
 * 
 *          TrxMgntCO.java used to hold transaction management details
 */

public class TrxMgntCO extends RetailBaseVO
{
    /* USER STORY#336860 INDI150072 */
    private CTSTRS_VDATE_INFOVO ctstrsVDateInfoVO;
    private BigDecimal valueDateAmendLovId;
    private String trxVDateAmendmentStatusDesc;
    
    /* Sarah Elhusseini, USER STORY#336860 INDI150072*/
    private String fromDebitValueDate;

    
    private BigDecimal cardReleaseHofDays;//
    private String dofEngDesc2,dofArabDesc2;//
    private BigDecimal checkBalance;//
    
    private BigDecimal reasonCode;
   // private RetWebServiceCO retWebServiceCO;

    private BigDecimal accActionLimit;
    private BigDecimal officer_code;
    private BigDecimal trsNo;
    private String officer_name;
    private String maskedCardNo;
    private BigDecimal serialNo;
    private String trsNoList;
    private String relatedSerialNoList;
    private BigDecimal batchNo;
    private BigDecimal fileType;
    private BigDecimal changesApplied;
    private String cardNo;
    private String multipleEntries;
    private CTSTRSVO ctstrsVO = new CTSTRSVO();
    private CTSTRS_UPLOAD_TMPVO trsUploadTmpVO = new CTSTRS_UPLOAD_TMPVO();
    private CTSTRS_EXTENDEDVO ctstrsExtendedVO = new CTSTRS_EXTENDEDVO();
    private CTSTRS_ALERTVO ctstrsAlertVO = new CTSTRS_ALERTVO();
    private CTSTRSSTATUSVO ctstrsstatusVO = new CTSTRSSTATUSVO();
    private CTSSTATUSVO ctsstatusVO = new CTSSTATUSVO();
    private USR_LEVELVO usrLevelVO = new USR_LEVELVO();
    private CTSTRXTYPE_STATUSVO ctsTrxTypeStatusVO = new CTSTRXTYPE_STATUSVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
    //NABIL FEGHALI - BB130085 - Global Payment File
    private CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO = new CTSTRXTYPE_EXTENDEDVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private GEN_LEDGERVO genLedgerVO = new GEN_LEDGERVO();
    private CTSTELLERACCTYPEDETVO ctsTellerAccTypeDetVO = new CTSTELLERACCTYPEDETVO();
    private TrxChargesCO trxChargesCO = new TrxChargesCO();
    private TrxSOChargesCO trxSOChargesCO = new TrxSOChargesCO();
    private TrxVoidChargesCO trxVoidChargesCO = new TrxVoidChargesCO();
    private AccountCO deductChargeAccountCO = new AccountCO();
    private CTS_EXCEPTIONS_TRACEVO exceptionsTraceVO = new CTS_EXCEPTIONS_TRACEVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private RIFATTVO rifAttVO = new RIFATTVO();
    private RIFCTTVO rifCttVO = new RIFCTTVO();
    private PTH_CTRLVO pthCtrlVO;
    private REMITTANCEVO remittanceVO;
    private CTSTRS_REMITT_DENOMVO ctstrsRemittDenomVO;
    private String printExceptionsReport;
    private BigDecimal processId;
    private BigDecimal scannedCIFNo;
    private BigDecimal firstCIFNo;
    private BigDecimal defaultTrxType;
    private String processName;
    private String newAmountInput;
    private String inChargedCyInput;
    private String waiveRateInput;
    private String similarCharge;
    private List<String> listWarningMsg = new ArrayList<String>();
    private AMFVO accountVO = new AMFVO();
    private EMPVO empVO;
    private CIFVO cifVO = new CIFVO();
    private String statusDesc;
    private String userDesc;
    private String trxBranch_Desc;
    private String isBank;
    private String isUnifiedCharge; // Denotes whether the charge calculation is being called using new Unified method or old traditional method
    private String loadChargeGrid; // Denotes whether charge calculation is being called when loading the charges grid or another source
    
    // Main TRX
    private String linkedTrsMsg;
    private String deletionDateMsg;
    private String approvedDateMsg;
    private String toRevDateMsg;
    private String reasonDescMsg;
    private String readOnlyRec;
    private String linkOpened;
    private String alertMode;
    private String emptyMoreBenef;
    private Date runningDateRET; // to be removed
    private String cif_short_name_eng; // trs_ac_cif CIF description
    private String amf_brief_name_eng; // trs account description
    private String ctrl_acc_desc; // Teller Account description
    private String to_acc_desc; // To Account description
    private String to_acc_cif_desc; // to_acc_cif_desc CIF description
    private String bill_type_desc; // bill_type description
    private String currencies_brief_desc_eng;// currencies brief Description
    private String rifatt_brief_desc_eng;// account type brief description
    private String avail_bal;// available balance
    private String round_amount;// containing function that gets round amount
    private String to_acc_cy_desc;// to AC currency description
    private String to_acc_rifatt_desc;// To AC Type description
    private String to_avail_bal;// to Avail Balance description
    private Date chq_date_hijri;// cheque date hirji
    private BigDecimal t_instr_avail_qty_ht; // Instr Avail Qty HT calculated
    private BigDecimal t_instr_avail_qty_vault;// Instr Avail Qty Vault
    // calculated
    private BigDecimal t_total_amount;// total Amount
    private BigDecimal t_total_ac_amount;// total Acccount Amount
    private BigDecimal REQUEST_ID;
    private String trx_type_desc; // transaction type description
    private String ctrl_additional_reference;// trx Details additional reference
    private String ch_ac_additional_reference; // charges additional reference
    private String charge_acc_name;
    private String id_typeDesc; // id type Description
    private String depositer_nationality_desc; // despositer nationality
    private BigDecimal mceRec;
    private BigDecimal bulkRemittanceType;
    // description
    private String currencyDesc; // currency Description for Trs Currency
    private BigDecimal cyDecimalPoints;// currencies decimal Point
    private BigDecimal baseCyDecimalPoints;// Base currency decimal Point
    private String linkToAnother_trxNo_desc; // link to another trx description
    private BigDecimal confirmation;// user's choice for the confirmation
    // message 0 yes,1 no
    private String confirmMsg;
    private BigDecimal cf_total_so_amount;
    private BigDecimal totalAmountInBaseCy;
    private BigDecimal totalAmountInCy;
    private BigDecimal totalCharges;

    private Integer activeSO;// 1 if active SO else 0
    private String autoApprove;// 1 if trxApproveMgnt is called from trxMgntSave
    private boolean autoApproveSuccess;// 1 if trxApproveMgnt is called from
				       // trxMgntSave
    private String errorType;// warning, limit warning, error
    private String amdendedCharges;// charges amended in breaking deposit
    private CTSMEMO_DETVO ctsmemoDETVO = new CTSMEMO_DETVO(); // memo
    private String actionStr;
    // end Main Trx

    // Charges Div
    private CTSTRS_CHARGES_DETVO ctstrsCHARGESDETVO = new CTSTRS_CHARGES_DETVO();
    private CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
    private String BRIEF_NAME; 			// Charges Brief Name
    private String DEDUCT_FROM_ACC_DESC;
    private String DEDUCT_FROM_ACC_REF;
    private BigDecimal chargeSchema; 		// il_charges_schema
    private String chargesEmpty;
    private String soChargesEmpty;
    private Boolean suppressMessage = false; 	// Used to determine if error message is outputted or not
    private String reference;			// For Charges to know where charge is coming from
    private String modifyMessage;
    private String rejectMessage;
    
    private String trxMgntChargesGridUpdate;
    private List<TrxMgntCO> listTrxMgntChargesMod = new ArrayList<TrxMgntCO>();
    // end Charges Div

    // Cy Denomination Div
    private String trxMgntCyDenomGridUpdate;
    // end Cy Denomination Div

    // Non Financial Info
    private BigDecimal COMP_COUNTRY;
    private BigDecimal lineNum;
    private String country_desc;
    private String desc_city;
    private String benef_country_desc;
    

    // More Benef related to Non financial info
    private CTSTRS_BENEF_DETVO ctstrsBENEFDETVO;
    private String trxMgntMoreBenefGridUpdate;
    private String trxMgntAccDetGrid;
    private String selectedBulkRemittance;
    private HashMap<String, TrxMgntCO> bulkRemittanceRows = new HashMap<String, TrxMgntCO>();
    private List<TrxMgntCO> listTrxMgntMoreBenefAdd = new ArrayList<TrxMgntCO>();
    private List<TrxMgntCO> listTrxMgntMoreBenefMod = new ArrayList<TrxMgntCO>();
    private List<TrxMgntCO> listTrxMgntMoreBenefDelete = new ArrayList<TrxMgntCO>();
    private List<TrxMgntCO> listBulkRemittance = new ArrayList<TrxMgntCO>();

    // Breaking Deposit
    private CTSTRS_BREAK_DEPVO ctstrsBREAKDEPVO;
    private String showBreakDeposit;
    private BigDecimal CY_CODE;
    private String t_pcs_tax;
    private String t_pcs_charges;
    private String t_tax;
    private String t_commission;
    private String t_charges;
    private BigDecimal acc_curr;
    private BigDecimal gv_curr;
    private String vipAlert;
    private String vipAlert1;
    private String totalAccount;
    private BigDecimal net_amount_t; // net amount computed field
    private BigDecimal pcs_netprofit_fc; // net profit amount in fc computed
    private BigDecimal pcs_netprofit_cv; // net profit amount in cv computed
    private BigDecimal netProfit; // net profit computed
    private BigDecimal GV_FISCAL_YEAR;
    private AMFVO istr_inv_acc = new AMFVO();
    private AMFVO istr_to_acc = new AMFVO();
    private ACC_NV_CONTROLVO accNvControlVO = new ACC_NV_CONTROLVO();
    private AMF_EXTENDEDVO amfExtendedVO = new AMF_EXTENDEDVO();
    private BigDecimal originalBODRate;

    // Account details
    private CTSTRS_ACC_DETVO ctstrsACCDETVO = new CTSTRS_ACC_DETVO();
    private String trxMgntAccountDtlGridUpdate;
    private List<TrxMgntCO> listTrxMgntAccountDtlAdd = new ArrayList<TrxMgntCO>();
    private List<TrxMgntCO> listTrxMgntAccountDtlMod = new ArrayList<TrxMgntCO>();
    private List<TrxMgntCO> listTrxMgntAccountDtlDelete = new ArrayList<TrxMgntCO>();
    private String fromTo;
    private String allowExceptions;
    private BigDecimal trxCy;

    private String terminalId;
    private String statusReasonKey;
    /**
     * for Remittance Denom management ...
     */
    private String remtDenomGridUpdate;
    private List<TrxMgntRemtDenomCO> remtDenomListAdd = new ArrayList<TrxMgntRemtDenomCO>();
    private List<TrxMgntRemtDenomCO> remtDenomListMod = new ArrayList<TrxMgntRemtDenomCO>();
    private List<TrxMgntRemtDenomCO> remtDenomListDel = new ArrayList<TrxMgntRemtDenomCO>();

    // SO Charges Details Grid
    private CTSTRS_SO_CHARGES_DETVO ctstrsSOCHARGESDETVO;

    private String trxMgntSoChargesDetGridUpdate;
    private List<CTSTRS_SO_CHARGES_DETVO> listTrxMgntSoChargesDetMod = new ArrayList<CTSTRS_SO_CHARGES_DETVO>();
    private BigDecimal infoMsg;
    private Integer infoMsgCode;
    private String[] infoMsgParam;

    /**
     * For Advance Profit Management ...
     */
    private CTSTRS_ADV_PROFVO ctstrsAdvProfVO;
    private BigDecimal net_amount;
    private COUNTRIES_REGIONVO countriesREGIONVO;
    private Integer confirmationCode;
    // Settlement and Deal Details of the Settlement Grids
    private String trxMgntSettlementGridUpdate;
    private List<TrxMgntSettlementCO> trxMgntSettlementCOs;
    private List<TrxMgntSettlementCO> trxMgntDealDetailsCOs;

    /**
     * 
     * @return
     */
    private String overdraftSettlGridUpdate;
    private List<TrxMgntOverdraftSettlCO> overdraftSettlListAdd = new ArrayList<TrxMgntOverdraftSettlCO>();
    private List<TrxMgntOverdraftSettlCO> overdraftSettlListMod = new ArrayList<TrxMgntOverdraftSettlCO>();
    private List<TrxMgntOverdraftSettlCO> overdraftSettlListDel = new ArrayList<TrxMgntOverdraftSettlCO>();

    /**
     * Outstanding Profit Management ...
     * 
     * @return
     */
    private CTSTRS_OUTSTANDING_PFTVO ctstrsOutstandingPftVO;
    private String outstandingPft_accDesc;
    private String outstandingPft_accRef;
    private BigDecimal applyNewRate;
    private String screenSrc; // instead of isMultiCHQ we specify the screen
    // source;
    private String isCalledTrxtype;
    private String prepaid;
    private String isProcessChargesTrx;
    private String drCrType;
    private String mceProceed;
    private String bulkRemitProceed;
    private BigDecimal trxType;

    /**
     * Batch Management ...
     */
    private String trxMgntBatchGridData;
    private String entryData;
    private List<TrxMgntCO> batchList = new ArrayList<TrxMgntCO>();
    private CTSBATCHVO ctsBatchVO = new CTSBATCHVO();
    private String batchType;
    private BigDecimal errorCode;
    private String errorMsg;
    private String batchStatusDesc;
    private BigDecimal clickOk = BigDecimal.ZERO;
    private BigDecimal getOrSet = BigDecimal.ZERO;
    private BigDecimal recursive = BigDecimal.ZERO;

    private String batchInformation;
    private String limitType;
    private String colName;
    private String machineID;
    private String validateProp;
    /**
     * 
     * Arralist of VOs of grids to be deleted then inserted
     */
    private List<CTSOVERDRAFT_SETTLMENTVO> ctsOverdraftSettlmentVOs = new ArrayList<CTSOVERDRAFT_SETTLMENTVO>();
    private List<CTSTRS_SO_CHARGES_DETVO> CTSTRS_SO_CHARGES_DETVOs;
    private List<TrxMgntRemtDenomCO> ctstrsRemittDenomVOs = new ArrayList<TrxMgntRemtDenomCO>();
    private List<TrxMgntAccountDtlCO/* CTSTRS_ACC_DETVO */> ctstrsACCDETVOs = new ArrayList<TrxMgntAccountDtlCO>();
    private List<TrxMgntMoreBenefCO/* CTSTRS_BENEF_DETVO */> ctstrsBENEFDETVOs = new ArrayList<TrxMgntMoreBenefCO>();
    private List<TrxMgntMoreBenefDetailsCO/* CTSTRS_BENEF_DETVO */> ctstrsBenefMoreDetailsList = new ArrayList<TrxMgntMoreBenefDetailsCO>();
    private List<TrsCurrencyDetCO> trsCurrencyDetCOs;
    // private List<TrxMgntChargesCO/* CTSTRS_CHARGES_DETVO */>
    // ctstrsCHARGESDETVOs;

    /*
     * Amf query
     */
    private String amfBriefName;
    private String amfLongName;
    private BigDecimal amfYTDBal;
    private BigDecimal amfBlockedBal;
    private BigDecimal amfAccPoints;
    private String accAddRef;

    private ArrayList<BaseException> listOfWarningMessages = new ArrayList<BaseException>();
    private String trxDefaultAcc;
    private HashMap<String, Object> addDefaultValues = new HashMap<String, Object>();
    private HashMap<String, Object> removeDefaultValues = new HashMap<String, Object>();
    private HashMap<String, Object> sessionDefaultValues = new HashMap<String, Object>();
    private String warningMsg;
    private BigDecimal refFieldLength;
    private String refMinMax;
    private String refFieldType;
    private String startWith;
    private String openCurrenciesLookup;
    private BigDecimal returnCurrencyCode;
    private String deleteAllTrxMgntAccountDtlList;
    private String deleteAllRemittDenomList;

    // Cards Management
    private CTSCARDS_MGTVO ctsCardsMgtVO = new CTSCARDS_MGTVO();
    private String reload;
    private String theMode;

    private String stOrder;
    private BigDecimal compute_2;
    private String oldTrsfrMethodValue;

    // Used to check if the user deletes the card no.
    // Value 1 means that the user deleted the card no.
    private String deleteCardNo;
    private BigDecimal windTrxType;

    private List<SelectCO> soPeriodicityDay = new ArrayList<SelectCO>();
    private List<SelectCO> cashDeductIndList = new ArrayList<SelectCO>();
    private String exch_reference;
    private String exch_reference_1;
    private String periodType;
    private BigDecimal period;
    private BigDecimal singleAmount;
    private BigDecimal totalAmount;
    private String pageKey;
    private BigDecimal isActiveSo;
    private String reloadCyDenomGrid;
    private String briefDescEngBase; // To be filled with Base Currency Brief
    // Desc from
    // sessionCO.getBaseCurrencyName()
    private String void_reason_1;
    private String trxReverseOrCancel;
    private String mainAccCif;
    private String mainAccName;
    private String secondAccName;
    private BigDecimal account_gl;
    private BigDecimal isDefaultAccount;

    /**
     * Account Details Diplay Management properties
     */
    private String hid_AC_BR = "false";
    private String hid_AC_CY = "false";
    private String hid_AC_GL = "false";
    private String hid_AC_CIF = "false";
    private String hid_AC_SL = "false";
    private String hid_LONG_NAME_ENG = "false";
    private String hid_EXCH_RATE = "false";
    private String hid_CHQ_NUM = "false";
    private String hid_SO_PERC = "false";
    private String hid_SO_PERC_MIN = "false";
    private String hid_SO_PERC_MAX = "false";
    private String hid_ACC_ADD_REF = "false";
    private String hid_INSTRUCTIONS1 = "false";
    private String instructions1;
    private String hid_INSTRUCTIONS2 = "false";
    private String hid_FC_AMOUNT = "false";
    private String hid_CV_AMOUNT = "false";
    /*
     * if transaction is Active and the transaction was retrieved from database
     * we should get the data of currency denomination from data base if exists
     */
    private String recalculateCyDenom;
    // Properties to protect/unprotect SO details and SO details charges dialog
    private BigDecimal SODetRO;
    private BigDecimal SOChargesDetRO;
    private String soChargesAction;
    // Additional Fields by Type isLoaded flag
    private List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList = new ArrayList<AdditionalFieldsByTypeCO>();

    // Alerts properties
    private String userIsBranchManager;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private List<AlertsParamCO> alertsParamCOList = new ArrayList<AlertsParamCO>();
    private Boolean alertButtonEnabled;
    private String isFromAlert;
    private String showAlertModifyButton;
    private String showAlertVoidButton;
    private String multiAppLevel;
    private BigDecimal countCtsTrsStatus;
    private String originalValueDate;
    private String isMlMessage;
    private String mlPeriodicityType;
    
    private String updateAdditionalField; // set 1 during insert new Trx and update 
    private Boolean enableAlertWhiteListButton = Boolean.FALSE;
    
    private BigDecimal cyExchTrsNo;
    private String dueAmountTransaction;
    private String cyDetType;

    private String statusReason;
    /**
     * for Format Management
     * 
     * @author marwanmaddah
     * @date Apr 25, 2013
     */
    private BigDecimal AMOUNT_FORMAT;
    private BigDecimal TRS_AC_AMOUNT_FORMAT;
    /**
     *  
     */

    // Special Conditions
    private String accountTaken; // In Case of Account Special Conditions, To
				 // Know Which Account was changed in order to
				 // know how to proceed
    private String forbidTrxOnCIF; // is_forbid_trx
    private String specialConditionReason; // is_reason
    private BigDecimal isRestricted; // is_restricted
    private List<String> listSpecialCondWarning = new ArrayList<String>(); // To
									   // fill
									   // the
									   // Special
									   // Condition
									   // Warnings
    private BigDecimal specialConditionCIF; // CIF number supplied to check if
					    // Special Conditions exist
    private String accOrCIF; // A or A1 for Account and C or C1 for CIF
    private CTSTRS_CHARGES_DETVO tvaChargesDetVO = new CTSTRS_CHARGES_DETVO();

    private String bookedEntryRepId;
    private BigDecimal returnNumber;
    private Boolean isDelete = false; // Set to True in case we are calling from
				      // Delete button
    private BigDecimal soLogChecking;
    private String afterConfirm = "false";
    private String confirmMgnt = "false";
    private String continueProcess = "false";
    
    
    private BigDecimal signAmount;
    //A:Accept ; C:Cancelled ; N; A-U: means accept sign after clicking on save, A-R: means reject sign after clicking on save (GAB160187)
    private String signReturnFlag;
    private boolean accDtlsSignBtnEnabled;
    private boolean viewAccSignMandatory;
    private boolean signViewed;
    
    
    private boolean showSign;

    //Print advice
    private List<ReportResponseCO> transferCrReportList = new ArrayList<ReportResponseCO>();
    private String transferCrReportConf;
    private List<ReportResponseCO> transferDrReportList = new ArrayList<ReportResponseCO>();
    private String transferDrReportConf;
    private List<ReportResponseCO> multiTrsfrReportList = new ArrayList<ReportResponseCO>();
    private String multiTrsfrReportConf;
    private List<ReportResponseCO> addAdviceReportList = new ArrayList<ReportResponseCO>();
    private String addAdviceReportConf;
    private List<ReportResponseCO> warningLetterReportList = new ArrayList<ReportResponseCO>();
    private String warningLetterReportConf;
    private List<ReportResponseCO> trxReportList = new ArrayList<ReportResponseCO>();
    private String trxReportConf;
    private List<ReportResponseCO> transferFromReportList = new ArrayList<ReportResponseCO>();
    private String transferFromReportConf;
    private List<ReportResponseCO> transferToReportList = new ArrayList<ReportResponseCO>();
    private String transferToReportConf;
    private String printCallBackFlag;
    private String printCallBackFunc;
    private BigDecimal fromTrxNo;
    private BigDecimal toTrxNo;
    private Boolean showWarningLetter = Boolean.FALSE;
    private Integer warningLetterCode;

    private String minorLink;
    private String chargesWaived;
    
    //suspicious cif
    private List<MosBlackListCO> suspiciousGridList = new ArrayList<MosBlackListCO>();
    private String suspiciousGridListValue;
    
    private String to_acc_name_eng;
    private String to_acc_sign;
    private String to_cif_name_eng;
    private String acc_gl_type;
    private String to_acc_gl_type;
    private String counterPartyCIFNameEng;
    
    /*
     * we added the variable clearing house here and don't use the one exists in CTSTRXTYPEVO because
     * this variable is changed on items change
     */
    private BigDecimal clearingHouse;

    private PassBookCO passBookCO = new PassBookCO();
    
    private String desc_region; 
    
    private String remitDenomValueEditable = "true";
    
    private String currencyFormat;
    
    //NABIL FEGHALI - BISI120150 - Alert Offline
    private String overDrawnVoid;
    private BigDecimal count;
    private BigDecimal totalCount;
    private String outstandingChecked = "false";
    private String openOutstandOrderWindow = "false";
    
    //Jihane TP82894 - IIAB080110 - Dues available balance; used later to know if we will send alert upon trx creation 
    private String os_s_string;
    
    private String resetDeals;
    private BigDecimal sessionID;
    
    private String deferredTrxConfMsg;
    private String chargeActionType;
    
    private String maintainHijriDate;
    //NABIL FEGHALI - Maintain Hijri dates
    private String valueDateHijri;
    private String trsDateHijri;
       
    //NABIL FEGHALI - IIAB110237 - SOA Charges
    //TRX_CHARGES: open soa report with watermark, TRX_CHARGES_APPROVE: open soa report without watermark, null or empty : don't open soa report
    private String openSOAReport;
    private CTSTRS_STATEMENTVO ctstrsStatementVO = new CTSTRS_STATEMENTVO();
    private TMP_REPORTSVOWithBLOBs tmpReportsVOWithBlobs  = new TMP_REPORTSVOWithBLOBs();
    
    private boolean openRemittDenomDialog;
    
    private String inOut;
    private BigDecimal value;
    
    private String dependencyFrom;  //TP234438
    
    private BigDecimal oldExchRate; 
     //Roland Freige - 22/01/2015 - TP#83004 - BOKI100080 - Dynamic Integration
    private String showSoRefLookup = "false";
 
    //BMOI130017
    private TrxMgntBenefCO trxMgntBenefCO = new TrxMgntBenefCO();
    private BillTypeAddReferenceCO billTypeAddReferenceCO = new BillTypeAddReferenceCO(); 
    
    //US#83030 BISI120145 - Available balance for Overdraft
    private String avail_bal_after;
    private String to_avail_bal_after;

    /*
     * BB140244, if the bank code is filled, the lookup of bank CIF will open on
     * after dependency of Account No in trxMgntNonFinancialInfo.jsp
     */
    private String bankCode;
    
    private String fromCardNoLookup;
    
    

  //DN BB150022 - John Massaad - Restrict Internal GLs From being Used by Other Branches 
    private BigDecimal internalACCBranch;
    private String restrictTrxBranches;
    
  //BB140191
    private String cardReaderEnabled; 
    
    //Roland Freige - BB140182 - Salary was posted but the online salary block failed + split of counters
    private String iisTableFilled;
    
    // TONY NOUH User Story#315732 AMANA130105 Overdraft Products
    private String alertOverDrawnAmount;
    private String alertCifWatchList;
    private String alertIisOverdueInst;
    private String alertDidntDeclProfit;
    // END TONY NOUH User Story#315732 AMANA130105 Overdraft Products
    
    private String emptySoRefDependency; /*TP #334534 invalid behavior when 2 provider exist for same trx type */
    
    //Bug # 405804 -- [John Massaad]
    private String fromField;
    private String dofDescEng, dofDescArab;
    private String billerCode;//CIF_TRXTYPE_LIMITS.ORGANIZATION_CODE
    private BigDecimal addNumber;//this field is used for webservice for multiple need
    private BigDecimal numOfShares;//this field is used for webservice for multiple need
    
    //abir Provider additional info
    private String addFieldsStr;//to save the values of provider additional Info button 
    private List<TrsTypeAddFieldsValuesCO> trsTypeAddFieldsValuesAllLst;

    private List<AccPositionSettCO> accEntriesLst = new ArrayList<AccPositionSettCO>();
    private boolean fromRetrieve;
    
    private BigDecimal deductBr;
    
    private BigDecimal firstMultiCif;
    
    private String hashCreated;
    
    private String ibBatch;//Batch Number for BB120355 - Salary file upload from IB for corporate customers
    
    private String bicCode;//Abdo ABARSI160019 14/09/2017
    private AMFVOKey entryDeductChrgVO = new AMFVOKey();//SBI160348 - 539170
    
    private boolean obligorExceed;
    
    // Raees IIS Account transfer
    private String calledFrom;
    private String mt200SwiftMessage1;
    private String mt200SwiftMessage2;
    
    /*Fx Deals*/
    private String trxMgntFxDealGridUpdates;
    private List<TrxMgntFxDealCO> trxMgntFxDealListModified = new ArrayList<TrxMgntFxDealCO>() ; 
    
    
    //Habib Baalbaki accocunt restriction 372747
    private String pageRef;
    private String currAppName;
    private S_AUDIT_ACTION_DTL_CIFVO sauditActionDtlCifVO = new S_AUDIT_ACTION_DTL_CIFVO();
    
    private int countBlackListLog;
    private BigDecimal criteriaPerc;
    private BigDecimal complianceDecision;
    private String todoAlert;
    
    //OMNI webservice
    private CURRENCIESVO currencyVO = new CURRENCIESVO();
    private String bankCifShortNameEng;
    private String transactionCurrency;
    
    private String accountOverdrawFlag;

    private Date certifiedChequeExpiryDate;
    private BigDecimal cardBranchCode;
    private BigDecimal cardAPPId;
    private String trxMgntMoreBenefDetGridUpdate;

    //Antonella Andraos BISI120155
    private ChequeScanCO chequeScanCO = new ChequeScanCO();
    
    private String sub_status_desc;
    
    private BigDecimal overdrawFromAccBr;
    private BigDecimal overdrawToAccBr;
    private String alreadyDeletedDetTMP;



    private BigDecimal zakatAmoutCV;
    private BigDecimal zakatAmoutFC;
    
    private String prizeBondTypeList; //Rania - 504699 - SBI170064 - Prize Bond Management
    private String trxRemitTypeDesc; //Rania - 504699 - SBI170064 - Prize Bond Management
    private BigDecimal denomination; //Rania - 504699 - SBI170064 - Prize Bond Management
    private RecordOfRemittanceCO recordOfRemittanceCO = new RecordOfRemittanceCO(); //Rania - 504699 - SBI170064 - Prize Bond Management
    private String reasonType;
    

    private String idTypeSwiftCode; //TP 776861 -- AUBBH150040 -- HUSSEIN EL HAJJ
    private String callingIndicator;
    
    private String CREDIT_CARD_NUMBER;
    private BigDecimal CIF;
    
    private String alertPersAccount="0"; //falha 795320 Restrict Staff transactions on personal accounts
    
    private String noMessageToDisplay; /*DBU190684*/
    //Antonella Andraos BISI120155
    private String synthesisStatusDesc;
    
    //Rania - BBLI180053 - System is not blocking trx on joint cif with staff
    private BigDecimal userCif; 
    //
    private SessionCO sessionCO;
    private ArrayList<Map<String,Object>> outputParamMapList;
    private String trxReferenceInteg;
    private String originalColName;
    
    //Rania - ABARI120283
    private Date openDate;
    private BigDecimal outstdngProfitCV;
    private BigDecimal outstdngProfitFC;
    private BigDecimal taxCV;
    private BigDecimal taxFC;
    //
    private ArrayList<SmartCO> smartCOList;
    private List<BigDecimal> lstOfChargesCodes;
    private String _soReferenceDis;
    
    private BigDecimal periodicity;
    private BigDecimal percentage;
    private BigDecimal advDistributionFC;
    private BigDecimal advDistributionCV;
    private BigDecimal csmAdvDistributionFC;
    private BigDecimal csmAdvDistributionCV;
    private BigDecimal totalAdvanceFC;
    private BigDecimal totalAdvanceCV;
    private BigDecimal accumulatedPftFC;
    private BigDecimal accumulatedPftCV;
    private BigDecimal pcsBalFC;
    private BigDecimal pcsBalCV;
    private String isAdvPft;
    
    
    private String ceftsResponceValue;
    private BigDecimal incrementalCefts;
    private BigDecimal ceftsRequestId;
    
    //Hala al Sheikh - TP947823 - AIB180060 
    private BigDecimal inverseExchangeRate;
    private BigDecimal oldInvExchRate;

    private String trxScreenRefAction; //AIBBI200117: needed to diffrenetiate between Update Existing trx and Save new
    
    //id:974654 Details:ABEI200152 - Unbalanced Entries - multi credit TAR:ABEI200152
    private BigDecimal accDtlLastRowAmount;
    
  //Hala Al Sheikh - AIBI180007 
    private String applyBlotterAlert; 
    private String blotterResponse;
    private BigDecimal blotterTimeInterval;
    private String blotterRateConfirmation;
    private String blotterCallingLevel;
    private BigDecimal blotterCyExchSeqNo;
    
    private Boolean fromWebService;
    private BigDecimal useAccount;
    private BigDecimal useToAccount;
    private BigDecimal newgainlosscvamount;
    private BigDecimal newgainlossfcamount;
    
    private Integer waiveConfirmationCode;
    private boolean soDepFromTrxType;//id:999887 Details:AUBBHU200069 - SO Invalid ending_date_key TAR:AUBBHU200069
    
    //US 386290 EWBI160012 Tony Nouh
    private String referenceNumber;
    private BigDecimal totalNumberOfCheques;
    private BigDecimal sumOfCheques;
    
    //EWBI160037 --[John Massaad]
    private String selectedSignaturesGridUpdates;
    private ArrayList<SignatureCO> signatureCOList = new ArrayList<SignatureCO>();
    private String signFromMainAcc;

   //EWBI160110 -- [John Massaad]
    private String originCountryCodeDesc;
    
    private boolean removeTempEntries;
    
    //Hasan EWBI160043 26/08/2016
    private BigDecimal numberOfBills;
    private BigDecimal sumOfBills;
    private Boolean hiddenBranchCode; 
    private BigDecimal cardReaderCivilID;
    
    private CardReaderCO cardReaderCO = new CardReaderCO();
    
    //Hasan BMO160011 03/02/2017
    private String blackListReasonDesc;
    private BigDecimal blackListReason;
    private String methodName;    
    private BigDecimal blackListReturnedValue;
    private String msgIdent;
    private Integer msgCode;
    private boolean RCVR_PCS_YN;    
    private String allowCifCreationMaskYN;
    
    private BigDecimal tryMatch;
    
    private BigDecimal cifType;
    private String fnSource;  
  //Rania
     private String proceedWithCyPurchaseSale;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTS_CIRCULAR_DEFVO	ctsCircularDefVO = new CTS_CIRCULAR_DEFVO();
    private CTS_SUB_INSTRUCTIONVO ctsSubInstructionVO = new CTS_SUB_INSTRUCTIONVO();


    private BigDecimal finalCY;
    private BigDecimal finalCif;
    
    private BigDecimal baseCurrencyCode;
    private String sbRate;
    private Date runningDate;
    private BigDecimal rate;
    
    private BigDecimal availAmount;
    
    private String loaded;
    private String specialAuthLoaded;
    private String clientDetailsloaded;
    
    private BigDecimal ceiling;
    private BigDecimal outstandingAm;
    
    private CTSTRS_EXCH_CLIENT_DETVO ctsTrsExchClientDetVO = new CTSTRS_EXCH_CLIENT_DETVO();
    private CTS_INSTRUCTIONVO ctsInstructionVO = new CTS_INSTRUCTIONVO();
    
    private String instructionDesc;
    
    private String exchOffTicketFlag;
    private String subInstrAvailFlag;
    
    private String flag;
    private String useNegoRate;
    private String cyPurchaseSaleBehavior;
    private String instrDesc;
    
    public String year;
    //End Rania
    
    private BigDecimal providerAmount;
    
    private String billPaymentAddRefBtnOpened;
    private String isToDoAlert;
    private String cifByProviderBillType;
    
    //Hala Al Sheikh 
    private BigDecimal multiTrsNo;
    private BigDecimal lineNo;
    private BigDecimal existingLineNo;
    private CTSTRS_BENEF_DET_ALERTVO ctstrsBenefDetAlertVO;
    private List<TrxMgntMoreBenefCO> ctstrsBenefDetAlertVOs = new ArrayList<TrxMgntMoreBenefCO>();
    private CTS_NON_FIN_INFO_ALERTVO ctsNonFinInfoAlertVO;
    private CTS_NON_FIN_INFOVO ctsNonFinInfoVO;
    private BigDecimal maskTrxAmtApproval;    
    private BigDecimal inputAmount;
	
	//added by maria for BMO180276
    private Date idExpiryDate;
    private String idNo;
    private String fromMethod;
    private BigDecimal nationality;
    private String gender;
    private String cardWarningMsg;    
    private String fromBreakDepOnOk;
    
    private boolean accBtnFromTrxSave;
    public BigDecimal getMaskTrxAmtApproval()
    {
        return maskTrxAmtApproval;
    }

    public void setMaskTrxAmtApproval(BigDecimal maskTrxAmtApproval)
    {
        this.maskTrxAmtApproval = maskTrxAmtApproval;
    }

    public String getCifByProviderBillType()
    {
        return cifByProviderBillType;
    }

    public void setCifByProviderBillType(String cifByProviderBillType)
    {
        this.cifByProviderBillType = cifByProviderBillType;
    }

    public boolean isFromRetrieve()
    {
        return fromRetrieve;
    }

    public void setFromRetrieve(boolean fromRetrieve)
    {
        this.fromRetrieve = fromRetrieve;
    }

    public String getFromCardNoLookup()
    {
        return fromCardNoLookup;
    }

    public void setFromCardNoLookup(String fromCardNoLookup)
    {
        this.fromCardNoLookup = fromCardNoLookup;
    }

    public boolean getOpenRemittDenomDialog()
    {
        return openRemittDenomDialog;
    }

    public void setOpenRemittDenomDialog(boolean openRemittDenomDialog)
    {
        this.openRemittDenomDialog = openRemittDenomDialog;
    }
    
    public PassBookCO getPassBookCO()
    {
	return passBookCO;
    }

    public void setPassBookCO(PassBookCO passBookCO)
    {
	this.passBookCO = passBookCO;
    }

    public String getAfterConfirm()
    {
	return afterConfirm;
    }

    public void setAfterConfirm(String afterConfirm)
    {
	this.afterConfirm = afterConfirm;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public Boolean getAlertButtonEnabled()
    {
	return alertButtonEnabled;
    }

    public void setAlertButtonEnabled(Boolean alertButtonEnabled)
    {
	this.alertButtonEnabled = alertButtonEnabled;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    private BigDecimal entityCode;

    public String getStOrder()
    {
	return stOrder;
    }

    public void setStOrder(String stOrder)
    {
	this.stOrder = stOrder;
    }

    public BigDecimal getOfficer_code()
    {
	return officer_code;
    }

    public void setOfficer_code(BigDecimal officerCode)
    {
	officer_code = officerCode;
    }

    public String getOfficer_name()
    {
	return officer_name;
    }

    public void setOfficer_name(String officerName)
    {
	officer_name = officerName;
    }

    public CTSTRSVO getCtstrsVO()
    {
	return ctstrsVO;
    }

    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
	this.ctstrsVO = ctstrsVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public CTSTRXTYPEVO getCtstrxtypeVO()
    {
	return ctstrxtypeVO;
    }

    public void setCtstrxtypeVO(CTSTRXTYPEVO ctstrxtypeVO)
    {
	this.ctstrxtypeVO = ctstrxtypeVO;
    }

    public CTSTELLERACCTYPEDETVO getCtsTellerAccTypeDetVO()
    {
	return ctsTellerAccTypeDetVO;
    }

    public String getInOut()
    {
        return inOut;
    }

    public void setInOut(String inOut)
    {
        this.inOut = inOut;
    }

    public void setCtsTellerAccTypeDetVO(CTSTELLERACCTYPEDETVO ctsTellerAccTypeDetVO)
    {
	this.ctsTellerAccTypeDetVO = ctsTellerAccTypeDetVO;
    }

    public RIFATTVO getRifAttVO()
    {
	return rifAttVO;
    }

    public void setRifAttVO(RIFATTVO rifAttVO)
    {
	this.rifAttVO = rifAttVO;
    }

    public PTH_CTRLVO getPthCtrlVO()
    {
	return pthCtrlVO;
    }

    public void setPthCtrlVO(PTH_CTRLVO pthCtrlVO)
    {
	this.pthCtrlVO = pthCtrlVO;
    }

    public REMITTANCEVO getRemittanceVO()
    {
	return remittanceVO;
    }

    public void setRemittanceVO(REMITTANCEVO remittanceVO)
    {
	this.remittanceVO = remittanceVO;
    }

    public CTSTRS_REMITT_DENOMVO getCtstrsRemittDenomVO()
    {
	return ctstrsRemittDenomVO;
    }

    public void setCtstrsRemittDenomVO(CTSTRS_REMITT_DENOMVO ctstrsRemittDenomVO)
    {
	this.ctstrsRemittDenomVO = ctstrsRemittDenomVO;
    }

    public AMFVO getAccountVO()
    {
	return accountVO;
    }

    public void setAccountVO(AMFVO accountVO)
    {
	this.accountVO = accountVO;
    }

    public EMPVO getEmpVO()
    {
	return empVO;
    }

    public void setEmpVO(EMPVO empVO)
    {
	this.empVO = empVO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getLinkedTrsMsg()
    {
	return linkedTrsMsg;
    }

    public void setLinkedTrsMsg(String linkedTrsMsg)
    {
	this.linkedTrsMsg = linkedTrsMsg;
    }

    public String getDeletionDateMsg()
    {
	return deletionDateMsg;
    }

    public void setDeletionDateMsg(String deletionDateMsg)
    {
	this.deletionDateMsg = deletionDateMsg;
    }

    public String getApprovedDateMsg()
    {
	return approvedDateMsg;
    }

    public void setApprovedDateMsg(String approvedDateMsg)
    {
	this.approvedDateMsg = approvedDateMsg;
    }

    public String getToRevDateMsg()
    {
	return toRevDateMsg;
    }

    public void setToRevDateMsg(String toRevDateMsg)
    {
	this.toRevDateMsg = toRevDateMsg;
    }

    public String getReasonDescMsg()
    {
	return reasonDescMsg;
    }

    public void setReasonDescMsg(String reasonDescMsg)
    {
	this.reasonDescMsg = reasonDescMsg;
    }

    public String getLinkOpened()
    {
	return linkOpened;
    }

    public void setLinkOpened(String linkOpened)
    {
	this.linkOpened = linkOpened;
    }

    public String getAlertMode()
    {
	return alertMode;
    }

    public void setAlertMode(String alertMode)
    {
	this.alertMode = alertMode;
    }

    public Date getRunningDateRET()
    {
	return runningDateRET;
    }

    public void setRunningDateRET(Date runningDateRET)
    {
	this.runningDateRET = runningDateRET;
    }

    public String getCif_short_name_eng()
    {
	return cif_short_name_eng;
    }

    public void setCif_short_name_eng(String cifShortNameEng)
    {
	cif_short_name_eng = cifShortNameEng;
    }

    public String getAmf_brief_name_eng()
    {
	return amf_brief_name_eng;
    }

    public void setAmf_brief_name_eng(String amfBriefNameEng)
    {
	amf_brief_name_eng = amfBriefNameEng;
    }

    public String getCtrl_acc_desc()
    {
	return ctrl_acc_desc;
    }

    public void setCtrl_acc_desc(String ctrlAccDesc)
    {
	ctrl_acc_desc = ctrlAccDesc;
    }

    public String getTo_acc_cif_desc()
    {
	return to_acc_cif_desc;
    }

    public void setTo_acc_cif_desc(String toAccCifDesc)
    {
	to_acc_cif_desc = toAccCifDesc;
    }

    public String getBill_type_desc()
    {
	return bill_type_desc;
    }

    public void setBill_type_desc(String billTypeDesc)
    {
	bill_type_desc = billTypeDesc;
    }

    public String getCurrencies_brief_desc_eng()
    {
	return currencies_brief_desc_eng;
    }

    public void setCurrencies_brief_desc_eng(String currenciesBriefDescEng)
    {
	currencies_brief_desc_eng = currenciesBriefDescEng;
    }

    public String getRifatt_brief_desc_eng()
    {
	return rifatt_brief_desc_eng;
    }

    public void setRifatt_brief_desc_eng(String rifattBriefDescEng)
    {
	rifatt_brief_desc_eng = rifattBriefDescEng;
    }

    public String getAvail_bal()
    {
	return avail_bal;
    }

    public void setAvail_bal(String availBal)
    {
	avail_bal = availBal;
    }

    public String getRound_amount()
    {
	return round_amount;
    }

    public void setRound_amount(String roundAmount)
    {
	round_amount = roundAmount;
    }

    public String getTo_acc_cy_desc()
    {
	return to_acc_cy_desc;
    }

    public void setTo_acc_cy_desc(String toAccCyDesc)
    {
	to_acc_cy_desc = toAccCyDesc;
    }

    public String getTo_acc_rifatt_desc()
    {
	return to_acc_rifatt_desc;
    }

    public void setTo_acc_rifatt_desc(String toAccRifattDesc)
    {
	to_acc_rifatt_desc = toAccRifattDesc;
    }

    public String getTo_avail_bal()
    {
	return to_avail_bal;
    }

    public void setTo_avail_bal(String toAvailBal)
    {
	to_avail_bal = toAvailBal;
    }

    public Date getChq_date_hijri()
    {
	return chq_date_hijri;
    }

    public void setChq_date_hijri(Date chqDateHijri)
    {
	chq_date_hijri = chqDateHijri;
    }

    public BigDecimal getT_instr_avail_qty_ht()
    {
	return t_instr_avail_qty_ht;
    }

    public void setT_instr_avail_qty_ht(BigDecimal tInstrAvailQtyHt)
    {
	t_instr_avail_qty_ht = tInstrAvailQtyHt;
    }

    public BigDecimal getT_instr_avail_qty_vault()
    {
	return t_instr_avail_qty_vault;
    }

    public void setT_instr_avail_qty_vault(BigDecimal tInstrAvailQtyVault)
    {
	t_instr_avail_qty_vault = tInstrAvailQtyVault;
    }

    public BigDecimal getT_total_amount()
    {
	return t_total_amount;
    }

    public void setT_total_amount(BigDecimal tTotalAmount)
    {
	t_total_amount = tTotalAmount;
    }

    public BigDecimal getT_total_ac_amount()
    {
	return t_total_ac_amount;
    }

    public void setT_total_ac_amount(BigDecimal tTotalAcAmount)
    {
	t_total_ac_amount = tTotalAcAmount;
    }

    public String getTrx_type_desc()
    {
	return trx_type_desc;
    }

    public void setTrx_type_desc(String trxTypeDesc)
    {
	trx_type_desc = trxTypeDesc;
    }

    public String getCtrl_additional_reference()
    {
	return ctrl_additional_reference;
    }

    public void setCtrl_additional_reference(String ctrlAdditionalReference)
    {
	ctrl_additional_reference = ctrlAdditionalReference;
    }

    public String getCh_ac_additional_reference()
    {
	return ch_ac_additional_reference;
    }

    public void setCh_ac_additional_reference(String chAcAdditionalReference)
    {
	ch_ac_additional_reference = chAcAdditionalReference;
    }

    public String getCharge_acc_name()
    {
	return charge_acc_name;
    }

    public void setCharge_acc_name(String chargeAccName)
    {
	charge_acc_name = chargeAccName;
    }

    public String getId_typeDesc()
    {
	return id_typeDesc;
    }

    public void setId_typeDesc(String idTypeDesc)
    {
	id_typeDesc = idTypeDesc;
    }

    public String getDepositer_nationality_desc()
    {
	return depositer_nationality_desc;
    }

    public void setDepositer_nationality_desc(String depositerNationalityDesc)
    {
	depositer_nationality_desc = depositerNationalityDesc;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public String getLinkToAnother_trxNo_desc()
    {
	return linkToAnother_trxNo_desc;
    }

    public void setLinkToAnother_trxNo_desc(String linkToAnotherTrxNoDesc)
    {
	linkToAnother_trxNo_desc = linkToAnotherTrxNoDesc;
    }

    public BigDecimal getConfirmation()
    {
	return confirmation;
    }

    public void setConfirmation(BigDecimal confirmation)
    {
	this.confirmation = confirmation;
    }

    public BigDecimal getCf_total_so_amount()
    {
	return cf_total_so_amount;
    }

    public void setCf_total_so_amount(BigDecimal cfTotalSoAmount)
    {
	cf_total_so_amount = cfTotalSoAmount;
    }

    public CTSTRS_CHARGES_DETVO getCtstrsCHARGESDETVO()
    {
	return ctstrsCHARGESDETVO;
    }

    public void setCtstrsCHARGESDETVO(CTSTRS_CHARGES_DETVO ctstrsCHARGESDETVO)
    {
	this.ctstrsCHARGESDETVO = ctstrsCHARGESDETVO;
    }

    public CTSCHARGESVO getCtsChargesVO()
    {
	return ctsChargesVO;
    }

    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
	this.ctsChargesVO = ctsChargesVO;
    }

    public String getBRIEF_NAME()
    {
	return BRIEF_NAME;
    }

    public void setBRIEF_NAME(String bRIEFNAME)
    {
	BRIEF_NAME = bRIEFNAME;
    }

    public String getDEDUCT_FROM_ACC_DESC()
    {
	return DEDUCT_FROM_ACC_DESC;
    }

    public void setDEDUCT_FROM_ACC_DESC(String dEDUCTFROMACCDESC)
    {
	DEDUCT_FROM_ACC_DESC = dEDUCTFROMACCDESC;
    }

    public String getDEDUCT_FROM_ACC_REF()
    {
	return DEDUCT_FROM_ACC_REF;
    }

    public void setDEDUCT_FROM_ACC_REF(String dEDUCTFROMACCREF)
    {
	DEDUCT_FROM_ACC_REF = dEDUCTFROMACCREF;
    }

    public String getTrxMgntChargesGridUpdate()
    {
	return trxMgntChargesGridUpdate;
    }

    public void setTrxMgntChargesGridUpdate(String trxMgntChargesGridUpdate)
    {
	this.trxMgntChargesGridUpdate = trxMgntChargesGridUpdate;
    }

    public List<TrxMgntCO> getListTrxMgntChargesMod()
    {
	return listTrxMgntChargesMod;
    }

    public void setListTrxMgntChargesMod(List<TrxMgntCO> listTrxMgntChargesMod)
    {
	this.listTrxMgntChargesMod = listTrxMgntChargesMod;
    }

    public String getTrxMgntCyDenomGridUpdate()
    {
	return trxMgntCyDenomGridUpdate;
    }

    public void setTrxMgntCyDenomGridUpdate(String trxMgntCyDenomGridUpdate)
    {
	this.trxMgntCyDenomGridUpdate = trxMgntCyDenomGridUpdate;
    }

    public BigDecimal getCOMP_COUNTRY()
    {
	return COMP_COUNTRY;
    }

    public void setCOMP_COUNTRY(BigDecimal cOMPCOUNTRY)
    {
	COMP_COUNTRY = cOMPCOUNTRY;
    }

    public String getCountry_desc()
    {
	return country_desc;
    }

    public void setCountry_desc(String countryDesc)
    {
	country_desc = countryDesc;
    }

    public String getDesc_city()
    {
	return desc_city;
    }

    public void setDesc_city(String descCity)
    {
	desc_city = descCity;
    }

    public CTSTRS_BENEF_DETVO getCtstrsBENEFDETVO()
    {
	return ctstrsBENEFDETVO;
    }

    public void setCtstrsBENEFDETVO(CTSTRS_BENEF_DETVO ctstrsBENEFDETVO)
    {
	this.ctstrsBENEFDETVO = ctstrsBENEFDETVO;
    }

    public String getTrxMgntMoreBenefGridUpdate()
    {
	return trxMgntMoreBenefGridUpdate;
    }

    public void setTrxMgntMoreBenefGridUpdate(String trxMgntMoreBenefGridUpdate)
    {
	this.trxMgntMoreBenefGridUpdate = trxMgntMoreBenefGridUpdate;
    }

    public List<TrxMgntCO> getListTrxMgntMoreBenefAdd()
    {
	return listTrxMgntMoreBenefAdd;
    }

    public void setListTrxMgntMoreBenefAdd(List<TrxMgntCO> listTrxMgntMoreBenefAdd)
    {
	this.listTrxMgntMoreBenefAdd = listTrxMgntMoreBenefAdd;
    }

    public List<TrxMgntCO> getListTrxMgntMoreBenefMod()
    {
	return listTrxMgntMoreBenefMod;
    }

    public void setListTrxMgntMoreBenefMod(List<TrxMgntCO> listTrxMgntMoreBenefMod)
    {
	this.listTrxMgntMoreBenefMod = listTrxMgntMoreBenefMod;
    }

    public List<TrxMgntCO> getListTrxMgntMoreBenefDelete()
    {
	return listTrxMgntMoreBenefDelete;
    }

    public void setListTrxMgntMoreBenefDelete(List<TrxMgntCO> listTrxMgntMoreBenefDelete)
    {
	this.listTrxMgntMoreBenefDelete = listTrxMgntMoreBenefDelete;
    }

    public CTSTRS_BREAK_DEPVO getCtstrsBREAKDEPVO()
    {
	return ctstrsBREAKDEPVO;
    }

    public void setCtstrsBREAKDEPVO(CTSTRS_BREAK_DEPVO ctstrsBREAKDEPVO)
    {
	this.ctstrsBREAKDEPVO = ctstrsBREAKDEPVO;
    }

    public BigDecimal getCY_CODE()
    {
	return CY_CODE;
    }

    public void setCY_CODE(BigDecimal cYCODE)
    {
	CY_CODE = cYCODE;
    }

    public String getT_pcs_tax()
    {
	return t_pcs_tax;
    }

    public void setT_pcs_tax(String tPcsTax)
    {
	t_pcs_tax = tPcsTax;
    }

    public String getT_pcs_charges()
    {
	return t_pcs_charges;
    }

    public void setT_pcs_charges(String tPcsCharges)
    {
	t_pcs_charges = tPcsCharges;
    }

    public String getT_tax()
    {
	return t_tax;
    }

    public void setT_tax(String tTax)
    {
	t_tax = tTax;
    }

    public String getT_commission()
    {
	return t_commission;
    }

    public void setT_commission(String tCommission)
    {
	t_commission = tCommission;
    }

    public String getT_charges()
    {
	return t_charges;
    }

    public void setT_charges(String tCharges)
    {
	t_charges = tCharges;
    }

    public BigDecimal getAcc_curr()
    {
	return acc_curr;
    }

    public void setAcc_curr(BigDecimal accCurr)
    {
	acc_curr = accCurr;
    }

    public BigDecimal getGv_curr()
    {
	return gv_curr;
    }

    public void setGv_curr(BigDecimal gvCurr)
    {
	gv_curr = gvCurr;
    }

    public CTSTRS_ACC_DETVO getCtstrsACCDETVO()
    {
	return ctstrsACCDETVO;
    }

    public void setCtstrsACCDETVO(CTSTRS_ACC_DETVO ctstrsACCDETVO)
    {
	this.ctstrsACCDETVO = ctstrsACCDETVO;
    }

    public String getTrxMgntAccountDtlGridUpdate()
    {
	return trxMgntAccountDtlGridUpdate;
    }

    public void setTrxMgntAccountDtlGridUpdate(String trxMgntAccountDtlGridUpdate)
    {
	this.trxMgntAccountDtlGridUpdate = trxMgntAccountDtlGridUpdate;
    }

    public List<TrxMgntCO> getListTrxMgntAccountDtlAdd()
    {
	return listTrxMgntAccountDtlAdd;
    }

    public void setListTrxMgntAccountDtlAdd(List<TrxMgntCO> listTrxMgntAccountDtlAdd)
    {
	this.listTrxMgntAccountDtlAdd = listTrxMgntAccountDtlAdd;
    }

    public List<TrxMgntCO> getListTrxMgntAccountDtlMod()
    {
	return listTrxMgntAccountDtlMod;
    }

    public void setListTrxMgntAccountDtlMod(List<TrxMgntCO> listTrxMgntAccountDtlMod)
    {
	this.listTrxMgntAccountDtlMod = listTrxMgntAccountDtlMod;
    }

    public List<TrxMgntCO> getListTrxMgntAccountDtlDelete()
    {
	return listTrxMgntAccountDtlDelete;
    }

    public void setListTrxMgntAccountDtlDelete(List<TrxMgntCO> listTrxMgntAccountDtlDelete)
    {
	this.listTrxMgntAccountDtlDelete = listTrxMgntAccountDtlDelete;
    }

    public String getRemtDenomGridUpdate()
    {
	return remtDenomGridUpdate;
    }

    public void setRemtDenomGridUpdate(String remtDenomGridUpdate)
    {
	this.remtDenomGridUpdate = remtDenomGridUpdate;
    }

    public List<TrxMgntRemtDenomCO> getRemtDenomListAdd()
    {
	return remtDenomListAdd;
    }

    public void setRemtDenomListAdd(List<TrxMgntRemtDenomCO> remtDenomListAdd)
    {
	this.remtDenomListAdd = remtDenomListAdd;
    }

    public List<TrxMgntRemtDenomCO> getRemtDenomListMod()
    {
	return remtDenomListMod;
    }

    public void setRemtDenomListMod(List<TrxMgntRemtDenomCO> remtDenomListMod)
    {
	this.remtDenomListMod = remtDenomListMod;
    }

    public List<TrxMgntRemtDenomCO> getRemtDenomListDel()
    {
	return remtDenomListDel;
    }

    public void setRemtDenomListDel(List<TrxMgntRemtDenomCO> remtDenomListDel)
    {
	this.remtDenomListDel = remtDenomListDel;
    }

    public CTSTRS_SO_CHARGES_DETVO getCtstrsSOCHARGESDETVO()
    {
	return ctstrsSOCHARGESDETVO;
    }

    public void setCtstrsSOCHARGESDETVO(CTSTRS_SO_CHARGES_DETVO ctstrsSOCHARGESDETVO)
    {
	this.ctstrsSOCHARGESDETVO = ctstrsSOCHARGESDETVO;
    }

    public String getTrxMgntSoChargesDetGridUpdate()
    {
	return trxMgntSoChargesDetGridUpdate;
    }

    public void setTrxMgntSoChargesDetGridUpdate(String trxMgntSoChargesDetGridUpdate)
    {
	this.trxMgntSoChargesDetGridUpdate = trxMgntSoChargesDetGridUpdate;
    }

    public List<CTSTRS_SO_CHARGES_DETVO> getListTrxMgntSoChargesDetMod()
    {
	return listTrxMgntSoChargesDetMod;
    }

    public void setListTrxMgntSoChargesDetMod(List<CTSTRS_SO_CHARGES_DETVO> listTrxMgntSoChargesDetMod)
    {
	this.listTrxMgntSoChargesDetMod = listTrxMgntSoChargesDetMod;
    }

    public BigDecimal getInfoMsg()
    {
	return infoMsg;
    }

    public void setInfoMsg(BigDecimal infoMsg)
    {
	this.infoMsg = infoMsg;
    }

    public CTSTRS_ADV_PROFVO getCtstrsAdvProfVO()
    {
	return ctstrsAdvProfVO;
    }

    public void setCtstrsAdvProfVO(CTSTRS_ADV_PROFVO ctstrsAdvProfVO)
    {
	this.ctstrsAdvProfVO = ctstrsAdvProfVO;
    }

    public BigDecimal getNet_amount()
    {
	return net_amount;
    }

    public void setNet_amount(BigDecimal netAmount)
    {
	net_amount = netAmount;
    }

    public COUNTRIES_REGIONVO getCountriesREGIONVO()
    {
	return countriesREGIONVO;
    }

    public void setCountriesREGIONVO(COUNTRIES_REGIONVO countriesREGIONVO)
    {
	this.countriesREGIONVO = countriesREGIONVO;
    }

    public String getTrxMgntSettlementGridUpdate()
    {
	return trxMgntSettlementGridUpdate;
    }

    public void setTrxMgntSettlementGridUpdate(String trxMgntSettlementGridUpdate)
    {
	this.trxMgntSettlementGridUpdate = trxMgntSettlementGridUpdate;
    }

    public String getOverdraftSettlGridUpdate()
    {
	return overdraftSettlGridUpdate;
    }

    public void setOverdraftSettlGridUpdate(String overdraftSettlGridUpdate)
    {
	this.overdraftSettlGridUpdate = overdraftSettlGridUpdate;
    }

    public List<TrxMgntOverdraftSettlCO> getOverdraftSettlListAdd()
    {
	return overdraftSettlListAdd;
    }

    public void setOverdraftSettlListAdd(List<TrxMgntOverdraftSettlCO> overdraftSettlListAdd)
    {
	this.overdraftSettlListAdd = overdraftSettlListAdd;
    }

    public List<TrxMgntOverdraftSettlCO> getOverdraftSettlListMod()
    {
	return overdraftSettlListMod;
    }

    public void setOverdraftSettlListMod(List<TrxMgntOverdraftSettlCO> overdraftSettlListMod)
    {
	this.overdraftSettlListMod = overdraftSettlListMod;
    }

    public List<TrxMgntOverdraftSettlCO> getOverdraftSettlListDel()
    {
	return overdraftSettlListDel;
    }

    public void setOverdraftSettlListDel(List<TrxMgntOverdraftSettlCO> overdraftSettlListDel)
    {
	this.overdraftSettlListDel = overdraftSettlListDel;
    }

    public String getTrxMgntBatchGridData()
    {
	return trxMgntBatchGridData;
    }

    public void setTrxMgntBatchGridData(String trxMgntBatchGridData)
    {
	this.trxMgntBatchGridData = trxMgntBatchGridData;
    }

    public List<TrxMgntCO> getBatchList()
    {
	return batchList;
    }

    public void setBatchList(List<TrxMgntCO> batchList)
    {
	this.batchList = batchList;
    }

    public CTSTRS_OUTSTANDING_PFTVO getCtstrsOutstandingPftVO()
    {
	return ctstrsOutstandingPftVO;
    }

    public void setCtstrsOutstandingPftVO(CTSTRS_OUTSTANDING_PFTVO ctstrsOutstandingPftVO)
    {
	this.ctstrsOutstandingPftVO = ctstrsOutstandingPftVO;
    }

    public String getOutstandingPft_accDesc()
    {
	return outstandingPft_accDesc;
    }

    public void setOutstandingPft_accDesc(String outstandingPftAccDesc)
    {
	outstandingPft_accDesc = outstandingPftAccDesc;
    }

    public String getOutstandingPft_accRef()
    {
	return outstandingPft_accRef;
    }

    public void setOutstandingPft_accRef(String outstandingPftAccRef)
    {
	outstandingPft_accRef = outstandingPftAccRef;
    }

    public BigDecimal getApplyNewRate()
    {
	return applyNewRate;
    }

    public void setApplyNewRate(BigDecimal applyNewRate)
    {
	this.applyNewRate = applyNewRate;
    }

    public String getScreenSrc()
    {
	return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
	this.screenSrc = screenSrc;
    }

    public String getIsCalledTrxtype()
    {
	return isCalledTrxtype;
    }

    public void setIsCalledTrxtype(String isCalledTrxtype)
    {
	this.isCalledTrxtype = isCalledTrxtype;
    }

    public String getPrepaid()
    {
	return prepaid;
    }

    public void setPrepaid(String prepaid)
    {
	this.prepaid = prepaid;
    }

    public String getIsProcessChargesTrx()
    {
	return isProcessChargesTrx;
    }

    public void setIsProcessChargesTrx(String isProcessChargesTrx)
    {
	this.isProcessChargesTrx = isProcessChargesTrx;
    }

    public String getDrCrType()
    {
	return drCrType;
    }

    public void setDrCrType(String drCrType)
    {
	this.drCrType = drCrType;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public CTSBATCHVO getCtsBatchVO()
    {
	return ctsBatchVO;
    }

    public void setCtsBatchVO(CTSBATCHVO ctsBatchVO)
    {
	this.ctsBatchVO = ctsBatchVO;
    }

    public String getBatchType()
    {
	return batchType;
    }

    public void setBatchType(String batchType)
    {
	this.batchType = batchType;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
	return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
	this.errorMsg = errorMsg;
    }

    public String getBatchStatusDesc()
    {
	return batchStatusDesc;
    }

    public void setBatchStatusDesc(String batchStatusDesc)
    {
	this.batchStatusDesc = batchStatusDesc;
    }

    public BigDecimal getClickOk()
    {
	return clickOk;
    }

    public void setClickOk(BigDecimal clickOk)
    {
	this.clickOk = clickOk;
    }

    public BigDecimal getGetOrSet()
    {
	return getOrSet;
    }

    public void setGetOrSet(BigDecimal getOrSet)
    {
	this.getOrSet = getOrSet;
    }

    public BigDecimal getRecursive()
    {
	return recursive;
    }

    public void setRecursive(BigDecimal recursive)
    {
	this.recursive = recursive;
    }

    public String getBatchInformation()
    {
	return batchInformation;
    }

    public void setBatchInformation(String batchInformation)
    {
	this.batchInformation = batchInformation;
    }

    public String getLimitType()
    {
	return limitType;
    }

    public void setLimitType(String limitType)
    {
	this.limitType = limitType;
    }

    public String getColName()
    {
	return colName;
    }

    public void setColName(String colName)
    {
	this.colName = colName;
    }

    public List<CTSOVERDRAFT_SETTLMENTVO> getCtsOverdraftSettlmentVOs()
    {
	return ctsOverdraftSettlmentVOs;
    }

    public void setCtsOverdraftSettlmentVOs(List<CTSOVERDRAFT_SETTLMENTVO> ctsOverdraftSettlmentVOs)
    {
	this.ctsOverdraftSettlmentVOs = ctsOverdraftSettlmentVOs;
    }

    public List<CTSTRS_SO_CHARGES_DETVO> getCTSTRS_SO_CHARGES_DETVOs()
    {
	return CTSTRS_SO_CHARGES_DETVOs;
    }

    public void setCTSTRS_SO_CHARGES_DETVOs(List<CTSTRS_SO_CHARGES_DETVO> cTSTRSSOCHARGESDETVOs)
    {
	CTSTRS_SO_CHARGES_DETVOs = cTSTRSSOCHARGESDETVOs;
    }

    public List<TrxMgntRemtDenomCO> getCtstrsRemittDenomVOs()
    {
	return ctstrsRemittDenomVOs;
    }

    public void setCtstrsRemittDenomVOs(List<TrxMgntRemtDenomCO> ctstrsRemittDenomVOs)
    {
	this.ctstrsRemittDenomVOs = ctstrsRemittDenomVOs;
    }

    public List<TrxMgntAccountDtlCO> getCtstrsACCDETVOs()
    {
	return ctstrsACCDETVOs;
    }

    public void setCtstrsACCDETVOs(List<TrxMgntAccountDtlCO> ctstrsACCDETVOs)
    {
	this.ctstrsACCDETVOs = ctstrsACCDETVOs;
    }

    public List<TrxMgntMoreBenefCO> getCtstrsBENEFDETVOs()
    {
	return ctstrsBENEFDETVOs;
    }

    public void setCtstrsBENEFDETVOs(List<TrxMgntMoreBenefCO> ctstrsBENEFDETVOs)
    {
	this.ctstrsBENEFDETVOs = ctstrsBENEFDETVOs;
    }

    // public List<TrxMgntChargesCO> getCtstrsCHARGESDETVOs()
    // {
    // return ctstrsCHARGESDETVOs;
    // }
    //
    // public void setCtstrsCHARGESDETVOs(List<TrxMgntChargesCO>
    // ctstrsCHARGESDETVOs)
    // {
    // this.ctstrsCHARGESDETVOs = ctstrsCHARGESDETVOs;
    // }

    public BigDecimal getAmfYTDBal()
    {
	return amfYTDBal;
    }

    public void setAmfYTDBal(BigDecimal amfYTDBal)
    {
	this.amfYTDBal = amfYTDBal;
    }

    public BigDecimal getAmfBlockedBal()
    {
	return amfBlockedBal;
    }

    public void setAmfBlockedBal(BigDecimal amfBlockedBal)
    {
	this.amfBlockedBal = amfBlockedBal;
    }

    public BigDecimal getAmfAccPoints()
    {
	return amfAccPoints;
    }

    public void setAmfAccPoints(BigDecimal amfAccPoints)
    {
	this.amfAccPoints = amfAccPoints;
    }

    public Integer getActiveSO()
    {
	return activeSO;
    }

    public void setActiveSO(Integer activeSO)
    {
	this.activeSO = activeSO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public String getValidateProp()
    {
	return validateProp;
    }

    public void setValidateProp(String validateProp)
    {
	this.validateProp = validateProp;
    }

    public String getAutoApprove()
    {
	return autoApprove;
    }

    public void setAutoApprove(String autoApprove)
    {
	this.autoApprove = autoApprove;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public GEN_LEDGERVO getGenLedgerVO()
    {
	return genLedgerVO;
    }

    public void setGenLedgerVO(GEN_LEDGERVO genLedgerVO)
    {
	this.genLedgerVO = genLedgerVO;
    }

    public ArrayList<BaseException> getListOfWarningMessages()
    {
	return listOfWarningMessages;
    }

    public void setListOfWarningMessages(ArrayList<BaseException> listOfWarningMessages)
    {
	this.listOfWarningMessages = listOfWarningMessages;
    }

    public String getTrxDefaultAcc()
    {
	return trxDefaultAcc;
    }

    public void setTrxDefaultAcc(String trxDefaultAcc)
    {
	this.trxDefaultAcc = trxDefaultAcc;
    }

    public HashMap<String, Object> getAddDefaultValues()
    {
	return addDefaultValues;
    }

    public void setAddDefaultValues(HashMap<String, Object> addDefaultValues)
    {
	this.addDefaultValues = addDefaultValues;
    }

    public HashMap<String, Object> getRemoveDefaultValues()
    {
	return removeDefaultValues;
    }

    public void setRemoveDefaultValues(HashMap<String, Object> removeDefaultValues)
    {
	this.removeDefaultValues = removeDefaultValues;
    }

    public HashMap<String, Object> getSessionDefaultValues()
    {
	return sessionDefaultValues;
    }

    public void setSessionDefaultValues(HashMap<String, Object> sessionDefaultValues)
    {
	this.sessionDefaultValues = sessionDefaultValues;
    }

    /**
     * @return the trxBranch_Desc
     */
    public String getTrxBranch_Desc()
    {
	return trxBranch_Desc;
    }

    /**
     * @param trxBranchDesc the trxBranch_Desc to set
     */
    public void setTrxBranch_Desc(String trxBranchDesc)
    {
	trxBranch_Desc = trxBranchDesc;
    }

    /**
     * @return the to_acc_desc
     */
    public String getTo_acc_desc()
    {
	return to_acc_desc;
    }

    /**
     * @param toAccDesc the to_acc_desc to set
     */
    public void setTo_acc_desc(String toAccDesc)
    {
	to_acc_desc = toAccDesc;
    }

    public String getVipAlert()
    {
	return vipAlert;
    }

    public void setVipAlert(String vipAlert)
    {
	this.vipAlert = vipAlert;
    }

    public String getVipAlert1()
    {
	return vipAlert1;
    }

    public void setVipAlert1(String vipAlert1)
    {
	this.vipAlert1 = vipAlert1;
    }

    public BigDecimal getCyDecimalPoints()
    {
	return cyDecimalPoints;
    }

    public void setCyDecimalPoints(BigDecimal cyDecimalPoints)
    {
	this.cyDecimalPoints = cyDecimalPoints;
    }

    public Integer getInfoMsgCode()
    {
	return infoMsgCode;
    }

    public void setInfoMsgCode(Integer infoMsgCode)
    {
	this.infoMsgCode = infoMsgCode;
    }

    public RIFCTTVO getRifCttVO()
    {
	return rifCttVO;
    }

    public void setRifCttVO(RIFCTTVO rifCttVO)
    {
	this.rifCttVO = rifCttVO;
    }

    public String getAmfBriefName()
    {
	return amfBriefName;
    }

    public void setAmfBriefName(String amfBriefName)
    {
	this.amfBriefName = amfBriefName;
    }

    public String getAmfLongName()
    {
	return amfLongName;
    }

    public void setAmfLongName(String amfLongName)
    {
	this.amfLongName = amfLongName;
    }

    public TrxChargesCO getTrxChargesCO()
    {
	return trxChargesCO;
    }

    public void setTrxChargesCO(TrxChargesCO trxChargesCO)
    {
	this.trxChargesCO = trxChargesCO;
    }

    public AccountCO getDeductChargeAccountCO()
    {
	return deductChargeAccountCO;
    }

    public void setDeductChargeAccountCO(AccountCO deductChargeAccountCO)
    {
	this.deductChargeAccountCO = deductChargeAccountCO;
    }

    public String getIsBank()
    {
	return isBank;
    }

    public void setIsBank(String isBank)
    {
	this.isBank = isBank;
    }

    public String[] getInfoMsgParam()
    {
	return infoMsgParam;
    }

    public void setInfoMsgParam(String... infoMsgParam)
    {
	this.infoMsgParam = infoMsgParam;
    }

    public String getWarningMsg()
    {
	return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
	this.warningMsg = warningMsg;
    }

    public BigDecimal getRefFieldLength()
    {
	return refFieldLength;
    }

    public void setRefFieldLength(BigDecimal refFieldLength)
    {
	this.refFieldLength = refFieldLength;
    }

    public String getRefMinMax()
    {
	return refMinMax;
    }

    public void setRefMinMax(String refMinMax)
    {
	this.refMinMax = refMinMax;
    }

    public String getRefFieldType()
    {
	return refFieldType;
    }

    public void setRefFieldType(String refFieldType)
    {
	this.refFieldType = refFieldType;
    }

    public String getStartWith()
    {
	return startWith;
    }

    public void setStartWith(String startWith)
    {
	this.startWith = startWith;
    }

    public CTSCARDS_MGTVO getCtsCardsMgtVO()
    {
	return ctsCardsMgtVO;
    }

    public void setCtsCardsMgtVO(CTSCARDS_MGTVO ctsCardsMgtVO)
    {
	this.ctsCardsMgtVO = ctsCardsMgtVO;
    }

    public String getReload()
    {
	return reload;
    }

    public void setReload(String reload)
    {
	this.reload = reload;
    }

    public String getOpenCurrenciesLookup()
    {
	return openCurrenciesLookup;
    }

    public void setOpenCurrenciesLookup(String openCurrenciesLookup)
    {
	this.openCurrenciesLookup = openCurrenciesLookup;
    }

    public BigDecimal getReturnCurrencyCode()
    {
	return returnCurrencyCode;
    }

    public void setReturnCurrencyCode(BigDecimal returnCurrencyCode)
    {
	this.returnCurrencyCode = returnCurrencyCode;
    }

    public String getDeleteAllTrxMgntAccountDtlList()
    {
	return deleteAllTrxMgntAccountDtlList;
    }

    public void setDeleteAllTrxMgntAccountDtlList(String deleteAllTrxMgntAccountDtlList)
    {
	this.deleteAllTrxMgntAccountDtlList = deleteAllTrxMgntAccountDtlList;
    }

    public String getDeleteAllRemittDenomList()
    {
	return deleteAllRemittDenomList;
    }

    public void setDeleteAllRemittDenomList(String deleteAllRemittDenomList)
    {
	this.deleteAllRemittDenomList = deleteAllRemittDenomList;
    }

    public BigDecimal getChargeSchema()
    {
	return chargeSchema;
    }

    public void setChargeSchema(BigDecimal chargeSchema)
    {
	this.chargeSchema = chargeSchema;
    }

    public BigDecimal getCompute_2()
    {
	return compute_2;
    }

    public void setCompute_2(BigDecimal compute_2)
    {
	this.compute_2 = compute_2;
    }

    public CTSTRSSTATUSVO getCtstrsstatusVO()
    {
	return ctstrsstatusVO;
    }

    public void setCtstrsstatusVO(CTSTRSSTATUSVO ctstrsstatusVO)
    {
	this.ctstrsstatusVO = ctstrsstatusVO;
    }

    public CTSSTATUSVO getCtsstatusVO()
    {
	return ctsstatusVO;
    }

    public void setCtsstatusVO(CTSSTATUSVO ctsstatusVO)
    {
	this.ctsstatusVO = ctsstatusVO;
    }

    public String getConfirmMsg()
    {
	return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
	this.confirmMsg = confirmMsg;
    }

    public String getTotalAccount()
    {
	return totalAccount;
    }

    public void setTotalAccount(String totalAccount)
    {
	this.totalAccount = totalAccount;
    }

    public String getOldTrsfrMethodValue()
    {
	return oldTrsfrMethodValue;
    }

    public void setOldTrsfrMethodValue(String oldTrsfrMethodValue)
    {
	this.oldTrsfrMethodValue = oldTrsfrMethodValue;
    }

    public String getDeleteCardNo()
    {
	return deleteCardNo;
    }

    public void setDeleteCardNo(String deleteCardNo)
    {
	this.deleteCardNo = deleteCardNo;
    }

    public USR_LEVELVO getUsrLevelVO()
    {
	return usrLevelVO;
    }

    public void setUsrLevelVO(USR_LEVELVO usrLevelVO)
    {
	this.usrLevelVO = usrLevelVO;
    }

    public CTSTRXTYPE_STATUSVO getCtsTrxTypeStatusVO()
    {
	return ctsTrxTypeStatusVO;
    }

    public void setCtsTrxTypeStatusVO(CTSTRXTYPE_STATUSVO ctsTrxTypeStatusVO)
    {
	this.ctsTrxTypeStatusVO = ctsTrxTypeStatusVO;
    }

    public String getAccAddRef()
    {
	return accAddRef;
    }

    public void setAccAddRef(String accAddRef)
    {
	this.accAddRef = accAddRef;
    }

    public BigDecimal getBaseCyDecimalPoints()
    {
	return baseCyDecimalPoints;
    }

    public void setBaseCyDecimalPoints(BigDecimal baseCyDecimalPoints)
    {
	this.baseCyDecimalPoints = baseCyDecimalPoints;
    }

    public String getTheMode()
    {
	return theMode;
    }

    public void setTheMode(String theMode)
    {
	this.theMode = theMode;
    }

    public List<SelectCO> getSoPeriodicityDay()
    {
	return soPeriodicityDay;
    }

    public void setSoPeriodicityDay(List<SelectCO> soPeriodicityDay)
    {
	this.soPeriodicityDay = soPeriodicityDay;
    }

    public CTSTRS_ALERTVO getCtstrsAlertVO()
    {
	return ctstrsAlertVO;
    }

    public void setCtstrsAlertVO(CTSTRS_ALERTVO ctstrsAlertVO)
    {
	this.ctstrsAlertVO = ctstrsAlertVO;
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

    public String getExch_reference()
    {
	return exch_reference;
    }

    public void setExch_reference(String exchReference)
    {
	exch_reference = exchReference;
    }

    public String getExch_reference_1()
    {
	return exch_reference_1;
    }

    public void setExch_reference_1(String exchReference_1)
    {
	exch_reference_1 = exchReference_1;
    }

    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public String getPeriodType()
    {
	return periodType;
    }

    public void setPeriodType(String periodType)
    {
	this.periodType = periodType;
    }

    public BigDecimal getPeriod()
    {
	return period;
    }

    public void setPeriod(BigDecimal period)
    {
	this.period = period;
    }

    public BigDecimal getSingleAmount()
    {
	return singleAmount;
    }

    public void setSingleAmount(BigDecimal singleAmount)
    {
	this.singleAmount = singleAmount;
    }

    public BigDecimal getTotalAmount()
    {
	return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
	this.totalAmount = totalAmount;
    }

    /**
     * @return the pageKey
     */
    public String getPageKey()
    {
	return pageKey;
    }

    /**
     * @param pageKey the pageKey to set
     */
    public void setPageKey(String pageKey)
    {
	this.pageKey = pageKey;
    }

    public String getAmdendedCharges()
    {
	return amdendedCharges;
    }

    public void setAmdendedCharges(String amdendedCharges)
    {
	this.amdendedCharges = amdendedCharges;
    }

    public BigDecimal getNet_amount_t()
    {
	return net_amount_t;
    }

    public void setNet_amount_t(BigDecimal netAmountT)
    {
	net_amount_t = netAmountT;
    }

    public BigDecimal getPcs_netprofit_fc()
    {
	return pcs_netprofit_fc;
    }

    public void setPcs_netprofit_fc(BigDecimal pcsNetprofitFc)
    {
	pcs_netprofit_fc = pcsNetprofitFc;
    }

    public BigDecimal getPcs_netprofit_cv()
    {
	return pcs_netprofit_cv;
    }

    public void setPcs_netprofit_cv(BigDecimal pcsNetprofitCv)
    {
	pcs_netprofit_cv = pcsNetprofitCv;
    }

    /**
     * @return the isActiveSo
     */
    public BigDecimal getIsActiveSo()
    {
	return isActiveSo;
    }

    /**
     * @param isActiveSo the isActiveSo to set
     */
    public void setIsActiveSo(BigDecimal isActiveSo)
    {
	this.isActiveSo = isActiveSo;
    }

    public List<TrsCurrencyDetCO> getTrsCurrencyDetCOs()
    {
	return trsCurrencyDetCOs;
    }

    public void setTrsCurrencyDetCOs(List<TrsCurrencyDetCO> trsCurrencyDetCOs)
    {
	this.trsCurrencyDetCOs = trsCurrencyDetCOs;
    }

    public String getBriefDescEngBase()
    {
	return briefDescEngBase;
    }

    public void setBriefDescEngBase(String briefDescEngBase)
    {
	this.briefDescEngBase = briefDescEngBase;
    }

    public String getReloadCyDenomGrid()
    {
	return reloadCyDenomGrid;
    }

    public void setReloadCyDenomGrid(String reloadCyDenomGrid)
    {
	this.reloadCyDenomGrid = reloadCyDenomGrid;
    }

    public CTSMEMO_DETVO getCtsmemoDETVO()
    {
	return ctsmemoDETVO;
    }

    public void setCtsmemoDETVO(CTSMEMO_DETVO ctsmemoDETVO)
    {
	this.ctsmemoDETVO = ctsmemoDETVO;
    }

    /**
     * @return the void_reason_1
     */
    public String getVoid_reason_1()
    {
	return void_reason_1;
    }

    /**
     * @param voidReason_1 the void_reason_1 to set
     */
    public void setVoid_reason_1(String voidReason_1)
    {
	void_reason_1 = voidReason_1;
    }

    public BigDecimal getTotalAmountInBaseCy()
    {
	return totalAmountInBaseCy;
    }

    public void setTotalAmountInBaseCy(BigDecimal totalAmountInBaseCy)
    {
	this.totalAmountInBaseCy = totalAmountInBaseCy;
    }

    public BigDecimal getTotalAmountInCy()
    {
	return totalAmountInCy;
    }

    public void setTotalAmountInCy(BigDecimal totalAmountInCy)
    {
	this.totalAmountInCy = totalAmountInCy;
    }

    public String getTrxReverseOrCancel()
    {
	return trxReverseOrCancel;
    }

    public void setTrxReverseOrCancel(String trxReverseOrCancel)
    {
	this.trxReverseOrCancel = trxReverseOrCancel;
    }

    public String getRecalculateCyDenom()
    {
	return recalculateCyDenom;
    }

    public void setRecalculateCyDenom(String recalculateCyDenom)
    {
	this.recalculateCyDenom = recalculateCyDenom;
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

    public String getMainAccCif()
    {
	return mainAccCif;
    }

    public void setMainAccCif(String mainAccCif)
    {
	this.mainAccCif = mainAccCif;
    }

    public String getFromTo()
    {
	return fromTo;
    }

    public void setFromTo(String fromTo)
    {
	this.fromTo = fromTo;
    }

    public BigDecimal getIsDefaultAccount()
    {
	return isDefaultAccount;
    }

    public void setIsDefaultAccount(BigDecimal isDefaultAccount)
    {
	this.isDefaultAccount = isDefaultAccount;
    }

    public BigDecimal getTrxCy()
    {
	return trxCy;
    }

    public void setTrxCy(BigDecimal trxCy)
    {
	this.trxCy = trxCy;
    }

    /**
     * @return the hid_AC_BR
     */
    public String getHid_AC_BR()
    {
	return hid_AC_BR;
    }

    /**
     * @param hidACBR the hid_AC_BR to set
     */
    public void setHid_AC_BR(String hidACBR)
    {
	hid_AC_BR = hidACBR;
    }

    /**
     * @return the hid_AC_CY
     */
    public String getHid_AC_CY()
    {
	return hid_AC_CY;
    }

    /**
     * @param hidACCY the hid_AC_CY to set
     */
    public void setHid_AC_CY(String hidACCY)
    {
	hid_AC_CY = hidACCY;
    }

    /**
     * @return the hid_AC_GL
     */
    public String getHid_AC_GL()
    {
	return hid_AC_GL;
    }

    /**
     * @param hidACGL the hid_AC_GL to set
     */
    public void setHid_AC_GL(String hidACGL)
    {
	hid_AC_GL = hidACGL;
    }

    /**
     * @return the hid_AC_CIF
     */
    public String getHid_AC_CIF()
    {
	return hid_AC_CIF;
    }

    /**
     * @param hidACCIF the hid_AC_CIF to set
     */
    public void setHid_AC_CIF(String hidACCIF)
    {
	hid_AC_CIF = hidACCIF;
    }

    /**
     * @return the hid_AC_SL
     */
    public String getHid_AC_SL()
    {
	return hid_AC_SL;
    }

    /**
     * @param hidACSL the hid_AC_SL to set
     */
    public void setHid_AC_SL(String hidACSL)
    {
	hid_AC_SL = hidACSL;
    }

    /**
     * @return the hid_LONG_NAME_ENG
     */
    public String getHid_LONG_NAME_ENG()
    {
	return hid_LONG_NAME_ENG;
    }

    /**
     * @param hidLONGNAMEENG the hid_LONG_NAME_ENG to set
     */
    public void setHid_LONG_NAME_ENG(String hidLONGNAMEENG)
    {
	hid_LONG_NAME_ENG = hidLONGNAMEENG;
    }

    /**
     * @return the hid_EXCH_RATE
     */
    public String getHid_EXCH_RATE()
    {
	return hid_EXCH_RATE;
    }

    /**
     * @param hidEXCHRATE the hid_EXCH_RATE to set
     */
    public void setHid_EXCH_RATE(String hidEXCHRATE)
    {
	hid_EXCH_RATE = hidEXCHRATE;
    }

    /**
     * @return the hid_CHQ_NUM
     */
    public String getHid_CHQ_NUM()
    {
	return hid_CHQ_NUM;
    }

    /**
     * @param hidCHQNUM the hid_CHQ_NUM to set
     */
    public void setHid_CHQ_NUM(String hidCHQNUM)
    {
	hid_CHQ_NUM = hidCHQNUM;
    }

    /**
     * @return the hid_SO_PERC
     */
    public String getHid_SO_PERC()
    {
	return hid_SO_PERC;
    }

    /**
     * @param hidSOPERC the hid_SO_PERC to set
     */
    public void setHid_SO_PERC(String hidSOPERC)
    {
	hid_SO_PERC = hidSOPERC;
    }

    /**
     * @return the hid_SO_PERC_MIN
     */
    public String getHid_SO_PERC_MIN()
    {
	return hid_SO_PERC_MIN;
    }

    /**
     * @param hidSOPERCMIN the hid_SO_PERC_MIN to set
     */
    public void setHid_SO_PERC_MIN(String hidSOPERCMIN)
    {
	hid_SO_PERC_MIN = hidSOPERCMIN;
    }

    /**
     * @return the hid_SO_PERC_MAX
     */
    public String getHid_SO_PERC_MAX()
    {
	return hid_SO_PERC_MAX;
    }

    /**
     * @param hidSOPERCMAX the hid_SO_PERC_MAX to set
     */
    public void setHid_SO_PERC_MAX(String hidSOPERCMAX)
    {
	hid_SO_PERC_MAX = hidSOPERCMAX;
    }

    /**
     * @return the hid_ACC_ADD_REF
     */
    public String getHid_ACC_ADD_REF()
    {
	return hid_ACC_ADD_REF;
    }

    /**
     * @param hidACCADDREF the hid_ACC_ADD_REF to set
     */
    public void setHid_ACC_ADD_REF(String hidACCADDREF)
    {
	hid_ACC_ADD_REF = hidACCADDREF;
    }

    /**
     * @return the hid_INSTRUCTIONS1
     */
    public String getHid_INSTRUCTIONS1()
    {
	return hid_INSTRUCTIONS1;
    }

    /**
     * @param hidINSTRUCTIONS1 the hid_INSTRUCTIONS1 to set
     */
    public void setHid_INSTRUCTIONS1(String hidINSTRUCTIONS1)
    {
	hid_INSTRUCTIONS1 = hidINSTRUCTIONS1;
    }

    /**
     * @return the hid_INSTRUCTIONS2
     */
    public String getHid_INSTRUCTIONS2()
    {
	return hid_INSTRUCTIONS2;
    }

    /**
     * @param hidINSTRUCTIONS2 the hid_INSTRUCTIONS2 to set
     */
    public void setHid_INSTRUCTIONS2(String hidINSTRUCTIONS2)
    {
	hid_INSTRUCTIONS2 = hidINSTRUCTIONS2;
    }

    /**
     * @return the hid_FC_AMOUNT
     */
    public String getHid_FC_AMOUNT()
    {
	return hid_FC_AMOUNT;
    }

    /**
     * @param hidFCAMOUNT the hid_FC_AMOUNT to set
     */
    public void setHid_FC_AMOUNT(String hidFCAMOUNT)
    {
	hid_FC_AMOUNT = hidFCAMOUNT;
    }

    /**
     * @return the hid_CV_AMOUNT
     */
    public String getHid_CV_AMOUNT()
    {
	return hid_CV_AMOUNT;
    }

    /**
     * @param hidCVAMOUNT the hid_CV_AMOUNT to set
     */
    public void setHid_CV_AMOUNT(String hidCVAMOUNT)
    {
	hid_CV_AMOUNT = hidCVAMOUNT;
    }

    public String getActionStr()
    {
	return actionStr;
    }

    public void setActionStr(String actionStr)
    {
	this.actionStr = actionStr;
    }

    /**
     * @return the chargesEmpty
     */
    public String getChargesEmpty()
    {
	return chargesEmpty;
    }

    /**
     * @param chargesEmpty the chargesEmpty to set
     */
    public void setChargesEmpty(String chargesEmpty)
    {
	this.chargesEmpty = chargesEmpty;
    }

    public BigDecimal getSODetRO()
    {
	return SODetRO;
    }

    public void setSODetRO(BigDecimal sODetRO)
    {
	SODetRO = sODetRO;
    }

    public BigDecimal getSOChargesDetRO()
    {
	return SOChargesDetRO;
    }

    public void setSOChargesDetRO(BigDecimal sOChargesDetRO)
    {
	SOChargesDetRO = sOChargesDetRO;
    }

    public TrxSOChargesCO getTrxSOChargesCO()
    {
	return trxSOChargesCO;
    }

    public void setTrxSOChargesCO(TrxSOChargesCO trxSOChargesCO)
    {
	this.trxSOChargesCO = trxSOChargesCO;
    }

    public String getAllowExceptions()
    {
	return allowExceptions;
    }

    public void setAllowExceptions(String allowExceptions)
    {
	this.allowExceptions = allowExceptions;
    }

    /**
     * @return the soChargesAction
     */
    public String getSoChargesAction()
    {
	return soChargesAction;
    }

    /**
     * @param soChargesAction the soChargesAction to set
     */
    public void setSoChargesAction(String soChargesAction)
    {
	this.soChargesAction = soChargesAction;
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
	this.alertsParamCO = alertsParamCO;
    }

    /**
     * @return the soChargesEmpty
     */
    public String getSoChargesEmpty()
    {
	return soChargesEmpty;
    }

    /**
     * @param soChargesEmpty the soChargesEmpty to set
     */
    public void setSoChargesEmpty(String soChargesEmpty)
    {
	this.soChargesEmpty = soChargesEmpty;
    }

    public BigDecimal getEntityCode()
    {
	return entityCode;
    }

    public void setEntityCode(BigDecimal entityCode)
    {
	this.entityCode = entityCode;
    }

    /**
     * @return the terminalId
     */
    public String getTerminalId()
    {
	return terminalId;
    }

    /**
     * @param terminalId the terminalId to set
     */
    public void setTerminalId(String terminalId)
    {
	this.terminalId = terminalId;
    }

    public BigDecimal getCyExchTrsNo()
    {
	return cyExchTrsNo;
    }

    public void setCyExchTrsNo(BigDecimal cyExchTrsNo)
    {
	this.cyExchTrsNo = cyExchTrsNo;
    }

    public String getDueAmountTransaction()
    {
	return dueAmountTransaction;
    }

    public void setDueAmountTransaction(String dueAmountTransaction)
    {
	this.dueAmountTransaction = dueAmountTransaction;
    }

    public String getShowAlertModifyButton()
    {
	return showAlertModifyButton;
    }

    public void setShowAlertModifyButton(String showAlertModifyButton)
    {
	this.showAlertModifyButton = showAlertModifyButton;
    }

    public String getShowAlertVoidButton()
    {
	return showAlertVoidButton;
    }

    public void setShowAlertVoidButton(String showAlertVoidButton)
    {
	this.showAlertVoidButton = showAlertVoidButton;
    }

    public String getMultiAppLevel()
    {
	return multiAppLevel;
    }

    public void setMultiAppLevel(String multiAppLevel)
    {
	this.multiAppLevel = multiAppLevel;
    }

    public BigDecimal getCountCtsTrsStatus()
    {
	return countCtsTrsStatus;
    }

    public void setCountCtsTrsStatus(BigDecimal countCtsTrsStatus)
    {
	this.countCtsTrsStatus = countCtsTrsStatus;
    }

    /**
     * @return the statusReason
     */
    public String getStatusReason()
    {
	return statusReason;
    }

    /**
     * @param statusReason the statusReason to set
     */
    public void setStatusReason(String statusReason)
    {
	this.statusReason = statusReason;
    }

    /**
     * @return the statusReasonKey
     */
    public String getStatusReasonKey()
    {
	return statusReasonKey;
    }

    /**
     * @param statusReasonKey the statusReasonKey to set
     */
    public void setStatusReasonKey(String statusReasonKey)
    {
	this.statusReasonKey = statusReasonKey;
    }

    public List<String> getListWarningMsg()
    {
	return listWarningMsg;
    }

    public void setListWarningMsg(List<String> listWarningMsg)
    {
	this.listWarningMsg = listWarningMsg;
    }

    public BigDecimal getLineNum()
    {
	return lineNum;
    }

    public void setLineNum(BigDecimal lineNum)
    {
	this.lineNum = lineNum;
    }

    /**
     * @return the aMOUNT_FORMAT
     */
    public BigDecimal getAMOUNT_FORMAT()
    {
	return AMOUNT_FORMAT;
    }

    /**
     * @param aMOUNTFORMAT the aMOUNT_FORMAT to set
     */
    public void setAMOUNT_FORMAT(BigDecimal aMOUNTFORMAT)
    {
	AMOUNT_FORMAT = aMOUNTFORMAT;
    }

    /**
     * @return the tRS_AC_AMOUNT_FORMAT
     */
    public BigDecimal getTRS_AC_AMOUNT_FORMAT()
    {
	return TRS_AC_AMOUNT_FORMAT;
    }

    /**
     * @param tRSACAMOUNTFORMAT the tRS_AC_AMOUNT_FORMAT to set
     */
    public void setTRS_AC_AMOUNT_FORMAT(BigDecimal tRSACAMOUNTFORMAT)
    {
	TRS_AC_AMOUNT_FORMAT = tRSACAMOUNTFORMAT;
    }

    public String getMachineID()
    {
	return machineID;
    }

    public void setMachineID(String machineID)
    {
	this.machineID = machineID;
    }

    public String getMceProceed()
    {
	return mceProceed;
    }

    public void setMceProceed(String mceProceed)
    {
	this.mceProceed = mceProceed;
    }

    public String getAccountTaken()
    {
	return accountTaken;
    }

    public void setAccountTaken(String accountTaken)
    {
	this.accountTaken = accountTaken;
    }

    public String getForbidTrxOnCIF()
    {
	return forbidTrxOnCIF;
    }

    public void setForbidTrxOnCIF(String forbidTrxOnCIF)
    {
	this.forbidTrxOnCIF = forbidTrxOnCIF;
    }

    public String getSpecialConditionReason()
    {
	return specialConditionReason;
    }

    public void setSpecialConditionReason(String specialConditionReason)
    {
	this.specialConditionReason = specialConditionReason;
    }

    public BigDecimal getIsRestricted()
    {
	return isRestricted;
    }

    public void setIsRestricted(BigDecimal isRestricted)
    {
	this.isRestricted = isRestricted;
    }

    public List<String> getListSpecialCondWarning()
    {
	return listSpecialCondWarning;
    }

    public void setListSpecialCondWarning(List<String> listSpecialCondWarning)
    {
	this.listSpecialCondWarning = listSpecialCondWarning;
    }

    public BigDecimal getSpecialConditionCIF()
    {
	return specialConditionCIF;
    }

    public void setSpecialConditionCIF(BigDecimal specialConditionCIF)
    {
	this.specialConditionCIF = specialConditionCIF;
    }

    public String getAccOrCIF()
    {
	return accOrCIF;
    }

    public void setAccOrCIF(String accOrCIF)
    {
	this.accOrCIF = accOrCIF;
    }

    public List<AlertsParamCO> getAlertsParamCOList()
    {
	return alertsParamCOList;
    }

    public void setAlertsParamCOList(List<AlertsParamCO> alertsParamCOList)
    {
	this.alertsParamCOList = alertsParamCOList;
    }

    /**
     * @return the tvaChargesDetVO
     */
    public CTSTRS_CHARGES_DETVO getTvaChargesDetVO()
    {
	return tvaChargesDetVO;
    }

    /**
     * @param tvaChargesDetVO the tvaChargesDetVO to set
     */
    public void setTvaChargesDetVO(CTSTRS_CHARGES_DETVO tvaChargesDetVO)
    {
	this.tvaChargesDetVO = tvaChargesDetVO;
    }

    public String getBookedEntryRepId()
    {
	return bookedEntryRepId;
    }

    public void setBookedEntryRepId(String bookedEntryRepId)
    {
	this.bookedEntryRepId = bookedEntryRepId;
    }

    
    public String getOriginalValueDate()
    {
        return originalValueDate;
    }

    public void setOriginalValueDate(String originalValueDate)
    {
        this.originalValueDate = originalValueDate;
    }

    public String getIsMlMessage()
    {
	return isMlMessage;
    }

    public void setIsMlMessage(String isMlMessage)
    {
	this.isMlMessage = isMlMessage;
    }

    public BigDecimal getReturnNumber()
    {
	return returnNumber;
    }

    public void setReturnNumber(BigDecimal returnNumber)
    {
	this.returnNumber = returnNumber;
    }

    public boolean isAutoApproveSuccess()
    {
	return autoApproveSuccess;
    }

    public void setAutoApproveSuccess(boolean autoApproveSuccess)
    {
	this.autoApproveSuccess = autoApproveSuccess;
    }

    public Boolean getSuppressMessage()
    {
	return suppressMessage;
    }

    public void setSuppressMessage(Boolean suppressMessage)
    {
	this.suppressMessage = suppressMessage;
    }

    public Boolean getIsDelete()
    {
	return isDelete;
    }

    public void setIsDelete(Boolean isDelete)
    {
	this.isDelete = isDelete;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    /**
     * @return the lstOfChargesCodes
     */
    public List<BigDecimal> getLstOfChargesCodes()
    {
	return lstOfChargesCodes;
    }

    /**
     * @param lstOfChargesCodes the lstOfChargesCodes to set
     */
    public void setLstOfChargesCodes(List<BigDecimal> lstOfChargesCodes)
    {
	this.lstOfChargesCodes = lstOfChargesCodes;
    }

    /**
     * @return the _soReferenceDis
     */
    public String get_soReferenceDis()
    {
	return _soReferenceDis;
    }

    /**
     * @param soReferenceDis the _soReferenceDis to set
     */
    public void set_soReferenceDis(String soReferenceDis)
    {
	_soReferenceDis = soReferenceDis;
    }

    /**
     * @return the soLogChecking
     */
    public BigDecimal getSoLogChecking()
    {
	return soLogChecking;
    }

    /**
     * @param soLogChecking the soLogChecking to set
     */
    public void setSoLogChecking(BigDecimal soLogChecking)
    {
	this.soLogChecking = soLogChecking;
    }

    public String getShowBreakDeposit()
    {
	return showBreakDeposit;
    }

    public void setShowBreakDeposit(String showBreakDeposit)
    {
	this.showBreakDeposit = showBreakDeposit;
    }

    public Integer getConfirmationCode()
    {
	return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode)
    {
	this.confirmationCode = confirmationCode;
    }

    public AMFVO getIstr_inv_acc()
    {
	return istr_inv_acc;
    }

    public AMFVO getIstr_to_acc()
    {
	return istr_to_acc;
    }

    public ACC_NV_CONTROLVO getAccNvControlVO()
    {
	return accNvControlVO;
    }

    public AMF_EXTENDEDVO getAmfExtendedVO()
    {
	return amfExtendedVO;
    }

    public void setIstr_inv_acc(AMFVO istrInvAcc)
    {
	istr_inv_acc = istrInvAcc;
    }

    public void setIstr_to_acc(AMFVO istrToAcc)
    {
	istr_to_acc = istrToAcc;
    }

    public void setAccNvControlVO(ACC_NV_CONTROLVO accNvControlVO)
    {
	this.accNvControlVO = accNvControlVO;
    }

    public void setAmfExtendedVO(AMF_EXTENDEDVO amfExtendedVO)
    {
	this.amfExtendedVO = amfExtendedVO;
    }

    /**
     * @return the confirmMgnt
     */
    public String getConfirmMgnt()
    {
	return confirmMgnt;
    }

    /**
     * @param confirmMgnt the confirmMgnt to set
     */
    public void setConfirmMgnt(String confirmMgnt)
    {
	this.confirmMgnt = confirmMgnt;
    }

    /**
     * @return the continueProcess
     */
    public String getContinueProcess()
    {
	return continueProcess;
    }

    /**
     * @param continueProcess the continueProcess to set
     */
    public void setContinueProcess(String continueProcess)
    {
	this.continueProcess = continueProcess;
    }

    public BigDecimal getREQUEST_ID()
    {
	return REQUEST_ID;
    }

    public void setREQUEST_ID(BigDecimal rEQUESTID)
    {
	REQUEST_ID = rEQUESTID;
    }

    public String getPrintExceptionsReport()
    {
	return printExceptionsReport;
    }

    public void setPrintExceptionsReport(String printExceptionsReport)
    {
	this.printExceptionsReport = printExceptionsReport;
    }

    public BigDecimal getProcessId()
    {
	return processId;
    }

    public void setProcessId(BigDecimal processId)
    {
	this.processId = processId;
    }

    public String getProcessName()
    {
	return processName;
    }

    public void setProcessName(String processName)
    {
	this.processName = processName;
    }

    public CTS_EXCEPTIONS_TRACEVO getExceptionsTraceVO()
    {
	return exceptionsTraceVO;
    }

    public void setExceptionsTraceVO(CTS_EXCEPTIONS_TRACEVO exceptionsTraceVO)
    {
	this.exceptionsTraceVO = exceptionsTraceVO;
    }

    public BigDecimal getSignAmount()
    {
	return signAmount;
    }

    public void setSignAmount(BigDecimal signAmount)
    {
	this.signAmount = signAmount;
    }

    public String getSignReturnFlag()
    {
	return signReturnFlag;
    }

    public void setSignReturnFlag(String signReturnFlag)
    {
	this.signReturnFlag = signReturnFlag;
    }

    public boolean isAccDtlsSignBtnEnabled()
    {
	return accDtlsSignBtnEnabled;
    }

    public void setAccDtlsSignBtnEnabled(boolean accDtlsSignBtnEnabled)
    {
	this.accDtlsSignBtnEnabled = accDtlsSignBtnEnabled;
    }

    public boolean isShowSign()
    {
	return showSign;
    }

    public void setShowSign(boolean showSign)
    {
	this.showSign = showSign;
    }

    public boolean isViewAccSignMandatory()
    {
	return viewAccSignMandatory;
    }

    public void setViewAccSignMandatory(boolean viewAccSignMandatory)
    {
	this.viewAccSignMandatory = viewAccSignMandatory;
    }

    public BigDecimal getGV_FISCAL_YEAR()
    {
	return GV_FISCAL_YEAR;
    }

    public void setGV_FISCAL_YEAR(BigDecimal gVFISCALYEAR)
    {
	GV_FISCAL_YEAR = gVFISCALYEAR;
    }

    public List<ReportResponseCO> getTransferCrReportList()
    {
	return transferCrReportList;
    }

    public void setTransferCrReportList(List<ReportResponseCO> transferCrReportList)
    {
	this.transferCrReportList = transferCrReportList;
    }

    public List<ReportResponseCO> getTransferDrReportList()
    {
	return transferDrReportList;
    }

    public void setTransferDrReportList(List<ReportResponseCO> transferDrReportList)
    {
	this.transferDrReportList = transferDrReportList;
    }

    public String getTransferDrReportConf()
    {
	return transferDrReportConf;
    }

    public void setTransferDrReportConf(String transferDrReportConf)
    {
	this.transferDrReportConf = transferDrReportConf;
    }

    public String getTransferCrReportConf()
    {
	return transferCrReportConf;
    }

    public void setTransferCrReportConf(String transferCrReportConf)
    {
	this.transferCrReportConf = transferCrReportConf;
    }

    public List<ReportResponseCO> getMultiTrsfrReportList()
    {
	return multiTrsfrReportList;
    }

    public void setMultiTrsfrReportList(List<ReportResponseCO> multiTrsfrReportList)
    {
	this.multiTrsfrReportList = multiTrsfrReportList;
    }

    public String getMultiTrsfrReportConf()
    {
	return multiTrsfrReportConf;
    }

    public void setMultiTrsfrReportConf(String multiTrsfrReportConf)
    {
	this.multiTrsfrReportConf = multiTrsfrReportConf;
    }

    public BigDecimal getFromTrxNo()
    {
	return fromTrxNo;
    }

    public void setFromTrxNo(BigDecimal fromTrxNo)
    {
	this.fromTrxNo = fromTrxNo;
    }

    public BigDecimal getToTrxNo()
    {
	return toTrxNo;
    }

    public void setToTrxNo(BigDecimal toTrxNo)
    {
	this.toTrxNo = toTrxNo;
    }

    public String getAddAdviceReportConf()
    {
	return addAdviceReportConf;
    }

    public void setAddAdviceReportConf(String addAdviceReportConf)
    {
	this.addAdviceReportConf = addAdviceReportConf;
    }

    public List<ReportResponseCO> getAddAdviceReportList()
    {
	return addAdviceReportList;
    }

    public void setAddAdviceReportList(List<ReportResponseCO> addAdviceReportList)
    {
	this.addAdviceReportList = addAdviceReportList;
    }

    public List<ReportResponseCO> getWarningLetterReportList()
    {
	return warningLetterReportList;
    }

    public void setWarningLetterReportList(List<ReportResponseCO> warningLetterReportList)
    {
	this.warningLetterReportList = warningLetterReportList;
    }

    public BigDecimal getNetProfit()
    {
	return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit)
    {
	this.netProfit = netProfit;
    }

    public String getWarningLetterReportConf()
    {
	return warningLetterReportConf;
    }

    public void setWarningLetterReportConf(String warningLetterReportConf)
    {
	this.warningLetterReportConf = warningLetterReportConf;
    }

    public List<ReportResponseCO> getTrxReportList()
    {
	return trxReportList;
    }

    public void setTrxReportList(List<ReportResponseCO> trxReportList)
    {
	this.trxReportList = trxReportList;
    }

    public String getTrxReportConf()
    {
	return trxReportConf;
    }

    public void setTrxReportConf(String trxReportConf)
    {
	this.trxReportConf = trxReportConf;
    }

    public List<ReportResponseCO> getTransferFromReportList()
    {
	return transferFromReportList;
    }

    public void setTransferFromReportList(List<ReportResponseCO> transferFromReportList)
    {
	this.transferFromReportList = transferFromReportList;
    }

    public List<ReportResponseCO> getTransferToReportList()
    {
	return transferToReportList;
    }

    public void setTransferToReportList(List<ReportResponseCO> transferToReportList)
    {
	this.transferToReportList = transferToReportList;
    }

    public String getTransferFromReportConf()
    {
	return transferFromReportConf;
    }

    public void setTransferFromReportConf(String transferFromReportConf)
    {
	this.transferFromReportConf = transferFromReportConf;
    }

    public String getTransferToReportConf()
    {
	return transferToReportConf;
    }

    public void setTransferToReportConf(String transferToReportConf)
    {
	this.transferToReportConf = transferToReportConf;
    }

    public String getPrintCallBackFlag()
    {
	return printCallBackFlag;
    }

    public void setPrintCallBackFlag(String printCallBackFlag)
    {
	this.printCallBackFlag = printCallBackFlag;
    }

    public String getMinorLink()
    {
	return minorLink;
    }

    public void setMinorLink(String minorLink)
    {
	this.minorLink = minorLink;
    }

    public Boolean getShowWarningLetter()
    {
	return showWarningLetter;
    }

    public void setShowWarningLetter(Boolean showWarningLetter)
    {
	this.showWarningLetter = showWarningLetter;
    }

    public Integer getWarningLetterCode()
    {
	return warningLetterCode;
    }

    public void setWarningLetterCode(Integer warningLetterCode)
    {
	this.warningLetterCode = warningLetterCode;
    }

    public String getChargesWaived()
    {
	return chargesWaived;
    }

    public void setChargesWaived(String chargesWaived)
    {
	this.chargesWaived = chargesWaived;
    }

    public BigDecimal getClearingHouse()
    {
	return clearingHouse;
    }

    public void setClearingHouse(BigDecimal clearingHouse)
    {
	this.clearingHouse = clearingHouse;
    }

    public boolean isSignViewed()
    {
	return signViewed;
    }

    public void setSignViewed(boolean signViewed)
    {
	this.signViewed = signViewed;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public Boolean getEnableAlertWhiteListButton()
    {
        return enableAlertWhiteListButton;
    }

    public void setEnableAlertWhiteListButton(Boolean enableAlertWhiteListButton)
    {
        this.enableAlertWhiteListButton = enableAlertWhiteListButton;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public String getUpdateAdditionalField()
    {
        return updateAdditionalField;
    }

    public void setUpdateAdditionalField(String updateAdditionalField)
    {
        this.updateAdditionalField = updateAdditionalField;
    }

    public String getEmptyMoreBenef()
    {
        return emptyMoreBenef;
    }

    public void setEmptyMoreBenef(String emptyMoreBenef)
    {
        this.emptyMoreBenef = emptyMoreBenef;
    }
    
    public String getEntryData()
    {
        return entryData;
    }

    public void setEntryData(String entryData)
    {
        this.entryData = entryData;
    }
    
    
    public String getTo_acc_name_eng()
    {
        return to_acc_name_eng;
    }

    public void setTo_acc_name_eng(String toAccNameEng)
    {
        to_acc_name_eng = toAccNameEng;
    }

    public String getTo_acc_sign()
    {
        return to_acc_sign;
    }

    public void setTo_acc_sign(String toAccSign)
    {
        to_acc_sign = toAccSign;
    }

    public String getTo_cif_name_eng()
    {
        return to_cif_name_eng;
    }

    public void setTo_cif_name_eng(String toCifNameEng)
    {
        to_cif_name_eng = toCifNameEng;
    }

    public String getAcc_gl_type()
    {
        return acc_gl_type;
    }

    public void setAcc_gl_type(String accGlType)
    {
        acc_gl_type = accGlType;
    }

    public String getTo_acc_gl_type()
    {
        return to_acc_gl_type;
    }

    public void setTo_acc_gl_type(String toAccGlType)
    {
        to_acc_gl_type = toAccGlType;
    }

    public String getCyDetType()
    {
        return cyDetType;
    }

    public void setCyDetType(String cyDetType)
    {
        this.cyDetType = cyDetType;
    }

    public String getReadOnlyRec()
    {
        return readOnlyRec;
    }

    public void setReadOnlyRec(String readOnlyRec)
    {
        this.readOnlyRec = readOnlyRec;
    }

    public String getMainAccName()
    {
        return mainAccName;
    }

    public void setMainAccName(String mainAccName)
    {
        this.mainAccName = mainAccName;
    }

    public String getSecondAccName()
    {
        return secondAccName;
    }

    public void setSecondAccName(String secondAccName)
    {
        this.secondAccName = secondAccName;
    }

    public BigDecimal getFirstCIFNo()
    {
        return firstCIFNo;
    }

    public void setFirstCIFNo(BigDecimal firstCIFNo)
    {
        this.firstCIFNo = firstCIFNo;
    }

    public List<MosBlackListCO> getSuspiciousGridList()
    {
        return suspiciousGridList;
    }

    public void setSuspiciousGridList(List<MosBlackListCO> suspiciousGridList)
    {
        this.suspiciousGridList = suspiciousGridList;
    }

    public String getModifyMessage()
    {
        return modifyMessage;
    }

    public void setModifyMessage(String modifyMessage)
    {
        this.modifyMessage = modifyMessage;
    }

    public String getSuspiciousGridListValue()
    {
        return suspiciousGridListValue;
    }

    public void setSuspiciousGridListValue(String suspiciousGridListValue)
    {
        this.suspiciousGridListValue = suspiciousGridListValue;
    }

    public String getTrxMgntAccDetGrid()
    {
        return trxMgntAccDetGrid;
    }

    public void setTrxMgntAccDetGrid(String trxMgntAccDetGrid)
    {
        this.trxMgntAccDetGrid = trxMgntAccDetGrid;
    }

    public String getDesc_region()
    {
        return desc_region;
    }

    public void setDesc_region(String descRegion)
    {
        desc_region = descRegion;
    }

    public CTSTRS_EXTENDEDVO getCtstrsExtendedVO()
    {
        return ctstrsExtendedVO;
    }

    public void setCtstrsExtendedVO(CTSTRS_EXTENDEDVO ctstrsExtendedVO)
    {
        this.ctstrsExtendedVO = ctstrsExtendedVO;
    }

    public String getMlPeriodicityType()
    {
        return mlPeriodicityType;
    }

    public void setMlPeriodicityType(String mlPeriodicityType)
    {
        this.mlPeriodicityType = mlPeriodicityType;
    }

    public String getBenef_country_desc()
    {
        return benef_country_desc;
    }

    public void setBenef_country_desc(String benefCountryDesc)
    {
        benef_country_desc = benefCountryDesc;
    }

    public String getMaskedCardNo()
    {
        return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
        this.maskedCardNo = maskedCardNo;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getRemitDenomValueEditable()
    {
        return remitDenomValueEditable;
    }

    public void setRemitDenomValueEditable(String remitDenomValueEditable)
    {
        this.remitDenomValueEditable = remitDenomValueEditable;
    }
    public String getCurrencyFormat()
    {
        return currencyFormat;
    }

    public void setCurrencyFormat(String currencyFormat)
    {
        this.currencyFormat = currencyFormat;
    }
    
    public String getOverDrawnVoid()
    {
        return overDrawnVoid;
    }

    public void setOverDrawnVoid(String overDrawnVoid)
    {
        this.overDrawnVoid = overDrawnVoid;
    }

    public BigDecimal getCount()
    {
        return count;
    }

    public void setCount(BigDecimal count)
    {
        this.count = count;
    }

    public BigDecimal getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getOutstandingChecked()
    {
        return outstandingChecked;
    }

    public void setOutstandingChecked(String outstandingChecked)
    {
        this.outstandingChecked = outstandingChecked;
    }

    public String getOpenOutstandOrderWindow()
    {
        return openOutstandOrderWindow;
    }

    public void setOpenOutstandOrderWindow(String openOutstandOrderWindow)
    {
        this.openOutstandOrderWindow = openOutstandOrderWindow;
    }

    public String getNewAmountInput()
    {
        return newAmountInput;
    }

    public void setNewAmountInput(String newAmountInput)
    {
        this.newAmountInput = newAmountInput;
    }

    public String getInChargedCyInput()
    {
        return inChargedCyInput;
    }

    public void setInChargedCyInput(String inChargedCyInput)
    {
        this.inChargedCyInput = inChargedCyInput;
    }

    public String getWaiveRateInput()
    {
        return waiveRateInput;
    }

    public void setWaiveRateInput(String waiveRateInput)
    {
        this.waiveRateInput = waiveRateInput;
    }

    public String getSimilarCharge()
    {
        return similarCharge;
    }

    public void setSimilarCharge(String similarCharge)
    {
        this.similarCharge = similarCharge;
    }
   
    public CTSTRXTYPE_EXTENDEDVO getCtstrxtypeExtendedVO()
    {
        return ctstrxtypeExtendedVO;
    }

    public void setCtstrxtypeExtendedVO(CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO)
    {
        this.ctstrxtypeExtendedVO = ctstrxtypeExtendedVO;
    }

    public String getResetDeals()
    {
        return resetDeals;
    }

    public void setResetDeals(String resetDeals)
    {
        this.resetDeals = resetDeals;
    }

    public List<TrxMgntSettlementCO> getTrxMgntSettlementCOs()
    {
        return trxMgntSettlementCOs;
    }

    public void setTrxMgntSettlementCOs(List<TrxMgntSettlementCO> trxMgntSettlementCOs)
    {
        this.trxMgntSettlementCOs = trxMgntSettlementCOs;
    }

    public List<TrxMgntSettlementCO> getTrxMgntDealDetailsCOs()
    {
        return trxMgntDealDetailsCOs;
    }

    public void setTrxMgntDealDetailsCOs(List<TrxMgntSettlementCO> trxMgntDealDetailsCOs)
    {
        this.trxMgntDealDetailsCOs = trxMgntDealDetailsCOs;
    }

    public BigDecimal getSessionID()
    {
        return sessionID;
    }

    public void setSessionID(BigDecimal sessionID)
    {
        this.sessionID = sessionID;
    }

    public String getDeferredTrxConfMsg()
    {
        return deferredTrxConfMsg;
    }

    public void setDeferredTrxConfMsg(String deferredTrxConfMsg)
    {
        this.deferredTrxConfMsg = deferredTrxConfMsg;
    }

    public String getChargeActionType()
    {
        return chargeActionType;
    }

    public void setChargeActionType(String chargeActionType)
    {
        this.chargeActionType = chargeActionType;
    }

    public String getMaintainHijriDate()
    {
        return maintainHijriDate;
    }

    public void setMaintainHijriDate(String maintainHijriDate)
    {
        this.maintainHijriDate = maintainHijriDate;
    }

    public String getValueDateHijri()
    {
        return valueDateHijri;
    }

    public void setValueDateHijri(String valueDateHijri)
    {
        this.valueDateHijri = valueDateHijri;
    }

    public String getTrsDateHijri()
    {
        return trsDateHijri;
    }

    public void setTrsDateHijri(String trsDateHijri)
    {
        this.trsDateHijri = trsDateHijri;
    }

    public String getIsUnifiedCharge()
    {
        return isUnifiedCharge;
    }

    public void setIsUnifiedCharge(String isUnifiedCharge)
    {
        this.isUnifiedCharge = isUnifiedCharge;
    }

    public String getLoadChargeGrid()
    {
        return loadChargeGrid;
    }

    public void setLoadChargeGrid(String loadChargeGrid)
    {
        this.loadChargeGrid = loadChargeGrid;
    }

    public CTSTRS_UPLOAD_TMPVO getTrsUploadTmpVO()
    {
        return trsUploadTmpVO;
    }

    public void setTrsUploadTmpVO(CTSTRS_UPLOAD_TMPVO trsUploadTmpVO)
    {
        this.trsUploadTmpVO = trsUploadTmpVO;
    }

    public String getOpenSOAReport()
    {
        return openSOAReport;
    }

    public void setOpenSOAReport(String openSOAReport)
    {
        this.openSOAReport = openSOAReport;
    }

    public CTSTRS_STATEMENTVO getCtstrsStatementVO()
    {
        return ctstrsStatementVO;
    }

    public void setCtstrsStatementVO(CTSTRS_STATEMENTVO ctstrsStatementVO)
    {
        this.ctstrsStatementVO = ctstrsStatementVO;
    }

    public TMP_REPORTSVOWithBLOBs getTmpReportsVOWithBlobs()
    {
        return tmpReportsVOWithBlobs;
    }

    public void setTmpReportsVOWithBlobs(TMP_REPORTSVOWithBLOBs tmpReportsVOWithBlobs)
    {
        this.tmpReportsVOWithBlobs = tmpReportsVOWithBlobs;
    }
     public BigDecimal getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo)
    {
        this.serialNo = serialNo;
    }

    public BigDecimal getBatchNo()
    {
        return batchNo;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
        this.batchNo = batchNo;
    }
    public List<SelectCO> getCashDeductIndList()
    {
        return cashDeductIndList;
    }

    public void setCashDeductIndList(List<SelectCO> cashDeductIndList)
    {
        this.cashDeductIndList = cashDeductIndList;
    }
    
    public String getOs_s_string()
    {
        return os_s_string;
    }

    public void setOs_s_string(String osSString)
    {
        os_s_string = osSString;
    }

    public TrxVoidChargesCO getTrxVoidChargesCO()
    {
        return trxVoidChargesCO;
    }

    public void setTrxVoidChargesCO(TrxVoidChargesCO trxVoidChargesCO)
    {
        this.trxVoidChargesCO = trxVoidChargesCO;
    }

    /**
     * @return the instructions1
     */
    public String getInstructions1()
    {
        return instructions1;
    }

    /**
     * @param instructions1 the instructions1 to set
     */
    public void setInstructions1(String instructions1)
    {
        this.instructions1 = instructions1;
    }

    public String getRejectMessage()
    {
        return rejectMessage;
    }

    public void setRejectMessage(String rejectMessage)
    {
        this.rejectMessage = rejectMessage;
    }

    /**
     * @return the mceRec
     */
    public BigDecimal getMceRec()
    {
        return mceRec;
    }

    /**
     * @param mceRec the mceRec to set
     */
    public void setMceRec(BigDecimal mceRec)
    {
        this.mceRec = mceRec;
    }

    /**
     * @return the multipleEntries
     */
    public String getMultipleEntries()
    {
        return multipleEntries;
    }

    /**
     * @param multipleEntries the multipleEntries to set
     */
    public void setMultipleEntries(String multipleEntries)
    {
        this.multipleEntries = multipleEntries;
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

    public BigDecimal getDefaultTrxType()
    {
        return defaultTrxType;
    }

    public void setDefaultTrxType(BigDecimal defaultTrxType)
    {
        this.defaultTrxType = defaultTrxType;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    /**
     * @return the changesApplied
     */
    public BigDecimal getChangesApplied()
    {
        return changesApplied;
    }

    /**
     * @param changesApplied the changesApplied to set
     */
    public void setChangesApplied(BigDecimal changesApplied)
    {
        this.changesApplied = changesApplied;
    }

    public String getDependencyFrom()
    {
        return dependencyFrom;
    }

    public void setDependencyFrom(String dependencyFrom)
    {
        this.dependencyFrom = dependencyFrom;
    }

    /**
     * @return the bulkRemittanceType
     */
    public BigDecimal getBulkRemittanceType()
    {
        return bulkRemittanceType;
    }

    /**
     * @param bulkRemittanceType the bulkRemittanceType to set
     */
    public void setBulkRemittanceType(BigDecimal bulkRemittanceType)
    {
        this.bulkRemittanceType = bulkRemittanceType;
    }

    public String getRelatedSerialNoList()
    {
        return relatedSerialNoList;
    }

    public void setRelatedSerialNoList(String relatedSerialNoList)
    {
        this.relatedSerialNoList = relatedSerialNoList;
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

    public BigDecimal getOldExchRate()
    {
        return oldExchRate;
    }

    public void setOldExchRate(BigDecimal oldExchRate)
    {
        this.oldExchRate = oldExchRate;
    }

    /**
     * @return the selectedBulkRemittance
     */
    public String getSelectedBulkRemittance()
    {
        return selectedBulkRemittance;
    }

    /**
     * @param selectedBulkRemittance the selectedBulkRemittance to set
     */
    public void setSelectedBulkRemittance(String selectedBulkRemittance)
    {
        this.selectedBulkRemittance = selectedBulkRemittance;
    }

    /**
     * @return the listBulkRemittance
     */
    public List<TrxMgntCO> getListBulkRemittance()
    {
        return listBulkRemittance;
    }

    /**
     * @param listBulkRemittance the listBulkRemittance to set
     */
    public void setListBulkRemittance(List<TrxMgntCO> listBulkRemittance)
    {
        this.listBulkRemittance = listBulkRemittance;
    }

    /**
     * @return the bulkRemittanceRows
     */
    public HashMap<String, TrxMgntCO> getBulkRemittanceRows()
    {
        return bulkRemittanceRows;
    }

    /**
     * @param bulkRemittanceRows the bulkRemittanceRows to set
     */
    public void setBulkRemittanceRows(HashMap<String, TrxMgntCO> bulkRemittanceRows)
    {
        this.bulkRemittanceRows = bulkRemittanceRows;
    }

    /**
     * @return the bulkRemitProceed
     */
    public String getBulkRemitProceed()
    {
        return bulkRemitProceed;
    }

    /**
     * @param bulkRemitProceed the bulkRemitProceed to set
     */
    public void setBulkRemitProceed(String bulkRemitProceed)
    {
        this.bulkRemitProceed = bulkRemitProceed;
    }


    public String getShowSoRefLookup()
    {
        return showSoRefLookup;
    }

    public void setShowSoRefLookup(String showSoRefLookup)
    {
        this.showSoRefLookup = showSoRefLookup;
    }


    /**
     * @return the printCallBackFunc
     */
    public String getPrintCallBackFunc()
    {
        return printCallBackFunc;
    }

    /**
     * @param printCallBackFunc the printCallBackFunc to set
     */
    public void setPrintCallBackFunc(String printCallBackFunc)
    {
        this.printCallBackFunc = printCallBackFunc;
    }

    public BigDecimal getOriginalBODRate()
    {
        return originalBODRate;
    }

    public void setOriginalBODRate(BigDecimal originalBODRate)
    {
        this.originalBODRate = originalBODRate;
    }

    /**
     * @return the trxMgntBenefCO
     */
    public TrxMgntBenefCO getTrxMgntBenefCO()
    {
        return trxMgntBenefCO;
    }

    /**
     * @param trxMgntBenefCO the trxMgntBenefCO to set
     */
    public void setTrxMgntBenefCO(TrxMgntBenefCO trxMgntBenefCO)
    {
        this.trxMgntBenefCO = trxMgntBenefCO;
    }

    /**
     * @return the billTypeAddReferenceCO
     */
    public BillTypeAddReferenceCO getBillTypeAddReferenceCO()
    {
        return billTypeAddReferenceCO;
    }

    /**
     * @param billTypeAddReferenceCO the billTypeAddReferenceCO to set
     */
    public void setBillTypeAddReferenceCO(BillTypeAddReferenceCO billTypeAddReferenceCO)
    {
        this.billTypeAddReferenceCO = billTypeAddReferenceCO;
    }

    public String getAvail_bal_after()
    {
        return avail_bal_after;
    }

    public void setAvail_bal_after(String availBalAfter)
    {
        avail_bal_after = availBalAfter;
    }

    public String getTo_avail_bal_after()
    {
        return to_avail_bal_after;
    }

    public void setTo_avail_bal_after(String toAvailBalAfter)
    {
        to_avail_bal_after = toAvailBalAfter;
    }

    public String getBankCode()
    {
        return bankCode;
    }

    public void setBankCode(String bankCode)
    {
        this.bankCode = bankCode;
    }

    public BigDecimal getInternalACCBranch()
    {
        return internalACCBranch;
    }

    public void setInternalACCBranch(BigDecimal internalACCBranch)
    {
        this.internalACCBranch = internalACCBranch;
    }

    public String getRestrictTrxBranches()
    {
        return restrictTrxBranches;
    }

    public void setRestrictTrxBranches(String restrictTrxBranches)
    {
        this.restrictTrxBranches = restrictTrxBranches;
    }

    public String getCounterPartyCIFNameEng()
    {
        return counterPartyCIFNameEng;
    }

    public void setCounterPartyCIFNameEng(String counterPartyCIFNameEng)
    {
        this.counterPartyCIFNameEng = counterPartyCIFNameEng;
    }

    public String getCardReaderEnabled()
    {
        return cardReaderEnabled;
    }

    public void setCardReaderEnabled(String cardReaderEnabled)
    {
        this.cardReaderEnabled = cardReaderEnabled;
    }

    public String getIisTableFilled()
    {
        return iisTableFilled;
    }

    public void setIisTableFilled(String iisTableFilled)
    {
        this.iisTableFilled = iisTableFilled;
    }

    public String getAlertOverDrawnAmount()
    {
        return alertOverDrawnAmount;
    }

    public void setAlertOverDrawnAmount(String alertOverDrawnAmount)
    {
        this.alertOverDrawnAmount = alertOverDrawnAmount;
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

    public String getEmptySoRefDependency()
    {
        return emptySoRefDependency;
    }

    public void setEmptySoRefDependency(String emptySoRefDependency)
    {
        this.emptySoRefDependency = emptySoRefDependency;
    }

    public String getFromField()
    {
        return fromField;
    }

    public void setFromField(String fromField)
    {
        this.fromField = fromField;
    }

    public List<AccPositionSettCO> getAccEntriesLst()
    {
        return accEntriesLst;
    }

    public void setAccEntriesLst(List<AccPositionSettCO> accEntriesLst)
    {
        this.accEntriesLst = accEntriesLst;
    }

    public String getDofDescEng()
    {
        return dofDescEng;
    }

    public void setDofDescEng(String dofDescEng)
    {
        this.dofDescEng = dofDescEng;
    }

    public String getDofDescArab()
    {
        return dofDescArab;
    }

    public void setDofDescArab(String dofDescArab)
    {
        this.dofDescArab = dofDescArab;
    }

    public String getBillerCode()
    {
        return billerCode;
    }

    public void setBillerCode(String billerCode)
    {
        this.billerCode = billerCode;
    }

    public BigDecimal getAddNumber()
    {
        return addNumber;
    }

    public void setAddNumber(BigDecimal addNumber)
    {
        this.addNumber = addNumber;
    }

    public BigDecimal getNumOfShares()
    {
        return numOfShares;
    }

    public void setNumOfShares(BigDecimal numOfShares)
    {
        this.numOfShares = numOfShares;
    }
    
    public BigDecimal getTotalCharges()
    {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges)
    {
        this.totalCharges = totalCharges;
    }

    public String getUserDesc()
    {
        return userDesc;
    }

    public void setUserDesc(String userDesc)
    {
        this.userDesc = userDesc;
    }

    public BigDecimal getDeductBr()
    {
        return deductBr;
    }

    public void setDeductBr(BigDecimal deductBr)
    {
        this.deductBr = deductBr;
    }

    public BigDecimal getFirstMultiCif()
    {
        return firstMultiCif;
    }

    public void setFirstMultiCif(BigDecimal firstMultiCif)
    {
        this.firstMultiCif = firstMultiCif;
    }

    public String getHashCreated()
    {
        return hashCreated;
    }

    public void setHashCreated(String hashCreated)
    {
        this.hashCreated = hashCreated;
    }

    public String getIbBatch()
    {
        return ibBatch;
    }

    public void setIbBatch(String ibBatch)
    {
        this.ibBatch = ibBatch;
    }

    public String getBicCode()
    {
        return bicCode;
    }

    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    public AMFVOKey getEntryDeductChrgVO()
    {
        return entryDeductChrgVO;
    }

    public void setEntryDeductChrgVO(AMFVOKey entryDeductChrgVO)
    {
        this.entryDeductChrgVO = entryDeductChrgVO;
    }

    public String getAddFieldsStr()
    {
        return addFieldsStr;
    }

    public void setAddFieldsStr(String addFieldsStr)
    {
        this.addFieldsStr = addFieldsStr;
    }

    public List<TrsTypeAddFieldsValuesCO> getTrsTypeAddFieldsValuesAllLst()
    {
        return trsTypeAddFieldsValuesAllLst;
    }

    public void setTrsTypeAddFieldsValuesAllLst(List<TrsTypeAddFieldsValuesCO> trsTypeAddFieldsValuesAllLst)
    {
        this.trsTypeAddFieldsValuesAllLst = trsTypeAddFieldsValuesAllLst;
    }
    
    public boolean isObligorExceed()
    {
	return obligorExceed;
    }

    public void setObligorExceed(boolean obligorExceed)
    {
	this.obligorExceed = obligorExceed;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public String getMt200SwiftMessage1()
    {
	return mt200SwiftMessage1;
    }

    public void setMt200SwiftMessage1(String mt200SwiftMessage1)
    {
	this.mt200SwiftMessage1 = mt200SwiftMessage1;
    }

    public String getMt200SwiftMessage2()
    {
	return mt200SwiftMessage2;
    }

    public void setMt200SwiftMessage2(String mt200SwiftMessage2)
    {
	this.mt200SwiftMessage2 = mt200SwiftMessage2;
    }
    
    public String getTrxMgntFxDealGridUpdates()
    {
        return trxMgntFxDealGridUpdates;
    }

    public void setTrxMgntFxDealGridUpdates(String trxMgntFxDealGridUpdates)
    {
        this.trxMgntFxDealGridUpdates = trxMgntFxDealGridUpdates;
    }

    public List<TrxMgntFxDealCO> getTrxMgntFxDealListModified()
    {
        return trxMgntFxDealListModified;
    }

    public void setTrxMgntFxDealListModified(List<TrxMgntFxDealCO> trxMgntFxDealListModified)
    {
        this.trxMgntFxDealListModified = trxMgntFxDealListModified;
    }

	
    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public String getCurrAppName()
    {
	return currAppName;
    }

    public void setCurrAppName(String currAppName)
    {
	this.currAppName = currAppName;
    }

    public BigDecimal getCriteriaPerc()
    {
        return criteriaPerc;
    }

    public void setCriteriaPerc(BigDecimal criteriaPerc)
    {
        this.criteriaPerc = criteriaPerc;
    }

    public int getCountBlackListLog()
    {
        return countBlackListLog;
    }

    public void setCountBlackListLog(int countBlackListLog)
    {
        this.countBlackListLog = countBlackListLog;
    }

    public BigDecimal getComplianceDecision()
    {
        return complianceDecision;
    }

    public void setComplianceDecision(BigDecimal complianceDecision)
    {
        this.complianceDecision = complianceDecision;
    }

    public String getTodoAlert()
    {
        return todoAlert;
    }



    public void setTodoAlert(String todoAlert)
    {
	this.todoAlert = todoAlert;
    }



    public void setAccActionLimit(BigDecimal accActionLimit)
    {
	this.accActionLimit = accActionLimit;
    }

    public S_AUDIT_ACTION_DTL_CIFVO getSauditActionDtlCifVO()
    {
	return sauditActionDtlCifVO;
    }

    public void setSauditActionDtlCifVO(S_AUDIT_ACTION_DTL_CIFVO sauditActionDtlCifVO)
    {
	this.sauditActionDtlCifVO = sauditActionDtlCifVO;
    }

    public CURRENCIESVO getCurrencyVO()
    {
        return currencyVO;
    }

    public void setCurrencyVO(CURRENCIESVO currencyVO)
    {
        this.currencyVO = currencyVO;
    }

    public String getBankCifShortNameEng()
    {
        return bankCifShortNameEng;
    }

    public void setBankCifShortNameEng(String bankCifShortNameEng)
    {
        this.bankCifShortNameEng = bankCifShortNameEng;
    }

    public Date getCertifiedChequeExpiryDate()
    {
        return certifiedChequeExpiryDate;
    }

    public void setCertifiedChequeExpiryDate(Date certifiedChequeExpiryDate)
    {
        this.certifiedChequeExpiryDate = certifiedChequeExpiryDate;
    }

    public BigDecimal getCardBranchCode()
    {
        return cardBranchCode;
    }

    public void setCardBranchCode(BigDecimal cardBranchCode)
    {
        this.cardBranchCode = cardBranchCode;
    }

    public BigDecimal getCardAPPId()
    {
        return cardAPPId;
    }

    public void setCardAPPId(BigDecimal cardAPPId)
    {
        this.cardAPPId = cardAPPId;
    }
    
    

    public String getTrxMgntMoreBenefDetGridUpdate()
    {
        return trxMgntMoreBenefDetGridUpdate;
    }

    public void setTrxMgntMoreBenefDetGridUpdate(String trxMgntMoreBenefDetGridUpdate)
    {
        this.trxMgntMoreBenefDetGridUpdate = trxMgntMoreBenefDetGridUpdate;
    }

    public List<TrxMgntMoreBenefDetailsCO> getCtstrsBenefMoreDetailsList()
    {
        return ctstrsBenefMoreDetailsList;
    }

    public void setCtstrsBenefMoreDetailsList(List<TrxMgntMoreBenefDetailsCO> ctstrsBenefMoreDetailsList)
    {
        this.ctstrsBenefMoreDetailsList = ctstrsBenefMoreDetailsList;
    }

    public String getTransactionCurrency()
    {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency)
    {
        this.transactionCurrency = transactionCurrency;
    }

    

    public String getIdTypeSwiftCode()
    {
        return idTypeSwiftCode;
    }

    public void setIdTypeSwiftCode(String idTypeSwiftCode)
    {
        this.idTypeSwiftCode = idTypeSwiftCode;
    }
    public String getSub_status_desc()
    {
        return sub_status_desc;
    }

    public void setSub_status_desc(String sub_status_desc)
    {
        this.sub_status_desc = sub_status_desc;
    }

    public String getCREDIT_CARD_NUMBER()
    {
        return CREDIT_CARD_NUMBER;
    }

    public void setCREDIT_CARD_NUMBER(String cREDIT_CARD_NUMBER)
    {
        CREDIT_CARD_NUMBER = cREDIT_CARD_NUMBER;
    }

    public BigDecimal getCIF()
    {
        return CIF;
    }

    public void setCIF(BigDecimal cIF)
    {
        CIF = cIF;
    }
    
    

    public String getCallingIndicator()
    {
	return callingIndicator;
    }

    public void setCallingIndicator(String callingIndicator)
    {
	this.callingIndicator = callingIndicator;
    }
    
    public String getAlertPersAccount()
    {
        return alertPersAccount;
    }

    public void setAlertPersAccount(String alertPersAccount)
    {
        this.alertPersAccount = alertPersAccount;
    }
	public String getAccountOverdrawFlag()
	{
	    return accountOverdrawFlag;
	}

	public void setAccountOverdrawFlag(String accountOverdrawFlag)
	{
	    this.accountOverdrawFlag = accountOverdrawFlag;
	}

	public String getNoMessageToDisplay()
	{
	    return noMessageToDisplay;
	}

	public void setNoMessageToDisplay(String noMessageToDisplay)
	{
	    this.noMessageToDisplay = noMessageToDisplay;
	}
	


	public String getAlreadyDeletedDetTMP()
	{
	    return alreadyDeletedDetTMP;
	}
	public void setAlreadyDeletedDetTMP(String alreadyDeletedDetTMP)
	{
	    this.alreadyDeletedDetTMP = alreadyDeletedDetTMP;
	}





    public void setChequeScanCO(ChequeScanCO chequeScanCO)
    {
	this.chequeScanCO = chequeScanCO;
    }

    public BigDecimal getOverdrawFromAccBr()
    {
        return overdrawFromAccBr;
    }

    public void setOverdrawFromAccBr(BigDecimal overdrawFromAccBr)
    {
        this.overdrawFromAccBr = overdrawFromAccBr;
    }

    public BigDecimal getOverdrawToAccBr()
    {
        return overdrawToAccBr;
    }

    public void setOverdrawToAccBr(BigDecimal overdrawToAccBr)
    {
        this.overdrawToAccBr = overdrawToAccBr;
    }

    public BigDecimal getZakatAmoutCV()
    {
        return zakatAmoutCV;
    }

    public void setZakatAmoutCV(BigDecimal zakatAmoutCV)
    {
        this.zakatAmoutCV = zakatAmoutCV;
    }

    public BigDecimal getZakatAmoutFC()
    {
        return zakatAmoutFC;
    }

    public void setZakatAmoutFC(BigDecimal zakatAmoutFC)
    {
        this.zakatAmoutFC = zakatAmoutFC;
    }

    public String getPrizeBondTypeList()
    {
        return prizeBondTypeList;
    }

    public void setPrizeBondTypeList(String prizeBondTypeList)
    {
        this.prizeBondTypeList = prizeBondTypeList;
    }

    public String getTrxRemitTypeDesc()
    {
        return trxRemitTypeDesc;
    }

    public void setTrxRemitTypeDesc(String trxRemitTypeDesc)
    {
        this.trxRemitTypeDesc = trxRemitTypeDesc;
    }

    public BigDecimal getDenomination()
    {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination)
    {
        this.denomination = denomination;
    }
    
    public RecordOfRemittanceCO getRecordOfRemittanceCO()
    {
        return recordOfRemittanceCO;
    }

    public void setRecordOfRemittanceCO(RecordOfRemittanceCO recordOfRemittanceCO)
    {
        this.recordOfRemittanceCO = recordOfRemittanceCO;
    }

    public String getReasonType()
    {
        return reasonType;
    }

    public void setReasonType(String reasonType)
    {
        this.reasonType = reasonType;
    }

    public String getSynthesisStatusDesc()
    {
	return synthesisStatusDesc;
    }

    public void setSynthesisStatusDesc(String synthesisStatusDesc)
    {
	this.synthesisStatusDesc = synthesisStatusDesc;
    }

    public BigDecimal getUserCif()
    {
	return userCif;
    }

    public void setUserCif(BigDecimal userCif)
    {
	this.userCif = userCif;
    }

    public SessionCO getSessionCO()
    {
	return sessionCO;
    }

    public void setSessionCO(SessionCO sessionCO)
    {
	this.sessionCO = sessionCO;
    }

    public ArrayList<Map<String, Object>> getOutputParamMapList()
    {
	return outputParamMapList;
    }

    public void setOutputParamMapList(ArrayList<Map<String, Object>> outputParamMapList)
    {
	this.outputParamMapList = outputParamMapList;
    }

    public String getTrxReferenceInteg()
    {
	return trxReferenceInteg;
    }

    public void setTrxReferenceInteg(String trxReferenceInteg)
    {
	this.trxReferenceInteg = trxReferenceInteg;
    }

    public String getOriginalColName()
    {
	return originalColName;
    }

    public void setOriginalColName(String originalColName)
    {
	this.originalColName = originalColName;
    }

    public Date getOpenDate()
    {
	return openDate;
    }

    public void setOpenDate(Date openDate)
    {
	this.openDate = openDate;
    }

    public BigDecimal getOutstdngProfitCV()
    {
	return outstdngProfitCV;
    }

    public void setOutstdngProfitCV(BigDecimal outstdngProfitCV)
    {
	this.outstdngProfitCV = outstdngProfitCV;
    }

    public BigDecimal getOutstdngProfitFC()
    {
	return outstdngProfitFC;
    }

    public void setOutstdngProfitFC(BigDecimal outstdngProfitFC)
    {
	this.outstdngProfitFC = outstdngProfitFC;
    }

    public BigDecimal getTaxCV()
    {
	return taxCV;
    }

    public void setTaxCV(BigDecimal taxCV)
    {
	this.taxCV = taxCV;
    }

    public BigDecimal getTaxFC()
    {
	return taxFC;
    }

    public void setTaxFC(BigDecimal taxFC)
    {
	this.taxFC = taxFC;
    }

    public BigDecimal getPeriodicity()
    {
	return periodicity;
    }

    public void setPeriodicity(BigDecimal periodicity)
    {
	this.periodicity = periodicity;
    }

    public BigDecimal getPercentage()
    {
	return percentage;
    }

    public void setPercentage(BigDecimal percentage)
    {
	this.percentage = percentage;
    }

    public BigDecimal getAdvDistributionFC()
    {
	return advDistributionFC;
    }

    public void setAdvDistributionFC(BigDecimal advDistributionFC)
    {
	this.advDistributionFC = advDistributionFC;
    }

    public BigDecimal getAdvDistributionCV()
    {
	return advDistributionCV;
    }

    public void setAdvDistributionCV(BigDecimal advDistributionCV)
    {
	this.advDistributionCV = advDistributionCV;
    }

    public BigDecimal getCsmAdvDistributionFC()
    {
	return csmAdvDistributionFC;
    }

    public void setCsmAdvDistributionFC(BigDecimal csmAdvDistributionFC)
    {
	this.csmAdvDistributionFC = csmAdvDistributionFC;
    }

    public BigDecimal getCsmAdvDistributionCV()
    {
	return csmAdvDistributionCV;
    }

    public void setCsmAdvDistributionCV(BigDecimal csmAdvDistributionCV)
    {
	this.csmAdvDistributionCV = csmAdvDistributionCV;
    }

    public BigDecimal getTotalAdvanceFC()
    {
	return totalAdvanceFC;
    }

    public void setTotalAdvanceFC(BigDecimal totalAdvanceFC)
    {
	this.totalAdvanceFC = totalAdvanceFC;
    }

    public BigDecimal getTotalAdvanceCV()
    {
	return totalAdvanceCV;
    }

    public void setTotalAdvanceCV(BigDecimal totalAdvanceCV)
    {
	this.totalAdvanceCV = totalAdvanceCV;
    }

    public BigDecimal getAccumulatedPftFC()
    {
	return accumulatedPftFC;
    }

    public void setAccumulatedPftFC(BigDecimal accumulatedPftFC)
    {
	this.accumulatedPftFC = accumulatedPftFC;
    }

    public BigDecimal getAccumulatedPftCV()
    {
	return accumulatedPftCV;
    }

    public void setAccumulatedPftCV(BigDecimal accumulatedPftCV)
    {
	this.accumulatedPftCV = accumulatedPftCV;
    }

    public BigDecimal getPcsBalFC()
    {
	return pcsBalFC;
    }

    public void setPcsBalFC(BigDecimal pcsBalFC)
    {
	this.pcsBalFC = pcsBalFC;
    }

    public BigDecimal getPcsBalCV()
    {
	return pcsBalCV;
    }

    public void setPcsBalCV(BigDecimal pcsBalCV)
    {
	this.pcsBalCV = pcsBalCV;
    }

    public String getIsAdvPft()
    {
        return isAdvPft;
    }

    public void setIsAdvPft(String isAdvPft)
    {
        this.isAdvPft = isAdvPft;
    }

    public BigDecimal getInverseExchangeRate()
    {
	return inverseExchangeRate;
    }

    public void setInverseExchangeRate(BigDecimal inverseExchangeRate)
    {
	this.inverseExchangeRate = inverseExchangeRate;
    }

    public BigDecimal getOldInvExchRate()
    {
        return oldInvExchRate;
    }

    public void setOldInvExchRate(BigDecimal oldInvExchRate)
    {
        this.oldInvExchRate = oldInvExchRate;
    }

    public String getTrxScreenRefAction()
    {
        return trxScreenRefAction;
    }

    public void setTrxScreenRefAction(String trxScreenRefAction)
    {
        this.trxScreenRefAction = trxScreenRefAction;
    }
    
    public BigDecimal getAccDtlLastRowAmount()
    {
	return accDtlLastRowAmount;
    }

    public void setAccDtlLastRowAmount(BigDecimal accDtlLastRowAmount)
    {
	this.accDtlLastRowAmount = accDtlLastRowAmount;
    }

    public String getApplyBlotterAlert()
    {
        return applyBlotterAlert;
    }

    public void setApplyBlotterAlert(String applyBlotterAlert)
    {
        this.applyBlotterAlert = applyBlotterAlert;
    }

    public String getBlotterResponse()
    {
        return blotterResponse;
    }

    public void setBlotterResponse(String blotterResponse)
    {
        this.blotterResponse = blotterResponse;
    }    
    
    public BigDecimal getBlotterTimeInterval()
    {
	return blotterTimeInterval;
    }

    public void setBlotterTimeInterval(BigDecimal blotterTimeInterval)
    {
	this.blotterTimeInterval = blotterTimeInterval;
    }
    
    public String getBlotterRateConfirmation()
    {
        return blotterRateConfirmation;
    }

    public void setBlotterRateConfirmation(String blotterRateConfirmation)
    {
        this.blotterRateConfirmation = blotterRateConfirmation;
    }  
    

    public String getBlotterCallingLevel()
    {
        return blotterCallingLevel;
    }

    public void setBlotterCallingLevel(String blotterCallingLevel)
    {
        this.blotterCallingLevel = blotterCallingLevel;
    }

    public BigDecimal getBlotterCyExchSeqNo()
    {
        return blotterCyExchSeqNo;
    }

    public void setBlotterCyExchSeqNo(BigDecimal blotterCyExchSeqNo)
    {
        this.blotterCyExchSeqNo = blotterCyExchSeqNo;
    }

	public String getCeftsResponceValue()
	{
	    return ceftsResponceValue;
	}

	public void setCeftsResponceValue(String ceftsResponceValue)
	{
	    this.ceftsResponceValue = ceftsResponceValue;
	}

	public BigDecimal getIncrementalCefts()
	{
	    return incrementalCefts;
	}

	public void setIncrementalCefts(BigDecimal incrementalCefts)
	{
	    this.incrementalCefts = incrementalCefts;
	}

	public BigDecimal getCeftsRequestId()
	{
	    return ceftsRequestId;
	}

	public void setCeftsRequestId(BigDecimal ceftsRequestId)
	{
	    this.ceftsRequestId = ceftsRequestId;
	}

	public Integer getWaiveConfirmationCode() {
		return waiveConfirmationCode;
	}

	public void setWaiveConfirmationCode(Integer waiveConfirmationCode) {
		this.waiveConfirmationCode = waiveConfirmationCode;
	}
	
	public BigDecimal getNewgainlosscvamount()
	{
	    return newgainlosscvamount;
	}

	public void setNewgainlosscvamount(BigDecimal newgainlosscvamount)
	{
	    this.newgainlosscvamount = newgainlosscvamount;
	}

	public BigDecimal getNewgainlossfcamount()
	{
	    return newgainlossfcamount;
	}

	public void setNewgainlossfcamount(BigDecimal newgainlossfcamount)
	{
	    this.newgainlossfcamount = newgainlossfcamount;
	}
	
	    public Boolean getFromWebService()
	    {
	        return fromWebService;
	    }

	    public void setFromWebService(Boolean fromWebService)
	    {
	        this.fromWebService = fromWebService;
	    }

	    public BigDecimal getUseAccount()
	    {
	        return useAccount;
	    }

	    public void setUseAccount(BigDecimal useAccount)
	    {
	        this.useAccount = useAccount;
	    }

	    public BigDecimal getUseToAccount()
	    {
	        return useToAccount;
	    }

	    public void setUseToAccount(BigDecimal useToAccount)
	    {
	        this.useToAccount = useToAccount;
	    }

	    public BigDecimal getAccActionLimit()
	    {
	        return accActionLimit;
	    }

	    public ChequeScanCO getChequeScanCO()
	    {
	        return chequeScanCO;
	    }

		public boolean isSoDepFromTrxType()
		{
			return soDepFromTrxType;
		}

		public void setSoDepFromTrxType(boolean soDepFromTrxType)
		{
			this.soDepFromTrxType = soDepFromTrxType;
		}

		public CTSTRS_VDATE_INFOVO getCtstrsVDateInfoVO()
		{
		    return ctstrsVDateInfoVO;
		}

		public void setCtstrsVDateInfoVO(CTSTRS_VDATE_INFOVO ctstrsVDateInfoVO)
		{
		    this.ctstrsVDateInfoVO = ctstrsVDateInfoVO;
		}

		public BigDecimal getValueDateAmendLovId()
		{
		    return valueDateAmendLovId;
		}

		public void setValueDateAmendLovId(BigDecimal valueDateAmendLovId)
		{
		    this.valueDateAmendLovId = valueDateAmendLovId;
		}

		public String getTrxVDateAmendmentStatusDesc()
		{
		    return trxVDateAmendmentStatusDesc;
		}

		public void setTrxVDateAmendmentStatusDesc(String trxVDateAmendmentStatusDesc)
		{
		    this.trxVDateAmendmentStatusDesc = trxVDateAmendmentStatusDesc;
		}

		public String getFromDebitValueDate()
		{
		    return fromDebitValueDate;
		}

		public void setFromDebitValueDate(String fromDebitValueDate)
		{
		    this.fromDebitValueDate = fromDebitValueDate;
		}

		public BigDecimal getCardReleaseHofDays()
		{
		    return cardReleaseHofDays;
		}

		public void setCardReleaseHofDays(BigDecimal cardReleaseHofDays)
		{
		    this.cardReleaseHofDays = cardReleaseHofDays;
		}

		public String getDofEngDesc2()
		{
		    return dofEngDesc2;
		}

		public void setDofEngDesc2(String dofEngDesc2)
		{
		    this.dofEngDesc2 = dofEngDesc2;
		}

		public String getDofArabDesc2()
		{
		    return dofArabDesc2;
		}

		public void setDofArabDesc2(String dofArabDesc2)
		{
		    this.dofArabDesc2 = dofArabDesc2;
		}

		public BigDecimal getCheckBalance()
		{
		    return checkBalance;
		}

		public void setCheckBalance(BigDecimal checkBalance)
		{
		    this.checkBalance = checkBalance;
		}

		public BigDecimal getReasonCode()
		{
		    return reasonCode;
		}

		public void setReasonCode(BigDecimal reasonCode)
		{
		    this.reasonCode = reasonCode;
		}
   
    // end Hasan


    public String getReferenceNumber()
    {
	return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber)
    {
	this.referenceNumber = referenceNumber;
    }

    public BigDecimal getTotalNumberOfCheques()
    {
	return totalNumberOfCheques;
    }

    public void setTotalNumberOfCheques(BigDecimal totalNumberOfCheques)
    {
	this.totalNumberOfCheques = totalNumberOfCheques;
    }

    public BigDecimal getSumOfCheques()
    {
	return sumOfCheques;
    }

    public void setSumOfCheques(BigDecimal sumOfCheques)
    {
	this.sumOfCheques = sumOfCheques;
    }

    public String getSelectedSignaturesGridUpdates()
    {
	return selectedSignaturesGridUpdates;
    }

    public void setSelectedSignaturesGridUpdates(String selectedSignaturesGridUpdates)
    {
	this.selectedSignaturesGridUpdates = selectedSignaturesGridUpdates;
    }

    public ArrayList<SignatureCO> getSignatureCOList()
    {
	return signatureCOList;
    }

    public void setSignatureCOList(ArrayList<SignatureCO> signatureCOList)
    {
	this.signatureCOList = signatureCOList;
    }

    public String getSignFromMainAcc()
    {
	return signFromMainAcc;
    }

    public void setSignFromMainAcc(String signFromMainAcc)
    {
	this.signFromMainAcc = signFromMainAcc;
    }

    public String getOriginCountryCodeDesc()
    {
	return originCountryCodeDesc;
    }

    public void setOriginCountryCodeDesc(String originCountryCodeDesc)
    {
	this.originCountryCodeDesc = originCountryCodeDesc;
    }

    public boolean isRemoveTempEntries()
    {
	return removeTempEntries;
    }

    public void setRemoveTempEntries(boolean removeTempEntries)
    {
	this.removeTempEntries = removeTempEntries;
    }

    public void setNumberOfBills(BigDecimal numberOfBills)
    {
	this.numberOfBills = numberOfBills;
    }

    public BigDecimal getNumberOfBills()
    {
	return numberOfBills;
    }

    public void setSumOfBills(BigDecimal sumOfBills)
    {
	this.sumOfBills = sumOfBills;
    }

    public BigDecimal getSumOfBills()
    {
	return sumOfBills;
    }

    public void setHiddenBranchCode(Boolean hiddenBranchCode)
    {
	this.hiddenBranchCode = hiddenBranchCode;
    }

    public Boolean getHiddenBranchCode()
    {
	return hiddenBranchCode;
    }

    

    public BigDecimal getCardReaderCivilID()
    {
	return cardReaderCivilID;
    }

    public void setCardReaderCivilID(BigDecimal cardReaderCivilID)
    {
	this.cardReaderCivilID = cardReaderCivilID;
    }

    public CardReaderCO getCardReaderCO()
    {
	return cardReaderCO;
    }

    public void setCardReaderCO(CardReaderCO cardReaderCO)
    {
	this.cardReaderCO = cardReaderCO;
    }

    public String getBlackListReasonDesc()
    {
	return blackListReasonDesc;
    }

    public void setBlackListReasonDesc(String blackListReasonDesc)
    {
	this.blackListReasonDesc = blackListReasonDesc;
    }

    public BigDecimal getBlackListReason()
    {
	return blackListReason;
    }

    public void setBlackListReason(BigDecimal blackListReason)
    {
	this.blackListReason = blackListReason;
    }

    public String getMethodName()
    {
	return methodName;
    }

    public void setMethodName(String methodName)
    {
	this.methodName = methodName;
    }

    public BigDecimal getBlackListReturnedValue()
    {
	return blackListReturnedValue;
    }

    public void setBlackListReturnedValue(BigDecimal blackListReturnedValue)
    {
	this.blackListReturnedValue = blackListReturnedValue;
    }

    public String getMsgIdent()
    {
	return msgIdent;
    }

    public void setMsgIdent(String msgIdent)
    {
	this.msgIdent = msgIdent;
    }

    public Integer getMsgCode()
    {
	return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
	this.msgCode = msgCode;
    }

    public BigDecimal getAccount_gl()
    {
	return account_gl;
    }

    public void setAccount_gl(BigDecimal account_gl)
    {
	this.account_gl = account_gl;
    }

    public boolean isRCVR_PCS_YN()
    {
	return RCVR_PCS_YN;
    }

    public void setRCVR_PCS_YN(boolean rCVR_PCS_YN)
    {
	RCVR_PCS_YN = rCVR_PCS_YN;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }
    public BigDecimal getTryMatch()
    {
        return tryMatch;
    }

    public void setTryMatch(BigDecimal tryMatch)
    {
        this.tryMatch = tryMatch;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public String getFnSource()
    {
        return fnSource;
    }

    public void setFnSource(String fnSource)
    {
        this.fnSource = fnSource;
    }

    public String getProceedWithCyPurchaseSale()
    {
        return proceedWithCyPurchaseSale;
    }

    public void setProceedWithCyPurchaseSale(String proceedWithCyPurchaseSale)
    {
        this.proceedWithCyPurchaseSale = proceedWithCyPurchaseSale;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamHm()
    {
        return sysParamHm;
    }

    public void setSysParamHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamHm)
    {
        this.sysParamHm = sysParamHm;
    }


    public BigDecimal getFinalCY()
    {
        return finalCY;
    }

    public void setFinalCY(BigDecimal finalCY)
    {
        this.finalCY = finalCY;
    }

    public BigDecimal getFinalCif()
    {
        return finalCif;
    }

    public void setFinalCif(BigDecimal finalCif)
    {
        this.finalCif = finalCif;
    }

    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getSbRate()
    {
        return sbRate;
    }

    public void setSbRate(String sbRate)
    {
        this.sbRate = sbRate;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public BigDecimal getRate()
    {
        return rate;
    }

    public void setRate(BigDecimal rate)
    {
        this.rate = rate;
    }

    public BigDecimal getAvailAmount()
    {
        return availAmount;
    }

    public void setAvailAmount(BigDecimal availAmount)
    {
        this.availAmount = availAmount;
    }

    public String getLoaded()
    {
        return loaded;
    }

    public void setLoaded(String loaded)
    {
        this.loaded = loaded;
    }

    public String getSpecialAuthLoaded()
    {
        return specialAuthLoaded;
    }

    public void setSpecialAuthLoaded(String specialAuthLoaded)
    {
        this.specialAuthLoaded = specialAuthLoaded;
    }

    public String getClientDetailsloaded()
    {
        return clientDetailsloaded;
    }

    public void setClientDetailsloaded(String clientDetailsloaded)
    {
        this.clientDetailsloaded = clientDetailsloaded;
    }

    public BigDecimal getCeiling()
    {
        return ceiling;
    }

    public void setCeiling(BigDecimal ceiling)
    {
        this.ceiling = ceiling;
    }

    public BigDecimal getOutstandingAm()
    {
        return outstandingAm;
    }

    public void setOutstandingAm(BigDecimal outstandingAm)
    {
        this.outstandingAm = outstandingAm;
    }

    public CTSTRS_EXCH_CLIENT_DETVO getCtsTrsExchClientDetVO()
    {
        return ctsTrsExchClientDetVO;
    }

    public void setCtsTrsExchClientDetVO(CTSTRS_EXCH_CLIENT_DETVO ctsTrsExchClientDetVO)
    {
        this.ctsTrsExchClientDetVO = ctsTrsExchClientDetVO;
    }

    public String getInstructionDesc()
    {
        return instructionDesc;
    }

    public void setInstructionDesc(String instructionDesc)
    {
        this.instructionDesc = instructionDesc;
    }

    public String getExchOffTicketFlag()
    {
        return exchOffTicketFlag;
    }

    public void setExchOffTicketFlag(String exchOffTicketFlag)
    {
        this.exchOffTicketFlag = exchOffTicketFlag;
    }

    public String getSubInstrAvailFlag()
    {
        return subInstrAvailFlag;
    }

    public void setSubInstrAvailFlag(String subInstrAvailFlag)
    {
        this.subInstrAvailFlag = subInstrAvailFlag;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getUseNegoRate()
    {
        return useNegoRate;
    }

    public void setUseNegoRate(String useNegoRate)
    {
        this.useNegoRate = useNegoRate;
    }

    public String getCyPurchaseSaleBehavior()
    {
        return cyPurchaseSaleBehavior;
    }

    public void setCyPurchaseSaleBehavior(String cyPurchaseSaleBehavior)
    {
        this.cyPurchaseSaleBehavior = cyPurchaseSaleBehavior;
    }

    public String getInstrDesc()
    {
        return instrDesc;
    }

    public void setInstrDesc(String instrDesc)
    {
        this.instrDesc = instrDesc;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public CTS_CIRCULAR_DEFVO getCtsCircularDefVO()
    {
        return ctsCircularDefVO;
    }

    public void setCtsCircularDefVO(CTS_CIRCULAR_DEFVO ctsCircularDefVO)
    {
        this.ctsCircularDefVO = ctsCircularDefVO;
    }

    public CTS_SUB_INSTRUCTIONVO getCtsSubInstructionVO()
    {
        return ctsSubInstructionVO;
    }

    public void setCtsSubInstructionVO(CTS_SUB_INSTRUCTIONVO ctsSubInstructionVO)
    {
        this.ctsSubInstructionVO = ctsSubInstructionVO;
    }

    public CTS_INSTRUCTIONVO getCtsInstructionVO()
    {
        return ctsInstructionVO;
    }

    public void setCtsInstructionVO(CTS_INSTRUCTIONVO ctsInstructionVO)
    {
        this.ctsInstructionVO = ctsInstructionVO;
    }
    
    public BigDecimal getProviderAmount()
    {
	return providerAmount;
    }

    public void setProviderAmount(BigDecimal providerAmount)
    {
	this.providerAmount = providerAmount;
    }

    public String getIsToDoAlert()
    {
	return isToDoAlert;
    }

    public void setIsToDoAlert(String isToDoAlert)
    {
	this.isToDoAlert = isToDoAlert;
    }

    public String getBillPaymentAddRefBtnOpened()
    {
	return billPaymentAddRefBtnOpened;
    }

    public void setBillPaymentAddRefBtnOpened(String billPaymentAddRefBtnOpened)
    {
	this.billPaymentAddRefBtnOpened = billPaymentAddRefBtnOpened;
    }
    public BigDecimal getMultiTrsNo()
    {
        return multiTrsNo;
    }

    public void setMultiTrsNo(BigDecimal multiTrsNo)
    {
        this.multiTrsNo = multiTrsNo;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public CTSTRS_BENEF_DET_ALERTVO getCtstrsBenefDetAlertVO()
    {
        return ctstrsBenefDetAlertVO;
    }

    public void setCtstrsBenefDetAlertVO(CTSTRS_BENEF_DET_ALERTVO ctstrsBenefDetAlertVO)
    {
        this.ctstrsBenefDetAlertVO = ctstrsBenefDetAlertVO;
    }

    public List<TrxMgntMoreBenefCO> getCtstrsBenefDetAlertVOs()
    {
        return ctstrsBenefDetAlertVOs;
    }

    public void setCtstrsBenefDetAlertVOs(List<TrxMgntMoreBenefCO> ctstrsBenefDetAlertVOs)
    {
        this.ctstrsBenefDetAlertVOs = ctstrsBenefDetAlertVOs;
    }

    public CTS_NON_FIN_INFO_ALERTVO getCtsNonFinInfoAlertVO()
    {
        return ctsNonFinInfoAlertVO;
    }

    public void setCtsNonFinInfoAlertVO(CTS_NON_FIN_INFO_ALERTVO ctsNonFinInfoAlertVO)
    {
        this.ctsNonFinInfoAlertVO = ctsNonFinInfoAlertVO;
    }

    public CTS_NON_FIN_INFOVO getCtsNonFinInfoVO()
    {
        return ctsNonFinInfoVO;
    }

    public void setCtsNonFinInfoVO(CTS_NON_FIN_INFOVO ctsNonFinInfoVO)
    {
        this.ctsNonFinInfoVO = ctsNonFinInfoVO;
    }

    public BigDecimal getExistingLineNo()
    {
        return existingLineNo;
    }

    public void setExistingLineNo(BigDecimal existingLineNo)
    {
        this.existingLineNo = existingLineNo;
    }

    public BigDecimal getInputAmount()
    {
        return inputAmount;
    }

    public void setInputAmount(BigDecimal inputAmount)
    {
        this.inputAmount = inputAmount;
    }
	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getFromMethod() {
		return fromMethod;
	}

	public void setFromMethod(String fromMethod) {
		this.fromMethod = fromMethod;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getNationality() {
		return nationality;
	}

	public void setNationality(BigDecimal nationality) {
		this.nationality = nationality;
	}

	public String getCardWarningMsg() {
		return cardWarningMsg;
	}

	public void setCardWarningMsg(String cardWarningMsg) {
		this.cardWarningMsg = cardWarningMsg;
	}

	public String getFromBreakDepOnOk()
	{
	    return fromBreakDepOnOk;
	}

	public void setFromBreakDepOnOk(String fromBreakDepOnOk)
	{
	    this.fromBreakDepOnOk = fromBreakDepOnOk;
	}

	 public boolean isAccBtnFromTrxSave()
	    {
	        return accBtnFromTrxSave;
	    }

	    public void setAccBtnFromTrxSave(boolean accBtnFromTrxSave)
	    {
	        this.accBtnFromTrxSave = accBtnFromTrxSave;
	    } 
	    
}