package com.path.bo.core.trxtype;

import java.util.List;

import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPE_LINKVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxtype.TrxTypeSC;

public interface TrxTypeBO
{
    public int trxTypeListCount(TrxTypeSC criteria) throws BaseException;
    public List trxTypeList(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO returnTrxTypeById(TrxTypeSC criteria)throws BaseException;
    
    public List cardsTrxTypeList(TrxTypeSC criteria) throws BaseException;
    public int cardsTrxTypeListCount(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO cardsTrxTypeDependency(TrxTypeSC criteria) throws BaseException;
    
    public List trxTypeForTransactionTrendsList(TrxTypeSC criteria) throws BaseException;
    public int  trxTypeForTransactionTrendsListCount(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO trxTypeForTransactionTrendsDependency(TrxTypeSC criteria) throws BaseException;
    
    //Hold Trx Type Lookup
    public List holdTrxTypeList(TrxTypeSC criteria) throws BaseException;
    public int holdTrxTypeListCount(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO returnHoldTrxTypeByDependency(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO returnCtsTrxTypeByDependency(TrxTypeSC criteria) throws BaseException;
    
    // Close transfer  Trx Type lookup
    public List closeTransferTrxTypeList(TrxTypeSC criteria) throws BaseException;
    public int closeTransferTrxTypeListCount(TrxTypeSC criteria) throws BaseException;
    
    public int trxTypeLookupForTrxTypeLimitChargesListCount(TrxTypeSC criteria) throws BaseException;
    public List trxTypeLookupForTrxTypeLimitChargesList(TrxTypeSC criteria) throws BaseException;
    
    //Trx Type lookup for fixed maturity account : dddw_import_trxtype - AccountsInstructionsTab.jsp
    public List getTrxTypeForFmaList(TrxTypeSC criteria) throws BaseException;
    public int getTrxTypeForFmaListCount(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO getTrxTypeForFma(TrxTypeSC criteria)throws BaseException;
 
    public List trxTypeForTransferCashList(TrxTypeSC criteria) throws BaseException;
    public int trxTypeForTransferCashListCount(TrxTypeSC criteria) throws BaseException;
    
    public int returnTrxUtilityPayment (TrxTypeSC trxTypeSC)throws BaseException;
    
    public List<CTSTRXTYPE_LINKVO> trxTypeLinkList(TrxMgntSC criteria) throws BaseException;
    
    public CTSTRXTYPEVO returnTrxTypeDependencyById(TrxTypeSC criteria)throws BaseException;
    
    public List<CTSTRXTYPEVO> trxTypeForCurrencyExchangeList(TrxTypeSC criteria) throws BaseException;
    public int trxTypeForCurrencyExchangeListCount(TrxTypeSC criteria) throws BaseException;
    public Integer trxTypeMCEListCount(TrxTypeSC criteria) throws BaseException;
    public List<CTSTRXTYPEVO> trxTypeMCEList(TrxTypeSC criteria) throws BaseException;
    public CTSTRXTYPEVO closeTransferTrxType(TrxTypeSC criteria) throws  BaseException;
    public Integer trxTypeBulkRemitListCount(TrxTypeSC criteria) throws  BaseException;
    public List<CTSTRXTYPEVO> trxTypeBulkRemitList(TrxTypeSC criteria) throws  BaseException;
    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtendedById(TrxTypeSC criteria) throws  BaseException;
	public Integer trxTypeLookupForAccChargesListCount(TrxTypeSC criteria) throws  BaseException;
	public List<CTSTRXTYPEVO> trxTypeLookupForAccChargesList(TrxTypeSC criteria) throws  BaseException;
	public CTSTRXTYPEVO trxTypeLookupForAccChargesDependency(TrxTypeSC criteria) throws BaseException;
	public TrxTypeSC returnTrxTypeMCEList(TrxTypeSC criteria) throws BaseException;
}
