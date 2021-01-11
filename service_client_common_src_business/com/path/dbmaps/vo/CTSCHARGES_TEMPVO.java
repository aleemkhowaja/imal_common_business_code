package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTSCHARGES_TEMPVO extends CTSCHARGES_TEMPVOKey { 
    /**
     * This field corresponds to the database column CTSCHARGES.CHARGE_TYPE
     */
    private String CHARGE_TYPE;
 
    /** 
     * This field corresponds to the database column CTSCHARGES.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column CTSCHARGES.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column CTSCHARGES.BRIEF_NAME_ARAB
     */
    private String BRIEF_NAME_ARAB;

    /**
     * This field corresponds to the database column CTSCHARGES.LONG_NAME_ARAB
     */
    private String LONG_NAME_ARAB;

    /**
     * This field corresponds to the database column CTSCHARGES.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column CTSCHARGES.ACC_BR
     */
    private BigDecimal ACC_BR;

    /**
     * This field corresponds to the database column CTSCHARGES.ACC_CY
     */
    private BigDecimal ACC_CY;

    /**
     * This field corresponds to the database column CTSCHARGES.ACC_GL
     */
    private BigDecimal ACC_GL;

    /**
     * This field corresponds to the database column CTSCHARGES.ACC_CIF
     */
    private BigDecimal ACC_CIF;

    /**
     * This field corresponds to the database column CTSCHARGES.ACC_SL
     */
    private BigDecimal ACC_SL;

    /**
     * This field corresponds to the database column CTSCHARGES.DEDUCT_FROM_TRX
     */
    private String DEDUCT_FROM_TRX;

    /**
     * This field corresponds to the database column CTSCHARGES.ALLOW_MODIFY
     */
    private String ALLOW_MODIFY;

    /**
     * This field corresponds to the database column CTSCHARGES.ALLOW_CLEARING
     */
    private String ALLOW_CLEARING;

    /**
     * This field corresponds to the database column CTSCHARGES.BASED_ON_MOSARAFA
     */
    private String BASED_ON_MOSARAFA;

    /**
     * This field corresponds to the database column CTSCHARGES.CHRG_ON_EXCEED
     */
    private String CHRG_ON_EXCEED;

    /**
     * This field corresponds to the database column CTSCHARGES.EXCEED_AMT
     */
    private BigDecimal EXCEED_AMT;

    /**
     * This field corresponds to the database column CTSCHARGES.CHRG_PERCENTAGE
     */
    private BigDecimal CHRG_PERCENTAGE;

    /**
     * This field corresponds to the database column CTSCHARGES.MIN_AMT
     */
    private BigDecimal MIN_AMT;

    /**
     * This field corresponds to the database column CTSCHARGES.MAX_AMT
     */
    private BigDecimal MAX_AMT;

    /**
     * This field corresponds to the database column CTSCHARGES.PASS_SEPARATELY
     */
    private String PASS_SEPARATELY;

    /**
     * This field corresponds to the database column CTSCHARGES.APPLY_TVA
     */
    private String APPLY_TVA;

    /**
     * This field corresponds to the database column CTSCHARGES.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This field corresponds to the database column CTSCHARGES.CHRG_BR
     */
    private String CHRG_BR;

    /**
     * This field corresponds to the database column CTSCHARGES.DR_ACC_CIF
     */
    private BigDecimal DR_ACC_CIF;

    /**
     * This field corresponds to the database column CTSCHARGES.DR_ACC_GL
     */
    private BigDecimal DR_ACC_GL;

    /**
     * This field corresponds to the database column CTSCHARGES.DR_ACC_SL
     */
    private BigDecimal DR_ACC_SL;

    /**
     * This field corresponds to the database column CTSCHARGES.DR_CRITERIA
     */
    private String DR_CRITERIA;

    /**
     * This field corresponds to the database column CTSCHARGES.FIX_CHARGES
     */
    private String FIX_CHARGES;

    /**
     * This field corresponds to the database column CTSCHARGES.CONSIDER_ONCE_FOR_MULTI_TRX
     */
    private String CONSIDER_ONCE_FOR_MULTI_TRX;

    /**
     * This field corresponds to the database column CTSCHARGES.DUES_COLLECTION_TYPE
     */
    private String DUES_COLLECTION_TYPE;

    /**
     * This field corresponds to the database column CTSCHARGES.DUES_MODE_PAY
     */
    private String DUES_MODE_PAY;

    /**
     * This field corresponds to the database column CTSCHARGES.HOF_REASON
     */
    private BigDecimal HOF_REASON;

    /**
     * This field corresponds to the database column CTSCHARGES.HOF_TRX_TYPE
     */
    private BigDecimal HOF_TRX_TYPE;

    
    
/*    private String USER_ID;
    private String ENTITY_TYPE;
    private String PRODUCT_TYPE;
    private String SCHEMA_TYPE;


    private BigDecimal ENTITY_CODE;
    private BigDecimal PRODUCT_CODE;
    private BigDecimal SCHEMA_CODE;
*/
    
    private String ISSUE_TYPE;
    private String CHARGES_CY_POLICY;
    private String CASH_ACCOUNT;
    private String ACTION_TYPE;
    
    
    private BigDecimal SEG_ACC_BR;
    private BigDecimal SEG_ACC_CY;
    private BigDecimal SEG_ACC_GL;    
    private BigDecimal SEG_ACC_CIF;
    private BigDecimal SEG_ACC_SL;
    private BigDecimal CHEQUE_TYPE;
    private BigDecimal LEAVES;
    
    private String GENERATE_DUES_SUSP_ENTRIES_YN;



    
    
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.CHARGE_TYPE
     *
     * @return the value of CTSCHARGES.CHARGE_TYPE
     */
    public String getCHARGE_TYPE() {
        return CHARGE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.CHARGE_TYPE
     *
     * @param CHARGE_TYPE the value for CTSCHARGES.CHARGE_TYPE
     */
    public void setCHARGE_TYPE(String CHARGE_TYPE) {
        this.CHARGE_TYPE = CHARGE_TYPE == null ? null : CHARGE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.BRIEF_NAME_ENG
     *
     * @return the value of CTSCHARGES.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for CTSCHARGES.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.LONG_NAME_ENG
     *
     * @return the value of CTSCHARGES.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for CTSCHARGES.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.BRIEF_NAME_ARAB
     *
     * @return the value of CTSCHARGES.BRIEF_NAME_ARAB
     */
    public String getBRIEF_NAME_ARAB() {
        return BRIEF_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.BRIEF_NAME_ARAB
     *
     * @param BRIEF_NAME_ARAB the value for CTSCHARGES.BRIEF_NAME_ARAB
     */
    public void setBRIEF_NAME_ARAB(String BRIEF_NAME_ARAB) {
        this.BRIEF_NAME_ARAB = BRIEF_NAME_ARAB == null ? null : BRIEF_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.LONG_NAME_ARAB
     *
     * @return the value of CTSCHARGES.LONG_NAME_ARAB
     */
    public String getLONG_NAME_ARAB() {
        return LONG_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.LONG_NAME_ARAB
     *
     * @param LONG_NAME_ARAB the value for CTSCHARGES.LONG_NAME_ARAB
     */
    public void setLONG_NAME_ARAB(String LONG_NAME_ARAB) {
        this.LONG_NAME_ARAB = LONG_NAME_ARAB == null ? null : LONG_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.AMOUNT
     *
     * @return the value of CTSCHARGES.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.AMOUNT
     *
     * @param AMOUNT the value for CTSCHARGES.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ACC_BR
     *
     * @return the value of CTSCHARGES.ACC_BR
     */
    public BigDecimal getACC_BR() {
        return ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ACC_BR
     *
     * @param ACC_BR the value for CTSCHARGES.ACC_BR
     */
    public void setACC_BR(BigDecimal ACC_BR) {
        this.ACC_BR = ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ACC_CY
     *
     * @return the value of CTSCHARGES.ACC_CY
     */
    public BigDecimal getACC_CY() {
        return ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ACC_CY
     *
     * @param ACC_CY the value for CTSCHARGES.ACC_CY
     */
    public void setACC_CY(BigDecimal ACC_CY) {
        this.ACC_CY = ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ACC_GL
     *
     * @return the value of CTSCHARGES.ACC_GL
     */
    public BigDecimal getACC_GL() {
        return ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ACC_GL
     *
     * @param ACC_GL the value for CTSCHARGES.ACC_GL
     */
    public void setACC_GL(BigDecimal ACC_GL) {
        this.ACC_GL = ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ACC_CIF
     *
     * @return the value of CTSCHARGES.ACC_CIF
     */
    public BigDecimal getACC_CIF() {
        return ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ACC_CIF
     *
     * @param ACC_CIF the value for CTSCHARGES.ACC_CIF
     */
    public void setACC_CIF(BigDecimal ACC_CIF) {
        this.ACC_CIF = ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ACC_SL
     *
     * @return the value of CTSCHARGES.ACC_SL
     */
    public BigDecimal getACC_SL() {
        return ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ACC_SL
     *
     * @param ACC_SL the value for CTSCHARGES.ACC_SL
     */
    public void setACC_SL(BigDecimal ACC_SL) {
        this.ACC_SL = ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DEDUCT_FROM_TRX
     *
     * @return the value of CTSCHARGES.DEDUCT_FROM_TRX
     */
    public String getDEDUCT_FROM_TRX() {
        return DEDUCT_FROM_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DEDUCT_FROM_TRX
     *
     * @param DEDUCT_FROM_TRX the value for CTSCHARGES.DEDUCT_FROM_TRX
     */
    public void setDEDUCT_FROM_TRX(String DEDUCT_FROM_TRX) {
        this.DEDUCT_FROM_TRX = DEDUCT_FROM_TRX == null ? null : DEDUCT_FROM_TRX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ALLOW_MODIFY
     *
     * @return the value of CTSCHARGES.ALLOW_MODIFY
     */
    public String getALLOW_MODIFY() {
        return ALLOW_MODIFY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ALLOW_MODIFY
     *
     * @param ALLOW_MODIFY the value for CTSCHARGES.ALLOW_MODIFY
     */
    public void setALLOW_MODIFY(String ALLOW_MODIFY) {
        this.ALLOW_MODIFY = ALLOW_MODIFY == null ? null : ALLOW_MODIFY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.ALLOW_CLEARING
     *
     * @return the value of CTSCHARGES.ALLOW_CLEARING
     */
    public String getALLOW_CLEARING() {
        return ALLOW_CLEARING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.ALLOW_CLEARING
     *
     * @param ALLOW_CLEARING the value for CTSCHARGES.ALLOW_CLEARING
     */
    public void setALLOW_CLEARING(String ALLOW_CLEARING) {
        this.ALLOW_CLEARING = ALLOW_CLEARING == null ? null : ALLOW_CLEARING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.BASED_ON_MOSARAFA
     *
     * @return the value of CTSCHARGES.BASED_ON_MOSARAFA
     */
    public String getBASED_ON_MOSARAFA() {
        return BASED_ON_MOSARAFA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.BASED_ON_MOSARAFA
     *
     * @param BASED_ON_MOSARAFA the value for CTSCHARGES.BASED_ON_MOSARAFA
     */
    public void setBASED_ON_MOSARAFA(String BASED_ON_MOSARAFA) {
        this.BASED_ON_MOSARAFA = BASED_ON_MOSARAFA == null ? null : BASED_ON_MOSARAFA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.CHRG_ON_EXCEED
     *
     * @return the value of CTSCHARGES.CHRG_ON_EXCEED
     */
    public String getCHRG_ON_EXCEED() {
        return CHRG_ON_EXCEED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.CHRG_ON_EXCEED
     *
     * @param CHRG_ON_EXCEED the value for CTSCHARGES.CHRG_ON_EXCEED
     */
    public void setCHRG_ON_EXCEED(String CHRG_ON_EXCEED) {
        this.CHRG_ON_EXCEED = CHRG_ON_EXCEED == null ? null : CHRG_ON_EXCEED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.EXCEED_AMT
     *
     * @return the value of CTSCHARGES.EXCEED_AMT
     */
    public BigDecimal getEXCEED_AMT() {
        return EXCEED_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.EXCEED_AMT
     *
     * @param EXCEED_AMT the value for CTSCHARGES.EXCEED_AMT
     */
    public void setEXCEED_AMT(BigDecimal EXCEED_AMT) {
        this.EXCEED_AMT = EXCEED_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.CHRG_PERCENTAGE
     *
     * @return the value of CTSCHARGES.CHRG_PERCENTAGE
     */
    public BigDecimal getCHRG_PERCENTAGE() {
        return CHRG_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.CHRG_PERCENTAGE
     *
     * @param CHRG_PERCENTAGE the value for CTSCHARGES.CHRG_PERCENTAGE
     */
    public void setCHRG_PERCENTAGE(BigDecimal CHRG_PERCENTAGE) {
        this.CHRG_PERCENTAGE = CHRG_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.MIN_AMT
     *
     * @return the value of CTSCHARGES.MIN_AMT
     */
    public BigDecimal getMIN_AMT() {
        return MIN_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.MIN_AMT
     *
     * @param MIN_AMT the value for CTSCHARGES.MIN_AMT
     */
    public void setMIN_AMT(BigDecimal MIN_AMT) {
        this.MIN_AMT = MIN_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.MAX_AMT
     *
     * @return the value of CTSCHARGES.MAX_AMT
     */
    public BigDecimal getMAX_AMT() {
        return MAX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.MAX_AMT
     *
     * @param MAX_AMT the value for CTSCHARGES.MAX_AMT
     */
    public void setMAX_AMT(BigDecimal MAX_AMT) {
        this.MAX_AMT = MAX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.PASS_SEPARATELY
     *
     * @return the value of CTSCHARGES.PASS_SEPARATELY
     */
    public String getPASS_SEPARATELY() {
        return PASS_SEPARATELY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.PASS_SEPARATELY
     *
     * @param PASS_SEPARATELY the value for CTSCHARGES.PASS_SEPARATELY
     */
    public void setPASS_SEPARATELY(String PASS_SEPARATELY) {
        this.PASS_SEPARATELY = PASS_SEPARATELY == null ? null : PASS_SEPARATELY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.APPLY_TVA
     *
     * @return the value of CTSCHARGES.APPLY_TVA
     */
    public String getAPPLY_TVA() {
        return APPLY_TVA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.APPLY_TVA
     *
     * @param APPLY_TVA the value for CTSCHARGES.APPLY_TVA
     */
    public void setAPPLY_TVA(String APPLY_TVA) {
        this.APPLY_TVA = APPLY_TVA == null ? null : APPLY_TVA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.VAT_CODE
     *
     * @return the value of CTSCHARGES.VAT_CODE
     */
    public BigDecimal getVAT_CODE() {
        return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.VAT_CODE
     *
     * @param VAT_CODE the value for CTSCHARGES.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE) {
        this.VAT_CODE = VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.CHRG_BR
     *
     * @return the value of CTSCHARGES.CHRG_BR
     */
    public String getCHRG_BR() {
        return CHRG_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.CHRG_BR
     *
     * @param CHRG_BR the value for CTSCHARGES.CHRG_BR
     */
    public void setCHRG_BR(String CHRG_BR) {
        this.CHRG_BR = CHRG_BR == null ? null : CHRG_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DR_ACC_CIF
     *
     * @return the value of CTSCHARGES.DR_ACC_CIF
     */
    public BigDecimal getDR_ACC_CIF() {
        return DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DR_ACC_CIF
     *
     * @param DR_ACC_CIF the value for CTSCHARGES.DR_ACC_CIF
     */
    public void setDR_ACC_CIF(BigDecimal DR_ACC_CIF) {
        this.DR_ACC_CIF = DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DR_ACC_GL
     *
     * @return the value of CTSCHARGES.DR_ACC_GL
     */
    public BigDecimal getDR_ACC_GL() {
        return DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DR_ACC_GL
     *
     * @param DR_ACC_GL the value for CTSCHARGES.DR_ACC_GL
     */
    public void setDR_ACC_GL(BigDecimal DR_ACC_GL) {
        this.DR_ACC_GL = DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DR_ACC_SL
     *
     * @return the value of CTSCHARGES.DR_ACC_SL
     */
    public BigDecimal getDR_ACC_SL() {
        return DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DR_ACC_SL
     *
     * @param DR_ACC_SL the value for CTSCHARGES.DR_ACC_SL
     */
    public void setDR_ACC_SL(BigDecimal DR_ACC_SL) {
        this.DR_ACC_SL = DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DR_CRITERIA
     *
     * @return the value of CTSCHARGES.DR_CRITERIA
     */
    public String getDR_CRITERIA() {
        return DR_CRITERIA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DR_CRITERIA
     *
     * @param DR_CRITERIA the value for CTSCHARGES.DR_CRITERIA
     */
    public void setDR_CRITERIA(String DR_CRITERIA) {
        this.DR_CRITERIA = DR_CRITERIA == null ? null : DR_CRITERIA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.FIX_CHARGES
     *
     * @return the value of CTSCHARGES.FIX_CHARGES
     */
    public String getFIX_CHARGES() {
        return FIX_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.FIX_CHARGES
     *
     * @param FIX_CHARGES the value for CTSCHARGES.FIX_CHARGES
     */
    public void setFIX_CHARGES(String FIX_CHARGES) {
        this.FIX_CHARGES = FIX_CHARGES == null ? null : FIX_CHARGES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.CONSIDER_ONCE_FOR_MULTI_TRX
     *
     * @return the value of CTSCHARGES.CONSIDER_ONCE_FOR_MULTI_TRX
     */
    public String getCONSIDER_ONCE_FOR_MULTI_TRX() {
        return CONSIDER_ONCE_FOR_MULTI_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.CONSIDER_ONCE_FOR_MULTI_TRX
     *
     * @param CONSIDER_ONCE_FOR_MULTI_TRX the value for CTSCHARGES.CONSIDER_ONCE_FOR_MULTI_TRX
     */
    public void setCONSIDER_ONCE_FOR_MULTI_TRX(String CONSIDER_ONCE_FOR_MULTI_TRX) {
        this.CONSIDER_ONCE_FOR_MULTI_TRX = CONSIDER_ONCE_FOR_MULTI_TRX == null ? null : CONSIDER_ONCE_FOR_MULTI_TRX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DUES_COLLECTION_TYPE
     *
     * @return the value of CTSCHARGES.DUES_COLLECTION_TYPE
     */
    public String getDUES_COLLECTION_TYPE() {
        return DUES_COLLECTION_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DUES_COLLECTION_TYPE
     *
     * @param DUES_COLLECTION_TYPE the value for CTSCHARGES.DUES_COLLECTION_TYPE
     */
    public void setDUES_COLLECTION_TYPE(String DUES_COLLECTION_TYPE) {
        this.DUES_COLLECTION_TYPE = DUES_COLLECTION_TYPE == null ? null : DUES_COLLECTION_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.DUES_MODE_PAY
     *
     * @return the value of CTSCHARGES.DUES_MODE_PAY
     */
    public String getDUES_MODE_PAY() {
        return DUES_MODE_PAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.DUES_MODE_PAY
     *
     * @param DUES_MODE_PAY the value for CTSCHARGES.DUES_MODE_PAY
     */
    public void setDUES_MODE_PAY(String DUES_MODE_PAY) {
        this.DUES_MODE_PAY = DUES_MODE_PAY == null ? null : DUES_MODE_PAY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.HOF_REASON
     *
     * @return the value of CTSCHARGES.HOF_REASON
     */
    public BigDecimal getHOF_REASON() {
        return HOF_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.HOF_REASON
     *
     * @param HOF_REASON the value for CTSCHARGES.HOF_REASON
     */
    public void setHOF_REASON(BigDecimal HOF_REASON) {
        this.HOF_REASON = HOF_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES.HOF_TRX_TYPE
     *
     * @return the value of CTSCHARGES.HOF_TRX_TYPE
     */
    public BigDecimal getHOF_TRX_TYPE() {
        return HOF_TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES.HOF_TRX_TYPE
     *
     * @param HOF_TRX_TYPE the value for CTSCHARGES.HOF_TRX_TYPE
     */
    public void setHOF_TRX_TYPE(BigDecimal HOF_TRX_TYPE) {
        this.HOF_TRX_TYPE = HOF_TRX_TYPE;
    }

    public String getISSUE_TYPE()
    {
        return ISSUE_TYPE;
    }

    public void setISSUE_TYPE(String iSSUE_TYPE)
    {
        ISSUE_TYPE = iSSUE_TYPE;
    }

    public String getCHARGES_CY_POLICY()
    {
        return CHARGES_CY_POLICY;
    }

    public void setCHARGES_CY_POLICY(String cHARGES_CY_POLICY)
    {
        CHARGES_CY_POLICY = cHARGES_CY_POLICY;
    }

    public String getCASH_ACCOUNT()
    {
        return CASH_ACCOUNT;
    }

    public void setCASH_ACCOUNT(String cASH_ACCOUNT)
    {
        CASH_ACCOUNT = cASH_ACCOUNT;
    }

    public String getACTION_TYPE()
    {
        return ACTION_TYPE;
    }

    public void setACTION_TYPE(String aCTION_TYPE)
    {
        ACTION_TYPE = aCTION_TYPE;
    }

    public BigDecimal getSEG_ACC_BR()
    {
        return SEG_ACC_BR;
    }

    public void setSEG_ACC_BR(BigDecimal sEG_ACC_BR)
    {
        SEG_ACC_BR = sEG_ACC_BR;
    }

    public BigDecimal getSEG_ACC_CY()
    {
        return SEG_ACC_CY;
    }

    public void setSEG_ACC_CY(BigDecimal sEG_ACC_CY)
    {
        SEG_ACC_CY = sEG_ACC_CY;
    }

    public BigDecimal getSEG_ACC_GL()
    {
        return SEG_ACC_GL;
    }

    public void setSEG_ACC_GL(BigDecimal sEG_ACC_GL)
    {
        SEG_ACC_GL = sEG_ACC_GL;
    }

    public BigDecimal getSEG_ACC_CIF()
    {
        return SEG_ACC_CIF;
    }

    public void setSEG_ACC_CIF(BigDecimal sEG_ACC_CIF)
    {
        SEG_ACC_CIF = sEG_ACC_CIF;
    }

    public BigDecimal getSEG_ACC_SL()
    {
        return SEG_ACC_SL;
    }

    public void setSEG_ACC_SL(BigDecimal sEG_ACC_SL)
    {
        SEG_ACC_SL = sEG_ACC_SL;
    }

    public BigDecimal getCHEQUE_TYPE()
    {
        return CHEQUE_TYPE;
    }

    public void setCHEQUE_TYPE(BigDecimal cHEQUE_TYPE)
    {
        CHEQUE_TYPE = cHEQUE_TYPE;
    }

    public BigDecimal getLEAVES()
    {
        return LEAVES;
    }

    public void setLEAVES(BigDecimal lEAVES)
    {
        LEAVES = lEAVES;
    }

    public String getGENERATE_DUES_SUSP_ENTRIES_YN()
    {
        return GENERATE_DUES_SUSP_ENTRIES_YN;
    }

    public void setGENERATE_DUES_SUSP_ENTRIES_YN(String gENERATE_DUES_SUSP_ENTRIES_YN)
    {
        GENERATE_DUES_SUSP_ENTRIES_YN = gENERATE_DUES_SUSP_ENTRIES_YN;
    }
    
}