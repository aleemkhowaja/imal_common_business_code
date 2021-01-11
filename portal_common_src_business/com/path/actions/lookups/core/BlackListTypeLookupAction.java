package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.blacklisttype.BlackListTypeBO;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public class BlackListTypeLookupAction extends LookupBaseAction {
	
	
	private BlackListTypeSC criteria = new BlackListTypeSC();
	private BlackListTypeBO blackListTypeBO;
	
	@Override
	public Object getModel()
    {
		return criteria;
    }
	 
	public String constructLookup()
    {
	try
	{	
		String[] name = { "CODE",
                          "BRIEF_NAME_ENG",
                          "BRIEF_NAME_ARAB",
                          "LONG_NAME_ENG",
                          "LONG_NAME_ARAB",
                        };	
	    String[] colType = { "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", };
		colType = new String[] { "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BlackListTypeLookup_fillBlackListTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	     
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BlackListTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillBlackListTypeLookup()
    {
	try
	{
	    List<MOSBLACKLIST_TYPEVO> blackListTypeVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(blackListTypeBO.blackLstTypeListCount(criteria));
	    }
	    blackListTypeVOList = blackListTypeBO.blackLstTypeList(criteria);
	    
	    setGridModel(blackListTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillBlackListTypeLookup of BlackListTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public BlackListTypeSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(BlackListTypeSC criteria)
	{
		this.criteria = criteria;
	}

	public void setBlackListTypeBO(BlackListTypeBO blackListTypeBO)
	{
		this.blackListTypeBO = blackListTypeBO;
	}
}
