package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.ctsoperationstype.CtsOperationsTypeLkpBO;
import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public class OperationTypeDependencyAction extends RetailBaseAction
{
    private CtsOperationsTypeLkpBO ctsOperationsTypeLkpBO;
    private CtsOperationsTypeLkpSC operationsTypeLkpSC;
    private CTS_OPERATIONS_TYPEVO ctsOperationTypeVO;

    public String dependencyByOperationType()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    operationsTypeLkpSC.setCompCode(sessionCO.getCompanyCode());
	    operationsTypeLkpSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    ctsOperationTypeVO = ctsOperationsTypeLkpBO.returnOperationTypeByCode(operationsTypeLkpSC);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByOperationType method of OperationTypeDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setCtsOperationsTypeLkpBO(CtsOperationsTypeLkpBO ctsOperationsTypeLkpBO)
    {
	this.ctsOperationsTypeLkpBO = ctsOperationsTypeLkpBO;
    }

    public CtsOperationsTypeLkpSC getOperationsTypeLkpSC()
    {
	return operationsTypeLkpSC;
    }

    public void setOperationsTypeLkpSC(CtsOperationsTypeLkpSC operationsTypeLkpSC)
    {
	this.operationsTypeLkpSC = operationsTypeLkpSC;
    }

    public CTS_OPERATIONS_TYPEVO getCtsOperationTypeVO()
    {
        return ctsOperationTypeVO;
    }

    public void setCtsOperationTypeVO(CTS_OPERATIONS_TYPEVO ctsOperationTypeVO)
    {
        this.ctsOperationTypeVO = ctsOperationTypeVO;
    }
}
