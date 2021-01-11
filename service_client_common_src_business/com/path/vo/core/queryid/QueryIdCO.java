package com.path.vo.core.queryid;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class QueryIdCO extends RetailBaseVO
{

    private BigDecimal queryId;
    private String queryName;
    private String queryObject;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    public BigDecimal getQueryId()
    {
	return queryId;
    }

    public void setQueryId(BigDecimal queryId)
    {
	this.queryId = queryId;
    }

    public String getQueryName()
    {
	return queryName;
    }

    public void setQueryName(String queryName)
    {
	this.queryName = queryName;
    }

    public String getQueryObject()
    {
	return queryObject;
    }

    public void setQueryObject(String queryObject)
    {
	this.queryObject = queryObject;
    }

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}

}
