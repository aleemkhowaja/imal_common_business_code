package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.religion.ReligionBO;
import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.religion.ReligionSC;

public class ReligionLookupAction extends LookupBaseAction {
	
	

	private ReligionSC criteria = new ReligionSC();
	private ReligionBO religionBO;
	
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
	    String[] name = {"RELIGION_CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                            };	
	    String[] colType = {"text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "RELIGION_CODE", "BRIEF_DESC_ENG" };
		colType = new String[] { "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Religion_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ReligionLookup_fillReligionLookup");
	   /* int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	     lookup(grid, lsGridColumn, null, criteria);
	     */
	    lookup(grid,criteria,name,colType,titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Religion data filtered by the defined criteria
     * 
     * @return
     */
    public String fillReligionLookup()
    {
	try
	{
	    List<RELIGIONVO> religionVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(religionBO.religionListCount(criteria));
	    }
	    religionVOList = religionBO.religionList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(religionVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillReligionLookup of ReligionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public ReligionSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ReligionSC criteria)
	{
		this.criteria = criteria;
	}

	public void setReligionBO(ReligionBO religionBO)
	{
		this.religionBO = religionBO;
	}

	
    

}
