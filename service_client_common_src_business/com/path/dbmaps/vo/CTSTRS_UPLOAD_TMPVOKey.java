package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSTRS_UPLOAD_TMPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTRS_UPLOAD_TMP.BATCH_NO
     */
    private BigDecimal BATCH_NO;

    /**
     * This field corresponds to the database column CTSTRS_UPLOAD_TMP.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSTRS_UPLOAD_TMP.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTRS_UPLOAD_TMP.SERIAL_NO
     */
    private BigDecimal SERIAL_NO;

    /**
     * This field corresponds to the database column CTSTRS_UPLOAD_TMP.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_UPLOAD_TMP.BATCH_NO
     *
     * @return the value of CTSTRS_UPLOAD_TMP.BATCH_NO
     */
    public BigDecimal getBATCH_NO() {
        return BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_UPLOAD_TMP.BATCH_NO
     *
     * @param BATCH_NO the value for CTSTRS_UPLOAD_TMP.BATCH_NO
     */
    public void setBATCH_NO(BigDecimal BATCH_NO) {
        this.BATCH_NO = BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_UPLOAD_TMP.BRANCH_CODE
     *
     * @return the value of CTSTRS_UPLOAD_TMP.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_UPLOAD_TMP.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSTRS_UPLOAD_TMP.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_UPLOAD_TMP.COMP_CODE
     *
     * @return the value of CTSTRS_UPLOAD_TMP.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_UPLOAD_TMP.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTRS_UPLOAD_TMP.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_UPLOAD_TMP.SERIAL_NO
     *
     * @return the value of CTSTRS_UPLOAD_TMP.SERIAL_NO
     */
    public BigDecimal getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_UPLOAD_TMP.SERIAL_NO
     *
     * @param SERIAL_NO the value for CTSTRS_UPLOAD_TMP.SERIAL_NO
     */
    public void setSERIAL_NO(BigDecimal SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_UPLOAD_TMP.USER_ID
     *
     * @return the value of CTSTRS_UPLOAD_TMP.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_UPLOAD_TMP.USER_ID
     *
     * @param USER_ID the value for CTSTRS_UPLOAD_TMP.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}