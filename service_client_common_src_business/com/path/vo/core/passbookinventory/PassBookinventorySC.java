package com.path.vo.core.passbookinventory;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class PassBookinventorySC extends BaseSC
{

    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal passbookType;
    private BigDecimal vaultNo;

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getPassbookType()
    {
	return passbookType;
    }

    public void setPassbookType(BigDecimal passbookType)
    {
	this.passbookType = passbookType;
    }

    public BigDecimal getVaultNo()
    {
	return vaultNo;
    }

    public void setVaultNo(BigDecimal vaultNo)
    {
	this.vaultNo = vaultNo;
    }

}
