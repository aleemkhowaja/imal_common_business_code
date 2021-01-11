package com.path.core.actions.blacklistmanagement;

import com.path.core.bo.blacklistmanagement.BlackListManagementConstant;
import com.path.core.bo.blacklistmanagement.blacklistintsource.BlackListIntSourceBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

/**
 * w_maintain_upload_un_ofac
 * 
 * @author EliasAoun
 * 
 */
public class BlackListMatchedCIFListAction extends LookupBaseAction
{
    private BlackListIntSourceBO blackListIntSourceBO;
    BlackListIntSourceSC criteria = new BlackListIntSourceSC();
    BlackListIntSourceCO blackListIntSourceCO = new BlackListIntSourceCO();

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * action to forward to jsp page related to cif matched list
     * 
     * @return String
     */
    public String openScreen()
    {
	return SUCCESS;
    }

    /**
     * @return
     */
    public String loadGrid()
    {

	String[] searchCol = { "cifNO", "LONG_NAME_ENG", "statusDesc", "BL_TYPE", "BL_CODE", "LONG_NAME",
		"nationality", "PASSPORT_NO", "STR_DOB", "LONG_NAME_AR" };
	try
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setPreferredLanguage(returnSessionObject().getLanguage());

	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(blackListIntSourceBO.getMatchedCIFListCount(criteria));
	    }

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(blackListIntSourceBO.getMatchedCIFList(criteria));
	}
	catch(Exception ex)
	{
	    log.error("Error in the loadGrid method");
	    ex.printStackTrace();
	}
	return "loadGrid";
    }

    /**
     * function to change the status of a white list to blackListed, and
     * vice-versa
     * 
     * @return SUCCESS
     * @throws BaseException
     */
    public String switchCIFListStatus() throws BaseException
    {
	try
	{
	    copyproperties(criteria);

	    blackListIntSourceCO.setCheckedList(criteria.getCheckedList());
	    blackListIntSourceCO.setLoginUserId(returnSessionObject().getUserName());

	    if("blackListed".equals(criteria.getFromWhere()))
	    {
		blackListIntSourceCO.setOldBlackListed(BlackListManagementConstant.SUSPICIOUS);
		blackListIntSourceBO.switchCIFToBlackList(blackListIntSourceCO);
	    }
	    else if("suspicious".equals(criteria.getFromWhere()))
	    {
		blackListIntSourceCO.setOldBlackListed(BlackListManagementConstant.BLACKLISTED);
		blackListIntSourceBO.switchCIFToSuspicious(blackListIntSourceCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return "loadGrid";
    }

    /** Getters and Setters */
    public void setBlackListIntSourceBO(BlackListIntSourceBO blackListIntSourceBO)
    {
	this.blackListIntSourceBO = blackListIntSourceBO;
    }

    public BlackListIntSourceSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(BlackListIntSourceSC criteria)
    {
	this.criteria = criteria;
    }

    public BlackListIntSourceCO getBlackListIntSourceCO()
    {
	return blackListIntSourceCO;
    }

    public void setBlackListIntSourceCO(BlackListIntSourceCO blackListIntSourceCO)
    {
	this.blackListIntSourceCO = blackListIntSourceCO;
    }

}
