package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMSFUNDLIMIT_CIF_EXPOSURE_DETVO extends FMSFUNDLIMIT_CIF_EXPOSURE_DETVOKey
{
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.CIF_TYPE
     */
    private BigDecimal CIF_TYPE;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.CREDIT_RATING
     */
    private BigDecimal CREDIT_RATING;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.EXPOSURE_LIMIT_PERC
     */
    private BigDecimal EXPOSURE_LIMIT_PERC;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.AMOUNT
     */
    private BigDecimal AMOUNT;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.UTILIZED
     */
    private BigDecimal UTILIZED;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.STATUS
     */
    private String STATUS;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.APPLICABLE_ALL_YN
     */
    private String APPLICABLE_ALL_YN;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.CREATED_BY
     */
    private String CREATED_BY;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.CREATED_DATE
     */
    private Date CREATED_DATE;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.MODIFIED_BY
     */
    private String MODIFIED_BY;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT_CIF_EXPOSURE_DET.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    public BigDecimal getCIF_TYPE()
    {
        return CIF_TYPE;
    }

    public void setCIF_TYPE(BigDecimal cIF_TYPE)
    {
        CIF_TYPE = cIF_TYPE;
    }

    public BigDecimal getCREDIT_RATING()
    {
        return CREDIT_RATING;
    }

    public void setCREDIT_RATING(BigDecimal cREDIT_RATING)
    {
        CREDIT_RATING = cREDIT_RATING;
    }

    public BigDecimal getEXPOSURE_LIMIT_PERC()
    {
        return EXPOSURE_LIMIT_PERC;
    }

    public void setEXPOSURE_LIMIT_PERC(BigDecimal eXPOSURE_LIMIT_PERC)
    {
        EXPOSURE_LIMIT_PERC = eXPOSURE_LIMIT_PERC;
    }

    public BigDecimal getAMOUNT()
    {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal aMOUNT)
    {
        AMOUNT = aMOUNT;
    }

    public BigDecimal getUTILIZED()
    {
        return UTILIZED;
    }

    public void setUTILIZED(BigDecimal uTILIZED)
    {
        UTILIZED = uTILIZED;
    }

    public String getSTATUS()
    {
        return STATUS;
    }

    public void setSTATUS(String sTATUS)
    {
        STATUS = sTATUS;
    }

    public String getAPPLICABLE_ALL_YN()
    {
        return APPLICABLE_ALL_YN;
    }

    public void setAPPLICABLE_ALL_YN(String aPPLICABLE_ALL_YN)
    {
        APPLICABLE_ALL_YN = aPPLICABLE_ALL_YN;
    }

    public String getCREATED_BY()
    {
        return CREATED_BY;
    }

    public void setCREATED_BY(String cREATED_BY)
    {
        CREATED_BY = cREATED_BY;
    }

    public Date getCREATED_DATE()
    {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date cREATED_DATE)
    {
        CREATED_DATE = cREATED_DATE;
    }

    public String getMODIFIED_BY()
    {
        return MODIFIED_BY;
    }

    public void setMODIFIED_BY(String mODIFIED_BY)
    {
        MODIFIED_BY = mODIFIED_BY;
    }

    public Date getMODIFIED_DATE()
    {
        return MODIFIED_DATE;
    }

    public void setMODIFIED_DATE(Date mODIFIED_DATE)
    {
        MODIFIED_DATE = mODIFIED_DATE;
    }
}
