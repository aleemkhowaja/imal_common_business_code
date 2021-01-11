package com.path.dao.core.facilitytypeclass.impl;

import java.util.List;

import com.path.dao.core.facilitytypeclass.FacilityTypeClassDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.facilitytypeclass.FacilityTypeClassSC;

public class FacilityTypeClassDAOImpl extends BaseDAO implements FacilityTypeClassDAO
{

    @Override
    public int facilityTypeClassCount(FacilityTypeClassSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "facilityTypeClassMapper.facilityTypeClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeClassMapper.facilityTypeClassListCount", criteria))
		.intValue();
	return nb;
    }

    @Override
    public List facilityTypeClassList(FacilityTypeClassSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeClassMapper.facilityTypeClassList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "facilityTypeClassMapper.facilityTypeClassListMap");
	    return getSqlMap().queryForList("facilityTypeClassMapper.facilityTypeClassList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public List facilityTypeClassTFAList(FacilityTypeClassSC facilityTypeClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeClassSC, getSqlMap(), "facilityTypeClassMapper.facilityTypeClassTFAListMap");
	if(facilityTypeClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeClassMapper.facilityTypeClassTFAList", facilityTypeClassSC);
	}
	else
	{
	    return getSqlMap().queryForList("facilityTypeClassMapper.facilityTypeClassTFAList", facilityTypeClassSC,
		    facilityTypeClassSC.getRecToskip(), facilityTypeClassSC.getNbRec());
	}
    }

    @Override
    public int facilityTypeClassTFAListCount(FacilityTypeClassSC facilityTypeClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeClassSC, getSqlMap(), "facilityTypeClassMapper.facilityTypeClassTFAListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeClassMapper.facilityTypeClassTFAListCount",
		facilityTypeClassSC)).intValue();
	return nb;
    }

}
