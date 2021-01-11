package com.path.actions.lookups.core;

import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.requests.csm.CtsRequestSC;

@SuppressWarnings("serial")
public class CtsRequestTypeLookupAction extends LookupBaseAction
{

    CtsRequestSC criteria = new CtsRequestSC();
    private CtsRequestBO ctsRequestBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "APP_NAME", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("Code__key"), getText("APPLICATION_NAME_key"), getText("Brief_Name_key"),
		    getText("Brief_Name_Arab_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    // grid.setCaption(getText("Provider_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsRequestTypeLookup_fillCtsRequestTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsRequestTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCtsRequestTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    //Hasan #502702 21/01/2017
	    if(!StringUtil.isNotEmpty(criteria.getAppName()))
	    {
		criteria.setAppName(sessionCO.getCurrentAppName());
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(ctsRequestBO.returnCtsRequestTypeListCount(criteria));
	    }
	    setGridModel(ctsRequestBO.returnCtsRequestTypeList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCtsRequestTypeLookup of CtsRequestTypeLookupAction");
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

}
