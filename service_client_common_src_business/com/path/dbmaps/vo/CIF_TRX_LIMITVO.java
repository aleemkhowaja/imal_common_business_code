package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CIF_TRX_LIMITVO extends CIF_TRX_LIMITVOKey {
    /**
     * This field corresponds to the database column CIF_TRX_LIMIT.CY_CODE
     */
    private BigDecimal CY_CODE;

    /**
     * This field corresponds to the database column CIF_TRX_LIMIT.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column CIF_TRX_LIMIT.AMOUNT
     */
    private String ACTION_TYPE;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_LIMIT.CY_CODE
     *
     * @return the value of CIF_TRX_LIMIT.CY_CODE
     */
    public BigDecimal getCY_CODE() {
        return CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_LIMIT.CY_CODE
     *
     * @param CY_CODE the value for CIF_TRX_LIMIT.CY_CODE
     */
    public void setCY_CODE(BigDecimal CY_CODE) {
        this.CY_CODE = CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_LIMIT.AMOUNT
     *
     * @return the value of CIF_TRX_LIMIT.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_LIMIT.AMOUNT
     *
     * @param AMOUNT the value for CIF_TRX_LIMIT.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_TRX_LIMIT.ACTION_TYPE
     *
     * @return the value of CIF_TRX_LIMIT.ACTION_TYPE
     */
    public String getACTION_TYPE()
    {
        return ACTION_TYPE;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_TRX_LIMIT.ACTION_TYPE
     *
     * @param aCTION_TYPE the value for CIF_TRX_LIMIT.ACTION_TYPE
     */
    public void setACTION_TYPE(String aCTION_TYPE)
    {
        ACTION_TYPE = aCTION_TYPE;
    }
    
    
}