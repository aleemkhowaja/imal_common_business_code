package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.blacklistsource.BlackSourceBO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public class BlackSourceLookupAction extends LookupBaseAction {
	
    private BlackSourceSC criteria = new BlackSourceSC();
    private BlackSourceBO blackSourceBO;

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
                          "BRIEF_DESC_ENG",
                          "BRIEF_DESC_ARAB",
                          "LONG_DESC_ENG",
                          "LONG_DESC_ARAB",
                          "CIF_NO"
	    				};	
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"), getText("CIF_No_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE",
                                    "BRIEF_DESC_ENG",
                                    "LONG_DESC_ENG",
                                    "CIF_NO"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("CIF_No_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BlackSourceLookup_fillBlackSourceLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BlackSourceLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillBlackSourceLookup()
    {
	try
	{
	    List<MOSBLACKSOURCEVO> blackSourceVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(blackSourceBO.blackSourceListCount(criteria));
	    }
	    blackSourceVOList = blackSourceBO.blackSourceList(criteria);
	    
	    setGridModel(blackSourceVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillBlackSourceLookup of BlackSourceLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setBlackSourceBO(BlackSourceBO blackSourceBO)
    {
	this.blackSourceBO = blackSourceBO;
    }

    public BlackSourceSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(BlackSourceSC criteria)
    {
	this.criteria = criteria;
    }
}
