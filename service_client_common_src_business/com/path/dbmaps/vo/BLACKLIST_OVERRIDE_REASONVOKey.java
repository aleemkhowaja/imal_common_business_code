package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class BLACKLIST_OVERRIDE_REASONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column BLACKLIST_OVERRIDE_REASON.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column BLACKLIST_OVERRIDE_REASON.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column BLACKLIST_OVERRIDE_REASON.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column BLACKLIST_OVERRIDE_REASON.PARENT_REF
     */
    private String PARENT_REF;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLACKLIST_OVERRIDE_REASON.APP_NAME
     *
     * @return the value of BLACKLIST_OVERRIDE_REASON.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLACKLIST_OVERRIDE_REASON.APP_NAME
     *
     * @param APP_NAME the value for BLACKLIST_OVERRIDE_REASON.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLACKLIST_OVERRIDE_REASON.COMP_CODE
     *
     * @return the value of BLACKLIST_OVERRIDE_REASON.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLACKLIST_OVERRIDE_REASON.COMP_CODE
     *
     * @param COMP_CODE the value for BLACKLIST_OVERRIDE_REASON.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLACKLIST_OVERRIDE_REASON.LINE_NO
     *
     * @return the value of BLACKLIST_OVERRIDE_REASON.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLACKLIST_OVERRIDE_REASON.LINE_NO
     *
     * @param LINE_NO the value for BLACKLIST_OVERRIDE_REASON.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLACKLIST_OVERRIDE_REASON.PARENT_REF
     *
     * @return the value of BLACKLIST_OVERRIDE_REASON.PARENT_REF
     */
    public String getPARENT_REF() {
        return PARENT_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLACKLIST_OVERRIDE_REASON.PARENT_REF
     *
     * @param PARENT_REF the value for BLACKLIST_OVERRIDE_REASON.PARENT_REF
     */
    public void setPARENT_REF(String PARENT_REF) {
        this.PARENT_REF = PARENT_REF == null ? null : PARENT_REF.trim();
    }
}