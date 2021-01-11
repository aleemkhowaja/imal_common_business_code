package com.path.dao.core.employee;

import java.util.List;

import com.path.dbmaps.vo.EMPVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.employee.EmployeeCO;
import com.path.vo.core.employee.EmployeeSC;

public interface EmployeeDAO
{
    public int employeeListCount(EmployeeSC criteria) throws DAOException;
    public List employeeList(EmployeeSC criteria) throws DAOException;
    public EMPVO returnEmployeeById(EmployeeSC criteria) throws DAOException;
    public EmployeeCO returnEmployeeUsrDetails(EmployeeSC criteria) throws BaseException;
    public EmployeeCO dependencyByOfficerID(EmployeeSC criteria) throws DAOException;
}

