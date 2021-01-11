package com.path.bo.core.cardsmessage;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardsMessageBO
{
	public int cardsMessageListCount(CardTypeSC criteria) throws BaseException;
    public List cardsMessageList(CardTypeSC criteria) throws BaseException;
    public CTSCARDS_MESSAGEVO returnCardsMessageById(CardTypeSC criteria) throws BaseException;

}
