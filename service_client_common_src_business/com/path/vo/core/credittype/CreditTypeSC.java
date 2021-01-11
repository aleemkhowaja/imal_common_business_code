package com.path.vo.core.credittype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CreditTypeSC extends GridParamsSC
{
    private BigDecimal code;

    public BigDecimal getCode()
    {
        return code;
    }
    
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
}