package com.path.actions.common.channelsubscription;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.channelsubscription.ChannelSubscriptionBO;
import com.path.bo.common.channelsubscription.ChannelSubscriptionConstant;
import com.path.bo.core.csmfom.FomConstant;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.channelsubscription.ChannelSubscriptionCO;
import com.path.vo.common.channelsubscription.ChannelSubscriptionSC;

/**
 * @author RakanMakarem Copyright 2013, Path Solutions Path Solutions retains
 *         all ownership rights to this source code
 * 
 *         ChannelSubscriptionMaintAction.java used to
 */
public class ChannelSubscriptionMaintAction extends BaseAction
{
    private ChannelSubscriptionBO channelSubscriptionBO;
    private ChannelSubscriptionSC channelSubscriptionSC = new ChannelSubscriptionSC();
    private ChannelSubscriptionCO channelSubscriptionCO = new ChannelSubscriptionCO();
    private String channelSubscriptionStr;

    /**
     * this method will load the main jsp page of the grid 
     */
    public String loadChannelSubscriptionPage()
    {
	try
	{
	    set_searchGridId("channelSubscriptionListGridTbl_Id");
	    //enable only in case of active,inactive, draft status
	    if(FomConstant.FOM_MAINTENANCE_IV_CRUD.equals(getIv_crud())
		    && ( FomConstant.STATUS_ACTIVE.equals(channelSubscriptionSC.getCifStatus())
			    || FomConstant.STATUS_INACTIVE.equals(channelSubscriptionSC.getCifStatus())
			    || ChannelSubscriptionConstant.CIF_STATUS_DRAFT.equals(channelSubscriptionSC.getCifStatus())))
	    {
		set_recReadOnly("false");
	    }
	    else
	    {
		//otherwise set the screen disabled (approve,...)
		set_recReadOnly("true");
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "channelSubscriptionList";
    }

    @Override
    public Object getModel()
    {
	return channelSubscriptionCO;
    }

    /**
     * This function below is called to save record
     */
    public String save()
    {
	try
	{
	    fillCoFromSession();
	    fillChannelSubscriptionPageFromStr();

	    channelSubscriptionCO = channelSubscriptionBO.save(channelSubscriptionCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "successJson";
    }

    /**
     * fill needed properties from sessionCO
     */
    private void fillCoFromSession()
    {
	SessionCO sessionCO = returnSessionObject();
	channelSubscriptionCO.setLoginCompCode(sessionCO.getCompanyCode());
	channelSubscriptionCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
    }

    private void fillChannelSubscriptionPageFromStr()
    {
	List<ChannelSubscriptionCO> clubbedAccountsDetailCOs = new ArrayList<ChannelSubscriptionCO>();
	if(channelSubscriptionStr != null && !"".equalsIgnoreCase(channelSubscriptionStr))
	{
	    GridUpdates gu = getGridUpdates(channelSubscriptionStr, ChannelSubscriptionCO.class, false);
	    clubbedAccountsDetailCOs = gu.getLstModify();
	    channelSubscriptionCO.getChannelSubscriptionCOList().addAll(clubbedAccountsDetailCOs);
	}
    }

    public void setChannelSubscriptionBO(ChannelSubscriptionBO channelSubscriptionBO)
    {
	this.channelSubscriptionBO = channelSubscriptionBO;
    }

    public final ChannelSubscriptionSC getChannelSubscriptionSC()
    {
	return channelSubscriptionSC;
    }

    public final void setChannelSubscriptionSC(ChannelSubscriptionSC channelSubscriptionSC)
    {
	this.channelSubscriptionSC = channelSubscriptionSC;
    }

    public final ChannelSubscriptionCO getChannelSubscriptionCO()
    {
	return channelSubscriptionCO;
    }

    public final void setChannelSubscriptionCO(ChannelSubscriptionCO channelSubscriptionCO)
    {
	this.channelSubscriptionCO = channelSubscriptionCO;
    }

    public final String getChannelSubscriptionStr()
    {
	return channelSubscriptionStr;
    }

    public final void setChannelSubscriptionStr(String channelSubscriptionStr)
    {
	this.channelSubscriptionStr = channelSubscriptionStr;
    }
}
