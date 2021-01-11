/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.dbmaps.vo.PMSPACVO;
import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersCO.java used to
 */
public class DashInvestmentsCO extends RetailBaseVO
{
    private PMSPACVO pmspacVO;
    private PMSPORTFOLIO_POSITION_TEMPVO pmsPortfolioTmpVO;
    private BigDecimal decimalPoints;
    
    //added by abbas for Bug#470633
    private BigDecimal consolDecimalPoints;
    
    public PMSPACVO getPmspacVO()
    {
        return pmspacVO;
    }
    public void setPmspacVO(PMSPACVO pmspacVO)
    {
        this.pmspacVO = pmspacVO;
    }
    public PMSPORTFOLIO_POSITION_TEMPVO getPmsPortfolioTmpVO()
    {
        return pmsPortfolioTmpVO;
    }
    public void setPmsPortfolioTmpVO(PMSPORTFOLIO_POSITION_TEMPVO pmsPortfolioTmpVO)
    {
        this.pmsPortfolioTmpVO = pmsPortfolioTmpVO;
    }
    public BigDecimal getDecimalPoints()
    {
        return decimalPoints;
    }
    public void setDecimalPoints(BigDecimal decimalPoints)
    {
        this.decimalPoints = decimalPoints;
    }
    public BigDecimal getConsolDecimalPoints()
    {
        return consolDecimalPoints;
    }
    public void setConsolDecimalPoints(BigDecimal consolDecimalPoints)
    {
        this.consolDecimalPoints = consolDecimalPoints;
    }
}