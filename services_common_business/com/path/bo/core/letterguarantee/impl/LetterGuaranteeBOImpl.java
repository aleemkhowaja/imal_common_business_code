package com.path.bo.core.letterguarantee.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.letterguarantee.LetterGuaranteeBO;
import com.path.dao.core.letterguarantee.LetterGuaranteeDAO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.letterguarantee.LetterGuaranteeCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: ghenoiesaab
 * LetterGuaranteeBOImpl.java used to open LG lookup
 */
public class LetterGuaranteeBOImpl extends BaseBO implements LetterGuaranteeBO
{
    LetterGuaranteeDAO letterGuaranteeDAO;

    /**
     * Return records number
     */
    public int returnLetterGuaranteeLookupCount(LetterGuaranteeSC criteria) throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        
        return letterGuaranteeDAO.returnLetterGuaranteeLookupCount(criteria);
    }

    /**
     * Return the List of Records
     */
    public List<LetterGuaranteeCO> returnLetterGuaranteeLookupList(LetterGuaranteeSC criteria)
        throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        
        return letterGuaranteeDAO.returnLetterGuaranteeLookupList(criteria);
    }
    
    /**
     * this method returns the status of the LG depending on the screen it is coming from
     * 
     * @author: KhaldounAlDanaf
     * @date: 19 / 03 / 2015
     */
    private void returnStatus(LetterGuaranteeSC criteria)
    {
        BigDecimal trxType = NumberUtil.emptyDecimalToZero(criteria.getTrxType());
        
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
     * Return LG by Id
     */
    public TFSLGVO checkLetterGuaranteeValidation(LetterGuaranteeSC criteria) throws BaseException
    {
        return letterGuaranteeDAO.checkLetterGuaranteeValidation(criteria);
    }

    /**
     * Return records number for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws BaseException
     */
    public int returnLgIssueLkpCount(LetterGuaranteeSC criteria) throws BaseException
    {
        criteria.setStatus(returnStatus());
        return letterGuaranteeDAO.returnLgIssueLkpCount(criteria);
    }

    /**
     * Return the List of Records for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws BaseException
     */
    public List<LetterGuaranteeCO> returnLgIssueLkpList(LetterGuaranteeSC criteria) throws BaseException
    {
        criteria.setStatus(returnStatus());
        return letterGuaranteeDAO.returnLgIssueLkpList(criteria);
    }

    /**
     * Return LG lookup status
     * 
     * @author: BassamEid
     * @date: Oct 3, 2013
     */
    private String returnStatus()
    {
        return ConstantsCommon.CRUD_APPROVE;
    }

    public LetterGuaranteeDAO getLetterGuaranteeDAO()
    {
        return letterGuaranteeDAO;
    }

    public void setLetterGuaranteeDAO(LetterGuaranteeDAO letterGuaranteeDAO)
    {
        this.letterGuaranteeDAO = letterGuaranteeDAO;
    }

}
