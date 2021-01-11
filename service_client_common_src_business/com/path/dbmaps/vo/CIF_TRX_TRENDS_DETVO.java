package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CIF_TRX_TRENDS_DETVO extends CIF_TRX_TRENDS_DETVOKey {
    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.CTSTRX_TYPE
     */
    private BigDecimal CTSTRX_TYPE;

    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.PERIODICITY_TYPE
     */
    private String PERIODICITY_TYPE;

    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.PERIODICITY
     */
    private BigDecimal PERIODICITY;
    
    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.SINGLE_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     * 
     */
    private BigDecimal SINGLE_TRX_AMT;

    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.TOTAL_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     */
    private BigDecimal TOTAL_TRX_AMT;

    /**
     * This field corresponds to the database column CIF_TRX_TRENDS_DET.CURRENCY_CODE
      */
     private BigDecimal CURRENCY_CODE;

    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_TRENDS_DET.CTSTRX_TYPE
     *
     * @return the value of CIF_TRX_TRENDS_DET.CTSTRX_TYPE
     */
    public BigDecimal getCTSTRX_TYPE() {
        return CTSTRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.CTSTRX_TYPE
     *
     * @param CTSTRX_TYPE the value for CIF_TRX_TRENDS_DET.CTSTRX_TYPE
     */
    public void setCTSTRX_TYPE(BigDecimal CTSTRX_TYPE) {
        this.CTSTRX_TYPE = CTSTRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_TRENDS_DET.PERIODICITY_TYPE
     *
     * @return the value of CIF_TRX_TRENDS_DET.PERIODICITY_TYPE
     */
    public String getPERIODICITY_TYPE() {
        return PERIODICITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.PERIODICITY_TYPE
     *
     * @param PERIODICITY_TYPE the value for CIF_TRX_TRENDS_DET.PERIODICITY_TYPE
     */
    public void setPERIODICITY_TYPE(String PERIODICITY_TYPE) {
        this.PERIODICITY_TYPE = PERIODICITY_TYPE == null ? null : PERIODICITY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_TRENDS_DET.PERIODICITY
     *
     * @return the value of CIF_TRX_TRENDS_DET.PERIODICITY
     */
    public BigDecimal getPERIODICITY() {
        return PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.PERIODICITY
     *
     * @param PERIODICITY the value for CIF_TRX_TRENDS_DET.PERIODICITY
     */
    public void setPERIODICITY(BigDecimal PERIODICITY) {
        this.PERIODICITY = PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_TRENDS_DET.SINGLE_TRX_AMT
     *
     * @return the value of CIF_TRX_TRENDS_DET.SINGLE_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     */
    public BigDecimal getSINGLE_TRX_AMT() {
        return SINGLE_TRX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.SINGLE_TRX_AMT
     *
     * @param SINGLE_TRX_AMT the value for CIF_TRX_TRENDS_DET.SINGLE_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     */
    public void setSINGLE_TRX_AMT(BigDecimal SINGLE_TRX_AMT) {
        this.SINGLE_TRX_AMT = SINGLE_TRX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_TRENDS_DET.TOTAL_TRX_AMT
     *
     * @return the value of CIF_TRX_TRENDS_DET.TOTAL_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     */
    public BigDecimal getTOTAL_TRX_AMT() {
        return TOTAL_TRX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.TOTAL_TRX_AMT
     *
     * @param TOTAL_TRX_AMT the value for CIF_TRX_TRENDS_DET.TOTAL_TRX_AMT
     * Sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001
     */
    public void setTOTAL_TRX_AMT(BigDecimal TOTAL_TRX_AMT) {
        this.TOTAL_TRX_AMT = TOTAL_TRX_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.CURRENCY_CODE
     *
     * @param TOTAL_TRX_AMT the value for CIF_TRX_TRENDS_DET.CURRENCY_CODE
      */
    public BigDecimal getCURRENCY_CODE()
    {
        return CURRENCY_CODE;
    }

    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_TRENDS_DET.CURRENCY_CODE
     *
     * @param TOTAL_TRX_AMT the value for CIF_TRX_TRENDS_DET.CURRENCY_CODE
      */
    public void setCURRENCY_CODE(BigDecimal cURRENCY_CODE)
    {
        CURRENCY_CODE = cURRENCY_CODE;
    }
    
    
}