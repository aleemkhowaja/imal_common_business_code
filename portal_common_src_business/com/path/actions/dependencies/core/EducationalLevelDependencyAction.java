package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.educationallevel.EducationalLevelBO;
import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.educationallevel.EducationalLevelSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * EducationalLevelDependencyAction.java used to
 */
public class EducationalLevelDependencyAction extends RetailBaseAction
{
	private EducationalLevelBO educationalLevelBO;
	private EDUC_DEGREEVO educationalLevelVO;
    private BigDecimal CODE;
	
	public String dependencyByEducCode() {

		try 
		{
			SessionCO sessionCO = returnSessionObject();
			EducationalLevelSC criteria = new EducationalLevelSC();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
			criteria.setCode(CODE);
			
			educationalLevelVO = educationalLevelBO.educationLevelDependency(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByEducCode method of EducationalLevelDependencyAction");
			handleException(e, "ERROR in Education Level Dependency", null);
		}

		return SUCCESS;

	}

	public EDUC_DEGREEVO getEducationalLevelVO()
	{
		return educationalLevelVO;
	}

	public void setEducationalLevelVO(EDUC_DEGREEVO educationalLevelVO)
	{
		this.educationalLevelVO = educationalLevelVO;
	}

	public BigDecimal getCODE()
	{
		return CODE;
	}

	public void setCODE(BigDecimal cODE)
	{
		CODE = cODE;
	}

	public void setEducationalLevelBO(EducationalLevelBO educationalLevelBO)
	{
		this.educationalLevelBO = educationalLevelBO;
	}


	
}
