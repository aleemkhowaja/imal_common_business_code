package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.division.DivisionBO;
import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.division.DivisionSC;

public class DivisionDependencyAction extends RetailBaseAction
{
    private DivisionBO divisionBO;
    private DIVISIONSVO divisionVO;
    private BigDecimal DIVISION_CODE;

    public String dependencyByDivisionCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    DivisionSC criteria = new DivisionSC();
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setDivisionCode(NumberUtil.emptyDecimalToZero(DIVISION_CODE));
	    if(NumberUtil.isEmptyDecimal(criteria.getCompCode()))
	    {
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    }
	    
	    divisionVO = divisionBO.returnDivisionById(criteria);
	    if(divisionVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Division_Code_key" });
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByDivisionCode method of DivisionDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DIVISIONSVO getDivisionVO()
    {
	return divisionVO;
    }

    public void setDivisionVO(DIVISIONSVO divisionVO)
    {
	this.divisionVO = divisionVO;
    }

    public BigDecimal getDIVISION_CODE()
    {
	return DIVISION_CODE;
    }

    public void setDIVISION_CODE(BigDecimal dIVISIONCODE)
    {
	DIVISION_CODE = dIVISIONCODE;
    }

    public void setDivisionBO(DivisionBO divisionBO)
    {
	this.divisionBO = divisionBO;
    }

}
