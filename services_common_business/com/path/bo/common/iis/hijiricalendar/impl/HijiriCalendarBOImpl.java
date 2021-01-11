package com.path.bo.common.iis.hijiricalendar.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.iis.hijiricalendar.HijiriCalendarBO;
import com.path.dao.common.iis.hijiricalendar.HijiriCalendarDAO;
import com.path.dbmaps.vo.TRSHIJRI_CALENDARVOKey;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVO;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;

public class HijiriCalendarBOImpl extends BaseBO implements HijiriCalendarBO
{
    HijiriCalendarDAO hijiriCalendarDAO;

    public void setHijiriCalendarDAO(HijiriCalendarDAO hijiriCalendarDAO)
    {
	this.hijiriCalendarDAO = hijiriCalendarDAO;
    }

    @Override
    public int getNoDaysOfMonth(BigDecimal compCode, BigDecimal month, BigDecimal year) throws BaseException
    {
	TRSHIJRI_CALENDARVOKey trshijriCALENDARVOKey = new TRSHIJRI_CALENDARVOKey();
	trshijriCALENDARVOKey.setCOMP_CODE(compCode);
	trshijriCALENDARVOKey.setHIJRI_MONTH(month);
	trshijriCALENDARVOKey.setHIJRI_YEAR(year);
	int noOfDays = hijiriCalendarDAO.noDaysOfMonthByLessThanYear(trshijriCALENDARVOKey);
	if(noOfDays <= 0)
	{
	    noOfDays = hijiriCalendarDAO.noDaysOfMonthByGreaterThanYear(trshijriCALENDARVOKey);
	}
	return noOfDays;
    }

    @Override
    public String addDays(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException
    {
	long ll_day = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 1, 2));
	long ll_month = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 4, 2));
	long ll_year = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 7, 4));

	long ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));
	int daysToBeadded = noOfDays.intValue();
	if(daysToBeadded < 0)
	{
	    daysToBeadded = daysToBeadded * -1;
	}
	if(noOfDays.intValue() > 0)
	{
	    for(int i = 1; i <= daysToBeadded; i++)
	    {
		if(ll_day == ll_no_of_days)
		{
		    if(ll_month == 12)
		    {
			ll_year = ll_year + 1;
			ll_month = 0;
		    }
		    ll_month = ll_month + 1;
		    ll_day = 1;
		    ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal
			    .valueOf(ll_year));
		}
		else
		{
		    ll_day = ll_day + 1;
		}
	    }
	}

	if(noOfDays.intValue() < 0)
	{
	    for(int i = 1; i <= daysToBeadded; i++)
	    {
		if(ll_day == 1)
		{
		    if(ll_month == 1)
		    {
			ll_year = ll_year - 1;
			ll_month = 13;
		    }
		    ll_month = ll_month - 1;
		    ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal
			    .valueOf(ll_year));
		    ll_day = ll_no_of_days;
		}
		else
		{
		    ll_day = ll_day - 1;
		}
	    }
	}

	String return_date = NumberUtil.addLeadingZeros(ll_day, 2) + "/" + NumberUtil.addLeadingZeros(ll_month, 2)
		+ "/" + NumberUtil.addLeadingZeros(ll_year, 4);

	return return_date;
    }

    @Override
    public String addMonths(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException
    {
	long ll_day = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 1, 2));
	long ll_month = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 4, 2));
	long ll_year = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 7, 4));

	long ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));
	int daysToBeadded = noOfDays.intValue();
	if(daysToBeadded < 0)
	{
	    daysToBeadded = daysToBeadded * -1;
	}

	if(noOfDays.intValue() > 0)
	{
	    for(int i = 1; i <= daysToBeadded; i++)
	    {
		if(ll_month == 12)
		{
		    ll_year = ll_year + 1;
		    ll_month = 0;
		}
		ll_month = ll_month + 1;

	    }
	}

	if(noOfDays.intValue() < 0)
	{
	    for(int i = 1; i <= daysToBeadded; i++)
	    {
		if(ll_month == 1)
		{
		    ll_year = ll_year - 1;
		    ll_month = 13;
		}
		ll_month = ll_month - 1;

	    }
	}

	ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));

	if(ll_day > ll_no_of_days)
	{
	    ll_day = ll_no_of_days;
	}

	String return_date = NumberUtil.addLeadingZeros(ll_day, 2) + "/" + NumberUtil.addLeadingZeros(ll_month, 2)
		+ "/" + NumberUtil.addLeadingZeros(ll_year, 4);

	return return_date;
    }

    @Override
    public String addYears(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException
    {
	long ll_day = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 1, 2));
	long ll_month = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 4, 2));
	long ll_year = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 7, 4));

	long ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));
	int daysToBeadded = noOfDays.intValue();

	ll_year = ll_year + daysToBeadded;

	ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));

	if(ll_day > ll_no_of_days)
	{
	    ll_day = ll_no_of_days;
	}

	String return_date = NumberUtil.addLeadingZeros(ll_day, 2) + "/" + NumberUtil.addLeadingZeros(ll_month, 2)
		+ "/" + NumberUtil.addLeadingZeros(ll_year, 4);

	return return_date;
    }

    @Override
    public Date getGregorianDate(BigDecimal compCode, String hijiriDate) throws BaseException
    {
	Date newDate = returnGregorianDate(compCode, hijiriDate);
	if(newDate == null)
	{
	    throw new BOException(MessageCodes.HIJIRI_DATE_IS_NOT_DEFINED, new String[] { hijiriDate },
		    false);
	}
	return newDate;
    }

    private Date returnGregorianDate(BigDecimal compCode, String hijiriDate) throws DAOException
    {
	long ll_day = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 1, 2));
	long ll_month = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 4, 2));
	long ll_year = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 7, 4));
	TRSHIJRI_DETAIL_CALENDARVOKey trshijriDETAILCALENDARVOKey = new TRSHIJRI_DETAIL_CALENDARVOKey();
	trshijriDETAILCALENDARVOKey.setCOMP_CODE(compCode);
	trshijriDETAILCALENDARVOKey.setHIJRI_YEAR(BigDecimal.valueOf(ll_year));
	trshijriDETAILCALENDARVOKey.setHIJRI_MONTH(BigDecimal.valueOf(ll_month));
	trshijriDETAILCALENDARVOKey.setHIJRI_DAY(BigDecimal.valueOf(ll_day));

	return hijiriCalendarDAO.getGregorianDate(trshijriDETAILCALENDARVOKey);
    }

    @Override
    public String getHijiriDateForGregorian(BigDecimal compCode, Date gregorianDate) throws BaseException
    {
	TRSHIJRI_DETAIL_CALENDARVO trshijriDETAILCALENDARVO = new TRSHIJRI_DETAIL_CALENDARVO();
	trshijriDETAILCALENDARVO.setCOMP_CODE(compCode);
	trshijriDETAILCALENDARVO.setGREGORIAN_DATE(gregorianDate);

	trshijriDETAILCALENDARVO = hijiriCalendarDAO.getHijiriDateForGregorian(trshijriDETAILCALENDARVO);
	if(trshijriDETAILCALENDARVO == null)
	{

	    throw new BOException(MessageCodes.HIJIRI_DATE_IS_NOT_DEFINED,
		    new String[] { DateUtil.format(gregorianDate) }, false);
	}
	String hijiriDate = NumberUtil.addLeadingZeros(trshijriDETAILCALENDARVO.getHIJRI_DAY(), 2) + "/"
		+ NumberUtil.addLeadingZeros(trshijriDETAILCALENDARVO.getHIJRI_MONTH(), 2) + "/"
		+ NumberUtil.addLeadingZeros(trshijriDETAILCALENDARVO.getHIJRI_YEAR(), 4);
	return hijiriDate;
    }

    @Override
    public int getLastdayGregorianDate(BigDecimal compCode, Date gregorianDate) throws BaseException
    {
	return DateUtil.getDayYearMonth(DateUtil.getMonthLastDay(gregorianDate), DateUtil.DAY_OF_MONTH);
    }

    @Override
    public int validateHijiriDateNoException(BigDecimal compCode, String hijiriDate) throws BaseException
    {
	Date newDate = returnGregorianDate(compCode, hijiriDate);
	if(newDate == null)
	{
	    return -1;
	}
	return 1;
    }

    @Override
    public int validateHijiriDateWithException(BigDecimal compCode, String hijiriDate) throws BaseException
    {
	Date newDate = returnGregorianDate(compCode, hijiriDate);
	if(newDate == null)
	{
	    throw new BOException(MessageCodes.HIJIRI_DATE_IS_NOT_DEFINED, new String[] { hijiriDate }, false);
	}
	return 1;
    }

    @Override
    public String createHijiriDate(BigDecimal compCode, long dayParam, long monthParam, long yearParam, long adjustTo)
	    throws BaseException
    {
	long day = dayParam, month = monthParam, year = yearParam;
	long ll_no_of_days = getNoDaysOfMonth(compCode, BigDecimal.valueOf(month), BigDecimal.valueOf(year));

	if(ll_no_of_days < day)
	{
	    if(adjustTo == -1)
	    {
		day = ll_no_of_days;
	    }
	    else
	    {
		day = 1;
		if(month == 12)
		{
		    month = 1;
		    year = year + 1;
		}
	    }
	}

	String return_date = NumberUtil.addLeadingZeros(day, 2) + "/" + NumberUtil.addLeadingZeros(month, 2) + "/"
		+ NumberUtil.addLeadingZeros(year, 4);

	return return_date;
    }

    @Override
    public String getHijiriMonthLastDate(BigDecimal compCode, String hijiriDateParam) throws BaseException
    {
	String hijiriDate = hijiriDateParam;
	long ll_month = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 4, 2));
	long ll_year = NumberUtil.toInteger(StringUtil.substring(hijiriDate, 7, 4));

	long ll_day = getNoDaysOfMonth(compCode, BigDecimal.valueOf(ll_month), BigDecimal.valueOf(ll_year));

	hijiriDate = NumberUtil.addLeadingZeros(ll_day, 2) + "/" + NumberUtil.addLeadingZeros(ll_month, 2) + "/"
		+ NumberUtil.addLeadingZeros(ll_year, 4);
	return hijiriDate;
    }

}
