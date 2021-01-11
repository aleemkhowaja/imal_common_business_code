package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSTRXTYPE_REMITVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTRXTYPE_REMIT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTRXTYPE_REMIT.REMIT_TYPE_CODE
     */
    private BigDecimal REMIT_TYPE_CODE;

    /**
     * This field corresponds to the database column CTSTRXTYPE_REMIT.TRXTYPE_CODE
     */
    private BigDecimal TRXTYPE_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_REMIT.COMP_CODE
     *
     * @return the value of CTSTRXTYPE_REMIT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_REMIT.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTRXTYPE_REMIT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_REMIT.REMIT_TYPE_CODE
     *
     * @return the value of CTSTRXTYPE_REMIT.REMIT_TYPE_CODE
     */
    public BigDecimal getREMIT_TYPE_CODE() {
        return REMIT_TYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_REMIT.REMIT_TYPE_CODE
     *
     * @param REMIT_TYPE_CODE the value for CTSTRXTYPE_REMIT.REMIT_TYPE_CODE
     */
    public void setREMIT_TYPE_CODE(BigDecimal REMIT_TYPE_CODE) {
        this.REMIT_TYPE_CODE = REMIT_TYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_REMIT.TRXTYPE_CODE
     *
     * @return the value of CTSTRXTYPE_REMIT.TRXTYPE_CODE
     */
    public BigDecimal getTRXTYPE_CODE() {
        return TRXTYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_REMIT.TRXTYPE_CODE
     *
     * @param TRXTYPE_CODE the value for CTSTRXTYPE_REMIT.TRXTYPE_CODE
     */
    public void setTRXTYPE_CODE(BigDecimal TRXTYPE_CODE) {
        this.TRXTYPE_CODE = TRXTYPE_CODE;
    }
}