package com.path.bo.core.trxtype.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.trxtype.TrxTypeBO;
import com.path.dao.core.trxtype.TrxTypeDAO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPE_LINKVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxtype.TrxTypeSC;

public class TrxTypeBOImpl extends BaseBO implements TrxTypeBO
{
    private TrxTypeDAO trxTypeDAO;
    private AccountBO accountBO;
    @Override
    public List trxTypeList(TrxTypeSC criteria) throws BaseException
    {
	/**
	  * 
	  * @author Alim Khowajaa
	  * Connction required for retrieve Trx Type List to call from ATM
	  */
	String jndiname = "services.jndi";
	CommonMethods.applyConnectionJNDIToSC(criteria, jndiname);
	
	return trxTypeDAO.trxTypeList(criteria);
    }

    @Override
    public int trxTypeListCount(TrxTypeSC criteria) throws BaseException
    {
	/**
	  * 
	  * @author Alim Khowajaa
	  * Connction required for retrieve Trx Type List to call from ATM
	  */
	String jndiname = "services.jndi";
	CommonMethods.applyConnectionJNDIToSC(criteria, jndiname);
	
	return trxTypeDAO.trxTypeListCount(criteria);
    }

    public CTSTRXTYPEVO returnTrxTypeById(TrxTypeSC criteria)throws BaseException
    {
	return trxTypeDAO.returnTrxTypeById(criteria);
    }

    public List cardsTrxTypeList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.cardsTrxTypeList(criteria);
    }

    public int cardsTrxTypeListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.cardsTrxTypeListCount(criteria);
    }

    public CTSTRXTYPEVO cardsTrxTypeDependency(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.cardsTrxTypeDependency(criteria);
    }

    public TrxTypeDAO getTrxTypeDAO()
    {
	return trxTypeDAO;
    }

    public void setTrxTypeDAO(TrxTypeDAO trxTypeDAO)
    {
	this.trxTypeDAO = trxTypeDAO;
    }


    public List trxTypeForTransactionTrendsList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeForTransactionTrendsList(criteria);
    }

    public int trxTypeForTransactionTrendsListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeForTransactionTrendsListCount(criteria);
    }

    @Override
    public CTSTRXTYPEVO trxTypeForTransactionTrendsDependency(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeForTransactionTrendsDependency(criteria);
    }

    public List holdTrxTypeList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.holdTrxTypeList(criteria);
    }

    public int holdTrxTypeListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.holdTrxTypeListCount(criteria);
    }
    
    public CTSTRXTYPEVO returnHoldTrxTypeByDependency(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.returnHoldTrxTypeByDependency(criteria);
    }

    public CTSTRXTYPEVO returnCtsTrxTypeByDependency(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.returnCtsTrxTypeByDependency(criteria);
    }

    public List closeTransferTrxTypeList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.closeTransferTrxTypeList(criteria);
    }

    public int closeTransferTrxTypeListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.closeTransferTrxTypeListCount(criteria);
    }

    @Override
    public List trxTypeLookupForTrxTypeLimitChargesList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeLookupForTrxTypeLimitChargesList(criteria);
    }

    @Override
    public int trxTypeLookupForTrxTypeLimitChargesListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeLookupForTrxTypeLimitChargesListCount(criteria);
    }

    @Override
    public List getTrxTypeForFmaList(TrxTypeSC criteria) throws BaseException 
    {
	Integer code = trxTypeDAO.returnCodeForTrxTypeList(criteria);
	List<CTSTRXTYPEVO> trxTypeList;
	if(code == null || code == 0)
	{
	    trxTypeList = trxTypeDAO.getTrxTypeForFmaList(criteria);
	}
	else
	{
	    criteria.setTrxTypeGrpCode(new BigDecimal(code));
	    trxTypeList = trxTypeDAO.trxTypeListByGrpForFMAList(criteria);
	}
	return trxTypeList;
    }

    @Override
    public int getTrxTypeForFmaListCount(TrxTypeSC criteria)throws BaseException 
    {
	Integer code = trxTypeDAO.returnCodeForTrxTypeList(criteria);
	int cnt;
	if(code == null || code == 0)
	{
	    cnt = trxTypeDAO.getTrxTypeForFmaListCount(criteria);
	}
	else
	{
	    criteria.setTrxTypeGrpCode(new BigDecimal(code));
	    cnt = trxTypeDAO.trxTypeListByGrpForFMACount(criteria);
	}
	return cnt;
    }
    
    @Override
    public CTSTRXTYPEVO getTrxTypeForFma(TrxTypeSC criteria)throws BaseException
    {
	CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO(); 
	Integer code = trxTypeDAO.returnCodeForTrxTypeList(criteria);
	if(code == null || code == 0)
	{
	    ctsTrxTypeVO = trxTypeDAO.getTrxTypeForFma(criteria);
	}
	else
	{
	    criteria.setTrxTypeGrpCode(new BigDecimal(code));
	    criteria.setNbRec(-1);
	    List<CTSTRXTYPEVO> trxTypeList = trxTypeDAO.trxTypeListByGrpForFMAList(criteria);
	    if(trxTypeList != null && !trxTypeList.isEmpty())
	    {
		ctsTrxTypeVO = trxTypeList.get(0);
	    }
	}
	return ctsTrxTypeVO;
    }
	
    public List trxTypeForTransferCashList(TrxTypeSC criteria) throws BaseException
    {
	Integer code = trxTypeDAO.returnCodeForTrxTypeList(criteria);
	List<CTSTRXTYPEVO> trxTypeList;
	if(code == null || code == 0)
	{
	    trxTypeList = trxTypeDAO.trxTypeLookupForTransferCashList(criteria);
	}
	else
	{
	    criteria.setTrxTypeGrpCode(new BigDecimal(code));
	    trxTypeList = trxTypeDAO.trxTypeListByGrpForTransferCashList(criteria);
	}
	return trxTypeList;
    }
    
    public int trxTypeForTransferCashListCount(TrxTypeSC criteria) throws BaseException
    {
	Integer code = trxTypeDAO.returnCodeForTrxTypeList(criteria);
	int cnt;
	if(code == null || code == 0)
	{
	    cnt = trxTypeDAO.trxTypeLookupForTransferCashCount(criteria);
	}
	else
	{
	    criteria.setTrxTypeGrpCode(new BigDecimal(code));
	    cnt = trxTypeDAO.trxTypeListByGrpForTransferCashCount(criteria);
	}
	return cnt;
    }	
    
    
    public int returnTrxUtilityPayment (TrxTypeSC trxTypeSC)throws BaseException
    {
    	return trxTypeDAO.returnTrxUtilityPayment(trxTypeSC);
    	
    }

    public List<CTSTRXTYPE_LINKVO> trxTypeLinkList(TrxMgntSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeLinkList(criteria);
    }
    
    public CTSTRXTYPEVO returnTrxTypeDependencyById(TrxTypeSC criteria)throws BaseException
    {
	CTSTRXTYPEVO ctsTrxTypeVO = trxTypeDAO.returnTrxTypeDependencyById(criteria);
	
	if(ctsTrxTypeVO == null && "true".equals(StringUtil.nullToEmpty(criteria.getShowMessage())))
        {
	    throw new BOException(MessageCodes.INVALID_CODE);
        }
	
	if(ctsTrxTypeVO != null && "1".equals(StringUtil.nullToEmpty(ctsTrxTypeVO.getHIDE_IN_TRS())) && !criteria.isGlobalDep()) 
	{
	    throw new BOException(MessageCodes.INVALID_MISSING,new String[]{"trxType_key"});
	}
	return ctsTrxTypeVO;
    }
    
    public List<CTSTRXTYPEVO> trxTypeForCurrencyExchangeList(TrxTypeSC trxTypeSC) throws BaseException
    {
	PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
	trxTypeSC.setCrDrForex(pthCtrlVO.getCR_DR_CY_EXCH());
	return trxTypeDAO.trxTypeForCurrencyExchangeList(trxTypeSC);
    }
    
    public int trxTypeForCurrencyExchangeListCount(TrxTypeSC trxTypeSC) throws BaseException
    {
	PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
	trxTypeSC.setCrDrForex(pthCtrlVO.getCR_DR_CY_EXCH());
    	return trxTypeDAO.trxTypeForCurrencyExchangeListCount(trxTypeSC);
    }

    public List<CTSTRXTYPEVO> trxTypeMCEList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeMCEList(criteria);
    }

    public Integer trxTypeMCEListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeMCEListCount(criteria);
    }
    
    
    @Override
    public TrxTypeSC returnTrxTypeMCEList(TrxTypeSC criteria) throws BaseException
    {
		// Habib Baalbaki accocunt restriction 372747
		AccountSC accountSC = new AccountSC();
		accountSC.setCurrAppName(criteria.getCurrAppName());
		accountSC.setPageRef(criteria.getPageRef());
		accountSC.setUserId(criteria.getUserId());
		accountSC.setCompCode(criteria.getCompCode());
		accountBO.callFillAccRestricted(accountSC);

		int result = 0;
		if (criteria.isCheckNbRec())
		{
			result = trxTypeMCEListCount(criteria);
			criteria.setNbRecords(result);
		}
		if (criteria.isCheckNbRec() && result == 0)
		{
			criteria.setSidx(null);
			criteria.setSord(null);
		}
		List<CTSTRXTYPEVO> amfList = trxTypeMCEList(criteria);
		criteria.setListRecords(amfList);
		return criteria;
    }
    
    
    
    
    /****
     * Method to select random trx type 
     */
    public CTSTRXTYPEVO closeTransferTrxType(TrxTypeSC criteria) throws  BaseException{
    	return trxTypeDAO.closeTransferTrxType(criteria);
    }

    public List<CTSTRXTYPEVO> trxTypeBulkRemitList(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeBulkRemitList(criteria);
    }

    public Integer trxTypeBulkRemitListCount(TrxTypeSC criteria) throws BaseException
    {
	return trxTypeDAO.trxTypeBulkRemitListCount(criteria);
    }

	@Override
	public Integer trxTypeLookupForAccChargesListCount(TrxTypeSC criteria) throws BaseException {
		return trxTypeDAO.trxTypeLookupForAccChargesListCount(criteria);
	}

	@Override
	public List<CTSTRXTYPEVO> trxTypeLookupForAccChargesList(TrxTypeSC criteria) throws BaseException {
		return trxTypeDAO.trxTypeLookupForAccChargesList(criteria);
	}

	@Override
	public CTSTRXTYPEVO trxTypeLookupForAccChargesDependency(TrxTypeSC criteria) throws BaseException {
		return trxTypeDAO.trxTypeLookupForAccChargesDependency(criteria);
	}

	    @Override
	    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtendedById(TrxTypeSC criteria) throws BaseException
	    {
		return trxTypeDAO.returnTrxTypeExtendedById(criteria);
	    }
	
	public void setAccountBO(AccountBO accountBO)
	{
		this.accountBO = accountBO;
	}
	


}
