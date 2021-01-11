package com.path.vo.core.employee;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class EmployeeSC extends GridParamsSC {

	private BigDecimal employee_id;
	private String language;
	private String colName;

	public BigDecimal getEmployee_id()
	{
		return employee_id;
	}

	public void setEmployee_id(BigDecimal employeeId)
	{
		employee_id = employeeId;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getColName()
	{
	    return colName;
	}

	public void setColName(String colName)
	{
	    this.colName = colName;
	}
}
