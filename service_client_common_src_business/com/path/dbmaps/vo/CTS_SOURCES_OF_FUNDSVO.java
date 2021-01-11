package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTS_SOURCES_OF_FUNDSVO extends CTS_SOURCES_OF_FUNDSVOKey
{
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.RECOM_EXPOSURE_LIMIT_PERC
     */
    private BigDecimal RECOM_EXPOSURE_LIMIT_PERC;
    
    /**
     * This field corresponds to the database column CTS_SOURCES_OF_FUNDS.RECOM_EXPOSURE_LIMIT_AMOUNT
     */
    private BigDecimal RECOM_EXPOSURE_LIMIT_AMOUNT;

    public BigDecimal getRECOM_EXPOSURE_LIMIT_PERC()
    {
        return RECOM_EXPOSURE_LIMIT_PERC;
    }

    public void setRECOM_EXPOSURE_LIMIT_PERC(BigDecimal rECOM_EXPOSURE_LIMIT_PERC)
    {
        RECOM_EXPOSURE_LIMIT_PERC = rECOM_EXPOSURE_LIMIT_PERC;
    }

    public BigDecimal getRECOM_EXPOSURE_LIMIT_AMOUNT()
    {
        return RECOM_EXPOSURE_LIMIT_AMOUNT;
    }

    public void setRECOM_EXPOSURE_LIMIT_AMOUNT(BigDecimal rECOM_EXPOSURE_LIMIT_AMOUNT)
    {
        RECOM_EXPOSURE_LIMIT_AMOUNT = rECOM_EXPOSURE_LIMIT_AMOUNT;
    }
}
