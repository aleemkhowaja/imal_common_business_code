package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.ctsclearinghouse.CtsClearingHouseBO;
import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseLookupAction.java used to create the lookup for ClearingHouse 
 */
public class CtsClearingHouseLookupAction extends LookupBaseAction
{
    private List<CTSCLEARINGHOUSEVO> ctsClearingHouseVOList;
    private final CtsClearingHouseSC criteria = new CtsClearingHouseSC();
    private CtsClearingHouseBO ctsClearingHouseBO;
    private BigDecimal curCode;

    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookupByComp()
    {
	// Design the Grid by defining the column model and column names
	String[] name = { "ctsClearingHouseVO.CODE", "ctsClearingHouseVO.BRIEF_NAME_ENG", "ctsClearingHouseVO.LONG_NAME_ENG"
			, "ctsClearingHouseVO.BRIEF_NAME_ARAB", "ctsClearingHouseVO.LONG_NAME_ARAB"};
	String[] colType = { "number", "text", "text", "text", "text" };
	String[] titles = { getText("Code__key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key")
			, getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key")};
	
	/* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	 if(returnSessionObject().getHideArabicColumns())
	 {
	     name = new String[] {"ctsClearingHouseVO.CODE", "ctsClearingHouseVO.BRIEF_NAME_ENG", "ctsClearingHouseVO.LONG_NAME_ENG"};
	     colType = new String[] { "number", "text", "text"};
	     titles = new String[] { getText("Code__key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key")};
	}
	try
	{
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Code__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsClearingHouseLookup_fillClearingHouseByCompLkp");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in safeBoxLookup of SafeBoxLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
		    "CY_CODE",
		    "CLEARING_DAYS",
		    "BRIEF_NAME_ENG",
		    "LONG_NAME_ENG",
		    "BRIEF_NAME_ARAB",
		    "LONG_NAME_ARAB"
	    };	
	    String[] colType = { "number", "number", "text","text","text","text","text"};
	    String[] titles = { getText("Code__key"), getText("Cy_Code_key"),getText("Clearing_Days_key"),
		    getText("Short_name_eng_key"),getText("Long_Name_eng_key"),getText("Short_Name_Arab_key"),getText("Long_Name_Arab_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
        			    "CY_CODE",
        			    "CLEARING_DAYS",
        			    "BRIEF_NAME_ENG",
        			    "LONG_NAME_ENG" };
		colType = new String[] { "number", "number", "text","text","text"};
		titles = new String[] { getText("Code__key"), getText("Cy_Code_key"),getText("Clearing_Days_key"),
			    getText("Short_name_eng_key"),getText("Long_Name_eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Clearing_House_Details_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsClearingHouseLookup_fillClearingHouseLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsClearingHouseLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup ClearingHouse data filtered by the defined criteria
     * 
     * @return
     */
    public String fillClearingHouseLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    //criteria.setCurrencyCode(new BigDecimal(1));curCode
	    criteria.setCurrencyCode(curCode);
	    if(checkNbRec(criteria))
	    {
		setRecords(ctsClearingHouseBO.ctsClearingHouseListCount(criteria));
	    }
	    ctsClearingHouseVOList = ctsClearingHouseBO.ctsClearingHouseList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ctsClearingHouseVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillClearingHouseLookup of CtsClearingHouseLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String fillClearingHouseByCompLkp()
    {
    	try
    	{
    		setSearchFilter(criteria);
    		copyproperties(criteria);
    		SessionCO sessionCO = returnSessionObject();
    		criteria.setCompCode(sessionCO.getCompanyCode());
    		
    		if(checkNbRec(criteria))
    		{
    			setRecords(ctsClearingHouseBO.clearingHouseByCompLkpCount(criteria));
    		}
    		ctsClearingHouseVOList = ctsClearingHouseBO.clearingHouseByCompLkpList(criteria);
    		// set the collection into gridModel attribute defined at JSP grid
    		setGridModel(ctsClearingHouseVOList);
    		
    	}
    	catch(Exception e)
    	{
    		log.error(e, "Error in fillClearingHouseLookup of CtsClearingHouseLookupAction");
    		 handleException(e, null, null);
    	}
    	return SUCCESS;
    }
    
    
    public void setCtsClearingHouseBO(CtsClearingHouseBO ctsClearingHouseBO)
    {
	this.ctsClearingHouseBO = ctsClearingHouseBO;
    }

    public BigDecimal getCurCode()
    {
	return curCode;
    }

    public void setCurCode(BigDecimal curCode)
    {
	this.curCode = curCode;
    }


}
