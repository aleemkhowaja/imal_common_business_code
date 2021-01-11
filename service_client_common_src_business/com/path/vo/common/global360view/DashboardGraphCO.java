/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersCO.java used to
 */
public class DashboardGraphCO extends RetailBaseVO
{
    private String name;
    private BigDecimal value;
    private BigDecimal market;
    private String trsDate;
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public BigDecimal getValue()
    {
        return value;
    }
    public void setValue(BigDecimal value)
    {
        this.value = value;
    }
    public BigDecimal getMarket()
    {
        return market;
    }
    public void setMarket(BigDecimal market)
    {
        this.market = market;
    }
    public String getTrsDate()
    {
        return trsDate;
    }
    public void setTrsDate(String trsDate)
    {
        this.trsDate = trsDate;
    }
}