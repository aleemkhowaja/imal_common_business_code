package com.path.dao.core.teller;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_ALLOWED_USERSVOKey;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.teller.TellerCO;
import com.path.vo.core.teller.TellerSC;

public interface TellerDAO
{

    Integer returnTellerLookupCount(TellerSC tellerSC) throws DAOException;

    List<CTSTELLERVO> returnTellerLookupData(TellerSC tellerSC) throws DAOException;

    public CTSTELLERVO returnRoleById(TellerSC criteria) throws DAOException;

    public String returnShowBranchCondition(TellerSC criteria) throws DAOException;

    public List<BigDecimal> getAllTellerBranches(TellerSC criteria) throws DAOException;

    public CTSTELLERVO returnCifReservedNo(TellerSC criteria) throws DAOException;
    Integer returnATMUsersLookupCount(TellerSC tellerSC) throws DAOException;

    List<CTSTELLER_ALLOWED_USERSVOKey> returnATMUsersLookupData(TellerSC tellerSC) throws DAOException;
    public Integer returnRepresentiveLookupCount(TellerSC tellerSC) throws DAOException;

    public List<TellerCO> returnRepresentiveLookupData(TellerSC tellerSC) throws DAOException;
    
    // returns representive description
    public TellerCO returnRepresentiveDesc (TellerSC criteria  ) throws DAOException;

}
