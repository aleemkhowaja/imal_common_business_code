package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.fmsindicator.FmsIndicatorBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public class FmsIndicatorLookupAction extends LookupBaseAction
{

    FmsIndicatorSC criteria = new FmsIndicatorSC();
    private FmsIndicatorBO fmsIndicatorBO;
    private BigDecimal cifType;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String constructLookup()
    {
	try
	{
	    String[] name = { "fmsIndicatorVO.CODE", "fmsIndicatorVO.BRIEF_NAME_ENG", "fmsIndicatorVO.LONG_NAME_ENG",
		    "fmsIndicatorVO.CIF_TYPE", "CIF_TYPE_NAME", "fmsIndicatorVO.BRIEF_NAME_ARAB",
		    "fmsIndicatorVO.LONG_NAME_ARAB", "fmsIndicatorVO.INDICATOR_TYPE" };
	    String[] colType = { "number", "text", "text", "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"), "",
		    getText("Cif_Type_key"), getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key"),
		    getText("Indicator_Type_key") };
	    Boolean[] hidden = { false, false, false, true, false, true, true, false };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "fmsIndicatorVO.CODE", "fmsIndicatorVO.BRIEF_NAME_ENG",
			"fmsIndicatorVO.LONG_NAME_ENG", "fmsIndicatorVO.CIF_TYPE", "CIF_TYPE_NAME",
			"fmsIndicatorVO.INDICATOR_TYPE" };
		colType = new String[] { "number", "text", "text", "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"), "", getText("Cif_Type_key"), getText("Indicator_Type_key") };
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FmsIndicatorLookup_fillFmsIndicatorLookup");
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
		gridColumn.setHidden(hidden[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of FmsIndicatorLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillFmsIndicatorLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(fmsIndicatorBO.fmsIndicatorListCount(criteria));
	    }
	    setGridModel(fmsIndicatorBO.fmsIndicatorList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillFmsIndicatorLookup of FmsIndicatorLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructFmsCustomerIndicatorLookup()
    {
	try
	{
	    String[] name = { "fmsIndicatorVO.CODE",

	    "fmsIndicatorVO.BRIEF_NAME_ENG", "fmsIndicatorVO.LONG_NAME_ENG",

	    "fmsIndicatorVO.BRIEF_NAME_ARAB", "fmsIndicatorVO.LONG_NAME_ARAB",

	    "fmsIndicatorVO.CIF_TYPE", "fmsIndicatorVO.INDICATOR_TYPE",

	    "CIF_TYPE_NAME"

	    };
	    String[] colType = { "number", "text", "text", "text", "text", "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),
		    getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key"), getText("Cif_Type_key"),
		    getText("Indicator_Type_key"), "" };
	    Boolean[] hidden = { false, false, false, false, false, false, false, true };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "fmsIndicatorVO.CODE", "fmsIndicatorVO.BRIEF_NAME_ENG",
			"fmsIndicatorVO.LONG_NAME_ENG", "fmsIndicatorVO.CIF_TYPE", "fmsIndicatorVO.INDICATOR_TYPE",
			"CIF_TYPE_NAME" };
		colType = new String[] { "number", "text", "text", "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"), getText("Cif_Type_key"), getText("Indicator_Type_key"), "" };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FmsIndicatorLookup_fillFmsCustomerIndicatorLookup");
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
		gridColumn.setHidden(hidden[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructFmsCustomerIndicatorLookup of FmsIndicatorLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillFmsCustomerIndicatorLookup()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(criteria.getCifNo()))
	    {
		criteria.setCifNo(BigDecimal.ZERO);
	    }
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(fmsIndicatorBO.fmsCustomerIndicatorListCount(criteria));
	    }
	    setGridModel(fmsIndicatorBO.fmsCustomerIndicatorList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillFmsCustomerIndicatorLookup of FmsIndicatorLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public FmsIndicatorSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(FmsIndicatorSC criteria)
    {
	this.criteria = criteria;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public void setFmsIndicatorBO(FmsIndicatorBO fmsIndicatorBO)
    {
	this.fmsIndicatorBO = fmsIndicatorBO;
    }

}
