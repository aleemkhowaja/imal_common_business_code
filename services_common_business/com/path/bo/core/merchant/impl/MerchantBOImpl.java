package com.path.bo.core.merchant.impl;

import java.util.List;

import com.path.bo.core.merchant.MerchantBO;
import com.path.dao.core.merchant.MerchantDAO;
import com.path.dbmaps.vo.CTS_MERCHANTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.merchant.MerchantSC;

public class MerchantBOImpl extends BaseBO implements MerchantBO
{
    private MerchantDAO merchantDAO;

    public List<CTS_MERCHANTVO> returnMerchantCodeList(MerchantSC criteria) throws BaseException
    {
	return merchantDAO.returnMerchantCodeList(criteria);
    }

    public int returnMerchantCodeListCount(MerchantSC criteria) throws BaseException
    {
	return merchantDAO.returnMerchantCodeListCount(criteria);
    }

    public MerchantDAO getMerchantDAO()
    {
	return merchantDAO;
    }

    public void setMerchantDAO(MerchantDAO merchantDAO)
    {
	this.merchantDAO = merchantDAO;
    }

}
