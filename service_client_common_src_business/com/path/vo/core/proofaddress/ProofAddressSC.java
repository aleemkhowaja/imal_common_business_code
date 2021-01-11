package com.path.vo.core.proofaddress;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author mariachamieh
 * 
 *          ProofAddressSC.java used to
 */
public class ProofAddressSC extends GridParamsSC
{
	private BigDecimal code;

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	} 
	
}
