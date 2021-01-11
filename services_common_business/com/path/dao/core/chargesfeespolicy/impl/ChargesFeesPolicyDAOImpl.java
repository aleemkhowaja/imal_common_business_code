package com.path.dao.core.chargesfeespolicy.impl;

import java.util.List;

import com.path.dao.core.chargesfeespolicy.ChargesFeesPolicyDAO;
import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;

public class ChargesFeesPolicyDAOImpl extends BaseDAO implements ChargesFeesPolicyDAO
{

	@Override
	public List chargesFeesPolicyList(ChargesFeesPolicySC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesFeesPolicyMapper.chargesFeesPolicyList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesFeesPolicyMapper.chargesFeesPolicyListMap");
		    return getSqlMap().queryForList("chargesFeesPolicyMapper.chargesFeesPolicyList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int chargesFeesPolicyListCount(ChargesFeesPolicySC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesFeesPolicyMapper.chargesFeesPolicyListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesFeesPolicyMapper.chargesFeesPolicyListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CTS_CHARGES_FEES_POLICYVO chargesFeesPolicyById(ChargesFeesPolicySC criteria) throws DAOException
	{
	    return (CTS_CHARGES_FEES_POLICYVO)getSqlMap().queryForObject("chargesFeesPolicyMapper.returnChargesFeesPolicyById", criteria);
	}
	
}
