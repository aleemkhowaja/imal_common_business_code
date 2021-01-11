package com.path.bo.core.facilitytype;

import java.util.List;

import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.facilitytype.FacilityCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public interface FacilityTypeBO
{
    public int facilityTypeListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List facilityTypeList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public FMSFACILITYTYPEVO returnFacilityTypeById(FacilityTypeSC criteria) throws BaseException;

    public FMSFACILITYTYPEVO returnFacilityTypeByCode(FacilityTypeSC criteria) throws BaseException;

    public int facilityNumberListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List facilityNumberList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public FacilityCO returnFacilityCOByCode(FacilityTypeSC criteria) throws BaseException;

    public int facilitySubLimitListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List facilitySubLimitList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public FMSFACILITYDETVO returnFacilityDetVOByCode(FacilityTypeSC criteria) throws BaseException;

    public int facilityNumberTFAListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List facilityNumberTFAList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List<CardsManagementCO> cardsFacilityList(CardsManagementSC criteria) throws BaseException;

    int cardsFacilityCountList(CardsManagementSC criteria) throws BaseException;
}
