package com.path.dao.core.employee.impl;

import java.util.List;

import com.path.dao.core.employee.EmployeeDAO;
import com.path.dbmaps.vo.EMPVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.employee.EmployeeCO;
import com.path.vo.core.employee.EmployeeSC;

public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO
{

	@Override
	public List employeeList(EmployeeSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("employeeMapper.employeeList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "employeeMapper.employeeListMap");
		    return getSqlMap().queryForList("employeeMapper.employeeList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int employeeListCount(EmployeeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "employeeMapper.employeeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("employeeMapper.employeeListCount", criteria)).intValue();
		return nb;
	}
	
	@Override
	public EMPVO returnEmployeeById(EmployeeSC criteria) throws DAOException
    {
		return (EMPVO) getSqlMap().queryForObject("employeeMapper.returnEmployeeById", criteria);
    }
    public EmployeeCO returnEmployeeUsrDetails(EmployeeSC criteria) throws BaseException
    {
	return (EmployeeCO) getSqlMap().queryForObject("employeeMapper.returnEmployeeUsrDetails", criteria);	
    }

    public EmployeeCO dependencyByOfficerID(EmployeeSC criteria) throws DAOException
    {
	return (EmployeeCO) getSqlMap().queryForObject("employeeMapper.dependencyByOfficerId", criteria);
    }

}
