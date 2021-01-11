package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.employee.EmployeeBO;
import com.path.dbmaps.vo.EMPVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.employee.EmployeeCO;
import com.path.vo.core.employee.EmployeeSC;

public class EmployeeDependencyAction extends RetailBaseAction
{
    private EmployeeBO employeeBO;
    private EMPVO employeeVO;
    private BigDecimal EMPLOYEE_ID;
    private EmployeeCO employeeCO = new EmployeeCO();
    
    public String dependencyByEmployeeId()
    {
	try
	{
	    EmployeeSC criteria = new EmployeeSC();
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setBranchCode(BigDecimal.ZERO);
	    criteria.setLanguage(returnSessionObject().getPreferredLanguage());
	    criteria.setEmployee_id(EMPLOYEE_ID);

	    employeeVO = employeeBO.returnEmployeeById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByEmployeeId method of EmployeeDependencyAction");
	    handleException(e, "ERROR in EmployeeDependency", null);
	}

	return SUCCESS;
    }
    public String dependencyByOfficerID()
    {
	
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    EmployeeSC criteria = new EmployeeSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setEmployee_id(EMPLOYEE_ID);
	    criteria.setColName(employeeCO.getColName());
	    employeeCO = employeeBO.dependencyByOfficerID(criteria);
	    if(null == employeeCO)
	    {
		employeeCO = new EmployeeCO();
	    }
	    setAdditionalScreenParams(employeeCO.getHm());
	}
	catch(Exception e)
	{
	    handleException(e, "ERROR in EmployeeDependency", null);
	}
	
	return SUCCESS;
    }

    public void setEmployeeBO(EmployeeBO employeeBO)
    {
	this.employeeBO = employeeBO;
    }

    public EMPVO getEmployeeVO()
    {
	return employeeVO;
    }
 
    public void setEmployeeVO(EMPVO employeeVO)
    {
	this.employeeVO = employeeVO;
    }

    public BigDecimal getEMPLOYEE_ID()
    {
	return EMPLOYEE_ID;
    }

    public void setEMPLOYEE_ID(BigDecimal eMPLOYEEID)
    {
	EMPLOYEE_ID = eMPLOYEEID;
    }
    public EmployeeCO getEmployeeCO()
    {
        return employeeCO;
    }
    public void setEmployeeCO(EmployeeCO employeeCO)
    {
        this.employeeCO = employeeCO;
    }
}
