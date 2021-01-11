package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.oneobligor.OneObligorBO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public class OneObligorDependencyAction extends RetailBaseAction
{
    private OneObligorBO oneObligorBO;
    private BigDecimal OBLIGOR_CODE;
    private RIFOBTVO oneObligorVO;

    public String dependencyByOneObligorCode()
    {
	try
	{
	    if(NumberUtil.emptyDecimalToNull(OBLIGOR_CODE) == null)
	    {
		oneObligorVO = new RIFOBTVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		OneObligorSC criteria = new OneObligorSC();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setOneObligorCode(OBLIGOR_CODE);
		oneObligorVO = oneObligorBO.returnOneObligorByCode(criteria);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public BigDecimal getOBLIGOR_CODE()
    {
	return OBLIGOR_CODE;
    }

    public void setOBLIGOR_CODE(BigDecimal oBLIGORCODE)
    {
	OBLIGOR_CODE = oBLIGORCODE;
    }

    public RIFOBTVO getOneObligorVO()
    {
	return oneObligorVO;
    }

    public void setOneObligorVO(RIFOBTVO oneObligorVO)
    {
	this.oneObligorVO = oneObligorVO;
    }

    public void setOneObligorBO(OneObligorBO oneObligorBO)
    {
	this.oneObligorBO = oneObligorBO;
    }

}
