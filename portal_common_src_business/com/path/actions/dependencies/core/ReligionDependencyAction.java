package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.religion.ReligionBO;
import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.religion.ReligionSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * ReligionDependencyAction.java used to
 */
public class ReligionDependencyAction extends RetailBaseAction
{
	private ReligionBO religionBO;
	private RELIGIONVO religionVO;
    private BigDecimal RELIGION_CODE;
	
    public String dependencyByReligionCode() {

		try 
		{
			if (NumberUtil.emptyDecimalToNull(RELIGION_CODE) != null)
			{
				SessionCO sessionCO = returnSessionObject();
				ReligionSC criteria = new ReligionSC();
				criteria.setCompCode(sessionCO.getCompanyCode());
				criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
				criteria.setReligionCode(RELIGION_CODE);

				religionVO = religionBO.returnReligionById(criteria);
			}
			
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByReligionCode method of ReligionDependencyAction");
			handleException(e, "ERROR in Religion Dependency", null);
		}

		return SUCCESS;

	}

	public RELIGIONVO getReligionVO()
	{
		return religionVO;
	}

	public void setReligionVO(RELIGIONVO religionVO)
	{
		this.religionVO = religionVO;
	}

	public BigDecimal getRELIGION_CODE()
	{
		return RELIGION_CODE;
	}

	public void setRELIGION_CODE(BigDecimal rELIGIONCODE)
	{
		RELIGION_CODE = rELIGIONCODE;
	}

	public void setReligionBO(ReligionBO religionBO)
	{
		this.religionBO = religionBO;
	}

	
	
}
