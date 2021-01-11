package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cifprofile.CifProfileBO;
import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifprofile.CifProfileSC;

public class CifProfileDependencyAction extends RetailBaseAction
{

    private CifProfileBO cifProfileBO;
    private BigDecimal CODE;
    private CIF_PROFILEVO cifProfileVO;

    public String dependencyByCifProfileCode()
    {

	try
	{
	    if (!NumberUtil.isEmptyDecimal(CODE))
	    {
		SessionCO sessionCO = returnSessionObject();
		CifProfileSC criteria = new CifProfileSC();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setCifProfileCode(CODE);
		cifProfileVO = cifProfileBO.returnCifProfileByCode(criteria);
		if(cifProfileVO==null)
		{
		    cifProfileVO = new CIF_PROFILEVO();
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "CIF_Profile_key" });
		}
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCifProfileCode method of CifProfileDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public void setCifProfileBO(CifProfileBO cifProfileBO)
    {
	this.cifProfileBO = cifProfileBO;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public CIF_PROFILEVO getCifProfileVO()
    {
	return cifProfileVO;
    }

    public void setCifProfileVO(CIF_PROFILEVO cifProfileVO)
    {
	this.cifProfileVO = cifProfileVO;
    }

}
