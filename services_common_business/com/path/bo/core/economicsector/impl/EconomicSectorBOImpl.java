package com.path.bo.core.economicsector.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.economicsector.EconomicSectorBO;
import com.path.dao.core.economicsector.EconomicSectorDAO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.economicsector.EconomicSectorSC;

public class EconomicSectorBOImpl extends BaseBO implements EconomicSectorBO
{
    private EconomicSectorDAO economicSectorDAO;

    public EconomicSectorDAO getEconomicSectorDAO()
    {
	return economicSectorDAO;
    }

    public void setEconomicSectorDAO(EconomicSectorDAO economicSectorDAO)
    {
	this.economicSectorDAO = economicSectorDAO;
    }

    public List economicSectorList(EconomicSectorSC economicSectorSC) throws BaseException
    {
	return economicSectorDAO.economicSectorList(economicSectorSC);
    }

    public int economicSectorListCount(EconomicSectorSC economicSectorSC) throws BaseException
    {
	return economicSectorDAO.economicSectorListCount(economicSectorSC);
    }

    public ECO_SECTORSVO returnDependencyBySectorCode(EconomicSectorSC economicSectorSC) throws BaseException
    {
	// TP#621590 ;13-Feb-2018;d.james
	ECO_SECTORSVO eco_SECTORSVO = null;
	if("true".equals(economicSectorSC.getAllTypesFlag()))
	{
	    if(BigDecimal.ZERO.equals(economicSectorSC.getSectorCode()))
	    {
		eco_SECTORSVO = new ECO_SECTORSVO();
		eco_SECTORSVO.setSECTOR_CODE(economicSectorSC.getSectorCode());
		eco_SECTORSVO.setBRIEF_DESC_ENG(economicSectorSC.getAllTypes());
	    }
	    else
	    {
		eco_SECTORSVO = economicSectorDAO.returnDependencyBySectorCode(economicSectorSC);
		if(eco_SECTORSVO == null || eco_SECTORSVO.getSECTOR_CODE() == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Economic_Sector_key" });//Azhar ; 1057597 ; 17/8/2020
		}
	    }
	}
	else
	{

	    eco_SECTORSVO = economicSectorDAO.returnDependencyBySectorCode(economicSectorSC);
	    if(eco_SECTORSVO == null) // assets team added if condition for tp
				      // bug id
				      // #84763

	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Economic_Sector_key" });
	    }
	}
	return eco_SECTORSVO;
    }

    public int economicSectorAddRefListCount(EconomicSectorSC economicSectorSC) throws BaseException
    {
	return economicSectorDAO.economicSectorAddRefListCount(economicSectorSC);
    }

    public List economicSectorAddRefList(EconomicSectorSC economicSectorSC) throws BaseException
    {
	return economicSectorDAO.economicSectorAddRefList(economicSectorSC);
    }

    public ECO_SECTORSVO returnDependencyBySectorCodeforFOM(EconomicSectorSC economicSectorSC) throws BaseException
    {
	return economicSectorDAO.returnDependencyBySectorCodeforFOM(economicSectorSC);
    }
    
    @Override
    public boolean checkIfSubEcoSectorMandatoryInAdmin(EconomicSectorSC economicSectorSC)throws BaseException
    {
	return economicSectorDAO.checkIfSubEcoSectorMandatoryInAdmin(economicSectorSC);
    }
}
