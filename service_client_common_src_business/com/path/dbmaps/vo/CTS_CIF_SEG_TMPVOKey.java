package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_CIF_SEG_TMPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.CRITERIA_CODE
     */
    private BigDecimal CRITERIA_CODE;

    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.SEGMENT_CODE
     */
    private BigDecimal SEGMENT_CODE;

    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.SEGMENT_TYPE
     */
    private String SEGMENT_TYPE;

    /**
     * This field corresponds to the database column CTS_CIF_SEG_TMP.SELECT_CRITERIA
     */
    private String SELECT_CRITERIA;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.CIF_NO
     *
     * @return the value of CTS_CIF_SEG_TMP.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.CIF_NO
     *
     * @param CIF_NO the value for CTS_CIF_SEG_TMP.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.CREATED_BY
     *
     * @return the value of CTS_CIF_SEG_TMP.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.CREATED_BY
     *
     * @param CREATED_BY the value for CTS_CIF_SEG_TMP.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.CRITERIA_CODE
     *
     * @return the value of CTS_CIF_SEG_TMP.CRITERIA_CODE
     */
    public BigDecimal getCRITERIA_CODE() {
        return CRITERIA_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.CRITERIA_CODE
     *
     * @param CRITERIA_CODE the value for CTS_CIF_SEG_TMP.CRITERIA_CODE
     */
    public void setCRITERIA_CODE(BigDecimal CRITERIA_CODE) {
        this.CRITERIA_CODE = CRITERIA_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.SEGMENT_CODE
     *
     * @return the value of CTS_CIF_SEG_TMP.SEGMENT_CODE
     */
    public BigDecimal getSEGMENT_CODE() {
        return SEGMENT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.SEGMENT_CODE
     *
     * @param SEGMENT_CODE the value for CTS_CIF_SEG_TMP.SEGMENT_CODE
     */
    public void setSEGMENT_CODE(BigDecimal SEGMENT_CODE) {
        this.SEGMENT_CODE = SEGMENT_CODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.SEGMENT_TYPE
     *
     * @return the value of CTS_CIF_SEG_TMP.SEGMENT_TYPE
     */
    public String getSEGMENT_TYPE() {
        return SEGMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.SEGMENT_TYPE
     *
     * @param SEGMENT_TYPE the value for CTS_CIF_SEG_TMP.SEGMENT_TYPE
     */
    public void setSEGMENT_TYPE(String SEGMENT_TYPE) {
        this.SEGMENT_TYPE = SEGMENT_TYPE == null ? null : SEGMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_SEG_TMP.SELECT_CRITERIA
     *
     * @return the value of CTS_CIF_SEG_TMP.SELECT_CRITERIA
     */
    public String getSELECT_CRITERIA() {
        return SELECT_CRITERIA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_SEG_TMP.SELECT_CRITERIA
     *
     * @param SELECT_CRITERIA the value for CTS_CIF_SEG_TMP.SELECT_CRITERIA
     */
    public void setSELECT_CRITERIA(String SELECT_CRITERIA) {
        this.SELECT_CRITERIA = SELECT_CRITERIA == null ? null : SELECT_CRITERIA.trim();
    }
}