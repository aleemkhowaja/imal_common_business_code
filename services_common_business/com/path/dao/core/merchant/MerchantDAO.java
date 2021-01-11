package com.path.dao.core.merchant;

import java.util.List;

import com.path.dbmaps.vo.CTS_MERCHANTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.merchant.MerchantSC;

public interface MerchantDAO
{
    public int returnMerchantCodeListCount(MerchantSC criteria) throws DAOException;

    public List<CTS_MERCHANTVO> returnMerchantCodeList(MerchantSC criteria) throws DAOException;
}
