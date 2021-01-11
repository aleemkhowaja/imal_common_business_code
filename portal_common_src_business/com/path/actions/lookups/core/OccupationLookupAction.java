package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.occupation.OccupationBO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.occupation.OccupationSC;

public class OccupationLookupAction extends LookupBaseAction
{
    
    private OccupationSC occupationSC = new OccupationSC();
    private OccupationBO occupationBO;

    @Override
    public Object getModel()
    {
	return occupationSC;
    }

    /**
     * Construct Occupation status Lookup based on the VO returned in the
     * resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "OCCUPATION_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB"};
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key") };


	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "OCCUPATION_CODE", "BRIEF_DESC_ENG"};
		colType = new String[] { "number", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_ecosector_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Occupation_fillOccupationLookup");
	    
	    lookup(grid, occupationSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Occupation data filtered by the defined criteria
     * 
     * @return
     */
    public String fillOccupationLookup()
    {
	try
	{
	    List<OCCUPATIONSVO> occupationVOList;
	    setSearchFilter(occupationSC);
	    copyproperties(occupationSC);
	    SessionCO sessionCO = returnSessionObject();
	    occupationSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(occupationSC))
	    {
		setRecords(occupationBO.occupationListCount(occupationSC));
	    }
	    occupationVOList = occupationBO.occupationList(occupationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(occupationVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of OccupationLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    
    public String constructCifOccupationStatusLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "STATUS"};
	    String[] colType = {"text"};
	    String[] titles = { getText("status_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Occupation_fillCifOccupationStatusLookup");
	    lookup(grid, occupationSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String fillCifOccupationStatusLookup()
    {
	try
	{
	    List<CIF_OCCUPATIONVO> cifOccupationStatusVOList;
	    setSearchFilter(occupationSC);
	    copyproperties(occupationSC);
	    SessionCO sessionCO = returnSessionObject();
	    occupationSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(occupationSC))
	    {
		setRecords(occupationBO.cifOccupationStatusListCount(occupationSC));
	    }
	    cifOccupationStatusVOList = occupationBO.cifOccupationStatusList(occupationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifOccupationStatusVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCifOccupationStatusLookup of OccupationLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    

    public OccupationSC getOccupationSC()
    {
	return occupationSC;
    }

    public void setOccupationSC(OccupationSC occupationSC)
    {
	this.occupationSC = occupationSC;
    }
    
    public void setOccupationBO(OccupationBO occupationBO)
    {
        this.occupationBO = occupationBO;
    }


}
