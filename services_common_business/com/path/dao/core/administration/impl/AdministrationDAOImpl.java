package com.path.dao.core.administration.impl;

import java.util.Collections;
import java.util.List;

import com.path.dao.core.administration.AdministrationDAO;
import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.administration.AdministrationSC;

public final class AdministrationDAOImpl extends BaseDAO implements AdministrationDAO
{
    private final static String ADMINISTRATION_MAPPER = "administrationMapper.administrationColumnMap";
    private final static String ADMINISTRATION_LIST = "administrationMapper.administrationList";
    private final static String ADMINISTRATION_COUNT = "administrationMapper.administrationCount";
    private final static String ADMINISTRATION_BY_CODE = "administrationMapper.administrationByCode";

    @Override
    public int administrationCount(final AdministrationSC administrationSC) throws DAOException
    {
	DAOHelper.fixGridMaps(administrationSC, getSqlMap(), ADMINISTRATION_MAPPER);
	return ((Integer) getSqlMap().queryForObject(ADMINISTRATION_COUNT, administrationSC)).intValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CTSADMINISTRATIONVO> administrationList(final AdministrationSC administrationSC) throws DAOException
    {
	DAOHelper.fixGridMaps(administrationSC, getSqlMap(), ADMINISTRATION_MAPPER);
	if(-1 != administrationSC.getNbRec())
	{
	    return getSqlMap().queryForList(ADMINISTRATION_LIST, administrationSC);
	}
	return Collections.emptyList();
    }

    @Override
    public CTSADMINISTRATIONVO selectAdministrationByCode(final AdministrationSC administrationSC) throws DAOException
    {
	return (CTSADMINISTRATIONVO) getSqlMap().queryForObject(ADMINISTRATION_BY_CODE, administrationSC);
    }
}
