package com.path.actions.common.dynamictemplate;

import java.math.BigDecimal;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.struts2.lib.common.base.TreeBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateMaintAction.java used to
 */
public class DynamicTemplateDepAction extends TreeBaseAction
{
    private DynamicTemplateBO dynamicTemplateBO;
    private DynamicTemplateCO dynTemplateCO;
    private DynamicTemplateSC criteria = new DynamicTemplateSC();
    private BigDecimal screenId;
    
    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
	this.dynamicTemplateBO = dynamicTemplateBO;
    }

    public DynamicTemplateCO getDynTemplateCO()
    {
        return dynTemplateCO;
    }

    public void setDynTemplateCO(DynamicTemplateCO dynTemplateCO)
    {
        this.dynTemplateCO = dynTemplateCO;
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
   
    public BigDecimal getScreenId()
    {
        return screenId;
    }

    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }

    public String dependencyScreenById() throws JSONException
    {
	try
	{
	    dynTemplateCO = new DynamicTemplateCO();
	    SessionCO sessionCO = returnSessionObject();
	    //criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    
	    dynTemplateCO = dynamicTemplateBO.retScreenDetails(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
}
