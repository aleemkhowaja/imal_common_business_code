package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.ciftype.CifTypeBO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ciftype.CifTypeSC;

public class CifTypeDependencyAction extends RetailBaseAction
{
    private CifTypeBO cifTypeBO;
    private RIFCTTVO cifTypeVO;
    private BigDecimal cifTypeCode;
    private CifTypeSC criteria = new CifTypeSC();

    public String dependencyByCifTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCifTypeCode(cifTypeCode);
	    criteria.setAllTypes(getText("All_types_key"));
	    cifTypeVO = cifTypeBO.returnCifTypeById(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public RIFCTTVO getCifTypeVO()
    {
	return cifTypeVO;
    }

    public void setCifTypeVO(RIFCTTVO cifTypeVO)
    {
	this.cifTypeVO = cifTypeVO;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public void setCifTypeBO(CifTypeBO cifTypeBO)
    {
	this.cifTypeBO = cifTypeBO;
    }

    public CifTypeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifTypeSC criteria)
    {
	this.criteria = criteria;
    }

}
