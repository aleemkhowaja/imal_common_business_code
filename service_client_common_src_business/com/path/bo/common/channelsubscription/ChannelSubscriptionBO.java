package com.path.bo.common.channelsubscription;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.channelsubscription.ChannelSubscriptionCO;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;

import java.util.List;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ChannelSubscriptionBO.java used to
 */
public interface ChannelSubscriptionBO
{
    public int returnChannelSubscriptionListCount(ChannelSubscriptionSC criteria) throws BaseException;

    public List returnChannelSubscriptionList(ChannelSubscriptionSC criteria) throws BaseException;

    public ChannelSubscriptionCO save(ChannelSubscriptionCO ChannelSubscriptionCO) throws BaseException;
}