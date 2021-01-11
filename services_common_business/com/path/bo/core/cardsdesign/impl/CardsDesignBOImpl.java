package com.path.bo.core.cardsdesign.impl;

import java.util.List;

import com.path.bo.core.cardsdesign.CardsDesignBO;
import com.path.dao.core.cardsdesign.CardsDesignDAO;
import com.path.dbmaps.vo.CTSCARDS_DESIGNVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardsDesignBOImpl extends BaseBO implements CardsDesignBO
{
	private CardsDesignDAO cardsDesignDAO;
	
	@Override
	public List cardsDesignList(CardTypeSC criteria) throws BaseException
	{
		return cardsDesignDAO.cardsDesignList(criteria);
	}

	@Override
	public int cardsDesignListCount(CardTypeSC criteria) throws BaseException
	{
		return cardsDesignDAO.cardsDesignListCount(criteria);
	}

	@Override
	public CTSCARDS_DESIGNVO returnCardsDesignById(CardTypeSC criteria) throws BaseException
	{
		return (CTSCARDS_DESIGNVO) cardsDesignDAO.returnCardsDesignById(criteria);
	}

	public CardsDesignDAO getCardsDesignDAO()
	{
		return cardsDesignDAO;
	}

	public void setCardsDesignDAO(CardsDesignDAO cardsDesignDAO)
	{
		this.cardsDesignDAO = cardsDesignDAO;
	}

}
