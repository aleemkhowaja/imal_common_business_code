package com.path.bo.common.fms.limitscommon.impl;

import java.math.BigDecimal;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.fms.limitscommon.FmsLimitsCommonBO;
import com.path.dao.common.fms.limitscommon.FmsLimitsCommonDAO;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.FMSCTRLVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
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
 *          FmsLimitsCommonBOImpl.java used to
 */
public class FmsLimitsCommonBOImpl extends BaseBO implements FmsLimitsCommonBO
{
    private FmsLimitsCommonDAO fmsLimitsCommonDAO;

    public void setFmsLimitsCommonDAO(FmsLimitsCommonDAO fmsLimitsCommonDAO)
    {
	this.fmsLimitsCommonDAO = fmsLimitsCommonDAO;
    }

    public FmsLimitsCommonDAO getFmsLimitsCommonDAO()
    {
	return fmsLimitsCommonDAO;
    }

    @Override
    public BigDecimal getDrawDownAvailableAmount(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {

	return null;
    }

    @Override
    public FmsLimitsCommonCO getDrawDownDetails(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean validateAmount(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean validateMaturityDate(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean validateValueDate(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public FmsLimitsInputCO utilizeFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	FMSCTRLVOKey fmsCtrlVoKey = new FMSCTRLVOKey();

	fmsCtrlVoKey.setCOMP_CODE(fmsLimitsInputCO.getCompanyCode());
	fmsCtrlVoKey.setBRANCH_CODE(fmsLimitsInputCO.getBranchCode());

	FMSCTRLVO fmsCtrlVO = (FMSCTRLVO) genericDAO.selectByPK(fmsCtrlVoKey);
	FmsLimitsInputCO procedureReturnMessage;
	if(fmsCtrlVO != null && fmsCtrlVO.getCIF_GEN_LIMIT() != null && fmsCtrlVO.getCIF_GEN_LIMIT().equals("Y"))
	{
	    if(!StringUtil.isNotEmpty(fmsLimitsInputCO.getSkipValidationYN()))
	    {
		fmsLimitsInputCO.setSkipValidationYN(ConstantsCommon.NO);
	    }

	    procedureReturnMessage = fmsLimitsCommonDAO.utilizeGeneralFMSLimit(fmsLimitsInputCO);

	}
	else
	{
	    procedureReturnMessage = fmsLimitsCommonDAO.utilizeFMSLimit(fmsLimitsInputCO);
	}
	// TP#518547 SBI170029- AIBBI180340; Ajas.Abbas; 19/02/2019
	if(StringUtil.isNotEmpty(procedureReturnMessage.getErrMsg())
		&& NumberUtil.nullToZero(procedureReturnMessage.getErrCode()).compareTo(BigDecimal.valueOf(-2)) != 0)
	{
	    throw new BOException(procedureReturnMessage.getErrMsg(), procedureReturnMessage.getUnutilizedAmount());
	}
	
	return procedureReturnMessage;

    }

    @Override
    public FmsOneObligorDetCO executeProcValidateOneObligor(FmsOneObligorDetCO fmsOneObligorDetCO) throws BaseException
    {
	return fmsLimitsCommonDAO.executeProcValidateOneObligor(fmsOneObligorDetCO);
    }

    /***
     * Method for one obligor procedure call for IIS module
     */
    @Override
    public FmsOneObligorDetCO executeProcValidateOneObligorGlobalLimit(FmsOneObligorDetCO fmsOneObligorDetCO)
	    throws BaseException
    {
	return fmsLimitsCommonDAO.executeProcValidateOneObligorGlobalLimit(fmsOneObligorDetCO);
    }

    /**
     * @author Ajas.Abbas TP#309028 Move TRG Overdraft to API
     */
    @Override
    public FmsLimitsInputCO execProc_P_FMS_AMF_OVERDRAFT(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	return fmsLimitsCommonDAO.execProc_P_FMS_AMF_OVERDRAFT(fmsLimitsInputCO);
    }
    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [Start]
    @Override
    public boolean checkParentCifOrNot(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {

	boolean isParentCif = Boolean.FALSE;
	int countSubcidariesCif = 0;
	if(fmsLimitsInputCO.getCompanyCode() != null && fmsLimitsInputCO.getCifCode() != null)
	{
	    countSubcidariesCif = fmsLimitsCommonDAO.getCountSubcidariesCif(fmsLimitsInputCO);
	    if(countSubcidariesCif > 0)
	    {
		isParentCif = Boolean.TRUE;
	    }
	    else
	    {
		isParentCif = Boolean.FALSE;
	    }
	}
	return isParentCif;
    }

    @Override
    public void execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(FmsLimitsInputCO fmsLimitsInputCO) throws BaseException
    {
	if(fmsLimitsInputCO.getCifCode() != null)
	{
	fmsLimitsCommonDAO.execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(fmsLimitsInputCO);
	}

    }
    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [End]

}
