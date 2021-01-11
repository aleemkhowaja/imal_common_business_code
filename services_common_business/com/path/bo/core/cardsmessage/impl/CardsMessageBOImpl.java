package com.path.bo.core.cardsmessage.impl;

import java.util.List;

import com.path.bo.core.cardsmessage.CardsMessageBO;
import com.path.dao.core.cardsmessage.CardsMessageDAO;
import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardsMessageBOImpl extends BaseBO implements CardsMessageBO
{
	private CardsMessageDAO cardsMessageDAO;
	
	@Override
	public List cardsMessageList(CardTypeSC criteria) throws BaseException
	{
		return cardsMessageDAO.cardsMessageList(criteria);
	}

	@Override
	public int cardsMessageListCount(CardTypeSC criteria) throws BaseException
	{
		return cardsMessageDAO.cardsMessageListCount(criteria);
	}

	@Override
	public CTSCARDS_MESSAGEVO returnCardsMessageById(CardTypeSC criteria) throws BaseException
	{
		return (CTSCARDS_MESSAGEVO) cardsMessageDAO.returnCardsMessageById(criteria);
	}

	public CardsMessageDAO getCardsMessageDAO()
	{
		return cardsMessageDAO;
	}

	public void setCardsMessageDAO(CardsMessageDAO cardsMessageDAO)
	{
		this.cardsMessageDAO = cardsMessageDAO;
	}

}
