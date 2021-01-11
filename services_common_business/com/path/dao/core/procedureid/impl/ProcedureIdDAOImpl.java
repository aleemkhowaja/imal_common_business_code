package com.path.dao.core.procedureid.impl;

import java.util.List;

import com.path.dao.core.procedureid.ProcedureIdDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public class ProcedureIdDAOImpl extends BaseDAO implements ProcedureIdDAO
{

    public int getprocedureIdCount(ProcedureIdSC procedureIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(procedureIdSC, getSqlMap(), "CTSPROCEDURE_IDMapper.getIdList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("CTSPROCEDURE_IDMapper.getIdCount", procedureIdSC)).intValue();
	return nb;
    }

    public List<ProcedureIdCO> getprocedureIdList(ProcedureIdSC procedureIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(procedureIdSC, getSqlMap(), "CTSPROCEDURE_IDMapper.getIdList_ResMap");
	if(procedureIdSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("CTSPROCEDURE_IDMapper.getIdList", procedureIdSC);
	}
	else
	{
	    return getSqlMap().queryForList("CTSPROCEDURE_IDMapper.getIdList", procedureIdSC,
		    procedureIdSC.getRecToskip(), procedureIdSC.getNbRec());
	}
    }

    public ProcedureIdCO dependencyByProcId(ProcedureIdSC procedureIdSC) throws DAOException
    {
	return (ProcedureIdCO) getSqlMap().queryForObject("CTSPROCEDURE_IDMapper.getProcId", procedureIdSC);
    }

    public int getprocedureCount(ProcedureIdSC procedureIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(procedureIdSC, getSqlMap(), "CTSPROCEDURE_IDMapper.getProceduresList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("CTSPROCEDURE_IDMapper.getProceduresCount", procedureIdSC))
		.intValue();
	return nb;
    }

    public List<ProcedureIdCO> getprocedureList(ProcedureIdSC procedureIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(procedureIdSC, getSqlMap(), "CTSPROCEDURE_IDMapper.getProceduresList_ResMap");
	if(procedureIdSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("CTSPROCEDURE_IDMapper.getProceduresList", procedureIdSC);
	}
	else
	{
	    return getSqlMap().queryForList("CTSPROCEDURE_IDMapper.getProceduresList", procedureIdSC,
		    procedureIdSC.getRecToskip(), procedureIdSC.getNbRec());
	}
    }

    public ProcedureIdCO dependencyByProcedure(ProcedureIdSC procedureIdSC) throws DAOException
    {
	return (ProcedureIdCO) getSqlMap().queryForObject("CTSPROCEDURE_IDMapper.getProcNames", procedureIdSC);
    }

}
