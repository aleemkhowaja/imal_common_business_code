package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.position.PositionBO;
import com.path.dbmaps.vo.POSITIONSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.position.PositionSC;

public class PositionLookupAction extends LookupBaseAction
{
  
    private PositionSC positionSC = new PositionSC();
    private PositionBO positionBO;


    @Override
    public Object getModel()
    {
	return positionSC;
    }

    /**
     * Construct Position Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "POSITION_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB"};
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "POSITION_CODE", "BRIEF_DESC_ENG"};
		colType = new String[] { "number", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_ecosector_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Position_fillPositionLookup");
	    lookup(grid, positionSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	

	return SUCCESS;

    }

    /**
     * Fill the lookup for PositionLookup data filtered by the defined criteria
     * 
     * @return
     */
    public String fillPositionLookup()
    {
	try
	{
	    List<POSITIONSVO> positionVOList;
	    setSearchFilter(positionSC);
	    copyproperties(positionSC);
	    SessionCO sessionCO = returnSessionObject();
	    positionSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(positionSC))
	    {
		setRecords(positionBO.positionListCount(positionSC));
	    }
	    positionVOList = positionBO.positionList(positionSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(positionVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of PositionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

  
    public PositionSC getPositionSC()
    {
	return positionSC;
    }

    public void setPositionSC(PositionSC positionSC)
    {
	this.positionSC = positionSC;
    }
    
    public void setPositionBO(PositionBO positionBO)
    {
        this.positionBO = positionBO;
    }
}
