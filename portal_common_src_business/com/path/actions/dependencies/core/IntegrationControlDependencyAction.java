package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.integrationcontrol.IntegrationControlBO;
import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;

public class IntegrationControlDependencyAction extends RetailBaseAction
{

    private IntegrationControlBO integrationControlBO;
    private CTS_INTEG_PARAMVO integrationControlVO;
    private BigDecimal TYPE_CODE;

    public String dependancyByIntegration()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    IntegrationControlSC criteria = new IntegrationControlSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setTypeCode(TYPE_CODE);

	    integrationControlVO = integrationControlBO.returnIntegrationControlById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByIntegration method of IntegrationControlDependencyAction");
	    handleException(e, "ERROR in IntegrationControl", null);
	}

	return SUCCESS;
    }

    public void setIntegrationControlBO(IntegrationControlBO integrationControlBO)
    {
	this.integrationControlBO = integrationControlBO;
    }

    public CTS_INTEG_PARAMVO getIntegrationControlVO()
    {
	return integrationControlVO;
    }

    public void setIntegrationControlVO(CTS_INTEG_PARAMVO integrationControlVO)
    {
	this.integrationControlVO = integrationControlVO;
    }

    public BigDecimal getTYPE_CODE()
    {
	return TYPE_CODE;
    }

    public void setTYPE_CODE(BigDecimal tYPECODE)
    {
	TYPE_CODE = tYPECODE;
    }

}
