package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDEAL_CHARGES_BLOCK_DETVO extends TRSDEAL_CHARGES_BLOCK_DETVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_TYPE
     */
    private String CHARGE_TYPE;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCK_STATUS
     */
    private String BLOCK_STATUS;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT_CV
     */
    private BigDecimal BLOCKED_AMOUNT_CV;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.EXCH_RATE
     */
    private BigDecimal EXCH_RATE;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT
     */
    private BigDecimal BLOCKED_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.RECOVERED_AMOUNT
     */
    private BigDecimal RECOVERED_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_CODE
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for TRSDEAL_CHARGES_BLOCK_DET.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_TYPE
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.CHARGE_TYPE
     */
    public String getCHARGE_TYPE() {
        return CHARGE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CHARGE_TYPE
     *
     * @param CHARGE_TYPE the value for TRSDEAL_CHARGES_BLOCK_DET.CHARGE_TYPE
     */
    public void setCHARGE_TYPE(String CHARGE_TYPE) {
        this.CHARGE_TYPE = CHARGE_TYPE == null ? null : CHARGE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCK_STATUS
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.BLOCK_STATUS
     */
    public String getBLOCK_STATUS() {
        return BLOCK_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCK_STATUS
     *
     * @param BLOCK_STATUS the value for TRSDEAL_CHARGES_BLOCK_DET.BLOCK_STATUS
     */
    public void setBLOCK_STATUS(String BLOCK_STATUS) {
        this.BLOCK_STATUS = BLOCK_STATUS == null ? null : BLOCK_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT_CV
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT_CV
     */
    public BigDecimal getBLOCKED_AMOUNT_CV() {
        return BLOCKED_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT_CV
     *
     * @param BLOCKED_AMOUNT_CV the value for TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT_CV
     */
    public void setBLOCKED_AMOUNT_CV(BigDecimal BLOCKED_AMOUNT_CV) {
        this.BLOCKED_AMOUNT_CV = BLOCKED_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.EXCH_RATE
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.EXCH_RATE
     */
    public BigDecimal getEXCH_RATE() {
        return EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.EXCH_RATE
     *
     * @param EXCH_RATE the value for TRSDEAL_CHARGES_BLOCK_DET.EXCH_RATE
     */
    public void setEXCH_RATE(BigDecimal EXCH_RATE) {
        this.EXCH_RATE = EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT
     */
    public BigDecimal getBLOCKED_AMOUNT() {
        return BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT
     *
     * @param BLOCKED_AMOUNT the value for TRSDEAL_CHARGES_BLOCK_DET.BLOCKED_AMOUNT
     */
    public void setBLOCKED_AMOUNT(BigDecimal BLOCKED_AMOUNT) {
        this.BLOCKED_AMOUNT = BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.RECOVERED_AMOUNT
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.RECOVERED_AMOUNT
     */
    public BigDecimal getRECOVERED_AMOUNT() {
        return RECOVERED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.RECOVERED_AMOUNT
     *
     * @param RECOVERED_AMOUNT the value for TRSDEAL_CHARGES_BLOCK_DET.RECOVERED_AMOUNT
     */
    public void setRECOVERED_AMOUNT(BigDecimal RECOVERED_AMOUNT) {
        this.RECOVERED_AMOUNT = RECOVERED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CURRENCY_CODE
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for TRSDEAL_CHARGES_BLOCK_DET.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CREATED_BY
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.CREATED_BY
     *
     * @param CREATED_BY the value for TRSDEAL_CHARGES_BLOCK_DET.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_CREATED
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_CREATED
     *
     * @param DATE_CREATED the value for TRSDEAL_CHARGES_BLOCK_DET.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.MODIFIED_BY
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TRSDEAL_CHARGES_BLOCK_DET.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_MODIFIED
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for TRSDEAL_CHARGES_BLOCK_DET.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.APPROVED_BY
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.APPROVED_BY
     *
     * @param APPROVED_BY the value for TRSDEAL_CHARGES_BLOCK_DET.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_APPROVED
     *
     * @return the value of TRSDEAL_CHARGES_BLOCK_DET.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGES_BLOCK_DET.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for TRSDEAL_CHARGES_BLOCK_DET.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }
}