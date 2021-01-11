/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.credittype.CreditTypeBO;
import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.credittype.CreditTypeSC;

public class CreditTypeLookupAction extends LookupBaseAction
{
    private CreditTypeSC criteria = new CreditTypeSC();
    private CreditTypeBO creditTypeBO;
    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }
    /**
     * Construct Card Type Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
                             "DESC_ENG"};
	    String[] colType = { "number", "text"};
	    String[] titles = { getText("code_key"), getText("brief_desc_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("creditTypeList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CreditTypeLookup_fillCreditTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CreditTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Card Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCreditTypeLookup()
    {
	try
	{
	    List<CTSCREDIT_TYPEVO> ctsCreditTypeList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(creditTypeBO.creditTypeListCount(criteria));
	    }
	    ctsCreditTypeList = creditTypeBO.creditTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ctsCreditTypeList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CreditTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public CreditTypeSC getCriteria()
    {
        return criteria;
    }
    public void setCriteria(CreditTypeSC criteria)
    {
        this.criteria = criteria;
    }
    public void setCreditTypeBO(CreditTypeBO creditTypeBO)
    {
        this.creditTypeBO = creditTypeBO;
    }
}