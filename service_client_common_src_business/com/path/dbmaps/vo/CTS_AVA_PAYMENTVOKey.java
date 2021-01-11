package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_AVA_PAYMENTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_AVA_PAYMENT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_AVA_PAYMENT.PAYMENT_CODE
     */
    private BigDecimal PAYMENT_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_AVA_PAYMENT.COMP_CODE
     *
     * @return the value of CTS_AVA_PAYMENT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_AVA_PAYMENT.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_AVA_PAYMENT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_AVA_PAYMENT.PAYMENT_CODE
     *
     * @return the value of CTS_AVA_PAYMENT.PAYMENT_CODE
     */
    public BigDecimal getPAYMENT_CODE() {
        return PAYMENT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_AVA_PAYMENT.PAYMENT_CODE
     *
     * @param PAYMENT_CODE the value for CTS_AVA_PAYMENT.PAYMENT_CODE
     */
    public void setPAYMENT_CODE(BigDecimal PAYMENT_CODE) {
        this.PAYMENT_CODE = PAYMENT_CODE;
    }
}