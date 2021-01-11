package com.path.dao.core.subecosector.impl;

import java.util.List;

import com.path.dao.core.subecosector.SubEcoSectorDAO;
import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.subecosector.SubEcoSectorSC;

public class SubEcoSectorDAOImpl extends BaseDAO implements SubEcoSectorDAO
{

    @Override
    public List subEcoSectorList(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(subEcoSectorSC.getSidx()).isEmpty())
	{
	    subEcoSectorSC.setSidx("SUB_SECTOR_CODE");
	    subEcoSectorSC.setSord("ASC");
	}

	if(subEcoSectorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subEcoSectorMapper.subEcoSectorList", subEcoSectorSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(subEcoSectorSC, getSqlMap(), "subEcoSectorMapper.subEcoSectorList_ResMap");
	    return getSqlMap().queryForList("subEcoSectorMapper.subEcoSectorList", subEcoSectorSC,
		    subEcoSectorSC.getRecToskip(), subEcoSectorSC.getNbRec());
	}
    }

    @Override
    public int subEcoSectorListCount(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subEcoSectorSC, getSqlMap(), "subEcoSectorMapper.subEcoSectorList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subEcoSectorMapper.subEcoSectorListCount", subEcoSectorSC))
		.intValue();
	return nb;
    }

    @Override
    public RIFSECVO returnDependencyBySubSectorCode(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	return (RIFSECVO) getSqlMap().queryForObject("subEcoSectorMapper.returnDependencyBySubSectorCode",
		subEcoSectorSC);
    }

    public List subEcoSectorParentList(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	if(subEcoSectorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("subEcoSectorMapper.subEcoSectorParentList", subEcoSectorSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(subEcoSectorSC, getSqlMap(), "subEcoSectorMapper.subEcoSectorList_ResMap");
	    return getSqlMap().queryForList("subEcoSectorMapper.subEcoSectorParentList", subEcoSectorSC,
		    subEcoSectorSC.getRecToskip(), subEcoSectorSC.getNbRec());
	}
    }

    public int subEcoSectorParentListCount(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(subEcoSectorSC, getSqlMap(), "subEcoSectorMapper.subEcoSectorList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("subEcoSectorMapper.subEcoSectorParentListCount", subEcoSectorSC))
		.intValue();
	return nb;
    }

    public RIFSECVO returnDependencyBySubSectorCodeforFOM(SubEcoSectorSC subEcoSectorSC) throws DAOException
    {
	return (RIFSECVO) getSqlMap().queryForObject("subEcoSectorMapper.returnDependencyBySubSectorCodeforFOM",
		subEcoSectorSC);
    }

}
