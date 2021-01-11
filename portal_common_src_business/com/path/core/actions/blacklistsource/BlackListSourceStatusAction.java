package com.path.core.actions.blacklistsource;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordConstant;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScoringControlRecordStatusAction.java used to generate Status common Popup for ScoringControlRecord
 */
public class BlackListSourceStatusAction extends GridBaseAction
{
	private BlackListSourceSC criteria = new BlackListSourceSC();
	private String url;

	public String search()
	{
		try
		{
		    ServletContext application = ServletActionContext.getServletContext();
		    String theRealPath = application.getContextPath();
		    //TODO add you criteria parameters to the URL
		    setUrl(theRealPath +"/path/blackListSource/BlackListSourceStatusAction_loadStatusGrid.action?code="
		    + criteria.getCode() + "&status=" + criteria.getStatus());
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
		MOSBLACKSOURCEVO blackListSourceVO = new MOSBLACKSOURCEVO();
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
			if (BigDecimal.ONE.equals(criteria.getDualParam()) )
			{
			 if(criteria.getStatus().equals("A") || criteria.getStatus().equals("D") || criteria.getStatus().equals("U"))
			    {
				 blackListSourceVO.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(sessionCO.getCompanyCode()));

			    }
			    else
			    {
			    	blackListSourceVO.setCOMP_CODE(sessionCO.getCompanyCode());

			    }
			}
			else
			{
				blackListSourceVO.setCOMP_CODE(sessionCO.getCompanyCode());
			}

			  blackListSourceVO.setCODE(criteria.getCode());
			List<String> colList  = BlackListSourceConstant.blackListSourceStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(BlackListSourceConstant.LOV_TYPE);

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(blackListSourceVO,colList,lovCriteria);
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
	
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	
	public BlackListSourceSC getCriteria()
	{
		return criteria;
	}

	
	public void setCriteria(BlackListSourceSC criteria)
	{
		this.criteria = criteria;
	}
	
	
	
	
}
