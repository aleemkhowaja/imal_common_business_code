package com.path.bo.core.cardsdesign;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDS_DESIGNVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardsDesignBO
{
	public int cardsDesignListCount(CardTypeSC criteria) throws BaseException;
    public List cardsDesignList(CardTypeSC criteria) throws BaseException;
    public CTSCARDS_DESIGNVO returnCardsDesignById(CardTypeSC criteria) throws BaseException;

}
