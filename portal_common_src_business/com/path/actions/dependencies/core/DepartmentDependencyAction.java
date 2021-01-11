package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.department.DepartmentBO;
import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.department.DepartmentSC;

public class DepartmentDependencyAction extends RetailBaseAction
{
    private DepartmentBO departmentBO;
    private DEPARTMENTSVO departmentVO;
    private BigDecimal DIVISION_CODE;
    private BigDecimal DEPT_CODE;

    public String dependencyByDepartmentCode()
    {
	try
	{

	    SessionCO sessionCO = returnSessionObject();
	    DepartmentSC criteria = new DepartmentSC();
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setDivisionCode(NumberUtil.emptyDecimalToZero(DIVISION_CODE));
	    criteria.setDepartmentCode(NumberUtil.emptyDecimalToZero(DEPT_CODE));

	    if(NumberUtil.isEmptyDecimal(criteria.getCompCode()))
	    {
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    }
	    
	    departmentVO = departmentBO.returnDepartmentById(criteria);
	    if(departmentVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Department_Code_key" });
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByDepartmentCode method of DepartmentDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DEPARTMENTSVO getDepartmentVO()
    {
	return departmentVO;
    }

    public void setDepartmentVO(DEPARTMENTSVO departmentVO)
    {
	this.departmentVO = departmentVO;
    }

    public BigDecimal getDIVISION_CODE()
    {
	return DIVISION_CODE;
    }

    public void setDIVISION_CODE(BigDecimal dIVISIONCODE)
    {
	DIVISION_CODE = dIVISIONCODE;
    }

    public BigDecimal getDEPT_CODE()
    {
	return DEPT_CODE;
    }

    public void setDEPT_CODE(BigDecimal dEPTCODE)
    {
	DEPT_CODE = dEPTCODE;
    }

    public void setDepartmentBO(DepartmentBO departmentBO)
    {
	this.departmentBO = departmentBO;
    }

}
