package com.path.dao.core.letterguarantee;

import java.util.List;

import com.path.dbmaps.vo.TFSLGVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.letterguarantee.LetterGuaranteeCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * @date: Nov 6, 2013
 * LetterGuaranteeDAO.java used to get LG lookup details
 */
public interface LetterGuaranteeDAO
{
    int returnLetterGuaranteeLookupCount(LetterGuaranteeSC criteria) throws DAOException;

    List<LetterGuaranteeCO> returnLetterGuaranteeLookupList(LetterGuaranteeSC criteria) throws DAOException;

    TFSLGVO checkLetterGuaranteeValidation(LetterGuaranteeSC criteria) throws DAOException;

    /**
     * Return records number for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     */
    int returnLgIssueLkpCount(LetterGuaranteeSC criteria) throws DAOException;

    /**
     * Return the List of Records for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     */
    List<LetterGuaranteeCO> returnLgIssueLkpList(LetterGuaranteeSC criteria) throws DAOException;

    /**
     * Validation of Request Number in LG
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws DAOException
     */
    TFSLGVO checkLgIssueValidation(LetterGuaranteeSC criteria) throws DAOException;

}
