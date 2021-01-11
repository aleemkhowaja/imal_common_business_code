package com.path.bo.core.sourcefunds.impl;

import java.math.BigDecimal;
import java.util.List;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.sourcefunds.SourceFundsBO;
import com.path.dao.core.sourcefunds.SourceFundsDAO;
import com.path.dbmaps.vo.CTS_SOURCE_FUNDSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.sourcefunds.SourceFundsSC;

public class SourceFundsBOImpl extends BaseBO implements SourceFundsBO
{

	private SourceFundsDAO sourceFundsDAO;

	public SourceFundsDAO getSourceFundsDAO()
	{
		return sourceFundsDAO;
	}

	public void setSourceFundsDAO(SourceFundsDAO sourceFundsDAO)
	{
		this.sourceFundsDAO = sourceFundsDAO;
	}

	@Override
	public CTS_SOURCE_FUNDSVO returnSourceFundsCodeById(SourceFundsSC sourceFundsSC) throws BaseException
	{
		CTS_SOURCE_FUNDSVO ctsSourceFundsVO = sourceFundsDAO.returnSourceFundsCodeById(sourceFundsSC);

		if ((ctsSourceFundsVO == null || ctsSourceFundsVO.getSOURCE_FUNDS_CODE() == null) && BigDecimal.ZERO.compareTo(sourceFundsSC.getCode()) != 0)
		{
			throw new BOException(MessageCodes.INVALID_MISSING_CODE);
		}
		return ctsSourceFundsVO;
	}

	@Override
	public List sourceFundsList(SourceFundsSC sourceFundsSC) throws BaseException
	{
		return sourceFundsDAO.sourceFundsList(sourceFundsSC);
	}

	@Override
	public int sourceFundsListCount(SourceFundsSC sourceFundsSC) throws BaseException
	{
		return sourceFundsDAO.sourceFundsListCount(sourceFundsSC);
	}
}
