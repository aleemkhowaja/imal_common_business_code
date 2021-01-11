package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.salutation.SalutationBO;
import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.salutation.SalutationSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * SalutationDependencyAction.java used to
 */
public class SalutationDependencyAction extends RetailBaseAction
{
	private SalutationBO salutationBO;
	private CIVIL_CODESVO salutationVO;
	private BigDecimal cifTypeCode;
	private BigDecimal civilCode;
	private BigDecimal cifFlag;
    
    public String dependencyByCivilCode() {

		try 
		{
			if (NumberUtil.emptyDecimalToNull(cifTypeCode) != null && NumberUtil.emptyDecimalToNull(civilCode) != null)
			{
				SessionCO sessionCO = returnSessionObject();
				SalutationSC criteria = new SalutationSC();
				criteria.setCompCode(sessionCO.getCompanyCode());
				criteria.setCifTypeCode(cifTypeCode);
				//criteria.setCifFlag(cifFlag);
				criteria.setCifFlag(BigDecimal.ONE);
				criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
				criteria.setCivilCode(civilCode);

				salutationVO = salutationBO.returnSalutationById(criteria);
			}
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByCivilCode method of SalutationDependencyAction");
			handleException(e, null, null);
		}

		return SUCCESS;

	}

	public CIVIL_CODESVO getSalutationVO()
	{
		return salutationVO;
	}

	public void setSalutationVO(CIVIL_CODESVO salutationVO)
	{
		this.salutationVO = salutationVO;
	}

	public BigDecimal getCivilCode()
	{
		return civilCode;
	}

	public void setCivilCode(BigDecimal civilCode)
	{
		this.civilCode = civilCode;
	}

	public void setSalutationBO(SalutationBO salutationBO)
	{
		this.salutationBO = salutationBO;
	}

	public BigDecimal getCifTypeCode()
	{
		return cifTypeCode;
	}

	public void setCifTypeCode(BigDecimal cifTypeCode)
	{
		this.cifTypeCode = cifTypeCode;
	}

	public BigDecimal getCifFlag()
	{
		return cifFlag;
	}

	public void setCifFlag(BigDecimal cifFlag)
	{
		this.cifFlag = cifFlag;
	}

	


	
	
}
