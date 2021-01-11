package com.path.vo.core.chequebookdesign;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChequeBookDesignSC extends GridParamsSC
{
    private String userId;
    private BigDecimal compCode;
    private BigDecimal designCode;

    public ChequeBookDesignSC()
    {
	super.setSearchCols(new String[] { "COMP_CODE", "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" });
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getDesignCode()
    {
	return designCode;
    }

    public void setDesignCode(BigDecimal designCode)
    {
	this.designCode = designCode;
    }

}
