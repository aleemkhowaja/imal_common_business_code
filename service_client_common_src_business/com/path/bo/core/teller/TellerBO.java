package com.path.bo.core.teller;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_ALLOWED_USERSVOKey;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.teller.TellerCO;
import com.path.vo.core.teller.TellerSC;

public interface TellerBO
{

    Integer returnTellerLookupCount(TellerSC tellerSC) throws BaseException;

    List<CTSTELLERVO> returnTellerLookupData(TellerSC tellerSC) throws BaseException;
    
    public CTSTELLERVO returnRoleById(TellerSC criteria) throws BaseException;
    
    public String returnShowBranchCondition(TellerSC criteria) throws BaseException;
    
    public List<BigDecimal> getAllTellerBranches(TellerSC criteria) throws BaseException;
    
    public CTSTELLERVO returnCifReservedNo(TellerSC criteria) throws BaseException;
    
    public Integer returnRepresentiveLookupCount(TellerSC tellerSC) throws BaseException;

    public List<TellerCO> returnRepresentiveLookupData(TellerSC tellerSC) throws BaseException;

    public TellerCO returnRepresentiveDesc(TellerSC tellerSC) throws BaseException;

    Integer returnATMUsersLookupCount(TellerSC tellerSC) throws BaseException;

    List<CTSTELLER_ALLOWED_USERSVOKey> returnATMUsersLookupData(TellerSC tellerSC) throws BaseException;

}
