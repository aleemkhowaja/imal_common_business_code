package com.path.dao.core.cardintegration.impl;

import java.util.List;


import com.path.dao.core.cardintegration.CardIntegrationDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cardintegration.CardIntegrationCO;
import com.path.vo.core.cardintegration.CardIntegrationSC;
import com.path.vo.core.link.LinkSC;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: Hussein elhajj
 * 
 * CardIntegrationDAOImpl.java used to
 */
public class CardIntegrationDAOImpl extends BaseDAO implements CardIntegrationDAO
{
   

    public int debitCardTypeLookupCount(CardIntegrationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cardIntegrationMapper.debitCardTypeLkpMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cardIntegrationMapper.debitCardTypeLkpCount", criteria)).intValue();
	return nb;
    }

    
    //Get All Cards Type Codes of type Debit
    public List debitCardTypeLookupRecs(CardIntegrationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cardIntegrationMapper.debitCardTypeLkpMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cardIntegrationMapper.debitCardTypeLkpRecords", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("cardIntegrationMapper.debitCardTypeLkpRecords", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }


}
