package com.path.core.actions.aml;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.aml.KycManagementConstant;
import com.path.dbmaps.vo.AML_KYCVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.aml.KycManagementSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementStatusAction.java used to generate Status common Popup for KycManagement
 */
public class KycManagementStatusAction extends GridBaseAction
{

	private KycManagementSC criteria = new KycManagementSC();
	private String url;

	public String search()
	{
		try
		{
			ServletContext application = ServletActionContext.getServletContext();
			String theRealPath = application.getContextPath();
			// TODO add you criteria parameters to the URL
			setUrl(theRealPath + "/path/kycManagement/KycManagementStatusAction_loadStatusGrid.action?code=" + criteria.getCode() + "&status="
					+ criteria.getStatus());
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "SUCCESS_STATUS";
	}

	public String loadStatusGrid()
	{
		String[] searchCol = { "userName", "status_desc", "status_date" };
		AML_KYCVO aml_kycVO = new AML_KYCVO();
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copyproperties(criteria);

			// TODO set vo correct properties
			aml_kycVO.setCOMP_CODE(sessionCO.getCompanyCode());
			aml_kycVO.setBRANCH_CODE(sessionCO.getBranchCode());
			aml_kycVO.setCODE(criteria.getCode());

			List<String> colList = KycManagementConstant.kycManagementStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(KycManagementConstant.LOV_TYPE);

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(aml_kycVO, colList, lovCriteria);
			setGridModel(resultList);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}

	public KycManagementSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(KycManagementSC criteria)
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
