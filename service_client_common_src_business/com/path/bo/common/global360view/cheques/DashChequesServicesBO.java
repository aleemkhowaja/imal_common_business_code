/**
 * 
 */
package com.path.bo.common.global360view.cheques;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashChequesServicesBO.java used to
 */
public interface DashChequesServicesBO
{
    public int voidedChequesListCount(DashboardSC criteria) throws BaseException;
    public List<DashChequesServicesCO> voidedChequesList(DashboardSC criteria) throws BaseException;
    public int chequesForColListCount(DashboardSC criteria) throws BaseException;
    public List<DashChequesServicesCO> chequesForColList(DashboardSC criteria) throws BaseException;
    public int postDatedChqWDrawalListCount(DashboardSC criteria) throws BaseException;
    public List<DashChequesServicesCO> postDatedChqWDrawalList(DashboardSC criteria) throws BaseException;
    public int postDatedChqDepListCount(DashboardSC criteria) throws BaseException;
    public List<DashChequesServicesCO> postDatedChqDepList(DashboardSC criteria) throws BaseException;
}
