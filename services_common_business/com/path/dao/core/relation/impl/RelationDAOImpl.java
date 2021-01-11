package com.path.dao.core.relation.impl;

import java.util.List;

import com.path.dao.core.relation.RelationDAO;
import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.relation.RelationSC;

public class RelationDAOImpl extends BaseDAO implements RelationDAO
{

    @Override
    public List relationList(RelationSC relationSC) throws DAOException
    {
	if(relationSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("relationMapper.relationList", relationSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(relationSC, getSqlMap(), "relationMapper.relationList_ResMap");
	    return getSqlMap().queryForList("relationMapper.relationList", relationSC,
		    relationSC.getRecToskip(), relationSC.getNbRec());
	}
    }

    @Override
    public int relationListCount(RelationSC relationSC) throws DAOException
    {
	DAOHelper.fixGridMaps(relationSC, getSqlMap(), "relationMapper.relationList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("relationMapper.relationListCount", relationSC)).intValue();
	return nb;
    }

    @Override
    public RELATIONVO returnRelationByCode(RelationSC relationSC) throws DAOException
    {
	return (RELATIONVO) getSqlMap().queryForObject("relationMapper.returnRelationById", relationSC);
    }

}
