package com.path.vo.core.residencetypes;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ResidenceTypesSC extends GridParamsSC 
{
    private BigDecimal code;

    /**
     * @return the code
     */
    public BigDecimal getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
}
