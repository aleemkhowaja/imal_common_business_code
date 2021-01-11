package com.path.bo.core.salutation.impl;

import java.util.List;

import com.path.bo.core.salutation.SalutationBO;
import com.path.dao.core.salutation.SalutationDAO;
import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.dbmaps.vo.RIFCTT_SALUTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.salutation.SalutationSC;

public class SalutationBOImpl extends BaseBO implements SalutationBO
{
	private SalutationDAO salutationDAO;
	@Override
	public List salutationList(SalutationSC criteria) throws BaseException
	{
		return salutationDAO.salutationList(criteria);
	}

	@Override
	public int salutationListCount(SalutationSC criteria) throws BaseException
	{
		return salutationDAO.salutationListCount(criteria);
	}

	public SalutationDAO getSalutationDAO()
	{
		return salutationDAO;
	}

	public void setSalutationDAO(SalutationDAO salutationDAO)
	{
		this.salutationDAO = salutationDAO;
	}

	@Override
    public CIVIL_CODESVO returnSalutationById(SalutationSC criteria) throws BaseException
    {
	CIVIL_CODESVO vo = new CIVIL_CODESVO();
	vo.setCOMP_CODE(criteria.getCompCode());
	vo.setCIVIL_CODE(criteria.getCivilCode());

	CIVIL_CODESVO newVO = (CIVIL_CODESVO) genericDAO.selectByPK(vo);

	if(newVO != null)
	{
	    int nb = salutationDAO.checkSalutExistByCifType(criteria);
	    if(nb != 0)
	    {
		int nb1 = salutationDAO.checkSalutationExistance(criteria);
		if(nb1 == 0)
		{
		    throw new BOException("Saluation defined is not allowed");
		}
		//throw new BOException("Saluation defiend is not allowed");
	    }
	}
	// CIVIL_CODESVO
	return (CIVIL_CODESVO) salutationDAO.returnSalutationById(criteria);
    }

}
