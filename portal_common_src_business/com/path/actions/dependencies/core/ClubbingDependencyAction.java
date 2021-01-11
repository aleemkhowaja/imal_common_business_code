package com.path.actions.dependencies.core;

import com.path.bo.core.clubbing.ClubbingBO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingDependencyAction.java used to
 */
public class ClubbingDependencyAction extends BaseAction
{
	ClubbingBO clubbingBO;
	private ClubbingSC criteria = new ClubbingSC();
	private ClubbingCO clubbingCO = new ClubbingCO();

	public String dependencyForClubbing()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			clubbingCO = clubbingBO.dependencyForClubbing(criteria);	
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
	}

	@Override
	public Object getModel()
	{
		return criteria;
	}
	public ClubbingSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(ClubbingSC criteria)
	{
		this.criteria = criteria;
	}
	public ClubbingCO getClubbingCO()
	{
		return clubbingCO;
	}
	public void setClubbingCO(ClubbingCO clubbingCO)
	{
		this.clubbingCO = clubbingCO;
	}
	public void setClubbingBO(ClubbingBO clubbingBO)
	{
		this.clubbingBO = clubbingBO;
	}
}
