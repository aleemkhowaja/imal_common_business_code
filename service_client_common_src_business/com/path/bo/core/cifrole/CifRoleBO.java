package com.path.bo.core.cifrole;

import java.util.List;

import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrole.CifRoleSC;

public interface CifRoleBO
{
	public int cifRoleListCount(CifRoleSC criteria) throws BaseException;
    public List cifRoleList(CifRoleSC criteria) throws BaseException;
    public CIF_ROLEVO returnRoleById(CifRoleSC criteria) throws BaseException;
}
