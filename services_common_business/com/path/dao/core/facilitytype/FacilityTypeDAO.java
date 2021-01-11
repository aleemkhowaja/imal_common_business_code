package com.path.dao.core.facilitytype;

import java.util.List;

import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.facilitytype.FacilityCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public interface FacilityTypeDAO
{
    public int facilityTypeListCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List facilityTypeList(FacilityTypeSC facilityTypeSC) throws DAOException;

    public FMSFACILITYTYPEVO returnFacilityTypeById(FacilityTypeSC criteria) throws DAOException;

    public FMSFACILITYTYPEVO returnFacilityTypeByCode(FacilityTypeSC criteria) throws DAOException;

    public int facilityNumberListCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List facilityNumberList(FacilityTypeSC facilityTypeSC) throws DAOException;

    public FacilityCO returnFacilityCOByCode(FacilityTypeSC criteria) throws DAOException;

    public int facilitySubLimitListCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List facilitySubLimitList(FacilityTypeSC facilityTypeSC) throws DAOException;

    public FMSFACILITYDETVO returnFacilityDetVOByCode(FacilityTypeSC criteria) throws DAOException;

    public int facilityNumberTFAListCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List facilityNumberTFAList(FacilityTypeSC facilityTypeSC) throws DAOException;
    
    public List<CardsManagementCO> cardsFacilityList(CardsManagementSC criteria) throws DAOException;

    int cardsFacilityCountList(CardsManagementSC criteria) throws DAOException;
}
