package com.path.dao.common.fms.limitscommon.impl;

import java.math.BigDecimal;

import com.path.dao.common.fms.limitscommon.FmsLimitsCommonDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.fms.limitscommon.FmsLimitsInputCO;
import com.path.vo.common.fms.limitscommon.FmsOneObligorDetCO;
import com.path.lib.common.util.NumberUtil; 
/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Vysakh.das
 * 
 *          FmsLimitsCommonDAOImpl.java used to
 */

public class FmsLimitsCommonDAOImpl extends BaseDAO implements FmsLimitsCommonDAO
{

    public FmsLimitsInputCO utilizeFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException
    {
	try
	{
	    getSqlMap().update("fmsLimitsCommonMapper.utilizeFMSLimit", fmsLimitsInputCO);

	    String errMessage = StringUtil.replaceProcedureMessage(fmsLimitsInputCO.getErrMsg());
	    fmsLimitsInputCO.setErrMsg(StringUtil.replaceEmptyLinesAndTrimLines(errMessage));

	    return fmsLimitsInputCO;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_FMS_NON_GEN_LMT_UTILIZATION " + e.getMessage(), e);
	}

    }

    public FmsLimitsInputCO utilizeGeneralFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException
    {
	try
	{
	    getSqlMap().update("fmsLimitsCommonMapper.utilizeGeneralFMSLimit", fmsLimitsInputCO);
	    String errMessage = StringUtil.replaceProcedureMessage(fmsLimitsInputCO.getErrMsg());

	    fmsLimitsInputCO.setErrMsg(StringUtil.replaceEmptyLinesAndTrimLines(errMessage));

	    return fmsLimitsInputCO;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_FMS_LIMIT_UTILIZATION " + e.getMessage(), e);
	}

    }

    @Override
    public FmsOneObligorDetCO executeProcValidateOneObligor(FmsOneObligorDetCO fmsOneObligorDetCO) throws DAOException
    {
	getSqlMap().update("fmsLimitsCommonMapper.executeProcValidateOneObligor", fmsOneObligorDetCO);
	fmsOneObligorDetCO.setErrorDesc(StringUtil.replaceProcedureMessage(fmsOneObligorDetCO.getErrorDesc()));
	if(StringUtil.isNotEmpty(StringUtil.replaceEmptyLinesAndTrimLines(fmsOneObligorDetCO.getErrorDesc())))
	{
	    throw new DAOException(fmsOneObligorDetCO.getErrorDesc());
	}
	return fmsOneObligorDetCO;
    }

    @Override
    public FmsOneObligorDetCO executeProcValidateOneObligorGlobalLimit(FmsOneObligorDetCO fmsOneObligorDetCO)
	    throws DAOException
    {
	getSqlMap().update("fmsLimitsCommonMapper.executeProcValidateOneObligorGlobalLimit", fmsOneObligorDetCO);
	fmsOneObligorDetCO.setErrorDesc(StringUtil.replaceProcedureMessage(fmsOneObligorDetCO.getErrorDesc()));
	if(NumberUtil.nullToZero(fmsOneObligorDetCO.getErrorNo()).compareTo(new BigDecimal(-2)) != 0)
	{

	    if(StringUtil.isNotEmpty(StringUtil.replaceEmptyLinesAndTrimLines(fmsOneObligorDetCO.getErrorDesc())))
	    {
		throw new DAOException(fmsOneObligorDetCO.getErrorDesc());
	    }
	}
	return fmsOneObligorDetCO;
    }

    @Override
    public FmsLimitsInputCO execProc_P_FMS_AMF_OVERDRAFT(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException
    {
	getSqlMap().update("fmsLimitsCommonMapper.execProc_P_FMS_AMF_OVERDRAFT", fmsLimitsInputCO);
	fmsLimitsInputCO.setErrMsg(StringUtil.replaceProcedureMessage(fmsLimitsInputCO.getErrMsg()));
	return fmsLimitsInputCO;
    }

    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [Start]
    @Override
    public int getCountSubcidariesCif(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("fmsLimitsCommonMapper.getCountSubcidariesCif", fmsLimitsInputCO)).intValue();
    }
    @Override
    public void execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException
    {
	getSqlMap().update("fmsLimitsCommonMapper.execProc_P_FMS_INSERT_SUBSIDIARY_CIFS", fmsLimitsInputCO);
    }
    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [End]

}