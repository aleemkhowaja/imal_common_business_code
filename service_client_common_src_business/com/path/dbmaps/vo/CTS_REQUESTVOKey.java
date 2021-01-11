package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_REQUESTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_REQUEST.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column CTS_REQUEST.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_REQUEST.REQ_NO
     */
    private BigDecimal REQ_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_REQUEST.BRANCH
     *
     * @return the value of CTS_REQUEST.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_REQUEST.BRANCH
     *
     * @param BRANCH the value for CTS_REQUEST.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_REQUEST.COMP_CODE
     *
     * @return the value of CTS_REQUEST.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_REQUEST.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_REQUEST.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_REQUEST.REQ_NO
     *
     * @return the value of CTS_REQUEST.REQ_NO
     */
    public BigDecimal getREQ_NO() {
        return REQ_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_REQUEST.REQ_NO
     *
     * @param REQ_NO the value for CTS_REQUEST.REQ_NO
     */
    public void setREQ_NO(BigDecimal REQ_NO) {
        this.REQ_NO = REQ_NO;
    }
}