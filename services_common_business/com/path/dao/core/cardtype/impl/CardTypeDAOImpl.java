/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Te\am.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.cardtype.impl;

import java.util.List;

import com.path.dao.core.cardtype.CardTypeDAO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardTypeDAOImpl extends BaseDAO implements CardTypeDAO
{
    public int cardTypeListCount(CardTypeSC criteria)throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cardTypeMapper.cardTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cardTypeMapper.cardTypeListCount", criteria)).intValue();
	return nb;
    }
    
    public List cardTypeList(CardTypeSC criteria)throws DAOException
    {
	 DAOHelper.fixGridMaps(criteria, getSqlMap(), "cardTypeMapper.cardTypeListMap");
	 
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cardTypeMapper.cardTypeList", criteria);
	}
	else
	{   
	    return getSqlMap().queryForList("cardTypeMapper.cardTypeList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public CTSCARDSVO returnCardTypeById(CardTypeSC criteria)throws DAOException
    {
	return (CTSCARDSVO) getSqlMap().queryForObject("cardTypeMapper.returnCardTypeById", criteria);
    }

	@Override
	public CTSCARDSVO returnDefaultedCardByCifTypeCode(CardTypeSC criteria) throws DAOException
	{
		return (CTSCARDSVO) getSqlMap().queryForObject("cardTypeMapper.returnDefaultedCardByCifTypeCode", criteria);
	}

	@Override
	public List cardMgtList(CardsManagementSC criteria) throws DAOException
	{
	    criteria.applyMaskResult(new String[]{"CARD_NO"});
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("CTSCARDS_MGT.BaseResultMap", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_MGT.BaseResultMap");
		    return getSqlMap().queryForList("cardTypeMapper.cardMgtList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int cardMgtListCount(CardsManagementSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCARDS_MGT.BaseResultMap");
		criteria.applyMaskResult(new String[]{"CARD_NO"});
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("cardTypeMapper.cardMgtListCount", criteria)).intValue();
		return nb;
	}
}
