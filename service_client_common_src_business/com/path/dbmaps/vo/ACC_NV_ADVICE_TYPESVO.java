package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class ACC_NV_ADVICE_TYPESVO extends ACC_NV_ADVICE_TYPESVOKey {
    /**
     * This field corresponds to the database column ACC_NV_ADVICE_TYPES.ACCOUNT_TYPE
     */
    private BigDecimal ACCOUNT_TYPE;

    /**
     * This field corresponds to the database column ACC_NV_ADVICE_TYPES.CIF_TYPE
     */
    private BigDecimal CIF_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_NV_ADVICE_TYPES.ACCOUNT_TYPE
     *
     * @return the value of ACC_NV_ADVICE_TYPES.ACCOUNT_TYPE
     */
    public BigDecimal getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_NV_ADVICE_TYPES.ACCOUNT_TYPE
     *
     * @param ACCOUNT_TYPE the value for ACC_NV_ADVICE_TYPES.ACCOUNT_TYPE
     */
    public void setACCOUNT_TYPE(BigDecimal ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_NV_ADVICE_TYPES.CIF_TYPE
     *
     * @return the value of ACC_NV_ADVICE_TYPES.CIF_TYPE
     */
    public BigDecimal getCIF_TYPE() {
        return CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_NV_ADVICE_TYPES.CIF_TYPE
     *
     * @param CIF_TYPE the value for ACC_NV_ADVICE_TYPES.CIF_TYPE
     */
    public void setCIF_TYPE(BigDecimal CIF_TYPE) {
        this.CIF_TYPE = CIF_TYPE;
    }
}