package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_ADD_FIELDSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_ADD_FIELDS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTS_ADD_FIELDS.COLUMN_NUMBER
     */
    private BigDecimal COLUMN_NUMBER;

    /**
     * This field corresponds to the database column CTS_ADD_FIELDS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_ADD_FIELDS.CODE
     *
     * @return the value of CTS_ADD_FIELDS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_ADD_FIELDS.CODE
     *
     * @param CODE the value for CTS_ADD_FIELDS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_ADD_FIELDS.COLUMN_NUMBER
     *
     * @return the value of CTS_ADD_FIELDS.COLUMN_NUMBER
     */
    public BigDecimal getCOLUMN_NUMBER() {
        return COLUMN_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_ADD_FIELDS.COLUMN_NUMBER
     *
     * @param COLUMN_NUMBER the value for CTS_ADD_FIELDS.COLUMN_NUMBER
     */
    public void setCOLUMN_NUMBER(BigDecimal COLUMN_NUMBER) {
        this.COLUMN_NUMBER = COLUMN_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_ADD_FIELDS.COMP_CODE
     *
     * @return the value of CTS_ADD_FIELDS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_ADD_FIELDS.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_ADD_FIELDS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}