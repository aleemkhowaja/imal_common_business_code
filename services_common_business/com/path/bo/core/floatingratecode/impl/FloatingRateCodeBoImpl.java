package com.path.bo.core.floatingratecode.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.floatingratecode.FloatingRateCodeBO;
import com.path.dao.core.floatingratecode.FloatingRateCodeDAO;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;

public class FloatingRateCodeBoImpl extends BaseBO implements FloatingRateCodeBO
{

    private FloatingRateCodeDAO floatingRateCodeDAO;

    public FloatingRateCodeDAO getFloatingRateCodeDAO()
    {
	return floatingRateCodeDAO;
    }

    public void setFloatingRateCodeDAO(FloatingRateCodeDAO floatingRateCodeDAO)
    {
	this.floatingRateCodeDAO = floatingRateCodeDAO;
    }

    @Override
    public List floatingRateCodeList(FloatingRateCodeSC floatingRateCodeSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return floatingRateCodeDAO.floatingRateCodeList(floatingRateCodeSC);
    }

    @Override
    public int floatingRateCodeListCount(FloatingRateCodeSC floatingRateCodeSC) throws BaseException
    {
	// TODO Auto-generated method stub

	return floatingRateCodeDAO.floatingRateCodeListCount(floatingRateCodeSC);
    }

    @Override
    public IBOR_HDRVO returnFloatingRateCodeById(FloatingRateCodeSC criteria) throws BaseException
    {
	// TODO Auto-generated method stub
	IBOR_HDRVO iborHDRVO = floatingRateCodeDAO.returnFloatingRateCodeById(criteria);
	if(iborHDRVO == null)
	{
	    // throw new BOException(MessageCodes.iis_invalid_code, new String[]
	    // { "Missing/Invalid_code_key" }, false);
	    // TAR#SUPT150098; Saheer.Naduthodi; 17/02/2015
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Invalid_Missing_Key", "Rate_Code_key" }, true);
	}
	return iborHDRVO;
    }
}
