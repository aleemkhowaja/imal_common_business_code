
package com.path.dao.core.accounttype;

import java.util.List;

import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.accounttype.AccountTypeSC;

/**
 * @author Libin
 *
 */
public interface AccountTypeDAO
{
    public int accountTypeListCount(AccountTypeSC criteria) throws DAOException;
    public List accountTypeList(AccountTypeSC criteria) throws DAOException;
    public RIFATTVO returnAccountTypeById(AccountTypeSC criteria) throws DAOException;
    
}
