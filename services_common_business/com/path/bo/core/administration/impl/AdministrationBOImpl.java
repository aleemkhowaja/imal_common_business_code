package com.path.bo.core.administration.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.administration.AdministrationBO;
import com.path.dao.core.administration.AdministrationDAO;
import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.administration.AdministrationSC;

public final class AdministrationBOImpl extends BaseBO implements AdministrationBO
{
    private AdministrationDAO administrationDAO;

    @Override
    public int administrationLookupCount(final AdministrationSC criteria) throws BaseException
    {
	return administrationDAO.administrationCount(criteria);
    }

    @Override
    public List<CTSADMINISTRATIONVO> administrationLookupList(final AdministrationSC criteria) throws BaseException
    {
	return administrationDAO.administrationList(criteria);
    }

    public AdministrationDAO getAdministrationDAO()
    {
	return administrationDAO;
    }

    public void setAdministrationDAO(AdministrationDAO obj)
    {
	administrationDAO = obj;
    }

    @Override
    public CTSADMINISTRATIONVO returnAdministrationByCode(final AdministrationSC criteria) throws BaseException
    {
	final CTSADMINISTRATIONVO result = administrationDAO.selectAdministrationByCode(criteria);
	if(null == result)
	{
	    throw new BOException(MessageCodes.INVALID_ADMINISTRATION_CODE);
	}
	return result;
    }
}
