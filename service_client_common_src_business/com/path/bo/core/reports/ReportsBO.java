package com.path.bo.core.reports;

import com.path.vo.core.reports.ReportsCO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.lib.common.exception.BaseException;

public interface ReportsBO
{

    ReportsCO checkCompanyDependency(ReportsCO reportsCO) throws Exception;

    ReportsCO getInitData(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkBranchByCodeDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkBeforeGenerate_statementOfAccount(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkStmtPeriodicity(ReportsCO reportsCO) throws BaseException;

    ReportsCO getProcessStmtInitData(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkBeforeGenerate_processingStmt(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkFromIbanDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkToIbanDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkFromReferenceDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkToReferenceDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkFromCardNoDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO showHideRangeByCriteria(ReportsCO reportsCO) throws BaseException;

    int updateTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException;

    public Integer countTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException;

    public TMP_REPORTSVOWithBLOBs returnTmpReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException;

    ReportsCO showHideRangeGregoHijri(ReportsCO reportsCO) throws BaseException;

    ReportsCO fromDateDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO toDateDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO msgIncludeInReportDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO chooseLanguageDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO rifMessageCodeDependency(ReportsCO reportsCO) throws BaseException;

    ReportsCO checkBeforeGenerate_authWithdTerm(ReportsCO reportsCOParam) throws BaseException;
    ReportsCO initialize_authWithdTerm(ReportsCO reportsCO) throws BaseException;

}
