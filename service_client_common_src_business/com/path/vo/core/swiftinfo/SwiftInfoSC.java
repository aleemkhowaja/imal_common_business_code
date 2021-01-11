package com.path.vo.core.swiftinfo;

import java.math.BigDecimal;

import com.path.bo.common.ConstantsCommon;
import com.path.struts2.lib.common.GridParamsSC;

public class SwiftInfoSC extends GridParamsSC
{
    private String sendToReceiver;

    public static final BigDecimal YES_NO_OPTION_cons = ConstantsCommon.YES_NO_OPTION;

    public String getSendToReceiver()
    {
	return sendToReceiver;
    }

    public void setSendToReceiver(String sendToReceiver)
    {
	this.sendToReceiver = sendToReceiver;
    }

}
