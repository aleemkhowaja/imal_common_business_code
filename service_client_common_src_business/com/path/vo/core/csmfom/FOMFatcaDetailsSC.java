package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FOMFatcaDetailsSC extends GridParamsSC
{
    public BigDecimal cifNo;
    public String tin;
    public String deactivatedStatus;
    
    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getTin()
    {
        return tin;
    }

    public void setTin(String tin)
    {
        this.tin = tin;
    }

    public String getDeactivatedStatus()
    {
        return deactivatedStatus;
    }

    public void setDeactivatedStatus(String deactivatedStatus)
    {
        this.deactivatedStatus = deactivatedStatus;
    }
    
}
