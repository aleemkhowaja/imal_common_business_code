package com.path.bo.core.department;

import java.util.List;

import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.department.DepartmentSC;

public interface DepartmentBO
{
    public int departmentListCount(DepartmentSC departmentSC) throws BaseException;

    public List departmentList(DepartmentSC departmentSC) throws BaseException;
    
    public DEPARTMENTSVO returnDepartmentById(DepartmentSC criteria) throws BaseException;

}
