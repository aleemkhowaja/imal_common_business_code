/**
 * @Date:Feb 13, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.csmfom; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.path.lib.log.Log;

public final class FomKYCYMCConstant
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private FomKYCYMCConstant(){
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    };
    
    // Ali Ammar Dynamic Screen
    public static final String  FINANCIAL_TYPE_AUTH_SIGNATORIES = "1";
    public static final String  FINANCIAL_TYPE_CUSTODIAN = "2";
    public static final String  FINANCIAL_TYPE_ACTUAL_BENEF = "3";
    public static final String  FINANCIAL_TYPE_BOARD_MEMBERS_MANAGER = "4";
    public static final String  FINANCIAL_TYPE_SHARE_HOLDERS = "5";
    public static final String  FINANCIAL_TYPE_PARTNER_DETAILS = "6";
    public static final String  FINANCIAL_TYPE_COMPANY_DETAILS = "7";
    public static final String  FINANCIAL_TYPE_INTER_SO = "8";
    public static final String  FINANCIAL_TYPE_FOREIGN_AUTO_SIGNATORIES = "9";
    public static final String  FINANCIAL_TYPE_ACC_DETAILS = "O";
    public static final String  FINANCIAL_TYPE_FOREIGN_INCOME = "F";
    public static final String  FINANCIAL_TYPE_FOREIGN_COUNTRY = "C";
    public static final String  FINANCIAL_TYPE_PHONE_NUMBERS = "P";
    public static final String  FINANCIAL_TYPE_PERIOD_OUTSIDE_COUNTRY = "N";
    public static final String  FINANCIAL_TYPE_IDS = "I";
    public static final String  FINANCIAL_TYPE_ADDRESSES = "A";
    public static final String  FINANCIAL_TYPE_BENEFECIARY = "B";
    public static final String  FINANCIAL_TYPE_ISSUE_OF_ATTORNY = "T";

//    public static final String KYC_FLAG_PASSPORT_LOADED="flagPassportLoaded";
//    public static final String FATCA_COMPLIANT_TYPEW9 = "C";    

    public static final ArrayList KYC_DYN_FLAGS = new ArrayList<String>(Arrays.asList(new String[] { "flagPassportLoaded"}));

    
    public static final String RECEIVE_FOREING_INCOME	="fomCO.cifKYCVO.RECEIVE_FOREIGN_INCOME_YN";
    public static final String FOREIGN_COMPANY 			="fomCO.cifKYCVO.FOREIGN_COMPANY_YN";
    public static final String COMP_OWN_EXCEEDING_PERC 	="fomCO.cifKYCVO.COMP_OWN_EXCEEDING_PERC_YN";
    public static final String PARTNER_EXCEEDING_PERC	="fomCO.cifKYCVO.PARTNER_EXCEEDING_PERC_YN";
    public static final String COMP_FOREIGN_ADDRESS 	="fomCO.cifKYCVO.COMP_FOREIGN_ADDRESS_YN";
    public static final String SO_FOREIGN_TRANSFER		="fomCO.cifKYCVO.SO_FOREIGN_TRANSFER_YN";
    public static final String ATTORNEY_FOREIGN_ADDRESS	="fomCO.cifKYCVO.ATTORNEY_FOREIGN_ADDRESS_YN";
    public static final String COMP_PHONE_YN 			="fomCO.cifKYCVO.COMP_PHONE_YN";
    public static final String OTHER_EXIST_BANK_YN		="fomCO.cifKYCVO.OTHER_EXIST_BANK_YN";
    public static final String ACTIVE_PASSIVE_YN 		="ACTIVE_PASSIVE_YN";
    public static final String FINANCIAL_YN 			="FINANCIAL_YN";
    
    public static final String OTHER_PASSPORT 			="fomCO.cifKYCVO.OTHER_PASSPORT_YN";
    public static final String OTHER_ID_NO 				="fomCO.cifKYCVO.OTHER_ID_NO_YN";
    public static final String PERMANENT_RESIDENT 		="fomCO.cifKYCVO.PERMANENT_RESIDENT_YN";
    public static final String STAYOTHERCOUNTRY 		="FOMCO.CIFKYCVO.STAYOTHERCOUNTRY_YN";
    public static final String TAX_PAYER_ANY_COUNTRY 	="fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN";
    public static final String HAVE_OTHER_ID 			="FOMCO.CIFKYCVO.HAVE_OTHER_ID_YN";
    public static final String OTHER_ADDRESS 			="FOMCO.CIFKYCVO.OTHER_ADDRESS_YN";
    public static final String HAVE_OTHER_STAND 		="FOMCO.CIFKYCVO.HAVE_OTHER_STAND_YN";
    public static final String ISSUE_OF_ATTORNEY 		="FOMCO.CIFKYCVO.ISSUE_OF_ATTORNEY_YN";
    public static final String OTHER_EXIST_BANK 		="fomCO.cifKYCVO.OTHER_EXIST_BANK_YN";

    /******************IDS***********************************/
    public static final String FULL_NAME_ID	 		="fullname";
    public static final String FIRST_NAME_ID	 		="firstName";
    public static final String LAST_NAME_ID	 		="lastName";
    public static final String CIVIL_ID_NO_ID	 		="civilIdNumber";
    public static final String GENDER_SELECT_ID 		="genderSelect";
    public static final String FINANCIAL_NATIONALITY_ID		="lookuptxt_financialNationality";
    public static final String BIRTH_COUNTRY_LKP_ID 		="lookuptxt_birthCountryLkp";
    public static final String REGION_LKP_ID	 		="lookuptxt_regionLkp";
    public static final String CITY_LKP_ID	 		="lookuptxt_cityLkp";
    public static final String PASSPORT_ISSUE_DATE_DYN_ID	="cifVO1_PASSPORT_ISSUE_DATEdyn";
    public static final String CIF_CATEG_ID	 		="cifCateg";
    public static final String KYC_CIF_TYPE_LKP_ID		="lookuptxt_kycCifTypeLkp";
    public static final String COUNTRY_OF_RESIDENCE_LKP_ID 	="lookuptxt_countryOfResidenceLkp";
    public static final String ADDRESS_REGION_LKP_ID	 	="lookuptxt_addressRegionLkp";
    public static final String ADDRESS_CITY_LKP_ID	 	="lookuptxt_addressCityLkp";
    public static final String KYC_FINANC_ADDRESS_ID		="kycFinancAddress";
    public static final String PASSPORT_NUMBER1_ID		="passportNumber1";
    public static final String SHARES_ID	 		="shares";
    public static final String SHARES_PERC_ID			="sharesPerc";
    public static final String POLITICAL_POSITION_LKP_ID 	="lookuptxt_politicalPositionLkp";
    public static final String RELATIONSHIP_ID	 		="relationship";
    public static final String POLITICALLY_EXPOSED_PERSON_ID	="politicallyExposedPerson";
    public static final String TAX_PAYER_ID	 		="taxPyerInt";
    public static final String PHONE_NO_ID	 		="phoneNo";
    public static final String GOVERNATE_ID	 		="governate";
    public static final String FOM_CASH_FLOW_SOURCES_BTN_ID	="fom_Cash_Flow_Sources_btn";
    public static final String YMC_IN_GRID_BTN_ID	 	="ymc_in_grid_btn";
    public static final String PO_BOX_ID	 		="lookuptxt_po_box";
    public static final String PO_BOX_AREA_DESC_ID	 	="poBoxAreaDesc";
    public static final String DYN_STATE_ID	 		="dyn_state";
    public static final String EXPIRY_DATE_DYN_ID	 	="EXPIRY_DATEdyn";
    public static final String ID_TYPE_ID	 		="lookuptxt_ID_TYPE";
    public static final String ID_TYPE_DESC_ID	 		="idTypeDesc";
    public static final String ID_NO_ID	 			="ID_NO";
    public static final String YMC_PURPOSE_ID	 		="ymc_purpose";
    public static final String AVENUE_ID	 		="avenue";
    public static final String FAX_ID	 			="FAX";
    public static final String HOUSE_BUILDING_ID	 	="HOUSE_BUILDING";
    public static final String CIF_DESC_ID	 		="cifDesc";
    public static final String POLITICAL_POSITION_DESC_ID	="politicalPositionDesc";
    public static final String KYC_FINANCIAL_EMPLOYER_ID	="kyc_financial_employer";
    public static final String KYC_FINANCIAL_POSITION_ID	="kyc_financial_position";
    public static final String CIF_NO_ID	 		="lookuptxt_cif_no";
    public static final String CODE_ROLE_ID	 		="lookuptxt_CODE_ROLE";
    public static final String ROLE_DESC_ID	 		="roleDesc";
    public static final String PERCENTAGE_OF_VOTING_RIGHT_ID	="percentage_of_voting_right";
    public static final String REGION_DESC_ID	 		="regionDesc";
    public static final String YMC_CITY_DESC_ID	 		="ymcCityDesc";
    public static final String NATIONALITY_DESC_ID	 	="nationalityDesc";
    public static final String POSTAL_CODE_ID	 		="lookuptxt_addressCO_POSTAL_CODE";
    public static final String MEMO_RANDOM_NO_ID	 	="memorandomNo";
    public static final String LICENCE_NO_ID	 		="licenceNo";
    public static final String YMC_COUNTRY_TAX_PAYER_DTLS_BTN_ID="ymcCountryTaxPayerDtls_btn";
    public static final String CUSTOMER_REF_ID			="customerRef";
    public static final String CIF_TYPE_ID			="cifType";
    public static final String E_MAIL_ID			="e_mail";
    public static final String COUNTRY_OF_RESIDENCE_DESC_ID	="countryOfResidenceDesc";
    public static final String ADDRESS_REGION_DESC_ID		="addressRegionDesc";
    public static final String ADDRESS_CITY_DESC_ID		="addressCityDesc";
    public static final String POSTAL_ZIP_CODE_ID		="postalZipCode";
    public static final String ECONOMIC_SECTOR_LKP_ID		="lookuptxt_economicSectorLkp";
    public static final String ECONOMIC_SECTOR_DESC_ID		="ecoSectorDesc";
    public static final String TOTAL_SHARES_ID			="totalShares";
    public static final String TOTAL_SHARES_PERC_ID		="totalSharesPerc";
    public static final String POSTAL_CODE_DESC_ID		="addressCO_postalcodeDesc";
    public static final String FINANCIAL_STREET_ID		="financial_street";
    public static final String BIRTH_COUNTRY_DESC_ID		="birthCountryDesc";
    
    //863170	BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement
    public static final String politicallyExposedPersonClientID = "politicallyExposedPersonClient";
    public static final String lookuptxt_politicalPositionClientLkpID = "lookuptxt_politicalPositionClientLkp";
    public static final String politicalPositionClientDescID = "politicalPositionClientDesc";
    public static final String politicallyExposedPersonID = "politicallyExposedPerson";
    public static final String relationShipSpecifyID = "relationShipSpecify";
    public static final String lookuptxt_relationshipID = "lookuptxt_relationship";
    public static final String relationShipDescID = "relationShipDesc";
    public static final String lookuptxt_politicalPositionLkpID = "lookuptxt_politicalPositionLkp";
    public static final String politicalPositionDescID = "politicalPositionDesc";
    public static final String otherBankAccID = "otherBankAcc";
    public static final String countryNameID = "countryName";
    public static final String lookuptxt_residentBankLkpID = "lookuptxt_residentBankLkp";
    public static final String residentBankDescID = "residentBankDesc";
    public static final String expectedValTrxID = "expectedValTrx";
    public static final String expectedValTrxMonID = "expectedValTrxMon";
    public static final String expectedValTrxYrID = "expectedValTrxYr";
    public static final String expectedNumTrxID = "expectedNumTrx";
    public static final String expectedNumTrxMonID = "expectedNumTrxMon";
    public static final String expectedNumTrxYrID = "expectedNumTrxYr";
    public static final String natureTrxCashDepYnID = "natureTrxCashDepYn";
    public static final String natureTrxChqYnID = "natureTrxChqYn";
    public static final String natureTrxLFYnID = "natureTrxLFYn";
    public static final String natureTrxIntTrnsYnID = "natureTrxIntTrnsYn";
    public static final String natureTrxSoYnID = "natureTrxSoYn";
    public static final String natureTrxOtherYnID = "natureTrxOtherYn";
    public static final String natureTrxOtherID = "natureTrxOther";
    public static final String averageAnnualIncomeID = "averageAnnualIncome";
    public static final String crsSignYnID = "crsSignYn";
    public static final String idCifNoID = "idCifNo";
    public static final String averageAnnualIncomeLblID                      ="averageAnnualIncomeLbl";
    public static final String natureTrxExeLblID                      ="natureTrxExeLbl";
    public static final String expectedNumTrxLblID                      ="expectedNumTrxLbl";
    public static final String expectedValueTrxLblID                      ="expectedValueTrxLbl";
    public static final String residentBankLblID                      ="residentBankLbl";
    public static final String countryPNameLblID                      ="countryPNameLbl";
    public static final String crsSignYnLblID 		      ="crsSignYnLbl";
    public static final String otherBankAccLblID                      ="otherBankAccLbl";
    public static final String cifIdTypeId="lookuptxt_CIF_ID_TYPE";
    public static final String cifIdTypeDescId="cifIdTypeDesc";
    //863170	BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement
    
    
    
    
    /******************NAMES*********************************/
    public static final String FULL_NAME_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_NAME";
    public static final String FIRST_NAME_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_FIRST_NAME";
    public static final String LAST_NAME_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_LAST_NAME";
    public static final String CIVIL_ID_NO_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIVIL_ID";
    public static final String GENDER_SELECT_NAME 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_GENDER";
    public static final String FINANCIAL_NATIONALITY_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_NATIONALITY";
    public static final String BIRTH_COUNTRY_LKP_NAME 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_COUNTRY";
    public static final String REGION_LKP_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANC_BIRTH_REGION";
    public static final String CITY_LKP_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_PLACE";
    public static final String PASSPORT_ISSUE_DATE_DYN_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_DATE";
    public static final String CIF_CATEG_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIF_CATEGORY";
    public static final String KYC_CIF_TYPE_LKP_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIF_TYPE";
    public static final String COUNTRY_OF_RESIDENCE_LKP_NAME 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_COUNTRY";
    public static final String ADDRESS_REGION_LKP_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANC_RESID_OP_REGION";
    public static final String ADDRESS_CITY_LKP_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CITY";
    public static final String KYC_FINANC_ADDRESS_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_ADDRESS";
    public static final String PASSPORT_NUMBER1_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PASSPORT_NUMBER";
    public static final String SHARES_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_SHARES";
    public static final String SHARES_PERC_NAME			="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_SHARES_PERC";
    public static final String POLITICAL_POSITION_LKP_NAME 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS";
    public static final String RELATIONSHIP_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP";
    public static final String POLITICALLY_EXPOSED_PERSON_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP";
    public static final String TAX_PAYER_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_TIN";
    public static final String PHONE_NO_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PHONE";
    public static final String GOVERNATE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.GOVERNATE";
    public static final String PO_BOX_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.PO_BOX";
    public static final String PO_BOX_AREA_DESC_NAME	 	="cifKycFinancialInfoCO.poBoxAreaDesc";
//    public static final String DYN_STATE_ID	 		="dyn_state";
    public static final String EXPIRY_DATE_DYN_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPIRY_DATE";
    public static final String ID_TYPE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.ID_TYPE";
    public static final String ID_TYPE_DESC_NAME 		="cifKycFinancialInfoCO.idTypeDesc";
    public static final String ID_NO_NAME 			="cifKycFinancialInfoCO.cifKycFinancialInfoVO.ID_NO";
    public static final String YMC_PURPOSE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.PURPOSE";
    public static final String AVENUE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.AVENUE";
    public static final String FAX_NAME	 			="cifKycFinancialInfoCO.cifKycFinancialInfoVO.FAX";
    public static final String HOUSE_BUILDING_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.HOUSE_BUILDING";
    public static final String CIF_DESC_NAME	 		="cifKycFinancialInfoCO.cifDesc";
    public static final String POLITICAL_POSITION_DESC_NAME	="cifKycFinancialInfoCO.KYC_FINANCIAL_POLITICAL_POS_DESC";
    public static final String KYC_FINANCIAL_EMPLOYER_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_EMPLOYER";
    public static final String KYC_FINANCIAL_POSITION_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POSITION";
    public static final String CIF_NO_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.CIF_NO";
    public static final String CODE_ROLE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.ROLE_CODE";
    public static final String ROLE_DESC_NAME	 		="cifKycFinancialInfoCO.roleDesc";
    public static final String PERCENTAGE_OF_VOTING_RIGHT_NAME	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.PERCENTAGE_VOTING_RIGHT";
    public static final String REGION_DESC_NAME	 		="cifKycFinancialInfoCO.KYC_REGION_DESC";
    public static final String YMC_CITY_DESC_NAME 		="cifKycFinancialInfoCO.KYC_CITY_DESC";
    public static final String NATIONALITY_DESC_NAME	 	="cifKycFinancialInfoCO.KYC_NATIONALITY_DESC";
    public static final String POSTAL_CODE_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.POSTAL_CODE";
    public static final String MEMO_RANDOM_NO_NAME	 	="cifKycFinancialInfoCO.cifKycFinancialInfoVO.COMP_MEMORANDUM_NO";
    public static final String LICENCE_NO_NAME	 		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.COMP_LICENSE_NO";
//    public static final String YMC_COUNTRY_TAX_PAYER_DTLS_BTN_ID="ymcCountryTaxPayerDtls_btn";
    public static final String CUSTOMER_REF_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CUSTOMER_REF";
    public static final String CIF_TYPE_NAME			="cifKycFinancialInfoCO.KYC_CIF_TYPE_DESC";
    public static final String E_MAIL_NAME			="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_EMAIL";
    public static final String COUNTRY_OF_RESIDENCE_DESC_NAME	="cifKycFinancialInfoCO.KYC_FINANCIAL_COUNTRY_DESC";
    public static final String ADDRESS_REGION_DESC_NAME		="cifKycFinancialInfoCO.KYC_ADDRESS_REGION_DESC";
    public static final String ADDRESS_CITY_DESC_NAME		="cifKycFinancialInfoCO.KYC_ADDRESS_CITY_DESC";
    public static final String POSTAL_ZIP_CODE_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_ZIP_CODE";
    public static final String ECONOMIC_SECTOR_LKP_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_ECONOMIC_SECTOR";
    public static final String ECONOMIC_SECTOR_DESC_NAME	="cifKycFinancialInfoCO.KYC_FINANCIAL_ECONOMIC_SECTOR_DESC";
    public static final String TOTAL_SHARES_NAME		="cifKycFinancialInfoCO.KYC_FINANCIAL_SHARES";
    public static final String TOTAL_SHARES_PERC_NAME		="cifKycFinancialInfoCO.KYC_FINANCIAL_SHARES_PERC";
    public static final String POSTAL_CODE_DESC_NAME		="cifKycFinancialInfoCO.postalcodeDesc";
    public static final String FINANCIAL_STREET_NAME		="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_STREET";
    public static final String BIRTH_COUNTRY_DESC_NAME		="cifKycFinancialInfoCO.KYC_FINANCIAL_BIRTH_COUNTRY_DESC";
   
    //863170	BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement
    public static final String politicallyExposedPersonClientNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP_CLIENT";
    public static final String lookuptxt_politicalPositionClientLkpNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.POLITICAL_POS_CLIENT";
    public static final String politicalPositionClientDescNAME = "cifKycFinancialInfoCO.POLITICAL_POS_CLIENT_DESC";
    public static final String politicallyExposedPersonNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP";
    public static final String relationShipSpecifyNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.RELATIONSHIP_SPECIFY";
    public static final String lookuptxt_relationshipNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP";
    public static final String relationShipDescNAME = "cifKycFinancialInfoCO.KYC_FINANCIAL_RELATION_DESC";
    public static final String lookuptxt_politicalPositionLkpNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS";
    public static final String politicalPositionDescNAME = "cifKycFinancialInfoCO.KYC_FINANCIAL_POLITICAL_POS_DESC";
    public static final String otherBankAccNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.OTHER_BANK_ACC";
    public static final String countryNameNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.COUNTRY_NAME";
    public static final String lookuptxt_residentBankLkpNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.RESIDENT_BANK_CIF_CODE";
    public static final String residentBankDescNAME = "cifKycFinancialInfoCO.RESIDENT_BANK_DESC";
    public static final String expectedValTrxNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX";
    public static final String expectedValTrxMonNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX_MON";
    public static final String expectedValTrxYrNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX_YR";
    public static final String expectedNumTrxNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX";
    public static final String expectedNumTrxMonNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX_MON";
    public static final String expectedNumTrxYrNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX_YRS";
    public static final String natureTrxCashDepYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_CASHDEP_YN";
    public static final String natureTrxChqYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_CHQ_YN";
    public static final String natureTrxLFYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_LOCAL_FOR_TRANT_YN";
    public static final String natureTrxIntTrnsYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_INTERNAL_TRANS_YN";
    public static final String natureTrxSoYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_STANDING_ORDER_YN";
    public static final String natureTrxOtherYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_OTHERS_YN";
    public static final String natureTrxOtherNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_OTHERS";
    public static final String averageAnnualIncomeNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.AVERAGE_ANNUAL_INCOME";
    public static final String crsSignYnNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.CRSSIGN_YN";
    public static final String idCifNoNAME = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.ID_CIF_NO";
    
    public static final String cifIdTypeName="cifKycFinancialInfoCO.cifKycFinancialInfoVO.CIF_ID_TYPE";
    public static final String cifIdTypeDescName="cifKycFinancialInfoCO.cifIdTypeDesc";
  //863170	BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement
}

