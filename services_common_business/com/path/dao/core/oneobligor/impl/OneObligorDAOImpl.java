package com.path.dao.core.oneobligor.impl;

import java.util.List;

import com.path.dao.core.oneobligor.OneObligorDAO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.oneobligor.OneObligorCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public class OneObligorDAOImpl extends BaseDAO implements OneObligorDAO
{

    @Override
    public List oneObligorList(OneObligorSC oneObligorSC) throws DAOException
    {

	if(oneObligorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("oneObligorMapper.oneObligorList", oneObligorSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorList_ResMap");
	    return getSqlMap().queryForList("oneObligorMapper.oneObligorList", oneObligorSC,
		    oneObligorSC.getRecToskip(), oneObligorSC.getNbRec());
	}
    }

    @Override
    public int oneObligorListCount(OneObligorSC oneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("oneObligorMapper.oneObligorListCount", oneObligorSC)).intValue();
	return nb;
    }

    @Override
    public RIFOBTVO returnOneObligorByCode(OneObligorSC oneObligorSC) throws DAOException
    {
	return (RIFOBTVO) getSqlMap().queryForObject("oneObligorMapper.returnOneObligorById", oneObligorSC);
    }

    @Override
    public List oneObligorTrendsList(OneObligorSC oneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorTrendsListMap");
	if(oneObligorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("oneObligorMapper.returnOneObligorTrendsList", oneObligorSC,
		    oneObligorSC.getRecToskip(), oneObligorSC.getNbRec());
	}
	else
	{
	    return getSqlMap().queryForList("oneObligorMapper.returnOneObligorTrendsList", oneObligorSC);
	}

    }

    @Override
    public int oneObligorTrendsListCount(OneObligorSC oneObligorSC) throws DAOException
    {

	DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorTrendsListMap");
	return ((Integer) getSqlMap().queryForObject("oneObligorMapper.returnOneObligorTrendsListCount", oneObligorSC))
		.intValue();
    }

    @Override
    public OneObligorCO fillOneObligorForm(OneObligorSC oneObligorSC) throws DAOException
    {

	return (OneObligorCO) getSqlMap().queryForObject("oneObligorMapper.returnOneObligorDataByCIF", oneObligorSC);
    }

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    @Override
    public Integer oneObligorClassCount(OneObligorSC oneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorClassMap");
	return (Integer) getSqlMap().queryForObject("oneObligorMapper.oneObligorClassCount", oneObligorSC);
    }

    @Override
    public List<TRSCLASSVO> oneObligorClassList(OneObligorSC oneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(oneObligorSC, getSqlMap(), "oneObligorMapper.oneObligorClassMap");
	if(oneObligorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("oneObligorMapper.oneObligorClassList", oneObligorSC);
	}
	else
	{
	    return getSqlMap().queryForList("oneObligorMapper.oneObligorClassList", oneObligorSC,
		    oneObligorSC.getRecToskip(), oneObligorSC.getNbRec());
	}

    }
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
