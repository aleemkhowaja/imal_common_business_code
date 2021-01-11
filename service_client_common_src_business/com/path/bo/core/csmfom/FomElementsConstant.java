package com.path.bo.core.csmfom; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.path.lib.log.Log;

public final class FomElementsConstant
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private FomElementsConstant(){
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    };
    
    public static final String SCREEN_REF	  	= "F00I1";
    public static final String SUSPEND_PAGE_REF	  	= "F00I1SP";
    public static final String APPROVE_PAGE_REF	  	= "F00I1P";
    public static final String REINSTARE_PAGE_REF 	= "F00I1RI";
    
    /***********************IDs of tab*********************************************/
    public static final String ID_FOMMAINTABS1= "fomMainTabs1"; 
    public static final String ID_FOM_MAIN_TABS_NAME_ADDRESS= "fomMainTabs2";
    public static final String ID_FOM_MAIN_TABS_ADDITIONAL_DETAILS= "fomMainTabs3";
    public static final String ID_FOM_MAIN_TABS_REFERENCES= "fomMainTabs4";
    public static final String ID_FOM_MAIN_TABS_FUND_TRANSFER= "fomMainTabs7";
    public static final String ID_FOM_MAIN_TABS_CIF_BIC_CODE= "fomMainTabs6";
    public static final String ID_FOM_MAIN_TABS_ADDITIONAL_FIELDS= "fomMainTabs5";
    
    /**********************FOM Header Elements **************************/
    public static final String CIF_NO= "fomCO.cifVO.CIF_NO";
    public static final String BRANCH_CODE= "fomCO.cifVO.BRANCH_CODE";
    public static final String ADDITIONAL_REFERENCE= "fomCO.cifVO.ADDITIONAL_REFERENCE";
    public static final String VIP_LABEL= "fomCO.sVipAlert";
    public static final String BLACK_LIST_LABEL= "fomCO.cifBlacklisted";
    public static final String CIF_ALLOWED_MODIF_LABEL= "fomCO.cifAllowedModification";
    /**********************elements in FOM Header  **************************/
 
     
     
     
    /******First tab*************** CIF Details************************/
    public static final String CIF_TYPE= "fomCO.cifVO.CIF_TYPE";    
    public static final String ID_TYPE  ="fomCO.cifVO.ID_TYPE";
    public static final String ID_NO  ="fomCO.cifVO.ID_NO"; 
    public static final String JOIN_ID_TYPE  ="fomCO.cifVO.JOIN_ID_TYPE";
    public static final String JOIN_ID_NO  ="fomCO.cifVO.JOIN_ID_NO";  
    public static final String JOIN_TYPE  ="fomCO.cifVO.JOIN_TYPE";
    public static final String ID_DELIVERY_DATE  ="fomCO.cifVO.ID_DELIVERY_DATE";
    public static final String ID_TYPE2  ="fomCO.cifVO.ID_TYPE2";
    public static final String ID_NO2  ="fomCO.cifVO.ID_NO2"; 
    public static final String ID_DELIVERED_BY  ="fomCO.cifVO.ID_DELIVERED_BY";
    public static final String TYPE= "fomCO.cifVO.TYPE";    
    public static final String BIRTH_DATE= "fomCO.cifVO.BIRTH_DATE";
    public static final String ID_EXPIRY_DATE= "fomCO.cifVO.ID_EXPIRY_DATE"; 
    public static final String MARITAL_STATUS= "fomCO.cifVO.MARITAL_STATUS";
    public static final String sexe= "fomCO.cifVO.SEXE";
    public static final String FORBID_TRX= "fomCO.cifVO.FORBID_TRX";
    public static final String FORBID_REASON= "fomCO.cifVO.FORBID_REASON";
    public static final String Language= "fomCO.cifVO.LANGUAGE";
    
    public static final String EXEMPT_REASON_CODE= "fomCO.cifExtendedVO.ZAKAT_EXEMPTION_REASON";
    public static final String EXEMPT_REASON_CODEID= "lookuptxt_exemptReasonCode";
    
    /******First tab*************** CIF Details************************/ 

  
    
    
    
    /******First tab****************Cif brief and long name***********************/
    public static final String CIVIL_CODE= "fomCO.cifVO.CIVIL_CODE";
    public static final String SHORT_NAME_ENG= "fomCO.cifVO.SHORT_NAME_ENG";
    public static final String LONG_NAME_ENG= "fomCO.cifVO.LONG_NAME_ENG";
    public static final String FULL_NAME_ENG= "fomCO.cifExtendedVO.FULL_NAME_ENG";
    public static final String SHORT_NAME_ARAB= "fomCO.cifVO.SHORT_NAME_ARAB";
    public static final String LONG_NAME_ARAB= "fomCO.cifVO.LONG_NAME_ARAB";
    public static final String FULL_NAME_ARAB= "fomCO.cifExtendedVO.FULL_NAME_ARAB";
    public static final String NICK_NAME= "fomCO.cifVO.NICK_NAME";
    //Hasan BB140080
    public static final String MASK_NAME= "fomCO.cifExtendedVO.MASK_NAME_YN";
    public static final String FIRST_NAME_ENG = "fomCO.cifVO.FIRST_NAME_ENG";
    public static final String SEC_NAME_ENG = "fomCO.cifVO.SEC_NAME_ENG";
    public static final String THIRD_NAME_ENG = "fomCO.cifVO.THIRD_NAME_ENG";
    public static final String LAST_NAME_ENG = "fomCO.cifVO.LAST_NAME_ENG";
    public static final String FIRST_NAME_AR = "fomCO.cifVO.FIRST_NAME_AR";
    public static final String SEC_NAME_AR = "fomCO.cifVO.SEC_NAME_AR";
    public static final String THIRD_NAME_AR = "fomCO.cifVO.THIRD_NAME_AR";
    public static final String LAST_NAME_AR = "fomCO.cifVO.LAST_NAME_AR";
    //End Hasan
    public static final String CARD_NAME= "fomCO.cifVO.CARD_NAME";   
    public static final String NATION_CODE= "fomCO.cifVO.NATION_CODE";
    public static final String COUNTRY= "fomCO.cifVO.COUNTRY";  
    public static final String RACE_CODE= "fomCO.cifVO.RACE_CODE";
    public static final String RACE_DESC= "fomCO.raceDesc";
    public static final String RELIGION_CODE= "fomCO.cifVO.RELIGION";
    public static final String RELIGION_DESC= "fomCO.religionDesc";
    public static final String JOIN_CARD_NAME= "fomCO.cifVO.JOIN_CARD_NAME";
    public static final String ID_EXP_DTE_MAN= "fomCO.cifVO.ID_EXP_DTE_MAN";
    public static final String ID_EXP_DTE_MAN_NAME= "fomCO.cifVO.ID_EXPIRY_DATE";
    public static final String KYC_COMPLETED_NAME= "fomCO.cifVO.KYC_COMPLETED";
    public static final String ID_EXP_DTE_MAN_ID= "cifVO_ID_EXPIRY_DATE";
    public static final String NICK_NAME_ID= "cifVO_NICK_NAME";
    public static final String BVN_DETAILS= "fomCO.cifVO.BVN_DETAILS";
    //Hasan BB140080
    public static final String MASK_NAME_ID= "cifExtendedVO_MASK_NAME_YN";
    public static final String FIRST_NAME_ENG_ID = "cifVO_FIRST_NAME_ENG";
    public static final String SEC_NAME_ENG_ID = "cifVO_SEC_NAME_ENG";
    public static final String THIRD_NAME_ENG_ID = "cifVO_THIRD_NAME_ENG";
    public static final String LAST_NAME_ENG_ID = "cifVO_LAST_NAME_ENG";
    public static final String FIRST_NAME_AR_ID = "cifVO_FIRST_NAME_AR";
    public static final String SEC_NAME_AR_ID = "cifVO_SEC_NAME_AR";
    public static final String THIRD_NAME_AR_ID = "cifVO_THIRD_NAME_AR";
    public static final String LAST_NAME_AR_ID = "cifVO_LAST_NAME_AR";
    //End Hasan
    
    
    
    
    
    
  
   
    /******First tab****************Statement************************/  
    public static final String PERIOD= "fomCO.cifVO.PERIOD";
    public static final String MAIL_STMT= "fomCO.cifVO.MAIL_STMT";
    public static final String MODE_COMM= "fomCO.cifVO.MODE_COMM";
    public static final String DESCRIPTION= "fomCO.cifVO.DESCRIPTION";
    
    
    
       
   
   
    public static final String sexe_ID= "cifVO_SEXE";
    public static final String MARITAL_STATUS_ID= "cifVO_MARITAL_STATUS";    
    public static final String ID_NO_ID = "cifVO_ID_NO";      
    public static final String JOIN_TYPE_ID_DESC ="fomCO.joinIdTypeDesc";
    public static final String ID_TYPE2_ID = "lookuptxt_cifVO_ID_TYPE2";  
    public static final String ID_RACE_CODE = "lookuptxt_cifVO_RACE_CODE";  
    public static final String ID_RACE_DESC = "fomCO_raceDesc";  
    public static final String ID_RELIGION_CODE  = "lookuptxt_cifVO_RELIGION";  
    public static final String ID_RELIGION_DESC  = "fomCO_religionDesc";  
    public static final String LBL_ID_TYPE_ID = "lbl_cifVO_ID_TYPE";  
    public static final String LBL_ID_TYPE2_ID = "lbl_cifVO_ID_TYPE2";  
    public static final String ID_NO2_ID  ="cifVO_ID_NO2"; 
    public static final String ID_REGION_CODE = "lookuptxt_cifExtendedVO_region_ofBirth";  
    public static final String ID_REGION_DESC  ="fomCO_regionBirthDesc"; 
    public static final String ID_CITY_CODE = "lookuptxt_cifExtendedVO_CITY_OF_BIRTH";  
    public static final String ID_CITY_DESC  ="cityDesc"; 
    public static final String EDUC_LEVEL  ="lookuptxt_cifVO_EDUC_LEVEL"; 
    
        
    
    
    /******Second tab****************Additional Details************************/
    
    public static final String ECO_SECTOR= "fomCO.cifVO.ECO_SECTOR";
    public static final String PRIORITY_CODE= "fomCO.cifVO.PRIORITY_CODE";  
    public static final String RELATION_CODE= "fomCO.cifVO.RELATION_CODE";
    public static final String RELATION_CODE_ID= "lbl_cifVO_RELATION_CODE";
    public static final String CHAT_BANK= "fomCO.cifVO.CHAT_BANK";
    public static final String CHAT_BANK_FLAG = "fomCO.chatFlag";
    public static final String CB_NO= "fomCO.cifVO.CB_NO";
    public static final String MONTHLY_SALARY= "fomCO.cifVO.MONTHLY_SALARY";
    
    
    public static final String SWIFT_COMPLIANT_ADD1= "fomCO.cifVO.SWIFT_COMPLIANT_ADD1";
    public static final String SWIFT_COMPLIANT_ADD2= "fomCO.cifVO.SWIFT_COMPLIANT_ADD2";
    public static final String SWIFT_COMPLIANT_ADD3= "fomCO.cifVO.SWIFT_COMPLIANT_ADD3";
    public static final String SWIFT_COMPLIANT_ADD4= "fomCO.cifVO.SWIFT_COMPLIANT_ADD4";    
    public static final String CAPITAL_AMOUNT= "fomCO.cifVO.CAPITAL_AMOUNT";    
    public static final String BKE= "fomCO.cifVO.BKE";       
    public static final String LICENCE_EXPIRY_DATE= "fomCO.cifVO.LICENCE_EXPIRY_DATE";
 
    
    public static final String SWIFT_COMPLIANT_ADD1_ID= "cifVO_SWIFT_COMPLIANT_ADD1";
    public static final String SWIFT_COMPLIANT_ADD2_ID= "cifVO_SWIFT_COMPLIANT_ADD2";
    public static final String SWIFT_COMPLIANT_ADD3_ID= "cifVO_SWIFT_COMPLIANT_ADD3";
    public static final String SWIFT_COMPLIANT_ADD4_ID= "cifVO_SWIFT_COMPLIANT_ADD4";
    
    public static final String CAPITAL_AMOUNT_ID= "cifVO_CAPITAL_AMOUNT";
    public static final String BKE_ID= "cifVO_BKE";
    public static final String LICENCE_EXPIRY_DATE_ID= "cifVO_LICENCE_EXPIRY_DATE";
    public static final String DIVISION= "fomCO.cifVO.DIVISION";
    public static final String DEPARTMENT= "fomCO.cifVO.DEPT";
    public static final String CIF_PROFESSION_ID= "cifVO_profession";
    
    public static final String EXEMPT_FULL_CHARGE_WAIVER_ID= "cifExtendedVO_EXEMPT_FULL_CHARGE_WAIVER_YN";
    public static final String EXEMPTED_FROM_VAT_YN= "fomCO.cifExtendedVO.EXEMPTED_FROM_VAT_YN";
    
    public static final String POLITICALLY_EXPOSED_ID= "cifVO_PEPS";
    
    
    
    public static final String ECONOMIC_AGENT = "lookuptxt_ECONOMIC_AGENT"; 
    public static final String PROFESSION = "lookuptxt_PROFESSION"; 
    public static final String PROFESSION_SEGMENT = "lookuptxt_PROFESSION_SEGMENT"; 
    public static final String PROFESSION_CATEGORY = "lookuptxt_PROFESSION_CATEGORY"; 
    
    public static final String SEGMENT_CODE = "lookuptxt_cifExtendedVO_SEGMENT_CODE";
    
    
    
    
    /******Third tab****************References***********************/
    public static final String CODE_ROLE= "fomCO.cifVO.CODE_ROLE";
    public static final String REL_OFF_ID= "fomCO.cifVO.REL_OFF_ID";
    //Bug 332869  -- [John Massaad]
    public static final String OFFICER_NAME= "fomCO.cifVO.REL_OFFICER";
    public static final String MANAGER_NAME = "fomCO.cifVO.REL_MANAGER";
    //Bug 332869  -- [John Massaad]  
   
    
    
    /******additional fields tab******************************************/  
    
    public static final String ADD_STRING1= "fomCO.cifVO.ADD_STRING1";
    public static final String ADD_STRING2= "fomCO.cifVO.ADD_STRING2";
    public static final String ADD_STRING3= "fomCO.cifVO.ADD_STRING3";
    public static final String ADD_STRING4= "fomCO.cifVO.ADD_STRING4";
    public static final String ADD_STRING5= "fomCO.cifVO.ADD_STRING5";
    public static final String ADD_STRING6= "fomCO.cifVO.ADD_STRING6";
    public static final String ADD_STRING7= "fomCO.cifVO.ADD_STRING7";
    
    
    public static final String CIF_VO="cifVO";
    
    //Passport Info

    public static final String PASS_ISSUE_DATE_HIJIRI= "cifVO1.PASS_ISSUE_DATE_HIJIRI";
    public static final String PASS_EXP_DATE_HIJIRI= "cifVO1.PASS_EXP_DATE_HIJIRI";
    public static final String PASS_ISSUE_DATE2_HIJIRI= "cifVO1.PASS_ISSUE_DATE2_HIJIRI";
    public static final String PASS_EXP_DATE2_HIJIRI= "cifVO1.PASS_EXP_DATE2_HIJIRI";
    public static final String PASS_ISSUE_DATE3_HIJIRI= "cifVO1.PASS_ISSUE_DATE3_HIJIRI";
    public static final String PASS_EXP_DATE3_HIJIRI= "cifVO1.PASS_EXP_DATE3_HIJIRI";
    
    
    
    
    
    
    
    
    /***********************************************/
    
    public static final String  fom_Reserved_CIF_btn= "fom_Reserved_CIF_btn";
    
    public static final String  fom_Show_Picture_btn= "fom_Show_Picture_btn";
    public static final String  fom_Reset_btn_= "fom_Reset_btn";
    public static final String  fom_Transaction_Trends_btn_= "fom_Transaction_Trends_btn";
    public static final String  fom_Cash_Flow_Sources_btn_= "fom_Cash_Flow_Sources_btn";
    public static final String  fom_Money_Laundring_btn_= "fom_Money_Laundring_btn";
    public static final String  fom_similar_ids_btn= "fom_similar_ids_btn";
    
    public static final String  fom_CIF_Related_Acc_btn= "fom_CIF_Related_Acc_btn";
    public static final String  fom_fatca_btn= "fom_fatca_btn";
    
    public static final String  fom_Joint_Details_btn= "fom_Joint_Details_btn";
    
    public static final String  fom_scan_btn= "fom_scan_btn";
    public static final String  fom_CIF_Financial_In_Out_btn= "fom_CIF_Financial_In_Out_btn";
    public static final String  fom_CIF_Products_btn= "fom_CIF_Products_btn";
    public static final String  fom_IRIS_btn= "fom_IRIS_btn";
    public static final String  fom_Member_Details_btn= "fom_Member_Details_btn";

    public static final String  fom_Ownership_Details_btn= "fom_Ownership_Details_btn";
    public static final String  fom_Trx_Type_Limits_btn= "fom_Trx_Type_Limits_btn";
    public static final String   fom_Education_btn= "fom_Education_btn";
    public static final String   FOMADDDETLS_KYCDETLS= "FOMAddDetls_KYCDetls";
    public static final String   FOM_IDS_BTN = "fom_IDs_btn";
    public static final String   fom_cif_branches_btn= "fom_CIF_Branches_btn";
    
    public static final String   fom_Save_btn= "fom_Save_btn";
    public static final String   fom_Validate_btn= "fom_Validate_btn";
    public static final String   fom_Delete_btn= "fom_Delete_btn";
    public static final String   fom_Approve_btn= "fom_Approve_btn";
    public static final String   fom_Suspend_btn= "fom_Suspend_btn";
    public static final String   fom_Reinstate_btn= "fom_Reinstate_btn";   
    public static final String   fom_waiver_Charges_btn= "fom_waiver_Charges_btn";
    public static final String   fom_Alert_btn= "fom_Alert_btn";
    public static final String   fom_additional_fields_btn= "fom_additional_fields_btn";
    
    
    
    
   //Rabih El Khatib visual elements IDs
    public static final String VIP_LABEL_ID  ="lbl_CIF_Vip_Alert";    
    public static final String ID_TYPE_ID  ="lookuptxt_cifVO_ID_TYPE";
    public static final String ID_TYPE_DESC_ID  ="fomCO_idTypeDesc";
    
    public static final String LEGAL_STATUS_ID  ="lookuptxt_cifVO_LEGAL_STATUS";
    public static final String RELATION_CODE_LV_ID = "lookuptxt_cifVO_RELATION_CODE";
    public static final String CB_NO_ID= "cifVO_CB_NO";
    
    public static final String BIRTH_DATE_ID = "cifVO_BIRTH_DATE";
        //John Massaad
//    public static final String BIRTH_DATE_HIJRI_ID = "cifVO_BIRTH_DATE_F00I1MT_hijriDate";
    
    public static final String REGISTER_NO = "cifVO_REGISTER_NO";
    public static final String ID_EXPIRY_DATE_ID  ="cifVO_ID_EXPIRY_DATE";
    public static final String LBL_ID_EXPIRY_DATE_ID  = "lbl_cifVO_ID_EXPIRY_DATE";
    public static final String MORE_DETAILS_BTN_ID  ="fom_More_Details_btn";
    public static final String MEMBER_DETAILS_BTN_ID  ="fom_Member_Details_btn";
    public static final String EDUCATION_BTN_ID  ="fom_Education_btn";
    public static final String OWNERSHIP_DETAILS_BTN_ID  ="fom_Ownership_Details_btn";
    public static final String TRX_TYPE_LIMIT_BTN_ID  = "fom_Trx_Type_Limits_btn";
    public static final String CHAT_BANK_ID = "cifVO_CHAT_BANK";
    public static final String JOIN_CARD_NAME_ID = "cifVO_JOIN_CARD_NAME";
    public static final String JOIN_ID_TYPE_ID  ="lookuptxt_cifVO_JOIN_ID_TYPE";
    public static final String JOIN_ID_NO_ID  ="cifVO_JOIN_ID_NO";    
    public static final String JOIN_TYPE_ID  ="cifVO_JOIN_TYPE";
    public static final String JOIN_TYPE_ID_DESC_ID  ="fomCO_joinIdTypeDesc";    
    public static final String CHARGES_WAIVER_BTN_ID  ="charges_waiver_btn";
    public static final String ADDRESS_CITY_DESC_ID  ="addressCO_cityDesc";
    
    public static final String POSTAL_CODE_ID = "lookuptxt_addressCO_POSTAL_CODE";
    public static final String POSTAL_CODE_DESC_ID = "addressCO_postalcodeDesc";
    
  
    public static final String ID_TYPE2_DESC_ID = "fomCO_idType2Desc";
 
    public static final String NATION_CODE_ID = "lookuptxt_cifVO_NATION_CODE";
    public static final String PRIORITY_CODE_ID = "lookuptxt_cifVO_PRIORITY_CODE";
    public static final String ECO_SECTOR_ID = "lookuptxt_cifVO_ECO_SECTOR";
    public static final String SUB_ECO_SECTOR_ID = "lookuptxt_cifVO_SUB_ECO_SECTOR";
    public static final String SUB_ECO_SECTOR = "fomCO.cifVO.SUB_ECO_SECTOR";
    public static final String COUNTRY_OF_BIRTH_ID = "lookuptxt_cifVO_COUNTRY_OF_BIRTH";
    public static final String CODE_ROLE_ID = "lookuptxt_cifVO_CODE_ROLE";
    public static final String STREET_DETAILS_EN_ID = "addressCO_STREET_DETAILS_ENG";
    public static final String STREET_DETAILS_ENG = "addressCO.STREET_DETAILS_ENG";
    public static final String TYPE_ID = "cifVO_TYPE";
    public static final String CIVIL_CODE_ID = "lookuptxt_cifVO_CIVIL_CODE";
    public static final String SEXE_ID = "cifVO_SEXE";
    public static final String AUTH_NAME_ID = "cifVO_AUTH_NAME";
    public static final String AUTH_ID_ID = "cifVO_AUTH_ID";
    public static final String AUTH_MORE_SIGNATORY = "fom_More_Signatory_btn";
    public static final String MODE_COMM_ID = "cifVO_MODE_COMM";
    public static final String MAIL_STMT_ID = "cifVO_MAIL_STMT";
    public static final String DESCRIPTION_ID = "cifVO_DESCRIPTION";
    public static final String SIGNATORY_ID_TYPE_ID = "lookuptxt_cifVO_SIGNATORY_ID_TYPE";
    public static final String PERIODICITY_ID = "cifVO_PERIOD";
    public static final String PERIODICITY = "fomCO.cifVO.PERIOD";
    public static final String MODE_COMM_DIRECT_MAIL_FLAG = "D";
    public static final String MODE_COMM_POBOX_FLAG = "P";
    public static final String MODE_COMM_EMAIL_FLAG = "E";
    public static final String MODE_COMM_SMS_FLAG = "S";
    public static final String MODE_COMM_FAX_FLAG = "F";
    public static final String MAIL_STMT_YES_FLAG = "Y";
    
    
    public static final String MODE_COMM_COLLECT_BRANCH_FLAG = "C";
    public static final String MODE_COMM_TELEX_FLAG = "T";
    public static final String MODE_COMM_BIC_FLAG = "W";

    
    //
    public static final String COUNTRY_ID = "lookuptxt_cifVO_COUNTRY";    
    public static final String ADD_COUNTRY_ID = "lookuptxt_addressCO_COUNTRY";
    public static final String ADD_COUNTRY_DESC_ID = "addressCO_countryDesc"; //922691 Details: Rania - ZKI190013 - Country value is disapprearing in FOM after inserting the country code in the address
    
    public static final String CITY_CODE_ID = "lookuptxt_addressCO_CITY_CODE";
    public static final String CITY_DESC_ID = "addressCO_cityDesc";
    
    public static final String SECTOR_CODE_ID = "lookuptxt_addressCO_SECTOR_CODE";
    public static final String SECTOR_DESC_ID = "addressCO_sectorDesc";
    
    public static final String REGION_ID = "lookuptxt_addressCO_REGION";
    public static final String REGION_DESC_ID = "addressCO_regionDesc";
    
    public static final String POBOX_AREA_ID = "lookuptxt_addressCO_POBOX_AREA";
    public static final String POBOX_AREA_DESC_ID = "addressCO_poBoxAreaDesc";
    
    public static final String MOBILE_NAME = "addressCO.MOBILE";
    public static final String TEL_NAME = "addressCO.TEL";
    public static final String WORK_TEL_NAME = "addressCO.WORK_TEL";
    public static final String OTHER_TEL_NAME = "addressCO.OTHER_TEL";
    public static final String FAX_NAME = "addressCO.FAX";
    public static final String POSTAL_CODE1 = "addressCO.POSTAL_CODE1";
    public static final String POSTAL_CODE = "addressCO.POSTAL_CODE";
    public static final String POBOX_AREA  = "addressCO.POBOX_AREA";
    public static final String ADDRESS2_ENG  = "addressCO.ADDRESS2_ENG";
    public static final String ADDRESS2_ARAB  = "addressCO.ADDRESS2_ARAB";
    
    public static final String MOBILE_ID = "addressCO_MOBILE";
    public static final String ADD_COUNTRY_NAME = "addressCO.COUNTRY";
    public static final String ADD_CITY_NAME = "addressCO.CITY_CODE";
    public static final String ADD_SECTOR_NAME = "addressCO.SECTOR_CODE";
    public static final String TEL_ID = "addressCO_TEL";
    public static final String WORK_TEL_ID = "addressCO_WORK_TEL";
    public static final String OTHER_TEL_ID = "addressCO_OTHER_TEL";
    public static final String FAX_ID = "addressCO_FAX";
    public static final String EMAIL_ID = "addressCO_EMAIL";
    public static final String EMAIL_NAME = "addressCO.EMAIL";
    public static final String REFERENCES_TEL_ID = "cifVO_TEL";
    public static final String REFERENCES_TELEX_ID = "cifVO_TELEX";
    public static final String REFERENCES_FAX_ID = "cifVO_FAX";
    public static final String HOME_TEL_LABEL_ID = "lbl_addressCO_TEL";
    public static final String BIOMETRIC_APPROVED_YN  = "fomCO.cifVO.BIOMETRIC_APPROVED_YN";
    public static final String REFERENCES_TEL_NAME = "fomCO.cifVO.TEL";
    public static final String REFERENCES_TELEX_NAME = "fomCO.cifVO.TELEX";
    public static final String REFERENCES_FAX_NAME = "fomCO.cifVO.FAX";
    
    public static final String ADDRESS1_ENG_ID = "addressCO_ADDRESS1_ENG";
    public static final String ADDRESS1_ARAB_ID = "addressCO_ADDRESS1_ARAB";
    public static final String ADDRESS2_ENG_ID = "addressCO_ADDRESS2_ENG";
    public static final String ADDRESS2_ARAB_ID = "addressCO_ADDRESS2_ARAB";
    public static final String ADDRESS3_ENG_ID = "addressCO_ADDRESS3_ENG";
    public static final String ADDRESS3_ARAB_ID = "addressCO_ADDRESS3_ARAB";
    public static final String ADDRESS4_ENG_ID = "addressCO_ADDRESS4_ENG";
    public static final String ADDRESS4_ARAB_ID = "addressCO_ADDRESS4_ARAB";
    public static final String STREET_DET_ENG_ID = "addressCO_STREET_DETAILS_ENG";
    public static final String STREET_DET_ARAB_ID = "addressCO_STREET_DETAILS_ARAB";
    public static final String CITY_ENG_ID = "addressCO_CITY_ENG";
    public static final String CITY_ARAB_ID = "addressCO_CITY_ARAB";
    public static final String CITY_ENG_NAME = "addressCO.CITY_ENG";
    public static final String PO_BOX_ID = "addressCO_PO_BOX";
    public static final String PO_BOX_NAME = "addressCO.PO_BOX";
    public static final String ADDRESS_DESC_ID = "lookuptxt_addressCO_ADDRESS_DESCRIPTION";
    public static final String ADDRESS_EXPIRY_DATE_ID = "addressCO_EXPIRY_DATE";
    public static final String ADDRESS_FROM_DATE_ID = "addressCO_FROM_DATE";
    public static final String ADDRESS_TO_DATE_ID = "addressCO_TO_DATE";
    public static final String PERM_ADDRESS_ID = "addressCO_PERM_ADDRESS";
    public static final String DEFAULT_ADDRESS_ID = "addressCO_DEFAULT_ADD";
    public static final String PRINT_STAT_ID = "addressCO_PRINT_STAT";
    
    //NABIL FEGHALI IIAB110426
    public static final String RESIDENT_TYPE_ID = "lookuptxt_cifVO_FOM_RESIDENCE_TYPE";
    public static final String RESIDENT_TYPE_DESC_ID = "fomCO_residenceTypeDesc";
    
    public static final String RESIDENT = "fomCO.cifVO.RESIDENT";
    
    //Rabih 1st Tab (Names and Addresses) Addresses section
    public static final String DEFAULT_ADDRESS = "1";
    public static final String PERMANENT_ADDRESS = "Y";
    public static final String WALLET_ADDRESS = "1";
    
    //Joyce KANAZI (More Occupations) Occupation section
    
    public static final String MAIN_OCCUPATION = "1";
    
    //Hasan EWBI160034 26/04/2016
    public static final String EXEMPTED_FROM_VAT_YN_ID = "cifExtendedVO_EXEMPTED_FROM_VAT_YN";
    
    public static final String STATUS_REASON_NAME = "fomCO.cifExtendedVO.STATUS_REASON";
    
    public static final String CARD_READER_SRL  = "fomCO.cifExtendedVO.CARD_READER_SRL";
    /**********************More Contacts***********************/
    public static final String contactVO_TEL_ID1 	= "contactVO_TEL_1";
    public static final String contactVO_TEL_ID2 	= "contactVO_TEL_2";
    public static final String contactVO_TEL_ID3 	= "contactVO_TEL_3";
    public static final String contactVO_TEL_ID4 	= "contactVO_TEL_4";
    public static final String contactVO_FAX_ID  	= "contactVO_FAX";
    public static final String contactVO_FAX_ID1 	= "contactVO_FAX_1";
    public static final String contactVO_FAX_ID2 	= "contactVO_FAX_2";

    public static final String contactVO_TEL_NAME1	= "contactCO.cifContactVO.TEL_1";
    public static final String contactVO_TEL_NAME2 	= "contactCO.cifContactVO.TEL_2";
    public static final String contactVO_TEL_NAME3 	= "contactCO.cifContactVO.TEL_3";
    public static final String contactVO_TEL_NAME4 	= "contactCO.cifContactVO.TEL_4";
    public static final String contactVO_FAX_NAME 	= "contactCO.cifContactVO.FAX";
    public static final String contactVO_FAX_NAME1 	= "contactCO.cifContactVO.FAX_1";
    public static final String contactVO_FAX_NAME2 	= "contactCO.cifContactVO.FAX_2";
    public static final String REASON_CODE_NAME = "fomCO.cifVO.REASON_CODE";//Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016

    
    
    /**********************Bank Details***********************/
    public static final String PARTY_BANK= "bankCO.bankDetailsVO.PARTY_BANK";
    public static final String INTERM_BANK= "bankCO.bankDetailsVO.INTERM_BANK";
    public static final String PARTY_BANK_BIC= "bankCO.bankDetailsVO.BIC_CODE";
    public static final String INTERM_BANK_BIC= "bankCO.bankDetailsVO.INTERM_BIC_CODE";
    

    /**********************Cif product Details***********************/

    
    /***** tab number seven *************** Fund Transfer ************************/
    public static final String EXPOSURE_LIMIT= "fomCO.cifVO.LIMIT"; 
    public static final String EDUCATION_INSTITUTION_NAME= "cifEducationVO_INSTITUTION_NAME"; 

    
    public static final String EMPLOYER_NAME= "fomCO.cifVO.EMPLOYER_NAME";  // TP239210 
    public static final String EMPLOYER_NAME_ID= "cifVO_EMPLOYER_NAME";  

   
    //Real Beneficiaries popup
    public static final String CIF_PROXY_BENEF_NAME = "fomRealBeneficiariesCO.cifProxyBenfVO.PROXY_TYPE";
    public static final String AGENT_MATURITY_DATE_NAME = "fomRealBeneficiariesCO.cifProxyBenfVO.AGENT_MATURITY_DATE";
    public static final String REAL_MATURITY_DATE_NAME= "fomRealBeneficiariesCO.cifProxyBenfVO.REAL_MATURITY_DATE";
    
    public static final List<String> realBeneficiariesDetlsFields = Arrays.asList(

    "language", "firstNameL", "firstNameO", "secondNameL", "secondNameO", "thirdNameL", "thirdNameO", "lastNameL",
	    "lastNameO", "lookuptxt_regionCode", "telephone", "address_1", "address_2", "address_3", "address_4", "workTelephone",
	    "mobile", "otherTel", "fax", "city", "email", "lookuptxt_country", "lookuptxt_poBoxArea", "PO_BOX",
	    "lookuptxt_cityCode", "lookuptxt_sector", "lookuptxt_postalCode", "lookuptxt_residenceType", "fromDate", "toDate",
	    "expiryDate", "lookuptxt_idType", "lookuptxt_cifProxyCountryOfIssuance","cifProxyCountryOfIssuanceDesc","idNO", "idExpiryDate", "idDateOfBirth", "lookuptxt_idPalceOfBirth",
	    "lookuptxt_idNationality", "fomrealbenef_MOTHER_FIRST_NAME", "fomrealbenef_MOTHER_LAST_NAME" //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner

    );
    
    public static final List<String> realBeneficiariesDetlsNameFields = Arrays.asList(

	    "fomRealBeneficiariesCO.cifProxyBenfDetVO.LANGUAGE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.FIRST_NAME_L", "fomRealBeneficiariesCO.cifProxyBenfDetVO.FIRST_NAME_O", "fomRealBeneficiariesCO.cifProxyBenfDetVO.SECOND_NAME_L", "fomRealBeneficiariesCO.cifProxyBenfDetVO.SECOND_NAME_O", "fomRealBeneficiariesCO.cifProxyBenfDetVO.THIRD_NAME_L", "fomRealBeneficiariesCO.cifProxyBenfDetVO.THIRD_NAME_O", "fomRealBeneficiariesCO.cifProxyBenfDetVO.LAST_NAME_L",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.LAST_NAME_O", "fomRealBeneficiariesCO.cifProxyBenfDetVO.REGION_CODE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.TELEPHONE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ADDRESS_1", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ADDRESS_2", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ADDRESS_3", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ADDRESS_4", "fomRealBeneficiariesCO.cifProxyBenfDetVO.WORK_TELEPHONE",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.MOBILE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.OTHER_TEL", "fomRealBeneficiariesCO.cifProxyBenfDetVO.FAX", "fomRealBeneficiariesCO.cifProxyBenfDetVO.CITY", "fomRealBeneficiariesCO.cifProxyBenfDetVO.EMAIL", "fomRealBeneficiariesCO.cifProxyBenfDetVO.COUNTRY_CODE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.PO_BOX_AREA", "fomRealBeneficiariesCO.cifProxyBenfDetVO.PO_BOX",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.CITY_CODE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.SECTOR", "fomRealBeneficiariesCO.cifProxyBenfDetVO.POSTAL_CODE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.DESCRIPTION_CODE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.FROM_DATE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.TO_DATE",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.EXPIRY_DATE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_TYPE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.COUNTRY_OF_ISSUANCE","fomRealBeneficiariesCO.cifProxyCountryOfIssuanceDesc","fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_NO", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_EXPIRY_DATE", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_DATE_OF_BIRTH", "fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_PLACE_OF_BIRTH",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.ID_NATIONALITY"

	    );
    
    public static final List<String> realBeneficiariesNameTransferDetls = Arrays.asList(

	    "fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_BIC_CODE","fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_CIF_NO","fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_BRANCH", "fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_ACC_NO", "fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_ADDRESS_1", "fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_ADDRESS_2", "fomRealBeneficiariesCO.cifProxyBenfDetVO.BANK_ADDRESS_3",
		    "fomRealBeneficiariesCO.cifProxyBenfDetVO.BENEF_ACC_NO"
	    );
    
    public static final List<String> realBeneficiariesTransferDetls = Arrays.asList(

	    "lookuptxt_bankBICCode","lookuptxt_bankCIFNo","bankBranch", "bankAccountNO", "bankAddress_1", "bankAddress_2", "bankAddress_3",
		    "benefAccNO"
	    );
    //IDs
    public static final String ADDITIONAL_REFFERENCE_ID =  "lookuptxt_addReference"; 
    public static final String CURRENCY_CODE_ID =  "lookuptxt_currencyCode"; 
    public static final String PURPOSE_OF_REGISTER_ID =  "purposeOfRegistr"; 
    public static final String FROM_DATE_ID =  "fromDate";
    public static final String TO_DATE_ID =  "toDate";
    public static final String EXPIRY_DATE_ID =  "expiryDate";
    public static final String RB_ID_EXPIRY_DATE_ID =  "idExpiryDate";
    public static final String ID_DATE_OF_BIRTH_ID =  "idDateOfBirth";
    public static final String RB_ID_NATIONALITY =  "idNationality";
    public static final String RB_ID_PLACE_OF_BIRTH = "idPalceOfBirth";
    public static final String RB_ID_TELEPHONE =  "telephone";
    public static final String RB_ID_WORK_TELEPHONE =  "workTelephone";
    public static final String RB_ID_OTHER_TEL =  "otherTel";
    public static final String RB_ID_FAX =  "fax";
    public static final String RB_ID_MOBILE = "mobile";
    public static final String RB_REAL_BENEFICIARIES_BTN_ID = "fom_real_beneficiaries_btn";
    public static final String CIFVO_GIIN_ID = "cifVO_GIIN";//Abdo  US 382751 - BB KYC with Dynamic Screen 
    //Real Beneficiaries popup
    
    //Rania - ABSAI180073
//    public static final String SCORE_VALUE = "fomCO.cifExtendedVO.SCORE_RISK_VALUE";
    public static final String SCORE_VALUE = "score_risk_value";
    public static final String MORE_SCORES_BTN = "more_scores_btn";
    public static final String FICA_LIST = "fica_list";
    public static final String SCORE_DESC = "score_risk_description";
    public static final String SCORE_CODE = "score_code";
    
    public static final String SCORE_DISPLAY_S = "S";
    public static final String SCORE_DISPLAY_V = "V";
    public static final String SCORE_DISPLAY_B = "B";
    
    //
    
    // Joint Details Salary section constants
     public static HashMap<String,String> jointDetailsNames(){
    	
      	HashMap<String,String> jointDetailsFields = new HashMap<String,String>() ;
    	
    	 jointDetailsFields.put("BRIEF_NAME_ENG", "jointAccountCO.cifJointAccVO.BRIEF_NAME_ENG");
         jointDetailsFields.put("BRIEF_NAME_ARAB", "jointAccountCO.cifJointAccVO.BRIEF_NAME_ARAB");
         jointDetailsFields.put("LONG_NAME_ENG", "jointAccountCO.cifJointAccVO.LONG_NAME_ENG");
         jointDetailsFields.put("LONG_NAME_ARAB", "jointAccountCO.cifJointAccVO.LONG_NAME_ARAB");
         jointDetailsFields.put("ID_NO", "jointAccountCO.cifJointAccVO.ID_NO");
         jointDetailsFields.put("PASSPORT_NO_1", "jointAccountCO.cifJointAccVO.PASSPORT_NO_1");
         jointDetailsFields.put("PASSPORT1_EXP_DATE", "jointAccountCO.cifJointAccVO.PASSPORT1_EXP_DATE");
         jointDetailsFields.put("PASSPORT1_EXP_DATE_HIJRI", "jointAccountCO.cifJointAccVO.PASSPORT1_EXP_DATE_HIJRI");         
         jointDetailsFields.put("PASSPORT_NO_2", "jointAccountCO.cifJointAccVO.PASSPORT_NO_2");
         jointDetailsFields.put("PASSPORT2_EXP_DATE", "jointAccountCO.cifJointAccVO.PASSPORT2_EXP_DATE");
         jointDetailsFields.put("PASSPORT2_EXP_DATE_HIJRI", "jointAccountCO.cifJointAccVO.PASSPORT2_EXP_DATE_HIJRI");         
         jointDetailsFields.put("PASSPORT_NO_3", "jointAccountCO.cifJointAccVO.PASSPORT_NO_3");
         jointDetailsFields.put("PASSPORT3_EXP_DATE", "jointAccountCO.cifJointAccVO.PASSPORT3_EXP_DATE");
         jointDetailsFields.put("PASSPORT3_EXP_DATE_HIJRI", "jointAccountCO.cifJointAccVO.PASSPORT3_EXP_DATE_HIJRI");
       
         jointDetailsFields.put("FIRST_NAME_ENG", "jointAccountCO.cifJointAccVO.FIRST_NAME_ENG");
         jointDetailsFields.put("FIRST_NAME_ARAB", "jointAccountCO.cifJointAccVO.FIRST_NAME_ARAB");
         
         jointDetailsFields.put("LAST_NAME_ENG", "jointAccountCO.cifJointAccVO.LAST_NAME_ENG");
         jointDetailsFields.put("LAST_NAME_ARAB", "jointAccountCO.cifJointAccVO.LAST_NAME_ARAB");
         
         jointDetailsFields.put("SECOND_NAME_ENG", "jointAccountCO.cifJointAccVO.SECOND_NAME_ENG");
         jointDetailsFields.put("SECOND_NAME_ARAB", "jointAccountCO.cifJointAccVO.SECOND_NAME_ARAB");
         
         jointDetailsFields.put("THIRD_NAME_ENG", "jointAccountCO.cifJointAccVO.THIRD_NAME_ENG");
         jointDetailsFields.put("THIRD_NAME_ARAB", "jointAccountCO.cifJointAccVO.THIRD_NAME_ARAB");
         

         jointDetailsFields.put("b_DATE", "jointAccountCO.cifJointAccVO.b_DATE");
         jointDetailsFields.put("b_DATE_HIJRI", "jointAccountCO.cifJointAccVO.b_DATE_HIJRI");
         jointDetailsFields.put("lookuptxt_jointAccountCO.cifJointAccVO.NATION_CODE", "lookuptxt_jointAccountCO.cifJointAccVO.NATION_CODE");
         jointDetailsFields.put("lookuptxt_jointAccountCO.cifJointAccVO.ID_TYPE", "lookuptxt_jointAccountCO.cifJointAccVO.ID_TYPE");
         jointDetailsFields.put("ID_EXPIRY_DATE", "jointAccountCO.cifJointAccVO.ID_EXPIRY_DATE");
         jointDetailsFields.put("ID_EXPIRY_DATE_HIJIRI", "jointAccountCO.cifJointAccVO.ID_EXPIRY_DATE_HIJIRI");
         
      jointDetailsFields.put("GENDER", "jointAccountCO.cifJointAccVO.GENDER");
      jointDetailsFields.put("MARITAL_STATUS", "jointAccountCO.cifJointAccVO.MARITAL_STATUS");
      jointDetailsFields.put("ID_DELIVERY_DATE", "jointAccountCO.cifJointAccVO.ID_DELIVERY_DATE");
      jointDetailsFields.put("ID_DELIVERED_BY", "jointAccountCO.cifJointAccVO.ID_DELIVERED_BY");
      jointDetailsFields.put("lookuptxt_jointAccountCO.cifJointAccVO.ID_TYPE2", "lookuptxt_jointAccountCO.cifJointAccVO.ID_TYPE2");
      jointDetailsFields.put("ID_NO2", "jointAccountCO.cifJointAccVO.ID_NO2");
      //Hala-BUG677443
      jointDetailsFields.put("lookuptxt_cifJointAccVO_ID_TYPE2", "lookuptxt_cifJointAccVO_ID_TYPE2");	
      jointDetailsFields.put("lookuptxt_cifJointAccVO_RELATION_CODE", "lookuptxt_cifJointAccVO_RELATION_CODE");
      jointDetailsFields.put("JOINT_TYPE", "jointAccountCO.cifJointAccVO.JOINT_TYPE");
      jointDetailsFields.put("lookuptxt_cifJointAccVO_NATION_CODE", "lookuptxt_cifJointAccVO_NATION_CODE");
      jointDetailsFields.put("lookuptxt_cifJointAccVO_JOINT_CIF_NO", "lookuptxt_cifJointAccVO_JOINT_CIF_NO");
      jointDetailsFields.put("lookuptxt_cifJointAccCountryOfIssuance1", "lookuptxt_cifJointAccCountryOfIssuance1");
      jointDetailsFields.put("lookuptxt_cifJointAccCountryOfIssuance2", "lookuptxt_cifJointAccCountryOfIssuance2");
      jointDetailsFields.put("lookuptxt_cifJointAccCountryOfIssuance3", "lookuptxt_cifJointAccCountryOfIssuance3");
      jointDetailsFields.put("lookuptxt_cifJointAccVO_ID_TYPE", "lookuptxt_cifJointAccVO_ID_TYPE");
    return jointDetailsFields;
    	

    }
    
    
    public static HashMap<String, String> requiredFieldsMap()
    {
	HashMap<String, String> elementsMainInformation = new HashMap<String, String>();

	elementsMainInformation.put("fomCO.cifVO.KYC_COMPLETED", "cifVO_KYC_COMPLETED");
	elementsMainInformation.put("fomCO.cifVO.COUNTRY_OF_BIRTH", "lookuptxt_cifVO_COUNTRY");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.DETAILS_ENG", "businessNatureVO_DETAILS_ENG");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.DETAILS_ARAB", "businessNatureVO_DETAILS_ARAB");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.PURPOSE_OF_ACC_ENG", "businessNatureVO_PURPOSE_OF_ACC_ENG");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.PURPOSE_OF_ACC_ARAB", "businessNatureVO_PURPOSE_OF_ACC_ARAB");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.VALUE_CY", "lookuptxt_businessNatureVO_VALUE_CY");
	elementsMainInformation.put("businessNatureCO.businessNatureVO.VALUE_OF_BUSINESS", "businessNatureVO_VALUE_OF_BUSINESS");
	elementsMainInformation.put("fomCO.cifVO.CIVIL_CODE", "lookuptxt_cifVO_CIVIL_CODE");
	elementsMainInformation.put("fomCO.cifVO.COUNTRY", "lookuptxt_cifVO_COUNTRY");
	elementsMainInformation.put("addressCO.MOBILE", "addressCO_MOBILE");
	elementsMainInformation.put("addressCO.EMAIL", "addressCO_EMAIL");
	
	/* to DO by CSM ADMIN*/
	elementsMainInformation.put("fomCO.cifVO.CIF_TYPE", "lookuptxt_cifVO_CIF_TYPE");
	elementsMainInformation.put("fomCO.cifVO.LANGUAGE", "cifVO_LANGUAGE");
	elementsMainInformation.put("fomCO.cifVO.SEXE", "cifVO_SEXE");
	elementsMainInformation.put("fomCO.cifVO.MARITAL_STATUS", "cifVO_MARITAL_STATUS");
	elementsMainInformation.put("fomCO.cifVO.SHORT_NAME_ENG", "cifVO_SHORT_NAME_ENG");
	elementsMainInformation.put("fomCO.cifVO.LONG_NAME_ENG", "cifVO_LONG_NAME_ENG");
	elementsMainInformation.put("fomCO.cifVO.NATION_CODE", "lookuptxt_cifVO_NATION_CODE");
	elementsMainInformation.put("fomCO.cifVO.MAIL_STMT", "cifVO_MAIL_STMT");
	elementsMainInformation.put("fomCO.cifVO.MODE_COMM", "cifVO_MODE_COMM");
	elementsMainInformation.put("fomCO.cifVO.ECO_SECTOR", "lookuptxt_cifVO_ECO_SECTOR");
	elementsMainInformation.put("fomCO.cifVO.PRIORITY_CODE", "lookuptxt_cifVO_PRIORITY_CODE");
	

	/*Jad Lezeik */
	elementsMainInformation.put("fomCO.cifVO.LEGAL_STATUS", "lookuptxt_cifVO_LEGAL_STATUS");
	
	return elementsMainInformation;
    }

     public static HashMap<String,String> cifDetailsHeader(){
 	 HashMap<String,String> elementsMainInformation = new HashMap<String,String>() ;
 	 elementsMainInformation.put("cifVO_CIF_NO", "fomCO.cifVO.CIF_NO");
 	 elementsMainInformation.put("lookuptxt_cifVO_BRANCH_CODE", "fomCO.cifVO.BRANCH_CODE");	
 	 elementsMainInformation.put("ADDITIONAL_REFERENCE", "fomCO.cifVO.ADDITIONAL_REFERENCE");
     return elementsMainInformation;
     }
     
     public static HashMap<String,String> cifFATCA(){
	 HashMap<String,String> elementsMainInformation = new HashMap<String,String>() ;
	 elementsMainInformation.put("select_fom_fatca_status", "fomCO.cifFatcaDetailsVO.FATCA_STATUS");
	 elementsMainInformation.put("lookuptxt_reason_code", "fomCO.cifFatcaDetailsVO.REASON_CODE");	
	 elementsMainInformation.put("dateId", "fomCO.cifFatcaDetailsVO.FATCA_DATE");
	 elementsMainInformation.put("tinId", "fomCO.cifFatcaDetailsVO.TIN");
	 return elementsMainInformation;
     }
     
     public static HashMap<String,String> onLOad(){
	 HashMap<String,String> elementsMainInformation = new HashMap<String,String>() ;
	 elementsMainInformation.put("cifVO_CIF_NO", "fomCO.cifVO.CIF_NO");
	 elementsMainInformation.put("lookuptxt_cifVO_BRANCH_CODE", "fomCO.cifVO.BRANCH_CODE");	
	 elementsMainInformation.put("ADDITIONAL_REFERENCE", "fomCO.cifVO.ADDITIONAL_REFERENCE");
	 return elementsMainInformation;
     }
     

     
     //CIF Details division
     public static HashMap<String,String> cifDetails(){
 	       HashMap<String,String> cifDetailshm = new HashMap<String,String>() ;
 	        cifDetailshm.put("CIF_TYPE","fomCO.cifVO.CIF_TYPE");   
 	        cifDetailshm.put("ID_TYPE","fomCO.cifVO.ID_TYPE");
 	        cifDetailshm.put("ID_NO","fomCO.cifVO.ID_NO");
 	        cifDetailshm.put("JOIN_ID_TYPE","fomCO.cifVO.JOIN_ID_TYPE");
 	        cifDetailshm.put("JOIN_ID_NO","fomCO.cifVO.JOIN_ID_NO");  
 	        cifDetailshm.put("JOIN_TYPE","fomCO.cifVO.JOIN_TYPE");
 	        cifDetailshm.put("ID_DELIVERY_DATE","fomCO.cifVO.ID_DELIVERY_DATE");
 	        cifDetailshm.put("ID_TYPE2","fomCO.cifVO.ID_TYPE2");
 	        cifDetailshm.put("ID_NO2","fomCO.cifVO.ID_NO2"); 
 	        cifDetailshm.put("ID_DELIVERED_BY","fomCO.cifVO.ID_DELIVERED_BY");
 	        cifDetailshm.put("TYPE","fomCO.cifVO.TYPE");    
 	        cifDetailshm.put("BIRTH_DATE","fomCO.cifVO.BIRTH_DATE");
 	        cifDetailshm.put("ID_EXPIRY_DATE","fomCO.cifVO.ID_EXPIRY_DATE");
 	        cifDetailshm.put("MARITAL_STATUS","fomCO.cifVO.MARITAL_STATUS");
 	        cifDetailshm.put("sexe","fomCO.cifVO.SEXE");
 	        cifDetailshm.put("Language","fomCO.cifVO.LANGUAGE"); 
     return cifDetailshm;
     	    	
     }
     
     public static HashMap<String,String> cifTypeAllFieldList(){
	HashMap<String, String> cifTypeAllField = cifDetailsHeader();
	cifTypeAllField.putAll(cifDetails());
	return cifTypeAllField;
     } 
     // CIF PRODUCT  section constants
     public static HashMap<String,String> cifProductFieldList(){
     	
    	HashMap<String,String> cifProductFields = new HashMap<String,String>() ;
    	cifProductFields.put("cifProductsCO_chequeTypeDesc", "cifProductsCO_chequeTypeDesc");
    	cifProductFields.put("lookuptxt_cifProductsVO_CHEQUE_TYPE", "lookuptxt_cifProductsVO_CHEQUE_TYPE");
    

    	cifProductFields.put("cifProductsCO_cardTypeDesc", "cifProductsCO_cardTypeDesc");
    	cifProductFields.put("lookuptxt_cifProductsVO_CARD_TYPE", "lookuptxt_cifProductsVO_CARD_TYPE");
    	
    	cifProductFields.put("cifProductsCO_passBookDesc", "cifProductsCO_passBookDesc");
    	cifProductFields.put("lookuptxt_cifProductsVO_PASSBOOK_TYPE", "lookuptxt_cifProductsVO_PASSBOOK_TYPE");

    	return cifProductFields;
     	
     
     }
     
     
     
     // Joint Details Salary section constants
     public static HashMap<String,String> jointDetailsFieldList(){
     	
    	HashMap<String,String> jointDetailsFields = new HashMap<String,String>() ;
    	 
    	jointDetailsFields.put("cifJointAccVO_BRIEF_NAME_ENG", "cifJointAccVO_BRIEF_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_BRIEF_NAME_ARAB", "cifJointAccVO_BRIEF_NAME_ARAB");
    	jointDetailsFields.put("cifJointAccVO_LONG_NAME_ENG", "cifJointAccVO_LONG_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_LONG_NAME_ARAB", "cifJointAccVO_LONG_NAME_ARAB");
    	jointDetailsFields.put("cifJointAccVO_ID_NO", "cifJointAccVO_ID_NO");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT_NO_1", "cifJointAccVO_PASSPORT_NO_1");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT1_EXP_DATE", "cifJointAccVO_PASSPORT1_EXP_DATE");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT1_EXP_DATE_HIJRI", "cifJointAccVO_PASSPORT1_EXP_DATE_HIJRI");
    	
 	jointDetailsFields.put("cifJointAccVO_PASSPORT_NO_2", "cifJointAccVO_PASSPORT_NO_2");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT2_EXP_DATE", "cifJointAccVO_PASSPORT2_EXP_DATE");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT2_EXP_DATE_HIJRI", "cifJointAccVO_PASSPORT2_EXP_DATE_HIJRI");
    	
 	jointDetailsFields.put("cifJointAccVO_PASSPORT_NO_3", "cifJointAccVO_PASSPORT_NO_3");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT3_EXP_DATE", "cifJointAccVO_PASSPORT3_EXP_DATE");
    	jointDetailsFields.put("cifJointAccVO_PASSPORT3_EXP_DATE_HIJRI", "cifJointAccVO_PASSPORT3_EXP_DATE_HIJRI");
    
    	jointDetailsFields.put("cifJointAccVO_FIRST_NAME_ENG", "cifJointAccVO_FIRST_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_FIRST_NAME_ARAB", "cifJointAccVO_FIRST_NAME_ARAB");
    	
    	jointDetailsFields.put("cifJointAccVO_LAST_NAME_ENG", "cifJointAccVO_LAST_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_LAST_NAME_ARAB", "cifJointAccVO_LAST_NAME_ARAB");
    	
    	jointDetailsFields.put("cifJointAccVO_SECOND_NAME_ENG", "cifJointAccVO_SECOND_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_SECOND_NAME_ARAB", "cifJointAccVO_SECOND_NAME_ARAB");
    	
    	jointDetailsFields.put("cifJointAccVO_THIRD_NAME_ENG", "cifJointAccVO_THIRD_NAME_ENG");
    	jointDetailsFields.put("cifJointAccVO_THIRD_NAME_ARAB", "cifJointAccVO_THIRD_NAME_ARAB");
    	

 	jointDetailsFields.put("cifJointAccVO_b_DATE", "cifJointAccVO_b_DATE");
    	jointDetailsFields.put("cifJointAccVO_b_DATE_HIJRI", "cifJointAccVO_b_DATE_HIJRI");
    	jointDetailsFields.put("lookuptxt_cifJointAccVO_NATION_CODE", "lookuptxt_cifJointAccVO_NATION_CODE");
    	jointDetailsFields.put("lookuptxt_cifJointAccVO_ID_TYPE", "lookuptxt_cifJointAccVO_ID_TYPE");
    	jointDetailsFields.put("cifJointAccVO_ID_EXPIRY_DATE", "cifJointAccVO_ID_EXPIRY_DATE");
    	jointDetailsFields.put("cifJointAccVO_ID_EXPIRY_DATE_HIJIRI", "cifJointAccVO_ID_EXPIRY_DATE_HIJIRI");
    	
 	jointDetailsFields.put("cifJointAccVO_GENDER", "cifJointAccVO_GENDER");
 	jointDetailsFields.put("cifJointAccVO_MARITAL_STATUS", "cifJointAccVO_MARITAL_STATUS");
 	jointDetailsFields.put("cifJointAccVO_ID_DELIVERY_DATE", "cifJointAccVO_ID_DELIVERY_DATE");
 	jointDetailsFields.put("cifJointAccVO_ID_DELIVERED_BY", "cifJointAccVO_ID_DELIVERED_BY");
 	jointDetailsFields.put("lookuptxt_cifJointAccVO_ID_TYPE2", "lookuptxt_cifJointAccVO_ID_TYPE2");
 	jointDetailsFields.put("cifJointAccVO_ID_NO2", "cifJointAccVO_ID_NO2");
   	
     return jointDetailsFields;
     }
     
     // Trx Type Limit section constants
     public static HashMap<String,String> trxTypeLimitFieldList(){
    	HashMap<String,String> trxTypeLimitFields = new HashMap<String,String>() ;
    	trxTypeLimitFields.put("TrxTypeLimitDiv", "TrxTypeLimitDiv");
    	trxTypeLimitFields.put("TrxTypePopUps", "TrxTypePopUps");
    	
    	return trxTypeLimitFields;
     }
     
     public static HashMap<String,String> fomTrxTypeLimitList(){
	 HashMap<String,String> trxTypeLimitFields = new HashMap<String,String>() ;
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_CY", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.CY");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_CY_DESC", "fomTrxTypeLimitsCO.CY_DESC");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_LIMIT", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.LIMIT");
	 trxTypeLimitFields.put("accBr", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ACC_BR");
	 trxTypeLimitFields.put("accCy", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ACC_CY");
	 trxTypeLimitFields.put("accGl", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ACC_GL");
	 trxTypeLimitFields.put("accCif", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ACC_CIF");
	 trxTypeLimitFields.put("lookuptxt_accSl", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ACC_SL");
	 trxTypeLimitFields.put("lookuptxt_accAddRef", "fomTrxTypeLimitsCO.ACC_ADD_REF");
	 trxTypeLimitFields.put("accDesc", "fomTrxTypeLimitsCO.AC_DESC");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.TEMPLATE_CODE");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_TMP_DESC", "fomTrxTypeLimitsCO.TMP_DESC");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_OVERIDE_USR_LEVEL", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.OVERIDE_USR_LEVEL");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_USER_LEVEL_DESC", "fomTrxTypeLimitsCO.USER_LEVEL_DESC");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_CHARGE_SCHEMA_CODE", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.CHARGE_SCHEMA_CODE");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_CHARGE_SCHEMA_NAME", "fomTrxTypeLimitsCO.CHARGE_SCHEMA_NAME");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_CHARGE_SCHEMA_OPER", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.CHARGE_SCHEMA_OPER");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_CHARGE_SCHEMA_OPER_NAME", "fomTrxTypeLimitsCO.CHARGE_SCHEMA_OPER_NAME");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_ORGANIZATION_CODE", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.ORGANIZATION_CODE");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_SECURITY_CODE", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.SECURITY_CODE");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_REF_FIELD_LENGTH", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.REF_FIELD_LENGTH");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_TYPE_CODE", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.TYPE_CODE");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_TYPE_DESC", "fomTrxTypeLimitsCO.TYPE_DESC");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_PROVIDER_REP_ID_ENG", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.PROVIDER_REP_ID_ENG");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_DESC_PROVIDER_REP_ENG", "fomTrxTypeLimitsCO.DESC_PROVIDER_REP_ENG");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_PROVIDER_REP_ID_ARAB", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.PROVIDER_REP_ID_ARAB");
	 trxTypeLimitFields.put("fomTrxTypeLimitsCO_DESC_PROVIDER_REP_ARAB", "fomTrxTypeLimitsCO.DESC_PROVIDER_REP_ARAB");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_PROVIDER_ARG_ID_ENG", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.PROVIDER_ARG_ID_ENG");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_DESC_PROVIDER_ARG_ENG", "fomTrxTypeLimitsCO.DESC_PROVIDER_ARG_ENG");
	 trxTypeLimitFields.put("lookuptxt_fomCifTrxtypeLimitsVO_PROVIDER_ARG_ID_ARAB", "fomTrxTypeLimitsCO.fomCifTrxtypeLimitsVO.PROVIDER_ARG_ID_ARAB");
	 trxTypeLimitFields.put("fomCifTrxtypeLimitsVO_DESC_PROVIDER_ARG_ARAB", "fomTrxTypeLimitsCO.DESC_PROVIDER_ARG_ARAB");
	 
	 return trxTypeLimitFields;
     }
     
     
     // Occupation Salary section constants
     public static HashMap<String,String> occupSalaryFieldList(){
    	HashMap<String,String> occupSalaryFields = new HashMap<String,String>() ;
    	 
    	occupSalaryFields.put("cifOccupationVO_MONTHLY_BASIC_SALARY", "fomCifOccupationCO.cif_OccupationVO.MONTHLY_BASIC_SALARY");
    	occupSalaryFields.put("cifOccupationVO_LOCATION_FEES", "fomCifOccupationCO.cif_OccupationVO.LOCATION_FEES");
    	occupSalaryFields.put("cifOccupationVO_TRANSPORTATION_FEES", "fomCifOccupationCO.cif_OccupationVO.TRANSPORTATION_FEES");
    	occupSalaryFields.put("cifOccupationVO_OTHER_FEES", "fomCifOccupationCO.cif_OccupationVO.OTHER_FEES");
    	occupSalaryFields.put("cifOccupationVO_MONTHLY_TOTAL_SALARY", "fomCifOccupationCO.cif_OccupationVO.MONTHLY_TOTAL_SALARY");
    	occupSalaryFields.put("cifOccupationVO_ANNUAL_SALARY", "fomCifOccupationCO.cif_OccupationVO.ANNUAL_SALARY");
    	occupSalaryFields.put("cifOccupationVO_OTHER_INCOME", "fomCifOccupationCO.cif_OccupationVO.OTHER_INCOME");
    	occupSalaryFields.put("cifOccupationVO_SALARY_CASHED_DATE", "fomCifOccupationCO.cif_OccupationVO.SALARY_CASHED_DATE");
     	return occupSalaryFields;
     }
     
     public static HashMap<String,String> passportInfo(){
 	 HashMap<String,String> hmPassportInfo = new HashMap<String,String>() ;
 	 hmPassportInfo.put("PASPORT_NO", "cifVO1.PASPORT_NO");
 	 hmPassportInfo.put("PASSPORT_ISSUE_DATE", "cifVO1.PASSPORT_ISSUE_DATE");	
 	 hmPassportInfo.put("PASS_ISSUE_DATE_HIJIRI", "cifVO1.PASS_ISSUE_DATE_HIJIRI");
 	 hmPassportInfo.put("PASSPORT_ISSUE_PLACE", "cifVO1.PASSPORT_ISSUE_PLACE");
 	 hmPassportInfo.put("PASSPORT_EXPIRY_DATE", "cifVO1.PASSPORT_EXPIRY_DATE");
 	 hmPassportInfo.put("PASS_EXP_DATE_HIJIRI", "cifVO1.PASS_EXP_DATE_HIJIRI");	 
 	 hmPassportInfo.put("PASPORT_NO2", "cifVO1.PASSPORT_NO2");
 	 hmPassportInfo.put("PASSPORT_ISSUE_DATE2", "cifVO1.PASSPORT_ISSUE_DATE2");	
 	 hmPassportInfo.put("PASS_ISSUE_DATE2_HIJIRI", "cifVO1.PASS_ISSUE_DATE2_HIJIRI");
 	 hmPassportInfo.put("PASSPORT_ISSUE_PLACE2", "cifVO1.PASSPORT_ISSUE_PLACE2");
 	 hmPassportInfo.put("PASSPORT_EXPIRY_DATE2", "cifVO1.PASSPORT_EXPIRY_DATE2");
 	 hmPassportInfo.put("PASS_EXP_DATE2_HIJIRI", "cifVO1.PASS_EXP_DATE2_HIJIRI");	 
 	 hmPassportInfo.put("PASPORT_NO3", "cifVO1.PASSPORT_NO3");
 	 hmPassportInfo.put("PASSPORT_ISSUE_DATE3", "cifVO1.PASSPORT_ISSUE_DATE3");	
 	 hmPassportInfo.put("PASS_ISSUE_DATE3_HIJIRI", "cifVO1.PASS_ISSUE_DATE3_HIJIRI");
 	 hmPassportInfo.put("PASSPORT_ISSUE_PLACE3", "cifVO1.PASSPORT_ISSUE_PLACE3");
 	 hmPassportInfo.put("PASSPORT_EXPIRY_DATE3", "cifVO1.PASSPORT_EXPIRY_DATE3");
 	 hmPassportInfo.put("PASS_EXP_DATE3_HIJIRI", "cifVO1.PASS_EXP_DATE3_HIJIRI");
   	return hmPassportInfo;
   }
     
   //ID / Registration Num  
    public static HashMap<String, String> IDRegistrationNum()
    {
	HashMap<String, String> hmIDRegistrationNum = new HashMap<String, String>();
	hmIDRegistrationNum.put("ID_NO", "fomCO.cifVO.ID_NO");
	hmIDRegistrationNum.put("ID_TYPE", "fomCO.cifVO.ID_TYPE");
	hmIDRegistrationNum.put("JOIN_ID_TYPE", "fomCO.cifVO.JOIN_ID_TYPE");
	hmIDRegistrationNum.put("JOIN_ID_NO", "fomCO.cifVO.JOIN_ID_NO");
	hmIDRegistrationNum.put("JOIN_TYPE", "fomCO.cifVO.JOIN_TYPE");
	hmIDRegistrationNum.put("ID_EXPIRY_DATE", "fomCO.cifVO.ID_EXPIRY_DATE");
	hmIDRegistrationNum.put("ID_TYPE2", "fomCO.cifVO.ID_TYPE2");
	hmIDRegistrationNum.put("ID_NO2", "fomCO.cifVO.ID_NO2");
	return hmIDRegistrationNum;
    }
     
   
  //ID / Cif brief and long name  
    public static HashMap<String, String> cifBriefLongDetails()
    {
	HashMap<String, String> hmBriefLongDetails = new HashMap<String, String>();
	hmBriefLongDetails.put("SHORT_NAME_ENG", "fomCO.cifVO.SHORT_NAME_ENG");
	hmBriefLongDetails.put("LONG_NAME_ENG", "fomCO.cifVO.LONG_NAME_ENG");
	hmBriefLongDetails.put("SHORT_NAME_ARAB", "fomCO.cifVO.SHORT_NAME_ARAB");
	hmBriefLongDetails.put("LONG_NAME_ARAB", "fomCO.cifVO.LONG_NAME_ARAB");
	return hmBriefLongDetails;
    }

    public static HashMap<String, String> additionalFields()
    {
	HashMap<String, String> addFields = new HashMap<String, String>();

	for(int i = 1; i <= 15; i++)
	{
	    addFields.put("additionalFieldCO.ADD_STRING" + i, "fomCO.cifVO.ADD_STRING" + i);
	}
	for(int i = 1; i <= 5; i++)
	{
	    addFields.put("additionalFieldCO.NUMBER" + i, "fomCO.cifVO.ADD_NUMBER" + i);
	}
	for(int i = 1; i <= 5; i++)
	{
	    addFields.put("additionalFieldCO.DATE" + i, "fomCO.cifVO.DATE" + i);
	}

	return addFields;
    }

    public static HashMap<String, String> additionalNumber()
    {
	HashMap<String, String> addString = new HashMap<String, String>();

	for(int i = 1; i < 16; i++)
	{
	    addString.put("additionalFieldCO.NUMBER" + i, "fomCO.cifVO.ADD_NUMBER" + i);
	}
	return addString;
    }
    
    public static HashMap<String, String> additionalDate()
    {
	HashMap<String, String> addString = new HashMap<String, String>();

	for(int i = 1; i < 6; i++)
	{
	    addString.put("additionalFieldCO.DATE" + i, "fomCO.cifVO.DATE" + i);
	}
	return addString;

    }
    
    
    
    
    
    
    public static List<String> getStatusFields()
    {
	ArrayList<String> elementsAddress = new ArrayList<String>();

	elementsAddress.add("addressCO.ADDRESS1_ENG");
	elementsAddress.add("addressCO.ADDRESS2_ENG");
	elementsAddress.add("addressCO.ADDRESS3_ENG");
	elementsAddress.add("addressCO.ADDRESS4_ENG");
	elementsAddress.add("addressCO.REGION");
	elementsAddress.add("addressCO.CITY_ENG");
	elementsAddress.add("addressCO.COUNTRY");
	return elementsAddress;
    }
    
    //Main Information
    public static HashMap<String,String> mainInformation(){
	 HashMap<String,String> elementsMainInformation = new HashMap<String,String>() ;
	 elementsMainInformation.put("CIF_NO", "fomCO.cifVO.CIF_NO");
	 elementsMainInformation.put("BRANCH_CODE", "fomCO.cifVO.BRANCH_CODE");	
	 elementsMainInformation.put("ADDITIONAL_REFERENCE", "fomCO.cifVO.ADDITIONAL_REFERENCE");
    	
    return elementsMainInformation;
    	    	
    }
    // Name Details
    public static HashMap<String,String> nameDetails(){
	 HashMap<String,String> hmNameDetails = new HashMap<String,String>() ;
	 hmNameDetails.put("FIRST_NAME_ENG", "fomCO.cifVO.FIRST_NAME_ENG");
	 hmNameDetails.put("FIRST_NAME_AR", "fomCO.cifVO.FIRST_NAME_AR");	
	 hmNameDetails.put("SEC_NAME_ENG", "fomCO.cifVO.SEC_NAME_ENG");
	 hmNameDetails.put("SEC_NAME_AR", "fomCO.cifVO.SEC_NAME_AR");	 
	 hmNameDetails.put("THIRD_NAME_ENG", "fomCO.cifVO.THIRD_NAME_ENG");
	 hmNameDetails.put("THIRD_NAME_AR", "fomCO.cifVO.THIRD_NAME_AR");
	 hmNameDetails.put("LAST_NAME_ENG", "fomCO.cifVO.LAST_NAME_ENG");
	 hmNameDetails.put("LAST_NAME_AR", "fomCO.cifVO.LAST_NAME_AR");
	 hmNameDetails.put("MOTHER_FIRST_NAME", "fomCO.cifVO.MOTHER_FIRST_NAME");
	 hmNameDetails.put("MOTHER_LAST_NAME", "fomCO.cifVO.MOTHER_LAST_NAME");
   	return hmNameDetails;
   	    	
   }
    
    
    public static HashMap<String,String> cifBriefLongName(){
	       HashMap<String,String> cifDetailshm = new HashMap<String,String>() ;
	        cifDetailshm.put("CIVIL_CODE","fomCO.cifVO.CIVIL_CODE");   
	        cifDetailshm.put("SHORT_NAME_ENG","fomCO.cifVO.SHORT_NAME_ENG");
	        cifDetailshm.put("LONG_NAME_ENG","fomCO.cifVO.LONG_NAME_ENG");
	        cifDetailshm.put("SHORT_NAME_ARAB","fomCO.cifVO.SHORT_NAME_ARAB");	        
	        cifDetailshm.put("LONG_NAME_ARAB","fomCO.cifVO.LONG_NAME_ARAB");  
	        cifDetailshm.put("NICK_NAME","fomCO.cifVO.JOIN_TYPE");
	        cifDetailshm.put("CARD_NAME","fomCO.cifVO.CARD_NAME");
	        cifDetailshm.put("NATION_CODE","fomCO.cifVO.NATION_CODE");
	        cifDetailshm.put("COUNTRY","fomCO.cifVO.COUNTRY"); 
	        cifDetailshm.put("RACE_CODE","fomCO.cifVO.RACE_CODE");
	        cifDetailshm.put("RELIGION","fomCO.cifVO.RELIGION");    
	        cifDetailshm.put("JOIN_CARD_NAME","fomCO.cifVO.JOIN_CARD_NAME");
	        return cifDetailshm;
 }
    
    public static HashMap<String, String> cifDetailsDivision()
    {
	HashMap<String, String> hmCifDetails = new HashMap<String, String>();
	hmCifDetails.put("CIF_TYPE", "fomCO.cifVO.CIF_TYPE");
	hmCifDetails.put("BRANCH_CODE", "fomCO.cifVO.BRANCH_CODE");
	hmCifDetails.put("ADDITIONAL_REFERENCE", "fomCO.cifVO.ADDITIONAL_REFERENCE");

	return hmCifDetails;
    }
    
    // added by nour for tp#925559
    public static String ARABIC ="A";
    public static String ENGLISH ="L";

    


}

