/**
 * 
 */
package com.path.dao.common.global360view.lostdocuments;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.LostDocumentsCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashLostDocsDAO.java used to
 */
public interface DashLostDocsDAO
{
    public int lostDocsListCount(DashboardSC criteria) throws DAOException;
    public List<LostDocumentsCO> lostDocsList(DashboardSC criteria) throws DAOException;

}
