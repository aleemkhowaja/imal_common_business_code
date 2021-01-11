package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSTRS_CHARGES_DET_VOIDVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTRS_CHARGES_DET_VOID.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSTRS_CHARGES_DET_VOID.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column CTSTRS_CHARGES_DET_VOID.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTRS_CHARGES_DET_VOID.TRS_NO
     */
    private BigDecimal TRS_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_CHARGES_DET_VOID.BRANCH_CODE
     *
     * @return the value of CTSTRS_CHARGES_DET_VOID.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_CHARGES_DET_VOID.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSTRS_CHARGES_DET_VOID.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_CHARGES_DET_VOID.CHARGE_CODE
     *
     * @return the value of CTSTRS_CHARGES_DET_VOID.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_CHARGES_DET_VOID.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for CTSTRS_CHARGES_DET_VOID.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_CHARGES_DET_VOID.COMP_CODE
     *
     * @return the value of CTSTRS_CHARGES_DET_VOID.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_CHARGES_DET_VOID.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTRS_CHARGES_DET_VOID.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_CHARGES_DET_VOID.TRS_NO
     *
     * @return the value of CTSTRS_CHARGES_DET_VOID.TRS_NO
     */
    public BigDecimal getTRS_NO() {
        return TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_CHARGES_DET_VOID.TRS_NO
     *
     * @param TRS_NO the value for CTSTRS_CHARGES_DET_VOID.TRS_NO
     */
    public void setTRS_NO(BigDecimal TRS_NO) {
        this.TRS_NO = TRS_NO;
    }
}