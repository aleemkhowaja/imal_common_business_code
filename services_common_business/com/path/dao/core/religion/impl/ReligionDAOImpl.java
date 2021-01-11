package com.path.dao.core.religion.impl;

import java.util.List;

import com.path.dao.core.religion.ReligionDAO;
import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.religion.ReligionSC;

public class ReligionDAOImpl extends BaseDAO implements ReligionDAO
{

	@Override
	public List religionList(ReligionSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("religionMapper.religionList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "religionMapper.religionListMap");
		    return getSqlMap().queryForList("religionMapper.religionList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int religionListCount(ReligionSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "religionMapper.religionListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("religionMapper.religionListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public RELIGIONVO returnReligionById(ReligionSC criteria) throws DAOException
	{
		return (RELIGIONVO) getSqlMap().queryForObject("religionMapper.returnReligionById", criteria);
	}

}
