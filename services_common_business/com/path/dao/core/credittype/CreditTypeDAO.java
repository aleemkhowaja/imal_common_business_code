/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.credittype;

import java.util.List;

import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.credittype.CreditTypeSC;

public interface CreditTypeDAO 
{
    public int creditTypeListCount(CreditTypeSC criteria)throws DAOException;
    public List creditTypeList(CreditTypeSC criteria)throws DAOException;
    public CTSCREDIT_TYPEVO returnCreditTypeById(CreditTypeSC criteria)throws DAOException;
}
