package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CIF_CREDIT_EVALUATIONVOKey extends BaseVO 
{
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.CIF_NO
     */
    private BigDecimal CIF_NO;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.EVALUATION_YEAR
     */
    private BigDecimal EVALUATION_YEAR;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.EVALUATION_TYPE
     */
    private String EVALUATION_TYPE;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.LINE_NUMBER
     */
    private BigDecimal LINE_NUMBER;

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIF_NO)
    {
        CIF_NO = cIF_NO;
    }

    public BigDecimal getEVALUATION_YEAR()
    {
        return EVALUATION_YEAR;
    }

    public void setEVALUATION_YEAR(BigDecimal eVALUATION_YEAR)
    {
        EVALUATION_YEAR = eVALUATION_YEAR;
    }

    public String getEVALUATION_TYPE()
    {
        return EVALUATION_TYPE;
    }

    public void setEVALUATION_TYPE(String eVALUATION_TYPE)
    {
        EVALUATION_TYPE = eVALUATION_TYPE;
    }

    public BigDecimal getLINE_NUMBER()
    {
        return LINE_NUMBER;
    }

    public void setLINE_NUMBER(BigDecimal lINE_NUMBER)
    {
        LINE_NUMBER = lINE_NUMBER;
    }
    

}
