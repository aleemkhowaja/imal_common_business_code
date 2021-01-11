/**
 * 
 */
package com.path.vo.common.limitschema;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * LimitSchemaSC.java used to
 */
public class LimitSchemaSC extends GridParamsSC
{
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifSubNo;
    private BigDecimal slNo;
    private String screen;
    private String enforceSignLimit;
    private String parentPage;
    private BigDecimal compCodeCif;
    
    private boolean openedFromSign;
    private boolean multiSelection;
    
	public boolean isOpenedFromSign() {
		return openedFromSign;
	}
	public void setOpenedFromSign(boolean openedFromSign) {
		this.openedFromSign = openedFromSign;
	}
	/**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }
    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    /**
     * @return the glCode
     */
    public BigDecimal getGlCode()
    {
        return glCode;
    }
    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }
    /**
     * @return the cifSubNo
     */
    public BigDecimal getCifSubNo()
    {
        return cifSubNo;
    }
    /**
     * @param cifSubNo the cifSubNo to set
     */
    public void setCifSubNo(BigDecimal cifSubNo)
    {
        this.cifSubNo = cifSubNo;
    }
    /**
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
        return slNo;
    }
    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
        this.slNo = slNo;
    }
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getEnforceSignLimit() {
		return enforceSignLimit;
	}
	public void setEnforceSignLimit(String enforceSignLimit) {
		this.enforceSignLimit = enforceSignLimit;
	}
	public String getParentPage()
	{
	    return parentPage;
	}
	public void setParentPage(String parentPage)
	{
	    this.parentPage = parentPage;
	}
	public boolean isMultiSelection()
	{
	    return multiSelection;
	}
	public void setMultiSelection(boolean multiSelection)
	{
	    this.multiSelection = multiSelection;
	}
	public void setCompCodeCif(BigDecimal compCodeCif) {
		this.compCodeCif = compCodeCif;
	}
	public BigDecimal getCompCodeCif() {
		return compCodeCif;
	}
 
}
