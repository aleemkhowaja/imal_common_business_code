package com.path.bo.common.fms.limitscommon;

import java.math.BigDecimal;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.fms.limitscommon.FmsLimitsCommonCO;
import com.path.vo.common.fms.limitscommon.FmsLimitsInputCO;
import com.path.vo.common.fms.limitscommon.FmsOneObligorDetCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Vysakh.das
 * 
 *          FmsLimitsCommonBO.java used to
 */
public interface FmsLimitsCommonBO
{

    public BigDecimal getDrawDownAvailableAmount(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    public FmsLimitsCommonCO getDrawDownDetails(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    public boolean validateAmount(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    public boolean validateValueDate(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    public boolean validateMaturityDate(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    public FmsLimitsInputCO utilizeFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    FmsOneObligorDetCO executeProcValidateOneObligor(FmsOneObligorDetCO fmsOneObligorDetCO) throws BaseException;

    FmsOneObligorDetCO executeProcValidateOneObligorGlobalLimit(FmsOneObligorDetCO fmsOneObligorDetCO)
	    throws BaseException;

    public FmsLimitsInputCO execProc_P_FMS_AMF_OVERDRAFT(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;

    //TP#1002268 - DBU191081;Azhar; 15/06/2020 [Start]
    public boolean checkParentCifOrNot(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;
    public void execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException;
  //TP#1002268 - DBU191081;Azhar; 15/06/2020 [End]
}
