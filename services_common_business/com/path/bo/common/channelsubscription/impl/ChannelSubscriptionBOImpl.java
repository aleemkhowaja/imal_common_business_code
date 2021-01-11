package com.path.bo.common.channelsubscription.impl;

import java.util.List;

import com.path.bo.common.channelsubscription.ChannelSubscriptionBO;
import com.path.dao.common.channelsubscription.ChannelSubscriptionDAO;
import com.path.dbmaps.vo.CIF_CHANNEL_REGISTRATIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.channelsubscription.ChannelSubscriptionCO;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ChannelSubscriptionBOImpl.java used to
 */
public class ChannelSubscriptionBOImpl extends BaseBO implements ChannelSubscriptionBO
{
    ChannelSubscriptionDAO channelSubscriptionDAO;

    /**
     * Method used to return Count of ChannelSubscription
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnChannelSubscriptionListCount(ChannelSubscriptionSC criteria) throws BaseException
    {
	return channelSubscriptionDAO.returnChannelSubscriptionListCount(criteria);
    }

    /**
     * Method used to return List of ChannelSubscription
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnChannelSubscriptionList(ChannelSubscriptionSC criteria) throws BaseException
    {
	return channelSubscriptionDAO.returnChannelSubscriptionList(criteria);
    }

    /**
     * @author RakanMakarem 
     * this function will update the grid
     */
    public ChannelSubscriptionCO save(ChannelSubscriptionCO channelSubscriptionCO) throws BaseException
    {
	if(channelSubscriptionCO.getChannelSubscriptionCOList() != null
		&& !channelSubscriptionCO.getChannelSubscriptionCOList().isEmpty())
	{
	    for(int i = 0; i < channelSubscriptionCO.getChannelSubscriptionCOList().size(); i++)
	    {
		CIF_CHANNEL_REGISTRATIONVO channelRegistrationVO = new CIF_CHANNEL_REGISTRATIONVO();
		channelRegistrationVO.setCOMP_CODE(channelSubscriptionCO.getLoginCompCode());
		channelRegistrationVO.setCIF_NO(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getCIF_NO());
		channelRegistrationVO.setCHANNEL(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getCHANNEL());
		channelRegistrationVO.setACC_BR(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getACC_BR());
		channelRegistrationVO.setACC_CY(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getACC_CY());
		channelRegistrationVO.setACC_GL(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getACC_GL());
		channelRegistrationVO.setACC_CIF(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getACC_CIF());
		channelRegistrationVO.setACC_SL(channelSubscriptionCO.getChannelSubscriptionCOList().get(i)
			.getCifChannelRegistrationVO().getACC_SL());

		genericDAO.update(channelRegistrationVO);

	    }
	}

	return channelSubscriptionCO;
    }

    public ChannelSubscriptionDAO getChannelSubscriptionDAO()
    {
	return channelSubscriptionDAO;
    }

    public void setChannelSubscriptionDAO(ChannelSubscriptionDAO channelSubscriptionDAO)
    {
	this.channelSubscriptionDAO = channelSubscriptionDAO;
    }
}
