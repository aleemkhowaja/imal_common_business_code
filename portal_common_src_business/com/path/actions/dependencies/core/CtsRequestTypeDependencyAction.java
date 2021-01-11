/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.requests.csm.CtsRequestSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequestTypeDependencyAction.java used to
 */
@SuppressWarnings("serial")
public class CtsRequestTypeDependencyAction extends RetailBaseAction
{
    CtsRequestSC criteria = new CtsRequestSC();
    private CtsRequestBO ctsRequestBO;
    private CTS_REQUEST_TYPEVO ctsRequestTypeVO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String ctsRequestById()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    ctsRequestTypeVO = ctsRequestBO.returnCtsRequestTypeById(criteria);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public CtsRequestSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(CtsRequestSC criteria)
    {
	this.criteria = criteria;
    }

    /**
     * @param ctsRequestBO the ctsRequestBO to set
     */
    public void setCtsRequestBO(CtsRequestBO ctsRequestBO)
    {
	this.ctsRequestBO = ctsRequestBO;
    }

    /**
     * @return the ctsRequestTypeVO
     */
    public CTS_REQUEST_TYPEVO getCtsRequestTypeVO()
    {
	return ctsRequestTypeVO;
    }

    /**
     * @param ctsRequestTypeVO the ctsRequestTypeVO to set
     */
    public void setCtsRequestTypeVO(CTS_REQUEST_TYPEVO ctsRequestTypeVO)
    {
	this.ctsRequestTypeVO = ctsRequestTypeVO;
    }

}
