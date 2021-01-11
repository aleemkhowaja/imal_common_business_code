package com.path.dao.core.residencetypes.impl;

import java.util.List;

import com.path.dao.core.residencetypes.ResidenceTypesDAO;
import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

public class ResidenceTypesDAOImpl extends BaseDAO implements ResidenceTypesDAO
{

	@Override
	public List residenceTypesList(ResidenceTypesSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("residenceTypesMapper.residenceTypesList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "residenceTypesMapper.residenceTypesListMap");
		    return getSqlMap().queryForList("residenceTypesMapper.residenceTypesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int residenceTypesListCount(ResidenceTypesSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "residenceTypesMapper.residenceTypesListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("residenceTypesMapper.residenceTypesListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public RESIDENCE_TYPESVO returnDependencyByCode(ResidenceTypesSC criteria) throws DAOException
	{
	    return (RESIDENCE_TYPESVO)getSqlMap().queryForObject("residenceTypesMapper.returnDependencyByCode", criteria);
	}

}
