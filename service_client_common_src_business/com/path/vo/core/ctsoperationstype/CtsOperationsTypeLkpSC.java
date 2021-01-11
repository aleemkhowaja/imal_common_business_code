package com.path.vo.core.ctsoperationstype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CtsOperationsTypeLkpSC extends GridParamsSC
{
    private BigDecimal operationTypeCode;

    public BigDecimal getOperationTypeCode()
    {
        return operationTypeCode;
    }

    public void setOperationTypeCode(BigDecimal operationTypeCode)
    {
        this.operationTypeCode = operationTypeCode;
    }
}
