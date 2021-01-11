package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTSCERTIFICATEVO extends CTSCERTIFICATEVOKey {
    /**
     * This field corresponds to the database column CTSCERTIFICATE.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CIF_NAME
     */
    private String CIF_NAME;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CERTIFICATE_TYPE
     */
    private BigDecimal CERTIFICATE_TYPE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.BALANCE_TYPE
     */
    private String BALANCE_TYPE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CLOSING_BALANCE_DATE
     */
    private Date CLOSING_BALANCE_DATE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_REJECTED
     */
    private Date DATE_REJECTED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.PRINTED_BY
     */
    private String PRINTED_BY;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_PRINTED
     */
    private Date DATE_PRINTED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CERTIFICATE_DATE
     */
    private Date CERTIFICATE_DATE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD1
     */
    private String FIELD1;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD2
     */
    private String FIELD2;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD3
     */
    private String FIELD3;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD4
     */
    private String FIELD4;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD5
     */
    private String FIELD5;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD6
     */
    private String FIELD6;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD7
     */
    private String FIELD7;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD8
     */
    private String FIELD8;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD9
     */
    private String FIELD9;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.FIELD10
     */
    private String FIELD10;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.ADD_FIELD1
     */
    private String ADD_FIELD1;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.ADD_FIELD2
     */
    private String ADD_FIELD2;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.ADD_FIELD3
     */
    private String ADD_FIELD3;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.ADD_FIELD4
     */
    private String ADD_FIELD4;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DETAILS_FROM
     */
    private String DETAILS_FROM;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.PRINT_DETAILS
     */
    private String PRINT_DETAILS;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.TRX_NO
     */
    private BigDecimal TRX_NO;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CHRG_WAIVED
     */
    private String CHRG_WAIVED;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.LANGUAGE
     */
    private String LANGUAGE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.DATE_UPDATED
     */
    private Date DATE_UPDATED;
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.NUMBER_OF_BILLS
     */
    private BigDecimal NUMBER_OF_BILLS;
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.TOTAL_AMOUNT_OF_BILLS
     */
    private BigDecimal TOTAL_AMOUNT_OF_BILLS;

    /**
     * This field corresponds to the database column CTSCERTIFICATE.CERTIFICATE_IMAGE
     */
    private byte[] CERTIFICATE_IMAGE;
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.TO_BE_CANCELLED_BY
     */ 
    private String TO_BE_CANCELLED_BY;
    
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.TO_BE_CANCELLED_DATE
     */
    private Date TO_BE_CANCELLED_DATE;
    
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.CANCELLED_BY
     */
    private String CANCELLED_BY;
    
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.CANCELLED_DATE
     */    
    private Date CANCELLED_DATE;
    
    
    /**
     * This field corresponds to the database column CTSCERTIFICATE.REASON_CODE
     */  
     private BigDecimal  REASON_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CIF_NO
     *
     * @return the value of CTSCERTIFICATE.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CIF_NO
     *
     * @param CIF_NO the value for CTSCERTIFICATE.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CIF_NAME
     *
     * @return the value of CTSCERTIFICATE.CIF_NAME
     */
    public String getCIF_NAME() {
        return CIF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CIF_NAME
     *
     * @param CIF_NAME the value for CTSCERTIFICATE.CIF_NAME
     */
    public void setCIF_NAME(String CIF_NAME) {
        this.CIF_NAME = CIF_NAME == null ? null : CIF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.STATUS
     *
     * @return the value of CTSCERTIFICATE.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.STATUS
     *
     * @param STATUS the value for CTSCERTIFICATE.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CERTIFICATE_TYPE
     *
     * @return the value of CTSCERTIFICATE.CERTIFICATE_TYPE
     */
    public BigDecimal getCERTIFICATE_TYPE() {
        return CERTIFICATE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CERTIFICATE_TYPE
     *
     * @param CERTIFICATE_TYPE the value for CTSCERTIFICATE.CERTIFICATE_TYPE
     */
    public void setCERTIFICATE_TYPE(BigDecimal CERTIFICATE_TYPE) {
        this.CERTIFICATE_TYPE = CERTIFICATE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CURRENCY
     *
     * @return the value of CTSCERTIFICATE.CURRENCY
     */
    public BigDecimal getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CURRENCY
     *
     * @param CURRENCY the value for CTSCERTIFICATE.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.BALANCE_TYPE
     *
     * @return the value of CTSCERTIFICATE.BALANCE_TYPE
     */
    public String getBALANCE_TYPE() {
        return BALANCE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.BALANCE_TYPE
     *
     * @param BALANCE_TYPE the value for CTSCERTIFICATE.BALANCE_TYPE
     */
    public void setBALANCE_TYPE(String BALANCE_TYPE) {
        this.BALANCE_TYPE = BALANCE_TYPE == null ? null : BALANCE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CLOSING_BALANCE_DATE
     *
     * @return the value of CTSCERTIFICATE.CLOSING_BALANCE_DATE
     */
    public Date getCLOSING_BALANCE_DATE() {
        return CLOSING_BALANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CLOSING_BALANCE_DATE
     *
     * @param CLOSING_BALANCE_DATE the value for CTSCERTIFICATE.CLOSING_BALANCE_DATE
     */
    public void setCLOSING_BALANCE_DATE(Date CLOSING_BALANCE_DATE) {
        this.CLOSING_BALANCE_DATE = CLOSING_BALANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CREATED_BY
     *
     * @return the value of CTSCERTIFICATE.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CREATED_BY
     *
     * @param CREATED_BY the value for CTSCERTIFICATE.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_CREATED
     *
     * @return the value of CTSCERTIFICATE.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_CREATED
     *
     * @param DATE_CREATED the value for CTSCERTIFICATE.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.MODIFIED_BY
     *
     * @return the value of CTSCERTIFICATE.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTSCERTIFICATE.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_MODIFIED
     *
     * @return the value of CTSCERTIFICATE.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for CTSCERTIFICATE.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DELETED_BY
     *
     * @return the value of CTSCERTIFICATE.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DELETED_BY
     *
     * @param DELETED_BY the value for CTSCERTIFICATE.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_DELETED
     *
     * @return the value of CTSCERTIFICATE.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_DELETED
     *
     * @param DATE_DELETED the value for CTSCERTIFICATE.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.APPROVED_BY
     *
     * @return the value of CTSCERTIFICATE.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.APPROVED_BY
     *
     * @param APPROVED_BY the value for CTSCERTIFICATE.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_APPROVED
     *
     * @return the value of CTSCERTIFICATE.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for CTSCERTIFICATE.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.REJECTED_BY
     *
     * @return the value of CTSCERTIFICATE.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.REJECTED_BY
     *
     * @param REJECTED_BY the value for CTSCERTIFICATE.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_REJECTED
     *
     * @return the value of CTSCERTIFICATE.DATE_REJECTED
     */
    public Date getDATE_REJECTED() {
        return DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_REJECTED
     *
     * @param DATE_REJECTED the value for CTSCERTIFICATE.DATE_REJECTED
     */
    public void setDATE_REJECTED(Date DATE_REJECTED) {
        this.DATE_REJECTED = DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.PRINTED_BY
     *
     * @return the value of CTSCERTIFICATE.PRINTED_BY
     */
    public String getPRINTED_BY() {
        return PRINTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.PRINTED_BY
     *
     * @param PRINTED_BY the value for CTSCERTIFICATE.PRINTED_BY
     */
    public void setPRINTED_BY(String PRINTED_BY) {
        this.PRINTED_BY = PRINTED_BY == null ? null : PRINTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_PRINTED
     *
     * @return the value of CTSCERTIFICATE.DATE_PRINTED
     */
    public Date getDATE_PRINTED() {
        return DATE_PRINTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_PRINTED
     *
     * @param DATE_PRINTED the value for CTSCERTIFICATE.DATE_PRINTED
     */
    public void setDATE_PRINTED(Date DATE_PRINTED) {
        this.DATE_PRINTED = DATE_PRINTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CERTIFICATE_DATE
     *
     * @return the value of CTSCERTIFICATE.CERTIFICATE_DATE
     */
    public Date getCERTIFICATE_DATE() {
        return CERTIFICATE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CERTIFICATE_DATE
     *
     * @param CERTIFICATE_DATE the value for CTSCERTIFICATE.CERTIFICATE_DATE
     */
    public void setCERTIFICATE_DATE(Date CERTIFICATE_DATE) {
        this.CERTIFICATE_DATE = CERTIFICATE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD1
     *
     * @return the value of CTSCERTIFICATE.FIELD1
     */
    public String getFIELD1() {
        return FIELD1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD1
     *
     * @param FIELD1 the value for CTSCERTIFICATE.FIELD1
     */
    public void setFIELD1(String FIELD1) {
        this.FIELD1 = FIELD1 == null ? null : FIELD1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD2
     *
     * @return the value of CTSCERTIFICATE.FIELD2
     */
    public String getFIELD2() {
        return FIELD2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD2
     *
     * @param FIELD2 the value for CTSCERTIFICATE.FIELD2
     */
    public void setFIELD2(String FIELD2) {
        this.FIELD2 = FIELD2 == null ? null : FIELD2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD3
     *
     * @return the value of CTSCERTIFICATE.FIELD3
     */
    public String getFIELD3() {
        return FIELD3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD3
     *
     * @param FIELD3 the value for CTSCERTIFICATE.FIELD3
     */
    public void setFIELD3(String FIELD3) {
        this.FIELD3 = FIELD3 == null ? null : FIELD3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD4
     *
     * @return the value of CTSCERTIFICATE.FIELD4
     */
    public String getFIELD4() {
        return FIELD4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD4
     *
     * @param FIELD4 the value for CTSCERTIFICATE.FIELD4
     */
    public void setFIELD4(String FIELD4) {
        this.FIELD4 = FIELD4 == null ? null : FIELD4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD5
     *
     * @return the value of CTSCERTIFICATE.FIELD5
     */
    public String getFIELD5() {
        return FIELD5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD5
     *
     * @param FIELD5 the value for CTSCERTIFICATE.FIELD5
     */
    public void setFIELD5(String FIELD5) {
        this.FIELD5 = FIELD5 == null ? null : FIELD5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD6
     *
     * @return the value of CTSCERTIFICATE.FIELD6
     */
    public String getFIELD6() {
        return FIELD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD6
     *
     * @param FIELD6 the value for CTSCERTIFICATE.FIELD6
     */
    public void setFIELD6(String FIELD6) {
        this.FIELD6 = FIELD6 == null ? null : FIELD6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD7
     *
     * @return the value of CTSCERTIFICATE.FIELD7
     */
    public String getFIELD7() {
        return FIELD7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD7
     *
     * @param FIELD7 the value for CTSCERTIFICATE.FIELD7
     */
    public void setFIELD7(String FIELD7) {
        this.FIELD7 = FIELD7 == null ? null : FIELD7.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD8
     *
     * @return the value of CTSCERTIFICATE.FIELD8
     */
    public String getFIELD8() {
        return FIELD8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD8
     *
     * @param FIELD8 the value for CTSCERTIFICATE.FIELD8
     */
    public void setFIELD8(String FIELD8) {
        this.FIELD8 = FIELD8 == null ? null : FIELD8.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD9
     *
     * @return the value of CTSCERTIFICATE.FIELD9
     */
    public String getFIELD9() {
        return FIELD9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD9
     *
     * @param FIELD9 the value for CTSCERTIFICATE.FIELD9
     */
    public void setFIELD9(String FIELD9) {
        this.FIELD9 = FIELD9 == null ? null : FIELD9.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.FIELD10
     *
     * @return the value of CTSCERTIFICATE.FIELD10
     */
    public String getFIELD10() {
        return FIELD10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.FIELD10
     *
     * @param FIELD10 the value for CTSCERTIFICATE.FIELD10
     */
    public void setFIELD10(String FIELD10) {
        this.FIELD10 = FIELD10 == null ? null : FIELD10.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.ADD_FIELD1
     *
     * @return the value of CTSCERTIFICATE.ADD_FIELD1
     */
    public String getADD_FIELD1() {
        return ADD_FIELD1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.ADD_FIELD1
     *
     * @param ADD_FIELD1 the value for CTSCERTIFICATE.ADD_FIELD1
     */
    public void setADD_FIELD1(String ADD_FIELD1) {
        this.ADD_FIELD1 = ADD_FIELD1 == null ? null : ADD_FIELD1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.ADD_FIELD2
     *
     * @return the value of CTSCERTIFICATE.ADD_FIELD2
     */
    public String getADD_FIELD2() {
        return ADD_FIELD2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.ADD_FIELD2
     *
     * @param ADD_FIELD2 the value for CTSCERTIFICATE.ADD_FIELD2
     */
    public void setADD_FIELD2(String ADD_FIELD2) {
        this.ADD_FIELD2 = ADD_FIELD2 == null ? null : ADD_FIELD2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.ADD_FIELD3
     *
     * @return the value of CTSCERTIFICATE.ADD_FIELD3
     */
    public String getADD_FIELD3() {
        return ADD_FIELD3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.ADD_FIELD3
     *
     * @param ADD_FIELD3 the value for CTSCERTIFICATE.ADD_FIELD3
     */
    public void setADD_FIELD3(String ADD_FIELD3) {
        this.ADD_FIELD3 = ADD_FIELD3 == null ? null : ADD_FIELD3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.ADD_FIELD4
     *
     * @return the value of CTSCERTIFICATE.ADD_FIELD4
     */
    public String getADD_FIELD4() {
        return ADD_FIELD4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.ADD_FIELD4
     *
     * @param ADD_FIELD4 the value for CTSCERTIFICATE.ADD_FIELD4
     */
    public void setADD_FIELD4(String ADD_FIELD4) {
        this.ADD_FIELD4 = ADD_FIELD4 == null ? null : ADD_FIELD4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DETAILS_FROM
     *
     * @return the value of CTSCERTIFICATE.DETAILS_FROM
     */
    public String getDETAILS_FROM() {
        return DETAILS_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DETAILS_FROM
     *
     * @param DETAILS_FROM the value for CTSCERTIFICATE.DETAILS_FROM
     */
    public void setDETAILS_FROM(String DETAILS_FROM) {
        this.DETAILS_FROM = DETAILS_FROM == null ? null : DETAILS_FROM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.PRINT_DETAILS
     *
     * @return the value of CTSCERTIFICATE.PRINT_DETAILS
     */
    public String getPRINT_DETAILS() {
        return PRINT_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.PRINT_DETAILS
     *
     * @param PRINT_DETAILS the value for CTSCERTIFICATE.PRINT_DETAILS
     */
    public void setPRINT_DETAILS(String PRINT_DETAILS) {
        this.PRINT_DETAILS = PRINT_DETAILS == null ? null : PRINT_DETAILS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.TRX_NO
     *
     * @return the value of CTSCERTIFICATE.TRX_NO
     */
    public BigDecimal getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.TRX_NO
     *
     * @param TRX_NO the value for CTSCERTIFICATE.TRX_NO
     */
    public void setTRX_NO(BigDecimal TRX_NO) {
        this.TRX_NO = TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CHRG_WAIVED
     *
     * @return the value of CTSCERTIFICATE.CHRG_WAIVED
     */
    public String getCHRG_WAIVED() {
        return CHRG_WAIVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CHRG_WAIVED
     *
     * @param CHRG_WAIVED the value for CTSCERTIFICATE.CHRG_WAIVED
     */
    public void setCHRG_WAIVED(String CHRG_WAIVED) {
        this.CHRG_WAIVED = CHRG_WAIVED == null ? null : CHRG_WAIVED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.SL_NO
     *
     * @return the value of CTSCERTIFICATE.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.SL_NO
     *
     * @param SL_NO the value for CTSCERTIFICATE.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.LANGUAGE
     *
     * @return the value of CTSCERTIFICATE.LANGUAGE
     */
    public String getLANGUAGE() {
        return LANGUAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.LANGUAGE
     *
     * @param LANGUAGE the value for CTSCERTIFICATE.LANGUAGE
     */
    public void setLANGUAGE(String LANGUAGE) {
        this.LANGUAGE = LANGUAGE == null ? null : LANGUAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.ADDITIONAL_REFERENCE
     *
     * @return the value of CTSCERTIFICATE.ADDITIONAL_REFERENCE
     */
    public String getADDITIONAL_REFERENCE() {
        return ADDITIONAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.ADDITIONAL_REFERENCE
     *
     * @param ADDITIONAL_REFERENCE the value for CTSCERTIFICATE.ADDITIONAL_REFERENCE
     */
    public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE) {
        this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE == null ? null : ADDITIONAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.DATE_UPDATED
     *
     * @return the value of CTSCERTIFICATE.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for CTSCERTIFICATE.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.CERTIFICATE_IMAGE
     *
     * @return the value of CTSCERTIFICATE.CERTIFICATE_IMAGE
     */
    public byte[] getCERTIFICATE_IMAGE() {
        return CERTIFICATE_IMAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.CERTIFICATE_IMAGE
     *
     * @param CERTIFICATE_IMAGE the value for CTSCERTIFICATE.CERTIFICATE_IMAGE
     */
    public void setCERTIFICATE_IMAGE(byte[] CERTIFICATE_IMAGE) {
        this.CERTIFICATE_IMAGE = CERTIFICATE_IMAGE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.NUMBER_OF_BILLS
     *
     * @return the value of CTSCERTIFICATE.NUMBER_OF_BILLS
     */
    public BigDecimal getNUMBER_OF_BILLS() {
        return NUMBER_OF_BILLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.NUMBER_OF_BILLS
     *
     * @param CIF_NO the value for CTSCERTIFICATE.NUMBER_OF_BILLS
     */
    public void setNUMBER_OF_BILLS(BigDecimal NUMBER_OF_BILLS) {
        this.NUMBER_OF_BILLS = NUMBER_OF_BILLS;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATE.TOTAL_AMOUNT_OF_BILLS
     *
     * @return the value of CTSCERTIFICATE.TOTAL_AMOUNT_OF_BILLS
     */
    public BigDecimal getTOTAL_AMOUNT_OF_BILLS() {
        return TOTAL_AMOUNT_OF_BILLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATE.TOTAL_AMOUNT_OF_BILLS
     *
     * @param CIF_NO the value for CTSCERTIFICATE.TOTAL_AMOUNT_OF_BILLS
     */
    public void setTOTAL_AMOUNT_OF_BILLS(BigDecimal TOTAL_AMOUNT_OF_BILLS) {
        this.TOTAL_AMOUNT_OF_BILLS = TOTAL_AMOUNT_OF_BILLS;
    }

    public String getTO_BE_CANCELLED_BY()
    {
        return TO_BE_CANCELLED_BY;
    }

    public void setTO_BE_CANCELLED_BY(String tO_BE_CANCELLED_BY)
    {
        TO_BE_CANCELLED_BY = tO_BE_CANCELLED_BY;
    }

    public Date getTO_BE_CANCELLED_DATE()
    {
        return TO_BE_CANCELLED_DATE;
    }

    public void setTO_BE_CANCELLED_DATE(Date tO_BE_CANCELLED_DATE)
    {
        TO_BE_CANCELLED_DATE = tO_BE_CANCELLED_DATE;
    }

    public String getCANCELLED_BY()
    {
        return CANCELLED_BY;
    }

    public void setCANCELLED_BY(String cANCELLED_BY)
    {
        CANCELLED_BY = cANCELLED_BY;
    }

    public Date getCANCELLED_DATE()
    {
        return CANCELLED_DATE;
    }

    public void setCANCELLED_DATE(Date cANCELLED_DATE)
    {
        CANCELLED_DATE = cANCELLED_DATE;
    }

    public BigDecimal getREASON_CODE()
    {
        return REASON_CODE;
    }

    public void setREASON_CODE(BigDecimal rEASON_CODE)
    {
        REASON_CODE = rEASON_CODE;
    }
}