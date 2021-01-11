package com.path.vo.core.professioncategory;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ProfessionCategorySC extends GridParamsSC
{
    private BigDecimal cifType;
    private BigDecimal code;
    private BigDecimal legalStatusCode;
    private String useCifMatrix;
    
    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public BigDecimal getLegalStatusCode()
    {
        return legalStatusCode;
    }

    public void setLegalStatusCode(BigDecimal legalStatusCode)
    {
        this.legalStatusCode = legalStatusCode;
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