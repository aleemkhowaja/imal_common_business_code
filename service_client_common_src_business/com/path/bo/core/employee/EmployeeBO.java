package com.path.bo.core.employee;

import java.util.List;

import com.path.dbmaps.vo.EMPVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.employee.EmployeeCO;
import com.path.vo.core.employee.EmployeeSC;

public interface EmployeeBO
{
   public int employeeListCount(EmployeeSC criteria) throws BaseException;
    public List employeeList(EmployeeSC criteria) throws BaseException;
    public EMPVO returnEmployeeById(EmployeeSC criteria) throws BaseException;
    /**
     * this function is created by jihad lamaa in order to get details from USR and EMP Tables
     * @param criteria
     * @return
     * @throws BaseException
     */
    public EmployeeCO returnEmployeeUsrDetails(EmployeeSC criteria) throws BaseException;
    public EmployeeCO dependencyByOfficerID(EmployeeSC criteria) throws BaseException;
    
}
