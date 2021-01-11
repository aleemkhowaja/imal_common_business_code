package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cifprofile.CifProfileBO;
import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifprofile.CifProfileSC;

public class CifProfileLookupAction extends LookupBaseAction
{
    private CifProfileBO cifProfileBO;
    private CifProfileSC cifProfileSC = new CifProfileSC();
    
    @Override
    public Object getModel()
    {
	return cifProfileSC;
    }

    /**
     * Construct CifProfile Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB",
		    "LONG_NAME_ARAB", "ADDITIONAL_REFERENCE"};
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), 
		    getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Arab_key"),getText("Additional_Reference_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "ADDITIONAL_REFERENCE"};
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), 
			    getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Additional_Reference_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_CIF_Profile_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifProfile_fillCifProfileLookup");
	    lookup(grid, cifProfileSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for CifProfile data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCifProfileLookup()
    {
	try
	{
	    List<CIF_PROFILEVO> cifProfileVOList;
	    setSearchFilter(cifProfileSC);
	    copyproperties(cifProfileSC);
	    SessionCO sessionCO = returnSessionObject();
	    cifProfileSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(cifProfileSC))
	    {
		setRecords(cifProfileBO.cifProfileListCount(cifProfileSC));
	    }
	    cifProfileVOList = cifProfileBO.cifProfileList(cifProfileSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifProfileVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CifProfileSC getCifProfileSC()
    {
	return cifProfileSC;
    }

    public void setCifProfileSC(CifProfileSC cifProfileSC)
    {
	this.cifProfileSC = cifProfileSC;
    }

    public void setCifProfileBO(CifProfileBO cifProfileBO)
    {
	this.cifProfileBO = cifProfileBO;
    }

}
