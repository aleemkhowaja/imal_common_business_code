package com.path.vo.core.ranking;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class RankingSC extends GridParamsSC
{
    private BigDecimal priorityCode;
    private BigDecimal cifType;

	public BigDecimal getPriorityCode()
	{
		return priorityCode;
	}

	public void setPriorityCode(BigDecimal priorityCode)
	{
		this.priorityCode = priorityCode;
	}

	public BigDecimal getCifType() {
		return cifType;
	}

	public void setCifType(BigDecimal cifType) {
		this.cifType = cifType;
	}

    
}
