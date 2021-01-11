package com.path.dao.core.passbook.impl;

import java.util.List;

import com.path.dao.core.passbook.PassbookDAO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.passbook.PassbookSC;
import com.path.vo.core.passbookinventory.PassBookinventoryCO;
import com.path.vo.core.passbookinventory.PassBookinventorySC;

public class PassbookDAOImpl extends BaseDAO implements PassbookDAO
{

	@Override
	public List passbookList(PassbookSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("passbookMapper.passbookList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSPASSBOOK_TYPE.BaseResultMap");
		    return getSqlMap().queryForList("passbookMapper.passbookList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int passbookListCount(PassbookSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSPASSBOOK_TYPE.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("passbookMapper.passbookListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CTSPASSBOOK_TYPEVO returnPassbookById(PassbookSC criteria) throws DAOException
	{
		return (CTSPASSBOOK_TYPEVO) getSqlMap().queryForObject("passbookMapper.returnPassbookById", criteria);
	}
       public PassBookinventoryCO checkQuantityMinimumAlert(PassBookinventorySC passBookinventorySC) throws DAOException
       {
    	   PassBookinventoryCO nullpassBookinventory=new PassBookinventoryCO();
    	   PassBookinventoryCO passBookinventory=(PassBookinventoryCO) getSqlMap().queryForObject("passbookMapper.checkQuantityMinimumAlert", passBookinventorySC);
    	  if (null == passBookinventory) 
    	  {
    		  passBookinventory = nullpassBookinventory;  
    	  }
   
	    return passBookinventory;
       }

	@Override
	public CTSPASSBOOK_TYPEVO returnDefaultedPassbookByCifTypeCode(PassbookSC criteria) throws DAOException
	{
		return (CTSPASSBOOK_TYPEVO) getSqlMap().queryForObject("passbookMapper.returnDefaultedPassbookByCifTypeCode", criteria);
	}
}        
