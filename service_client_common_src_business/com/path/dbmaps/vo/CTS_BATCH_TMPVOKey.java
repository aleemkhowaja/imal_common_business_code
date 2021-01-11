package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_BATCH_TMPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_BATCH_TMP.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_BATCH_TMP.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTS_BATCH_TMP.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_BATCH_TMP.OPERATION_TYPE
     */
    private String OPERATION_TYPE;

    /**
     * This field corresponds to the database column CTS_BATCH_TMP.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BATCH_TMP.BRANCH_CODE
     *
     * @return the value of CTS_BATCH_TMP.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BATCH_TMP.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTS_BATCH_TMP.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BATCH_TMP.CODE
     *
     * @return the value of CTS_BATCH_TMP.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BATCH_TMP.CODE
     *
     * @param CODE the value for CTS_BATCH_TMP.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BATCH_TMP.COMP_CODE
     *
     * @return the value of CTS_BATCH_TMP.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BATCH_TMP.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_BATCH_TMP.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BATCH_TMP.OPERATION_TYPE
     *
     * @return the value of CTS_BATCH_TMP.OPERATION_TYPE
     */
    public String getOPERATION_TYPE() {
        return OPERATION_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BATCH_TMP.OPERATION_TYPE
     *
     * @param OPERATION_TYPE the value for CTS_BATCH_TMP.OPERATION_TYPE
     */
    public void setOPERATION_TYPE(String OPERATION_TYPE) {
        this.OPERATION_TYPE = OPERATION_TYPE == null ? null : OPERATION_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BATCH_TMP.USER_ID
     *
     * @return the value of CTS_BATCH_TMP.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BATCH_TMP.USER_ID
     *
     * @param USER_ID the value for CTS_BATCH_TMP.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}