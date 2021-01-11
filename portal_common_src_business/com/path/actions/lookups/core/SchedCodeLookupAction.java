package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.schedcode.SchedCodeLookupBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.schedcode.SchedCodeLookupCO;
import com.path.vo.core.schedcode.SchedCodeLookupSC;

public class SchedCodeLookupAction extends LookupBaseAction
{
    private SchedCodeLookupBO schedCodeLookupBO;
    private SchedCodeLookupSC schedCodeLookupSC = new SchedCodeLookupSC();

    @Override
    public Object getModel()
    {
	return schedCodeLookupSC;
    }

    public String constructSchedCodeLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "crmVisitSchedVO.COMP_CODE", "crmVisitSchedVO.BRANCH_CODE", "crmVisitSchedVO.CODE",
		    "crmVisitSchedVO.USER_ID", "crmVisitSchedVO.CIF_NO", "crmVisitSchedVO.VISIT_REASON",
		    "crmVisitSchedVO.VISIT_DATE", "crmVisitSchedVO.STATUS", "shortNameEng" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Comp_Code_key"), getText("Branch_Code_key"), getText("Code_key"),
		    getText("User_ID_key"), getText("Cif_No_key"), getText("Visit_Reason_key"),
		    getText("Visit_Date_key"), getText("Status_key"), getText("Short_Name_Eng_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Visits Scheduler"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SchedCode_fillSchedCodeLookup");
	    lookup(grid, schedCodeLookupSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillSchedCodeLookup()
    {
	try
	{
	    List<SchedCodeLookupCO> schedCodeLookupCOList;
	    setSearchFilter(schedCodeLookupSC);
	    copyproperties(schedCodeLookupSC);
	    SessionCO sessionCO = returnSessionObject();
	    schedCodeLookupSC.setCompCode(sessionCO.getCompanyCode());
	    schedCodeLookupSC.setBranchCode(sessionCO.getBranchCode());
	    schedCodeLookupSC.setCode(sessionCO.getCtsTellerVO().getCODE());
	    schedCodeLookupSC.setUserId(sessionCO.getUserName());
	    schedCodeLookupSC.setTellerCode(sessionCO.getCtsTellerVO().getCODE());

	    if(checkNbRec(schedCodeLookupSC))
	    {
		setRecords(schedCodeLookupBO.returnSchedCodeLookupCount(schedCodeLookupSC));
	    }
	    schedCodeLookupCOList = schedCodeLookupBO.returnSchedCodeLookup(schedCodeLookupSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(schedCodeLookupCOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillSchedCodeLookup of SchedCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public SchedCodeLookupSC getSchedCodeLookupSC()
    {
	return schedCodeLookupSC;
    }

    public void setSchedCodeLookupSC(SchedCodeLookupSC schedCodeLookupSC)
    {
	this.schedCodeLookupSC = schedCodeLookupSC;
    }

    public void setSchedCodeLookupBO(SchedCodeLookupBO schedCodeLookupBO)
    {
	this.schedCodeLookupBO = schedCodeLookupBO;
    }
}
