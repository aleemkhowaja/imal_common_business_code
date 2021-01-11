package com.path.bo.core.csmfom;

import java.math.BigDecimal;

public class NCifMaintenanceConstant
{
    public static final String CIF_INACTIVE_STATUS 	= "I";
    
    /** VALIDATE_CID */    
    public static final String VALIDATE_CID_TRUE	= "1";
    public static final String VALIDATE_CID_FALSE	= "0";
    
    /** JOINT_ACCOUNTS */
    public static final String IS_JOINT_ACCOUNTS	= "1";
    public static final String NOT_JOINT_ACCOUNTS	= "0";
    
    /** type of CIF bank or not */
    public static final String CIF_NOT_BANK 	= "N";
    public static final String CIF_IS_BANK 	= "Y";
    /** type of CIF client or not */
    public static final String CIF_IS_CLIENT 	= "Y";
    public static final String CIF_NOT_CLIENT 	= "N";
    
    /** type of CIF is individual  or institution */
    public static final String CIF_IS_INSTITUTION 	= "T";
    public static final String CIF_IS_INDIVIDUAL 	= "V";
    
    /** type of CIF is individual  or institution */
    public static final String CIF_IS_STAFF	= "1";
    public static final String CIF_IS_NOT_STAFF 	= "0";
    
    
    /** Categories of the CIF*/
    public static final String CATEGORY_ALL 	      = "A";
    public static final String CATEGORY_POTENTIEL 	= "P";
    public static final String CATEGORY_CLIENT 	        = "C";
    public static final String CATEGORY_NEITHER 	= "N";
    /** if the value of types in ID_TYPE equal 1 then civil_id*/
    public static final int CIVIL_ID 	= 1;
    
    /** ID CARD TYPE */
    public static final String ID_CARD_TYPE_Not_Applicable 	= "0";
    public static final String ID_CARD_TYPE_MyKid 		= "1";
    public static final String ID_CARD_TYPE_MyKad 		= "2";
    public static final String ID_CARD_TYPE_IDCardReader 	= "3";
    public static final String ID_CARD_TYPE_PACI 		= "4";
    public static final String ID_CARD_TYPE_NID 	= "5";
   
    /**
     * Status of CIF
     */
    public static final String CIF_INACTIVE		= "I";
    public static final String CIF_ACTIVE		= "A";
    public static final String CIF_SUSPENDED		= "S";
    public static final String CIF_DELETED		= "D";
    public static final String CIF_COMPLETED		= "C";
    public static final String CIF_DRAFT		= null;
  
    
   
    public static final String CIF_DRAFT_DESCRIPTION		= "F";
    // max cif no
    public static final BigDecimal MAX_CIF_NO		= new BigDecimal(99999999);
    
    /*
     * Uniqueness Options
     */
    public static final String   UNIQUNESS_DISABLED	 = "0";
    public static final String   UNIQUNESS_ALLOW_PROCEED = "1";
    public static final String   UNIQUNESS_ENABLED	 = "2";
    
    //public static FIELDS_NOT
    
    /**
     * Mode of communucation of CIF
     */
    public static final String MODE_COMM_POBOX		= "P";
    public static final String MODE_COMM_EMAIL	        = "E"; 
    public static final String MODE_COMM_SMS	        = "S"; 
    public static final String MODE_COMM_FAX	        = "F"; 
    public static final String MODE_COMM_D	        = "D"; 
    
    
    /**
     * RESIDENT column in CIF table
     */
    public static final String IS_RESIDENT			= "R";
    public static final String NON_RESIDENT			= "S";
  
    
    /**
     * Language column in CIF table
     */
    public static final String BOTH_LANGUAGE			= "B";
    public static final String LATIN_LANGUAGE			= "L";
    public static final String ARABIC_LANGUAGE			= "A";
    
   /**
    * cif teller acces
    */
   
    public static final Integer	MAIN_INFORMATION	        = 1;
    public static final Integer	NAME_ADDRESS	                = 2;
    public static final Integer	ADDITIONAL_DETAILS	        = 3;
    public static final Integer	CONTACTS	                = 4;
    public static final Integer	FUND_TRANSFER	                = 5;
    public static final Integer	CIF_BIC_CODE	                = 6;
    public static final Integer	ADDITIONAL_FIELDS	        = 7;
    public static final Integer	NAME_DETAILS	                = 8;
    public static final Integer	PASSPORT_INFO	                = 9;
    public static final Integer	MORE_DETAILS	                = 10;
    public static final Integer	TRANSACTION_TRENDS	        = 11;
    public static final Integer	BUSINESS_NATURE    	        = 12;
    public static final Integer	TRX_TYPE_LIMITS	                = 13;
    public static final Integer	MORE_ADDRESSES	                = 14;
    public static final Integer	OCCUPATION	                = 15;
    public static final Integer	EDUCATION	                = 16;
    public static final Integer	MORE_BANKS	                = 17;
    public static final Integer	CLEARING_HOUSE_DETAILS	        = 18;
    public static final Integer	MORE_CONTACTS    	        = 19;
    public static final Integer	MORE_OFFICERS	                = 20;
    public static final Integer	SCAN	                        = 21;
    public static final Integer	OTHER_FINANCIAL_ENGAGEMENTS	= 22;
    public static final Integer	EDIT_CIF_BANK_DETAILS	        = 23;
    public static final Integer	GET_CIF_RELATED_ACCOUNTS	= 24;
    public static final Integer	CASH_FLOW_SOURCES	        = 25;
    public static final Integer	PRIORITY_CODE	                = 26;
    public static final Integer	E_MAIL                         	= 27;
    public static final Integer	COUNTRY	                        = 28;
    public static final Integer	GENDER	                        = 29;
    public static final Integer	NATIONALITY	                = 30;
    public static final Integer	REGION_CODE	                = 31;
    public static final Integer	RESIDENT	                = 32;
    public static final Integer	CIF_TYPE	                = 33;
    public static final Integer	MARITAL_STATUS	                = 34;
    public static final Integer	BIRTH_DATE	                = 35;
    public static final Integer	ID_REGISTRATION_NUM	        = 36;
    public static final Integer	TYPE	                        = 37;
    public static final Integer	LANGUAGE	                = 38;
    public static final Integer	TELEPHONE	                = 39;
    public static final Integer	POSTAL_ZIP_CODE             	= 40;
    public static final Integer	CIF_BRIEF_NAME_ENG	        = 41;
    public static final Integer	CIF_BRIEF_NAME_ARAB	        = 42;
    public static final Integer	CIF_LONG_NAME_ENG	        = 43;
    public static final Integer	CIF_LONG_NAME_ARAB	        = 44;
    public static final Integer	ARABIC_ADDRESS_LINE_1	        = 45;
    public static final Integer	ARABIC_ADDRESS_LINE_2	        = 46;
    public static final Integer	ARABIC_ADDRESS_LINE_3	        = 47;
    public static final Integer	ENG_ADDRESS_LINE_1	        = 48;
    public static final Integer	ENG_ADDRESS_LINE_2	        = 49;
    public static final Integer	ENG_ADDRESS_LINE_3	        = 50;
    public static final Integer	CIF_LIMIT_SCHEMA	        = 51;
    public static final Integer	CIF_JOINT_DET	                = 52;
    public static final Integer	VOID_REASON_CHARGES	        = 53;
    public static final Integer	TRANSACTION_TYPE_CHARGES	= 54;
    public static final Integer	BALANCE_LIMIT	                = 55;
    public static final Integer	PACKAGE                  	= 56;
    public static final Integer	POLICY_TREATMENT	        = 57;
    public static final Integer	ID_DETAILS	                = 58;
    public static final Integer	MAX_CIF_USER_ACCES	        = 58;
    public static final Integer	EXPOSURE_LIMIT	        	= 59;
    public static final Integer	FATCA	        		= 60;
    public static final Integer	REAL_BENEFICIARIES	        = 63;
    public static final Integer	TRANSACTION_DETAILS	        = 66;
    public static final Integer	EXCLUDE_VAT	        	= 67;
    public static final Integer	ADD_NATIONALITIES  	        = 68;
    public static final Integer	MARKTED_BY  	        	= 77;
    public static final Integer	BVN_DETAILS  	                = 69;
    public static final Integer	SEGMENT		        	= 70;
    public static final Integer	POLITICALLY_EXPOSED		= 75;
    public static final Integer	FINANCIAL_IN_OUT_FLOWS 	        = 69;
    public static final Integer	CIF_PRODUCTS 	                = 71;
    public static final Integer	IRIS_ENROLLMENT	                = 72;
    public static final Integer	MEMBER_DETAILS	                = 73;
    
    //teller Permession for all FOM
    public static final String	ALLOW_TO_MODIFY_CIF_ON	        = "Y";
    public static final String	ALLOW_TO_MODIFY_CIF_OFF	        = "N";
    
    
    public static final Integer	CIF_IS_BLACKLISTED                            = 1381;
    public static final Integer	CIF_HAS_MORE_THREE_RETURNED_CHEQUES           = 31328;
    //division
    public static final String DIV_IS_MANDATORY_ON="Y";
    public static final String DIV_IS_MANDATORY_OFF="N";
   //departmenet
    public static final String DEP_IS_MANDATORY_ON="Y";
    public static final String DEP_IS_MANDATORY_OFF="N";
    //
    
   //Salutation
    public static final String SALUTATION_IS_MANDATORY_ON="1";
    public static final String SALUTATION_IS_MANDATORY_OFF="0";
    //
    
   //Card 
    public static final String CARD_NAME_MANDATORY_ON  = "1";
    public static final String CARD_NAME_MANDATORY_OFF = "0";
    //
    //ID_TYPES ID_TYPE_MAND_YN
    public static final String	ID_TYPE_MAND_YN_YES = "1";
    public static final String	ID_TYPE_MAND_YN_NO  = "0";
    
    
   //Teller(CTSTELLER)
    public static final String CHECK_ROLE_ON="Y";
    public static final String CHECK_ROLE_OFF="N";
    
    public static final String CIF_RESERVED_NO_ON="1";
    public static final String CIF_RESERVED_NO_OFF="0";
    
    
    public static final String ACCESS_ALLOWED_ON="Y";
    public static final String ACCESS_ALLOWED_OFF="N";
    //AFFECT_MONEY_LAUNDRING
    public static final String AFFECT_MONEY_LAUNDRING_ON="1";
    public static final String AFFECT_MONEY_LAUNDRING_OFF="0";
    //SHOW_CB_SECRETNUM_ON (RIFCTT)
    public static final String SHOW_CB_SECRETNUM_ON="1";
    public static final String SHOW_CB_SECRETNUM_OFF="0";
    
    
    
    //PASSPORT_NO_MAND from CIFCONTROL
    public static final String PASSPORT_NO_MAND_ON = "1";
    public static final String PASSPORT_NO_MAND_OFF = "0";
   //PASSPORT_NO_MAND from RIFCTT(CIF TYPE SCREEN)
    public static final String PASSPORT_MANDATORY_ON = "Y";
    public static final String PASSPORT_MANDATORY_OFF = "N";
    
    public static final String LEGAL_STATUS_MAND_ON = "1";
    public static final String LEGAL_STATUS_MAND_OFF = "0";
    
    //
    public static final String POBOX_MANDATORY_ON = "1";
    public static final String POBOX_MANDATORY_OFF = "0";
    
    public static final String POSTAL_MANDATORY_ON = "1";
    public static final String POSTAL_MANDATORY_OFF = "0";
    //
    
    
    
    //CifControlVO suspend account
    public static final String      SUSPEND_ACC_NOT_APPLICABLE = "0"; 	//0-Not Applicable
    public static final String      SUSPEND_ACC_ANY_BANK_MODIF = "1";	//1-Upon Bank Details Modification 
    public static final String      SUSPEND_ACC_ANY_MODIF      = "2";	//2-Upon Any Modification
    
    
    
    
    //ALLOW_CHANGE_IDTYPE
    public static final String    ALLOW_CHANGE_IDTYPE_ON = "1";
    public static final String    ALLOW_CHANGE_IDTYPE_OFF = "0";
    
    
    //KYC
    public static final String    KYC_COMPLETED = "Y";
    public static final String    KYC_OUTSTANDING= "N";
    public static final String    KYC_REJECTED = "J";
    public static final String 	  KYC_COMPLETED_BY_CALL = "C";
    public static final String    KYC_RECALCITRANT		= "R";
    public static final String    KYC_NOT_REQUIRED		= "P";
    //KYC mandatory
    public static final String    ALLOW_KYC_NOT_COMPLETED_ON = "1";
    public static final String    ALLOW_KYC_NOT_COMPLETED_OFF = "0";
    
    public static final String 	  MAIL_STMT_YES	= "Y";
    public static final String 	  MAIL_STMT_NO	= "N";
    public static final String 	  MAIL_STMT_HOLD	= "H";
    
    //BIC CODE
    
    public static final Integer 	  ELEVEN	= 11;
    public static final Integer 	  TWELVE	= 12;
    
    //population
    public static final Integer 	   POPULATE_ALL_COMPANIES	= 0;
    public static final Integer 	    CIF_POPULATION_COMPANIES	= 1;
   //rang population
    public static final Integer 	   RANGE_1	= 1;
    public static final Integer 	   RANGE_2	= 2;
    public static final Integer 	   RANGE_3	= 3;
    
  //overriding population
    public static final Integer 	   OVERRIDING_POPULATION	= 2; 
    
    public static final Integer 	   CHANGE_STATUS_TO_SUSPEND_ON	= 1;
    public static final Integer 	   CHANGE_STATUS_TO_SUSPEND_OFF	= 0; 
    
    //issue card
    public static final String   ISSUE_CARD_ON = "1";
    public static final String   ISSUE_CARD_OFF= "0";
    
    public static final String   VALIDATE_CIF_ID_INPUT_UPDATE= "I";
    public static final String   VALIDATE_CIF_ID_UPDATE= "U";
    
    //fboukarroum 82940 - AMANA110094 - Alpha - Numeric characters in FOM - MORE CONTACT - ID field
    public static final String DEFAULT_DATA_TYPE="0";
    public static final String ALPHA_DATA_TYPE="1";
    public static final String NUMERIC_DATA_TYPE="2";
    public static final String ALPHA_NUMERIC_DATA_TYPE="3";
	
    //IIAB100318 [John Massaad]
    public static final String COLUMN_NAME_BRANCH ="branch";
    public static final String COLUMN_NAME_SEQUENCE ="seq";
    public static final String COLUMN_NAME_ANY = "any";
    
    public static final String ADDRESS_DETAILS_MAX_LENGTH = "23";

    //AMF STAUS CLOSED/APPROVED CLOSED
    public static final String CLOSED_APPROVED_CLOSED = "'C','M','R'";
    
    //Hala Al Sheikh - BIPL180103
    public static final String DONT_PROCEED_ON_BLACKLISTED_CIF = "0";
    public static final String WARN_PROCEED_ON_BLACKLISTED_CIF = "1";
    public static final String FOM_OWNERSHIP_BLKLLIST = "FOM_OWNERSHIP_BLKLLIST";
    public static final String FOM_OCCUPATION_BLKLLIST = "FOM_OCCUPATION_BLKLLIST";
    public static final String FOM_MORE_SIG_BLKLLIST = "FOM_MORE_SIG_BLKLLIST";
    public static final String FOM_REAL_BENEF_BLKLLIST = "FOM_REAL_BENEF_BLKLLIST";
    public static final String FOM_JOINT_DETAILS_BLKLLIST = "FOM_JOINT_DETAILS_BLKLLIST";
    public static final String FOM_PROXY_BLKLLIST = "FOM_PROXY_BLKLLIST";
    public static final String FOM_OTHER_FIN_ENGAGE_BLKLLIST = "FOM_OTHER_FIN_ENGAGE_BLKLLIST";
    public static final String FOM_BLKLIST_FROM_DEPENDENCY = "D";
    public static final String FOM_BLKLIST_FROM_SAVE = "S";
}
