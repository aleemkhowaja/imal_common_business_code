package com.path.dao.core.employmentstatus.impl;

import java.util.List;

import com.path.dao.core.employmentstatus.EmploymentStatusDAO;
import com.path.dbmaps.vo.CTS_EMPLOYMENT_STATUSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.employmentstatus.EmploymentStatusSC;

public class EmploymentStatusDAOImpl extends BaseDAO implements EmploymentStatusDAO
{

    public CTS_EMPLOYMENT_STATUSVO returnEmpStatusCodeById(EmploymentStatusSC employmentStatusSC) throws DAOException
    {

	return (CTS_EMPLOYMENT_STATUSVO) getSqlMap().queryForObject("employmentStatusMapper.returnEmpStatusCodeById", employmentStatusSC);
    }

    public List empStatusList(EmploymentStatusSC employmentStatusSC) throws DAOException
    {

	if(employmentStatusSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("employmentStatusMapper.empStatusList", employmentStatusSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(employmentStatusSC, getSqlMap(), "employmentStatusMapper.empStatusListMap");
	    return getSqlMap().queryForList("employmentStatusMapper.empStatusList", employmentStatusSC, employmentStatusSC.getRecToskip(),
	    		employmentStatusSC.getNbRec());
	}
    }

    @Override
    public int empStatusListCount(EmploymentStatusSC employmentStatusSC) throws DAOException
    {

	DAOHelper.fixGridMaps(employmentStatusSC, getSqlMap(), "employmentStatusMapper.empStatusListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("employmentStatusMapper.empStatusListCount", employmentStatusSC)).intValue();
	return nb;
    }

}
