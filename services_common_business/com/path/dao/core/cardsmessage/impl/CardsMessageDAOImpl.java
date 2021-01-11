package com.path.dao.core.cardsmessage.impl;

import java.util.List;

import com.path.dao.core.cardsmessage.CardsMessageDAO;
import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardsMessageDAOImpl extends BaseDAO implements CardsMessageDAO
{

	@Override
	public List cardsMessageList(CardTypeSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("cardsMessageMapper.cardsMessageList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_MESSAGE.BaseResultMap");
		    return getSqlMap().queryForList("cardsMessageMapper.cardsMessageList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int cardsMessageListCount(CardTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_MESSAGE.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("cardsMessageMapper.cardsMessageListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CTSCARDS_MESSAGEVO returnCardsMessageById(CardTypeSC criteria) throws DAOException
	{
		return (CTSCARDS_MESSAGEVO) getSqlMap().queryForObject("cardsMessageMapper.returnCardsMessageById", criteria);
	}

}
