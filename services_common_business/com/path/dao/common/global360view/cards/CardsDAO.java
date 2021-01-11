/**
 * 
 */
package com.path.dao.common.global360view.cards;

import java.util.List;

import com.path.dbmaps.vo.FMSCOLLATERALVO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.CardsCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.cardsmanagement.CardsManagementSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesDAO.java used to
 */
public interface CardsDAO
{
    public int cardsListCount(DashboardSC criteria) throws DAOException;
    public List<CardsCO> cardsList(DashboardSC criteria) throws DAOException;
    public int cardsManagementListCount(CardsManagementSC criteria) throws DAOException;
    public List cardsManagementList(CardsManagementSC criteria) throws DAOException;
    //Hala Al Sheikh - ABEI180106
    public int collateralsListCount(CardsManagementSC cardsManagementSC) throws DAOException;
    public List<FMSCOLLATERALVO> collateralsList(CardsManagementSC cardsManagementSC) throws DAOException; 
}
