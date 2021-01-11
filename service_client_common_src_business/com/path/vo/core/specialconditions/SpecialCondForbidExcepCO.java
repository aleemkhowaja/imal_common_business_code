package com.path.vo.core.specialconditions;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSSPCOND_EXCEPTIONSVO;
import com.path.vo.core.common.RetailBaseVO;

@SuppressWarnings("serial")
public final class SpecialCondForbidExcepCO extends RetailBaseVO
{
    private BigDecimal specialConditionLineNo;
    private CTSSPCOND_EXCEPTIONSVO ctsSpCondExceptionsVO;
    private String fromTimeHidden;
    private String toTimeHidden;
    private String exceptionAccList;
    private String forbidExcepAccUpdates;
    private List<SpecialCondForbidExcepAccCO> spCondforbidExcepAccCOs;
    private BigDecimal exceptionLineNo;
    private String forbidExcepAccOpened;

    public BigDecimal getSpecialConditionLineNo()
    {
        return specialConditionLineNo;
    }

    public void setSpecialConditionLineNo(BigDecimal specialConditionLineNo)
    {
        this.specialConditionLineNo = specialConditionLineNo;
    }

    public CTSSPCOND_EXCEPTIONSVO getCtsSpCondExceptionsVO()
    {
        return ctsSpCondExceptionsVO;
    }

    public void setCtsSpCondExceptionsVO(CTSSPCOND_EXCEPTIONSVO ctsSpCondExceptionsVO)
    {
        this.ctsSpCondExceptionsVO = ctsSpCondExceptionsVO;
    }

    public String getFromTimeHidden()
    {
        return fromTimeHidden;
    }

    public void setFromTimeHidden(String fromTimeHidden)
    {
        this.fromTimeHidden = fromTimeHidden;
    }

    public String getToTimeHidden()
    {
        return toTimeHidden;
    }

    public void setToTimeHidden(String toTimeHidden)
    {
        this.toTimeHidden = toTimeHidden;
    }

    public String getExceptionAccList()
    {
        return exceptionAccList;
    }

    public void setExceptionAccList(String exceptionAccList)
    {
        this.exceptionAccList = exceptionAccList;
    }

    public String getForbidExcepAccUpdates()
    {
        return forbidExcepAccUpdates;
    }

    public void setForbidExcepAccUpdates(String forbidExcepAccUpdates)
    {
        this.forbidExcepAccUpdates = forbidExcepAccUpdates;
    }

    public List<SpecialCondForbidExcepAccCO> getSpCondforbidExcepAccCOs()
    {
        return spCondforbidExcepAccCOs;
    }

    public void setSpCondforbidExcepAccCOs(List<SpecialCondForbidExcepAccCO> spCondforbidExcepAccCOs)
    {
        this.spCondforbidExcepAccCOs = spCondforbidExcepAccCOs;
    }

    public BigDecimal getExceptionLineNo()
    {
        return exceptionLineNo;
    }

    public void setExceptionLineNo(BigDecimal exceptionLineNo)
    {
        this.exceptionLineNo = exceptionLineNo;
    }

    public String getForbidExcepAccOpened()
    {
        return forbidExcepAccOpened;
    }

    public void setForbidExcepAccOpened(String forbidExcepAccOpened)
    {
        this.forbidExcepAccOpened = forbidExcepAccOpened;
    }

}