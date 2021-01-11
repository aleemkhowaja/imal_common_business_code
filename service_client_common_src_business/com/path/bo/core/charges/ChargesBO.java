package com.path.bo.core.charges;

import java.util.List;

import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.charges.ChargesSC;

public interface ChargesBO {
	public int chargesListCount(ChargesSC chargesSC) throws BaseException;
	 public List chargesList(ChargesSC chargesSC) throws BaseException;
	 public TRSCHARGESVO returnChargesById(ChargesSC criteria) throws BaseException;
}
