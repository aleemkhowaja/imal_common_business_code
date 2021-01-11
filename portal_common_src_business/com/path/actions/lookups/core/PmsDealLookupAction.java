/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.pmsdeal.PmsDealBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * PmsDeal.java used to
 */
public class PmsDealLookupAction extends LookupBaseAction
{
    private PmsDealSC criteria = new PmsDealSC();
   
    private PmsDealBO pmsDealBO;
    
    public String constructLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"pmsDealVO.COMP_CODE",
		    		"pmsDealVO.BRANCH_CODE",
                             "pmsDealVO.DEAL_NO",
                             "pmsDealVO.BRIEF_NAME_ENG",
                             "pmsDealVO.LONG_NAME_ENG",
                             "pmsDealVO.SHORT_CODE",
                             "pmsDealVO.DEAL_CIF",
                             "SHORT_NAME_ENG",
                             "pmsDealVO.LONG_NAME_ENG2",
                             "pmsDealVO.BRIEF_NAME_ARAB",
                             "pmsDealVO.LONG_NAME_ARAB",
                             "pmsDealVO.LONG_NAME_ARAB2"};
	    String[] colType = { "number","number", "number", "text", "text",
		                 "text", "number", "text", "text",  "text", "text","text"};
	    String[] titles = { getText("compCode"),getText("branchCode"), getText("Deal_No_key"), getText("Brief_Name_key"),
            		        getText("Long_Name__key"),
            		        getText("Short_Code_key"), getText("Deal_Cif_key"),getText("Short_Name_key"),getText("Long_Name_2_key"),
            		        getText("Brief_Name_Arab_key"), getText("Long_Name_Arab_key"),getText("Long_Name_Arab_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/PmsDealLookup_fillLookup");
	     
	     List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
		lsGridColumn.get(0).setHidden(true);
		lsGridColumn.get(6).setHidden(true);
		lsGridColumn.get(7).setHidden(true);	
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return SUCCESS;

    }
    /**
     * 
     * Used for construction of Lookups requested By Assets Module 
     * 
     * @return
     */
    public String constructAssetsLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = { "pmsDealVO.DEAL_NO",
		    "pmsDealVO.SHORT_CODE",
		    "pmsDealVO.PROJECT_NO",
		    "pmsDealVO.BRIEF_NAME_ENG",
		    "pmsDealVO.LONG_NAME_ENG",
		    "pmsDealVO.LONG_NAME_ENG2",
		    "pmsDealVO.STATUS",
		    "pmsDealVO.TRADE_DATE",
		    "pmsDealVO.DEAL_CIF",
		    "shortNameEng" };
	    String[] colType = { "number",
		    "text",
		    "number",
		    "text",
		    "text",
		    "text",
		    "text",
		    "text",
		    "number",
		    "text"};
	    String[] titles = { getText("Deal_No_key"),
		    getText("Short_Code_key"),
		    getText("Project_No_key"),
		    getText("Brief_Name_key"),
		    getText("Long_Name__key"),
		    getText("Long_Name_2_key"),
		    getText("Status_key"),
		    getText("Trade_Date_key"),
		    getText("Deal_Cif_key"),
		    getText("Cif_Name_key")
		     };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/PmsDealLookup_fillLookup");
	    
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return SUCCESS;
    }
    /**
     * Fill the lookup  data filtered by the defined criteria
     * 
     * @return
     */
    public String fillLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	  
	    
	    if(getRecords() == 0)
	    {
		setRecords(pmsDealBO.pmsDealListCount(criteria));
	    }
	    List<PmsDealCO>  pmsDealCOList = pmsDealBO.pmsDealList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(pmsDealCOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of PmsDealLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public PmsDealSC getCriteria()
    {
        return criteria;
    }
    
    @Override
    public Object getModel()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(PmsDealSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @param pmsDealBO the pmsDealBO to set
     */
    public void setPmsDealBO(PmsDealBO pmsDealBO)
    {
        this.pmsDealBO = pmsDealBO;
    }

  
}
