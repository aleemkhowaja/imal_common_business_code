package com.path.actions.common.channelsubscription;

import com.path.bo.common.channelsubscription.ChannelSubscriptionBO;
import com.path.bo.common.channelsubscription.ChannelSubscriptionConstant;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;

/**
 * /**
 * 
 * @author RakanMakarem Copyright 2013, Path Solutions Path Solutions retains
 *         all ownership rights to this source code
 * 
 *         ChannelSubscriptionListAction.java used to
 */
public class ChannelSubscriptionListAction extends GridBaseAction
{
    private ChannelSubscriptionBO channelSubscriptionBO;
    private ChannelSubscriptionSC channelSubscriptionSC = new ChannelSubscriptionSC();

    public String loadChannelSubscriptionGrid()
    {
	try
	{
	    String[] searchCol = { "CIF_NO", "CHANNEL_DESC", "ACC_BR", "ACC_CY", "ACC_GL", "ACC_CIF", "ACC_SL" };
	    SessionCO sessionCO = returnSessionObject();
	    channelSubscriptionSC.setSearchCols(searchCol);
	    // criteria.setDateSearchCols(hmDate);
	    copyproperties(channelSubscriptionSC);
	    channelSubscriptionSC.setCompCode(sessionCO.getCompanyCode());
	    channelSubscriptionSC.setLovType(ChannelSubscriptionConstant.LOV_TYPE);
	    channelSubscriptionSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    channelSubscriptionSC.setLangCode(sessionCO.getLanguage());
	    if(checkNbRec(channelSubscriptionSC))
	    {
		setRecords(channelSubscriptionBO.returnChannelSubscriptionListCount(channelSubscriptionSC));
	    }
	    setGridModel(channelSubscriptionBO.returnChannelSubscriptionList(channelSubscriptionSC));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadChannelSubscriptionGrid of ChannelSubscriptionListAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return channelSubscriptionSC;
    }

    public final ChannelSubscriptionSC getChannelSubscriptionSC()
    {
	return channelSubscriptionSC;
    }

    public final void setChannelSubscriptionSC(ChannelSubscriptionSC channelSubscriptionSC)
    {
	this.channelSubscriptionSC = channelSubscriptionSC;
    }

    public void setChannelSubscriptionBO(ChannelSubscriptionBO channelSubscriptionBO)
    {
	this.channelSubscriptionBO = channelSubscriptionBO;
    }

}
