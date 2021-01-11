package com.path.actions.lookups.core;

import com.path.bo.core.smsservices.SmsServicesBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.smsservices.SmsServicesSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SmsServicesLookupAction.java used to
 */
public class SmsServicesLookupAction extends LookupBaseAction
{
	SmsServicesBO smsServicesBO;
	private SmsServicesSC criteria = new SmsServicesSC();

    public String constructSmsServicesLookup()
    {
	try
	{
	    String[] name = {"COMP_CODE", "CODE", "SERVICE_TYPE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB"};
	    String[] colType = {"number", "number", "text", "text", "text"};
	    String[] titles = {getText("compCode"), getText("Code_key"), getText("service_type_key"), getText("Brief_Description_key"), getText("Brief_Description_key")};
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "COMP_CODE", "CODE", "SERVICE_TYPE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB" };
		colType = new String[] {"number", "number", "text", "text", "text"};
		titles = new String[] {getText("comp_code_key"), getText("CODE_key"), getText("service_type_key"), getText("BRIEF_DESC_ENG_key"), getText("BRIEF_DESC_ARAB_key")};
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("SmsServices_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SmsServicesLookupAction_fillSmsServicesLookup");
	    /*int cols = name.length;

			for(int i = 0; i < cols; i++)
			{
				LookupGridColumn gridColumn = new LookupGridColumn();
				gridColumn.setName(name[i]);
				gridColumn.setIndex(name[i]);
				gridColumn.setColType(colType[i]);
				gridColumn.setTitle(titles[i]);
				gridColumn.setSearch(true);
				lsGridColumn.add(gridColumn);
			}*/
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructSmsServicesLookup of SmsServicesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillSmsServicesLookup()
    {
	try
	{
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(smsServicesBO.returnSmsServicesLookupCount(criteria));
	    }
	    setGridModel(smsServicesBO.returnSmsServicesLookup(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public SmsServicesSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(SmsServicesSC criteria)
    {
	this.criteria = criteria;
    }

    public void setSmsServicesBO(SmsServicesBO smsServicesBO)
    {
	this.smsServicesBO = smsServicesBO;
    }
}
