/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.unit.UnitsBO;
import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsLookupAction.java used to
 */
public class UnitsLookupAction extends LookupBaseAction
{
    
    private UnitsBO unitsBO;
    private UnitSC unitSC = new UnitSC();
    
    /**
     * Construct Units Lookup based on the VO returned in the
     * resultMap.
     * window : w_lookup_units
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names 
	    String[] name = { "DIVISION_CODE", "DEPT_CODE", "UNIT_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG","LONG_DESC_ENG","BRIEF_DESC_ARAB","LONG_DESC_ARAB"};
	    String[] colType = { "number", "number", "number", "text", "text","text","text","text" };
	    String[] titles = { getText("Division_key"), getText("Department_Code_key"), getText("Unit_key"), getText("Additional_Ref_key"),
		    getText("Brief_Desc_Eng_key"),getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]  { "DIVISION_CODE", "DEPT_CODE", "UNIT_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG","LONG_DESC_ENG"};
		colType = new String[] { "number", "number", "number", "text", "text","text"};
		titles = new String[]  { getText("Division_key"), getText("Department_Code_key"), getText("Unit_key"), getText("Additional_Ref_key"),
			    getText("Brief_Desc_Eng_key"),getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Unit_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Units_fillUnitsLookup");
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
	    lookup(grid, lsGridColumn, null, unitSC);
	    */
	    lookup(grid,unitSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for Units data filtered by the defined criteria
     * 
     * @return
     */
    public String fillUnitsLookup()
    {
	try
	{
	    setSearchFilter(unitSC);
	    copyproperties(unitSC);
	    SessionCO sessionCO = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(unitSC.getCompCode())){
	    	 unitSC.setCompCode(sessionCO.getCompanyCode());
	    }
	   
	    if(checkNbRec(unitSC))
	    {
		setRecords(unitsBO.unitListCount(unitSC));
	    }
	    List<UNITSVO> unitVOList = unitsBO.unitList(unitSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(unitVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of UnitsLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @return the unitSC
     */
    @Override
    public Object getModel()
    {
        return unitSC;
    }
    /**
     * @return the unitSC
     */
    public UnitSC getUnitSC()
    {
        return unitSC;
    }
    /**
     * @param unitSC the unitSC to set
     */
    public void setUnitSC(UnitSC unitSC)
    {
        this.unitSC = unitSC;
    }
    /**
     * @param unitsBO the unitsBO to set
     */
    public void setUnitsBO(UnitsBO unitsBO)
    {
        this.unitsBO = unitsBO;
    }
}
