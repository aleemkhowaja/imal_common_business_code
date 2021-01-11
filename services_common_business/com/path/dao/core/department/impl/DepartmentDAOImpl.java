package com.path.dao.core.department.impl;

import java.util.List;

import com.path.dao.core.department.DepartmentDAO;
import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.department.DepartmentSC;

public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO
{

    @Override
    public List departmentList(DepartmentSC departmentSC) throws DAOException
    {
	if(departmentSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("departmentListMapper.departmentList", departmentSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(departmentSC, getSqlMap(), "departmentListMapper.departmentList_ResMap");
	    return getSqlMap().queryForList("departmentListMapper.departmentList", departmentSC,
		    departmentSC.getRecToskip(), departmentSC.getNbRec());
	}
    }

    @Override
    public int departmentListCount(DepartmentSC departmentSC) throws DAOException
    {
	DAOHelper.fixGridMaps(departmentSC, getSqlMap(), "departmentListMapper.departmentList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("departmentListMapper.departmentListCount", departmentSC))
		.intValue();
	return nb;
    }

    @Override
    public DEPARTMENTSVO returnDepartmentById(DepartmentSC criteria) throws DAOException
    {
	return (DEPARTMENTSVO) getSqlMap().queryForObject("departmentListMapper.returnDepartmentById", criteria);
    }
}
