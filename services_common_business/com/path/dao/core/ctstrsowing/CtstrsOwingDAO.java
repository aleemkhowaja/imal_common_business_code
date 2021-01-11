/**
 * 
 */
package com.path.dao.core.ctstrsowing;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ctstrsowing.CtstrsOwingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CtstrsOwingDAO.java used to
 */
public interface CtstrsOwingDAO
{
    public int ctstrsOwingListCount(CtstrsOwingSC criteria) throws DAOException;
    public List ctstrsOwingList(CtstrsOwingSC criteria) throws DAOException;
}
