/**
 * 
 */
package com.path.dao.common.reasoncharges;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.reasoncharges.ReasonChargesCommonSC;

public interface ReasonChargesCommonDAO
{
	public List getReasonChargesList(ReasonChargesCommonSC criteria) throws DAOException;

	public int getReasonChargesListCount(ReasonChargesCommonSC criteria) throws DAOException;
	public void deleteReasonchargesList(ReasonChargesCommonSC reasonChargesSC) throws DAOException;
}
