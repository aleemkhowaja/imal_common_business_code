package com.path.dao.core.cifuseraccess;

import java.math.BigDecimal;
import java.util.Map;

import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;

public interface CifUserAccessDAO
{
    public Map<BigDecimal, CTSTELLER_AXSVO>   selectCifUserAccessList (CifUserAccessSC cifUserAccessSC) throws DAOException;
}
