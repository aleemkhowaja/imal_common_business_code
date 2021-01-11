/**
 * 
 */
package com.path.vo.core.amfstatus;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfStatusSC.java used to
 */
public class AmfStatusSC extends GridParamsSC
{
    private String statusType;
    private BigDecimal code;
    private Boolean cannotReopen;

    /**
     * @return the statusType
     */
    public String getStatusType()
    {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(String statusType)
    {
        this.statusType = statusType;
    }

    /**
     * @return the code
     */
    public BigDecimal getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public Boolean getCannotReopen()
    {
        return cannotReopen;
    }

    public void setCannotReopen(Boolean cannotReopen)
    {
        this.cannotReopen = cannotReopen;
    }
}
