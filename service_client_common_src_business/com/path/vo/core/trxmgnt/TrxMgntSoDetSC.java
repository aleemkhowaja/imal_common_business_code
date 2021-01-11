package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.BaseSC;

public class TrxMgntSoDetSC extends BaseSC
{

    private String periodicity;
    private String periodicityType;
    private BigDecimal period;
    private Date date;
    private BigDecimal soPeriodDay;
    private BigDecimal soPeriodMonth;
    private BigDecimal soPeriodInterval;
    private Date startDate;
    private Date endingDate;

    public String getPeriodicity()
    {
	return periodicity;
    }

    public void setPeriodicity(String periodicity)
    {
	this.periodicity = periodicity;
    }

    public String getPeriodicityType()
    {
	return periodicityType;
    }

    public void setPeriodicityType(String periodicityType)
    {
	this.periodicityType = periodicityType;
    }

    public BigDecimal getPeriod()
    {
	return period;
    }

    public void setPeriod(BigDecimal period)
    {
	this.period = period;
    }

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public BigDecimal getSoPeriodDay()
    {
	return soPeriodDay;
    }

    public void setSoPeriodDay(BigDecimal soPeriodDay)
    {
	this.soPeriodDay = soPeriodDay;
    }

    public BigDecimal getSoPeriodMonth()
    {
	return soPeriodMonth;
    }

    public void setSoPeriodMonth(BigDecimal soPeriodMonth)
    {
	this.soPeriodMonth = soPeriodMonth;
    }

    public BigDecimal getSoPeriodInterval()
    {
	return soPeriodInterval;
    }

    public void setSoPeriodInterval(BigDecimal soPeriodInterval)
    {
	this.soPeriodInterval = soPeriodInterval;
    }

    public Date getStartDate()
    {
	return startDate;
    }

    public void setStartDate(Date startDate)
    {
	this.startDate = startDate;
    }

    public Date getEndingDate()
    {
	return endingDate;
    }

    public void setEndingDate(Date endingDate)
    {
	this.endingDate = endingDate;
    }

}