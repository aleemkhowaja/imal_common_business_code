package com.path.vo.core.specialconditions;

import com.path.dbmaps.vo.CTSSPCOND_EXCEPTIONS_ACCVO;
import com.path.vo.core.common.RetailBaseVO;

public final class SpecialCondForbidExcepAccCO extends RetailBaseVO
{
    private CTSSPCOND_EXCEPTIONS_ACCVO ctsSpCondExcepAccVO;
    private String excepAccAddRef;
    private String excepAccBriefDesc;
    private String excepAccLongDesc;
    private String excepAccStatus;
    
    private String excepAccIbanNumber;

    public CTSSPCOND_EXCEPTIONS_ACCVO getCtsSpCondExcepAccVO()
    {
        return ctsSpCondExcepAccVO;
    }

    public void setCtsSpCondExcepAccVO(CTSSPCOND_EXCEPTIONS_ACCVO ctsSpCondExcepAccVO)
    {
        this.ctsSpCondExcepAccVO = ctsSpCondExcepAccVO;
    }

    public String getExcepAccAddRef()
    {
        return excepAccAddRef;
    }

    public void setExcepAccAddRef(String excepAccAddRef)
    {
        this.excepAccAddRef = excepAccAddRef;
    }

    public String getExcepAccBriefDesc()
    {
        return excepAccBriefDesc;
    }

    public void setExcepAccBriefDesc(String excepAccBriefDesc)
    {
        this.excepAccBriefDesc = excepAccBriefDesc;
    }

    public String getExcepAccLongDesc()
    {
        return excepAccLongDesc;
    }

    public void setExcepAccLongDesc(String excepAccLongDesc)
    {
        this.excepAccLongDesc = excepAccLongDesc;
    }

    public String getExcepAccStatus()
    {
        return excepAccStatus;
    }

    public void setExcepAccStatus(String excepAccStatus)
    {
        this.excepAccStatus = excepAccStatus;
    }

    public String getExcepAccIbanNumber()
    {
        return excepAccIbanNumber;
    }

    public void setExcepAccIbanNumber(String excepAccIbanNumber)
    {
        this.excepAccIbanNumber = excepAccIbanNumber;
    }

}