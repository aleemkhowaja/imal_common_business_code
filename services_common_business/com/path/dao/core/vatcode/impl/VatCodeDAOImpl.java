package com.path.dao.core.vatcode.impl;

import java.util.List;

import com.path.dao.core.vatcode.VatCodeDAO;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.vatcode.VatCodeSC;

public class VatCodeDAOImpl extends BaseDAO implements VatCodeDAO {

	@Override
	public TRSVATVO returnVatCodeById(VatCodeSC criteria) throws DAOException {
	
		return (TRSVATVO) getSqlMap().queryForObject("vatCodeListMapper.returnVatCodeById", criteria);
	}

	@Override
	public List vatCodeList(VatCodeSC vatCodeSC) throws DAOException {
		
		if(vatCodeSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("vatCodeListMapper.vatCodeList", vatCodeSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(vatCodeSC, getSqlMap(), "vatCodeListMapper.vatCodeListMap");
		    return getSqlMap().queryForList("vatCodeListMapper.vatCodeList", vatCodeSC, vatCodeSC.getRecToskip(),
		    		vatCodeSC.getNbRec());
		}
	}

	@Override
	public int vatCodeListCount(VatCodeSC vatCodeSC) throws DAOException {
		
		DAOHelper.fixGridMaps(vatCodeSC, getSqlMap(), "vatCodeListMapper.vatCodeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("vatCodeListMapper.vatCodeListCount", vatCodeSC)).intValue();
		return nb;
	}

}
