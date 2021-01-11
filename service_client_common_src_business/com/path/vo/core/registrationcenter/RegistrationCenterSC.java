package com.path.vo.core.registrationcenter;

import com.path.struts2.lib.common.GridParamsSC;
import java.math.BigDecimal;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterSC.java used to
 */
public class RegistrationCenterSC extends GridParamsSC
{
    private BigDecimal regCode;

    public BigDecimal getRegCode()
    {
        return regCode;
    }

    public void setRegCode(BigDecimal regCode)
    {
        this.regCode = regCode;
    }
    
    
}
