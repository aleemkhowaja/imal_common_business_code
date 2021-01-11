/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.cardtype;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardTypeBO 
{
    public int cardTypeListCount(CardTypeSC criteria)throws BaseException;
    public List cardTypeList(CardTypeSC criteria)throws BaseException;
    public CTSCARDSVO returnCardTypeById(CardTypeSC criteria)throws BaseException;
    
    public CTSCARDSVO returnDefaultedCardByCifTypeCode(CardTypeSC criteria) throws BaseException;
    
    public int cardMgtListCount(CardsManagementSC criteria)throws BaseException;
    public List cardMgtList(CardsManagementSC criteria)throws BaseException;
}