package com.path.core.actions.blacklistmanagement;

import java.math.BigDecimal;

import com.path.core.bo.blacklistmanagement.BlackListManagementConstant;
import com.path.core.bo.blacklistmanagement.blacklistintsource.BlackListIntSourceBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public class BlackListWhiteListAction extends GridBaseAction  
{
    private BlackListIntSourceBO blackListIntSourceBO;
    BlackListIntSourceSC criteria = new BlackListIntSourceSC();
    BlackListIntSourceCO blackListIntSourceCO = new BlackListIntSourceCO();
    private String whiteListGridStr="whiteListGridId";
    
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    /**
     * action to forward to jsp page related to cif white list
     * @return success
     */
    public String openScreen()
    {
	return SUCCESS;
    }
    
    
    /**
     * get data from DB, to load white list grid
     * @return loadGrid
     */
    public String loadGrid()
    {
	String[] searchCol = { "cifNO","LONG_NAME_ENG","statusDesc","BL_TYPE" };
	
	try
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    
	    //fill criteria parameters
	    criteria.setPreferredLanguage(returnSessionObject().getLanguage());
	    criteria.setLovTypeId( new BigDecimal(102));
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(blackListIntSourceBO.getWhiteListCount(criteria));
	    }
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(blackListIntSourceBO.getWhiteList(criteria));
	}
	catch(Exception ex)
	{
	    log.error("Error in the loadGrid method");
	    ex.printStackTrace();
	}
	return "loadGrid";
    }
    
    /**
     * action to change the status of a white list to suspicious, and vice-versa
     * @return SUCCESS
     * @throws BaseException
     */
    public String switchCIFListStatus() throws BaseException{
	copyproperties(criteria);

	blackListIntSourceCO.setCheckedList(criteria.getCheckedList());
	blackListIntSourceCO.setLoginUserId(returnSessionObject().getUserName());
	
	if(criteria.getFromWhere().equals("whiteListed")){
	    blackListIntSourceCO.setOldBlackListed(BlackListManagementConstant.SUSPICIOUS);
	    blackListIntSourceBO.switchCIFToWhiteList( blackListIntSourceCO);
	}else
	    if(criteria.getFromWhere().equals("suspicious")){
		blackListIntSourceCO.setOldBlackListed(BlackListManagementConstant.WHITELISTED);
		blackListIntSourceBO.switchCIFToSuspicious( blackListIntSourceCO);
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
    public String getWhiteListGridStr()
    {
        return whiteListGridStr;
    }
    public void setWhiteListGridStr(String whiteListGridStr)
    {
        this.whiteListGridStr = whiteListGridStr;
    }
    
}
