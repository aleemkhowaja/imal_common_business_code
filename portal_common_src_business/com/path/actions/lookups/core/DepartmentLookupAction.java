package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.department.DepartmentBO;
import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.department.DepartmentSC;

public class DepartmentLookupAction extends LookupBaseAction
{

    private DepartmentBO departmentBO;
    private DepartmentSC departmentSC = new DepartmentSC();
    private BigDecimal DIVISION_CODE;

    @Override
    public Object getModel()
    {
	return departmentSC;
    }

    /**
     * Construct Department Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "DEPT_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Department_Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "DEPT_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Department_Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_for_Department_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Department_fillDepartmentLookup");

	    lookup(grid, departmentSC, name, colType, titles);
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
    public String constructDepartmentLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "DEPT_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "COMP_CODE", "DIVISION_CODE" };
	    String[] colType = { "number", "text", "text", "text", "text", "number", "number" };
	    String[] titles = { getText("Department_Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"),
		    getText("compCode"), getText("Division_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "DEPT_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "COMP_CODE", "DIVISION_CODE" };
		colType = new String[] { "number", "text", "text", "number", "number" };
		titles = new String[] { getText("Department_Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("compCode"), getText("Division_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_for_Department_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Department_fillDepartmentLookup");
	    
	    lookup(grid, departmentSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Department data filtered by the defined criteria
     * 
     * @return
     */
    public String fillDepartmentLookup()
    {
	try
	{
	    List<DEPARTMENTSVO> departmentVOList;
	    setSearchFilter(departmentSC);
	    copyproperties(departmentSC);
	    SessionCO sessionCO = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(departmentSC.getCompCode()))
	    {
	    	departmentSC.setCompCode(sessionCO.getCompanyCode());
	    }
	    if(NumberUtil.nullToZero(DIVISION_CODE)!=null)
	    {
	    	departmentSC.setDivisionCode(NumberUtil.nullToZero(DIVISION_CODE));
	    }
	    if(checkNbRec(departmentSC))
	    {
		setRecords(departmentBO.departmentListCount(departmentSC));
	    }
	    departmentVOList = departmentBO.departmentList(departmentSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(departmentVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of DepartmentLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DepartmentSC getDepartmentSC()
    {
	return departmentSC;
    }

    public void setDepartmentSC(DepartmentSC departmentSC)
    {
	this.departmentSC = departmentSC;
    }

    public void setDepartmentBO(DepartmentBO departmentBO)
    {
	this.departmentBO = departmentBO;
    }

    public BigDecimal getDIVISION_CODE()
    {
	return DIVISION_CODE;
    }

    public void setDIVISION_CODE(BigDecimal dIVISIONCODE)
    {
	DIVISION_CODE = dIVISIONCODE;
    }

}
