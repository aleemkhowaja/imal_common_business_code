/**
 * 
 */
package com.path.bo.common.global360view.bankerscheques;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.BankersChequesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashBankersChequesBO.java used to
 */
public interface DashBankersChequesBO
{
    public int bankersChequesListCount(DashboardSC criteria) throws BaseException;
    public List<BankersChequesCO> bankersChequesList(DashboardSC criteria) throws BaseException;
}
