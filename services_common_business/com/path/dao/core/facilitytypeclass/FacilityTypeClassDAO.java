package com.path.dao.core.facilitytypeclass;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.facilitytypeclass.FacilityTypeClassSC;

public interface FacilityTypeClassDAO
{
    public int facilityTypeClassCount(FacilityTypeClassSC criteria) throws DAOException;

    public List facilityTypeClassList(FacilityTypeClassSC criteria) throws DAOException;

    public List facilityTypeClassTFAList(FacilityTypeClassSC facilityTypeClassSC) throws DAOException;

    public int facilityTypeClassTFAListCount(FacilityTypeClassSC facilityTypeClassSC) throws DAOException;

}
