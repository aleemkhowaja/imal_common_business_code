package com.path.bo.core.employee.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.employee.EmployeeBO;
import com.path.dao.core.employee.EmployeeDAO;
import com.path.dbmaps.vo.EMPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.employee.EmployeeCO;
import com.path.vo.core.employee.EmployeeSC;

public class EmployeeBOImpl extends BaseBO implements EmployeeBO
{
    private EmployeeDAO employeeDAO;

    public List employeeList(EmployeeSC criteria) throws BaseException
    {
	return employeeDAO.employeeList(criteria);
    }

    public int employeeListCount(EmployeeSC criteria) throws BaseException
    {
	return employeeDAO.employeeListCount(criteria);
    }

    public EMPVO returnEmployeeById(EmployeeSC criteria) throws BaseException
    {
	return (EMPVO) employeeDAO.returnEmployeeById(criteria);
    }

    public EmployeeCO returnEmployeeUsrDetails(EmployeeSC criteria) throws BaseException
    {
	return employeeDAO.returnEmployeeUsrDetails(criteria);
    }

    public EmployeeCO dependencyByOfficerID(EmployeeSC criteria) throws BaseException
    {
	// enabling employee name
	String elementId= "", elementName=""; 
	if("officer".equals(criteria.getColName()))
	{
	    elementId = "cifVO_REL_OFFICER";
	    elementName = "fomCO.cifVO.REL_OFFICER";
	}
	else if("manager".equals(criteria.getColName()))
	{
	    elementId = "cifVO_REL_MANAGER";
	    elementName = "fomCO.cifVO.REL_MANAGER";
	}
	else if("popOfficer".equals(criteria.getColName()))
	{
	    elementId = "cifOfficerVO_REL_OFFICER";
	    elementName = "officerCO.cifOfficerVO.REL_OFFICER";
	}
	
	EmployeeCO employeeCO = employeeDAO.dependencyByOfficerID(criteria);
	if(NumberUtil.isEmptyDecimal(criteria.getEmployee_id()))
	{
	    employeeCO = new EmployeeCO();
	    applyAction(employeeCO, elementName, elementId, ConstantsCommon.ACTION_TYPE_READONLY, "0");
	    return employeeCO;
	}
	
	if(null == employeeCO)
	{
	    employeeCO = new EmployeeCO();
	    //applyAction(employeeCO, elementName, elementId, ConstantsCommon.ACTION_TYPE_READONLY, "0");
	}
	else
	{
	    if(null != employeeCO.getEmpVO() && NumberUtil.isEmptyDecimal(employeeCO.getEmpVO().getEMPLOYEE_ID()))
	    {
		applyAction(employeeCO, elementName, elementId, ConstantsCommon.ACTION_TYPE_READONLY, "0");
	    }
	    else
	    {
		applyAction(employeeCO, elementName, elementId, ConstantsCommon.ACTION_TYPE_READONLY, "1");
	    }
	}
	return employeeCO;
    }
    private EmployeeCO applyAction(EmployeeCO employeeCO, String elementName, String elementId, String actionType, String value) throws BaseException
    {
	if(StringUtil.isNotEmpty(elementId) || StringUtil.isNotEmpty(elementName))
	{
	    applyDynScreenDisplay(elementId, elementName, actionType, value, employeeCO.getHm(), null);
	}
	return employeeCO;
    }
    public EmployeeDAO getEmployeeDAO()
    {
	return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO)
    {
	this.employeeDAO = employeeDAO;
    }
}
