package com.path.bo.core.cifrole.impl;

import java.util.List;

import com.path.bo.core.cifrole.CifRoleBO;
import com.path.dao.core.cifrole.CifRoleDAO;
import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrole.CifRoleSC;

public class CifRoleBOImpl extends BaseBO implements CifRoleBO
{
	private CifRoleDAO cifRoleDAO;
	@Override
	public List cifRoleList(CifRoleSC criteria) throws BaseException
	{
		return cifRoleDAO.cifRoleList(criteria);
	}

	@Override
	public int cifRoleListCount(CifRoleSC criteria) throws BaseException
	{
		return cifRoleDAO.cifRoleListCount(criteria);
	}

	public CIF_ROLEVO returnRoleById(CifRoleSC criteria) throws BaseException
	{
		return cifRoleDAO.returnRoleById(criteria);
	}

	public CifRoleDAO getCifRoleDAO()
	{
		return cifRoleDAO;
	}

	public void setCifRoleDAO(CifRoleDAO cifRoleDAO)
	{
		this.cifRoleDAO = cifRoleDAO;
	}

}
