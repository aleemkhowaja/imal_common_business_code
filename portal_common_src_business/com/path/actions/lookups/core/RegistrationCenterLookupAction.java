package com.path.actions.lookups.core;

import com.path.bo.core.registrationcenter.RegistrationCenterBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;

public class RegistrationCenterLookupAction extends LookupBaseAction
{
    RegistrationCenterSC criteria = new RegistrationCenterSC();
    RegistrationCenterBO registrationCenterBO;
    
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookup() 
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "REGISTER_CODE", "BRIEF_NAME_ENG" };
	    String[] colType = { "number","text"};
	    String[] titles = { getText("code_key"),  getText("Short_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("registration_center_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RegCenterLookup_fillRegCenterLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    public String fillRegCenterLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    
	    if(getRecords() == 0)
		{
		    setRecords(registrationCenterBO.returnRegistrationCenterListCount(criteria));
		}
	    
	    setGridModel(registrationCenterBO.returnRegistrationCenterList(criteria));	
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public RegistrationCenterSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(RegistrationCenterSC criteria)
    {
        this.criteria = criteria;
    }

    public void setRegistrationCenterBO(RegistrationCenterBO registrationCenterBO)
    {
        this.registrationCenterBO = registrationCenterBO;
    }
    
    
}
