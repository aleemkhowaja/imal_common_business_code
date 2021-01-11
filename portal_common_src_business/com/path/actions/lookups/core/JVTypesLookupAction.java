package com.path.actions.lookups.core;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.jvtypes.JVTypesBO;
import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.jvtypes.JVTypeSC;

public class JVTypesLookupAction extends LookupBaseAction
{
    	private JVTypesBO jvTypesBO;
	
	private JVTypeSC criteria = new JVTypeSC();
	private List<JV_TYPEVO> jvTYPEVOs = new ArrayList<JV_TYPEVO>();
	
	


    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "TYPE_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG"};
	    String[] colType = { "number", "text", "text"};
	    String[] titles = { getText("Code__key"), getText("Brief_Description_key"), getText("Long_Description_key")};

	    if("true".equals(criteria.getShowAddRef()))
	    {
	    	name = new String[]{ "TYPE_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG"};
	 	    colType = new String[]{ "number", "text", "text", "text"};
	 	    titles = new String[]{ getText("Code__key"), getText("Additional_Reference_key"), getText("Brief_Description_key"), getText("Long_Description_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Currency_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/JVTypesLookup_fillJVTypeLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillJVTypeLookup() 
    {	
	try {
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
			
	    if(checkNbRec(criteria))
	    {
	    setRecords(jvTypesBO.getJVTypeLookupCount(criteria));
	    }
	    jvTYPEVOs =  jvTypesBO.getJVTypeLookupList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(jvTYPEVOs);
	    } catch (Exception e) {
		log.error(e, "Error in fillLookupData of fillJVTypeLookup");
		 handleException(e, null, null);
	    }
		return SUCCESS;
	}
	
    
	public List<JV_TYPEVO> getJvTYPEVOs()
	{
	    return jvTYPEVOs;
	}

	public void setJvTYPEVOs(List<JV_TYPEVO> jvTYPEVOs)
	{
	    this.jvTYPEVOs = jvTYPEVOs;
	}

	@Override
	public Object getModel()
	{
		return criteria;
	}

	public JVTypeSC getCriteria()
	{
	    return criteria;
	}

	public void setCriteria(JVTypeSC criteria)
	{
	    this.criteria = criteria;
	}

	public void setJvTypesBO(JVTypesBO jvTypesBO)
	{
	    this.jvTypesBO = jvTypesBO;
	}

}
