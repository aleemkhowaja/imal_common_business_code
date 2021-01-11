package com.path.dao.common.global360view.treasury.impl;

import java.util.List;

import com.path.dao.common.global360view.treasury.TreasuryDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.TreasuryDerivativesCO;
import com.path.vo.common.global360view.TreasurySC;

public class TreasuryDAOImpl extends BaseDAO implements TreasuryDAO {

	@Override
	public List<TreasuryDerivativesCO> getTreasuryDerivativesDetails(TreasurySC treasurySC) throws DAOException {
		return (List<TreasuryDerivativesCO>)getSqlMap().queryForList("treasuryMapper.selectTreasuryDerivates",treasurySC);
	}

		

}
