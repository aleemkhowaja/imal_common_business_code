package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AMF_EASY_CASHVO extends AMF_EASY_CASHVOKey {
    /**
     * This field corresponds to the database column AMF_EASY_CASH.PSR_RATE
     */
    private BigDecimal PSR_RATE;

    /**
     * This field corresponds to the database column AMF_EASY_CASH.PROFIT_DECL_AMOUNT
     */
    private BigDecimal PROFIT_DECL_AMOUNT;

    /**
     * This field corresponds to the database column AMF_EASY_CASH.PSR_AMOUNT
     */
    private BigDecimal PSR_AMOUNT;

    /**
     * This field corresponds to the database column AMF_EASY_CASH.PROFIT_DECL_DATE
     */
    private Date PROFIT_DECL_DATE;

    /**
     * This field corresponds to the database column AMF_EASY_CASH.EXPECTED_PROFIT_DECL_DATE
     */
    private Date EXPECTED_PROFIT_DECL_DATE;

    /**
     * This field corresponds to the database column AMF_EASY_CASH.IS_PROCESSED
     */
    private String IS_PROCESSED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.PSR_RATE
     *
     * @return the value of AMF_EASY_CASH.PSR_RATE
     */
    public BigDecimal getPSR_RATE() {
        return PSR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.PSR_RATE
     *
     * @param PSR_RATE the value for AMF_EASY_CASH.PSR_RATE
     */
    public void setPSR_RATE(BigDecimal PSR_RATE) {
        this.PSR_RATE = PSR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.PROFIT_DECL_AMOUNT
     *
     * @return the value of AMF_EASY_CASH.PROFIT_DECL_AMOUNT
     */
    public BigDecimal getPROFIT_DECL_AMOUNT() {
        return PROFIT_DECL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.PROFIT_DECL_AMOUNT
     *
     * @param PROFIT_DECL_AMOUNT the value for AMF_EASY_CASH.PROFIT_DECL_AMOUNT
     */
    public void setPROFIT_DECL_AMOUNT(BigDecimal PROFIT_DECL_AMOUNT) {
        this.PROFIT_DECL_AMOUNT = PROFIT_DECL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.PSR_AMOUNT
     *
     * @return the value of AMF_EASY_CASH.PSR_AMOUNT
     */
    public BigDecimal getPSR_AMOUNT() {
        return PSR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.PSR_AMOUNT
     *
     * @param PSR_AMOUNT the value for AMF_EASY_CASH.PSR_AMOUNT
     */
    public void setPSR_AMOUNT(BigDecimal PSR_AMOUNT) {
        this.PSR_AMOUNT = PSR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.PROFIT_DECL_DATE
     *
     * @return the value of AMF_EASY_CASH.PROFIT_DECL_DATE
     */
    public Date getPROFIT_DECL_DATE() {
        return PROFIT_DECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.PROFIT_DECL_DATE
     *
     * @param PROFIT_DECL_DATE the value for AMF_EASY_CASH.PROFIT_DECL_DATE
     */
    public void setPROFIT_DECL_DATE(Date PROFIT_DECL_DATE) {
        this.PROFIT_DECL_DATE = PROFIT_DECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.EXPECTED_PROFIT_DECL_DATE
     *
     * @return the value of AMF_EASY_CASH.EXPECTED_PROFIT_DECL_DATE
     */
    public Date getEXPECTED_PROFIT_DECL_DATE() {
        return EXPECTED_PROFIT_DECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.EXPECTED_PROFIT_DECL_DATE
     *
     * @param EXPECTED_PROFIT_DECL_DATE the value for AMF_EASY_CASH.EXPECTED_PROFIT_DECL_DATE
     */
    public void setEXPECTED_PROFIT_DECL_DATE(Date EXPECTED_PROFIT_DECL_DATE) {
        this.EXPECTED_PROFIT_DECL_DATE = EXPECTED_PROFIT_DECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_EASY_CASH.IS_PROCESSED
     *
     * @return the value of AMF_EASY_CASH.IS_PROCESSED
     */
    public String getIS_PROCESSED() {
        return IS_PROCESSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_EASY_CASH.IS_PROCESSED
     *
     * @param IS_PROCESSED the value for AMF_EASY_CASH.IS_PROCESSED
     */
    public void setIS_PROCESSED(String IS_PROCESSED) {
        this.IS_PROCESSED = IS_PROCESSED == null ? null : IS_PROCESSED.trim();
    }
}