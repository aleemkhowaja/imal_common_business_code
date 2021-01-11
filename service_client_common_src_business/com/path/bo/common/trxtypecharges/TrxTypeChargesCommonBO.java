/**
 * 
 */
package com.path.bo.common.trxtypecharges;

import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonCO;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonSC;
import com.path.vo.core.csmfom.FomCO;



public interface TrxTypeChargesCommonBO
{
	public List getTrxTypeChargesList(TrxTypeChargesCommonSC criteria) throws BaseException;

	public int getTrxTypeChargesListCount(TrxTypeChargesCommonSC criteria) throws BaseException;
    //ADDED BY JIHAD IN ORDER TO SVE UPDATE DELETED DETAILS OF CHARGE
	public CIFVO updateTrxTypeChargeDetail(List<TrxTypeChargesCommonCO>  lst , TrxTypeChargesCommonCO trxTypeChargesCommonCO) throws BaseException;
	public TrxTypeChargesCommonCO initialiseOnModeNew(TrxTypeChargesCommonCO trxTypeChargesCO, FomCO fomCO) throws BaseException;

	public int checkNegativeComp(TrxTypeChargesCommonSC criteria) throws BaseException;
	
}
