package com.path.vo.core.services;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ServicesSC extends GridParamsSC
{
    private BigDecimal serviceType;

    
    
    public BigDecimal getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(BigDecimal serviceType)
    {
        this.serviceType = serviceType;
    }

   

}
