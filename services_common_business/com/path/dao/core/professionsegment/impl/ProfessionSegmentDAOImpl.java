package com.path.dao.core.professionsegment.impl;

import java.util.List;

import com.path.dao.core.professionsegment.ProfessionSegmentDAO;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;

public class ProfessionSegmentDAOImpl extends BaseDAO implements ProfessionSegmentDAO
{

    @Override
    public List professionSegmentList(ProfessionSegmentSC professionSegmentSC) throws DAOException
    {
	if(professionSegmentSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("professionSegmentListMapper.professionSegmentList", professionSegmentSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(professionSegmentSC, getSqlMap(), "professionSegmentListMapper.professionSegmentList_ResMap");
	    return getSqlMap().queryForList("professionSegmentListMapper.professionSegmentList", professionSegmentSC,
		    professionSegmentSC.getRecToskip(), professionSegmentSC.getNbRec());
	}
    }

    public int professionSegmentListCount(ProfessionSegmentSC professionSegmentSC) throws DAOException
    {
	DAOHelper.fixGridMaps(professionSegmentSC, getSqlMap(), "professionSegmentListMapper.professionSegmentList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("professionSegmentListMapper.professionSegmentListCount", professionSegmentSC)).intValue();
	return nb;
    }

    public CTS_PROFESSION_SEGMENTVO returnDependencyByProfessionSegment(ProfessionSegmentSC professionSegmentSC) throws DAOException
    {
	return (CTS_PROFESSION_SEGMENTVO)getSqlMap().queryForObject("professionSegmentListMapper.returnDependencyByProfessionSegment", professionSegmentSC);
    }
}
