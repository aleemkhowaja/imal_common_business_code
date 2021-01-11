/**
 * @Auther:Reda Charabaty
 * @Date:11/01/2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2013
 */

package com.path.bo.core.entitycharges;

import java.math.BigDecimal;

public class EntityChargesConstant
{
    // Entity Type
    public static final String ENTITY_LOSTFOUND				= "LOS";
    public static final String ENTITY_CHEQUEBOOK			= "CHQ";
    public static final String ENTITY_PASSBOOK				= "PAS";
    public static final String ENTITY_SAFEBOX				= "SAF";
    public static final String ENTITY_CARDS				= "CAR";
    public static final String ENTITY_EXCHANGE				= "EXC";
    public static final String ENTITY_CERTIFICATE			= "CER";
    public static final String ENTITY_SMS				= "SMS";
    public static final String ENTITY_ACCOUNT				= "ACC";
    public static final String ENTITY_REQUEST				= "REQ";
    public static final String ENTITY_AVA_FILE				= "AVA";
    public static final String ENTITY_ADD_PAYMENT			= "ADP";
    public static final String ENTITY_INCIDENT				= "INC";
    
    //Base Foreign
    public static final String BASE_CURRENCY				= "B";
    public static final String FOREIGN_CURRENCY				= "F";
    public static final String CHARGE_PERC				= "C";
    
    //Multiply / Divide Indicator
    public static final String MULTDIV_MULT				= "M";
    public static final String MULTDIV_DIV				= "D";
    
    //Values
    public static final String VALUE_EMPTY				= "";
    public static final String VALUE_ZERO				= "0";
    public static final String VALUE_ONE				= "1";
    
    //Entity Type Indicator
    public static final String TYPEIND_CHEQUEBOOK_CREATE		= "P";
    public static final String TYPEIND_CHEQUEBOOK_APPROVE_DESTROY	= "AD";
    public static final String TYPEIND_CHEQUEBOOK_APPROVE_CANCEL	= "AC";
    public static final String TYPEIND_CHEQUEBOOK_SUBMIT		= "B";
    public static final String TYPEIND_PASSBOOK				= "I";
    public static final String TYPEIND_ALL_DEFAULT			= "C";
    public static final String TYPEIND_CLOSE_TRANSFER			= "CA"; //Rania - DB130089 Close account with transfer

    public static final String TYPEIND_LOSTFOUND_REASON			= "R";
    public static final String TYPEIND_CERTIFICATE_REASON		= "R";
    public static final String TYPEIND_IN_HOUSE_CHARGES			= "H";
    
    //SaveNew or Update
    public static final String SAVEUPDATE_SAVE				= "I";
    public static final String SAVEUPDATE_UPDATE			= "U";
    
    //Charges Booking
    public static final String CHARGES_BOOKING_A			= "A";
    public static final String CHARGES_BOOKING_B			= "B";
    public static final String CHARGES_BOOKING_C			= "C"; //Hala Al Sheikh ABEI190073
    
    //Charges Branch Booking
    public static final String CHARGES_BR_BOOKING_A			= "A";
    
    //Entity Command
    public static final String ENTITY_COMMAND_RT			= "RT";
    public static final String ENTITY_COMMAND_RTM			= "RTM";
    public static final String ENTITY_COMMAND_GEN			= "GEN";
    public static final String ENTITY_COMMAND_CHECKING			= "CHECKING";
    public static final String ENTITY_COMMAND_SBR			= "SBR";
    public static final String ENTITY_COMMAND_DOM			= "DOM";
    public static final String ENTITY_COMMAND_GAMT			= "GAMT";
    public static final String ENTITY_COMMAND_CAR			= "CAR";
    public static final String ENTITY_COMMAND_ACC			= "ACC";
    public static final String ENTITY_COMMAND_USO			= "USO";
    public static final String ENTITY_COMMAND_EXCH			= "EXCH";
    public static final String ENTITY_COMMAND_NORMAL			= "CHQ";
    public static final String ENTITY_COMMAND_OBLIGOR_CONFIRMATION	= "OBLIGOR_CONFIRMATION";
    // modified by nancy -- 10/07/2018-- 382769-- account limits
    public static final String ENTITY_COMMAND_CONFIRMATION_MESSAGE	= "CONFIRMATION_MESSAGE";
    // end nancy 
    public static final String ENTITY_COMMAND_AVA_FILE			= "AVA";
    public static final String ENTITY_COMMAND_ADD_PAYMENT		= "ADP";
    public static final String ENTITY_COMMAND_INCIDENT			= "INC";

    //Charge Detail Type: Charge / Transaction
    public static final String CHARGE_DETAIL_CHARGE			= "C";
    
    //Charges Deduct
    public static final String CHARGES_DEDUCT_BY_CASH			= "1";
    public static final String CHARGES_DEDUCT_BY_ACCOUNT		= "2";
    
    //Exchange Rate
    public static final String RATE_MIDDLE_RATE				= "M";
    public static final String RATE_TRANSFER_BUY_RATE			= "TB";
    
    //Transaction Type
    public static final String TRXTYPE_LOSTFOUND			= "LF";
    public static final String TRXTYPE_CHEQUEBOOK			= "CHQ";
    public static final String TRXTYPE_SAFEBOX				= "SB";
    public static final String TRXTYPE_PASSBOOK				= "PAS";
    public static final String TRXTYPE_CARDS				= "CAR";
    public static final String TRXTYPE_CERTIFICATE			= "CER";
    public static final String TRXTYPE_SMS				= "SMS";
    
    //Instructions
    public static final String INSTRUCTIONS_CHEQUEBOOK			= "CHEQUEBOOK";
    public static final String INSTRUCTIONS_SAFEBOX			= "SAFEBOX";
    public static final String INSTRUCTIONS_CERTIFICATE			= "CERTIFICATE";
    public static final String INSTRUCTIONS_PASSBOOK			= "PASSBOOK";
    public static final String INSTRUCTIONS_CARDS			= "CARD REQUEST";
    public static final String INSTRUCTIONS_SMS				= "SMS SUBSCRIPTION";
    public static final String INSTRUCTIONS_REQUEST			= "REQUEST";
    public static final String INSTRUCTIONS_AVA_FILE			= "AVA FILE";
    public static final String INSTRUCTIONS_ADD_PAYMENT			= "ADD PAYMENT";
    public static final String INSTRUCTIONS_INCIDENT			= "INCIDENT REPORT";
    
    //Reference
    public static final String REFERENCE_LOSTFOUND			= "LF";
    public static final String REFERENCE_CHEQUEBOOK			= "CHQ";
    public static final String REFERENCE_CHEQUEBOOK_CANCEL		= "CHQ_CANCEL";
    public static final String REFERENCE_PASSBOOK			= "PAS";
    public static final String REFERENCE_SAFEBOX			= "SB";
    public static final String REFERENCE_CARDS				= "CD";
    public static final String REFERENCE_CARDS_PREPAID			= "CDP";
    public static final String REFERENCE_CERTIFICATE			= "CER";
    public static final String REFERENCE_CLOSE_ACCOUNT			= "CLOSE ACC";
    public static final String REFERENCE_SMS				= "SMS";
    public static final String REFERENCE_AVA_FILE			= "AVA_FILE";
    public static final String REFERENCE_ADD_PAYMENT			= "ADD_PAYMENT";
    public static final String REFERENCE_INCIDENT			= "INC REP";
    
    //Confirm / Stop
    public static final String CONFIRMSTOP_CONFIRM			= "C";
    public static final String CONFIRMSTOP_STOP				= "S";
    public static final String CONFIRMSTOP_WARN				= "W";
    
    //Product Type Charges
    public static final String ENTITY_TRANSACTION			= "TRX";
    public static final String ENTITY_REASON				= "REA";
    
    //True / False
    public static final String TF_TRUE					= "true";
    public static final String TF_FALSE					= "false";
    
    //dues collection type
    public static final String DUES_COLLECTION_TYPE                     = "N" ;
    
    //Jihane TP82894 - IIAB080110 ; TP82682 ABARI110659 - Dues available balance;
    public static final String DUES_IND				        = "C"; 
    public static final String REFERENCE_REACTIVATE_ACCOUNT		= "Reactivate ACC";
    
    //Charge Branch
    public static final String CHARGE_BRANCH_DEFAULT			= "0";
    public static final String CHARGE_BRANCH_TRX_OR_TELLER		= "1";
    public static final String CHARGE_BRANCH_MAIN_ACCOUNT		= "2";
    public static final String CHARGE_BRANCH_SPECIFIC			= "3";
    
    //SafeBox Constants
    public static final String SAFEBOX_CHARGES_RENTAL			= "R";
    public static final String SAFEBOX_CHARGES_INSURANCE		= "I";
    public static final String SAFEBOX_CHARGES_STAMP			= "S";
    
    
    public static final String TO_BE_CANCELLED_CRUD 			="TC";
    /**
     * Common value for dues, should be in DuesManagementConstant, but called from admin
     */
    public static final BigDecimal PAYMENT_MODE_LOV_TYPE = BigDecimal.valueOf(469);
    public static final BigDecimal DUE_TYPE_LOV_TYPE = BigDecimal.valueOf(468);
    public static final BigDecimal STATUS_LOV_TYPE = BigDecimal.valueOf(451);
}
