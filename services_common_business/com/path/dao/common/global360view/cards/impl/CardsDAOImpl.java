/**
 * 
 */
package com.path.dao.common.global360view.cards.impl;

import java.util.List;

import com.path.dao.common.global360view.cards.CardsDAO;
import com.path.dbmaps.vo.FMSCOLLATERALVO;
import com.path.lib.common.base.BaseDAO;
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
 * SafeboxesDAOImpl.java used to
 */
public class CardsDAOImpl extends BaseDAO implements CardsDAO
{
    public int cardsListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashCardsMapper.cardsListMap");
	criteria.applyMaskResult(new String[]{"CARD_NO"});
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashCardsMapper.getCardsListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<CardsCO> cardsList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashCardsMapper.cardsListMap");
	criteria.applyMaskResult(new String[]{"CARD_NO"});
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashCardsMapper.getCardsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashCardsMapper.getCardsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }
    
    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException Hasan Youssef BB140052
     */
    public int cardsManagementListCount(CardsManagementSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashCardsMapper.cardsManagementMap");
		criteria.applyMaskResult(new String[]{"CARD_NO"});
	return ((Integer) getSqlMap().queryForObject("dashCardsMapper.cardsManagementListCount", criteria)).intValue();
    }

    public List cardsManagementList(CardsManagementSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashCardsMapper.cardsManagementMap");
	criteria.applyMaskResult(new String[]{"CARD_NO"});
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashCardsMapper.cardsManagementList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashCardsMapper.cardsManagementList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    //Hala Al Sheikh - ABEI180106
    public int collateralsListCount(CardsManagementSC cardsManagementSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cardsManagementSC, getSqlMap(), "dashCardsMapper.collateralsGridMap");
	return ((Integer) getSqlMap().queryForObject("dashCardsMapper.collateralsListCount", cardsManagementSC)).intValue();
    }
    public List<FMSCOLLATERALVO> collateralsList(CardsManagementSC cardsManagementSC) throws DAOException
    {
	if(cardsManagementSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashCardsMapper.collateralsList", cardsManagementSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cardsManagementSC, getSqlMap(), "dashCardsMapper.collateralsGridMap");
	    return getSqlMap().queryForList("dashCardsMapper.collateralsList", cardsManagementSC,cardsManagementSC.getRecToskip(), cardsManagementSC.getNbRec());
	}
    }
    //End Hala Al Sheikh - ABEI180106
}
