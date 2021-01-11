package com.path.bo.core.facilitytypeclass;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.facilitytypeclass.FacilityTypeClassSC;

/**
 * @Auther:BKodiyan
 * @Date:May 12, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public interface FacilityTypeClassBO
{
    // Transaction Draw Down Lookup Action
    public int facilityTypeClassListCount(FacilityTypeClassSC criteria) throws BaseException;

    public List facilityTypeClassList(FacilityTypeClassSC criteria) throws BaseException;

    public int facilityTypeClassTFAListCount(FacilityTypeClassSC facilityTypeClassSC) throws BaseException;

    public List facilityTypeClassTFAList(FacilityTypeClassSC facilityTypeClassSC) throws BaseException;

}
