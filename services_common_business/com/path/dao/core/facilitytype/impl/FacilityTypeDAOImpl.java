package com.path.dao.core.facilitytype.impl;

import java.util.List;

import com.path.dao.core.facilitytype.FacilityTypeDAO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.facilitytype.FacilityCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public class FacilityTypeDAOImpl extends BaseDAO implements FacilityTypeDAO
{

    @Override
    public List facilityTypeList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(facilityTypeSC.getSidx()).isEmpty())
	{
	    facilityTypeSC.setSidx("CODE");
	    facilityTypeSC.setSord("ASC");
	}
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityTypeList", facilityTypeSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityTypeListMap");
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityTypeList", facilityTypeSC,
		    facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
	}
    }

    @Override
    public int facilityTypeListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeListMapper.facilityTypeListCount", facilityTypeSC))
		.intValue();
	return nb;
    }

    public FMSFACILITYTYPEVO returnFacilityTypeByCode(FacilityTypeSC criteria) throws DAOException
    {
	return (FMSFACILITYTYPEVO) getSqlMap().queryForObject("facilityTypeListMapper.returnFacilityTypeByCode",
		criteria);
    }

    @Override
    public FMSFACILITYTYPEVO returnFacilityTypeById(FacilityTypeSC criteria) throws DAOException
    {
	return (FMSFACILITYTYPEVO) getSqlMap().queryForObject("facilityTypeListMapper.returnFacilityTypeById",
		criteria);
    }

    public List facilityNumberList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityCOListMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityNumberList", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityNumberList", facilityTypeSC,
		    facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
	}
    }

    public int facilityNumberListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityCOListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeListMapper.facilityNumberListCount", facilityTypeSC))
		.intValue();
	return nb;
    }

    public FacilityCO returnFacilityCOByCode(FacilityTypeSC criteria) throws DAOException
    {
	return (FacilityCO) getSqlMap().queryForObject("facilityTypeListMapper.returnFacilityCOByCode", criteria);
    }

    public List facilitySubLimitList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "FMSFACILITYDET.BaseResultMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilitySubLimitList", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilitySubLimitList", facilityTypeSC,
		    facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
	}
    }

    public int facilitySubLimitListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeListMapper.facilitySubLimitListCount", facilityTypeSC))
		.intValue();
	return nb;
    }

    public FMSFACILITYDETVO returnFacilityDetVOByCode(FacilityTypeSC criteria) throws DAOException
    {
	return (FMSFACILITYDETVO) getSqlMap().queryForObject("facilityTypeListMapper.returnFacilityDetVOByCode",
		criteria);
    }

    public List facilityNumberTFAList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityCOListMapTFA");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityNumberTFAList", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.facilityNumberTFAList", facilityTypeSC,
		    facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
	}
    }

    public int facilityNumberTFAListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "facilityTypeListMapper.facilityCOListMapTFA");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeListMapper.facilityNumberTFAListCount", facilityTypeSC))
		.intValue();
	return nb;
    }

 // Raed Saad - BMOI150250
    @Override
    public int cardsFacilityCountList(CardsManagementSC criteria) throws DAOException
    {
//	DAOHelper.fixGridMaps(criteria, getSqlMap(), "facilityTypeMapper.cardsFacilityResultList");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("facilityTypeListMapper.cardsFacilityListCount", criteria))
		.intValue();
	return nb;	
	
    }
    
    // Raed Saad - BMOI150250
    @Override
    public List<CardsManagementCO> cardsFacilityList(CardsManagementSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "facilityTypeListMapper.cardsFacilityResultList");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.cardsFacilityList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("facilityTypeListMapper.cardsFacilityList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}
