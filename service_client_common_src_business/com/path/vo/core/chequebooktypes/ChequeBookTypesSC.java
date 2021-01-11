/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookTypesSC.java used to
 */
package com.path.vo.core.chequebooktypes;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChequeBookTypesSC extends GridParamsSC
{

    private String userId;
    private BigDecimal compCode;
    private BigDecimal typesCode;

    public ChequeBookTypesSC()
    {
	super.setSearchCols(new String[] { "COMP_CODE", "CODE", "DESC_ENG", "DESC_ARAB"});
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

    public BigDecimal getTypesCode()
    {
	return typesCode;
    }

    public void setTypesCode(BigDecimal typesCode)
    {
	this.typesCode = typesCode;
    }

}
