package com.path.dao.core.cardsmessage;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardsMessageDAO
{
	public int cardsMessageListCount(CardTypeSC criteria) throws DAOException;
    public List cardsMessageList(CardTypeSC criteria) throws DAOException;
    public CTSCARDS_MESSAGEVO returnCardsMessageById(CardTypeSC criteria) throws DAOException;
}

