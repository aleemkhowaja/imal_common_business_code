package com.path.dao.core.reports.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.reports.ReportsDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.yrt.YRTSC;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.reports.ReportsSC;

public class ReportsDAOImpl extends BaseDAO implements ReportsDAO
{

    @Override
    public List<SelectCO> selectRifMessage(ReportsSC reportsSC) throws DAOException
    {
	return sqlMap.queryForList("reportsMapper.selectRifMessage", reportsSC);
    }


    /**
     * check if there exist any account between from account & to account
     */
    @Override
    public Integer accountRangeValidity(ReportsCO reportsCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("reportsMapper.accountRangeValidity", reportsCO);
    }

    @Override
    public String getOpenedDateBranch(YRTSC yrtSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("reportsMapper.getOpenedDateBranch", yrtSC);
    }

    @Override
    public ReportsCO getProcessStmtInitData(ReportsCO reportsCO) throws DAOException
    {
	return (ReportsCO) getSqlMap().queryForObject("reportsMapper.getProcessStmtInitData", reportsCO);
    }

    @Override
    public BigDecimal getMaxCifNo(ReportsCO reportsCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("reportsMapper.getMaxCifNo", reportsCO);
    }

    @Override
    public BigDecimal getMaxGlCode(ReportsCO reportsCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("reportsMapper.getMaxGlCode", reportsCO);
    }

    @Override
    public int getProcessingStmtData(ReportsCO reportsCO) throws DAOException
    {
	reportsCO.setFrom_date_str(DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT));
	reportsCO.setTo_date_str(DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT));
	return (Integer) getSqlMap().queryForObject("reportsMapper.getProcessingStmtData", reportsCO);
    }

    @Override
    public List<AMFVO> returnAMFbasedOnFieldId(ReportsSC criteria) throws DAOException
    {
	return (List<AMFVO>) getSqlMap().queryForList("reportsMapper.returnAMFbasedOnFieldId", criteria);
    }

    public int updateTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException
    {
	return getSqlMap().update("reportsMapper.updateTMPReports", criteria);
    }

    public Integer countTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException
    {
	return (Integer)getSqlMap().queryForObject("reportsMapper.countTMPReports", criteria);
    }
    
    public TMP_REPORTSVOWithBLOBs returnTmpReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException
    {
	return (TMP_REPORTSVOWithBLOBs)getSqlMap().queryForObject("reportsMapper.returnTmpReports", criteria);
    }


    @Override
    public BigDecimal checkAccountRestriction(ReportsCO reportsCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("reportsMapper.checkAccountRestriction", reportsCO);
    }
}
