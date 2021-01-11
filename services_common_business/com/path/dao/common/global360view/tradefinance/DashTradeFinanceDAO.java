/**
 * 
 */
package com.path.dao.common.global360view.tradefinance;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashTradeFinanceCO;
import com.path.vo.common.global360view.DashboardSC;


/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashChequesServicesDAO.java used to
 */
public interface DashTradeFinanceDAO
{
    public int acceptanceListCount(DashboardSC criteria) throws BaseException;
    public List<DashTradeFinanceCO> acceptanceList(DashboardSC criteria) throws BaseException;
    
    public int inOutBillsListCount(DashboardSC criteria) throws BaseException;
    public List<DashTradeFinanceCO> inOutBillsList(DashboardSC criteria) throws BaseException;
    
    public int lgListCount(DashboardSC criteria) throws BaseException;
    public List<DashTradeFinanceCO> lgList(DashboardSC criteria) throws BaseException;
    
    public int inOutLCListCount(DashboardSC criteria) throws BaseException;
    public List<DashTradeFinanceCO> inOutLCList(DashboardSC criteria) throws BaseException;
}