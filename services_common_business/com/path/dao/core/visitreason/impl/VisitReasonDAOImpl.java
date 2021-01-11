package com.path.dao.core.visitreason.impl;

import java.util.List;

import com.path.dao.core.visitreason.VisitReasonDAO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.visitreason.VisitReasonSC;

public class VisitReasonDAOImpl extends BaseDAO implements VisitReasonDAO
{

    public List visitReasonList(VisitReasonSC visitReasonSC) throws DAOException
    {
	if(visitReasonSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("visitReasonMapper.visitReasonList", visitReasonSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(visitReasonSC, getSqlMap(), "visitReasonMapper.visitReasonList_ResMap");
	    return getSqlMap().queryForList("visitReasonMapper.visitReasonList", visitReasonSC,
		    visitReasonSC.getRecToskip(), visitReasonSC.getNbRec());
	}
    }

    public int visitReasonListCount(VisitReasonSC visitReasonSC) throws DAOException
    {

	DAOHelper.fixGridMaps(visitReasonSC, getSqlMap(), "visitReasonMapper.visitReasonList_ResMap");
	return ((Integer) getSqlMap().queryForObject("visitReasonMapper.visitReasonListCount", visitReasonSC))
		.intValue();
    }

    public CRM_PARAMVO returnVisitReasonById(VisitReasonSC visitReasonSC) throws DAOException
    {
	return (CRM_PARAMVO) getSqlMap().queryForObject("visitReasonMapper.returnVisitReasonById", visitReasonSC);
    }

    @Override
    public CRM_PARAMVO returnVisitReasonDesc(VisitReasonSC criteria) throws DAOException
    {
	return (CRM_PARAMVO) getSqlMap().queryForObject("visitReasonMapper.returnVisitReasonDesc", criteria);
    }

}
