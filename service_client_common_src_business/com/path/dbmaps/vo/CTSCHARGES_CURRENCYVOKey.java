package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSCHARGES_CURRENCYVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSCHARGES_CURRENCY.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column CTSCHARGES_CURRENCY.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSCHARGES_CURRENCY.CY_CODE
     */
    private BigDecimal CY_CODE;

    /**
     * This field corresponds to the database column CTSCHARGES_CURRENCY.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES_CURRENCY.CHARGE_CODE
     *
     * @return the value of CTSCHARGES_CURRENCY.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES_CURRENCY.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for CTSCHARGES_CURRENCY.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES_CURRENCY.COMP_CODE
     *
     * @return the value of CTSCHARGES_CURRENCY.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES_CURRENCY.COMP_CODE
     *
     * @param COMP_CODE the value for CTSCHARGES_CURRENCY.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES_CURRENCY.CY_CODE
     *
     * @return the value of CTSCHARGES_CURRENCY.CY_CODE
     */
    public BigDecimal getCY_CODE() {
        return CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES_CURRENCY.CY_CODE
     *
     * @param CY_CODE the value for CTSCHARGES_CURRENCY.CY_CODE
     */
    public void setCY_CODE(BigDecimal CY_CODE) {
        this.CY_CODE = CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCHARGES_CURRENCY.LINE_NO
     *
     * @return the value of CTSCHARGES_CURRENCY.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCHARGES_CURRENCY.LINE_NO
     *
     * @param LINE_NO the value for CTSCHARGES_CURRENCY.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}