package com.path.dao.core.charges.impl;

import java.util.List;

import com.path.dao.core.charges.ChargesDAO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.charges.ChargesSC;

public class ChargesDAOImpl extends BaseDAO implements ChargesDAO{

	@Override
	public List chargesList(ChargesSC chargesSC) throws DAOException {
		if(chargesSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesListMapper.chargesList", chargesSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(chargesSC, getSqlMap(), "chargesListMapper.chargesListMap");
		    return getSqlMap().queryForList("chargesListMapper.chargesList", chargesSC, chargesSC.getRecToskip(),
		    		chargesSC.getNbRec());
		}
	}

	@Override
	public int chargesListCount(ChargesSC chargesSC) throws DAOException {
		DAOHelper.fixGridMaps(chargesSC, getSqlMap(), "chargesListMapper.chargesListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesListMapper.chargesListCount", chargesSC)).intValue();
		return nb;
	}

	@Override
	public TRSCHARGESVO returnChargesById(ChargesSC criteria)
			throws DAOException {
		return (TRSCHARGESVO) getSqlMap().queryForObject("chargesListMapper.returnChargesById", criteria);

	}
}
