package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.queryid.QueryIdBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public class QueryIdLookupAction extends LookupBaseAction
{
    private final QueryIdSC queryIdSC = new QueryIdSC();
    private QueryIdBO queryIdBO;

    @Override
    public Object getModel()
    {
	return queryIdSC;
    }

    /**
     * Construct criteria Query Id Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "queryId", "queryName" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("Query_Id_key"), getText("Query_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("TypesList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/QueryIdLookup_fillCriteriaQueryIdLkp");

	    lookup(grid, queryIdSC, name, colType, titles);
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
    public String fillCriteriaQueryIdLkp()
    {
	try
	{
	    List<QueryIdCO> typesCOList;
	    setSearchFilter(queryIdSC);
	    copyproperties(queryIdSC);

	    SessionCO sessionCO = returnSessionObject();
	    queryIdSC.setUserId(sessionCO.getUserName());
	    queryIdSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(queryIdBO.getcriteriaQueryIdCount(queryIdSC));
	    }
	    typesCOList = queryIdBO.getcriteriaQueryIdList(queryIdSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(typesCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setQueryIdBO(QueryIdBO queryIdBO)
    {
	this.queryIdBO = queryIdBO;
    }

}
