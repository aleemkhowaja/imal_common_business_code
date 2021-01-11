package com.path.dao.core.reports;

import java.math.BigDecimal;
import java.util.List;


import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.yrt.YRTSC;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.reports.ReportsSC;

public interface ReportsDAO
{

    List<SelectCO> selectRifMessage(ReportsSC reportsSC) throws DAOException;

    Integer accountRangeValidity(ReportsCO reportsCO) throws DAOException;

    String getOpenedDateBranch(YRTSC yrtSC) throws DAOException;

    ReportsCO getProcessStmtInitData(ReportsCO reportsCO) throws DAOException;

    BigDecimal getMaxCifNo(ReportsCO reportsCO) throws DAOException;

    BigDecimal getMaxGlCode(ReportsCO reportsCO) throws DAOException;

    int getProcessingStmtData(ReportsCO reportsCO) throws DAOException;

    List<AMFVO> returnAMFbasedOnFieldId(ReportsSC criteria) throws DAOException;
    
    int updateTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException;
    
    Integer countTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException;
    
    public TMP_REPORTSVOWithBLOBs returnTmpReports(TMP_REPORTSVOWithBLOBs criteria) throws DAOException;

    public BigDecimal checkAccountRestriction(ReportsCO reportsCO) throws DAOException;

}
