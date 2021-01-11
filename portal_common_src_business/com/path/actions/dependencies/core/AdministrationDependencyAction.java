package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.administration.AdministrationBO;
import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.administration.AdministrationSC;

@SuppressWarnings("serial")
public final class AdministrationDependencyAction extends RetailBaseAction
{
    private AdministrationBO administrationBO;
    private AdministrationSC criteria = new AdministrationSC();
    private CTSADMINISTRATIONVO administrationVO;
    private BigDecimal administrationCode;

    public Object getModel()
    {
	return criteria;
    }

    public String dependencyByCode()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(administrationCode))
	    {
		final SessionCO sessionCO = returnSessionObject();
		final BigDecimal compCode = sessionCO.getCompanyCode();
		criteria.setCompCode(compCode);
		criteria.setCode(administrationCode);
		administrationVO = administrationBO.returnAdministrationByCode(criteria);
	    }
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CTSADMINISTRATIONVO getAdministrationVO()
    {
	return administrationVO;
    }

    public void setAdministrationVO(CTSADMINISTRATIONVO obj)
    {
	this.administrationVO = obj;
    }

    public BigDecimal getAdministrationCode()
    {
	return administrationCode;
    }

    public void setAdministrationCode(BigDecimal obj)
    {
	this.administrationCode = obj;
    }

    public AdministrationSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AdministrationSC obj)
    {
	this.criteria = obj;
    }

    public void setAdministrationBO(AdministrationBO obj)
    {
	this.administrationBO = obj;
    }
}
