/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.ctstrsowing.CtstrsOwingBO;
import com.path.dbmaps.vo.CTSTRS_OWINGVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctstrsowing.CtstrsOwingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * OwingLookupAction.java used to
 */
public class CtstrsOwingLookupAction extends LookupBaseAction
{
 
    private List<CTSTRS_OWINGVO> owingList;
    private CtstrsOwingSC criteria = new CtstrsOwingSC();
    private CtstrsOwingBO ctstrsOwingBO;
    /**
     * 
     */
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
	    String[] name    = {"DD_BR","DD_NO","LINK_TO_TRS_BR","LINK_TO_TRS_NO","OWING_AMOUNT"};
	    String[] colType = {"number","number","number","number","number"};
	    String[] titles = { getText("dd_br_key")
		               ,getText("dd_no_key")
		               ,getText("link_to_trs_br_key")
		               ,getText("link_to_trs_no_key")
		               ,getText("owing_amount_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("CTSTRSOwing_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtstrsOwingLookupAction_fillOwingLookup");
	    lookup(grid, criteria, name, colType, titles);
	     
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    public String fillOwingLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
            criteria.setCompCode(sessionCO.getCompanyCode());
	    if(getRecords() == 0)
	    {
		setRecords(ctstrsOwingBO.ctstrsOwingListCount(criteria));
	    }
	    owingList = ctstrsOwingBO.ctstrsOwingList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(owingList);

	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in fillLookupData of OwingLookupAction");
	    handleException(ex, null, null);	    
	}
	return SUCCESS;
    }
   
 
    /**
     * @return the owingList
     */
    public List<CTSTRS_OWINGVO> getOwingList()
    {
        return owingList;
    }
    /**
     * @param owingList the owingList to set
     */
    public void setOwingList(List<CTSTRS_OWINGVO> owingList)
    {
        this.owingList = owingList;
    }
    /**
     * @return the criteria
     */
    public CtstrsOwingSC getCriteria()
    {
        return criteria;
    }
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(CtstrsOwingSC criteria)
    {
        this.criteria = criteria;
    }
    /**
     * @param ctstrsOwingBO the ctstrsOwingBO to set
     */
    public void setCtstrsOwingBO(CtstrsOwingBO ctstrsOwingBO)
    {
        this.ctstrsOwingBO = ctstrsOwingBO;
    }
}
