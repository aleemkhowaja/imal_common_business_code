package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AMF_DCHEQSVO extends AMF_DCHEQSVOKey {
    /**
     * This field corresponds to the database column AMF_DCHEQS.DCHEQS_FLAG
     */
    private String DCHEQS_FLAG;

    /**
     * This field corresponds to the database column AMF_DCHEQS.VOIDING_LEVEL
     */
    private BigDecimal VOIDING_LEVEL;

    /**
     * This field corresponds to the database column AMF_DCHEQS.CHQ_NUM
     */
    private BigDecimal CHQ_NUM;

    /**
     * This field corresponds to the database column AMF_DCHEQS.CHQ_AMOUNT
     */
    private BigDecimal CHQ_AMOUNT;

    /**
     * This field corresponds to the database column AMF_DCHEQS.INCIDENCE_DATE
     */
    private Date INCIDENCE_DATE;

    /**
     * This field corresponds to the database column AMF_DCHEQS.INCIDENCE_STATUS
     */
    private String INCIDENCE_STATUS;

    /**
     * This field corresponds to the database column AMF_DCHEQS.UPDATED_BY
     */
    private String UPDATED_BY;

    /**
     * This field corresponds to the database column AMF_DCHEQS.UPDATED_DATE
     */
    private Date UPDATED_DATE;

    /**
     * This field corresponds to the database column AMF_DCHEQS.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.DCHEQS_FLAG
     *
     * @return the value of AMF_DCHEQS.DCHEQS_FLAG
     */
    public String getDCHEQS_FLAG() {
        return DCHEQS_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.DCHEQS_FLAG
     *
     * @param DCHEQS_FLAG the value for AMF_DCHEQS.DCHEQS_FLAG
     */
    public void setDCHEQS_FLAG(String DCHEQS_FLAG) {
        this.DCHEQS_FLAG = DCHEQS_FLAG == null ? null : DCHEQS_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.VOIDING_LEVEL
     *
     * @return the value of AMF_DCHEQS.VOIDING_LEVEL
     */
    public BigDecimal getVOIDING_LEVEL() {
        return VOIDING_LEVEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.VOIDING_LEVEL
     *
     * @param VOIDING_LEVEL the value for AMF_DCHEQS.VOIDING_LEVEL
     */
    public void setVOIDING_LEVEL(BigDecimal VOIDING_LEVEL) {
        this.VOIDING_LEVEL = VOIDING_LEVEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.CHQ_NUM
     *
     * @return the value of AMF_DCHEQS.CHQ_NUM
     */
    public BigDecimal getCHQ_NUM() {
        return CHQ_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.CHQ_NUM
     *
     * @param CHQ_NUM the value for AMF_DCHEQS.CHQ_NUM
     */
    public void setCHQ_NUM(BigDecimal CHQ_NUM) {
        this.CHQ_NUM = CHQ_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.CHQ_AMOUNT
     *
     * @return the value of AMF_DCHEQS.CHQ_AMOUNT
     */
    public BigDecimal getCHQ_AMOUNT() {
        return CHQ_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.CHQ_AMOUNT
     *
     * @param CHQ_AMOUNT the value for AMF_DCHEQS.CHQ_AMOUNT
     */
    public void setCHQ_AMOUNT(BigDecimal CHQ_AMOUNT) {
        this.CHQ_AMOUNT = CHQ_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.INCIDENCE_DATE
     *
     * @return the value of AMF_DCHEQS.INCIDENCE_DATE
     */
    public Date getINCIDENCE_DATE() {
        return INCIDENCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.INCIDENCE_DATE
     *
     * @param INCIDENCE_DATE the value for AMF_DCHEQS.INCIDENCE_DATE
     */
    public void setINCIDENCE_DATE(Date INCIDENCE_DATE) {
        this.INCIDENCE_DATE = INCIDENCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.INCIDENCE_STATUS
     *
     * @return the value of AMF_DCHEQS.INCIDENCE_STATUS
     */
    public String getINCIDENCE_STATUS() {
        return INCIDENCE_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.INCIDENCE_STATUS
     *
     * @param INCIDENCE_STATUS the value for AMF_DCHEQS.INCIDENCE_STATUS
     */
    public void setINCIDENCE_STATUS(String INCIDENCE_STATUS) {
        this.INCIDENCE_STATUS = INCIDENCE_STATUS == null ? null : INCIDENCE_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.UPDATED_BY
     *
     * @return the value of AMF_DCHEQS.UPDATED_BY
     */
    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.UPDATED_BY
     *
     * @param UPDATED_BY the value for AMF_DCHEQS.UPDATED_BY
     */
    public void setUPDATED_BY(String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY == null ? null : UPDATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.UPDATED_DATE
     *
     * @return the value of AMF_DCHEQS.UPDATED_DATE
     */
    public Date getUPDATED_DATE() {
        return UPDATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.UPDATED_DATE
     *
     * @param UPDATED_DATE the value for AMF_DCHEQS.UPDATED_DATE
     */
    public void setUPDATED_DATE(Date UPDATED_DATE) {
        this.UPDATED_DATE = UPDATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DCHEQS.DATE_UPDATED
     *
     * @return the value of AMF_DCHEQS.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DCHEQS.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for AMF_DCHEQS.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }
}