package com.path.dao.core.billcollection.impl;

import java.util.List;

import com.path.dao.core.billcollection.BillCollectionDAO;
import com.path.dbmaps.vo.TFSBILLVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.billcollection.BillCollectionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights
 * to this source code
 * BillCollectionDAOImpl.java used to retrieve data from DB
 */
public class BillCollectionDAOImpl extends BaseDAO implements BillCollectionDAO
{
    /**
     * BillCollection Lookup count
     */
    public int returnBillCollectionLookupCount(BillCollectionSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "billCollectionMapper.resultBillCollectionLookupMap");
        return ((Integer) getSqlMap().queryForObject("billCollectionMapper.selectBillCollectionLookupCount",
            criteria)).intValue();
    }

    /**
     * BillCollection Lookup list
     */
    public List<BillCollectionCO> returnBillCollectionLookupList(BillCollectionSC criteria) throws DAOException
    {

        DAOHelper.fixGridMaps(criteria, getSqlMap(), "billCollectionMapper.resultBillCollectionLookupMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("billCollectionMapper.selectBillCollectionLookupList", criteria);
        }
        else
        {
            return getSqlMap().queryForList("billCollectionMapper.selectBillCollectionLookupList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * BillCollection Dependency
     */
    public TFSBILLVO checkBillCollectionValidation(BillCollectionSC criteria) throws DAOException
    {
        return (TFSBILLVO) getSqlMap().queryForObject("billCollectionMapper.checkBillCollectionValidation",
            criteria);
    }

    /**
     * BillCollection Lookup count
     */

    public int returnAcceptanceLkpCount(BillCollectionSC criteria) throws DAOException
    {
        return ((Integer) getSqlMap().queryForObject("billCollectionMapper.returnAcceptanceLkpCount", criteria));
    }

    /**
     * BillCollection Lookup list
     */

    public List<BillCollectionCO> returnAcceptanceLkpList(BillCollectionSC criteria) throws DAOException
    {
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("billCollectionMapper.returnAcceptanceLkpList", criteria);
        }
        else
        {
            DAOHelper.fixGridMaps(criteria, getSqlMap(), "billCollectionMapper.acceptanceLkpListMap");
            return getSqlMap().queryForList("billCollectionMapper.returnAcceptanceLkpList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * BillCollection Lookup count
     */

    public int returnAcceptanceAmendLkpCount(BillCollectionSC criteria) throws DAOException
    {
        return ((Integer) getSqlMap().queryForObject("billCollectionMapper.returnAcceptanceAmendLkpCount",
            criteria));
    }

    /**
     * BillCollection Lookup list
     */

    public List<BillCollectionCO> returnAcceptanceAmendLkpList(BillCollectionSC criteria) throws DAOException
    {
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("billCollectionMapper.returnAcceptanceAmendLkpList", criteria);
        }
        else
        {
            DAOHelper.fixGridMaps(criteria, getSqlMap(), "billCollectionMapper.acceptanceAmendLkpListMap");
            return getSqlMap().queryForList("billCollectionMapper.returnAcceptanceAmendLkpList", criteria,
                criteria.getRecToskip(), criteria.getNbRec());
        }
    }

}
