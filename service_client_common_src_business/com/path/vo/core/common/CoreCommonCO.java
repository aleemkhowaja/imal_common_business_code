package com.path.vo.core.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;

public class CoreCommonCO  extends RetailBaseVO
{
    private String elementId; 
    private String elementName;
    private String actionType;
    private String value;
    private BigDecimal trxType;
    private BigDecimal cifType;
    private String actionStr;
    private String screenSrc;
    
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private BigDecimal exemptedFromFilerReason; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    private String reasonCodeDesc; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    private Date exemptedFromFilerExpiryDte; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    
    public String getElementId()
    {
        return elementId;
    }
    public void setElementId(String elementId)
    {
        this.elementId = elementId;
    }
    public String getElementName()
    {
        return elementName;
    }
    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    public BigDecimal getTrxType()
    {
        return trxType;
    }
    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }
    public BigDecimal getCifType()
    {
        return cifType;
    }
    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }
    public String getActionStr()
    {
        return actionStr;
    }
    public void setActionStr(String actionStr)
    {
        this.actionStr = actionStr;
    }
    public String getScreenSrc()
    {
        return screenSrc;
    }
    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }
    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }
    public BigDecimal getExemptedFromFilerReason()
    {
        return exemptedFromFilerReason;
    }
    public void setExemptedFromFilerReason(BigDecimal exemptedFromFilerReason)
    {
        this.exemptedFromFilerReason = exemptedFromFilerReason;
    }
    public String getReasonCodeDesc()
    {
        return reasonCodeDesc;
    }
    public void setReasonCodeDesc(String reasonCodeDesc)
    {
        this.reasonCodeDesc = reasonCodeDesc;
    }
    public Date getExemptedFromFilerExpiryDte()
    {
        return exemptedFromFilerExpiryDte;
    }
    public void setExemptedFromFilerExpiryDte(Date exemptedFromFilerExpiryDte)
    {
        this.exemptedFromFilerExpiryDte = exemptedFromFilerExpiryDte;
    }
}
