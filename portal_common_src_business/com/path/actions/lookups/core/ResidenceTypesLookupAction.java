package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.residencetypes.ResidenceTypesBO;
import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

public class ResidenceTypesLookupAction extends LookupBaseAction {
	
	

	private ResidenceTypesSC criteria = new ResidenceTypesSC();
	private ResidenceTypesBO residenceTypesBO;
	
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
					         "ADDITIONAL_REFERENCE"                     
						     };	
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]  {"CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE" };	
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[]  { getText("Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Residence_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ResidenceTypes_fillResidenceTypeLookup");
	  /*  int cols = name.length;

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
     * Fill the lookup Residence Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillResidenceTypeLookup()
    {
	try
	{
	    List<RESIDENCE_TYPESVO> residenceTypesVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(residenceTypesBO.residenceTypesListCount(criteria));
	    }
	    residenceTypesVOList = residenceTypesBO.residenceTypesList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(residenceTypesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillNationalityLookup of ResidenceTypesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public ResidenceTypesSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ResidenceTypesSC criteria)
	{
		this.criteria = criteria;
	}

	public void setResidenceTypesBO(ResidenceTypesBO residenceTypesBO)
	{
		this.residenceTypesBO = residenceTypesBO;
	}

	
    

}
