package com.path.vo.core.giftclass;

import com.path.struts2.lib.common.GridParamsSC;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class GiftClassLookupSC extends GridParamsSC
{
    private BigDecimal code;
    private BigDecimal tellerCode;

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }
}
