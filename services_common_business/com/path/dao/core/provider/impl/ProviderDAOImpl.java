package com.path.dao.core.provider.impl;

import java.util.List;

import com.path.dao.core.provider.ProviderDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.struts2.lib.common.GridParamsSC;

public class ProviderDAOImpl extends BaseDAO implements ProviderDAO
{
    @Override
    public int returnProviderLookupCount(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "providerLookupMapper.providerLookupMap");
	return ((Integer) getSqlMap().queryForObject("providerLookupMapper.returnProviderLookupCount", criteria))
		.intValue();
    }

    @Override
    public List returnProviderLookup(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "providerLookupMapper.providerLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("providerLookupMapper.returnProviderLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("providerLookupMapper.returnProviderLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
}
