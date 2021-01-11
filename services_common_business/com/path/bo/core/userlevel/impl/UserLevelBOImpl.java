package com.path.bo.core.userlevel.impl;

import java.util.List;

import com.path.bo.core.userlevel.UserLevelBO;
import com.path.dao.core.userlevel.UserLevelDAO;
import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.userlevel.UserLevelSC;

public class UserLevelBOImpl extends BaseBO implements UserLevelBO {
	
	private UserLevelDAO userLevelDAO;
	
	 public UserLevelDAO getUserLevelDAO()
	    {
		return userLevelDAO;
	    }
	 
		public void setUserLevelDAO(UserLevelDAO userLevelDAO) {
			this.userLevelDAO = userLevelDAO;
		}


	@Override
	public USR_LEVELVO returnUserLevelById(UserLevelSC criteria)
			throws BaseException {
		return (USR_LEVELVO) userLevelDAO.returnUserLevelById(criteria);
	}

	@Override
	public List userLevelList(UserLevelSC userLevelSC) throws BaseException {
		return userLevelDAO.userLevelList(userLevelSC);
	}

	@Override
	public int userLevelListCount(UserLevelSC userLevelSC) throws BaseException {
		return userLevelDAO.userLevelListCount(userLevelSC);
	}

}
