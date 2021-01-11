/**
 * 
 */
package com.path.vo.core.trxmgnt.overdraftsettlment;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * TrxMgntOverdraftSettlSC.java used to
 */
public class TrxMgntOverdraftSettlSC extends GridParamsSC
{
    private String     langCode;
    private String     appName;
    private String     progRef;
    private BigDecimal trsNo;
    /**
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }
    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }
    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }
    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    /**
     * @return the trsNo
     */
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }
    /**
     * @param trsNo the trsNo to set
     */
    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

}
