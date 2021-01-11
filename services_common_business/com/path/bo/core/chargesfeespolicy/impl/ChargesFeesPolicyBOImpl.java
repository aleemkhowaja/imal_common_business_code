package com.path.bo.core.chargesfeespolicy.impl;

import java.util.List;

import com.path.bo.core.chargesfeespolicy.ChargesFeesPolicyBO;
import com.path.dao.core.chargesfeespolicy.ChargesFeesPolicyDAO;
import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;

public class ChargesFeesPolicyBOImpl extends BaseBO implements ChargesFeesPolicyBO
{
	private ChargesFeesPolicyDAO chargesFeesPolicyDAO;
	@Override
	public List chargesFeesPolicyList(ChargesFeesPolicySC criteria) throws BaseException
	{
		return chargesFeesPolicyDAO.chargesFeesPolicyList(criteria);
	}

	@Override
	public int chargesFeesPolicyListCount(ChargesFeesPolicySC criteria) throws BaseException
	{
		return chargesFeesPolicyDAO.chargesFeesPolicyListCount(criteria);
	}

	public ChargesFeesPolicyDAO getChargesFeesPolicyDAO()
	{
		return chargesFeesPolicyDAO;
	}

	public void setChargesFeesPolicyDAO(ChargesFeesPolicyDAO chargesFeesPolicyDAO)
	{
		this.chargesFeesPolicyDAO = chargesFeesPolicyDAO;
	}

	@Override
	public CTS_CHARGES_FEES_POLICYVO chargesFeesPolicyById(ChargesFeesPolicySC criteria) throws DAOException
	{
	    return chargesFeesPolicyDAO.chargesFeesPolicyById(criteria);
	}

}
