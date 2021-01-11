/**
 *
 */
package com.path.actions.common.global360view.others;

import com.path.bo.common.global360view.others.DashOthersBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 *
 * @author: elieachkar
 *
 *          DashAuthorizedSigListAction.java used to
 */
public class DashChildCifListAction extends GridBaseAction
{
    private DashOthersBO dashOthersBO;
    private DashboardSC criteria = new DashboardSC();

    /**
     *
     */
    public Object getModel()
    {
	return criteria;
    }

    

    

    public String loadChildCifGridData()
	{
		String[] searchCol = { "CIFNO", "cif_desc" };		 
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copysearchproperties(criteria);
			
			copyproperties(criteria);
			
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setBranchCode(sessionCO.getBranchCode());
			criteria.setUserId(sessionCO.getUserName());
			
		  	    if(checkNbRec(criteria))
		  	    {
		  		setRecords(dashOthersBO.childCifListCount(criteria));
		  	    }
		  	    setGridModel(dashOthersBO.childCifList(criteria));
		  	    
		  	    
		
		    }
		    catch(Exception e)
		    {
			log.error(e, "Error in Child Cifs Grid");
			handleException(e, null, null);
		    }
		    return SUCCESS;
		}



    public void setDashOthersBO(DashOthersBO dashOthersBO)
    {
	this.dashOthersBO = dashOthersBO;
    }

    public DashboardSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }
}
