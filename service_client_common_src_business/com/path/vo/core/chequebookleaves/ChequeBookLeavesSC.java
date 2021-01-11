/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookLeavesSC.java used to
 */
package com.path.vo.core.chequebookleaves;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChequeBookLeavesSC extends GridParamsSC
{
    private String userId;
    private BigDecimal compCode;
    private BigDecimal leavesCode;

    public ChequeBookLeavesSC()
    {
	super.setSearchCols(new String[] { "COMP_CODE", "CODE", "NO_LEAVES", "DESC_ENG", "DESC_ARAB" });
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

    public BigDecimal getLeavesCode()
    {
	return leavesCode;
    }

    public void setLeavesCode(BigDecimal leavesCode)
    {
	this.leavesCode = leavesCode;
    }

}
