package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.employmentstatus.EmploymentStatusBO;
import com.path.dbmaps.vo.CTS_EMPLOYMENT_STATUSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.employmentstatus.EmploymentStatusSC;

public class EmploymentStatusLookupAction extends LookupBaseAction
{

    private EmploymentStatusBO employmentStatusBO;
    private EmploymentStatusSC employmentStatusSC = new EmploymentStatusSC();
    private BigDecimal EMPLOYMENT_STATUS_CODE;
    private CTS_EMPLOYMENT_STATUSVO ctsEmploymentStatusVO = new CTS_EMPLOYMENT_STATUSVO();

    @Override
    public Object getModel()
    {
	return employmentStatusSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "EMPLOYMENT_STATUS_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EmploymentStatusLookup_fillEmploymentStatusLookup");
	    lookup(grid, employmentStatusSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillEmploymentStatusLookup()
    {
	try
	{
	    List<CTS_EMPLOYMENT_STATUSVO> employmentStatusVOList;
	    setSearchFilter(employmentStatusSC);
	    copyproperties(employmentStatusSC);
	    SessionCO sessionCO = returnSessionObject();
	    employmentStatusSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(employmentStatusSC))
	    {
		setRecords(employmentStatusBO.empStatusListCount(employmentStatusSC));
	    }
	    employmentStatusVOList = employmentStatusBO.empStatusList(employmentStatusSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(employmentStatusVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of EmploymentStatusLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByEmpStatus()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    employmentStatusSC.setCompCode(sessionCO.getCompanyCode());
	    employmentStatusSC.setCode(EMPLOYMENT_STATUS_CODE);
	    if(NumberUtil.isEmptyDecimal(EMPLOYMENT_STATUS_CODE))
	    {
	    	ctsEmploymentStatusVO = new CTS_EMPLOYMENT_STATUSVO();
	    }
	    else
	    {
	    	ctsEmploymentStatusVO = employmentStatusBO.returnEmpStatusCodeById(employmentStatusSC);
	    }
	   
	}
	catch(Exception e)
	{
		ctsEmploymentStatusVO = new CTS_EMPLOYMENT_STATUSVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public EmploymentStatusSC getEmploymentStatusSC() {
		return employmentStatusSC;
	}

	public void setEmploymentStatusSC(EmploymentStatusSC employmentStatusSC) {
		this.employmentStatusSC = employmentStatusSC;
	}

	public BigDecimal getEMPLOYMENT_STATUS_CODE() {
		return EMPLOYMENT_STATUS_CODE;
	}

	public void setEMPLOYMENT_STATUS_CODE(BigDecimal eMPLOYMENT_STATUS_CODE) {
		EMPLOYMENT_STATUS_CODE = eMPLOYMENT_STATUS_CODE;
	}

	public CTS_EMPLOYMENT_STATUSVO getCtsEmploymentStatusVO() {
		return ctsEmploymentStatusVO;
	}

	public void setCtsEmploymentStatusVO(CTS_EMPLOYMENT_STATUSVO ctsEmploymentStatusVO) {
		this.ctsEmploymentStatusVO = ctsEmploymentStatusVO;
	}

	public void setEmploymentStatusBO(EmploymentStatusBO employmentStatusBO) {
		this.employmentStatusBO = employmentStatusBO;
	}
  

}
