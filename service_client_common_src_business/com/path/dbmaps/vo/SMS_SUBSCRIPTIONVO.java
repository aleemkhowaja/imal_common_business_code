package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SMS_SUBSCRIPTIONVO extends SMS_SUBSCRIPTIONVOKey {
    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.MOBILE_NUM
     */
    private String MOBILE_NUM;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.SEND_TIME
     */
    private Date SEND_TIME;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.SPECIF_TYPE
     */
    private String SPECIF_TYPE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_BR
     */
    private BigDecimal ACC_BR;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_CY
     */
    private BigDecimal ACC_CY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_GL
     */
    private BigDecimal ACC_GL;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_CIF
     */
    private BigDecimal ACC_CIF;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_SL
     */
    private BigDecimal ACC_SL;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.ACC_ADD_REF
     */
    private String ACC_ADD_REF;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.SERVICE_CODE
     */
    private BigDecimal SERVICE_CODE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CANCEL_BY
     */
    private String CANCEL_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CANCEL_DATE
     */
    private Date CANCEL_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.DELETED_DATE
     */
    private Date DELETED_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.LOW_LIMIT
     */
    private BigDecimal LOW_LIMIT;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.HIGH_LIMIT
     */
    private BigDecimal HIGH_LIMIT;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_BR
     */
    private BigDecimal CHR_AC_BR;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_CY
     */
    private BigDecimal CHR_AC_CY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_GL
     */
    private BigDecimal CHR_AC_GL;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_CIF
     */
    private BigDecimal CHR_AC_CIF;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_SL
     */
    private BigDecimal CHR_AC_SL;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHR_AC_ADD_REF
     */
    private String CHR_AC_ADD_REF;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.CHARGES_DEDUCT
     */
    private String CHARGES_DEDUCT;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.WD_OPERATOR
     */
    private String WD_OPERATOR;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.WD_AMOUNT
     */
    private BigDecimal WD_AMOUNT;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.JV_TYPE
     */
    private BigDecimal JV_TYPE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.DEP_OPERATOR
     */
    private String DEP_OPERATOR;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.DEPOSIT_AMOUNT
     */
    private BigDecimal DEPOSIT_AMOUNT;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.APPROVED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.APPROVED_DATE
     */
    private Date REJECTED_DATE;

    /**
     * This field corresponds to the database column SMS_SUBSCRIPTION.STATUS
     */
    private String OLD_STATUS;

    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.STATUS
     *
     * @return the value of SMS_SUBSCRIPTION.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.STATUS
     *
     * @param STATUS the value for SMS_SUBSCRIPTION.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.MOBILE_NUM
     *
     * @return the value of SMS_SUBSCRIPTION.MOBILE_NUM
     */
    public String getMOBILE_NUM() {
        return MOBILE_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.MOBILE_NUM
     *
     * @param MOBILE_NUM the value for SMS_SUBSCRIPTION.MOBILE_NUM
     */
    public void setMOBILE_NUM(String MOBILE_NUM) {
        this.MOBILE_NUM = MOBILE_NUM == null ? null : MOBILE_NUM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.SEND_TIME
     *
     * @return the value of SMS_SUBSCRIPTION.SEND_TIME
     */
    public Date getSEND_TIME() {
        return SEND_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.SEND_TIME
     *
     * @param SEND_TIME the value for SMS_SUBSCRIPTION.SEND_TIME
     */
    public void setSEND_TIME(Date SEND_TIME) {
        this.SEND_TIME = SEND_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.SPECIF_TYPE
     *
     * @return the value of SMS_SUBSCRIPTION.SPECIF_TYPE
     */
    public String getSPECIF_TYPE() {
        return SPECIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.SPECIF_TYPE
     *
     * @param SPECIF_TYPE the value for SMS_SUBSCRIPTION.SPECIF_TYPE
     */
    public void setSPECIF_TYPE(String SPECIF_TYPE) {
        this.SPECIF_TYPE = SPECIF_TYPE == null ? null : SPECIF_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_BR
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_BR
     */
    public BigDecimal getACC_BR() {
        return ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_BR
     *
     * @param ACC_BR the value for SMS_SUBSCRIPTION.ACC_BR
     */
    public void setACC_BR(BigDecimal ACC_BR) {
        this.ACC_BR = ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_CY
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_CY
     */
    public BigDecimal getACC_CY() {
        return ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_CY
     *
     * @param ACC_CY the value for SMS_SUBSCRIPTION.ACC_CY
     */
    public void setACC_CY(BigDecimal ACC_CY) {
        this.ACC_CY = ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_GL
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_GL
     */
    public BigDecimal getACC_GL() {
        return ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_GL
     *
     * @param ACC_GL the value for SMS_SUBSCRIPTION.ACC_GL
     */
    public void setACC_GL(BigDecimal ACC_GL) {
        this.ACC_GL = ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_CIF
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_CIF
     */
    public BigDecimal getACC_CIF() {
        return ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_CIF
     *
     * @param ACC_CIF the value for SMS_SUBSCRIPTION.ACC_CIF
     */
    public void setACC_CIF(BigDecimal ACC_CIF) {
        this.ACC_CIF = ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_SL
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_SL
     */
    public BigDecimal getACC_SL() {
        return ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_SL
     *
     * @param ACC_SL the value for SMS_SUBSCRIPTION.ACC_SL
     */
    public void setACC_SL(BigDecimal ACC_SL) {
        this.ACC_SL = ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.ACC_ADD_REF
     *
     * @return the value of SMS_SUBSCRIPTION.ACC_ADD_REF
     */
    public String getACC_ADD_REF() {
        return ACC_ADD_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.ACC_ADD_REF
     *
     * @param ACC_ADD_REF the value for SMS_SUBSCRIPTION.ACC_ADD_REF
     */
    public void setACC_ADD_REF(String ACC_ADD_REF) {
        this.ACC_ADD_REF = ACC_ADD_REF == null ? null : ACC_ADD_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.SERVICE_CODE
     *
     * @return the value of SMS_SUBSCRIPTION.SERVICE_CODE
     */
    public BigDecimal getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.SERVICE_CODE
     *
     * @param SERVICE_CODE the value for SMS_SUBSCRIPTION.SERVICE_CODE
     */
    public void setSERVICE_CODE(BigDecimal SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CREATED_BY
     *
     * @return the value of SMS_SUBSCRIPTION.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CREATED_BY
     *
     * @param CREATED_BY the value for SMS_SUBSCRIPTION.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CREATED_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CREATED_DATE
     *
     * @param CREATED_DATE the value for SMS_SUBSCRIPTION.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.APPROVED_BY
     *
     * @return the value of SMS_SUBSCRIPTION.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.APPROVED_BY
     *
     * @param APPROVED_BY the value for SMS_SUBSCRIPTION.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.APPROVED_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for SMS_SUBSCRIPTION.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CANCEL_BY
     *
     * @return the value of SMS_SUBSCRIPTION.CANCEL_BY
     */
    public String getCANCEL_BY() {
        return CANCEL_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CANCEL_BY
     *
     * @param CANCEL_BY the value for SMS_SUBSCRIPTION.CANCEL_BY
     */
    public void setCANCEL_BY(String CANCEL_BY) {
        this.CANCEL_BY = CANCEL_BY == null ? null : CANCEL_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CANCEL_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.CANCEL_DATE
     */
    public Date getCANCEL_DATE() {
        return CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CANCEL_DATE
     *
     * @param CANCEL_DATE the value for SMS_SUBSCRIPTION.CANCEL_DATE
     */
    public void setCANCEL_DATE(Date CANCEL_DATE) {
        this.CANCEL_DATE = CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.MODIFIED_BY
     *
     * @return the value of SMS_SUBSCRIPTION.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SMS_SUBSCRIPTION.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.MODIFIED_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SMS_SUBSCRIPTION.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.DELETED_BY
     *
     * @return the value of SMS_SUBSCRIPTION.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.DELETED_BY
     *
     * @param DELETED_BY the value for SMS_SUBSCRIPTION.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.DELETED_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.DELETED_DATE
     */
    public Date getDELETED_DATE() {
        return DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.DELETED_DATE
     *
     * @param DELETED_DATE the value for SMS_SUBSCRIPTION.DELETED_DATE
     */
    public void setDELETED_DATE(Date DELETED_DATE) {
        this.DELETED_DATE = DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.LOW_LIMIT
     *
     * @return the value of SMS_SUBSCRIPTION.LOW_LIMIT
     */
    public BigDecimal getLOW_LIMIT() {
        return LOW_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.LOW_LIMIT
     *
     * @param LOW_LIMIT the value for SMS_SUBSCRIPTION.LOW_LIMIT
     */
    public void setLOW_LIMIT(BigDecimal LOW_LIMIT) {
        this.LOW_LIMIT = LOW_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.HIGH_LIMIT
     *
     * @return the value of SMS_SUBSCRIPTION.HIGH_LIMIT
     */
    public BigDecimal getHIGH_LIMIT() {
        return HIGH_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.HIGH_LIMIT
     *
     * @param HIGH_LIMIT the value for SMS_SUBSCRIPTION.HIGH_LIMIT
     */
    public void setHIGH_LIMIT(BigDecimal HIGH_LIMIT) {
        this.HIGH_LIMIT = HIGH_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_BR
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_BR
     */
    public BigDecimal getCHR_AC_BR() {
        return CHR_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_BR
     *
     * @param CHR_AC_BR the value for SMS_SUBSCRIPTION.CHR_AC_BR
     */
    public void setCHR_AC_BR(BigDecimal CHR_AC_BR) {
        this.CHR_AC_BR = CHR_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_CY
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_CY
     */
    public BigDecimal getCHR_AC_CY() {
        return CHR_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_CY
     *
     * @param CHR_AC_CY the value for SMS_SUBSCRIPTION.CHR_AC_CY
     */
    public void setCHR_AC_CY(BigDecimal CHR_AC_CY) {
        this.CHR_AC_CY = CHR_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_GL
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_GL
     */
    public BigDecimal getCHR_AC_GL() {
        return CHR_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_GL
     *
     * @param CHR_AC_GL the value for SMS_SUBSCRIPTION.CHR_AC_GL
     */
    public void setCHR_AC_GL(BigDecimal CHR_AC_GL) {
        this.CHR_AC_GL = CHR_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_CIF
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_CIF
     */
    public BigDecimal getCHR_AC_CIF() {
        return CHR_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_CIF
     *
     * @param CHR_AC_CIF the value for SMS_SUBSCRIPTION.CHR_AC_CIF
     */
    public void setCHR_AC_CIF(BigDecimal CHR_AC_CIF) {
        this.CHR_AC_CIF = CHR_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_SL
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_SL
     */
    public BigDecimal getCHR_AC_SL() {
        return CHR_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_SL
     *
     * @param CHR_AC_SL the value for SMS_SUBSCRIPTION.CHR_AC_SL
     */
    public void setCHR_AC_SL(BigDecimal CHR_AC_SL) {
        this.CHR_AC_SL = CHR_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHR_AC_ADD_REF
     *
     * @return the value of SMS_SUBSCRIPTION.CHR_AC_ADD_REF
     */
    public String getCHR_AC_ADD_REF() {
        return CHR_AC_ADD_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHR_AC_ADD_REF
     *
     * @param CHR_AC_ADD_REF the value for SMS_SUBSCRIPTION.CHR_AC_ADD_REF
     */
    public void setCHR_AC_ADD_REF(String CHR_AC_ADD_REF) {
        this.CHR_AC_ADD_REF = CHR_AC_ADD_REF == null ? null : CHR_AC_ADD_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.CHARGES_DEDUCT
     *
     * @return the value of SMS_SUBSCRIPTION.CHARGES_DEDUCT
     */
    public String getCHARGES_DEDUCT() {
        return CHARGES_DEDUCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.CHARGES_DEDUCT
     *
     * @param CHARGES_DEDUCT the value for SMS_SUBSCRIPTION.CHARGES_DEDUCT
     */
    public void setCHARGES_DEDUCT(String CHARGES_DEDUCT) {
        this.CHARGES_DEDUCT = CHARGES_DEDUCT == null ? null : CHARGES_DEDUCT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.WD_OPERATOR
     *
     * @return the value of SMS_SUBSCRIPTION.WD_OPERATOR
     */
    public String getWD_OPERATOR() {
        return WD_OPERATOR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.WD_OPERATOR
     *
     * @param WD_OPERATOR the value for SMS_SUBSCRIPTION.WD_OPERATOR
     */
    public void setWD_OPERATOR(String WD_OPERATOR) {
        this.WD_OPERATOR = WD_OPERATOR == null ? null : WD_OPERATOR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.WD_AMOUNT
     *
     * @return the value of SMS_SUBSCRIPTION.WD_AMOUNT
     */
    public BigDecimal getWD_AMOUNT() {
        return WD_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.WD_AMOUNT
     *
     * @param WD_AMOUNT the value for SMS_SUBSCRIPTION.WD_AMOUNT
     */
    public void setWD_AMOUNT(BigDecimal WD_AMOUNT) {
        this.WD_AMOUNT = WD_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.JV_TYPE
     *
     * @return the value of SMS_SUBSCRIPTION.JV_TYPE
     */
    public BigDecimal getJV_TYPE() {
        return JV_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.JV_TYPE
     *
     * @param JV_TYPE the value for SMS_SUBSCRIPTION.JV_TYPE
     */
    public void setJV_TYPE(BigDecimal JV_TYPE) {
        this.JV_TYPE = JV_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.DEP_OPERATOR
     *
     * @return the value of SMS_SUBSCRIPTION.DEP_OPERATOR
     */
    public String getDEP_OPERATOR() {
        return DEP_OPERATOR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.DEP_OPERATOR
     *
     * @param DEP_OPERATOR the value for SMS_SUBSCRIPTION.DEP_OPERATOR
     */
    public void setDEP_OPERATOR(String DEP_OPERATOR) {
        this.DEP_OPERATOR = DEP_OPERATOR == null ? null : DEP_OPERATOR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.DEPOSIT_AMOUNT
     *
     * @return the value of SMS_SUBSCRIPTION.DEPOSIT_AMOUNT
     */
    public BigDecimal getDEPOSIT_AMOUNT() {
        return DEPOSIT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.DEPOSIT_AMOUNT
     *
     * @param DEPOSIT_AMOUNT the value for SMS_SUBSCRIPTION.DEPOSIT_AMOUNT
     */
    public void setDEPOSIT_AMOUNT(BigDecimal DEPOSIT_AMOUNT) {
        this.DEPOSIT_AMOUNT = DEPOSIT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.DATE_UPDATED
     *
     * @return the value of SMS_SUBSCRIPTION.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for SMS_SUBSCRIPTION.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.APPROVED_BY
     *
     * @return the value of SMS_SUBSCRIPTION.APPROVED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.APPROVED_BY
     *
     * @param APPROVED_BY the value for SMS_SUBSCRIPTION.APPROVED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.APPROVED_DATE
     *
     * @return the value of SMS_SUBSCRIPTION.APPROVED_DATE
     */
    public Date getREJECTED_DATE() {
        return REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for SMS_SUBSCRIPTION.APPROVED_DATE
     */
    public void setREJECTED_DATE(Date REJECTED_DATE) {
        this.REJECTED_DATE = REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SUBSCRIPTION.STATUS
     *
     * @return the value of SMS_SUBSCRIPTION.STATUS
     */
    public String getOLD_STATUS() {
        return OLD_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SUBSCRIPTION.STATUS
     *
     * @param STATUS the value for SMS_SUBSCRIPTION.STATUS
     */
    public void setOLD_STATUS(String OLD_STATUS) {
        this.OLD_STATUS = OLD_STATUS == null ? null : OLD_STATUS.trim();
    }

}