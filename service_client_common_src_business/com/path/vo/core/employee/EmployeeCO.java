package com.path.vo.core.employee;

import java.util.HashMap;

import com.path.dbmaps.vo.EMPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.USRVO;
import com.path.vo.core.common.RetailBaseVO;

public class EmployeeCO extends RetailBaseVO
{
    private EMPVO empVO;
    private USRVO userVO;
    private String divisionDesc;
    private String deptDesc;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String colName;

    public USRVO getUserVO()
    {
	return userVO;
    }

    public void setUserVO(USRVO userVO)
    {
	this.userVO = userVO;
    }

    public EMPVO getEmpVO()
    {
	return empVO;
    }

    public void setEmpVO(EMPVO empVO)
    {
	this.empVO = empVO;
    }

    public String getDivisionDesc()
    {
        return divisionDesc;
    }

    public String getDeptDesc()
    {
        return deptDesc;
    }

    public void setDivisionDesc(String divisionDesc)
    {
        this.divisionDesc = divisionDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
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
