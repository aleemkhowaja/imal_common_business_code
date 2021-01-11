package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSTELLER_AXSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTELLER_AXS.ACCESS_CODE
     */
    private BigDecimal ACCESS_CODE;

    /**
     * This field corresponds to the database column CTSTELLER_AXS.ACCESS_TYPE
     */
    private String ACCESS_TYPE;

    /**
     * This field corresponds to the database column CTSTELLER_AXS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSTELLER_AXS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTELLER_AXS.TELLER_CODE
     */
    private BigDecimal TELLER_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLER_AXS.ACCESS_CODE
     *
     * @return the value of CTSTELLER_AXS.ACCESS_CODE
     */
    public BigDecimal getACCESS_CODE() {
        return ACCESS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLER_AXS.ACCESS_CODE
     *
     * @param ACCESS_CODE the value for CTSTELLER_AXS.ACCESS_CODE
     */
    public void setACCESS_CODE(BigDecimal ACCESS_CODE) {
        this.ACCESS_CODE = ACCESS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLER_AXS.ACCESS_TYPE
     *
     * @return the value of CTSTELLER_AXS.ACCESS_TYPE
     */
    public String getACCESS_TYPE() {
        return ACCESS_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLER_AXS.ACCESS_TYPE
     *
     * @param ACCESS_TYPE the value for CTSTELLER_AXS.ACCESS_TYPE
     */
    public void setACCESS_TYPE(String ACCESS_TYPE) {
        this.ACCESS_TYPE = ACCESS_TYPE == null ? null : ACCESS_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLER_AXS.BRANCH_CODE
     *
     * @return the value of CTSTELLER_AXS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLER_AXS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSTELLER_AXS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLER_AXS.COMP_CODE
     *
     * @return the value of CTSTELLER_AXS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLER_AXS.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTELLER_AXS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLER_AXS.TELLER_CODE
     *
     * @return the value of CTSTELLER_AXS.TELLER_CODE
     */
    public BigDecimal getTELLER_CODE() {
        return TELLER_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLER_AXS.TELLER_CODE
     *
     * @param TELLER_CODE the value for CTSTELLER_AXS.TELLER_CODE
     */
    public void setTELLER_CODE(BigDecimal TELLER_CODE) {
        this.TELLER_CODE = TELLER_CODE;
    }
}