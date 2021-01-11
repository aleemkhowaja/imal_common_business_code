package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.core.facilitytype.FacilityTypeBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public class FacilityTypeLookupAction extends LookupBaseAction
{

    private FacilityTypeBO facilityTypeBO;
    private FacilityTypeSC facilityTypeSC = new FacilityTypeSC();

    @Override
    public Object getModel()
    {
	return facilityTypeSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG" , "FACILITY_CATEG"};
	    String[] colType = { "number", "text","number" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_eng_key"), "FACILITY CATEG" };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_FacilityType_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FacilityTypeLookup_fillFacilityTypeLookup");
	    int cols = name.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
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
	    lookup(grid, lsGridColumn, null, facilityTypeSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillFacilityTypeLookup() throws JSONException
    {
	try
	{
	    setSearchFilter(facilityTypeSC);
	    copyproperties(facilityTypeSC);
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
	    facilityTypeSC.setAllTypes(getText("All_types_key"));
	    if(facilityTypeSC.getFACILITY_CATEG() == null)
	    {
		facilityTypeSC.setFACILITY_CATEG(BigDecimal.ZERO);
	    }

	    if(checkNbRec(facilityTypeSC))
	    {
		setRecords(facilityTypeBO.facilityTypeListCount(facilityTypeSC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(facilityTypeBO.facilityTypeList(facilityTypeSC));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public FacilityTypeSC getFacilityTypeSC()
    {
	return facilityTypeSC;
    }

    public void setFacilityTypeSC(FacilityTypeSC facilityTypeSC)
    {
	this.facilityTypeSC = facilityTypeSC;
    }

    public void setFacilityTypeBO(FacilityTypeBO facilityTypeBO)
    {
	this.facilityTypeBO = facilityTypeBO;
    }
}
