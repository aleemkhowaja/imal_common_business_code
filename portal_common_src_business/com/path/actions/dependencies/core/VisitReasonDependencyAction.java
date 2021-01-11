package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.visitreason.VisitReasonBO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.visitreason.VisitReasonSC;

public class VisitReasonDependencyAction extends RetailBaseAction
{

    private CRM_PARAMVO crmParamVO;
    private VisitReasonBO visitReasonBO;
    private VisitReasonSC criteria;
    private BigDecimal reasonCode;
    
    /**
     * This method is used to validate the reason code and return the description
     * @return
     */
    public String dependencyByVisitReason()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setReasonCode(getReasonCode());
	    crmParamVO = visitReasonBO.returnVisitReasonDesc(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public CRM_PARAMVO getCrmParamVO()
    {
	return crmParamVO;
    }

    public void setCrmParamVO(CRM_PARAMVO crmParamVO)
    {
	this.crmParamVO = crmParamVO;
    }

    public void setVisitReasonBO(VisitReasonBO visitReasonBO)
    {
	this.visitReasonBO = visitReasonBO;
    }

    public BigDecimal getReasonCode()
    {
	return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
	this.reasonCode = reasonCode;
    }

    public VisitReasonSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(VisitReasonSC criteria)
    {
        this.criteria = criteria;
    }

}