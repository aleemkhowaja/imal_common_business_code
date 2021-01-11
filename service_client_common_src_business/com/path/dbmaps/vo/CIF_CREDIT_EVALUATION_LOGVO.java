package com.path.dbmaps.vo;

import java.util.Date;

public class CIF_CREDIT_EVALUATION_LOGVO extends CIF_CREDIT_EVALUATION_LOGVOKey
{

    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION_LOG.ACTION
     */
    private String ACTION;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION_LOG.USER_ID
     */
    private String USER_ID;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION_LOG.ACTION_DATE
     */
    private Date ACTION_DATE;

    public String getACTION()
    {
        return ACTION;
    }

    public void setACTION(String aCTION)
    {
        ACTION = aCTION;
    }

    public String getUSER_ID()
    {
        return USER_ID;
    }

    public void setUSER_ID(String uSER_ID)
    {
        USER_ID = uSER_ID;
    }

    public Date getACTION_DATE()
    {
        return ACTION_DATE;
    }

    public void setACTION_DATE(Date aCTION_DATE)
    {
        ACTION_DATE = aCTION_DATE;
    }
}
