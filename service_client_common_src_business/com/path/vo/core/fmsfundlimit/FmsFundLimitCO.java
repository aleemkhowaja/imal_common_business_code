package com.path.vo.core.fmsfundlimit;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.FMSFUNDLIMITVO;
import com.path.vo.core.common.RetailBaseVO;

public class FmsFundLimitCO extends RetailBaseVO  
{
    
    private FMSFUNDLIMITVO fmsFundLimitVO = new FMSFUNDLIMITVO();
    private CIFVO cifVO = new CIFVO();

    public FMSFUNDLIMITVO getFmsFundLimitVO()
    {
        return fmsFundLimitVO;
    }

    public void setFmsFundLimitVO(FMSFUNDLIMITVO fmsFundLimitVO)
    {
        this.fmsFundLimitVO = fmsFundLimitVO;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

}
