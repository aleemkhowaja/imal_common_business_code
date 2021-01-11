package com.path.vo.core.legalstatus;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class LegalStatusSC extends GridParamsSC
{
    private BigDecimal statusCode;
    private BigDecimal cifType;
    private BigDecimal ecoAgentCode;
    private String useCifMatrix;

    /**
     * @return the statusCode
     */
    public BigDecimal getStatusCode()
    {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(BigDecimal statusCode)
    {
        this.statusCode = statusCode;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getEcoAgentCode()
    {
        return ecoAgentCode;
    }

    public void setEcoAgentCode(BigDecimal ecoAgentCode)
    {
        this.ecoAgentCode = ecoAgentCode;
    }

    public String getUseCifMatrix()
    {
        return useCifMatrix;
    }

    public void setUseCifMatrix(String useCifMatrix)
    {
        this.useCifMatrix = useCifMatrix;
    }


}
