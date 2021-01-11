package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.division.DivisionBO;
import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.division.DivisionSC;

public class DivisionLookupAction extends LookupBaseAction
{

    private DivisionBO divisionBO;
    private DivisionSC divisionSC = new DivisionSC();

    @Override
    public Object getModel()
    {
	return divisionSC;
    }

    /**
     * Construct Division Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "DIVISION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Division_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "DIVISION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Division_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_Divisions_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Division_fillDivisionLookup");
	    lookup(grid, divisionSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /**
     * Anand,09/05/2017,TP#487954
     * @return
     */
    public String constructDivisionLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "DIVISION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "COMP_CODE" };
	    String[] colType = { "number", "text", "text", "text", "text", "number" };
	    String[] titles = { getText("Division_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("compCode") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "DIVISION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "COMP_CODE" };
		colType = new String[] { "number", "text", "text", "number" };
		titles = new String[] { getText("Division_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("compCode") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_Divisions_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Division_fillDivisionLookup");
	    lookup(grid, divisionSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Division data filtered by the defined criteria
     * 
     * @return
     */
    public String fillDivisionLookup()
    {
	try
	{
	    List<DIVISIONSVO> divisionVOList;
	    setSearchFilter(divisionSC);
	    copyproperties(divisionSC);
	    SessionCO sessionCO = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(divisionSC.getCompCode()))
	    {
		divisionSC.setCompCode(sessionCO.getCompanyCode());
	    }
	    if(checkNbRec(divisionSC))
	    {
		setRecords(divisionBO.divisionListCount(divisionSC));
	    }
	    divisionVOList = divisionBO.divisionList(divisionSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(divisionVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of DivisionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DivisionSC getDivisionSC()
    {
	return divisionSC;
    }

    public void setDivisionSC(DivisionSC divisionSC)
    {
	this.divisionSC = divisionSC;
    }

    public void setDivisionBO(DivisionBO divisionBO)
    {
	this.divisionBO = divisionBO;
    }

}
