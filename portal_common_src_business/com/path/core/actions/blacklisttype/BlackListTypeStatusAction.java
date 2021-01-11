package com.path.core.actions.blacklisttype;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.blacklisttype.BlackListTypeConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * BlackListTypeStatusAction.java used to generate Status common Popup for BlackListType
 */
public class BlackListTypeStatusAction extends GridBaseAction
{
	private BlackListTypeSC criteria = new BlackListTypeSC();
	private String url;

	public String search()
	{
		try
		{
		    ServletContext application = ServletActionContext.getServletContext();
		    String theRealPath = application.getContextPath();
		    //TODO add you criteria parameters to the URL
		    setUrl(theRealPath +"/path/blackListType/BlackListTypeStatusAction_loadStatusGrid.action?code="
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
		MOSBLACKLIST_TYPEVO mosblacklist_typeVO = new MOSBLACKLIST_TYPEVO();
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
			//mosblacklist_typeVO.setCOMP_CODE(sessionCO.getCompanyCode());
			if (BigDecimal.ONE.equals(criteria.getDualParam()) )
			{ if(criteria.getStatus().equals("A") || criteria.getStatus().equals("D") || criteria.getStatus().equals("U"))
			    {
				 mosblacklist_typeVO.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(sessionCO.getCompanyCode()));

			    }
			    else
			    {
					mosblacklist_typeVO.setCOMP_CODE(sessionCO.getCompanyCode());

			    }
			}
			else
			{
				mosblacklist_typeVO.setCOMP_CODE(sessionCO.getCompanyCode());
			}

			 mosblacklist_typeVO.setCODE(criteria.getCode());

			List<String> colList  = BlackListTypeConstant.blackListTypeStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(BlackListTypeConstant.LOV_TYPE);

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(mosblacklist_typeVO,colList,lovCriteria);
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
	public BlackListTypeSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(BlackListTypeSC criteria)
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
