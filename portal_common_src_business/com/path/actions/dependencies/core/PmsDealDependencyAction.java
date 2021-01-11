/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.pmsdeal.PmsDealBO;
import com.path.lib.common.exception.BOException;
import com.path.vo.common.SessionCO;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * PmsDealDependencyAction.java used to
 */
public class PmsDealDependencyAction extends RetailBaseAction
{
    private PmsDealSC criteria = new PmsDealSC();
    private PmsDealCO pmsDealCO;
    private PmsDealBO pmsDealBO;
    
    public String dependencyByDealNo()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    pmsDealCO = pmsDealBO.returnDependencyByDealNo(criteria);
	    if(pmsDealCO == null)
	    {
		pmsDealCO = new PmsDealCO();
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByDealNo method of PmsDealDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public PmsDealSC getCriteria()
    {
        return criteria;
    }
    
    @Override
    public Object getModel()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(PmsDealSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @return the pmsDealCO
     */
    public PmsDealCO getPmsDealCO()
    {
        return pmsDealCO;
    }

    /**
     * @param pmsDealCO the pmsDealCO to set
     */
    public void setPmsDealCO(PmsDealCO pmsDealCO)
    {
        this.pmsDealCO = pmsDealCO;
    }

    /**
     * @param pmsDealBO the pmsDealBO to set
     */
    public void setPmsDealBO(PmsDealBO pmsDealBO)
    {
        this.pmsDealBO = pmsDealBO;
    }
}
