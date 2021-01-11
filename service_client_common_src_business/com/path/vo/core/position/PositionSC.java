package com.path.vo.core.position;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class PositionSC extends GridParamsSC
{
    private BigDecimal position_code;
    
    public BigDecimal getPosition_code()
    {
        return position_code;
    }
    public void setPosition_code(BigDecimal positionCode)
    {
        position_code = positionCode;
    }

}
