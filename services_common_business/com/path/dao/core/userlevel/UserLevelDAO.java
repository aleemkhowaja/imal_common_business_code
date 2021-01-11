package com.path.dao.core.userlevel;

import java.util.List;

import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.userlevel.UserLevelSC;

public interface UserLevelDAO {
	
	  public int userLevelListCount(UserLevelSC userLevelSC) throws DAOException;

	    public List userLevelList(UserLevelSC userLevelSC) throws DAOException;
	    
	    public USR_LEVELVO returnUserLevelById(UserLevelSC criteria) throws DAOException;

}
