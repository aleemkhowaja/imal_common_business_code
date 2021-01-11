package com.path.dao.common.iis.hijiricalendar;

import java.util.Date;

import com.path.dbmaps.vo.TRSHIJRI_CALENDARVOKey;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVO;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVOKey;
import com.path.lib.common.exception.DAOException;

public interface HijiriCalendarDAO
{

    public int noDaysOfMonthByLessThanYear(TRSHIJRI_CALENDARVOKey trshijriCALENDARVOKey) throws DAOException;

    public int noDaysOfMonthByGreaterThanYear(TRSHIJRI_CALENDARVOKey trshijriCALENDARVOKey) throws DAOException;

    public Date getGregorianDate(TRSHIJRI_DETAIL_CALENDARVOKey trshijriDETAILCALENDARVOKey) throws DAOException;

    public TRSHIJRI_DETAIL_CALENDARVO getHijiriDateForGregorian(TRSHIJRI_DETAIL_CALENDARVO trshijriDETAILCALENDARVO) throws DAOException;

}
