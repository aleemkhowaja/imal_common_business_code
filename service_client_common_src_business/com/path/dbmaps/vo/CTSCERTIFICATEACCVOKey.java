package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSCERTIFICATEACCVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSCERTIFICATEACC.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column CTSCERTIFICATEACC.CERTIFICATE_CODE
     */
    private BigDecimal CERTIFICATE_CODE;

    /**
     * This field corresponds to the database column CTSCERTIFICATEACC.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSCERTIFICATEACC.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATEACC.BRANCH
     *
     * @return the value of CTSCERTIFICATEACC.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATEACC.BRANCH
     *
     * @param BRANCH the value for CTSCERTIFICATEACC.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATEACC.CERTIFICATE_CODE
     *
     * @return the value of CTSCERTIFICATEACC.CERTIFICATE_CODE
     */
    public BigDecimal getCERTIFICATE_CODE() {
        return CERTIFICATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATEACC.CERTIFICATE_CODE
     *
     * @param CERTIFICATE_CODE the value for CTSCERTIFICATEACC.CERTIFICATE_CODE
     */
    public void setCERTIFICATE_CODE(BigDecimal CERTIFICATE_CODE) {
        this.CERTIFICATE_CODE = CERTIFICATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATEACC.COMP_CODE
     *
     * @return the value of CTSCERTIFICATEACC.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATEACC.COMP_CODE
     *
     * @param COMP_CODE the value for CTSCERTIFICATEACC.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCERTIFICATEACC.LINE_NBR
     *
     * @return the value of CTSCERTIFICATEACC.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCERTIFICATEACC.LINE_NBR
     *
     * @param LINE_NBR the value for CTSCERTIFICATEACC.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }
}