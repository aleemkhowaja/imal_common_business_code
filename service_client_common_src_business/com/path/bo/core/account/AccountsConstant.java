/**
 * 
 */
package com.path.bo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.lib.log.Log;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          AccountsConstant.java used to
 */
public final class AccountsConstant
{

    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private AccountsConstant()
    {
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    }
    private static final String STATUS_CREATED = "0_C";
    private static final String STATUS_MODIFIED = "0_M";
    private static final String STATUS_REACTIVATED = "0_R";

    public static final String STATUS_DELETE = "D";
    public static final String STATUS_SUSPENDED = "S";
    public static final String STATUS_CLOSED = "C";
    public static final String STATUS_REJECT = "R";
    public static final String STATUS_AUTHORIZED_REJECT = "1_R";
    public static final String STATUS_TO_SUSPEND = "Q";
    public static final String STATUS_TO_REACTIVATE = "Y";
    public static final String STATUS_TO_REJECT = "X";
    public static final String STATUS_AUTHORIZED = "A";
    public static final String STATUS_OFFENDING = "F";
    public static final String STATUS_REACTIVATE = "V";

    public static final String STATUS_CLOSURE_APPROVED = "M";
    public static final String ACC_STATUS_CLOSED = "C";
    public static final String STATUS_DORMANT = "T";
    public static final String STATUS_INACTIVE = "I";
    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_OPEN = "O";
    public static final String STATUS_APPLY_FOR_CLOSURE = "P";

    public static final String ALERT_STATUS = "AS";
    // Account Sign
    public static final String ACCOUNT_SIGN_CREDIT = "C";
    public static final String ACCOUNT_SIGN_DEBIT = "D";
    public static final String ACCOUNT_SIGN_BOTH = "B";

    // GMI_FLAG in AMF table
    public static final String INTERNAL_ACCOUNT = "I";
    public static final String GENERAL_ACCOUNT = "G";
    public static final String FIXED_ACCOUNT = "F";

    public static final String NEW_LINE = "\n";
    // MULT_DIV_IND from CURRENCIES table
    public static final String MULT_DIV_IND_MUL = "M";
    public static final String MULT_DIV_IND_DIV = "D";

    // TERM_IND from RIFATT table
    public static final String TERM_IND_MONTHS = "M";
    public static final String TERM_IND_YEARS = "Y";
    public static final String TERM_IND_DAYS = "D";

    // Distribution Periodicity
    public static final String DISTRBTN_PERIOD_YEARLY = "Y";
    public static final String DISTRBTN_PERIOD_MONTHS = "M";
    public static final String DISTRBTN_PERIOD_SEMI_ANNUALY = "S";
    public static final String DISTRBTN_PERIOD_QUARTERLY = "Q";
    public static final String DISTRBTN_PERIOD_MATURITY = "T";

    // SOT Periodicity
    public static final String SOT_PERIOD_DAILY = "D";
    public static final String SOT_PERIOD_WEEKLY = "W";
    public static final String SOT_PERIOD_MONTHLY = "M";
    public static final String SOT_PERIOD_FIXED_WEEKLY = "F";
    public static final String SOT_PERIOD_FIXED_BI_WEEKLY = "B";
    public static final String SOT_PERIOD_WEEKLY_MONH_ENDING = "E";
    
    //AMANA130105   --[John Massaad]
    //Declaration Periodiciy
    public static final String DECL_PERIOD_DAILY = "D";
    public static final String DECL_PERIOD_WEEKLY = "W";
    public static final String DECL_PERIOD_MONTHLY = "M";
    public static final String DECL_PERIOD_FORTNIGHTlY = "F";
    public static final String DECL_PERIOD_QUARTERLY = "Q";
    public static final String DECL_PERIOD_SEMI_ANNUALLY = "S";
    public static final String DECL_PERIOD_YEARLY= "Y";
    
    
    //OverDraft Type (RIFATT)
    public static final String OD_NA = "N";
    public static final String OD_EXPRESS_CASH = "I";
    public static final String OD_EASY_CASH = "M";
    //This flag is used in FacilityLookup, it fills FacilitySC.sectionKey if the Apply Easy Cash/Express Cash is chekced and Overdraft Type is set to Express Cash or Easy Cash
    //I = EXPRESS_CASH and M = EASY_CASH and Y = yes ( checked)
    public static final String OD_EASY_CASH_OR_OD_EASY_CASH = "IMY";
    
  //AMANA130105   --[John Massaad]
    
    // Maturity flag for maturity date and final maturity date
    public static final String MATURITY_FLAG = "M";
    public static final String FINAL_MATURITY_FLAG = "F";

    // Application New Mode
    public static final String NEW_MODE = "new";

    // Calling Mode
//    public static final String CALLING_MOD_LOAD = "LOAD";
//    public static final String CALLING_MOD_ONCHANGE = "CHANGE";
    public static final String CALLING_MOD_UPDATE = "UPDATE";

    /**
     * A static hashMap for general accounts Status Management ...
     */
    public static final List<String> genAccountsStatusList = new ArrayList<String>();
    static
    {
	genAccountsStatusList.add("ENTERED_BY," + STATUS_CREATED + ",DATE_ENTERED");
	genAccountsStatusList.add("MODIFIED_BY," + STATUS_MODIFIED + ",DATE_MODIFIED");
	genAccountsStatusList.add("DELETED_BY," + STATUS_DELETE + ",DATE_DELETED");
	genAccountsStatusList.add("SUSPENDED_BY," + STATUS_SUSPENDED + ",DATE_SUSPENDED");
	genAccountsStatusList.add("REINSTATED_BY," + STATUS_REACTIVATED + ",DATE_REINSTATED");
	genAccountsStatusList.add("CLOSED_BY," + STATUS_CLOSED + ",DATE_CLOSD");
	genAccountsStatusList.add("TO_SUSPEND_BY," + STATUS_TO_SUSPEND + ",TO_SUSPEND_DATE");
	genAccountsStatusList.add("TO_REACTIVATE_BY," + STATUS_TO_REACTIVATE + ",TO_REACTIVATE_DATE");
	genAccountsStatusList.add("TO_CLOSE_BY," + STATUS_APPLY_FOR_CLOSURE + ",TO_CLOSE_DATE");// TODO
												// FINALISE
	genAccountsStatusList.add("TO_REJECT_BY," + STATUS_TO_REJECT + ",TO_REJECT_DATE");
	genAccountsStatusList.add("AUTH_REJ_USR," + STATUS_AUTHORIZED_REJECT + ",AUTH_REJ_DTE");// TODO
												// FINALISE
	genAccountsStatusList.add("CLOSED_BY," + STATUS_CLOSURE_APPROVED + ",DATE_CLOSD");

	// genAccountsStatusList.add("TODO,TODO,LAST_DATE_CALC");
	// genAccountsStatusList.add("TODO,TODO,LAST_POST_DATE");

    }
    /************************* FixedMaturity-Main details ***************************/
    // AMF.Language
    public static final String LANGUAGE_ENG = "L";
    public static final String LANGUAGE_ARABIC = "A";
    public static final String LANGUAGE_BOTH = "B";

    public static final String MODE_COMM_MAIL = "D";
    public static final String MODE_COMM_NOT_REQUIRED = "N";

    public static final String CANCEL_CHARGES_YES = "Y";
    public static final String CANCEL_CHARGES_NO = "N";
    public static final String UPDATE_PASSBOOK_NO = "0";
    public static final String UPDATE_PASSBOOK_YES = "1";

    /************************* FixedMaturity-tab-pt_ind ***************************/

    // AMF.PT_IND
    public static final String PT_IND_YES = "Y";
    public static final String PT_IND_NO = "N";

    // AMF.PT_PERIOD
    public static final String PT_PERIOD_DAILY = "D";

    // AMF.PT_METHOD
    public static final Integer PT_METHOD_360 = 2;
    public static final Integer PT_METHOD_365 = 1;
    public static final Integer PT_METHOD_366 = 3;

    // AMF.PT_METHOD_DAYS

    public static final String PT_METHOD_DAYS_30 = "1";
    public static final String PT_METHOD_DAYS_31 = "2";
    public static final String PT_METHOD_DAYS_ACTUAL = "3";

    public static final String PT_INDEX_ONE = "1";
    public static final String PT_INDEX_TWO = "2";
    public static final String PT_INDEX_THREE = "3";

    // AMF.SIGN
    public static final String AC_SIGN_DEBIT = "D";
    public static final String AC_SIGN_CREDIT = "C";
    public static final String AC_SIGN_BOTH = "B";

    // AMF.SPECIAL_RATE
    public static final String SPECIAL_RATE_NO = "0";
    public static final String SPECIAL_RATE_YES = "1";
    public static final String SPECIAL_RATE_SPECIFIC = "2";
    //
    /************************* FixedMaturity-tab-pt_ind ***************************/

    /************************* FixedMaturity-tab-MainDetails ***************************/

    /************************* FixedMaturity-tab-instructions ***************************/
    // AMF.RENEW
    public static final String RENEW_YES = "Y";
    public static final String RENEW_NO = "N";

    public static final String EXT_TRF_YES = "Y";
    public static final String EXT_TRF_NO = "N";

    // AMF.pft_post_to
    public static final String FMA_POST_TO_PAYABLE_ACCOUNT = "0";
    public static final String FMA_POST_TO_DEPOSIT_ACCOUNT = "1";
    public static final String FMA_POST_TO_MATURITY_ACCOUNT = "2";
    public static final String FMA_POST_TO_OFFENDING_ACCOUNT = "3";
    public static final String FMA_POST_TO_PROFIT_ACCOUNT = "4";
    
 // GA AMF.post interest to
    public static final String GA_POST_INTEREST_TO_PAYABLE_ACCOUNT = "0";
    public static final String GA_POST_INTEREST_TO_DEPOSIT_ACCOUNT = "1";
    public static final String GA_POST_INTEREST_TO_OFFENDING_ACCOUNT = "2";
    public static final String GA_POST_INTEREST_TO_PROFIT_ACCOUNT = "3";

    public static final String FIXED_INDEX = "F";

    public static final String TAX_APPLIED_YES = "1";
    public static final String TAX_APPLIED_NO = "0";

    public static final String APPLY_PCS_CHARGES_YES = "1";
    public static final String APPLY_PCS_CHARGES_NO = "0";

    //

    // AMF.CANCEL_CHARGES
    public static final String DO_NOT_CANCEL_CHARGES = "N";

    // AMF.NEW_IND
    public static final String NEW_IND_YES = "Y";
    public static final String NEW_IND_NO = "N";

    // AMF.FL_IND
    public static final String FL_IND_YES = "Y";
    public static final String FL_IND_NO = "N";

    public static final String FL_IND_LOAN = "Y";
    public static final String FL_IND_DEPOSIT = "N";
    public static final String FL_IND_NEITHER = "0";
    /************************************** additional details ******************************/
    public static final String RESET_RATE_MATURITY_YES = "1";
    public static final String RESET_RATE_MATURITY_NO = "0";
    public static final String RESET_RATE_MATURITY_SAME_AS_CONTROL_RECORD = "2";

    // ACC_NV_CONTROL
    public static final String FMA_MATURITY_DATE_ON = "1";
    public static final String FMA_MATURITY_DATE_OFF = "0";

    public static final String MAT_ONE_DAY_AFTER_ON = "1";
    public static final String MAT_ONE_DAY_AFTER_OFF = "0";
    //

    // MENU CRUD STATUS FIXED ACCOUNTS
    public static final String MAINTAINANCE_CRUD = "M";
    public static final String AUTHORIZE_CRUD = "A";
    public static final String UPDATE_AFTER_AUTHORIZE_CRUD = "U";

    public static final String SUSPEND_CRUD = "Q";
    public static final String AUTH_SUSPEND_CRUD = "S";

    public static final String REACTIVATE_CRUD = "Y";
    public static final String AUTH_REACTIVATE_CRUD = "E";

    public static final String REJECT_CRUD = "X";
    public static final String AUTH_REJECT_CRUD = "R";

    public static final String CLOSE_CRUD = "C";
    public static final String AUTH_CLOSE_CRUD = "L";
    //

    // MENU CRUD STATUS GENERAL ACCOUNTS
    public static final String AUTH_CLOSE_WITH_TRANSFER_CRUD = "W";
    public static final String CLOSE_WITH_TRANSFER_CRUD = "V";

    public static final String PRINT_CRUD = "N";

    // Buisnes CRUD STATUS FIXED ACCOUNTS
    public static final String MAINTAINANCE_BUISNESS_CRUD = "R";
    public static final String AUTHORIZE_BUISNESS_CRUD = "T";
    public static final String UPDATE_AFTER_AUTHORIZE_BUISNESS_CRUD = "I";
    public static final String SUSPEND_BUISNESS_CRUD = "Q";
    public static final String AUTH_SUSPEND_BUISNESS_CRUD = "S";

    public static final String REACTIVATE_BUISNESS_CRUD = "Y";
    public static final String AUTH_REACTIVATE_BUISNESS_CRUD = "A";

    public static final String REJECT_BUISNESS_CRUD = "X";
    public static final String AUTH_REJECT_BUISNESS_CRUD = "J";

    public static final String CLOSE_BUISNESS_CRUD = "O";
    public static final String AUTH_CLOSE_BUISNESS_CRUD = "L";

    // BUSINESS CRUD STATUS GENERAL ACCOUNTS
    public static final String AUTH_CLOSE_WITH_TRANSFER_BUSINESS_CRUD = "W";
    public static final String CLOSE_WITH_TRANSFER_BUSINESS_CRUD = "V";

    // Account Type screen
    public static final String DEFAULT_OFFEND_INST_ON = "1";
    public static final String DEFAULT_OFFEND_INST_OFF = "0";

    public static final String FMA_OPEN_DEP_DETAILS_ON = "1";
    public static final String FMA_OPEN_DEP_DETAILS_OFF = "0";

    public static final String NOT_AFFECTED = "0";
    public static final String AFFECT_PASSBOOK = "1";
    public static final String AFFECT_CHEQUEBOOK = "2";
    public static final String AFFECT_CERITIFICATE_DEPOSIT = "3";
    public static final String AFFECT_TYPE_CHEQUEBOOK = "0";  /* AFFECT CHEQUEBOOK OF TYPE CHEQUES*/
    public static final String AFFECT_TYPE_BILLS = "1";  /* AFFECT CHEQUEBOOK OF TYPE BILLS*/
    public static final String AFFECT_TYPE_CHQ_BILLS = "2";  /* AFFECT CHEQUEBOOK OF TYPE BOTH (CHEQUEBOOK AND BILLS)*/

    public static final String MATURITY_AS_CONTROL = "0";
    public static final String MATURITY_ONE_DAY_BEFORE = "1";
    public static final String MATURITY_ON_DATE = "2";

    // Account Type screen
    public static final String SAVE_TYPE_NEW = "C";
    public static final String SAVE_TYPE_MODIFIED = "M";
    public static final String SAVE_TYPE_DELETE = "D";

    // Account Type screen
    public static final String ALLOW_CHANGE_DIST_PER_ON = "1";
    public static final String ALLOW_CHANGE_DIST_PER_OFF = "0";

    // auto renew from accountype
    public static final String AUTO_RENEW_ON = "1";
    public static final String AUTO_RENEW_OFF = "0";

    // allow other cif from accountype
    public static final String ALLOW_OTHER_CIF_ON = "1";
    public static final String ALLOW_OTHER_CIF_OFF = "0";

    // allow BlackListe from accountype
    public static final String ALLOW_BLACKLISTED_ON = "1";
    public static final String ALLOW_BLACKLISTED_OFF = "0";

    // Reset rate Maturity
    public static final String CLEAR_PT_RATE = "1";

    // DEFAULT_OFFEND_INST
    public static final String DEFAULT_OFFEND_INST_YES = "1";
    public static final String DEFAULT_OFFEND_INST_NO = "0";

    public static final String PARENT_REF_FIXED   = "A001";
    public static final String PARENT_REF_GENERAL = "A002";
	//#Modif ASB130049 ; Elias Aoun 08/06/2015
    public static final String PROG_REF_REACTIVATE_REPORT = "A002RE-L";

    public static final String GL_STATUS_ASSET = "A";
    public static final String GL_STATUS_LIABILITY = "L";

    public static final String CLOSE_IND_YES = "Y";
    public static final String CLOSE_IND_NO = "N";

    public static final String AUTO_SWEEP_ON = "1";
    public static final String AUTO_SWEEP_OFF = "0";

    public static final String PROTECT_PT_PERIOD_ON = "1";

    public static final String CR_PT_IND_VARIABLE = "V";
    public static final String DR_PT_IND_FIXED = "F";
    public static final String DR_PT_IND_VARIABLE = "V";

    public static final String APPL_DATE_IS_SUB_DATE_OFF = "0";
    public static final String MAIL_STMT_YES = "Y";
    public static final String MAIL_STMT_NO = "N";

    public static final int ACCOUNT_ELEMENT_BRANCH = 0;
    public static final int ACCOUNT_ELEMENT_CURRENCY = 1;
    public static final int ACCOUNT_ELEMENT_GL = 2;
    public static final int ACCOUNT_ELEMENT_CIF = 3;
    public static final int ACCOUNT_ELEMENT_SL = 4;

    public static final String MODE_OF_PAYMENT_ACCOUNT = "A";
    public static final String MODE_OF_PAYMENT_CASH = "C";
    public static final String MODE_OF_PAYMENT_CHEQUE = "Q";

    public static final String TRX_TYPE_D = "D";
    public static final String CR_DR_FOREX_C = "C";
    public static final String CR_DR_FOREX_D = "D";

    public static final String CTS_TRX_TYPE_D = "D";
    public static final String CTS_TRX_TYPE_T = "T";
    public static final String CTS_TRX_TYPE_W = "W";

    public static final String CHECK_UN_CLAIMED = "Y";

    public static final String MATURITY_CALCULATION_DEFAULT = "T";
    
    public static final String CREDIT_IND = "CR";
    public static final String DEBIT_IND = "DR";
    
    //#544242 SBI170032 ;Rakan Makarem 24/07/2017
    public static final String FULL_NAME= "F";

    /**
     * this function is used to ge the iv_crud from the menu crid for the fixed
     * maturity
     * 
     * @param menuCrud
     * @return
     * @throws BaseException
     */
    public static String returnFixedBuisnessCrud(String menuCrud) throws BaseException
    {
	if(menuCrud != null)
	{
	    // if we r in maintaincace level return status 'O' opened
	    if(MAINTAINANCE_CRUD.equals((menuCrud)))
	    {
		return MAINTAINANCE_BUISNESS_CRUD;
	    }

	    // if we r in athorize level return status 'A' authorize
	    else if(AUTHORIZE_CRUD.equals((menuCrud)))
	    {
		return AUTHORIZE_BUISNESS_CRUD;
	    }

	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(UPDATE_AFTER_AUTHORIZE_CRUD.equals((menuCrud)))
	    {
		return UPDATE_AFTER_AUTHORIZE_BUISNESS_CRUD;
	    }

	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(SUSPEND_CRUD.equals((menuCrud)))
	    {
		return SUSPEND_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_SUSPEND_CRUD.equals((menuCrud)))
	    {
		return AUTH_SUSPEND_BUISNESS_CRUD;
	    }

	    else if(REACTIVATE_CRUD.equals((menuCrud)))
	    {
		return REACTIVATE_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_REACTIVATE_CRUD.equals((menuCrud)))
	    {
		return AUTH_REACTIVATE_BUISNESS_CRUD;
	    }
	    else if(REJECT_CRUD.equals((menuCrud)))
	    {
		return REJECT_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_REJECT_CRUD.equals((menuCrud)))
	    {
		return AUTH_REJECT_BUISNESS_CRUD;
	    }
	    else if(CLOSE_CRUD.equals((menuCrud)))
	    {
		return CLOSE_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_CLOSE_CRUD.equals((menuCrud)))
	    {
		return AUTH_CLOSE_BUISNESS_CRUD;
	    }
	    else if(PRINT_CRUD.equals((menuCrud)))
	    {
		return PRINT_CRUD;
	    }
	}
	return null;
    }

    /****
     * method for getting business crud for GA
     * 
     * @param menuCrud
     * @return
     * @throws BaseException
     */
    public static String returnGeneralBuisnessCrud(String menuCrud) throws BaseException
    {
	if(menuCrud != null)
	{
	    // if we r in maintenance level return status 'O' opened
	    if(MAINTAINANCE_CRUD.equals((menuCrud)))
	    {
		return MAINTAINANCE_BUISNESS_CRUD;
	    }

	    else if(AUTH_CLOSE_WITH_TRANSFER_CRUD.equals((menuCrud)))
	    {
		return AUTH_CLOSE_WITH_TRANSFER_BUSINESS_CRUD;
	    }

	    else if(CLOSE_WITH_TRANSFER_CRUD.equals((menuCrud)))
	    {
		return CLOSE_WITH_TRANSFER_BUSINESS_CRUD;
	    }

	    // if we r in athorize level return status 'A' authorize
	    else if(AUTHORIZE_CRUD.equals((menuCrud)))
	    {
		return AUTHORIZE_BUISNESS_CRUD;
	    }

	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(UPDATE_AFTER_AUTHORIZE_CRUD.equals((menuCrud)))
	    {
		return UPDATE_AFTER_AUTHORIZE_BUISNESS_CRUD;
	    }

	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(SUSPEND_CRUD.equals((menuCrud)))
	    {
		return SUSPEND_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_SUSPEND_CRUD.equals((menuCrud)))
	    {
		return AUTH_SUSPEND_BUISNESS_CRUD;
	    }

	    else if(REACTIVATE_CRUD.equals((menuCrud)))
	    {
		return REACTIVATE_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_REACTIVATE_CRUD.equals((menuCrud)))
	    {
		return AUTH_REACTIVATE_BUISNESS_CRUD;
	    }
	    else if(REJECT_CRUD.equals((menuCrud)))
	    {
		return REJECT_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_REJECT_CRUD.equals((menuCrud)))
	    {
		return AUTH_REJECT_BUISNESS_CRUD;
	    }
	    else if(CLOSE_CRUD.equals((menuCrud)))
	    {
		return CLOSE_BUISNESS_CRUD;
	    }
	    // if we r in update after athorize level return status 'A'
	    // authorize
	    else if(AUTH_CLOSE_CRUD.equals((menuCrud)))
	    {
		return AUTH_CLOSE_BUISNESS_CRUD;
	    }
	    else if(PRINT_CRUD.equals((menuCrud)))
	    {
		return PRINT_CRUD;
	    }

	}
	return null;
    }

    public static final String GLOBAL_CONFIRMATION = "GLOBAL_CONFIRMATION";
    public static final String ERROR_VALIDATE_CIF_SUB_NUMBER = "ERROR_VALIDATE_CIF_SUB_NUMBER";
    public static final String REVERSE_DRAWDOWN_CONF = "REVERSE_DRAWDOWN_CONF";

    public static final String AMENDING_YES = "YES";
    public static final String AMENDING_NO_ACCESS = "NO ACCESS";

    // Print advice
    public static final String PRINT_ACCOUNT_CONFIRMATION_DEFAULT = "RETPRCONF";
    public static final String PRINT_FIX_ACCOUNT_OPEN_ACC = "OP/AC";
    public static final String PRINT_FIX_ACCOUNT_ADV = "ADV";

    // MODE_COMM values
    public static final String DIRECT_MAIL = "D";
    public static final String PO_BOX = "P";
    public static final String MOBILE_NO = "S";
    public static final String PHONE_NO = "F";
    
    //Actions taken as Web Services
    public static final String WS_ACCOUNT_UPDATE 		= "UPD";
    public static final String WS_ACCOUNT_AUTHORIZE 		= "AUTH";
    public static final String WS_ACCOUNT_CLOSE   		= "CLSE";
    public static final String WS_ACCOUNT_AUTHORIZE_CLOSE 	= "ACLSE";
    public static final String WS_ACCOUNT_REJECT 		= "REJ";
    public static final String WS_ACCOUNT_APPROVE_REJECT 	= "AREJ";
    public static final String WS_ACCOUNT_REACTIVATE 		= "REAC";
    public static final String WS_ACCOUNT_APPROVE_REACTIVATE 	= "AREAC";
    public static final String WS_ACCOUNT_SUSPEND 		= "SUSP";
    public static final String WS_ACCOUNT_APPROVE_SUSPEND 	= "ASUSP";   
    public static final String WS_ACCOUNT_DELETE 		= "DELETE";   

    public static final String SUSPEND_INT_ACC_BUISNESS_CRUD 	= "S";
    public static final String REACTIVATE_INT_ACC_BUISNESS_CRUD = "A";
    public static final String CLOSE_INT_ACC_BUSINESS_CRUD 	= "Z";

    public static final String CERTIFICATE_DEPOSIT = "CD";

    // RIFATT Category
    public static final String CATEGORY_DEMAND = "D";
    public static final String CATEGORY_TERM = "T";
    public static final BigDecimal ACCOUNT_HIST_LOV_TYPE_ID = new BigDecimal(481);

    public static final String OVERDRAWN_LIMIT_MCASH = "M";
    public static final String OVERDRAWN_LIMIT_OVERDRAFT = "O";
    public static final String OVERDRAWN_LIMIT_MUSHARAKA = "S";
    
    
    public static final String FROM_SCREEN_BILL = "BILL";
    
    public static final String ACCOUNT_CHRG_ENTITY_TYPE    = "ACCCHRG";
    
    //For Calling P_CREATE_ACCOUNT, status must be supplied as '1' to create account with status 'I'
    public static final String CREATE_INACTIVE_ACCOUNT = "1";
    
    public static final String GENERAL_ACCOUNT_COUNTER = "GAC";
    public static final String FIXED_MATURITY_COUNTER = "FMA";
    
    public static final String COL_NAME_ACC_SL = "ACC_SL";
    public static final String COL_NAME_ACC_ADD_REF = "ACC_ADD_REF";
    public static final String ACCOUNTS_SCREEN_SRC = "ACCOUNTS";
    public static final String FOM_SCREEN_SRC = "FOM";
    //Elias Aoun 12/06/2015 ; ASB130049 
    public static final BigDecimal PROC_REACTIVATE_COVERING_ACCOUNT = BigDecimal.valueOf(11);
    public static final BigDecimal PROC_RESUBMIT_CHEQUEBOOKS = BigDecimal.valueOf(13);
    public static final String PROC_EOD_REACTIVATE_USER = "EOD71";
    
    public static final String CHECK_OBLIGOR = "CHECK_OBLIGOR";
    
    //AUBBH170058-MODIFICATION ON FMA
    public static final BigDecimal RESET_RATE_MATURITY_LOV = BigDecimal.valueOf(1436);
    
    public static final class SYS_PARAM_LOV_TRANS
    {
	public static final BigDecimal JOINT_ACCOUNTS = BigDecimal.valueOf(25);
	public static final BigDecimal PFT_POST_INTEREST = BigDecimal.valueOf(77);
	public static final BigDecimal PFT_POST_PROFIT = BigDecimal.valueOf(89);

    }
    //Raed Saad User Story #412599 EWBI160163
    public static final BigDecimal UPON_RENEWAL_AFFECT_LOV_TYPE = new BigDecimal(770); 
    public static final String UPON_RENEWAL_AFFECT_OPENING_PROFIT_ACCOUNTS = "2";
    

    public static final String WS_GET_CIF_ACCOUNTS_ALL_STS 	= "GCAASTS";   
    
    public static final String NOT_MANDATORY = "NM";
    public static final String BY_ACCOUNT_TYPE = "AT";
    public static final String WARN_AND_PROCEED = "WP";
    public static final String MANDATORY = "M";
    // Tony Nouh User Story#336860 INDI150072
    public static final Integer PT_METHOD_ACTUAL = 4;
}

