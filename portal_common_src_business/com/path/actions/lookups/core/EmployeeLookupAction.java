package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.employee.EmployeeBO;
import com.path.dbmaps.vo.EMPVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.employee.EmployeeSC;

public class EmployeeLookupAction extends LookupBaseAction
{

    private EmployeeBO employeeBO;
    private EmployeeSC criteria = new EmployeeSC();

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
	    String[] name = { "BRANCH_CODE", "EMPLOYEE_ID", "FULL_NAME_ENG", };
	    String[] colType = { "number", "number", "text" };
	    String[] titles = { getText("Branch_Code_key"), getText("Officer_ID_key"), getText("Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_for_Officer_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Employee_fillEmployeeLookup");

	    List<LookupGridColumn> gridColumn = returnStandarColSpecs(name, colType, titles);
	    for(int i = 0; i < name.length; i++)
	    {
		if("BRANCH_CODE".equals(gridColumn.get(i).getName()))
		{
		    gridColumn.get(i).setLeadZeros("4");
		}
		else if("EMPLOYEE_ID".equals(gridColumn.get(i).getName()))
		{
		    gridColumn.get(i).setLeadZeros("8");
		}
	    }

	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    /**
     * Fill the lookup for Employee data filtered by the defined criteria
     * 
     * @return
     */
    public String fillEmployeeLookup()
    {
	try
	{
	    List<EMPVO> employeeVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(BigDecimal.ZERO);

	    if(checkNbRec(criteria))
	    {
		setRecords(employeeBO.employeeListCount(criteria));
	    }
	    employeeVOList = employeeBO.employeeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(employeeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillEmployeeLookup of EmployeeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public EmployeeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(EmployeeSC criteria)
    {
	this.criteria = criteria;
    }

    public void setEmployeeBO(EmployeeBO employeeBO)
    {
	this.employeeBO = employeeBO;
    }

}
