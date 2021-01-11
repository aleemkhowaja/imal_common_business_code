/**
 * 
 */
package com.path.vo.common.address;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class AddressCommonCO extends RetailBaseVO implements Serializable
{

    private HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement =new HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO>();
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private CIFVO cifVO = new CIFVO();
    private CTSCONTROLVO ctsControl = new CTSCONTROLVO();
    private String warningMsg;
    private String countryTelFormat;
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
    
    //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
    private BigDecimal cifType;
    //End Mark
    
    /**
     * This field corresponds to the database column CIF_ADDRESS.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CIF_ADDRESS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.LINE_NO
     */
    private BigDecimal LINE_NO;
    /**
     * This field corresponds to the database column CIF_ADDRESS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS_DESC
     */
    private String ADDRESS_DESC;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS1_ENG
     */
    private String ADDRESS1_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS2_ENG
     */
    private String ADDRESS2_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS3_ENG
     */
    private String ADDRESS3_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS4_ENG
     */
    private String ADDRESS4_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS1_ARAB
     */
    private String ADDRESS1_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS2_ARAB
     */
    private String ADDRESS2_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS3_ARAB
     */
    private String ADDRESS3_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS4_ARAB
     */
    private String ADDRESS4_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.PRINT_STAT
     */
    private BigDecimal PRINT_STAT;

    /**
     * This field corresponds to the database column CIF_ADDRESS.CONTACT_NAME
     */
    private String CONTACT_NAME;

    /**
     * This field corresponds to the database column CIF_ADDRESS.CONTACT_NAME_ARAB
     */
    private String CONTACT_NAME_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.STREET_DETAILS_ENG
     */
    private String STREET_DETAILS_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.CITY_ENG
     */
    private String CITY_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.GOVERNERATE_ENG
     */
    private String GOVERNERATE_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.STREET_DETAILS_ARAB
     */
    private String STREET_DETAILS_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.CITY_ARAB
     */
    private String CITY_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.GOVERNERATE_ARAB
     */
    private String GOVERNERATE_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.SALUTATION_ENG
     */
    private String SALUTATION_ENG;

    /**
     * This field corresponds to the database column CIF_ADDRESS.SALUTATION_ARAB
     */
    private String SALUTATION_ARAB;

    /**
     * This field corresponds to the database column CIF_ADDRESS.FAX
     */
    private String FAX;

    /**
     * This field corresponds to the database column CIF_ADDRESS.TEL
     */
    private String TEL;
   

    private String HIDDEN_TEL;
    private String HIDDEN_MOBILE;
    /**
     * This field corresponds to the database column CIF_ADDRESS.DEFAULT_ADD
     */
    private String DEFAULT_ADD;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ORIGIN_BR_I
     */
    private BigDecimal ORIGIN_BR_I;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ORIGIN_BR_U
     */
    private BigDecimal ORIGIN_BR_U;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ORIGIN_BR_D
     */
    private BigDecimal ORIGIN_BR_D;

    /**
     * This field corresponds to the database column CIF_ADDRESS.PO_BOX
     */
    private String PO_BOX;

    /**
     * This field corresponds to the database column CIF_ADDRESS.COUNTRY
     */
    private BigDecimal COUNTRY;

    /**
     * This field corresponds to the database column CIF_ADDRESS.REGION
     */
    private BigDecimal REGION;

    /**
     * This field corresponds to the database column CIF_ADDRESS.MOBILE
     */
    private String MOBILE;
    
    /**
     * This field corresponds to the database column CIF_ADDRESS.OLD_MOBILE
     */
    private String OLD_MOBILE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.HOME_TEL
     */
    private String HOME_TEL;

    /**
     * This field corresponds to the database column CIF_ADDRESS.WORK_TEL
     */
    private String WORK_TEL;

    /**
     * This field corresponds to the database column CIF_ADDRESS.EMAIL
     */
    private String EMAIL;

    /**
     * This field corresponds to the database column CIF_ADDRESS.OTHER_TEL
     */
    private String OTHER_TEL;

    /**
     * This field corresponds to the database column CIF_ADDRESS.POBOX_AREA
     */
    private BigDecimal POBOX_AREA;

    /**
     * This field corresponds to the database column CIF_ADDRESS.POSTAL_CODE1
     */
    private String POSTAL_CODE1;

    /**
     * This field corresponds to the database column CIF_ADDRESS.POSTAL_CODE
     */
    private BigDecimal POSTAL_CODE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.EXPIRY_DATE
     */
    private Date EXPIRY_DATE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.CITY_CODE
     */
    private BigDecimal CITY_CODE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.SECTOR_CODE
     */
    private BigDecimal SECTOR_CODE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.SHORT_NAME_AR
     */
    private String SHORT_NAME_AR;

    /**
     * This field corresponds to the database column CIF_ADDRESS.ADDRESS_DESCRIPTION
     */
    private BigDecimal ADDRESS_DESCRIPTION;

    /**
     * This field corresponds to the database column CIF_ADDRESS.PERM_ADDRESS
     */
    private String PERM_ADDRESS;

    /**
     * This field corresponds to the database column CIF_ADDRESS.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This field corresponds to the database column CIF_ADDRESS.TO_DATE
     */
    private Date TO_DATE;
    
    private BigDecimal PROF_ADDRESS_CODE;
    
    /**
     * This field corresponds to the database column CIF_ADDRESS.E_WALLET_YN
     */
    private String E_WALLET_YN;
    
    // For Accounts Screen
    private BigDecimal ACC_BR;
    private BigDecimal ACC_CIF;
    private BigDecimal ACC_CY;
    private BigDecimal ACC_GL;
    private BigDecimal ACC_SL;
    
    private String countryDesc;
    private String countryDescArab;
    private String regionDesc;
    private String cityDesc;
    private String sectorDesc;
    private String postalcodeDesc;
    private String residenceTypeDesc;
    private String poBoxAreaDesc;
    private String preferredLanguage;
    // For check Box on screen
	private Boolean permnAddrFlag;
	private Boolean printAddrFlag = false;
	private Boolean defaultAddrFlag = false;
	private Boolean eWalletFlag = false;//MAUREENA
    
    private String dependencyCallSource;// identify the field from where dependency is being called(when calling same dependency from multiple fields)
    private String screenName;// to identify the screen from were the page is called(added because this page is common across application)
	private String addrScreenLang;// Eng or Arb
	private String addrScreenMode;// To differentiate whether call from pop up or Main page  -- M for main and P for Pop Up
	
	private Boolean accesByTeller=true;
	
	private Date systemDate;
	
	private String IS_KYC_YN;
	
	 private boolean moreAddressWindowOpened;
	 private boolean defaultAddressFromCif;
	 private String fromDependency;//DASI180068 
	 private String postalCodeType;
	 private String STATE_ENG;
	 private String STATE_ARAB;
	 
	 //used for webservice
	 private String deleteAddress;
	
	 
	 
    // Ali Nakouzi DB170071- Online Integration with IMAL and Anti-Fraud
    // Management system

	//maria BMO180181
    private String proofAddressDesc;
    /**
     * This field corresponds to the database column CIF_ADDRESS.TELEX
     */
    private String TELEX;

    /**
     * This field corresponds to the database column CIF_ADDRESS.OLD_EMAIL
     */
    private String OLD_EMAIL;

    /**
     * This field corresponds to the database column
     * CIF_ADDRESS.LAST_CHANGE_MOBILE_EMAIL
     */
    private String LAST_CHANGE_MOBILE_EMAIL;

    /**
     * This field corresponds to the database column
     * CIF_ADDRESS.LAST_DATE_MOBILE_EMAIL
     */
    private Date LAST_DATE_MOBILE_EMAIL;
	
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CIF_NO
     *
     * @return the value of CIF_ADDRESS.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CIF_NO
     *
     * @param CIF_NO the value for CIF_ADDRESS.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.COMP_CODE
     *
     * @return the value of CIF_ADDRESS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.COMP_CODE
     *
     * @param COMP_CODE the value for CIF_ADDRESS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.LINE_NO
     *
     * @return the value of CIF_ADDRESS.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.LINE_NO
     *
     * @param LINE_NO the value for CIF_ADDRESS.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.BRANCH_CODE
     *
     * @return the value of CIF_ADDRESS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CIF_ADDRESS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS_DESC
     *
     * @return the value of CIF_ADDRESS.ADDRESS_DESC
     */
    public String getADDRESS_DESC() {
        return ADDRESS_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS_DESC
     *
     * @param ADDRESS_DESC the value for CIF_ADDRESS.ADDRESS_DESC
     */
    public void setADDRESS_DESC(String ADDRESS_DESC) {
        this.ADDRESS_DESC = ADDRESS_DESC == null ? null : ADDRESS_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS1_ENG
     *
     * @return the value of CIF_ADDRESS.ADDRESS1_ENG
     */
    public String getADDRESS1_ENG() {
        return ADDRESS1_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS1_ENG
     *
     * @param ADDRESS1_ENG the value for CIF_ADDRESS.ADDRESS1_ENG
     */
    public void setADDRESS1_ENG(String ADDRESS1_ENG) {
        this.ADDRESS1_ENG = ADDRESS1_ENG == null ? null : ADDRESS1_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS2_ENG
     *
     * @return the value of CIF_ADDRESS.ADDRESS2_ENG
     */
    public String getADDRESS2_ENG() {
        return ADDRESS2_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS2_ENG
     *
     * @param ADDRESS2_ENG the value for CIF_ADDRESS.ADDRESS2_ENG
     */
    public void setADDRESS2_ENG(String ADDRESS2_ENG) {
        this.ADDRESS2_ENG = ADDRESS2_ENG == null ? null : ADDRESS2_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS3_ENG
     *
     * @return the value of CIF_ADDRESS.ADDRESS3_ENG
     */
    public String getADDRESS3_ENG() {
        return ADDRESS3_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS3_ENG
     *
     * @param ADDRESS3_ENG the value for CIF_ADDRESS.ADDRESS3_ENG
     */
    public void setADDRESS3_ENG(String ADDRESS3_ENG) {
        this.ADDRESS3_ENG = ADDRESS3_ENG == null ? null : ADDRESS3_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS4_ENG
     *
     * @return the value of CIF_ADDRESS.ADDRESS4_ENG
     */
    public String getADDRESS4_ENG() {
        return ADDRESS4_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS4_ENG
     *
     * @param ADDRESS4_ENG the value for CIF_ADDRESS.ADDRESS4_ENG
     */
    public void setADDRESS4_ENG(String ADDRESS4_ENG) {
        this.ADDRESS4_ENG = ADDRESS4_ENG == null ? null : ADDRESS4_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS1_ARAB
     *
     * @return the value of CIF_ADDRESS.ADDRESS1_ARAB
     */
    public String getADDRESS1_ARAB() {
        return ADDRESS1_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS1_ARAB
     *
     * @param ADDRESS1_ARAB the value for CIF_ADDRESS.ADDRESS1_ARAB
     */
    public void setADDRESS1_ARAB(String ADDRESS1_ARAB) {
        this.ADDRESS1_ARAB = ADDRESS1_ARAB == null ? null : ADDRESS1_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS2_ARAB
     *
     * @return the value of CIF_ADDRESS.ADDRESS2_ARAB
     */
    public String getADDRESS2_ARAB() {
        return ADDRESS2_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS2_ARAB
     *
     * @param ADDRESS2_ARAB the value for CIF_ADDRESS.ADDRESS2_ARAB
     */
    public void setADDRESS2_ARAB(String ADDRESS2_ARAB) {
        this.ADDRESS2_ARAB = ADDRESS2_ARAB == null ? null : ADDRESS2_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS3_ARAB
     *
     * @return the value of CIF_ADDRESS.ADDRESS3_ARAB
     */
    public String getADDRESS3_ARAB() {
        return ADDRESS3_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS3_ARAB
     *
     * @param ADDRESS3_ARAB the value for CIF_ADDRESS.ADDRESS3_ARAB
     */
    public void setADDRESS3_ARAB(String ADDRESS3_ARAB) {
        this.ADDRESS3_ARAB = ADDRESS3_ARAB == null ? null : ADDRESS3_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS4_ARAB
     *
     * @return the value of CIF_ADDRESS.ADDRESS4_ARAB
     */
    public String getADDRESS4_ARAB() {
        return ADDRESS4_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS4_ARAB
     *
     * @param ADDRESS4_ARAB the value for CIF_ADDRESS.ADDRESS4_ARAB
     */
    public void setADDRESS4_ARAB(String ADDRESS4_ARAB) {
        this.ADDRESS4_ARAB = ADDRESS4_ARAB == null ? null : ADDRESS4_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.PRINT_STAT
     *
     * @return the value of CIF_ADDRESS.PRINT_STAT
     */
    public BigDecimal getPRINT_STAT() {
        return PRINT_STAT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.PRINT_STAT
     *
     * @param PRINT_STAT the value for CIF_ADDRESS.PRINT_STAT
     */
    public void setPRINT_STAT(BigDecimal PRINT_STAT) {
        this.PRINT_STAT = PRINT_STAT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CONTACT_NAME
     *
     * @return the value of CIF_ADDRESS.CONTACT_NAME
     */
    public String getCONTACT_NAME() {
        return CONTACT_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CONTACT_NAME
     *
     * @param CONTACT_NAME the value for CIF_ADDRESS.CONTACT_NAME
     */
    public void setCONTACT_NAME(String CONTACT_NAME) {
        this.CONTACT_NAME = CONTACT_NAME == null ? null : CONTACT_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CONTACT_NAME_ARAB
     *
     * @return the value of CIF_ADDRESS.CONTACT_NAME_ARAB
     */
    public String getCONTACT_NAME_ARAB() {
        return CONTACT_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CONTACT_NAME_ARAB
     *
     * @param CONTACT_NAME_ARAB the value for CIF_ADDRESS.CONTACT_NAME_ARAB
     */
    public void setCONTACT_NAME_ARAB(String CONTACT_NAME_ARAB) {
        this.CONTACT_NAME_ARAB = CONTACT_NAME_ARAB == null ? null : CONTACT_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.STREET_DETAILS_ENG
     *
     * @return the value of CIF_ADDRESS.STREET_DETAILS_ENG
     */
    public String getSTREET_DETAILS_ENG() {
        return STREET_DETAILS_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.STREET_DETAILS_ENG
     *
     * @param STREET_DETAILS_ENG the value for CIF_ADDRESS.STREET_DETAILS_ENG
     */
    public void setSTREET_DETAILS_ENG(String STREET_DETAILS_ENG) {
        this.STREET_DETAILS_ENG = STREET_DETAILS_ENG == null ? null : STREET_DETAILS_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CITY_ENG
     *
     * @return the value of CIF_ADDRESS.CITY_ENG
     */
    public String getCITY_ENG() {
        return CITY_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CITY_ENG
     *
     * @param CITY_ENG the value for CIF_ADDRESS.CITY_ENG
     */
    public void setCITY_ENG(String CITY_ENG) {
        this.CITY_ENG = CITY_ENG == null ? null : CITY_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.GOVERNERATE_ENG
     *
     * @return the value of CIF_ADDRESS.GOVERNERATE_ENG
     */
    public String getGOVERNERATE_ENG() {
        return GOVERNERATE_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.GOVERNERATE_ENG
     *
     * @param GOVERNERATE_ENG the value for CIF_ADDRESS.GOVERNERATE_ENG
     */
    public void setGOVERNERATE_ENG(String GOVERNERATE_ENG) {
        this.GOVERNERATE_ENG = GOVERNERATE_ENG == null ? null : GOVERNERATE_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.STREET_DETAILS_ARAB
     *
     * @return the value of CIF_ADDRESS.STREET_DETAILS_ARAB
     */
    public String getSTREET_DETAILS_ARAB() {
        return STREET_DETAILS_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.STREET_DETAILS_ARAB
     *
     * @param STREET_DETAILS_ARAB the value for CIF_ADDRESS.STREET_DETAILS_ARAB
     */
    public void setSTREET_DETAILS_ARAB(String STREET_DETAILS_ARAB) {
        this.STREET_DETAILS_ARAB = STREET_DETAILS_ARAB == null ? null : STREET_DETAILS_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CITY_ARAB
     *
     * @return the value of CIF_ADDRESS.CITY_ARAB
     */
    public String getCITY_ARAB() {
        return CITY_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CITY_ARAB
     *
     * @param CITY_ARAB the value for CIF_ADDRESS.CITY_ARAB
     */
    public void setCITY_ARAB(String CITY_ARAB) {
        this.CITY_ARAB = CITY_ARAB == null ? null : CITY_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.GOVERNERATE_ARAB
     *
     * @return the value of CIF_ADDRESS.GOVERNERATE_ARAB
     */
    public String getGOVERNERATE_ARAB() {
        return GOVERNERATE_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.GOVERNERATE_ARAB
     *
     * @param GOVERNERATE_ARAB the value for CIF_ADDRESS.GOVERNERATE_ARAB
     */
    public void setGOVERNERATE_ARAB(String GOVERNERATE_ARAB) {
        this.GOVERNERATE_ARAB = GOVERNERATE_ARAB == null ? null : GOVERNERATE_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.SALUTATION_ENG
     *
     * @return the value of CIF_ADDRESS.SALUTATION_ENG
     */
    public String getSALUTATION_ENG() {
        return SALUTATION_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.SALUTATION_ENG
     *
     * @param SALUTATION_ENG the value for CIF_ADDRESS.SALUTATION_ENG
     */
    public void setSALUTATION_ENG(String SALUTATION_ENG) {
        this.SALUTATION_ENG = SALUTATION_ENG == null ? null : SALUTATION_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.SALUTATION_ARAB
     *
     * @return the value of CIF_ADDRESS.SALUTATION_ARAB
     */
    public String getSALUTATION_ARAB() {
        return SALUTATION_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.SALUTATION_ARAB
     *
     * @param SALUTATION_ARAB the value for CIF_ADDRESS.SALUTATION_ARAB
     */
    public void setSALUTATION_ARAB(String SALUTATION_ARAB) {
        this.SALUTATION_ARAB = SALUTATION_ARAB == null ? null : SALUTATION_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.FAX
     *
     * @return the value of CIF_ADDRESS.FAX
     */
    public String getFAX() {
        return FAX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.FAX
     *
     * @param FAX the value for CIF_ADDRESS.FAX
     */
    public void setFAX(String FAX) {
        this.FAX = FAX == null ? null : FAX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.TEL
     *
     * @return the value of CIF_ADDRESS.TEL
     */
    public String getTEL() {
        return TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.TEL
     *
     * @param TEL the value for CIF_ADDRESS.TEL
     */
    public void setTEL(String TEL) {
        this.TEL = TEL == null ? null : TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.DEFAULT_ADD
     *
     * @return the value of CIF_ADDRESS.DEFAULT_ADD
     */
    public String getDEFAULT_ADD() {
        return DEFAULT_ADD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.DEFAULT_ADD
     *
     * @param DEFAULT_ADD the value for CIF_ADDRESS.DEFAULT_ADD
     */
    public void setDEFAULT_ADD(String DEFAULT_ADD) {
        this.DEFAULT_ADD = DEFAULT_ADD == null ? null : DEFAULT_ADD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ORIGIN_BR_I
     *
     * @return the value of CIF_ADDRESS.ORIGIN_BR_I
     */
    public BigDecimal getORIGIN_BR_I() {
        return ORIGIN_BR_I;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ORIGIN_BR_I
     *
     * @param ORIGIN_BR_I the value for CIF_ADDRESS.ORIGIN_BR_I
     */
    public void setORIGIN_BR_I(BigDecimal ORIGIN_BR_I) {
        this.ORIGIN_BR_I = ORIGIN_BR_I;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ORIGIN_BR_U
     *
     * @return the value of CIF_ADDRESS.ORIGIN_BR_U
     */
    public BigDecimal getORIGIN_BR_U() {
        return ORIGIN_BR_U;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ORIGIN_BR_U
     *
     * @param ORIGIN_BR_U the value for CIF_ADDRESS.ORIGIN_BR_U
     */
    public void setORIGIN_BR_U(BigDecimal ORIGIN_BR_U) {
        this.ORIGIN_BR_U = ORIGIN_BR_U;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ORIGIN_BR_D
     *
     * @return the value of CIF_ADDRESS.ORIGIN_BR_D
     */
    public BigDecimal getORIGIN_BR_D() {
        return ORIGIN_BR_D;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ORIGIN_BR_D
     *
     * @param ORIGIN_BR_D the value for CIF_ADDRESS.ORIGIN_BR_D
     */
    public void setORIGIN_BR_D(BigDecimal ORIGIN_BR_D) {
        this.ORIGIN_BR_D = ORIGIN_BR_D;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.PO_BOX
     *
     * @return the value of CIF_ADDRESS.PO_BOX
     */
    public String getPO_BOX() {
        return PO_BOX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.PO_BOX
     *
     * @param PO_BOX the value for CIF_ADDRESS.PO_BOX
     */
    public void setPO_BOX(String PO_BOX) {
        this.PO_BOX = PO_BOX == null ? null : PO_BOX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.COUNTRY
     *
     * @return the value of CIF_ADDRESS.COUNTRY
     */
    public BigDecimal getCOUNTRY() {
        return COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.COUNTRY
     *
     * @param COUNTRY the value for CIF_ADDRESS.COUNTRY
     */
    public void setCOUNTRY(BigDecimal COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.REGION
     *
     * @return the value of CIF_ADDRESS.REGION
     */
    public BigDecimal getREGION() {
        return REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.REGION
     *
     * @param REGION the value for CIF_ADDRESS.REGION
     */
    public void setREGION(BigDecimal REGION) {
        this.REGION = REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.MOBILE
     *
     * @return the value of CIF_ADDRESS.MOBILE
     */
    public String getMOBILE() {
        return MOBILE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.MOBILE
     *
     * @param MOBILE the value for CIF_ADDRESS.MOBILE
     */
    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.HOME_TEL
     *
     * @return the value of CIF_ADDRESS.HOME_TEL
     */
    public String getHOME_TEL() {
        return HOME_TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.HOME_TEL
     *
     * @param HOME_TEL the value for CIF_ADDRESS.HOME_TEL
     */
    public void setHOME_TEL(String HOME_TEL) {
        this.HOME_TEL = HOME_TEL == null ? null : HOME_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.WORK_TEL
     *
     * @return the value of CIF_ADDRESS.WORK_TEL
     */
    public String getWORK_TEL() {
        return WORK_TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.WORK_TEL
     *
     * @param WORK_TEL the value for CIF_ADDRESS.WORK_TEL
     */
    public void setWORK_TEL(String WORK_TEL) {
        this.WORK_TEL = WORK_TEL == null ? null : WORK_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.EMAIL
     *
     * @return the value of CIF_ADDRESS.EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.EMAIL
     *
     * @param EMAIL the value for CIF_ADDRESS.EMAIL
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.OTHER_TEL
     *
     * @return the value of CIF_ADDRESS.OTHER_TEL
     */
    public String getOTHER_TEL() {
        return OTHER_TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.OTHER_TEL
     *
     * @param OTHER_TEL the value for CIF_ADDRESS.OTHER_TEL
     */
    public void setOTHER_TEL(String OTHER_TEL) {
        this.OTHER_TEL = OTHER_TEL == null ? null : OTHER_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.POBOX_AREA
     *
     * @return the value of CIF_ADDRESS.POBOX_AREA
     */
    public BigDecimal getPOBOX_AREA() {
        return POBOX_AREA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.POBOX_AREA
     *
     * @param POBOX_AREA the value for CIF_ADDRESS.POBOX_AREA
     */
    public void setPOBOX_AREA(BigDecimal POBOX_AREA) {
        this.POBOX_AREA = POBOX_AREA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.POSTAL_CODE1
     *
     * @return the value of CIF_ADDRESS.POSTAL_CODE1
     */
    public String getPOSTAL_CODE1() {
        return POSTAL_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.POSTAL_CODE1
     *
     * @param POSTAL_CODE1 the value for CIF_ADDRESS.POSTAL_CODE1
     */
    public void setPOSTAL_CODE1(String POSTAL_CODE1) {
        this.POSTAL_CODE1 = POSTAL_CODE1 == null ? null : POSTAL_CODE1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.POSTAL_CODE
     *
     * @return the value of CIF_ADDRESS.POSTAL_CODE
     */
    public BigDecimal getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.POSTAL_CODE
     *
     * @param POSTAL_CODE the value for CIF_ADDRESS.POSTAL_CODE
     */
    public void setPOSTAL_CODE(BigDecimal POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDITIONAL_REFERENCE
     *
     * @return the value of CIF_ADDRESS.ADDITIONAL_REFERENCE
     */
    public String getADDITIONAL_REFERENCE() {
        return ADDITIONAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDITIONAL_REFERENCE
     *
     * @param ADDITIONAL_REFERENCE the value for CIF_ADDRESS.ADDITIONAL_REFERENCE
     */
    public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE) {
        this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE == null ? null : ADDITIONAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.EXPIRY_DATE
     *
     * @return the value of CIF_ADDRESS.EXPIRY_DATE
     */
    public Date getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.EXPIRY_DATE
     *
     * @param EXPIRY_DATE the value for CIF_ADDRESS.EXPIRY_DATE
     */
    public void setEXPIRY_DATE(Date EXPIRY_DATE) {
        this.EXPIRY_DATE = EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.CITY_CODE
     *
     * @return the value of CIF_ADDRESS.CITY_CODE
     */
    public BigDecimal getCITY_CODE() {
        return CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.CITY_CODE
     *
     * @param CITY_CODE the value for CIF_ADDRESS.CITY_CODE
     */
    public void setCITY_CODE(BigDecimal CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.SECTOR_CODE
     *
     * @return the value of CIF_ADDRESS.SECTOR_CODE
     */
    public BigDecimal getSECTOR_CODE() {
        return SECTOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.SECTOR_CODE
     *
     * @param SECTOR_CODE the value for CIF_ADDRESS.SECTOR_CODE
     */
    public void setSECTOR_CODE(BigDecimal SECTOR_CODE) {
        this.SECTOR_CODE = SECTOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.SHORT_NAME_AR
     *
     * @return the value of CIF_ADDRESS.SHORT_NAME_AR
     */
    public String getSHORT_NAME_AR() {
        return SHORT_NAME_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.SHORT_NAME_AR
     *
     * @param SHORT_NAME_AR the value for CIF_ADDRESS.SHORT_NAME_AR
     */
    public void setSHORT_NAME_AR(String SHORT_NAME_AR) {
        this.SHORT_NAME_AR = SHORT_NAME_AR == null ? null : SHORT_NAME_AR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.ADDRESS_DESCRIPTION
     *
     * @return the value of CIF_ADDRESS.ADDRESS_DESCRIPTION
     */
    public BigDecimal getADDRESS_DESCRIPTION() {
        return ADDRESS_DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.ADDRESS_DESCRIPTION
     *
     * @param ADDRESS_DESCRIPTION the value for CIF_ADDRESS.ADDRESS_DESCRIPTION
     */
    public void setADDRESS_DESCRIPTION(BigDecimal ADDRESS_DESCRIPTION) {
        this.ADDRESS_DESCRIPTION = ADDRESS_DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.PERM_ADDRESS
     *
     * @return the value of CIF_ADDRESS.PERM_ADDRESS
     */
    public String getPERM_ADDRESS() {
        return PERM_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.PERM_ADDRESS
     *
     * @param PERM_ADDRESS the value for CIF_ADDRESS.PERM_ADDRESS
     */
    public void setPERM_ADDRESS(String PERM_ADDRESS) {
        this.PERM_ADDRESS = PERM_ADDRESS == null ? null : PERM_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.FROM_DATE
     *
     * @return the value of CIF_ADDRESS.FROM_DATE
     */
    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.FROM_DATE
     *
     * @param FROM_DATE the value for CIF_ADDRESS.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ADDRESS.TO_DATE
     *
     * @return the value of CIF_ADDRESS.TO_DATE
     */
    public Date getTO_DATE() {
        return TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ADDRESS.TO_DATE
     *
     * @param TO_DATE the value for CIF_ADDRESS.TO_DATE
     */
    public void setTO_DATE(Date TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    public String getCountryDesc()
    {
	return countryDesc;
    }

    public void setCountryDesc(String countryDesc)
    {
	this.countryDesc = countryDesc;
    }

    public String getRegionDesc()
    {
	return regionDesc;
    }

    public void setRegionDesc(String regionDesc)
    {
	this.regionDesc = regionDesc;
    }

    public String getCityDesc()
    {
	return cityDesc;
    }

    public void setCityDesc(String cityDesc)
    {
	this.cityDesc = cityDesc;
    }

    public String getSectorDesc()
    {
	return sectorDesc;
    }

    public void setSectorDesc(String sectorDesc)
    {
	this.sectorDesc = sectorDesc;
    }

    public String getPostalcodeDesc()
    {
	return postalcodeDesc;
    }

    public void setPostalcodeDesc(String postalcodeDesc)
    {
	this.postalcodeDesc = postalcodeDesc;
    }

    public String getResidenceTypeDesc()
    {
	return residenceTypeDesc;
    }

    public void setResidenceTypeDesc(String residenceTypeDesc)
    {
	this.residenceTypeDesc = residenceTypeDesc;
    }

    public String getPoBoxAreaDesc()
    {
	return poBoxAreaDesc;
    }

    public void setPoBoxAreaDesc(String poBoxAreaDesc)
    {
	this.poBoxAreaDesc = poBoxAreaDesc;
    }

    public Boolean getPermnAddrFlag()
    {
	return permnAddrFlag;
    }

    public void setPermnAddrFlag(Boolean permnAddrFlag)
    {
	this.permnAddrFlag = permnAddrFlag;
    }

    public Boolean getDefaultAddrFlag()
    {
	return defaultAddrFlag;
    }

    public void setDefaultAddrFlag(Boolean defaultAddrFlag)
    {
	this.defaultAddrFlag = defaultAddrFlag;
    }

    public Boolean getPrintAddrFlag()
    {
	return printAddrFlag;
    }

    public void setPrintAddrFlag(Boolean printAddrFlag)
    {
	this.printAddrFlag = printAddrFlag;
    }

    public String getAddrScreenLang()
    {
	return addrScreenLang;
    }

    public void setAddrScreenLang(String addrScreenLang)
    {
	this.addrScreenLang = addrScreenLang;
    }

    public String getAddrScreenMode()
    {
	return addrScreenMode;
    }

    public void setAddrScreenMode(String addrScreenMode)
    {
	this.addrScreenMode = addrScreenMode;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public String getDependencyCallSource()
    {
	return dependencyCallSource;
    }

    public void setDependencyCallSource(String dependencyCallSource)
    {
	this.dependencyCallSource = dependencyCallSource;
    }

    public String getScreenName()
    {
	return screenName;
    }

    public void setScreenName(String screenName)
    {
	this.screenName = screenName;
    }

    public Date getSystemDate()
    {
	return systemDate;
    }

    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }

    public BigDecimal getACC_BR()
    {
	return ACC_BR;
    }

    public void setACC_BR(BigDecimal aCCBR)
    {
	ACC_BR = aCCBR;
    }

    public BigDecimal getACC_CIF()
    {
	return ACC_CIF;
    }

    public void setACC_CIF(BigDecimal aCCCIF)
    {
	ACC_CIF = aCCCIF;
    }

    public BigDecimal getACC_CY()
    {
	return ACC_CY;
    }

    public void setACC_CY(BigDecimal aCCCY)
    {
	ACC_CY = aCCCY;
    }

    public BigDecimal getACC_GL()
    {
	return ACC_GL;
    }

    public void setACC_GL(BigDecimal aCCGL)
    {
	ACC_GL = aCCGL;
    }

    public BigDecimal getACC_SL()
    {
	return ACC_SL;
    }

    public void setACC_SL(BigDecimal aCCSL)
    {
	ACC_SL = aCCSL;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
	return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
	this.buisnessElement = buisnessElement;
    }

    public CIFCONTROLVO getCifControlVO()
    {
        return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
        this.cifControlVO = cifControlVO;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public CTSCONTROLVO getCtsControl()
    {
        return ctsControl;
    }

    public void setCtsControl(CTSCONTROLVO ctsControl)
    {
        this.ctsControl = ctsControl;
    }

    public String getIS_KYC_YN()
    {
        return IS_KYC_YN;
    }

    public void setIS_KYC_YN(String iSKYCYN)
    {
        IS_KYC_YN = iSKYCYN;
    }

    /**
     * @return the warningMsg
     */
    public String getWarningMsg()
    {
        return warningMsg;
    }

    /**
     * @param warningMsg the warningMsg to set
     */
    public void setWarningMsg(String warningMsg)
    {
        this.warningMsg = warningMsg;
    }

    public String getCountryTelFormat()
    {
        return countryTelFormat;
    }

    public void setCountryTelFormat(String countryTelFormat)
    {
        this.countryTelFormat = countryTelFormat;
    }

    public boolean isMoreAddressWindowOpened()
    {
        return moreAddressWindowOpened;
    }

    public void setMoreAddressWindowOpened(boolean moreAddressWindowOpened)
    {
        this.moreAddressWindowOpened = moreAddressWindowOpened;
    }

    public boolean isDefaultAddressFromCif()
    {
        return defaultAddressFromCif;
    }

    public void setDefaultAddressFromCif(boolean defaultAddressFromCif)
    {
        this.defaultAddressFromCif = defaultAddressFromCif;
    }

    public String getCountryDescArab()
    {
        return countryDescArab;
    }

    public void setCountryDescArab(String countryDescArab)
    {
        this.countryDescArab = countryDescArab;
    }

    public String getPostalCodeType()
    {
        return postalCodeType;
    }

    public void setPostalCodeType(String postalCodeType)
    {
        this.postalCodeType = postalCodeType;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public String getSTATE_ENG()
    {
        return STATE_ENG;
    }

    public void setSTATE_ENG(String sTATE_ENG)
    {
        STATE_ENG = sTATE_ENG;
    }

    public String getSTATE_ARAB()
    {
        return STATE_ARAB;
    }

    public void setSTATE_ARAB(String sTATE_ARAB)
    {
        STATE_ARAB = sTATE_ARAB;
    }


    public Boolean geteWalletFlag()
    {
        return eWalletFlag;
    }

    public void seteWalletFlag(Boolean eWalletFlag)
    {
        this.eWalletFlag = eWalletFlag;
    }

    public String getE_WALLET_YN()
    {
        return E_WALLET_YN;
    }

    public void setE_WALLET_YN(String e_WALLET_YN)
    {
        E_WALLET_YN = e_WALLET_YN;
    }

    public String getHIDDEN_TEL()
    {
        return HIDDEN_TEL;
    }

    public void setHIDDEN_TEL(String hIDDEN_TEL)
    {
        HIDDEN_TEL = hIDDEN_TEL;
    }

    public String getHIDDEN_MOBILE()
    {
        return HIDDEN_MOBILE;
    }

    public void setHIDDEN_MOBILE(String hIDDEN_MOBILE)
    {
        HIDDEN_MOBILE = hIDDEN_MOBILE;
    }

    public String getOLD_MOBILE()
    {
        return OLD_MOBILE;
    }

    public void setOLD_MOBILE(String oLD_MOBILE)
    {
        OLD_MOBILE = oLD_MOBILE;
    }

    public String getOLD_EMAIL()
    {
        return OLD_EMAIL;
    }

    public void setOLD_EMAIL(String oLD_EMAIL)
    {
        OLD_EMAIL = oLD_EMAIL;
    }

    public String getLAST_CHANGE_MOBILE_EMAIL()
    {
        return LAST_CHANGE_MOBILE_EMAIL;
    }

    public void setLAST_CHANGE_MOBILE_EMAIL(String lAST_CHANGE_MOBILE_EMAIL)
    {
        LAST_CHANGE_MOBILE_EMAIL = lAST_CHANGE_MOBILE_EMAIL;
    }

    public Date getLAST_DATE_MOBILE_EMAIL()
    {
        return LAST_DATE_MOBILE_EMAIL;
    }

    public void setLAST_DATE_MOBILE_EMAIL(Date lAST_DATE_MOBILE_EMAIL)
    {
        LAST_DATE_MOBILE_EMAIL = lAST_DATE_MOBILE_EMAIL;
    }

    
    public String getDeleteAddress()
    {
        return deleteAddress;
    }

    public void setDeleteAddress(String deleteAddress)
    {
        this.deleteAddress = deleteAddress;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

    public String getTELEX()
    {
        return TELEX;
    }

    public void setTELEX(String tELEX)
    {
        TELEX = tELEX;
    }

    public String getFromDependency()
    {
        return fromDependency;
    }

    public void setFromDependency(String fromDependency)
    {
        this.fromDependency = fromDependency;
    }

	public String getProofAddressDesc() {
		return proofAddressDesc;
	}

	public void setProofAddressDesc(String proofAddressDesc) {
		this.proofAddressDesc = proofAddressDesc;
	}

	public BigDecimal getPROF_ADDRESS_CODE() {
		return PROF_ADDRESS_CODE;
	}

	public void setPROF_ADDRESS_CODE(BigDecimal pROF_ADDRESS_CODE) {
		PROF_ADDRESS_CODE = pROF_ADDRESS_CODE;
	}

}
