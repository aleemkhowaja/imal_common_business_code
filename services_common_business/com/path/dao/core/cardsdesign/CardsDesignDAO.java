package com.path.dao.core.cardsdesign;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDS_DESIGNVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardsDesignDAO
{
	public int cardsDesignListCount(CardTypeSC criteria) throws DAOException;
    public List cardsDesignList(CardTypeSC criteria) throws DAOException;
    public CTSCARDS_DESIGNVO returnCardsDesignById(CardTypeSC criteria) throws DAOException;
}

