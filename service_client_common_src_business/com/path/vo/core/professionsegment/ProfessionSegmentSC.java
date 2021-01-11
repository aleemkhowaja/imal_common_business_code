package com.path.vo.core.professionsegment;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ProfessionSegmentSC extends GridParamsSC
{
    private BigDecimal cifType;
    private BigDecimal code;
    private BigDecimal categoryCode;
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

    public BigDecimal getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(BigDecimal categoryCode)
    {
        this.categoryCode = categoryCode;
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