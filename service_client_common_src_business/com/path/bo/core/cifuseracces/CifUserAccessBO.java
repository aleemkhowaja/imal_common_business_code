package com.path.bo.core.cifuseracces;

import java.math.BigDecimal;
import java.util.Map;

import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;

public interface CifUserAccessBO


{
    public Map<BigDecimal, CTSTELLER_AXSVO>   selectCifUserAccessList (CifUserAccessSC cifUserAccessSC) throws BaseException;
}
