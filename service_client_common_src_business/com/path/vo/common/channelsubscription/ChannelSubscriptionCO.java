package com.path.vo.common.channelsubscription;

import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AMFVOKey;
import com.path.dbmaps.vo.CIF_CHANNEL_REGISTRATIONVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ChannelSubscriptionCO.java used to
 */
import com.path.vo.core.common.RetailBaseVO;
public class ChannelSubscriptionCO  extends RetailBaseVO
{
   private CIF_CHANNEL_REGISTRATIONVO cifChannelRegistrationVO = new CIF_CHANNEL_REGISTRATIONVO();
   private String additionalReference; 
   private List<ChannelSubscriptionCO> channelSubscriptionCOList  =new ArrayList<ChannelSubscriptionCO>();
   private AMFVOKey amfVO = new AMFVOKey();
   private String channelDesc;
    
    public final CIF_CHANNEL_REGISTRATIONVO getCifChannelRegistrationVO()
    {
        return cifChannelRegistrationVO;
    }

    public final void setCifChannelRegistrationVO(CIF_CHANNEL_REGISTRATIONVO cifChannelRegistrationVO)
    {
        this.cifChannelRegistrationVO = cifChannelRegistrationVO;
    }

    public final String getAdditionalReference()
    {
        return additionalReference;
    }

    public final void setAdditionalReference(String additionalReference)
    {
        this.additionalReference = additionalReference;
    }

    public final AMFVOKey getAmfVO()
    {
        return amfVO;
    }

    public final void setAmfVO(AMFVOKey amfVO)
    {
        this.amfVO = amfVO;
    }

    public final List<ChannelSubscriptionCO> getChannelSubscriptionCOList()
    {
        return channelSubscriptionCOList;
    }

    public final void setChannelSubscriptionCOList(List<ChannelSubscriptionCO> channelSubscriptionCOList)
    {
        this.channelSubscriptionCOList = channelSubscriptionCOList;
    }

    public final String getChannelDesc()
    {
        return channelDesc;
    }

    public final void setChannelDesc(String channelDesc)
    {
        this.channelDesc = channelDesc;
    }
    

}
