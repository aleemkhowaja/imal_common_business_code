package com.path.dao.core.userlevel.impl;

import java.util.List;

import com.path.dao.core.userlevel.UserLevelDAO;
import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.userlevel.UserLevelSC;

public class UserLevelDAOImpl extends BaseDAO implements UserLevelDAO{

	@Override
	public USR_LEVELVO returnUserLevelById(UserLevelSC criteria)
			throws DAOException {
		return (USR_LEVELVO) getSqlMap().queryForObject("userLevelListMapper.returnUserLevelById", criteria);
	}

	@Override
	public List userLevelList(UserLevelSC userLevelSC) throws DAOException {
		if(userLevelSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("userLevelListMapper.userLevelList", userLevelSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(userLevelSC, getSqlMap(), "userLevelListMapper.userLevelListMap");
		    return getSqlMap().queryForList("userLevelListMapper.userLevelList", userLevelSC, userLevelSC.getRecToskip(),
		    		userLevelSC.getNbRec());
		}

	}

	@Override
	public int userLevelListCount(UserLevelSC userLevelSC) throws DAOException {
		DAOHelper.fixGridMaps(userLevelSC, getSqlMap(), "userLevelListMapper.userLevelListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("userLevelListMapper.userLevelListCount", userLevelSC)).intValue();
		return nb;
	}

}
