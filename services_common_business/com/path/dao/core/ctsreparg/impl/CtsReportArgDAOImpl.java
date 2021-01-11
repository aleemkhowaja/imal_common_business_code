package com.path.dao.core.ctsreparg.impl;

import java.util.List;

import com.path.dao.core.ctsreparg.CtsReportArgDAO;
import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public class CtsReportArgDAOImpl extends BaseDAO  implements CtsReportArgDAO
{

    @Override
    public List reportArgList(CtsReportArgSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("ctsReportArgMapper.ctsReportArgList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTS_REP_ARG.BaseResultMap");
	    return getSqlMap().queryForList("ctsReportArgMapper.ctsReportArgList", criteria, criteria.getRecToskip(),
	    		criteria.getNbRec());
	}
    }

    @Override
    public int reportArgListCount(CtsReportArgSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTS_REP_ARG.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("ctsReportArgMapper.ctsReportArgListCount", criteria)).intValue();
	return nb;
    }

	@Override
	public CTS_REP_ARGVO reportArgById(CtsReportArgSC criteria) throws DAOException
	{
		return (CTS_REP_ARGVO) getSqlMap().queryForObject("ctsReportArgMapper.ctsReportArgById", criteria);
	}
 

}
