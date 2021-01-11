package com.path.dao.core.department;

import java.util.List;

import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.department.DepartmentSC;

public interface DepartmentDAO
{
    public int departmentListCount(DepartmentSC departmentSC) throws DAOException;

    public List departmentList(DepartmentSC departmentSC) throws DAOException;
    
    public DEPARTMENTSVO returnDepartmentById(DepartmentSC criteria) throws DAOException;
}
