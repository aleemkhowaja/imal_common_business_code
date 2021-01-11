package com.path.vo.core.itempropertydet;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public class ItemPropertydetSC extends GridParamsSC
{

    private BigDecimal propertyCode;
    private BigDecimal lineNo;

    public void setPropertyCode(BigDecimal propertyCode)
    {
	this.propertyCode = propertyCode;
    }

    public BigDecimal getPropertyCode()
    {
	return propertyCode;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

}
