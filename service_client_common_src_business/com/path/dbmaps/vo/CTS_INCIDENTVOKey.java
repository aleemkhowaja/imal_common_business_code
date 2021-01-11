package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_INCIDENTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_INCIDENT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_INCIDENT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_INCIDENT.INCD_CODE
     */
    private BigDecimal INCD_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INCIDENT.BRANCH_CODE
     *
     * @return the value of CTS_INCIDENT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INCIDENT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTS_INCIDENT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INCIDENT.COMP_CODE
     *
     * @return the value of CTS_INCIDENT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INCIDENT.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_INCIDENT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INCIDENT.INCD_CODE
     *
     * @return the value of CTS_INCIDENT.INCD_CODE
     */
    public BigDecimal getINCD_CODE() {
        return INCD_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INCIDENT.INCD_CODE
     *
     * @param INCD_CODE the value for CTS_INCIDENT.INCD_CODE
     */
    public void setINCD_CODE(BigDecimal INCD_CODE) {
        this.INCD_CODE = INCD_CODE;
    }
}