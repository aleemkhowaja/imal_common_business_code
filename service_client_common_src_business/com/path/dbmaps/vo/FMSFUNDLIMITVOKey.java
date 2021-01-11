package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class FMSFUNDLIMITVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.FUND_CODE
     */
    private BigDecimal FUND_CODE;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    public BigDecimal getFUND_CODE()
    {
        return FUND_CODE;
    }

    public void setFUND_CODE(BigDecimal fUND_CODE)
    {
        FUND_CODE = fUND_CODE;
    }

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }
}
