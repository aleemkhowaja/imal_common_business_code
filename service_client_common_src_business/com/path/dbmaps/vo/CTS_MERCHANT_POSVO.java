package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_MERCHANT_POSVO extends CTS_MERCHANT_POSVOKey {
    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.MERCHANT_CODE
     */
    private BigDecimal MERCHANT_CODE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.POS_TYPE
     */
    private String POS_TYPE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.POS_DESC
     */
    private String POS_DESC;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.TERMINAL_ID
     */
    private String TERMINAL_ID;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.INSTALLATION_DATE
     */
    private Date INSTALLATION_DATE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_TOBE_CANCELED
     */
    private Date DATE_TOBE_CANCELED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.TOBE_CANCELED_BY
     */
    private String TOBE_CANCELED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_CANCELED
     */
    private Date DATE_CANCELED;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.CANCELED_BY
     */
    private String CANCELED_BY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.SENT_FLAG
     */
    private String SENT_FLAG;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.ADDRESS1
     */
    private String ADDRESS1;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.ADDRESS2
     */
    private String ADDRESS2;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.ADDRESS3
     */
    private String ADDRESS3;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.ADDRESS4
     */
    private String ADDRESS4;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.STREET_DETAILS
     */
    private String STREET_DETAILS;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.CITY
     */
    private String CITY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.COUNTRY
     */
    private BigDecimal COUNTRY;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.REGION
     */
    private BigDecimal REGION;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.CITY_CODE
     */
    private BigDecimal CITY_CODE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.SECTOR_CODE
     */
    private BigDecimal SECTOR_CODE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.TEL
     */
    private String TEL;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.WORK_TEL
     */
    private String WORK_TEL;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.OTHER_TEL
     */
    private String OTHER_TEL;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.MOBILE
     */
    private String MOBILE;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.FAX
     */
    private String FAX;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.EMAIL
     */
    private String EMAIL;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.STATUS_REMARK
     */
    private String STATUS_REMARK;

    /**
     * This field corresponds to the database column CTS_MERCHANT_POS.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.MERCHANT_CODE
     *
     * @return the value of CTS_MERCHANT_POS.MERCHANT_CODE
     */
    public BigDecimal getMERCHANT_CODE() {
        return MERCHANT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.MERCHANT_CODE
     *
     * @param MERCHANT_CODE the value for CTS_MERCHANT_POS.MERCHANT_CODE
     */
    public void setMERCHANT_CODE(BigDecimal MERCHANT_CODE) {
        this.MERCHANT_CODE = MERCHANT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.POS_TYPE
     *
     * @return the value of CTS_MERCHANT_POS.POS_TYPE
     */
    public String getPOS_TYPE() {
        return POS_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.POS_TYPE
     *
     * @param POS_TYPE the value for CTS_MERCHANT_POS.POS_TYPE
     */
    public void setPOS_TYPE(String POS_TYPE) {
        this.POS_TYPE = POS_TYPE == null ? null : POS_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.POS_DESC
     *
     * @return the value of CTS_MERCHANT_POS.POS_DESC
     */
    public String getPOS_DESC() {
        return POS_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.POS_DESC
     *
     * @param POS_DESC the value for CTS_MERCHANT_POS.POS_DESC
     */
    public void setPOS_DESC(String POS_DESC) {
        this.POS_DESC = POS_DESC == null ? null : POS_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.TERMINAL_ID
     *
     * @return the value of CTS_MERCHANT_POS.TERMINAL_ID
     */
    public String getTERMINAL_ID() {
        return TERMINAL_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.TERMINAL_ID
     *
     * @param TERMINAL_ID the value for CTS_MERCHANT_POS.TERMINAL_ID
     */
    public void setTERMINAL_ID(String TERMINAL_ID) {
        this.TERMINAL_ID = TERMINAL_ID == null ? null : TERMINAL_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.INSTALLATION_DATE
     *
     * @return the value of CTS_MERCHANT_POS.INSTALLATION_DATE
     */
    public Date getINSTALLATION_DATE() {
        return INSTALLATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.INSTALLATION_DATE
     *
     * @param INSTALLATION_DATE the value for CTS_MERCHANT_POS.INSTALLATION_DATE
     */
    public void setINSTALLATION_DATE(Date INSTALLATION_DATE) {
        this.INSTALLATION_DATE = INSTALLATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.STATUS
     *
     * @return the value of CTS_MERCHANT_POS.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.STATUS
     *
     * @param STATUS the value for CTS_MERCHANT_POS.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_CREATED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_CREATED
     *
     * @param DATE_CREATED the value for CTS_MERCHANT_POS.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.CREATED_BY
     *
     * @return the value of CTS_MERCHANT_POS.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.CREATED_BY
     *
     * @param CREATED_BY the value for CTS_MERCHANT_POS.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_APPROVED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for CTS_MERCHANT_POS.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.APPROVED_BY
     *
     * @return the value of CTS_MERCHANT_POS.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.APPROVED_BY
     *
     * @param APPROVED_BY the value for CTS_MERCHANT_POS.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_DELETED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_DELETED
     *
     * @param DATE_DELETED the value for CTS_MERCHANT_POS.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DELETED_BY
     *
     * @return the value of CTS_MERCHANT_POS.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DELETED_BY
     *
     * @param DELETED_BY the value for CTS_MERCHANT_POS.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_MODIFIED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for CTS_MERCHANT_POS.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.MODIFIED_BY
     *
     * @return the value of CTS_MERCHANT_POS.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTS_MERCHANT_POS.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_TOBE_CANCELED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_TOBE_CANCELED
     */
    public Date getDATE_TOBE_CANCELED() {
        return DATE_TOBE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_TOBE_CANCELED
     *
     * @param DATE_TOBE_CANCELED the value for CTS_MERCHANT_POS.DATE_TOBE_CANCELED
     */
    public void setDATE_TOBE_CANCELED(Date DATE_TOBE_CANCELED) {
        this.DATE_TOBE_CANCELED = DATE_TOBE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.TOBE_CANCELED_BY
     *
     * @return the value of CTS_MERCHANT_POS.TOBE_CANCELED_BY
     */
    public String getTOBE_CANCELED_BY() {
        return TOBE_CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.TOBE_CANCELED_BY
     *
     * @param TOBE_CANCELED_BY the value for CTS_MERCHANT_POS.TOBE_CANCELED_BY
     */
    public void setTOBE_CANCELED_BY(String TOBE_CANCELED_BY) {
        this.TOBE_CANCELED_BY = TOBE_CANCELED_BY == null ? null : TOBE_CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_CANCELED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_CANCELED
     */
    public Date getDATE_CANCELED() {
        return DATE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_CANCELED
     *
     * @param DATE_CANCELED the value for CTS_MERCHANT_POS.DATE_CANCELED
     */
    public void setDATE_CANCELED(Date DATE_CANCELED) {
        this.DATE_CANCELED = DATE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.CANCELED_BY
     *
     * @return the value of CTS_MERCHANT_POS.CANCELED_BY
     */
    public String getCANCELED_BY() {
        return CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.CANCELED_BY
     *
     * @param CANCELED_BY the value for CTS_MERCHANT_POS.CANCELED_BY
     */
    public void setCANCELED_BY(String CANCELED_BY) {
        this.CANCELED_BY = CANCELED_BY == null ? null : CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.SENT_FLAG
     *
     * @return the value of CTS_MERCHANT_POS.SENT_FLAG
     */
    public String getSENT_FLAG() {
        return SENT_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.SENT_FLAG
     *
     * @param SENT_FLAG the value for CTS_MERCHANT_POS.SENT_FLAG
     */
    public void setSENT_FLAG(String SENT_FLAG) {
        this.SENT_FLAG = SENT_FLAG == null ? null : SENT_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.ADDRESS1
     *
     * @return the value of CTS_MERCHANT_POS.ADDRESS1
     */
    public String getADDRESS1() {
        return ADDRESS1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.ADDRESS1
     *
     * @param ADDRESS1 the value for CTS_MERCHANT_POS.ADDRESS1
     */
    public void setADDRESS1(String ADDRESS1) {
        this.ADDRESS1 = ADDRESS1 == null ? null : ADDRESS1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.ADDRESS2
     *
     * @return the value of CTS_MERCHANT_POS.ADDRESS2
     */
    public String getADDRESS2() {
        return ADDRESS2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.ADDRESS2
     *
     * @param ADDRESS2 the value for CTS_MERCHANT_POS.ADDRESS2
     */
    public void setADDRESS2(String ADDRESS2) {
        this.ADDRESS2 = ADDRESS2 == null ? null : ADDRESS2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.ADDRESS3
     *
     * @return the value of CTS_MERCHANT_POS.ADDRESS3
     */
    public String getADDRESS3() {
        return ADDRESS3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.ADDRESS3
     *
     * @param ADDRESS3 the value for CTS_MERCHANT_POS.ADDRESS3
     */
    public void setADDRESS3(String ADDRESS3) {
        this.ADDRESS3 = ADDRESS3 == null ? null : ADDRESS3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.ADDRESS4
     *
     * @return the value of CTS_MERCHANT_POS.ADDRESS4
     */
    public String getADDRESS4() {
        return ADDRESS4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.ADDRESS4
     *
     * @param ADDRESS4 the value for CTS_MERCHANT_POS.ADDRESS4
     */
    public void setADDRESS4(String ADDRESS4) {
        this.ADDRESS4 = ADDRESS4 == null ? null : ADDRESS4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.STREET_DETAILS
     *
     * @return the value of CTS_MERCHANT_POS.STREET_DETAILS
     */
    public String getSTREET_DETAILS() {
        return STREET_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.STREET_DETAILS
     *
     * @param STREET_DETAILS the value for CTS_MERCHANT_POS.STREET_DETAILS
     */
    public void setSTREET_DETAILS(String STREET_DETAILS) {
        this.STREET_DETAILS = STREET_DETAILS == null ? null : STREET_DETAILS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.CITY
     *
     * @return the value of CTS_MERCHANT_POS.CITY
     */
    public String getCITY() {
        return CITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.CITY
     *
     * @param CITY the value for CTS_MERCHANT_POS.CITY
     */
    public void setCITY(String CITY) {
        this.CITY = CITY == null ? null : CITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.COUNTRY
     *
     * @return the value of CTS_MERCHANT_POS.COUNTRY
     */
    public BigDecimal getCOUNTRY() {
        return COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.COUNTRY
     *
     * @param COUNTRY the value for CTS_MERCHANT_POS.COUNTRY
     */
    public void setCOUNTRY(BigDecimal COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.REGION
     *
     * @return the value of CTS_MERCHANT_POS.REGION
     */
    public BigDecimal getREGION() {
        return REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.REGION
     *
     * @param REGION the value for CTS_MERCHANT_POS.REGION
     */
    public void setREGION(BigDecimal REGION) {
        this.REGION = REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.CITY_CODE
     *
     * @return the value of CTS_MERCHANT_POS.CITY_CODE
     */
    public BigDecimal getCITY_CODE() {
        return CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.CITY_CODE
     *
     * @param CITY_CODE the value for CTS_MERCHANT_POS.CITY_CODE
     */
    public void setCITY_CODE(BigDecimal CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.SECTOR_CODE
     *
     * @return the value of CTS_MERCHANT_POS.SECTOR_CODE
     */
    public BigDecimal getSECTOR_CODE() {
        return SECTOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.SECTOR_CODE
     *
     * @param SECTOR_CODE the value for CTS_MERCHANT_POS.SECTOR_CODE
     */
    public void setSECTOR_CODE(BigDecimal SECTOR_CODE) {
        this.SECTOR_CODE = SECTOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.TEL
     *
     * @return the value of CTS_MERCHANT_POS.TEL
     */
    public String getTEL() {
        return TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.TEL
     *
     * @param TEL the value for CTS_MERCHANT_POS.TEL
     */
    public void setTEL(String TEL) {
        this.TEL = TEL == null ? null : TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.WORK_TEL
     *
     * @return the value of CTS_MERCHANT_POS.WORK_TEL
     */
    public String getWORK_TEL() {
        return WORK_TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.WORK_TEL
     *
     * @param WORK_TEL the value for CTS_MERCHANT_POS.WORK_TEL
     */
    public void setWORK_TEL(String WORK_TEL) {
        this.WORK_TEL = WORK_TEL == null ? null : WORK_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.OTHER_TEL
     *
     * @return the value of CTS_MERCHANT_POS.OTHER_TEL
     */
    public String getOTHER_TEL() {
        return OTHER_TEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.OTHER_TEL
     *
     * @param OTHER_TEL the value for CTS_MERCHANT_POS.OTHER_TEL
     */
    public void setOTHER_TEL(String OTHER_TEL) {
        this.OTHER_TEL = OTHER_TEL == null ? null : OTHER_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.MOBILE
     *
     * @return the value of CTS_MERCHANT_POS.MOBILE
     */
    public String getMOBILE() {
        return MOBILE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.MOBILE
     *
     * @param MOBILE the value for CTS_MERCHANT_POS.MOBILE
     */
    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.FAX
     *
     * @return the value of CTS_MERCHANT_POS.FAX
     */
    public String getFAX() {
        return FAX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.FAX
     *
     * @param FAX the value for CTS_MERCHANT_POS.FAX
     */
    public void setFAX(String FAX) {
        this.FAX = FAX == null ? null : FAX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.EMAIL
     *
     * @return the value of CTS_MERCHANT_POS.EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.EMAIL
     *
     * @param EMAIL the value for CTS_MERCHANT_POS.EMAIL
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.STATUS_REMARK
     *
     * @return the value of CTS_MERCHANT_POS.STATUS_REMARK
     */
    public String getSTATUS_REMARK() {
        return STATUS_REMARK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.STATUS_REMARK
     *
     * @param STATUS_REMARK the value for CTS_MERCHANT_POS.STATUS_REMARK
     */
    public void setSTATUS_REMARK(String STATUS_REMARK) {
        this.STATUS_REMARK = STATUS_REMARK == null ? null : STATUS_REMARK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_MERCHANT_POS.DATE_UPDATED
     *
     * @return the value of CTS_MERCHANT_POS.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_MERCHANT_POS.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for CTS_MERCHANT_POS.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }
}