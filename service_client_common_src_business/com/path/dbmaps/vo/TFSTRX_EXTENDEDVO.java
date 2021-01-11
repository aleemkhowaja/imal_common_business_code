package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TFSTRX_EXTENDEDVO extends BaseVO {
    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.LC_TYPE
     */
    private String LC_TYPE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.TRX_NBR
     */
    private BigDecimal TRX_NBR;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.TRX_TYPE
     */
    private BigDecimal TRX_TYPE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_REFERENCE
     */
    private String AMEND_REFERENCE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_ADVISING_BANK_CIF
     */
    private BigDecimal AMEND_ADVISING_BANK_CIF;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE
     */
    private String AMEND_BANK_DEF_BIC_CODE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE1
     */
    private String AMEND_BANK_DEF_BIC_CODE1;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_NAME1
     */
    private String AMEND_BANK_DEF_NAME1;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_BANK_BRANCH
     */
    private String AMEND_BANK_BRANCH;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_BANK_ACCOUNT
     */
    private String AMEND_BANK_ACCOUNT;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_PRINCIPAL_REF
     */
    private String AMEND_PRINCIPAL_REF;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_COUNTRY
     */
    private BigDecimal AMEND_COUNTRY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_FULLNAME
     */
    private String AMEND_FULLNAME;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_ADDRESS1
     */
    private String AMEND_ADDRESS1;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_ADDRESS2
     */
    private String AMEND_ADDRESS2;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMEND_ADDRESS3
     */
    private String AMEND_ADDRESS3;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CROSS_RATE
     */
    private BigDecimal CROSS_RATE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.MARGIN_AMOUNT
     */
    private BigDecimal MARGIN_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.MARGIN_AMT_CY2
     */
    private BigDecimal MARGIN_AMT_CY2;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.MARGIN_PERC
     */
    private BigDecimal MARGIN_PERC;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.MARGIN_REQUIRED
     */
    private BigDecimal MARGIN_REQUIRED;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_BR
     */
    private BigDecimal NOSTRO_MARGIN_BR;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CIF
     */
    private BigDecimal NOSTRO_MARGIN_CIF;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CY
     */
    private BigDecimal NOSTRO_MARGIN_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_GL
     */
    private BigDecimal NOSTRO_MARGIN_GL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_SL
     */
    private BigDecimal NOSTRO_MARGIN_SL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_BR
     */
    private BigDecimal SETTLEMENT_ACC_BR;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CIF
     */
    private BigDecimal SETTLEMENT_ACC_CIF;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CY
     */
    private BigDecimal SETTLEMENT_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_GL
     */
    private BigDecimal SETTLEMENT_ACC_GL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_SL
     */
    private BigDecimal SETTLEMENT_ACC_SL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.BANK_ACC_CY
     */
    private BigDecimal BANK_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.BANK_PENALIZED_YN
     */
    private String BANK_PENALIZED_YN;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.BANK_PENALTY_CROSS_RATE
     */
    private BigDecimal BANK_PENALTY_CROSS_RATE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMT_IN_BANK_CY
     */
    private BigDecimal AMT_IN_BANK_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMT_IN_CREDIT_CY
     */
    private BigDecimal AMT_IN_CREDIT_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CREDIT_ACC_CY
     */
    private BigDecimal CREDIT_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_ACC_BR
     */
    private BigDecimal CUSTOMER_ACC_BR;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CIF
     */
    private BigDecimal CUSTOMER_ACC_CIF;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CY
     */
    private BigDecimal CUSTOMER_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_ACC_GL
     */
    private BigDecimal CUSTOMER_ACC_GL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_ACC_SL
     */
    private BigDecimal CUSTOMER_ACC_SL;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.CUSTOMER_PENALTY_CROSS_RATE
     */
    private BigDecimal CUSTOMER_PENALTY_CROSS_RATE;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMT_IN_CUSTOMER_CY
     */
    private BigDecimal AMT_IN_CUSTOMER_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.AMT_IN_PENALTY_CY
     */
    private BigDecimal AMT_IN_PENALTY_CY;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.DOCUMENTS_RECEIVED_YN
     */
    private String DOCUMENTS_RECEIVED_YN;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.DOC_DATE_RECEIVED
     */
    private Date DOC_DATE_RECEIVED;

    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.PENALTY_ACC_CY
     */
    private BigDecimal PENALTY_ACC_CY;
    
    
    /**
     * This field corresponds to the database column TFSTRX_EXTENDED.SYNTHESIS_STATUS
     */
    private String SYNTHESIS_STATUS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.BRANCH
     *
     * @return the value of TFSTRX_EXTENDED.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.BRANCH
     *
     * @param BRANCH the value for TFSTRX_EXTENDED.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.COMP_CODE
     *
     * @return the value of TFSTRX_EXTENDED.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.COMP_CODE
     *
     * @param COMP_CODE the value for TFSTRX_EXTENDED.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.LC_TYPE
     *
     * @return the value of TFSTRX_EXTENDED.LC_TYPE
     */
    public String getLC_TYPE() {
        return LC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.LC_TYPE
     *
     * @param LC_TYPE the value for TFSTRX_EXTENDED.LC_TYPE
     */
    public void setLC_TYPE(String LC_TYPE) {
        this.LC_TYPE = LC_TYPE == null ? null : LC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.TRX_NBR
     *
     * @return the value of TFSTRX_EXTENDED.TRX_NBR
     */
    public BigDecimal getTRX_NBR() {
        return TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.TRX_NBR
     *
     * @param TRX_NBR the value for TFSTRX_EXTENDED.TRX_NBR
     */
    public void setTRX_NBR(BigDecimal TRX_NBR) {
        this.TRX_NBR = TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.TRX_TYPE
     *
     * @return the value of TFSTRX_EXTENDED.TRX_TYPE
     */
    public BigDecimal getTRX_TYPE() {
        return TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.TRX_TYPE
     *
     * @param TRX_TYPE the value for TFSTRX_EXTENDED.TRX_TYPE
     */
    public void setTRX_TYPE(BigDecimal TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_REFERENCE
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_REFERENCE
     */
    public String getAMEND_REFERENCE() {
        return AMEND_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_REFERENCE
     *
     * @param AMEND_REFERENCE the value for TFSTRX_EXTENDED.AMEND_REFERENCE
     */
    public void setAMEND_REFERENCE(String AMEND_REFERENCE) {
        this.AMEND_REFERENCE = AMEND_REFERENCE == null ? null : AMEND_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_ADVISING_BANK_CIF
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_ADVISING_BANK_CIF
     */
    public BigDecimal getAMEND_ADVISING_BANK_CIF() {
        return AMEND_ADVISING_BANK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_ADVISING_BANK_CIF
     *
     * @param AMEND_ADVISING_BANK_CIF the value for TFSTRX_EXTENDED.AMEND_ADVISING_BANK_CIF
     */
    public void setAMEND_ADVISING_BANK_CIF(BigDecimal AMEND_ADVISING_BANK_CIF) {
        this.AMEND_ADVISING_BANK_CIF = AMEND_ADVISING_BANK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE
     */
    public String getAMEND_BANK_DEF_BIC_CODE() {
        return AMEND_BANK_DEF_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE
     *
     * @param AMEND_BANK_DEF_BIC_CODE the value for TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE
     */
    public void setAMEND_BANK_DEF_BIC_CODE(String AMEND_BANK_DEF_BIC_CODE) {
        this.AMEND_BANK_DEF_BIC_CODE = AMEND_BANK_DEF_BIC_CODE == null ? null : AMEND_BANK_DEF_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE1
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE1
     */
    public String getAMEND_BANK_DEF_BIC_CODE1() {
        return AMEND_BANK_DEF_BIC_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE1
     *
     * @param AMEND_BANK_DEF_BIC_CODE1 the value for TFSTRX_EXTENDED.AMEND_BANK_DEF_BIC_CODE1
     */
    public void setAMEND_BANK_DEF_BIC_CODE1(String AMEND_BANK_DEF_BIC_CODE1) {
        this.AMEND_BANK_DEF_BIC_CODE1 = AMEND_BANK_DEF_BIC_CODE1 == null ? null : AMEND_BANK_DEF_BIC_CODE1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_NAME1
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_BANK_DEF_NAME1
     */
    public String getAMEND_BANK_DEF_NAME1() {
        return AMEND_BANK_DEF_NAME1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_BANK_DEF_NAME1
     *
     * @param AMEND_BANK_DEF_NAME1 the value for TFSTRX_EXTENDED.AMEND_BANK_DEF_NAME1
     */
    public void setAMEND_BANK_DEF_NAME1(String AMEND_BANK_DEF_NAME1) {
        this.AMEND_BANK_DEF_NAME1 = AMEND_BANK_DEF_NAME1 == null ? null : AMEND_BANK_DEF_NAME1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_BANK_BRANCH
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_BANK_BRANCH
     */
    public String getAMEND_BANK_BRANCH() {
        return AMEND_BANK_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_BANK_BRANCH
     *
     * @param AMEND_BANK_BRANCH the value for TFSTRX_EXTENDED.AMEND_BANK_BRANCH
     */
    public void setAMEND_BANK_BRANCH(String AMEND_BANK_BRANCH) {
        this.AMEND_BANK_BRANCH = AMEND_BANK_BRANCH == null ? null : AMEND_BANK_BRANCH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_BANK_ACCOUNT
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_BANK_ACCOUNT
     */
    public String getAMEND_BANK_ACCOUNT() {
        return AMEND_BANK_ACCOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_BANK_ACCOUNT
     *
     * @param AMEND_BANK_ACCOUNT the value for TFSTRX_EXTENDED.AMEND_BANK_ACCOUNT
     */
    public void setAMEND_BANK_ACCOUNT(String AMEND_BANK_ACCOUNT) {
        this.AMEND_BANK_ACCOUNT = AMEND_BANK_ACCOUNT == null ? null : AMEND_BANK_ACCOUNT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_PRINCIPAL_REF
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_PRINCIPAL_REF
     */
    public String getAMEND_PRINCIPAL_REF() {
        return AMEND_PRINCIPAL_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_PRINCIPAL_REF
     *
     * @param AMEND_PRINCIPAL_REF the value for TFSTRX_EXTENDED.AMEND_PRINCIPAL_REF
     */
    public void setAMEND_PRINCIPAL_REF(String AMEND_PRINCIPAL_REF) {
        this.AMEND_PRINCIPAL_REF = AMEND_PRINCIPAL_REF == null ? null : AMEND_PRINCIPAL_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_COUNTRY
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_COUNTRY
     */
    public BigDecimal getAMEND_COUNTRY() {
        return AMEND_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_COUNTRY
     *
     * @param AMEND_COUNTRY the value for TFSTRX_EXTENDED.AMEND_COUNTRY
     */
    public void setAMEND_COUNTRY(BigDecimal AMEND_COUNTRY) {
        this.AMEND_COUNTRY = AMEND_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_FULLNAME
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_FULLNAME
     */
    public String getAMEND_FULLNAME() {
        return AMEND_FULLNAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_FULLNAME
     *
     * @param AMEND_FULLNAME the value for TFSTRX_EXTENDED.AMEND_FULLNAME
     */
    public void setAMEND_FULLNAME(String AMEND_FULLNAME) {
        this.AMEND_FULLNAME = AMEND_FULLNAME == null ? null : AMEND_FULLNAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS1
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_ADDRESS1
     */
    public String getAMEND_ADDRESS1() {
        return AMEND_ADDRESS1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS1
     *
     * @param AMEND_ADDRESS1 the value for TFSTRX_EXTENDED.AMEND_ADDRESS1
     */
    public void setAMEND_ADDRESS1(String AMEND_ADDRESS1) {
        this.AMEND_ADDRESS1 = AMEND_ADDRESS1 == null ? null : AMEND_ADDRESS1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS2
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_ADDRESS2
     */
    public String getAMEND_ADDRESS2() {
        return AMEND_ADDRESS2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS2
     *
     * @param AMEND_ADDRESS2 the value for TFSTRX_EXTENDED.AMEND_ADDRESS2
     */
    public void setAMEND_ADDRESS2(String AMEND_ADDRESS2) {
        this.AMEND_ADDRESS2 = AMEND_ADDRESS2 == null ? null : AMEND_ADDRESS2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS3
     *
     * @return the value of TFSTRX_EXTENDED.AMEND_ADDRESS3
     */
    public String getAMEND_ADDRESS3() {
        return AMEND_ADDRESS3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMEND_ADDRESS3
     *
     * @param AMEND_ADDRESS3 the value for TFSTRX_EXTENDED.AMEND_ADDRESS3
     */
    public void setAMEND_ADDRESS3(String AMEND_ADDRESS3) {
        this.AMEND_ADDRESS3 = AMEND_ADDRESS3 == null ? null : AMEND_ADDRESS3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CROSS_RATE
     *
     * @return the value of TFSTRX_EXTENDED.CROSS_RATE
     */
    public BigDecimal getCROSS_RATE() {
        return CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CROSS_RATE
     *
     * @param CROSS_RATE the value for TFSTRX_EXTENDED.CROSS_RATE
     */
    public void setCROSS_RATE(BigDecimal CROSS_RATE) {
        this.CROSS_RATE = CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.MARGIN_AMOUNT
     *
     * @return the value of TFSTRX_EXTENDED.MARGIN_AMOUNT
     */
    public BigDecimal getMARGIN_AMOUNT() {
        return MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.MARGIN_AMOUNT
     *
     * @param MARGIN_AMOUNT the value for TFSTRX_EXTENDED.MARGIN_AMOUNT
     */
    public void setMARGIN_AMOUNT(BigDecimal MARGIN_AMOUNT) {
        this.MARGIN_AMOUNT = MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.MARGIN_AMT_CY2
     *
     * @return the value of TFSTRX_EXTENDED.MARGIN_AMT_CY2
     */
    public BigDecimal getMARGIN_AMT_CY2() {
        return MARGIN_AMT_CY2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.MARGIN_AMT_CY2
     *
     * @param MARGIN_AMT_CY2 the value for TFSTRX_EXTENDED.MARGIN_AMT_CY2
     */
    public void setMARGIN_AMT_CY2(BigDecimal MARGIN_AMT_CY2) {
        this.MARGIN_AMT_CY2 = MARGIN_AMT_CY2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.MARGIN_PERC
     *
     * @return the value of TFSTRX_EXTENDED.MARGIN_PERC
     */
    public BigDecimal getMARGIN_PERC() {
        return MARGIN_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.MARGIN_PERC
     *
     * @param MARGIN_PERC the value for TFSTRX_EXTENDED.MARGIN_PERC
     */
    public void setMARGIN_PERC(BigDecimal MARGIN_PERC) {
        this.MARGIN_PERC = MARGIN_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.MARGIN_REQUIRED
     *
     * @return the value of TFSTRX_EXTENDED.MARGIN_REQUIRED
     */
    public BigDecimal getMARGIN_REQUIRED() {
        return MARGIN_REQUIRED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.MARGIN_REQUIRED
     *
     * @param MARGIN_REQUIRED the value for TFSTRX_EXTENDED.MARGIN_REQUIRED
     */
    public void setMARGIN_REQUIRED(BigDecimal MARGIN_REQUIRED) {
        this.MARGIN_REQUIRED = MARGIN_REQUIRED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_BR
     *
     * @return the value of TFSTRX_EXTENDED.NOSTRO_MARGIN_BR
     */
    public BigDecimal getNOSTRO_MARGIN_BR() {
        return NOSTRO_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_BR
     *
     * @param NOSTRO_MARGIN_BR the value for TFSTRX_EXTENDED.NOSTRO_MARGIN_BR
     */
    public void setNOSTRO_MARGIN_BR(BigDecimal NOSTRO_MARGIN_BR) {
        this.NOSTRO_MARGIN_BR = NOSTRO_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CIF
     *
     * @return the value of TFSTRX_EXTENDED.NOSTRO_MARGIN_CIF
     */
    public BigDecimal getNOSTRO_MARGIN_CIF() {
        return NOSTRO_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CIF
     *
     * @param NOSTRO_MARGIN_CIF the value for TFSTRX_EXTENDED.NOSTRO_MARGIN_CIF
     */
    public void setNOSTRO_MARGIN_CIF(BigDecimal NOSTRO_MARGIN_CIF) {
        this.NOSTRO_MARGIN_CIF = NOSTRO_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CY
     *
     * @return the value of TFSTRX_EXTENDED.NOSTRO_MARGIN_CY
     */
    public BigDecimal getNOSTRO_MARGIN_CY() {
        return NOSTRO_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_CY
     *
     * @param NOSTRO_MARGIN_CY the value for TFSTRX_EXTENDED.NOSTRO_MARGIN_CY
     */
    public void setNOSTRO_MARGIN_CY(BigDecimal NOSTRO_MARGIN_CY) {
        this.NOSTRO_MARGIN_CY = NOSTRO_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_GL
     *
     * @return the value of TFSTRX_EXTENDED.NOSTRO_MARGIN_GL
     */
    public BigDecimal getNOSTRO_MARGIN_GL() {
        return NOSTRO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_GL
     *
     * @param NOSTRO_MARGIN_GL the value for TFSTRX_EXTENDED.NOSTRO_MARGIN_GL
     */
    public void setNOSTRO_MARGIN_GL(BigDecimal NOSTRO_MARGIN_GL) {
        this.NOSTRO_MARGIN_GL = NOSTRO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_SL
     *
     * @return the value of TFSTRX_EXTENDED.NOSTRO_MARGIN_SL
     */
    public BigDecimal getNOSTRO_MARGIN_SL() {
        return NOSTRO_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.NOSTRO_MARGIN_SL
     *
     * @param NOSTRO_MARGIN_SL the value for TFSTRX_EXTENDED.NOSTRO_MARGIN_SL
     */
    public void setNOSTRO_MARGIN_SL(BigDecimal NOSTRO_MARGIN_SL) {
        this.NOSTRO_MARGIN_SL = NOSTRO_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_BR
     *
     * @return the value of TFSTRX_EXTENDED.SETTLEMENT_ACC_BR
     */
    public BigDecimal getSETTLEMENT_ACC_BR() {
        return SETTLEMENT_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_BR
     *
     * @param SETTLEMENT_ACC_BR the value for TFSTRX_EXTENDED.SETTLEMENT_ACC_BR
     */
    public void setSETTLEMENT_ACC_BR(BigDecimal SETTLEMENT_ACC_BR) {
        this.SETTLEMENT_ACC_BR = SETTLEMENT_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CIF
     *
     * @return the value of TFSTRX_EXTENDED.SETTLEMENT_ACC_CIF
     */
    public BigDecimal getSETTLEMENT_ACC_CIF() {
        return SETTLEMENT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CIF
     *
     * @param SETTLEMENT_ACC_CIF the value for TFSTRX_EXTENDED.SETTLEMENT_ACC_CIF
     */
    public void setSETTLEMENT_ACC_CIF(BigDecimal SETTLEMENT_ACC_CIF) {
        this.SETTLEMENT_ACC_CIF = SETTLEMENT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CY
     *
     * @return the value of TFSTRX_EXTENDED.SETTLEMENT_ACC_CY
     */
    public BigDecimal getSETTLEMENT_ACC_CY() {
        return SETTLEMENT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_CY
     *
     * @param SETTLEMENT_ACC_CY the value for TFSTRX_EXTENDED.SETTLEMENT_ACC_CY
     */
    public void setSETTLEMENT_ACC_CY(BigDecimal SETTLEMENT_ACC_CY) {
        this.SETTLEMENT_ACC_CY = SETTLEMENT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_GL
     *
     * @return the value of TFSTRX_EXTENDED.SETTLEMENT_ACC_GL
     */
    public BigDecimal getSETTLEMENT_ACC_GL() {
        return SETTLEMENT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_GL
     *
     * @param SETTLEMENT_ACC_GL the value for TFSTRX_EXTENDED.SETTLEMENT_ACC_GL
     */
    public void setSETTLEMENT_ACC_GL(BigDecimal SETTLEMENT_ACC_GL) {
        this.SETTLEMENT_ACC_GL = SETTLEMENT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_SL
     *
     * @return the value of TFSTRX_EXTENDED.SETTLEMENT_ACC_SL
     */
    public BigDecimal getSETTLEMENT_ACC_SL() {
        return SETTLEMENT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.SETTLEMENT_ACC_SL
     *
     * @param SETTLEMENT_ACC_SL the value for TFSTRX_EXTENDED.SETTLEMENT_ACC_SL
     */
    public void setSETTLEMENT_ACC_SL(BigDecimal SETTLEMENT_ACC_SL) {
        this.SETTLEMENT_ACC_SL = SETTLEMENT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.BANK_ACC_CY
     *
     * @return the value of TFSTRX_EXTENDED.BANK_ACC_CY
     */
    public BigDecimal getBANK_ACC_CY() {
        return BANK_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.BANK_ACC_CY
     *
     * @param BANK_ACC_CY the value for TFSTRX_EXTENDED.BANK_ACC_CY
     */
    public void setBANK_ACC_CY(BigDecimal BANK_ACC_CY) {
        this.BANK_ACC_CY = BANK_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.BANK_PENALIZED_YN
     *
     * @return the value of TFSTRX_EXTENDED.BANK_PENALIZED_YN
     */
    public String getBANK_PENALIZED_YN() {
        return BANK_PENALIZED_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.BANK_PENALIZED_YN
     *
     * @param BANK_PENALIZED_YN the value for TFSTRX_EXTENDED.BANK_PENALIZED_YN
     */
    public void setBANK_PENALIZED_YN(String BANK_PENALIZED_YN) {
        this.BANK_PENALIZED_YN = BANK_PENALIZED_YN == null ? null : BANK_PENALIZED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.BANK_PENALTY_CROSS_RATE
     *
     * @return the value of TFSTRX_EXTENDED.BANK_PENALTY_CROSS_RATE
     */
    public BigDecimal getBANK_PENALTY_CROSS_RATE() {
        return BANK_PENALTY_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.BANK_PENALTY_CROSS_RATE
     *
     * @param BANK_PENALTY_CROSS_RATE the value for TFSTRX_EXTENDED.BANK_PENALTY_CROSS_RATE
     */
    public void setBANK_PENALTY_CROSS_RATE(BigDecimal BANK_PENALTY_CROSS_RATE) {
        this.BANK_PENALTY_CROSS_RATE = BANK_PENALTY_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMT_IN_BANK_CY
     *
     * @return the value of TFSTRX_EXTENDED.AMT_IN_BANK_CY
     */
    public BigDecimal getAMT_IN_BANK_CY() {
        return AMT_IN_BANK_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMT_IN_BANK_CY
     *
     * @param AMT_IN_BANK_CY the value for TFSTRX_EXTENDED.AMT_IN_BANK_CY
     */
    public void setAMT_IN_BANK_CY(BigDecimal AMT_IN_BANK_CY) {
        this.AMT_IN_BANK_CY = AMT_IN_BANK_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMT_IN_CREDIT_CY
     *
     * @return the value of TFSTRX_EXTENDED.AMT_IN_CREDIT_CY
     */
    public BigDecimal getAMT_IN_CREDIT_CY() {
        return AMT_IN_CREDIT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMT_IN_CREDIT_CY
     *
     * @param AMT_IN_CREDIT_CY the value for TFSTRX_EXTENDED.AMT_IN_CREDIT_CY
     */
    public void setAMT_IN_CREDIT_CY(BigDecimal AMT_IN_CREDIT_CY) {
        this.AMT_IN_CREDIT_CY = AMT_IN_CREDIT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CREDIT_ACC_CY
     *
     * @return the value of TFSTRX_EXTENDED.CREDIT_ACC_CY
     */
    public BigDecimal getCREDIT_ACC_CY() {
        return CREDIT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CREDIT_ACC_CY
     *
     * @param CREDIT_ACC_CY the value for TFSTRX_EXTENDED.CREDIT_ACC_CY
     */
    public void setCREDIT_ACC_CY(BigDecimal CREDIT_ACC_CY) {
        this.CREDIT_ACC_CY = CREDIT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_BR
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_ACC_BR
     */
    public BigDecimal getCUSTOMER_ACC_BR() {
        return CUSTOMER_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_BR
     *
     * @param CUSTOMER_ACC_BR the value for TFSTRX_EXTENDED.CUSTOMER_ACC_BR
     */
    public void setCUSTOMER_ACC_BR(BigDecimal CUSTOMER_ACC_BR) {
        this.CUSTOMER_ACC_BR = CUSTOMER_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CIF
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_ACC_CIF
     */
    public BigDecimal getCUSTOMER_ACC_CIF() {
        return CUSTOMER_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CIF
     *
     * @param CUSTOMER_ACC_CIF the value for TFSTRX_EXTENDED.CUSTOMER_ACC_CIF
     */
    public void setCUSTOMER_ACC_CIF(BigDecimal CUSTOMER_ACC_CIF) {
        this.CUSTOMER_ACC_CIF = CUSTOMER_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CY
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_ACC_CY
     */
    public BigDecimal getCUSTOMER_ACC_CY() {
        return CUSTOMER_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_CY
     *
     * @param CUSTOMER_ACC_CY the value for TFSTRX_EXTENDED.CUSTOMER_ACC_CY
     */
    public void setCUSTOMER_ACC_CY(BigDecimal CUSTOMER_ACC_CY) {
        this.CUSTOMER_ACC_CY = CUSTOMER_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_GL
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_ACC_GL
     */
    public BigDecimal getCUSTOMER_ACC_GL() {
        return CUSTOMER_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_GL
     *
     * @param CUSTOMER_ACC_GL the value for TFSTRX_EXTENDED.CUSTOMER_ACC_GL
     */
    public void setCUSTOMER_ACC_GL(BigDecimal CUSTOMER_ACC_GL) {
        this.CUSTOMER_ACC_GL = CUSTOMER_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_SL
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_ACC_SL
     */
    public BigDecimal getCUSTOMER_ACC_SL() {
        return CUSTOMER_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_ACC_SL
     *
     * @param CUSTOMER_ACC_SL the value for TFSTRX_EXTENDED.CUSTOMER_ACC_SL
     */
    public void setCUSTOMER_ACC_SL(BigDecimal CUSTOMER_ACC_SL) {
        this.CUSTOMER_ACC_SL = CUSTOMER_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.CUSTOMER_PENALTY_CROSS_RATE
     *
     * @return the value of TFSTRX_EXTENDED.CUSTOMER_PENALTY_CROSS_RATE
     */
    public BigDecimal getCUSTOMER_PENALTY_CROSS_RATE() {
        return CUSTOMER_PENALTY_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.CUSTOMER_PENALTY_CROSS_RATE
     *
     * @param CUSTOMER_PENALTY_CROSS_RATE the value for TFSTRX_EXTENDED.CUSTOMER_PENALTY_CROSS_RATE
     */
    public void setCUSTOMER_PENALTY_CROSS_RATE(BigDecimal CUSTOMER_PENALTY_CROSS_RATE) {
        this.CUSTOMER_PENALTY_CROSS_RATE = CUSTOMER_PENALTY_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMT_IN_CUSTOMER_CY
     *
     * @return the value of TFSTRX_EXTENDED.AMT_IN_CUSTOMER_CY
     */
    public BigDecimal getAMT_IN_CUSTOMER_CY() {
        return AMT_IN_CUSTOMER_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMT_IN_CUSTOMER_CY
     *
     * @param AMT_IN_CUSTOMER_CY the value for TFSTRX_EXTENDED.AMT_IN_CUSTOMER_CY
     */
    public void setAMT_IN_CUSTOMER_CY(BigDecimal AMT_IN_CUSTOMER_CY) {
        this.AMT_IN_CUSTOMER_CY = AMT_IN_CUSTOMER_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.AMT_IN_PENALTY_CY
     *
     * @return the value of TFSTRX_EXTENDED.AMT_IN_PENALTY_CY
     */
    public BigDecimal getAMT_IN_PENALTY_CY() {
        return AMT_IN_PENALTY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.AMT_IN_PENALTY_CY
     *
     * @param AMT_IN_PENALTY_CY the value for TFSTRX_EXTENDED.AMT_IN_PENALTY_CY
     */
    public void setAMT_IN_PENALTY_CY(BigDecimal AMT_IN_PENALTY_CY) {
        this.AMT_IN_PENALTY_CY = AMT_IN_PENALTY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.DOCUMENTS_RECEIVED_YN
     *
     * @return the value of TFSTRX_EXTENDED.DOCUMENTS_RECEIVED_YN
     */
    public String getDOCUMENTS_RECEIVED_YN() {
        return DOCUMENTS_RECEIVED_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.DOCUMENTS_RECEIVED_YN
     *
     * @param DOCUMENTS_RECEIVED_YN the value for TFSTRX_EXTENDED.DOCUMENTS_RECEIVED_YN
     */
    public void setDOCUMENTS_RECEIVED_YN(String DOCUMENTS_RECEIVED_YN) {
        this.DOCUMENTS_RECEIVED_YN = DOCUMENTS_RECEIVED_YN == null ? null : DOCUMENTS_RECEIVED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.DOC_DATE_RECEIVED
     *
     * @return the value of TFSTRX_EXTENDED.DOC_DATE_RECEIVED
     */
    public Date getDOC_DATE_RECEIVED() {
        return DOC_DATE_RECEIVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.DOC_DATE_RECEIVED
     *
     * @param DOC_DATE_RECEIVED the value for TFSTRX_EXTENDED.DOC_DATE_RECEIVED
     */
    public void setDOC_DATE_RECEIVED(Date DOC_DATE_RECEIVED) {
        this.DOC_DATE_RECEIVED = DOC_DATE_RECEIVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRX_EXTENDED.PENALTY_ACC_CY
     *
     * @return the value of TFSTRX_EXTENDED.PENALTY_ACC_CY
     */
    public BigDecimal getPENALTY_ACC_CY() {
        return PENALTY_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRX_EXTENDED.PENALTY_ACC_CY
     *
     * @param PENALTY_ACC_CY the value for TFSTRX_EXTENDED.PENALTY_ACC_CY
     */
    public void setPENALTY_ACC_CY(BigDecimal PENALTY_ACC_CY) {
        this.PENALTY_ACC_CY = PENALTY_ACC_CY;
    }

    public String getSYNTHESIS_STATUS()
    {
        return SYNTHESIS_STATUS;
    }

    public void setSYNTHESIS_STATUS(String sYNTHESIS_STATUS)
    {
        SYNTHESIS_STATUS = sYNTHESIS_STATUS;
    }


}