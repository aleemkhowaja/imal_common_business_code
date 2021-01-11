package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.nationality.NationalityBO;
import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.nationality.NationalitySC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 *          NationalityDependencyAction.java used to
 */
public class NationalityDependencyAction extends RetailBaseAction
{
    private NationalityBO nationalityBO;
    private NATIONALITYVO nationalityVO;
    private BigDecimal NATIONALITY_CODE;

    public String dependencyByNationalityCode()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(NATIONALITY_CODE))
	    {
		nationalityVO = new NATIONALITYVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		NationalitySC criteria = new NationalitySC();
		if(nationalityVO == null || NumberUtil.isEmptyDecimal(nationalityVO.getCOMP_CODE()))
		{
		    criteria.setCompCode(sessionCO.getCompanyCode());
		}
		else
		{
		    criteria.setCompCode(nationalityVO.getCOMP_CODE());
		}
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		criteria.setNationalityCode(NATIONALITY_CODE);
		nationalityVO = nationalityBO.returnNationalityById(criteria);
	    }
	}
	catch(Exception e)
	{
	    nationalityVO = null;
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public NATIONALITYVO getNationalityVO()
    {
	return nationalityVO;
    }

    public void setNationalityVO(NATIONALITYVO nationalityVO)
    {
	this.nationalityVO = nationalityVO;
    }

    public BigDecimal getNATIONALITY_CODE()
    {
	return NATIONALITY_CODE;
    }

    public void setNATIONALITY_CODE(BigDecimal nATIONALITYCODE)
    {
	NATIONALITY_CODE = nATIONALITYCODE;
    }

    public void setNationalityBO(NationalityBO nationalityBO)
    {
	this.nationalityBO = nationalityBO;
    }

}
