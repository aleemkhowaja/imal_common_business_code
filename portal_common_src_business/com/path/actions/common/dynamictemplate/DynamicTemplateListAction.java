package com.path.actions.common.dynamictemplate;

import java.util.List;

import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateListAction.java used to
 */
public class DynamicTemplateListAction extends GridBaseAction
{
    private DynamicTemplateBO dynamicTemplateBO;
    private DynamicTemplateSC criteria = new DynamicTemplateSC();

    public String loadDynamicTemplateGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    copyproperties(criteria);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setMenuRef(get_pageRef());
	    criteria.setCrudMode(getIv_crud());
	    int dynReportCnt = dynamicTemplateBO.returnDynamicTemplateListCount(criteria);
	    setRecords(dynReportCnt);
	    List<DynamicTemplateCO> dynReportList = dynamicTemplateBO.returnDynamicTemplateList(criteria);
	    setGridModel(dynReportList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDynamicTemplateGrid of DynamicTemplateListAction");
	    handleException(e, null, null);
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

    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
	this.dynamicTemplateBO = dynamicTemplateBO;
    }
}
