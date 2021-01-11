package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.procedureid.ProcedureIdBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public class ProcedureIdLookupAction extends LookupBaseAction
{
    private ProcedureIdSC procedureIdSC = new ProcedureIdSC();
    private ProcedureIdBO procedureIdBO;

    @Override
    public Object getModel()
    {
	return procedureIdSC;
    }

    /**
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "procId", "procName" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("proc_id_key"), getText("proc_name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("TypesList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProcedureIdLookup_fillProcedureIdLkp");

	    lookup(grid, procedureIdSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * 
     */
    public String fillProcedureIdLkp()
    {
	try
	{
	    List<ProcedureIdCO> typesCOList;
	    setSearchFilter(procedureIdSC);
	    copyproperties(procedureIdSC);

	    SessionCO sessionCO = returnSessionObject();
	    procedureIdSC.setUserId(sessionCO.getUserName());
	    procedureIdSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(procedureIdBO.getprocedureIdCount(procedureIdSC));
	    }
	    typesCOList = procedureIdBO.getprocedureIdList(procedureIdSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(typesCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setProcedureIdBO(ProcedureIdBO procedureIdBO)
    {
	this.procedureIdBO = procedureIdBO;
    }

    public String constructProcedureLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "procNames", "procDesc" };
	    String[] colType = { "text", "text" };
	    String[] titles = { getText("proc_name_key"), getText("proc_desc_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("TypesList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProcedureIdLookup_fillProcedureLkp");

	    lookup(grid, procedureIdSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * 
     */
    public String fillProcedureLkp()
    {
	try
	{
	    List<ProcedureIdCO> typesCOList;
	    setSearchFilter(procedureIdSC);
	    copyproperties(procedureIdSC);

	    SessionCO sessionCO = returnSessionObject();
	    procedureIdSC.setUserId(sessionCO.getUserName());
	    procedureIdSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(procedureIdBO.getprocedureCount(procedureIdSC));
	    }
	    typesCOList = procedureIdBO.getprocedureList(procedureIdSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(typesCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

}
