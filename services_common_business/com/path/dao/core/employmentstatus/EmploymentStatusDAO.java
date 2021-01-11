package com.path.dao.core.employmentstatus;

import java.util.List;

import com.path.dbmaps.vo.CTS_EMPLOYMENT_STATUSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.employmentstatus.EmploymentStatusSC;

public interface EmploymentStatusDAO
{
    public CTS_EMPLOYMENT_STATUSVO returnEmpStatusCodeById(EmploymentStatusSC employmentStatusSC) throws DAOException;

    public List empStatusList(EmploymentStatusSC employmentStatusSC) throws DAOException;

    public int empStatusListCount(EmploymentStatusSC employmentStatusSC) throws DAOException;
}
