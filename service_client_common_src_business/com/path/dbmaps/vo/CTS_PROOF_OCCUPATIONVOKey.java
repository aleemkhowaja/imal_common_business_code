package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_PROOF_OCCUPATIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_PROOF_OCCUPATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_PROOF_OCCUPATION.PROOF_OCCUPATION_CODE
     */
    private BigDecimal PROOF_OCCUPATION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PROOF_OCCUPATION.COMP_CODE
     *
     * @return the value of CTS_PROOF_OCCUPATION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PROOF_OCCUPATION.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_PROOF_OCCUPATION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PROOF_OCCUPATION.PROOF_OCCUPATION_CODE
     *
     * @return the value of CTS_PROOF_OCCUPATION.PROOF_OCCUPATION_CODE
     */
    public BigDecimal getPROOF_OCCUPATION_CODE() {
        return PROOF_OCCUPATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PROOF_OCCUPATION.PROOF_OCCUPATION_CODE
     *
     * @param PROOF_OCCUPATION_CODE the value for CTS_PROOF_OCCUPATION.PROOF_OCCUPATION_CODE
     */
    public void setPROOF_OCCUPATION_CODE(BigDecimal PROOF_OCCUPATION_CODE) {
        this.PROOF_OCCUPATION_CODE = PROOF_OCCUPATION_CODE;
    }
}