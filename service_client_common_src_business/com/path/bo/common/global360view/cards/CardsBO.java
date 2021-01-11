/**
 * 
 */
package com.path.bo.common.global360view.cards;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.CardsCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesBO.java used to
 */
public interface CardsBO
{
    public int cardsListCount(DashboardSC criteria) throws BaseException;
    public List<CardsCO> cardsList(DashboardSC criteria) throws BaseException;
    public int cardsManagementListCount(CardsManagementSC criteria) throws BaseException;
    public List cardsManagementList(CardsManagementSC criteria) throws BaseException;
    //Hala Al Sheikh - ABEI180106
    public int collateralsListCount(CardsManagementSC cardsManagementSC) throws BaseException;
    public List collateralsList(CardsManagementSC cardsManagementSC) throws BaseException;
}
