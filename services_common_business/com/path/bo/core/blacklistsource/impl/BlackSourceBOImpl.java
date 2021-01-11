package com.path.bo.core.blacklistsource.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.blacklistsource.BlackSourceBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dao.core.blacklistsource.BlackSourceDAO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public class BlackSourceBOImpl extends BaseBO implements BlackSourceBO
{
	private BlackSourceDAO blackSourceDAO;

	public BlackSourceDAO getBlackSourceDAO()
	{
		return blackSourceDAO;
	}

	public void setBlackSourceDAO(BlackSourceDAO blackSourceDAO)
	{
		this.blackSourceDAO = blackSourceDAO;
	}

	@Override
	public List blackSourceList(BlackSourceSC criteria) throws BaseException
	{
		return blackSourceDAO.blackSourceList(criteria);
	}

	@Override
	public int blackSourceListCount(BlackSourceSC criteria) throws BaseException
	{
		return blackSourceDAO.blackSourceListCount(criteria);
	}

	@Override
	public MOSBLACKSOURCEVO returnBlackSourceById(BlackSourceSC criteria) throws BaseException
	{
		MOSBLACKSOURCEVO blackSourceVO= (MOSBLACKSOURCEVO) blackSourceDAO.returnBlackSourceById(criteria);
		// added by nour for 777000

		if (CoreCommonConstants.AML.equals(criteria.getCurrAppName()))
		{
			if(criteria.getCode().intValue() <= 0)
			{
			    throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
			}
			
			if (blackSourceVO != null)
			{
				// added by bilal to check if called from BL source Screen
				if (ConstantsCommon.ONE.equals(criteria.getIsMainScreen())
						&& blackSourceVO.getCODE().equals(criteria.getCode())) {
					throw new BOException(MessageCodes.DUPLICATE_VALUE);
				}
			} else {
				if (ConstantsCommon.ZERO.equals(criteria.getIsMainScreen()))
				{
					throw new BOException(MessageCodes.VALUE_DOES_NOT_EXIST);
				}
			}
		}
		// end nour 
		return blackSourceVO;
	}


}
