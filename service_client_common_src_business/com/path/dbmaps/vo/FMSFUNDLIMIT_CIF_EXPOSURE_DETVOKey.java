package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class FMSFUNDLIMIT_CIF_EXPOSURE_DETVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.FUND_CODE
     */
    private BigDecimal FUND_CODE;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

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

    public BigDecimal getLINE_NO()
    {
        return LINE_NO;
    }

    public void setLINE_NO(BigDecimal lINE_NO)
    {
        LINE_NO = lINE_NO;
    }
}
