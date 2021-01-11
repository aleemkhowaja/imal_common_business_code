package com.path.dao.core.cardsdesign.impl;

import java.util.List;

import com.path.dao.core.cardsdesign.CardsDesignDAO;
import com.path.dbmaps.vo.CTSCARDS_DESIGNVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardsDesignDAOImpl extends BaseDAO implements CardsDesignDAO
{

	@Override
	public List cardsDesignList(CardTypeSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("cardsDesignMapper.cardsDesignListList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_DESIGN.BaseResultMap");
		    return getSqlMap().queryForList("cardsDesignMapper.cardsDesignList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int cardsDesignListCount(CardTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_DESIGN.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("cardsDesignMapper.cardsDesignListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CTSCARDS_DESIGNVO returnCardsDesignById(CardTypeSC criteria) throws DAOException
	{
		return (CTSCARDS_DESIGNVO) getSqlMap().queryForObject("cardsDesignMapper.returnCardsDesignById", criteria);
	}

}
