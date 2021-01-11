package com.path.vo.core.ctsbatch;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          CtsBatchSC.java used to fill criterias related to batch
 */
public class CtsBatchSC extends GridParamsSC
{
    private BigDecimal batchNo;

    public BigDecimal getBatchNo()
    {
	return batchNo;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
	this.batchNo = batchNo;
    }

}
