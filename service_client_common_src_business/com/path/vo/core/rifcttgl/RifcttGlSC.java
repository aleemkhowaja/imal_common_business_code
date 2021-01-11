package com.path.vo.core.rifcttgl;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class RifcttGlSC extends GridParamsSC {

	private BigDecimal cifTypeCode;
	private BigDecimal glCode;
	private BigDecimal slNbr;
	private BigDecimal cyCode;
	private int lineNbr;
	private BigDecimal typeCode;
	private BigDecimal baseCurrency;
	private String checkExistGl;		
	

	public BigDecimal getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(BigDecimal typeCode) {
		this.typeCode = typeCode;
	}

	public int getLineNbr() {
		return lineNbr;
	}

	public void setLineNbr(int lineNbr) {
		this.lineNbr = lineNbr;
	}

	public BigDecimal getCifTypeCode()
	{
		return cifTypeCode;
	}

	public void setCifTypeCode(BigDecimal cifTypeCode)
	{
		this.cifTypeCode = cifTypeCode;
	}

	public BigDecimal getGlCode()
	{
		return glCode;
	}

	public void setGlCode(BigDecimal glCode)
	{
		this.glCode = glCode;
	}

	public BigDecimal getSlNbr()
	{
		return slNbr;
	}

	public void setSlNbr(BigDecimal slNbr)
	{
		this.slNbr = slNbr;
	}

	public BigDecimal getCyCode()
	{
		return cyCode;
	}

	public void setCyCode(BigDecimal cyCode)
	{
		this.cyCode = cyCode;
	}

	public BigDecimal getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(BigDecimal baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getCheckExistGl() {
		return checkExistGl;
	}

	public void setCheckExistGl(String checkExistGl) {
		this.checkExistGl = checkExistGl;
	}
	


}
