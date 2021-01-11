package com.path.bo.core.lettercredit.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.lettercredit.LetterCreditBO;
import com.path.dao.core.lettercredit.LetterCreditDAO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.lettercredit.LetterCreditCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * LetterCreditBOImpl.java used to get all data related to LC (letter of Credit)
 */
public class LetterCreditBOImpl extends BaseBO implements LetterCreditBO
{
    LetterCreditDAO letterCreditDAO;

    /**
     * Letter Credit lookup count
     * 
     * @author: ghenoiesaab
     * @date: Nov 13, 2013
     */
    public int returnLetterCreditLookupCount(LetterCreditSC criteria) throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        
        return letterCreditDAO.returnLetterCreditLookupCount(criteria);
    }

    /**
     * Letter Credit Lookup List
     * 
     * @author: ghenoiesaab
     * @date: Nov 13, 2013
     */
    public List<LetterCreditCO> returnLetterCreditLookupList(LetterCreditSC criteria) throws BaseException
    {
        // kaldanaf - FIBA140163 - setting up the status using the new method
        returnStatus(criteria);
        
        return letterCreditDAO.returnLetterCreditLookupList(criteria);
    }
    
    /**
     * this method returns the status of the LC depending on document type
     * 
     * @author: KhaldounAlDanaf
     * @date: 19 / 03 / 2015
     */
    private void returnStatus(LetterCreditSC criteria)
    {
        
        BigDecimal trxType = NumberUtil.emptyDecimalToZero(criteria.getTrxType());
        
        // margin case
        if(ConstantsCommon.TRX_TYPE_AMEND_MARGIN.equals(trxType))
        {
            criteria.setStatusInclude(ConstantsCommon.MARGIN_LOOKUP_STATUS_LC);
        }
        // suspense settlement - outside charges - other charges screens
        else if(ConstantsCommon.TRX_TYPE_SUSPENSE_SETTLEMENT.equals(trxType)
            || ConstantsCommon.TRX_TYPE_OUTSIDE_CHARGES.equals(trxType)
            || ConstantsCommon.TRX_TYPE_OTHER_COMMISSION.equals(trxType))
        {
            criteria.setStatusInclude(ConstantsCommon.SUSPENSE_SETTLEMENT_LOOKUP_LC);
        }
        // default
        else
        {
            criteria.setStatus(ConstantsCommon.DOC_TYPE_IMPORT_LC.equals(criteria.getLcType())
                ? ConstantsCommon.STATUS_ISSUED
                    : ConstantsCommon.STATUS_APPROVED);
        }
    }

    /**
     * Letter Credit Details by Id
     * 
     * @author: ghenoiesaab
     */
    public TFSLC1VO returnLetterCreditById(LetterCreditSC criteria) throws BaseException
    {
        return letterCreditDAO.returnLetterCreditById(criteria);
    }

    /**
     * Letter Credit Dependency for Advices
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @PB:
     * @param criteria
     * @return
     * @throws BaseException
     */
    public LetterCreditCO returnLcDetailsById(LetterCreditSC criteria) throws BaseException
    {
        LetterCreditCO letterCreditCO = letterCreditDAO.returnLcDetailsById(criteria);

        if(letterCreditCO != null && letterCreditCO.getTfsLc1VO().getLC_REFERENCE_YEAR() != null
            && letterCreditCO.getTfsLc1VO().getLC_REFERENCE_NBR() != null
            && letterCreditCO.getTfsLc1VO().getCREDIT_AVAILABILITY() != null)
        {
            letterCreditCO.setLcRefNbrDesc(letterCreditCO.getTfsLc1VO().getLC_REFERENCE_YEAR().toString()
                .concat("-").concat(letterCreditCO.getTfsLc1VO().getCREDIT_AVAILABILITY()).concat("-").concat(
                    NumberUtil.addLeadingZeros(letterCreditCO.getTfsLc1VO().getLC_REFERENCE_NBR(), 10)
                        .toString()));
        }

        return letterCreditCO;
    }

    /**
     * Return Lc Issue LookupCount
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int returnLcIssueLookupCount(LetterCreditSC criteria) throws BaseException
    {
        return letterCreditDAO.returnLcIssueLookupCount(criteria);
    }

    /**
     * Return Lc Issue LookupList
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return List<LetterCreditCO>
     * @throws BaseException
     */
    public List<LetterCreditCO> returnLcIssueLookupList(LetterCreditSC criteria) throws BaseException
    {
        return letterCreditDAO.returnLcIssueLookupList(criteria);
    }

    public LetterCreditDAO getLetterCreditDAO()
    {
        return letterCreditDAO;
    }

    public void setLetterCreditDAO(LetterCreditDAO letterCreditDAO)
    {
        this.letterCreditDAO = letterCreditDAO;
    }
}
