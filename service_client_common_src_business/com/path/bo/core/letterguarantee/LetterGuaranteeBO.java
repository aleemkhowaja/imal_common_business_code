package com.path.bo.core.letterguarantee;

import java.util.List;

import com.path.dbmaps.vo.TFSLGVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.letterguarantee.LetterGuaranteeCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * @date: Nov 6, 2013
 * LetterGuaranteeBO.java used to open LG Lookup
 */
public interface LetterGuaranteeBO
{
    int returnLetterGuaranteeLookupCount(LetterGuaranteeSC criteria) throws BaseException;

    List<LetterGuaranteeCO> returnLetterGuaranteeLookupList(LetterGuaranteeSC criteria) throws BaseException;

    TFSLGVO checkLetterGuaranteeValidation(LetterGuaranteeSC criteria) throws BaseException;

    /**
     * Return records number for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws BaseException
     */
    int returnLgIssueLkpCount(LetterGuaranteeSC criteria) throws BaseException;

    /**
     * Return the List of Records for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws BaseException
     */
    List<LetterGuaranteeCO> returnLgIssueLkpList(LetterGuaranteeSC criteria) throws BaseException;

}
