package com.path.bo.core.aml;

import java.math.BigDecimal;
import java.util.List;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * KycManagementConstant.java used to define Constant variables 
 */
public class KycManagementConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(153);
	public static final String STATUS_CREATED = "C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "M";
	public static final String STATUS_APPROVED = "P";
    public static final String CRUD_UPDATE_AFTER_AUTHORIZE = "U";
    public static final String STATUS_ACTIVE = "A";
    public static final String KYC_UPDATE_DATE="kycUpdateDate";
    public static final String Y="Y";
    public static final String A="A";
    public static final String ARABIC="AR";
    public static final String MINUS_ONE="-1";
    public static final BigDecimal CIF_STATUS_LOV_TYPE  = BigDecimal.valueOf(32);
    public static final Integer	NAME_DETAILS	                = 8;
    public final static String ENTITY_CIF_TYPE_LOV     = "CIFTYPE";
    public static final Integer	MORE_ADDRESSES	                = 14;
    public static final String MODE_COMM_EMAIL	        = "E"; 
    public static final String DEFAULT_ADDRESS = "1";
    public static final String PERMANENT_ADDRESS = "Y";
    public static final String MODE_COMM_POBOX		= "P";
    public static final String CIF_IS_INDIVIDUAL 	= "V";
    public static final String CIF_INACTIVE		= "I";
    public static final String CIF_ACTIVE		= "A";
    public static final String ADDRESS_DETAILS_MAX_LENGTH = "23";
    public static final ArrayList KYC_DYN_FLAGS = new ArrayList<String>(Arrays.asList(new String[] { "flagPassportLoaded"}));

    public static final String N = "N";
    public static final String CHECKED = "true";
    public static final String UNCHECKED = "false";
    
    //PASSPORT_NO_MAND from CIFCONTROL
    public static final String PASSPORT_NO_MAND_ON = "1";
    public static final String PASSPORT_NO_MAND_OFF = "0";
   //PASSPORT_NO_MAND from RIFCTT(CIF TYPE SCREEN)
    public static final String PASSPORT_MANDATORY_ON = "Y";
    public static final String PASSPORT_MANDATORY_OFF = "N";
    
    /** Categories of the CIF*/
    public static final String CATEGORY_ALL 	      = "A";
    public static final String CATEGORY_POTENTIEL 	= "P";
    public static final String CATEGORY_CLIENT 	        = "C";
    public static final String CATEGORY_NEITHER 	= "N";
    public static final String CIF_IS_CLIENT 	= "Y";
    public static final String RECEIVE_FOREING_INCOME	="fomCO.cifKYCVO.RECEIVE_FOREIGN_INCOME_YN";
    public static final String  FINANCIAL_TYPE_FOREIGN_INCOME = "F";
    public static final String FOREIGN_COMPANY 			="fomCO.cifKYCVO.FOREIGN_COMPANY_YN";
    public static final String COMP_OWN_EXCEEDING_PERC 	="fomCO.cifKYCVO.COMP_OWN_EXCEEDING_PERC_YN";
    public static final String PARTNER_EXCEEDING_PERC	="fomCO.cifKYCVO.PARTNER_EXCEEDING_PERC_YN";
    public static final String  FINANCIAL_TYPE_PARTNER_DETAILS = "6";
    public static final String  FINANCIAL_TYPE_COMPANY_DETAILS = "7";
    public static final String COMP_FOREIGN_ADDRESS 	="fomCO.cifKYCVO.COMP_FOREIGN_ADDRESS_YN";
    public static final String  FINANCIAL_TYPE_FOREIGN_COUNTRY = "C";
    public static final String SO_FOREIGN_TRANSFER		="fomCO.cifKYCVO.SO_FOREIGN_TRANSFER_YN";
    public static final String  FINANCIAL_TYPE_INTER_SO = "8";
    public static final String ATTORNEY_FOREIGN_ADDRESS	="fomCO.cifKYCVO.ATTORNEY_FOREIGN_ADDRESS_YN";
    public static final String  FINANCIAL_TYPE_FOREIGN_AUTO_SIGNATORIES = "9";
    public static final String COMP_PHONE_YN 			="fomCO.cifKYCVO.COMP_PHONE_YN";
    public static final String  FINANCIAL_TYPE_PHONE_NUMBERS = "P";
    public static final String  FINANCIAL_TYPE_PERIOD_OUTSIDE_COUNTRY = "N";
    public static final String  FINANCIAL_TYPE_ACC_DETAILS = "O";
    public static final String OTHER_EXIST_BANK_YN		="fomCO.cifKYCVO.OTHER_EXIST_BANK_YN";
    public static final String OTHER_PASSPORT 			="fomCO.cifKYCVO.OTHER_PASSPORT_YN";
    public static final String OTHER_ID_NO 				="fomCO.cifKYCVO.OTHER_ID_NO_YN";
    public static final String PERMANENT_RESIDENT 		="fomCO.cifKYCVO.PERMANENT_RESIDENT_YN";
    public static final String STAYOTHERCOUNTRY 		="FOMCO.CIFKYCVO.STAYOTHERCOUNTRY_YN";
    public static final String TAX_PAYER_ANY_COUNTRY 	="fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN";
    public static final String HAVE_OTHER_ID 			="FOMCO.CIFKYCVO.HAVE_OTHER_ID_YN";
    public static final String OTHER_ADDRESS 			="FOMCO.CIFKYCVO.OTHER_ADDRESS_YN";
    public static final String  FINANCIAL_TYPE_ADDRESSES = "A";
    public static final String  FINANCIAL_TYPE_BENEFECIARY = "B";
    public static final String  FINANCIAL_TYPE_ISSUE_OF_ATTORNY = "T";
    public static final String HAVE_OTHER_STAND 		="FOMCO.CIFKYCVO.HAVE_OTHER_STAND_YN";
    public static final String ISSUE_OF_ATTORNEY 		="FOMCO.CIFKYCVO.ISSUE_OF_ATTORNEY_YN";
    public static final String OTHER_EXIST_BANK 		="fomCO.cifKYCVO.OTHER_EXIST_BANK_YN";
    public static final String ONE="1";
    public static final String ZERO ="0";
    public static final String C="C";
    public static final String R="R";
    public static final String O="O";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String FOUR ="4";
    public static final String FIVE="5";
    public static final String SIX="6";
    public static final String M="M";
    public static final String AML="AML";
    public static final String L= "L";
    public static final String D= "D";
    public static final String E = "E";
    public static final String TRUE = "true";
    public static final String FALSE = "false";





    

	public static final List<String> kycManagementStatusLst = new ArrayList<String>();
    	static{
    		kycManagementStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
    		kycManagementStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    		kycManagementStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		kycManagementStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
