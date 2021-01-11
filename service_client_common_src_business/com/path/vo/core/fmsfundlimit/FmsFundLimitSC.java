package com.path.vo.core.fmsfundlimit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FmsFundLimitSC extends GridParamsSC 
{
    private BigDecimal cifNo;

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
}
