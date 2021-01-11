package com.path.bo.core.chargesfeespolicy;

import java.util.List;

import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;

public interface ChargesFeesPolicyBO {

	public int chargesFeesPolicyListCount(ChargesFeesPolicySC criteria) throws BaseException;
    public List chargesFeesPolicyList(ChargesFeesPolicySC criteria) throws BaseException;
    public CTS_CHARGES_FEES_POLICYVO chargesFeesPolicyById(ChargesFeesPolicySC criteria) throws DAOException;
}
