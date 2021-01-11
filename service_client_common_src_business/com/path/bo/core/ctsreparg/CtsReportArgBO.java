package com.path.bo.core.ctsreparg;

import java.util.List;

import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public interface CtsReportArgBO
{
	public int  reportArgListCount(CtsReportArgSC criteria) throws BaseException;
	public List reportArgList(CtsReportArgSC criteria) throws BaseException;
	public CTS_REP_ARGVO  reportArgById(CtsReportArgSC criteria) throws BaseException;

}
