package com.path.dao.core.trxtype;

import java.util.List;

import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_LINKVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxtype.TrxTypeSC;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;

public interface TrxTypeDAO
{
    public int trxTypeListCount(TrxTypeSC criteria) throws DAOException;
    public List trxTypeList(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO returnTrxTypeById(TrxTypeSC criteria)throws DAOException;
    public List cardsTrxTypeList(TrxTypeSC criteria) throws DAOException;
    public int cardsTrxTypeListCount(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO cardsTrxTypeDependency(TrxTypeSC criteria) throws DAOException;
    
    public List trxTypeForTransactionTrendsList(TrxTypeSC criteria) throws DAOException;
    public int  trxTypeForTransactionTrendsListCount(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO trxTypeForTransactionTrendsDependency(TrxTypeSC criteria) throws DAOException;
    
    //Hold Trx Type lookup
    public List holdTrxTypeList(TrxTypeSC criteria) throws DAOException;
    public int holdTrxTypeListCount(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO returnHoldTrxTypeByDependency(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO returnCtsTrxTypeByDependency(TrxTypeSC criteria) throws DAOException;
    
    // Close transfer Trx Type lookup
    public List closeTransferTrxTypeList(TrxTypeSC criteria) throws DAOException;
    public int closeTransferTrxTypeListCount(TrxTypeSC criteria) throws DAOException;
    
    public int trxTypeLookupForTrxTypeLimitChargesListCount(TrxTypeSC criteria) throws DAOException;
    public List trxTypeLookupForTrxTypeLimitChargesList(TrxTypeSC criteria) throws DAOException;
    
  //Trx Type lookup for fixed maturity account : dddw_import_trxtype - AccountsInstructionsTab.jsp
    public int getTrxTypeForFmaListCount(TrxTypeSC criteria) throws DAOException;
    public List getTrxTypeForFmaList(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO getTrxTypeForFma(TrxTypeSC criteria)throws DAOException;
    
        
    public Integer returnCodeForTrxTypeList(TrxTypeSC criteria) throws DAOException;
    public List trxTypeLookupForTransferCashList(TrxTypeSC criteria) throws DAOException;
    public int trxTypeLookupForTransferCashCount(TrxTypeSC criteria) throws DAOException;
    public List trxTypeListByGrpForTransferCashList(TrxTypeSC criteria) throws DAOException;
    public int trxTypeListByGrpForFMACount(TrxTypeSC criteria) throws DAOException;
    public List trxTypeListByGrpForFMAList(TrxTypeSC criteria) throws DAOException;
    public int trxTypeListByGrpForTransferCashCount(TrxTypeSC criteria) throws DAOException;
    public int returnTrxUtilityPayment (TrxTypeSC trxTypeSC) throws DAOException;
    public List<CTSTRXTYPE_LINKVO> trxTypeLinkList(TrxMgntSC criteria) throws DAOException;
    
    public CTSTRXTYPEVO returnTrxTypeDependencyById(TrxTypeSC criteria)throws DAOException;
    
    public int trxTypeForCurrencyExchangeListCount(TrxTypeSC trxTypeSC) throws DAOException;
    public List<CTSTRXTYPEVO> trxTypeForCurrencyExchangeList(TrxTypeSC criteria) throws DAOException;
    public List<CTSTRXTYPEVO> trxTypeMCEList(TrxTypeSC criteria) throws DAOException;
    public Integer trxTypeMCEListCount(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPEVO closeTransferTrxType(TrxTypeSC criteria) throws DAOException;
    public List<CTSTRXTYPEVO> trxTypeBulkRemitList(TrxTypeSC criteria) throws DAOException;
    public Integer trxTypeBulkRemitListCount(TrxTypeSC criteria) throws DAOException;
	public Integer trxTypeLookupForAccChargesListCount(TrxTypeSC criteria) throws DAOException;
	public List<CTSTRXTYPEVO> trxTypeLookupForAccChargesList(TrxTypeSC criteria) throws DAOException;
	public CTSTRXTYPEVO trxTypeLookupForAccChargesDependency(TrxTypeSC criteria) throws DAOException;
    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtendedById(TrxTypeSC criteria) throws DAOException;
}
