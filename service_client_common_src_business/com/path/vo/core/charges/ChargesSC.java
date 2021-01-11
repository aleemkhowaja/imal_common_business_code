package com.path.vo.core.charges;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChargesSC extends GridParamsSC
{

    private BigDecimal code;
    private String considerFlatAmount;
    private String isBrokerCharge = "N";

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public String getConsiderFlatAmount()
    {
	return considerFlatAmount;
    }

    public void setConsiderFlatAmount(String considerFlatAmount)
    {
	this.considerFlatAmount = considerFlatAmount;
    }

    public String getIsBrokerCharge()
    {
	return isBrokerCharge;
    }

    public void setIsBrokerCharge(String isBrokerCharge)
    {
	this.isBrokerCharge = isBrokerCharge;
    }

}
