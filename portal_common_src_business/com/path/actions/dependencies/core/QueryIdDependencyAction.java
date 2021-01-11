package com.path.actions.dependencies.core;

import com.path.bo.core.queryid.QueryIdBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public class QueryIdDependencyAction extends BaseAction
{
    private QueryIdBO queryIdBO;

    private QueryIdCO queryIdCO = new QueryIdCO();
    private QueryIdSC queryIdSC = new QueryIdSC();

    @Override
    public Object getModel()
    {
	return queryIdSC;
    }

    /**
     * Get dependency between Types Code and Description
     * 
     * @return
     */
    public String dependencyByQueryId()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(queryIdSC.getQueryId()))
	    {
		queryIdCO = queryIdBO.dependencyByQueryId(queryIdSC);

		if(null == queryIdCO)
		{
		    queryIdCO = new QueryIdCO();
		}
	    }
	    else
	    {
		queryIdCO = new QueryIdCO();
	    }
	}
	catch(Exception e)
	{
	    queryIdCO = new QueryIdCO();
	    log.error(e, "Error in dependencyByTypes method of QueryIdDependencyAction.java");
	    handleException(e, "ERROR in Dependency", null);
	}
	return SUCCESS;
    }

    public void setQueryIdCO(QueryIdCO queryIdCO)
    {
	this.queryIdCO = queryIdCO;
    }

    public QueryIdCO getQueryIdCO()
    {
	return queryIdCO;
    }

    public void setQueryIdSC(QueryIdSC queryIdSC)
    {
	this.queryIdSC = queryIdSC;
    }

    public QueryIdSC getQueryIdSC()
    {
	return queryIdSC;
    }

    public void setQueryIdBO(QueryIdBO queryIdBO)
    {
	this.queryIdBO = queryIdBO;
    }

}
