package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CIF_OCCUPATIONVO extends CIF_OCCUPATIONVOKey {
    /**
     * This field corresponds to the database column CIF_OCCUPATION.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.TO_DATE
     */
    private Date TO_DATE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_CIF
     */
    private BigDecimal INSTITUTION_CIF;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_NAME
     */
    private String INSTITUTION_NAME;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.POSITION_CODE
     */
    private BigDecimal POSITION_CODE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.TEL
     */
    private String TEL;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.FAX
     */
    private String FAX;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.COMMENTS
     */
    private String COMMENTS;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.DIVISION
     */
    private BigDecimal DIVISION;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.DEPARTMENT
     */
    private BigDecimal DEPARTMENT;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_1
     */
    private String ADDRESSE_1;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_2
     */
    private String ADDRESSE_2;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_3
     */
    private String ADDRESSE_3;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.PO_BOX
     */
    private String PO_BOX;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.MONTHLY_BASIC_SALARY
     */
    private BigDecimal MONTHLY_BASIC_SALARY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.TRANSPORTATION_FEES
     */
    private BigDecimal TRANSPORTATION_FEES;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.LOCATION_FEES
     */
    private BigDecimal LOCATION_FEES;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.OTHER_FEES
     */
    private BigDecimal OTHER_FEES;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.MONTHLY_TOTAL_SALARY
     */
    private BigDecimal MONTHLY_TOTAL_SALARY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.SALARY_CASHED_DATE
     */
    private Date SALARY_CASHED_DATE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.OTHER_INCOME
     */
    private BigDecimal OTHER_INCOME;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INCOME_SOURCE
     */
    private String INCOME_SOURCE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.TYPE
     */
    private String TYPE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ANNUAL_SALARY
     */
    private BigDecimal ANNUAL_SALARY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.EMPLOYER_TITLE
     */
    private String EMPLOYER_TITLE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.LEGAL_ACTION
     */
    private String LEGAL_ACTION;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_CITY
     */
    private String INSTITUTION_CITY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.POSTAL_CODE
     */
    private BigDecimal POSTAL_CODE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.POSTAL_ADDR_COUNTRY
     */
    private BigDecimal POSTAL_ADDR_COUNTRY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.MOBILE
     */
    private String MOBILE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.POSTAL_ADDR_CITY
     */
    private String POSTAL_ADDR_CITY;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_REGION
     */
    private BigDecimal INSTITUTION_REGION;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.EMAIL
     */
    private String EMAIL;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.POSTAL_ADDR_REGION
     */
    private BigDecimal POSTAL_ADDR_REGION;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.FROM_DATE_HIJRI
     */
    private Date FROM_DATE_HIJRI;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_NAME_ARAB
     */
    private String INSTITUTION_NAME_ARAB;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.INSTITUTION_CITY_ARAB
     */
    private String INSTITUTION_CITY_ARAB;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_1_ARAB
     */
    private String ADDRESSE_1_ARAB;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_2_ARAB
     */
    private String ADDRESSE_2_ARAB;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.ADDRESSE_3_ARAB
     */
    private String ADDRESSE_3_ARAB;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.RETIREMENT_AGE
     */
    private BigDecimal RETIREMENT_AGE;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.EMP_LEGAL_STATUS
     */
    private BigDecimal EMP_LEGAL_STATUS;

    /**
     * This field corresponds to the database column CIF_OCCUPATION.CONFIRMED_EMPLOYMENT
     */
    private String CONFIRMED_EMPLOYMENT;

    
    /**
     * This field corresponds to the database column CIF_OCCUPATION.MAIN_OCCUPATION_YN
     */
    private String MAIN_OCCUPATION_YN;
    
    private BigDecimal POSTAL_CODE_AREA;

    private BigDecimal CITY;
    
    private String AVENUE;
    
    private String STREET;
    
    /**
     * This field corresponds to the database column CIF_OCCUPATION.STAFF_EMPLOYEE_NO
     */
    private String STAFF_EMPLOYEE_NO;


    /**
     * This field corresponds to the database column CIF_OCCUPATION.COUNTRY
     */
    private BigDecimal COUNTRY;
    
    /**
     * This field corresponds to the database column CIF_OCCUPATION.REGION
     */
    private BigDecimal REGION;    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.FROM_DATE
     *
     * @return the value of CIF_OCCUPATION.FROM_DATE
     */
    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.FROM_DATE
     *
     * @param FROM_DATE the value for CIF_OCCUPATION.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.TO_DATE
     *
     * @return the value of CIF_OCCUPATION.TO_DATE
     */
    public Date getTO_DATE() {
        return TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.TO_DATE
     *
     * @param TO_DATE the value for CIF_OCCUPATION.TO_DATE
     */
    public void setTO_DATE(Date TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_CIF
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_CIF
     */
    public BigDecimal getINSTITUTION_CIF() {
        return INSTITUTION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_CIF
     *
     * @param INSTITUTION_CIF the value for CIF_OCCUPATION.INSTITUTION_CIF
     */
    public void setINSTITUTION_CIF(BigDecimal INSTITUTION_CIF) {
        this.INSTITUTION_CIF = INSTITUTION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_NAME
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_NAME
     */
    public String getINSTITUTION_NAME() {
        return INSTITUTION_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_NAME
     *
     * @param INSTITUTION_NAME the value for CIF_OCCUPATION.INSTITUTION_NAME
     */
    public void setINSTITUTION_NAME(String INSTITUTION_NAME) {
        this.INSTITUTION_NAME = INSTITUTION_NAME == null ? null : INSTITUTION_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.POSITION_CODE
     *
     * @return the value of CIF_OCCUPATION.POSITION_CODE
     */
    public BigDecimal getPOSITION_CODE() {
        return POSITION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.POSITION_CODE
     *
     * @param POSITION_CODE the value for CIF_OCCUPATION.POSITION_CODE
     */
    public void setPOSITION_CODE(BigDecimal POSITION_CODE) {
        this.POSITION_CODE = POSITION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.TEL
     *
     * @return the value of CIF_OCCUPATION.TEL
     */
    public String getTEL() {
        return TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.TEL
     *
     * @param TEL the value for CIF_OCCUPATION.TEL
     */
    public void setTEL(String TEL) {
        this.TEL = TEL == null ? null : TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.FAX
     *
     * @return the value of CIF_OCCUPATION.FAX
     */
    public String getFAX() {
        return FAX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.FAX
     *
     * @param FAX the value for CIF_OCCUPATION.FAX
     */
    public void setFAX(String FAX) {
        this.FAX = FAX == null ? null : FAX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.COMMENTS
     *
     * @return the value of CIF_OCCUPATION.COMMENTS
     */
    public String getCOMMENTS() {
        return COMMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.COMMENTS
     *
     * @param COMMENTS the value for CIF_OCCUPATION.COMMENTS
     */
    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS == null ? null : COMMENTS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.DIVISION
     *
     * @return the value of CIF_OCCUPATION.DIVISION
     */
    public BigDecimal getDIVISION() {
        return DIVISION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.DIVISION
     *
     * @param DIVISION the value for CIF_OCCUPATION.DIVISION
     */
    public void setDIVISION(BigDecimal DIVISION) {
        this.DIVISION = DIVISION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.DEPARTMENT
     *
     * @return the value of CIF_OCCUPATION.DEPARTMENT
     */
    public BigDecimal getDEPARTMENT() {
        return DEPARTMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.DEPARTMENT
     *
     * @param DEPARTMENT the value for CIF_OCCUPATION.DEPARTMENT
     */
    public void setDEPARTMENT(BigDecimal DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_1
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_1
     */
    public String getADDRESSE_1() {
        return ADDRESSE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_1
     *
     * @param ADDRESSE_1 the value for CIF_OCCUPATION.ADDRESSE_1
     */
    public void setADDRESSE_1(String ADDRESSE_1) {
        this.ADDRESSE_1 = ADDRESSE_1 == null ? null : ADDRESSE_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_2
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_2
     */
    public String getADDRESSE_2() {
        return ADDRESSE_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_2
     *
     * @param ADDRESSE_2 the value for CIF_OCCUPATION.ADDRESSE_2
     */
    public void setADDRESSE_2(String ADDRESSE_2) {
        this.ADDRESSE_2 = ADDRESSE_2 == null ? null : ADDRESSE_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_3
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_3
     */
    public String getADDRESSE_3() {
        return ADDRESSE_3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_3
     *
     * @param ADDRESSE_3 the value for CIF_OCCUPATION.ADDRESSE_3
     */
    public void setADDRESSE_3(String ADDRESSE_3) {
        this.ADDRESSE_3 = ADDRESSE_3 == null ? null : ADDRESSE_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.PO_BOX
     *
     * @return the value of CIF_OCCUPATION.PO_BOX
     */
    public String getPO_BOX() {
        return PO_BOX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.PO_BOX
     *
     * @param PO_BOX the value for CIF_OCCUPATION.PO_BOX
     */
    public void setPO_BOX(String PO_BOX) {
        this.PO_BOX = PO_BOX == null ? null : PO_BOX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.MONTHLY_BASIC_SALARY
     *
     * @return the value of CIF_OCCUPATION.MONTHLY_BASIC_SALARY
     */
    public BigDecimal getMONTHLY_BASIC_SALARY() {
        return MONTHLY_BASIC_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.MONTHLY_BASIC_SALARY
     *
     * @param MONTHLY_BASIC_SALARY the value for CIF_OCCUPATION.MONTHLY_BASIC_SALARY
     */
    public void setMONTHLY_BASIC_SALARY(BigDecimal MONTHLY_BASIC_SALARY) {
        this.MONTHLY_BASIC_SALARY = MONTHLY_BASIC_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.TRANSPORTATION_FEES
     *
     * @return the value of CIF_OCCUPATION.TRANSPORTATION_FEES
     */
    public BigDecimal getTRANSPORTATION_FEES() {
        return TRANSPORTATION_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.TRANSPORTATION_FEES
     *
     * @param TRANSPORTATION_FEES the value for CIF_OCCUPATION.TRANSPORTATION_FEES
     */
    public void setTRANSPORTATION_FEES(BigDecimal TRANSPORTATION_FEES) {
        this.TRANSPORTATION_FEES = TRANSPORTATION_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.LOCATION_FEES
     *
     * @return the value of CIF_OCCUPATION.LOCATION_FEES
     */
    public BigDecimal getLOCATION_FEES() {
        return LOCATION_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.LOCATION_FEES
     *
     * @param LOCATION_FEES the value for CIF_OCCUPATION.LOCATION_FEES
     */
    public void setLOCATION_FEES(BigDecimal LOCATION_FEES) {
        this.LOCATION_FEES = LOCATION_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.OTHER_FEES
     *
     * @return the value of CIF_OCCUPATION.OTHER_FEES
     */
    public BigDecimal getOTHER_FEES() {
        return OTHER_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.OTHER_FEES
     *
     * @param OTHER_FEES the value for CIF_OCCUPATION.OTHER_FEES
     */
    public void setOTHER_FEES(BigDecimal OTHER_FEES) {
        this.OTHER_FEES = OTHER_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.MONTHLY_TOTAL_SALARY
     *
     * @return the value of CIF_OCCUPATION.MONTHLY_TOTAL_SALARY
     */
    public BigDecimal getMONTHLY_TOTAL_SALARY() {
        return MONTHLY_TOTAL_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.MONTHLY_TOTAL_SALARY
     *
     * @param MONTHLY_TOTAL_SALARY the value for CIF_OCCUPATION.MONTHLY_TOTAL_SALARY
     */
    public void setMONTHLY_TOTAL_SALARY(BigDecimal MONTHLY_TOTAL_SALARY) {
        this.MONTHLY_TOTAL_SALARY = MONTHLY_TOTAL_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.SALARY_CASHED_DATE
     *
     * @return the value of CIF_OCCUPATION.SALARY_CASHED_DATE
     */
    public Date getSALARY_CASHED_DATE() {
        return SALARY_CASHED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.SALARY_CASHED_DATE
     *
     * @param SALARY_CASHED_DATE the value for CIF_OCCUPATION.SALARY_CASHED_DATE
     */
    public void setSALARY_CASHED_DATE(Date SALARY_CASHED_DATE) {
        this.SALARY_CASHED_DATE = SALARY_CASHED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.OTHER_INCOME
     *
     * @return the value of CIF_OCCUPATION.OTHER_INCOME
     */
    public BigDecimal getOTHER_INCOME() {
        return OTHER_INCOME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.OTHER_INCOME
     *
     * @param OTHER_INCOME the value for CIF_OCCUPATION.OTHER_INCOME
     */
    public void setOTHER_INCOME(BigDecimal OTHER_INCOME) {
        this.OTHER_INCOME = OTHER_INCOME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INCOME_SOURCE
     *
     * @return the value of CIF_OCCUPATION.INCOME_SOURCE
     */
    public String getINCOME_SOURCE() {
        return INCOME_SOURCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INCOME_SOURCE
     *
     * @param INCOME_SOURCE the value for CIF_OCCUPATION.INCOME_SOURCE
     */
    public void setINCOME_SOURCE(String INCOME_SOURCE) {
        this.INCOME_SOURCE = INCOME_SOURCE == null ? null : INCOME_SOURCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.STATUS
     *
     * @return the value of CIF_OCCUPATION.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.STATUS
     *
     * @param STATUS the value for CIF_OCCUPATION.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.TYPE
     *
     * @return the value of CIF_OCCUPATION.TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.TYPE
     *
     * @param TYPE the value for CIF_OCCUPATION.TYPE
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ANNUAL_SALARY
     *
     * @return the value of CIF_OCCUPATION.ANNUAL_SALARY
     */
    public BigDecimal getANNUAL_SALARY() {
        return ANNUAL_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ANNUAL_SALARY
     *
     * @param ANNUAL_SALARY the value for CIF_OCCUPATION.ANNUAL_SALARY
     */
    public void setANNUAL_SALARY(BigDecimal ANNUAL_SALARY) {
        this.ANNUAL_SALARY = ANNUAL_SALARY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.EMPLOYER_TITLE
     *
     * @return the value of CIF_OCCUPATION.EMPLOYER_TITLE
     */
    public String getEMPLOYER_TITLE() {
        return EMPLOYER_TITLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.EMPLOYER_TITLE
     *
     * @param EMPLOYER_TITLE the value for CIF_OCCUPATION.EMPLOYER_TITLE
     */
    public void setEMPLOYER_TITLE(String EMPLOYER_TITLE) {
        this.EMPLOYER_TITLE = EMPLOYER_TITLE == null ? null : EMPLOYER_TITLE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.LEGAL_ACTION
     *
     * @return the value of CIF_OCCUPATION.LEGAL_ACTION
     */
    public String getLEGAL_ACTION() {
        return LEGAL_ACTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.LEGAL_ACTION
     *
     * @param LEGAL_ACTION the value for CIF_OCCUPATION.LEGAL_ACTION
     */
    public void setLEGAL_ACTION(String LEGAL_ACTION) {
        this.LEGAL_ACTION = LEGAL_ACTION == null ? null : LEGAL_ACTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_CITY
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_CITY
     */
    public String getINSTITUTION_CITY() {
        return INSTITUTION_CITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_CITY
     *
     * @param INSTITUTION_CITY the value for CIF_OCCUPATION.INSTITUTION_CITY
     */
    public void setINSTITUTION_CITY(String INSTITUTION_CITY) {
        this.INSTITUTION_CITY = INSTITUTION_CITY == null ? null : INSTITUTION_CITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.POSTAL_CODE
     *
     * @return the value of CIF_OCCUPATION.POSTAL_CODE
     */
    public BigDecimal getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.POSTAL_CODE
     *
     * @param POSTAL_CODE the value for CIF_OCCUPATION.POSTAL_CODE
     */
    public void setPOSTAL_CODE(BigDecimal POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.POSTAL_ADDR_COUNTRY
     *
     * @return the value of CIF_OCCUPATION.POSTAL_ADDR_COUNTRY
     */
    public BigDecimal getPOSTAL_ADDR_COUNTRY() {
        return POSTAL_ADDR_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.POSTAL_ADDR_COUNTRY
     *
     * @param POSTAL_ADDR_COUNTRY the value for CIF_OCCUPATION.POSTAL_ADDR_COUNTRY
     */
    public void setPOSTAL_ADDR_COUNTRY(BigDecimal POSTAL_ADDR_COUNTRY) {
        this.POSTAL_ADDR_COUNTRY = POSTAL_ADDR_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.MOBILE
     *
     * @return the value of CIF_OCCUPATION.MOBILE
     */
    public String getMOBILE() {
        return MOBILE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.MOBILE
     *
     * @param MOBILE the value for CIF_OCCUPATION.MOBILE
     */
    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.POSTAL_ADDR_CITY
     *
     * @return the value of CIF_OCCUPATION.POSTAL_ADDR_CITY
     */
    public String getPOSTAL_ADDR_CITY() {
        return POSTAL_ADDR_CITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.POSTAL_ADDR_CITY
     *
     * @param POSTAL_ADDR_CITY the value for CIF_OCCUPATION.POSTAL_ADDR_CITY
     */
    public void setPOSTAL_ADDR_CITY(String POSTAL_ADDR_CITY) {
        this.POSTAL_ADDR_CITY = POSTAL_ADDR_CITY == null ? null : POSTAL_ADDR_CITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_REGION
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_REGION
     */
    public BigDecimal getINSTITUTION_REGION() {
        return INSTITUTION_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_REGION
     *
     * @param INSTITUTION_REGION the value for CIF_OCCUPATION.INSTITUTION_REGION
     */
    public void setINSTITUTION_REGION(BigDecimal INSTITUTION_REGION) {
        this.INSTITUTION_REGION = INSTITUTION_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.EMAIL
     *
     * @return the value of CIF_OCCUPATION.EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.EMAIL
     *
     * @param EMAIL the value for CIF_OCCUPATION.EMAIL
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.POSTAL_ADDR_REGION
     *
     * @return the value of CIF_OCCUPATION.POSTAL_ADDR_REGION
     */
    public BigDecimal getPOSTAL_ADDR_REGION() {
        return POSTAL_ADDR_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.POSTAL_ADDR_REGION
     *
     * @param POSTAL_ADDR_REGION the value for CIF_OCCUPATION.POSTAL_ADDR_REGION
     */
    public void setPOSTAL_ADDR_REGION(BigDecimal POSTAL_ADDR_REGION) {
        this.POSTAL_ADDR_REGION = POSTAL_ADDR_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.FROM_DATE_HIJRI
     *
     * @return the value of CIF_OCCUPATION.FROM_DATE_HIJRI
     */
    public Date getFROM_DATE_HIJRI() {
        return FROM_DATE_HIJRI;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.FROM_DATE_HIJRI
     *
     * @param FROM_DATE_HIJRI the value for CIF_OCCUPATION.FROM_DATE_HIJRI
     */
    public void setFROM_DATE_HIJRI(Date FROM_DATE_HIJRI) {
        this.FROM_DATE_HIJRI = FROM_DATE_HIJRI;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_NAME_ARAB
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_NAME_ARAB
     */
    public String getINSTITUTION_NAME_ARAB() {
        return INSTITUTION_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_NAME_ARAB
     *
     * @param INSTITUTION_NAME_ARAB the value for CIF_OCCUPATION.INSTITUTION_NAME_ARAB
     */
    public void setINSTITUTION_NAME_ARAB(String INSTITUTION_NAME_ARAB) {
        this.INSTITUTION_NAME_ARAB = INSTITUTION_NAME_ARAB == null ? null : INSTITUTION_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.INSTITUTION_CITY_ARAB
     *
     * @return the value of CIF_OCCUPATION.INSTITUTION_CITY_ARAB
     */
    public String getINSTITUTION_CITY_ARAB() {
        return INSTITUTION_CITY_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.INSTITUTION_CITY_ARAB
     *
     * @param INSTITUTION_CITY_ARAB the value for CIF_OCCUPATION.INSTITUTION_CITY_ARAB
     */
    public void setINSTITUTION_CITY_ARAB(String INSTITUTION_CITY_ARAB) {
        this.INSTITUTION_CITY_ARAB = INSTITUTION_CITY_ARAB == null ? null : INSTITUTION_CITY_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_1_ARAB
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_1_ARAB
     */
    public String getADDRESSE_1_ARAB() {
        return ADDRESSE_1_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_1_ARAB
     *
     * @param ADDRESSE_1_ARAB the value for CIF_OCCUPATION.ADDRESSE_1_ARAB
     */
    public void setADDRESSE_1_ARAB(String ADDRESSE_1_ARAB) {
        this.ADDRESSE_1_ARAB = ADDRESSE_1_ARAB == null ? null : ADDRESSE_1_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_2_ARAB
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_2_ARAB
     */
    public String getADDRESSE_2_ARAB() {
        return ADDRESSE_2_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_2_ARAB
     *
     * @param ADDRESSE_2_ARAB the value for CIF_OCCUPATION.ADDRESSE_2_ARAB
     */
    public void setADDRESSE_2_ARAB(String ADDRESSE_2_ARAB) {
        this.ADDRESSE_2_ARAB = ADDRESSE_2_ARAB == null ? null : ADDRESSE_2_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.ADDRESSE_3_ARAB
     *
     * @return the value of CIF_OCCUPATION.ADDRESSE_3_ARAB
     */
    public String getADDRESSE_3_ARAB() {
        return ADDRESSE_3_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.ADDRESSE_3_ARAB
     *
     * @param ADDRESSE_3_ARAB the value for CIF_OCCUPATION.ADDRESSE_3_ARAB
     */
    public void setADDRESSE_3_ARAB(String ADDRESSE_3_ARAB) {
        this.ADDRESSE_3_ARAB = ADDRESSE_3_ARAB == null ? null : ADDRESSE_3_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.RETIREMENT_AGE
     *
     * @return the value of CIF_OCCUPATION.RETIREMENT_AGE
     */
    public BigDecimal getRETIREMENT_AGE() {
        return RETIREMENT_AGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.RETIREMENT_AGE
     *
     * @param RETIREMENT_AGE the value for CIF_OCCUPATION.RETIREMENT_AGE
     */
    public void setRETIREMENT_AGE(BigDecimal RETIREMENT_AGE) {
        this.RETIREMENT_AGE = RETIREMENT_AGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.EMP_LEGAL_STATUS
     *
     * @return the value of CIF_OCCUPATION.EMP_LEGAL_STATUS
     */
    public BigDecimal getEMP_LEGAL_STATUS() {
        return EMP_LEGAL_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.EMP_LEGAL_STATUS
     *
     * @param EMP_LEGAL_STATUS the value for CIF_OCCUPATION.EMP_LEGAL_STATUS
     */
    public void setEMP_LEGAL_STATUS(BigDecimal EMP_LEGAL_STATUS) {
        this.EMP_LEGAL_STATUS = EMP_LEGAL_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.CONFIRMED_EMPLOYMENT
     *
     * @return the value of CIF_OCCUPATION.CONFIRMED_EMPLOYMENT
     */
    public String getCONFIRMED_EMPLOYMENT() {
        return CONFIRMED_EMPLOYMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.CONFIRMED_EMPLOYMENT
     *
     * @param CONFIRMED_EMPLOYMENT the value for CIF_OCCUPATION.CONFIRMED_EMPLOYMENT
     */
    public void setCONFIRMED_EMPLOYMENT(String CONFIRMED_EMPLOYMENT) {
        this.CONFIRMED_EMPLOYMENT = CONFIRMED_EMPLOYMENT == null ? null : CONFIRMED_EMPLOYMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.STAFF_EMPLOYEE_NO
     *
     * @return the value of CIF_OCCUPATION.STAFF_EMPLOYEE_NO
     */
    public String getSTAFF_EMPLOYEE_NO() {
        return STAFF_EMPLOYEE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.STAFF_EMPLOYEE_NO
     *
     * @param STAFF_EMPLOYEE_NO the value for CIF_OCCUPATION.STAFF_EMPLOYEE_NO
     */
    public void setSTAFF_EMPLOYEE_NO(String STAFF_EMPLOYEE_NO) {
        this.STAFF_EMPLOYEE_NO = STAFF_EMPLOYEE_NO == null ? null : STAFF_EMPLOYEE_NO.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_OCCUPATION.MAIN_OCCUPATION_YN
     *
     * @return the value of CIF_OCCUPATION.MAIN_OCCUPATION_YN
     */
    public String getMAIN_OCCUPATION_YN() {
        return MAIN_OCCUPATION_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_OCCUPATION.MAIN_OCCUPATION_YN
     *
     * @param MAIN_OCCUPATION_YN the value for CIF_OCCUPATION.MAIN_OCCUPATION_YN
     */
    public void setMAIN_OCCUPATION_YN(String MAIN_OCCUPATION_YN) {
        this.MAIN_OCCUPATION_YN = MAIN_OCCUPATION_YN == null ? null : MAIN_OCCUPATION_YN.trim();
    }

    public BigDecimal getCITY()
    {
        return CITY;
    }

    public void setCITY(BigDecimal cITY)
    {
        CITY = cITY;
    }

    public String getAVENUE()
    {
        return AVENUE;
    }

    public void setAVENUE(String aVENUE)
    {
        AVENUE = aVENUE;
    }

    public String getSTREET()
    {
        return STREET;
    }

    public void setSTREET(String sTREET)
    {
        STREET = sTREET;
    }
    
    

    public BigDecimal getCOUNTRY()
    {
        return COUNTRY;
    }

    public void setCOUNTRY(BigDecimal cOUNTRY)
    {
        COUNTRY = cOUNTRY;
    }

    public BigDecimal getREGION()
    {
        return REGION;
    }

    public void setREGION(BigDecimal rEGION)
    {
        REGION = rEGION;
    }	public BigDecimal getPOSTAL_CODE_AREA() {
		return POSTAL_CODE_AREA;
	}

	public void setPOSTAL_CODE_AREA(BigDecimal pOSTAL_CODE_AREA) {
		POSTAL_CODE_AREA = pOSTAL_CODE_AREA;
	}
    
    
}