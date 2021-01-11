package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

 public class FomCifOfficerSC extends  GridParamsSC
 {
	 private BigDecimal cifCode;
	 private BigDecimal lineNo;	
         private BigDecimal relOffId;
        private BigDecimal codeRole;
        private BigDecimal compCodeCif;

	public BigDecimal getLineNo() {
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}

	public BigDecimal getCifCode()
	{
		return cifCode;
	}

	public void setCifCode(BigDecimal cifCode)
	{
		this.cifCode = cifCode;
	}

	public BigDecimal getRelOffId()
	{
	    return relOffId;
	}

	public void setRelOffId(BigDecimal relOffId)
	{
	    this.relOffId = relOffId;
	}

	public BigDecimal getCodeRole()
	{
	    return codeRole;
	}

	public void setCodeRole(BigDecimal codeRole)
	{
	    this.codeRole = codeRole;
	}

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	

	

 }