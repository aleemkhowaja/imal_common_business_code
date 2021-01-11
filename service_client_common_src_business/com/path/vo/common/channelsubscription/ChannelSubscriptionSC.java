package com.path.vo.common.channelsubscription;

import com.path.struts2.lib.common.GridParamsSC;
import java.math.BigDecimal;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ChannelSubscriptionSC.java used to
 */
public class ChannelSubscriptionSC extends GridParamsSC
{
   private BigDecimal cifNo ;
   private String langCode;
   private BigDecimal lovType;
   private String cifStatus;

public final BigDecimal getCifNo()
{
    return cifNo;
}

public final void setCifNo(BigDecimal cifNo)
{
    this.cifNo = cifNo;
}

public final String getLangCode()
{
    return langCode;
}

public final void setLangCode(String langCode)
{
    this.langCode = langCode;
}

public final BigDecimal getLovType()
{
    return lovType;
}

public final void setLovType(BigDecimal lovType)
{
    this.lovType = lovType;
}

public final String getCifStatus()
{
    return cifStatus;
}

public final void setCifStatus(String cifStatus)
{
    this.cifStatus = cifStatus;
}

}
