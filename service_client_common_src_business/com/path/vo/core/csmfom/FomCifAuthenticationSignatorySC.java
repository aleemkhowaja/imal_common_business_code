/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * FomCifAuthenticationSignatorySC.java can be used for ownership details and more signatory fetching
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomCifAuthenticationSignatorySC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private BigDecimal authCifNo ;
    private BigDecimal capitalPercentage;
    private BigDecimal percentageOfVotingRight;//Ali Ammar Dynamic Screen
    
    private BigDecimal cifType;//Majd Haidar DB170142 - Capital Percentage 21/11/2018
    private BigDecimal compCodeCif;
  
    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    private String parentChildInd;
    //
    
    /**
     * @return the capitalPercentage
     */
    public BigDecimal getCapitalPercentage()
    {
        return capitalPercentage;
    }

    /**
     * @param capitalPercentage the capitalPercentage to set
     */
    public void setCapitalPercentage(BigDecimal capitalPercentage)
    {
        this.capitalPercentage = capitalPercentage;
    }

    public BigDecimal getAuthCifNo()
    {
	return authCifNo;
    }

    public void setAuthCifNo(BigDecimal authCifNo)
    {
	this.authCifNo = authCifNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    /**
     * @return the lineNo
     */
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    /**
     * @param lineNo the lineNo to set
     */
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getPercentageOfVotingRight()
    {
	return percentageOfVotingRight;
    }

    public void setPercentageOfVotingRight(BigDecimal percentageOfVotingRight)
    {
	this.percentageOfVotingRight = percentageOfVotingRight;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

    public String getParentChildInd()
    {
        return parentChildInd;
    }

    public void setParentChildInd(String parentChildInd)
    {
        this.parentChildInd = parentChildInd;
    }
}
