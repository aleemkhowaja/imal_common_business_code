/**
 * 
 */
package com.path.dao.common.trxtypecharges;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonSC;

public interface TrxTypeChargesCommonDAO
{
	public List getTrxTypeChargesList(TrxTypeChargesCommonSC criteria) throws DAOException;

	public int getTrxTypeChargesListCount(TrxTypeChargesCommonSC criteria) throws DAOException;
	
	 public void deleteTrxtypeChargesDetail(TrxTypeChargesCommonSC trxTypeChargesSC) throws DAOException;
}
