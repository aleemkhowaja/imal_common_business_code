package com.path.vo.core.blacklistsource;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class BlackSourceSC extends GridParamsSC {

	private BigDecimal code;
	private String isMainScreen;

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
	}

	public String getIsMainScreen() {
		return isMainScreen;
	}

	public void setIsMainScreen(String isMainScreen) {
		this.isMainScreen = isMainScreen;
	}

	
}
