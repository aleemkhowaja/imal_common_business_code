package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TFS_MULTI_ACCVO extends BaseVO {
    /**
     * This field corresponds to the database column TFS_MULTI_ACC.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DOC_TYPE
     */
    private String DOC_TYPE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.TRX_NBR
     */
    private BigDecimal TRX_NBR;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.TRX_TYPE
     */
    private BigDecimal TRX_TYPE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_BR
     */
    private BigDecimal CLIENT_BR;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_CY
     */
    private BigDecimal CLIENT_CY;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_GL
     */
    private BigDecimal CLIENT_GL;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_CIF
     */
    private BigDecimal CLIENT_CIF;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_SL
     */
    private BigDecimal CLIENT_SL;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_FC
     */
    private BigDecimal CLIENT_FC;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_RATE
     */
    private BigDecimal CLIENT_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_CV
     */
    private BigDecimal CLIENT_CV;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.PAYMENT_METHOD
     */
    private String PAYMENT_METHOD;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.REMITTANCE_TYPE
     */
    private BigDecimal REMITTANCE_TYPE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DD_TRS_NO
     */
    private BigDecimal DD_TRS_NO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DD_CHQ_NBR
     */
    private BigDecimal DD_CHQ_NBR;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DD_PRINTED
     */
    private String DD_PRINTED;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.FC_SUSPENSE
     */
    private BigDecimal FC_SUSPENSE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CV_SUSPENSE
     */
    private BigDecimal CV_SUSPENSE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.SUSPENSE_RATE
     */
    private BigDecimal SUSPENSE_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.FC_WITHDRAW
     */
    private BigDecimal FC_WITHDRAW;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CV_WITHDRAW
     */
    private BigDecimal CV_WITHDRAW;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.WITHDRAW_RATE
     */
    private BigDecimal WITHDRAW_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.FC_MARGIN
     */
    private BigDecimal FC_MARGIN;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CV_MARGIN
     */
    private BigDecimal CV_MARGIN;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.MARGIN_RATE
     */
    private BigDecimal MARGIN_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.FC_NOSTRO
     */
    private BigDecimal FC_NOSTRO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CV_NOSTRO
     */
    private BigDecimal CV_NOSTRO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.NOSTRO_RATE
     */
    private BigDecimal NOSTRO_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.FC_MARGIN_1
     */
    private BigDecimal FC_MARGIN_1;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CV_MARGIN_1
     */
    private BigDecimal CV_MARGIN_1;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.MARGIN_RATE_1
     */
    private BigDecimal MARGIN_RATE_1;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.USE_SUSPENSE
     */
    private String USE_SUSPENSE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_MULT_DIV
     */
    private String CLIENT_MULT_DIV;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.CLIENT_UNIT
     */
    private BigDecimal CLIENT_UNIT;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.ORIGINAL_FC_NOSTRO
     */
    private BigDecimal ORIGINAL_FC_NOSTRO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.ORIGINAL_CV_NOSTRO
     */
    private BigDecimal ORIGINAL_CV_NOSTRO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_RATE
     */
    private BigDecimal ORIGINAL_NOSTRO_RATE;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_CY
     */
    private BigDecimal ORIGINAL_NOSTRO_CY;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.VISIBLE_CV
     */
    private String VISIBLE_CV;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.BRIDGING_ACC
     */
    private String BRIDGING_ACC;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DEAL_SERIAL_NO
     */
    private BigDecimal DEAL_SERIAL_NO;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DEAL_BR
     */
    private BigDecimal DEAL_BR;

    /**
     * This field corresponds to the database column TFS_MULTI_ACC.DEALER_NAME
     */
    private String DEALER_NAME;
    
    
    /**
     * This field corresponds to the database column TFS_MULTI_ACC.HOF_TRS_NO
     */
    private BigDecimal HOF_TRS_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.BRANCH_CODE
     *
     * @return the value of TFS_MULTI_ACC.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TFS_MULTI_ACC.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.COMP_CODE
     *
     * @return the value of TFS_MULTI_ACC.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.COMP_CODE
     *
     * @param COMP_CODE the value for TFS_MULTI_ACC.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DOC_TYPE
     *
     * @return the value of TFS_MULTI_ACC.DOC_TYPE
     */
    public String getDOC_TYPE() {
        return DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DOC_TYPE
     *
     * @param DOC_TYPE the value for TFS_MULTI_ACC.DOC_TYPE
     */
    public void setDOC_TYPE(String DOC_TYPE) {
        this.DOC_TYPE = DOC_TYPE == null ? null : DOC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.LINE_NO
     *
     * @return the value of TFS_MULTI_ACC.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.LINE_NO
     *
     * @param LINE_NO the value for TFS_MULTI_ACC.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.TRX_NBR
     *
     * @return the value of TFS_MULTI_ACC.TRX_NBR
     */
    public BigDecimal getTRX_NBR() {
        return TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.TRX_NBR
     *
     * @param TRX_NBR the value for TFS_MULTI_ACC.TRX_NBR
     */
    public void setTRX_NBR(BigDecimal TRX_NBR) {
        this.TRX_NBR = TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.TRX_TYPE
     *
     * @return the value of TFS_MULTI_ACC.TRX_TYPE
     */
    public BigDecimal getTRX_TYPE() {
        return TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.TRX_TYPE
     *
     * @param TRX_TYPE the value for TFS_MULTI_ACC.TRX_TYPE
     */
    public void setTRX_TYPE(BigDecimal TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_BR
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_BR
     */
    public BigDecimal getCLIENT_BR() {
        return CLIENT_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_BR
     *
     * @param CLIENT_BR the value for TFS_MULTI_ACC.CLIENT_BR
     */
    public void setCLIENT_BR(BigDecimal CLIENT_BR) {
        this.CLIENT_BR = CLIENT_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_CY
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_CY
     */
    public BigDecimal getCLIENT_CY() {
        return CLIENT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_CY
     *
     * @param CLIENT_CY the value for TFS_MULTI_ACC.CLIENT_CY
     */
    public void setCLIENT_CY(BigDecimal CLIENT_CY) {
        this.CLIENT_CY = CLIENT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_GL
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_GL
     */
    public BigDecimal getCLIENT_GL() {
        return CLIENT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_GL
     *
     * @param CLIENT_GL the value for TFS_MULTI_ACC.CLIENT_GL
     */
    public void setCLIENT_GL(BigDecimal CLIENT_GL) {
        this.CLIENT_GL = CLIENT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_CIF
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_CIF
     */
    public BigDecimal getCLIENT_CIF() {
        return CLIENT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_CIF
     *
     * @param CLIENT_CIF the value for TFS_MULTI_ACC.CLIENT_CIF
     */
    public void setCLIENT_CIF(BigDecimal CLIENT_CIF) {
        this.CLIENT_CIF = CLIENT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_SL
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_SL
     */
    public BigDecimal getCLIENT_SL() {
        return CLIENT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_SL
     *
     * @param CLIENT_SL the value for TFS_MULTI_ACC.CLIENT_SL
     */
    public void setCLIENT_SL(BigDecimal CLIENT_SL) {
        this.CLIENT_SL = CLIENT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_FC
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_FC
     */
    public BigDecimal getCLIENT_FC() {
        return CLIENT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_FC
     *
     * @param CLIENT_FC the value for TFS_MULTI_ACC.CLIENT_FC
     */
    public void setCLIENT_FC(BigDecimal CLIENT_FC) {
        this.CLIENT_FC = CLIENT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_RATE
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_RATE
     */
    public BigDecimal getCLIENT_RATE() {
        return CLIENT_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_RATE
     *
     * @param CLIENT_RATE the value for TFS_MULTI_ACC.CLIENT_RATE
     */
    public void setCLIENT_RATE(BigDecimal CLIENT_RATE) {
        this.CLIENT_RATE = CLIENT_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_CV
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_CV
     */
    public BigDecimal getCLIENT_CV() {
        return CLIENT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_CV
     *
     * @param CLIENT_CV the value for TFS_MULTI_ACC.CLIENT_CV
     */
    public void setCLIENT_CV(BigDecimal CLIENT_CV) {
        this.CLIENT_CV = CLIENT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.PAYMENT_METHOD
     *
     * @return the value of TFS_MULTI_ACC.PAYMENT_METHOD
     */
    public String getPAYMENT_METHOD() {
        return PAYMENT_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.PAYMENT_METHOD
     *
     * @param PAYMENT_METHOD the value for TFS_MULTI_ACC.PAYMENT_METHOD
     */
    public void setPAYMENT_METHOD(String PAYMENT_METHOD) {
        this.PAYMENT_METHOD = PAYMENT_METHOD == null ? null : PAYMENT_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.REMITTANCE_TYPE
     *
     * @return the value of TFS_MULTI_ACC.REMITTANCE_TYPE
     */
    public BigDecimal getREMITTANCE_TYPE() {
        return REMITTANCE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.REMITTANCE_TYPE
     *
     * @param REMITTANCE_TYPE the value for TFS_MULTI_ACC.REMITTANCE_TYPE
     */
    public void setREMITTANCE_TYPE(BigDecimal REMITTANCE_TYPE) {
        this.REMITTANCE_TYPE = REMITTANCE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DD_TRS_NO
     *
     * @return the value of TFS_MULTI_ACC.DD_TRS_NO
     */
    public BigDecimal getDD_TRS_NO() {
        return DD_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DD_TRS_NO
     *
     * @param DD_TRS_NO the value for TFS_MULTI_ACC.DD_TRS_NO
     */
    public void setDD_TRS_NO(BigDecimal DD_TRS_NO) {
        this.DD_TRS_NO = DD_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DD_CHQ_NBR
     *
     * @return the value of TFS_MULTI_ACC.DD_CHQ_NBR
     */
    public BigDecimal getDD_CHQ_NBR() {
        return DD_CHQ_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DD_CHQ_NBR
     *
     * @param DD_CHQ_NBR the value for TFS_MULTI_ACC.DD_CHQ_NBR
     */
    public void setDD_CHQ_NBR(BigDecimal DD_CHQ_NBR) {
        this.DD_CHQ_NBR = DD_CHQ_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DD_PRINTED
     *
     * @return the value of TFS_MULTI_ACC.DD_PRINTED
     */
    public String getDD_PRINTED() {
        return DD_PRINTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DD_PRINTED
     *
     * @param DD_PRINTED the value for TFS_MULTI_ACC.DD_PRINTED
     */
    public void setDD_PRINTED(String DD_PRINTED) {
        this.DD_PRINTED = DD_PRINTED == null ? null : DD_PRINTED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.FC_SUSPENSE
     *
     * @return the value of TFS_MULTI_ACC.FC_SUSPENSE
     */
    public BigDecimal getFC_SUSPENSE() {
        return FC_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.FC_SUSPENSE
     *
     * @param FC_SUSPENSE the value for TFS_MULTI_ACC.FC_SUSPENSE
     */
    public void setFC_SUSPENSE(BigDecimal FC_SUSPENSE) {
        this.FC_SUSPENSE = FC_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CV_SUSPENSE
     *
     * @return the value of TFS_MULTI_ACC.CV_SUSPENSE
     */
    public BigDecimal getCV_SUSPENSE() {
        return CV_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CV_SUSPENSE
     *
     * @param CV_SUSPENSE the value for TFS_MULTI_ACC.CV_SUSPENSE
     */
    public void setCV_SUSPENSE(BigDecimal CV_SUSPENSE) {
        this.CV_SUSPENSE = CV_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.SUSPENSE_RATE
     *
     * @return the value of TFS_MULTI_ACC.SUSPENSE_RATE
     */
    public BigDecimal getSUSPENSE_RATE() {
        return SUSPENSE_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.SUSPENSE_RATE
     *
     * @param SUSPENSE_RATE the value for TFS_MULTI_ACC.SUSPENSE_RATE
     */
    public void setSUSPENSE_RATE(BigDecimal SUSPENSE_RATE) {
        this.SUSPENSE_RATE = SUSPENSE_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.FC_WITHDRAW
     *
     * @return the value of TFS_MULTI_ACC.FC_WITHDRAW
     */
    public BigDecimal getFC_WITHDRAW() {
        return FC_WITHDRAW;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.FC_WITHDRAW
     *
     * @param FC_WITHDRAW the value for TFS_MULTI_ACC.FC_WITHDRAW
     */
    public void setFC_WITHDRAW(BigDecimal FC_WITHDRAW) {
        this.FC_WITHDRAW = FC_WITHDRAW;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CV_WITHDRAW
     *
     * @return the value of TFS_MULTI_ACC.CV_WITHDRAW
     */
    public BigDecimal getCV_WITHDRAW() {
        return CV_WITHDRAW;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CV_WITHDRAW
     *
     * @param CV_WITHDRAW the value for TFS_MULTI_ACC.CV_WITHDRAW
     */
    public void setCV_WITHDRAW(BigDecimal CV_WITHDRAW) {
        this.CV_WITHDRAW = CV_WITHDRAW;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.WITHDRAW_RATE
     *
     * @return the value of TFS_MULTI_ACC.WITHDRAW_RATE
     */
    public BigDecimal getWITHDRAW_RATE() {
        return WITHDRAW_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.WITHDRAW_RATE
     *
     * @param WITHDRAW_RATE the value for TFS_MULTI_ACC.WITHDRAW_RATE
     */
    public void setWITHDRAW_RATE(BigDecimal WITHDRAW_RATE) {
        this.WITHDRAW_RATE = WITHDRAW_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.FC_MARGIN
     *
     * @return the value of TFS_MULTI_ACC.FC_MARGIN
     */
    public BigDecimal getFC_MARGIN() {
        return FC_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.FC_MARGIN
     *
     * @param FC_MARGIN the value for TFS_MULTI_ACC.FC_MARGIN
     */
    public void setFC_MARGIN(BigDecimal FC_MARGIN) {
        this.FC_MARGIN = FC_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CV_MARGIN
     *
     * @return the value of TFS_MULTI_ACC.CV_MARGIN
     */
    public BigDecimal getCV_MARGIN() {
        return CV_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CV_MARGIN
     *
     * @param CV_MARGIN the value for TFS_MULTI_ACC.CV_MARGIN
     */
    public void setCV_MARGIN(BigDecimal CV_MARGIN) {
        this.CV_MARGIN = CV_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.MARGIN_RATE
     *
     * @return the value of TFS_MULTI_ACC.MARGIN_RATE
     */
    public BigDecimal getMARGIN_RATE() {
        return MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.MARGIN_RATE
     *
     * @param MARGIN_RATE the value for TFS_MULTI_ACC.MARGIN_RATE
     */
    public void setMARGIN_RATE(BigDecimal MARGIN_RATE) {
        this.MARGIN_RATE = MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.FC_NOSTRO
     *
     * @return the value of TFS_MULTI_ACC.FC_NOSTRO
     */
    public BigDecimal getFC_NOSTRO() {
        return FC_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.FC_NOSTRO
     *
     * @param FC_NOSTRO the value for TFS_MULTI_ACC.FC_NOSTRO
     */
    public void setFC_NOSTRO(BigDecimal FC_NOSTRO) {
        this.FC_NOSTRO = FC_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CV_NOSTRO
     *
     * @return the value of TFS_MULTI_ACC.CV_NOSTRO
     */
    public BigDecimal getCV_NOSTRO() {
        return CV_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CV_NOSTRO
     *
     * @param CV_NOSTRO the value for TFS_MULTI_ACC.CV_NOSTRO
     */
    public void setCV_NOSTRO(BigDecimal CV_NOSTRO) {
        this.CV_NOSTRO = CV_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.NOSTRO_RATE
     *
     * @return the value of TFS_MULTI_ACC.NOSTRO_RATE
     */
    public BigDecimal getNOSTRO_RATE() {
        return NOSTRO_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.NOSTRO_RATE
     *
     * @param NOSTRO_RATE the value for TFS_MULTI_ACC.NOSTRO_RATE
     */
    public void setNOSTRO_RATE(BigDecimal NOSTRO_RATE) {
        this.NOSTRO_RATE = NOSTRO_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.FC_MARGIN_1
     *
     * @return the value of TFS_MULTI_ACC.FC_MARGIN_1
     */
    public BigDecimal getFC_MARGIN_1() {
        return FC_MARGIN_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.FC_MARGIN_1
     *
     * @param FC_MARGIN_1 the value for TFS_MULTI_ACC.FC_MARGIN_1
     */
    public void setFC_MARGIN_1(BigDecimal FC_MARGIN_1) {
        this.FC_MARGIN_1 = FC_MARGIN_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CV_MARGIN_1
     *
     * @return the value of TFS_MULTI_ACC.CV_MARGIN_1
     */
    public BigDecimal getCV_MARGIN_1() {
        return CV_MARGIN_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CV_MARGIN_1
     *
     * @param CV_MARGIN_1 the value for TFS_MULTI_ACC.CV_MARGIN_1
     */
    public void setCV_MARGIN_1(BigDecimal CV_MARGIN_1) {
        this.CV_MARGIN_1 = CV_MARGIN_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.MARGIN_RATE_1
     *
     * @return the value of TFS_MULTI_ACC.MARGIN_RATE_1
     */
    public BigDecimal getMARGIN_RATE_1() {
        return MARGIN_RATE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.MARGIN_RATE_1
     *
     * @param MARGIN_RATE_1 the value for TFS_MULTI_ACC.MARGIN_RATE_1
     */
    public void setMARGIN_RATE_1(BigDecimal MARGIN_RATE_1) {
        this.MARGIN_RATE_1 = MARGIN_RATE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.USE_SUSPENSE
     *
     * @return the value of TFS_MULTI_ACC.USE_SUSPENSE
     */
    public String getUSE_SUSPENSE() {
        return USE_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.USE_SUSPENSE
     *
     * @param USE_SUSPENSE the value for TFS_MULTI_ACC.USE_SUSPENSE
     */
    public void setUSE_SUSPENSE(String USE_SUSPENSE) {
        this.USE_SUSPENSE = USE_SUSPENSE == null ? null : USE_SUSPENSE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_MULT_DIV
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_MULT_DIV
     */
    public String getCLIENT_MULT_DIV() {
        return CLIENT_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_MULT_DIV
     *
     * @param CLIENT_MULT_DIV the value for TFS_MULTI_ACC.CLIENT_MULT_DIV
     */
    public void setCLIENT_MULT_DIV(String CLIENT_MULT_DIV) {
        this.CLIENT_MULT_DIV = CLIENT_MULT_DIV == null ? null : CLIENT_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.CLIENT_UNIT
     *
     * @return the value of TFS_MULTI_ACC.CLIENT_UNIT
     */
    public BigDecimal getCLIENT_UNIT() {
        return CLIENT_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.CLIENT_UNIT
     *
     * @param CLIENT_UNIT the value for TFS_MULTI_ACC.CLIENT_UNIT
     */
    public void setCLIENT_UNIT(BigDecimal CLIENT_UNIT) {
        this.CLIENT_UNIT = CLIENT_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.ORIGINAL_FC_NOSTRO
     *
     * @return the value of TFS_MULTI_ACC.ORIGINAL_FC_NOSTRO
     */
    public BigDecimal getORIGINAL_FC_NOSTRO() {
        return ORIGINAL_FC_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.ORIGINAL_FC_NOSTRO
     *
     * @param ORIGINAL_FC_NOSTRO the value for TFS_MULTI_ACC.ORIGINAL_FC_NOSTRO
     */
    public void setORIGINAL_FC_NOSTRO(BigDecimal ORIGINAL_FC_NOSTRO) {
        this.ORIGINAL_FC_NOSTRO = ORIGINAL_FC_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.ORIGINAL_CV_NOSTRO
     *
     * @return the value of TFS_MULTI_ACC.ORIGINAL_CV_NOSTRO
     */
    public BigDecimal getORIGINAL_CV_NOSTRO() {
        return ORIGINAL_CV_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.ORIGINAL_CV_NOSTRO
     *
     * @param ORIGINAL_CV_NOSTRO the value for TFS_MULTI_ACC.ORIGINAL_CV_NOSTRO
     */
    public void setORIGINAL_CV_NOSTRO(BigDecimal ORIGINAL_CV_NOSTRO) {
        this.ORIGINAL_CV_NOSTRO = ORIGINAL_CV_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_RATE
     *
     * @return the value of TFS_MULTI_ACC.ORIGINAL_NOSTRO_RATE
     */
    public BigDecimal getORIGINAL_NOSTRO_RATE() {
        return ORIGINAL_NOSTRO_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_RATE
     *
     * @param ORIGINAL_NOSTRO_RATE the value for TFS_MULTI_ACC.ORIGINAL_NOSTRO_RATE
     */
    public void setORIGINAL_NOSTRO_RATE(BigDecimal ORIGINAL_NOSTRO_RATE) {
        this.ORIGINAL_NOSTRO_RATE = ORIGINAL_NOSTRO_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_CY
     *
     * @return the value of TFS_MULTI_ACC.ORIGINAL_NOSTRO_CY
     */
    public BigDecimal getORIGINAL_NOSTRO_CY() {
        return ORIGINAL_NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.ORIGINAL_NOSTRO_CY
     *
     * @param ORIGINAL_NOSTRO_CY the value for TFS_MULTI_ACC.ORIGINAL_NOSTRO_CY
     */
    public void setORIGINAL_NOSTRO_CY(BigDecimal ORIGINAL_NOSTRO_CY) {
        this.ORIGINAL_NOSTRO_CY = ORIGINAL_NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.VISIBLE_CV
     *
     * @return the value of TFS_MULTI_ACC.VISIBLE_CV
     */
    public String getVISIBLE_CV() {
        return VISIBLE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.VISIBLE_CV
     *
     * @param VISIBLE_CV the value for TFS_MULTI_ACC.VISIBLE_CV
     */
    public void setVISIBLE_CV(String VISIBLE_CV) {
        this.VISIBLE_CV = VISIBLE_CV == null ? null : VISIBLE_CV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.BRIDGING_ACC
     *
     * @return the value of TFS_MULTI_ACC.BRIDGING_ACC
     */
    public String getBRIDGING_ACC() {
        return BRIDGING_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.BRIDGING_ACC
     *
     * @param BRIDGING_ACC the value for TFS_MULTI_ACC.BRIDGING_ACC
     */
    public void setBRIDGING_ACC(String BRIDGING_ACC) {
        this.BRIDGING_ACC = BRIDGING_ACC == null ? null : BRIDGING_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DEAL_SERIAL_NO
     *
     * @return the value of TFS_MULTI_ACC.DEAL_SERIAL_NO
     */
    public BigDecimal getDEAL_SERIAL_NO() {
        return DEAL_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DEAL_SERIAL_NO
     *
     * @param DEAL_SERIAL_NO the value for TFS_MULTI_ACC.DEAL_SERIAL_NO
     */
    public void setDEAL_SERIAL_NO(BigDecimal DEAL_SERIAL_NO) {
        this.DEAL_SERIAL_NO = DEAL_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DEAL_BR
     *
     * @return the value of TFS_MULTI_ACC.DEAL_BR
     */
    public BigDecimal getDEAL_BR() {
        return DEAL_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DEAL_BR
     *
     * @param DEAL_BR the value for TFS_MULTI_ACC.DEAL_BR
     */
    public void setDEAL_BR(BigDecimal DEAL_BR) {
        this.DEAL_BR = DEAL_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_MULTI_ACC.DEALER_NAME
     *
     * @return the value of TFS_MULTI_ACC.DEALER_NAME
     */
    public String getDEALER_NAME() {
        return DEALER_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_MULTI_ACC.DEALER_NAME
     *
     * @param DEALER_NAME the value for TFS_MULTI_ACC.DEALER_NAME
     */
    public void setDEALER_NAME(String DEALER_NAME) {
        this.DEALER_NAME = DEALER_NAME == null ? null : DEALER_NAME.trim();
    }

    public BigDecimal getHOF_TRS_NO()
    {
        return HOF_TRS_NO;
    }

    public void setHOF_TRS_NO(BigDecimal hOF_TRS_NO)
    {
        HOF_TRS_NO = hOF_TRS_NO;
    }
}