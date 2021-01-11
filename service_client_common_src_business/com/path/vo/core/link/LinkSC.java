/**
 * 
 */
package com.path.vo.core.link;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkSC.java used to
 */
public class LinkSC extends GridParamsSC
{
    private BigDecimal linkCode;
    private BigDecimal linkSerial;
    private String     langCode;
    private BigDecimal lovType;
    private String     appName;
    private String     progRef;
    
    public BigDecimal getLinkCode()
    {
        return linkCode;
    }
    public void setLinkCode(BigDecimal linkCode)
    {
        this.linkCode = linkCode;
    }
    public BigDecimal getLinkSerial()
    {
        return linkSerial;
    }
    public void setLinkSerial(BigDecimal linkSerial)
    {
        this.linkSerial = linkSerial;
    }
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public BigDecimal getLovType()
    {
        return lovType;
    }
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

}
