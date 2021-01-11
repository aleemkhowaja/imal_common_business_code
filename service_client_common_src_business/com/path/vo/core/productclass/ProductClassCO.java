package com.path.vo.core.productclass;

import java.io.Serializable;
import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class ProductClassCO extends BaseVO implements Serializable
{
    private BigDecimal CODE;
    private BigDecimal CATEGORY;
    private String DESC_ENG;
    private String BRIEF_NAME_ENG;
    private String BRIEF_NAME_ARAB;
    private String LONG_NAME_ENG;
    private BigDecimal EXPOSURE_LIMIT;

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public String getDESC_ENG()
    {
	return DESC_ENG;
    }

    public String getBRIEF_NAME_ENG()
    {
	return BRIEF_NAME_ENG;
    }

    public String getBRIEF_NAME_ARAB()
    {
	return BRIEF_NAME_ARAB;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public void setDESC_ENG(String dESCENG)
    {
	DESC_ENG = dESCENG;
    }

    public void setBRIEF_NAME_ENG(String bRIEFNAMEENG)
    {
	BRIEF_NAME_ENG = bRIEFNAMEENG;
    }

    public void setBRIEF_NAME_ARAB(String bRIEFNAMEARAB)
    {
	BRIEF_NAME_ARAB = bRIEFNAMEARAB;
    }

    /**
     * @return the cATEGORY
     */
    public BigDecimal getCATEGORY()
    {
	return CATEGORY;
    }

    /**
     * @param cATEGORY the cATEGORY to set
     */
    public void setCATEGORY(BigDecimal cATEGORY)
    {
	CATEGORY = cATEGORY;
    }

    public String getLONG_NAME_ENG()
    {
	return LONG_NAME_ENG;
    }

    public void setLONG_NAME_ENG(String lONG_NAME_ENG)
    {
	LONG_NAME_ENG = lONG_NAME_ENG;
    }

    public BigDecimal getEXPOSURE_LIMIT()
    {
	return EXPOSURE_LIMIT;
    }

    public void setEXPOSURE_LIMIT(BigDecimal eXPOSURE_LIMIT)
    {
	EXPOSURE_LIMIT = eXPOSURE_LIMIT;
    }

}
