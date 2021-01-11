/**
 * 
 */
package com.path.vo.core.unit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitSC.java used to
 */
public class UnitSC extends GridParamsSC
{
    private BigDecimal divisionCode;
    private BigDecimal deptCode;
    private BigDecimal unitCode;
    /**
     * @return the divisionCode
     */
    public BigDecimal getDivisionCode()
    {
        return divisionCode;
    }
    /**
     * @param divisionCode the divisionCode to set
     */
    public void setDivisionCode(BigDecimal divisionCode)
    {
        this.divisionCode = divisionCode;
    }
    /**
     * @return the deptCode
     */
    public BigDecimal getDeptCode()
    {
        return deptCode;
    }
    /**
     * @param deptCode the deptCode to set
     */
    public void setDeptCode(BigDecimal deptCode)
    {
        this.deptCode = deptCode;
    }
    /**
     * @return the unitCode
     */
    public BigDecimal getUnitCode()
    {
        return unitCode;
    }
    /**
     * @param unitCode the unitCode to set
     */
    public void setUnitCode(BigDecimal unitCode)
    {
        this.unitCode = unitCode;
    }
}
