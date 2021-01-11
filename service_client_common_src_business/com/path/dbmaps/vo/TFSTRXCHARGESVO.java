package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class TFSTRXCHARGESVO extends BaseVO {
    /**
     * This field corresponds to the database column TFSTRXCHARGES.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DOC_TYPE
     */
    private String DOC_TYPE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.TRX_LINE_NBR
     */
    private BigDecimal TRX_LINE_NBR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.TRX_NBR
     */
    private BigDecimal TRX_NBR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.TRX_TYPE
     */
    private BigDecimal TRX_TYPE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.LC_YEAR
     */
    private BigDecimal LC_YEAR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DOC_NBR
     */
    private BigDecimal DOC_NBR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CHARGE
     */
    private BigDecimal CHARGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CHARGE_TYPE
     */
    private String CHARGE_TYPE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FLAT_AMOUNT
     */
    private BigDecimal FLAT_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CR_ACC_GL
     */
    private BigDecimal CR_ACC_GL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CR_ACC_CIF
     */
    private BigDecimal CR_ACC_CIF;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CR_ACC_SL
     */
    private BigDecimal CR_ACC_SL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.TFSTRX_NBR
     */
    private BigDecimal TFSTRX_NBR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.BORN_BY_APPLICANT
     */
    private BigDecimal BORN_BY_APPLICANT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DR_ACC_GL
     */
    private BigDecimal DR_ACC_GL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DR_ACC_CIF
     */
    private BigDecimal DR_ACC_CIF;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DR_ACC_SL
     */
    private BigDecimal DR_ACC_SL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DR_ACC_CY
     */
    private BigDecimal DR_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.PERCENTAGE
     */
    private BigDecimal PERCENTAGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DR_ACC_BR
     */
    private BigDecimal DR_ACC_BR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CH_FROM_TYPE
     */
    private String CH_FROM_TYPE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.ADD_LINE_NO
     */
    private BigDecimal ADD_LINE_NO;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FC_DR_AMOUNT
     */
    private BigDecimal FC_DR_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CV_DR_AMOUNT
     */
    private BigDecimal CV_DR_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.EXCH_DR_RATE
     */
    private BigDecimal EXCH_DR_RATE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.ROUNDING
     */
    private String ROUNDING;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.ROUNDING_POINT
     */
    private BigDecimal ROUNDING_POINT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.COMMISSION_GL
     */
    private BigDecimal COMMISSION_GL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.COMMISSION_CIF
     */
    private BigDecimal COMMISSION_CIF;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.COMMISSION_SL
     */
    private BigDecimal COMMISSION_SL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.PASS_ACCRUAL
     */
    private String PASS_ACCRUAL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FC_IN_LC_CY
     */
    private BigDecimal FC_IN_LC_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CROSS_RATE
     */
    private BigDecimal CROSS_RATE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CROSS_MULT_DIV
     */
    private String CROSS_MULT_DIV;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.LC_CY
     */
    private BigDecimal LC_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CR_ACC_BR
     */
    private BigDecimal CR_ACC_BR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DEFAULT_LOGGED_CR_BR
     */
    private String DEFAULT_LOGGED_CR_BR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.OLD_PERCENTAGE
     */
    private BigDecimal OLD_PERCENTAGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.OVERDRAWN_ACC
     */
    private String OVERDRAWN_ACC;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CR_ACC_CY
     */
    private BigDecimal CR_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DIFFERENT_CY_CHARGE
     */
    private String DIFFERENT_CY_CHARGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FREQUENTLY_CHARGE
     */
    private String FREQUENTLY_CHARGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED
     */
    private String FREQUENTLY_CHARGE_POSTED;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED_DT
     */
    private Date FREQUENTLY_CHARGE_POSTED_DT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DOC_SELL_RATE
     */
    private BigDecimal DOC_SELL_RATE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.APPLY_DAILY_PERCENT
     */
    private String APPLY_DAILY_PERCENT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.DELETE_CHARGE
     */
    private String DELETE_CHARGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.PROTECT_CHARGE
     */
    private String PROTECT_CHARGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_CV_DR_AMOUNT
     */
    private BigDecimal AMEND_CV_DR_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_FC_DR_AMOUNT
     */
    private BigDecimal AMEND_FC_DR_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_FLAT_AMOUNT
     */
    private BigDecimal AMEND_FLAT_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_PERCENTAGE
     */
    private BigDecimal AMEND_PERCENTAGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_PERCENTAGE
     */
    private BigDecimal VAT_PERCENTAGE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_FC_AMOUNT
     */
    private BigDecimal VAT_FC_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_CY_RATE
     */
    private BigDecimal VAT_CY_RATE;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_CV_AMOUNT
     */
    private BigDecimal VAT_CV_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_ACC_BR
     */
    private BigDecimal VAT_ACC_BR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_ACC_CY
     */
    private BigDecimal VAT_ACC_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_ACC_GL
     */
    private BigDecimal VAT_ACC_GL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_ACC_CIF
     */
    private BigDecimal VAT_ACC_CIF;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_ACC_SL
     */
    private BigDecimal VAT_ACC_SL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CHARGES_BY_TIERS
     */
    private String CHARGES_BY_TIERS;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CHARGE_CV_AMOUNT
     */
    private BigDecimal CHARGE_CV_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CHARGE_FC_AMOUNT
     */
    private BigDecimal CHARGE_FC_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CLOSED_SUSP_CV_AMOUNT
     */
    private BigDecimal CLOSED_SUSP_CV_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.CLOSED_SUSP_FC_AMOUNT
     */
    private BigDecimal CLOSED_SUSP_FC_AMOUNT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.SUSPENSE_CHARGE_BR
     */
    private BigDecimal SUSPENSE_CHARGE_BR;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CIF
     */
    private BigDecimal SUSPENSE_CHARGE_CIF;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CY
     */
    private BigDecimal SUSPENSE_CHARGE_CY;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.SUSPENSE_CHARGE_GL
     */
    private BigDecimal SUSPENSE_CHARGE_GL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.SUSPENSE_CHARGE_SL
     */
    private BigDecimal SUSPENSE_CHARGE_SL;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_IND
     */
    private String AMEND_IND;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.ALLOW_MODIFY_CHARGES
     */
    private String ALLOW_MODIFY_CHARGES;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.HOF_TRS_NO
     */
    private BigDecimal HOF_TRS_NO;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.OVERDRAWN_VAT
     */
    private String OVERDRAWN_VAT;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_SUSPENSE_CV
     */
    private BigDecimal VAT_SUSPENSE_CV;

    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_SUSPENSE_FC
     */
    private BigDecimal VAT_SUSPENSE_FC;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.CV_DR_NON_PROV_AMOUNT
     */
    private BigDecimal CV_DR_NON_PROV_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.FC_DR_NON_PROV_AMOUNT
     */
    private BigDecimal FC_DR_NON_PROV_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.NON_PROV_AMT_CHARGE
     */
    private BigDecimal NON_PROV_AMT_CHARGE;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.PROV_AMT_CHARGE
     */
    private BigDecimal PROV_AMT_CHARGE;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_CV_PROV_AMOUNT
     */
    private BigDecimal VAT_CV_PROV_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.VAT_FC_PROV_AMOUNT
     */
    private BigDecimal VAT_FC_PROV_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_PROV_CV_DR_AMOUNT
     */
    private BigDecimal AMEND_PROV_CV_DR_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_PROV_FC_DR_AMOUNT
     */
    private BigDecimal AMEND_PROV_FC_DR_AMOUNT;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_PROV_AMT_CHARGE
     */
    private BigDecimal AMEND_PROV_AMT_CHARGE;
    
    /**
     * This field corresponds to the database column TFSTRXCHARGES.AMEND_NON_PROV_AMT_CHARGE
     */
    private BigDecimal AMEND_NON_PROV_AMT_CHARGE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.BRANCH
     *
     * @return the value of TFSTRXCHARGES.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.BRANCH
     *
     * @param BRANCH the value for TFSTRXCHARGES.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.COMP_CODE
     *
     * @return the value of TFSTRXCHARGES.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.COMP_CODE
     *
     * @param COMP_CODE the value for TFSTRXCHARGES.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DOC_TYPE
     *
     * @return the value of TFSTRXCHARGES.DOC_TYPE
     */
    public String getDOC_TYPE() {
        return DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DOC_TYPE
     *
     * @param DOC_TYPE the value for TFSTRXCHARGES.DOC_TYPE
     */
    public void setDOC_TYPE(String DOC_TYPE) {
        this.DOC_TYPE = DOC_TYPE == null ? null : DOC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.TRX_LINE_NBR
     *
     * @return the value of TFSTRXCHARGES.TRX_LINE_NBR
     */
    public BigDecimal getTRX_LINE_NBR() {
        return TRX_LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.TRX_LINE_NBR
     *
     * @param TRX_LINE_NBR the value for TFSTRXCHARGES.TRX_LINE_NBR
     */
    public void setTRX_LINE_NBR(BigDecimal TRX_LINE_NBR) {
        this.TRX_LINE_NBR = TRX_LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.TRX_NBR
     *
     * @return the value of TFSTRXCHARGES.TRX_NBR
     */
    public BigDecimal getTRX_NBR() {
        return TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.TRX_NBR
     *
     * @param TRX_NBR the value for TFSTRXCHARGES.TRX_NBR
     */
    public void setTRX_NBR(BigDecimal TRX_NBR) {
        this.TRX_NBR = TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.TRX_TYPE
     *
     * @return the value of TFSTRXCHARGES.TRX_TYPE
     */
    public BigDecimal getTRX_TYPE() {
        return TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.TRX_TYPE
     *
     * @param TRX_TYPE the value for TFSTRXCHARGES.TRX_TYPE
     */
    public void setTRX_TYPE(BigDecimal TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.LC_YEAR
     *
     * @return the value of TFSTRXCHARGES.LC_YEAR
     */
    public BigDecimal getLC_YEAR() {
        return LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.LC_YEAR
     *
     * @param LC_YEAR the value for TFSTRXCHARGES.LC_YEAR
     */
    public void setLC_YEAR(BigDecimal LC_YEAR) {
        this.LC_YEAR = LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DOC_NBR
     *
     * @return the value of TFSTRXCHARGES.DOC_NBR
     */
    public BigDecimal getDOC_NBR() {
        return DOC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DOC_NBR
     *
     * @param DOC_NBR the value for TFSTRXCHARGES.DOC_NBR
     */
    public void setDOC_NBR(BigDecimal DOC_NBR) {
        this.DOC_NBR = DOC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CHARGE
     *
     * @return the value of TFSTRXCHARGES.CHARGE
     */
    public BigDecimal getCHARGE() {
        return CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CHARGE
     *
     * @param CHARGE the value for TFSTRXCHARGES.CHARGE
     */
    public void setCHARGE(BigDecimal CHARGE) {
        this.CHARGE = CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CHARGE_TYPE
     *
     * @return the value of TFSTRXCHARGES.CHARGE_TYPE
     */
    public String getCHARGE_TYPE() {
        return CHARGE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CHARGE_TYPE
     *
     * @param CHARGE_TYPE the value for TFSTRXCHARGES.CHARGE_TYPE
     */
    public void setCHARGE_TYPE(String CHARGE_TYPE) {
        this.CHARGE_TYPE = CHARGE_TYPE == null ? null : CHARGE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FLAT_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.FLAT_AMOUNT
     */
    public BigDecimal getFLAT_AMOUNT() {
        return FLAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FLAT_AMOUNT
     *
     * @param FLAT_AMOUNT the value for TFSTRXCHARGES.FLAT_AMOUNT
     */
    public void setFLAT_AMOUNT(BigDecimal FLAT_AMOUNT) {
        this.FLAT_AMOUNT = FLAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CR_ACC_GL
     *
     * @return the value of TFSTRXCHARGES.CR_ACC_GL
     */
    public BigDecimal getCR_ACC_GL() {
        return CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CR_ACC_GL
     *
     * @param CR_ACC_GL the value for TFSTRXCHARGES.CR_ACC_GL
     */
    public void setCR_ACC_GL(BigDecimal CR_ACC_GL) {
        this.CR_ACC_GL = CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CR_ACC_CIF
     *
     * @return the value of TFSTRXCHARGES.CR_ACC_CIF
     */
    public BigDecimal getCR_ACC_CIF() {
        return CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CR_ACC_CIF
     *
     * @param CR_ACC_CIF the value for TFSTRXCHARGES.CR_ACC_CIF
     */
    public void setCR_ACC_CIF(BigDecimal CR_ACC_CIF) {
        this.CR_ACC_CIF = CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CR_ACC_SL
     *
     * @return the value of TFSTRXCHARGES.CR_ACC_SL
     */
    public BigDecimal getCR_ACC_SL() {
        return CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CR_ACC_SL
     *
     * @param CR_ACC_SL the value for TFSTRXCHARGES.CR_ACC_SL
     */
    public void setCR_ACC_SL(BigDecimal CR_ACC_SL) {
        this.CR_ACC_SL = CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.TFSTRX_NBR
     *
     * @return the value of TFSTRXCHARGES.TFSTRX_NBR
     */
    public BigDecimal getTFSTRX_NBR() {
        return TFSTRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.TFSTRX_NBR
     *
     * @param TFSTRX_NBR the value for TFSTRXCHARGES.TFSTRX_NBR
     */
    public void setTFSTRX_NBR(BigDecimal TFSTRX_NBR) {
        this.TFSTRX_NBR = TFSTRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.BORN_BY_APPLICANT
     *
     * @return the value of TFSTRXCHARGES.BORN_BY_APPLICANT
     */
    public BigDecimal getBORN_BY_APPLICANT() {
        return BORN_BY_APPLICANT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.BORN_BY_APPLICANT
     *
     * @param BORN_BY_APPLICANT the value for TFSTRXCHARGES.BORN_BY_APPLICANT
     */
    public void setBORN_BY_APPLICANT(BigDecimal BORN_BY_APPLICANT) {
        this.BORN_BY_APPLICANT = BORN_BY_APPLICANT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DR_ACC_GL
     *
     * @return the value of TFSTRXCHARGES.DR_ACC_GL
     */
    public BigDecimal getDR_ACC_GL() {
        return DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DR_ACC_GL
     *
     * @param DR_ACC_GL the value for TFSTRXCHARGES.DR_ACC_GL
     */
    public void setDR_ACC_GL(BigDecimal DR_ACC_GL) {
        this.DR_ACC_GL = DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DR_ACC_CIF
     *
     * @return the value of TFSTRXCHARGES.DR_ACC_CIF
     */
    public BigDecimal getDR_ACC_CIF() {
        return DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DR_ACC_CIF
     *
     * @param DR_ACC_CIF the value for TFSTRXCHARGES.DR_ACC_CIF
     */
    public void setDR_ACC_CIF(BigDecimal DR_ACC_CIF) {
        this.DR_ACC_CIF = DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DR_ACC_SL
     *
     * @return the value of TFSTRXCHARGES.DR_ACC_SL
     */
    public BigDecimal getDR_ACC_SL() {
        return DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DR_ACC_SL
     *
     * @param DR_ACC_SL the value for TFSTRXCHARGES.DR_ACC_SL
     */
    public void setDR_ACC_SL(BigDecimal DR_ACC_SL) {
        this.DR_ACC_SL = DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DR_ACC_CY
     *
     * @return the value of TFSTRXCHARGES.DR_ACC_CY
     */
    public BigDecimal getDR_ACC_CY() {
        return DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DR_ACC_CY
     *
     * @param DR_ACC_CY the value for TFSTRXCHARGES.DR_ACC_CY
     */
    public void setDR_ACC_CY(BigDecimal DR_ACC_CY) {
        this.DR_ACC_CY = DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.PERCENTAGE
     *
     * @return the value of TFSTRXCHARGES.PERCENTAGE
     */
    public BigDecimal getPERCENTAGE() {
        return PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.PERCENTAGE
     *
     * @param PERCENTAGE the value for TFSTRXCHARGES.PERCENTAGE
     */
    public void setPERCENTAGE(BigDecimal PERCENTAGE) {
        this.PERCENTAGE = PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DR_ACC_BR
     *
     * @return the value of TFSTRXCHARGES.DR_ACC_BR
     */
    public BigDecimal getDR_ACC_BR() {
        return DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DR_ACC_BR
     *
     * @param DR_ACC_BR the value for TFSTRXCHARGES.DR_ACC_BR
     */
    public void setDR_ACC_BR(BigDecimal DR_ACC_BR) {
        this.DR_ACC_BR = DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CH_FROM_TYPE
     *
     * @return the value of TFSTRXCHARGES.CH_FROM_TYPE
     */
    public String getCH_FROM_TYPE() {
        return CH_FROM_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CH_FROM_TYPE
     *
     * @param CH_FROM_TYPE the value for TFSTRXCHARGES.CH_FROM_TYPE
     */
    public void setCH_FROM_TYPE(String CH_FROM_TYPE) {
        this.CH_FROM_TYPE = CH_FROM_TYPE == null ? null : CH_FROM_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.ADD_LINE_NO
     *
     * @return the value of TFSTRXCHARGES.ADD_LINE_NO
     */
    public BigDecimal getADD_LINE_NO() {
        return ADD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.ADD_LINE_NO
     *
     * @param ADD_LINE_NO the value for TFSTRXCHARGES.ADD_LINE_NO
     */
    public void setADD_LINE_NO(BigDecimal ADD_LINE_NO) {
        this.ADD_LINE_NO = ADD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FC_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.FC_DR_AMOUNT
     */
    public BigDecimal getFC_DR_AMOUNT() {
        return FC_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FC_DR_AMOUNT
     *
     * @param FC_DR_AMOUNT the value for TFSTRXCHARGES.FC_DR_AMOUNT
     */
    public void setFC_DR_AMOUNT(BigDecimal FC_DR_AMOUNT) {
        this.FC_DR_AMOUNT = FC_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CV_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CV_DR_AMOUNT
     */
    public BigDecimal getCV_DR_AMOUNT() {
        return CV_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CV_DR_AMOUNT
     *
     * @param CV_DR_AMOUNT the value for TFSTRXCHARGES.CV_DR_AMOUNT
     */
    public void setCV_DR_AMOUNT(BigDecimal CV_DR_AMOUNT) {
        this.CV_DR_AMOUNT = CV_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.EXCH_DR_RATE
     *
     * @return the value of TFSTRXCHARGES.EXCH_DR_RATE
     */
    public BigDecimal getEXCH_DR_RATE() {
        return EXCH_DR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.EXCH_DR_RATE
     *
     * @param EXCH_DR_RATE the value for TFSTRXCHARGES.EXCH_DR_RATE
     */
    public void setEXCH_DR_RATE(BigDecimal EXCH_DR_RATE) {
        this.EXCH_DR_RATE = EXCH_DR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.ROUNDING
     *
     * @return the value of TFSTRXCHARGES.ROUNDING
     */
    public String getROUNDING() {
        return ROUNDING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.ROUNDING
     *
     * @param ROUNDING the value for TFSTRXCHARGES.ROUNDING
     */
    public void setROUNDING(String ROUNDING) {
        this.ROUNDING = ROUNDING == null ? null : ROUNDING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.ROUNDING_POINT
     *
     * @return the value of TFSTRXCHARGES.ROUNDING_POINT
     */
    public BigDecimal getROUNDING_POINT() {
        return ROUNDING_POINT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.ROUNDING_POINT
     *
     * @param ROUNDING_POINT the value for TFSTRXCHARGES.ROUNDING_POINT
     */
    public void setROUNDING_POINT(BigDecimal ROUNDING_POINT) {
        this.ROUNDING_POINT = ROUNDING_POINT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.COMMISSION_GL
     *
     * @return the value of TFSTRXCHARGES.COMMISSION_GL
     */
    public BigDecimal getCOMMISSION_GL() {
        return COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.COMMISSION_GL
     *
     * @param COMMISSION_GL the value for TFSTRXCHARGES.COMMISSION_GL
     */
    public void setCOMMISSION_GL(BigDecimal COMMISSION_GL) {
        this.COMMISSION_GL = COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.COMMISSION_CIF
     *
     * @return the value of TFSTRXCHARGES.COMMISSION_CIF
     */
    public BigDecimal getCOMMISSION_CIF() {
        return COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.COMMISSION_CIF
     *
     * @param COMMISSION_CIF the value for TFSTRXCHARGES.COMMISSION_CIF
     */
    public void setCOMMISSION_CIF(BigDecimal COMMISSION_CIF) {
        this.COMMISSION_CIF = COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.COMMISSION_SL
     *
     * @return the value of TFSTRXCHARGES.COMMISSION_SL
     */
    public BigDecimal getCOMMISSION_SL() {
        return COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.COMMISSION_SL
     *
     * @param COMMISSION_SL the value for TFSTRXCHARGES.COMMISSION_SL
     */
    public void setCOMMISSION_SL(BigDecimal COMMISSION_SL) {
        this.COMMISSION_SL = COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.PASS_ACCRUAL
     *
     * @return the value of TFSTRXCHARGES.PASS_ACCRUAL
     */
    public String getPASS_ACCRUAL() {
        return PASS_ACCRUAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.PASS_ACCRUAL
     *
     * @param PASS_ACCRUAL the value for TFSTRXCHARGES.PASS_ACCRUAL
     */
    public void setPASS_ACCRUAL(String PASS_ACCRUAL) {
        this.PASS_ACCRUAL = PASS_ACCRUAL == null ? null : PASS_ACCRUAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FC_IN_LC_CY
     *
     * @return the value of TFSTRXCHARGES.FC_IN_LC_CY
     */
    public BigDecimal getFC_IN_LC_CY() {
        return FC_IN_LC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FC_IN_LC_CY
     *
     * @param FC_IN_LC_CY the value for TFSTRXCHARGES.FC_IN_LC_CY
     */
    public void setFC_IN_LC_CY(BigDecimal FC_IN_LC_CY) {
        this.FC_IN_LC_CY = FC_IN_LC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CROSS_RATE
     *
     * @return the value of TFSTRXCHARGES.CROSS_RATE
     */
    public BigDecimal getCROSS_RATE() {
        return CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CROSS_RATE
     *
     * @param CROSS_RATE the value for TFSTRXCHARGES.CROSS_RATE
     */
    public void setCROSS_RATE(BigDecimal CROSS_RATE) {
        this.CROSS_RATE = CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CROSS_MULT_DIV
     *
     * @return the value of TFSTRXCHARGES.CROSS_MULT_DIV
     */
    public String getCROSS_MULT_DIV() {
        return CROSS_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CROSS_MULT_DIV
     *
     * @param CROSS_MULT_DIV the value for TFSTRXCHARGES.CROSS_MULT_DIV
     */
    public void setCROSS_MULT_DIV(String CROSS_MULT_DIV) {
        this.CROSS_MULT_DIV = CROSS_MULT_DIV == null ? null : CROSS_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.LC_CY
     *
     * @return the value of TFSTRXCHARGES.LC_CY
     */
    public BigDecimal getLC_CY() {
        return LC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.LC_CY
     *
     * @param LC_CY the value for TFSTRXCHARGES.LC_CY
     */
    public void setLC_CY(BigDecimal LC_CY) {
        this.LC_CY = LC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CR_ACC_BR
     *
     * @return the value of TFSTRXCHARGES.CR_ACC_BR
     */
    public BigDecimal getCR_ACC_BR() {
        return CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CR_ACC_BR
     *
     * @param CR_ACC_BR the value for TFSTRXCHARGES.CR_ACC_BR
     */
    public void setCR_ACC_BR(BigDecimal CR_ACC_BR) {
        this.CR_ACC_BR = CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DEFAULT_LOGGED_CR_BR
     *
     * @return the value of TFSTRXCHARGES.DEFAULT_LOGGED_CR_BR
     */
    public String getDEFAULT_LOGGED_CR_BR() {
        return DEFAULT_LOGGED_CR_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DEFAULT_LOGGED_CR_BR
     *
     * @param DEFAULT_LOGGED_CR_BR the value for TFSTRXCHARGES.DEFAULT_LOGGED_CR_BR
     */
    public void setDEFAULT_LOGGED_CR_BR(String DEFAULT_LOGGED_CR_BR) {
        this.DEFAULT_LOGGED_CR_BR = DEFAULT_LOGGED_CR_BR == null ? null : DEFAULT_LOGGED_CR_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.OLD_PERCENTAGE
     *
     * @return the value of TFSTRXCHARGES.OLD_PERCENTAGE
     */
    public BigDecimal getOLD_PERCENTAGE() {
        return OLD_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.OLD_PERCENTAGE
     *
     * @param OLD_PERCENTAGE the value for TFSTRXCHARGES.OLD_PERCENTAGE
     */
    public void setOLD_PERCENTAGE(BigDecimal OLD_PERCENTAGE) {
        this.OLD_PERCENTAGE = OLD_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.OVERDRAWN_ACC
     *
     * @return the value of TFSTRXCHARGES.OVERDRAWN_ACC
     */
    public String getOVERDRAWN_ACC() {
        return OVERDRAWN_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.OVERDRAWN_ACC
     *
     * @param OVERDRAWN_ACC the value for TFSTRXCHARGES.OVERDRAWN_ACC
     */
    public void setOVERDRAWN_ACC(String OVERDRAWN_ACC) {
        this.OVERDRAWN_ACC = OVERDRAWN_ACC == null ? null : OVERDRAWN_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CR_ACC_CY
     *
     * @return the value of TFSTRXCHARGES.CR_ACC_CY
     */
    public BigDecimal getCR_ACC_CY() {
        return CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CR_ACC_CY
     *
     * @param CR_ACC_CY the value for TFSTRXCHARGES.CR_ACC_CY
     */
    public void setCR_ACC_CY(BigDecimal CR_ACC_CY) {
        this.CR_ACC_CY = CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DIFFERENT_CY_CHARGE
     *
     * @return the value of TFSTRXCHARGES.DIFFERENT_CY_CHARGE
     */
    public String getDIFFERENT_CY_CHARGE() {
        return DIFFERENT_CY_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DIFFERENT_CY_CHARGE
     *
     * @param DIFFERENT_CY_CHARGE the value for TFSTRXCHARGES.DIFFERENT_CY_CHARGE
     */
    public void setDIFFERENT_CY_CHARGE(String DIFFERENT_CY_CHARGE) {
        this.DIFFERENT_CY_CHARGE = DIFFERENT_CY_CHARGE == null ? null : DIFFERENT_CY_CHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_CODE
     *
     * @return the value of TFSTRXCHARGES.VAT_CODE
     */
    public BigDecimal getVAT_CODE() {
        return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_CODE
     *
     * @param VAT_CODE the value for TFSTRXCHARGES.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE) {
        this.VAT_CODE = VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE
     *
     * @return the value of TFSTRXCHARGES.FREQUENTLY_CHARGE
     */
    public String getFREQUENTLY_CHARGE() {
        return FREQUENTLY_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE
     *
     * @param FREQUENTLY_CHARGE the value for TFSTRXCHARGES.FREQUENTLY_CHARGE
     */
    public void setFREQUENTLY_CHARGE(String FREQUENTLY_CHARGE) {
        this.FREQUENTLY_CHARGE = FREQUENTLY_CHARGE == null ? null : FREQUENTLY_CHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED
     *
     * @return the value of TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED
     */
    public String getFREQUENTLY_CHARGE_POSTED() {
        return FREQUENTLY_CHARGE_POSTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED
     *
     * @param FREQUENTLY_CHARGE_POSTED the value for TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED
     */
    public void setFREQUENTLY_CHARGE_POSTED(String FREQUENTLY_CHARGE_POSTED) {
        this.FREQUENTLY_CHARGE_POSTED = FREQUENTLY_CHARGE_POSTED == null ? null : FREQUENTLY_CHARGE_POSTED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED_DT
     *
     * @return the value of TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED_DT
     */
    public Date getFREQUENTLY_CHARGE_POSTED_DT() {
        return FREQUENTLY_CHARGE_POSTED_DT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED_DT
     *
     * @param FREQUENTLY_CHARGE_POSTED_DT the value for TFSTRXCHARGES.FREQUENTLY_CHARGE_POSTED_DT
     */
    public void setFREQUENTLY_CHARGE_POSTED_DT(Date FREQUENTLY_CHARGE_POSTED_DT) {
        this.FREQUENTLY_CHARGE_POSTED_DT = FREQUENTLY_CHARGE_POSTED_DT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DOC_SELL_RATE
     *
     * @return the value of TFSTRXCHARGES.DOC_SELL_RATE
     */
    public BigDecimal getDOC_SELL_RATE() {
        return DOC_SELL_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DOC_SELL_RATE
     *
     * @param DOC_SELL_RATE the value for TFSTRXCHARGES.DOC_SELL_RATE
     */
    public void setDOC_SELL_RATE(BigDecimal DOC_SELL_RATE) {
        this.DOC_SELL_RATE = DOC_SELL_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.APPLY_DAILY_PERCENT
     *
     * @return the value of TFSTRXCHARGES.APPLY_DAILY_PERCENT
     */
    public String getAPPLY_DAILY_PERCENT() {
        return APPLY_DAILY_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.APPLY_DAILY_PERCENT
     *
     * @param APPLY_DAILY_PERCENT the value for TFSTRXCHARGES.APPLY_DAILY_PERCENT
     */
    public void setAPPLY_DAILY_PERCENT(String APPLY_DAILY_PERCENT) {
        this.APPLY_DAILY_PERCENT = APPLY_DAILY_PERCENT == null ? null : APPLY_DAILY_PERCENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.DELETE_CHARGE
     *
     * @return the value of TFSTRXCHARGES.DELETE_CHARGE
     */
    public String getDELETE_CHARGE() {
        return DELETE_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.DELETE_CHARGE
     *
     * @param DELETE_CHARGE the value for TFSTRXCHARGES.DELETE_CHARGE
     */
    public void setDELETE_CHARGE(String DELETE_CHARGE) {
        this.DELETE_CHARGE = DELETE_CHARGE == null ? null : DELETE_CHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.PROTECT_CHARGE
     *
     * @return the value of TFSTRXCHARGES.PROTECT_CHARGE
     */
    public String getPROTECT_CHARGE() {
        return PROTECT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.PROTECT_CHARGE
     *
     * @param PROTECT_CHARGE the value for TFSTRXCHARGES.PROTECT_CHARGE
     */
    public void setPROTECT_CHARGE(String PROTECT_CHARGE) {
        this.PROTECT_CHARGE = PROTECT_CHARGE == null ? null : PROTECT_CHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_CV_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.AMEND_CV_DR_AMOUNT
     */
    public BigDecimal getAMEND_CV_DR_AMOUNT() {
        return AMEND_CV_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_CV_DR_AMOUNT
     *
     * @param AMEND_CV_DR_AMOUNT the value for TFSTRXCHARGES.AMEND_CV_DR_AMOUNT
     */
    public void setAMEND_CV_DR_AMOUNT(BigDecimal AMEND_CV_DR_AMOUNT) {
        this.AMEND_CV_DR_AMOUNT = AMEND_CV_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_FC_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.AMEND_FC_DR_AMOUNT
     */
    public BigDecimal getAMEND_FC_DR_AMOUNT() {
        return AMEND_FC_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_FC_DR_AMOUNT
     *
     * @param AMEND_FC_DR_AMOUNT the value for TFSTRXCHARGES.AMEND_FC_DR_AMOUNT
     */
    public void setAMEND_FC_DR_AMOUNT(BigDecimal AMEND_FC_DR_AMOUNT) {
        this.AMEND_FC_DR_AMOUNT = AMEND_FC_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_FLAT_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.AMEND_FLAT_AMOUNT
     */
    public BigDecimal getAMEND_FLAT_AMOUNT() {
        return AMEND_FLAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_FLAT_AMOUNT
     *
     * @param AMEND_FLAT_AMOUNT the value for TFSTRXCHARGES.AMEND_FLAT_AMOUNT
     */
    public void setAMEND_FLAT_AMOUNT(BigDecimal AMEND_FLAT_AMOUNT) {
        this.AMEND_FLAT_AMOUNT = AMEND_FLAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_PERCENTAGE
     *
     * @return the value of TFSTRXCHARGES.AMEND_PERCENTAGE
     */
    public BigDecimal getAMEND_PERCENTAGE() {
        return AMEND_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_PERCENTAGE
     *
     * @param AMEND_PERCENTAGE the value for TFSTRXCHARGES.AMEND_PERCENTAGE
     */
    public void setAMEND_PERCENTAGE(BigDecimal AMEND_PERCENTAGE) {
        this.AMEND_PERCENTAGE = AMEND_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_PERCENTAGE
     *
     * @return the value of TFSTRXCHARGES.VAT_PERCENTAGE
     */
    public BigDecimal getVAT_PERCENTAGE() {
        return VAT_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_PERCENTAGE
     *
     * @param VAT_PERCENTAGE the value for TFSTRXCHARGES.VAT_PERCENTAGE
     */
    public void setVAT_PERCENTAGE(BigDecimal VAT_PERCENTAGE) {
        this.VAT_PERCENTAGE = VAT_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_FC_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.VAT_FC_AMOUNT
     */
    public BigDecimal getVAT_FC_AMOUNT() {
        return VAT_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_FC_AMOUNT
     *
     * @param VAT_FC_AMOUNT the value for TFSTRXCHARGES.VAT_FC_AMOUNT
     */
    public void setVAT_FC_AMOUNT(BigDecimal VAT_FC_AMOUNT) {
        this.VAT_FC_AMOUNT = VAT_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_CY_RATE
     *
     * @return the value of TFSTRXCHARGES.VAT_CY_RATE
     */
    public BigDecimal getVAT_CY_RATE() {
        return VAT_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_CY_RATE
     *
     * @param VAT_CY_RATE the value for TFSTRXCHARGES.VAT_CY_RATE
     */
    public void setVAT_CY_RATE(BigDecimal VAT_CY_RATE) {
        this.VAT_CY_RATE = VAT_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_CV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.VAT_CV_AMOUNT
     */
    public BigDecimal getVAT_CV_AMOUNT() {
        return VAT_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_CV_AMOUNT
     *
     * @param VAT_CV_AMOUNT the value for TFSTRXCHARGES.VAT_CV_AMOUNT
     */
    public void setVAT_CV_AMOUNT(BigDecimal VAT_CV_AMOUNT) {
        this.VAT_CV_AMOUNT = VAT_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_ACC_BR
     *
     * @return the value of TFSTRXCHARGES.VAT_ACC_BR
     */
    public BigDecimal getVAT_ACC_BR() {
        return VAT_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_ACC_BR
     *
     * @param VAT_ACC_BR the value for TFSTRXCHARGES.VAT_ACC_BR
     */
    public void setVAT_ACC_BR(BigDecimal VAT_ACC_BR) {
        this.VAT_ACC_BR = VAT_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_ACC_CY
     *
     * @return the value of TFSTRXCHARGES.VAT_ACC_CY
     */
    public BigDecimal getVAT_ACC_CY() {
        return VAT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_ACC_CY
     *
     * @param VAT_ACC_CY the value for TFSTRXCHARGES.VAT_ACC_CY
     */
    public void setVAT_ACC_CY(BigDecimal VAT_ACC_CY) {
        this.VAT_ACC_CY = VAT_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_ACC_GL
     *
     * @return the value of TFSTRXCHARGES.VAT_ACC_GL
     */
    public BigDecimal getVAT_ACC_GL() {
        return VAT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_ACC_GL
     *
     * @param VAT_ACC_GL the value for TFSTRXCHARGES.VAT_ACC_GL
     */
    public void setVAT_ACC_GL(BigDecimal VAT_ACC_GL) {
        this.VAT_ACC_GL = VAT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_ACC_CIF
     *
     * @return the value of TFSTRXCHARGES.VAT_ACC_CIF
     */
    public BigDecimal getVAT_ACC_CIF() {
        return VAT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_ACC_CIF
     *
     * @param VAT_ACC_CIF the value for TFSTRXCHARGES.VAT_ACC_CIF
     */
    public void setVAT_ACC_CIF(BigDecimal VAT_ACC_CIF) {
        this.VAT_ACC_CIF = VAT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_ACC_SL
     *
     * @return the value of TFSTRXCHARGES.VAT_ACC_SL
     */
    public BigDecimal getVAT_ACC_SL() {
        return VAT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_ACC_SL
     *
     * @param VAT_ACC_SL the value for TFSTRXCHARGES.VAT_ACC_SL
     */
    public void setVAT_ACC_SL(BigDecimal VAT_ACC_SL) {
        this.VAT_ACC_SL = VAT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CHARGES_BY_TIERS
     *
     * @return the value of TFSTRXCHARGES.CHARGES_BY_TIERS
     */
    public String getCHARGES_BY_TIERS() {
        return CHARGES_BY_TIERS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CHARGES_BY_TIERS
     *
     * @param CHARGES_BY_TIERS the value for TFSTRXCHARGES.CHARGES_BY_TIERS
     */
    public void setCHARGES_BY_TIERS(String CHARGES_BY_TIERS) {
        this.CHARGES_BY_TIERS = CHARGES_BY_TIERS == null ? null : CHARGES_BY_TIERS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CHARGE_CV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CHARGE_CV_AMOUNT
     */
    public BigDecimal getCHARGE_CV_AMOUNT() {
        return CHARGE_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CHARGE_CV_AMOUNT
     *
     * @param CHARGE_CV_AMOUNT the value for TFSTRXCHARGES.CHARGE_CV_AMOUNT
     */
    public void setCHARGE_CV_AMOUNT(BigDecimal CHARGE_CV_AMOUNT) {
        this.CHARGE_CV_AMOUNT = CHARGE_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CHARGE_FC_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CHARGE_FC_AMOUNT
     */
    public BigDecimal getCHARGE_FC_AMOUNT() {
        return CHARGE_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CHARGE_FC_AMOUNT
     *
     * @param CHARGE_FC_AMOUNT the value for TFSTRXCHARGES.CHARGE_FC_AMOUNT
     */
    public void setCHARGE_FC_AMOUNT(BigDecimal CHARGE_FC_AMOUNT) {
        this.CHARGE_FC_AMOUNT = CHARGE_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CLOSED_SUSP_CV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CLOSED_SUSP_CV_AMOUNT
     */
    public BigDecimal getCLOSED_SUSP_CV_AMOUNT() {
        return CLOSED_SUSP_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CLOSED_SUSP_CV_AMOUNT
     *
     * @param CLOSED_SUSP_CV_AMOUNT the value for TFSTRXCHARGES.CLOSED_SUSP_CV_AMOUNT
     */
    public void setCLOSED_SUSP_CV_AMOUNT(BigDecimal CLOSED_SUSP_CV_AMOUNT) {
        this.CLOSED_SUSP_CV_AMOUNT = CLOSED_SUSP_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CLOSED_SUSP_FC_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CLOSED_SUSP_FC_AMOUNT
     */
    public BigDecimal getCLOSED_SUSP_FC_AMOUNT() {
        return CLOSED_SUSP_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CLOSED_SUSP_FC_AMOUNT
     *
     * @param CLOSED_SUSP_FC_AMOUNT the value for TFSTRXCHARGES.CLOSED_SUSP_FC_AMOUNT
     */
    public void setCLOSED_SUSP_FC_AMOUNT(BigDecimal CLOSED_SUSP_FC_AMOUNT) {
        this.CLOSED_SUSP_FC_AMOUNT = CLOSED_SUSP_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_BR
     *
     * @return the value of TFSTRXCHARGES.SUSPENSE_CHARGE_BR
     */
    public BigDecimal getSUSPENSE_CHARGE_BR() {
        return SUSPENSE_CHARGE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_BR
     *
     * @param SUSPENSE_CHARGE_BR the value for TFSTRXCHARGES.SUSPENSE_CHARGE_BR
     */
    public void setSUSPENSE_CHARGE_BR(BigDecimal SUSPENSE_CHARGE_BR) {
        this.SUSPENSE_CHARGE_BR = SUSPENSE_CHARGE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CIF
     *
     * @return the value of TFSTRXCHARGES.SUSPENSE_CHARGE_CIF
     */
    public BigDecimal getSUSPENSE_CHARGE_CIF() {
        return SUSPENSE_CHARGE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CIF
     *
     * @param SUSPENSE_CHARGE_CIF the value for TFSTRXCHARGES.SUSPENSE_CHARGE_CIF
     */
    public void setSUSPENSE_CHARGE_CIF(BigDecimal SUSPENSE_CHARGE_CIF) {
        this.SUSPENSE_CHARGE_CIF = SUSPENSE_CHARGE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CY
     *
     * @return the value of TFSTRXCHARGES.SUSPENSE_CHARGE_CY
     */
    public BigDecimal getSUSPENSE_CHARGE_CY() {
        return SUSPENSE_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_CY
     *
     * @param SUSPENSE_CHARGE_CY the value for TFSTRXCHARGES.SUSPENSE_CHARGE_CY
     */
    public void setSUSPENSE_CHARGE_CY(BigDecimal SUSPENSE_CHARGE_CY) {
        this.SUSPENSE_CHARGE_CY = SUSPENSE_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_GL
     *
     * @return the value of TFSTRXCHARGES.SUSPENSE_CHARGE_GL
     */
    public BigDecimal getSUSPENSE_CHARGE_GL() {
        return SUSPENSE_CHARGE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_GL
     *
     * @param SUSPENSE_CHARGE_GL the value for TFSTRXCHARGES.SUSPENSE_CHARGE_GL
     */
    public void setSUSPENSE_CHARGE_GL(BigDecimal SUSPENSE_CHARGE_GL) {
        this.SUSPENSE_CHARGE_GL = SUSPENSE_CHARGE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_SL
     *
     * @return the value of TFSTRXCHARGES.SUSPENSE_CHARGE_SL
     */
    public BigDecimal getSUSPENSE_CHARGE_SL() {
        return SUSPENSE_CHARGE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.SUSPENSE_CHARGE_SL
     *
     * @param SUSPENSE_CHARGE_SL the value for TFSTRXCHARGES.SUSPENSE_CHARGE_SL
     */
    public void setSUSPENSE_CHARGE_SL(BigDecimal SUSPENSE_CHARGE_SL) {
        this.SUSPENSE_CHARGE_SL = SUSPENSE_CHARGE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_IND
     *
     * @return the value of TFSTRXCHARGES.AMEND_IND
     */
    public String getAMEND_IND() {
        return AMEND_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_IND
     *
     * @param AMEND_IND the value for TFSTRXCHARGES.AMEND_IND
     */
    public void setAMEND_IND(String AMEND_IND) {
        this.AMEND_IND = AMEND_IND == null ? null : AMEND_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.ALLOW_MODIFY_CHARGES
     *
     * @return the value of TFSTRXCHARGES.ALLOW_MODIFY_CHARGES
     */
    public String getALLOW_MODIFY_CHARGES() {
        return ALLOW_MODIFY_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.ALLOW_MODIFY_CHARGES
     *
     * @param ALLOW_MODIFY_CHARGES the value for TFSTRXCHARGES.ALLOW_MODIFY_CHARGES
     */
    public void setALLOW_MODIFY_CHARGES(String ALLOW_MODIFY_CHARGES) {
        this.ALLOW_MODIFY_CHARGES = ALLOW_MODIFY_CHARGES == null ? null : ALLOW_MODIFY_CHARGES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.HOF_TRS_NO
     *
     * @return the value of TFSTRXCHARGES.HOF_TRS_NO
     */
    public BigDecimal getHOF_TRS_NO() {
        return HOF_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.HOF_TRS_NO
     *
     * @param HOF_TRS_NO the value for TFSTRXCHARGES.HOF_TRS_NO
     */
    public void setHOF_TRS_NO(BigDecimal HOF_TRS_NO) {
        this.HOF_TRS_NO = HOF_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.OVERDRAWN_VAT
     *
     * @return the value of TFSTRXCHARGES.OVERDRAWN_VAT
     */
    public String getOVERDRAWN_VAT() {
        return OVERDRAWN_VAT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.OVERDRAWN_VAT
     *
     * @param OVERDRAWN_VAT the value for TFSTRXCHARGES.OVERDRAWN_VAT
     */
    public void setOVERDRAWN_VAT(String OVERDRAWN_VAT) {
        this.OVERDRAWN_VAT = OVERDRAWN_VAT == null ? null : OVERDRAWN_VAT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_SUSPENSE_CV
     *
     * @return the value of TFSTRXCHARGES.VAT_SUSPENSE_CV
     */
    public BigDecimal getVAT_SUSPENSE_CV() {
        return VAT_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_SUSPENSE_CV
     *
     * @param VAT_SUSPENSE_CV the value for TFSTRXCHARGES.VAT_SUSPENSE_CV
     */
    public void setVAT_SUSPENSE_CV(BigDecimal VAT_SUSPENSE_CV) {
        this.VAT_SUSPENSE_CV = VAT_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_SUSPENSE_FC
     *
     * @return the value of TFSTRXCHARGES.VAT_SUSPENSE_FC
     */
    public BigDecimal getVAT_SUSPENSE_FC() {
        return VAT_SUSPENSE_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_SUSPENSE_FC
     *
     * @param VAT_SUSPENSE_FC the value for TFSTRXCHARGES.VAT_SUSPENSE_FC
     */
    public void setVAT_SUSPENSE_FC(BigDecimal VAT_SUSPENSE_FC) {
        this.VAT_SUSPENSE_FC = VAT_SUSPENSE_FC;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.CV_DR_NON_PROV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.CV_DR_NON_PROV_AMOUNT
     */
    public BigDecimal getCV_DR_NON_PROV_AMOUNT() {
        return CV_DR_NON_PROV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.CV_DR_NON_PROV_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.CV_DR_NON_PROV_AMOUNT
     */
    public void setCV_DR_NON_PROV_AMOUNT(BigDecimal CV_DR_NON_PROV_AMOUNT) {
        this.CV_DR_NON_PROV_AMOUNT = CV_DR_NON_PROV_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.FC_DR_NON_PROV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.FC_DR_NON_PROV_AMOUNT
     */
    public BigDecimal getFC_DR_NON_PROV_AMOUNT() {
        return FC_DR_NON_PROV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.FC_DR_NON_PROV_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.FC_DR_NON_PROV_AMOUNT
     */
    public void setFC_DR_NON_PROV_AMOUNT(BigDecimal FC_DR_NON_PROV_AMOUNT) {
        this.FC_DR_NON_PROV_AMOUNT = FC_DR_NON_PROV_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.NON_PROV_AMT_CHARGE
     *
     * @return the value of TFSTRXCHARGES.NON_PROV_AMT_CHARGE
     */
    public BigDecimal getNON_PROV_AMT_CHARGE() {
        return NON_PROV_AMT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.NON_PROV_AMT_CHARGE
     *
     * @param CODE the value for TFSTRXCHARGES.NON_PROV_AMT_CHARGE
     */
    public void setNON_PROV_AMT_CHARGE(BigDecimal NON_PROV_AMT_CHARGE) {
        this.NON_PROV_AMT_CHARGE = NON_PROV_AMT_CHARGE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.PROV_AMT_CHARGE
     *
     * @return the value of TFSTRXCHARGES.PROV_AMT_CHARGE
     */
    public BigDecimal getPROV_AMT_CHARGE() {
        return PROV_AMT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.PROV_AMT_CHARGE
     *
     * @param CODE the value for TFSTRXCHARGES.PROV_AMT_CHARGE
     */
    public void setPROV_AMT_CHARGE(BigDecimal PROV_AMT_CHARGE) {
        this.PROV_AMT_CHARGE = PROV_AMT_CHARGE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_CV_PROV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.VAT_CV_PROV_AMOUNT
     */
    public BigDecimal getVAT_CV_PROV_AMOUNT() {
        return VAT_CV_PROV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_CV_PROV_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.VAT_CV_PROV_AMOUNT
     */
    public void setVAT_CV_PROV_AMOUNT(BigDecimal VAT_CV_PROV_AMOUNT) {
        this.VAT_CV_PROV_AMOUNT = VAT_CV_PROV_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.VAT_FC_PROV_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.VAT_FC_PROV_AMOUNT
     */
    public BigDecimal getVAT_FC_PROV_AMOUNT() {
        return VAT_FC_PROV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.VAT_FC_PROV_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.VAT_FC_PROV_AMOUNT
     */
    public void setVAT_FC_PROV_AMOUNT(BigDecimal VAT_FC_PROV_AMOUNT) {
        this.VAT_FC_PROV_AMOUNT = VAT_FC_PROV_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_PROV_CV_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.AMEND_PROV_CV_DR_AMOUNT
     */
    public BigDecimal getAMEND_PROV_CV_DR_AMOUNT() {
        return AMEND_PROV_CV_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_PROV_CV_DR_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.AMEND_PROV_CV_DR_AMOUNT
     */
    public void setAMEND_PROV_CV_DR_AMOUNT(BigDecimal AMEND_PROV_CV_DR_AMOUNT) {
        this.AMEND_PROV_CV_DR_AMOUNT = AMEND_PROV_CV_DR_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_PROV_FC_DR_AMOUNT
     *
     * @return the value of TFSTRXCHARGES.AMEND_PROV_FC_DR_AMOUNT
     */
    public BigDecimal getAMEND_PROV_FC_DR_AMOUNT() {
        return AMEND_PROV_FC_DR_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_PROV_FC_DR_AMOUNT
     *
     * @param CODE the value for TFSTRXCHARGES.AMEND_PROV_FC_DR_AMOUNT
     */
    public void setAMEND_PROV_FC_DR_AMOUNT(BigDecimal AMEND_PROV_FC_DR_AMOUNT) {
        this.AMEND_PROV_FC_DR_AMOUNT = AMEND_PROV_FC_DR_AMOUNT;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_PROV_AMT_CHARGE
     *
     * @return the value of TFSTRXCHARGES.AMEND_PROV_AMT_CHARGE
     */
    public BigDecimal getAMEND_PROV_AMT_CHARGE() {
        return AMEND_PROV_AMT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_PROV_AMT_CHARGE
     *
     * @param CODE the value for TFSTRXCHARGES.AMEND_PROV_AMT_CHARGE
     */
    public void setAMEND_PROV_AMT_CHARGE(BigDecimal AMEND_PROV_AMT_CHARGE) {
        this.AMEND_PROV_AMT_CHARGE = AMEND_PROV_AMT_CHARGE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSTRXCHARGES.AMEND_NON_PROV_AMT_CHARGE
     *
     * @return the value of TFSTRXCHARGES.AMEND_NON_PROV_AMT_CHARGE
     */
    public BigDecimal getAMEND_NON_PROV_AMT_CHARGE() {
        return AMEND_NON_PROV_AMT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSTRXCHARGES.AMEND_NON_PROV_AMT_CHARGE
     *
     * @param CODE the value for TFSTRXCHARGES.AMEND_NON_PROV_AMT_CHARGE
     */
    public void setAMEND_NON_PROV_AMT_CHARGE(BigDecimal AMEND_NON_PROV_AMT_CHARGE) {
        this.AMEND_NON_PROV_AMT_CHARGE = AMEND_NON_PROV_AMT_CHARGE;
    }
}