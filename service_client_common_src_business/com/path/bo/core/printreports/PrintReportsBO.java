package com.path.bo.core.printreports;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.printreports.PrintReportsSC;


public interface PrintReportsBO
{
    public int printReportsListCount(PrintReportsSC criteria) throws BaseException;
    public List printReportsList(PrintReportsSC criteria) throws BaseException;
    
  
}
