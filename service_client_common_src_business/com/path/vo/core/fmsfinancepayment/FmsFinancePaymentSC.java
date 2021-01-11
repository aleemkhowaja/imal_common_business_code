package com.path.vo.core.fmsfinancepayment;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FmsFinancePaymentSC extends GridParamsSC
{
    private BigDecimal code;
    private String status;
    
    public BigDecimal getCode()
    {
        return code;
    }
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    
     
}