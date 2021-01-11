package com.path.dao.core.merchant.impl;

import java.util.List;

import com.path.dao.core.merchant.MerchantDAO;
import com.path.dbmaps.vo.CTS_MERCHANTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.merchant.MerchantSC;

public class MerchantDAOImpl extends BaseDAO implements MerchantDAO
{

    public List<CTS_MERCHANTVO> returnMerchantCodeList(MerchantSC merchantSC) throws DAOException
    {
	if(merchantSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("merchantMapper.returnMerchantCodeList", merchantSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(merchantSC, getSqlMap(), "merchantMapper.merchantCodeMap");
	    return getSqlMap().queryForList("merchantMapper.returnMerchantCodeList", merchantSC,
		    merchantSC.getRecToskip(), merchantSC.getNbRec());
	}
    }

    public int returnMerchantCodeListCount(MerchantSC merchantSC) throws DAOException
    {
	DAOHelper.fixGridMaps(merchantSC, getSqlMap(), "servicesMapper.terminalIdResultMap");
	return ((Integer) getSqlMap().queryForObject("merchantMapper.returnMerchantCodeListCount", merchantSC))
		.intValue();
    }
}
