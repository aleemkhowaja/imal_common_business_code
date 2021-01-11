package com.path.bo.core.merchant;

import java.util.List;

import com.path.dbmaps.vo.CTS_MERCHANTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.merchant.MerchantSC;

public interface MerchantBO
{
    public int returnMerchantCodeListCount(MerchantSC criteria) throws BaseException;

    public List<CTS_MERCHANTVO> returnMerchantCodeList(MerchantSC criteria) throws BaseException;
}
