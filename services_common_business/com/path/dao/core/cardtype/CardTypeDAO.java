/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.cardtype;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.cardtype.CardTypeSC;

public interface CardTypeDAO 
{
    public int cardTypeListCount(CardTypeSC criteria)throws DAOException;
    public List cardTypeList(CardTypeSC criteria)throws DAOException;
    public CTSCARDSVO returnCardTypeById(CardTypeSC criteria)throws DAOException;
    
    public CTSCARDSVO returnDefaultedCardByCifTypeCode(CardTypeSC criteria) throws DAOException;
    
    public int cardMgtListCount(CardsManagementSC criteria)throws DAOException;
    public List cardMgtList(CardsManagementSC criteria)throws DAOException;

}
