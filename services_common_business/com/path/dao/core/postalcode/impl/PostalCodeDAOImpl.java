package com.path.dao.core.postalcode.impl;

import java.util.List;

import com.path.dao.core.postalcode.PostalCodeDAO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.postalcode.PostalCodeSC;

public class PostalCodeDAOImpl extends BaseDAO implements PostalCodeDAO
{

	@Override
	public List postalCodeList(PostalCodeSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("postalCodeMapper.postalCodeList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "postalCodeMapper.postalCodeListMap");
		    return getSqlMap().queryForList("postalCodeMapper.postalCodeList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int postalCodeListCount(PostalCodeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "postalCodeMapper.postalCodeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("postalCodeMapper.postalCodeListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public POSTAL_CODEVO returnPostalCodeById(PostalCodeSC criteria) throws DAOException
	{
		return (POSTAL_CODEVO) getSqlMap().queryForObject("postalCodeMapper.returnPostalCodeById", criteria);
	}

}
