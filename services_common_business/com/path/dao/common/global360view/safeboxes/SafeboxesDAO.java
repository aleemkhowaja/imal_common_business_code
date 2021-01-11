/**
 * 
 */
package com.path.dao.common.global360view.safeboxes;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesDAO.java used to
 */
public interface SafeboxesDAO
{
    public int safeboxesListCount(DashboardSC criteria) throws DAOException;
    public List safeboxesList(DashboardSC criteria) throws DAOException;
}
