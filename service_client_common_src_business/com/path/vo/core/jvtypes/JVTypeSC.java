package com.path.vo.core.jvtypes;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class JVTypeSC extends GridParamsSC
{

    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal jvCode;
    private String language;
    private String showAddRef;
    
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
    public BigDecimal getJvCode()
    {
        return jvCode;
    }
    public void setJvCode(BigDecimal jvCode)
    {
        this.jvCode = jvCode;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
	public String getShowAddRef() {
		return showAddRef;
	}
	public void setShowAddRef(String showAddRef) {
		this.showAddRef = showAddRef;
	}
    
}
