package com.path.dao.core.cifrating.impl;

import java.util.List;

import com.path.dao.core.cifrating.CifRatingDAO;
import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cifrating.CifRatingSC;

public class CifRatingDAOImpl extends BaseDAO implements CifRatingDAO
{

    @Override
    public List cifRatingList(CifRatingSC cifRatingSC) throws DAOException
    {
	if(cifRatingSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifRatingMapper.cifRatingList", cifRatingSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cifRatingSC, getSqlMap(), "cifRatingMapper.cifRatingList_ResMap");
	    return getSqlMap().queryForList("cifRatingMapper.cifRatingList", cifRatingSC,
		    cifRatingSC.getRecToskip(), cifRatingSC.getNbRec());
	}
    }

    @Override
    public int cifRatingListCount(CifRatingSC cifRatingSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifRatingSC, getSqlMap(), "cifRatingMapper.cifRatingList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifRatingMapper.cifRatingListCount", cifRatingSC)).intValue();
	return nb;
    }

    @Override
    public CREDIT_RATINGVO returnCifRatingByCode(CifRatingSC cifRatingSC) throws DAOException
    {
	return (CREDIT_RATINGVO) getSqlMap().queryForObject("cifRatingMapper.returnCifRatingById", cifRatingSC);
    }

	@Override
	public CREDIT_RATINGVO returnCifRatingDetailsByCode(CifRatingSC cifRatingSC) throws DAOException
	{
		return (CREDIT_RATINGVO) getSqlMap().queryForObject("cifRatingMapper.returnCifRatingDetailsById", cifRatingSC);
	}

}
