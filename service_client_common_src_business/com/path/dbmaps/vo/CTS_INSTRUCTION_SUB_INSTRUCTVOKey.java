package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_INSTRUCTION_SUB_INSTRUCTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_INSTRUCTION_SUB_INSTRUCT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_INSTRUCTION_SUB_INSTRUCT.INSTRUCTION_CODE
     */
    private BigDecimal INSTRUCTION_CODE;

    /**
     * This field corresponds to the database column CTS_INSTRUCTION_SUB_INSTRUCT.SUB_INSTRUCTION_CODE
     */
    private BigDecimal SUB_INSTRUCTION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.COMP_CODE
     *
     * @return the value of CTS_INSTRUCTION_SUB_INSTRUCT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_INSTRUCTION_SUB_INSTRUCT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.INSTRUCTION_CODE
     *
     * @return the value of CTS_INSTRUCTION_SUB_INSTRUCT.INSTRUCTION_CODE
     */
    public BigDecimal getINSTRUCTION_CODE() {
        return INSTRUCTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.INSTRUCTION_CODE
     *
     * @param INSTRUCTION_CODE the value for CTS_INSTRUCTION_SUB_INSTRUCT.INSTRUCTION_CODE
     */
    public void setINSTRUCTION_CODE(BigDecimal INSTRUCTION_CODE) {
        this.INSTRUCTION_CODE = INSTRUCTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.SUB_INSTRUCTION_CODE
     *
     * @return the value of CTS_INSTRUCTION_SUB_INSTRUCT.SUB_INSTRUCTION_CODE
     */
    public BigDecimal getSUB_INSTRUCTION_CODE() {
        return SUB_INSTRUCTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INSTRUCTION_SUB_INSTRUCT.SUB_INSTRUCTION_CODE
     *
     * @param SUB_INSTRUCTION_CODE the value for CTS_INSTRUCTION_SUB_INSTRUCT.SUB_INSTRUCTION_CODE
     */
    public void setSUB_INSTRUCTION_CODE(BigDecimal SUB_INSTRUCTION_CODE) {
        this.SUB_INSTRUCTION_CODE = SUB_INSTRUCTION_CODE;
    }
}