package com.path.bo.core.account;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.account.AccountSC;

public interface AccountTierNoBO
{
    public int accountTierNoListCount(AccountSC criteria) throws BaseException;
    public List accountTierNoList(AccountSC criteria) throws BaseException;
    public int returnAccountTierNoCount(AccountSC criteria) throws BaseException;
    public int returnAccountTierNoSuspension (AccountSC criteria) throws BaseException;
}
