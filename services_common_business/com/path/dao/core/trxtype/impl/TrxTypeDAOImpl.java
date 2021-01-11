package com.path.dao.core.trxtype.impl;

import java.util.List;

import com.path.dao.core.trxtype.TrxTypeDAO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPE_LINKVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxtype.TrxTypeSC;

public class TrxTypeDAOImpl extends BaseDAO implements TrxTypeDAO
{

	public List trxTypeList(TrxTypeSC criteria) throws DAOException
	{
	    List lst;
	    if(criteria.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeList", criteria, criteria.getRecToskip(),
			       criteria.getNbRec());
		}
	    return lst;
	}

	public int trxTypeListCount(TrxTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeListCount", criteria)).intValue();
		return nb;
	}
	
	public CTSTRXTYPEVO returnTrxTypeById(TrxTypeSC criteria)throws DAOException
	{
		return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.returnTrxTypeById", criteria);	
	}
	
	
	public List cardsTrxTypeList(TrxTypeSC criteria) throws DAOException
	{
	    List lst;
	    if(criteria.getNbRec() == -1)
	    {
		lst = getSqlMap().queryForList("trxTypeMapper.cardsTrxTypeList",criteria);
	    }
	    else
	    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
		lst = getSqlMap().queryForList("trxTypeMapper.cardsTrxTypeList", criteria, criteria.getRecToskip(),
			       criteria.getNbRec());
	    }
	    return lst;
	}
	
	public int cardsTrxTypeListCount(TrxTypeSC criteria) throws DAOException
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
	    int nb = 0;
	    nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.cardsTrxTypeListCount", criteria)).intValue();
	    return nb;
	}
	
	public CTSTRXTYPEVO cardsTrxTypeDependency(TrxTypeSC criteria) throws DAOException
	{
	    return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.cardsTrxTypeDependency", criteria);
	}

	/**
	 * Transaction Type for transaction trends popup
	 * @return List
	 */
	public List trxTypeForTransactionTrendsList(TrxTypeSC criteria) throws DAOException
	{
	    List lst;
	    if(criteria.getNbRec() == -1)
	    {
		lst = getSqlMap().queryForList("trxTypeMapper.trxTypeForTransactionTrendsList",criteria);
	    }
	    else
	    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
		lst = getSqlMap().queryForList("trxTypeMapper.trxTypeForTransactionTrendsList", criteria, criteria.getRecToskip(),
			criteria.getNbRec());
	    }
	    return lst;
	}


	/**
	 * Transaction Type list count for the transaction trends popup.
	 * @return int
	 */
	public int trxTypeForTransactionTrendsListCount(TrxTypeSC criteria) throws DAOException
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
	    int nb = 0;
	    nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeForTransactionTrendsCount", criteria)).intValue();
	    return nb;
	}
	
	/**
	 * Transaction Type dependency for transaciton trends 
	 * @return CTSTRXTYPEVO
	 */
	public CTSTRXTYPEVO trxTypeForTransactionTrendsDependency(TrxTypeSC criteria) throws DAOException
	{
	    return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.trxTypeForTransactionTrendsDependency", criteria);
	}

	/**
	 * Hold Transaction Type List for Lookup
	 * @return List
	 */
	public List holdTrxTypeList(TrxTypeSC criteria) throws DAOException
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
	    if(criteria.getNbRec() == -1)
	    {
		return getSqlMap().queryForList("trxTypeMapper.holdTrxTypeList",criteria);
	    }
	    else
	    {
		return getSqlMap().queryForList("trxTypeMapper.holdTrxTypeList", criteria, criteria.getRecToskip(),
			criteria.getNbRec());
	    }
	}

	/**
	 * Hold Transaction Type List Count for pagination in the Lookup grid
	 * @return int
	 */
	public int holdTrxTypeListCount(TrxTypeSC criteria) throws DAOException
	{
	    int nb = 0;
	    nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.holdTrxTypeListCount", criteria)).intValue();
	    return nb;
	}
	
	/**
	 * Hold Transaction Type dependency by Code 
	 * @return CTSTRXTYPEVO
	 */
	public CTSTRXTYPEVO returnHoldTrxTypeByDependency(TrxTypeSC criteria) throws DAOException
	{
	    return (CTSTRXTYPEVO)getSqlMap().queryForObject("trxTypeMapper.holdTrxTypeDependency", criteria);
	}

	/**
	 * Transaction Type dependency by Code 
	 * @return CTSTRXTYPEVO
	 */
	public CTSTRXTYPEVO returnCtsTrxTypeByDependency(TrxTypeSC criteria) throws DAOException
	{
	    return (CTSTRXTYPEVO)getSqlMap().queryForObject("trxTypeMapper.ctsTrxTypeByDependency", criteria);
	}

	/**
	 * Close Transfer Transaction Type List for Lookup
	 * @return List
	 */
	public List closeTransferTrxTypeList(TrxTypeSC criteria) throws DAOException
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.cardsTrxTypeListMap");
	    if(criteria.getNbRec() == -1)
	    {
		return getSqlMap().queryForList("trxTypeMapper.closeTrsfrTrxTypeList",criteria);
	    }
	    else
	    {
		return getSqlMap().queryForList("trxTypeMapper.closeTrsfrTrxTypeList", criteria, criteria.getRecToskip(),
			criteria.getNbRec());
	    }
	}

	/**
	 * Close Transfer Transaction Type List Count for pagination in the Lookup grid
	 * @return int
	 */
	public int closeTransferTrxTypeListCount(TrxTypeSC criteria) throws DAOException
	{
	    int nb = 0;
	    nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.closeTrsfrTrxTypeListCount", criteria)).intValue();
	    return nb;
	}

	@Override
	public List trxTypeLookupForTrxTypeLimitChargesList(TrxTypeSC criteria) throws DAOException
	{
	    List lst;
	    if(criteria.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeLookupForTrxTypeLimitChargesList", criteria, criteria.getRecToskip(),
			       criteria.getNbRec());
		}
	    return lst;
	}

	@Override
	public int trxTypeLookupForTrxTypeLimitChargesListCount(TrxTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeLookupForTrxTypeLimitChargesListCount", criteria)).intValue();
		return nb;
	}
	
	/***
	 * Trx Type lookup for fixed maturity account : dddw_import_trxtype - AccountsInstructionsTab.jsp
	 */
	@Override
	public List getTrxTypeForFmaList(TrxTypeSC criteria) throws DAOException {
	    List lst;
	    if(criteria.getNbRec() == -1)
	    {
		lst = getSqlMap().queryForList("trxTypeMapper.selectTrxTypeListForFma",criteria);
	    }
	    else
	    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		lst = getSqlMap().queryForList("trxTypeMapper.selectTrxTypeListForFma", criteria, criteria.getRecToskip(),
			       criteria.getNbRec());
	    }
	    return lst;	
	}
	
	/***Trx Type lookup for fixed maturity account : dddw_import_trxtype - AccountsInstructionsTab.jsp
	 * 
	 */
	@Override
    public int getTrxTypeForFmaListCount(TrxTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
	return ((Integer) getSqlMap().queryForObject("trxTypeMapper.selectTrxTypeListCountForFma", criteria))
		.intValue();
    }
	
	public CTSTRXTYPEVO getTrxTypeForFma(TrxTypeSC criteria)throws DAOException {
		
		return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.selectTrxTypeForFma", criteria);	
	}
	
    public Integer returnCodeForTrxTypeList(TrxTypeSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("trxTypeMapper.returnCodeForTrxTypeList", criteria);
    }


	
    public List<CTSTRXTYPEVO> trxTypeLookupForTransferCashList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeLookupForTransferCashList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeLookupForTransferCashList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
	return lst;
    }
    
    public int trxTypeLookupForTransferCashCount(TrxTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeLookupForTransferCashCount",
		criteria)).intValue();
	return nb;
    }
    
    public List<CTSTRXTYPEVO> trxTypeListByGrpForTransferCashList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeListByGrpForTransferCashList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeListByGrpForTransferCashList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
	return lst;
    }
    
    public int trxTypeListByGrpForTransferCashCount(TrxTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeListByGrpForTransferCashCount",
		criteria)).intValue();
	return nb;
    }
    
    public List trxTypeListByGrpForFMAList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeListByGrpForFMAList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeListByGrpForFMAList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
	return lst;
    }
    
    public int trxTypeListByGrpForFMACount(TrxTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListForTransferCashMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeListByGrpForFMACount",
		criteria)).intValue();
	return nb;
    }
    
    public int returnTrxUtilityPayment (TrxTypeSC trxTypeSC) throws DAOException
    {
	
    	return ((Integer) getSqlMap().queryForObject("trxTypeMapper.returnTrxUtilityPayment",trxTypeSC)).intValue();
	
    }
    /**
     * to get the list of transactions that user can link his transaction to them
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<CTSTRXTYPE_LINKVO> trxTypeLinkList(TrxMgntSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("trxTypeMapper.trxTypeLinkList", criteria);
    }
    
    public CTSTRXTYPEVO returnTrxTypeDependencyById(TrxTypeSC criteria)throws DAOException
    {	
	return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.returnTrxTypeDependencyById", criteria);	
    }
    
    public List<CTSTRXTYPEVO> trxTypeForCurrencyExchangeList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeForCurrencyExchangeMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeForCurrencyExchangeList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeForCurrencyExchangeList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
	return lst;
    }
    
    public int trxTypeForCurrencyExchangeListCount(TrxTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeForCurrencyExchangeMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeForCurrencyExchangeListCount",
		criteria)).intValue();
	return nb;
    }

    public List<CTSTRXTYPEVO> trxTypeMCEList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeMCEList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeMCEList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
	return lst;
    }

    public Integer trxTypeMCEListCount(TrxTypeSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeMCEListCount", criteria);
    }
    
    /*****
     * Method for getting trxtype VO object for a specific trsfr_method
     * @param criteria
     * @return
     * @throws DAOException
     */
    public CTSTRXTYPEVO closeTransferTrxType(TrxTypeSC criteria) throws DAOException{
		List<CTSTRXTYPEVO> ctsTrxList 	=	getSqlMap().queryForList("trxTypeMapper.closeTrsfrTrxTypeList",criteria);
		if(ctsTrxList!=null && ctsTrxList.size() == 1)
		{
			return ctsTrxList.get(0);
		}
		return null;
	}

    public List<CTSTRXTYPEVO> trxTypeBulkRemitList(TrxTypeSC criteria) throws DAOException
    {
	List lst;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
	if(criteria.getNbRec() == -1)
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeBulkRemitList", criteria);
	}
	else
	{
	    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeBulkRemitList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
	return lst;
    }

    public Integer trxTypeBulkRemitListCount(TrxTypeSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeBulkRemitListCount", criteria);
    }

	@Override
	public Integer trxTypeLookupForAccChargesListCount(TrxTypeSC criteria) throws DAOException {
		return (Integer) getSqlMap().queryForObject("trxTypeMapper.trxTypeLookupForAccChargesListCount", criteria);
	}

	@Override
	public List<CTSTRXTYPEVO> trxTypeLookupForAccChargesList(TrxTypeSC criteria) throws DAOException {
		List lst;
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxTypeMapper.trxTypeListMap");
		if(criteria.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeLookupForAccChargesList", criteria);
		}
		else
		{
		    lst = getSqlMap().queryForList("trxTypeMapper.trxTypeLookupForAccChargesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
		return lst;
	}

	@Override
	public CTSTRXTYPEVO trxTypeLookupForAccChargesDependency(TrxTypeSC criteria) throws DAOException {
		return (CTSTRXTYPEVO) getSqlMap().queryForObject("trxTypeMapper.trxTypeLookupForAccChargesDependency", criteria);
	}
	
	    @Override
	    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtendedById(TrxTypeSC criteria) throws DAOException
	    {
		return (CTSTRXTYPE_EXTENDEDVO) getSqlMap().queryForObject("trxTypeMapper.returnTrxTypeExtendedById", criteria);
	    }

    
}
