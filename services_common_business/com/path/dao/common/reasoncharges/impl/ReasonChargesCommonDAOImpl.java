package com.path.dao.common.reasoncharges.impl;

import java.util.List;

import com.path.dao.common.reasoncharges.ReasonChargesCommonDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.reasoncharges.ReasonChargesCommonSC;

public class ReasonChargesCommonDAOImpl extends BaseDAO implements ReasonChargesCommonDAO
{
	@Override
	public List getReasonChargesList(ReasonChargesCommonSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("reasonchargesMapper.reasonchargesList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "reasonchargesMapper.reasonchargesDetailMap");
		    return getSqlMap().queryForList("reasonchargesMapper.reasonchargesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int getReasonChargesListCount(ReasonChargesCommonSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "reasonchargesMapper.reasonchargesDetailMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("reasonchargesMapper.reasonchargesListCount", criteria)).intValue();
		return nb;
	}
	
	 public void deleteReasonchargesList(ReasonChargesCommonSC reasonChargesSC) throws DAOException
	 {
		 getSqlMap().delete("reasonchargesMapper.deleteReasonchargesList", reasonChargesSC);
	 }
	 
}
