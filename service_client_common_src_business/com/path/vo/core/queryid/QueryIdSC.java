package com.path.vo.core.queryid;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class QueryIdSC extends GridParamsSC
{
    public QueryIdSC()
    {
	super.setSearchCols(new String[] { "queryId", "CODE", "queryName" });
    }

    private BigDecimal queryId;
    private Boolean isSegment;

    public BigDecimal getQueryId()
    {
	return queryId;
    }

    public void setQueryId(BigDecimal queryId)
    {
	this.queryId = queryId;
    }

    public Boolean getIsSegment()
    {
        return isSegment;
    }

    public void setIsSegment(Boolean isSegment)
    {
        this.isSegment = isSegment;
    }

}
