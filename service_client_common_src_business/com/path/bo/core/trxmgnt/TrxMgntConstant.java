package com.path.bo.core.trxmgnt; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrxMgntConstant
{
    public static final String CRUD_RETURN     	     			= "RO";
    public static final String CRUD_CANCEL   	     			= "N";
    public static final String CRUD_TO_REVERSE	     			= "W";
    public static final String CRUD_APPROVE	     			= "P";
    public static final String CRUD_REVERSE	     			= "V";
    public static final String CRUD_BULK_REMITTANCE  			= "M";
    public static final String CRUD_REPRESENT_VOID_CHQ 			= "E";
    public static final String CRUD_REJECT	 			= "J";
    public static final String CRUD_TO_CANCEL        			= "Z";
    public static final String CRUD_TO_RETURN        			= "TR";
    public static final String CRUD_AMEND_SO        			= "AS";
    public static final String CRUD_MAINTENANCE      			= "R";
    public static final String CRUD_VOID_INWARD_CHQ    			= "I";
    public static final String CRUD_APP_VOID_INWARD_CHQ 		= "O";
    public static final String CRUD_TO_BE_STOPPED_SO			= "TS";
    public static final String CRUD_STOP_SO				= "SS";
    public static final String CRUD_REACTIVATE_SO			= "RS";
    public static final String CRUD_APPROVE_REACTIVATE_SO		= "ARS";
    public static final String CRUD_TO_BE_CLOSED_SO			= "TCL";
    public static final String CRUD_CLOSE_SO				= "CL";
    public static final String CRUD_APPLY_VOID_INWARD_CHQ		= "VIL";
    public static final String CRUD_APPLY_VOID_OUTWARD_CHQ		= "VOL";
    public static final String CRUD_APPLY_VOID_HOUSE_CHQ		= "VCL";
    public static final String CRUD_CLEAR_INWARD_CHQ			= "C";
    public static final String CRUD_REVERSE_CLEAR_OUTWARD_CHQ		= "RCO";
    public static final String CRUD_TO_REVERSE_CLEAR_OUTWARD_CHQ	= "ARC";
    public static final String CRUD_PRINT     	     			= "T";
    public static final String CRUD_RELEASE_HOF	     			= "L";
    public static final String CRUD_VOID_HOUSE_CHQ			= "VC";
    public static final String CRUD_AMEND_VDATE				= "AD";
    public static final String CRUD_APPROVE_AMEND_VDATE			= "ADP";
    public static final String CRUD_TO_RELEASE_HOF	     		= "K";
    public static final String CRUD_TO_BE_RELEASED                      = "K";
    public static final String CRUD_AMMEND_BENEFICIARY_DETAILS 		= "ABD";

    public static final String TRX_REFERENCE		= "n_transaction";
    public static final String DOF_TRX_TYPE 		= "DOF";
    
    public static final String TRX_PARENT_OPT		= "D001";
    public static final String OPT_MAINTENANCE		= "D001MT";
    public static final String OPT_APPROVE		= "D001AU";
    public static final String OPT_MULTI_CHEQUES_ENTRY	= "D001CE";
    public static final String OPT_BULK_REMITTANCE	= "D001RE";
    public static final String PARENT_OPT_CURRENCY_EXCHANGE  = "TE001";
    public static final String OPT_REACTIVATE_REMITTANCE= "D001RR";
    public static final String OPT_SCANCHEQUEMT		="SCANCHEQUEMT";
    
    //TRSFR_METHOD column in CTSTRXTYPE table
    public static final int NORMAL_BEHAVIOR 		= 1;
    public static final int FORBID_CASH 		= 2;
    public static final int FORBID_ACCOUNT 		= 3;
    public static final int FORBID_CASH_ACCOUNT 	= 5;
    public static final int FORBID_CASH_CHEQUE 		= 6;
    public static final int FORBID_ACCOUNT_CHEQUE 	= 7;
    public static final int ALLOW_ALL 			= 8;
    
    public static final int TRX_FOM_ACC_DEPENDENCY 	= 1;
    public static final int TRX_TELLER_ACC_DEPENDENCY 	= 2;
    public static final int TRX_TO_ACC_DEPENDENCY 	= 3;
    public static final int TRX_MULTIPLE_ACC_DEPENDENCY = 4;
    public static final int TRX_CHARGE_ACC_DEPENDENCY 	= 5;
    
    //TRS_METHOD column in CTSTRS table
    public static final String CASH = "C";
    public static final String FOREIGN_CHEQUE = "F";
    public static final String LOCAL_CHEQUE = "L";
    public static final String INTRA = "I";
    public static final String EXTERNAL = "E";

    public static final BigDecimal ACTION_TYPE_LOV   	     = new BigDecimal(462);
    public static final BigDecimal BULK_REMITTANCE_TYPE_LOV  = new BigDecimal(583);
    
    //
    public static final String GET_ACC_BAL 		= "G";
    public static final String FROM_ACC_BAL 	= "F";
    public static final String TO_ACC_BAL 	= "T";

    //CR_DR_FOREX column in CTSTRS table
    public static final String MAIN_ACC_CR 		= "C";
    public static final String MAIN_ACC_DR 		= "D";
    
    //TRX_PURPOSE column in CTSTRS table
    public static final String TRX_PURPOSE_ISSUANCE 	= "I";
    public static final String TRX_PURPOSE_COLLECTION 	= "C";
    public static final String TRX_PURPOSE_CANCELLATION = "N";
    public static final String TRX_PURPOSE_REFUND 	= "R";
    
    //Type Column in CTSTRXTYPE table 
    public static final String DEPOSIT        	     	= "D";
    public static final String WITHDRAWAL            	= "W";
    public static final String TRANSFER		     	= "T";
    public static final String HOLD_OF_FUND	     	= "H";
    
    //CHQ_RELATED Column in CTSTRXTYPE table 
    public static final String HOUSE_CHEQUE          	= "H";
    public static final String CLEARING_CHEQUE       	= "C";
    public static final String NOT_CHQ_RELATED   	= "N";
    

    public static final String TRANSFER_TYPE_LOCAL	     	= "L";
    public static final String TRANSFER_TYPE_INTRA_BANK	     	= "I";
    public static final String TRANSFER_TYPE_INTERNATIONAL    	= "E";
    
    
    //TRSFR_TYPE Column in CTSTRXTYPE table 
    public static final BigDecimal TRSFR_TYPE_INTRA_BANK	= BigDecimal.ONE;
    public static final BigDecimal TRSFR_TYPE_LOCAL      	= BigDecimal.valueOf(2);
    public static final BigDecimal TRSFR_TYPE_INTERNATIONAL 	= BigDecimal.valueOf(3);
    
    //TRSFR_METHOD Column in CTSTRS table 
    public static final String CASH_TRSFR 	     	= "C";
    public static final String Account_TRSFR         	= "A";
    public static final String CHEQUE_TRSFR  	     	= "Q";
    
    //SO_TYPE Column in CTSTRXTYPE table 
    public static final String PERIODICAL_SPEC_AMOUNT	= "P";
    public static final String MIN_BALANCE         	= "M";
    public static final String MAX_BALANCE  	     	= "X";
    
   // public static final String CLEARING              	= "C";
  //  public static final String NOT_CHQ_RELATED       	= "N";
    public static final String TRAVELLER_CHQ         	= "TC";
    public static final String CERTIFICATE_DEPOSIT   	= "CD";
    public static final String DEMAND_DRAFT          	= "DD";
    public static final String UNCLAIMED_REMITT      	= "U";
    public static final String STALE_REMITT          	= "ST";
    public static final String DECAYED_REMITT        	= "DC";
    public static final String ISSUED_REMITT        	= "I";
    public static final String TO_BE_REACT_REMITT    	= "TR";
    public static final String TRS_TYPE_CSM          	= "R";
    public static final String MULTI_CHEQUE_ENTRY      	= "MCE";
    public static final String CLIENT_CB_IND         	= "C";    
    public static final String REMITT_BY_COMP        	= "C";
    public static final String ACCOUNT_SIGN_DEBIT    	= "D";
    public static final String ACCOUNT_SIGN_CREDIT   	= "C";
    public static final String ACCOUNT_SIGN_BOTH   	= "B";
    public static final String RETURN_OLD_STATUS_REMITT = "J";
    
    public static final String STATUS_ACTIVE         	= "A";    
    public static final String STATUS_DELETED        	= "D";
    public static final String STATUS_TO_CANCEL      	= "Z";
    public static final String STATUS_TO_RETURN      	= "X";
    public static final String STATUS_TO_REVERSE     	= "W";
    public static final String STATUS_REVERSE        	= "R";
    public static final String STATUS_TO_BE_RELEASED 	= "K";
    public static final String STATUS_RELEASED       	= "L";
    public static final String STATUS_APPROVE        	= "P";
    public static final String STATUS_CANCEL         	= "N";
    public static final String STATUS_TO_STOP_SO     	= "B";
    public static final String STATUS_STOPPED_SO	= "S";
    public static final String STATUS_TO_CLOSE_SO     	= "2";
    public static final String STATUS_CLOSED_SO		= "3";
    public static final String STATUS_TO_REACTIVATE_SO	= "1";
    public static final String STATUS_CLEARED		= "C";
    public static final String STATUS_CLEAR_IN_PROCESS	= "6";
    public static final String STATUS_CLEAR_NO_ACTION	= "N";
    public static final String STATUS_TO_BE_CLEARED	= "U";
    public static final String STATUS_CREATED_SO	= "T";
    public static final String STATUS_CLOSED		= "O";
    public static final String STATUS_TO_BE_VOIDED      = "H";
    public static final String STATUS_REJECT         	= "J";
    public static final String STATUS_VOID         	= "V";
    public static final String STATUS_REPRESENTED      	= "E";
    public static final String STATUS_PROCESSED     	= "F";
    
    
    
    //active SO
    public static final Integer ACTIVE_SO         	= 1;
    public static final Integer NON_ACTIVE_SO         	= 0;
    public static final String TRX_SCREEN_REF	     	= "TRX";
    public static final String CHECK_MANDATORY	     	= "M";
    public static final String UPDATE_ACTION	     	= "U";
    public static final String INSERT_ACTION	     	= "I";
    public static final String ACTIVE_TRX	     	= "R";	
    public static final String APPROVED_TRX	     	= "P";
    public static final String REVERSED_TRX	     	= "V";
    public static final String VOID_TRX	     	     	= "VI";
    public static final String VOID_ACTIVE_TRX  	= "VA";
    public static final String VOID_NO_ENTRIES  	= "VN";
    public static final String VOID_TEMPLATE	  	= "VT";
    public static final String CANCELLED_TRX	     	= "N";
    public static final String ERROR		     	= "E"; 
    public static final String WARNING		     	= "W";
    public static final String LIMIT_WARNING		= "L";   
    public static final String WARNING_SEPERATOR     	= "~~"; 
    public static final String REASON_TYPE           	= "4";
    public static final String CONFIRM_YES           	= "0";
    public static final String CONFIRM_NO            	= "1";
    
    public static final String HOLD_REASON_TYPE         = "3";
    public static final String PURPOSE_REASON_TYPE      = "4";

    public static final String PERIODICITY_YEARLY	= "Y";
    public static final String PERIODICITY_MONTHLY	= "M";
    public static final String PERIODICITY_WEEKLY	= "W";
    public static final String PERIODICITY_DAILY	= "D";
    public static final String PERIODICITY_FORTNIGHTLY	= "F";
    
    public static final String SO_SPECIFIC_DAY		= "D";
    public static final String SO_END_OF_MONTH		= "M";
    
    public static final String PERCENTAGE 		= "E";
    public static final String ONLINE_SO 		= "O";
    public static final String SO_PROCESS_END_OF_DAY 	= "E";
    
    //CY_FIELD Column in CTS_TRXTYPE_ALLOWED_CY table 
    public static final String MAIN_CY_FIELD		= "0";
    public static final String TRS_CY_FIELD		= "1";
    public static final String BOTH_CY_FIELD		= "2";
    
    //LIMIT_TYPE Column in CTSTELLERCIFTYPEDET table
    public static final String CIF_PRIORITY		= "P";
    public static final String CIF_ECONOMIC_SECTOR	= "E";
    public static final String CIF_TYPE			= "C";

    public static final String TRX_ENTRY_SCREEN	 	 = "TRX";
    public static final String MULTI_CHQ_ENTRY_SCREEN	 = "W_MCHQ";
    public static final String MULTI_CHQ_ENTRY_SCREEN_UO = "UO_MCHQ";
    public static final String BULK_REMITTANCE_SCREEN	 = "BULK_REMITTANCE";
    public static final String CY_EXCHANGE_SCREEN	 = "CURRENCY EXCHANGE SCREEN JAVA";
    
    //CENTRAL BANK
    public static final String CBS_SRI_LANKA		= "14"; 
    
    //actions for DOF procedures
    public static final String ACTION_APPROVE       	= "APPROVE";
    public static final String ACTION_REVERSE       	= "REVERSE";
    
    public static final BigDecimal LOV_TYPE          	= new BigDecimal(63);
    public static final BigDecimal LOV_TYPE_SYNTHESIS_STATUS  = new BigDecimal(1771);
    //NABIL FEGHALI - BISI120150 - Alert Offline
    public static final BigDecimal PROCESSED_LOV_TYPE   = new BigDecimal(401);
    public static final BigDecimal CHARGE_ACTION_LOV_TYPE = new BigDecimal(415);
    
    //FOREX DEBTOR / CREDITOR
    public static final String FOREX_CREDITOR		= "C"; 
    public static final String FOREX_DEBTOR		= "D";
    
    public static final String HASH_CARD_SEPARATOR	= "******";
    
    //CASH DEDUCT INDICATOR
    public static final String DEDUCT_CASH		= "0";
    public static final String DEDUCT_FROM_ACCOUNT	= "1";
    public static final String DEDUCT_FROM_CREDITOR	= "2";
    public static final String DEDUCT_FROM_DEBTOR	= "3";
    public static final String DEDUCT_FROM_TELLER_ACC	= "4";
    public static final String DEDUCT_FROM_OTHER_ACC	= "5";
    public static final String DEDUCT_NOT_APPLICABLE	= "6";
    
    //Default Main Account toTeller Account
    public static final String NO_DEFAULT_DR_ACC_TELLER	= "0";
    public static final String DEFAULT_DR_ACC_TELLER	= "1";
    
    //Charges Booking
    public static final String CHARGES_BOOKING_A	= "A";
    public static final String CHARGES_BOOKING_B	= "B";
    public static final String CHARGES_BOOKING_C	= "C";
    
    //Charge Branch
    public static final String CHARGES_BRANCH_DEFAULT_BRANCH			= "0";
    public static final String CHARGES_BRANCH_TRANSACTION_OR_TELLER_BRANCH	= "1";
    public static final String CHARGES_BRANCH_MAIN_ACCOUNT_BRANCH		= "2";
    public static final String CHARGES_BRANCH_SPECIFIC_BRANCH			= "3";
    
    //Charge Action Type
    public static final String CHARGES_ACTION_TYPE_APPROVE			= "P";
    public static final String CHARGES_ACTION_TYPE_CANCEL			= "N";
    public static final String CHARGES_ACTION_TYPE_CANCEL_REASON		= "RC";
    public static final String CHARGES_ACTION_TYPE_VOID_REASON			= "RV";
    public static final String CHARGES_ACTION_TYPE_REVERSE_REASON		= "RR";
    public static final String CHARGES_ACTION_TYPE_SO_SETUP			= "E";
    public static final String CHARGES_ACTION_TYPE_SO_AMEND			= "A";
    public static final String CHARGES_ACTION_TYPE_SO_REINSTATE			= "R";
    public static final String CHARGES_ACTION_TYPE_SO_SUSPEND			= "S";
    public static final String CHARGES_ACTION_TYPE_SO_CLOSE			= "C";
    public static final String CHARGES_ACTION_TYPE_RELEASE_HOF			= "L";
    public static final String CHARGES_ACTION_TYPE_HOF_REASON		        = "HOF";
    
    //Transaction from to.
    public static final String TRANSACTION_FROM ="FROM";
    public static final String TRANSACTION_TO ="TO";
    public static final String TRANSACTION_MULTI ="MULTI";
    public static final String TRANSACTION_NOSTRO ="NOSTRO";
    
    public static final String FROM        	= "F";
    public static final String TO        	= "T";
    public static final String CTRL        	= "C";
    public static final String SAVE_NEW_MODE	= "saveNew";
    public static final String REMITT_ALL_CURR = "A";
    public static final String REMITT_IN_TRANS_CURR = "T";
    
    //Dormant Account types
    public static final String PROCEED_ON_DORMANT_AC_AND_VIEW_SIGNATURE		="1";
    public static final String PROCEED_ON_DORMANT_AC_AND_DONT_VIEW_SIGNATURE	="2";
    public static final String DONT_PROCEED_ON_DORMANT_AC			="0";
    public static final String PROCEED_ON_DORMANT_AC_IF_DEPOSIT			="3";
    public static final String PROCEED_ON_DORMANT_AC_AND_DONT_VIEW_CIF_SIGNATURE="4";
    
    //Suspend Account types
    public static final String DONT_PROCEED_ON_SUSPENDED_AC			="0";
    public static final String PROCEED_ON_SUSPENDED_AC_AND_VIEW_SIGNATURE	="1";
    public static final String PROCEED_ON_SUSPENDED_AC_AND_DONT_VIEW_SIGNATURE	="2";
    public static final String PROCEED_ON_SUSPENDED_AC_IF_DEPOSIT		="3";
    
    //TO VOID STATUSES IN CTSTRS
    public static final String STATUS_TO_BE_VOIDED_AFTER_APPROVE		= "I";
    public static final String STATUS_TO_BE_VOIDED_AFTER_CLEAR			= "H";
    public static final String STATUS_TO_BE_VOIDED_AFTER_TO_BE_CLEARED		= "M";
    
    
    //Multi Trx
    public static final String SINGLE_TRX	= "0";
    public static final String MULTI_TRX 	= "1";
	
    // Transaction Purpose
    public static final String TRANSACTION_PURPOSE_ISSUANCE = "I";
    public static final String TRANSACTION_PURPOSE_COLLECTION = "C";
    public static final String TRANSACTION_PURPOSE_CANCELLATION = "N";
    public static final String TRANSACTION_PURPOSE_REFUND = "R";
    
    //SO operation type
    
    public static final String CREATE_SO 	= "CT";
    public static final String AMEND_SO 	= "AT";
    public static final String SUSPEND_SO 	= "ST";
    public static final String REINSTATE_SO 	= "RT";
    public static final String CLOSE_SO 	= "LT";
    public static final String STOP_SO 		= "OT";

    //BS_CONTRA_FLAG
    public static final String TEMPLATE_ENTRIES			= "Z";
    public static final String ON_BS      			= "B";
    public static final String OFF_BS      			= "O";
    public static final String ON_OFF_BS      			= "X";
    public static final String OFF_BS_AND_ON_BS_AT_VDATE 	= "C";
    
    // Remittance Currency
    public static final String TRX_CURRENCY 			= "T";
    public static final String ALL_CURRENCIES 			= "A";
    
    public static final String NEW_LINE 			= "\n";
    public static final String SEND_SWIFT 			= "1";
    
    public static final String TRUE 				= "TRUE";
    public static final String FALSE 				= "FALSE";
    
    public static final String TRUE_LOWER_CASE			= "true";
    public static final String FALSE_LOWER_CASE			= "false";
    
    //CTSBATCH Statuses
    public static final String CLEARING_IN_PROCESS 		= "P";
    public static final String CLEARING_NO_ACTION 		= "N";
    
    
    //Action for SO Charges Calculation
    public static final String SO_CHARGE_SAVE      		= "S";
    
    public static final BigDecimal SUB_STATUS_LOV_TYPE = new BigDecimal(815);

    //SO Charge Action
    public static final String SO_CHARGE_RETRIEVE		= "P";
    public static final String SO_CHARGE_CALCULATE		= "S";

    public static final List<String> trxMgntPropToCheck  = Arrays.asList( "trxMgntCO.ctstrsVO.VOID_REASON", "trxMgntCO.ctstrsVO.BENEF_ADDRESS_4",
                                                	 "trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS", "trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS_1",
                                                	 "trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS_2", "trxMgntCO.ctstrsVO.BENEF_BANK_ADDRESS_1",
                                                	 "trxMgntCO.ctstrsVO.BENEF_BANK_ADDRESS_2", "trxMgntCO.ctstrsVO.SO_PERIODICITY",
                                                	 "trxMgntCO.ctstrsVO.SO_PERIOD_DAY", "trxMgntCO.ctstrsVO.RECEIVER_CORR_BANK_ADDRESS",
                                                	 "trxMgntCO.ctstrsVO.RECEIVER_CORR_BANK_ADDRESS1", "trxMgntCO.ctstrsVO.RECEIVER_CORR_BANK_ADDRESS2",
                                                	 "trxMgntCO.ctstrsVO.RECEIVER_CORR_BANK_ADDRESS3", "trxMgntCO.ctstrsVO.SO_PERIOD_INTERVAL",
                                                	 "trxMgntCO.ctstrsVO.MT103_FIELD71F", "trxMgntCO.ctstrsVO.VOID_REASON","trxMgntCO.void_reason_1",
                                                	 /*"trxMgntCO.ctstrsVO.TRS_DATE_HIJRI",*/ "trxMgntCO.ctstrsVO.COUNTER_PARTY",
                                                 	 "trxMgntCO.ctstrsVO.DEPOSITER_ID", "trxMgntCO.ctstrsVO.DEPOSITER_ADDRESS_1",
                                                 	 "trxMgntCO.ctstrsVO.DEPOSITER_ADDRESS_2", "trxMgntCO.ctstrsVO.DEPOSITER_ADDRESS_3",
                                                	 "trxMgntCO.ctstrsVO.TEL", "trxMgntCO.ctstrsVO.DEPOSITER_NATIONALITY", "trxMgntCO.ctstrsVO.ID_TYPE",
                                                	 "trxMgntCO.ctstrsVO.DEPOSITER_NAME", /*"trxMgntCO.ctstrsVO.VALUE_DATE_HIJRI",*/
                                                	 "trxMgntCO.ctstrsVO.INSTRUCTIONS4", "trxMgntCO.ctstrsVO.INSTRUCTIONS2",
                                                	 "trxMgntCO.ctstrsVO.INSTRUCTIONS1", "trxMgntCO.ctstrsVO.INSTRUCTIONS3",
                                                	 "trxMgntCO.ctstrsVO.TO_TRS_AC_CIF", "trxMgntCO.ctstrsVO.TO_ACC_ADD_REF",
                                                	 "trxMgntCO.ctstrsVO.SO_TO_DAY", "trxMgntCO.ctstrsVO.SO_FROM_DAY", "trxMgntCO.ctstrsVO.TO_TRS_AC_SL",
                                                	 "trxMgntCO.ctstrsVO.TO_TRS_AC_CIF", "trxMgntCO.ctstrsVO.TO_TRS_AC_GL",
                                                	 "trxMgntCO.ctstrsVO.TO_TRS_AC_CY", "trxMgntCO.ctstrsVO.TO_TRS_AC_BR","trxMgntCO.ctstrsVO.VALUE_DATE",
                                                	 "trxMgntCO.ctstrsVO.RELEASE_DATE", "trxMgntCO.ctstrsVO.REMITTANCE_FR_NUM",
                                                	 "trxMgntCO.ctstrsVO.SO_REFERENCE", "trxMgntCO.ctstrsVO.REMITTANCE_TO_NUM",
                                                	 "trxMgntCO.ctstrsVO.BENEF_NAME", "trxMgntCO.ctstrsVO.BENEF_ACC", "trxMgntCO.ctstrsVO.BENEF_BANK_NAME",
                                                	 "trxMgntCO.ctstrsVO.BENEF_ADDRESS", "trxMgntCO.ctstrsVO.BENEF_BANK",
                                                	 "trxMgntCO.ctstrsVO.BENEF_ADDRESS_2", "trxMgntCO.ctstrsVO.BENEF_ADDRESS_3",
                                                	 "overdraftSettlBtnId","trxFxDealBtnId",
                                                	 "trxMgntCO.ctstrsVO.BENEF_BANK_BIC_CODE","trxMgntCO.ctstrsVO.INTERM_BANK_BIC",
                                                	 "trxMgntCO.ctstrsVO.FACILITY_NO",
                                                	 "trxMgntCO.t_instr_avail_qty_ht",
                                                	 "trxMgntCO.t_instr_avail_qty_vault",
                                                	 "trxMgntCO.ctstrsVO.REMITT_CY",
                                                	 "trxMgntCO.ctstrsVO.TRX_TYPE",
                                                 	 "trxMgntCO.ctstrsVO.DATE_REQUESTED",
                                                	 "trxMgntCO.ctstrsVO.TRS_NO",
                                                	 "trxMgntCO.avail_bal",
                                                	 "trxMgntCO.id_typeDesc",
                                                	 "trxMgntCO.depositer_nationality_desc"
                                                	 ,"trxMgntCO.ctstrsVO.AMOUNT"
                                                	 ,"trxMgntCO.ctstrsBREAKDEPVO.TAX_FC"
                                                	 /* INDI150072 */
                                                	 ,"trxMgntCO.ctstrsExtendedVO.DEBIT_VDATE"
                                                	 ,"trxMgntCO.ctstrsVO.INTERM_BANK"
                                                	 ,"trxMgntCO.ctstrsVO.INTERM_BANK_NAME"
                                                	 ,"trxMgntCO.ctstrsVO.INTERM_BANK_BIC"
                                                	 , "trxMgntCO.ctstrsVO.INTERM_BANK_BR"
                                                	 ,"trxMgntCO.ctstrsVO.INTERM_BANK_ACC", "trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS"
                                                	 ,"trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS_1", "trxMgntCO.ctstrsVO.INTERM_BANK_ADDRESS_2"
                                                	 ,"trxMgntCO.ctstrsExtendedVO.UETR", "trxMgntCO.ctstrsExtendedVO.BIRTH_DATE"
                                                	 ,"trxMgntCO.ctstrsExtendedVO.NARRATION","trxMgntCO.ctstrsVO.BENEF_BANK_ACC"  
                                                	 ,"trxMgntCO.ctstrsVO.BENEF_BANK_BR"
                                                	 ,"trxMgntCO.synthesisStatusDesc",
                                                	 "trxMgntCO.ctstrsExtendedVO.DEPOSITOR_CUST_RELATIONSHIP",
                                                	 "trxMgntCO.ctstrsExtendedVO.DEPOSIT_PURPOSE",
                                                	 "trxMgntCO.ctstrsExtendedVO.DEPOSIT_SOURCE",
                                                	 "trxMgntCO.ctstrsExtendedVO.DEPOSIT_SRC_DOCS_AVAIL_YN"	    
                                                     );
    
    
    /**
     * A static hashMap for Transaction Status Management ...
     */
    private static final String STATUS_CREATED       = "0_C";
    private static final String STATUS_MODIFIED      = "0_M";
//    private static final String STATUS_REACTIVATED   = "0_R";
    private static final String STATUS_APPROVED      = "0_P";
    private static final String STATUS_REVERSED_VOIDED = "0_RV";
    //TP 804206 Srikumar
    private static final String STATUS_VERIFIED = "0_F";
    
    public static final List<String> trxMgntStatusLst = new ArrayList<String>();
    static{
	trxMgntStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
	trxMgntStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED");
	trxMgntStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",DATE_MODIFIED");
	trxMgntStatusLst.add("CANCELED_BY,"+STATUS_CANCEL+",DATE_CANCELED");
	trxMgntStatusLst.add("TO_CANCEL_BY,"+STATUS_TO_CANCEL+",TO_CANCEL_DATE");
	trxMgntStatusLst.add("TO_BE_RETURNED_BY,"+STATUS_TO_RETURN+",DATE_TO_BE_RETURNED");
	trxMgntStatusLst.add("TO_REVERSE_BY,"+STATUS_TO_REVERSE+",TO_REVERSE_DATE");
	//trxMgntStatusLst.add("REVERSED_BY,"+STATUS_REVERSE+",DATE_REVERSED");
	trxMgntStatusLst.add("TO_RELEASE_BY,"+STATUS_TO_BE_RELEASED+",TO_RELEASE_DATE");
	//trxMgntStatusLst.add("CLEARED_BY,"+STATUS_RELEASED+",DATE_CLEARED");
	trxMgntStatusLst.add("CLEARED_BY,"+STATUS_TO_BE_CLEARED+",DATE_CLEARED"); // Done as per PowerBuilder
	trxMgntStatusLst.add("CLEAR_AUTH_BY,"+STATUS_CLEARED+",DATE_CLEAR_AUTH");
	trxMgntStatusLst.add("TO_BE_STOPPED_SO_BY,"+STATUS_TO_STOP_SO+",TO_BE_STOPPED_SO_DATE");
	trxMgntStatusLst.add("STOPPED_SO_BY,"+STATUS_STOPPED_SO+",STOPPED_SO_DATE");
	trxMgntStatusLst.add("TO_BE_CLOSED_SO_BY,"+STATUS_TO_CLOSE_SO+",TO_BE_CLOSED_SO_DATE");
	trxMgntStatusLst.add("CLOSED_SO_BY,"+STATUS_CLOSED_SO+",CLOSED_SO_DATE");
	trxMgntStatusLst.add("REACTIVATED_SO_BY,"+STATUS_TO_REACTIVATE_SO+",REACTIVATED_SO_DATE");
	//trxMgntStatusLst.add("APPROVE_REACTIVATE_SO_BY,"+STATUS_TO_REACTIVATE_SO+",APPROVE_REACTIVATE_SO_DATE");

	//TP 804206 Srikumar
	trxMgntStatusLst.add("VERIFIED_BY,"+STATUS_VERIFIED+",DATE_VERIFIED");
	trxMgntStatusLst.add("AUTH_BY,"+STATUS_APPROVED+",DATE_AUTH");
	trxMgntStatusLst.add("REJECTED_BY,"+STATUS_REJECT+",DATE_REJECTED");
	trxMgntStatusLst.add("PROCESSED_BY,"+STATUS_PROCESSED+",DATE_PROCESSED");
	/**
	 * STATUS FROM CTSTRS_STATUSLOG...
	 */
	trxMgntStatusLst.add("CLEAR_INPROCESS_BY,"+STATUS_CLEAR_IN_PROCESS+",DATE_CLEAR_INPROCESS");
	trxMgntStatusLst.add("CLEAR_INPROCESS_AUTH_BY,"+STATUS_CLEARED+",DATE_CLEAR_INPROCESS_AUTH");
	trxMgntStatusLst.add("TO_REVERSE_CLEARED_BY,"+STATUS_CLEAR_IN_PROCESS+",TO_REVERSE_CLEARED_DATE");
	trxMgntStatusLst.add("REVERSE_CLEARED_BY,"+STATUS_APPROVE+",REVERSE_CLEARED_DATE");
	
	trxMgntStatusLst.add("TO_VOID_BY,"+STATUS_TO_BE_VOIDED+",TO_VOID_DATE");
	trxMgntStatusLst.add("REVERSED_BY,"+STATUS_REVERSED_VOIDED+",DATE_REVERSED");
	
    }  
    
    public static final String STATUS_APPLY_REACTIVATE_REMITTANCE 	= "ARR";
    public static final String STATUS_APPROVE_REACTIVATE_REMITTANCE 	= "RR";
    public static final String STATUS_REJECT_ALERT 			= "RJ";
    
    public static final String REJECT_OPT      = "D001RJ";
    public static final String TO_STOP_SO_OPT  = "D001TS";
    public static final String TO_CLOSE_SO_OPT = "D001TCL";    
    public static final List<String> crudStsReasonList = Arrays.asList(CRUD_REJECT,CRUD_TO_BE_STOPPED_SO,CRUD_TO_BE_CLOSED_SO);
    
    public static final String CLEARING_CHEQUE_STATUS = "L";
    
    // Transaction Progref extensions
    public static final String PROG_REF_EXT_RO 		= "RO";
    public static final String PROG_REF_EXT_CN 		= "CN";
    public static final String PROG_REF_EXT_RV 		= "RV";
   // public static final String PROG_REF_EXT_L 		= "L";
    public static final String PROG_REF_EXT_RH 		= "RH";
    public static final String PROG_REF_EXT_VO 		= "VO";
    public static final String PROG_REF_EXT_OD 		= "OD";
    public static final String PROG_REF_EXT_VC 		= "VC";
    public static final String PROG_REF_EXT_SO3SS 	= "SO3SS";
    public static final String PROG_REF_EXT_SS 		= "SS";
    public static final String PROG_REF_EXT_S03CL 	= "S03CL";
    public static final String PROG_REF_EXT_CL 		= "CL";
    public static final String PROG_REF_EXT_RCO 	= "RCO";
    public static final String PROG_REF_EXT_ARS 	= "ARS";
    public static final String PROG_REF_EXT_RR 		= "RR";
    //public static final String PROG_REF_EXT_P 	= "P";
    public static final String PROG_REF_EXT_AU 		= "AU";
    
    //List of pageRef related to STAND ORDER screens
    public static final List<String> SoOptList = Arrays.asList("SO3MT","SO3RJ","SO3AU","SO3WV","SO3RV","SO3PT","SO3SS","SO3RS","SO3ARS","SO3AS","SO3TS","SO3TCL","SO3CL");
    public static final String ERROR_OVD 		= "OVD";
    public static final String ERROR_6 			= "6";
    public static final String NOT_EXIST_CONDITION 	= "NOT_EXISTS";
    
    
    //Special Condition
    public static final String SPECIAL_COND_FILL_INVERT 	= "INVERT";
    public static final String SPECIAL_COND_FILL_BOTH      	= "BOTH";
    public static final String SPECIAL_COND_FILL_FROM      	= "FROM";
    public static final String SPECIAL_COND_FILL_TO      	= "TO";
    public static final String SPECIAL_COND_FILL_CHARGE_FROM   	= "CHARGE FROM";
    public static final String SPECIAL_COND_FILL_MUTLI_TO      	= "MULTI TO";
    
    //entries
    public static final String ONLY_PASS_CHARGES_ENTRIES      			= "C";
    public static final String PASS_BOTH_CHARGES_AND_NORMAL_ENTRIES      	= "B";
    public static final String PASS_NORMAL_ENTRIES_WITHOUT_CHARGES      	= "E";
    
    //Bulk Remittance Type
    public static final BigDecimal ISSUE_MULTIPLE_INSTRUMENTS_THROUGH_ONE_DEBIT     = BigDecimal.ONE;
    public static final BigDecimal ISSUE_ONE_INSTRUMENT_THROUGH_MULTI_DEBITS        = BigDecimal.valueOf(2);
    public static final BigDecimal DEPOSITING_ONE_INSTRUMENT_IN_MULTIPLE_ACCOUNTS   = BigDecimal.valueOf(3);
    public static final BigDecimal DEPOSITING_MULTIPLE_INSTRUMENTS_IN_ONE_ACCOUNT   = BigDecimal.valueOf(4);
    
    //batch management
    public static final String EXISTING_BATCH = "E" ; 
    public static final String NEW_BATCH = "N" ;
    public static final String SO_MODIFY_TO_DAY = "1";
    
    //print advice
    public static final String PRINT_CONF_LANG_CIF = "C";
    public static final String PRINT_CONF_LANG_PROMPT = "P";
    public static final String PRINT_CONF_LANG_LATIN = "L";
    public static final String PRINT_CONF_LANG_ARAB = "A";
    public static final String PRINT_ADVICE_FROM_MULTI_CHQ = "MULTI_CHQ";
    public static final String PRINT_ADVICE_FROM_TRX = "TRX";
    public static final String PRINT_ADVICE_FROM_BULK_REM = "BULK_REM";
    public static final String ADVICE_SENT_TO_SCREEN = "S";
    public static final String ADVICE_SENT_TO_PRINTER = "P";
    public static final String TRX_RETAIL_CREDIT_DEBIT_ADVICE = "RETADV";
    public static final String TRX_RETAIL_MULTI_TRSFR_ADVICE = "RETMADV";
    
    public static final String TRANSFER_CR_REPORT_CALLBACK = "transferCrReportCallBack";
    public static final String TRANSFER_DR_REPORT_CALLBACK = "transferDrReportCallBack"; 
    public static final String MULTI_TRSFR_REPORT_CALLBACK = "multiTrsfrReportCallBack"; 
    public static final String ADD_ADVICE_TRX_REPORT_CALLBACK = "addAdviceTrxReportCallBack"; 
    public static final String ADD_ADVICE_MULTI_CHQ_REPORT_CALLBACK = "addAdviceMultiChqReportCallBack";
    public static final String ADD_ADVICE_BULK_REMIT_REPORT_CALLBACK = "addAdviceBulkRemitReportCallBack";
    public static final String WARNING_LETTER_REPORT_CALLBACK = "warningLetterReportCallBack"; 
    public static final String TRANSFER_FROM_REPORT_CALLBACK = "transferFromReportCallBack"; 
    public static final String TRANSFER_TO_REPORT_CALLBACK = "transferToReportCallBack"; 
    public static final String TRX_REPORT_CALLBACK = "trxReportCallBack";
    
    // Money laundring periodicity - Current Transaction Only
    // NABIL FEGHALI - SRS IIAB120051
    public static final String TRX_ML_PERIODICITY_CURRENT = "C";
    
    //TONY NOUH PATH120072 CTSTRXTYPE.ALLOW_REVERSE_LINKED_TRX
    public static final String PROCEED_WITHOUT_WARNING = "P";
    public static final String WARN_AND_STOP = "S";
    public static final String WARN_AND_PROCEED = "W";
    
    public static final String RETRIEVE_ACTION_STR = "retrieve";
    
    public static final String OUTSTANDING_PROFIT_QUERY_SCREEN_SRC = "outStandingProfitQueryScreenSrc";
    public static final String CLOSED_DORMANT_ACCOUNTS_SCREEN_SRC = "closedDormantAccountsScreenSrc";
    
    //Guitta for Channels and services
    public static final String CHANNEL_ATM 	= "ATM";
    public static final String CHANNEL_ATM_CRUD = "TM";
    
    //NABIL FEGHALI - IIAB110237 - SOA Charges
    public static final String SOA_REPORT_BYTES	= "SOA_REPORT_BYTES";
    public static final String SOA_WATERMARK_REPORT_BYTES = "SOA_WATERMARK_REPORT_BYTES";
    public static final String DEFAULT_CHARGES_IN_TRX = "DEFAULT_CHARGES_IN_TRX";
    
    // Sarah - BB140191 - Integration between card reader device and transaction screen
    public static final String ID_CARD_TYPE_PACI = "4";

    //Jihane TP82894 - IIAB080110 - Dues available balance;
    //TONY NOUH User Story#315732 AMANA130105 Overdraft Products
    public static final String LOG_DUES = "<LOG_DUES>" ;
    public static final String LOG_DUES_WITHOUT_TRX = "<LOG_DUES_WITHOUT_TRX>" ;
    public static final String ALERT_OVER_DRAWN_AMT = "<ALERT_OVER_DRAWN_AMT>" ;
    public static final String ALERT_IIS_OVERDUE_INST = "<ALERT_IIS_OVERDUE_INST>" ;

    //DASI170044 - Cheque Certification [mfalha]
    public static final String TERMINATION_OF_CERTIFICATION		= "C";
    //DASI170044 - Cheque Certification [mfalha]
    
//    // List of all Constant OPTs for Transaction Screen
    public static final List<String> allOptsList = new ArrayList<String>();
    static{
	allOptsList.add("D001MT");
	allOptsList.add("D001@");
	allOptsList.add("D001RJ");
	allOptsList.add("D001AU");
	allOptsList.add("D001WV");
	allOptsList.add("D001RV");
	allOptsList.add("D001PT");
	allOptsList.add("D001KL");
	allOptsList.add("D001RH");
	allOptsList.add("D001OD");
	allOptsList.add("D001ODA");
	allOptsList.add("D001CE");
	allOptsList.add("D001RE");
	allOptsList.add("D001ZN");
	allOptsList.add("D001CN");
	allOptsList.add("D003RE");
	allOptsList.add("D001E");
	allOptsList.add("D001VO");
	allOptsList.add("D001SS");
	allOptsList.add("D001RS");
	allOptsList.add("D001ARS");
	allOptsList.add("D001AS");
	allOptsList.add("D001TS");
	allOptsList.add("D001TCL");
	allOptsList.add("D001CL");
	allOptsList.add("D001ARCO");
	allOptsList.add("D001RCO");
    }

    public static final String CASH_DEDUCT_INDICATOR  			= "CASH_DEDUCT_INDICATOR"; //TP234438
    // modified by nancy -- 05/07/2018-- 382769-- acoount limits
    public static final String OBLIGOR_CONFIRMATION			= "OBLIGOR_CONFIRMATION";
    public static final String CONFIRMATION_MESSAGE			= "CONFIRMATION_MESSAGE";
    // end nancy 
    
    
    public static final String APPEND_CRUD_CLOSE_ACC     	     	= "CA";
    public static final String APPEND_CRUD_REACTIVATE_ACC	     	= "RA";
    
    public static final String LOCK_ACCOUNTS	     	= "L";
    public static final String UNLOCK_ACCOUNTS	     	= "U";
    
    
    // Defaulting fields upon linking - #336304 - INDI150065 - Indevco Forward FX 13/10/2015
    public static final String LINKED_TRX_NOT_APPLICABLE = "N";
    public static final String LINKED_TRX_DEFAULT_VALUE_DATE = "V";
    public static final String LINKED_TRX_DEFAULT_EXCH_RATE = "E";
    public static final String LINKED_TRX_DEFAULT_BOTH = "B";
    
    public static final String ENTITY_PRODUCT_NAME_TRX_SO = "TRX_TYPE_SO";
    
    public static final BigDecimal LOV_VDATE_AMENDMENT_LOV_ID	= BigDecimal.valueOf(646);
    public static final String STATUS_VDATE_ACTIVE	= "A";
    public static final String STATUS_VDATE_PRCOESSED	= "P";
    
    public static final String SKIP_OBLIGOR_CHECKING = "SKIP_OBLIGOR";
    
    public static final String DELETE_FX_DEAL_UTILIZATION = "V";
    public static final String UPDATE_FX_DEAL_UTILIZATION = "P"; 
    public static final String TRX_UPDATE_FUNCTION			= "1";//Raed Saad - AMANA140004
    public static final String TRX_APPROVE_FUNCTION			= "2";//Raed Saad - AMANA140004
    public static final String OPT_BLACKLIST_LOG  = "BL001BLL";
    public static final String BLACK_LIST_LOG = "BLACK_LIST_LOG";
    public static final String  BLACKLIST_LOG_COMPLIANCE_ACTION = "BLACKLIST_LOG_COMPLIANCE_ACTION";

    public static final String CHEQUE_COLLECTED				= "Q";

    public static final String DOCUMENT_TYPE_BILLS  = "B";
    public static final String DOCUMENT_TYPE_CHEQUES = "C";
    public static final String DOCUMENT_TYPE_NOT_APPLICABLE = "N";


    public static final String TRX_AVA_PAYMENT 				= "P";
    public static final String TRX_AVA_RETURN_PAYMENT			= "R";

    public static final String STATUS_VALIDATED = "V";
    public static final String STATUS_NOT_VALIDATED = "N";
    public static final List<String> trxMgntSynthesisStatusLst = new ArrayList<String>();
    static
    {
	trxMgntSynthesisStatusLst.add("CREATED_BY,"+STATUS_VALIDATED+",CREATED_DATE");
	trxMgntSynthesisStatusLst.add("DELETED_BY,"+STATUS_NOT_VALIDATED+",DATE_DELETED");
    }  
    
    //Hala Al Sheikh - AIBI180007
    public static final String REJECTED_BLOTTER_TRX = "R";
    public static final String TIME_OUT_BLOTTER = "N";
    public static final String APPROVED_BLOTTER = "P";
    public static final String ACTIVE_BLOTTER = "A";
    public static final String UPDATED_BLOTTER = "U";
    //End Hala


}
