package com.path.vo.core.integrationDynamic;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class IntegrationDynamicSC extends GridParamsSC
{
        private String lang;
	private BigDecimal integrationCode;
	private BigDecimal typeCode;
	private BigDecimal bankCif;
	private BigDecimal trxType;
	private BigDecimal trsCy;
	private String status;
	
	
	public String getLang()
	{
	    return lang;
	}
	public void setLang(String lang)
	{
	    this.lang = lang;
	}
	public BigDecimal getIntegrationCode()
	{
	    return integrationCode;
	}
	public void setIntegrationCode(BigDecimal integrationCode)
	{
	    this.integrationCode = integrationCode;
	}
	public BigDecimal getTypeCode()
	{
	    return typeCode;
	}
	public void setTypeCode(BigDecimal typeCode)
	{
	    this.typeCode = typeCode;
	}
	public BigDecimal getBankCif()
	{
	    return bankCif;
	}
	public void setBankCif(BigDecimal bankCif)
	{
	    this.bankCif = bankCif;
	}
	public BigDecimal getTrxType()
	{
	    return trxType;
	}
	public void setTrxType(BigDecimal trxType)
	{
	    this.trxType = trxType;
	}
	public BigDecimal getTrsCy()
	{
	    return trsCy;
	}
	public void setTrsCy(BigDecimal trsCy)
	{
	    this.trsCy = trsCy;
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
