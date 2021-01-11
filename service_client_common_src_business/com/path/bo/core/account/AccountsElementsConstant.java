package com.path.bo.core.account;

import java.util.HashMap;

import com.path.lib.log.Log;

public final class AccountsElementsConstant
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private AccountsElementsConstant()
    {
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    }
    
    
    public static final String FMA_ACC_OPENING_PAGE_REF = "A001MT";

    // accountsManagementCO.amfVO.CURRENCY_CODE
    public static final String BRANCH_CODE = "accountsManagementCO.amfVO.BRANCH_CODE";
    public static final String CURRENCY_CODE = "accountsManagementCO.amfVO.CURRENCY_CODE";
    public static final String GL_CODE = "accountsManagementCO.amfVO.GL_CODE";
    public static final String CIF_SUB_NO = "accountsManagementCO.amfVO.CIF_SUB_NO";
    public static final String LINK_YEAR = "accountsManagementCO.amfVO.LNK_YEAR";

    public static final String CIFNAME = "accountsManagementCO.cifName";
    public static final String CIFNAME_ID = "cifName";
    // accountsManagementCO.cifName" id="cifName

    public static final String SL_NO = "accountsManagementCO.amfVO.SL_NO";
    public static final String SL_NO_ID = "srNo";
    public static final String GL_DESC_ID = "typeDesc";

    public static final String ADDITIONAL_REFERENCE = "accountsManagementCO.amfVO.ADDITIONAL_REFERENCE";

    public static final String CIF_NO_PREV_VALUE = "cifNoPrevValue";

    public static final String GENERAL_ACCOUNT_SAVE = "generalAccountSave";
    public static final String GA_MAINT_UPDATE = "gaMaintUpdate";
    public static final String GA_MAINT_DELETE = "gaMaintDelete";

    public static final String FMA_SAVE = "fmaSave";
    public static final String FMA_MAINT_UPDATE = "fmaMaintUpdate";
    public static final String FMA_MAINT_DELETE = "fmaOpenDelete";
    public static final String MORE_ADDRESS_BTN = "account_More_Address_btn";
    public static final String CHARGES_WAIVER_BTN = "chargesWaiverBtn";

    public static final String IBAN_ACC_NO = "accountsManagementCO.amfVO.IBAN_ACC_NO";

    public static final String UNIT_CODE = "accountsManagementCO.amfVO.UNIT_CODE";

    public static final String ECO_SECTOR_CODE = "accountsManagementCO.amfVO.ECO_SECTOR_CODE";
    public static final String ECO_SECTOR_CODE_ID = "lookuptxt_economicSector";
    public static final String ECOSECTORDESC = "accountsManagementCO.economicSectorDesc";
    public static final String ECOSECTORDESC_ID = "ecoSectorDesc";

    public static final String DIV = "accountsManagementCO.amfVO.DIV";
    public static final String DIV_ID = "lookuptxt_divisionId";
    public static final String DIV_DESC = "accountsManagementCO.divisionDesc";
    public static final String DIV_DESC_ID = "divisionDesc";
    public static final String ACC_TIER_NO = "lookuptxt_accTierNo"; // Added by nancy -- 17/07/2018 -- 382769-- account limits

    public static final String DEPT = "accountsManagementCO.amfVO.DEPT";
    public static final String DEPT_ID = "lookuptxt_departmentId";
    public static final String DEPT_DESC = "accountsManagementCO.departmentDesc";
    public static final String DEPT_DESC_ID = "departmentDesc";

    public static final String SUB_ECO_SECTOR_CODE = "accountsManagementCO.amfVO.SUB_ECO_SECTOR_CODE";
    public static final String SUB_ECO_SECTOR_CODE_ID = "lookuptxt_subEconomicSector";

    public static final String SUB_ECOSECTORDESC = "accountsManagementCO.subEconomicSectorDesc";
    public static final String SUB_ECOSECTORDESC_ID = "subEcoSectorDesc";

    // public static final String CURRENCY_MIN_BAL
    // ="accountsManagementCO.amfVO.CURRENCY_MIN_BAL";
    public static final String CURRENCY_MIN_BAL_ID = "minimumOpeningBalance";
    // public static final String CURRENCY_MIN_BAL_ID= "payableAmount";

    public static final String MINIMUM_BALANCE = "accountsManagementCO.minimumBalance";
    public static final String MINIMUM_BALANCE_ID = "minimumBalance";
    public static final String PAYABLE_AMOUNT_ID = "payableAmount";

    public static final String EFF_CLSD_DTE = "accountsManagementCO.amfVO.EFF_CLSD_DTE";

    public static final String SUSPEND_REASON = "accountsManagementCO.amfVO.SUSPEND_REASON";
    public static final String SUSPEND_REASON_DESC = "statusReasonDesc";
    public static final String WITHD_PER = "accountsManagementCO.amfVO.WITHD_PER";
    public static final String AUTO_SWEEP_ID = "autoSweep";
    public static final String AUTO_SWEEP = "accountsManagementCO.amfVO.AUTO_SWEEP";
    public static final String AUTO_SWEEP_MIN_BAL = "minBalance";
    public static final String ON_LOAD_AUTO_SWEEP_MIN_BAL = "accountsManagementCO.amfVO.AUTO_SWEEP_MIN_BAL";
    
    public static final String STATUS_REASON = "accountsManagementCO.amfVO.STATUS_REASON";

    public static final String PROFIT_TILL_DUE_DATE = "profitTillDueDate";
    public static final String PROFIT_TILL_DATE = "profitTillDate";
    public static final String OF_THE_TOTAL_DEPOSITAMOUNT = "accountsManagementCO.ofTheTotalDepositAmount";
    public static final String PERCENTAGE_LABEL = "accountsManagementCO.percentageLabel";

    public static final String MIN_DEP = "accountsManagementCO.amfVO.MIN_DEP";

    public static final String JOINT_ACCOUNTS_ID = "jointAccount";

//    public static final String MODE_COMM = "modeOfStmtDelivery";
    public static final String MODE_STMT_DELIVERY_ID = "modeOfStmtDelivery";

    public static final String OFFICER_ID = "accountsManagementCO.amfVO.OFFICER_ID";
    public static final String OFFICER_ID_ID = "lookuptxt_officerId";

    public static final String OFFICER_DESCRIPTION = "accountsManagementCO.officerDesc";
    public static final String OFFICER_DESCRIPTION_ID = "officerName";

    public static final String DESCRIPTION = "accountsManagementCO.amfVO.DESCRIPTION";
    public static final String DESCRIPTION_ID = "description";

    public static final String OFFICER_DESC = "accountsManagementCO.officerDesc";

    public static final String SS_ACC_NO = "accountsManagementCO.amfVO.SS_ACC_NO";
    public static final String DOWN_GRD_DTE = "accountsManagementCO.amfVO.DOWN_GRD_DTE";

    // PT calculation Details

    public static final String PT_IND = "accountsManagementCO.amfVO.PT_IND";
    public static final String PT_PERIOD = "accountsManagementCO.amfVO.PT_PERIOD";
    public static final String AC_SIGN = "accountsManagementCO.amfVO.AC_SIGN";

    // public static final String INTEREST_INDEX="interestIndex";

    public static final String CR_APPL_DATE = "accountsManagementCO.amfVO.CR_APPL_DATE";
    public static final String CR_PT_RATE = "accountsManagementCO.amfVO.CR_PT_RATE";
    public static final String CR_PT_INDEX = "accountsManagementCO.amfVO.CR_PT_INDEX";

    public static final String DR_APPL_DATE = "accountsManagementCO.amfVO.DR_APPL_DATE";
    public static final String DR_PT_RATE = "accountsManagementCO.amfVO.DR_PT_RATE";
    public static final String DR_PT_INDEX = "accountsManagementCO.amfVO.DR_PT_INDEX";

    public static final String MODARIB_RATE = "accountsManagementCO.amfVO.MODARIB_RATE";
    public static final String MODARIB_RATE_ID = "modaribRate";

    public static final String PSR_CUSTOMER = "accountsManagementCO.psrCustomer";
    public static final String PSR_CUSTOMER_ID = "psrCustomer";

    public static final String LAST_POST_DATE = "accountsManagementCO.amfVO.LAST_POST_DATE";
    public static final String CH_EVT_REGION = "lookuptxt_addressCO_REGION";
    public static final String CH_EVT_REGION_DESC = "addressCO_regionDesc";
    public static final String ADVANCE_PROFIT_YN = "accountsManagementCO.amfExtendedVO.ADVANCE_PROFIT_YN";
    public static final String DEDUCTION_METHOD = "accountsManagementCO.amfExtendedVO.DEDUCTION_METHOD";
    public static final String ADVANCE_PROFIT_PERCENTAGE = "accountsManagementCO.amfExtendedVO.ADVANCE_PROFIT_PERCENTAGE";
    public static final String DEDUCTION_PERIODICITY = "accountsManagementCO.amfExtendedVO.DEDUCTION_PERIODICITY";

    public static final String FL_IND = "accountsManagementCO.amfVO.FL_INDT";
    public static final String FL_IND_ID = "facilityIndicator";
    public static final String FL_AMT = "accountsManagementCO.amfVO.FL_AMT";
    public static final String FL_AMT_ID = "facilityAmount";

    public static final String DEPOSIT_RATE = "accountsManagementCO.amfVO.DEPOSIT_RATE";
    public static final String DEPOSIT_RATE_ID = "depositRate";

    public static final String DEPOSIT_EQUIV = "accountsManagementCO.amfVO.DEPOSIT_EQUIV";
    public static final String DEPOSIT_EQUIV_ID = "depositEquiv";

    public static final String COMM_FEES_ID = "commFees";
    public static final String DISCNT_FACT_ID = "discountFactor";
    public static final String PERIODICITY_OVERDRAFT = "periodicity_overdraft";

    public static final String DISCNT_FACT = "accountsManagementCO.amfVO.DISCNT_FACT";
    public static final String GL_TERM = "accountsManagementCO.amfVO.GL_TERM";

    
    // <hedaer Details>
    public static HashMap<String, String> HeaderElements()
    {
	HashMap<String, String> hmElements = new HashMap<String, String>();
	hmElements.put("CURRENCY_CODE", "accountsManagementCO.amfVO.CURRENCY_CODE");
	hmElements.put("GL_CODE", "accountsManagementCO.amfVO.GL_CODE");
	hmElements.put("CIF_SUB_NO", "accountsManagementCO.amfVO.CIF_SUB_NO");
	hmElements.put("SL_NO", "accountsManagementCO.amfVO.SL_NO");
	hmElements.put("ADDITIONAL_REFERENCE", "accountsManagementCO.amfVO.ADDITIONAL_REFERENCE");
	hmElements.put("formattedReference", "accountsManagementCO.FORMATTED_ADDITIONAL_REFERENCE");  //id:1057741 Details:MBSI200026 - Seperator set up not working while account number generation falha TAR:MBSI200026

	return hmElements;
    }

    /**
     *  Address Elements
     *  these fields are set by each screen to show/hide elements
     */
    public static HashMap<String, String> AddressElements()
    {

	HashMap<String, String> addressElements = new HashMap<String, String>();
	addressElements.put("WORK_TEL", "addressCO.WORK_TEL");
	addressElements.put("MOBILE", "addressCO.MOBILE");
	addressElements.put("OTHER_TEL", "addressCO.OTHER_TEL");
	addressElements.put("REGION", "addressCO.REGION");
	addressElements.put("regionDesc", "addressCO.regionDesc");
	addressElements.put("COUNTRY", "addressCO.COUNTRY");
	addressElements.put("countryDesc", "addressCO.countryDesc");
	addressElements.put("CITY_CODE", "addressCO.CITY_CODE");
	addressElements.put("cityDesc", "addressCO.cityDesc");
	addressElements.put("SECTOR_CODE", "addressCO.SECTOR_CODE");
	addressElements.put("sectorDesc", "addressCO.sectorDesc");
	addressElements.put("ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION");
	addressElements.put("residenceTypeDesc", "addressCO.residenceTypeDesc");
	addressElements.put("EXPIRY_DATE", "addressCO.EXPIRY_DATE");
	addressElements.put("FROM_DATE", "addressCO.FROM_DATE");
	addressElements.put("TO_DATE", "addressCO.TO_DATE");
	addressElements.put("permnAddrFlag", "addressCO.permnAddrFlag");
	 addressElements.put("POBOX_AREA", "addressCO.POBOX_AREA");
	 addressElements.put("poBoxAreaDesc", "addressCO.poBoxAreaDesc");
	// addressElements.put("POSTAL_CODE", "addressCO.POSTAL_CODE");
	// addressElements.put("postalcodeDesc", "addressCO.postalcodeDesc");
	addressElements.put("PO_BOX", "addressCO.PO_BOX");

	return addressElements;
    }

    // overDraftDetail Elements
    public static HashMap<String, String> OverDraftDetail()
    {

	HashMap<String, String> overDraftDetail = new HashMap<String, String>();
	overDraftDetail.put("FACILITY_NO", "accountsManagementCO.amfVO.FACILITY_NO");
	overDraftDetail.put("FACILITY_SUB_LIMIT", "accountsManagementCO.amfVO.FACILITY_SUB_LIMIT");
	overDraftDetail.put("LIMIT_EXP_DATE", "accountsManagementCO.amfVO.LIMIT_EXP_DATE");
	overDraftDetail.put("OVERDRAFT_LIMIT", "accountsManagementCO.amfVO.OVERDRAFT_LIMIT");
	overDraftDetail.put("LIBOR", "accountsManagementCO.amfVO.LIBOR");
	overDraftDetail.put("PERIODICITY", "accountsManagementCO.amfVO.PERIODICITY");
	overDraftDetail.put("CHARGES_FEES", "accountsManagementCO.amfVO.CHARGES_FEES");
	overDraftDetail.put("chargesDesc", "accountsManagementCO.chargesDesc");
	overDraftDetail.put("MIN_RATE", "accountsManagementCO.amfVO.MIN_RATE");
	overDraftDetail.put("PENALTY", "accountsManagementCO.amfVO.PENALTY");
	overDraftDetail.put("MAX_RATE", "accountsManagementCO.amfVO.MAX_RATE");
	overDraftDetail.put("availableOverdraft", "availableOverdraft");
	overDraftDetail.put("ovDraftAvLimit", "ovDraftAvLimit");

//	overDraftDetail.put("lblFacilityNo", "lblFacilityNo");
//	overDraftDetail.put("lblFacilitySubLimit", "lblFacilitySubLimit");
//	overDraftDetail.put("lblCharges", "lblCharges");
//	overDraftDetail.put("lblovDraftAvLimit", "lblovDraftAvLimit");

	return overDraftDetail;
    }

    //Hala Al Sheikh - SBI170059 SBI170060
    public static HashMap<String, String> OverDraftDetailLoad()
    {

	HashMap<String, String> OverDraftDetailLoad = new HashMap<String, String>();
	OverDraftDetailLoad.put("FACILITY_NO", "lookuptxt_facility_no");
	OverDraftDetailLoad.put("FACILITY_SUB_LIMIT", "lookuptxt_facility_sub_limit");
	OverDraftDetailLoad.put("LIMIT_EXP_DATE", "expiryDate");
	OverDraftDetailLoad.put("OVERDRAFT_LIMIT", "overDraftLimit");
	OverDraftDetailLoad.put("LIBOR", "liborPlusMinus");
	OverDraftDetailLoad.put("PERIODICITY", "periodicity_overdraft");
	OverDraftDetailLoad.put("CHARGES_FEES", "lookuptxt_charges_fees");
	OverDraftDetailLoad.put("chargesDesc", "charges_fees_Desc");
	OverDraftDetailLoad.put("MIN_RATE", "minRate");
	OverDraftDetailLoad.put("PENALTY", "penaltyPercentage");
	OverDraftDetailLoad.put("MAX_RATE", "maxRate");
	OverDraftDetailLoad.put("availableOverdraft", "availableOverdraft");
	OverDraftDetailLoad.put("ovDraftAvLimit", "ovDraftAvLimit");
	return OverDraftDetailLoad;
    }
    
    // <points details Division>
    public static HashMap<String, String> PointDetailsElements()
    {
	HashMap<String, String> hmElements = new HashMap<String, String>();
	hmElements.put("PT_IND", "accountsManagementCO.amfVO.PT_IND");
	hmElements.put("PT_PERIOD", "accountsManagementCO.amfVO.PT_PERIOD");
	hmElements.put("AC_SIGN", "accountsManagementCO.amfVO.AC_SIGN");
	hmElements.put("CR_APPL_DATE", "accountsManagementCO.amfVO.CR_APPL_DATE");
	hmElements.put("DR_APPL_DATE", "accountsManagementCO.amfVO.DR_APPL_DATE");
	hmElements.put("DR_PT_RATE", "accountsManagementCO.amfVO.DR_PT_RATE");
	hmElements.put("CR_PT_RATE", "accountsManagementCO.amfVO.CR_PT_RATE");
	return hmElements;
    }

    public static HashMap<String, String> OpenDepositElements()
    {
	HashMap<String, String> hmElements = new HashMap<String, String>();
	hmElements.put("OPEN_DEP_AMOUNT", "accountsManagementCO.amfVO.OPEN_DEP_AMOUNT");
	hmElements.put("SEQ_NO", "accountsManagementCO.amfV.SEQ_NO");
	hmElements.put("SERIAL_NO", "accountsManagementCO.amfVO.SERIAL_NO");
	hmElements.put("CUR_AC_BR", "accountsManagementCO.amfVO.CUR_AC_BR");
	hmElements.put("CUR_AC_CY", "accountsManagementCO.amfVO.CUR_AC_CY");
	hmElements.put("CUR_AC_GL", "accountsManagementCO.amfVO.CUR_AC_GL");
	hmElements.put("CUR_AC_CIF", "accountsManagementCO.amfVO.CUR_AC_CIF");
	hmElements.put("CUR_AC_SL", "accountsManagementCO.amfVO.CUR_AC_SL");
	hmElements.put("OPEN_DEP_TRX_TYPE", "accountsManagementCO.amfVO.OPEN_DEP_TRX_TYPE");
	hmElements.put("MATURITY_DTE", "accountsManagementCO.amfVO.MATURITY_DTE");
	hmElements.put("MATURITY_DAYS", "accountsManagementCO.amfVO.MATURITY_DAYS");

	return hmElements;

    }

    public static final String MAIL_ADVISE = "accountsManagementCO.amfVO.MAIL_ADVISE";
    public static final String MAIL_ADVISE_ID = "mailDrCrAdvice";
    public static final String MAIL_STMT = "accountsManagementCO.amfVO.MAIL_STMT";
    public static final String MAIL_STMT_ID = "statement";
    public static final String STMT_PERIOD = "accountsManagementCO.amfVO.STMT_PERIOD";
    public static final String STMT_PERIOD_ID = "periodicity";

    public static final String MATURITY_DTE = "accountsManagementCO.amfVO.MATURITY_DTE";
    public static final String MATURITY_DAYS = "accountsManagementCO.amfVO.MATURED_CALCULATION";

    public static final String MATURED_CALCULATION = "accountsManagementCO.amfVO.MATURED_CALCULATION";

    //public static final String RENEW = "accountsManagementCO.amfVO.RENEW";
    public static final String EXT_TRF = "accountsManagementCO.amfVO.EXT_TRF";
    public static final String FINAL_MATURITY_DATE = "accountsManagementCO.amfVO.FINAL_MATURITY_DATE";
    public static final String TAX_APPLIED = "accountsManagementCO.amfVO.TAX_APPLIED";
    public static final String APPLY_PCS_CHARGES = "accountsManagementCO.amfVO.APPLY_PCS_CHARGES";

    public static final String ZAKAT_APPLIED = "accountsManagementCO.amfVO.ZAKAT_APPLIED";
    public static final String DEDUCT_ZAKAT_FR = "accountsManagementCO.amfVO.DEDUCT_ZAKAT_FR";

    public static final String PREM_DED_PCS = "accountsManagementCO.amfVO.PREM_DED_PCS";
    public static final String PREM_DED_PCS_ID = "applyProfitPremiumDeduction";
     public static final String APPLY_CHARGES_ID = "applyCharges";
    public static final String APPLY_TAX_ID = "applyTax";
    // public static final String EXT_TRF= "accountsManagementCO.amfVO.EXT_TRF";
    /*
     * tab_1.tp_9.dw_extended.setitem(1,'reset_rate_maturity','1') END IF
     * 
     * Tab_1.tp_2.dw_main_2.SetItem(1,'special_rate','0')
     */
    public static final String CH_EVT_CREATE_NEW_ACCOUNT = "createNewAccount";
    public static final String CH_EVT_ACC_TYPE_NEW_OFF_INSTR = "lookuptxt_accountTypeNewOffInstr";
    public static final String CH_EVT_PT_INDICATOR = "ptIndicator";
    public static final String CH_EVT_FINAL_MATURITY_DATE = "finalMaturityDate";
    public static final String CH_EVT_MATURITY_DATE = "maturityDate";
    public static final String CH_EVT_MATURITY_DAYS = "maturityDays";
    public static final String CH_EVT_AC_SIGN = "accountSign";
    public static final String CH_EVT_AC_SIGN_1 = "maximumOverdrawBalanceDesc";
    public static final String CH_EVT_AC_SIGN_2 = "minimumBalancePointsDesc";
    
    public static final String CH_EVT_MAIL_ADVISE = "mailDrCrAdvice";
    public static final String CH_EVT_PT_PERIOD = "ptPeriod";
    public static final String CH_EVT_MATURED_CALCULATION = "distributionPeriodicity";
    public static final String CH_EVT_LAST_POST_DATE = "lastPostDate";
    public static final String CH_EVT_MAIL_STMT = "statement";
    public static final String CH_EVT_MAIL_STMT_PERIOD = "periodicity";
    public static final String CH_EVT_CERTIF_OF_MGMT = "accountsManagement_certificateDeposit_Btn";
    public static final String CH_EVT_OPEN_DEP_AMOUNT = "amount";
    public static final String CH_EVT_SERIAL_NO = "serialNumber";
    public static final String CH_EVT_SEQ_NO = "sequence";
    public static final String CH_EVT_ACCOUNT_OPEN_DEPOSIT = "accBrOpd~accCyOpd~accGlOpd~accCifOpd~lookuptxt_accSlOpd~lookuptxt_accAddRefOpd~accDescOpd";// AccountsInstructionsTab
																			 // :
																			 // accountsManagementCO.amfVO.CUR_AC_BR~accountsManagementCO.amfVO.CUR_AC_CY~accountsManagementCO.amfVO.CUR_AC_GL~accountsManagementCO.amfVO.CUR_AC_CIF~accountsManagementCO.amfVO.CUR_AC_SL~accountsManagementCO.curAccName~accountsManagementCO.curAccAddRef:
																			 // sequence
    public static final String CH_EVT_OPEN_DEP_TRX_TYPE = "lookuptxt_openDepTrxType";
    // AccountsElementsConstant.CH_EVT_OPEN_DEP_TRX_TYPE_DESC
    public static final String CH_EVT_OPEN_DEP_TRX_TYPE_DESC = "openDepTrxTypeDesc";
    public static final String CH_EVT_RENEW = "renewAccount";
    public static final String CH_EVT_EXT_TRF = "externalTransfer";
    public static final String CH_EVT_CR_PT_METHOD_DAYS = "creditPTMethodDays";
    public static final String CH_EVT_DR_APPL_DATE = "applicableDateDebit";
    public static final String CH_EVT_CR_APPL_DATE = "applicableDateCredit";
    public static final String CH_EVT_DR_PT_RATE = "rate";
    public static final String CH_EVT_CR_PT_RATE = "creditRate";
    public static final String CH_EVT_ORIGIN_DR_RATE = "originDrRate";
    public static final String CH_EVT_ORIGIN_CR_RATE = "originCrRate";

    public static final String CH_EVT_TRF_BR = "accBrMI";
    public static final String CH_EVT_TRF_CY = "accCyMI";
    public static final String CH_EVT_TRF_GL = "accGlMI";
    public static final String CH_EVT_TRF_CIF = "accCifMI";
    public static final String CH_EVT_TRF_SL = "lookuptxt_accSlMI";
    public static final String CH_EVT_TRF_ADDREF = "lookuptxt_accAddRefMI";
    public static final String CH_EVT_TRF_DESC = "accDescMI";
    

    public static final String TRF_BR = "accountsManagementCO.amfVO.TRF_BR";
    public static final String TRF_CY = "accountsManagementCO.amfVO.TRF_CY";
    public static final String TRF_GL = "accountsManagementCO.amfVO.TRF_GL";
    public static final String TRF_CIF = "accountsManagementCO.amfVO.TRF_CIF";
    public static final String TRF_SL = "accountsManagementCO.amfVO.TRF_SL";
    public static final String RENEW_MAT_DAYS = "accountsManagementCO.amfVO.RENEW_MAT_DAYS";
    public static final String RENEW_MAT_DATE = "accountsManagementCO.amfVO.RENEW_MAT_DATE";
    public static final String TRF_CUR_ACCAD = "accountsManagementCO.trfCurAccAddRef";

//    public static final String CH_EVT_MATURITY_GL = "accountTypeAccInstr";
    public static final String CH_EVT_POST_PFT_TO = "postProfitTo";
    
    public static final String CH_EVT_POST_INTREST_TO = "postInterestTo";
    
    public static final String CH_EVT_CIF_SUB_NO = "cif_sub_no";
    public static final String CH_EVT_SL_NO = "srNo";
    public static final String CH_EVT_LONG_NAME_ENG = "longNameEng";
    public static final String CH_EVT_BRIEF_NAME_ENG = "breifName";
    public static final String CH_EVT_FULL_NAME_ENG = "fullNameEng";
    public static final String CH_EVT_LONG_NAME_ARAB = "longNameArb";
    public static final String CH_EVT_BRIEF_NAME_ARAB = "briefNameArb";
    public static final String CH_EVT_FULL_NAME_ARAB = "fullNameArb";
    public static final String CH_EVT_ADDITIONAL_REFERENCE = "reference";
    public static final String CH_EVT_AFFECT_PASS_BOOK = "affectPassbook"; 
    public static final String CH_EVT_AFFECT_BILLS = "affectBills";
    public static final String CH_EVT_CANCEL_CHARGES = "applySpecificChargesForRqst";
    public static final String CH_EVT_MODARIB_RATE = "modaribRate";
    public static final String CH_EVT_PSR_CUSTOMER = "psrCustomer";
    public static final String CH_EVT_DR_PT_INDEX = "interestIndex";
    public static final String CH_EVT_CR_PT_INDEX = "ptIndex";
    public static final String CH_EVT_HOLD_AMOUNT = "holdAmount";
    public static final String HOLD_TRX_TYPE_DESC = "holdTrxTypeDesc";
    public static final String CH_EVT_HOLD_TRX_TYPE = "lookuptxt_holdTrxType";
    public static final String CH_EVT_DEDUCT_ZAKAT_FR = "deductZakatFr";
    public static final String CH_EVT_APPLY_ZAKAT = "applyZakat";
    public static final String CH_EVT_ADVANCE_PROFIT = "advanceProfit";
    public static final String CH_EVT_ADVANCE_PROFIT_PERCTAGE = "advanceProfitText";
    public static final String CH_EVT_DEDUCTION_PERIODICITY = "deductionPeriodicity";
    public static final String CH_EVT_DEDUCTION_METHOD = "deductionMethod";
    public static final String CH_EVT_GL_CODE = "lookuptxt_glType";
    public static final String CH_EVT_CIF_SUB_NO_MAIN = "lookuptxt_cifNo";
    public static final String CH_EVT_CY_CODE = "lookuptxt_currencyCode";
    // public static final String CH_EVT_MIN_OPEN_BAL = "minimumOpeningBalance";
    
    public static final String CH_EVT_MIN_DEPOSIT = "minimumDeposit";
    public static final String CH_EVT_PAYABLE_AMOUNT = "payableAmount";

    public static final String CH_EVT_OFF_BR = "accBrOI";
    public static final String CH_EVT_OFF_CY = "accCyOI";
    public static final String CH_EVT_OFF_GL = "accGlOI";
    public static final String CH_EVT_OFF_CIF = "accCifOI";
    public static final String CH_EVT_OFF_SL = "lookuptxt_accSlOI";
    public static final String CH_EVT_OFF_ADDREF = "lookuptxt_accAddRefOI";
    public static final String CH_EVT_OFF_DESC = "accDescOI";

    public static final String CH_EVT_PFT_BR = "accBrPI";
    public static final String CH_EVT_PFT_CY = "accCyPI";
    public static final String CH_EVT_PFT_GL = "accGlPI";
    public static final String CH_EVT_PFT_CIF = "accCifPI";
    public static final String CH_EVT_PFT_SL = "lookuptxt_accSlPI";
    public static final String CH_EVT_PFT_ADDREF = "lookuptxt_accAddRefPI";
    public static final String CH_EVT_PFT_ACC_DESC = "accDescPI";
    
    public static final String CH_EVT_OPD_BR = "accBrOpd";
    public static final String CH_EVT_OPD_CY = "accCyOpd";
    public static final String CH_EVT_OPD_GL = "accGlOpd";
    public static final String CH_EVT_OPD_CIF = "accCifOpd";
    public static final String CH_EVT_OPD_SL = "lookuptxt_accSlOpd";
    public static final String CH_EVT_OPD_ADDREF = "lookuptxt_accAddRefOpd";
    public static final String CH_EVT_OPD_DESC = "accDescOpd";
    
    public static final String CH_EVT_CR_PT_METHOD = "creditPTMethod";
    public static final String CH_EVT_CURRENCY_DESC = "currencyDesc";
    public static final String CH_EVT_DEPOSIT_RATE = "depositRate";
    public static final String CH_EVT_RESET_MATURITY = "resetRateMaturity";
    public static final String CH_EVT_CRED_SPEC_RATE = "creditSpecialRateSelect";
    public static final String CH_EVT_ORIGIN = "debitPTMethod";
    public static final String CH_EVT_BANK_ACCOUNT = "lookuptxt_bankAccount";
    public static final String CH_EVT_CY_TRANSFER_ACCOUNT = "accCyTransferAc";
    public static final String CH_EVT_CY_FACILITY_NO = "lookuptxt_facility_no";
    public static final String CH_EVT_FACILITY_SUB_LIMIT = "lookuptxt_facility_sub_limit";
    public static final String CH_EVT_OVER_DRAFT_LIMIT = "overDraftLimit";
    public static final String CH_EVT_AVAILABLE_OVERDRAFT = "availableOverdraft";
    public static final String CH_EVT_OVERDRAFT_AVAIL_LIMIT = "ovDraftAvLimit";
    public static final String CH_EVT_LIBOR_PLUS_MINUS = "liborPlusMinus";
    public static final String CH_EVT_MIN_RATE = "minRate";
    public static final String CH_EVT_MAX_RATE = "maxRate";
    public static final String CH_EVT_EXPIRY_DATE = "expiryDate";
    public static final String CH_EVT_PENALTY_PERCENTAGE = "penaltyPercentage";
    public static final String CH_EVT_CHARGES_FEES = "lookuptxt_charges_fees";
    public static final String CH_EVT_CHARGES_FEES_DESC = "charges_fees_Desc";
    public static final String CH_EVT_DET_MODE_OF_PAYMENT = "modeOfPayment";
    public static final String CH_EVT_FLOATING_RATE = "floatingRate";
    public static final String CH_EVT_MARGIN_RATE = "marginRate";

    public static final String CH_EVT_DET_POST_DATE = "postDate";
    
    public static final String CH_EVT_PFT_BR_GA = "pftBr";
    public static final String CH_EVT_PFT_CY_GA = "pftCy";
    public static final String CH_EVT_PFT_GL_GA = "pftGl";
    public static final String CH_EVT_PFT_CIF_GA = "pftCif";
    public static final String CH_EVT_PFT_SL_GA = "lookuptxt_pftSl";
    public static final String CH_EVT_PFT_ADD_REF_GA = "lookuptxt_pftAddRef";
    public static final String CH_EVT_PFT_DESC_GA = "pftDesc";
   
    public static final String CH_EVT_PFT_TYPES_GA = "typesGA";
    public static final String CH_EVT_ACC_BC = "accBc";
    public static final String CH_MIN_STMT_BAL = "minStatementBal";

    public static final String CH_EVT_CURR_CIF = "accCifOpd";
    public static final String CH_PRINT_STAT = "addressCO_PRINT_STAT";
    public static final String CH_ADDRESS1_ENG = "addressCO_ADDRESS1_ENG";
    public static final String CH_ADDRESS2_ENG = "addressCO_ADDRESS2_ENG";
    public static final String CH_ADDRESS3_ENG = "addressCO_ADDRESS3_ENG";
    public static final String CH_ADDRESS4_ENG = "addressCO_ADDRESS4_ENG";
    public static final String CH_ADDRESS1_ARAB = "addressCO_ADDRESS1_ARAB";
    public static final String CH_ADDRESS2_ARAB = "addressCO_ADDRESS2_ARAB";
    public static final String CH_ADDRESS3_ARAB = "addressCO_ADDRESS3_ARAB";
    public static final String CH_ADDRESS4_ARAB = "addressCO_ADDRESS4_ARAB";
    public static final String CH_ADDRESS_DESC = "lookuptxt_addressCO_ADDRESS_DESCRIPTION";
    // public static final String CH_CONTACT_NAME_ARAB = "";
    // public static final String CH_CONTACT_NAME = "";
    // public static final String CH_GOVERNERATE_ENG = "";
    // public static final String CH_GOVERNERATE_ARAB = "";
    // public static final String CH_SALUTATION_ENG = "";
    // public static final String CH_SALUTATION_ARAB = "";
    // public static final String CH_POSTAL_CODE1 = "";

    public static final String CH_STREET_DETAILS_ENG = "addressCO_STREET_DETAILS_ENG";
    public static final String CH_CITY_ENG = "addressCO_CITY_ENG";
    public static final String CH_STREET_DETAILS_ARAB = "addressCO_STREET_DETAILS_ARAB";
    public static final String CH_CITY_ARB = "addressCO_CITY_ARB";
    public static final String CH_FAX = "addressCO_FAX";
    public static final String CH_TEL = "addressCO_TEL";
    public static final String CH_DEFAULT_ADD = "addressCO_DEFAULT_ADD";
    public static final String CH_PO_BOX = "addressCO_PO_BOX";
    public static final String CH_COUNTRY = "lookuptxt_addressCO_COUNTRY";
    public static final String CH_COUNTRY_DESC = "addressCO_countryDesc";
    public static final String CH_MOBILE = "addressCO_MOBILE";
    public static final String CH_WORK_TEL = "addressCO_WORK_TEL";
    public static final String CH_EMAIL = "addressCO_EMAIL";
    public static final String CH_OTHER_TEL = "addressCO_OTHER_TEL";
    public static final String CH_POSTAL_CODE = "lookuptxt_addressCO_POSTAL_CODE";
    public static final String CH_POSTAL_CODE_DESC = "addressCO_postalcodeDesc";
    public static final String CH_REGION = "lookuptxt_addressCO_REGION";
    public static final String CH_POBOX_AREA = "addressCO_POBOX_AREA";
    public static final String CH_GOVERNERATE_ENG = "addressCO_GOVERNERATE_ENG";
    public static final String CH_GOVERNERATE_ARAB = "addressCO_GOVERNERATE_ARAB";

    public static final String CH_EVT_RENEW_MAT_DATE = "renewMaturityDate";
    public static final String CH_EVT_RENEW_MAT_DAYS = "renewMaturityDays";
    public static final String CH_EVT_DIS_PROFIT_MAT_ACT = "distProfitToMaturityAccount";
    public static final String CH_EVT_ACC_TYPE_ACC_INSTR = "lookuptxt_accountTypeAccInstr";
    
    public static final String CH_EVT_BR_TRNS = "accBrTransferAc";
    public static final String CH_EVT_CY_TRNS = "accCyTransferAc";
    public static final String CH_EVT_GL_TRNS = "accGlTransferAc";
    public static final String CH_EVT_CIF_TRNS = "accCifTransferAc";
    public static final String CH_EVT_SL_NO_TRNS = "lookuptxt_accSlTransferAc";
    public static final String CH_EVT_ADD_REF_TRNS = "lookuptxt_addRefTransferAc";
    public static final String CH_EVT_DESC_TRNS = "accDescTransferAc";
    
    public static final String CH_EVT_DET_TRANSFER_ACC_BR = "accMainDetTransfrAccBr";
    public static final String CH_EVT_DET_TRANSFER_ACC_CY = "accMainDetTransfrAccCy";
    public static final String CH_EVT_DET_TRANSFER_ACC_GL = "accMainDetTransfrAccGl";
    public static final String CH_EVT_DET_TRANSFER_ACC_CIF = "accMainDetTransfrAccCif";
    public static final String CH_EVT_DET_TRANSFER_ACC_SL = "lookuptxt_accMainDetTransfrAccSl";
    public static final String CH_EVT_DET_TRANSFER_ACC_ADDREF = "lookuptxt_accMainDetTransfrAccAddRef";
    public static final String CH_EVT_DET_TRANSFER_ACC_DESC = "accMainDetTransfrAccDesc";
    public static final String CH_EVT_APPLY_TAX_ON_CAP_REVENUE = "appTaxCapRev";
    public static final String CH_EVT_TCR_RATE = "taxRateCapRev";
    public static final String CH_EVT_EXEMPT_FULL_CHARGES_WAIVER  = "exemptFullChargesWaiver";
    
    public static final String CH_EVT_ACC_TYPE_ACC_TRNS_DESC = "glTypeDescAccountsAccTransDetTab";

    public static final String CH_EVT_MIN_BALANCE_POINTS = "minimumBalancePoints";
    public static final String CH_EVT_MAX_OVERDRAW_BAL = "maximumOverdrawBalance";
    public static final String CH_EVT_MIN_OVERDRAW_POINTS = "minimumOverdrawPoints";
    public static final String CH_EVT_ACCOUNTS_HAVING_CIF_DORMANT = "accountsHavingCifDormant";
    public static final String CH_EVT_CURRENCT_MATURITY_DAYS = "currentMaturityDays";
    public static final String CH_EVT_EXEMPTED_FROM_VAT_YN = "amfExtendedVO_EXEMPTED_FROM_VAT_YN";
    public static final String CH_EVT_GENERATE_QRCODE_YN = "generateQrCode_YN";
    public static final String CH_EVT_QR_CODE_BUTTON_ID = "qrcodebutton";

    public static final String ON_LOAD_FINAL_MATURITY_DATE = "accountsManagementCO.amfVO.FINAL_MATURITY_DATE";
    public static final String ON_LOAD_MATURITY_DATE = "accountsManagementCO.amfVO.MATURITY_DTE";
    public static final String ON_LOAD_AC_SIGN = "accountsManagementCO.amfVO.AC_SIGN";
    public static final String ON_LOAD_AC_SIGN_1 = "accountsManagementCO.accountSign1";
    public static final String ON_LOAD_AC_SIGN_2 = "accountsManagementCO.accountSign2";
    
    public static final String ON_LOAD_PT_INDICATOR = "accountsManagementCO.amfVO.PT_IND";
    public static final String ON_LOAD_PT_PERIOD = "accountsManagementCO.amfVO.PT_PERIOD";
    public static final String ON_LOAD_MAIL_ADVISE = "accountsManagementCO.amfVO.MAIL_ADVISE";
    public static final String ON_LOAD_MATURED_CALCULATION = "accountsManagementCO.amfVO.MATURED_CALCULATION";
    public static final String ON_LOAD_LAST_POST_DATE = "accountsManagementCO.amfVO.LAST_POST_DATE";
    public static final String ON_LOAD_MAIL_STMT = "accountsManagementCO.amfVO.MAIL_STMT";
    public static final String ON_LOAD_MAIL_STMT_PERIOD = "accountsManagementCO.amfVO.STMT_PERIOD";
    public static final String ON_LOAD_CERTIF_OF_MGMT = "";
    public static final String ON_LOAD_OPEN_DEP_AMOUNT = "accountsManagementCO.amfVO.OPEN_DEP_AMOUNT";
    public static final String ON_LOAD_SERIAL_NO = "accountsManagementCO.amfVO.SERIAL_NO";
    public static final String ON_LOAD_SEQ_NO = "accountsManagementCO.amfVO.SEQ_NO";
    public static final String ON_LOAD_ACCOUNT_OPEN_DEPOSIT = "accountsManagementCO.amfVO.CUR_AC_BR~accountsManagementCO.amfVO.CUR_AC_CY~accountsManagementCO.amfVO.CUR_AC_GL~accountsManagementCO.amfVO.CUR_AC_CIF~accountsManagementCO.amfVO.CUR_AC_SL~accountsManagementCO.curAccName~accountsManagementCO.curAccAddRef";
    public static final String ON_LOAD_EVT_RENEW = "accountsManagementCO.amfVO.RENEW";
    public static final String ON_LOAD_EXT_TRF = "accountsManagementCO.amfVO.EXT_TRF";
    public static final String ON_LOAD_OPEN_DEP_TRX_TYPE = "accountsManagementCO.amfVO.OPEN_DEP_TRX_TYPE";
    public static final String ON_LOAD_OPEN_DEP_TRX_TYPE_DESC = "accountsManagementCO.trxtTypeDesc";

    public static final String ON_CHANGE_OPEN_DEP_TRX_TYPE_DESC = "openDepTrxTypeDesc";

    public static final String ON_LOAD_MATURITY_DAYS = "accountsManagementCO.amfVO.MATURITY_DAYS";
    public static final String ON_LOAD_ORIGIN = "accountsManagementCO.amfVO.ORIGIN";
    public static final String ON_LOAD_CR_PT_METHOD = "accountsManagementCO.amfVO.PT_METHOD";
    public static final String ON_LOAD_CR_PT_METHOD_DAYS = "accountsManagementCO.amfVO.PT_METHOD_DAYS";
    public static final String ON_LOAD_DR_APPL_DATE = "accountsManagementCO.amfVO.DR_APPL_DATE";
    public static final String ON_LOAD_CR_APPL_DATE = "accountsManagementCO.amfVO.CR_APPL_DATE";
    public static final String ON_LOAD_DR_PT_RATE = "accountsManagementCO.amfVO.DR_PT_RATE";
    public static final String ON_LOAD_CR_PT_RATE = "accountsManagementCO.amfVO.CR_PT_RATE";
    public static final String ON_LOAD_RENEW = "accountsManagementCO.amfVO.RENEW";
    public static final String ON_LOAD_POST_PFT_TO = "accountsManagementCO.amfVO.PFT_POST_TO";
    public static final String ON_LOAD_TRF_CY = "accountsManagementCO.amfVO.TRF_CY";
    public static final String ON_LOAD_TRF_GL = "accountsManagementCO.amfVO.TRF_GL";
    public static final String ON_LOAD_TRF_SL = "accountsManagementCO.amfVO.TRF_SL";
    public static final String ON_LOAD_TRF_DESC = "accountsManagementCO.curAccName";
    public static final String ON_LOAD_LONG_NAME_ENG = "accountsManagementCO.amfVO.LONG_NAME_ENG";
    public static final String ON_LOAD_BRIEF_NAME_ENG = "accountsManagementCO.amfVO.BRIEF_NAME_ENG";
    public static final String ON_LOAD_LONG_NAME_ARAB = "accountsManagementCO.amfVO.LONG_NAME_ARAB";

    // [EliasAoun - KIBIDI120215 - Full Name modification]
    public static final String ON_LOAD_FULL_NAME_ENG = "accountsManagementCO.amfExtendedVO.FULL_NAME_ENG";
    public static final String ON_LOAD_FULL_NAME_ARAB = "accountsManagementCO.amfExtendedVO.FULL_NAME_ARAB";
    // [EliasAoun - IIAB110220]
    public static final String ON_LOAD_REASON_CHANGE_STATUS = "reasonChangeStatus";
    // IIAB120102 - [EliasAoun]
    public static final String CH_EVT_DATE_DATE_OPND = "dateSubmitted";
    public static final String ON_LOAD_DATE_DATE_OPND = "accountsManagementCO.amfVO.DATE_OPND";

    public static final String ON_LOAD_BRIEF_NAME_ARAB = "accountsManagementCO.amfVO.BRIEF_NAME_ARAB";
    public static final String ON_LOAD_CREATE_NEW_ACCOUNT = "accountsManagementCO.createNewAccountFlag";
    public static final String ON_LOAD_ACC_TYPE_NEW_OFF_INSTR = "accountsManagementCO.amfVO.MATURITY_GL";
    public static final String ON_LOAD_CIF_SUB_NO = "accountsManagementCO.amfVO.PFT_POST_TO";
    public static final String ON_LOAD_SL_NO = "accountsManagementCO.amfVO.SL_NO";
    public static final String ON_LOAD_DEDUCT_ZAKAT_FR = "accountsManagementCO.amfVO.DEDUCT_ZAKAT_FR";
    public static final String ON_LOAD_APPLY_ZAKAT = "accountsManagementCO.amfVO.ZAKAT_APPLIED";
    public static final String ON_LOAD_AFFECT_PASS_BOOK = "accountsManagementCO.amfVO.UPDATE_PASSBOOK";
    public static final String ON_LOAD_AFFECT_BILLS = "accountsManagementCO.amfVO.UPDATE_BILLS";
    public static final String ON_LOAD_CANCEL_CHARGES = "accountsManagementCO.amfVO.CANCEL_CHARGES";
    public static final String ON_LOAD_MODARIB_RATE = "accountsManagementCO.amfVO.MODARIB_RATE";
    public static final String ON_LOAD_PSR_CUSTOMER = "accountsManagementCO.psrCustomer";
    public static final String ON_LOAD_HOLD_AMOUNT = "accountsManagementCO.amfVO.HOLD_AMOUNT";
    public static final String ON_LOAD_HOLD_TRX_TYPE = "accountsManagementCO.amfVO.HOLD_TRX_TYPE";
    public static final String ON_LOAD_ADVANCE_PROFIT = "accountsManagementCO.amfExtendedVO.ADVANCE_PROFIT_YN";
    public static final String ON_LOAD_ADVANCE_PROFIT_PERCTAGE = "accountsManagementCO.amfExtendedVO.ADVANCE_PROFIT_PERCENTAGE";
    public static final String ON_LOAD_DEDUCTION_PERIODICITY = "accountsManagementCO.amfExtendedVO.DEDUCTION_PERIODICITY";
    public static final String ON_LOAD_DEDUCTION_METHOD = "accountsManagementCO.amfExtendedVO.DEDUCTION_METHOD";
    public static final String ON_LOAD_MIN_OPEN_BAL = "accountsManagementCO.amfVO.CURRENCY_MIN_BAL";
    public static final String ON_LOAD_OFF_CY = "accountsManagementCO.amfVO.OFF_CY";
    public static final String ON_LOAD_OFF_GL = "accountsManagementCO.amfVO.OFF_GL";
    public static final String ON_LOAD_OFF_SL = "accountsManagementCO.amfVO.OFF_SL";
    public static final String ON_LOAD_PFT_BR = "accountsManagementCO.amfVO.PFT_BR";
    public static final String ON_LOAD_PFT_CY = "accountsManagementCO.amfVO.PFT_CY";
    public static final String ON_LOAD_PFT_GL = "accountsManagementCO.amfVO.PFT_GL";
    public static final String ON_LOAD_PFT_CIF = "accountsManagementCO.amfVO.PFT_CIF";
    public static final String ON_LOAD_PFT_SL = "accountsManagementCO.amfVO.PFT_SL";
    public static final String ON_LOAD_PFT_ADDREF = "accountsManagementCO.pftCurAccAddRef";
    
    public static final String ON_LOAD_LIMIT_EXP_DATE = "accountsManagementCO.amfVO.LIMIT_EXP_DATE";
    public static final String ON_LOAD_FACILITY_SUB_LIMIT = "accountsManagementCO.amfVO.FACILITY_SUB_LIMIT";
    public static final String ON_LOAD_TRSFR_METHOD = "accountsManagementCO.amfVO.TRSFR_METHOD";
    public static final String ON_LOAD_OVERDRAFT_LIMIT = "accountsManagementCO.amfVO.OVERDRAFT_LIMIT";
    public static final String ON_LOAD_PERIODICITY = "accountsManagementCO.amfVO.PERIODICITY";
    public static final String ON_LOAD_FACILITY_NO = "accountsManagementCO.amfVO.FACILITY_NO";
    public static final String ON_LOAD_APPLY_ZAKAT_EXEMPTED = "accountsManagementCO.amfExtendedVO.EXEMPTED_FROM_ZAKAT_YND";
    public static final String ON_LOAD_APPLY_ZAKAT_REASON = "accountsManagementCO.amfExtendedVO.ZAKAT_EXEMPTION_REASON";
    public static final String ON_LOAD_EXEMPTED_FROM_VAT_YN = "accountsManagementCO.amfExtendedVO.EXEMPTED_FROM_VAT_YN";
    public static final String ADDRESS1_ENG = "addressCO.ADDRESS1_ENG";
    public static final String ADDRESS2_ENG = "addressCO.ADDRESS2_ENG";
    public static final String ADDRESS3_ENG = "addressCO.ADDRESS3_ENG";
    public static final String ADDRESS4_ENG = "addressCO.ADDRESS4_ENG";

    public static final String ADDRESS1_ARAB = "addressCO.ADDRESS1_ARAB";
    public static final String ADDRESS2_ARAB = "addressCO.ADDRESS2_ARAB";
    public static final String ADDRESS3_ARAB = "addressCO.ADDRESS3_ARAB";
    public static final String ADDRESS4_ARAB = "addressCO.ADDRESS4_ARAB";
    public static final String POSTAL_CODE = "addressCO.POSTAL_CODE";
    public static final String POSTAL_CODE1 = "addressCO.POSTAL_CODE1";

    public static final String VIP_LABEL = "accountsManagementCO.vipAlert";
    public static final String MIN_RATE = "accountsManagementCO.amfVO.MIN_RATE";
    public static final String MAX_RATE = "accountsManagementCO.amfVO.MAX_RATE";
    public static final String LIBOR = "accountsManagementCO.amfVO.LIBOR";
    public static final String PFT_CIF = "accountsManagementCO.amfVO.PFT_CIF";

    public static final String CUR_AC_BR = "accountsManagementCO.amfVO.CUR_AC_BR";
    public static final String CUR_AC_CY = "accountsManagementCO.amfVO.CUR_AC_CY";
    public static final String CUR_AC_GL = "accountsManagementCO.amfVO.CUR_AC_GL";
    public static final String CUR_AC_CIF = "accountsManagementCO.amfVO.CUR_AC_CIF";
    public static final String CUR_AC_SL = "accountsManagementCO.amfVO.CUR_AC_SL";
    public static final String CUR_AC_ADDREF = "accountsManagementCO.curAccAddRef";
    public static final String CUR_AC_ACCNAME = "accountsManagementCO.curAccName";

    public static final String RENEWAL_MATURITY_DATE = "accountsManagementCO.amfVO.RENEWAL_MATURITY_DATE";
    public static final String RENEWAL_MATURITY_DAYS = "accountsManagementCO.amfVO.RENEWAL_MATURITY_DAYS";
    public static final String CH_EVT_ACCOUNT_POST_PROFIT_TO = "accBrPI~accCyPI~accGlPI~accCifPI~lookuptxt_accSlPI~lookuptxt_accAddRefPI~accDescPI";// accountsManagementCO.amfVO.PFT_BR~accountsManagementCO.amfVO.PFT_CY~accountsManagementCO.amfVO.PFT_GL~accountsManagementCO.amfVO.PFT_CIF~accountsManagementCO.amfVO.PFT_SL~accountsManagementCO.pftCurAccAddRef~accountsManagementCO.pftCurAccName

    public static final String ACCOUNT_NUMBER_LABEL = "lblAccountNumber";
    
    public static final String AMF_NEW_GL_ID = "lookuptxt_glCodeAccountsAccTransDetTab";
    public static final String AMF_NEW_GL_NAME = "accountsManagementCO.amfVO.NEW_GL";
    
    public static final String RIFATT_NEW_IND_ID = "newAccount";
    public static final String RIFATT_NEW_IND_NAME = "accountsManagementCO.createNewAccountTransferFlag";
    
    public static final String VIEW_TRANSACTION_BTN = "accounts_view_transaction_btn";
    
    public static final String VIEW_ADDFIELDS_BTN = "additionalFieldsBtn";
    public static final String ON_LOAD_MIN_BALANCE_POINTS = "accountsManagementCO.amfVO.MIN_BALANCE_POINTS";
    public static final String ON_LOAD_MAX_OVERDRAW_BAL = "accountsManagementCO.amfVO.MAX_OVERDRAW_BAL";
    public static final String ON_LOAD_MIN_OVERDRAW_POINTS = "accountsManagementCO.amfVO.MIN_OVERDRAW_POINTS";
    public static final String ON_LOAD_COMM_FEES = "accountsManagementCO.amfVO.COMM_FEES";
    public static final String ON_LOAD_MIN_STMT_BAL = "accountsManagementCO.amfVO.MIN_STMT_BAL";
    public static final String CH_EVT_CHARGES_SCHEMA_FROM_PFT_RATE = "returnChargesSchemaFromPftRate";
    public static final String ON_LOAD_APPLY_TAX_ON_CAP_REVENUE = "accountsManagementCO.appTaxCapRev";
    public static final String ON_LOAD_TCR_RATE = "accountsManagementCO.amfExtendedVO.TAX_RATE_CAP_REV";
    
    public static final String ON_LOAD_REJECTION_REASON = "accountsManagementCO.amfExtendedVO.REJECTION_REASON";

    //AMANA130105 --[John Massaad]
    public static final String PROFIT_DECL_PERIOD_NO_NAME = "accountsManagementCO.amfExtendedVO.PROFIT_DECL_PERIOD_NO";
    
    public static final String PROFIT_DECL_PERIOD_FREQ_NAME = "accountsManagementCO.amfExtendedVO.PROFIT_DECL_PERIOD_FREQ";
    
    public static final String IJARA_ENDING_PERIODICITY_NAME = "accountsManagementCO.amfExtendedVO.IJARA_ENDING_PERIODICITY";
    
    //AMANA130105 --[John Massaad]
  
    //Hala Al Sheikh - SBI170059 SBI170060
    public static final String PROFIT_DECL_PERIOD_NO_ID = "profitDeclPeriodNo";
    public static final String PROFIT_DECL_PERIOD_FREQ_ID = "profitDeclPeriodFreq";
    public static final String IJARA_ENDING_PERIODICITY_ID = "ijaraEndingPeriodicity";
    public static final String EXPRESS_CASH_END_PERIOD_DATE = "lbl_expressCashEndPeriodDate";
    
 // Tony Nouh User Story#336860 INDI150072
//    public static final String ON_LOAD_DISTIBUTION_PERIODICITY = "accountsManagementCO.amfExtendedVO.DISTIBUTION_PERIODICITY";
    public static final String CH_EVT_DEBIT_PT_METHOD_DAYS = "debitPTMethodDays";
    public static final String ON_LOAD_DEBIT_PT_METHOD_DAYS = "accountsManagementCO.amfExtendedVO.PT_DEBIT_METHOD_DAYS";
    public static final String CH_EVT_DEBIT_PT_METHOD = "debitPTMethod";
    public static final String ON_LOAD_DEBIT_PT_METHOD = "accountsManagementCO.amfExtendedVO.PT_DEBIT_METHOD";
    public static final String CH_EVT_PT_ACCOUNT_SIGN = "ptAccountSign";
    public static final String ON_LOAD_PT_ACCOUNT_SIGN = "accountsManagementCO.amfExtendedVO.PT_ACCOUNT_SIGN";
    public static final String CH_EVT_TAX_PERCENTAGE = "taxPercentage";
    public static final String ON_LOAD_TAX_PERCENTAGE = "accountsManagementCO.amfExtendedVO.PT_ACCRUED_TAX_PERC";
    public static final String CH_EVT_COLLECTION_FEES = "collectionFees";
    public static final String ON_LOAD_COLLECTION_FEES = "accountsManagementCO.amfExtendedVO.PT_ACCRUED_COLLECTION_FEE";
    public static final String CH_EVT_COMMISSION_ON_CAPITAL = "commissionOnCapital";
    public static final String ON_LOAD_COMMISSION_ON_CAPITAL = "accountsManagementCO.amfExtendedVO.PT_ACCRUED_COMMISSION_CAPITAL";
    public static final String CH_EVT_MAX_OVERDRAWN_PERCENTAGE = "maxOverDrawnPercentage";
    public static final String ON_LOAD_MAX_OVERDRAWN_PERCENTAGE = "accountsManagementCO.amfExtendedVO.PT_ACCRUED_MAX_OVERDRAW_PERC";

    /**
     * @author RaniaAlBitar
     * DB170108 - Advance profit payment
     */
    public static final String ADVANCED_PROFIT_FLAG = "accountsManagementCO.advancedProfitFlag";
    public static final String ADVANCED_PROFIT_PAY_FLAG = "advanceProfitPayment";
    public static final String ADVANCED_PROFIT_RATES = "advanceProfitRates";
    public static final String PROFIT_ADJ = "profitAdjustment";
    public static final String POST_ADV_PFT_TO_ACC_BR 		= "postAdvancePftToAccBr";
    public static final String POST_ADV_PFT_TO_ACC_CY 		= "postAdvancePftToAccCy";
    public static final String POST_ADV_PFT_TO_ACC_GL 		= "postAdvancePftToAccGl";
    public static final String POST_ADV_PFT_TO_ACC_CIF 		= "postAdvancePftToAccCif";
    public static final String POST_ADV_PFT_TO_ACC_SL 		= "lookuptxt_postAdvancePftToAccSl";
    public static final String POST_ADV_PFT_TO_ACC_ADD_REF 	= "lookuptxt_postAdvancePftToAccAddRef";
    public static final String POST_ADV_PFT_TO_ACC_DESC 	= "postAdvancePftToAccDesc";
    
    /** End Rania */
    //Raed Saad User Story #410997 EWBI160163
    public static final String UPON_RENEWAL_AFFECT_ID = "upon_RenewalAffect";//"accountsManagementCO.amfExtendedVO.UPON_RENEWAL_AFFECT";
    public static final String RENEW_SAME_ACC_YN_ID = "renewInSameAccount";//"accountsManagementCO.amfExtendedVO.RENEW_SAME_ACC_YN";
    public static final String ON_LOAD_UPON_RENEWAL_AFFECT_ID = "accountsManagementCO.amfExtendedVO.ACC_RENEWAL_AFFECT";
    public static final String ON_LOAD_RENEW_SAME_ACC_YN_ID = "accountsManagementCO.amfExtendedVO.RENEW_SAME_ACC_YN";

    //Raed Saad - [#539366 - AMANA130105]
    public static final String ACC_CV_POINTS_NAME = "accountsManagementCO.amfVO.ACC_CV_POINTS";
    public static final String ACC_CV_POINTS_ID = "accCvPoints";
    //Raed Saad - [#539366 - AMANA130105]
    
    public static final String PATH_REFUND_ACCOUNT_ID = "pathAccount_refund_acc";
    public static final String PATH_REFUND_ACCOUNT_NAME = "accountsManagementCO.amfExtendedVO.REFUND_BR";
    
    //Hala Al Sheikh TP790351 - DASI190021
    public static final String DUES_SETTLEMENT_ACCOUNT_ID = "pathAccount_duesSettlementAccount";
    public static final String SETTLEMENT_NEW_CY_ID = "accCySettlement";
    public static final String SETTLEMENT_NEW_CY_NAME = "accountsManagementCO.accCySettlement";
    public static final String SETTLEMENT_NEW_CIF_ID = "accCifSettlement";
    public static final String SETTLEMENT_NEW_CIF_NAME = "accountsManagementCO.accCifSettlement";
    public static final String SETTLEMENT_NEW_GL_ID = "accGlSettlement";
    public static final String SETTLEMENT_NEW_SL_ID = "lookuptxt_accSlSettlement";
    
    public static final String NET_RETURN_RATE = "netRateOfReturn";
    //id:1057741 Details:MBSI200026 - Seperator set up not working while account number generation falha TAR:MBSI200026

    public static final String FORMATTED_CH_EVT_ADDITIONAL_REFERENCE = "formattedReference";
    public static final String FORMATTED_ADDITIONAL_REFERENCE = "accountsManagementCO.FORMATTED_ADDITIONAL_REFERENCE";
    
    
    
}
