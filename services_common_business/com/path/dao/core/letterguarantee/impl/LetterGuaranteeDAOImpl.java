package com.path.dao.core.letterguarantee.impl;

import java.util.List;

import com.path.dao.core.letterguarantee.LetterGuaranteeDAO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.letterguarantee.LetterGuaranteeCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights
 * to this source code
 * LetterGuaranteeDAOImpl.java used to open LG lookup
 */
public class LetterGuaranteeDAOImpl extends BaseDAO implements LetterGuaranteeDAO
{
    /**
     * LetterGuarantee Lookup count
     */
    public int returnLetterGuaranteeLookupCount(LetterGuaranteeSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterGuaranteeMapper.resultLetterGuaranteeLookupMap");
        return ((Integer) getSqlMap().queryForObject("letterGuaranteeMapper.selectLetterGuaranteeLookupCount",
            criteria)).intValue();
    }

    /**
     * LetterGuarantee Lookup list
     */
    public List<LetterGuaranteeCO> returnLetterGuaranteeLookupList(LetterGuaranteeSC criteria)
        throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterGuaranteeMapper.resultLetterGuaranteeLookupMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("letterGuaranteeMapper.selectLetterGuaranteeLookupList", criteria);
        }
        else
        {
            return getSqlMap().queryForList("letterGuaranteeMapper.selectLetterGuaranteeLookupList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * LetterGuarantee Dependency
     */
    public TFSLGVO checkLetterGuaranteeValidation(LetterGuaranteeSC criteria) throws DAOException
    {
        return (TFSLGVO) getSqlMap().queryForObject("letterGuaranteeMapper.checkLetterGuaranteeValidation",
            criteria);
    }

    /**
     * Return records number for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     */
    public int returnLgIssueLkpCount(LetterGuaranteeSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterGuaranteeMapper.resultLgIssueLkpMap");
        return ((Integer) getSqlMap().queryForObject("letterGuaranteeMapper.returnLgIssueLkpCount", criteria))
            .intValue();
    }

    /**
     * Return the List of Records for LG Issuance
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     */
    public List<LetterGuaranteeCO> returnLgIssueLkpList(LetterGuaranteeSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterGuaranteeMapper.resultLgIssueLkpMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("letterGuaranteeMapper.returnLgIssueLkpList", criteria);
        }
        else
        {
            return getSqlMap().queryForList("letterGuaranteeMapper.returnLgIssueLkpList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * Validation of Request Number in LG
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @param criteria
     * @throws DAOException
     */
    public TFSLGVO checkLgIssueValidation(LetterGuaranteeSC criteria) throws DAOException
    {
        return (TFSLGVO) getSqlMap().queryForObject("letterGuaranteeMapper.checkLgIssueValidation", criteria);
    }

}
