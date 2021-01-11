package com.path.bo.core.cifrating.impl;

import java.util.List;

import com.path.bo.core.cifrating.CifRatingBO;
import com.path.dao.core.cifrating.CifRatingDAO;
import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrating.CifRatingSC;

public class CifRatingBOImpl extends BaseBO implements CifRatingBO
{

    private CifRatingDAO cifRatingDAO;

    public CifRatingDAO getCifRatingDAO()
    {
	return cifRatingDAO;
    }

    public void setCifRatingDAO(CifRatingDAO cifRatingDAO)
    {
	this.cifRatingDAO = cifRatingDAO;
    }

    @Override
    public List cifRatingList(CifRatingSC cifRatingSC) throws BaseException
    {
	return cifRatingDAO.cifRatingList(cifRatingSC);
    }

    @Override
    public int cifRatingListCount(CifRatingSC cifRatingSC) throws BaseException
    {
	return cifRatingDAO.cifRatingListCount(cifRatingSC);
    }

    @Override
    public CREDIT_RATINGVO returnCifRatingByCode(CifRatingSC cifRatingSC) throws BaseException
    {
	return cifRatingDAO.returnCifRatingByCode(cifRatingSC);
    }

	@Override
	public CREDIT_RATINGVO returnCifRatingDetailsByCode(CifRatingSC cifRatingSC) throws BaseException
	{
		return cifRatingDAO.returnCifRatingDetailsByCode(cifRatingSC);
	}

}
