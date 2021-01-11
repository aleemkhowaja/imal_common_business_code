/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Te\am.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.credittype.impl;

import java.util.List;

import com.path.dao.core.credittype.CreditTypeDAO;
import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.credittype.CreditTypeSC;

public class CreditTypeDAOImpl extends BaseDAO implements CreditTypeDAO
{
    public int creditTypeListCount(CreditTypeSC criteria)throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "creditTypeMapper.creditTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("creditTypeMapper.creditTypeListCount", criteria)).intValue();
	return nb;
    }
    
    public List creditTypeList(CreditTypeSC criteria)throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("creditTypeMapper.creditTypeListMap", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "creditTypeMapper.creditTypeListMap");
	    return getSqlMap().queryForList("creditTypeMapper.creditTypeList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public CTSCREDIT_TYPEVO returnCreditTypeById(CreditTypeSC criteria)throws DAOException
    {
	return (CTSCREDIT_TYPEVO) getSqlMap().queryForObject("creditTypeMapper.returnCreditTypeById", criteria);
    }
}
