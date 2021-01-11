package com.path.dao.core.chargesfeespolicy;

import java.util.List;

import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;

public interface ChargesFeesPolicyDAO {

    public int chargesFeesPolicyListCount(ChargesFeesPolicySC criteria) throws DAOException;
    public List chargesFeesPolicyList(ChargesFeesPolicySC criteria) throws DAOException;
    public CTS_CHARGES_FEES_POLICYVO chargesFeesPolicyById(ChargesFeesPolicySC criteria) throws DAOException;
}
