package com.path.bo.core.facilitytypeclass.impl;

import java.util.List;

import com.path.bo.core.facilitytypeclass.FacilityTypeClassBO;
import com.path.dao.core.facilitytypeclass.FacilityTypeClassDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.facilitytypeclass.FacilityTypeClassSC;

public class FacilityTypeClassBOImpl extends BaseBO implements FacilityTypeClassBO

{
    private FacilityTypeClassDAO facilityTypeClassDAO;

    @Override
    public List facilityTypeClassList(FacilityTypeClassSC criteria) throws BaseException
    {
	return facilityTypeClassDAO.facilityTypeClassList(criteria);
    }

    @Override
    public int facilityTypeClassListCount(FacilityTypeClassSC criteria) throws BaseException
    {
	return facilityTypeClassDAO.facilityTypeClassCount(criteria);
    }

    public FacilityTypeClassDAO getFacilityTypeClassDAO()
    {
	return facilityTypeClassDAO;
    }

    public void setFacilityTypeClassDAO(FacilityTypeClassDAO facilityTypeClassDAO)
    {
	this.facilityTypeClassDAO = facilityTypeClassDAO;
    }

    @Override
    public List facilityTypeClassTFAList(FacilityTypeClassSC facilityTypeClassSC) throws BaseException
    {
	return facilityTypeClassDAO.facilityTypeClassTFAList(facilityTypeClassSC);
    }

    @Override
    public int facilityTypeClassTFAListCount(FacilityTypeClassSC facilityTypeClassSC) throws BaseException
    {
	return facilityTypeClassDAO.facilityTypeClassTFAListCount(facilityTypeClassSC);
    }

}
