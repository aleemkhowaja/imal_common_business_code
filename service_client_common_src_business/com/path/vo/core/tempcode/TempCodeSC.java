package com.path.vo.core.tempcode;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TempCodeSC extends GridParamsSC{
	private BigDecimal templateCode;
	private String language;
	public BigDecimal getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(BigDecimal templateCode) {
		this.templateCode = templateCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
