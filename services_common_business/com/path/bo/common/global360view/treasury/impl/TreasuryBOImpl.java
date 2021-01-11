package com.path.bo.common.global360view.treasury.impl;

import java.util.List;

import com.path.bo.common.global360view.treasury.TreasuryBO;
import com.path.dao.common.global360view.treasury.TreasuryDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.TreasuryDerivativesCO;
import com.path.vo.common.global360view.TreasurySC;

public class TreasuryBOImpl extends BaseBO implements TreasuryBO {

	private TreasuryDAO treasuryDAO;

	@Override
	public List<TreasuryDerivativesCO> getTreasuryDerivativesDetails(TreasurySC treasurySC) throws BaseException {
		return treasuryDAO.getTreasuryDerivativesDetails(treasurySC);
	}


	public TreasuryDAO getTreasuryDAO() {
		return treasuryDAO;
	}

	public void setTreasuryDAO(TreasuryDAO treasuryDAO) {
		this.treasuryDAO = treasuryDAO;
	}




}