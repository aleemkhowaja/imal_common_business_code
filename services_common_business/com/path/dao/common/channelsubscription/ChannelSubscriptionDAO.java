package com.path.dao.common.channelsubscription;

import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;
import com.path.vo.core.account.AccountSC;

import java.util.List;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ChannelSubscriptionDAO.java used to
 */
public interface ChannelSubscriptionDAO
{
    public int returnChannelSubscriptionListCount(ChannelSubscriptionSC criteria) throws DAOException;

    public List returnChannelSubscriptionList(ChannelSubscriptionSC criteria) throws DAOException;

    public List<AMFVO> returnAMFByAddRef(AccountSC accountSC) throws DAOException;
}