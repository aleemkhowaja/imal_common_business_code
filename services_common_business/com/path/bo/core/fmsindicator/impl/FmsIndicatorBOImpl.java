package com.path.bo.core.fmsindicator.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.fmsindicator.FmsIndicatorBO;
import com.path.dao.core.fmsindicator.FmsIndicatorDAO;
import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public class FmsIndicatorBOImpl extends BaseBO implements FmsIndicatorBO
{
	private FmsIndicatorDAO fmsIndicatorDAO;
	
	@Override
	public List fmsIndicatorList(FmsIndicatorSC criteria) throws BaseException
	{
		return fmsIndicatorDAO.fmsIndicatorList(criteria);
	}

	@Override
	public int fmsIndicatorListCount(FmsIndicatorSC criteria) throws BaseException
	{
		return fmsIndicatorDAO.fmsIndicatorListCount(criteria);
	}

	@Override
	public FMSINDICATORVO returnFmsIndicatorNameById(FmsIndicatorSC criteria) throws BaseException
	{
	    FMSINDICATORVO indicatorVO = fmsIndicatorDAO.returnFmsIndicatorNameById(criteria);
	    
	    
	    return indicatorVO;
	}
	
	@Override
	public List fmsCustomerIndicatorList(FmsIndicatorSC criteria) throws BaseException
	{
		return fmsIndicatorDAO.fmsCustomerIndicatorList(criteria);
	}

	@Override
	public int fmsCustomerIndicatorListCount(FmsIndicatorSC criteria) throws BaseException
	{
		return fmsIndicatorDAO.fmsCustomerIndicatorListCount(criteria);
	}

	@Override
	public FMSINDICATORVO returnFmsCustomerIndicatorNameById(FmsIndicatorSC criteria) throws BaseException
	{
	    return fmsIndicatorDAO.returnFmsCustomerIndicatorNameById(criteria);
	}

	public FmsIndicatorDAO getFmsIndicatorDAO()
	{
		return fmsIndicatorDAO;
	}

	public void setFmsIndicatorDAO(FmsIndicatorDAO fmsIndicatorDAO)
	{
		this.fmsIndicatorDAO = fmsIndicatorDAO;
	}

	public BigDecimal dependencyOfFmsGrossValue(FmsIndicatorSC criteria) throws BaseException
	{
	    
	    if(NumberUtil.isEmptyDecimal( criteria.getIndicatorCode()))
	    {
		throw new BOException(MessageCodes.FINANCIAL_INDICATOR_IS_MISSING);
	    }
	    if(NumberUtil.isEmptyDecimal( criteria.getValue())){
		criteria.setValue(BigDecimal.ZERO);
	    }
	    return criteria.getMultiplier().multiply(criteria.getValue());
	}

}
