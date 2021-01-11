/**
 * 
 */
package com.path.bo.common.global360view.chequebooks;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.chequebook.ChequeBookCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ChequebooksBO.java used to
 */
public interface DashChequebooksBO
{
    public int chequebooksListCount(DashboardSC criteria) throws BaseException;
    public List<ChequeBookCO> chequebooksList(DashboardSC criteria) throws BaseException;
}
