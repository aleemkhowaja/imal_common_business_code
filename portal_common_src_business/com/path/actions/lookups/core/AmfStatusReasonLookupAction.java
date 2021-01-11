/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.amfstatus.AmfStatusReasonBO;
import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.amfstatus.AmfStatusSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfSuspendReasonLookupAction.java used to
 */
public class AmfStatusReasonLookupAction extends LookupBaseAction
{
    private AmfStatusReasonBO amfStatusReasonBO;
    private AmfStatusSC amfStatusSC = new AmfStatusSC();
    private String ref;
    
    /**
     * Construct Amf Status Reason Lookup based on the VO returned in the
     * resultMap.
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names 
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB"};
	    String[] colType = { "number", "text", "text"};
	    String[] titles = { getText("Code__key"), getText("Short_name_eng_key"), getText("Short_Name_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG"};
		colType = new String[] { "number", "text"};
		titles = new String[] { getText("Code__key"), getText("Short_name_eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
//	    grid.setCaption(getText("Unit_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AmfStatusReason_fillAmfStatusReasonLookup?ref="+getRef());
	    lookup(grid, amfStatusSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AmfStatusReasonLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for AmfStatusReason data filtered by the defined criteria
     * 
     * @return
     */
    public String fillAmfStatusReasonLookup()
    {
	try
	{
	    setSearchFilter(amfStatusSC);
	    copyproperties(amfStatusSC);
	    SessionCO sessionCO = returnSessionObject();
	    amfStatusSC.setCompCode(sessionCO.getCompanyCode());
	    
	    /*
	     * add orginal progref to the criteria in case there is an original
	     * progRef. this case will be exists in SAVE AS Management
	     */
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), getRef()), getRef());
	    
	    if("A001CL".equalsIgnoreCase(originalProgRef) || "A002CL".equalsIgnoreCase(originalProgRef) || "A002CLT".equalsIgnoreCase(originalProgRef)
		    || "TA001MT".equals(originalProgRef))
	    {
		amfStatusSC.setStatusType("C");
//	    else if("A001ZP".equalsIgnoreCase(getRef()) || "A002ZP".equalsIgnoreCase(getRef()))// Suspend
//	    	amfStatusSC.setStatusType("S");
		if("TA001MT".equals(originalProgRef))
		{
		    amfStatusSC.setCannotReopen(Boolean.TRUE);
		}
	    }
	    else
	    {
		amfStatusSC.setStatusType("S");
	    }
	    if(checkNbRec(amfStatusSC))
	    {
		setRecords(amfStatusReasonBO.amfStatusReasonListCount(amfStatusSC));
	    }
	    List<AMF_SUSPEND_REASONVO> amfSuspendReasonVOList = amfStatusReasonBO.amfStatusReasonList(amfStatusSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(amfSuspendReasonVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillAmfStatusReasonLookup of AmfStatusReasonLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @return the amfStatusSC
     */
    @Override
    public Object getModel()
    {
        return amfStatusSC;
    }

    /**
     * @return the amfStatusSC
     */
    public AmfStatusSC getAmfStatusSC()
    {
        return amfStatusSC;
    }

    /**
     * @param amfStatusSC the amfStatusSC to set
     */
    public void setAmfStatusSC(AmfStatusSC amfStatusSC)
    {
        this.amfStatusSC = amfStatusSC;
    }

    /**
     * @param amfStatusReasonBO the amfStatusReasonBO to set
     */
    public void setAmfStatusReasonBO(AmfStatusReasonBO amfStatusReasonBO)
    {
        this.amfStatusReasonBO = amfStatusReasonBO;
    }

	public String getRef()
	{
		return ref;
	}

	public void setRef(String ref)
	{
		this.ref = ref;
	}	
}
