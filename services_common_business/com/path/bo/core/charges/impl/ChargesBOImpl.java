package com.path.bo.core.charges.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.charges.ChargesBO;
import com.path.dao.core.charges.ChargesDAO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.charges.ChargesSC;

public class ChargesBOImpl extends BaseBO implements ChargesBO{
	
	private ChargesDAO chargesDAO;
	public ChargesDAO getChargesDAO() {
		return chargesDAO;
	}

	public void setChargesDAO(ChargesDAO chargesDAO) {
		this.chargesDAO = chargesDAO;
	}

	@Override
	public List chargesList(ChargesSC chargesSC) throws BaseException {
		return chargesDAO.chargesList(chargesSC);
	}

	@Override
	public int chargesListCount(ChargesSC chargesSC) throws BaseException {
		return chargesDAO.chargesListCount(chargesSC);
	}

	@Override
	public TRSCHARGESVO returnChargesById(ChargesSC criteria)
			throws BaseException {
		TRSCHARGESVO chargesVO	=	chargesDAO.returnChargesById(criteria);
		if(chargesVO==null)
		{
			throw new BOException(MessageCodes.INVALID_CHARGE_CODE);
		}
		return chargesVO;
	}
}
