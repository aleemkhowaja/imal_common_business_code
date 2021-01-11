package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.race.RaceBO;
import com.path.dbmaps.vo.RACEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.race.RaceSC;

public class RaceLookupAction extends LookupBaseAction {
	
	

	private RaceSC criteria = new RaceSC();
	private RaceBO raceBO;
	
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
	    String[] name = {"CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                             "LONG_DESC_ENG",
                             "LONG_DESC_ARAB",
                             "ADDITIONAL_REFERENCE"};	
	    String[] colType = {"text","text", "text", "text", "text", "text"};
	    String[] titles = { getText("Race_Code_key"), getText("Brief_Desc_Eng_key"),getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
                                    "BRIEF_DESC_ENG",
                                    "LONG_DESC_ENG",
                                    "ADDITIONAL_REFERENCE"};
		colType = new String[] {"text","text", "text", "text"};
		titles = new String[] { getText("Race_Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Race_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RaceLookup_fillRaceLookup");
	    lookup(grid,criteria,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Race data filtered by the defined criteria
     * 
     * @return
     */
    public String fillRaceLookup()
    {
	try
	{
	    List<RACEVO> raceVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(criteria))
	    {
	    	setRecords(raceBO.raceListCount(criteria));
	    }
	    raceVOList = raceBO.raceList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(raceVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillRaceLookup of RaceLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public RaceSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(RaceSC criteria)
	{
		this.criteria = criteria;
	}

	public void setRaceBO(RaceBO raceBO)
	{
		this.raceBO = raceBO;
	}
    

}
