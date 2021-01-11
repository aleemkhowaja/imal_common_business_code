package com.path.bo.core.ctsreparg.impl;

import java.util.List;

import com.path.bo.core.ctsreparg.CtsReportArgBO;
import com.path.dao.core.ctsreparg.CtsReportArgDAO;
import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public class CtsReportArgBOImpl extends BaseBO implements CtsReportArgBO
{
    private CtsReportArgDAO ctsReportArgDAO;
    
    @Override
    public List reportArgList(CtsReportArgSC criteria) throws BaseException
    {
	return ctsReportArgDAO.reportArgList(criteria);
    }

    @Override
    public int reportArgListCount(CtsReportArgSC criteria) throws BaseException
    {
	return ctsReportArgDAO.reportArgListCount(criteria);
    }

	@Override
	public CTS_REP_ARGVO reportArgById(CtsReportArgSC criteria) throws BaseException
	{
		return (CTS_REP_ARGVO) ctsReportArgDAO.reportArgById(criteria);
	}

	public CtsReportArgDAO getCtsReportArgDAO()
	{
		return ctsReportArgDAO;
	}

	public void setCtsReportArgDAO(CtsReportArgDAO ctsReportArgDAO)
	{
		this.ctsReportArgDAO = ctsReportArgDAO;
	}

}
