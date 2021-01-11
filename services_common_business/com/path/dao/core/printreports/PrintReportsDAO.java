package com.path.dao.core.printreports;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.printreports.PrintReportsSC;

public interface PrintReportsDAO
{
    public int printReportsListCount(PrintReportsSC criteria) throws DAOException;
    public List printReportsList(PrintReportsSC criteria) throws DAOException;
}
