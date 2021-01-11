/**
 * 
 */
package com.path.bo.common.reasoncharges;

import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.reasoncharges.ReasonChargesCommonCO;
import com.path.vo.common.reasoncharges.ReasonChargesCommonSC;
import com.path.vo.core.csmfom.FomCO;



public interface ReasonChargesCommonBO
{
	public List getReasonChargesList(ReasonChargesCommonSC criteria) throws BaseException;

	public int getReasonChargesListCount(ReasonChargesCommonSC criteria) throws BaseException;
	
	public CIFVO updateReasonChargeDetail(List<ReasonChargesCommonCO>  lst , ReasonChargesCommonCO reasonChargesCommonCO) throws BaseException;
	
	public ReasonChargesCommonCO initialiseOnModeNew(ReasonChargesCommonCO reasonChargesCO, FomCO fomCO) throws BaseException;

	public int checkNegativeComp(ReasonChargesCommonSC criteria) throws BaseException;
}
