package com.path.dao.core.cifrole;

import java.util.List;

import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifrole.CifRoleSC;

public interface CifRoleDAO
{
	public int cifRoleListCount(CifRoleSC criteria) throws DAOException;
    public List cifRoleList(CifRoleSC criteria) throws DAOException;
    public CIF_ROLEVO returnRoleById(CifRoleSC criteria) throws DAOException;
}

