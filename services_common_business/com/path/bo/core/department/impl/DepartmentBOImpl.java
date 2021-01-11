package com.path.bo.core.department.impl;

import java.util.List;

import com.path.bo.core.department.DepartmentBO;
import com.path.dao.core.department.DepartmentDAO;
import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.department.DepartmentSC;

public class DepartmentBOImpl extends BaseBO implements DepartmentBO
{
    private DepartmentDAO departmentDAO;

    public DepartmentDAO getDepartmentDAO()
    {
	return departmentDAO;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO)
    {
	this.departmentDAO = departmentDAO;
    }

    @Override
    public List departmentList(DepartmentSC departmentSC) throws BaseException
    {
	return departmentDAO.departmentList(departmentSC);
    }

    @Override
    public int departmentListCount(DepartmentSC departmentSC) throws BaseException
    {
	return departmentDAO.departmentListCount(departmentSC);
    }

	@Override
	public DEPARTMENTSVO returnDepartmentById(DepartmentSC criteria) throws BaseException
	{
		return (DEPARTMENTSVO) departmentDAO.returnDepartmentById(criteria);
	}

}
