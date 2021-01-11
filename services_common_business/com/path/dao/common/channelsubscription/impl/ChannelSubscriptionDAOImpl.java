package com.path.dao.common.channelsubscription.impl;

import com.path.dao.common.channelsubscription.ChannelSubscriptionDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;
import com.path.vo.core.account.AccountSC;

import java.util.List;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ChannelSubscriptionDAOImpl.java used to
 */
public class ChannelSubscriptionDAOImpl extends BaseDAO implements ChannelSubscriptionDAO
{
    /**
     * Method used to return Count of ChannelSubscription
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    public int returnChannelSubscriptionListCount(ChannelSubscriptionSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "channelSubscriptionMapper.resChannelSubscriptionListMap");
	return ((Integer) getSqlMap().queryForObject("channelSubscriptionMapper.returnChannelSubscriptionListCount",
		criteria)).intValue();
    }

    /**
     * Method used to return List of ChannelSubscription
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnChannelSubscriptionList(ChannelSubscriptionSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "channelSubscriptionMapper.resChannelSubscriptionListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("channelSubscriptionMapper.returnChannelSubscriptionList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("channelSubscriptionMapper.returnChannelSubscriptionList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public List<AMFVO> returnAMFByAddRef(AccountSC accountSC) throws DAOException
    {

	return getSqlMap().queryForList("accountMapper.returnAMFByAddRef", accountSC);
    }
}
