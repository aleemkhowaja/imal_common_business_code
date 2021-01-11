package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.visitreason.VisitReasonBO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.visitreason.VisitReasonSC;

public class VisitReasonLookupAction extends LookupBaseAction
{

    private VisitReasonBO visitReasonBO;
    private VisitReasonSC visitReasonSC = new VisitReasonSC();

    @Override
    public Object getModel()
    {
	return visitReasonSC;
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
	    System.out.println("LOOKUPS");
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_VisitReason_key"));
	    grid.setRowNum("7");
	    grid.setUrl("/pathdesktop/VisitReasonLookup_fillDivisionLookup");
	    lookup(grid, visitReasonSC, name, colType, titles);
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
	    List<CRM_PARAMVO> visitReasonVOList;
	    // visitReasonSC.setParamType("P");
	    setSearchFilter(visitReasonSC);
	    copyproperties(visitReasonSC);
	    SessionCO sessionCO = returnSessionObject();

	    visitReasonSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(visitReasonSC))
	    {
		setRecords(visitReasonBO.visitReasonListCount(visitReasonSC));
	    }
	    visitReasonVOList = visitReasonBO.visitReasonList(visitReasonSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(visitReasonVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VisitReasonLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public VisitReasonSC getVisitReasonSC()
    {
	return visitReasonSC;
    }

    public void setVisitReasonSC(VisitReasonSC visitReasonSC)
    {
	this.visitReasonSC = visitReasonSC;
    }

    public void setVisitReasonBO(VisitReasonBO visitReasonBO)
    {
	this.visitReasonBO = visitReasonBO;
    }

}