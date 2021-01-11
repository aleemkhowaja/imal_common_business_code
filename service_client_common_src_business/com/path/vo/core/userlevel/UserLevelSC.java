package com.path.vo.core.userlevel;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class UserLevelSC extends GridParamsSC{

	private BigDecimal code;

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}
}
