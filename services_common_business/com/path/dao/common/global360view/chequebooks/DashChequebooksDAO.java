/**
 * 
 */
package com.path.dao.common.global360view.chequebooks;

import java.util.List;

import com.path.vo.core.chequebook.ChequeBookCO;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ChequebooksDAO.java used to
 */
public interface DashChequebooksDAO
{
    public int chequebooksListCount(DashboardSC criteria) throws DAOException;
    public List<ChequeBookCO> chequebooksList(DashboardSC criteria) throws DAOException;
}
