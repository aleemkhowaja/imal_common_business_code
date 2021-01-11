/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TFSBILLVO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.dbmaps.vo.TFSTRXVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersCO.java used to
 */
public class DashTradeFinanceCO extends RetailBaseVO
{
    private TFSTRXVO tfstrxVO;
    private TFSLC1VO tfslc1VO;
    private TFSLGVO tfslgVO;
    private TFSBILLVO tfsbillVO;
    private BigDecimal decimalPoints;
    private String currencyDesc;
    private String statusDesc;
    
    public TFSTRXVO getTfstrxVO()
    {
        return tfstrxVO;
    }
    public void setTfstrxVO(TFSTRXVO tfstrxVO)
    {
        this.tfstrxVO = tfstrxVO;
    }
    public TFSLC1VO getTfslc1VO()
    {
        return tfslc1VO;
    }
    public void setTfslc1VO(TFSLC1VO tfslc1vo)
    {
        tfslc1VO = tfslc1vo;
    }
    public TFSLGVO getTfslgVO()
    {
        return tfslgVO;
    }
    public void setTfslgVO(TFSLGVO tfslgVO)
    {
        this.tfslgVO = tfslgVO;
    }
    public TFSBILLVO getTfsbillVO()
    {
        return tfsbillVO;
    }
    public void setTfsbillVO(TFSBILLVO tfsbillVO)
    {
        this.tfsbillVO = tfsbillVO;
    }
    public BigDecimal getDecimalPoints()
    {
        return decimalPoints;
    }
    public void setDecimalPoints(BigDecimal decimalPoints)
    {
        this.decimalPoints = decimalPoints;
    }
    public String getCurrencyDesc()
    {
        return currencyDesc;
    }
    public void setCurrencyDesc(String currencyDesc)
    {
        this.currencyDesc = currencyDesc;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
}