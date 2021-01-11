package com.path.dbmaps.vo;

public class CTS_EVALUATION_RECOMMENDATIONVO extends CTS_EVALUATION_RECOMMENDATIONVOKey
{

    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.BRIEF_NAME_ENGLISH
     */
    private String BRIEF_NAME_ENGLISH;
    
    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.LONG_NAME_ENGLISH
     */
    private String LONG_NAME_ENGLISH;
    
    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.BRIEF_NAME_ARABIC
     */
    private String BRIEF_NAME_ARABIC;
    
    /**
     * This field corresponds to the database column CTS_EVALUATION_RECOMMENDATION.LONG_NAME_ARABIC
     */
    private String LONG_NAME_ARABIC;

    public String getBRIEF_NAME_ENGLISH()
    {
        return BRIEF_NAME_ENGLISH;
    }

    public void setBRIEF_NAME_ENGLISH(String bRIEF_NAME_ENGLISH)
    {
        BRIEF_NAME_ENGLISH = bRIEF_NAME_ENGLISH;
    }

    public String getLONG_NAME_ENGLISH()
    {
        return LONG_NAME_ENGLISH;
    }

    public void setLONG_NAME_ENGLISH(String lONG_NAME_ENGLISH)
    {
        LONG_NAME_ENGLISH = lONG_NAME_ENGLISH;
    }

    public String getBRIEF_NAME_ARABIC()
    {
        return BRIEF_NAME_ARABIC;
    }

    public void setBRIEF_NAME_ARABIC(String bRIEF_NAME_ARABIC)
    {
        BRIEF_NAME_ARABIC = bRIEF_NAME_ARABIC;
    }

    public String getLONG_NAME_ARABIC()
    {
        return LONG_NAME_ARABIC;
    }

    public void setLONG_NAME_ARABIC(String lONG_NAME_ARABIC)
    {
        LONG_NAME_ARABIC = lONG_NAME_ARABIC;
    }
}
