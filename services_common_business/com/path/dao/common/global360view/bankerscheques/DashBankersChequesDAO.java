/**
 * 
 */
package com.path.dao.common.global360view.bankerscheques;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.BankersChequesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashBankersChequesDAO.java used to
 */
public interface DashBankersChequesDAO
{
    public int bankersChequesListCount(DashboardSC criteria) throws DAOException;
    public List<BankersChequesCO> bankersChequesList(DashboardSC criteria) throws DAOException;

}
