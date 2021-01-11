package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.tempcode.TempCodeBO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.tempcode.TempCodeSC;

public class TemplateCodeDependencyAction extends RetailBaseAction
{

    private TempCodeBO tempCodeBO;
    private TRSPAYPLANTMPLTVO tempCodeVO;
    private BigDecimal TEMPLATE_CODE;

    public String dependancyByTemplateCode()
    {
	try
	{
	    if(TEMPLATE_CODE == null || TEMPLATE_CODE.compareTo(BigDecimal.ZERO) < 0)
	    {
		tempCodeVO = new TRSPAYPLANTMPLTVO();
		return SUCCESS;
	    }
	    SessionCO sessionCO = returnSessionObject();
	    TempCodeSC criteria = new TempCodeSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setTemplateCode(TEMPLATE_CODE);
	    criteria.setLanguage(sessionCO.getPreferredLanguage());
	    tempCodeVO = tempCodeBO.returnTempCodeById(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
	
    public void setTempCodeBO(TempCodeBO tempCodeBO)
    {
	this.tempCodeBO = tempCodeBO;
    }

    public BigDecimal getTEMPLATE_CODE()
    {
	return TEMPLATE_CODE;
    }

    public void setTEMPLATE_CODE(BigDecimal tEMPLATECODE)
    {
	TEMPLATE_CODE = tEMPLATECODE;
    }

    public TRSPAYPLANTMPLTVO getTempCodeVO()
    {
	return tempCodeVO;
    }

    public void setTempCodeVO(TRSPAYPLANTMPLTVO tempCodeVO)
    {
	this.tempCodeVO = tempCodeVO;
    }

}
