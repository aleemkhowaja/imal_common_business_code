package com.path.dao.core.billcollection;

import java.util.List;

import com.path.dbmaps.vo.TFSBILLVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.billcollection.BillCollectionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * BillCollectionDAO.java used to get Bill lookup details
 */
public interface BillCollectionDAO
{
    int returnBillCollectionLookupCount(BillCollectionSC criteria) throws DAOException;

    List<BillCollectionCO> returnBillCollectionLookupList(BillCollectionSC criteria) throws DAOException;

    TFSBILLVO checkBillCollectionValidation(BillCollectionSC criteria) throws DAOException;

    /**
     * Acceptance Collection Count
     */
    int returnAcceptanceLkpCount(BillCollectionSC criteria) throws DAOException;

    /**
     * Acceptance Collection List
     */
    List<BillCollectionCO> returnAcceptanceLkpList(BillCollectionSC criteria) throws DAOException;

    /**
     * Acceptance amend Collection Count
     */
    int returnAcceptanceAmendLkpCount(BillCollectionSC criteria) throws DAOException;

    /**
     * Acceptance amend Collection List
     */
    List<BillCollectionCO> returnAcceptanceAmendLkpList(BillCollectionSC criteria) throws DAOException;

}
