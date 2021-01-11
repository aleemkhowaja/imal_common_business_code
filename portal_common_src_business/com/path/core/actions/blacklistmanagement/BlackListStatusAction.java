package com.path.core.actions.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;

import com.path.core.bo.blacklistmanagement.BlackListConstant;
import com.path.dbmaps.vo.MOSBLACKLISTVOKey;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public class BlackListStatusAction extends GridBaseAction
{
    
    private BlackListSC blackListSC = new BlackListSC();
    private List<StatusCO> statusList = new ArrayList<StatusCO>();
    private String url;

    /**
     * Set the status Grid URL and load the Common Status Jsp Page...
     * 
     * @return
     */
    public String loadStatusGridDef()throws JSONException
    {
		try
		{
		    url = ServletActionContext.getServletContext().getContextPath() + "/path/blackList/BlackListStatus_loadStatusGridData.action?blackListSC.code="
			    + blackListSC.getCode();
		}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
	return "SUCCESS_STATUS";
    }

    /**
     * get data from Database, convert them to be compatible with statusCO, get
     * HTML and set the Model.
     * 
     * @return
     */
    public String loadStatusGridData()
    {
	String[] searchCol = { "userName", "status_desc", "status_date" };
	MOSBLACKLISTVOKey blackListKey = new MOSBLACKLISTVOKey();
	SelectSC lovCriteria = new SelectSC();
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    blackListSC.setSearchCols(searchCol);
	    copyproperties(blackListSC);
	    blackListKey.setCOMP_CODE(sessionCO.getCompanyCode());
	    blackListKey.setCODE(blackListSC.getCode());

        lovCriteria.setLanguage(sessionCO.getLanguage());
        lovCriteria.setCompCode(compCode);
        lovCriteria.setLovTypeId(BlackListConstant.BLACK_LIST_STATUS_LOV_TYPE);
    
    
        List<StatusCO> statusList= returnCommonLibBO().generateStatusList(blackListKey, BlackListConstant.getStatusFields(), lovCriteria);
        setGridModel(statusList);
	    
	}
	catch(Exception ex)
	{
	    log.error("Error in the loadStatusGrid method");
	    ex.printStackTrace();
	}
	return SUCCESS;
    }

    /**
     * 
     */
    public Object getModel()
    {
	return blackListSC;
    }

    /**
     * @return the statusList
     */
    public List<StatusCO> getStatusList()
    {
	return statusList;
    }

    /**
     * @param statusList the statusList to set
     */
    public void setStatusList(List<StatusCO> statusList)
    {
	this.statusList = statusList;
    }
    
    public String getUrl()
    {
	return url;
    }
    
    public void setUrl(String url)
    {
	this.url = url;
    }

	public BlackListSC getBlackListSC()
	{
		return blackListSC;
	}

	public void setBlackListSC(BlackListSC blackListSC)
	{
		this.blackListSC = blackListSC;
	}



}
