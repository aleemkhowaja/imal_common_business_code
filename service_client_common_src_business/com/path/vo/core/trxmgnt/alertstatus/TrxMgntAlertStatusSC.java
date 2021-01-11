/**
 * 
 */
package com.path.vo.core.trxmgnt.alertstatus;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * TrxMgntAlertStatusSC.java used to
 */
public class TrxMgntAlertStatusSC extends GridParamsSC
{
    private BigDecimal trsNo;
    private String language;
    
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
    
}
