package com.path.dao.core.ctsreparg;

import java.util.List;

import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public interface CtsReportArgDAO
{
	public int  reportArgListCount(CtsReportArgSC criteria) throws DAOException;
	public List reportArgList(CtsReportArgSC criteria) throws DAOException;
	public CTS_REP_ARGVO  reportArgById(CtsReportArgSC criteria) throws DAOException;
}
