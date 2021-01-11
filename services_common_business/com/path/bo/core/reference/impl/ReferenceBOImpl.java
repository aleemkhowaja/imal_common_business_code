package com.path.bo.core.reference.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.reference.ReferenceBO;
import com.path.dao.core.reference.ReferenceDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.reference.ReferenceCO;
import com.path.vo.core.reference.ReferenceSC;

public class ReferenceBOImpl extends BaseBO implements ReferenceBO
{
	private ReferenceDAO referenceDAO;
	@Override
	public List referenceList(ReferenceSC referenceSC) throws BaseException {
		return referenceDAO.referenceList(referenceSC);
	}

	@Override
	public int referenceListCount(ReferenceSC referenceSC) throws BaseException {
		return referenceDAO.referenceListCount(referenceSC);
	}

	public ReferenceDAO getReferenceDAO() {
		return referenceDAO;
	}

	public void setReferenceDAO(ReferenceDAO referenceDAO) {
		this.referenceDAO = referenceDAO;
	}

	@Override
	public BigDecimal returnReference(ReferenceSC criteria)throws BaseException {
		return  referenceDAO.returnReference(criteria);
	}

	@Override
	public List referenceBCList(ReferenceSC referenceSC) throws BaseException {
		return referenceDAO.referenceBCList(referenceSC);
	}

	@Override
	public int referenceBCListCount(ReferenceSC referenceSC)
			throws BaseException {
		return referenceDAO.referenceBCListCount(referenceSC);
	}

	@Override
	public List referenceDealList(ReferenceSC referenceSC) throws BaseException {
		return referenceDAO.referenceDealList(referenceSC);
	}

	@Override
	public int referenceDealListCount(ReferenceSC referenceSC)
			throws BaseException {
		return referenceDAO.referenceDealListCount(referenceSC);
	}

	@Override
	public List referenceLGList(ReferenceSC referenceSC) throws BaseException {
		return referenceDAO.referenceLGList(referenceSC);
	}

	@Override
	public int referenceLGListCount(ReferenceSC referenceSC)
			throws BaseException {
		return referenceDAO.referenceLGListCount(referenceSC);
	}

    /**
     * Returns Lookup count for FxDeal
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB:w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    public int returnFxDealLkpCount(ReferenceSC referenceSC) throws BaseException
    {
        return referenceDAO.returnFxDealLkpCount(referenceSC);
    }

    /**
     * Returns Lookup count for FxDeal
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB:w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    public List<ReferenceCO> returnFxDealLkpList(ReferenceSC referenceSC) throws BaseException
    {
        return referenceDAO.returnFxDealLkpList(referenceSC);
    }

}
