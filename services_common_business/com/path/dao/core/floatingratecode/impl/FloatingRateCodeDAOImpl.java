package com.path.dao.core.floatingratecode.impl;


import java.util.List;

import com.path.dao.core.floatingratecode.FloatingRateCodeDAO;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;


public class FloatingRateCodeDAOImpl extends BaseDAO implements FloatingRateCodeDAO  {

	@Override
	public List floatingRateCodeList(FloatingRateCodeSC floatingRateCodeSC)
				throws DAOException {
		if (floatingRateCodeSC.getNbRec() == -1) {
			return getSqlMap().queryForList("floatingRateCodeMapper.floatingRateCodeList",
					floatingRateCodeSC);
		} else {
			DAOHelper.fixGridMaps(floatingRateCodeSC, getSqlMap(),
					"floatingRateCodeMapper.floatingRateCodeListMap");
			return getSqlMap().queryForList("floatingRateCodeMapper.floatingRateCodeList",
					floatingRateCodeSC, floatingRateCodeSC.getRecToskip(),
					floatingRateCodeSC.getNbRec());
		}
	}
	
	@Override
	public int floatingRateCodeListCount(FloatingRateCodeSC floatingRateCodeSC)
			throws DAOException {
		DAOHelper.fixGridMaps(floatingRateCodeSC, getSqlMap(),
		"floatingRateCodeMapper.floatingRateCodeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject(
				"floatingRateCodeMapper.floatingRateCodeListCount", floatingRateCodeSC)).intValue();
		return nb;
	}

	@Override
	public IBOR_HDRVO returnFloatingRateCodeById(FloatingRateCodeSC criteria)
			throws DAOException {
		// TODO Auto-generated method stub
		
		return (IBOR_HDRVO) getSqlMap().queryForObject("floatingRateCodeMapper.returnFloatingRateCodeById", criteria);
		
	}

}
