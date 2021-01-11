package com.path.dao.core.rifcttgl.impl;

import java.util.List;

import com.path.dao.core.rifcttgl.RifcttGlDAO;
import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.rifcttgl.RifcttGlSC;

public class RifcttGlDAOImpl extends BaseDAO implements RifcttGlDAO
{
    @Override
    public List accountList(RifcttGlSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("rifcttGlMapper.rifcttGlList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "RIFCTT_GL.BaseResultMap");
	    return getSqlMap().queryForList("rifcttGlMapper.rifcttGlList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int accountListCount(RifcttGlSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "RIFCTT_GL.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("rifcttGlMapper.rifcttGlListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public RIFCTT_GLVO returnRifcttGlById(RifcttGlSC criteria) throws DAOException
    {
	return (RIFCTT_GLVO) getSqlMap().queryForObject("rifcttGlMapper.returnRifcttGlById", criteria);
    }

    @Override
    public int getRifMessageByCompLkpCount(RifcttGlSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "RIFMESSAGE.BaseResultMap");
	return (Integer) getSqlMap().queryForObject("rifcttGlMapper.getRifMessageByCompLkpCount", criteria);
    }

    @Override
    public List getRifMessageByCompLkpList(RifcttGlSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("rifcttGlMapper.getRifMessageByCompLkpList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "RIFMESSAGE.BaseResultMap");
	    return getSqlMap().queryForList("rifcttGlMapper.getRifMessageByCompLkpList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}