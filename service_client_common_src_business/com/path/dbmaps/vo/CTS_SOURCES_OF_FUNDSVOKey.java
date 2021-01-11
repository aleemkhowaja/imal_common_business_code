package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTS_SOURCES_OF_FUNDSVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.CIF_NO
     */
    private BigDecimal CIF_NO;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.EVALUATION_YEAR
     */
    private BigDecimal EVALUATION_YEAR;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.EVALUATION_TYPE
     */
    private String EVALUATION_TYPE;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.CREDIT_RATING
     */
    private BigDecimal CREDIT_RATING;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.LINE_NO
     */
    private BigDecimal LINE_NO;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.FUND_CODE
     */
    private BigDecimal FUND_CODE;

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

    public BigDecimal getCREDIT_RATING()
    {
        return CREDIT_RATING;
    }

    public void setCREDIT_RATING(BigDecimal cREDIT_RATING)
    {
        CREDIT_RATING = cREDIT_RATING;
    }

    public BigDecimal getLINE_NO()
    {
        return LINE_NO;
    }

    public void setLINE_NO(BigDecimal lINE_NO)
    {
        LINE_NO = lINE_NO;
    }

    public BigDecimal getFUND_CODE()
    {
        return FUND_CODE;
    }

    public void setFUND_CODE(BigDecimal fUND_CODE)
    {
        FUND_CODE = fUND_CODE;
    }
}
