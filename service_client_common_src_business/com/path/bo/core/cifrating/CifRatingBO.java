package com.path.bo.core.cifrating;

import java.util.List;

import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrating.CifRatingSC;

public interface CifRatingBO
{
    public int cifRatingListCount(CifRatingSC cifRatingSC) throws BaseException;

    public List cifRatingList(CifRatingSC cifRatingSC) throws BaseException;
    
    public CREDIT_RATINGVO returnCifRatingByCode(CifRatingSC cifRatingSC) throws BaseException;
    
    public CREDIT_RATINGVO returnCifRatingDetailsByCode(CifRatingSC cifRatingSC) throws BaseException;
}
