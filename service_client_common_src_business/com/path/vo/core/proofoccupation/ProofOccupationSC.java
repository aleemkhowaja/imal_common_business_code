package com.path.vo.core.proofoccupation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author mariachamieh
 * 
 *          ProofOccupationSC.java used to
 */
public class ProofOccupationSC extends GridParamsSC
{
	private BigDecimal code;
	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}
	
}
