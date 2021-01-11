/**
 * 
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          FOMRequiredDocSC.java used to
 */
public class FOMRequiredDocSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal legalStatusCode;
    private String status;
    private String saveType;
    private boolean resetFlag;

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getLegalStatusCode()
    {
	return legalStatusCode;
    }

    public void setLegalStatusCode(BigDecimal legalStatusCode)
    {
	this.legalStatusCode = legalStatusCode;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public boolean isResetFlag()
    {
	return resetFlag;
    }

    public void setResetFlag(boolean resetFlag)
    {
	this.resetFlag = resetFlag;
    }

}
