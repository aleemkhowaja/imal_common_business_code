package com.path.dao.core.tempcode.impl;

import java.util.List;

import com.path.dao.core.tempcode.TempCodeDAO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.tempcode.TempCodeSC;

public class TempCodeDAOImpl extends BaseDAO implements TempCodeDAO {

	@Override
	public TRSPAYPLANTMPLTVO returnTempCodeById(TempCodeSC criteria)
			throws DAOException {
		return (TRSPAYPLANTMPLTVO) getSqlMap().queryForObject("tempCodeListMapper.returnTempCodeById", criteria);
	}

	@Override
	public List tempCodeList(TempCodeSC tempCodeSC) throws DAOException {				    
			if(tempCodeSC.getNbRec() == -1)
			{
			    return getSqlMap().queryForList("tempCodeListMapper.tempCodeList", tempCodeSC);
			}
			else
			{
			    DAOHelper.fixGridMaps(tempCodeSC, getSqlMap(), "tempCodeListMapper.tempCodeListMap");
			    return getSqlMap().queryForList("tempCodeListMapper.tempCodeList", tempCodeSC, tempCodeSC.getRecToskip(),
			    		tempCodeSC.getNbRec());
			}
		    }	
	
	@Override
	public int tempCodeListCount(TempCodeSC tempCodeSC) throws DAOException {
		DAOHelper.fixGridMaps(tempCodeSC, getSqlMap(), "tempCodeListMapper.tempCodeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("tempCodeListMapper.tempCodeListCount", tempCodeSC)).intValue();
		return nb;
	}

}
