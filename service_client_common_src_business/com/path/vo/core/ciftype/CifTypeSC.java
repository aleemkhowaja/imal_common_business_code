package com.path.vo.core.ciftype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: RabihElKhatib
 *
 *          CifTypeSC.java used to hold the variables of the items validation as
 *          arguments for DB queries in CifTypeMapper
 */
public class CifTypeSC extends GridParamsSC
{

    private BigDecimal cifTypeCode;
    private String vtIndicator;
    private String clientIndicator;
    private int idType;
    private int civilCode;
    private String checkMinMaxAge = "B";
    private String noExceptionMsg;
    private Boolean minAgeByAccountType = false;
    private BigDecimal glCode;
    // TP#621590 ;13-Feb-2018;d.james
    private String allTypes;
    private String allTypesFlag;

    public String getNoExceptionMsg()
    {
	return noExceptionMsg;
    }

    public void setNoExceptionMsg(String noExceptionMsg)
    {
	this.noExceptionMsg = noExceptionMsg;
    }

    public String getCheckMinMaxAge()
    {
	return checkMinMaxAge;
    }

    public void setCheckMinMaxAge(String checkMinMaxAge)
    {
	this.checkMinMaxAge = checkMinMaxAge;
    }

    public int getCivilCode()
    {
	return civilCode;
    }

    public void setCivilCode(int civilCode)
    {
	this.civilCode = civilCode;
    }

    public int getIdType()
    {
	return idType;
    }

    public void setIdType(int idType)
    {
	this.idType = idType;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public void setVtIndicator(String vtIndicator)
    {
	this.vtIndicator = vtIndicator;
    }

    public String getVtIndicator()
    {
	return vtIndicator;
    }

    public void setClientIndicator(String clientIndicator)
    {
	this.clientIndicator = clientIndicator;
    }

    public String getClientIndicator()
    {
	return clientIndicator;
    }

    public Boolean getMinAgeByAccountType()
    {
	return minAgeByAccountType;
    }

    public void setMinAgeByAccountType(Boolean minAgeByAccountType)
    {
	this.minAgeByAccountType = minAgeByAccountType;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public String getAllTypes()
    {
	return allTypes;
    }

    public void setAllTypes(String allTypes)
    {
	this.allTypes = allTypes;
    }

    public String getAllTypesFlag()
    {
	return allTypesFlag;
    }

    public void setAllTypesFlag(String allTypesFlag)
    {
	this.allTypesFlag = allTypesFlag;
    }

}
