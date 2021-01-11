/**
 * @Date:Feb 13, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.csmfom; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;

public final class FomConstant
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private FomConstant(){
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    };

    public static final String  PARENT_OPT 		= "F00I1";
    public static final String  FOM_SCREEN_NAME	  	= "FOM";   
    
    public static final BigDecimal CIF_STATUS_LOV_TYPE        		= BigDecimal.valueOf(32);
    public static final BigDecimal ACCOUNT_STATUS_LOV_TYPE    		= BigDecimal.valueOf(64);
    public static final BigDecimal FATCA_STATUS_LOV_TYPE    		= BigDecimal.valueOf(393);
    public static final BigDecimal CUSTODIAN_TYPE_LOV_TYPE    		= BigDecimal.valueOf(463);
    public static final BigDecimal INTERN_CUSTODIAN_TYPE_LOV_TYPE    	= BigDecimal.valueOf(464);
    public static final BigDecimal POSITION_LOV_TYPE    		= BigDecimal.valueOf(542);
    public static final BigDecimal PAYMENT_CHANNEL_LOV_TYPE    		= BigDecimal.valueOf(580);
    //SBI160329- Modifications at Member details (CIF)-TP:481947
    public static final BigDecimal POLITICALLY_EXPOSED    		= BigDecimal.valueOf(43);  
    public static final BigDecimal SIGNATORY_TYPE    			= BigDecimal.valueOf(1059);  
    public static final BigDecimal SIGN_GRP_LOV_ID			= BigDecimal.valueOf(1072);  
    public static final BigDecimal SIGNATORY_INST			= BigDecimal.valueOf(988);
    public static final BigDecimal PACKAGE_CHARGES_DEDUCT_LOV_TYPE	= BigDecimal.valueOf(21);
    public static final BigDecimal COMPANY_DETAILS_SITUATION_LOV_TYPE   = BigDecimal.valueOf(843); 
    public static final BigDecimal COMPANY_DETAILS_CERTIFIED_LOV_TYPE   = BigDecimal.valueOf(844);
         
    public static final String CIF_DEFAULT_ADDRESS 	= "1";        

    public static final String CIF_STATUS_INACTIVE		= "Inactive";
    public static final String CIF_STATUS_ACTIVE		= "Active";
    public static final String CIF_STATUS_SUSPENDED		= "Suspended";
    public static final String CIF_STATUS_DELETED		= "Deleted";
    public static final String CIF_STATUS_COMPLETED		= "Completed";
    public static final String CIF_STATUS_DRAFT			= "Draft";
    
    public static final String STATUS_ACTIVE		= "A";
    public static final String STATUS_COMPLETED 	= "C";
    public static final String STATUS_DELETED 		= "D";
    public static final String STATUS_TO_CANCEL 	= "N";
    public static final String STATUS_APPROVED 		= "P";
    public static final String STATUS_SUSPENDED 	= "S";
    public static final String STATUS_CREATED       	= "0_C";
    public static final String STATUS_MODIFIED      	= "0_M";
    public static final String STATUS_REINSTATED   	= "0_R";
    public static final String STATUS_INACTIVE		= "I";
    
    //Fatca different statuses used for FATCA Details ( select and business )
    public static final String CIF_FATCA_STATUS_NON_US_ACC_Holder = "1";
    public static final String CIF_FATCA_STATUS_US_ACC_Holder	  = "2";
    public static final String CIF_FATCA_STATUS_INCOMPLETE	  = "3";
    public static final String CIF_FATCA_STATUS_RECALCITRANT	  = "4";
  
    //Fatca different REASON_TYPE used for FATCA Details checking   
    public static final String CIF_FATCA_REASON_TYPE_US_ACC_Holder = "19";
    public static final String CIF_FATCA_REASON_TYPE_DEFAULT	   = "1";
    public static final String FOM_DECEASED_CIF_REASON			   = "32";
    
    // different cif types v for individual and T for institution
    public static final String CIF_INDIVIDUAL_TYPE		= "V";
    public static final String CIF_INSTITUTION_TYPE		= "T";
	
    public static final String GENDER_NA = "NA";
    
    /**
     * KYC Values
     */
    public static final String KYC_COMPLETED		= "Y";
    public static final String KYC_OUTSTANDING		= "N";
    
    public static final String ESTIMATED_INCOME_MONTHS  = "1";
    public static final String ESTIMATED_INCOME_YEARS  =  "2";
    public static final String ESTIMATED_INCOME_OTHERS  = "3";
    
    public static final String FOM_MAINTENANCE_IV_CRUD	= "R";
    public static final String FOM_SUSPEND_IV_CRUD	= "S";
    public static final String FOM_REINSTATE_IV_CRUD	= "A";
    public static final String FOM_APPROVE_IV_CRUD	= "P";
    public static final String FOM_PRINT_CIF_CRUD	= "PC";
    public static final String FOM_PRINT_ACCOUNT_CRUD	= "PA";
    public static final String FOM_QUERIES_IV_CRUD	= "Q";
    /** added by jihad**/
    public static final String LABEL_BIRTH_DATE		= "Date of Birth";
    public static final String LABEL_ESTABLISH_DATE     = "Establishment Date";
    public static final BigDecimal ZERO_BIG            = BigDecimal.ONE;
    public static final String CREATED_FROM            = "C";
    
    
    //Teller Limit Type
    public static final String TELLER_LIMIT_TYPE_CIF_TYPE = "C";
    public static final String TELLER_LIMIT_TYPE_ECO_SECTOR = "E";
    public static final String TELLER_LIMIT_TYPE_PRIORITY = "P";

    //Mode of Stmt Delivery
    public static final String MODE_OF_STMT_DELIVERY_EMAIL = "E";
    
    //rabih
    public static final String SAVE_TYPE_CREATED = "C";
    public static final String SAVE_TYPE_MODIFIED = "M";
    
    public static final String CALLING_MOD_LOAD = "LOAD";
    public static final String CALLING_MOD_ONCHANGE = "CHANGE";
    public static final String CALLING_MOD_UPDATE = "UPDATE";
    public static final String CALLING_MOD_VALIDATE = "VALIDATE";
    
    
    //Added by jihad
    
    public static final String GLOBAL_CONFIRMATION = "GLOBAL_CONFIRMATION";//this is used to identify the exception
    public static final String RESTRICTION_CONFIRMATION = "RESTRICTION_CONFIRMATION";//this is used to identify the exception
    public static final String RESERVED_CIF_CONFIRMATION = "RESERVED_CIF_CONFIRMATION";//this is used to identify the exception
    public static final String ID_NUM_DUPLICATION = "ID_NUM_DUPLICATION";//this is used to identify the exception
    public static final String POPULATE_CIF_CONFIRMATION = "POPULATE_CIF_CONFIRMATION";//this is used to identify the exception
    public static final String BIOMETRIC_APPROVED_CONFIRMATION = "BIOMETRIC_APPROVED_CONFIRMATION";//this is used to identify the exception
    
    public static final String SWIFT_TYPE_MT103 = "1";
    public static final String SWIFT_TYPE_MT103_202COV = "2";
    
    public static final String SWIFT_CHARGE_OUR = "O";
    public static final String SWIFT_CHARGE_SHA = "S";
    
    public static final String ENTITY_TYPE_CHARGE = "C";
    
    public static final String SHOW_CHARGE_ON = "1";
    public static final String SHOW_CHARGE_OFF = "0";
    //CIF black list
    public static final BigDecimal IS_BLACK_LISTED = BigDecimal.ONE;
    public static final BigDecimal NOT_BLACK_LISTED = BigDecimal.ONE;
    

    //FinancialInOutFlowTypes
    
    public static final String MONTHLY_SALARY = "M";
    public static final String FIXED_ALLOWANCE = "F";
    public static final String OTHER_INCOME = "O";
    public static final String MONTHLY_COMMITMENTS = "C";
    
    //population
    
    public static final String DO_NOT_POPULATE_CIF ="0";
    public static final String POPULATE_AUTOMATICALLY ="1";
    public static final String ASK_BEFORE_POPULATING ="2";

    //Fom min max age
    public static final String MIN ="MIN";
    public static final String MAX ="MAX";
    
    //Alerts
    public static final String CIF_ALERT_STATUS_N = "N";
    public static final String CIF_ALERT_STATUS_RS = "RS";
//    public static final String CIF_ALERT_STATUS_SS = "SS";
    public static final String CIF_ALERT_STATUS_AS = "AS";
    public static final String CIF_ALERT_STATUS_S = "S";
    
    //Alerts for specific table "SS"
    public static final String CIF_ALERT_FLAG_FATCA 		= "FTC";
    public static final String CIF_ALERT_FLAG_TRANS_TREND 	= "TRT";
    public static final String CIF_ALERT_FLAG_CASH_FLOW		= "CFL";
    public static final String CIF_ALERT_FLAG_MNEY_LAUND	= "ML";
    public static final String CIF_ALERT_FLAG_OTHER_FIN_ENG	= "OFE";
    public static final String CIF_ALERT_FLAG_BANK_DET 		= "BD";
    public static final String CIF_ALERT_FLAG_CIF_PROD 		= "CP";
    public static final String CIF_ALERT_FLAG_JOINT_DET		= "JDT";
    public static final String CIF_ALERT_FLAG_POL_TRT 		= "PT";
    public static final String CIF_ALERT_FLAG_TRX_TYPE_CHR	= "TTC";
    public static final String CIF_ALERT_FLAG_VOID_CHR 		= "VCH";
    public static final String CIF_ALERT_FLAG_FIN_IN_OUT	= "FIO";
    public static final String CIF_ALERT_FLAG_BAL_LIMIT		= "BL";
    public static final String CIF_ALERT_FLAG_LIM_SCHEMA	= "LSC";
    public static final String CIF_ALERT_FLAG_MEMB_DET		= "MED";
    public static final String CIF_ALERT_FLAG_MORE_DET		= "MRD";
    public static final String CIF_ALERT_FLAG_TRXTYPE_LIM	= "TTL";
    public static final String CIF_ALERT_FLAG_ADD_FILED		= "AF";
    public static final String CIF_ALERT_FLAG_IDS 		= "IDS";
    public static final String CIF_ALERT_FLAG_MORE_ADD 		= "MA";
    public static final String CIF_ALERT_FLAG_EDUCATION		= "EDU";
    public static final String CIF_ALERT_FLAG_OCCUPATION	= "OCC";
    public static final String CIF_ALERT_FLAG_MORE_SIGN		= "MS";
    public static final String CIF_ALERT_FLAG_OWN_DET 		= "OWD";
    public static final String CIF_ALERT_FLAG_CIF_RATING	= "CR";
    public static final String CIF_ALERT_FLAG_MORE_CONTACT	= "MCT";
    public static final String CIF_ALERT_FLAG_MORE_OFFICIER	= "MOF";
    public static final String CIF_ALERT_FLAG_MORE_BANKS	= "MBK";
    public static final String CIF_ALERT_FLAG_CLR_HOUSE_DET	= "CHD";
    
    //signature by cif control
    public static final String SIGNATURE_NOT_MANDATORY= "0";
    public static final String SIGNATURE_BY_CIF_TYPE = "3";
    public static final String SIGNATURE_ALLOW_TO_PROCEED = "2";
    public static final String SIGNATURE_MANDATORY = "1";
    
    
    //signature by cif CIF TYPE
    public static final String SIGNATURE_CIFTYPE_NOT_MANDATORY= "0";
    public static final String SIGNATURE_CIFTYPE_MANDATORY = "1";
    public static final String SIGNATURE_CIFTYPE_ALLOW_TO_PROCEED = "2";
    
    //Print advice
    public static final String PRINT_CIF_AMF_CONFIRMATION_DEFAULT = "RETPRCONF";
    public static final String MAINTENANCE_OPT = "F00I1MT";
    
    //Screen of cif Product opened
    public static final String CIF_PROD_OPENED = "1";
    //A modification is done in IRIS and in the SCREEN 
    public static final String IRIS_FORM_MODIF = "IRIS_FORM_MODIF";
    //A modification is done only in IRIS
    public static final String IRIS_MODIF_ONLY = "IRIS_MODIF_ONLY";

    //82998 SUPT130035 - Sukuk Swift Messages changes 
    public static final String EMPTY_CUSTODIAN_OPTION = "NA";
    
    public static List<String> getStatusFields(){
    	ArrayList<String> statusFields = new ArrayList<String>();

    	statusFields.add("CREATED_BY,"+STATUS_CREATED+",DATE_CREATED");
    	statusFields.add("MODIFIED_BY,"+STATUS_MODIFIED+",DATE_MODIFIED");
    	statusFields.add("REINSTATED_BY,"+STATUS_REINSTATED+",DATE_REINSTATED");
    	statusFields.add("SUSPENDED_BY,"+STATUS_SUSPENDED+",DATE_SUSPENDED");
    	statusFields.add("APPROVED_BY,"+STATUS_APPROVED+",DATE_APPROVED");
    	statusFields.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED"); 
    	statusFields.add("SUSPEND_VALIDATED_BY,"+STATUS_APPLY_SUSPEND+",SUSPEND_VALIDATION_DATE"); //Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    	statusFields.add("REINSTATE_VALIDATED_BY,"+STATUS_APPLY_REINSTATED+",REINSTATE_VALIDATION_DATE"); //Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    	statusFields.add("DRAFTED_BY,"+CIF_STATUS_DRAFT+",DATE_DRAFTED");//Abdo DCR -AMANAUPG170016 30/10/2017
    	return statusFields;
    }
    
    public static final String TYPE_INDIVIDUAL = "V";
    public static final String TYPE_CORPORATE = "T";
    
    public static final String POSITION_OFFICER = "O";
    public static final String POSITION_DIRECTOR = "D";
    public static final String POSITION_BENFICIAR_OWNER = "B";
   
    public static final String OPENING_ACC_REASON = "24";//Hasan Bug#514073 05/06/2017
    
    //John Massaad PATH130241 - FOM V.S Relationship File
    public static final String MORE_OCCUPATION_SCREEN = "MoreOccupation";
    
    //Real Beneficiaries
    //TranserType values
    public static final String RB_TRANSFER_INTRA = "I";
    public static final String RB_TRANSFER_LOCAL = "L";
    public static final String RB_TRANSFER_INTERNATIONAL = "E";
    public static final String RB_REAL_BENEFICIARIES_REF = "BENEF";
    
    public static final String RB_TYPE_BENEFICIARY = "B";
    public static final String RB_TYPE_PROXY = "P";
    public static final String RB_TYPE_GENERAL = "G";
    
    public static final String SWIFT_BIC_BBBB = "XXXX";
    public static final String SWIFT_BIC_CC = "XX";
    public static final String SWIFT_BIC_LL = "XX";
    public static final String SWIFT_BIC_T = "X";
    public static final String SWIFT_BIC_BCD = "XXX";
    
    
    /*
     * PAYMENT CHANNEL
     */
    // Mobile Banking
    public static final String PAYMENT_CHANNEL_MB = "MB";
    // Cash Deposit Machine
    public static final String PAYMENT_CHANNEL_CDM = "CDM";
    // Automated Teller Machine
    public static final String PAYMENT_CHANNEL_ATM = "ATM";
    // Internet Banking
    public static final String PAYMENT_CHANNEL_IB = "IB";
    // Branch
    public static final String PAYMENT_CHANNEL_BR = "BR";
    // Interactive Voice Response
    public static final String PAYMENT_CHANNEL_IVR = "IVR";

    //case sensitivity
    public static final String LOWER_CASE = "L";
    public static final String UPPER_CASE = "U";
    public static final String NONE_CASE = "A";
 
    //Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    public static final String STATUS_APPLY_SUSPEND	= "TS";
    public static final String STATUS_APPLY_REINSTATED	= "TR";
    public static final String FOM_APPLY_SUSPEND_CRUD	= "TS";
    public static final String FOM_APPLY_REINSTATED_CRUD = "TR";
    public static final String FOM_APPLY_SUSPEND_REASON = "22";
    public static final String FOM_APPLY_REINSTATE_REASON = "23";
    //End Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    
    public static final String UPDATE_CIF_FROM_SAVE = "S";
    public static final String UPDATE_CIF_FROM_ALERT_APPROVE = "AS";
    public static final String UPDATE_CIF_FROM_REJECT = "RS";
    public static final String FOM_TRXTYPE_LIMITS = "FOMTRXTYPELIM";
    public static final String PACKAGE_PRODUCT_REF = "PACK";
    
    //SBI170096 - Transaction types for Cash Management_TP#507137
    public static final BigDecimal LABEL_TYPE_LOV_TYPE    		= BigDecimal.valueOf(1171);

    //Abdo US 382751 - BB KYC with Dynamic Screen
    public static final String FINANCIAL_INFO_ACTUAL_BENEFICIARIES = "3";
    public static final String FINANCIAL_INFO_SHAREHOLDERS = "5";
    public static final String FINANCIAL_INFO_AUTHORIZED_SIGNATORIES = "1";
    public static final String FINANCIAL_INFO_BOARD_MEMBERS_MANAGERS = "4";
    public static final String FINANCIAL_INFO_PARTNER_OWN_EXCEED_PERC = "6";
    public static final String FINANCIAL_INFO_COMP_OWN_EXCEED_PERC = "7";
    public static final String FINANCIAL_INFO_SO_BENEFICIARIES = "8";
    public static final String FINANCIAL_INFO_ATTORNEY_FOREIGN_ADDRESS= "9";  
    public static final String FATCA_COMMPLIANT_TYPEW1 = "W1";
    public static final String FATCA_COMMPLIANT_TYPEW8 = "B";
    public static final String KYC_FLAG_PASSPORT_LOADED="flagPassportLoaded";
    //Raed Saad - [BB160150]
    public static final String CIFVO_FIRST_NAME_ENG = "cifVO_FIRST_NAME_ENG";
    public static final String CIFVO_FIRST_NAME_ENG_NAME = "fomCO.cifVO.FIRST_NAME_ENG";
    public static final String CIFVO_LAST_NAME_ENG = "cifVO_LAST_NAME_ENG";
    public static final String CIFVO_LAST_NAME_ENG_NAME = "fomCO.cifVO.LAST_NAME_ENG";
    public static final String CIFVO_FIRST_NAME_AR = "cifVO_FIRST_NAME_AR";
    public static final String CIFVO_FIRST_NAME_AR_NAME = "fomCO.cifVO.FIRST_NAME_AR";
    public static final String CIFVO_LAST_NAME_AR = "cifVO_LAST_NAME_AR"; 
    public static final String CIFVO_LAST_NAME_AR_NAME = "fomCO.cifVO.LAST_NAME_AR ";
    public static final String CIFVO_MOTHER_FIRST_NAME_ID = "cifVO_MOTHER_FIRST_NAME_";
    public static final String CIFVO_MOTHER_FIRST_NAME_NAME = "fomCO.cifVO.MOTHER_FIRST_NAME";
    public static final String CIFVO_MOTHER_LAST_NAME_ID = "cifVO_MOTHER_LAST_NAME";
    public static final String CIFVO_MOTHER_LAST_NAME_NAME = "fomCO.cifVO.MOTHER_LAST_NAME";
    public static final String CIFVO_SEC_NAME_ENG_NAME = "fomCO.cifVO.SEC_NAME_ENG";
    public static final String CIFVO_SEC_NAME_ENG = "cifVO_SEC_NAME_ENG";
    public static final String CIFVO_THIRD_NAME_ENG_NAME = "fomCO.cifVO.THIRD_NAME_ENG";
    public static final String CIFVO_THIRD_NAME_ENG = "cifVO_THIRD_NAME_ENG";
    public static final String CIFVO_SEC_NAME_AR_NAME = "fomCO.cifVO.SEC_NAME_AR";
    public static final String CIFVO_SEC_NAME_AR ="cifVO_SEC_NAME_AR";
    public static final String CIFVO_THIRD_NAME_AR_NAME= "fomCO.cifVO.THIRD_NAME_AR";
    public static final String CIFVO_THIRD_NAME_AR = "cifVO_THIRD_NAME_AR";
   

    public static final String FATCA_COMPLIANT_TYPEW9 = "C";  
    public static final String KYC_COMPLETED_BY_CALL= "C";
    public static final String KYC_RECALCITRANT		= "R";
    public static final String KYC_NOT_REQUIRED		= "P";    
    public static final String KYC_NO			= "N";
    public static final String KYC_YES			= "Y";
    public static final String OPT_COMPLIANCE_USER  = "F00I1SKYC";
    public static final String OPT_COMPLIANCE_RETURN_ALERT = "F00I1SKYCRP";
    public static final String OPT_RESET_KYC_SCORE  = "F00I1SKYC_RESET"; //#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
    public static final String SYRON_PASS_ENC_KEY= "P@th012345678910";
    public static final String STATUS_SIRON_ACTIVE  = "A";
    public static final String STATUS_SIRON_PENDING  = "P";
    public static final String STATUS_SIRON_REJECTED  = "R";
    public static final String STATUS_SIRON_WAITING_FOR_SIRON  = "T";//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
    public static final ArrayList KYC_DYN_FLAGS = new ArrayList<String>(
	    Arrays.asList(new String[] { "flagPassportLoaded", "fomNationality", "fatcaCountry" }));
    public static final String CIFVO_SHORT_NAME_ENG = "cifVO_SHORT_NAME_ENG";
    public static final String CIFVO_LONG_NAME_ENG = "cifVO_LONG_NAME_ENG";
    
    public static final String CIFVO_SHORT_NAME_ENG_NAME = "fomCO.cifVO.SHORT_NAME_ENG";
    public static final String CIFVO_LONG_NAME_ENG_NAME = "fomCO.cifVO.LONG_NAME_ENG";
    public static final String CIFVO_SHORT_NAME_AR_NAME = "fomCO.cifVO.SHORT_NAME_AR";
    public static final String CIFVO_LONG_NAME_AR_NAME = "fomCO.cifVO.LONG_NAME_AR ";
    public static final String AUTH_NAME_NAME = "fomCO.cifVO.AUTH_NAME";
    public static final String CIFVO_NICK_NAME_NAME = "fomCO.cifVO.NICK_NAME";
    
    public static final String CIFVO_SHORT_NAME_AR = "cifVO_SHORT_NAME_AR";
    public static final String CIFVO_LONG_NAME_AR = "cifVO_LONG_NAME_AR"; 
 
    public static final String CIFVO_AUTH_NAME_ID = "cifVO_AUTH_NAME";
    public static final String CIFVO_AUTH_NAME_NAME = "fomCO.cifVO.AUTH_NAME";
    
    public static final String AUTH_NAME_ID = "cifVO_AUTH_NAME";
    
    public static final String CIFVO_NICK_NAME = "cifVO_NICK_NAME";
   

    public static final String CIFVO_CARD_NAME = "cifVO_CARD_NAME";
    public static final String MaskNameCheckBoxId = "cifExtendedVO_MASK_NAME_YN";
    public static final String MaskNameCheckBoxName = "fomCO.cifExtendedVO.MASK_NAME_YN";
    public static final String cifJointAccVO_FIRST_NAME_ENG = "cifJointAccVO_FIRST_NAME_ENG";
    public static final String cifJointAccVO_SECOND_NAME_ENG = "cifJointAccVO_SECOND_NAME_ENG";
    public static final String cifJointAccVO_THIRD_NAME_ENG = "cifJointAccVO_THIRD_NAME_ENG";
    public static final String cifJointAccVO_LAST_NAME_ENG = "cifJointAccVO_LAST_NAME_ENG";
  
    public static final String cifJointAccVO_FIRST_NAME_ARAB = "cifJointAccVO_FIRST_NAME_ARAB";
    public static final String cifJointAccVO_SECOND_NAME_ARAB = "cifJointAccVO_SECOND_NAME_ARAB";
    public static final String cifJointAccVO_THIRD_NAME_ARAB = "cifJointAccVO_THIRD_NAME_ARAB";
    public static final String cifJointAccVO_LAST_NAME_ARAB = "cifJointAccVO_LAST_NAME_ARAB";
    
    public static final String cifJointAccVO_FIRST_NAME_ENG_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.FIRST_NAME_ENG";
    public static final String cifJointAccVO_SECOND_NAME_ENG_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.SECOND_NAME_ENG";
    public static final String cifJointAccVO_THIRD_NAME_ENG_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.THIRD_NAME_ENG";
    public static final String cifJointAccVO_LAST_NAME_ENG_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.LAST_NAME_ENG";

    public static final String cifJointAccVO_FIRST_NAME_ARAB_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.FIRST_NAME_ARAB";
    public static final String cifJointAccVO_SECOND_NAME_ARAB_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.SECOND_NAME_ARAB";
    public static final String cifJointAccVO_THIRD_NAME_ARAB_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.THIRD_NAME_ARAB";
    public static final String cifJointAccVO_LAST_NAME_ARAB_NAME_ELEMENT = "jointAccountCO.cifJointAccVO.LAST_NAME_ARAB";
   
    public static final String cifJointAccVO_BRIEF_NAME_ENG = "cifJointAccVO_BRIEF_NAME_ENG";
    public static final String cifJointAccVO_BRIEF_NAME_ENG_NAME = "jointAccountCO.cifJointAccVO.BRIEF_NAME_ENG";
    public static final String cifJointAccVO_LONG_NAME_ENG = "cifJointAccVO_LONG_NAME_ENG";
    public static final String cifJointAccVO_LONG_NAME_ENG_NAME = "jointAccountCO.cifJointAccVO.LONG_NAME_ENG";
    public static final String cifJointAccVO_BRIEF_NAME_ARAB = "cifJointAccVO_BRIEF_NAME_ARAB";
    public static final String cifJointAccVO_BRIEF_NAME_ARAB_NAME = "jointAccountCO.cifJointAccVO.BRIEF_NAME_ARAB";
    public static final String cifJointAccVO_LONG_NAME_ARAB = "cifJointAccVO_LONG_NAME_ARAB";
    public static final String cifJointAccVO_LONG_NAME_ARAB_NAME = "jointAccountCO.cifJointAccVO.LONG_NAME_ARAB";
  
    public static final String blackListVO_CIF_FIRST_NAME_ENG_ID = "blackListVO_CIF_FIRST_NAME_ENG";	
    public static final String blackListVO_CIF_FIRST_NAME_ENG_NAME= "blackListCO.blackListVO.CIF_FIRST_NAME_ENG";

    public static final String blackListVO_CIF_FIRST_NAME_AR_ID= "blackListVO_CIF_FIRST_NAME_AR";
    public static final String blackListVO_CIF_FIRST_NAME_AR_NAME= "blackListCO.blackListVO.CIF_FIRST_NAME_AR";

    public static final String blackListVO_CIF_SEC_NAME_ENG_ID = "blackListVO_CIF_SEC_NAME_ENG"; 
    public static final String blackListVO_CIF_SEC_NAME_ENG_NAME = "blackListCO.blackListVO.CIF_SEC_NAME_ENG";
    public static final String blackListVO_CIF_SEC_NAME_AR_ID = "blackListVO_CIF_SEC_NAME_AR";  
    public static final String blackListVO_CIF_SEC_NAME_AR_NAME = "blackListCO.blackListVO.CIF_SEC_NAME_AR";
    public static final String blackListVO_CIF_THIRD_NAME_ENG_ID= "blackListVO_CIF_THIRD_NAME_ENG";  
    public static final String blackListVO_CIF_THIRD_NAME_ENG_NAME= "blackListCO.blackListVO.CIF_THIRD_NAME_ENG";

    public static final String blackListVO_CIF_THIRD_NAME_AR_ID = "blackListVO_CIF_THIRD_NAME_AR"; 
    public static final String blackListVO_CIF_THIRD_NAME_AR_NAME= "blackListCO.blackListVO.CIF_THIRD_NAME_AR";
    public static final String blackListVO_CIF_LAST_NAME_ENG_ID = "blackListVO_CIF_LAST_NAME_ENG";  
    public static final String blackListVO_CIF_LAST_NAME_ENG_NAME = "blackListCO.blackListVO.CIF_LAST_NAME_ENG";
    public static final String blackListVO_CIF_LAST_NAME_AR_ID = "blackListVO_CIF_LAST_NAME_AR";  
    public static final String blackListVO_CIF_LAST_NAME_AR_NAME= "blackListCO.blackListVO.CIF_LAST_NAME_AR"; 

    public static final String blackListVO_CIF_MOTHER_FNAME_ID = "blackListVO_CIF_MOTHER_FNAME";  
    public static final String blackListVO_CIF_MOTHER_FNAME_NAME = "blackListCO.blackListVO.CIF_MOTHER_FNAME";
    
    public static final String blackListVO_CIF_MOTHER_LNAME_ID = "blackListVO_CIF_MOTHER_LNAME";   
    public static final String blackListVO_CIF_MOTHER_LNAME_NAME = "blackListCO.blackListVO.CIF_MOTHER_LNAME"; 
    
    public static final String blackListVO_BRIEF_NAME_ARAB_ID = "blackListVO_BRIEF_NAME_ARAB"; 
    public static final String blackListVO_BRIEF_NAME_ARAB_NAME = "blackListCO.blackListVO.BRIEF_NAME_ARAB"; 
    public static final String blackListVO_LONG_NAME_ARAB_ID = "blackListVO_LONG_NAME_ARAB"; 
    public static final String blackListVO_LONG_NAME_ARAB_NAME = "blackListCO.blackListVO.LONG_NAME_ARAB"; 
    public static final String blackListVO_LONG_NAME_ENG_ID = "blackListVO_LONG_NAME_ENG"; 
    public static final String blackListVO_LONG_NAME_ENG_NAME = "blackListCO.blackListVO.LONG_NAME_ENG"; 
    //END Raed Saad - [BB160150]
    
    public static final Date EMPTY_DATE = DateUtil.createDate(1900, 0, 1);
    
    public static String appendSwiftBic(PMSCIFSWIFTVO swiftVO)
    {
	StringBuffer bic = new StringBuffer();
	bic.append(StringUtil.nullToEmpty(swiftVO.getSWIFT_BIC_BBBB()))
		.append(StringUtil.nullToEmpty(swiftVO.getSWIFT_BIC_CC()))
		.append(StringUtil.nullToEmpty(swiftVO.getSWIFT_BIC_LL()))
		.append(StringUtil.nullToEmpty((swiftVO.getSWIFT_BIC_T())))
		.append(StringUtil.nullToEmpty(swiftVO.getSWIFT_BIC_BCD()));
	return bic.toString();
    }
    
    public static final String APPROVED_BY_SIRON 	 = "APPROVED_BY_SIRON";
    public static final String AUTO_APPROVED_BY_SIRON 	 = "AUTO_APPROVED_BY_SIRON_COMPLIANCE_USER";
    public static final String APPROVED_BY_SIRON_COMPLIANCE_USER = "APPROVED_BY_SIRON_COMPLIANCE_USER";
    public static final String REJECTED_BY_SIRON_COMPLIANCE_USER = "REJECTED_BY_SIRON_COMPLIANCE_USER";
    public static final String CIF_IS_BEING_PROCESSED_BY_SIRON = "CIF_IS_BEING_PROCESSED_BY_SIRON";
    
    public static final String SIRON_KYC_STATUS = "SIRON_KYC_STATUS";
    public static final String SENT_TO_COMPLIANCE_USER = "SENT_TO_COMPLIANCE_USER";
    public static final String  SIRON_CHECK_THIS_CASE_AND_TAKE_REQUIRED_ACTION = "SIRON_CHECK_THIS_CASE_AND_TAKE_REQUIRED_ACTION";
    public static final String REJECTED_BY_SIRON = "REJECTED_BY_SIRON";
    public static final String KYC_EXPIRY_PERIODICITY_DAYS = "D";
    public static final String KYC_EXPIRY_PERIODICITY_MONTH = "M";


    
    public static final String B001_ProgRef = "B001";
    public static final String B002_ProgRef = "B002";
    public static final String OPT_BLACKLIST_LOG  = "BL001BLL";
    public static final String BLACK_LIST_LOG = "BLACK_LIST_LOG";
    public static final String  BLACKLIST_LOG_COMPLIANCE_ACTION = "BLACKLIST_LOG_COMPLIANCE_ACTION";
    

    
    public static final String CIF_FILER_NON_FILER_REASON_TYPE = "30"; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    public static final String AML ="AML"; //#864398 add AML application 
    
    //Added By Lina for TP#864398
    public static final String REASON_BR = "33";

    
 }

