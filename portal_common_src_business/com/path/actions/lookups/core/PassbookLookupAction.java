package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.passbook.PassbookBO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.passbook.PassbookSC;

public class PassbookLookupAction extends LookupBaseAction {
	
	
	private PassbookSC criteria = new PassbookSC();
	private PassbookBO passbookBO;
	
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
	    String[] name = {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG","BRIEF_NAME_ARAB","LONG_NAME_ARAB","PASSBOOK_LAYOUT"};	
	    String[] colType = { "number", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),getText("Short_Name_Arab_key"), 
	    		getText("Long_Name_Arab_key"),getText("Passbook_Layout_key")};


	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG","PASSBOOK_LAYOUT"};
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),getText("Passbook_Layout_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Passbook_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/PassbookLookup_fillPassbookLookup");
	    
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Passbook data filtered by the defined criteria
     * 
     * @return
     */
    public String fillPassbookLookup()
    {
	try
	{
	    List<CTSPASSBOOK_TYPEVO> passbookVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLang(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.PASSBOOK_LAYOUT_LOV_TYPE);
	    if(checkNbRec(criteria))
	    {
		setRecords(passbookBO.passbookListCount(criteria));
	    }
	    passbookVOList = passbookBO.passbookList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(passbookVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillPassbookLookup of PassbookLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public PassbookSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(PassbookSC criteria)
	{
		this.criteria = criteria;
	}

	public void setPassbookBO(PassbookBO passbookBO)
	{
		this.passbookBO = passbookBO;
	}



	

}
