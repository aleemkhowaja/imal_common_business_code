/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.credittype.impl;

import java.util.List;

import com.path.bo.core.credittype.CreditTypeBO;
import com.path.dao.core.credittype.CreditTypeDAO;
import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.credittype.CreditTypeSC;

public class CreditTypeBOImpl extends BaseBO implements CreditTypeBO
{
    private CreditTypeDAO creditTypeDAO;
    
    public int creditTypeListCount(CreditTypeSC criteria)throws BaseException
    {
	return creditTypeDAO.creditTypeListCount(criteria);
    }
    
    public List creditTypeList(CreditTypeSC criteria)throws BaseException
    {
	return creditTypeDAO.creditTypeList(criteria);
    }
    
    public CTSCREDIT_TYPEVO returnCreditTypeById(CreditTypeSC criteria)throws BaseException
    {
	return creditTypeDAO.returnCreditTypeById(criteria);
    }

    public CreditTypeDAO getCreditTypeDAO()
    {
        return creditTypeDAO;
    }

    public void setCreditTypeDAO(CreditTypeDAO creditTypeDAO)
    {
        this.creditTypeDAO = creditTypeDAO;
    }
    
}
