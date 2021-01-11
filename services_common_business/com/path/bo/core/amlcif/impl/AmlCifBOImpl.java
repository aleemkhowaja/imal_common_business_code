package com.path.bo.core.amlcif.impl;

import java.util.List;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.amlcif.AmlCifBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.dao.core.amlcif.AmlCifDAO;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cif.CifSC;

/**
 * @author Nour Choueikani
 * 
 */
public class AmlCifBOImpl extends BaseBO implements AmlCifBO
{

	private AmlCifDAO amlCifDAO;

	/***
	 * added by nour for 777000
	 */
	/**
	 * return the cif,rifctt list count...
	 * 
	 * @param criteria
	 * @return int
	 * @throws BaseException
	 */
	public int returnBankCifListCount(CifSC criteria) throws BaseException
	{
		return amlCifDAO.returnBankCifListCount(criteria);
	}

	/**
	 * 
	 */
	public List returnBankCIF(CifSC criteria) throws BaseException
	{
		return amlCifDAO.returnBankCIF(criteria);
	}
	
	@Override
	public int cifListCount(CifSC criteria) throws BaseException
	{
		return amlCifDAO.returnCifListCount(criteria);

	}

	@Override
	public List cifList(CifSC criteria) throws BaseException
	{
		return amlCifDAO.returnCIF(criteria);

	}
	
	public AML_CUSTOMERVO returnCifByNo(CifSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	AML_CUSTOMERVO cifVO = amlCifDAO.returnCifByNo(criteria);

	if("1".equals(criteria.getRetExpIfExsits()))
	{
	    if(cifVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	    }
	    else if(ConstantsCommon.CIF_SUSPENDED.equals(cifVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.CLIENT_CIF_IS_SUSPENDED);
	    }
	    else if(ConstantsCommon.CIF_DELETED.equals(cifVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.CLIENT_CIF_IS_DELETED);
	    }
	    else if(ConstantsCommon.CIF_INACTIVE.equals(cifVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.CLIENT_CIF_IS_INACTIVE);
	    }
	}
	return cifVO;
    }

	public void setAmlCifDAO(AmlCifDAO amlCifDAO)
	{
		this.amlCifDAO = amlCifDAO;
	}
	
	

	

}
