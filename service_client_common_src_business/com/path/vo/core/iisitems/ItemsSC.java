package com.path.vo.core.iisitems;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ItemsSC extends GridParamsSC
{
    private BigDecimal currency = BigDecimal.ZERO;// HardCoded for now

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

}
