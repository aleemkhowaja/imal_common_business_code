package com.path.dao.core.cifrating;

import java.util.List;

import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifrating.CifRatingSC;

public interface CifRatingDAO
{
    public int cifRatingListCount(CifRatingSC cifRatingSC) throws DAOException;

    public List cifRatingList(CifRatingSC cifRatingSC) throws DAOException;
    
    public CREDIT_RATINGVO returnCifRatingByCode(CifRatingSC cifRatingSC) throws DAOException;
    
    public CREDIT_RATINGVO returnCifRatingDetailsByCode(CifRatingSC cifRatingSC) throws DAOException;
}
