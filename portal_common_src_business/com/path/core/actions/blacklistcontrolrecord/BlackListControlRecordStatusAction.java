package com.path.core.actions.blacklistcontrolrecord;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ControlRecordStatusAction.java used to generate Status common Popup for ControlRecord
 */
public class BlackListControlRecordStatusAction extends GridBaseAction
{
	private BlackListControlRecordSC criteria = new BlackListControlRecordSC();
	private String url;

	public String search()
	{
		try
		{
		    ServletContext application = ServletActionContext.getServletContext();
		    String theRealPath = application.getContextPath();
		    //TODO add you criteria parameters to the URL
		    setUrl(theRealPath + "/path/controlRecord/BlackListControlRecordStatusAction_loadStatusGrid.action?status="
		    + criteria.getStatus());
		}
		catch(Exception ex)
		{
		    handleException(ex, null, null);
		    return ERROR_ACTION;
		}
		return "SUCCESS_STATUS";
	}

	public String loadStatusGrid()
	{
		String[] searchCol = { "userName", "status_desc", "status_date" };
		CIFCONTROLVO cifcontrolVO = new CIFCONTROLVO();
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copyproperties(criteria);
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);
			criteria.setDualParam(sAppVO.getDUAL_PARAM());

			//TODO set vo correct properties
			
			//TODO set vo correct properties
			if (BigDecimal.ONE.equals(criteria.getDualParam()) )
			{
			 if(criteria.getStatus().equals("A") || criteria.getStatus().equals("D") || criteria.getStatus().equals("U"))
			    {
				 cifcontrolVO.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(sessionCO.getCompanyCode()));

			    }
			    else
			    {
					cifcontrolVO.setCOMP_CODE(sessionCO.getCompanyCode());

			    }
			}
			else
			{
				cifcontrolVO.setCOMP_CODE(sessionCO.getCompanyCode());
			}

			List<String> colList  = BlackListControlRecordConstant.controlRecordStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(BlackListControlRecordConstant.LOV_TYPE);

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(cifcontrolVO,colList,lovCriteria);
			setGridModel(resultList);
		}
		catch(Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}
	public BlackListControlRecordSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(BlackListControlRecordSC criteria)
	{
		this.criteria = criteria;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
}
