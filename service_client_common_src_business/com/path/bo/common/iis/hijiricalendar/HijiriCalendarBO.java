package com.path.bo.common.iis.hijiricalendar;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.common.exception.BaseException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: mvalappil
 * 
 *          HijiriCalendarBO.java used to Hijiri calendar details PB Object
 *          uo_hijiri_calendor
 */
public interface HijiriCalendarBO
{
    /**
     * uf_nodays_ofmonth() in PB - TO get the number of days in a Hijiri month
     * 
     * @param trshijriCALENDARVOKey
     * @return
     * @throws BaseException
     */
    public int getNoDaysOfMonth(BigDecimal compCode, BigDecimal month, BigDecimal year) throws BaseException;

    /**
     * uf_adddays - Add no of days to hijiri date and return new date
     * 
     * @param noOfDays
     * @param hijiriDate
     * @return
     * @throws BaseException
     */
    public String addDays(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException;

    /**
     * uf_addmonths - To add the number of months with the Hijiri date
     * 
     * @param compCode
     * @param noOfDays
     * @param hijiriDate
     * @return
     * @throws BaseException
     */

    public String addMonths(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException;

    /**
     * uf_addyear - To add the number of year to hihiry date and return the new
     * date
     * 
     * @param compCode
     * @param noOfDays
     * @param hijiriDate
     * @return
     * @throws BaseException
     */
    public String addYears(BigDecimal compCode, BigDecimal noOfDays, String hijiriDate) throws BaseException;

    /**
     * uf_get_grdate - To return the Gregorian Date for Hijiri Date
     * 
     * @param compCode
     * @param noOfDays
     * @param hijiriDate
     * @return
     * @throws BaseException
     */

    public Date getGregorianDate(BigDecimal compCode, String hijiriDate) throws BaseException;

    /**
     * uf_get_hijiri_date - To get the Hijiri date for Gregorian date
     * 
     * @param compCode
     * @param gregorianDate
     * @return
     * @throws BaseException
     */
    public String getHijiriDateForGregorian(BigDecimal compCode, Date gregorianDate) throws BaseException;

    /**
     * uf_lastday_grdate - To return the last day of the month
     * 
     * @param compCode
     * @param gregorianDate
     * @return
     * @throws BaseException
     */
    public int getLastdayGregorianDate(BigDecimal compCode, Date gregorianDate) throws BaseException;

    /**
     * uf_validate_hijiri_date_new - To validate the given Hijiri date is exist
     * or not and will not throw exception
     * 
     * @param compCode
     * @param gregorianDate
     * @return return 1 if exist -1 if not exist
     * @throws BaseException
     */
    public int validateHijiriDateNoException(BigDecimal compCode, String hijiriDate) throws BaseException;

    /**
     * uf_validate_hijiri_date-To validate the given Hijiri date is exist or not
     * and will throw exception if not exist
     * 
     * @param compCode
     * @param hijiriDate
     * @return
     * @throws BaseException
     */
    public int validateHijiriDateWithException(BigDecimal compCode, String hijiriDate) throws BaseException;

    /**
     * To return the Hijiri date by giving day, month, year
     * 
     * @param compCode
     * @param day
     * @param month
     * @param year
     * @param adjustTo - if the date is not valid need to adjust days by adding
     *            or substractingf (1 / -1)
     * @return new Hijiri Date
     * @throws BaseException
     */
    public String createHijiriDate(BigDecimal compCode, long day, long month, long year, long adjustTo)
	    throws BaseException;

    /**
     * To return the last date of the given month
     * 
     * @param compCode
     * @param hijiriDate
     * @return
     * @throws BaseException
     */
    public String getHijiriMonthLastDate(BigDecimal compCode, String hijiriDate) throws BaseException;
}
