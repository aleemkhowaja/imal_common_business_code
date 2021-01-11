package com.path.dao.core.account;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.account.AccountSC;

public interface AccountTierNoDAO
{
    public int accountTierNoListCount(AccountSC criteria) throws DAOException;
    public List accountTierNoList(AccountSC criteria) throws DAOException;
    public int returnAccountTierNoCount(AccountSC criteria) throws DAOException;
    public int returnAccountTierNoSuspension(AccountSC criteria) throws DAOException;
    
}
