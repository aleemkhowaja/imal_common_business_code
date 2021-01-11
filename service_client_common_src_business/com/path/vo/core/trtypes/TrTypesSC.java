package com.path.vo.core.trtypes;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrTypesSC.java used to list methods used in retrieving data from
 *          TR_TYPES table.
 */
public class TrTypesSC extends GridParamsSC
{
    private BigDecimal trCode;

    public BigDecimal getTrCode()
    {
	return trCode;
    }

    public void setTrCode(BigDecimal tRCODE)
    {
	trCode = tRCODE;
    }
}
