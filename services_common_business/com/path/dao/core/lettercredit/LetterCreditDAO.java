package com.path.dao.core.lettercredit;

import java.util.List;

import com.path.dbmaps.vo.TFSLC1VO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.lettercredit.LetterCreditCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * LetterCreditDAO.java used to get LC lookup details
 */
public interface LetterCreditDAO
{
    int returnLetterCreditLookupCount(LetterCreditSC criteria) throws DAOException;

    List<LetterCreditCO> returnLetterCreditLookupList(LetterCreditSC criteria) throws DAOException;

    TFSLC1VO returnLetterCreditById(LetterCreditSC criteria) throws DAOException;

    LetterCreditCO returnLcDetailsById(LetterCreditSC criteria) throws DAOException;

    int returnLcIssueLookupCount(LetterCreditSC criteria) throws DAOException;

    List<LetterCreditCO> returnLcIssueLookupList(LetterCreditSC criteria) throws DAOException;

}
