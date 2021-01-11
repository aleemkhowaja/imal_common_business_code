package com.path.dao.common.trxtypecharges.impl;

import java.util.List;

import com.path.dao.common.trxtypecharges.TrxTypeChargesCommonDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonSC;

public class TrxTypeChargesCommonDAOImpl extends BaseDAO implements TrxTypeChargesCommonDAO
{
	@Override
	public List getTrxTypeChargesList(TrxTypeChargesCommonSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("trxtypechargesMapper.trxtypechargesList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxtypechargesMapper.trxtypechargesDetailMap");
		    return getSqlMap().queryForList("trxtypechargesMapper.trxtypechargesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int getTrxTypeChargesListCount(TrxTypeChargesCommonSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxtypechargesMapper.trxtypechargesDetailMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("trxtypechargesMapper.trxtypechargesListCount", criteria)).intValue();
		return nb;
	}
	//addded by jihad to delete all cif type charge details
	  public void deleteTrxtypeChargesDetail(TrxTypeChargesCommonSC trxTypeChargesSC) throws DAOException
		 {
			 getSqlMap().delete("trxtypechargesMapper.deleteTrxtypechargesDetail", trxTypeChargesSC);
		 }

}
