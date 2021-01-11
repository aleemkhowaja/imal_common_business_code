package com.path.vo.core.teller;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TellerSC extends GridParamsSC
{
    private String status;
    private BigDecimal privilegeLevel;
    private String tellerType;
    private BigDecimal tellerCode;//representative
    private BigDecimal loggedInUserCode;
    private BigDecimal subTellerBranch;//branch code of subordinate Tellers
    private String allowHeadTelleAccessATM;
    private String transferCashReference;
    private String restrictTransferVaultATM;
    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getPrivilegeLevel()
    {
	return privilegeLevel;
    }

    public void setPrivilegeLevel(BigDecimal privilegeLevel)
    {
	this.privilegeLevel = privilegeLevel;
    }

    public String getTellerType()
    {
	return tellerType;
    }

    public void setTellerType(String tellerType)
    {
	this.tellerType = tellerType;
    }

	public BigDecimal getTellerCode()
	{
		return tellerCode;
	}

	public void setTellerCode(BigDecimal tellerCode)
	{
		this.tellerCode = tellerCode;
	}

	public final String getAllowHeadTelleAccessATM()
	{
	    return allowHeadTelleAccessATM;
	}

	public final void setAllowHeadTelleAccessATM(String allowHeadTelleAccessATM)
	{
	    this.allowHeadTelleAccessATM = allowHeadTelleAccessATM;
	}

	public final String getTransferCashReference()
	{
	    return transferCashReference;
	}

	public final void setTransferCashReference(String transferCashReference)
	{
	    this.transferCashReference = transferCashReference;
	}

	public final String getRestrictTransferVaultATM()
	{
	    return restrictTransferVaultATM;
	}

	public final void setRestrictTransferVaultATM(String restrictTransferVaultATM)
	{
	    this.restrictTransferVaultATM = restrictTransferVaultATM;
	}

	public BigDecimal getLoggedInUserCode()
	{
	    return loggedInUserCode;
	}

	public void setLoggedInUserCode(BigDecimal loggedInUserCode)
	{
	    this.loggedInUserCode = loggedInUserCode;
	}

	public BigDecimal getSubTellerBranch()
	{
	    return subTellerBranch;
	}

	public void setSubTellerBranch(BigDecimal subTellerBranch)
	{
	    this.subTellerBranch = subTellerBranch;
	}
	
	
}
