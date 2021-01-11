package com.path.dao.common.reservedcif.impl;

import java.util.List;

import com.path.dao.common.reservedcif.ReservedCifDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.reservedcif.ReservedCifSC;

public class ReservedCifDAOImpl extends BaseDAO implements ReservedCifDAO
{

    @Override
    public List getReservedCifList(ReservedCifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("reservedCifMapper.reservedCifList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CIF_RESERVED.BaseResultMap");
	    return getSqlMap().queryForList("reservedCifMapper.reservedCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int getReservedCifListCount(ReservedCifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "CIF_RESERVED.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reservedCifMapper.reservedCifListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public int returnReservedCifCount(ReservedCifSC criteria) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("reservedCifMapper.returnReservedCifCount", criteria)).intValue();
	return nb;
    }

}
