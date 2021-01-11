/**
 * 
 */
package com.path.bo.common.global360view.tradefinance.impl;

import java.util.List;

import com.path.bo.common.global360view.tradefinance.DashTradeFinanceBO;
import com.path.dao.common.global360view.tradefinance.DashTradeFinanceDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashTradeFinanceCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersBOImpl.java used to
 */
public class DashTradeFinanceBOImpl extends BaseBO implements DashTradeFinanceBO
{
    private DashTradeFinanceDAO dashTradeFinanceDAO;
    
    public int acceptanceListCount(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.acceptanceListCount(criteria);
    }
    public List<DashTradeFinanceCO> acceptanceList(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.acceptanceList(criteria);
    }
    
    public int inOutBillsListCount(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.inOutBillsListCount(criteria);
    }
    public List<DashTradeFinanceCO> inOutBillsList(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.inOutBillsList(criteria);
    }
    
    public int lgListCount(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.lgListCount(criteria);
    }
    public List<DashTradeFinanceCO> lgList(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.lgList(criteria);
    }
    
    public int inOutLCListCount(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.inOutLCListCount(criteria);
    }
    public List<DashTradeFinanceCO> inOutLCList(DashboardSC criteria) throws BaseException
    {
	return dashTradeFinanceDAO.inOutLCList(criteria);
    }
    
    public DashTradeFinanceDAO getDashTradeFinanceDAO()
    {
        return dashTradeFinanceDAO;
    }
    public void setDashTradeFinanceDAO(DashTradeFinanceDAO dashTradeFinanceDAO)
    {
        this.dashTradeFinanceDAO = dashTradeFinanceDAO;
    }
}
