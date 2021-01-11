package com.path.bo.core.accounttype;

import java.util.List;

import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.accounttype.AccountTypeSC;

public interface AccountTypeBO
{
    public int accountTypeListCount(AccountTypeSC criteria) throws BaseException;
    public List accountTypeList(AccountTypeSC criteria) throws BaseException;
    public RIFATTVO returnAccountTypeById(AccountTypeSC criteria) throws BaseException;
}
