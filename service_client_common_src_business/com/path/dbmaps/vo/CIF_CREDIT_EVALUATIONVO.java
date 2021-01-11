package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CIF_CREDIT_EVALUATIONVO extends CIF_CREDIT_EVALUATIONVOKey
{

    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.STATUS
     */
    private String STATUS;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.EVALUATION_RECOMMENDATION_CODE
     */
    private BigDecimal EVALUATION_RECOMMENDATION_CODE;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.INTERNAL_RATING_CODE
     */
    private BigDecimal INTERNAL_RATING_CODE;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.COVENANT_COMPLIANCE_YN
     */
    private String COVENANT_COMPLIANCE_YN;
    
    /**
     * This field corresponds to the database column CIF_CREDIT_EVALUATION.COMMENTS
     */
    private String COMMENTS;

    public String getSTATUS()
    {
        return STATUS;
    }

    public void setSTATUS(String sTATUS)
    {
        STATUS = sTATUS;
    }

    public BigDecimal getEVALUATION_RECOMMENDATION_CODE()
    {
        return EVALUATION_RECOMMENDATION_CODE;
    }

    public void setEVALUATION_RECOMMENDATION_CODE(BigDecimal eVALUATION_RECOMMENDATION_CODE)
    {
        EVALUATION_RECOMMENDATION_CODE = eVALUATION_RECOMMENDATION_CODE;
    }

    public BigDecimal getINTERNAL_RATING_CODE()
    {
        return INTERNAL_RATING_CODE;
    }

    public void setINTERNAL_RATING_CODE(BigDecimal iNTERNAL_RATING_CODE)
    {
        INTERNAL_RATING_CODE = iNTERNAL_RATING_CODE;
    }

    public String getCOVENANT_COMPLIANCE_YN()
    {
        return COVENANT_COMPLIANCE_YN;
    }

    public void setCOVENANT_COMPLIANCE_YN(String cOVENANT_COMPLIANCE_YN)
    {
        COVENANT_COMPLIANCE_YN = cOVENANT_COMPLIANCE_YN;
    }

    public String getCOMMENTS()
    {
        return COMMENTS;
    }

    public void setCOMMENTS(String cOMMENTS)
    {
        COMMENTS = cOMMENTS;
    }
}
