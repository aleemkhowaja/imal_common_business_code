package com.path.actions.dependencies.core;

import com.path.bo.core.procedureid.ProcedureIdBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public class ProcedureIdDependencyAction extends BaseAction
{
    private ProcedureIdBO procedureIdBO;
    private ProcedureIdCO procedureIdCO = new ProcedureIdCO();
    private ProcedureIdSC procedureIdSC = new ProcedureIdSC();

    @Override
    public Object getModel()
    {
	return procedureIdSC;
    }

    /**
     * Get dependency between Types Code and Description
     * 
     * @return
     */
    public String dependencyByProcId()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(procedureIdSC.getProcId()))
	    {
		procedureIdCO = procedureIdBO.dependencyByProcId(procedureIdSC);

		if(null == procedureIdCO)
		{
		    procedureIdCO = new ProcedureIdCO();
		}
	    }
	    else
	    {
		procedureIdCO = new ProcedureIdCO();
	    }
	}
	catch(Exception e)
	{
	    procedureIdCO = new ProcedureIdCO();
	    log.error(e, "Error in dependencyByTypes method of ProcedureIdDependencyAction.java");
	    handleException(e, "ERROR in Dependency", null);
	}
	return SUCCESS;
    }

    /**
     * Get dependency between Types Code and Description
     * 
     * @return
     */
    public String dependencyByProcedure()
    {
	try
	{
	    if(StringUtil.isNotEmpty(procedureIdSC.getProcNames()))
	    {
		procedureIdCO = procedureIdBO.dependencyByProcedure(procedureIdSC);

		if(null == procedureIdCO)
		{
		    procedureIdCO = new ProcedureIdCO();
		}
	    }
	    else
	    {
		procedureIdCO = new ProcedureIdCO();
	    }
	}
	catch(Exception e)
	{
	    procedureIdCO = new ProcedureIdCO();
	    log.error(e, "Error in dependencyByTypes method of PrfocedureDependencyAction.java");
	    handleException(e, "ERROR in Dependency", null);
	}
	return SUCCESS;
    }

    public void setProcedureIdCO(ProcedureIdCO procedureIdCO)
    {
	this.procedureIdCO = procedureIdCO;
    }

    public ProcedureIdCO getProcedureIdCO()
    {
	return procedureIdCO;
    }

    public void setProcedureIdSC(ProcedureIdSC procedureIdSC)
    {
	this.procedureIdSC = procedureIdSC;
    }

    public ProcedureIdSC getProcedureIdSC()
    {
	return procedureIdSC;
    }

    public void setProcedureIdBO(ProcedureIdBO procedureIdBO)
    {
	this.procedureIdBO = procedureIdBO;
    }

}
