package com.path.dao.core.reference.impl;

import java.math.BigDecimal;
import java.util.List;
import com.path.dao.core.reference.ReferenceDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.reference.ReferenceCO;
import com.path.vo.core.reference.ReferenceSC;

public class ReferenceDAOImpl extends BaseDAO implements ReferenceDAO
{
	@Override
	public List referenceList(ReferenceSC referenceSC) throws DAOException {
		if(referenceSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("referenceListMapper.referenceList", referenceSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceList_ResMap");
		    return getSqlMap().queryForList("referenceListMapper.referenceList", referenceSC, referenceSC.getRecToskip(),
		    		referenceSC.getNbRec());
		}
	}

	@Override
	public int referenceListCount(ReferenceSC referenceSC) throws DAOException {
		DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("referenceListMapper.referenceListCount", referenceSC)).intValue();
		return nb;
	}

	@Override
	public BigDecimal returnReference(ReferenceSC criteria) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("referenceListMapper.dependencyByReference", criteria);
	}

	@Override
	public List referenceBCList(ReferenceSC referenceSC) throws DAOException {
		if(referenceSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("referenceListMapper.referenceBCList", referenceSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceBCList_ResMap");
		    return getSqlMap().queryForList("referenceListMapper.referenceBCList", referenceSC, referenceSC.getRecToskip(),
		    		referenceSC.getNbRec());
		}
	}

	@Override
	public int referenceBCListCount(ReferenceSC referenceSC)
			throws DAOException {
		DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceBCList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("referenceListMapper.referenceBCListCount", referenceSC)).intValue();
		return nb;
	}

	@Override
	public List referenceDealList(ReferenceSC referenceSC) throws DAOException {
		if(referenceSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("referenceListMapper.referenceDealList", referenceSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceDealList_ResMap");
		    return getSqlMap().queryForList("referenceListMapper.referenceDealList", referenceSC, referenceSC.getRecToskip(),
		    		referenceSC.getNbRec());
		}
	}

	@Override
	public int referenceDealListCount(ReferenceSC referenceSC)
			throws DAOException {
		DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceDealList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("referenceListMapper.referenceDealListCount", referenceSC)).intValue();
		return nb;
	}

	@Override
	public List referenceLGList(ReferenceSC referenceSC) throws DAOException {
		if(referenceSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("referenceListMapper.referenceLGList", referenceSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceLGList_ResMap");
		    return getSqlMap().queryForList("referenceListMapper.referenceLGList", referenceSC, referenceSC.getRecToskip(),
		    		referenceSC.getNbRec());
		}
	}

	@Override
	public int referenceLGListCount(ReferenceSC referenceSC)
			throws DAOException {
		DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.referenceLGList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("referenceListMapper.referenceLGListCount", referenceSC)).intValue();
		return nb;
	}

    /**
     * FxDeal Lookup Count
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    public int returnFxDealLkpCount(ReferenceSC referenceSC) throws DAOException
    {
        DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.resultFxDealLookupMap");
        return ((Integer) getSqlMap().queryForObject("referenceListMapper.returnFxDealLkpCount", referenceSC))
            .intValue();
    }

    /**
     * FxDeal Lookup list
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    public List<ReferenceCO> returnFxDealLkpList(ReferenceSC referenceSC) throws DAOException
    {

        DAOHelper.fixGridMaps(referenceSC, getSqlMap(), "referenceListMapper.resultFxDealLookupMap");
        if(referenceSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("referenceListMapper.returnFxDealLkpList", referenceSC);

        }
        else
        {
            return getSqlMap().queryForList("referenceListMapper.returnFxDealLkpList", referenceSC,
                referenceSC.getRecToskip(), referenceSC.getNbRec());
        }
    }
	
}
