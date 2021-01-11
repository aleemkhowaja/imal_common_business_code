package com.path.vo.core.integrationcontrol;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class IntegrationControlSC extends GridParamsSC{
	
	private BigDecimal typeCode;

	public BigDecimal getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(BigDecimal typeCode) {
		this.typeCode = typeCode;
	}

}
