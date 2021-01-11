package com.path.bo.core.lettercredit;

import java.util.List;

import com.path.dbmaps.vo.TFSLC1VO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.lettercredit.LetterCreditCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * @date: Nov 6, 2013
 * 
 */
public interface LetterCreditBO
{
    int returnLetterCreditLookupCount(LetterCreditSC criteria) throws BaseException;

    List<LetterCreditCO> returnLetterCreditLookupList(LetterCreditSC criteria) throws BaseException;

    TFSLC1VO returnLetterCreditById(LetterCreditSC criteria) throws BaseException;

    LetterCreditCO returnLcDetailsById(LetterCreditSC criteria) throws BaseException;

    /**
     * Lc Issue Lookup count
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return int
     * @throws BaseException
     */
    int returnLcIssueLookupCount(LetterCreditSC criteria) throws BaseException;

    /**
     * Lc Issue Lookup List
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return List<LetterCreditCO>
     * @throws BaseException
     */
    List<LetterCreditCO> returnLcIssueLookupList(LetterCreditSC criteria) throws BaseException;

}
