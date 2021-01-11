package com.path.bo.common.iis;

import java.math.BigDecimal;

public class IISCommonConstants
{

    public static final String CHECK_APPROVE_TRX_DATE = "CHECK_APPROVE_TRX_DATE";
    public static final BigDecimal LOV_TYPE_IIS_COMMON_STATUS = new BigDecimal(290);
    public static final String SORT_BY_ASC = "ASC";
    public static final String SORT_BY_DSC = "DSC";
    public static final String REPAYMENT_MERGE_REPAYMENT = "MERGE_REPAYMENT";
    public static final String CHECK_ONE_OBLIGOR_CIF_CAPITAL_LIMIT = "CHECK_ONE_OBLIGOR_CIF_CAPITAL_LIMIT";
    public static final BigDecimal ALLOW_TO_EDIT_TRADE_DEAL_SALES_AC_CY_31 = new BigDecimal(31);
    public static final String ISLAMIC_CALCULATOR_AR_RAHANU = "AR_RAHANU"; // M01683
    public static final String ISLAMIC_CORPORTAE_CALCULATOR = "ISLAMIC_CORPORTAE"; // M0168
    public static final String ISLAMIC_FINANCIL_CALCULATOR_I = "FINANCIL_CALCULATOR_I";
    public static final String ISLAMIC_FINANCIL_CALCULATOR_II = "FINANCIL_CALCULATOR_II";
    public static final String RESCHEDULE_CALCULATOR = "RESCHEDULE_CALCULATOR";
    public static final String PROJECT_FINANCE_CALCULATOR = "PROJECT_FINANCE_CALCULATOR";// M01681
    public static final String RESCHEDULE_PROFIT_CALCULATOR = "RESCHEDULE_PROFIT_CALCULATOR";
    public static final String RESCHEDULE_PROFIT_CALCULATOR_RENEWAL_ADVICE = "RESCHEDULE_PROFIT_CALCULATOR_RENEWAL_ADVICE";
    public static final String ISLAMIC_BILLS_CALCULATOR = "BILLS_CALCULATOR";// M01682
    public static final String HEDGING_CALCULATOR = "HEDGING_CALCULATOR";// M0164
    public static final String EOD_CALCULATOR = "EOD_CALCULATOR";// M0163
    public static final String CALCULATOR_PAYMENT_CRITERIA = "CALCULATOR_PAYMENT_CRITERIA";

    public static final String TEMP_TABLE_INSERT = "I";
    public static final String TEMP_TABLE_UPDATE = "U";
    public static final String CHECK_HOLIDAY_WARNING = "CHECK_HOLIDAY_WARNING";
    public static final String CREATE = "CREATE";
    public static final String VALIDATE = "VALIDATE";

    public static final String TRAIL_FINAL_TRIAL = "T";
    public static final String TRAIL_FINAL_FINAL = "F";
    public static final String POSTING_TYPE_SINGLE = "S";
    public static final String POSTING_TYPE_ALL = "A";

    public static final String MODE_CREATE = "C";
    public static final String MODE_APPROVE = "A";
    public static final String MODE_REVERSE = "R";
    public static final String MODE_P = "P";
    public static final String MODE_V = "V";

    public static final String STATUS_CREATE = "Create";

    public static final String DEFERRAL = "D";
    public static final String WAIVER = "W";

    public static final String STOPPING = "S";
    public static final String WARNING = "W";

    public static final String CONFIRM_EXPIRY_DATE_HAS_BEEN_ELAPSED = "CONFIRM_EXPIRY_DATE_HAS_BEEN_ELAPSED";
    public static final String DOC_STATUS_AVAILABLE_A = "A";

    public static final String ACTIVE = "Active";
    public static final String DEAL_VERIFY_STATUS_F = "F";
    public static final String DEAL_VERIFY_STATUS_U = "U";
    public static final String DEALVERIFYSTATUS_A1 = "A1";
    public static final String DEAL_VERIFY_STATUS_SA = "SA";
    public static final String DEAL_VERIFY_STATUS_A = "A";
    public static final String DEAL_VERIFY_STATUS_S = "S";
    public static final String STATUS_CREATED = "0_C";
    public static final String STATUS_MODIFIED = "0_M";
    public static final String STATUS_ACTIVE_A = "A";
    public static final String STATUS_DELETED = "D";
    public static final String STATUS_VERIFIED = "V1";
    public static final String STATUS_REVERSED = "V";
    public static final String STATUS_CLOSED = "C";
    public static final String STATUS_R = "R";

    public static final BigDecimal MAX_SKIP_PERIOD_YEAR_TYPE_FISCAL_YEAR_2 = BigDecimal.valueOf(2);
    public static final BigDecimal MAX_SKIP_PERIOD_YEAR_TYPE_VALUE_DATE_1 = BigDecimal.valueOf(1);

    public static final String TRX_MODE_DELETE = "Delete";
    public static final String TRX_MODE_VERIFY = "Verify";
    public static final String TRX_MODE_REJECT = "Reject";
    public static final String TRX_MODE_APPROVE = "Approve";
    public static final String TRX_MODE_REVERSE = "Reverse";
    public static final String TRX_MODE_UPDATE_AFTER_APPROVE = "Update After Approve";
    public static final String STATUS_DECLINE = "L";
    public static final String SAVENEW = "saveNew";
    public static final String UPDATE = "update";

    public static final String STATUS_DRAFT = "B";
    public static final String MIN_YIELD = "0.000";
    public static final String MAX_YIELD = "999.999";
    public static final String MIN_DEAL_AMOUNT = "0.001";
    public static final String MAX_DEAL_AMOUNT = "999999999.999";

    public static final String FMS_LIMIT_GENERAL_TYPE = "P";
    public static final String LOCAL = "local";
    public static final String NEW = "NEW";

    public static final String ACTION_TYPE_CHECK = "CHECK";
    public static final String ACTION_TYPE_INSERT = "INSERT";
    public static final String ACTION_TYPE_INSERT_ONLY = "INSERT ONLY";
    public static final String ACTION_TYPE_APPROVE = "APPROVE";
    public static final String ACTION_TYPE_UPDATE = "UPDATE";
    public static final String ACTION_TYPE_REVERSE = "REVERSE";
    public static final String ACTION_TYPE_DELETE = "DELETE";
    public static final String ACTION_TYPE_UPFRONT = "UPFRONT";
    public static final String ACTION_TYPE_SAVE = "SAVE";
    public static final String ACTION_TYPE_SETTLE_APPROVE = "SETTLE APPROVE";
    public static final String ACTION_TYPE_SETTLE_REVERSE = "SETTLE REVERSE";
    public static final String EARLY_STLMT_CAPITAL_AMT = "ESCAPITAL";
    public static final String ACTION_TYPE_C = "C";
    public static final String ACTION_TYPE_U = "U";
    public static final String ACTION_TYPE_D = "D";

    public static final BigDecimal DEAL_TYPE_PLACEMENT_1 = BigDecimal.ONE;
    public static final BigDecimal DEAL_TYPE_BORROWING_2 = new BigDecimal(2);
    public static final BigDecimal DEAL_TYPE_MURABAHA_3 = new BigDecimal(3);
    public static final BigDecimal DEAL_TYPE_MODARABAH_4 = new BigDecimal(4);
    public static final BigDecimal DEAL_TYPE_SETOFF_RATIO_5 = new BigDecimal(5);
    /**
     * For IIS Deal Type
     */
    public static final BigDecimal DEAL_TYPE_ISTISNAA_12 = new BigDecimal(12);
    public static final BigDecimal DEAL_TYPE_EOD_13 = new BigDecimal(13);
    public static final BigDecimal DEAL_TYPE_REAL_ESTATE_15 = new BigDecimal(15);
    public static final BigDecimal DEAL_TYPE_FOREX_17 = new BigDecimal(17);
    public static final BigDecimal DEAL_TYPE_MURABAHA_FINANCING_18 = new BigDecimal(18);
    public static final BigDecimal DEAL_TYPE_REVERSE_MURABAHA_19 = new BigDecimal(19);
    public static final BigDecimal DEAL_TYPE_MODARABAH_BORROWING_23 = new BigDecimal(23);
    public static final BigDecimal DEAL_TYPE_WAKALA_DEPOSIT_25 = new BigDecimal(25);
    public static final BigDecimal DEAL_TYPE_WAKALA_INVESTMENT_24 = new BigDecimal(24);
    public static final BigDecimal DEAL_SCREEN_TYPE_SET_OFF_RATIO = new BigDecimal(25); // iv_deal_type
    public static final BigDecimal DEAL_TYPE_PROFIT_RATE_SWAP = new BigDecimal(31);

    public static final String RESCHEDULE_TYPE_NO_RECALCULATE = "NO_RECALCOLATE";
    public static final String RESCHEDULE_TYPE_STAFF_SKIPP = "STAFF_SKIPP";

    public static final String RESCHEDULE_TYPE_RECALCULATE = "RECALCOLATE";
    public static final String RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL = "ADVANCE_PRINCIPAL_SETTLMENT";
    public static final String RESCHEDULE_YES = "Y";
    public static final String RESCHEDULE_NO = "N";

    public static final BigDecimal RESCHEDULE_TYPE_STAFF_SKIPP_12 = BigDecimal.valueOf(12);
    public static final BigDecimal WRITE_OFF_TYPE_MANULA_CLASSIFICATION_4 = new BigDecimal(4);

    public static final String CALENDAR_TYPE_HIJRI_H = "H";
    public static final String CALENDAR_TYPE_GREGORIAN_G = "G";
    public static final String BLANKSTRING = "";
    public static final String ALLOW_EDIT_FLOAT_RATE_YN_NONE = "O";
    public static final String ALLOW_EDIT_FLOAT_RATE_YN_FLOATING = "F";
    public static final String ALLOW_EDIT_FLOAT_RATE_YN_MARGIN = "N";
    public static final String ALLOW_EDIT_FLOAT_RATE_YN_BOTH = "Y";

    public static final String SECURITY_DEPOSIT = "S";
    public static final String DOWN_PAYMENT = "D";
    public static final String INITIAL_PAYMENT_TYPE_A = "A";
    public static final String DOWN_PAYMENT_DP = "DP";
    public static final String MESSAGE_TYPEWARNING = "W";
    public static final String MESSAGE_TYPE_STOP = "S";
    public static final String MESSAGE_TYPE_NONE = "N";
    public static String MESSAGE_TYPE_C = "C";
    public static String MESSAGE_TYPE_MT = "MT";

    public static final String ACTION_TYPE_VISIBLE = "VISIBLE";
    public static final String ACTION_TYPE_REQUIRED = "REQUIRED";
    public static final String ACTION_TYPE_READ_ONLY = "READ_ONLY";
    public static final String ACTION_TYPE_READONLY = "READONLY";
    public static final String ACTION_TYPE_LABEL = "LABEL";
    public static final String ACTION_TYPE_CURRENCYFORMAT = "CURRENCYFORMAT";
    public static final String ACTION_TYPE_OVERWRITE_READONLY = "OVERWRITE_READONLY";
    public static final String ACTION_TYPE_VALUE = "VALUE";
    public static final String IV_CRUD_R = "R";
    public static final String IV_CRUD_D = "D";
    public static final String IV_CRUD_F = "F";
    public static final String IV_CRUD_E = "E";
    public static final String IV_CRUD_P = "P";
    public static final String IV_CRUD_N = "N";
    public static final String IV_CRUD_RR = "RR";
    public static final String IV_CRUD_UP = "UP";
    public static final String IV_CRUD_V = "V";
    public static final String IV_CRUD_VR = "VR";
    public static final String IV_CRUD_QUERY = "Q";
    public static final String IV_CRUD_VP = "VP";
    public static final String IV_CRUD_PP = "PP";
    public static final String IV_CRUD_S = "S";
    public static final String IV_CRUD_A = "A";
    public static final String IV_CRUD_H = "H";

    public static final String STATUS_APPROVE = "P";
    // SBI170009
    public static final String STATUS_SUSPENDED = "S";

    public static final String FALSE = "false";
    public static final String TRUE = "true";
    public static final String DAY = "D";
    public static final String MONTH = "M";
    public static final String WEEK = "W";
    public static final String YEAR = "Y";
    public static final String QUARTER = "Q";
    public static final String SEMI = "S";
    public static final String ANUAL = "A";
    public static final String GRACE = "G";
    public static final String MONTH_START = "S";
    public static final String MONTH_MIDDLE = "M";
    public static final String MONTH_END = "E";
    public static final String MONTH_DAY = "D";
    public static final String SET_DATE = "Set Date";
    public static final String ON = "1";
    public static final String OFF = "0";
    public static final String MAX = "MAX";
    public static final String FMS_GENERAL_TYPE = "N";
    public static final String LIMIT_REINSTATE_BASED_ON_PRINCIPAL = "P";
    public static final String SHOW_BRIEF_LONG_NAME_L = "L";

    public static final String MINIMUM_SECURITY_DEPOSIT_TYPE_AMOUNT = "A";
    public static final String MINIMUM_SECURITY_DEPOSIT_TYPE_PERCENTAGE = "P";
    public static final String MINIMUM_SECURITY_DEPOSIT_TYPE_HIGHEST = "H";
    public static final String MINIMUM_SECURITY_DEPOSIT_TYPE_FIRST = "F";

    public static final String DRAWDOWN_UTILIZATION_INDICATOR_PRINCIPAL_CHARGE_P = "P";
    public static final String DRAWDOWN_UTILIZATION_INDICATOR_PRINCIPAL_PROFIT_CHARGE_R = "R";
    public static final String DRAWDOWN_UTILIZATION_INDICATOR_PRINCIPAL_I = "I";
    public static final String DRAWDOWN_UTILIZATION_INDICATOR_PRINCIPAL_PROFIT_T = "T";

    public static final String WRITE_OFF_TYPE_ONE = "1";
    public static final String WRITE_OFF_TYPE_TWO = "2";
    public static final String WRITE_OFF_TYPE_THREE = "3";

    public static final String CALCULATOR_TYPE_CALCULATOR = "CALCULATOR";

    public static final String ACCRUAL_AMOUNT_TYPE_INSTALLMENT = "I";
    // TP#193259; Ramesh; Date 15/07/2014
    public static final String ACCRUAL_AMOUNT_TYPE_P = "P";
    public static final String ACCRUAL_AMOUNT_TYPE_PROFIT = "P";

    public static final String PROFIT_CALCULATION_METHOD_S = "S";
    public static final String PROFIT_CALCULATION_METHOD_STRAIGHT_LINE = "S";
    public static final String PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS = "R";

    public static final String PROFIT_DISTRIBUTION_METHOD_STRAIGHT_LINE = "S";
    public static final String PROFIT_DISTRIBUTION_METHOD_DIMINISHING_RETURNS = "R";
    public static final String PROFIT_DISTRIBUTION_METHOD_IAS_18 = "I";
    public static final String PROFIT_DISTRIBUTION_METHOD_RULE_78 = "L";

    public static final String COMPOUND_PROFIT_GRACE = "G";
    public static final String COMPOUND_PROFIT_DEAL = "D";
    public static final String COMPOUND_PROFIT_BOTH = "B";

    public static final String GRACE_COMPOUND_PERIODICITY_DAILY = "D";
    public static final String GRACE_COMPOUND_PERIODICITY_MONTHLY = "M";
    public static final String GRACE_COMPOUND_PERIODICITY_QUARTERLY = "Q";
    public static final String GRACE_COMPOUND_PERIODICITY_SEMI_ANNUALLY = "S";
    public static final String GRACE_COMPOUND_PERIODICITY_ANNUALLY = "A";
    public static final String GRACE_COMPOUND_PERIODICITY_GRACE_PERIOD = "G";

    public static final String PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT = "B";
    public static final String PAYMENT_TYPE_SETTLE_PRINCIPAL = "C";
    public static final String PAYMENT_TYPE_SETTLE_PROFIT = "P";
    public static final String PAYMENT_TYPE_COMPOUND_PROFIT = "D";
    public static final String PAYMENT_TYPE_UPFRONT_PROFIT = "U";
    public static final String PAYMENT_TYPE_UPFRONT_PRINCIPAL_UPFRONT_PROFIT = "A";
    public static final String PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT = "O";
    public static final String PAYMENT_TYPE_SPECIFIC_AMOUNT = "S";
    public static final String PAYMENT_TYPE_PROFIT_CHARGES = "Q";
    public static final String PAYMENT_TYPE_ASSET_RESIDUAL_VALUE = "E";
    public static final String PAYMENT_TYPE_REPOSSESSION_ASSET = "R";

    public static final String PAYMENT_PERIODICITY_TYPE_WEEKLY = "W";
    public static final String PAYMENT_PERIODICITY_TYPE_MONTHLY = "M";
    public static final String PAYMENT_PERIODICITY_TYPE_ANNUALLY = "A";
    public static final String PAYMENT_PERIODICITY_TYPE_DIALY = "D";
    public static final String PAYMENT_PERIODICITY_TYPE_QUARTERLY = "Q";
    public static final String PAYMENT_PERIODICITY_TYPE_SEMI_ANNUALLY = "S";

    public static final String PAYM_PERIOD_POS_MONTH_START = "S";
    public static final String PAYM_PERIOD_POS_MONTH_MIDDLE = "M";
    public static final String PAYM_PERIOD_POS_MONTH_END = "E";
    public static final String PAYM_PERIOD_POS_DEFEND_DAY = "D";

    public static final String RESIDUAL_VALUE_FIRST_INSTALLMENT = "F";
    public static final String RESIDUAL_VALUE_LAST_INSTALLMENT = "L";
    public static final String RESIDUAL_VALUE_ON_DOWN_PAYMENT = "D";

    /* Calculator Page Ref */
    public static final String CALCULATOR_PAGE_REF_RESCHEDULE_M0165 = "M0165";
    public static final String CALCULATOR_PAGE_REF_RESCHEDULE_M0169 = "M0169";

    public static final String VAT_PERCENTAGE_INDICATOR_INSTALLMENT = "I";
    public static final String VAT_PERCENTAGE_INDICATOR_PROFIT = "P";
    public static final String VAT_PERCENTAGE_INDICATOR_SETTLED_INSTALLMENT = "S";
    public static final String VAT_PERCENTAGE_INDICATOR_DEAL_PROFIT = "D";
    public static final String ADVANCE_PRINCIPAL_SETTLEMNT_MAINTENANCE_SCREEN = "T036MT";
    public static final String PROFIT_CALCULATION_METHOD_R = "R";
    public static final String TRS_TYPE_I = "I";
    public static final String TRS_TYPE_G = "G";
    public static final String TRS_TYPE_D = "D";
    public static final String TRS_TYPE_H = "H";
    public static final String TRS_TYPE_S = "S";
    public static final String TRS_TYPE_B = "B";
    public static final String TRS_TYPE_O = "C";
    public static final String TRS_TYPE_N = "N";
    public static final String TRS_TYPE_CL = "CL";
    public static final String TRS_TYPE_P = "P";
    public static final String TRS_TYPE_V = "V";
    public static final String TRS_TYPE_MR = "MR";
    public static final String TRS_TYPE_PF = "PF";
    public static final String TRS_TYPE_L = "L";
    public static final String TRS_TYPE_A = "A";
    public static final String TRS_TYPE_F = "F";
    public static final String TRS_TYPE_Q = "Q";
    public static final String TRS_TYPE_Z = "Z";

    public static final String CONTRIBUTOR_TYPE_PLACEMENT_P = "P";
    public static final String CONTRIBUTOR_TYPE_BORROWED_B = "B";

    public static final String PAY_RESIDUAL_AMOUNT_FIRST_F = "F";
    public static final String PAY_RESIDUAL_AMOUNT_LAST_L = "L";
    public static final String DITRIBUTION_METHOD_U = "U";

    public static final String ACCRUAL_METHOD_TYPE_DAILY_D = "D";
    public static final String ACCRUAL_METHOD_TYPE_MONTHLY_M = "M";

    public static final BigDecimal INSTRUCTION_TYPE_PAYMENT_INSTRUCTION_1 = BigDecimal.ONE;
    public static final BigDecimal INSTRUCTION_TYPE_RECEIVING_INSTRUCTION_2 = BigDecimal.valueOf(2);
    public static final BigDecimal INSTRUCTION_TYPE_MATURITY_PAYMENT_INSTRUCTION_3 = BigDecimal.valueOf(3);
    public static final BigDecimal INSTRUCTION_TYPE_MATURITY_RECEIVING_INSTRUCTION_4 = BigDecimal.valueOf(4);
    public static final String APP_IPRC = "IPRC";

    /* For CSM Request */
    public static final String BRANCH_REQUEST_ACTIVE = "9";
    public static final String BRANCH_REQUEST_DRAFT = "8";

    /**
     * For IISCTRL Additinal Parametor Values
     */
    public static final BigDecimal IISCTRL_ADDITIONAL_PARAM_SHOW_MEMOS_FOR_RELATED_CIF_ACCOUNT = BigDecimal.valueOf(14);
    public static final BigDecimal IISCTRL_ADDITIONAL_PARAM_SHOW_MEMOS_IN_ALL_OPTS_UPON_RETRIEVAL = BigDecimal
	    .valueOf(15);
    public static final BigDecimal CHECK_ON_SPECIAL_CONDITIONS = BigDecimal.valueOf(16);
    public static final BigDecimal SHOW_XIRR_WITH_DEAL_CHARGES = BigDecimal.valueOf(22);
    public static final BigDecimal ALLOW_FLOATRATE_LESS_MINIMUM = BigDecimal.valueOf(21);

    public static final String DEAL_MULTDIV_MULTIPLY = "M";
    public static final String ITRS_APP = "ITRS";
    public static final String ICOR_APP = "ICOR";
    public static final String LEND_APP = "LEND";
    public static final String IRET_APP = "IRET";
    public static final String LRET_APP = "LRET";
    public static final String PROV_APP = "PROV";
    public static final String IFIN_APP = "IFIN";
    public static final String IRVL_APP = "IRVL";
    public static final String LCOR_APP = "LCOR";
    public static final String IIS_APP = "IIS";
    public static final String EXIM_APP = "EXIM";

    public static final String REJECT_PROVISION = "J";

    public static final String OPT_T10PRV = "_T10PRV";
    public static final String OPT_T10PRT = "_T10PRT";
    public static final String OPT_T10PR = "_T10PR";

    public static final String SHOW_MEMOS_ON_APPROVE = "P";
    public static final String SHOW_MEMOS_ON_REVERSE = "V";
    public static final String CONFIRM_ON_SPECIAL_CONDITIONS = "CONFIRM_ON_SPECIAL_CONDITIONS";
    public static final String SHOW_MEMOS_ON_SAVE = "S";
    public static final String SHOW_MEMOS_ON_RETRIEVAL = "R";

    public static final String DEAL_CREATED_TYPE_M = "M";
    public static final String DEAL_CREATED_TYPE_CALCILATOR_C = "C";
    public static final String AUTOMATIC = "A";
    public static final String MANUAL = "M";

    public static final BigDecimal POSTING_PROCESS_CODE = BigDecimal.valueOf(996);
    public static final String OPT_T10PRF = "_T10PRF";

    public static final BigDecimal WITHOUT_CONSIDERING_INSTALLMENT_DATE_2 = BigDecimal.valueOf(2);
    public static final String CHECK_CIF_EXISTING_DEALS = "CHECK_CIF_EXISTING_DEALS";

    public static final String STATUS_COLOR_CODE_B = "B";
    public static String LSDATESTATUS_C = "C";
    public static String TYPE_DA = "DA";
    public static String TYPE_RA = "RA";
    public static String TYPE_J = "J";
    public static String TYPE_D = "D";
    public static String TYPE_A = "A";
    public static String TYPE_R = "R";

    public static String PERIODICITY_TYPE_R = "R";
    public static String PERIODICITY_TYPE_D = "D";

    public static String STATUS_D = "D";
    public static String STATUS_W = "W";

    public static final String MODIFIED_LIST = "lstModify";
    public static final String DELETED_LIST = "lstDelete";
    public static final String ADDED_LIST = "lstAdd";
    public static final String ALL_LIST = "lstAllRec";

    public static String PERIODICITY_TYPE_W = "W";
    public static String PERIODICITY_TYPE_M = "M";
    public static String PERIODICITY_TYPE_Y = "Y";
    public static final String TRX_MODE_A = "A";
    public static final String TRX_MODE_R = "R";
    public static final String TRX_MODE_C = "C";
    public static final String DATE_DD = "DD";
    public static final String MONTH_MM = "MM";
    public static final String YEAR_YY = "YY";

    public static final String GL_STATUS_ASSET = "A";
    public static final String GL_STATUS_LIABILITY = "L";

    // Account Sign
    public static final String ACCOUNT_SIGN_CREDIT = "C";
    public static final String ACCOUNT_SIGN_DEBIT = "D";
    public static final String ACCOUNT_SIGN_BOTH = "B";

    // GMI_FLAG in AMF table
    public static final String INTERNAL_ACCOUNT = "I";
    public static final String GENERAL_ACCOUNT = "G";
    public static final String FIXED_ACCOUNT = "F";

    public static final String CATEGORY = "C";
    public static final String PROCUCT_CLASS = "P";

    public static final String DOC_STATUS_DISCREPANT_D = "D";
    public static final String DOC_STATUS_AWAITED_W = "W";
    public static final String DATE_TYPE_VALUE_DATE_V = "V";
    public static final String DATE_TYPE_MATURITY_DATE_M = "M";
    public static final String DATE_TYPE_PLAN_DATE_P = "P";
    public static final String DATE_TYPE_DELIVERY_DATE_D = "D";
    public static final String DATE_TYPE_SALES_DATE_S = "S";
    public static final String DATE_TYPE_PLACEMENT_VALUE_DATE_PV = "PV";
    public static final String DATE_TYPE_PLACEMENT_MATURITY_PM = "PM";
    public static final String DATE_TYPE_BORROWING_VALUE_BV = "BV";
    public static final String DATE_TYPE_BORROWING_MATURITY_BM = "BM";
    public static final String SCREEN_NAME_PAYMENT_INSTRUCTION = "PI";
    public static final String SCREEN_NAME_LOS = "LOS";
    // BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
    public static final String TOPUP = "T";
    public static final String BUYOUT = "B";
    public static final String TYPE = "dealType";
    public static final String TYPEBTN = "dealTypeBtn";
    public static final String VALIDATEB4UPDATE = "VALIDATEB4UPDATE";
    public static final String VALIDATEONREVERSE = "VALIDATEONREVERSE";
    public static final String SCREEN_NAME_DEAL_SWITCHING = "DS";
    // BB150223; EOD - Settlement process; Shabeer 29/01/2018 [Begin]
    public static final String BLOCK_TYPE_NON_CASH = "N";
    public static final String BLOCK_TYPE_CASH = "C";
    // BB150223; EOD - Settlement process; Shabeer 29/01/2018 [End]

    public static final String CALLED_FROM_LOS = "LOS";
    public static final String CALLED_FROM_INTERNET_BANKING = "IB";
    public static final String CALLED_FROM_WS = "WS";
    public static final String CALLED_FROM_BATCH = "BT";
    public static final String CHANNAL_ID_BPM = "BPM";
    public static final String CHANNAL_ID_BPM1 = "BPM1";

    public static final String NOSTRO = "NOSTRO";
    // Fawas K TAR; 795856,DASI190043 18/02/2019
    public static final String IIS_ADDITIONAL_VALIDATION_CONFIRMATION = "IIS_ADDITIONAL_VALIDATION_CONFIRMATION";

    public static final String CALLED_FROM_FX_OPTION = "FXOPTION";
    public static final String STATUS_EXPIRE = "E";
    public static final String STATUS_TO_BE_EXPIRE = "X";
    // TP#795449 AIBBI190122 ; Srikumar
    public static final String CRITERIA = "CRITERIA";

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    public static final String YIELD_FIRST = "Y";
    
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_CONFIRMATION = "CIF_BLACK_LIST_RESTRICTION_BYPASS_CONFIRMATION";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_REF_BULK_TRADE = "T030";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_REF_TRADE = "T01";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_INV_TRADE = "T02";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_PARTY_SWITCH = "T017";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_DISBURSEMENT = "T027";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_FOREX = "F02";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_PFX = "F08";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_PFX_EXT = "F09";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_PFX_MAT_EXC = "F02";
	public static final String CIF_BLACK_LIST_RESTRICTION_BYPASS_PAGE_PFX_EAR_EXC = "F02";

}