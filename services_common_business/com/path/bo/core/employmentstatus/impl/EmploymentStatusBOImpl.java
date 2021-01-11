package com.path.bo.core.employmentstatus.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.employmentstatus.EmploymentStatusBO;
import com.path.dao.core.employmentstatus.EmploymentStatusDAO;
import com.path.dbmaps.vo.CTS_EMPLOYMENT_STATUSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.employmentstatus.EmploymentStatusSC;

public class EmploymentStatusBOImpl extends BaseBO implements EmploymentStatusBO
{
    private EmploymentStatusDAO employmentStatusDAO;


    public EmploymentStatusDAO getEmploymentStatusDAO() {
		return employmentStatusDAO;
	}

	public void setEmploymentStatusDAO(EmploymentStatusDAO employmentStatusDAO) {
		this.employmentStatusDAO = employmentStatusDAO;
	}

	@Override
    public CTS_EMPLOYMENT_STATUSVO returnEmpStatusCodeById(EmploymentStatusSC employmentStatusSC) throws BaseException
    {
		CTS_EMPLOYMENT_STATUSVO ctsEmploymentStatusVO = employmentStatusDAO.returnEmpStatusCodeById(employmentStatusSC);
	if(ctsEmploymentStatusVO == null || ctsEmploymentStatusVO.getEMPLOYMENT_STATUS_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	}
	return ctsEmploymentStatusVO;
    }

    @Override
    public List empStatusList(EmploymentStatusSC employmentStatusSC) throws BaseException
    {
	return employmentStatusDAO.empStatusList(employmentStatusSC);
    }

    @Override
    public int empStatusListCount(EmploymentStatusSC employmentStatusSC) throws BaseException
    {
	return employmentStatusDAO.empStatusListCount(employmentStatusSC);
    }
}
