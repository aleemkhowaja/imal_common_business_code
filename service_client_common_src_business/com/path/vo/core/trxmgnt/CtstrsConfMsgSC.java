package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CtstrsConfMsgSC extends GridParamsSC
{
    private String user_id;
    private BigDecimal sessionId;
    private BigDecimal fromAccType;
    private BigDecimal toAccType;
   
    public BigDecimal getSessionId()
    {
        return sessionId;
    }
    public void setSessionId(BigDecimal sessionId)
    {
        this.sessionId = sessionId;
    }
    public String getUser_id()
    {
        return user_id;
    }
    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }
    public BigDecimal getFromAccType()
    {
        return fromAccType;
    }
    public void setFromAccType(BigDecimal fromAccType)
    {
        this.fromAccType = fromAccType;
    }
    public BigDecimal getToAccType()
    {
        return toAccType;
    }
    public void setToAccType(BigDecimal toAccType)
    {
        this.toAccType = toAccType;
    }
}
