package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSDEALCHARGESVO extends TRSDEALCHARGESVOKey
{
    /**
     * This field corresponds to the database column TRSDEALCHARGES.CHARGES_CODE
     */
    private BigDecimal CHARGES_CODE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_AMOUNT
     */
    private BigDecimal CHARGES_AMOUNT;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CR_ACC_BRANCH
     */
    private BigDecimal CR_ACC_BRANCH;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CR_ACC_CURRENCY
     */
    private BigDecimal CR_ACC_CURRENCY;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.CR_ACC_GL
     */
    private BigDecimal CR_ACC_GL;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CR_ACC_CIF_SUB_NO
     */
    private BigDecimal CR_ACC_CIF_SUB_NO;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.CR_ACC_SL_NO
     */
    private BigDecimal CR_ACC_SL_NO;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.PROFIT_ON_CHARGES
     */
    private BigDecimal PROFIT_ON_CHARGES;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_AMT_FC
     */
    private BigDecimal CHARGES_AMT_FC;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_AMT_CV
     */
    private BigDecimal CHARGES_AMT_CV;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.EXCH_RATE
     */
    private BigDecimal EXCH_RATE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_MULTDIV
     */
    private String CHARGES_MULTDIV;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.COLLECT_CHARGES_ACCOUNT_TYPE
     */
    private String COLLECT_CHARGES_ACCOUNT_TYPE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.COLLECT_CHARGE_AT_DEAL_YN
     */
    private String COLLECT_CHARGE_AT_DEAL_YN;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.CHARGE_TYPE
     */
    private String CHARGE_TYPE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_PERCENTAGE
     */
    private BigDecimal CHARGES_PERCENTAGE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.AMOUNT_CALCULATION_BASIS
     */
    private String AMOUNT_CALCULATION_BASIS;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_CALCULATION_METHOD
     */
    private String CHARGES_CALCULATION_METHOD;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.PERIODICAL_NUMBER
     */
    private BigDecimal PERIODICAL_NUMBER;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.PERIODICAL_PERIODICITY
     */
    private String PERIODICAL_PERIODICITY;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.PERIODICAL_BASIS
     */
    private String PERIODICAL_BASIS;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGE_AMT_PER_INST_YN
     */
    private String CHARGE_AMT_PER_INST_YN;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.VAT_CHARGE_INSUR_PERCENT
     */
    private BigDecimal VAT_CHARGE_INSUR_PERCENT;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.VAT_CHARGE_INSUR_AMT
     */
    private BigDecimal VAT_CHARGE_INSUR_AMT;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CREDIT_TO_SD_ACCOUNT_YN
     */
    private String CREDIT_TO_SD_ACCOUNT_YN;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CHARGES_REVERSED_AMOUNT
     */
    private BigDecimal CHARGES_REVERSED_AMOUNT;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.PAY_AT_DEAL_CLOSURE_YN
     */
    private String PAY_AT_DEAL_CLOSURE_YN;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.CALC_ON_CONTRACT_PRICE_YN
     */
    private String CALC_ON_CONTRACT_PRICE_YN;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.TEMPLATE_CODE
     */
    private BigDecimal TEMPLATE_CODE;
    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.VAT_AMOUNT_CV
     */
    private BigDecimal VAT_AMOUNT_CV;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.VAT_AMOUNT
     */
    private BigDecimal VAT_AMOUNT;
    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.ALLOW_BLOCK_ACCT_NO_BALANCE_YN
     */
    private String ALLOW_BLOCK_ACCT_NO_BALANCE_YN;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.BLOCKED_AMOUNT
     */
    private BigDecimal BLOCKED_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEALCHARGES.BLOCKED_YN
     */
    private String BLOCKED_YN;
    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.ADJUST_FRM_VNDR_CONTRIBUTION
     */
    private String ADJUST_FRM_VNDR_CONTRIBUTION;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.VENDOR_CONTRIBUTION_AMOUNT
     */
    private BigDecimal VENDOR_CONTRIBUTION_AMOUNT;
    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.ADJUST_FROM_VENDOR_DISCOUNT_YN
     */
    private String ADJUST_FROM_VENDOR_DISCOUNT_YN;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.ADJUST_VENDOR_DISCOUNT_AMOUNT
     */
    private BigDecimal ADJUST_VENDOR_DISCOUNT_AMOUNT;

    /**
     * This field corresponds to the database column
     * TRSDEALCHARGES.TEMPLATE_TYPE
     */
    private BigDecimal TEMPLATE_TYPE;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_CODE
     *
     * @return the value of TRSDEALCHARGES.CHARGES_CODE
     */
    public BigDecimal getCHARGES_CODE()
    {
	return CHARGES_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_CODE
     *
     * @param CHARGES_CODE the value for TRSDEALCHARGES.CHARGES_CODE
     */
    public void setCHARGES_CODE(BigDecimal CHARGES_CODE)
    {
	this.CHARGES_CODE = CHARGES_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_AMOUNT
     *
     * @return the value of TRSDEALCHARGES.CHARGES_AMOUNT
     */
    public BigDecimal getCHARGES_AMOUNT()
    {
	return CHARGES_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_AMOUNT
     *
     * @param CHARGES_AMOUNT the value for TRSDEALCHARGES.CHARGES_AMOUNT
     */
    public void setCHARGES_AMOUNT(BigDecimal CHARGES_AMOUNT)
    {
	this.CHARGES_AMOUNT = CHARGES_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CR_ACC_BRANCH
     *
     * @return the value of TRSDEALCHARGES.CR_ACC_BRANCH
     */
    public BigDecimal getCR_ACC_BRANCH()
    {
	return CR_ACC_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CR_ACC_BRANCH
     *
     * @param CR_ACC_BRANCH the value for TRSDEALCHARGES.CR_ACC_BRANCH
     */
    public void setCR_ACC_BRANCH(BigDecimal CR_ACC_BRANCH)
    {
	this.CR_ACC_BRANCH = CR_ACC_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CR_ACC_CURRENCY
     *
     * @return the value of TRSDEALCHARGES.CR_ACC_CURRENCY
     */
    public BigDecimal getCR_ACC_CURRENCY()
    {
	return CR_ACC_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CR_ACC_CURRENCY
     *
     * @param CR_ACC_CURRENCY the value for TRSDEALCHARGES.CR_ACC_CURRENCY
     */
    public void setCR_ACC_CURRENCY(BigDecimal CR_ACC_CURRENCY)
    {
	this.CR_ACC_CURRENCY = CR_ACC_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CR_ACC_GL
     *
     * @return the value of TRSDEALCHARGES.CR_ACC_GL
     */
    public BigDecimal getCR_ACC_GL()
    {
	return CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CR_ACC_GL
     *
     * @param CR_ACC_GL the value for TRSDEALCHARGES.CR_ACC_GL
     */
    public void setCR_ACC_GL(BigDecimal CR_ACC_GL)
    {
	this.CR_ACC_GL = CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CR_ACC_CIF_SUB_NO
     *
     * @return the value of TRSDEALCHARGES.CR_ACC_CIF_SUB_NO
     */
    public BigDecimal getCR_ACC_CIF_SUB_NO()
    {
	return CR_ACC_CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CR_ACC_CIF_SUB_NO
     *
     * @param CR_ACC_CIF_SUB_NO the value for TRSDEALCHARGES.CR_ACC_CIF_SUB_NO
     */
    public void setCR_ACC_CIF_SUB_NO(BigDecimal CR_ACC_CIF_SUB_NO)
    {
	this.CR_ACC_CIF_SUB_NO = CR_ACC_CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CR_ACC_SL_NO
     *
     * @return the value of TRSDEALCHARGES.CR_ACC_SL_NO
     */
    public BigDecimal getCR_ACC_SL_NO()
    {
	return CR_ACC_SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CR_ACC_SL_NO
     *
     * @param CR_ACC_SL_NO the value for TRSDEALCHARGES.CR_ACC_SL_NO
     */
    public void setCR_ACC_SL_NO(BigDecimal CR_ACC_SL_NO)
    {
	this.CR_ACC_SL_NO = CR_ACC_SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.PROFIT_ON_CHARGES
     *
     * @return the value of TRSDEALCHARGES.PROFIT_ON_CHARGES
     */
    public BigDecimal getPROFIT_ON_CHARGES()
    {
	return PROFIT_ON_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.PROFIT_ON_CHARGES
     *
     * @param PROFIT_ON_CHARGES the value for TRSDEALCHARGES.PROFIT_ON_CHARGES
     */
    public void setPROFIT_ON_CHARGES(BigDecimal PROFIT_ON_CHARGES)
    {
	this.PROFIT_ON_CHARGES = PROFIT_ON_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_AMT_FC
     *
     * @return the value of TRSDEALCHARGES.CHARGES_AMT_FC
     */
    public BigDecimal getCHARGES_AMT_FC()
    {
	return CHARGES_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_AMT_FC
     *
     * @param CHARGES_AMT_FC the value for TRSDEALCHARGES.CHARGES_AMT_FC
     */
    public void setCHARGES_AMT_FC(BigDecimal CHARGES_AMT_FC)
    {
	this.CHARGES_AMT_FC = CHARGES_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_AMT_CV
     *
     * @return the value of TRSDEALCHARGES.CHARGES_AMT_CV
     */
    public BigDecimal getCHARGES_AMT_CV()
    {
	return CHARGES_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_AMT_CV
     *
     * @param CHARGES_AMT_CV the value for TRSDEALCHARGES.CHARGES_AMT_CV
     */
    public void setCHARGES_AMT_CV(BigDecimal CHARGES_AMT_CV)
    {
	this.CHARGES_AMT_CV = CHARGES_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.EXCH_RATE
     *
     * @return the value of TRSDEALCHARGES.EXCH_RATE
     */
    public BigDecimal getEXCH_RATE()
    {
	return EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.EXCH_RATE
     *
     * @param EXCH_RATE the value for TRSDEALCHARGES.EXCH_RATE
     */
    public void setEXCH_RATE(BigDecimal EXCH_RATE)
    {
	this.EXCH_RATE = EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_MULTDIV
     *
     * @return the value of TRSDEALCHARGES.CHARGES_MULTDIV
     */
    public String getCHARGES_MULTDIV()
    {
	return CHARGES_MULTDIV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_MULTDIV
     *
     * @param CHARGES_MULTDIV the value for TRSDEALCHARGES.CHARGES_MULTDIV
     */
    public void setCHARGES_MULTDIV(String CHARGES_MULTDIV)
    {
	this.CHARGES_MULTDIV = CHARGES_MULTDIV == null ? null : CHARGES_MULTDIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.COLLECT_CHARGES_ACCOUNT_TYPE
     *
     * @return the value of TRSDEALCHARGES.COLLECT_CHARGES_ACCOUNT_TYPE
     */
    public String getCOLLECT_CHARGES_ACCOUNT_TYPE()
    {
	return COLLECT_CHARGES_ACCOUNT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.COLLECT_CHARGES_ACCOUNT_TYPE
     *
     * @param COLLECT_CHARGES_ACCOUNT_TYPE the value for
     *            TRSDEALCHARGES.COLLECT_CHARGES_ACCOUNT_TYPE
     */
    public void setCOLLECT_CHARGES_ACCOUNT_TYPE(String COLLECT_CHARGES_ACCOUNT_TYPE)
    {
	this.COLLECT_CHARGES_ACCOUNT_TYPE = COLLECT_CHARGES_ACCOUNT_TYPE == null ? null
		: COLLECT_CHARGES_ACCOUNT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.COLLECT_CHARGE_AT_DEAL_YN
     *
     * @return the value of TRSDEALCHARGES.COLLECT_CHARGE_AT_DEAL_YN
     */
    public String getCOLLECT_CHARGE_AT_DEAL_YN()
    {
	return COLLECT_CHARGE_AT_DEAL_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.COLLECT_CHARGE_AT_DEAL_YN
     *
     * @param COLLECT_CHARGE_AT_DEAL_YN the value for
     *            TRSDEALCHARGES.COLLECT_CHARGE_AT_DEAL_YN
     */
    public void setCOLLECT_CHARGE_AT_DEAL_YN(String COLLECT_CHARGE_AT_DEAL_YN)
    {
	this.COLLECT_CHARGE_AT_DEAL_YN = COLLECT_CHARGE_AT_DEAL_YN == null ? null : COLLECT_CHARGE_AT_DEAL_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGE_TYPE
     *
     * @return the value of TRSDEALCHARGES.CHARGE_TYPE
     */
    public String getCHARGE_TYPE()
    {
	return CHARGE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGE_TYPE
     *
     * @param CHARGE_TYPE the value for TRSDEALCHARGES.CHARGE_TYPE
     */
    public void setCHARGE_TYPE(String CHARGE_TYPE)
    {
	this.CHARGE_TYPE = CHARGE_TYPE == null ? null : CHARGE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_PERCENTAGE
     *
     * @return the value of TRSDEALCHARGES.CHARGES_PERCENTAGE
     */
    public BigDecimal getCHARGES_PERCENTAGE()
    {
	return CHARGES_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_PERCENTAGE
     *
     * @param CHARGES_PERCENTAGE the value for TRSDEALCHARGES.CHARGES_PERCENTAGE
     */
    public void setCHARGES_PERCENTAGE(BigDecimal CHARGES_PERCENTAGE)
    {
	this.CHARGES_PERCENTAGE = CHARGES_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.AMOUNT_CALCULATION_BASIS
     *
     * @return the value of TRSDEALCHARGES.AMOUNT_CALCULATION_BASIS
     */
    public String getAMOUNT_CALCULATION_BASIS()
    {
	return AMOUNT_CALCULATION_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.AMOUNT_CALCULATION_BASIS
     *
     * @param AMOUNT_CALCULATION_BASIS the value for
     *            TRSDEALCHARGES.AMOUNT_CALCULATION_BASIS
     */
    public void setAMOUNT_CALCULATION_BASIS(String AMOUNT_CALCULATION_BASIS)
    {
	this.AMOUNT_CALCULATION_BASIS = AMOUNT_CALCULATION_BASIS == null ? null : AMOUNT_CALCULATION_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_CALCULATION_METHOD
     *
     * @return the value of TRSDEALCHARGES.CHARGES_CALCULATION_METHOD
     */
    public String getCHARGES_CALCULATION_METHOD()
    {
	return CHARGES_CALCULATION_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_CALCULATION_METHOD
     *
     * @param CHARGES_CALCULATION_METHOD the value for
     *            TRSDEALCHARGES.CHARGES_CALCULATION_METHOD
     */
    public void setCHARGES_CALCULATION_METHOD(String CHARGES_CALCULATION_METHOD)
    {
	this.CHARGES_CALCULATION_METHOD = CHARGES_CALCULATION_METHOD == null ? null : CHARGES_CALCULATION_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.PERIODICAL_NUMBER
     *
     * @return the value of TRSDEALCHARGES.PERIODICAL_NUMBER
     */
    public BigDecimal getPERIODICAL_NUMBER()
    {
	return PERIODICAL_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.PERIODICAL_NUMBER
     *
     * @param PERIODICAL_NUMBER the value for TRSDEALCHARGES.PERIODICAL_NUMBER
     */
    public void setPERIODICAL_NUMBER(BigDecimal PERIODICAL_NUMBER)
    {
	this.PERIODICAL_NUMBER = PERIODICAL_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.PERIODICAL_PERIODICITY
     *
     * @return the value of TRSDEALCHARGES.PERIODICAL_PERIODICITY
     */
    public String getPERIODICAL_PERIODICITY()
    {
	return PERIODICAL_PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.PERIODICAL_PERIODICITY
     *
     * @param PERIODICAL_PERIODICITY the value for
     *            TRSDEALCHARGES.PERIODICAL_PERIODICITY
     */
    public void setPERIODICAL_PERIODICITY(String PERIODICAL_PERIODICITY)
    {
	this.PERIODICAL_PERIODICITY = PERIODICAL_PERIODICITY == null ? null : PERIODICAL_PERIODICITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.PERIODICAL_BASIS
     *
     * @return the value of TRSDEALCHARGES.PERIODICAL_BASIS
     */
    public String getPERIODICAL_BASIS()
    {
	return PERIODICAL_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.PERIODICAL_BASIS
     *
     * @param PERIODICAL_BASIS the value for TRSDEALCHARGES.PERIODICAL_BASIS
     */
    public void setPERIODICAL_BASIS(String PERIODICAL_BASIS)
    {
	this.PERIODICAL_BASIS = PERIODICAL_BASIS == null ? null : PERIODICAL_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGE_AMT_PER_INST_YN
     *
     * @return the value of TRSDEALCHARGES.CHARGE_AMT_PER_INST_YN
     */
    public String getCHARGE_AMT_PER_INST_YN()
    {
	return CHARGE_AMT_PER_INST_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGE_AMT_PER_INST_YN
     *
     * @param CHARGE_AMT_PER_INST_YN the value for
     *            TRSDEALCHARGES.CHARGE_AMT_PER_INST_YN
     */
    public void setCHARGE_AMT_PER_INST_YN(String CHARGE_AMT_PER_INST_YN)
    {
	this.CHARGE_AMT_PER_INST_YN = CHARGE_AMT_PER_INST_YN == null ? null : CHARGE_AMT_PER_INST_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.VAT_CODE
     *
     * @return the value of TRSDEALCHARGES.VAT_CODE
     */
    public BigDecimal getVAT_CODE()
    {
	return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.VAT_CODE
     *
     * @param VAT_CODE the value for TRSDEALCHARGES.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE)
    {
	this.VAT_CODE = VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.VAT_CHARGE_INSUR_PERCENT
     *
     * @return the value of TRSDEALCHARGES.VAT_CHARGE_INSUR_PERCENT
     */
    public BigDecimal getVAT_CHARGE_INSUR_PERCENT()
    {
	return VAT_CHARGE_INSUR_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.VAT_CHARGE_INSUR_PERCENT
     *
     * @param VAT_CHARGE_INSUR_PERCENT the value for
     *            TRSDEALCHARGES.VAT_CHARGE_INSUR_PERCENT
     */
    public void setVAT_CHARGE_INSUR_PERCENT(BigDecimal VAT_CHARGE_INSUR_PERCENT)
    {
	this.VAT_CHARGE_INSUR_PERCENT = VAT_CHARGE_INSUR_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.VAT_CHARGE_INSUR_AMT
     *
     * @return the value of TRSDEALCHARGES.VAT_CHARGE_INSUR_AMT
     */
    public BigDecimal getVAT_CHARGE_INSUR_AMT()
    {
	return VAT_CHARGE_INSUR_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.VAT_CHARGE_INSUR_AMT
     *
     * @param VAT_CHARGE_INSUR_AMT the value for
     *            TRSDEALCHARGES.VAT_CHARGE_INSUR_AMT
     */
    public void setVAT_CHARGE_INSUR_AMT(BigDecimal VAT_CHARGE_INSUR_AMT)
    {
	this.VAT_CHARGE_INSUR_AMT = VAT_CHARGE_INSUR_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CREDIT_TO_SD_ACCOUNT_YN
     *
     * @return the value of TRSDEALCHARGES.CREDIT_TO_SD_ACCOUNT_YN
     */
    public String getCREDIT_TO_SD_ACCOUNT_YN()
    {
	return CREDIT_TO_SD_ACCOUNT_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CREDIT_TO_SD_ACCOUNT_YN
     *
     * @param CREDIT_TO_SD_ACCOUNT_YN the value for
     *            TRSDEALCHARGES.CREDIT_TO_SD_ACCOUNT_YN
     */
    public void setCREDIT_TO_SD_ACCOUNT_YN(String CREDIT_TO_SD_ACCOUNT_YN)
    {
	this.CREDIT_TO_SD_ACCOUNT_YN = CREDIT_TO_SD_ACCOUNT_YN == null ? null : CREDIT_TO_SD_ACCOUNT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CHARGES_REVERSED_AMOUNT
     *
     * @return the value of TRSDEALCHARGES.CHARGES_REVERSED_AMOUNT
     */
    public BigDecimal getCHARGES_REVERSED_AMOUNT()
    {
	return CHARGES_REVERSED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CHARGES_REVERSED_AMOUNT
     *
     * @param CHARGES_REVERSED_AMOUNT the value for
     *            TRSDEALCHARGES.CHARGES_REVERSED_AMOUNT
     */
    public void setCHARGES_REVERSED_AMOUNT(BigDecimal CHARGES_REVERSED_AMOUNT)
    {
	this.CHARGES_REVERSED_AMOUNT = CHARGES_REVERSED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.PAY_AT_DEAL_CLOSURE_YN
     *
     * @return the value of TRSDEALCHARGES.PAY_AT_DEAL_CLOSURE_YN
     */
    public String getPAY_AT_DEAL_CLOSURE_YN()
    {
	return PAY_AT_DEAL_CLOSURE_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.PAY_AT_DEAL_CLOSURE_YN
     *
     * @param PAY_AT_DEAL_CLOSURE_YN the value for
     *            TRSDEALCHARGES.PAY_AT_DEAL_CLOSURE_YN
     */
    public void setPAY_AT_DEAL_CLOSURE_YN(String PAY_AT_DEAL_CLOSURE_YN)
    {
	this.PAY_AT_DEAL_CLOSURE_YN = PAY_AT_DEAL_CLOSURE_YN == null ? null : PAY_AT_DEAL_CLOSURE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.CALC_ON_CONTRACT_PRICE_YN
     *
     * @return the value of TRSDEALCHARGES.CALC_ON_CONTRACT_PRICE_YN
     */
    public String getCALC_ON_CONTRACT_PRICE_YN()
    {
	return CALC_ON_CONTRACT_PRICE_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.CALC_ON_CONTRACT_PRICE_YN
     *
     * @param CALC_ON_CONTRACT_PRICE_YN the value for
     *            TRSDEALCHARGES.CALC_ON_CONTRACT_PRICE_YN
     */
    public void setCALC_ON_CONTRACT_PRICE_YN(String CALC_ON_CONTRACT_PRICE_YN)
    {
	this.CALC_ON_CONTRACT_PRICE_YN = CALC_ON_CONTRACT_PRICE_YN == null ? null : CALC_ON_CONTRACT_PRICE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.TEMPLATE_CODE
     *
     * @return the value of TRSDEALCHARGES.TEMPLATE_CODE
     */
    public BigDecimal getTEMPLATE_CODE()
    {
	return TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.TEMPLATE_CODE
     *
     * @param TEMPLATE_CODE the value for TRSDEALCHARGES.TEMPLATE_CODE
     */
    public void setTEMPLATE_CODE(BigDecimal TEMPLATE_CODE)
    {
	this.TEMPLATE_CODE = TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column
     * TRSDEALCHARGES.ALLOW_BLOCK_ACCT_NO_BALANCE_YN
     *
     * @return the value of TRSDEALCHARGES.ALLOW_BLOCK_ACCT_NO_BALANCE_YN
     */
    public String getALLOW_BLOCK_ACCT_NO_BALANCE_YN()
    {
	return ALLOW_BLOCK_ACCT_NO_BALANCE_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column
     * TRSDEALCHARGES.ALLOW_BLOCK_ACCT_NO_BALANCE_YN
     *
     * @param ALLOW_BLOCK_ACCT_NO_BALANCE_YN the value for
     *            TRSDEALCHARGES.ALLOW_BLOCK_ACCT_NO_BALANCE_YN
     */
    public void setALLOW_BLOCK_ACCT_NO_BALANCE_YN(String ALLOW_BLOCK_ACCT_NO_BALANCE_YN)
    {
	this.ALLOW_BLOCK_ACCT_NO_BALANCE_YN = ALLOW_BLOCK_ACCT_NO_BALANCE_YN == null ? null
		: ALLOW_BLOCK_ACCT_NO_BALANCE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.BLOCKED_AMOUNT
     *
     * @return the value of TRSDEALCHARGES.BLOCKED_AMOUNT
     */
    public BigDecimal getBLOCKED_AMOUNT()
    {
	return BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.BLOCKED_AMOUNT
     *
     * @param BLOCKED_AMOUNT the value for TRSDEALCHARGES.BLOCKED_AMOUNT
     */
    public void setBLOCKED_AMOUNT(BigDecimal BLOCKED_AMOUNT)
    {
	this.BLOCKED_AMOUNT = BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.BLOCKED_YN
     *
     * @return the value of TRSDEALCHARGES.BLOCKED_YN
     */
    public String getBLOCKED_YN()
    {
	return BLOCKED_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.BLOCKED_YN
     *
     * @param BLOCKED_YN the value for TRSDEALCHARGES.BLOCKED_YN
     */
    public void setBLOCKED_YN(String BLOCKED_YN)
    {
	this.BLOCKED_YN = BLOCKED_YN == null ? null : BLOCKED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.ADJUST_FRM_VNDR_CONTRIBUTION
     *
     * @return the value of TRSDEALCHARGES.ADJUST_FRM_VNDR_CONTRIBUTION
     */
    public String getADJUST_FRM_VNDR_CONTRIBUTION()
    {
	return ADJUST_FRM_VNDR_CONTRIBUTION;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.ADJUST_FRM_VNDR_CONTRIBUTION
     *
     * @param ADJUST_FRM_VNDR_CONTRIBUTION the value for
     *            TRSDEALCHARGES.ADJUST_FRM_VNDR_CONTRIBUTION
     */
    public void setADJUST_FRM_VNDR_CONTRIBUTION(String ADJUST_FRM_VNDR_CONTRIBUTION)
    {
	this.ADJUST_FRM_VNDR_CONTRIBUTION = ADJUST_FRM_VNDR_CONTRIBUTION == null ? null
		: ADJUST_FRM_VNDR_CONTRIBUTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.VENDOR_CONTRIBUTION_AMOUNT
     *
     * @return the value of TRSDEALCHARGES.VENDOR_CONTRIBUTION_AMOUNT
     */
    public BigDecimal getVENDOR_CONTRIBUTION_AMOUNT()
    {
	return VENDOR_CONTRIBUTION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.VENDOR_CONTRIBUTION_AMOUNT
     *
     * @param VENDOR_CONTRIBUTION_AMOUNT the value for
     *            TRSDEALCHARGES.VENDOR_CONTRIBUTION_AMOUNT
     */
    public void setVENDOR_CONTRIBUTION_AMOUNT(BigDecimal VENDOR_CONTRIBUTION_AMOUNT)
    {
	this.VENDOR_CONTRIBUTION_AMOUNT = VENDOR_CONTRIBUTION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column
     * TRSDEALCHARGES.ADJUST_FROM_VENDOR_DISCOUNT_YN
     *
     * @return the value of TRSDEALCHARGES.ADJUST_FROM_VENDOR_DISCOUNT_YN
     */
    public String getADJUST_FROM_VENDOR_DISCOUNT_YN()
    {
	return ADJUST_FROM_VENDOR_DISCOUNT_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column
     * TRSDEALCHARGES.ADJUST_FROM_VENDOR_DISCOUNT_YN
     *
     * @param ADJUST_FROM_VENDOR_DISCOUNT_YN the value for
     *            TRSDEALCHARGES.ADJUST_FROM_VENDOR_DISCOUNT_YN
     */
    public void setADJUST_FROM_VENDOR_DISCOUNT_YN(String ADJUST_FROM_VENDOR_DISCOUNT_YN)
    {
	this.ADJUST_FROM_VENDOR_DISCOUNT_YN = ADJUST_FROM_VENDOR_DISCOUNT_YN == null ? null
		: ADJUST_FROM_VENDOR_DISCOUNT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.ADJUST_VENDOR_DISCOUNT_AMOUNT
     *
     * @return the value of TRSDEALCHARGES.ADJUST_VENDOR_DISCOUNT_AMOUNT
     */
    public BigDecimal getADJUST_VENDOR_DISCOUNT_AMOUNT()
    {
	return ADJUST_VENDOR_DISCOUNT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.ADJUST_VENDOR_DISCOUNT_AMOUNT
     *
     * @param ADJUST_VENDOR_DISCOUNT_AMOUNT the value for
     *            TRSDEALCHARGES.ADJUST_VENDOR_DISCOUNT_AMOUNT
     */
    public void setADJUST_VENDOR_DISCOUNT_AMOUNT(BigDecimal ADJUST_VENDOR_DISCOUNT_AMOUNT)
    {
	this.ADJUST_VENDOR_DISCOUNT_AMOUNT = ADJUST_VENDOR_DISCOUNT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDEALCHARGES.TEMPLATE_TYPE
     *
     * @return the value of TRSDEALCHARGES.TEMPLATE_TYPE
     */
    public BigDecimal getTEMPLATE_TYPE()
    {
	return TEMPLATE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDEALCHARGES.TEMPLATE_TYPE
     *
     * @param TEMPLATE_TYPE the value for TRSDEALCHARGES.TEMPLATE_TYPE
     */
    public void setTEMPLATE_TYPE(BigDecimal TEMPLATE_TYPE)
    {
	this.TEMPLATE_TYPE = TEMPLATE_TYPE;
    }

    public BigDecimal getVAT_AMOUNT_CV()
    {
	return VAT_AMOUNT_CV;
    }

    public void setVAT_AMOUNT_CV(BigDecimal vAT_AMOUNT_CV)
    {
	VAT_AMOUNT_CV = vAT_AMOUNT_CV;
    }

    public BigDecimal getVAT_AMOUNT()
    {
	return VAT_AMOUNT;
    }

    public void setVAT_AMOUNT(BigDecimal vAT_AMOUNT)
    {
	VAT_AMOUNT = vAT_AMOUNT;
    }
}