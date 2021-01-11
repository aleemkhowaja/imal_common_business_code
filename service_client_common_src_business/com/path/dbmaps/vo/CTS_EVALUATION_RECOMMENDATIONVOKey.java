package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTS_EVALUATION_RECOMMENDATIONVOKey extends BaseVO 
{

    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.CODE
     */
    private BigDecimal CODE;

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getCODE()
    {
        return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }
}
