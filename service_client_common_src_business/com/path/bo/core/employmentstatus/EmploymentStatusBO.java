package com.path.bo.core.employmentstatus;

import com.path.lib.common.exception.BaseException;
import com.path.dbmaps.vo.CTS_EMPLOYMENT_STATUSVO;
import java.util.List;
import com.path.vo.core.employmentstatus.EmploymentStatusSC;

public interface EmploymentStatusBO
{
    public int empStatusListCount(EmploymentStatusSC employmentStatusSC) throws BaseException;

    public List empStatusList(EmploymentStatusSC employmentStatusSC) throws BaseException;

    public CTS_EMPLOYMENT_STATUSVO returnEmpStatusCodeById(EmploymentStatusSC employmentStatusSC) throws BaseException;

}
