package com.path.actions.dependencies.core;

import com.path.bo.core.avacategory.AvaCategoryBO;
import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDependencyAction.java used to
 */
public class AvaCategoryDependencyAction extends BaseAction
{
    AvaCategoryBO avaCategoryBO;
    private AvaCategorySC criteria = new AvaCategorySC();
    private CTS_AVA_CATEGVO avaCategoryVO = new CTS_AVA_CATEGVO();

    public String dependencyForAvaCategory()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());

	    avaCategoryVO = avaCategoryBO.dependencyForAvaCategory(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public AvaCategorySC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AvaCategorySC criteria)
    {
	this.criteria = criteria;
    }

    public void setAvaCategoryBO(AvaCategoryBO avaCategoryBO)
    {
	this.avaCategoryBO = avaCategoryBO;
    }

    public CTS_AVA_CATEGVO getAvaCategoryVO()
    {
	return avaCategoryVO;
    }

    public void setAvaCategoryVO(CTS_AVA_CATEGVO avaCategoryVO)
    {
	this.avaCategoryVO = avaCategoryVO;
    }
}
