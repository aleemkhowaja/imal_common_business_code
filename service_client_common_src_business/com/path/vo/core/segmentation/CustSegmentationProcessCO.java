package com.path.vo.core.segmentation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTS_SEG_CIF_EXEC_RESULTVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationProcessCO.java used to
 */
public class CustSegmentationProcessCO extends RetailBaseVO
{
    CTS_SEG_CIF_EXEC_RESULTVO ctsSegmentCifExResVO = new CTS_SEG_CIF_EXEC_RESULTVO();
    private BigDecimal recomendedPriority;
    private BigDecimal currentSegment;
    private BigDecimal currentPriority;
    private BigDecimal branchCode;
    private BigDecimal recommendedGroupCode;
    private BigDecimal currentGroupCode;
    private Date recommendedDate;
    
    public CTS_SEG_CIF_EXEC_RESULTVO getCtsSegmentCifExResVO()
    {
        return ctsSegmentCifExResVO;
    }

    public void setCtsSegmentCifExResVO(CTS_SEG_CIF_EXEC_RESULTVO ctsSegmentCifExResVO)
    {
        this.ctsSegmentCifExResVO = ctsSegmentCifExResVO;
    }

    public BigDecimal getRecomendedPriority()
    {
	return recomendedPriority;
    }

    public void setRecomendedPriority(BigDecimal recomendedPriority)
    {
	this.recomendedPriority = recomendedPriority;
    }

    public BigDecimal getCurrentSegment()
    {
	return currentSegment;
    }

    public void setCurrentSegment(BigDecimal currentSegment)
    {
	this.currentSegment = currentSegment;
    }

    public BigDecimal getCurrentPriority()
    {
	return currentPriority;
    }

    public void setCurrentPriority(BigDecimal currentPriority)
    {
	this.currentPriority = currentPriority;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public BigDecimal getRecommendedGroupCode()
    {
        return recommendedGroupCode;
    }

    public void setRecommendedGroupCode(BigDecimal recommendedGroupCode)
    {
        this.recommendedGroupCode = recommendedGroupCode;
    }

    public BigDecimal getCurrentGroupCode()
    {
        return currentGroupCode;
    }

    public void setCurrentGroupCode(BigDecimal currentGroupCode)
    {
        this.currentGroupCode = currentGroupCode;
    }

    public Date getRecommendedDate()
    {
        return recommendedDate;
    }

    public void setRecommendedDate(Date recommendedDate)
    {
        this.recommendedDate = recommendedDate;
    }
}