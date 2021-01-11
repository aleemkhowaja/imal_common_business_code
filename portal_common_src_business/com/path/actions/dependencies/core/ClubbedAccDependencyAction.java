package com.path.actions.dependencies.core;

import com.path.bo.core.clubbing.ClubbingBO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;

public class ClubbedAccDependencyAction extends BaseAction
{
	private ClubbingBO clubbingBO;
	private ClubbingSC criteria = new ClubbingSC();
	private ClubbingCO clubbingCO = new ClubbingCO();
	
	@Override
	public Object getModel()
	{
	    return criteria;
	}
	
	public String dependencyForClubbedAcc()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			clubbingCO = clubbingBO.dependencyForClubbedAcc(criteria);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
	}

	public ClubbingBO getClubbingBO()
	{
	    return clubbingBO;
	}

	public void setClubbingBO(ClubbingBO clubbingBO)
	{
	    this.clubbingBO = clubbingBO;
	}

	public ClubbingCO getClubbingCO()
	{
	    return clubbingCO;
	}

	public void setClubbingCO(ClubbingCO clubbingCO)
	{
	    this.clubbingCO = clubbingCO;
	}

	public void setCriteria(ClubbingSC criteria)
	{
	    this.criteria = criteria;
	}

}
