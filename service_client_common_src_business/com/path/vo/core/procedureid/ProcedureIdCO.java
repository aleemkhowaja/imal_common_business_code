package com.path.vo.core.procedureid;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

public class ProcedureIdCO extends RetailBaseVO
{

    private BigDecimal procId;
    private String procName;
    private String procNames;
    private String procDesc;
    private String procObject;

    public BigDecimal getProcId()
    {
	return procId;
    }

    public void setProcId(BigDecimal procId)
    {
	this.procId = procId;
    }

    public String getProcName()
    {
	return procName;
    }

    public void setProcName(String procName)
    {
	this.procName = procName;
    }

    public String getProcObject()
    {
	return procObject;
    }

    public void setProcObject(String procObject)
    {
	this.procObject = procObject;
    }

    public String getProcNames()
    {
	return procNames;
    }

    public void setProcNames(String procNames)
    {
	this.procNames = procNames;
    }

    public String getProcDesc()
    {
	return procDesc;
    }

    public void setProcDesc(String procDesc)
    {
	this.procDesc = procDesc;
    }

}
