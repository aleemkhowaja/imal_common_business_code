package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_TRSFR_ACC_CRITERIAVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_CRITERIA.BATCH_NO
     */
    private BigDecimal BATCH_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_CRITERIA.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_CRITERIA.CRITERIA_LINE_NO
     */
    private BigDecimal CRITERIA_LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_CRITERIA.BATCH_NO
     *
     * @return the value of CTS_TRSFR_ACC_CRITERIA.BATCH_NO
     */
    public BigDecimal getBATCH_NO() {
        return BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_CRITERIA.BATCH_NO
     *
     * @param BATCH_NO the value for CTS_TRSFR_ACC_CRITERIA.BATCH_NO
     */
    public void setBATCH_NO(BigDecimal BATCH_NO) {
        this.BATCH_NO = BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_CRITERIA.COMP_CODE
     *
     * @return the value of CTS_TRSFR_ACC_CRITERIA.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_CRITERIA.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_TRSFR_ACC_CRITERIA.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_CRITERIA.CRITERIA_LINE_NO
     *
     * @return the value of CTS_TRSFR_ACC_CRITERIA.CRITERIA_LINE_NO
     */
    public BigDecimal getCRITERIA_LINE_NO() {
        return CRITERIA_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_CRITERIA.CRITERIA_LINE_NO
     *
     * @param CRITERIA_LINE_NO the value for CTS_TRSFR_ACC_CRITERIA.CRITERIA_LINE_NO
     */
    public void setCRITERIA_LINE_NO(BigDecimal CRITERIA_LINE_NO) {
        this.CRITERIA_LINE_NO = CRITERIA_LINE_NO;
    }
}