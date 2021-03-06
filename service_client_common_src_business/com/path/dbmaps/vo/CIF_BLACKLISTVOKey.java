package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CIF_BLACKLISTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CIF_BLACKLIST.BL_CODE
     */
    private BigDecimal BL_CODE;

    /**
     * This field corresponds to the database column CIF_BLACKLIST.BL_TYPE
     */
    private String BL_TYPE;

    /**
     * This field corresponds to the database column CIF_BLACKLIST.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CIF_BLACKLIST.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_BLACKLIST.BL_CODE
     *
     * @return the value of CIF_BLACKLIST.BL_CODE
     */
    public BigDecimal getBL_CODE() {
        return BL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_BLACKLIST.BL_CODE
     *
     * @param BL_CODE the value for CIF_BLACKLIST.BL_CODE
     */
    public void setBL_CODE(BigDecimal BL_CODE) {
        this.BL_CODE = BL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_BLACKLIST.BL_TYPE
     *
     * @return the value of CIF_BLACKLIST.BL_TYPE
     */
    public String getBL_TYPE() {
        return BL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_BLACKLIST.BL_TYPE
     *
     * @param BL_TYPE the value for CIF_BLACKLIST.BL_TYPE
     */
    public void setBL_TYPE(String BL_TYPE) {
        this.BL_TYPE = BL_TYPE == null ? null : BL_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_BLACKLIST.CIF_NO
     *
     * @return the value of CIF_BLACKLIST.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_BLACKLIST.CIF_NO
     *
     * @param CIF_NO the value for CIF_BLACKLIST.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_BLACKLIST.COMP_CODE
     *
     * @return the value of CIF_BLACKLIST.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_BLACKLIST.COMP_CODE
     *
     * @param COMP_CODE the value for CIF_BLACKLIST.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}