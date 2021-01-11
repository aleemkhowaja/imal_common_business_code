package com.path.bo.core.reference;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.reference.ReferenceCO;
import com.path.vo.core.reference.ReferenceSC;

public interface ReferenceBO
{
    public int referenceListCount(ReferenceSC referenceSC) throws BaseException;

    public List referenceList(ReferenceSC referenceSC) throws BaseException;

    public BigDecimal returnReference(ReferenceSC criteria) throws BaseException;

    public int referenceLGListCount(ReferenceSC referenceSC) throws BaseException;

    public List referenceLGList(ReferenceSC referenceSC) throws BaseException;

    public int referenceBCListCount(ReferenceSC referenceSC) throws BaseException;

    public List referenceBCList(ReferenceSC referenceSC) throws BaseException;

    public int referenceDealListCount(ReferenceSC referenceSC) throws BaseException;

    public List referenceDealList(ReferenceSC referenceSC) throws BaseException;

    /**
     * Returns Lookup count for FxDeal
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB:w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    int returnFxDealLkpCount(ReferenceSC referenceSC) throws BaseException;

    /**
     * Returns Lookup count for FxDeal
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB:w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    List<ReferenceCO> returnFxDealLkpList(ReferenceSC referenceSC) throws BaseException;

}
