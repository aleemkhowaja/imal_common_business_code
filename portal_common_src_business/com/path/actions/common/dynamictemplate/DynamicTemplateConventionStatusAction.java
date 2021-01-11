package com.path.actions.common.dynamictemplate;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.dynamictemplate.DynamicTemplateConstant;
import com.path.dbmaps.vo.BCOM_DYN_ENT_TEMPL_CONVVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusAddFieldCO;
import com.path.vo.common.status.StatusCO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateStatusAction.java used to generate Status common Popup for DynamicTemplate
 */
public class DynamicTemplateConventionStatusAction extends GridBaseAction
{
	private DynamicTemplateSC criteria = new DynamicTemplateSC();
	private String url;
	private List<StatusAddFieldCO> addFields;

	public String search()
	{
		try
		{
		    ServletContext application = ServletActionContext.getServletContext();
		    String theRealPath = application.getContextPath();
		    //TODO add you criteria parameters to the URL
		    url = theRealPath + "/path/dynamicTemplate/dynamicTemplateConvStatusAction_loadStatusGrid.action?dtConvNo="+criteria.getDtConvNo();
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
		BCOM_DYN_ENT_TEMPL_CONVVO dyn_chrg_template_conventionVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copyproperties(criteria);

			//TODO set vo correct properties
			//dyn_chrg_template_conventionVO.setCOMP_CODE(sessionCO.getCompanyCode());

			List<String> colList  = DynamicTemplateConstant.dynamicTemplateStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(DynamicTemplateConstant.LOV_TYPE);
			lovCriteria.setCompCode(sessionCO.getCompanyCode());
			
			dyn_chrg_template_conventionVO.setCOMP_CODE(sessionCO.getCompanyCode());
			dyn_chrg_template_conventionVO.setCONVENTION_NUMBER(criteria.getDtConvNo());

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(dyn_chrg_template_conventionVO,colList,lovCriteria);
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
	public DynamicTemplateSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(DynamicTemplateSC criteria)
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
