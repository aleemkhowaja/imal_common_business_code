/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * @date: Jun 27, 2013
 * BillCollectionBOImpl.java used to get all data related to Bill Collection
 */

package com.path.bo.core.billcollection.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.billcollection.BillCollectionBO;
import com.path.dao.core.billcollection.BillCollectionDAO;
import com.path.dbmaps.vo.TFSBILLVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.billcollection.BillCollectionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

public class BillCollectionBOImpl extends BaseBO implements BillCollectionBO
{
    BillCollectionDAO billCollectionDAO;

    /**
     * Return records number
     */
    public int returnBillCollectionLookupCount(BillCollectionSC criteria) throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        return billCollectionDAO.returnBillCollectionLookupCount(criteria);
    }

    /**
     * Return the List of Records
     */
    public List<BillCollectionCO> returnBillCollectionLookupList(BillCollectionSC criteria)
        throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        return billCollectionDAO.returnBillCollectionLookupList(criteria);
    }
    
    
    /**
     * this method returns the status of the LG depending on the screen it is coming from
     * 
     * @author: KhaldounAlDanaf
     * @date: 19 / 03 / 2015
     */
    private void returnStatus(BillCollectionSC criteria)
    {
        BigDecimal trxType = NumberUtil.emptyDecimalToZero(criteria.getTrxType());
        
        // margin case
        if(ConstantsCommon.TRX_TYPE_AMEND_MARGIN.equals(trxType))
        {
            criteria.setStatusInclude(ConstantsCommon.MARGIN_LOOKUP_STATUS);
        }
        // suspense settlement - outside charges - other charges screens
        else if(ConstantsCommon.TRX_TYPE_SUSPENSE_SETTLEMENT.equals(trxType)
            || ConstantsCommon.TRX_TYPE_OUTSIDE_CHARGES.equals(trxType)
            || ConstantsCommon.TRX_TYPE_OTHER_COMMISSION.equals(trxType))
        {
            criteria.setStatusInclude(ConstantsCommon.SUSPENSE_SETTLEMENT_LOOKUP_STATUS);
        }
        // default
        else
        {
            criteria.setStatus(ConstantsCommon.CRUD_APPROVE);
        }
    }



    /**
     * Return Bill Collection by Id
     */
    public TFSBILLVO checkBillCollectionValidation(BillCollectionSC criteria) throws BaseException
    {
        criteria.setStatus(returnStatus());
        return billCollectionDAO.checkBillCollectionValidation(criteria);
    }

    /**
     * Return records number
     */
    public int returnAcceptanceLkpCount(BillCollectionSC criteria) throws BaseException
    {
        return billCollectionDAO.returnAcceptanceLkpCount(criteria);
    }

    /**
     * Return the List of Records
     */
    public List<BillCollectionCO> returnAcceptanceLkpList(BillCollectionSC criteria) throws BaseException
    {
        return billCollectionDAO.returnAcceptanceLkpList(criteria);
    }

    /**
     * Return records number
     */
    public int returnAcceptanceAmendLkpCount(BillCollectionSC criteria) throws BaseException
    {
        return billCollectionDAO.returnAcceptanceAmendLkpCount(criteria);
    }

    /**
     * Return the List of Records
     */
    public List<BillCollectionCO> returnAcceptanceAmendLkpList(BillCollectionSC criteria) throws BaseException
    {
        return billCollectionDAO.returnAcceptanceAmendLkpList(criteria);
    }

    /**
     * Return Bill Collection status
     * 
     * @author: BassamEid
     * @date: Oct 3, 2013
     */
    private String returnStatus()
    {
        return ConstantsCommon.CRUD_APPROVE;
    }

    public BillCollectionDAO getBillCollectionDAO()
    {
        return billCollectionDAO;
    }

    public void setBillCollectionDAO(BillCollectionDAO billCollectionDAO)
    {
        this.billCollectionDAO = billCollectionDAO;
    }

}
