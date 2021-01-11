/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * 
 * LetterCreditDAOImpl.java used to open LC Lookup
 */
package com.path.dao.core.lettercredit.impl;

import java.util.List;

import com.path.dao.core.lettercredit.LetterCreditDAO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.lettercredit.LetterCreditCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

public class LetterCreditDAOImpl extends BaseDAO implements LetterCreditDAO
{
    /**
     *LetterCredit Lookup count
     */
    public int returnLetterCreditLookupCount(LetterCreditSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterCreditMapper.resultLetterCreditLookupMap");
        return ((Integer) getSqlMap().queryForObject("letterCreditMapper.selectLetterCreditLookupCount",
            criteria)).intValue();
    }

    /**
     * LetterCredit Lookup list
     */
    public List<LetterCreditCO> returnLetterCreditLookupList(LetterCreditSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterCreditMapper.resultLetterCreditLookupMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("letterCreditMapper.selectLetterCreditLookupList", criteria);
        }
        else
        {
            return getSqlMap().queryForList("letterCreditMapper.selectLetterCreditLookupList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * LetterCredit Dependency by id
     */
    public TFSLC1VO returnLetterCreditById(LetterCreditSC criteria) throws DAOException
    {
        return (TFSLC1VO) getSqlMap().queryForObject("letterCreditMapper.returnLetterCreditById", criteria);
    }

    /**
     * LetterCredit Dependency for Advices
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     */
    public LetterCreditCO returnLcDetailsById(LetterCreditSC criteria) throws DAOException
    {
        return (LetterCreditCO) getSqlMap().queryForObject("letterCreditMapper.returnLcDetailsById", criteria);
    }

    /**
     * Return Lc Issue Lookup Count
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return int
     * @throws DAOException
     */
    public int returnLcIssueLookupCount(LetterCreditSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterCreditMapper.resultLcIssueLookupMap");
        return ((Integer) getSqlMap().queryForObject("letterCreditMapper.selectLcIssueLookupCount", criteria))
            .intValue();
    }

    /**
     * Return Lc Issue Lookup List
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @param criteria
     * @return List<LetterCreditCO>
     * @throws DAOException
     */
    public List<LetterCreditCO> returnLcIssueLookupList(LetterCreditSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "letterCreditMapper.resultLcIssueLookupMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("letterCreditMapper.selectLcIssueLookupList", criteria);
        }
        else
        {
            return getSqlMap().queryForList("letterCreditMapper.selectLcIssueLookupList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

}
