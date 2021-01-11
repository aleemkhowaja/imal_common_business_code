/**
 * 
 */
package com.path.dao.core.pmsdeal;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealDAO.java used to
 */
public interface PmsDealDAO
{
    public int pmsDealListCount(PmsDealSC criteria) throws DAOException;

    public List<PmsDealCO> pmsDealList(PmsDealSC criteria) throws DAOException;

    public PmsDealCO returnDependencyByDealNo(PmsDealSC criteria) throws DAOException;

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException return deal details
     */
    public PmsDealCO returnDealAndDealCyDetail(PmsDealSC criteria) throws DAOException;
}
