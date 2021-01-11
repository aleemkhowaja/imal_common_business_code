package com.path.bo.core.printreports.impl;

import java.util.List;

import com.path.bo.core.printreports.PrintReportsBO;
import com.path.dao.core.printreports.PrintReportsDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.printreports.PrintReportsSC;



public class PrintReportsBOImpl extends BaseBO implements PrintReportsBO
{
    private PrintReportsDAO printReportsDAO;
    
    
    @Override
    public int printReportsListCount(PrintReportsSC criteria) throws BaseException
    {
	return printReportsDAO.printReportsListCount(criteria);
    }
    @Override
    public List printReportsList(PrintReportsSC criteria) throws BaseException
    {
	return printReportsDAO.printReportsList(criteria);
    }
    
    public PrintReportsDAO getPrintReportsDAO()
    {
        return printReportsDAO;
    }
    public void setPrintReportsDAO(PrintReportsDAO printReportsDAO)
    {
        this.printReportsDAO = printReportsDAO;
    }
    
    
}
