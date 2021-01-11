package com.path.vo.core.procedureid;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ProcedureIdSC extends GridParamsSC
{
    public ProcedureIdSC()
    {
	super.setSearchCols(new String[] { "procId", "procName", "procNames", "procDesc" });
    }

    private BigDecimal procId;
    private String procNames;

    public BigDecimal getProcId()
    {
	return procId;
    }

    public void setProcId(BigDecimal procId)
    {
	this.procId = procId;
    }

    public String getProcNames()
    {
	return procNames;
    }

    public void setProcNames(String procNames)
    {
	this.procNames = procNames;
    }

}
