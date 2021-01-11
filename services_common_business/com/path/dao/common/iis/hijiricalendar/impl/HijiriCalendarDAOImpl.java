package com.path.dao.common.iis.hijiricalendar.impl;

import java.util.Date;

import com.path.dao.common.iis.hijiricalendar.HijiriCalendarDAO;
import com.path.dbmaps.vo.TRSHIJRI_CALENDARVOKey;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVO;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVOKey;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;

public class HijiriCalendarDAOImpl extends BaseDAO implements HijiriCalendarDAO
{

    @Override
    public int noDaysOfMonthByGreaterThanYear(TRSHIJRI_CALENDARVOKey trshijriCALENDARVOKey) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("hijiricalendor.noDaysOfMonthByGreaterThanYear", trshijriCALENDARVOKey);
    }

    @Override
    public int noDaysOfMonthByLessThanYear(TRSHIJRI_CALENDARVOKey trshijriCALENDARVOKey) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("hijiricalendor.noDaysOfMonthByGreaterThanYear", trshijriCALENDARVOKey);
    }

    @Override
    public Date getGregorianDate(TRSHIJRI_DETAIL_CALENDARVOKey trshijriDETAILCALENDARVOKey) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("hijiricalendor.getGregorianDate", trshijriDETAILCALENDARVOKey);
    }

    @Override
    public TRSHIJRI_DETAIL_CALENDARVO getHijiriDateForGregorian(TRSHIJRI_DETAIL_CALENDARVO trshijriDETAILCALENDARVO) throws DAOException
    {
	return (TRSHIJRI_DETAIL_CALENDARVO) getSqlMap().queryForObject("hijiricalendor.getHijiriDateForGregorian", trshijriDETAILCALENDARVO);
    }

}
