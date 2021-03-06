package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_EXCH_OFFICE_AUTHVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_EXCH_OFFICE_AUTH.AUTH_NO
     */
    private BigDecimal AUTH_NO;

    /**
     * This field corresponds to the database column CTS_EXCH_OFFICE_AUTH.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_EXCH_OFFICE_AUTH.AUTH_NO
     *
     * @return the value of CTS_EXCH_OFFICE_AUTH.AUTH_NO
     */
    public BigDecimal getAUTH_NO() {
        return AUTH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_EXCH_OFFICE_AUTH.AUTH_NO
     *
     * @param AUTH_NO the value for CTS_EXCH_OFFICE_AUTH.AUTH_NO
     */
    public void setAUTH_NO(BigDecimal AUTH_NO) {
        this.AUTH_NO = AUTH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_EXCH_OFFICE_AUTH.COMP_CODE
     *
     * @return the value of CTS_EXCH_OFFICE_AUTH.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_EXCH_OFFICE_AUTH.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_EXCH_OFFICE_AUTH.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}