package com.path.bo.core.billcollection;

import java.util.List;

import com.path.dbmaps.vo.TFSBILLVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.billcollection.BillCollectionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: ghenoiesaab
 * @date: Nov 6, 2013
 */
public interface BillCollectionBO
{
    /**
     * Bill Collection Count
     */
    int returnBillCollectionLookupCount(BillCollectionSC criteria) throws BaseException;

    /**
     * Bill Collectin List
     */
    List<BillCollectionCO> returnBillCollectionLookupList(BillCollectionSC criteria) throws BaseException;

    /**
     * Check bill validation
     */
    TFSBILLVO checkBillCollectionValidation(BillCollectionSC criteria) throws BaseException;

    /**
     * Acceptance Collection Count
     */
    int returnAcceptanceLkpCount(BillCollectionSC criteria) throws BaseException;

    /**
     * Acceptance Collection List
     */
    List<BillCollectionCO> returnAcceptanceLkpList(BillCollectionSC criteria) throws BaseException;

    /**
     * Acceptance Amend Collection Count
     */
    int returnAcceptanceAmendLkpCount(BillCollectionSC criteria) throws BaseException;

    /**
     * Acceptance Amend Collection List
     */
    List<BillCollectionCO> returnAcceptanceAmendLkpList(BillCollectionSC criteria) throws BaseException;

}
