package com.path.vo.core.ctsreparg;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class CtsReportArgSC extends GridParamsSC
{
    private String appName;
    private String trxType;
    private BigDecimal argCode;
    private BigDecimal currency;
    private BigDecimal genLedger;
    private BigDecimal cifNo;
    private BigDecimal serialNo;
    private BigDecimal trxNo;
    private BigDecimal fromTrxNo;
    private BigDecimal toTrxNo;
    private BigDecimal trxTypeCode;
    private BigDecimal code;
    private List<BigDecimal> argCodeList;
    private String parameters;
    
	public String getAppName()
	{
		return appName;
	}
	public void setAppName(String appName)
	{
		this.appName = appName;
	}
	public String getTrxType()
	{
		return trxType;
	}
	public void setTrxType(String trxType)
	{
		this.trxType = trxType;
	}
	public BigDecimal getArgCode()
	{
		return argCode;
	}
	public void setArgCode(BigDecimal argCode)
	{
		this.argCode = argCode;
	}
	public BigDecimal getCurrency()
	{
	    return currency;
	}
	public void setCurrency(BigDecimal currency)
	{
	    this.currency = currency;
	}
	public BigDecimal getGenLedger()
	{
	    return genLedger;
	}
	public void setGenLedger(BigDecimal genLedger)
	{
	    this.genLedger = genLedger;
	}
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	public BigDecimal getSerialNo()
	{
	    return serialNo;
	}
	public void setSerialNo(BigDecimal serialNo)
	{
	    this.serialNo = serialNo;
	}
	public BigDecimal getTrxNo()
	{
	    return trxNo;
	}
	public void setTrxNo(BigDecimal trxNo)
	{
	    this.trxNo = trxNo;
	}
	public BigDecimal getFromTrxNo()
	{
	    return fromTrxNo;
	}
	public void setFromTrxNo(BigDecimal fromTrxNo)
	{
	    this.fromTrxNo = fromTrxNo;
	}
	public BigDecimal getToTrxNo()
	{
	    return toTrxNo;
	}
	public void setToTrxNo(BigDecimal toTrxNo)
	{
	    this.toTrxNo = toTrxNo;
	}
	public BigDecimal getTrxTypeCode()
	{
	    return trxTypeCode;
	}
	public void setTrxTypeCode(BigDecimal trxTypeCode)
	{
	    this.trxTypeCode = trxTypeCode;
	}
	public List<BigDecimal> getArgCodeList()
	{
	    return argCodeList;
	}
	public void setArgCodeList(List<BigDecimal> argCodeList)
	{
	    this.argCodeList = argCodeList;
	}
	public String getParameters()
	{
	    return parameters;
	}
	public void setParameters(String parameters)
	{
	    this.parameters = parameters;
	}

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }
}
