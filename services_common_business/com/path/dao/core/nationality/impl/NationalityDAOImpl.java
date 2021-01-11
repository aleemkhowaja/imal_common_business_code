package com.path.dao.core.nationality.impl;

import java.util.List;

import com.path.dao.core.nationality.NationalityDAO;
import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.nationality.NationalitySC;
import com.path.vo.core.nationalityvalid.NationalityValidSC;

public class NationalityDAOImpl extends BaseDAO implements NationalityDAO
{

	@Override
	public List nationalityList(NationalitySC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("nationalityMapper.nationalityList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "nationalityMapper.nationalityListMap");
		    return getSqlMap().queryForList("nationalityMapper.nationalityList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int nationalityListCount(NationalitySC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "nationalityMapper.nationalityListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("nationalityMapper.nationalityListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public NATIONALITYVO returnNationalityById(NationalitySC criteria) throws DAOException
	{
		return (NATIONALITYVO) getSqlMap().queryForObject("nationalityMapper.returnNationalityById", criteria);
	}
	
	public int nationalityValidListCount(NationalityValidSC criteria) throws DAOException
	{
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("nationalityMapper.nationalityValidCnt", criteria)).intValue();
		return nb;
	}

}
