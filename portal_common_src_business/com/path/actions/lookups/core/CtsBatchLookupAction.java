package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.ctsbatch.CtsBatchBO;
import com.path.dbmaps.vo.CTSBATCHVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsbatch.CtsBatchSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          BatchLookupAction.java used to load batch lookups
 */
public class CtsBatchLookupAction extends LookupBaseAction
{
    private CtsBatchSC criteria = new CtsBatchSC();
    private List<CTSBATCHVO> batchVOList;
    private CtsBatchBO ctsBatchBO;

    private static final String CLASS_URL = "/pathdesktop/CtsBatchLookupAction_";

    
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    
    /**
     * PB : w_lookup_batch
     */
    public String batchLookup()
    {
	// Design the Grid by defining the column model and column names
	String[] name = { "BATCH_NO", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB" };
	String[] colType = { "number", "text", "text" };
	String[] titles = { getText("BATCH_NO_key"), getText("BATCH_NAME_key"), getText("Brief_Desc_Arab_key")};
	try
	{

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("BATCH_NO_key"));
	    grid.setRowNum("5");
	    grid.setUrl(CLASS_URL + "fillBatchLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup reason data filtered by the defined criteria
     * 
     */
    public String fillBatchLookup() throws BaseException
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    if(getRecords() == 0)
	    {
		setRecords(ctsBatchBO.batchLookupCount(criteria));
	    }
	    batchVOList = ctsBatchBO.batchLookupList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(batchVOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CtsBatchSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CtsBatchSC criteria)
    {
	this.criteria = criteria;
    }

    public List<CTSBATCHVO> getBatchVOList()
    {
	return batchVOList;
    }

    public void setBatchVOList(List<CTSBATCHVO> batchVOList)
    {
	this.batchVOList = batchVOList;
    }

    public void setCtsBatchBO(CtsBatchBO ctsBatchBO)
    {
	this.ctsBatchBO = ctsBatchBO;
    }

}
