package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVO;
import com.path.vo.core.common.RetailBaseVO;

public class ProductClassCO extends RetailBaseVO
{

    private TRSCLASSVO trsClassVO;
    private TRSCLASS_EXTENDEDVO trsclassEXTENDEDVO;
    private BigDecimal amount;
    private BigDecimal decimalPoints;

    public void setTrsClassVO(TRSCLASSVO trsClassVO)
    {
	this.trsClassVO = trsClassVO;
    }

    public TRSCLASSVO getTrsClassVO()
    {
	return trsClassVO;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setDecimalPoints(BigDecimal decimalPoints)
    {
	this.decimalPoints = decimalPoints;
    }

    public BigDecimal getDecimalPoints()
    {
	return decimalPoints;
    }

    public TRSCLASS_EXTENDEDVO getTrsclassEXTENDEDVO()
    {
	return trsclassEXTENDEDVO;
    }

    public void setTrsclassEXTENDEDVO(TRSCLASS_EXTENDEDVO trsclassEXTENDEDVO)
    {
	this.trsclassEXTENDEDVO = trsclassEXTENDEDVO;
    }

}
