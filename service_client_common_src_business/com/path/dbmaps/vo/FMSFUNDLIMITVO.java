package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMSFUNDLIMITVO extends FMSFUNDLIMITVOKey
{
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.GLOBAL_LIMIT
     */
    private BigDecimal GLOBAL_LIMIT;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.UTILIZED
     */
    private BigDecimal UTILIZED;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.MUDARIB_SHARE_PERC
     */
    private BigDecimal MUDARIB_SHARE_PERC;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.STATUS
     */
    private String STATUS;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.CREATED_BY
     */
    private String CREATED_BY;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.CREATED_DATE
     */
    private Date CREATED_DATE;
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.MODIFIED_BY
     */
    private String MODIFIED_BY;
    
    /**
     * This field corresponds to the database column FMSFUNDLIMIT.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    public BigDecimal getCURRENCY_CODE()
    {
        return CURRENCY_CODE;
    }

    public void setCURRENCY_CODE(BigDecimal cURRENCY_CODE)
    {
        CURRENCY_CODE = cURRENCY_CODE;
    }

    public BigDecimal getGLOBAL_LIMIT()
    {
        return GLOBAL_LIMIT;
    }

    public void setGLOBAL_LIMIT(BigDecimal gLOBAL_LIMIT)
    {
        GLOBAL_LIMIT = gLOBAL_LIMIT;
    }

    public BigDecimal getUTILIZED()
    {
        return UTILIZED;
    }

    public void setUTILIZED(BigDecimal uTILIZED)
    {
        UTILIZED = uTILIZED;
    }

    public BigDecimal getMUDARIB_SHARE_PERC()
    {
        return MUDARIB_SHARE_PERC;
    }

    public void setMUDARIB_SHARE_PERC(BigDecimal mUDARIB_SHARE_PERC)
    {
        MUDARIB_SHARE_PERC = mUDARIB_SHARE_PERC;
    }

    public String getSTATUS()
    {
        return STATUS;
    }

    public void setSTATUS(String sTATUS)
    {
        STATUS = sTATUS;
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
