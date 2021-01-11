package com.path.core.actions.blacklistmanagement;

import net.sf.json.JSONException;

import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public class BlackListIdsGridAction extends GridBaseAction
{
    private BlackListBO blackListBO;
    private BlackListSC criteria = new BlackListSC();

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String loadBlackListIdsGrid() throws JSONException
    {
	String[] searchCol = { "blackListIdVO.ID_NO", "blackListIdVO.ID_TYPE", "idTypeDesc" };
	try
	{
	    criteria.setSearchCols(searchCol);

	    copyproperties(criteria);

	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.getCode();
	    if(criteria.getCode() != null)
	    {
		if(checkNbRec(criteria))
		{
		    setRecords(blackListBO.getBlackListIdsListCount(criteria));
		}
		setGridModel(blackListBO.getBlackListIdsList(criteria));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setBlackListBO(BlackListBO blackListBO)
    {
	this.blackListBO = blackListBO;
    }

    public BlackListSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(BlackListSC criteria)
    {
	this.criteria = criteria;
    }

}
