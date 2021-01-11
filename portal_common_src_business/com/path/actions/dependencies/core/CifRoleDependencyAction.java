package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cifrole.CifRoleBO;
import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.vo.core.cifrole.CifRoleSC;

public class CifRoleDependencyAction extends RetailBaseAction
{
	private CifRoleBO cifRoleBO;
	private CIF_ROLEVO cifRoleVO;
	private BigDecimal ROLE_CODE;
	
	public String dependencyByCifRole() {

		try 
		{
			CifRoleSC criteria = new CifRoleSC();
			criteria.setCompCode(returnSessionObject().getCompanyCode());
			criteria.setLanguage(returnSessionObject().getPreferredLanguage());
			criteria.setRoleCode(ROLE_CODE);

			cifRoleVO = cifRoleBO.returnRoleById(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByCifRole method of CifRoleDependencyAction");
			handleException(e, "ERROR in CIF ROLE Dependency", null);
		}

		return SUCCESS;

	}
	
	public BigDecimal getROLE_CODE()
	{
		return ROLE_CODE;
	}

	public void setROLE_CODE(BigDecimal rOLECODE)
	{
		ROLE_CODE = rOLECODE;
	}

	public CIF_ROLEVO getCifRoleVO()
	{
		return cifRoleVO;
	}

	public void setCifRoleVO(CIF_ROLEVO cifRoleVO)
	{
		this.cifRoleVO = cifRoleVO;
	}

	public void setCifRoleBO(CifRoleBO cifRoleBO)
	{
		this.cifRoleBO = cifRoleBO;
	}
}
