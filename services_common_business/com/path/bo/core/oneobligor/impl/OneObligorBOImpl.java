package com.path.bo.core.oneobligor.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.oneobligor.OneObligorBO;
import com.path.dao.core.oneobligor.OneObligorDAO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.oneobligor.OneObligorCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public class OneObligorBOImpl extends BaseBO implements OneObligorBO
{

    private OneObligorDAO oneObligorDAO;

    public OneObligorDAO getOneObligorDAO()
    {
	return oneObligorDAO;
    }

    public void setOneObligorDAO(OneObligorDAO oneObligorDAO)
    {
	this.oneObligorDAO = oneObligorDAO;
    }

    @Override
    public List oneObligorList(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.oneObligorList(oneObligorSC);
    }

    @Override
    public int oneObligorListCount(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.oneObligorListCount(oneObligorSC);

    }

    @Override
    public RIFOBTVO returnOneObligorByCode(OneObligorSC oneObligorSC) throws BaseException
    {
	RIFOBTVO oneObligorVO = oneObligorDAO.returnOneObligorByCode(oneObligorSC);
	if(oneObligorVO == null)
	{
	    //throw new BOException(MessageCodes.INVALID_CODE);
	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "One_Obligor_key" });
	}
	return oneObligorVO;
    }

    @Override
    public List oneObligorTrendsList(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.oneObligorTrendsList(oneObligorSC);
    }

    @Override
    public int oneObligorTrendsListCount(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.oneObligorTrendsListCount(oneObligorSC);
    }

    @Override
    public OneObligorCO fillOneObligorForm(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.fillOneObligorForm(oneObligorSC);
    }

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    @Override
    public Integer oneObligorClassCount(OneObligorSC oneObligorSC) throws BaseException
    {

	return oneObligorDAO.oneObligorClassCount(oneObligorSC);
    }

    @Override
    public List<TRSCLASSVO> oneObligorClassList(OneObligorSC oneObligorSC) throws BaseException
    {
	return oneObligorDAO.oneObligorClassList(oneObligorSC);
    }
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
