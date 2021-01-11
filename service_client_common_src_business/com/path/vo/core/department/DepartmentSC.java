package com.path.vo.core.department;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class DepartmentSC extends GridParamsSC
{
    private BigDecimal divisionCode;
    private BigDecimal departmentCode;

    public BigDecimal getDivisionCode()
    {
	return divisionCode;
    }

    public void setDivisionCode(BigDecimal divisionCode)
    {
	this.divisionCode = divisionCode;
    }

    public BigDecimal getDepartmentCode()
    {
	return departmentCode;
    }

    public void setDepartmentCode(BigDecimal departmentCode)
    {
	this.departmentCode = departmentCode;
    }

}
